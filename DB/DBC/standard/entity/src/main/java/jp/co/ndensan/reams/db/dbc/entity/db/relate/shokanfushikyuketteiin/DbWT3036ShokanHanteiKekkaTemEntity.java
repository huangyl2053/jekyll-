/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 償還払不支給判定結果一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT3036ShokanHanteiKekkaTemEntity extends DbTableEntityBase<DbWT3036ShokanHanteiKekkaTemEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(3)
    private RString shoKisaiHokenshaName;
    @TempTableColumnOrder(4)
    private FlexibleDate sakuseiYMD;
    @TempTableColumnOrder(5)
    private RString kokuhorenName;
    @TempTableColumnOrder(6)
    private RString tsuchishoNo;
    @TempTableColumnOrder(7)
    private RString seiriNo;
    @TempTableColumnOrder(8)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(9)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(10)
    private RString jigyoshoName;
    @TempTableColumnOrder(11)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(12)
    private RString serviceShuruiMei;
    @TempTableColumnOrder(13)
    private Decimal tanisuKingaku;
    @TempTableColumnOrder(14)
    private Decimal shiharaiKingaku;
    @TempTableColumnOrder(15)
    private Decimal zougenTanisu;
    @TempTableColumnOrder(16)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(17)
    private RString biko1;
    @TempTableColumnOrder(18)
    private RString biko2;
    @TempTableColumnOrder(19)
    private RString koshinDBumu;
    @TempTableColumnOrder(20)
    private JigyoshaNo wrkJigyoshoNo;
}
