package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査順確定フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsakaiOrderKakuteiFlg {

    /**
     * コード:True 名称:確定 略称:定義なし
     */
    確定(true, "確定"),
    /**
     * コード:False 名称:未確定 略称:定義なし
     */
    未確定(false, "未確定");

    private final boolean code;
    private final RString fullName;

    private ShinsakaiOrderKakuteiFlg(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 介護認定審査会審査順確定フラグのコードを返します。
     *
     * @return 介護認定審査会審査順確定フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 介護認定審査会審査順確定フラグの名称を返します。
     *
     * @return 介護認定審査会審査順確定フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護認定審査会審査順確定フラグのコードと一致する内容を探します。
     *
     * @param code 介護認定審査会審査順確定フラグのコード
     * @return {@code code} に対応する介護認定審査会審査順確定フラグ
     */
    public static ShinsakaiOrderKakuteiFlg toValue(boolean code) {
        for (ShinsakaiOrderKakuteiFlg shinsakaiOrderKakuteiFlg : ShinsakaiOrderKakuteiFlg.values()) {
            if (shinsakaiOrderKakuteiFlg.code == code) {
                return shinsakaiOrderKakuteiFlg;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護認定審査会審査順確定フラグ"));
    }
}
