/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書のイメージ管理を表す列挙型です。
 */
public enum ShujiiIkenshoImages {

    /**
     * 他科受診の有無_その他
     */
    他科受診の有無_その他("1", "D1001"),
    /**
     * 他科受診の有無_その他
     */
    特定疾病1("2", "D1002"),
    /**
     * 他科受診の有無_その他
     */
    特定疾病2("3", "D1003"),
    /**
     * 他科受診の有無_その他
     */
    特定疾病4("4", "D1004"),
    /**
     * 傷病特別疾病の経過及び投薬内容を含む治療内容
     */
    傷病特別疾病の経過及び投薬内容を含む治療内容("5", "D1005"),
    /**
     * 傷病特別疾病の経過及び投薬内容を含む治療内容_原本
     */
    傷病特別疾病の経過及び投薬内容を含む治療内容_原本("6", "D1005_BAK"),
    /**
     * 認知症の周辺症状_その他
     */
    認知症の周辺症状_その他("7", "D1006"),
    /**
     * その他の精神_神経症状名
     */
    その他の精神_神経症状名("8", "D1007"),
    /**
     * 専門医受診の有無
     */
    専門医受診の有無("9", "D1008"),
    /**
     * 専門医受診の有無_原本
     */
    専門医受診の有無_原本("10", "D1008_BAK"),
    /**
     * 体重
     */
    体重("11", "D1009"),
    /**
     * 身長
     */
    身長("12", "D1010"),
    /**
     * 四肢欠損_部位
     */
    四肢欠損_部位("13", "D1011"),
    /**
     * 麻痺_その他部位
     */
    麻痺_その他部位("14", "D1012"),
    /**
     * 筋力の低下_部位
     */
    筋力の低下_部位("15", "D1013"),
    /**
     * じょくそう_部位
     */
    じょくそう_部位("16", "D1014"),
    /**
     * その他の皮膚疾患_部位
     */
    その他の皮膚疾患_部位("17", "D1015"),
    /**
     * 現在あるかまたは今後発生の可能性の高い状態_その他
     */
    現在あるかまたは今後発生の可能性の高い状態_その他("18", "D1017"),
    /**
     * 現在あるかまたは今後発生の可能性の高い状態_その他_対処方針
     */
    現在あるかまたは今後発生の可能性の高い状態_その他_対処方針("19", "D1018"),
    /**
     * その他の医療系サービス
     */
    その他の医療系サービス("20", "D1019"),
    /**
     * 血圧
     */
    血圧("21", "D1020"),
    /**
     * えん下
     */
    えん下("22", "D1021"),
    /**
     * 摂食
     */
    摂食("23", "D1022"),
    /**
     * 移動
     */
    移動("24", "D1023"),
    /**
     * 医学的観点_その他
     */
    医学的観点_その他("25", "D1024"),
    /**
     * 感染症
     */
    感染症("26", "D1025"),
    /**
     * 意見書特記
     */
    意見書特記("27", "D1026"),
    /**
     * 意見書特記_原本
     */
    意見書特記_原本("28", "D1026_BAK"),
    /**
     * 症状としての安定性_不安定
     */
    症状としての安定性_不安定("29", "D1027"),
    /**
     * 症状としての安定性_不安定_原本
     */
    症状としての安定性_不安定_原本("30", "D1027_BAK"),
    /**
     * 関節の拘縮_部位
     */
    関節の拘縮_部位("31", "D1028"),
    /**
     * 関節の痛み_部位
     */
    関節の痛み_部位("32", "D1029"),
    /**
     * 栄養_食生活の留意点
     */
    栄養_食生活の留意点("33", "D1030"),
    /**
     * 運動
     */
    運動("34", "D1031");

    private final RString no;
    private final RString fileName;

    private ShujiiIkenshoImages(String no, String fileName) {
        this.no = new RString(no);
        this.fileName = new RString(fileName);
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return this.no;
    }

    /**
     * ファイル名を返します。
     *
     * @return ファイル名
     */
    public RString getファイル名() {
        return this.fileName;
    }

    /**
     * enumの名称を返します。
     *
     * @return enumの名称
     */
    public RString getName() {
        return this.getName();
    }

    /**
     * 引数に渡された連番に対応する主治医意見書のイメージ管理を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param no 連番
     * @return 対応するイメージ管理
     * @throws IllegalArgumentException 引数に対応するイメージ管理が存在しないとき
     */
    public static ShujiiIkenshoImages toValueFromNo(RString no) throws IllegalArgumentException {
        for (ShujiiIkenshoImages item : values()) {
            if (item.get連番().equals(no)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 引数に渡されたファイル名に対応する主治医意見書のイメージ管理を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param fileName ファイル名
     * @return 対応するイメージ管理
     * @throws IllegalArgumentException 引数に対応するイメージ管理が存在しないとき
     */
    public static ShujiiIkenshoImages toValueFromFileName(RString fileName) throws IllegalArgumentException {
        for (ShujiiIkenshoImages item : values()) {
            if (item.getファイル名().equals(fileName)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

}
