package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.hyojunfutangakugemmen;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減額区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum GengakuKubun {

    /**
     * コード:なし 名称:市町村民税非課税 略称:定義なし
     */
    市町村民税非課税("市町村民税非課税"),
    /**
     * コード:なし 名称:老齢福祉年金受給 略称:定義なし
     */
    老齢福祉年金受給("老齢福祉年金受給"),
    /**
     * コード:なし 名称:その他 略称:定義なし
     */
    その他("その他");

    private final RString fullName;

    private GengakuKubun(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 減額区分の名称を返します。
     *
     * @return 減額区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 減額区分の名称と一致する内容を探します。
     *
     * @param fullname 減額区分の名称
     * @return {@code fullname} に対応する減額区分
     */
    public static GengakuKubun toValue(RString fullname) {
        for (GengakuKubun gengakuKubun : GengakuKubun.values()) {
            if (gengakuKubun.get名称().equals(fullname)) {
                return gengakuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("減額区分"));
    }
}
