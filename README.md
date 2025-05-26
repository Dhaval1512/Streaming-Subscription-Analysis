# Streaming-Subscription-Analysis
Java-based tool to compare and recommend streaming services using real-time web scraping.

# 🎬 Streaming Subscription Analysis

**Streaming Subscription Analysis** is a Java-based project designed to help users compare and choose the best streaming platform—**Netflix, Amazon Prime Video, Disney+, Paramount+, and Rakuten Viki**—based on real-time data.

## 📌 Features

- 🔍 **Web Scraping**: Extracts subscription plans, content types, and streaming features from official websites using Selenium.
- 📊 **Data Processing**: Converts scraped HTML data into clean, structured CSV and text formats using Jsoup.
- 🤖 **Recommendation System**: Suggests the best streaming service based on user preferences like budget, genre, and video quality.
- 🧠 **Algorithms & Data Structures**:
  - Edit Distance (Spell Checking)
  - Trie (Inverted Indexing)
  - AVL Tree (Feature Frequency Counting)
  - Hash Map (Search Frequency & Word Completion)
  - Boyer-Moore (Page Ranking)
- 🖥️ **GUI Interface**: Interactive Java-based UI for user input and result visualization.

## 👥 Team Contributions

Each team member contributed by scraping a different streaming platform and implementing a key feature:
- **Netflix**: Page Ranking, Frequency Search
- **Amazon Prime**: Spell Checking, Regex Validation
- **Disney+**: Inverted Indexing, Best Plan Search
- **Paramount+**: Frequency Count, Web Crawler
- **Rakuten Viki**: Word Completion, Regex-based Validation

## 🧩 Technologies Used

- Java, HTML, CSS, JavaScript  
- Selenium WebDriver  
- Jsoup (HTML Parsing)  
- Data formats: CSV, TXT

## 🚀 Future Enhancements

- Add more platforms like Hulu, Apple TV+
- Implement machine learning for smarter recommendations
- Add visual dashboards using graphs and charts

## 🗃️ Folder Structure
/src
├── webcrawler/
├── parser/
├── services/
├── gui/
└── data/

