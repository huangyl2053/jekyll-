/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給決定者一覧表帳票ソースデータのクラス。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanBaraiShikyuKetteiJohoTyouhyouEntity implements Serializable {

    private RString printTimeStamp;
    private int pageCount;
    private RString kokuhorenName;
    private ShoKisaiHokenshaNo hokenshaNo;
    private RString hokenshaName;
    private RString shutsuryokujun1;
    private RString shutsuryokujun2;
    private RString shutsuryokujun3;
    private RString shutsuryokujun4;
    private RString shutsuryokujun5;
    private RString kaipage1;
    private RString kaipage2;
    private RString kaipage3;
    private RString kaipage4;
    private RString kaipage5;
    private RString listUpper_1;
    private HihokenshaNo listUpper_2;
    private RString listUpper_3;
    private JigyoshaNo listUpper_4;
    private RString listUpper_5;
    private FlexibleYearMonth listUpper_6;
    private Decimal listUpper_7;
    private Decimal listUpper_8;
    private RString listUpper_9;
    private RString listUpper_10;
    private RString listLower_1;
    private RString listLower_2;
    private RString listLower_3;
    private GyoseikuCode listLower_4;
    private RString listLower_5;
    private RString listLower_6;
    private int listLower_7;
    private RString listLower_8;
    private RString listLower_9;
    private RString listDBKoshinUmu_1;
}
