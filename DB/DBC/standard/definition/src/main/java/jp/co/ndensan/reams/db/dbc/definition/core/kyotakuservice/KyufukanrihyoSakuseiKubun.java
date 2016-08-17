/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票情報作成区分コードを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 cuilin
 */
public enum KyufukanrihyoSakuseiKubun {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:変更 略称:定義なし
     */
    変更("2", "変更"),
    /**
     * コード:3 名称:取消 略称:定義なし
     */
    取消("3", "取消");

    private final RString code;
    private final RString fullName;

    private KyufukanrihyoSakuseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付管理票情報作成区分のコードを返します。
     *
     * @return 給付管理票情報作成区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付管理票情報作成区分の名称を返します。
     *
     * @return 給付管理票情報作成区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付管理票情報作成区分のコードと一致する内容を探します。
     *
     * @param code 給付管理票情報作成区分コード
     * @return {@code code} に対応する給付管理票情報作成区分コード
     */
    public static KyufukanrihyoSakuseiKubun toValue(RString code) {

        for (KyufukanrihyoSakuseiKubun kyufukanrihyoSakuseiKubun : KyufukanrihyoSakuseiKubun.values()) {
            if (kyufukanrihyoSakuseiKubun.code.equals(code)) {
                return kyufukanrihyoSakuseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付管理票情報作成区分コード"));
    }
}
