package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮一次判定区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KariIchijiHanteiKubun {

    /**
     * コード:True 名称:仮一次判定 略称:定義なし
     */
    仮一次判定(true, "仮一次判定"),
    /**
     * コード:False 名称:本一次判定 略称:定義なし
     */
    本一次判定(false, "本一次判定");

    private final boolean code;
    private final RString fullName;

    private KariIchijiHanteiKubun(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 仮一次判定区分のコードを返します。
     *
     * @return 仮一次判定区分のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 仮一次判定区分の名称を返します。
     *
     * @return 仮一次判定区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 仮一次判定区分のコードと一致する内容を探します。
     *
     * @param code 仮一次判定区分のコード
     * @return {@code code} に対応する仮一次判定区分
     */
    public static KariIchijiHanteiKubun toValue(boolean code) {
        for (KariIchijiHanteiKubun kariIchijiHanteiKubun : KariIchijiHanteiKubun.values()) {
            if (kariIchijiHanteiKubun.code == code) {
                return kariIchijiHanteiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("仮一次判定区分"));
    }
}
