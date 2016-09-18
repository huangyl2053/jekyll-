/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.servicecode;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード一覧_抽出条件区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 jiangxiaolong
 */
public enum ServiceCodeIchiran_ChushutsuJokenKubun {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:サービスコードを指定 略称:定義なし
     */
    サービスコードを指定("1", "サービスコードを指定"),
    /**
     * コード:2 名称:サービス分類を指定 略称:定義なし
     */
    サービス分類を指定("2", "サービス分類を指定");
    private final RString code;
    private final RString fullName;

    private ServiceCodeIchiran_ChushutsuJokenKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サービスコード一覧_抽出条件区分のコードを返します。
     *
     * @return サービスコード一覧_抽出条件区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サービスコード一覧_抽出条件区分の名称を返します。
     *
     * @return サービスコード一覧_抽出条件区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービスコード一覧_抽出条件区分のコードと一致する内容を探します。
     *
     * @param code サービスコード一覧_抽出条件区分のコード
     * @return {@code code} に対応するサービスコード一覧_抽出条件区分
     */
    public static ServiceCodeIchiran_ChushutsuJokenKubun toValue(RString code) {

        for (ServiceCodeIchiran_ChushutsuJokenKubun kubun : ServiceCodeIchiran_ChushutsuJokenKubun.values()) {
            if (kubun.code.equals(code)) {
                return kubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービスコード一覧_抽出条件区分"));
    }
}
