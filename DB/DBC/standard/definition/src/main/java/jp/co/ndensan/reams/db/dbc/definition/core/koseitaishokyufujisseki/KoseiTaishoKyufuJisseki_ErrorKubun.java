/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.koseitaishokyufujisseki;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更正対象給付実績_エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 dengwei
 */
public enum KoseiTaishoKyufuJisseki_ErrorKubun {

    /**
     * コード:01 名称:負担割合_削除 略称:定義なし
     */
    負担割合_削除("01", "負担割合_削除"),
    /**
     * コード:02 名称:負担割合_取得 略称:定義なし
     */
    負担割合_取得("02", "負担割合_取得");

    private final RString code;
    private final RString fullName;

    private KoseiTaishoKyufuJisseki_ErrorKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 更正対象給付実績_エラー区分のコードを返します。
     *
     * @return 更正対象給付実績_エラー区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 更正対象給付実績_エラー区分の名称を返します。
     *
     * @return 更正対象給付実績_エラー区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 更正対象給付実績_エラー区分のコードと一致する内容を探します。
     *
     * @param code 更正対象給付実績_エラー区分のコード
     * @return {@code code} に対応する 更正対象給付実績_エラー区分
     */
    public static KoseiTaishoKyufuJisseki_ErrorKubun toValue(RString code) {

        for (KoseiTaishoKyufuJisseki_ErrorKubun errorKubun : KoseiTaishoKyufuJisseki_ErrorKubun.values()) {
            if (errorKubun.code.equals(code)) {
                return errorKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(" 更正対象給付実績_エラー区分"));
    }
}
