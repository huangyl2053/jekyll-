/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum TorokuKubun {

    /**
     * コード:1 名称:取込 略称:定義なし
     */
    取込("1", "取込"),
    /**
     * コード:2 名称:画面登録 略称:定義なし
     */
    画面登録("2", "画面登録");

    private final RString code;
    private final RString fullName;

    private TorokuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 登録区分のコードを返します。
     *
     * @return 登録区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 登録区分の名称を返します。
     *
     * @return 登録区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 登録区分のコードと一致する内容を探します。
     *
     * @param code 登録区分のコード
     * @return {@code code} に対応する登録区分
     */
    public static TorokuKubun toValue(RString code) {
        for (TorokuKubun torokuKubun : TorokuKubun.values()) {
            if (torokuKubun.code.equals(code)) {
                return torokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("登録区分"));
    }
}
