/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況調査票サービスの状況99Aを表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum GaikyoChosahyouServiceJyouk99A {

    /**
     * データベース内連番:1 単位1:回 単位2:/月 帳票上の文言:訪問介護(ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ)
     */
    訪問介護("1", get単位_回(), get単位_月(), "訪問介護(ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ)"),
    /**
     * データベース内連番:2 単位1:回 単位2:/月 帳票上の文言:訪問入浴介護
     */
    訪問入浴介護("2", get単位_回(), get単位_月(), "訪問入浴介護"),
    /**
     * データベース内連番:3 単位1:回 単位2:/月 帳票上の文言:訪問看護
     */
    訪問看護("3", get単位_回(), get単位_月(), "訪問看護"),
    /**
     * データベース内連番:4 単位1:回 単位2:/月 帳票上の文言:訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ
     */
    訪問リハビリ("4", get単位_回(), get単位_月(), "訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ"),
    /**
     * データベース内連番:5 単位1:回 単位2:/月 帳票上の文言:居宅療養管理指導
     */
    居宅療養管理指導("5", get単位_回(), get単位_月(), "居宅療養管理指導"),
    /**
     * データベース内連番:6 単位1:回 単位2:/月 帳票上の文言:通所介護(ﾃﾞｲｻｰﾋﾞｽ)
     */
    通所介護("6", get単位_回(), get単位_月(), "通所介護(ﾃﾞｲｻｰﾋﾞｽ)"),
    /**
     * データベース内連番:7 単位1:回 単位2:/月 帳票上の文言:通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ(ﾃﾞｲｹｱ)
     */
    通所リハビリ("7", get単位_回(), get単位_月(), "通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ(ﾃﾞｲｹｱ)"),
    /**
     * データベース内連番:8 単位1:品目 単位2:無 帳票上の文言:福祉用具貸与
     */
    福祉用具貸与("8", get単位_品目(), "", "福祉用具貸与"),
    /**
     * データベース内連番:9 単位1:日 単位2:/月 帳票上の文言:短期入所生活介護(特養)
     */
    短期入所生活介護("9", get単位_日(), get単位_月(), "短期入所生活介護(特養)"),
    /**
     * データベース内連番:10 単位1:日 単位2:/月 帳票上の文言:短期入所療養介護(老健・診療所)
     */
    短期入所療養介護("10", get単位_日(), get単位_月(), "短期入所療養介護(老健・診療所)"),
    /**
     * データベース内連番:11 単位1:日 単位2:/月 帳票上の文言:認知症対応型共同生活介護
     */
    認知症対応型共同生活介護("11", get単位_日(), get単位_月(), "認知症対応型共同生活介護"),
    /**
     * データベース内連番:12 単位1:日 単位2:/月 帳票上の文言:特定施設入所者生活介護
     */
    特定施設入所者生活介護("12", get単位_日(), get単位_月(), "特定施設入所者生活介護"),
    /**
     * データベース内連番:13 単位1:品目 単位2:無 帳票上の文言:福祉用具購入
     */
    福祉用具購入("13", get単位_品目(), "", "福祉用具購入");

    private final RString code;
    private final RString tani1;
    private final RString tani2;
    private final RString fullName;

    private GaikyoChosahyouServiceJyouk99A(String code, String tani1, String tani2, String fullname) {
        this.code = new RString(code);
        this.tani1 = new RString(tani1);
        this.tani2 = new RString(tani2);
        this.fullName = new RString(fullname);
    }

    /**
     * 概況調査票サービスの状況99Aの連番を返します。
     *
     * @return 概況調査票サービスの状況99Aの連番
     */
    public RString get連番() {
        return code;
    }

    /**
     * 概況調査票サービスの状況99Aの単位1を返します。
     *
     * @return 概況調査票サービスの状況99Aの単位1
     */
    public RString get単位1() {
        return tani1;
    }

    /**
     * 概況調査票サービスの状況99Aの単位2を返します。
     *
     * @return 概況調査票サービスの状況99Aの単位2
     */
    public RString get単位2() {
        return tani2;
    }

    /**
     * 概況調査票サービスの状況99Aの帳票上の文言を返します。
     *
     * @return 概況調査票サービスの状況99Aの帳票上の文言
     */
    public RString get名称() {
        return fullName;
    }

    private static String get単位_日() {
        return new RString("日").toString();
    }

    private static String get単位_品目() {
        return new RString("品目").toString();
    }

    private static String get単位_回() {
        return new RString("回").toString();
    }

    private static String get単位_月() {
        return new RString("/月").toString();
    }

    /**
     * 概況調査票サービスの状況99Aの連番と一致する内容を探します。
     *
     * @param code 概況調査票サービスの状況99Aの連番
     * @return {@code code} に対応する概況調査票サービスの状況99A
     */
    public static GaikyoChosahyouServiceJyouk99A toValue(RString code) {
        for (GaikyoChosahyouServiceJyouk99A values : GaikyoChosahyouServiceJyouk99A.values()) {
            if (values.code.equals(code)) {
                return values;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("概況調査票サービスの状況99A"));
    }
}
