/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 償還払不支給決定者一覧表 償還払不支給決定者Entity
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFushikyuKetteiInEntity implements IDbAccessable, Serializable {

    @TempTableColumnOrder(1)
    private RString kokanShikibetsuNo;
    @TempTableColumnOrder(2)
    private RString recordTypeHeader;
    @TempTableColumnOrder(3)
    private ShoKisaiHokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(4)
    private RString hokenshaName;
    @TempTableColumnOrder(5)
    private FlexibleDate sakuseiYMD;
    @TempTableColumnOrder(6)
    private RString kokuhoRenkokaiName;
    @TempTableColumnOrder(7)
    private RString recordTypeMesai;
    @TempTableColumnOrder(8)
    private RString no;
    @TempTableColumnOrder(9)
    private RString seiriNo;
    @TempTableColumnOrder(10)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(11)
    private RString hiHokenshaName;
    @TempTableColumnOrder(12)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(13)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(14)
    private RString jigyoshoName;
    @TempTableColumnOrder(15)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(16)
    private RString serviceShuruiName;
    @TempTableColumnOrder(17)
    private Decimal tensuKingaku;
    @TempTableColumnOrder(18)
    private RString bikoOne;
    @TempTableColumnOrder(19)
    private RString bikoTwo;
    @TempTableColumnOrder(20)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(21)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(22)
    private ZenkokuJushoCode jushoCode;
    @TempTableColumnOrder(23)
    private AtenaJusho jusho;
    @TempTableColumnOrder(24)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(25)
    private RString gyoseiku;
    @TempTableColumnOrder(26)
    private RString soshitsuJiyuCode;
    @TempTableColumnOrder(27)
    private FlexibleDate soshitsuYMD;
    @TempTableColumnOrder(28)
    private Boolean isUpdate;
    @TempTableColumnOrder(29)
    private RString shikyuKubunCode;

}
