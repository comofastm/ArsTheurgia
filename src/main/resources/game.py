import os
import sys

directory = "./assets/arstheurgia/blockstates/"
string = "{\n\"type\": \"minecraft:block\",\n\"pools\": [\n\t{\n\t\t\"rolls\": 1,\n\t\t\"entries\": [\n\t\t\t{\n\t\t\t\t\"type\": \"minecraft:item\",\n\t\t\t\t\"name\": \"tutorial:example_block\"\n\t\t\t}\n\t\t],\n\t\t\"conditions\": [\n\t\t\t{\n\t\t\t\t\"condition\": \"minecraft:survives_explosion\"\n\t\t\t}\n\t\t]\n\t}\n]\n}"
for filename in os.listdir(directory):
    f = open("data/arstheurgia/loot_tables/blocks/"+filename, "w") 
    f.write(string.replace("tutorial:example_block", "arstheurgia:"+filename.replace(".json","")))
    f.close()
