/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 過誤決定通知書（保険者分）情報（明細）一時テーブルEntity
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInMeisaiEntity implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("TEMP_TABLE_KagoKetteiTsuchishoJyohoHokenshabunMeisai");

    private FlexibleYearMonth toriatsukaiYM;
    private HokenshaNo shokisaiHokenshaNo;
    private RString shokisaiHokenshaNa;
    private FlexibleDate sakuseiYMD;
    private RString kokukoRengoukaiNa;

    private JigyoshaNo jigyoshoNo;
    private RString jigyoshoName;
    private HihokenshaNo hiHokenshaNo;
    private RString hiHokenshaSimei;
    private FlexibleYearMonth serviceTeikyoYM;
    private ServiceShuruiCode serviceShuruiCode;
    private RString serviceShuruiName;
    private Code kagomoushitateJiyuCode;
    private RString kagomoushitateJiyu;
    private Decimal tanisu;
    private Decimal hokenshaFutangaku;

}
