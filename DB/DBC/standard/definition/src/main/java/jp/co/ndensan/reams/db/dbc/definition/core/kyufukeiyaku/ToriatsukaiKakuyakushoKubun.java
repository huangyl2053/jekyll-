package jp.co.ndensan.reams.db.dbc.definition.core.kyufukeiyaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 確約書有りを表す列挙型です。
 *
 * @author LDNS
 */
public enum ToriatsukaiKakuyakushoKubun {

    /**
     * コード:true 名称:確約書有り 略称:定義なし
     */
    確約書有り("true", "確約書有り"),
    /**
     * コード:false 名称:確約書無し 略称:定義なし
     */
    確約書無し("false", "確約書無し");

    private final RString code;
    private final RString fullName;

    private ToriatsukaiKakuyakushoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 確約書有りのコードを返します。
     *
     * @return 確約書有りのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 確約書有りの名称を返します。
     *
     * @return 確約書有りの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 確約書有りのコードと一致する内容を探します。
     *
     * @param code 確約書有りのコード
     * @return {@code code} に対応する確約書有り
     */
    public static ToriatsukaiKakuyakushoKubun toValue(RString code) {

        for (ToriatsukaiKakuyakushoKubun toriatsukaiKakuyakushoKubun : ToriatsukaiKakuyakushoKubun.values()) {
            if (toriatsukaiKakuyakushoKubun.code.equals(code)) {
                return toriatsukaiKakuyakushoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("確約書有り"));
    }
}
