package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKanri;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKey;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.chotei.Chotei;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.ShunoShoriJokyo;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.chotei.ChoteiJiyu;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.chotei.FukaShoriJokyo;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.chotei.SaibanKeysChotei;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.ShunoManager;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokitsuki.Nokitsuki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.JigyoKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.code.RyokinShubetsuCodeValue;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課を管理するクラスです。
 *
 * @reamsid_L DBB-9040-090 wangxiaodong
 */
public class FukaManager {

    private static final int 納期_2 = 2;
    private static final int 納期_3 = 3;
    private static final int 納期_4 = 4;
    private static final int 納期_5 = 5;
    private static final int 納期_6 = 6;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;

    /**
     * コンストラクタです。
     */
    FukaManager() {
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.介護期別Manager = new KibetsuManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 介護賦課Dac 介護賦課Dac
     * @param 介護期別Manager 介護期別Manager
     */
    FukaManager(DbT2002FukaDac 介護賦課Dac, KibetsuManager 介護期別Manager) {
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
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
        ShunoManager shunoManager = new ShunoManager();
        ShunoKamokuFinder shunoKamokuManager = ShunoKamokuFinder.createInstance();
        FukaNokiResearcher 納期 = FukaNokiResearcher.createInstance();
        save介護期別By特別徴収(介護賦課, shunoKamokuManager, shunoManager, 納期);
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト();
        save介護期別By普通徴収07期(介護賦課, shunoKamokuManager, shunoManager, 納期, 期月リスト);
        save介護期別By普通徴収14期(介護賦課, shunoKamokuManager, shunoManager, 納期, 期月リスト);
        DbT2002FukaEntity 介護賦課Entity = 介護賦課.toEntity();
        介護賦課Entity.setState(EntityDataState.Added);
        介護賦課Dac.save(介護賦課Entity);
    }

    private void save介護期別By特別徴収(FukaJoho 介護賦課,
            ShunoKamokuFinder shunoKamokuManager,
            ShunoManager shunoManager,
            FukaNokiResearcher 納期) {
        if (介護賦課.get特徴期別金額01() != null && Decimal.ZERO.compareTo(介護賦課.get特徴期別金額01()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.特別徴収,
                    介護賦課.get特徴期別金額01(), 納期.get特徴納期(1).get納期限(), 1);
        }
        if (介護賦課.get特徴期別金額02() != null && Decimal.ZERO.compareTo(介護賦課.get特徴期別金額02()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.特別徴収,
                    介護賦課.get特徴期別金額02(), 納期.get特徴納期(納期_2).get納期限(), 納期_2);
        }
        if (介護賦課.get特徴期別金額03() != null && Decimal.ZERO.compareTo(介護賦課.get特徴期別金額03()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.特別徴収,
                    介護賦課.get特徴期別金額03(), 納期.get特徴納期(納期_3).get納期限(), 納期_3);
        }
        if (介護賦課.get特徴期別金額04() != null && Decimal.ZERO.compareTo(介護賦課.get特徴期別金額04()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.特別徴収,
                    介護賦課.get特徴期別金額04(), 納期.get特徴納期(納期_4).get納期限(), 納期_4);
        }
        if (介護賦課.get特徴期別金額05() != null && Decimal.ZERO.compareTo(介護賦課.get特徴期別金額05()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.特別徴収,
                    介護賦課.get特徴期別金額05(), 納期.get特徴納期(納期_5).get納期限(), 納期_5);
        }
        if (介護賦課.get特徴期別金額06() != null && Decimal.ZERO.compareTo(介護賦課.get特徴期別金額06()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.特別徴収,
                    介護賦課.get特徴期別金額06(), 納期.get特徴納期(納期_6).get納期限(), 納期_6);
        }

    }

    private void save介護期別By普通徴収07期(FukaJoho 介護賦課,
            ShunoKamokuFinder shunoKamokuManager,
            ShunoManager shunoManager,
            FukaNokiResearcher 納期,
            KitsukiList 期月リスト) {
        if (介護賦課.get普徴期別金額01() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額01()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額01(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._4月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._4月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額02() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額02()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額02(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._5月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._5月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額03() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額03()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額03(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._6月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._6月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額04() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額04()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額02(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._7月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._7月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額05() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額05()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額05(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._8月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._8月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額06() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額06()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額06(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._9月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._9月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額07() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額07()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額07(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._10月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._10月).get期AsInt());
        }
    }

    private void save介護期別By普通徴収14期(FukaJoho 介護賦課,
            ShunoKamokuFinder shunoKamokuManager,
            ShunoManager shunoManager,
            FukaNokiResearcher 納期,
            KitsukiList 期月リスト) {
        if (介護賦課.get普徴期別金額08() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額08()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額08(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._11月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._11月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額09() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額09()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額09(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._12月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._12月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額10() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額10()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額10(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._1月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._1月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額11() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額11()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額11(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._2月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._2月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額12() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額12()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額12(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki._3月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki._3月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額13() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額13()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額13(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki.翌年度4月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki.翌年度4月).get期AsInt());
        }
        if (介護賦課.get普徴期別金額14() != null && Decimal.ZERO.compareTo(介護賦課.get普徴期別金額14()) < 0) {
            save介護期別(shunoManager, shunoKamokuManager, 介護賦課, ChoshuHohoKibetsu.普通徴収, 介護賦課.get普徴期別金額14(),
                    納期.get普徴納期(期月リスト.get月の期(Tsuki.翌年度5月).get期AsInt()).get納期限(), 期月リスト.get月の期(Tsuki.翌年度5月).get期AsInt());
        }
    }

    private void save介護期別(ShunoManager shunoManager,
            ShunoKamokuFinder shunoKamokuManager,
            FukaJoho 介護賦課,
            ChoshuHohoKibetsu 徴収種別,
            Decimal 調定額,
            RDate 納期限,
            int 期) {
        IShunoKamoku 科目 = shunoKamokuManager.get科目(徴収種別.equals(ChoshuHohoKibetsu.普通徴収)
                ? ShunoKamokuShubetsu.介護保険料_普通徴収 : ShunoKamokuShubetsu.介護保険料_特別徴収);
        shunoManager.save調定(get収納キークラス(介護賦課, 科目, 期),
                get調定クラス(介護賦課.get調定年度(), 調定額, 納期限, 科目));
        介護期別Manager.save介護期別(new Kibetsu(介護賦課.get調定年度(), 介護賦課.get賦課年度(),
                介護賦課.get通知書番号(), 介護賦課.get履歴番号(), 徴収種別.getコード(), 期));
    }

    private ShunoKey get収納キークラス(FukaJoho 介護賦課, IShunoKamoku 科目, int 期) {
        return new ShunoKey(get収納管理(介護賦課, 科目, 期), 科目, get納期月(科目, 期));
    }

    private Chotei get調定クラス(FlexibleYear 調定年度, Decimal 調定額, RDate 納期限, IShunoKamoku 科目) {
        Chotei.Builder builder = Chotei.newBuilder();
        long id = Saiban.get(SubGyomuCode.CAX収滞公開, new RString(SaibanKeysChotei.調定ID.name())).next();
        builder.set調定ID(id);
        builder.set調定状況ID(id);
        builder.set科目コード(科目.getコード());
        builder.set科目枝番コード(科目.get枝番コード());
        builder.set料金種別コード(new RyokinShubetsuCodeValue(RString.EMPTY));
        builder.set事業区分(JigyoKubun.未使用);
        // TODO QA#89276 回答待ち。DBはNOT NULL COLUMN ですが、対応する項目は設定しない、DBにINSERTする場合、エラーが発生しました。
        // rshare."UrT0707ChoteiJokyo" NOT NULL
        // builder.set調定状況ID
        // builder.set収納処理状況
        // builder.set合計件数
        // builder.set合計金額
        // builder.set調定年月日
        builder.set収納処理状況(ShunoShoriJokyo.未取込);
        builder.set合計件数(0);
        builder.set合計金額(Decimal.ZERO);
        builder.set調定年月日(RDate.getNowDate());
        builder.set収納ID(0L);
        builder.set更正回数(0);
        builder.set会計年度(new RYear(調定年度.getYearValue()));
        builder.set調定事由コード(ChoteiJiyu.更正その他);
        builder.set調定額(調定額);
        builder.set消費税額(Decimal.ZERO);
        builder.set納期限(納期限);
        builder.set賦課処理状況(FukaShoriJokyo.保留中);
        return builder.build();
    }

    private ShunoKanri get収納管理(FukaJoho 介護賦課, IShunoKamoku 科目, int 期) {
        ShunoKanri.Builder builder = ShunoKanri.newBuilder();
        builder.setChoteiNendo(new RYear(介護賦課.get調定年度().getYearValue()));
        builder.setRyokinShubetsuCode(new RyokinShubetsuCodeValue(RString.EMPTY));
        builder.setJigyoKubunCode(JigyoKubun.未使用);
        builder.setChoshukenUmu(false);
        builder.setChoteiNo(0);
        builder.setKamokuCode(科目.getコード());
        builder.setKamokuEdabanCode(科目.get枝番コード());
        builder.setKazeiNendo(new RYear(介護賦課.get賦課年度().getYearValue()));
        builder.setKibetsu(期);
        builder.setShikibetsuCode(介護賦課.get識別コード());
        builder.setShunoId(0L);
        builder.setTsuchishoNo(new TsuchishoNo(new Decimal(介護賦課.get通知書番号().toString())));

        return builder.build();
    }

    private Nokitsuki get納期月(IShunoKamoku 科目, int 期) {
        Nokitsuki.Builder builder = Nokitsuki.newBuilder();
        builder.set科目コード(科目.getコード());
        builder.set科目枝番コード(科目.get枝番コード());
        builder.set期別(期);
        return builder.build();
    }
}
