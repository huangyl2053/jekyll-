package jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入力識別番号償還上３桁を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum NyuryokuShikibetsuNoShokan3Keta {

    /**
     * コード:213 名称:居宅介護サービス 略称:定義なし
     */
    居宅介護サービス("213", "居宅介護サービス"),
    /**
     * コード:214 名称:短期入所生活介護 略称:定義なし
     */
    短期入所生活介護("214", "短期入所生活介護"),
    /**
     * コード:215 名称:短期入所老健施設 略称:定義なし
     */
    短期入所老健施設("215", "短期入所老健施設"),
    /**
     * コード:216 名称:短期入所医療施設 略称:定義なし
     */
    短期入所医療施設("216", "短期入所医療施設"),
    /**
     * コード:217 名称:認知症型共同生活 略称:定義なし
     */
    認知症型共同生活("217", "認知症型共同生活"),
    /**
     * コード:218 名称:福祉施設・地域福祉施設 略称:定義なし
     */
    福祉施設_地域福祉施設("218", "福祉施設・地域福祉施設"),
    /**
     * コード:219 名称:介護老人保健施設 略称:定義なし
     */
    介護老人保健施設("219", "介護老人保健施設"),
    /**
     * コード:21A 名称:介護療養型医療施設 略称:定義なし
     */
    介護療養型医療施設("21A", "介護療養型医療施設"),
    /**
     * コード:21B 名称:居宅サービス計画費 略称:定義なし
     */
    居宅サービス計画費("21B", "居宅サービス計画費"),
    /**
     * コード:21C 名称:福祉用具販売費 略称:定義なし
     */
    福祉用具販売費("21C", "福祉用具販売費"),
    /**
     * コード:21D 名称:住宅改修費 略称:定義なし
     */
    住宅改修費("21D", "住宅改修費"),
    /**
     * コード:341 名称:高額介護サービス 略称:定義なし
     */
    高額介護サービス("341", "高額介護サービス");

    private final RString code;
    private final RString fullName;

    private NyuryokuShikibetsuNoShokan3Keta(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 入力識別番号償還上３桁のコードを返します。
     *
     * @return 入力識別番号償還上３桁のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 入力識別番号償還上３桁の名称を返します。
     *
     * @return 入力識別番号償還上３桁の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 入力識別番号償還上３桁のコードと一致する内容を探します。
     *
     * @param code 入力識別番号償還上３桁のコード
     * @return {@code code} に対応する入力識別番号償還上３桁
     */
    public static NyuryokuShikibetsuNoShokan3Keta toValue(RString code) {

        for (NyuryokuShikibetsuNoShokan3Keta value : NyuryokuShikibetsuNoShokan3Keta.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("入力識別番号償還上３桁"));
    }
}
