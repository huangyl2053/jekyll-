package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.ca.cax.business.core.chotei.choteikyotsu.Chotei;
import jp.co.ndensan.reams.ca.cax.business.core.chotei.choteikyotsu.ChoteiFactory;
import jp.co.ndensan.reams.ca.cax.business.core.shunokanri.shunokanri.ShunoKanri;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.ShunoShoriJokyo;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.chotei.ChoteiJiyu;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.chotei.FukaShoriJokyo;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.ShunoService;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.shuno.ShunoManager;
import jp.co.ndensan.reams.ca.cax.service.saiban.ChoteiSaiban;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajohotoroku.FukaJohoTorokuMybatisParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fukajohotoroku.IFukaJohoTorokuMapper;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.JigyoKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.code.RyokinShubetsuCodeValue;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課を管理するクラスです。
 *
 * @reamsid_L DBB-9040-090 wangxiaodong
 */
public class FukaManager {

    private static final int 最後の期_過年度 = new KanendoKiUtil().get期月リスト().getLast().get期AsInt();
    private static final RString メソッド_普徴期別金額 = new RString("get普徴期別金額");
    private static final RString 処理名 = new RString("本算定賦課");
    private static final int 納期_2 = 2;
    private static final int 納期_3 = 3;
    private static final int 納期_4 = 4;
    private static final int 納期_5 = 5;
    private static final int 納期_6 = 6;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;
    private final List<RString> 全て期;
    private final IShunoKamoku 科目_普通徴収;
    private final IShunoKamoku 科目_特別徴収;
    private final FukaNokiResearcher 賦課納期取得;
    private final ShunoManager shunoManager;
    private final IFukaJohoTorokuMapper mapper;

    /**
     * コンストラクタです。
     */
    FukaManager() {
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.mapper = InstanceProvider.create(MapperProvider.class).create(IFukaJohoTorokuMapper.class);
        this.介護期別Manager = new KibetsuManager();
        全て期 = get全て期();
        ShunoKamokuFinder manager = ShunoKamokuFinder.createInstance();
        科目_普通徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        科目_特別徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        賦課納期取得 = FukaNokiResearcher.createInstance();
        shunoManager = ShunoService.get収納Manager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 介護賦課Dac 介護賦課Dac
     * @param 介護期別Manager 介護期別Manager
     */
    FukaManager(DbT2002FukaDac 介護賦課Dac, KibetsuManager 介護期別Manager, MapperProvider mapperProvider) {
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
        this.mapper = mapperProvider.create(IFukaJohoTorokuMapper.class);
        全て期 = get全て期();
        ShunoKamokuFinder manager = ShunoKamokuFinder.createInstance();
        科目_普通徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        科目_特別徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        賦課納期取得 = FukaNokiResearcher.createInstance();
        shunoManager = ShunoService.get収納Manager();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンス
     */
    public static FukaManager createInstance() {
        return InstanceProvider.create(FukaManager.class);
    }

    /**
     * 介護賦課を保存します。
     *
     * @param 介護賦課 介護賦課
     */
    @Transaction
    public void save賦課(FukaJoho 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));
        FukaJohoTorokuMybatisParameter parameter = getMybatisParameter(介護賦課);
        if (介護賦課.get賦課年度().equals(介護賦課.get調定年度())) {
            KitsukiList 月期対応取得_普徴 = new FuchoKiUtil(介護賦課.get賦課年度()).get期月リスト();
            List<DbT7022ShoriDateKanriEntity> 処理日付情報 = mapper.getSyoriDateForManager(parameter);
            YMDHMS 処理日時 = get処理日時(処理日付情報, 介護賦課.get賦課年度());
            YMDHMS 調定日時 = 介護賦課.get調定日時();
            if (処理日時 == null || 処理日時.isEmpty() || (調定日時 != null && 調定日時.isBefore(処理日時))) {
                save仮算定データ(介護賦課, 月期対応取得_普徴, parameter);
            } else {
                save特徴期別(介護賦課, parameter);
                save普徴期別金額By最後の期(介護賦課, 月期対応取得_普徴.getLast().get期AsInt(), parameter);
            }
        } else {
            save普徴期別金額By最後の期(介護賦課, 最後の期_過年度, parameter);
        }
        DbT2002FukaEntity 介護賦課Entity = 介護賦課.toEntity();
        介護賦課Entity.setState(EntityDataState.Added);
        介護賦課Dac.save(介護賦課Entity);
    }

