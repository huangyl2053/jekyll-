/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuservicekeikakuhi.KyotakuServiceKeikakuhiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.tokuteinyushoshahi.TokuteiNyushoshahiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績情報照会のbusinessクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiPrmBusiness implements Serializable {

    private static final long serialVersionUID = -5919506043541482841L;

//    private DukanriJoho dukanriJoho; 共通管理情報
    private KojinKakuteiKey kojinKakuteiKey;
    private KyufuJissekiCommonHeader commonHeader;
//    private SearchData searchData; 検索結果データ
    private RString dataType;
    private RString hokenshaNO;
    private FlexibleYearMonth serviceSTYM;
    private FlexibleYearMonth serviceEDYM;
    private RString maxKensu;
    private DataRow selectRow;
    private Boolean blnMaxKensuFG;
    private Boolean blnRirekiFG;
    private List<KyufujissekiKihon> csData_A;
    private List<KyufujissekiMeisaiBusiness> csData_B;
    private List<KyufujissekiKinkyuShisetsuRyoyo> csData_C;
    private List<KyufujissekiTokuteiSinryohi> csData_D;
    private List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> csData_J;
    private List<KyufujissekiShokujiHiyo> csData_E;
    private List<KyotakuServiceKeikakuhiBusiness> csData_F;
    private List<KyufujissekiFukushiYoguHanbaihiBusiness> csData_G;
    private List<KyufujissekiJutakuKaishuhi> csData_H;
    private List<KyufujissekiKogakuKaigoServicehi> csData_I;
    private List<TokuteiNyushoshahiBusiness> csData_K;
    private List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> csData_L;
    private List<KyufuJissekiCareManagementHiBusiness> csData_M;
    private List<KyufujissekiMeisaiJushochiTokurei> csData_N;
    private List<KyufujissekiShukei> csData_Z;
    private List<KyufujissekiShoteiShikkanShisetsuRyoyo> csData_P;
    private List<JukyushaDaicho> jukyushaData;
//    private Data_N data_N; 給付実績情報照会
    private RString hiHokenShaName;
    private RString yoKaiGoDoName;
    private RString nenrei;
    private RString zenGo;
    private Integer selectLineNo;
    private RString meiSaiGaMen_Current;
    private RString sortItem;
    private Integer pageIndx;
    private Integer selectIndx;
    private RString aLJoken;
    private Integer cuPageIndx;
    private Integer cuSelectIndx;
    private Integer sort;
}
