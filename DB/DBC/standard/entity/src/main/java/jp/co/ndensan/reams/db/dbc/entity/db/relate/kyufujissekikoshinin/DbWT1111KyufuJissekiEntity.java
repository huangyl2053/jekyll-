/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT1111KyufuJissekiEntity extends DbTableEntityBase<DbWT1111KyufuJissekiEntity> implements IDbAccessable {
    
    @TempTableColumnOrder(1)
    private Decimal renban;
    @TempTableColumnOrder(2)
    private RString kokanJohoShikibetsuNo;
    @TempTableColumnOrder(3)
    private NyuryokuShikibetsuNo nyuryokuShikibetsuNo;
    @TempTableColumnOrder(4)
    private RString recordShubetsuCode;
    @TempTableColumnOrder(5)
    private RString kyufuJissekiSakuseiKubunCode;
    @TempTableColumnOrder(6)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(7)
    private RString kyufuJissekiKubun;
    @TempTableColumnOrder(8)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(9)
    private RString seiriNo;
    @TempTableColumnOrder(10)
    private Decimal recordKensuH1;
    @TempTableColumnOrder(11)
    private Decimal recordKensuD1;
    @TempTableColumnOrder(12)
    private Decimal recordKensuDD;
    @TempTableColumnOrder(13)
    private Decimal recordKensuD2;
    @TempTableColumnOrder(14)
    private Decimal recordKensuDC;
    @TempTableColumnOrder(15)
    private Decimal recordKensuD3;
    @TempTableColumnOrder(16)
    private Decimal recordKensuD4;
    @TempTableColumnOrder(17)
    private Decimal recordKensuD5;
    @TempTableColumnOrder(18)
    private Decimal recordKensuD6;
    @TempTableColumnOrder(19)
    private Decimal recordKensuD7;
    @TempTableColumnOrder(20)
    private Decimal recordKensuD8;
    @TempTableColumnOrder(21)
    private Decimal recordKensuDE;
    @TempTableColumnOrder(22)
    private Decimal recordKensuT1;
    @TempTableColumnOrder(23)
    private Decimal recordKensuD9;
    @TempTableColumnOrder(24)
    private Decimal recordKensuDA;
    @TempTableColumnOrder(25)
    private Decimal recordKensuDB;
    @TempTableColumnOrder(26)
    private RString keikokuKubunCode;
    @TempTableColumnOrder(27)
    private HokenjaNo hokenshaNo;
    @TempTableColumnOrder(28)
    private RString hokenshaName;
    @TempTableColumnOrder(29)
    private RString jigyoshaName;
    @TempTableColumnOrder(30)
    private RString nyuryokuShikibetsuMeisho;
    
}
