package kelasterbuka.latihan01;

//player
class Player{
    String name;
    double health;
    int level;
    
    //object member
    Weapon weapon;
    Armor armor;
    
    Player(String name, double health){
        this.name = name;
        this.health = health;
    }
    
    void att(Player opponet){
        double attpower = this.weapon.attpower;        
        System.out.println(this.name + " attacking " +opponet.name + " with power " + attpower);
        
        opponet.def(attpower);
    }
    
    void def(double attpower){
        //akan mengambil dmg
        //if attpower > deffpower
        double damage;
        if(this.armor.deffpower < attpower){
            damage = attpower - this.armor.deffpower;
        } else{
            damage = 0;
        }
        
        this.health -= damage;
        System.out.println(this.name + " gets damage " + damage);
    }
            
    void equipweapon(Weapon weapon){
        this.weapon = weapon;
    }
    
    void equiparmor(Armor armor){
        this.armor = armor;
    }
    
    void display(){
        System.out.println("Name : " + this.name);
        System.out.println("Health : " +this.health + "hp");
        this.weapon.display();
        this.armor.display();
    }
}

//senjata
class Weapon{
    double attpower;
    String name;

    Weapon(String name, double attpower){
        this.name = name;
        this.attpower = attpower;
    }
    
    void display(){
        System.out.println("Weapon : " + this.name + " , power : " + this.attpower);
    }
}

//armor
class Armor{
    double deffpower;
    String name;
    
    Armor(String name, double deffpower){
        this.name = name;
        this.deffpower = deffpower;
    }
    
    void display(){
        System.out.println("Armor : " + this.name + " , power : " + this.deffpower);
    }
}

public class KelasTerbukaLatihan01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //membuat object player
        Player p1 = new Player("He",100);
        Player p2 = new Player("Her",50);
        
        //membuat object weapon
        Weapon sword = new Weapon("Sword",15);
        Weapon bow = new Weapon("Bow",20);
        
        //membuat oject armor
        Armor chestplate = new Armor("ChestPlate",10);
        Armor leatherarmor = new Armor("LeatherArmor",0);
        
        //equip senjata dan armor
        
        //p1
        p1.equipweapon(sword);
        p1.equiparmor(chestplate);
        p1.display();
        p1.weapon.display();
        p1.armor.display();
        
        
        //spasi
        System.out.println("");
        
        //p2
        p2.equipweapon(bow);
        p2.equiparmor(leatherarmor);
        p2.display();
        p2.weapon.display();
        p2.armor.display();
        
        System.out.println("\nBattle 1");
        System.out.println("");
        p1.att(p2);
        System.out.println("");
        p1.display();
        System.out.println("");
        p2.display();
        System.out.println("\nBattle 2");
        System.out.println("");
        p2.att(p1);
        System.out.println("");
        p1.display();
        System.out.println("");
        p2.display();
        
    }
    
}
