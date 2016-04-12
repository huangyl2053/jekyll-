package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始月4月捕捉を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum TokuchoKaishiTsuki4GatsuHosoku {

    /**
     * コード:00 名称:特別徴収しない 略称:定義なし
     */
    特別徴収しない("00", "特別徴収しない", ""),
    /**
     * コード:10 名称:_10月開始 略称:10月
     */
    _10月("10", "_10月開始", "10月");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokuchoKaishiTsuki4GatsuHosoku(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特徴開始月4月捕捉のコードを返します。
     *
     * @return 特徴開始月4月捕捉のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴開始月4月捕捉の名称を返します。
     *
     * @return 特徴開始月4月捕捉の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴開始月4月捕捉の略称を返します。
     *
     * @return 特徴開始月4月捕捉の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特徴開始月4月捕捉のコードと一致する内容を探します。
     *
     * @param code 特徴開始月4月捕捉のコード
     * @return {@code code} に対応する特徴開始月4月捕捉
     */
    public static TokuchoKaishiTsuki4GatsuHosoku toValue(RString code) {
        for (TokuchoKaishiTsuki4GatsuHosoku value : TokuchoKaishiTsuki4GatsuHosoku.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴開始月4月捕捉"));
    }
}