    private void save仮算定データ(FukaJoho 賦課情報, KitsukiList 月期対応取得_普徴, FukaJohoTorokuMybatisParameter parameter) {
        save特徴期別01まで特徴期別03(賦課情報, parameter);
        for (Kitsuki 期月 : 月期対応取得_普徴.filtered仮算定期間().toList()) {
            int 期別 = 期月.get期AsInt();
            if (0 < 期別) {
                Decimal 期別金額 = get期別金額By期(賦課情報, 期月.get期());
                if (期別金額 != null) {
                    save介護期別(賦課情報, 科目_普通徴収, ChoshuHohoKibetsu.普通徴収,
                            parameter, 期別金額, 賦課納期取得.get普徴納期(期別).get納期限(), 期別);
                }
            }
        }
    }

    private void save特徴期別01まで特徴期別03(FukaJoho 賦課情報, FukaJohoTorokuMybatisParameter parameter) {
        if (賦課情報.get特徴期別金額01() != null) {
            save介護期別(賦課情報, 科目_特別徴収, ChoshuHohoKibetsu.特別徴収, parameter,
                    賦課情報.get特徴期別金額01(), 賦課納期取得.get特徴納期(1).get納期限(), 1);
        }
        if (賦課情報.get特徴期別金額02() != null) {
            save介護期別(賦課情報, 科目_特別徴収, ChoshuHohoKibetsu.特別徴収, parameter,
                    賦課情報.get特徴期別金額02(), 賦課納期取得.get特徴納期(納期_2).get納期限(), 納期_2);
        }
        if (賦課情報.get特徴期別金額03() != null) {
            save介護期別(賦課情報, 科目_特別徴収, ChoshuHohoKibetsu.特別徴収, parameter,
                    賦課情報.get特徴期別金額03(), 賦課納期取得.get特徴納期(納期_3).get納期限(), 納期_3);
        }
    }

    private void save特徴期別(FukaJoho 賦課情報, FukaJohoTorokuMybatisParameter parameter) {
        save特徴期別01まで特徴期別03(賦課情報, parameter);
        if (賦課情報.get特徴期別金額04() != null) {
            save介護期別(賦課情報, 科目_特別徴収, ChoshuHohoKibetsu.特別徴収, parameter,
                    賦課情報.get特徴期別金額04(), 賦課納期取得.get特徴納期(納期_4).get納期限(), 納期_4);
        }
        if (賦課情報.get特徴期別金額05() != null) {
            save介護期別(賦課情報, 科目_特別徴収, ChoshuHohoKibetsu.特別徴収, parameter,
                    賦課情報.get特徴期別金額05(), 賦課納期取得.get特徴納期(納期_5).get納期限(), 納期_5);
        }
        if (賦課情報.get特徴期別金額06() != null) {
            save介護期別(賦課情報, 科目_特別徴収, ChoshuHohoKibetsu.特別徴収, parameter,
                    賦課情報.get特徴期別金額06(), 賦課納期取得.get特徴納期(納期_6).get納期限(), 納期_6);
        }
    }

    private void save普徴期別金額By最後の期(FukaJoho 賦課情報, int 最後の期, FukaJohoTorokuMybatisParameter parameter) {
        for (RString 期別 : 全て期) {
            int 期 = Integer.parseInt(期別.toString());
            if (期 <= 最後の期) {
                Decimal 期別金額 = get期別金額By期(賦課情報, 期別);
                if (期別金額 != null) {
                    save介護期別(賦課情報, 科目_普通徴収, ChoshuHohoKibetsu.普通徴収,
                            parameter, 期別金額, 賦課納期取得.get普徴納期(期).get納期限(), 期);
                }
            }
        }
    }

