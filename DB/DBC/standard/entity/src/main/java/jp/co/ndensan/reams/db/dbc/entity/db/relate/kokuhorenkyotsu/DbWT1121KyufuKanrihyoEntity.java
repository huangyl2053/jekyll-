/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付管理票一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT1121KyufuKanrihyoEntity extends DbTableEntityBase<DbWT1121KyufuKanrihyoEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString kokanJohoShikibetsuNo;
    @TempTableColumnOrder(3)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(5)
    private RString kyufuShubetsuKubunCode;
    @TempTableColumnOrder(6)
    private RString kyufuMeisaiLineNo;
    @TempTableColumnOrder(7)
    private RString kyotakushienJigyoshoNo;
    @TempTableColumnOrder(8)
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(9)
    private FlexibleDate kyufuSakuseiYMD;
    @TempTableColumnOrder(10)
    private RString meisaiHokenshaNo;
    @TempTableColumnOrder(11)
    private FlexibleDate hiHokenshaUmareYMD;
    @TempTableColumnOrder(12)
    private RString seibetsuCode;
    @TempTableColumnOrder(13)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(14)
    private FlexibleYearMonth gendogakuTekiyoKaishiYM;
    @TempTableColumnOrder(15)
    private FlexibleYearMonth gendogakuTekiyoShuryoYM;
    @TempTableColumnOrder(16)
    private Decimal kyotakuKaigoYoboShikyuGendogaku;
    @TempTableColumnOrder(17)
    private RString kyotakuServicePlanSakuseiKubunCode;
    @TempTableColumnOrder(18)
    private RString serviceJigyoshoNo;
    @TempTableColumnOrder(19)
    private RString shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    @TempTableColumnOrder(20)
    private RString serviceShuruiCode;
    @TempTableColumnOrder(21)
    private Decimal kyufuKeikakuTanisuNissu;
    @TempTableColumnOrder(22)
    private Decimal kyufuKeikakuNissu;
    @TempTableColumnOrder(23)
    private Decimal shiteiServiceSubTotal;
    @TempTableColumnOrder(24)
    private Decimal kijyunGaitoServiceSubTotal;
    @TempTableColumnOrder(25)
    private Decimal kyufuKeikakuTotalTanisuNissu;
    @TempTableColumnOrder(26)
    private RString tantoKaigoShienSemmoninNo;
    @TempTableColumnOrder(27)
    private RString kaigoShienJigyoshaNo;
    @TempTableColumnOrder(28)
    private RString itakusakiTantoKaigoShienSemmoninNo;
    @TempTableColumnOrder(29)
    private FlexibleDate toshoTorokuYMD;
    @TempTableColumnOrder(30)
    private FlexibleYearMonth torikomiYM;
    @TempTableColumnOrder(31)
    private RString hokenshaNo;
    @TempTableColumnOrder(32)
    private RString hokenshaName;
    @TempTableColumnOrder(33)
    private RString jigyoshaName;

}
