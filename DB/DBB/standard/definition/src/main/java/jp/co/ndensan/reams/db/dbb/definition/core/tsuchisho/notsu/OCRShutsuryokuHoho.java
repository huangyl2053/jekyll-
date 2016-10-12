package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座振替のOCR出力方法を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum OCRShutsuryokuHoho {

    /**
     * コード:0 名称:「口座振替」ならOCR欄を印字しない 略称:定義なし
     */
    印字しない("0", "「口座振替」ならOCR欄を印字しない"),
    /**
     * コード:1 名称:「口座振替」ならOCR欄を「＊」でつぶす 略称:定義なし
     */
    マスクでつぶす("1", "「口座振替」ならOCR欄を「＊」でつぶす"),
    /**
     * コード:2 名称:「口座振替」ならOCR欄を印字する 略称:定義なし
     */
    印字する("2", "「口座振替」ならOCR欄を印字する");

    private final RString code;
    private final RString fullName;

    private OCRShutsuryokuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座振替のOCR出力方法のコードを返します。
     *
     * @return 口座振替のOCR出力方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座振替のOCR出力方法の名称を返します。
     *
     * @return 口座振替のOCR出力方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座振替のOCR出力方法のコードと一致する内容を探します。
     *
     * @param code 口座振替のOCR出力方法のコード
     * @return {@code code} に対応する口座振替のOCR出力方法
     */
    public static OCRShutsuryokuHoho toValue(RString code) {
        for (OCRShutsuryokuHoho oCRShutsuryokuHoho : OCRShutsuryokuHoho.values()) {
            if (oCRShutsuryokuHoho.code.equals(code)) {
                return oCRShutsuryokuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座振替のOCR出力方法"));
    }
}
