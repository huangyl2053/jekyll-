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
     * コード:1 名称:居宅サービス 略称:居宅
     */
    居宅サービス("1", "居宅サービス", "居宅"),
    /**
     * コード:2 名称:居宅介護支援 略称:居宅支援
     */
    居宅介護支援("2", "居宅介護支援", "居宅支援"),
    /**
     * コード:3 名称:施設サービス 略称:施設
     */
    施設サービス("3", "施設サービス", "施設"),
    /**
     * コード:4 名称:特定入所者介護サービス 略称:特定入所者
     */
    特定入所者介護サービス("4", "特定入所者介護サービス", "特定入所者"),
    /**
     * コード:5 名称:介護予防サービス 略称:予防
     */
    介護予防サービス("5", "介護予防サービス", "予防"),
    /**
     * コード:6 名称:介護予防支援 略称:介護予防支援
     */
    介護予防支援("6", "介護予防支援", "介護予防支援"),
    /**
     * コード:7 名称:地域密着型サービス 略称:地域密着
     */
    地域密着型サービス("7", "地域密着型サービス", "地域密着"),
    /**
     * コード:8 名称:地域密着型予防サービス 略称:地域密着型予防
     */
    地域密着型予防サービス("8", "地域密着型予防サービス", "地域密着型予防"),
    /**
     * コード:9 名称:その他 略称:その他
     */
    その他("9", "その他", "その他"),
    /**
     * コード:10 名称:総合事業(経過措置） 略称:総合事業(経過措置）
     */
    総合事業_経過措置("10", "総合事業(経過措置）", "総合事業(経過措置）"),
    /**
     * コード:AF 名称:ケアマネジメント(経過措置） 略称:ケアマネ(経過措置）
     */
    ケアマネジメント_経過措置("11", "ケアマネジメント(経過措置）", "ケアマネ(経過措置）"),
    /**
     * コード:12 名称:総合事業 略称:総合事業
     */
    総合事業("12", "総合事業", "総合事業"),
    /**
     * コード:13 名称:ケアマネジメント 略称:ケアマネ
     */
    ケアマネジメント("13", "ケアマネジメント", "ケアマネ");

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
