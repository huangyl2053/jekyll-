/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定申請情報を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum DbT5001NinteiShinseiJoho implements IColumnDefinition {

    shinseishoKanriNo(10, 0),
    shichosonCode(5, 0),
    shishoCode(9, 0),
    hihokenshaNo(10, 0),
    shikibetsuCode(2147483647, 0),
    ninteiShinseiYMD(2147483647, 0),
    ninteiShinseiEdabanCode(2147483647, 0),
    ninteiShinseiShinseijiKubunCode(2147483647, 0),
    ninteiShinseiHoreiKubunCode(2147483647, 0),
    ninteiShinseiYukoKubunCode(2147483647, 0),
    shienShinseiKubun(1, 0),
    shinseiRiyu(2147483647, 0),
    zenYokaigoKubunCode(2147483647, 0),
    zenYukoKikan(5, 0),
    johoteikyoDouiUmuKubun(1, 0),
    ninteichosaIraiRirekiNo(5, 0),
    ikenshoIraiRirekiNo(5, 0),
    minashiCode(1, 0),
    enkitsuchiDoiUmuKubun(1, 0),
    shisetsuNyushoUmuKubun(1, 0),
    sichosonRenrakuJiko(2147483647, 0),
    torisageKubunCode(2147483647, 0),
    torisageRiyu(2147483647, 0),
    torisageYMD(2147483647, 0),
    shinsaKeizokuKubun(1, 0);
    private final int maxLength;
    private final int scale;

    private DbT5001NinteiShinseiJoho(int maxLength, int scale) {
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
