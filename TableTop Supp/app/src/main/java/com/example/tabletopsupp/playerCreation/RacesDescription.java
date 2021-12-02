package com.example.tabletopsupp.playerCreation;

public class RacesDescription {

    public String human() {
        String human = "Características de raça\n" +
                "+2 pontos em Três Atributos Diferentes: Filhos da Deusa da Ambição, humanos podem se destacar em qualquer caminho que escolham.\n" +
                "Versátil: Você se torna treinado em duas perícias a sua escolha (não precisam ser da sua classe)." +
                "\n Você pode trocar uma dessas perícias por um poder geral a sua escolha.";

        return human;

    }

    public String elf() {
        String elf = "Características de raça\n" +
                "Inteligência +4, Destreza +2, Constituição  –2.\n" +
                "Graça de Glórienn: Seu deslocamento é 12m (em vez de 9m).\n" +
                "Herança Feérica: Você recebe +1 ponto de mana por nível.\n" +
                "Sentidos Élficos: Você recebe visão na penumbra e +2 em Misticismo e Percepção.";

        return elf;

    }

    public String dwarf() {
        String dwarf = "Características de raça\n" +
                "Constituição +4, Sabedoria +2, Destreza  –2.\n" +
                "Conhecimento das Rochas: Você recebe visão no escuro" +
                " e +2 em testes de Percepção e Sobrevivência realizados no subterrâneo.\n" +
                "Devagar e Sempre: Seu deslocamento é 6m (em vez de 9m). Porém, seu deslocamento nunca é reduzido" +
                " por uso de armadura ou excesso de carga.\n" +
                "Duro como Pedra: Você recebe +3 pontos de vida no 1º nível e +1 por nível seguinte.\n" +
                "Tradição de Heredrimm: Você é perito nas armas tradicionais anãs, seja por ter treinado com elas," +
                " seja por usá-las como ferramentas de ofício. Para você, todos os machados, martelos, marretas e picaretas são armas simples." +
                " Você recebe +2 em ataques com essas armas.";

        return dwarf;

    }

}
