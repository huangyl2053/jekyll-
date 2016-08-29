/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連データ再送フラグを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 qinzhen
 */
public enum KokuhorenDataSaisoFlag {

    /**
     * コード:0 名称:再送不要 略称:再送不要
     */
    再送不要("0", "再送不要", "再送不要"),
    /**
     * コード:1 名称:再送要 略称:再送要
     */
    再送要("1", "再送要", "再送要");
    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private KokuhorenDataSaisoFlag(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 基準収入額適用申請書登録_抽出対象のコードを返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 基準収入額適用申請書登録_抽出対象の名称を返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 基準収入額適用申請書登録_抽出対象の名称を返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象の名称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 基準収入額適用申請書登録_抽出対象のコードと一致する内容を探します。
     *
     * @param code 基準収入額適用申請書登録_抽出対象のコード
     * @return {@code code} に対応する基準収入額適用申請書登録_抽出対象
     */
    public static KokuhorenDataSaisoFlag toValue(RString code) {

        for (KokuhorenDataSaisoFlag dataSaisoFlag : KokuhorenDataSaisoFlag.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連データ再送フラグ"));
    }
}
