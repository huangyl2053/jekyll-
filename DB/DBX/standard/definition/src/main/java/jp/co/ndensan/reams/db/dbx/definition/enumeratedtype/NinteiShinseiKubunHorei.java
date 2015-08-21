/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 認定申請区分(法令)を表す列挙型です。
 *
 * @author n3310 酒井 裕亮
 * @jpName 認定申請区分法令
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public enum NinteiShinseiKubunHorei {

    /**
     * コード「1」新規申請
     */
    新規申請(1),
    /**
     * コード「2」更新申請
     */
    更新申請(2),
    /**
     * コード「3」区分変更申請
     */
    区分変更申請(3),
    /**
     * コード「4」職権
     */
    職権(4);
    private final int コード;

    private NinteiShinseiKubunHorei(int コード) {
        this.コード = コード;
    }

    /**
     * 指定された認定申請区分(法令)の名称を返します。
     *
     * @param code 認定申請区分(法令)コード
     * @return 認定申請区分(法令)
     */
    public static NinteiShinseiKubunHorei toValue(int code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請区分(法令)"));

        for (NinteiShinseiKubunHorei item : NinteiShinseiKubunHorei.values()) {
            if (item.コード == code) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する認定申請区分(法令)").evaluate());
    }

    /**
     * 認定申請区分(法令)コードを返します。
     *
     * @return コード
     */
    public int getコード() {
        return コード;
    }
}
