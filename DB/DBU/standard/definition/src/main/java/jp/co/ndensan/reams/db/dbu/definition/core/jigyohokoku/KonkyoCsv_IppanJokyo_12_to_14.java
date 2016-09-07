package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 根拠CSV_一般状況_12_to_14を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum KonkyoCsv_IppanJokyo_12_to_14 {

    /**
     * コード:DBZ011200 名称:居宅介護_介護予防_サービス受給者数 略称:定義なし
     */
    居宅介護_介護予防_サービス受給者数("DBZ011200", "居宅介護_介護予防_サービス受給者数"),
    /**
     * コード:DBZ011400 名称:地域密着型_介護予防_サービス受給者数 略称:定義なし
     */
    地域密着型_介護予防_サービス受給者数("DBZ011400", "地域密着型_介護予防_サービス受給者数"),
    /**
     * コード:DBZ011391 名称:施設介護_サービス受給者数_介護老人福祉施設 略称:定義なし
     */
    施設介護_サービス受給者数_介護老人福祉施設("DBZ011391", "施設介護_サービス受給者数_介護老人福祉施設"),
    /**
     * コード:DBZ011392 名称:施設介護_サービス受給者数_介護老人保健施設 略称:定義なし
     */
    施設介護_サービス受給者数_介護老人保健施設("DBZ011392", "施設介護_サービス受給者数_介護老人保健施設"),
    /**
     * コード:DBZ011393 名称:施設介護_サービス受給者数_介護療養型医療施設_総数含む 略称:定義なし
     */
    施設介護_サービス受給者数_介護療養型医療施設_総数含む("DBZ011393", "施設介護_サービス受給者数_介護療養型医療施設_総数含む");

    private final RString code;
    private final RString fullName;

    private KonkyoCsv_IppanJokyo_12_to_14(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 根拠CSV_一般状況_12_to_14のコードを返します。
     *
     * @return 根拠CSV_一般状況_12_to_14のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 根拠CSV_一般状況_12_to_14の名称を返します。
     *
     * @return 根拠CSV_一般状況_12_to_14の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 根拠CSV_一般状況_12_to_14のコードと一致する内容を探します。
     *
     * @param code 根拠CSV_一般状況_12_to_14のコード
     * @return {@code code} に対応する根拠CSV_一般状況_12_to_14
     */
    public static KonkyoCsv_IppanJokyo_12_to_14 toValue(RString code) {
        for (KonkyoCsv_IppanJokyo_12_to_14 konkyoCsv_IppanJokyo_12_to_14 : KonkyoCsv_IppanJokyo_12_to_14.values()) {
            if (konkyoCsv_IppanJokyo_12_to_14.code.equals(code)) {
                return konkyoCsv_IppanJokyo_12_to_14;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("根拠CSV_一般状況_12_to_14"));
    }
}
