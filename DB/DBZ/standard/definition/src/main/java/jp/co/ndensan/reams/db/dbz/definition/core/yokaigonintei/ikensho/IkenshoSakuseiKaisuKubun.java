/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成回数区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum IkenshoSakuseiKaisuKubun {

    /**
     * コード:1 名称:初回 略称:定義なし
     */
    初回("1", "初回"),
    /**
     * コード:2 名称:2回目以降 略称:定義なし
     */
    _2回目以降("2", "2回目以降");

    private final RString code;
    private final RString fullName;

    private IkenshoSakuseiKaisuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書作成回数区分のコードを返します。
     *
     * @return 意見書作成回数区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書作成回数区分の名称を返します。
     *
     * @return 意見書作成回数区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書作成回数区分のコードと一致する内容を探します。
     *
     * @param code 意見書作成回数区分のコード
     * @return {@code code} に対応する意見書作成回数区分
     */
    public static IkenshoSakuseiKaisuKubun toValue(RString code) {

        for (IkenshoSakuseiKaisuKubun ikenshoSakuseiKaisuKubun : IkenshoSakuseiKaisuKubun.values()) {
            if (ikenshoSakuseiKaisuKubun.code.equals(code)) {
                return ikenshoSakuseiKaisuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書作成回数区分"));
    }

    public static IkenshoSakuseiKaisuKubun toCode(RString name) {
        for (IkenshoSakuseiKaisuKubun kubunCode : IkenshoSakuseiKaisuKubun.values()) {
            if (kubunCode.get名称().equals(name)) {
                return kubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書作成回数区分"));
    }
}
