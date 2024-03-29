from dotenv import load_dotenv
import streamlit as st
import os
import mysql.connector
import google.generativeai as genai

# Load environment variables
load_dotenv()

# Configure Genai Key (to convert english question to mysql query)
genai.configure(api_key="AIzaSyBYQ3Pz-SLDTg3M_Ly87u2glyuLhgb1Bac")

# Function to load Google Gemini Model and provide queries as response
def get_gemini_response(question, prompt):
    model = genai.GenerativeModel('gemini-pro')
    response = model.generate_content([prompt[0], question])
    return response.text

# Function to retrieve query from the database
def read_sql_query(sql, conn):
    cursor = conn.cursor()
    print("******sql : ", sql)
    cursor.execute(sql)
    rows = cursor.fetchall()
    print("------rows = ", rows)
    return rows

# Define your prompt
prompt = [
    """
    You are an expert in converting English questions to SQL query!
    The SQL database has the name Consumer within which it has a table called consumer which has the following columns - consumer_id, consumer_age, consumer_food_habbits, consumer_kind, consumer_login, consumer_name, consumer_order, consumer_sex and consumer_address
    please look for details in table "consumer" and not "Consumer".
    There is another table in the database called items which has the following columns - item_id, item_cost, item_name
    "consumer_order" from table "consumer" relates to "item_name" in table "items".
    # For example:
    # Example 1 - How many entries of records are present?
    # Example 2 - Tell me all the order of the consumer with name "Gaura Gopal"?
    # Example 3 - What items are available in your menu?
    """
]

# Streamlit App
st.set_page_config(page_title="I can Retrieve Any SQL query")
st.header("Gemini App To Retrieve SQL Data")

question = st.text_input("Input:")
submit = st.button("Ask the question")

# If submit is clicked
if submit:
    st.write(question)
    response = get_gemini_response(question, prompt)
    st.subheader("The Response is")
    st.write(response)
    try:
        response =response.replace("```","")
        response =response.replace("sql","")
        sql_query = f""" 
        {response}
        """
        print("------",sql_query)

        print("Connecting db")
        # Connect to MySQL database
        conn = mysql.connector.connect(
            host="localhost",
            port="3307",
            user="root",
            password="root",
            database="Consumer"
        )
        
        print("connected db")
#         sql_query = """
# SELECT COUNT(*) AS row_count FROM Teacher;
# """
        print("******* ",sql_query)
        result = read_sql_query(sql_query, conn)
        print("result : ", result)
        if result:
            st.subheader("The Result is")
            st.table(result)
        else:
            st.write("No records found.")
        conn.close()
    except Exception as e:
        st.write(f"Failed to retrieve SQL query or execute it: {str(e)}")