package jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年齢層抽出方法を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum NenreiSoChushutsuHoho {

    /**
     * コード:1 名称:年齢 略称:定義なし
     */
    年齢範囲("1", "年齢"),
    /**
     * コード:2 名称:生年月日 略称:定義なし
     */
    生年月日範囲("2", "生年月日");

    private final RString code;
    private final RString fullName;

    private NenreiSoChushutsuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 年齢層抽出方法のコードを返します。
     *
     * @return 年齢層抽出方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 年齢層抽出方法の名称を返します。
     *
     * @return 年齢層抽出方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 年齢層抽出方法のコードと一致する内容を探します。
     *
     * @param code 年齢層抽出方法のコード
     * @return {@code code} に対応する年齢層抽出方法
     */
    public static NenreiSoChushutsuHoho toValue(RString code) {
        for (NenreiSoChushutsuHoho nenreiSoChushutsuHoho : NenreiSoChushutsuHoho.values()) {
            if (nenreiSoChushutsuHoho.code.equals(code)) {
                return nenreiSoChushutsuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("年齢層抽出方法"));
    }
}
