package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ShiharaiHoho {

    /**
     * コード:0 名称:すべて 略称:支払方法の判定を行わない
     */
    支払方法の判定を行わない("0", "すべて", "支払方法の判定を行わない"),
    /**
     * コード:1 名称:窓口払い 略称:窓口払いのデータを抽出
     */
    窓口払いのデータを抽出("1", "窓口払い", "窓口払いのデータを抽出"),
    /**
     * コード:2 名称:口座払い 略称:金融機関への振込データを抽出
     */
    金融機関への振込データを抽出("2", "口座払い", "金融機関への振込データを抽出");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ShiharaiHoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 支払方法のコードを返します。
     *
     * @return 支払方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法の名称を返します。
     *
     * @return 支払方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法の略称を返します。
     *
     * @return 支払方法の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 支払方法のコードと一致する内容を探します。
     *
     * @param code 支払方法のコード
     * @return {@code code} に対応する支払方法
     */
    public static ShiharaiHoho toValue(RString code) {
        for (ShiharaiHoho shiharaiHoho : ShiharaiHoho.values()) {
            if (shiharaiHoho.code.equals(code)) {
                return shiharaiHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法"));
    }
}
