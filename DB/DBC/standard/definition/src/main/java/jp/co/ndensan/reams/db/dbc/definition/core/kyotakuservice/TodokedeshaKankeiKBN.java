/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 届出者関係区分を表す列挙型です。
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public enum TodokedeshaKankeiKBN {

    /**
     * コード:1 名称:本人 表示名称:本人
     */
    本人("1", "本人"),
    /**
     * コード:2 名称:家族 表示名称:家族
     */
    家族("2", "家族"),
    /**
     * コード:3 名称:代理人 表示名称:代理人
     */
    代理人("3", "代理人"),
    /**
     * コード:4 名称:サービス事業者 表示名称:サービス事業者
     */
    サービス事業者("4", "サービス事業者"),
    /**
     * コード:5 名称:ケアマネージャ 表示名称:ケアマネージャ
     */
    ケアマネージャ("5", "ケアマネージャ");

    private final RString code;
    private final RString fullName;

    private TodokedeshaKankeiKBN(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 届出者関係区分のコードを返します。
     *
     * @return 届出者関係区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 届出者関係区分の名称を返します。
     *
     * @return 届出者関係区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 届出者関係区分のコードと一致する内容を探します。
     *
     * @param code 届出者関係区分のコード
     * @return {@code code} に対応する届出者関係区分
     */
    public static TodokedeshaKankeiKBN toValue(RString code) {

        for (TodokedeshaKankeiKBN todokedeshaKankeiKBN : TodokedeshaKankeiKBN.values()) {
            if (todokedeshaKankeiKBN.code.equals(code)) {
                return todokedeshaKankeiKBN;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("届出者関係区分のコード"));
    }
}
