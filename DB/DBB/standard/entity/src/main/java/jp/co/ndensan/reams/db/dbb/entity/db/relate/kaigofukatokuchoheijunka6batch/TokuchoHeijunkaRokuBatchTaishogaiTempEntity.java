/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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

/**
 * 対象外データTempEntity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeijunkaRokuBatchTaishogaiTempEntity implements Cloneable, Serializable {

    private RString 備考コード;
    private FlexibleYear dbT2002Fuka_choteiNendo;
    private FlexibleYear dbT2002Fuka_fukaNendo;
    private TsuchishoNo dbT2002Fuka_tsuchishoNo;
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

    private FlexibleYear dbT2003Kibetsu_choteiNendo;
    private FlexibleYear dbT2003Kibetsu_fukaNendo;
    private TsuchishoNo dbT2003Kibetsu_tsuchishoNo;
    private int dbT2003Kibetsu_rirekiNo;
    private RString dbT2003Kibetsu_choshuHouhou;
    private int dbT2003Kibetsu_ki;
    private Decimal dbT2003Kibetsu_choteiId;
    private Long urT0705ChoteiKyotsu_choteiId;
    private Long urT0705ChoteiKyotsu_shunoId;
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

    /**
     * コンストラクタです。
     *
     */
    public TokuchoHeijunkaRokuBatchTaishogaiTempEntity() {
        this.dbT2002Fuka_choteiNendo = null;
        this.dbT2002Fuka_fukaNendo = null;
        this.dbT2002Fuka_tsuchishoNo = null;
        this.dbT2002Fuka_rirekiNo = 0;
        this.dbT2002Fuka_hihokenshaNo = null;
    }

    /**
     * コンストラクタです。
     *
     * @param 賦課の情報 FukaJohoRelateEntity
     * @param 備考コード RString
     */
    public TokuchoHeijunkaRokuBatchTaishogaiTempEntity(FukaJohoRelateEntity 賦課の情報, RString 備考コード) {
        requireNonNull(賦課の情報.get介護賦課Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(賦課の情報.get介護期別RelateEntity(), UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        final DbT2002FukaEntity 介護賦課 = 賦課の情報.get介護賦課Entity();
        final KibetsuEntity 介護期別RelateEntity = 賦課の情報.get介護期別RelateEntity().get(0);
        final DbT2003KibetsuEntity 介護期別Entity = 介護期別RelateEntity.get介護期別Entity();
        final UrT0705ChoteiKyotsuEntity 調定共通Entity = 介護期別RelateEntity.get調定共通Entity().get(0);
        this.dbT2002Fuka_choteiNendo = 介護賦課.getChoteiNendo();
        this.dbT2002Fuka_fukaNendo = 介護賦課.getFukaNendo();
        this.dbT2002Fuka_tsuchishoNo = 介護賦課.getTsuchishoNo();
        this.dbT2002Fuka_rirekiNo = 介護賦課.getRirekiNo();
        this.dbT2002Fuka_hihokenshaNo = 介護賦課.getHihokenshaNo();
        this.dbT2002Fuka_shikibetsuCode = 介護賦課.getShikibetsuCode();
        this.dbT2002Fuka_setaiCode = 介護賦課.getSetaiCode();
        this.dbT2002Fuka_setaiInsu = 介護賦課.getSetaiInsu();
        this.dbT2002Fuka_shikakuShutokuYMD = 介護賦課.getShikakuShutokuYMD();
        this.dbT2002Fuka_shikakuShutokuJiyu = 介護賦課.getShikakuShutokuJiyu();
        this.dbT2002Fuka_shikakuSoshitsuYMD = 介護賦課.getShikakuSoshitsuYMD();
        this.dbT2002Fuka_shikakuSoshitsuJiyu = 介護賦課.getShikakuSoshitsuJiyu();
        this.dbT2002Fuka_seihofujoShurui = 介護賦課.getSeihofujoShurui();
        this.dbT2002Fuka_seihoKaishiYMD = 介護賦課.getSeihoKaishiYMD();
        this.dbT2002Fuka_seihoHaishiYMD = 介護賦課.getSeihoHaishiYMD();
        this.dbT2002Fuka_ronenKaishiYMD = 介護賦課.getRonenKaishiYMD();
        this.dbT2002Fuka_ronenHaishiYMD = 介護賦課.getRonenHaishiYMD();
        this.dbT2002Fuka_fukaYMD = 介護賦課.getFukaYMD();
        this.dbT2002Fuka_kazeiKubun = 介護賦課.getKazeiKubun();
        this.dbT2002Fuka_setaikazeiKubun = 介護賦課.getSetaikazeiKubun();
        this.dbT2002Fuka_gokeiShotokuGaku = 介護賦課.getGokeiShotokuGaku();
        this.dbT2002Fuka_nenkinShunyuGaku = 介護賦課.getNenkinShunyuGaku();
        this.dbT2002Fuka_hokenryoDankai = 介護賦課.getHokenryoDankai();
        this.dbT2002Fuka_hokenryoDankai1 = 介護賦課.getHokenryoDankai1();
        this.dbT2002Fuka_nengakuHokenryo1 = 介護賦課.getNengakuHokenryo1();
        this.dbT2002Fuka_tsukiwariStartYM1 = 介護賦課.getTsukiwariStartYM1();
        this.dbT2002Fuka_tsukiwariEndYM1 = 介護賦課.getTsukiwariEndYM1();
        this.dbT2002Fuka_hokenryoDankai2 = 介護賦課.getHokenryoDankai2();
        this.dbT2002Fuka_nengakuHokenryo2 = 介護賦課.getNengakuHokenryo2();
        this.dbT2002Fuka_tsukiwariStartYM2 = 介護賦課.getTsukiwariStartYM2();
        this.dbT2002Fuka_tsukiwariEndYM2 = 介護賦課.getTsukiwariEndYM2();
        this.dbT2002Fuka_choteiNichiji = 介護賦課.getChoteiNichiji();
        this.dbT2002Fuka_choteiJiyu1 = 介護賦課.getChoteiJiyu1();
        this.dbT2002Fuka_choteiJiyu2 = 介護賦課.getChoteiJiyu2();
        this.dbT2002Fuka_choteiJiyu3 = 介護賦課.getChoteiJiyu3();
        this.dbT2002Fuka_choteiJiyu4 = 介護賦課.getChoteiJiyu4();
        this.dbT2002Fuka_koseiM = 介護賦課.getKoseiM();
        this.dbT2002Fuka_gemmenMaeHokenryo = 介護賦課.getGemmenMaeHokenryo();
        this.dbT2002Fuka_gemmenGaku = 介護賦課.getGemmenGaku();
        this.dbT2002Fuka_kakuteiHokenryo = 介護賦課.getKakuteiHokenryo();
        this.dbT2002Fuka_hokenryoDankaiKarisanntei = 介護賦課.getHokenryoDankaiKarisanntei();
        this.dbT2002Fuka_choshuHohoRirekiNo = 介護賦課.getChoshuHohoRirekiNo();
        this.dbT2002Fuka_idoKijunNichiji = 介護賦課.getIdoKijunNichiji();
        this.dbT2002Fuka_kozaKubun = 介護賦課.getKozaKubun();
        this.dbT2002Fuka_kyokaisoKubun = 介護賦課.getKyokaisoKubun();
        this.dbT2002Fuka_shokkenKubun = 介護賦課.getShokkenKubun();
        this.dbT2002Fuka_fukaShichosonCode = 介護賦課.getFukaShichosonCode();
        this.dbT2002Fuka_tkSaishutsuKampuGaku = 介護賦課.getTkSaishutsuKampuGaku();
        this.dbT2002Fuka_fuSaishutsuKampuGaku = 介護賦課.getFuSaishutsuKampuGaku();
        this.dbT2003Kibetsu_choteiNendo = 介護期別Entity.getChoteiNendo();
        this.dbT2003Kibetsu_fukaNendo = 介護期別Entity.getFukaNendo();
        this.dbT2003Kibetsu_tsuchishoNo = 介護期別Entity.getTsuchishoNo();
        this.dbT2003Kibetsu_rirekiNo = 介護期別Entity.getRirekiNo();
        this.dbT2003Kibetsu_choshuHouhou = 介護期別Entity.getChoshuHouhou();
        this.dbT2003Kibetsu_ki = 介護期別Entity.getKi();
        this.dbT2003Kibetsu_choteiId = 介護期別Entity.getChoteiId();
        this.urT0705ChoteiKyotsu_choteiId = 調定共通Entity.getChoteiId();
        this.urT0705ChoteiKyotsu_shunoId = 調定共通Entity.getShunoId();
        this.urT0705ChoteiKyotsu_kaikeiNendo = 調定共通Entity.getKaikeiNendo();
        this.urT0705ChoteiKyotsu_shoriNendo = 調定共通Entity.getShoriNendo();
        this.urT0705ChoteiKyotsu_shoriNo = 調定共通Entity.getShoriNo();
        this.urT0705ChoteiKyotsu_koseiKaisu = 調定共通Entity.getKoseiKaisu();
        this.urT0705ChoteiKyotsu_choteiJiyuCode = 調定共通Entity.getChoteiJiyuCode();
        this.urT0705ChoteiKyotsu_choteiYMD = 調定共通Entity.getChoteiYMD();
        this.urT0705ChoteiKyotsu_choteigaku = 調定共通Entity.getChoteigaku();
        this.urT0705ChoteiKyotsu_shohizei = 調定共通Entity.getShohizei();
        this.urT0705ChoteiKyotsu_nokigenYMD = 調定共通Entity.getNokigenYMD();
        this.urT0705ChoteiKyotsu_hoteiNokigenToYMD = 調定共通Entity.getHoteiNokigenToYMD();
        this.urT0705ChoteiKyotsu_fukaShoriJokyo = 調定共通Entity.getFukaShoriJokyo();
        this.備考コード = 備考コード;
    }
}
