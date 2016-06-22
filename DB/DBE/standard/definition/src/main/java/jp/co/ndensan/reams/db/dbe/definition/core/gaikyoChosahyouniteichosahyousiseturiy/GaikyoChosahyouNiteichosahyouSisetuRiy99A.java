/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gaikyoChosahyouniteichosahyousiseturiy;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況調査票認定調査票施設利用99Aを表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum GaikyoChosahyouNiteichosahyouSisetuRiy99A {

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
     * データベース内連番:9 帳票上の文言:その他の施設
     */
    その他の施設("9", "その他の施設");

    private final RString code;
    private final RString fullName;

    private GaikyoChosahyouNiteichosahyouSisetuRiy99A(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 概況調査票認定調査票施設利用99Aの連番を返します。
     *
     * @return 概況調査票認定調査票施設利用99Aの連番
     */
    public RString get連番() {
        return code;
    }

    /**
     * 概況調査票認定調査票施設利用99Aの帳票上の文言を返します。
     *
     * @return 概況調査票認定調査票施設利用99Aの帳票上の文言
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 概況調査票認定調査票施設利用99Aの連番と一致する内容を探します。
     *
     * @param code 概況調査票認定調査票施設利用99Aの連番
     * @return {@code code} に対応する概況調査票認定調査票施設利用99A
     */
    public static GaikyoChosahyouNiteichosahyouSisetuRiy99A toValue(RString code) {

        for (GaikyoChosahyouNiteichosahyouSisetuRiy99A values : GaikyoChosahyouNiteichosahyouSisetuRiy99A.values()) {
            if (values.code.equals(code)) {
                return values;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("概況調査票認定調査票施設利用99A"));
    }
}
