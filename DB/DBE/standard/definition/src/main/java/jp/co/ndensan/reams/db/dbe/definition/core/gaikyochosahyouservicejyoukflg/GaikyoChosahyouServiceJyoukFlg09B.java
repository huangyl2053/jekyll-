/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況調査票サービスの状況フラグ09Bを表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum GaikyoChosahyouServiceJyoukFlg09B {

    /**
     * データベース内連番:1 帳票上の文言:住宅改修
     */
    住宅改修("1", "住宅改修");

    private final RString code;
    private final RString fullName;

    private GaikyoChosahyouServiceJyoukFlg09B(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 概況調査票サービスの状況フラグ09Bの連番を返します。
     *
     * @return 概況調査票サービスの状況フラグ09Bの連番
     */
    public RString get連番() {
        return code;
    }

    /**
     * 概況調査票サービスの状況フラグ09Bの帳票上の文言を返します。
     *
     * @return 概況調査票サービスの状況フラグ09Bの帳票上の文言
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 概況調査票サービスの状況フラグ09Bの連番と一致する内容を探します。
     *
     * @param code 概況調査票サービスの状況フラグ09Bの連番
     * @return {@code code} に対応する概況調査票サービスの状況フラグ09B
     */
    public static GaikyoChosahyouServiceJyoukFlg09B toValue(RString code) {
        for (GaikyoChosahyouServiceJyoukFlg09B values : GaikyoChosahyouServiceJyoukFlg09B.values()) {
            if (values.code.equals(code)) {
                return values;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("概況調査票サービスの状況フラグ09B"));
    }
}
