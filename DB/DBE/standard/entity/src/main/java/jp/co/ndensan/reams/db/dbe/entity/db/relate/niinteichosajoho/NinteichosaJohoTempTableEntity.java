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
 * 調査票概況調査サービスの状況一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class NinteichosaJohoTempTableEntity extends DbTableEntityBase<NinteichosaJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private RString koroshoIfShikibetsuCode;
    @TempTableColumnOrder(3)
    private RString zenkaiShinseishoKanriNo;
    @TempTableColumnOrder(4)
    private RString remban1;
    @TempTableColumnOrder(5)
    private RString remban2;
    @TempTableColumnOrder(6)
    private RString remban3;
    @TempTableColumnOrder(7)
    private RString remban4;
    @TempTableColumnOrder(8)
    private RString remban5;
    @TempTableColumnOrder(9)
    private RString remban6;
    @TempTableColumnOrder(10)
    private RString remban7;
    @TempTableColumnOrder(11)
    private RString remban8;
    @TempTableColumnOrder(12)
    private RString remban9;
    @TempTableColumnOrder(13)
    private RString remban10;
    @TempTableColumnOrder(14)
    private RString remban11;
    @TempTableColumnOrder(15)
    private RString remban12;
    @TempTableColumnOrder(16)
    private RString remban13;
    @TempTableColumnOrder(17)
    private RString remban14;
    @TempTableColumnOrder(18)
    private RString remban15;
    @TempTableColumnOrder(19)
    private RString remban16;
    @TempTableColumnOrder(20)
    private RString remban17;
    @TempTableColumnOrder(21)
    private RString remban18;
    @TempTableColumnOrder(22)
    private RString remban19;
    @TempTableColumnOrder(23)
    private RString remban20;
}
