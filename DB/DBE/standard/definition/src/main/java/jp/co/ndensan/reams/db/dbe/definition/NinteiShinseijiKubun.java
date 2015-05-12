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
 * 認定申請区分（申請時）の列挙型です。
 *
 * @author n8107 千秋雄
 */
public enum NinteiShinseijiKubun implements IRStringConvertable {
//TODO N8107千秋雄 コードマスタにて管理されることも考慮する　2014/2/28 まで

    /**
     * 新規申請 ("01")
     */
    新規申請(new RString("01")),
    /**
     * 更新申請 ("02")
     */
    更新申請(new RString("02")),
    /**
     * 区分変更申請 ("03")
     */
    区分変更申請(new RString("03")),
    /**
     * 職権 ("04")
     */
    職権(new RString("04")),
    /**
     * 転入申請 ("05")
     */
    転入申請(new RString("05")),
    /**
     * 資格喪失（死亡）("06")
     */
    資格喪失_死亡(new RString("06"));
    private final RString コード;

    private NinteiShinseijiKubun(RString code) {
        this.コード = code;
    }

    /**
     * 指定された認定申請区分（申請時）に該当する認定申請区分（申請時）情報を返します。
     *
     * @param code 認定申請区分（申請時）
     * @return 名称
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない認定申請区分（申請時）の場合
     */
    public static NinteiShinseijiKubun toValue(RString code) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請区分（申請時）"));

        for (NinteiShinseijiKubun item : NinteiShinseijiKubun.values()) {
            if (item.コード.equals(code)) {
                return item;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する認定申請区分（申請時）").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する認定申請区分（申請時）").getMessage());

    }

    /**
     * 認定申請区分（申請時）を返します。
     *
     * @return 認定申請区分（申請時）
     */
    public RString getCode() {
        return コード;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
