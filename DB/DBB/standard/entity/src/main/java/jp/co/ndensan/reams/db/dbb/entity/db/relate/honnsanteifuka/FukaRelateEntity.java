/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

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
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課計算中間Tempのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaRelateEntity {

    @PrimaryKey
    private FlexibleYear dbT2002_choteiNendo;
    @PrimaryKey
    private FlexibleYear dbT2002_fukaNendo;
    @PrimaryKey
    private TsuchishoNo dbT2002_tsuchishoNo;
    @PrimaryKey
    private int dbT2002_rirekiNo;
    private HihokenshaNo dbT2002_hihokenshaNo;
    private ShikibetsuCode dbT2002_shikibetsuCode;
    private SetaiCode dbT2002_setaiCode;
    private int dbT2002_setaiInsu;
    private FlexibleDate dbT2002_shikakuShutokuYMD;
    private RString dbT2002_shikakuShutokuJiyu;
    private FlexibleDate dbT2002_shikakuSoshitsuYMD;
    private RString dbT2002_shikakuSoshitsuJiyu;
    private RString dbT2002_seihofujoShurui;
    private FlexibleDate dbT2002_seihoKaishiYMD;
    private FlexibleDate dbT2002_seihoHaishiYMD;
    private FlexibleDate dbT2002_ronenKaishiYMD;
    private FlexibleDate dbT2002_ronenHaishiYMD;
    private FlexibleDate dbT2002_fukaYMD;
    private RString dbT2002_kazeiKubun;
    private RString dbT2002_setaikazeiKubun;
    private Decimal dbT2002_gokeiShotokuGaku;
    private Decimal dbT2002_nenkinShunyuGaku;
    private RString dbT2002_hokenryoDankai;
    private RString dbT2002_hokenryoDankai1;
    private Decimal dbT2002_nengakuHokenryo1;
    private FlexibleYearMonth dbT2002_tsukiwariStartYM1;
    private FlexibleYearMonth dbT2002_tsukiwariEndYM1;
    private RString dbT2002_hokenryoDankai2;
    private Decimal dbT2002_nengakuHokenryo2;
    private FlexibleYearMonth dbT2002_tsukiwariStartYM2;
    private FlexibleYearMonth dbT2002_tsukiwariEndYM2;
    private YMDHMS dbT2002_choteiNichiji;
    private RString dbT2002_choteiJiyu1;
    private RString dbT2002_choteiJiyu2;
    private RString dbT2002_choteiJiyu3;
    private RString dbT2002_choteiJiyu4;
    private RString dbT2002_koseiM;
    private Decimal dbT2002_gemmenMaeHokenryo;
    private Decimal dbT2002_gemmenGaku;
    private Decimal dbT2002_kakuteiHokenryo;
    private RString dbT2002_hokenryoDankaiKarisanntei;
    private int dbT2002_choshuHohoRirekiNo;
    private YMDHMS dbT2002_idoKijunNichiji;
    private RString dbT2002_kozaKubun;
    private RString dbT2002_kyokaisoKubun;
    private RString dbT2002_shokkenKubun;
    private LasdecCode dbT2002_fukaShichosonCode;
    private Decimal dbT2002_tkSaishutsuKampuGaku;
    private Decimal dbT2002_fuSaishutsuKampuGaku;
    private FlexibleYear dbT2003_choteiNendo;
    private FlexibleYear dbT2003_fukaNendo;
    private TsuchishoNo dbT2003_tsuchishoNo;
    private int dbT2003_rirekiNo;
    private RString dbT2003_choshuHouhou;
    private int dbT2003_ki;
    private Decimal dbT2003_choteiId;
    private Long urT0705_choteiId;
    private int urT0705_rirekiNo;
    private Long urT0705_shunoId;
    private RYear urT0705_kaikeiNendo;
    private RYear urT0705_shoriNendo;
    private int urT0705_shoriNo;
    private int urT0705_koseiKaisu;
    private RString urT0705_choteiJiyuCode;
    private RDate urT0705_choteiYMD;
    private Decimal urT0705_choteigaku;
    private Decimal urT0705_shohizei;
    private RDate urT0705_nokigenYMD;
    private RDate urT0705_hoteiNokigenToYMD;
    private boolean urT0705_fukaShoriJokyo;
}
