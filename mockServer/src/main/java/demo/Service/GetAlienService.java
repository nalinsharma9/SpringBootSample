package main.com.demo.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.com.demo.Model.Alien;

import javax.swing.tree.TreeNode;

public class GetAlienService {
    public static void main(String[] args) throws JsonProcessingException {
        Alien alien1 = new Alien();
        alien1.setAid(1);
        alien1.setAname("Nalin");
        alien1.setTech("Java");

        Alien alien2 = new Alien();
        alien2.setAid(2);
        alien2.setAname("Nikhil");
        alien2.setTech("C#");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode1 = mapper.valueToTree(alien1);
        JsonNode jsonNode2 = mapper.valueToTree(alien2);
        ArrayNode jsonNodeArray = mapper.createArrayNode();
        jsonNodeArray.add(jsonNode1);
        jsonNodeArray.add(jsonNode2);

        for(JsonNode node: jsonNodeArray ){
            ObjectNode objectNode = (ObjectNode) node;
//            System.out.println(objectNode.get("name").asText());
            System.out.println(objectNode.get("id"));
            objectNode.put("name",objectNode.get("name").asText()+" Sharma");
            objectNode.put("id",objectNode.get("id").asInt()+1);
        }
        System.out.println(jsonNodeArray.toPrettyString());

        for(JsonNode node: jsonNodeArray ) {
            Alien alien = mapper.treeToValue(node, Alien.class);
            System.out.println(alien.getAid());
        }

    }
}
