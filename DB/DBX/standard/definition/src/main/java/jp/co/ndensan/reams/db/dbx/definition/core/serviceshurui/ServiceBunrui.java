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
 * @reamsid_L DBX-9999-023 wangchao
 */
public enum ServiceBunrui {

    /**
     * コード:1 名称:居宅 略称:無
     */
    居宅サービス("1", "居宅"),
    /**
     * コード:2 名称:居宅支援 略称:無
     */
    居宅介護支援("2", "居宅支援"),
    /**
     * コード:3 名称:施設 略称:無
     */
    施設サービス("3", "施設"),
    /**
     * コード:4 名称:総合事業(経過措置） 略称:無
     */
    特定入所者介護サービス("4", "特定入所者"),
    /**
     * コード:5 名称:総合事業(経過措置） 略称:無
     */
    介護予防サービス("5", "予防"),
    /**
     * コード:6 名称:総合事業(経過措置） 略称:無
     */
    介護予防支援("6", "介護予防支援"),
    /**
     * コード:7 名称:総合事業(経過措置） 略称:無
     */
    地域密着型サービス("7", "地域密着"),
    /**
     * コード:8 名称:地域密着型予防サービス 略称:無
     */
    地域密着型予防サービス("8", "地域密着型予防"),
    /**
     * コード:9 名称:その他 略称:無
     */
    その他("9", "その他"),
    /**
     * コード:10 名称:総合事業(経過措置） 略称:無
     */
    総合事業_経過措置("10", "総合事業(経過措置）"),
    /**
     * コード:AF 名称:ケアマネジメント(経過措置） 略称:無
     */
    ケアマネジメント_経過措置("11", "ケアマネジメント(経過措置）"),
    /**
     * コード:12 名称:総合事業 略称:無
     */
    総合事業("12", "総合事業"),
    /**
     * コード:13 名称:ケアマネ 略称:無
     */
    ケアマネジメント("13", "ケアマネ");

    private final RString code;
    private final RString fullName;

    private ServiceBunrui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
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
