/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;

/**
 * 認定申請区分(申請時)を表す列挙型です。
 *
 * @author n3310 酒井 裕亮
 * @jpName 認定申請区分申請時
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public enum NinteiShinseiKubunShinsei {

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
    職権(4),
    /**
     * コード「4」転入申請
     */
    転入申請(5),
    /**
     * コード「6」資格喪失(死亡)
     */
    資格喪失_死亡(6);
    private int コード;

    /**
     * 認定申請区分(申請時)コードを返します。
     *
     * @param コード
     */
    private NinteiShinseiKubunShinsei(int コード) {
        this.コード = コード;
    }

    /**
     * 指定された認定申請区分(申請時)の名称を返します。
     *
     * @param code 認定申請区分(申請時)コード
     * @return 認定申請区分(申請時)
     */
    public static NinteiShinseiKubunShinsei toValue(int code) {
        for (NinteiShinseiKubunShinsei item : NinteiShinseiKubunShinsei.values()) {
            if (item.コード == code) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する認定申請区分(申請時)").evaluate());
    }

    /**
     * 認定申請区分(申請時)コードを返します。
     *
     * @return コード
     */
    public int コード() {
        return コード;
    }
}
