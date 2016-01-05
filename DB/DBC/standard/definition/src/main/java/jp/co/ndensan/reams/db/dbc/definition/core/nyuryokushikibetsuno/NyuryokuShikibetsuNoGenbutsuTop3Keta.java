package jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入力識別番号現物上３桁を表す列挙型です。
 *
 * @author LDNS
 */
public enum NyuryokuShikibetsuNoGenbutsuTop3Keta {

    /**
     * コード:713 名称:居宅介護サービス 略称:定義なし
     */
    居宅介護サービス("713", "居宅介護サービス"),
    /**
     * コード:714 名称:短期入所生活介護 略称:定義なし
     */
    短期入所生活介護("714", "短期入所生活介護"),
    /**
     * コード:715 名称:短期入所老健施設 略称:定義なし
     */
    短期入所老健施設("715", "短期入所老健施設"),
    /**
     * コード:716 名称:短期入所医療施設 略称:定義なし
     */
    短期入所医療施設("716", "短期入所医療施設"),
    /**
     * コード:717 名称:認知症型共同生活 略称:定義なし
     */
    認知症型共同生活("717", "認知症型共同生活"),
    /**
     * コード:718 名称:福祉施設・地域福祉施設 略称:定義なし
     */
    福祉施設_地域福祉施設("718", "福祉施設・地域福祉施設"),
    /**
     * コード:719 名称:介護老人保健施設 略称:定義なし
     */
    介護老人保健施設("719", "介護老人保健施設"),
    /**
     * コード:71A 名称:介護療養型医療施設 略称:定義なし
     */
    介護療養型医療施設("71A", "介護療養型医療施設"),
    /**
     * コード:812 名称:居宅サービス計画費 略称:定義なし
     */
    居宅サービス計画費("812", "居宅サービス計画費"),
    /**
     * コード:71P 名称:介護予防・日常生活支援総合事業（予防サービス・生活支援サービス） 略称:定義なし
     */
    介護予防_日常生活支援総合事業_予防サービス_生活支援サービス("71P", "介護予防・日常生活支援総合事業（予防サービス・生活支援サービス）"),
    /**
     * コード:816 名称:介護予防・日常生活支援総合事業（ケアマネジメント） 略称:定義なし
     */
    介護予防_日常生活支援総合事業_ケアマネジメント("816", "介護予防・日常生活支援総合事業（ケアマネジメント）");

    private final RString code;
    private final RString fullName;

    private NyuryokuShikibetsuNoGenbutsuTop3Keta(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 入力識別番号現物上３桁のコードを返します。
     *
     * @return 入力識別番号現物上３桁のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 入力識別番号現物上３桁の名称を返します。
     *
     * @return 入力識別番号現物上３桁の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 入力識別番号現物上３桁のコードと一致する内容を探します。
     *
     * @param code 入力識別番号現物上３桁のコード
     * @return {@code code} に対応する入力識別番号現物上３桁
     */
    public static NyuryokuShikibetsuNoGenbutsuTop3Keta toValue(RString code) {

        for (NyuryokuShikibetsuNoGenbutsuTop3Keta value : NyuryokuShikibetsuNoGenbutsuTop3Keta.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("入力識別番号現物上３桁"));
    }
}
