import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class StudiChain {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static void main (String[] args) {
        blockchain.add(new Block("Salut, je suis le 1er block!", "0"));
        blockchain.add(new Block("Hi, je suis le 2eme block!", blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block("Hey, je suis le 3eme block!", blockchain.get(blockchain.size()-1).getHash()));

        if (isChainValid()) {
            System.out.println("Chain est valide");
        }
        else {
            System.out.println("Chain n'est pas valide");
        }
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i=1; i< blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())){
                System.out.println("Problem avec le Hash");
                return false;
            }
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Probleme avec le hash precedent");
                return false;
            }
        }
        return true;
    }
}
