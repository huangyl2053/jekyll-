/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績集計根拠一時テーブル1のEntityクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class TempDwbTKyufujissekiShukeiKonkyo1Entity extends DbTableEntityBase<TempDwbTKyufujissekiShukeiKonkyo1Entity> implements IDbAccessable {

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
    private ShoKisaiHokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(10)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(11)
    private RString serviceTeikyoYM;
    @TempTableColumnOrder(12)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(13)
    private JigyoshaNo jigyoshaNo;
    @TempTableColumnOrder(14)
    private RString seiriNo;
    @TempTableColumnOrder(15)
    private RString meisaiNo;
    @TempTableColumnOrder(16)
    private JigyoshaNo motoSeiriNo;
    @TempTableColumnOrder(17)
    private RString shinseiKanrisikyuKubunCode;
    @TempTableColumnOrder(18)
    private RString umareYMD;
    @TempTableColumnOrder(19)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(20)
    private RString kyuSochiNyushoshaTokureiCode;
    @TempTableColumnOrder(21)
    private HokenKyufuRitsu hokenKyufuritsu;
    @TempTableColumnOrder(22)
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(23)
    private RString shokujihiyoHokenshaNo;
    @TempTableColumnOrder(24)
    private int kihonTeikyoNissu;
    @TempTableColumnOrder(25)
    private int tokubetsuTeikyoNissu;
    @TempTableColumnOrder(26)
    private int shokujiTeikyoNobeNissu;
    @TempTableColumnOrder(27)
    private Decimal kihonTeikyoTanka;
    @TempTableColumnOrder(27)
    private Decimal tokubetsuTeikyoTanka;
    @TempTableColumnOrder(29)
    private Decimal atoShokujiTeikyoSeikyuGaku;
    @TempTableColumnOrder(30)
    private RString shokujiHiyosikyuKubunCode;
    @TempTableColumnOrder(31)
    private Decimal shokujiHiyosikyuGaku;
    @TempTableColumnOrder(32)
    private ServiceShuruiCode serviceSyuruiCode;
    @TempTableColumnOrder(33)
    private Decimal seikyuTensuTanka;
    @TempTableColumnOrder(34)
    private Decimal seikyugaku;
    @TempTableColumnOrder(35)
    private Decimal riyoshaFutangaku;
    @TempTableColumnOrder(36)
    private int atoTensuGokei;
    @TempTableColumnOrder(37)
    private Decimal atoHokenSeikyugaku;
    @TempTableColumnOrder(38)
    private int atoDekidakaTensuGokei;
    @TempTableColumnOrder(39)
    private Decimal atoDekidakaSeikyuGaku;
    @TempTableColumnOrder(40)
    private RString shukeiShikyukubunCode;
    @TempTableColumnOrder(41)
    private Decimal shukeiShikyuKingaku;
    @TempTableColumnOrder(42)
    private int zougenten;
    @TempTableColumnOrder(43)
    private int atoTensu;
    @TempTableColumnOrder(44)
    private Decimal atoSeikyuKingaku;
    @TempTableColumnOrder(45)
    private RString keikakuhiShikyukubunCode;
    @TempTableColumnOrder(46)
    private Decimal keikakuhiShikyuKingaku;
    @TempTableColumnOrder(47)
    private Decimal meisaiTensu;
    @TempTableColumnOrder(48)
    private RString shikakuKubun;
    @TempTableColumnOrder(49)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(50)
    private LasdecCode kyuShichosonCode;
    @TempTableColumnOrder(51)
    private RString genbutsubunSonzaiFlag;
    @TempTableColumnOrder(52)
    private RString futanWariaiNendo;
    @TempTableColumnOrder(53)
    private RString futanWariaiKubun;
    @TempTableColumnOrder(54)
    private RString shinsaYM;
    @TempTableColumnOrder(55)
    private RString riyoshaFutanGenmenHihokenshaNo;
    @TempTableColumnOrder(56)
    private RString sakuseiKubunErrorFlag;
    @TempTableColumnOrder(57)
    private RString futanWariaiErrorFlag;
    @TempTableColumnOrder(58)
    private RString zengoKyufurituErrorFlag;
    @TempTableColumnOrder(59)
    private Decimal shukei0x01;
    @TempTableColumnOrder(60)
    private Decimal shukei0x02;
    @TempTableColumnOrder(61)
    private Decimal shukei0x03;
    @TempTableColumnOrder(62)
    private Decimal shukei0x04;
    @TempTableColumnOrder(63)
    private RString saikeibunHokenritu;
    @TempTableColumnOrder(64)
    private Decimal saikeiShukei0x04;
    @TempTableColumnOrder(65)
    private RString rirekiFlag;
}
