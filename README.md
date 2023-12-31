# App Documentation (edu project)
(generated by ChatGpt - reviewed and changed by author - Artur Szmer)
## Overview

This app is a Java-based service that provides various functionalities related to text generation and language improvement. It uses the OpenAI API for chat-based text generation. The app includes two main controllers: `ChatController` and `FlashCardsController`, each serving different purposes.

## Configuration
The `OpenAiInterceptor` class is an essential part of the app's integration with the OpenAI API. It serves as a configuration class for Feign client requests, ensuring that the necessary authorization is added to the requests.


The `OpenAiInterceptor` class is automatically configured within the Spring application context and is used to add the necessary authorization header to Feign client requests when communicating with the OpenAI API. The API key is obtained from the `OPENAI_TOKEN` environment variable for secure authentication.

This class ensures that requests to the OpenAI API are properly authenticated, making it a crucial component of the app's integration with OpenAI services.

## ChatController

### Endpoints

#### Chat

- **Endpoint:** `/api/chat`
- **Method:** POST
- **Description:** This endpoint allows users to engage in a conversation with the chat-based model. It takes a JSON request containing a `ChatMessage` and returns a `ChatCompletionResponse`. The conversation is processed by the `ChatService.conversation` method, which communicates with the OpenAI API.

#### English Improver

- **Endpoint:** `/api/english-improver`
- **Method:** POST
- **Description:** This endpoint is used for grammatical improvement of text provided by the user. It takes a JSON request with a `ChatMessage` and returns an improved grammatical version of the text. The `ChatService.englishImprover` method is responsible for processing this request using the OpenAI API.

## FlashCardsController

### Endpoints

#### Generate Flash Cards

- **Endpoint:** `/api/anki/generate`
- **Method:** POST
- **Content Type:** `text/plain`
- **Parameters:**
    - `languageLevel` (Query Parameter): Specifies the language level for generating flashcards.
- **Description:** This endpoint generates flashcards from the provided text. It communicates with the `GenerateFlashCardsService` to process the request and returns a list of `Card` objects. The language level is specified as a query parameter.

## Models

### ChatMessage

- Represents a message in a conversation.
- Contains the message content and the role of the sender (e.g., user or system).

### ChatCompletionRequest

- Represents a request for chat-based text generation.
- Includes various parameters such as the model, messages, and tokens for customizing text generation.

### ChatCompletionResponse

- Represents the response from chat-based text generation.
- Contains the generated text and relevant information.

### Card

- Represents a flashcard with a front and back side.

### FlashCards

- Contains a list of flashcards.

## Services

### ChatService

- Provides services for text generation and conversation with the OpenAI API.
- Includes methods for conversation, grammatical improvement, and flashcard generation.

### GenerateFlashCardsService

- Implements flashcard generation from text, using the OpenAI API.

## Console Interface

A `MyConsole` class is provided to interact with the app via a console interface. Users can start a conversation with the chat-based model.

## Main Application

The main application class, `OpenAiLibApplication`, initializes the Spring Boot application, configures the application context, and starts the console interface for user interaction.

## Usage

1. Run the `OpenAiLibApplication` class to start the Spring Boot application.
2. Access the app's endpoints, such as `/api/chat` for conversation and `/api/anki/generate` for flashcard generation, through HTTP requests.
3. Use the console interface via the `MyConsole` class to engage in conversations and request grammatical improvements.

Feel free to refer to this documentation for an overview of the app's functionalities and endpoints. You can use the provided endpoints to interact with the app and leverage its features for text generation and language improvement.
