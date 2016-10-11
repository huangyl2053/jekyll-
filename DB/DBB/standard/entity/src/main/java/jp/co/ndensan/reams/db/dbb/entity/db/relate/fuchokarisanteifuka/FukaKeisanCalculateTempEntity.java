/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 賦課計算のEntity。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaKeisanCalculateTempEntity extends DbTableEntityBase<FukaKeisanCalculateTempEntity>
        implements IDbAccessable {

    //賦課Newest
    @PrimaryKey
    private FlexibleYear dbT2002Fuka_choteiNendo;
    @PrimaryKey
    private FlexibleYear dbT2002Fuka_fukaNendo;
    @PrimaryKey
    private TsuchishoNo dbT2002Fuka_tsuchishoNo;
    @PrimaryKey
    private int dbT2002Fuka_rirekiNo;
    private HihokenshaNo dbT2002Fuka_hihokenshaNo;
    private ShikibetsuCode dbT2002Fuka_shikibetsuCode;
    private SetaiCode dbT2002Fuka_setaiCode;
    private int dbT2002Fuka_setaiInsu;
    private FlexibleDate dbT2002Fuka_shikakuShutokuYMD;
    private RString dbT2002Fuka_shikakuShutokuJiyu;
    private FlexibleDate dbT2002Fuka_shikakuSoshitsuYMD;
    private RString dbT2002Fuka_shikakuSoshitsuJiyu;
    private RString dbT2002Fuka_seihofujoShurui;
    private FlexibleDate dbT2002Fuka_seihoKaishiYMD;
    private FlexibleDate dbT2002Fuka_seihoHaishiYMD;
    private FlexibleDate dbT2002Fuka_ronenKaishiYMD;
    private FlexibleDate dbT2002Fuka_ronenHaishiYMD;
    private FlexibleDate dbT2002Fuka_fukaYMD;
    private RString dbT2002Fuka_kazeiKubun;
    private RString dbT2002Fuka_setaikazeiKubun;
    private Decimal dbT2002Fuka_gokeiShotokuGaku;
    private Decimal dbT2002Fuka_nenkinShunyuGaku;
    private RString dbT2002Fuka_hokenryoDankai;
    private RString dbT2002Fuka_hokenryoDankai1;
    private Decimal dbT2002Fuka_nengakuHokenryo1;
    private FlexibleYearMonth dbT2002Fuka_tsukiwariStartYM1;
    private FlexibleYearMonth dbT2002Fuka_tsukiwariEndYM1;
    private RString dbT2002Fuka_hokenryoDankai2;
    private Decimal dbT2002Fuka_nengakuHokenryo2;
    private FlexibleYearMonth dbT2002Fuka_tsukiwariStartYM2;
    private FlexibleYearMonth dbT2002Fuka_tsukiwariEndYM2;
    private YMDHMS dbT2002Fuka_choteiNichiji;
    private RString dbT2002Fuka_choteiJiyu1;
    private RString dbT2002Fuka_choteiJiyu2;
    private RString dbT2002Fuka_choteiJiyu3;
    private RString dbT2002Fuka_choteiJiyu4;
    private RString dbT2002Fuka_koseiM;
    private Decimal dbT2002Fuka_gemmenMaeHokenryo;
    private Decimal dbT2002Fuka_gemmenGaku;
    private Decimal dbT2002Fuka_kakuteiHokenryo;
    private RString dbT2002Fuka_hokenryoDankaiKarisanntei;
    private int dbT2002Fuka_choshuHohoRirekiNo;
    private YMDHMS dbT2002Fuka_idoKijunNichiji;
    private RString dbT2002Fuka_kozaKubun;
    private RString dbT2002Fuka_kyokaisoKubun;
    private RString dbT2002Fuka_shokkenKubun;
    private LasdecCode dbT2002Fuka_fukaShichosonCode;
    private Decimal dbT2002Fuka_tkSaishutsuKampuGaku;
    private Decimal dbT2002Fuka_fuSaishutsuKampuGaku;

    //介護期別
    private FlexibleYear dbT2003Kibetsu_choteiNendo;
    private FlexibleYear dbT2003Kibetsu_fukaNendo;
    private TsuchishoNo dbT2003Kibetsu_tsuchishoNo;
    private int dbT2003Kibetsu_rirekiNo;
    private RString dbT2003Kibetsu_choshuHouhou;
    private int dbT2003Kibetsu_ki;
    private Decimal dbT2003Kibetsu_choteiId;

    //介護継承
    private long urT0705ChoteiKyotsu_choteiId;
    private long urT0705ChoteiKyotsu_rirekiNo;
    private long urT0705ChoteiKyotsu_shunoId;
    private RYear urT0705ChoteiKyotsu_kaikeiNendo;
    private RYear urT0705ChoteiKyotsu_shoriNendo;
    private int urT0705ChoteiKyotsu_shoriNo;
    private int urT0705ChoteiKyotsu_koseiKaisu;
    private RString urT0705ChoteiKyotsu_choteiJiyuCode;
    private RDate urT0705ChoteiKyotsu_choteiYMD;
    private Decimal urT0705ChoteiKyotsu_choteigaku;
    private Decimal urT0705ChoteiKyotsu_shohizei;
    private RDate urT0705ChoteiKyotsu_nokigenYMD;
    private RDate urT0705ChoteiKyotsu_hoteiNokigenToYMD;
    private boolean urT0705ChoteiKyotsu_fukaShoriJokyo;

    //普徴仮算定抽出Temp
    private HihokenshaNo fuchoKarisanteiTemp_hihokenshaNo;
    private FlexibleDate fuchoKarisanteiTemp_idoYMD;
    private RString fuchoKarisanteiTemp_edaNo;
    private RString fuchoKarisanteiTemp_idoJiyuCode;
    private LasdecCode fuchoKarisanteiTemp_shichosonCode;
    private ShikibetsuCode fuchoKarisanteiTemp_shikibetsuCode;
    private RString fuchoKarisanteiTemp_shikakuShutokuJiyuCode;
    private FlexibleDate fuchoKarisanteiTemp_shikakuShutokuYMD;
    private FlexibleDate fuchoKarisanteiTemp_shikakuShutokuTodokedeYMD;
    private FlexibleDate fuchoKarisanteiTemp_ichigoShikakuShutokuYMD;
    private RString fuchoKarisanteiTemp_hihokennshaKubunCode;
    private RString fuchoKarisanteiTemp_shikakuSoshitsuJiyuCode;
    private FlexibleDate fuchoKarisanteiTemp_shikakuSoshitsuYMD;
    private FlexibleDate fuchoKarisanteiTemp_shikakuSoshitsuTodokedeYMD;
    private RString fuchoKarisanteiTemp_shikakuHenkoJiyuCode;
    private FlexibleDate fuchoKarisanteiTemp_shikakuHenkoYMD;
    private FlexibleDate fuchoKarisanteiTemp_shikakuHenkoTodokedeYMD;
    private RString fuchoKarisanteiTemp_jushochitokureiTekiyoJiyuCode;
    private FlexibleDate fuchoKarisanteiTemp_jushochitokureiTekiyoYMD;
    private FlexibleDate fuchoKarisanteiTemp_jushochitokureiTekiyoTodokedeYMD;
    private RString fuchoKarisanteiTemp_jushochitokureiKaijoJiyuCode;
    private FlexibleDate fuchoKarisanteiTemp_jushochitokureiKaijoYMD;
    private FlexibleDate fuchoKarisanteiTemp_jushochitokureiKaijoTodokedeYMD;
    private RString fuchoKarisanteiTemp_jushochiTokureiFlag;
    private RString fuchoKarisanteiTemp_koikinaiJushochiTokureiFlag;
    private LasdecCode fuchoKarisanteiTemp_koikinaiTokureiSochimotoShichosonCode;
    private LasdecCode fuchoKarisanteiTemp_kyuShichosonCode;
    private boolean fuchoKarisanteiTemp_logicalDeletedFlag;
    private FlexibleYear fuchoKarisanteiTemp_choteiNendo;
    private FlexibleYear fuchoKarisanteiTemp_fukaNendo;
    private TsuchishoNo fuchoKarisanteiTemp_tsuchishoNo;
    private FlexibleDate fuchoKarisanteiTemp_fukaYMD;

}
