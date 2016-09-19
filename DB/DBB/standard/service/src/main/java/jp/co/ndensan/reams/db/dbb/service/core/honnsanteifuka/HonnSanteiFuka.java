/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.honnsanteifuka.CalculateChoteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.FukaTempEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.service.core.choshuhoho.ChoshuHohoKoshin;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定賦課バッチのクラス
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class HonnSanteiFuka {

    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private static final RString 本算定賦課 = new RString("A1");
    private static final RString 年金保険者からの通知 = new RString("T1");
    private static final RString 保険料額の減額変更 = new RString("T2");
    private static final RString 徴収方法修正 = new RString("T4");
    private static final RString 特別徴収対象者外 = new RString("T5");
    private static final RString 資格喪失特徴中止 = new RString("T6");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;

    /**
     * にて生成した{@link HonnSanteiFuka}のインスタンスを返します。
     *
     * @return FukaKeisan
     */
    public static HonnSanteiFuka createInstance() {
        return InstanceProvider.create(HonnSanteiFuka.class);
    }

    /**
     * 賦課の情報を作成のメソッドです。
     *
     * @param 賦課の情報Entity FukaTempEntity
     * @return FukaJoho
     */
    public FukaJoho get賦課の情報(FukaTempEntity 賦課の情報Entity) {

        if (賦課の情報Entity == null || 賦課の情報Entity.getDbT2002_choteiNendo() == null || 賦課の情報Entity.getDbT2002_choteiNendo().isEmpty()
                || 賦課の情報Entity.getDbT2002_fukaNendo() == null || 賦課の情報Entity.getDbT2002_fukaNendo().isEmpty()
                || 賦課の情報Entity.getDbT2002_tsuchishoNo() == null || 賦課の情報Entity.getDbT2002_tsuchishoNo().isEmpty()) {
            return null;
        }
        FukaJoho fuka = new FukaJoho(賦課の情報Entity.getDbT2002_choteiNendo(), 賦課の情報Entity.getDbT2002_fukaNendo(),
                賦課の情報Entity.getDbT2002_tsuchishoNo(), 賦課の情報Entity.getDbT2002_rirekiNo());
        fuka = fuka.createBuilderForEdit().set被保険者番号(賦課の情報Entity.getDbT2002_hihokenshaNo())
                .set識別コード(賦課の情報Entity.getDbT2002_shikibetsuCode())
                .set世帯コード(賦課の情報Entity.getDbT2002_setaiCode()).set世帯員数(賦課の情報Entity.getDbT2002_setaiInsu())
                .set資格取得日(賦課の情報Entity.getDbT2002_shikakuShutokuYMD()).set資格取得事由(賦課の情報Entity.getDbT2002_shikakuShutokuJiyu())
                .set資格喪失日(賦課の情報Entity.getDbT2002_shikakuSoshitsuYMD()).set資格喪失事由(賦課の情報Entity.getDbT2002_shikakuSoshitsuJiyu())
                .set生活保護扶助種類(賦課の情報Entity.getDbT2002_seihofujoShurui()).set生保開始日(賦課の情報Entity.getDbT2002_seihoKaishiYMD())
                .set生保廃止日(賦課の情報Entity.getDbT2002_seihoHaishiYMD()).set老年開始日(賦課の情報Entity.getDbT2002_ronenKaishiYMD())
                .set老年廃止日(賦課の情報Entity.getDbT2002_ronenHaishiYMD()).set賦課期日(賦課の情報Entity.getDbT2002_fukaYMD())
                .set課税区分(賦課の情報Entity.getDbT2002_kazeiKubun()).set世帯課税区分(賦課の情報Entity.getDbT2002_setaikazeiKubun())
                .set合計所得金額(賦課の情報Entity.getDbT2002_gokeiShotokuGaku()).set公的年金収入額(賦課の情報Entity.getDbT2002_nenkinShunyuGaku())
                .set保険料段階(賦課の情報Entity.getDbT2002_hokenryoDankai()).set保険料算定段階1(賦課の情報Entity.getDbT2002_hokenryoDankai1())
                .set算定年額保険料1(賦課の情報Entity.getDbT2002_nengakuHokenryo1()).set保険料算定段階2(賦課の情報Entity.getDbT2002_hokenryoDankai2())
                .set算定年額保険料2(賦課の情報Entity.getDbT2002_nengakuHokenryo2()).set調定日時(賦課の情報Entity.getDbT2002_choteiNichiji())
                .set調定事由1(賦課の情報Entity.getDbT2002_choteiJiyu1()).set調定事由2(賦課の情報Entity.getDbT2002_choteiJiyu2())
                .set調定事由3(賦課の情報Entity.getDbT2002_choteiJiyu3()).set調定事由4(賦課の情報Entity.getDbT2002_choteiJiyu4())
                .set更正月(賦課の情報Entity.getDbT2002_koseiM()).set減免前介護保険料_年額(賦課の情報Entity.getDbT2002_gemmenMaeHokenryo())
                .set減免額(賦課の情報Entity.getDbT2002_gemmenGaku()).set確定介護保険料_年額(賦課の情報Entity.getDbT2002_kakuteiHokenryo())
                .set保険料段階_仮算定時(賦課の情報Entity.getDbT2002_hokenryoDankaiKarisanntei())
                .set徴収方法履歴番号(賦課の情報Entity.getDbT2002_choshuHohoRirekiNo())
                .set異動基準日時(賦課の情報Entity.getDbT2002_idoKijunNichiji()).set口座区分(賦課の情報Entity.getDbT2002_kozaKubun())
                .set境界層区分(賦課の情報Entity.getDbT2002_kyokaisoKubun()).set職権区分(賦課の情報Entity.getDbT2002_shokkenKubun())
                .set賦課市町村コード(賦課の情報Entity.getDbT2002_fukaShichosonCode()).set特徴歳出還付額(賦課の情報Entity.getDbT2002_tkSaishutsuKampuGaku())
                .set普徴歳出還付額(賦課の情報Entity.getDbT2002_fuSaishutsuKampuGaku()).set月割開始年月1(賦課の情報Entity.getDbT2002_tsukiwariStartYM1())
                .set月割終了年月1(賦課の情報Entity.getDbT2002_tsukiwariEndYM1()).set月割開始年月2(賦課の情報Entity.getDbT2002_tsukiwariStartYM2())
                .set月割終了年月2(賦課の情報Entity.getDbT2002_tsukiwariEndYM2()).build();

        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(fuka.toEntity());
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        for (int index = INDEX_1; index < INDEX_7; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(賦課の情報Entity.getDbT2002_choteiNendo());
            介護期別Entity.setFukaNendo(賦課の情報Entity.getDbT2002_fukaNendo());
            介護期別Entity.setTsuchishoNo(賦課の情報Entity.getDbT2002_tsuchishoNo());
            介護期別Entity.setRirekiNo(賦課の情報Entity.getDbT2002_rirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.特別徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).longValue());
            調定共通Entity.setChoteigaku(get特徴調定額(賦課の情報Entity, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        for (int index = INDEX_1; index <= INDEX_14; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(賦課の情報Entity.getDbT2002_choteiNendo());
            介護期別Entity.setFukaNendo(賦課の情報Entity.getDbT2002_fukaNendo());
            介護期別Entity.setTsuchishoNo(賦課の情報Entity.getDbT2002_tsuchishoNo());
            介護期別Entity.setRirekiNo(賦課の情報Entity.getDbT2002_rirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index).add(Decimal.TEN));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.普通徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).add(Decimal.TEN).longValue());
            調定共通Entity.setChoteigaku(get普通調定額(賦課の情報Entity, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        FukaJoho 賦課情報 = new FukaJoho(fukaJohoRelateEntity);
        return 賦課情報;
    }

    private Decimal get特徴調定額(FukaTempEntity 賦課の情報Entity, int index) {
        switch (index) {
            case INDEX_1:
                return 賦課の情報Entity.getTkKibetsuGaku01();
            case INDEX_2:
                return 賦課の情報Entity.getTkKibetsuGaku02();
            case INDEX_3:
                return 賦課の情報Entity.getTkKibetsuGaku03();
            case INDEX_4:
                return 賦課の情報Entity.getTkKibetsuGaku04();
            case INDEX_5:
                return 賦課の情報Entity.getTkKibetsuGaku05();
            default:
                return 賦課の情報Entity.getTkKibetsuGaku06();
        }
    }

    private Decimal get普通調定額(FukaTempEntity 賦課の情報Entity, int index) {
        switch (index) {
            case INDEX_1:
                return 賦課の情報Entity.getFuKibetsuGaku01();
            case INDEX_2:
                return 賦課の情報Entity.getFuKibetsuGaku02();
            case INDEX_3:
                return 賦課の情報Entity.getFuKibetsuGaku03();
            case INDEX_4:
                return 賦課の情報Entity.getFuKibetsuGaku04();
            case INDEX_5:
                return 賦課の情報Entity.getFuKibetsuGaku05();
            case INDEX_6:
                return 賦課の情報Entity.getFuKibetsuGaku06();
            case INDEX_7:
                return 賦課の情報Entity.getFuKibetsuGaku07();
            case INDEX_8:
                return 賦課の情報Entity.getFuKibetsuGaku08();
            case INDEX_9:
                return 賦課の情報Entity.getFuKibetsuGaku09();
            case INDEX_10:
                return 賦課の情報Entity.getFuKibetsuGaku10();
            case INDEX_11:
                return 賦課の情報Entity.getFuKibetsuGaku11();
            case INDEX_12:
                return 賦課の情報Entity.getFuKibetsuGaku12();
            case INDEX_13:
                return 賦課の情報Entity.getFuKibetsuGaku13();
            default:
                return 賦課の情報Entity.getFuKibetsuGaku14();
        }
    }

    /**
     * 一時賦課情報を設定のメソッドです。
     *
     * @param entity DbT2002FukaJohoTempTableEntity
     * @param 賦課の情報 FukaJoho
     * @return DbT2002FukaJohoTempTableEntity
     */
    public DbT2002FukaJohoTempTableEntity set一時賦課情報(DbT2002FukaJohoTempTableEntity entity, FukaJoho 賦課の情報) {
        entity.setChoteiNendo(賦課の情報.get調定年度());
        entity.setFukaNendo(賦課の情報.get賦課年度());
        entity.setTsuchishoNo(賦課の情報.get通知書番号());
        entity.setRirekiNo(賦課の情報.get履歴番号());
        entity.setHihokenshaNo(賦課の情報.get被保険者番号());
        entity.setShikibetsuCode(賦課の情報.get識別コード());
        entity.setSetaiCode(賦課の情報.get世帯コード());
        entity.setSetaiInsu(賦課の情報.get世帯員数());
        entity.setShikakuShutokuYMD(賦課の情報.get資格取得日());
        entity.setShikakuShutokuJiyu(賦課の情報.get資格取得事由());
        entity.setShikakuSoshitsuYMD(賦課の情報.get資格喪失日());
        entity.setShikakuSoshitsuJiyu(賦課の情報.get資格喪失事由());
        entity.setSeihofujoShurui(賦課の情報.get生活保護扶助種類());
        entity.setSeihoKaishiYMD(賦課の情報.get生保開始日());
        entity.setSeihoHaishiYMD(賦課の情報.get生保廃止日());
        entity.setRonenKaishiYMD(賦課の情報.get老年開始日());
        entity.setRonenHaishiYMD(賦課の情報.get老年廃止日());
        entity.setFukaYMD(賦課の情報.get賦課期日());
        entity.setKazeiKubun(賦課の情報.get課税区分());
        entity.setSetaikazeiKubun(賦課の情報.get世帯課税区分());
        entity.setGokeiShotokuGaku(賦課の情報.get合計所得金額());
        entity.setNenkinShunyuGaku(賦課の情報.get公的年金収入額());
        entity.setHokenryoDankai(賦課の情報.get保険料段階());
        entity.setHokenryoDankai1(賦課の情報.get保険料算定段階1());
        entity.setNengakuHokenryo1(賦課の情報.get算定年額保険料1());
        entity.setTsukiwariStartYM1(賦課の情報.get月割開始年月1());
        entity.setTsukiwariEndYM1(賦課の情報.get月割終了年月1());
        entity.setHokenryoDankai2(賦課の情報.get保険料算定段階2());
        entity.setNengakuHokenryo2(賦課の情報.get算定年額保険料2());
        entity.setTsukiwariStartYM2(賦課の情報.get月割開始年月2());
        entity.setTsukiwariEndYM2(賦課の情報.get月割終了年月2());
        entity.setChoteiNichiji(賦課の情報.get調定日時());
        entity.setChoteiJiyu1(賦課の情報.get調定事由1());
        entity.setChoteiJiyu2(賦課の情報.get調定事由2());
        entity.setChoteiJiyu3(賦課の情報.get調定事由3());
        entity.setChoteiJiyu4(賦課の情報.get調定事由4());
        entity.setKoseiM(賦課の情報.get更正月());
        entity.setGemmenMaeHokenryo(賦課の情報.get減免前介護保険料_年額());
        entity.setGemmenGaku(賦課の情報.get減免額());
        entity.setKakuteiHokenryo(賦課の情報.get確定介護保険料_年額());
        entity.setHokenryoDankaiKarisanntei(賦課の情報.get保険料段階_仮算定時());
        entity.setChoshuHohoRirekiNo(賦課の情報.get徴収方法履歴番号());
        entity.setIdoKijunNichiji(賦課の情報.get異動基準日時());
        entity.setKozaKubun(賦課の情報.get口座区分());
        entity.setKyokaisoKubun(賦課の情報.get境界層区分());
        entity.setShokkenKubun(賦課の情報.get職権区分());
        entity.setFukaShichosonCode(賦課の情報.get賦課市町村コード());
        entity.setTkSaishutsuKampuGaku(賦課の情報.get特徴歳出還付額());
        entity.setFuSaishutsuKampuGaku(賦課の情報.get普徴歳出還付額());
        entity.setTkKibetsuGaku01(賦課の情報.get特徴期別金額01());
        entity.setTkKibetsuGaku02(賦課の情報.get特徴期別金額02());
        entity.setTkKibetsuGaku03(賦課の情報.get特徴期別金額03());
        entity.setTkKibetsuGaku04(賦課の情報.get特徴期別金額04());
        entity.setTkKibetsuGaku05(賦課の情報.get特徴期別金額05());
        entity.setTkKibetsuGaku06(賦課の情報.get特徴期別金額06());
        entity.setFuKibetsuGaku01(賦課の情報.get普徴期別金額01());
        entity.setFuKibetsuGaku02(賦課の情報.get普徴期別金額02());
        entity.setFuKibetsuGaku03(賦課の情報.get普徴期別金額03());
        entity.setFuKibetsuGaku04(賦課の情報.get普徴期別金額04());
        entity.setFuKibetsuGaku05(賦課の情報.get普徴期別金額05());
        entity.setFuKibetsuGaku06(賦課の情報.get普徴期別金額06());
        entity.setFuKibetsuGaku07(賦課の情報.get普徴期別金額07());
        entity.setFuKibetsuGaku08(賦課の情報.get普徴期別金額08());
        entity.setFuKibetsuGaku09(賦課の情報.get普徴期別金額09());
        entity.setFuKibetsuGaku10(賦課の情報.get普徴期別金額10());
        entity.setFuKibetsuGaku11(賦課の情報.get普徴期別金額11());
        entity.setFuKibetsuGaku12(賦課の情報.get普徴期別金額12());
        entity.setFuKibetsuGaku13(賦課の情報.get普徴期別金額13());
        entity.setFuKibetsuGaku14(賦課の情報.get普徴期別金額14());
        return entity;
    }

    /**
     * 普徴期別がZEROを判断のメソッドです。
     *
     * @param 賦課の情報_更正後 FukaJoho
     * @return boolean
     */
    public boolean is普徴期別がZERO(FukaJoho 賦課の情報_更正後) {
        return Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額01())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額02())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額03())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額04())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額05())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額06())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額07())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額08())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額09())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額10())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額11())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額12())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額13())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額14());
    }

    /**
     * 賦課を変化有無の判断のメソッドです。
     *
     * @param 更正前 FukaJoho
     * @param 更正後 FukaJoho
     * @return boolean
     */
    public boolean is変化有り(FukaJoho 更正前, FukaJoho 更正後) {
        return is変化有り1(更正前, 更正後)
                || is変化有り2(更正前, 更正後)
                || is変化有り3(更正前, 更正後)
                || is変化有り4(更正前, 更正後);
    }

    private boolean is変化有り1(FukaJoho 更正前, FukaJoho 更正後) {
        return isTsuchishoNo変更(更正前.get通知書番号(), 更正後.get通知書番号())
                || isHihokenshaNo変更(更正前.get被保険者番号(), 更正後.get被保険者番号())
                || isShikibetsuCode変更(更正前.get識別コード(), 更正後.get識別コード())
                || isSetaiCode変更(更正前.get世帯コード(), 更正後.get世帯コード())
                || isInt変更(更正前.get世帯員数(), 更正後.get世帯員数())
                || isFlexibleDate変更(更正前.get資格取得日(), 更正後.get資格取得日())
                || isRString変更(更正前.get資格取得事由(), 更正後.get資格取得事由())
                || isFlexibleDate変更(更正前.get資格喪失日(), 更正後.get資格喪失日())
                || isRString変更(更正前.get資格喪失事由(), 更正後.get資格喪失事由())
                || isRString変更(更正前.get生活保護扶助種類(), 更正後.get生活保護扶助種類())
                || isFlexibleDate変更(更正前.get生保開始日(), 更正後.get生保開始日())
                || isFlexibleDate変更(更正前.get生保廃止日(), 更正後.get生保廃止日())
                || isFlexibleDate変更(更正前.get老年開始日(), 更正後.get老年開始日())
                || isFlexibleDate変更(更正前.get老年廃止日(), 更正後.get老年廃止日())
                || isFlexibleDate変更(更正前.get賦課期日(), 更正後.get賦課期日())
                || isRString変更(更正前.get課税区分(), 更正後.get課税区分())
                || isRString変更(更正前.get世帯課税区分(), 更正後.get世帯課税区分())
                || isDecimal変更(更正前.get合計所得金額(), 更正後.get合計所得金額());
    }

    private boolean is変化有り2(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get公的年金収入額(), 更正後.get公的年金収入額())
                || isRString変更(更正前.get保険料段階(), 更正後.get保険料段階())
                || isRString変更(更正前.get保険料算定段階1(), 更正後.get保険料算定段階1())
                || isDecimal変更(更正前.get算定年額保険料1(), 更正後.get算定年額保険料1())
                || isFlexibleYearMonth変更(更正前.get月割開始年月1(), 更正後.get月割開始年月1())
                || isFlexibleYearMonth変更(更正前.get月割終了年月1(), 更正後.get月割終了年月1())
                || isRString変更(更正前.get保険料算定段階2(), 更正後.get保険料算定段階2())
                || isDecimal変更(更正前.get算定年額保険料2(), 更正後.get算定年額保険料2())
                || isFlexibleYearMonth変更(更正前.get月割開始年月2(), 更正後.get月割開始年月2())
                || isFlexibleYearMonth変更(更正前.get月割終了年月2(), 更正後.get月割終了年月2())
                || isRString変更(更正前.get調定事由1(), 更正後.get調定事由1())
                || isRString変更(更正前.get調定事由2(), 更正後.get調定事由2())
                || isRString変更(更正前.get調定事由3(), 更正後.get調定事由3())
                || isRString変更(更正前.get調定事由4(), 更正後.get調定事由4())
                || isDecimal変更(更正前.get減免前介護保険料_年額(), 更正後.get減免前介護保険料_年額())
                || isDecimal変更(更正前.get減免額(), 更正後.get減免額())
                || isDecimal変更(更正前.get確定介護保険料_年額(), 更正後.get確定介護保険料_年額())
                || isRString変更(更正前.get保険料段階_仮算定時(), 更正後.get保険料段階_仮算定時())
                || isRString変更(更正前.get口座区分(), 更正後.get口座区分());
    }

    private boolean is変化有り3(FukaJoho 更正前, FukaJoho 更正後) {
        return isRString変更(更正前.get境界層区分(), 更正後.get境界層区分())
                || isRString変更(更正前.get職権区分(), 更正後.get職権区分())
                || isLasdecCode変更(更正前.get賦課市町村コード(), 更正後.get賦課市町村コード())
                || isDecimal変更(更正前.get特徴歳出還付額(), 更正後.get特徴歳出還付額())
                || isDecimal変更(更正前.get普徴歳出還付額(), 更正後.get普徴歳出還付額())
                || isDecimal変更(更正前.get特徴期別金額01(), 更正後.get特徴期別金額01())
                || isDecimal変更(更正前.get特徴期別金額02(), 更正後.get特徴期別金額02())
                || isDecimal変更(更正前.get特徴期別金額03(), 更正後.get特徴期別金額03())
                || isDecimal変更(更正前.get特徴期別金額04(), 更正後.get特徴期別金額04())
                || isDecimal変更(更正前.get特徴期別金額05(), 更正後.get特徴期別金額05())
                || isDecimal変更(更正前.get特徴期別金額06(), 更正後.get特徴期別金額06());
    }

    private boolean is変化有り4(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get普徴期別金額01(), 更正後.get普徴期別金額01())
                || isDecimal変更(更正前.get普徴期別金額02(), 更正後.get普徴期別金額02())
                || isDecimal変更(更正前.get普徴期別金額03(), 更正後.get普徴期別金額03())
                || isDecimal変更(更正前.get普徴期別金額04(), 更正後.get普徴期別金額04())
                || isDecimal変更(更正前.get普徴期別金額05(), 更正後.get普徴期別金額05())
                || isDecimal変更(更正前.get普徴期別金額06(), 更正後.get普徴期別金額06())
                || isDecimal変更(更正前.get普徴期別金額07(), 更正後.get普徴期別金額07())
                || isDecimal変更(更正前.get普徴期別金額08(), 更正後.get普徴期別金額08())
                || isDecimal変更(更正前.get普徴期別金額09(), 更正後.get普徴期別金額09())
                || isDecimal変更(更正前.get普徴期別金額10(), 更正後.get普徴期別金額10())
                || isDecimal変更(更正前.get普徴期別金額11(), 更正後.get普徴期別金額11())
                || isDecimal変更(更正前.get普徴期別金額12(), 更正後.get普徴期別金額12())
                || isDecimal変更(更正前.get普徴期別金額13(), 更正後.get普徴期別金額13())
                || isDecimal変更(更正前.get普徴期別金額14(), 更正後.get普徴期別金額14());
    }

    private boolean isTsuchishoNo変更(TsuchishoNo 更正前, TsuchishoNo 更正後) {
        if (更正前 == null) {
            更正前 = TsuchishoNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = TsuchishoNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isHihokenshaNo変更(HihokenshaNo 更正前, HihokenshaNo 更正後) {
        if (更正前 == null) {
            更正前 = HihokenshaNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = HihokenshaNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isShikibetsuCode変更(ShikibetsuCode 更正前, ShikibetsuCode 更正後) {

        if (更正前 == null) {
            更正前 = ShikibetsuCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = ShikibetsuCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isSetaiCode変更(SetaiCode 更正前, SetaiCode 更正後) {
        if (更正前 == null) {
            更正前 = SetaiCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = SetaiCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isInt変更(int 更正前, int 更正後) {
        return 更正前 != 更正後;
    }

    private boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleDate.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleDate.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isRString変更(RString 更正前, RString 更正後) {
        if (更正前 == null) {
            更正前 = RString.EMPTY;
        }
        if (更正後 == null) {
            更正後 = RString.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isFlexibleYearMonth変更(FlexibleYearMonth 更正前, FlexibleYearMonth 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleYearMonth.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleYearMonth.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isLasdecCode変更(LasdecCode 更正前, LasdecCode 更正後) {
        if (更正前 == null) {
            更正前 = LasdecCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = LasdecCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isDecimal変更(Decimal 更正前, Decimal 更正後) {
        if (更正前 == null) {
            更正前 = Decimal.ZERO;
        }
        if (更正後 == null) {
            更正後 = Decimal.ZERO;
        }
        return !更正後.equals(更正前);
    }

    /**
     * 最終月の市町村コードを取得のメソッドです。
     *
     * @param 月別ランク情報 List<MonthShichoson>
     * @return LasdecCode
     */
    public LasdecCode get最終月の市町村コード(List<MonthShichoson> 月別ランク情報) {
        LasdecCode 市町村コード_3月 = get市町村コード(月別ランク情報, Tsuki._3月.getコード());
        if (市町村コード_3月 != null) {
            return 市町村コード_3月;
        }
        LasdecCode 市町村コード_2月 = get市町村コード(月別ランク情報, Tsuki._2月.getコード());
        if (市町村コード_2月 != null) {
            return 市町村コード_2月;
        }
        LasdecCode 市町村コード_1月 = get市町村コード(月別ランク情報, Tsuki._1月.getコード());
        if (市町村コード_1月 != null) {
            return 市町村コード_1月;
        }
        LasdecCode 市町村コード_12月 = get市町村コード(月別ランク情報, Tsuki._12月.getコード());
        if (市町村コード_12月 != null) {
            return 市町村コード_12月;
        }
        LasdecCode 市町村コード_11月 = get市町村コード(月別ランク情報, Tsuki._11月.getコード());
        if (市町村コード_11月 != null) {
            return 市町村コード_11月;
        }
        LasdecCode 市町村コード_10月 = get市町村コード(月別ランク情報, Tsuki._10月.getコード());
        if (市町村コード_10月 != null) {
            return 市町村コード_10月;
        }
        LasdecCode 市町村コード_9月 = get市町村コード(月別ランク情報, Tsuki._9月.getコード());
        if (市町村コード_9月 != null) {
            return 市町村コード_9月;
        }
        LasdecCode 市町村コード_8月 = get市町村コード(月別ランク情報, Tsuki._8月.getコード());
        if (市町村コード_8月 != null) {
            return 市町村コード_8月;
        }
        LasdecCode 市町村コード_7月 = get市町村コード(月別ランク情報, Tsuki._7月.getコード());
        if (市町村コード_7月 != null) {
            return 市町村コード_7月;
        }
        LasdecCode 市町村コード_6月 = get市町村コード(月別ランク情報, Tsuki._6月.getコード());
        if (市町村コード_6月 != null) {
            return 市町村コード_6月;
        }
        LasdecCode 市町村コード_5月 = get市町村コード(月別ランク情報, Tsuki._5月.getコード());
        if (市町村コード_5月 != null) {
            return 市町村コード_5月;
        }
        LasdecCode 市町村コード_4月 = get市町村コード(月別ランク情報, Tsuki._4月.getコード());
        if (市町村コード_4月 != null) {
            return 市町村コード_4月;
        }
        return null;
    }

    private LasdecCode get市町村コード(List<MonthShichoson> 月別ランク情報, RString 月) {
        for (MonthShichoson choson : 月別ランク情報) {
            if (月.equals(choson.get月().getコード()) && choson.get市町村コード() != null
                    && !choson.get市町村コード().getColumnValue().isEmpty()) {
                return choson.get市町村コード();
            }
        }
        return null;
    }

    /**
     * 調定計算
     *
     * @param 調定日時 YMDHMS
     * @param 賦課情報_更正前 FukaJoho
     * @param 徴収方法情報_更正前 ChoshuHoho
     * @param 年額保険料 NengakuHokenryo
     * @param 資格の情報 HihokenshaDaicho
     * @return CalculateChoteiResult
     */
    public CalculateChoteiResult caluculateChotei(YMDHMS 調定日時,
            FukaJoho 賦課情報_更正前,
            ChoshuHoho 徴収方法情報_更正前,
            NengakuHokenryo 年額保険料,
            HihokenshaDaicho 資格の情報) {
        // TODO QAのNo.933(Redmine#91256)
        List<Decimal> 特徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INDEX_6; i++) {
            特徴期別金額.add(Decimal.ONE);
        }
        List<Decimal> 普徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INDEX_14; i++) {
            普徴期別金額.add(Decimal.TEN);
        }
        FukaJohoRelateEntity relateEntity = new FukaJohoRelateEntity();
        relateEntity.set介護賦課Entity(賦課情報_更正前.toEntity());
        List<KibetsuEntity> 介護期別EntityList = new ArrayList<>();
        for (Kibetsu kibetsu : 賦課情報_更正前.getKibetsuList()) {
            KibetsuEntity 介護期別Entity = new KibetsuEntity();
            介護期別Entity.set介護期別Entity(kibetsu.toEntity());
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            for (ChoteiKyotsu choteiKyotsu : kibetsu.getChoteiKyotsuList()) {
                調定共通EntityList.add(choteiKyotsu.toEntity());
            }
            介護期別Entity.set調定共通Entity(調定共通EntityList);
            介護期別EntityList.add(介護期別Entity);
        }
        relateEntity.set介護期別RelateEntity(介護期別EntityList);
        FukaJoho 賦課の情報_クローン = new FukaJoho(relateEntity);
        for (Kibetsu kibetsu : 賦課情報_更正前.getKibetsuList()) {
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(kibetsu.get徴収方法())) {
                set特徴期別金額(kibetsu, 特徴期別金額);
            } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(kibetsu.get徴収方法())) {
                set普徴期別金額(kibetsu, 普徴期別金額);
            }
        }
        ChoshuHoho 徴収方法の情報_クローン = new ChoshuHoho(徴収方法情報_更正前.toEntity());
        徴収方法の情報_クローン = 徴収方法の情報_クローン.createBuilderForEdit().set特別徴収停止事由コード(
                new RString("01")).set特別徴収停止日時(調定日時).build();
        ChoshuHoho 出力用徴収方法の情報 = ChoshuHohoKoshin.createInstance()
                .getChoshuHohoKoshinData(徴収方法の情報_クローン, 調定日時, 賦課の情報_クローン.get資格取得日(),
                        賦課の情報_クローン.get資格喪失日());
        CalculateChoteiResult result = new CalculateChoteiResult();
        result.set徴収方法情報(出力用徴収方法の情報);
        result.set賦課情報(賦課の情報_クローン);
        return result;
    }

    private void set特徴期別金額(Kibetsu kibetsu, List<Decimal> 特徴期別金額) {
        switch (kibetsu.get期()) {
            case INDEX_1:
                set期別金額(kibetsu, 特徴期別金額.get(0));
                break;
            case INDEX_2:
                set期別金額(kibetsu, 特徴期別金額.get(INDEX_1));
                break;
            case INDEX_3:
                set期別金額(kibetsu, 特徴期別金額.get(INDEX_2));
                break;
            case INDEX_4:
                set期別金額(kibetsu, 特徴期別金額.get(INDEX_3));
                break;
            case INDEX_5:
                set期別金額(kibetsu, 特徴期別金額.get(INDEX_5));
                break;
            case INDEX_6:
                set期別金額(kibetsu, 特徴期別金額.get(INDEX_6));
                break;
            default:
        }
    }

    private void set普徴期別金額(Kibetsu kibetsu, List<Decimal> 普徴期別金額) {
        switch (kibetsu.get期()) {
            case INDEX_1:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_0));
                break;
            case INDEX_2:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_1));
                break;
            case INDEX_3:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_2));
                break;
            case INDEX_4:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_3));
                break;
            case INDEX_5:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_4));
                break;
            case INDEX_6:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_5));
                break;
            case INDEX_7:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_6));
                break;
            case INDEX_8:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_7));
                break;
            case INDEX_9:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_8));
                break;
            case INDEX_10:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_9));
                break;
            case INDEX_11:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_10));
                break;
            case INDEX_12:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_11));
                break;
            case INDEX_13:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_12));
                break;
            case INDEX_14:
                set期別金額(kibetsu, 普徴期別金額.get(INDEX_13));
                break;
            default:
        }
    }

    private void set期別金額(Kibetsu kibetsu, Decimal 期別金額) {
        List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
        for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
            ChoteiKyotsuBuilder builder = choteiKyotsu.createBuilderForEdit();
            if (choteiKyotsu.get調定ID().equals(kibetsu.get調定ID().longValue())) {
                builder.set調定額(期別金額).build();
                break;
            }
        }
    }

    /**
     * 調定事由設定
     *
     * @param 当初賦課情報 FukaJoho
     * @param 設定前賦課情報 FukaJoho
     * @param 徴収方法情報 ChoshuHoho
     * @return DbT2002FukaEntity
     */
    public FukaJoho setChoteiJiyu(FukaJoho 当初賦課情報,
            FukaJoho 設定前賦課情報,
            ChoshuHoho 徴収方法情報) {
        RString 調定事由１ = 本算定賦課;
        RString 調定事由２ = RString.EMPTY;
        RString 調定事由３ = RString.EMPTY;
        RString 調定事由４ = RString.EMPTY;
        if (設定前賦課情報.get履歴番号() == INDEX_0) {
            if (!RString.isNullOrEmpty(設定前賦課情報.get資格喪失事由())) {
                調定事由２ = 設定前賦課情報.get資格喪失事由();
            }
        } else {
            if (is特別徴収停止事由コード(徴収方法情報) && is調定事由(当初賦課情報, 徴収方法情報)) {
                if (RString.isNullOrEmpty(当初賦課情報.get調定事由2())) {
                    調定事由２ = 徴収方法情報.get特別徴収停止事由コード();
                } else if (RString.isNullOrEmpty(当初賦課情報.get調定事由3())) {
                    調定事由３ = 徴収方法情報.get特別徴収停止事由コード();

                } else if (RString.isNullOrEmpty(当初賦課情報.get調定事由4())) {
                    調定事由４ = 徴収方法情報.get特別徴収停止事由コード();
                }
            } else if (!RString.isNullOrEmpty(設定前賦課情報.get資格喪失事由())) {
                if (RString.isNullOrEmpty(当初賦課情報.get調定事由2())) {
                    調定事由２ = 設定前賦課情報.get資格喪失事由();
                } else if (RString.isNullOrEmpty(当初賦課情報.get調定事由3())) {
                    調定事由３ = 設定前賦課情報.get資格喪失事由();
                } else if (RString.isNullOrEmpty(当初賦課情報.get調定事由4())) {
                    調定事由４ = 設定前賦課情報.get資格喪失事由();
                }
            }
        }
        FukaJohoRelateEntity relateEntity = new FukaJohoRelateEntity();
        relateEntity.set介護賦課Entity(設定前賦課情報.toEntity());
        List<KibetsuEntity> 介護期別EntityList = new ArrayList<>();
        for (Kibetsu kibetsu : 設定前賦課情報.getKibetsuList()) {
            KibetsuEntity 介護期別Entity = new KibetsuEntity();
            介護期別Entity.set介護期別Entity(kibetsu.toEntity());
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            for (ChoteiKyotsu choteiKyotsu : kibetsu.getChoteiKyotsuList()) {
                調定共通EntityList.add(choteiKyotsu.toEntity());
            }
            介護期別Entity.set調定共通Entity(調定共通EntityList);
            介護期別EntityList.add(介護期別Entity);
        }
        relateEntity.set介護期別RelateEntity(介護期別EntityList);
        FukaJoho 設定後賦課情報 = new FukaJoho(relateEntity);
        設定後賦課情報 = 設定後賦課情報.createBuilderForEdit().set調定事由1(調定事由１)
                .set調定事由2(調定事由２).set調定事由3(調定事由３).set調定事由4(調定事由４).build();
        return 設定後賦課情報;
    }

    private boolean is調定事由(FukaJoho 当初賦課情報, ChoshuHoho 徴収方法情報) {
        return !(当初賦課情報.get調定事由1().equals(徴収方法情報.get特別徴収停止事由コード())
                && 当初賦課情報.get調定事由2().equals(徴収方法情報.get特別徴収停止事由コード())
                && 当初賦課情報.get調定事由3().equals(徴収方法情報.get特別徴収停止事由コード())
                && 当初賦課情報.get調定事由4().equals(徴収方法情報.get特別徴収停止事由コード()));
    }

    private boolean is特別徴収停止事由コード(ChoshuHoho 徴収方法情報) {
        RString tokuchoTeishiJiyuCode = 徴収方法情報.get特別徴収停止事由コード();
        if (tokuchoTeishiJiyuCode != null) {
            return tokuchoTeishiJiyuCode.equals(年金保険者からの通知)
                    || tokuchoTeishiJiyuCode.equals(保険料額の減額変更)
                    || tokuchoTeishiJiyuCode.equals(徴収方法修正)
                    || tokuchoTeishiJiyuCode.equals(特別徴収対象者外)
                    || tokuchoTeishiJiyuCode.equals(資格喪失特徴中止);
        } else {
            return false;
        }
    }

    /**
     * 月別保険料制御情報を設定のメソッドです。
     *
     * @param 保険料段階List HokenryoDankaiList
     * @return SeigyoJoho
     */
    public SeigyoJoho editor月別保険料制御情報(HokenryoDankaiList 保険料段階List) {
        RDate nowDate = RDate.getNowDate();
        Decimal 基準年金収入額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額04 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額05 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額06 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額07 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額08 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額09 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額10 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額11 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額12 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額13 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額14 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額15 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 課税層所得段階 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 未申告段階使用有無 = false;
        if (使用する.equals(未申告段階使用)) {
            未申告段階使用有無 = true;
        } else if (使用しない.equals(未申告段階使用)) {
            未申告段階使用有無 = false;
        }
        RString 未申告段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 所得調査中段階使用有無 = false;
        if (使用する.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = true;
        } else if (使用しない.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = false;
        }
        RString 所得調査中段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 課税取消段階使用有無 = false;
        if (使用する.equals(課税取消段階使用)) {
            課税取消段階使用有無 = true;
        } else if (使用しない.equals(課税取消段階使用)) {
            課税取消段階使用有無 = false;
        }
        RString 課税取消段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        SeigyojohoFactory seigyojohoFactory = InstanceProvider.create(SeigyojohoFactory.class);
        SeigyoJoho 月別保険料制御情報 = seigyojohoFactory.createSeigyojoho(
                保険料段階List,
                基準年金収入額01,
                基準年金収入額02,
                基準年金収入額03,
                基準所得金額01,
                基準所得金額02,
                基準所得金額03,
                基準所得金額04,
                基準所得金額05,
                基準所得金額06,
                基準所得金額07,
                基準所得金額08,
                基準所得金額09,
                基準所得金額10,
                基準所得金額11,
                基準所得金額12,
                基準所得金額13,
                基準所得金額14,
                基準所得金額15,
                課税層所得段階,
                未申告段階使用有無,
                未申告段階インデックス,
                KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無,
                所得調査中段階インデックス,
                KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無,
                課税取消段階インデックス,
                KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    /**
     * 年額制御情報を設定のメソッドです。
     *
     * @return NengakuSeigyoJoho
     */
    public NengakuSeigyoJoho editor年額制御情報() {
        RDate nowDate = RDate.getNowDate();
        Decimal 端数単位 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_通常,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        Decimal 端数単位_ランク用 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_ランク変更のみ,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法_ランク用 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 端数調整対象 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整対象,
                nowDate, SubGyomuCode.DBB介護賦課);
        // TODO QAのNo.957　「ランク別制御情報」の設定方法がない。
        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<RString, RankBetsuKijunKingaku>();
        RankBetsuKijunKingaku gaku = new RankBetsuKijunKingaku();
//        gaku.setランク基準金額1(Decimal.ONE);
//        gaku.setランク基準金額2(Decimal.ONE);
//        gaku.setランク基準金額3(Decimal.ONE);
        ランク別制御情報.put(new RString("1"), gaku);
        ランク別制御情報.put(new RString("2"), gaku);
        NengakuFukaKonkyoFactory nengakuFukaKonkyoFactory = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
        NengakuSeigyoJoho 年額制御情報 = nengakuFukaKonkyoFactory.createNengakuSeigyoJoho(
                端数単位,
                HasuChoseiHoho.toValue(端数調整方法),
                端数単位_ランク用,
                HasuChoseiHoho.toValue(端数調整方法_ランク用),
                HasuChoseiTaisho.toValue(端数調整対象),
                ランク別制御情報);
        return 年額制御情報;
    }

}
