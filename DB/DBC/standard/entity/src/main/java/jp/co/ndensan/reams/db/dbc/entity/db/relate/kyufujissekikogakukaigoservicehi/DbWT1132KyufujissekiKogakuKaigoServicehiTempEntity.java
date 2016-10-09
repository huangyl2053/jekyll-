/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikogakukaigoservicehi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績高額一時テーブルです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity
        extends DbTableEntityBase<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @TempTableColumnOrder(2)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(3)
    private RString recodeShubetsuCode;
    @TempTableColumnOrder(4)
    private HokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(6)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(7)
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(8)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(9)
    private RString toshiNo;
    @TempTableColumnOrder(10)
    private FlexibleDate uketsukeYMD;
    @TempTableColumnOrder(11)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(12)
    private RString kohi1FutanNo;
    @TempTableColumnOrder(13)
    private RString kohi2FutanNo;
    @TempTableColumnOrder(14)
    private RString kohi3FutanNo;
    @TempTableColumnOrder(15)
    private int riyoshaFutangaku;
    @TempTableColumnOrder(16)
    private int kohi1Futangaku;
    @TempTableColumnOrder(17)
    private int kohi2Futangaku;
    @TempTableColumnOrder(18)
    private int kohi3Futangaku;
    @TempTableColumnOrder(19)
    private int shikyugaku;
    @TempTableColumnOrder(20)
    private int kohi1Shikyugaku;
    @TempTableColumnOrder(21)
    private int kohi2Shikyugaku;
    @TempTableColumnOrder(22)
    private int kohi3Shikyugaku;
    @TempTableColumnOrder(23)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(24)
    private RString seiriNo;
    @TempTableColumnOrder(25)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(26)
    private FlexibleYearMonth torikomiYM;
    @TempTableColumnOrder(27)
    private RString sakuseiKubun;
    @TempTableColumnOrder(28)
    private RString kanriNo;
    @TempTableColumnOrder(29)
    private boolean hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;
    @TempTableColumnOrder(30)
    @PrimaryKey
    private int renban;
    @TempTableColumnOrder(31)
    private boolean sofuJogaiFlag;
    @TempTableColumnOrder(32)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(33)
    private RString hokenshaName;
    @TempTableColumnOrder(34)
    private HihokenshaNo sofuHihokenshaNo;

}
