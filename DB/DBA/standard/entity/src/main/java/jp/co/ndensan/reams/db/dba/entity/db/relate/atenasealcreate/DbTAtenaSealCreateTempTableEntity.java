/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 宛名シール作成 宛名識別対象一時テーブルEntity。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbTAtenaSealCreateTempTableEntity extends DbTableEntityBase<DbTAtenaSealCreateTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString shikibetsuCode;
    @TempTableColumnOrder(2)
    private RString kanaMeisho;
    @TempTableColumnOrder(3)
    private RString shichouzonCode;
    @TempTableColumnOrder(4)
    private RString meisho;
    @TempTableColumnOrder(5)
    private RString wkKannaiKangaiKubun;
    @TempTableColumnOrder(6)
    private RString yubinNo;
    @TempTableColumnOrder(7)
    private RString jusho;
    @TempTableColumnOrder(8)
    private RString saiyuusenjyuushu;
    @TempTableColumnOrder(9)
    private RString banchi;
    @TempTableColumnOrder(10)
    private RString katagaki;
    @TempTableColumnOrder(11)
    private RString gyoseikuName;
    @TempTableColumnOrder(12)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(13)
    private RString setainushiMei;
    @TempTableColumnOrder(14)
    private RString dainoukubunmeishou;
    @TempTableColumnOrder(15)
    private RString banchiCode;
    @TempTableColumnOrder(16)
    private RString gyoseikuCode;
    @TempTableColumnOrder(17)
    private RString chikuCode1;
    @TempTableColumnOrder(18)
    private RString chikuCode2;
    @TempTableColumnOrder(19)
    private RString chikuCode3;
    @TempTableColumnOrder(20)
    private RString setaiCode;
    @TempTableColumnOrder(21)
    private RString zenkokuJushoCode;
    @TempTableColumnOrder(22)
    private RString hihokenshaNo;
    @TempTableColumnOrder(23)
    private RString seibetsuCode;

}
