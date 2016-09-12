/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況調査票認定調査票施設利用09Bを表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum GaikyoChosahyouNiteichosahyouSisetuRiy09B {

    /**
     * データベース内連番:1 帳票上の文言:居宅
     */
    居宅("1", "居宅"),
    /**
     * データベース内連番:2 帳票上の文言:介護老人福祉施設
     */
    介護老人福祉施設("2", "介護老人福祉施設"),
    /**
     * データベース内連番:3 帳票上の文言:介護老人保健施設
     */
    介護老人保健施設("3", "介護老人保健施設"),
    /**
     * データベース内連番:4 帳票上の文言:介護療養型医療施設
     */
    介護療養型医療施設("4", "介護療養型医療施設"),
    /**
     * データベース内連番:5 帳票上の文言:認知症対応型共同生活介護適用施設(ｸﾞﾙｰﾌﾟﾎｰﾑ)
     */
    認知症対応型共同生活介護適用施設("5", "認知症対応型共同生活介護適用施設(ｸﾞﾙｰﾌﾟﾎｰﾑ)"),
    /**
     * データベース内連番:6 帳票上の文言:特定施設入所者生活介護適用施設(ｹｱﾊｳｽ等)
     */
    特定施設入所者生活介護適用施設("6", "特定施設入所者生活介護適用施設(ｹｱﾊｳｽ等)"),
    /**
     * データベース内連番:7 帳票上の文言:医療機関(医療保険適用療養病床)
     */
    医療機関_療養("7", "医療機関(医療保険適用療養病床)"),
    /**
     * データベース内連番:8 帳票上の文言:医療機関(療養病床以外)
     */
    医療機関_療養以外("8", "医療機関(療養病床以外)"),
    /**
     * データベース内連番:9 帳票上の文言:その他の施設
     */
    その他の施設("9", "その他の施設");

    private final RString code;
    private final RString fullName;

    private GaikyoChosahyouNiteichosahyouSisetuRiy09B(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 概況調査票認定調査票施設利用09Bの連番を返します。
     *
     * @return 概況調査票認定調査票施設利用09Bの連番
     */
    public RString get連番() {
        return code;
    }

    /**
     * 概況調査票認定調査票施設利用09Bの帳票上の文言を返します。
     *
     * @return 概況調査票認定調査票施設利用09Bの帳票上の文言
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 概況調査票認定調査票施設利用09Bの連番と一致する内容を探します。
     *
     * @param code 概況調査票認定調査票施設利用09Bの連番
     * @return {@code code} に対応する概況調査票認定調査票施設利用09B
     */
    public static GaikyoChosahyouNiteichosahyouSisetuRiy09B toValue(RString code) {

        for (GaikyoChosahyouNiteichosahyouSisetuRiy09B value : GaikyoChosahyouNiteichosahyouSisetuRiy09B.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("概況調査票認定調査票施設利用09B"));
    }
}
