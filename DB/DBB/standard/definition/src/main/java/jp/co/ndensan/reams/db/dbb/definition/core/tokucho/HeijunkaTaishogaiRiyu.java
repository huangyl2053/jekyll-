package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平準化対象外理由を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum HeijunkaTaishogaiRiyu {

    /**
     * コード:1 名称:併徴者 略称:定義なし
     */
    併徴者("1", "併徴者"),
    /**
     * コード:2 名称:仮徴収額修正者 略称:定義なし
     */
    仮徴収額修正者("2", "仮徴収額修正者"),
    /**
     * コード:3 名称:平準化の結果0円以下 略称:定義なし
     */
    平準化の結果0円以下("3", "平準化の結果0円以下"),
    /**
     * コード:4 名称:対象外・減額 略称:定義なし
     */
    対象外_減額("4", "対象外・減額"),
    /**
     * コード:5 名称:対象外・増額 略称:定義なし
     */
    対象外_増額("5", "対象外・増額"),
    /**
     * コード:6 名称:特徴6月開始者 略称:定義なし
     */
    特徴6月開始者("6", "特徴6月開始者"),
    /**
     * コード:7 名称:変更なし 略称:定義なし
     */
    変更なし("7", "変更なし");

    private final RString code;
    private final RString fullName;

    private HeijunkaTaishogaiRiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 平準化対象外理由のコードを返します。
     *
     * @return 平準化対象外理由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 平準化対象外理由の名称を返します。
     *
     * @return 平準化対象外理由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 平準化対象外理由のコードと一致する内容を探します。
     *
     * @param code 平準化対象外理由のコード
     * @return {@code code} に対応する平準化対象外理由
     */
    public static HeijunkaTaishogaiRiyu toValue(RString code) {
        for (HeijunkaTaishogaiRiyu heijunkaTaishogaiRiyu : HeijunkaTaishogaiRiyu.values()) {
            if (heijunkaTaishogaiRiyu.code.equals(code)) {
                return heijunkaTaishogaiRiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("平準化対象外理由"));
    }
}
