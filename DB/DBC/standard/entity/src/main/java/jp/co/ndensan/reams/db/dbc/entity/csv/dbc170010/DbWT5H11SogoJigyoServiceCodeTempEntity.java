/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc170010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 総合事業サービスコード一時TBLです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT5H11SogoJigyoServiceCodeTempEntity
        extends DbTableEntityBase<DbWT5H11SogoJigyoServiceCodeTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;

    @TempTableColumnOrder(2)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(3)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth tekiyoKaishiYM;
    @TempTableColumnOrder(5)
    private int rirekiNo;
    @TempTableColumnOrder(6)
    private FlexibleYearMonth tekiyoShuryoYM;
    @TempTableColumnOrder(7)
    private RString serviceMeisho;
    @TempTableColumnOrder(8)
    private Decimal taniSu;
    @TempTableColumnOrder(9)
    private RString gendoGakuTaishogaiFlag;
    @TempTableColumnOrder(10)
    private RString taniSuShikibetsuCode;
    @TempTableColumnOrder(11)
    private RString gaibuServiceRiyoKubun;
    @TempTableColumnOrder(12)
    private RString tokubetsuChiikiKasanFlag;
    @TempTableColumnOrder(13)
    private RString teiRitsu_TeiGakuKubun;
    @TempTableColumnOrder(14)
    private Decimal riyoshaFutanGaku;
    @TempTableColumnOrder(15)
    private HokenKyufuRitsu kyufuRitsu;
    @TempTableColumnOrder(16)
    private RString nijiYoboTaishosha_JissiKubun;
    @TempTableColumnOrder(17)
    private RString yoShien1_JisshiKubun;
    @TempTableColumnOrder(18)
    private RString yoShien2_JisshiKubun;
    @TempTableColumnOrder(19)
    private RString taishoJigyosha_JisshiKubun;
    @TempTableColumnOrder(20)
    private RString santeiTaniKubun;
    @TempTableColumnOrder(21)
    private int seigenNissuKaisu;
    @TempTableColumnOrder(22)
    private RString santeiKaisuSeigenKikanKubun;
    @TempTableColumnOrder(23)
    private RString sofuKubun;
    @TempTableColumnOrder(24)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(25)
    private FlexibleDate shinkiHenkoIdoYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate shuryoIdoYMD;
    @TempTableColumnOrder(27)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(28)
    private RString idoKubunCode;
    @TempTableColumnOrder(29)
    private boolean dummyDataFlag;

}
