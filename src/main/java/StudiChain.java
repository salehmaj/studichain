public class StudiChain {
    public static void main (String[] args) {
        Block genesisBlock = new Block("Salut, je suis le 1er block!", "0");
        System.out.println("Hash pour le 1er block : " + genesisBlock.getHash());

        Block block2 = new Block("Hi, je suis le 2eme block!", genesisBlock.getHash());
        System.out.println("Hash pour le 2eme block : " + block2.getHash());

        Block block3 = new Block("Hey, je suis le 3eme block!", block2.getHash());
        System.out.println("Hash pour le 3eme block : " + block3.getHash());
    }
}