    private Decimal get期別金額By期(FukaJoho 賦課情報, RString 期) {
        Class clazz = 賦課情報.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(メソッド_普徴期別金額.concat(期).toString());
            return (Decimal) getMethod.invoke(賦課情報);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void save介護期別(FukaJoho 介護賦課, IShunoKamoku 科目, ChoshuHohoKibetsu 徴収種別,
            FukaJohoTorokuMybatisParameter parameter, Decimal 調定額, RDate 納期限, int 期) {
        parameter.setChoshuHouhou(徴収種別.getコード());
        parameter.setKi(期);
        boolean is収納管理マスタ存在;
        long 収納ID;
        UrT0705ChoteiKyotsuEntity 調定共通 = mapper.getChoteiKyotsuByFukaJoho(parameter);
        if (調定共通 != null) {
            is収納管理マスタ存在 = true;
            収納ID = 調定共通.getShunoId();
        } else {
            is収納管理マスタ存在 = false;
            収納ID = 0L;
        }
        ShunoKanri 収納管理 = get収納管理(介護賦課, 科目, 期, 収納ID);
        if (!is収納管理マスタ存在) {
            shunoManager.save収納管理(収納管理);
        }
        long 調定ID = ChoteiSaiban.getNumbering調定ID();
        shunoManager.save調定(収納管理, get調定クラス(介護賦課.get調定年度(), 調定額, 納期限, 調定ID, 収納ID, 納期限, 収納管理));
        介護期別Manager.save介護期別(new Kibetsu(介護賦課.get調定年度(), 介護賦課.get賦課年度(),
                介護賦課.get通知書番号(), 介護賦課.get履歴番号(), 徴収種別.getコード(), 期)
                .createBuilderForEdit().set調定ID(new Decimal(調定ID)).build());
    }

    private YMDHMS get処理日時(List<DbT7022ShoriDateKanriEntity> 処理日付情報, FlexibleYear 賦課年度) {
        for (DbT7022ShoriDateKanriEntity shoriDate : 処理日付情報) {
            if (shoriDate.getNendo().equals(賦課年度)) {
                return shoriDate.getKijunTimestamp();
            }
        }
        return null;
    }

    private Chotei get調定クラス(FlexibleYear 調定年度, Decimal 調定額, RDate 納期限,
            long 調定ID, long 収納ID, RDate 調定年月日, ShunoKanri 収納管理) {
        return ChoteiFactory.createChoteiInstanceParamChoteiId(
                調定ID, new RYear(調定年度.getYearValue()), 0, ChoteiJiyu.更正その他, 調定年月日, 調定額,
                Decimal.ZERO, 納期限, FukaShoriJokyo.保留中, ShunoShoriJokyo.未取込, Collections.EMPTY_LIST, 収納管理)
                .createBuilderForEdit()
                .set処理年度(new RYear(調定年度.getYearValue()))
                .set収納ID(収納ID)
                .set処理番号(0).build();
    }

    private ShunoKanri get収納管理(FukaJoho 介護賦課, IShunoKamoku 科目, int 期, long 収納ID) {
        return new ShunoKanri(収納ID,
                科目.getコード(),
                科目.get枝番コード(),
                new RyokinShubetsuCodeValue(RString.EMPTY),
                JigyoKubun.未使用.getJigyoKubunCd(),
                new RYear(介護賦課.get調定年度().toString()),
                new RYear(介護賦課.get賦課年度().toString()),
                new TsuchishoNo(new Decimal(介護賦課.get通知書番号().toString())),
                期, true, 0).createBuilderForEdit().set識別コード(介護賦課.get識別コード()).build();
    }

    private FukaJohoTorokuMybatisParameter getMybatisParameter(FukaJoho 介護賦課) {
        FukaJohoTorokuMybatisParameter parameter = new FukaJohoTorokuMybatisParameter();
        parameter.setSyoriName(処理名);
        parameter.setNendo(介護賦課.get賦課年度());
        parameter.setChoteiNendo(介護賦課.get調定年度());
        parameter.setFukaNendo(介護賦課.get賦課年度());
        parameter.setTsuchishoNo(介護賦課.get通知書番号());
        return parameter;
    }

    private List<RString> get全て期() {
        List<RString> 期 = new ArrayList<>();
        期.add(new RString("01"));
        期.add(new RString("02"));
        期.add(new RString("03"));
        期.add(new RString("04"));
        期.add(new RString("05"));
        期.add(new RString("06"));
        期.add(new RString("07"));
        期.add(new RString("08"));
        期.add(new RString("09"));
        期.add(new RString("10"));
        期.add(new RString("11"));
        期.add(new RString("12"));
        期.add(new RString("13"));
        期.add(new RString("14"));
        return 期;
    }
}
