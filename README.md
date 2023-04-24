# BlueVa Frontend

## Author: 

Abhijith

Nishanth 

## Project Structure 

This project comprises of two sub projects( frontend and backend ). Link to backend can be seen as a submodule in root path of this present repo link.

## Description

The tool BLUEVA is an acronym for BLUEprint jaVA.
We envision a tool that would be used by novice developers to create Java programs with the help of nodes being the basic development unit of development.

Blueva primarily focuses on easy access and a better coding environment, enabling users to code and visually understand the code's working.  
It also enables the developers to easily debug the code as it is in the form of interconnected nodes with the help of pre-designed debugging elements. This tool considers any java program as a tree-like structure made from independent working atomic units called nodes. 

## How our idea differs 

Our Idea differs from the existing ones since none of the existing visual scriptings support Java and the Blueprints for C++ in Unreal Engine are used for game development solely.
Our tool is targeted towards a general developers community and helps them write Java programs with ease.

## Similar Works 

The most similar work we came across was Blueprints for creating gameplay systems in Unreal Engine 5.1 (in earlier versions too) which is built upon C++ code to generate C++ code.
We also came across MIT’s Scratch, Scratch is a high-level block-based visual programming language helping developers to learn the basics of coding.

## Functionalities ( can be done on backend using the UI )

1. Supports multiple packages 
2. create class,enums and interfaces in files on the provided directory following the package path convention
3. add documentation to methods/fields/class/enums/file comments/interfaces/enums/parameters
4. automatic constructor creation ( default and parameterized constructor )
5. automatic default value initialization of fields 
6. method with both primtive type + array types based on primitive types
7. supports all access modifiers and non-access modifiers
8. allow extending other classes 
9. allow implementing other interfaces

Note: GUI part comes under frontend part of this app

## Links
1. Workflow Link [Link](https://drive.google.com/file/d/1d5iuXdy5BAa6lV574-3G1fSnnQo9vdFI/view?usp=share_link)

## Screenshots (only frontend)

![Class-I](https://drive.google.com/uc?export=view&id=1HyU9udRyuj-B3NyGEUzrvVx4GMCYhsKp)
![Class-I](https://drive.google.com/uc?export=view&id=1ocio3iSBke7L1-tnsX5T4lRFobvc0Zrj)
![Class-I](https://drive.google.com/uc?export=view&id=1JxKI-mtEZ9EVaFf2EE_5X9ZEtNsoWm2m)
![Class-I](https://drive.google.com/uc?export=view&id=1rBazxsD36zDuBxawigpcL2DU067j1ZeU)
![Class-I](https://drive.google.com/uc?export=view&id=1n-nu_LXzq2u7cA-CxDCno8SilVnta6Ea)
![Class-I](https://drive.google.com/uc?export=view&id=1r6cXBeu3DsUmXT-yALBb2HhoihkjYNkW)
![Class-I](https://drive.google.com/uc?export=view&id=1wDeRp2Z5uFlgL3yK2OZNyiUXpOkmQpap)
![Class-I](https://drive.google.com/uc?export=view&id=1t35qmM_HiVlZRVf7d2SJ8sivdXhqn7_Z)
![Class-I](https://drive.google.com/uc?export=view&id=1Kvuw8z96sMrZy5P9eCCWcZ0XloFsr1XW)

## To build
We have used Maven build system for the project and it is suggested to use the same. Intellij IDE has intellisense which would further properly index and analyze the code as well.
To run the code the Main.java file inside "R2\src\main\java\com\indua\blueva\Main.java" should be run using the specified java versions and SDK.
# Developed Using: Java 16.0.2 2021-07-20 SDK Default 16 Oracle OpenJDK version 16.0.2, Amazon Corretto 19.0.2, javafx.runtime.version=17.0.2-ea+3, sun.cpu.isalist=amd64
