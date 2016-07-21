/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 要介護認定主治医意見書意見項目一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class ShujiiIkenshoJohoTempTableEntity extends DbTableEntityBase<NinteichosaJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private RString koroshoIfShikibetsuCode;
    @TempTableColumnOrder(3)
    private RString remban14;
    @TempTableColumnOrder(4)
    private RString remban15;
    @TempTableColumnOrder(5)
    private RString remban16;
    @TempTableColumnOrder(6)
    private RString remban17;
    @TempTableColumnOrder(7)
    private RString remban18;
    @TempTableColumnOrder(8)
    private RString remban19;
    @TempTableColumnOrder(9)
    private RString remban69;
}
