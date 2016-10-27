/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 高額サービス等支給（不支給）決定通知書情報一時TBLと事業高額決定通知書情報一時TBL作成する用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
@SuppressWarnings("PMD.UnusedPrivateField")
public class KetteiTsuchishoInfoTempEntity extends DbTableEntityBase<KetteiTsuchishoInfoTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private int rirekiNo;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private HokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private FlexibleDate uketsukeYMD;
    @TempTableColumnOrder(6)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(7)
    private RString shiharaiBasho;
    @TempTableColumnOrder(8)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(9)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(10)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(11)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(12)
    private long kozaID;
    @TempTableColumnOrder(13)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(14)
    private RString tsuchishoNo;
    @TempTableColumnOrder(15)
    private RString fushikyuRiyu;
    @TempTableColumnOrder(16)
    private RString hanteiShikyuKubunCode;
    @TempTableColumnOrder(17)
    private Decimal shikyuKingaku;

    @TempTableColumnOrder(18)
    private RString shinsaHohoKubun;
    @TempTableColumnOrder(19)
    private Decimal honninShiharaiGaku;
    @TempTableColumnOrder(20)
    private boolean jidoShokanTaishoFlag;
    @TempTableColumnOrder(21)
    private RString ketteiShikyuKubunCode;
    @TempTableColumnOrder(22)
    private Decimal kogakuShikyuGaku;
    @TempTableColumnOrder(23)
    private Decimal riyoshaFutanGaku;

    @TempTableColumnOrder(24)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(25)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(26)
    private RString shikakuSoshitsuJiyuCode;

    @TempTableColumnOrder(27)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(28)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(29)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(30)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(31)
    private RString shikakuJyotaiKubun;
    @TempTableColumnOrder(32)
    private int gokeiRirekiNo;
    @TempTableColumnOrder(33)
    private RString serviceShuruiName;

}
