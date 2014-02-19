/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定進捗情報を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum DbT5005NinteiShinchokuJoho implements IColumnDefinition {

    shinseishoKanriNo(10, 0),
    ninteiShinseiJohoTorokuYMD(2147483647, 0),
    enkitsuchiDoiUmuKubun(1, 0),
    enkitsuchiHakkoYMD(2147483647, 0),
    enkitsuchiHakkoKaisu(5, 0),
    ninteiEnkiRuyu(2147483647, 0),
    ichijihanteiChushutsuYMD(2147483647, 0),
    iraiJohoSoshinYMD(2147483647, 0),
    ninteichosaIraiKanryoYMD(2147483647, 0),
    ninteichosaKanryoYMD(2147483647, 0),
    ikenshoSakuseiIraiKanryoYMD(2147483647, 0),
    ikenshoTorokuKanryoYMD(2147483647, 0),
    ichijiHanteiKanryoYMD(2147483647, 0),
    ichiGoHanteiKanryoYMD(2147483647, 0),
    ninteiShinsakaiWariateKanryoYMD(2147483647, 0),
    ninteiShinsakaiKanryoYMD(2147483647, 0),
    centerSoshinYMD(2147483647, 0);
    private final int maxLength;
    private final int scale;

    private DbT5005NinteiShinchokuJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長を返します。
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 項目の小数点以下の桁数を返します。
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
}
