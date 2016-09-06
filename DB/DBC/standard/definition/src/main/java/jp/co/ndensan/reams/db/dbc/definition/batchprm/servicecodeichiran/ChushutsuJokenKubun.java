/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.servicecodeichiran;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出条件区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 chenyadong
 */
public enum ChushutsuJokenKubun {

    /**
     * コード:0 名称:すべて 略称:無
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:サービスコードを指定 略称:無
     */
    サービスコードを指定("1", "サービスコードを指定"),
    /**
     * コード:2 名称:サービス分類を指定 略称:無
     */
    サービス分類を指定("2", "サービス分類を指定");

    private final RString code;
    private final RString fullName;

    private ChushutsuJokenKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出条件区分のコードを返します。
     *
     * @return 抽出条件区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出条件区分の名称を返します。
     *
     * @return 抽出条件区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出条件区分のコードと一致する内容を探します。
     *
     * @param code 抽出条件区分のコード
     * @return {@code code} に対応する抽出条件区分
     */
    public static ChushutsuJokenKubun toValue(RString code) {
        for (ChushutsuJokenKubun chushutsuJokenKubun : ChushutsuJokenKubun.values()) {
            if (chushutsuJokenKubun.code.equals(code)) {
                return chushutsuJokenKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("抽出条件区分"));
    }
}
