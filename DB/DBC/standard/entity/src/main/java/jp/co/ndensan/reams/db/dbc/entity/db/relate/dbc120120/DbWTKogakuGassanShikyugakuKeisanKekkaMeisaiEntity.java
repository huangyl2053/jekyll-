/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 高額合算支給額計算結果明細一時TBL項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWTKogakuGassanShikyugakuKeisanKekkaMeisaiEntity {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private RString meisanNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString hokenSeidoCode;
    private RString uchiwakeHokenshaNo;
    private RString kokuho_HihokenshaShoKigo;
    private RString hiHokenshaShoNo;
    private RString uchiwakeHokenshaMei;
    private RString jikoFutanSeiriNo;
    private RString taishoshaShimei;
    private RString over70_Futangaku;
    private RString over70_AmbunRitsu;
    private RString over70_Shikyugaku;
    private RString under70_Futangaku;
    private RString futangaku;
    private RString ambunRitsu;
    private RString under70_Shikyugaku;
    private RString shikyugaku;
    private RString over70_Biko;
    private RString under70_Biko;
    private RString dataKubun;
    private FlexibleYearMonth uketoriYM;
    private FlexibleYearMonth sofuYM;
    private ShoKisaiHokenshaNo shoHokenshaNo;
    private HihokenshaNo dbwt0001_hihokenshaNo;
    private RString meisho;
}
