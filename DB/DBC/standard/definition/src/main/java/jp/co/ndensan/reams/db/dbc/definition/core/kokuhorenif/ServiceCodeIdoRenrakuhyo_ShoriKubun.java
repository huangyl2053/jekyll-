/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード異動連絡票_処理選択区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 liuxiaoyu
 */
public enum ServiceCodeIdoRenrakuhyo_ShoriKubun {

    /**
     * コード:1 名称:テスト処理 略称:定義なし
     */
    テスト処理("1", "テスト処理"),
    /**
     * コード:2 名称:本番処理 略称:定義なし
     */
    本番処理("2", "本番処理");

    private final RString code;
    private final RString fullName;

    private ServiceCodeIdoRenrakuhyo_ShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サービスコード異動連絡票_処理選択区分のコードを返します。
     *
     * @return サービスコード異動連絡票_処理選択区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サービスコード異動連絡票_処理選択区分の名称を返します。
     *
     * @return サービスコード異動連絡票_処理選択区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービスコード異動連絡票_処理選択区分のコードと一致する内容を探します。
     *
     * @param code サービスコード異動連絡票_処理選択区分のコード
     * @return {@code code} に対応するサービスコード異動連絡票_処理選択区分
     */
    public static ServiceCodeIdoRenrakuhyo_ShoriKubun toValue(RString code) {

        for (ServiceCodeIdoRenrakuhyo_ShoriKubun dataSaisoFlag : ServiceCodeIdoRenrakuhyo_ShoriKubun.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービスコード異動連絡票_処理選択区分"));
    }

}
