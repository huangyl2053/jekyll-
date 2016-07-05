/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況調査票サービスの状況06Aを表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum GaikyoChosahyouServiceJyouk06A {

    /**
     * データベース内連番:1 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)訪問介護(ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ)
     */
    訪問介護("1", "回", "/月", "介護予防", "(介護予防)訪問介護(ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ)"),
    /**
     * データベース内連番:2 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)訪問入浴介護
     */
    訪問入浴介護("2", "回", "/月", "介護予防", "(介護予防)訪問入浴介護"),
    /**
     * データベース内連番:3 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)訪問看護
     */
    訪問看護("3", "回", "/月", "介護予防", "(介護予防)訪問看護"),
    /**
     * データベース内連番:4 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ
     */
    訪問リハビリ("4", "回", "/月", "介護予防", "(介護予防)訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ"),
    /**
     * データベース内連番:5 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)居宅療養管理指導
     */
    居宅療養管理指導("5", "回", "/月", "介護予防", "(介護予防)居宅療養管理指導"),
    /**
     * データベース内連番:6 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)通所介護(ﾃﾞｲｻｰﾋﾞｽ)
     */
    通所介護("6", "回", "/月", "介護予防", "(介護予防)通所介護(ﾃﾞｲｻｰﾋﾞｽ)"),
    /**
     * データベース内連番:7 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ(ﾃﾞｲｹｱ)
     */
    通所リハビリ("7", "回", "/月", "介護予防", "(介護予防)通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ(ﾃﾞｲｹｱ)"),
    /**
     * データベース内連番:8 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)短期入所生活介護(特養等)
     */
    短期入所生活介護("8", "回", "/月", "介護予防", "(介護予防)短期入所生活介護(特養等)"),
    /**
     * データベース内連番:9 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)短期入所療養介護(老健・診療所)
     */
    短期入所療養介護("9", "回", "/月", "介護予防", "(介護予防)短期入所療養介護(老健・診療所)"),
    /**
     * データベース内連番:10 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)特定施設入所者生活介護
     */
    特定施設入所者生活介護("10", "回", "/月", "介護予防", "(介護予防)特定施設入所者生活介護"),
    /**
     * データベース内連番:11 単位1:回 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)福祉用具貸与
     */
    福祉用具貸与("11", "品目", "", "介護予防", "(介護予防)福祉用具貸与"),
    /**
     * データベース内連番:12 単位1:回 単位2:/6カ月 給付区分:介護予防 帳票上の文言:特定(介護予防)福祉用具販売
     */
    福祉用具購入("12", "品目", "/6カ月", "介護予防", "特定(介護予防)福祉用具販売"),
    /**
     * データベース内連番:13 単位1:日 単位2:/月 給付区分:介護予防 帳票上の文言:夜間対応型訪問介護
     */
    夜間対応型訪問介護("13", "日", "/月", "介護", "夜間対応型訪問介護"),
    /**
     * データベース内連番:14 単位1:日 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)認知症対応型通所介護
     */
    認知症対応型通所介護("14", "日", "/月", "介護予防", "(介護予防)認知症対応型通所介護"),
    /**
     * データベース内連番:15 単位1:日 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)小規模多機能型居宅介護
     */
    小規模多機能型居宅介護("15", "日", "/月", "介護予防", "(介護予防)小規模多機能型居宅介護"),
    /**
     * データベース内連番:16 単位1:日 単位2:/月 給付区分:介護予防 帳票上の文言:(介護予防)認知症対応型共同生活介護
     */
    認知症対応型共同生活介護("16", "日", "/月", "介護予防", "(介護予防)認知症対応型共同生活介護"),
    /**
     * データベース内連番:17 単位1:日 単位2:/月 給付区分:介護予防 帳票上の文言:地域密着型特定施設入居者生活介護
     */
    地域密着型特定施設入居者生活介護("17", "日", "/月", "介護", "地域密着型特定施設入居者生活介護"),
    /**
     * データベース内連番:18 単位1:日 単位2:/月 給付区分:介護予防 帳票上の文言:地域密着型介護老人福祉施設入所者生活介護
     */
    地域密着型介護老人福祉施設入所者生活介護("18", "日", "/月", "介護", "地域密着型介護老人福祉施設入所者生活介護");

    private final RString code;
    private final RString tani1;
    private final RString tani2;
    private final RString kyuufuKubun;
    private final RString fullName;

    private GaikyoChosahyouServiceJyouk06A(String code, String tani1, String tani2, String kyuufuKubun, String fullname) {
        this.code = new RString(code);
        this.tani1 = new RString(tani1);
        this.tani2 = new RString(tani2);
        this.kyuufuKubun = new RString(kyuufuKubun);
        this.fullName = new RString(fullname);
    }

    /**
     * 概況調査票サービスの状況06Aの連番を返します。
     *
     * @return 概況調査票サービスの状況06Aの連番
     */
    public RString get連番() {
        return code;
    }

    /**
     * 概況調査票サービスの状況06Aの単位1を返します。
     *
     * @return 概況調査票サービスの状況06Aの単位1
     */
    public RString get単位1() {
        return tani1;
    }

    /**
     * 概況調査票サービスの状況06Aの単位2を返します。
     *
     * @return 概況調査票サービスの状況06Aの単位2
     */
    public RString get単位2() {
        return tani2;
    }

    /**
     * 概況調査票サービスの状況06Aの給付区分を返します。
     *
     * @return 概況調査票サービスの状況06Aの給付区分2
     */
    public RString get給付区分() {
        return kyuufuKubun;
    }

    /**
     * 概況調査票サービスの状況06Aの帳票上の文言を返します。
     *
     * @return 概況調査票サービスの状況06Aの帳票上の文言
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 概況調査票サービスの状況06Aの連番と一致する内容を探します。
     *
     * @param code 概況調査票サービスの状況06Aの連番
     * @return {@code code} に対応する概況調査票サービスの状況06A
     */
    public static GaikyoChosahyouServiceJyouk06A toValue(RString code) {

        for (GaikyoChosahyouServiceJyouk06A values : GaikyoChosahyouServiceJyouk06A.values()) {
            if (values.code.equals(code)) {
                return values;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("概況調査票サービスの状況06A"));
    }
}
