/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課の情報登録のRelateEntityクラスです。
 *
 * @reamsid_L DBB-9040-080 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class FukaJohoTorokuRelateEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private int rirekiNo;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private SetaiCode setaiCode;
    private int setaiInsu;
    private FlexibleDate shikakuShutokuYMD;
    private RString shikakuShutokuJiyu;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuJiyu;
    private RString seihofujoShurui;
    private FlexibleDate seihoKaishiYMD;
    private FlexibleDate seihoHaishiYMD;
    private FlexibleDate ronenKaishiYMD;
    private FlexibleDate ronenHaishiYMD;
    private FlexibleDate fukaYMD;
    private RString kazeiKubun;
    private RString setaikazeiKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkinShunyuGaku;
    private RString hokenryoDankai;
    private RString hokenryoDankai1;
    private Decimal nengakuHokenryo1;
    private FlexibleYearMonth tsukiwariStartYM1;
    private FlexibleYearMonth tsukiwariEndYM1;
    private RString hokenryoDankai2;
    private Decimal nengakuHokenryo2;
    private FlexibleYearMonth tsukiwariStartYM2;
    private FlexibleYearMonth tsukiwariEndYM2;
    private YMDHMS choteiNichiji;
    private RString choteiJiyu1;
    private RString choteiJiyu2;
    private RString choteiJiyu3;
    private RString choteiJiyu4;
    private RString koseiM;
    private Decimal gemmenMaeHokenryo;
    private Decimal gemmenGaku;
    private Decimal kakuteiHokenryo;
    private RString hokenryoDankaiKarisanntei;
    private int choshuHohoRirekiNo;
    private YMDHMS idoKijunNichiji;
    private RString kozaKubun;
    private RString kyokaisoKubun;
    private RString shokkenKubun;
    private LasdecCode fukaShichosonCode;
    private Decimal tkSaishutsuKampuGaku;
    private Decimal fuSaishutsuKampuGaku;
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
    private Decimal 調定ID;
    private int 期;
    private KamokuCode 科目コード;
}
