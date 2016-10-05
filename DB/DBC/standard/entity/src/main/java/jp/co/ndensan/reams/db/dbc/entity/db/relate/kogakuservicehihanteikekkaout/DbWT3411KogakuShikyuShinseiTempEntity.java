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
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費支給一時TBL
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3411KogakuShikyuShinseiTempEntity {

    private int renban;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private HokenshaNo shoKisaiHokenshaNo;
    private Decimal rirekiNo;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate shinseiYMD;
    private RString shinseiRiyu;
    private RString shinseishaKubun;
    private AtenaMeisho shinseishaShimei;
    private AtenaKanaMeisho shinseishaShimeiKana;
    private RString shinseishaJusho;
    private TelNo shinseishaTelNo;
    private JigyoshaNo shinseiJigyoshaNo;
    private RString shiharaiHohoKubunCode;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private long kozaID;
    private RString juryoininKeiyakuNo;
    private FlexibleDate ketteiYMD;
    private Decimal honninShiharaiGaku;
    private RString shikyuKubunCode;
    private Decimal shikyuKingaku;
    private RString fushikyuRiyu;
    private RString shinsaHohoKubun;
    private FlexibleYearMonth hanteiKekkaSofuYM;
    private boolean saiSofuFlag;
    private boolean hanteiKekkaSofuFuyoFlag;
    private RString shinsaKekkaHaneiKubun;
    private FlexibleDate ketteiTsuchishoSakuseiYMD;
    private FlexibleDate furikomiMeisaishoSakuseiYMD;
    private HokenshaNo hokenshaNo;
    private RString hokenshaName;
    private boolean sofuJogaiFlag;
    
}
