package com.example.tabletopsupp.playerCreation;

public class ClassDescription {
    private int life;
    private int mana;
    public String warrior(){
        String  warrior = "Características de classe\n" +
                "Pontos de Vida: Um guerreiro começa com 20 pontos de vida (+ modificador de Constituição)" +
                " e ganha 5 PV (+ mod. Con) por nível.\n" +
                "Pontos de Mana: 3 PM por nível.\n" +
                "Perícias: Luta (For) ou Pontaria (Des), Fortitude (Con), mais 2 a sua escolha entre Adestramento (Car)," +
                " Atletismo (For), Cavalgar (Des), Guerra (Int), Iniciativa (Des), Intimidação (Car), Luta (For)," +
                " Ofício (Int), Percepção (Sab), Pontaria (Des) e Reflexos (Des).\n" +
                "Proficiências: Armas marciais, armaduras pesadas e escudos.";

        return warrior;

    }

    public int lifeWarrior(int modConst){
        int life = 20;
         life += modConst ;

        return life;
    }

    public int manaWarrior(int level){
        int mana = 3;
        mana = level*mana;

        return mana;
    }

    public String rogue(){
        String  rogue = "Características de classe\n" +
                "Pontos de Vida: Você começa com 12 pontos de vida (+ modificador de Constituição) e" +
                " ganha 3 PV (+ mod. Con) por nível.\n" +
                "Pontos de Mana: 4 PM por nível.\n" +
                "Perícias: Ladinagem (Des) e Reflexos (Des), mais 8 a sua escolha entre Acrobacia (Des)," +
                " Atletismo (For), Atuação (Car), Cavalgar (Des), Conhecimento (Int), Diplomacia (Car), Enganação (Car)," +
                " Furtividade (Des), Iniciativa (Des), Intimidação (Car), Intuição (Sab), Investigação (Int)," +
                " Jogatina (Car), Luta (For), Ofício (Int), Percepção (Sab), Pilotagem (Des) e Pontaria (Des).\n" +
                "Proficiências: Nenhuma.";

        return rogue;
    }

    public int lifeRogue(int modConst){
        int life = 12;
        life += modConst ;

        return life;
    }

    public int manaRogue(int level){
        int mana = 4;
        mana = level*mana;

        return mana;
    }

    public String fighter(){
        String  fighter = "Características de classe\n" +
                "Pontos de Vida: Você começa com 20 pontos de vida (+ modificador de Constituição) e" +
                " ganha 5 PV (+ mod. Con) por nível.\n" +
                "Pontos de Mana: 3 PM por nível.\n" +
                "Perícias: Fortitude (Con) e Luta (For), mais 4 a sua escolha entre Acrobacia (Des)," +
                " Adestramento (Car), Atletismo (For), Enganação (Car), Furtividade (Des), Iniciativa (Des)," +
                " Intimidação (Car), Ofício (Int), Percepção (Sab), Pontaria (Des) e Reflexos (Des).\n" +
                "Proficiências: Nenhuma.";

        return fighter;
    }

    public int lifeFighter(int modConst){
        int life = 20;
        life += modConst ;

        return life;
    }

    public int manaFighter(int level){
        int mana = 3;
        mana = level*mana;

        return mana;
    }
}
