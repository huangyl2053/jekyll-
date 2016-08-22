/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiCareManagementHi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiNyushosyaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryohi;
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
public class KyufuJissekiPrmBusiness {

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
    private KyufujissekiKihon csData_A;
    private KyufujissekiMeisai csData_B;
    private KyufujissekiKinkyuShisetsuRyoyo csData_C;
    private KyufujissekiTokuteiSinryohi csData_D;
    private KyufujissekiTokuteiSinryoTokubetsuRyoyo csData_J;
    private KyufujissekiShokujiHiyo csData_E;
    private KyufujissekiKyotakuService csData_F;
    private KyufujissekiFukushiYoguHanbaihi csData_G;
    private KyufujissekiJutakuKaishuhi csData_H;
    private KyufujissekiKogakuKaigoServicehi csData_I;
    private KyufujissekiTokuteiNyushosyaKaigoServiceHiyo csData_K;
    private KyufuJissekiShakaiFukushiHojinKeigengaku csData_L;
    private KyufuJissekiCareManagementHi csData_M;
    private KyufujissekiMeisaiJushochiTokurei csData_N;
    private KyufujissekiShukei csData_Z;
    private JukyushaDaicho jukyushaData;
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
