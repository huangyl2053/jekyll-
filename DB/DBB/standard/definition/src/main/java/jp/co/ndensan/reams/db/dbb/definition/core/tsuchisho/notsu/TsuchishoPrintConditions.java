package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書プリント条件を表す列挙型です。
 *
 * @author LDNS
 */
public enum TsuchishoPrintConditions {

    /**
     * コード:0 名称:なし 略称:なし
     */
    なし("0", "なし", "なし"),
    /**
     * コード:1 名称:全被保険者 略称:全被保険者（異動時は異動分全件）
     */
    全被保険者_異動時は異動分全件("1", "全被保険者", "全被保険者（異動時は異動分全件）"),
    /**
     * コード:2 名称:差引き保険料1円以上の被保険者 略称:差引き保険料１円以上の被保険者
     */
    差引き保険料１円以上の被保険者("2", "差引き保険料1円以上の被保険者", "差引き保険料１円以上の被保険者"),
    /**
     * コード:3 名称:保険料変更有りで差引き保険料１円以上の被保険者 略称:保険料変更有りで差引き保険料１円以上の被保険者（異動分のみ）
     */
    保険料変更有りで差引き保険料１円以上の被保険者_異動分のみ("3", "保険料変更有りで差引き保険料１円以上の被保険者", "保険料変更有りで差引き保険料１円以上の被保険者（異動分のみ）"),
    /**
     * コード:4 名称:差引き保険料0円以外で確定保険料がある被保険者 略称:差引き保険料０円以外で確定保険料がある被保険者（当初のみ）
     */
    差引き保険料０円以外で確定保険料がある被保険者_当初のみ("4", "差引き保険料0円以外で確定保険料がある被保険者", "差引き保険料０円以外で確定保険料がある被保険者（当初のみ）");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TsuchishoPrintConditions(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 通知書プリント条件のコードを返します。
     *
     * @return 通知書プリント条件のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 通知書プリント条件の名称を返します。
     *
     * @return 通知書プリント条件の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 通知書プリント条件の略称を返します。
     *
     * @return 通知書プリント条件の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 通知書プリント条件のコードと一致する内容を探します。
     *
     * @param code 通知書プリント条件のコード
     * @return {@code code} に対応する通知書プリント条件
     */
    public static TsuchishoPrintConditions toValue(RString code) {
        for (TsuchishoPrintConditions tsuchishoPrintConditions : TsuchishoPrintConditions.values()) {
            if (tsuchishoPrintConditions.code.equals(code)) {
                return tsuchishoPrintConditions;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("通知書プリント条件"));
    }
}
