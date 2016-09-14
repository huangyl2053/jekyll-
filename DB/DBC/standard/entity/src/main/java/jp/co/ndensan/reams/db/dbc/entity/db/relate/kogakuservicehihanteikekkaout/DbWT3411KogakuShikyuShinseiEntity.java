/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 高額介護サービス費支給一時TBLのEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT3411KogakuShikyuShinseiEntity extends DbTableEntityBase<DbWT3411KogakuShikyuShinseiEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(4)
    private HokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private Decimal rirekiNo;
    @TempTableColumnOrder(6)
    private FlexibleDate uketsukeYMD;
    @TempTableColumnOrder(7)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(8)
    private RString shinseiRiyu;
    @TempTableColumnOrder(9)
    private RString shinseishaKubun;
    @TempTableColumnOrder(10)
    private AtenaMeisho shinseishaShimei;
    @TempTableColumnOrder(11)
    private AtenaKanaMeisho shinseishaShimeiKana;
    @TempTableColumnOrder(12)
    private RString shinseishaJusho;
    @TempTableColumnOrder(13)
    private TelNo shinseishaTelNo;
    @TempTableColumnOrder(14)
    private JigyoshaNo shinseiJigyoshaNo;
    @TempTableColumnOrder(15)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(16)
    private RString shiharaiBasho;
    @TempTableColumnOrder(17)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(19)
    private RString heichoNaiyo;
    @TempTableColumnOrder(20)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(21)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(22)
    private long kozaID;
    @TempTableColumnOrder(23)
    private RString juryoininKeiyakuNo;
    @TempTableColumnOrder(24)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(25)
    private Decimal honninShiharaiGaku;
    @TempTableColumnOrder(26)
    private RString shikyuKubunCode;
    @TempTableColumnOrder(27)
    private Decimal shikyuKingaku;
    @TempTableColumnOrder(28)
    private RString fushikyuRiyu;
    @TempTableColumnOrder(29)
    private RString shinsaHohoKubun;
    @TempTableColumnOrder(30)
    private FlexibleYearMonth hanteiKekkaSofuYM;
    @TempTableColumnOrder(31)
    private boolean saiSofuFlag;
    @TempTableColumnOrder(32)
    private boolean hanteiKekkaSofuFuyoFlag;
    @TempTableColumnOrder(33)
    private RString shinsaKekkaHaneiKubun;
    @TempTableColumnOrder(34)
    private FlexibleDate ketteiTsuchishoSakuseiYMD;
    @TempTableColumnOrder(35)
    private FlexibleDate furikomiMeisaishoSakuseiYMD;
    @TempTableColumnOrder(36)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(37)
    private RString hokenshaName;
    @TempTableColumnOrder(38)
    private boolean sofuJogaiFlag;

}
