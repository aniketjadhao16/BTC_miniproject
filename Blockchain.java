import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

class Block {

    int blockNumber;
    String transaction;
    String previousHash;
    String hash;
    long timestamp;

    Block(int blockNumber, String transaction, String previousHash) {

        this.blockNumber = blockNumber;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();

        this.hash = calculateHash();
    }

    String calculateHash() {

        String data = blockNumber + transaction + previousHash + timestamp;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] bytes = md.digest(data.getBytes());

            StringBuilder hex = new StringBuilder();

            for (byte b : bytes) {
                hex.append(String.format("%02x", b));
            }

            return hex.toString();

        } catch (Exception e) {
            return "";
        }
    }
}

public class Blockchain {

    static ArrayList<Block> blockchain = new ArrayList<>();

    // Create the first block
    static void createGenesisBlock() {

        Block genesis = new Block(
                0,
                "Genesis Block",
                "0"
        );

        blockchain.add(genesis);
    }

    // Add a new block
    static void addBlock(String transaction) {

        Block previousBlock =
                blockchain.get(blockchain.size() - 1);

        Block newBlock = new Block(
                blockchain.size(),
                transaction,
                previousBlock.hash
        );

        blockchain.add(newBlock);

        System.out.println("\nBlock added successfully!");
        System.out.println("Block Number: " + newBlock.blockNumber);
        System.out.println("Hash: " + newBlock.hash);
    }

    // Display complete blockchain
    static void displayBlockchain() {

        System.out.println("\n========== BLOCKCHAIN ==========");

        for (Block block : blockchain) {

            System.out.println("\nBlock Number : "
                    + block.blockNumber);

            System.out.println("Transaction  : "
                    + block.transaction);

            System.out.println("Previous Hash: "
                    + block.previousHash);

            System.out.println("Hash         : "
                    + block.hash);

            System.out.println("Timestamp    : "
                    + block.timestamp);
        }
    }

    // Verify blockchain
    static void verifyBlockchain() {

        for (int i = 1; i < blockchain.size(); i++) {

            Block current = blockchain.get(i);
            Block previous = blockchain.get(i - 1);

            // Check current block hash
            if (!current.hash.equals(current.calculateHash())) {

                System.out.println(
                        "\nBlockchain is INVALID!"
                );

                System.out.println(
                        "Block " + current.blockNumber
                        + " has been tampered."
                );

                return;
            }

            // Check previous hash connection
            if (!current.previousHash.equals(previous.hash)) {

                System.out.println(
                        "\nBlockchain is INVALID!"
                );

                System.out.println(
                        "Block connection is broken."
                );

                return;
            }
        }

        System.out.println(
                "\nBlockchain is VALID ✓"
        );

        System.out.println(
                "No block has been tampered with."
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        createGenesisBlock();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("       BLOCKCHAIN SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Add Transaction");
            System.out.println("2. Display Blockchain");
            System.out.println("3. Verify Blockchain");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter transaction: "
                    );

                    String transaction =
                            sc.nextLine();

                    addBlock(transaction);

                    break;

                case 2:

                    displayBlockchain();

                    break;

                case 3:

                    verifyBlockchain();

                    break;

                case 4:

                    System.out.println(
                            "Thank you!"
                    );

                    sc.close();

                    return;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }
        }
    }
}