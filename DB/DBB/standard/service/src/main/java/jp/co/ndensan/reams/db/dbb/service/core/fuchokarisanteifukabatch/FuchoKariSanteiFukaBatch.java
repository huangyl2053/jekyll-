/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuchokarisanteifukabatch;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
    private static final RString 仮算定端数調整有無_なし = new RString("0");
    private static final RString 仮算定賦課方法_01 = new RString("01");
    private static final RString 仮算定賦課方法_02 = new RString("02");
    private static final RString 仮算定賦課方法_03 = new RString("03");
    private static final RString 仮算定賦課方法_04 = new RString("04");
    private static final RString 仮算定賦課方法_05 = new RString("05");
    private static final RString 仮算定賦課方法_06 = new RString("06");
    private static final RString 仮算定賦課方法_10 = new RString("10");
    private static final RString 仮算定賦課方法_11 = new RString("11");
    private static final RString 境界層区分_非該当 = new RString("0");
    private static final Decimal 月処理区分_5 = new Decimal("5");
    private static final int NUM_1 = 1;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
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
     * @param 通知書番号 通知書番号
     * @param 調定日時 調定日時
     * @return {@link FukaJohoTempEntity}
     */
    public FukaJohoTempEntity 賦課通情報編集(FlexibleYear 調定年度, HihokenshaDaicho 資格情報, DbT2001ChoshuHohoEntity 徴収方法,
            List<SeikatsuHogoJukyusha> 生保の情報, List<RoreiFukushiNenkinJukyusha> 老齢の情報, Decimal 計算用保険料,
            RString 区分, FukaJohoTempEntity 更正前賦課情報, FukaJohoTempEntity 前年度賦課情報, RString 保険料段階_段階区分,
            TokuteiKozaRelateEntity 口座Entity, TsuchishoNo 通知書番号, YMDHMS 調定日時) {
        FukaJohoTempEntity 賦課情報 = new FukaJohoTempEntity();
        賦課情報.setShikakuShutokuYMD(資格情報.get第1号資格取得年月日());
        賦課情報.setShikakuShutokuJiyu(資格情報.get資格取得事由コード());
        賦課情報.setShikakuSoshitsuYMD(資格情報.get資格喪失年月日());
        賦課情報.setShikakuSoshitsuJiyu(資格情報.get資格喪失事由コード());

        賦課情報.setSeihofujoShurui(RString.EMPTY);
        賦課情報.setSeihoKaishiYMD(FlexibleDate.EMPTY);
        賦課情報.setSeihoHaishiYMD(FlexibleDate.EMPTY);
        賦課情報.setRonenKaishiYMD(FlexibleDate.EMPTY);
        賦課情報.setRonenHaishiYMD(FlexibleDate.EMPTY);
        FlexibleDate 賦課年度開始日 = new FlexibleDate(調定年度.getYearValue(), NUM_4, NUM_1);
        FlexibleDate 賦課年度終了日 = new FlexibleDate(調定年度.getYearValue() + NUM_1, NUM_3, NUM_31);
        FlexibleDate 生保情報_受給開始日;
        FlexibleDate 生保情報_受給廃止日;
        FlexibleDate 最も新生保情報_受給開始日 = FlexibleDate.MIN;
        for (SeikatsuHogoJukyusha seikatsuHogoJukyusha : 生保の情報) {
            生保情報_受給開始日 = seikatsuHogoJukyusha.get受給開始日();
            生保情報_受給廃止日 = seikatsuHogoJukyusha.get受給廃止日() != null ? seikatsuHogoJukyusha.get受給廃止日() : FlexibleDate.MAX;
            if (((賦課年度開始日.isBefore(生保情報_受給開始日) && !賦課年度終了日.isBefore(生保情報_受給開始日))
                    || (賦課年度開始日.isBefore(生保情報_受給廃止日) && !賦課年度終了日.isBefore(生保情報_受給廃止日)))
                    && 最も新生保情報_受給開始日.isBefore(生保情報_受給開始日)) {
                RString 生活保護扶助種類 = seikatsuHogoJukyusha.getSeikatsuHogoFujoShuruiList().isEmpty() ? RString.EMPTY
                        : seikatsuHogoJukyusha.getSeikatsuHogoFujoShuruiList().get(0).get扶助種類コード().getColumnValue().getColumnValue();
                賦課情報.setSeihofujoShurui(生活保護扶助種類);
                賦課情報.setSeihoKaishiYMD(seikatsuHogoJukyusha.get受給開始日());
                賦課情報.setSeihoHaishiYMD(seikatsuHogoJukyusha.get受給廃止日());
                最も新生保情報_受給開始日 = 生保情報_受給開始日;
            }
        }
        FlexibleDate 老齢情報_受給開始日;
        FlexibleDate 老齢情報_受給廃止日;
        FlexibleDate 最も新老齢情報_受給開始日 = FlexibleDate.MIN;
        for (RoreiFukushiNenkinJukyusha roreiFukushiNenkinJukyusha : 老齢の情報) {
            老齢情報_受給開始日 = roreiFukushiNenkinJukyusha.get受給開始年月日();
            老齢情報_受給廃止日 = roreiFukushiNenkinJukyusha.get受給終了年月日() != null ? roreiFukushiNenkinJukyusha.get受給終了年月日()
                    : FlexibleDate.MAX;
            if (((賦課年度開始日.isBefore(老齢情報_受給開始日) && !賦課年度終了日.isBefore(老齢情報_受給開始日))
                    || (賦課年度開始日.isBefore(老齢情報_受給廃止日) && !賦課年度終了日.isBefore(老齢情報_受給廃止日)))
                    && 最も新老齢情報_受給開始日.isBefore(老齢情報_受給開始日)) {
                賦課情報.setRonenKaishiYMD(roreiFukushiNenkinJukyusha.get受給開始年月日());
                賦課情報.setRonenHaishiYMD(roreiFukushiNenkinJukyusha.get受給終了年月日());
                最も新老齢情報_受給開始日 = 老齢情報_受給開始日;
            }
        }
        賦課情報.setHokenryoDankaiKarisanntei(保険料段階_段階区分);
        return 賦課通情報編集Part2(賦課情報, 調定年度, 更正前賦課情報, 資格情報, 徴収方法, 通知書番号, 調定日時,
                計算用保険料, 区分, 口座Entity, 前年度賦課情報);
    }

    private FukaJohoTempEntity 賦課通情報編集Part2(FukaJohoTempEntity 賦課情報, FlexibleYear 調定年度, FukaJohoTempEntity 更正前賦課情報,
            HihokenshaDaicho 資格情報, DbT2001ChoshuHohoEntity 徴収方法, TsuchishoNo 通知書番号, YMDHMS 調定日時, Decimal 計算用保険料,
            RString 区分, TokuteiKozaRelateEntity 口座Entity, FukaJohoTempEntity 前年度賦課情報) {
        KoseiTsukiHantei koseiTsukiHantei = new KoseiTsukiHantei();
        Kitsuki 期月 = koseiTsukiHantei.find更正月(調定日時.getDate());
        賦課情報.setKoseiM(期月.get月().getコード());
        FukaKeisan 賦課の計算 = FukaKeisan.createInstance();
        賦課情報.setFukaYMD(賦課の計算.findOut賦課基準日(調定年度, 資格情報));
        if (資格情報.get旧市町村コード() != null && !資格情報.get旧市町村コード().isEmpty()) {
            賦課情報.setFukaShichosonCode(資格情報.get旧市町村コード());
        } else if (資格情報.get広住特措置元市町村コード() != null
                && !資格情報.get広住特措置元市町村コード().isEmpty()) {
            賦課情報.setFukaShichosonCode(資格情報.get広住特措置元市町村コード());
        } else {
            賦課情報.setFukaShichosonCode(資格情報.get市町村コード());
        }
        if (更正前賦課情報 != null && 更正前賦課情報.getTsuchishoNo() != null) {
            賦課情報.setChoteiNendo(更正前賦課情報.getChoteiNendo());
            賦課情報.setFukaNendo(更正前賦課情報.getFukaNendo());
            賦課情報.setRirekiNo(更正前賦課情報.getRirekiNo() + NUM_1);
            賦課情報.setHihokenshaNo(更正前賦課情報.getHihokenshaNo());
            賦課情報.setShikibetsuCode(更正前賦課情報.getShikibetsuCode());
            賦課情報.setSetaiCode(更正前賦課情報.getSetaiCode());
            賦課情報.setHokenryoDankaiKarisanntei(更正前賦課情報.getHokenryoDankaiKarisanntei());
            賦課情報.setTkKibetsuGaku01(更正前賦課情報.getTkKibetsuGaku01());
            賦課情報.setTkKibetsuGaku02(更正前賦課情報.getTkKibetsuGaku02());
            賦課情報.setTkKibetsuGaku03(更正前賦課情報.getTkKibetsuGaku03());
            賦課情報.setTkKibetsuGaku04(更正前賦課情報.getTkKibetsuGaku04());
            賦課情報.setTkKibetsuGaku05(更正前賦課情報.getTkKibetsuGaku05());
            賦課情報.setTkKibetsuGaku06(更正前賦課情報.getTkKibetsuGaku06());
        } else {
            賦課情報.setChoteiNendo(調定年度);
            賦課情報.setFukaNendo(調定年度);
            賦課情報.setRirekiNo(0);
            賦課情報.setHihokenshaNo(資格情報.get被保険者番号());
            賦課情報.setShikibetsuCode(資格情報.get識別コード());
            賦課情報.setTkKibetsuGaku01(Decimal.ZERO);
            賦課情報.setTkKibetsuGaku02(Decimal.ZERO);
            賦課情報.setTkKibetsuGaku03(Decimal.ZERO);
            賦課情報.setTkKibetsuGaku04(Decimal.ZERO);
            賦課情報.setTkKibetsuGaku05(Decimal.ZERO);
            賦課情報.setTkKibetsuGaku06(Decimal.ZERO);
        }
        賦課情報.setTsuchishoNo(通知書番号);
        賦課情報.setChoteiNichiji(調定日時);
        賦課情報.setIdoKijunNichiji(調定日時);
        賦課情報.setChoteiJiyu1(ChoteiJiyuCode.仮算定賦課.getコード());
        賦課情報.setChoshuHohoRirekiNo(徴収方法.getRirekiNo());
        賦課情報.setKyokaisoKubun(境界層区分_非該当);
        賦課情報.setFuKibetsuGaku01(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku02(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku03(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku04(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku05(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku06(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku07(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku08(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku09(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku10(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku11(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku12(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku13(Decimal.ZERO);
        賦課情報.setFuKibetsuGaku14(Decimal.ZERO);
        賦課情報.setFukaYMD(FukaKeisan.createInstance().findOut賦課基準日(調定年度, 資格情報));
        List<Decimal> 普徴期別金額リスト = 調定計算(調定年度, 更正前賦課情報, 計算用保険料, 区分, 前年度賦課情報);
        賦課情報.setFuKibetsuGaku01(普徴期別金額リスト.get(0));
        賦課情報.setFuKibetsuGaku02(普徴期別金額リスト.get(1));
        if (普徴期別金額リスト.size() == NUM_3) {
            賦課情報.setFuKibetsuGaku03(普徴期別金額リスト.get(2));
        }
        Decimal 普徴期別金額合計 = sum普徴期別金額(普徴期別金額リスト);
        if (0 < 普徴期別金額合計.intValue() && 口座Entity != null && 口座Entity.getUaT0310KozaEntity() != null
                && 口座Entity.getUaT0310KozaEntity().getKozaId() != 0L) {
            賦課情報.setKozaKubun(KozaKubun.口座振替.getコード());
        } else if (0 < 普徴期別金額合計.intValue() && (口座Entity == null || 口座Entity.getUaT0310KozaEntity() == null
                || 口座Entity.getUaT0310KozaEntity().getKozaId() == 0L)) {
            賦課情報.setKozaKubun(KozaKubun.現金納付.getコード());
        } else if (Decimal.ZERO.equals(普徴期別金額合計)) {
            賦課情報.setKozaKubun(KozaKubun.現金納付.getコード());
        }
        return 賦課情報;
    }

    private Decimal sum普徴期別金額(List<Decimal> 普徴期別金額リスト) {
        if (!普徴期別金額リスト.isEmpty()) {
            Decimal dec = Decimal.ZERO;
            for (Decimal decimal : 普徴期別金額リスト) {
                dec = dec.add(decimal);
            }
            return dec;
        }
        return Decimal.ZERO;
    }

    private List<Decimal> 調定計算(FlexibleYear 調定年度, FukaJohoTempEntity 更正前賦課情報, Decimal 計算用保険料, RString 区分, FukaJohoTempEntity 前年度賦課情報) {
        List<Decimal> 普徴期別金額リスト = new ArrayList<>();
        Decimal 金額リスト0 = Decimal.ZERO;
        Decimal 金額リスト1 = Decimal.ZERO;
        RDate 調定年度開始日 = new RDate(調定年度.getYearValue(), NUM_4, NUM_1);
        RDate 前年度開始日 = new RDate(調定年度.getYearValue() - NUM_1, NUM_4, NUM_1);
        RString 仮算定端数調整有無 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定端数調整有無, 調定年度開始日, SubGyomuCode.DBB介護賦課);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(調定年度);
        KitsukiList 期月リスト = 月期対応取得_普徴.get期月リスト();
        int 期 = 期月リスト.get最終法定納期().get期AsInt();
        if (区分_新規.equals(区分)) {
            int 納期数 = 0;
            RString 仮算定賦課方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法, 調定年度開始日, SubGyomuCode.DBB介護賦課);
            if (仮算定賦課方法_02.equals(仮算定賦課方法) || 仮算定賦課方法_04.equals(仮算定賦課方法)
                    || 仮算定賦課方法_10.equals(仮算定賦課方法) || 仮算定賦課方法_11.equals(仮算定賦課方法)) {
                納期数 = 期月リスト.get最終法定納期().get期AsInt();
            } else if (仮算定賦課方法_03.equals(仮算定賦課方法) || 仮算定賦課方法_05.equals(仮算定賦課方法)) {
                月期対応取得_普徴 = new FuchoKiUtil(調定年度.minusYear(1));
                期月リスト = 月期対応取得_普徴.get期月リスト();
                納期数 = 期月リスト.get最終法定納期().get期AsInt();
            } else if (仮算定賦課方法_06.equals(仮算定賦課方法)) {
                納期数 = get賦課納期数(納期数, 前年度開始日, 前年度賦課情報, 期, 期月リスト);
            }
            if (仮算定賦課方法_01.equals(仮算定賦課方法)) {
                Decimal 期別端数 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数, 調定年度開始日,
                        SubGyomuCode.DBB介護賦課).toString());
                Decimal 期別納付額_端数調整 = 計算用保険料.divide(期別端数).roundDownTo(0).multiply(期別端数);
                金額リスト0 = 仮算定端数調整有無_あり.equals(仮算定端数調整有無) ? 計算用保険料.roundDownTo(0) : 期別納付額_端数調整;
                金額リスト1 = 期別納付額_端数調整;
            } else {
                Decimal 納付額 = 計算用保険料.multiply(期).divide(納期数).roundDownTo(0);
                Decimal 期別納付額 = 納付額.divide(期).roundDownTo(0);
                Decimal 期別納付額_端数調整 = 期別納付額;
                金額リスト0 = 仮算定端数調整有無_あり.equals(仮算定端数調整有無)
                        ? 期別納付額_端数調整.add(納付額).subtract(期別納付額_端数調整.multiply(期)) : 期別納付額_端数調整;
                金額リスト1 = 期別納付額_端数調整;
            }
        } else {
            Decimal 期別特徴金額 = 計算用保険料.divide(NUM_6).divide(NUM_100).roundDownTo(0).multiply(NUM_100);
            Decimal 後半特徴金額 = 期別特徴金額.multiply(NUM_3);
            Decimal 特徴期別金額02 = 更正前賦課情報.getTkKibetsuGaku02() == null ? Decimal.ZERO : 更正前賦課情報.getTkKibetsuGaku02();
            Decimal 特徴期別金額03 = 更正前賦課情報.getTkKibetsuGaku03() == null ? Decimal.ZERO : 更正前賦課情報.getTkKibetsuGaku03();
            Decimal 六月より前の普徴仮算定金額 = 計算用保険料.subtract(特徴期別金額02.
                    add(特徴期別金額03).subtract(後半特徴金額));
            List<Kitsuki> 期月 = 期月リスト.filtered仮算定期間().toList();
            Decimal 六月より前仮期数 = Decimal.ZERO;
            for (Kitsuki 仮算定期間 : 期月) {
                if (仮算定期間.get月AsInt() < NUM_6 && NUM_3 < 仮算定期間.get月AsInt()) {
                    六月より前仮期数 = 六月より前仮期数.add(Decimal.ONE);
                }
            }
            Decimal 期別納付額 = 六月より前の普徴仮算定金額.divide(六月より前仮期数);
            Decimal 期別端数 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数, 調定年度開始日,
                    SubGyomuCode.DBB介護賦課).toString());
            Decimal 期別納付額_端数調整 = 期別納付額.divide(期別端数).roundDownTo(0).multiply(期別端数);
            if (仮算定端数調整有無_あり.equals(仮算定端数調整有無)) {
                金額リスト0 = 期別納付額_端数調整.add(六月より前の普徴仮算定金額).subtract(期別納付額_端数調整.multiply(六月より前仮期数));
                金額リスト1 = 期別納付額_端数調整;
            } else if (仮算定端数調整有無_なし.equals(仮算定端数調整有無)) {
                金額リスト0 = 期別納付額_端数調整;
                金額リスト1 = 期別納付額_端数調整;
            }
        }
        普徴期別金額リスト = set普徴期別金額リスト(普徴期別金額リスト, 期月リスト, 期, 金額リスト0, 金額リスト1);
        return 普徴期別金額リスト;
    }

    private List<Decimal> set普徴期別金額リスト(List<Decimal> 普徴期別金額リスト, KitsukiList 期月リスト, int 期,
            Decimal 金額リスト0, Decimal 金額リスト1) {
        List<Kitsuki> 期月 = 期月リスト.filtered仮算定期間().toList();
        if (期月.get(0).get月AsInt() == NUM_4) {
            普徴期別金額リスト.add(金額リスト0);
            普徴期別金額リスト.add(金額リスト1);
            if (期 == NUM_3) {
                普徴期別金額リスト.add(金額リスト1);
            }
        } else {
            普徴期別金額リスト.add(金額リスト0);
            普徴期別金額リスト.add(金額リスト1);
            if (期 == NUM_3) {
                普徴期別金額リスト.add(金額リスト1);
            }
        }
        return 普徴期別金額リスト;
    }

    private int get賦課納期数(int 納期数, RDate 調定年度開始日, FukaJohoTempEntity 前年度賦課情報, int 期, KitsukiList 期月リスト) {
        List<RString> 月処理区分list = new ArrayList<>();
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分1, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分2, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分3, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分4, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分5, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分6, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分7, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分8, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分9, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分10, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分11, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分12, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分13, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分14, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        List<Decimal> 普徴期別金額list = new ArrayList<>();
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku01());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku02());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku03());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku04());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku05());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku06());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku07());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku08());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku09());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku10());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku11());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku12());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku13());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku14());
        for (int i = 1; i <= 期; i++) {
            boolean flag = false;
            for (Kitsuki kitsuki : 期月リスト.get期の月(i)) {
                int 月 = kitsuki.get月AsInt();
                Decimal 月処理区分 = new Decimal(月処理区分list.get(月 - 1).toString());
                Decimal 普徴期別金額 = 普徴期別金額list.get(i - 1) == null ? Decimal.ZERO : 普徴期別金額list.get(i - 1);
                if (月処理区分.compareTo(月処理区分_5) <= 0
                        && 普徴期別金額.compareTo(Decimal.ZERO) > 0) {
                    flag = true;
                }
            }
            if (flag) {
                納期数++;
            }
        }
        return 納期数;
    }
}
