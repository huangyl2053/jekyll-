/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 特定入所者集計根拠テーブルのEntityクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class TempDwbTKyufujissekiShukeiKonkyo2Entity extends DbTableEntityBase<TempDwbTKyufujissekiShukeiKonkyo2Entity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString dataKubun;
    @TempTableColumnOrder(2)
    private RString shukeiKubun;
    @TempTableColumnOrder(3)
    private RString hyoNo;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private RString shukeiNo;
    @TempTableColumnOrder(5)
    private RString shukeiTani;
    @PrimaryKey
    @TempTableColumnOrder(6)
    private RString tateNo;
    @PrimaryKey
    @TempTableColumnOrder(7)
    private RString yokoNo;
    @TempTableColumnOrder(8)
    private RString inputShikibetsuNo;
    @TempTableColumnOrder(9)
    private RString shoKisaiHokenshaNo;
    @TempTableColumnOrder(10)
    private RString hihokenshaNo;
    @TempTableColumnOrder(11)
    private RString serviceTeikyoYM;
    @TempTableColumnOrder(12)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(13)
    private RString jigyoshaNo;
    @TempTableColumnOrder(14)
    private RString seiriNo;
    @TempTableColumnOrder(15)
    private RString meisaiNo;
    @TempTableColumnOrder(16)
    private RString motoSeiriNo;
    @TempTableColumnOrder(17)
    private RString shikyukubunCode;
    @TempTableColumnOrder(18)
    private RString umareYMD;
    @TempTableColumnOrder(19)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(20)
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(21)
    private RString renban;
    @TempTableColumnOrder(22)
    private RString recodeJunjiNo;
    @TempTableColumnOrder(23)
    private RString serviceSyuruiCode;
    @TempTableColumnOrder(24)
    private RString serviceKomokuCode;
    @TempTableColumnOrder(25)
    private Decimal atoHokenbunSeikyugaku;
    @TempTableColumnOrder(26)
    private RString shikakuKubun;
    @TempTableColumnOrder(27)
    private RString shichosonCode;
    @TempTableColumnOrder(28)
    private RString kyuShichosonCode;
    @TempTableColumnOrder(29)
    private RString genbutsubunSonzaiFlag;
    @TempTableColumnOrder(30)
    private Decimal shukei0x05;
    @TempTableColumnOrder(31)
    private Decimal shukei0x06;

}
