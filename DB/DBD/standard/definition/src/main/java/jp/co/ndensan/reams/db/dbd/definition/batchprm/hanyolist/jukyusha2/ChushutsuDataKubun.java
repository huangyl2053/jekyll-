package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出データ区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ChushutsuDataKubun {

    /**
     * コード:1 名称:直近の認定データから抽出 略称:定義なし
     */
    直近の認定データから抽出("1", "直近の認定データから抽出"),
    /**
     * コード:2 名称:申請データから抽出 略称:定義なし
     */
    申請データから抽出("2", "申請データから抽出"),
    /**
     * コード:3 名称:両方のデータから抽出 略称:定義なし
     */
    両方のデータから抽出("3", "両方のデータから抽出"),
    /**
     * コード:0 名称:全履歴 略称:定義なし
     */
    全履歴("0", "全履歴");

    private final RString code;
    private final RString fullName;

    private ChushutsuDataKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出データ区分のコードを返します。
     *
     * @return 抽出データ区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出データ区分の名称を返します。
     *
     * @return 抽出データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出データ区分のコードと一致する内容を探します。
     *
     * @param code 抽出データ区分のコード
     * @return {@code code} に対応する抽出データ区分
     */
    public static ChushutsuDataKubun toValue(RString code) {
        for (ChushutsuDataKubun chushutsuDataKubun : ChushutsuDataKubun.values()) {
            if (chushutsuDataKubun.code.equals(code)) {
                return chushutsuDataKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("抽出データ区分"));
    }
}
