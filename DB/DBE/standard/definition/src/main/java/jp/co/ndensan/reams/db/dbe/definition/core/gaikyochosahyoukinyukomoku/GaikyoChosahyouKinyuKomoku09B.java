/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyoukinyukomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況調査票記入項目09Bを表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum GaikyoChosahyouKinyuKomoku09B {

    /**
     * データベース内連番:1 帳票上の文言:市町村特別給付
     */
    市町村特別給付("1", "市町村特別給付"),
    /**
     * データベース内連番:2 帳票上の文言:介護保険給付外の在宅サービス
     */
    介護保険給付外の在宅サービス("2", "介護保険給付外の在宅サービス");

    private final RString code;
    private final RString fullName;

    private GaikyoChosahyouKinyuKomoku09B(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 概況調査票記入項目09Bの連番を返します。
     *
     * @return 概況調査票記入項目09Bの連番
     */
    public RString get連番() {
        return code;
    }

    /**
     * 概況調査票記入項目09Bの帳票上の文言を返します。
     *
     * @return 概況調査票記入項目09Bの帳票上の文言
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 概況調査票記入項目09Bの連番と一致する内容を探します。
     *
     * @param code 概況調査票記入項目09Bの連番
     * @return {@code code} に対応する概況調査票記入項目09B
     */
    public static GaikyoChosahyouKinyuKomoku09B toValue(RString code) {
        for (GaikyoChosahyouKinyuKomoku09B values : GaikyoChosahyouKinyuKomoku09B.values()) {
            if (values.code.equals(code)) {
                return values;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("概況調査票記入項目09B"));
    }
}
