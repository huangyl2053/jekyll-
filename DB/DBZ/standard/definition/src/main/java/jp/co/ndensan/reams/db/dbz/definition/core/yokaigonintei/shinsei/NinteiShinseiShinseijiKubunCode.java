/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請区分（申請時）コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum NinteiShinseiShinseijiKubunCode {

    /**
     * コード:1 名称:新規申請 略称:定義なし
     */
    新規申請("1", "新規申請"),
    /**
     * コード:2 名称:更新申請 略称:定義なし
     */
    更新申請("2", "更新申請"),
    /**
     * コード:3 名称:区分変更申請 略称:定義なし
     */
    区分変更申請("3", "区分変更申請"),
    /**
     * コード:4 名称:職権 略称:定義なし
     */
    職権("4", "職権"),
    /**
     * コード:5 名称:転入申請 略称:定義なし
     */
    転入申請("5", "転入申請"),
    /**
     * コード:6 名称:資格喪失（死亡） 略称:定義なし
     */
    資格喪失_死亡("6", "資格喪失（死亡）"),
    /**
     * コード:A 名称:新規申請（事前） 略称:定義なし
     */
    新規申請_事前("A", "新規申請（事前）"),
    /**
     * コード:B 名称:更新申請（事前） 略称:定義なし
     */
    更新申請_事前("B", "更新申請（事前）");

    private final RString code;
    private final RString fullName;

    private NinteiShinseiShinseijiKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護状態区分コード02のコードを返します。
     *
     * @return 要介護状態区分コード02のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護状態区分コード02の名称を返します。
     *
     * @return 要介護状態区分コード02の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護状態区分コード02のコードと一致する内容を探します。
     *
     * @param code 要介護状態区分コード02のコード
     * @return {@code code} に対応する要介護状態区分コード02
     */
    public static NinteiShinseiShinseijiKubunCode toValue(RString code) {

        for (NinteiShinseiShinseijiKubunCode kubunCode : NinteiShinseiShinseijiKubunCode.values()) {
            if (kubunCode.code.equals(code)) {
                return kubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請区分（申請時）コード"));
    }
}
