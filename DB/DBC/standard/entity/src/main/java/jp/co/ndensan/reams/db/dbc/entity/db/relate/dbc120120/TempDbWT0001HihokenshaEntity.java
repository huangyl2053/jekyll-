/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 被保険者一時TBL項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempDbWT0001HihokenshaEntity extends DbTableEntityBase<TempDbWT0001HihokenshaEntity>
        implements IDbAccessable {

    @PrimaryKey
    private Decimal meisaiRenban;
    private ShoKisaiHokenshaNo shoHokenshaNo;
    private HihokenshaNo orgHihokenshaNo;
    private FlexibleDate serviceTeikyoYmd;
    private RString orgHihokenshaKanaShimei;
    private RString orgHihokenshaShimei;
    private LasdecCode oldShichosonCode;
    private HihokenshaNo henkanHihokenshaNo;
    private HihokenshaNo hihokenshaNo;
    private LasdecCode shichosonCode;
    private RString kannaiKangaiKubun;
    private YubinNo yubinNo;
    private ChoikiCode choikiCode;
    private GyoseikuCode gyoseikuCode;
    private RString gyoseikuMei;
    private RString jusho;
    private RString banchi;
    private RString katagaki;
    private RString kanaMeisho;
    private RString meisho;
    private RString shimei50onKana;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate shikakuShutokuYmd;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuSoshitsuYmd;
    private RString shikakuSoshitsuJiyuCode;
    private HihokenshaNo setaiShuyakuNo;
}
