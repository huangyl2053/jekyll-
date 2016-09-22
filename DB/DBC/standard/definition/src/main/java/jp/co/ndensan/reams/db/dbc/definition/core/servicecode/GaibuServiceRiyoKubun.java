/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.servicecode;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 外部サービス利用型フラグを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 chenhui
 */
public enum GaibuServiceRiyoKubun {

    /**
     * コード:0 名称:その他 略称:""
     */
    その他("0", "その他", ""),
    /**
     * コード:1 名称:限度額対象外 略称:一般
     */
    一般型("1", "一般型", "一般"),
    /**
     * コード:2 名称:限度額対象外 略称:外部サービス利用型
     */
    外部サービス利用型("2", "外部サービス利用型", "外部サービス利用型");
    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private GaibuServiceRiyoKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 外部サービス利用型フラグのコードを返します。
     *
     * @return 外部サービス利用型フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 外部サービス利用型フラグの名称を返します。
     *
     * @return 外部サービス利用型フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 外部サービス利用型フラグの略称を返します。
     *
     * @return 外部サービス利用型フラグの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 外部サービス利用型フラグのコードと一致する内容を探します。
     *
     * @param code 外部サービス利用型フラグのコード
     * @return {@code code} に対応する外部サービス利用型フラグ
     */
    public static GaibuServiceRiyoKubun toValue(RString code) {

        for (GaibuServiceRiyoKubun flag : GaibuServiceRiyoKubun.values()) {
            if (flag.code.equals(code)) {
                return flag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("外部サービス利用型フラグ"));
    }
}
