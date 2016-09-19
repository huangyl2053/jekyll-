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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 賦課の情報Tempのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaTempEntity implements IDbAccessable {

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
    private Decimal tkKibetsuGaku01;
    private Decimal tkKibetsuGaku02;
    private Decimal tkKibetsuGaku03;
    private Decimal tkKibetsuGaku04;
    private Decimal tkKibetsuGaku05;
    private Decimal tkKibetsuGaku06;
    private Decimal fuKibetsuGaku01;
    private Decimal fuKibetsuGaku02;
    private Decimal fuKibetsuGaku03;
    private Decimal fuKibetsuGaku04;
    private Decimal fuKibetsuGaku05;
    private Decimal fuKibetsuGaku06;
    private Decimal fuKibetsuGaku07;
    private Decimal fuKibetsuGaku08;
    private Decimal fuKibetsuGaku09;
    private Decimal fuKibetsuGaku10;
    private Decimal fuKibetsuGaku11;
    private Decimal fuKibetsuGaku12;
    private Decimal fuKibetsuGaku13;
    private Decimal fuKibetsuGaku14;
}
