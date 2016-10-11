/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuchokarisanteifukabatch;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課計算のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class FuchoKariSanteiFukaBatch {

    private static final RString 区分_新規 = new RString("1");
    private static final RString 仮算定端数調整有無_あり = new RString("1");
    private static final RString 仮算定端数調整有無_なし = new RString("2");
    private static final RString 仮算定賦課方法_02 = new RString("02");
    private static final RString 仮算定賦課方法_03 = new RString("03");
    private static final RString 仮算定賦課方法_04 = new RString("04");
    private static final RString 仮算定賦課方法_05 = new RString("05");
    private static final RString 仮算定賦課方法_10 = new RString("10");
    private static final RString 仮算定賦課方法_11 = new RString("11");
    private static final int NUM_1 = 1;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_31 = 31;
    private static final int NUM_100 = 100;

    /**
     * にて生成した{@link CreatFukaEntity}のインスタンスを返します。
     *
     * @return CreatFukaEntity
     */
    public static FuchoKariSanteiFukaBatch createInstance() {
        return InstanceProvider.create(FuchoKariSanteiFukaBatch.class);
    }

    /**
     * 賦課の情報共通編集です。
     *
     * @param 調定年度 調定年度
     * @param 資格情報 資格情報
     * @param 徴収方法 徴収方法
     * @param 生保の情報 生保の情報
     * @param 老齢の情報 老齢の情報
     * @param 計算用保険料 計算用保険料
     * @param 区分 区分
     * @param 更正前賦課情報 更正前賦課情報
     * @param 前年度賦課情報 前年度賦課情報
     * @param 保険料段階_段階区分 保険料段階_段階区分
     * @param 口座Entity 口座Entity
     * @return {@link FukaJohoTempEntity}
     */
    public FukaJohoTempEntity 賦課通情報編集(FlexibleYear 調定年度, HihokenshaDaicho 資格情報, DbT2001ChoshuHohoEntity 徴収方法,
            List<SeikatsuHogoJukyusha> 生保の情報, List<RoreiFukushiNenkinJukyusha> 老齢の情報, Decimal 計算用保険料,
            RString 区分, FukaJohoTempEntity 更正前賦課情報, FukaJohoTempEntity 前年度賦課情報, RString 保険料段階_段階区分,
            TokuteiKozaRelateEntity 口座Entity) {
        FukaJohoTempEntity 賦課情報 = new FukaJohoTempEntity();
        賦課情報.setShikakuShutokuYMD(資格情報.get第1号資格取得年月日());
        賦課情報.setShikakuShutokuJiyu(資格情報.get資格取得事由コード());
        賦課情報.setShikakuSoshitsuYMD(資格情報.get資格喪失年月日());
        賦課情報.setShikakuSoshitsuJiyu(資格情報.get資格喪失事由コード());
        FlexibleDate 賦課年度開始日 = new FlexibleDate(調定年度.getYearValue(), NUM_4, NUM_1);
        FlexibleDate 賦課年度終了日 = new FlexibleDate(調定年度.getYearValue() + NUM_1, NUM_3, NUM_31);
        for (SeikatsuHogoJukyusha seikatsuHogoJukyusha : 生保の情報) {
            if (!賦課年度開始日.isBefore(seikatsuHogoJukyusha.get受給開始日()) && 賦課年度終了日.isBefore(seikatsuHogoJukyusha.get受給廃止日())) {
                賦課情報.setSeihofujoShurui(seikatsuHogoJukyusha.get受給者番号()); ///
                賦課情報.setSeihoKaishiYMD(seikatsuHogoJukyusha.get受給開始日());
                賦課情報.setSeihoHaishiYMD(seikatsuHogoJukyusha.get受給廃止日());
            }
        }
        for (RoreiFukushiNenkinJukyusha roreiFukushiNenkinJukyusha : 老齢の情報) {
            if (!賦課年度開始日.isBefore(roreiFukushiNenkinJukyusha.get受給開始年月日())
                    && 賦課年度終了日.isBefore(roreiFukushiNenkinJukyusha.get受給終了年月日())) {
                賦課情報.setRonenKaishiYMD(roreiFukushiNenkinJukyusha.get受給開始年月日());
                賦課情報.setRonenHaishiYMD(roreiFukushiNenkinJukyusha.get受給終了年月日());
            }
        }
        KoseiTsukiHantei koseiTsukiHantei = new KoseiTsukiHantei();
        Kitsuki 期月 = koseiTsukiHantei.find更正月(RDate.getNowDate());
        賦課情報.setKoseiM(期月.get月().getコード());
        FukaKeisan 賦課の計算 = FukaKeisan.createInstance();
        賦課情報.setFukaYMD(賦課の計算.findOut賦課基準日(調定年度, 資格情報));

        賦課情報.setHokenryoDankai(保険料段階_段階区分);
        if (資格情報.get旧市町村コード() != null && !資格情報.get旧市町村コード().isEmpty()) {
            賦課情報.setFukaShichosonCode(資格情報.get旧市町村コード());
        } else if (資格情報.get広住特措置元市町村コード() != null
                && !資格情報.get広住特措置元市町村コード().isEmpty()) {
            賦課情報.setFukaShichosonCode(資格情報.get広住特措置元市町村コード());
        } else {
            賦課情報.setFukaShichosonCode(資格情報.get市町村コード());
        }

        List<Decimal> 普徴期別金額リスト = 調定計算(更正前賦課情報, 計算用保険料, 区分);
        賦課情報.setFuKibetsuGaku01(普徴期別金額リスト.get(0));
        賦課情報.setFuKibetsuGaku02(普徴期別金額リスト.get(1));
        賦課情報.setFuKibetsuGaku03(普徴期別金額リスト.get(2));
        return 賦課情報;
    }

    private List<Decimal> 調定計算(FukaJohoTempEntity 更正前賦課情報, Decimal 計算用保険料, RString 区分) {
        List<Decimal> 普徴期別金額リスト = new ArrayList<>();
        Decimal 金額リスト0 = Decimal.ZERO;
        Decimal 金額リスト1 = Decimal.ZERO;
        FlexibleYear 調定年度 = 更正前賦課情報.getChoteiNendo();
        RString 仮算定端数調整有無 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定端数調整有無, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (区分_新規.equals(区分)) {
            FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(調定年度);
            KitsukiList 期月リスト = 月期対応取得_普徴.get期月リスト();
            int 期 = 期月リスト.filtered仮算定期間().toList().size();
            int 納期数 = 0;
            RString 仮算定賦課 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            RString 仮算定賦課方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);

            if (仮算定賦課方法_02.equals(仮算定賦課方法) || 仮算定賦課方法_04.equals(仮算定賦課方法)
                    || 仮算定賦課方法_10.equals(仮算定賦課方法) || 仮算定賦課方法_11.equals(仮算定賦課方法)) {
                納期数 = 期月リスト.get最終法定納期().get期AsInt();
            } else if (仮算定賦課方法_03.equals(仮算定賦課方法) || 仮算定賦課方法_05.equals(仮算定賦課方法)) {
                月期対応取得_普徴 = new FuchoKiUtil(調定年度.minusYear(1));
                期月リスト = 月期対応取得_普徴.get期月リスト();
                納期数 = 期月リスト.get最終法定納期().get期AsInt();
            }

            if (仮算定賦課方法_02.equals(仮算定賦課方法)) {
                Decimal 期別端数 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数, RDate.getNowDate(),
                        SubGyomuCode.DBB介護賦課).toString());
                Decimal 期別納付額_端数調整 = 計算用保険料.divide(期別端数).roundDownTo(0).multiply(期別端数);
                金額リスト0 = 仮算定端数調整有無_あり.equals(仮算定端数調整有無) ? 計算用保険料.roundDownTo(0) : 期別納付額_端数調整;
                金額リスト1 = 期別納付額_端数調整;
            } else {
                Decimal 納付額 = 計算用保険料.multiply(期).divide(納期数);
                Decimal 期別納付額 = 納付額.divide(期);
                Decimal 期別納付額_端数調整 = 期別納付額;
                金額リスト0 = 仮算定端数調整有無_あり.equals(仮算定端数調整有無)
                        ? 期別納付額_端数調整.add(納付額).subtract(期別納付額_端数調整.multiply(期)) : 期別納付額_端数調整;
                金額リスト1 = 期別納付額_端数調整;
            }
        } else {
            Decimal 期別特徴金額 = 計算用保険料.divide(NUM_6).divide(NUM_100).roundDownTo(0).multiply(NUM_100);
            Decimal 後半特徴金額 = 期別特徴金額.multiply(NUM_3);
            Decimal 六月より前の普徴仮算定金額 = 計算用保険料.subtract(更正前賦課情報.getTkKibetsuGaku02().
                    add(更正前賦課情報.getTkKibetsuGaku03()).subtract(後半特徴金額));
            FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(調定年度);
            KitsukiList 期月リスト = 月期対応取得_普徴.get期月リスト();
            List<Kitsuki> 期月 = 期月リスト.filtered仮算定期間().toList();
            Decimal 六月より前仮期数 = Decimal.ZERO;
            for (Kitsuki 仮算定期間 : 期月) {
                if (仮算定期間.get月AsInt() < NUM_6 && NUM_3 < 仮算定期間.get月AsInt()) {
                    六月より前仮期数 = 六月より前仮期数.add(Decimal.ONE);
                }
            }
            Decimal 期別納付額 = 六月より前の普徴仮算定金額.divide(六月より前仮期数);
            Decimal 期別端数 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数, RDate.getNowDate(),
                    SubGyomuCode.DBB介護賦課).toString());
            Decimal 期別納付額_端数調整 = 計算用保険料.divide(期別端数).roundDownTo(0).multiply(期別端数);
            if (仮算定端数調整有無_あり.equals(仮算定端数調整有無)) {
                金額リスト0 = 期別納付額_端数調整.add(六月より前の普徴仮算定金額).subtract(期別納付額_端数調整.multiply(六月より前仮期数));
                金額リスト1 = 期別納付額_端数調整;
            } else if (仮算定端数調整有無_なし.equals(仮算定端数調整有無)) {
                金額リスト0 = 期別納付額_端数調整;
                金額リスト1 = 期別納付額_端数調整;
            }
        }
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(調定年度);
        KitsukiList 期月リスト = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 期月 = 期月リスト.filtered仮算定期間().toList();
        if (期月.get(0).get月AsInt() == NUM_4) {
            普徴期別金額リスト.add(金額リスト0);
            普徴期別金額リスト.add(金額リスト1);
            普徴期別金額リスト.add(金額リスト1);
        } else if (期月.get(0).get月AsInt() == NUM_5) {
            普徴期別金額リスト.add(金額リスト0);
            普徴期別金額リスト.add(金額リスト1);
            普徴期別金額リスト.add(Decimal.ZERO);
        }
        return 普徴期別金額リスト;
    }

}
