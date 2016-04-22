package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出対象を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ChushutsuTaisho {

    /**
     * コード:1 名称:抽出年月日 略称:定義なし
     */
    抽出年月日("1", "抽出年月日"),
    /**
     * コード:2 名称:医療機関 略称:定義なし
     */
    医療機関("2", "医療機関"),
    /**
     * コード:3 名称:調査委託先 略称:定義なし
     */
    調査委託先("3", "調査委託先");

    private final RString code;
    private final RString fullName;

    private ChushutsuTaisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出対象のコードを返します。
     *
     * @return 抽出対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出対象の名称を返します。
     *
     * @return 抽出対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出対象のコードと一致する内容を探します。
     *
     * @param code 抽出対象のコード
     * @return {@code code} に対応する抽出対象
     */
    public static ChushutsuTaisho toValue(RString code) {
        for (ChushutsuTaisho chushutsuTaisho : ChushutsuTaisho.values()) {
            if (chushutsuTaisho.code.equals(code)) {
                return chushutsuTaisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対応する抽出対象"));
    }
}
