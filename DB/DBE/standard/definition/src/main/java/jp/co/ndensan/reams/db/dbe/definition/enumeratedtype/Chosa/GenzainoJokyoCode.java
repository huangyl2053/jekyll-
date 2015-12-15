package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 現在の状況コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum GenzainoJokyoCode {

    /**
     * コード:1 名称:居宅（施設利用なし） 略称:定義なし
     */
    居宅_施設利用なし("1", "居宅（施設利用なし）"),
    /**
     * コード:2 名称:指定介護老人福祉施設 略称:定義なし
     */
    指定介護老人福祉施設("2", "指定介護老人福祉施設"),
    /**
     * コード:3 名称:介護老人保健施設 略称:定義なし
     */
    介護老人保健施設("3", "介護老人保健施設"),
    /**
     * コード:4 名称:指定介護療養型医療施設 略称:定義なし
     */
    指定介護療養型医療施設("4", "指定介護療養型医療施設"),
    /**
     * コード:5 名称:認知症対応型共同生活介護適用施設（グループホーム） 略称:定義なし
     */
    認知症対応型共同生活介護適用施設_グループホーム("5", "認知症対応型共同生活介護適用施設（グループホーム）"),
    /**
     * コード:6 名称:特定施設入居者生活介護適用施設（ケアハウス等） 略称:定義なし
     */
    特定施設入居者生活介護適用施設_ケアハウス等("6", "特定施設入居者生活介護適用施設（ケアハウス等）"),
    /**
     * コード:7 名称:医療機関（医療保険適用療養病床） 略称:定義なし
     */
    医療機関_医療保険適用療養病床("7", "医療機関（医療保険適用療養病床）"),
    /**
     * コード:8 名称:医療機関（療養病棟以外） 略称:定義なし
     */
    医療機関_療養病棟以外("8", "医療機関（療養病棟以外）"),
    /**
     * コード:9 名称:その他の施設 略称:定義なし
     */
    その他の施設("9", "その他の施設");

    private final RString code;
    private final RString fullName;

    private GenzainoJokyoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 現在の状況コードのコードを返します。
     *
     * @return 現在の状況コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 現在の状況コードの名称を返します。
     *
     * @return 現在の状況コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 現在の状況コードのコードと一致する内容を探します。
     *
     * @param code 現在の状況コードのコード
     * @return {@code code} に対応する現在の状況コード
     */
    public static GenzainoJokyoCode toValue(RString code) {

        for (GenzainoJokyoCode genzainoJokyoCode : GenzainoJokyoCode.values()) {
            if (genzainoJokyoCode.code.equals(code)) {
                return genzainoJokyoCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("現在の状況コード"));
    }
}
