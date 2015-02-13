/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 引渡し区分の列挙型です。
 *
 * @author n8107 千秋雄
 */
public enum HikiwatashiKubun implements IRStringConvertable {
//TODO N8107千秋雄 コードマスタにて管理されることも考慮する　2014/2/28 まで

    /**
     * 連携データの引き渡しが済んでいる("1")
     */
    引渡し済み(new RString("1")),
    /**
     * 連携データが引き渡されていない("0")
     */
    引き渡し未済(new RString("0"));
    private final RString コード;

    private HikiwatashiKubun(RString code) {
        this.コード = code;
    }

    /**
     * 指定された引渡し区分に該当する引渡し区分情報を返します。
     *
     * @param code 引渡し区分
     * @return 名称
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない引渡し区分の場合
     */
    public static HikiwatashiKubun toValue(RString code) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("引渡し区分"));

        for (HikiwatashiKubun item : HikiwatashiKubun.values()) {
            if (item.コード.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する引渡し区分").evaluate());
    }

    /**
     * 引渡し区分を返します。
     *
     * @return 引渡し区分
     */
    public RString getCode() {
        return コード;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
