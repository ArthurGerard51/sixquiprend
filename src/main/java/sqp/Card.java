package sqp;

public enum Card {
    C_1(1,1),
    C_2(2,1),
    C_3(3,1),
    C_4(4,1),
    C_5(5,2),
    C_6(6,1),
    C_7(7,1),
    C_8(8,1),
    C_9(9,1),
    C_10(10,3),
    C_11(11,5),
    C_12(12,1),
    C_13(13,1),
    C_14(14,1),
    C_15(15,2),
    C_16(16,1),
    C_17(17,1),
    C_18(18,1),
    C_19(19,1),
    C_20(20,3),
    C_21(21,1),
    C_22(22,5),
    C_23(23,1),
    C_24(24,1),
    C_25(25,2),
    C_26(26,1),
    C_27(27,1),
    C_28(28,1),
    C_29(29,1),
    C_30(30,3),
    C_31(31,1),
    C_32(32,1),
    C_33(33,5),
    C_34(34,1),
    C_35(35,2),
    C_36(36,1),
    C_37(37,1),
    C_38(38,1),
    C_39(39,1),
    C_40(40,3),
    C_41(41,1),
    C_42(42,1),
    C_43(43,1),
    C_44(44,5),
    C_45(45,2),
    C_46(46,1),
    C_47(47,1),
    C_48(48,1),
    C_49(49,1),
    C_50(50,3),
    C_51(51,1),
    C_52(52,1),
    C_53(53,1),
    C_54(54,1),
    C_55(55,7),
    C_56(56,1),
    C_57(57,1),
    C_58(58,1),
    C_59(59,1),
    C_60(60,3),
    C_61(61,1),
    C_62(62,1),
    C_63(63,1),
    C_64(64,1),
    C_65(65,2),
    C_66(66,5),
    C_67(67,1),
    C_68(68,1),
    C_69(69,1),
    C_70(70,3),
    C_71(71,1),
    C_72(72,1),
    C_73(73,1),
    C_74(74,1),
    C_75(75,2),
    C_76(76,1),
    C_77(77,5),
    C_78(78,1),
    C_79(79,1),
    C_80(80,3),
    C_81(81,1),
    C_82(82,1),
    C_83(83,1),
    C_84(84,1),
    C_85(85,2),
    C_86(86,1),
    C_87(87,1),
    C_88(88,5),
    C_89(89,1),
    C_90(90,3),
    C_91(91,1),
    C_92(92,1),
    C_93(93,1),
    C_94(94,1),
    C_95(95,2),
    C_96(96,1),
    C_97(97,1),
    C_98(98,1),
    C_99(99,5),
    C_100(100,3),
    C_101(101,1),
    C_102(102,1),
    C_103(103,1),
    C_104(104,1);

    Card(int num, int head){
        number = num;
        headNumber = head;
        player = null;
    }

    private int number;
    private int headNumber;
    private AbstractPlayer player;

    public int getNumber() {
        return number;
    }

    public int getHeadNumber() {
        return headNumber;
    }
    public AbstractPlayer getPlayer(){
        return player;
    }

    public void setPlayer(AbstractPlayer playerThatPlayed){
        player = playerThatPlayed;
    }

    public String getImage() {
        return "src/main/resources/sqp/cards/" + number + ".png";
    }


}
