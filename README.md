# Simple Blockchain-Based Secure Transaction System

## Introduction

This project is a simple blockchain implementation developed using Java. It demonstrates the basic concepts of blockchain such as blocks, transactions, hashing, previous block linking, and blockchain verification.

## Objectives

* To understand the basic structure of blockchain.
* To implement blocks and transactions using Java.
* To generate SHA-256 hashes.
* To connect blocks using previous hashes.
* To detect unauthorized modification of blockchain data.

## Technologies Used

* Java
* SHA-256 Hashing
* ArrayList
* Java Scanner

## Features

* Add transactions
* Create blockchain blocks
* Generate SHA-256 hash
* Display complete blockchain
* Verify blockchain integrity
* Detect tampering

## How It Works

Each transaction is stored in a block. Every block contains its own hash and the hash of the previous block. If the transaction or any important block data is changed, its hash changes. Therefore, the blockchain verification process can detect the modification.

## How to Run

1. Install Java JDK.
2. Download or clone this repository.
3. Open the project in a Java IDE or terminal.
4. Compile the program:

```bash
javac Blockchain.java
```

5. Run the program:

```bash
java Blockchain
```

## Sample Transactions

```text
Aniket -> Rahul : Rs.500
Rahul -> Amit : Rs.200
Amit -> Priya : Rs.100
```

## Project Output

The program displays the block number, transaction, previous hash, current hash, and timestamp.

## Conclusion

The project demonstrates the fundamental working of blockchain using Java. It shows how blocks are connected using cryptographic hashes and how blockchain integrity can be verified.

## Future Scope

The project can be extended by adding a graphical user interface, multiple users, digital signatures, a peer-to-peer network, and a consensus mechanism.
