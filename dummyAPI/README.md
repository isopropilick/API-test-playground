
# Dummy API

A simple Spring Boot API for file operations. This API allows you to create, delete, read, and list files in a specified directory.

## API Endpoints

### Create a Text File

**Endpoint:** `/file/create`
Creates a text file with the provided content in the specified directory.

#### Request

- Method: POST
- Headers:
    * `file-name` (String): The name of the file.
    * `directory` (String): The directory path where the file will be created.
- Request Body: The content of the text file.

#### Response

- 201 (Created): File created successfully.
- 500 (Internal Server Error): Error creating the file.

  ---
### Delete a Text File

**Endpoint:** `/file/delete`

Deletes the specified text file from the specified directory.

#### Request

- Method: DELETE
- Headers:
    * `file-name` (String): The name of the file to be deleted.
    * `directory` (String): The directory path where the file is located.

#### Response

- 200 (OK): File deleted successfully.
- 404 (Not Found): File not found.
- 500 (Internal Server Error): Error deleting the file.

  ---
### Read a Text File

**Endpoint:** `/file/read`

Reads the content of the specified text file from the specified directory.

#### Request

- Method: GET
- Headers:
    * `file-name` (String): The name of the file to be read.
    * `directory` (String): The directory path where the file is located.

#### Response

- 200 (OK): The content of the text file.
- 404 (Not Found): File not found.
- 500 (Internal Server Error): Error reading the file.

  ---
### List Files in a Directory

**Endpoint:** `/file/list`

Lists all files in the specified directory.

#### Request

- Method: GET
- Headers:
    * `directory` (String): The directory path to list files from.

#### Response

- 200 (OK): An array of file names in the directory.
- 404 (Not Found): Directory not found.
- 500 (Internal Server Error): Error listing files.

## Getting Started

1. Clone this repository.
2. Build and run the Spring Boot application.

## Prerequisites

- Java 8+
- Maven

## Built With

- Spring Boot

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
