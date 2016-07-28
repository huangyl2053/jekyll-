/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス分類を表す列挙型です。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public enum ServiceBunrui {

    /**
     * コード:10 名称:総合事業(経過措置） 略称:総合事業(経過措置）
     */
    総合事業("10", "総合事業(経過措置）", "総合事業(経過措置）"),
    /**
     * コード:AF 名称:ケアマネジメント(経過措置） 略称:ケアマネジメント(経過措置）
     */
    ケアマネジメント("11", "ケアマネジメント(経過措置）", "ケアマネジメント(経過措置）");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ServiceBunrui(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * サービス分類のコードを返します。
     *
     * @return サービス分類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サービス分類の名称を返します。
     *
     * @return サービス分類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービス分類の略称を返します。
     *
     * @return サービス分類の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * サービス分類のコードと一致する内容を探します。
     *
     * @param code サービス分類のコード
     * @return {@code code} に対応するサービス分類
     */
    public static ServiceBunrui toValue(RString code) {

        for (ServiceBunrui serviceBunrui : ServiceBunrui.values()) {
            if (serviceBunrui.code.equals(code)) {
                return serviceBunrui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービス分類"));
    }
}
