package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象リストを表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TargetList {

    /**
     * コード:1 名称:認定者リスト 略称:定義なし
     */
    認定者リスト("1", "認定者リスト"),
    /**
     * コード:2 名称:該当者リスト 略称:定義なし
     */
    該当者リスト("2", "該当者リスト");

    private final RString code;
    private final RString fullName;

    private TargetList(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 対象リストのコードを返します。
     *
     * @return 対象リストのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 対象リストの名称を返します。
     *
     * @return 対象リストの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 対象リストのコードと一致する内容を探します。
     *
     * @param code 対象リストのコード
     * @return {@code code} に対応する対象リスト
     */
    public static TargetList toValue(RString code) {
        for (TargetList targetList : TargetList.values()) {
            if (targetList.code.equals(code)) {
                return targetList;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象リスト"));
    }
}
