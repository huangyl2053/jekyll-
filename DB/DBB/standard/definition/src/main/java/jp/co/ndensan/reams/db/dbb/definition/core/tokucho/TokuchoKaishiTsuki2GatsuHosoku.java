package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始月2月捕捉を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum TokuchoKaishiTsuki2GatsuHosoku {

    /**
     * コード:00 名称:特別徴収しない 略称:定義なし
     */
    特別徴収しない("00", "特別徴収しない", ""),
    /**
     * コード:08 名称:_8月開始 略称:08月
     */
    _8月開始("08", "_8月開始", "08月");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokuchoKaishiTsuki2GatsuHosoku(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特徴開始月2月捕捉のコードを返します。
     *
     * @return 特徴開始月2月捕捉のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴開始月2月捕捉の名称を返します。
     *
     * @return 特徴開始月2月捕捉の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴開始月2月捕捉の略称を返します。
     *
     * @return 特徴開始月2月捕捉の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特徴開始月2月捕捉のコードと一致する内容を探します。
     *
     * @param code 特徴開始月2月捕捉のコード
     * @return {@code code} に対応する特徴開始月2月捕捉
     */
    public static TokuchoKaishiTsuki2GatsuHosoku toValue(RString code) {
        for (TokuchoKaishiTsuki2GatsuHosoku value : TokuchoKaishiTsuki2GatsuHosoku.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴開始月2月捕捉"));
    }
}
