/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.CalculateChoteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingakuFactory;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.dz.dzx.business.core.kiwarikeisan.ChoteiNendoKibetsuClass;
import jp.co.ndensan.reams.dz.dzx.business.core.kiwarikeisan.FuchoTsukiClass;
import jp.co.ndensan.reams.dz.dzx.business.core.kiwarikeisan.FukaKoseiJohoClass;
import jp.co.ndensan.reams.dz.dzx.business.core.kiwarikeisan.GyomuConfigJohoClass;
import jp.co.ndensan.reams.dz.dzx.business.core.kiwarikeisan.KiwariKeisanInput;
import jp.co.ndensan.reams.dz.dzx.definition.core.kiwarikeisan.GenzaiTokuchoKiKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課の計算のビジネスクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
public class FukaKeisanFath {

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int INT_15 = 15;
    private static final int INT_16 = 16;
    private static final int INT_17 = 17;
    private static final int INT_18 = 18;
    private static final int INT_19 = 19;
    private static final int INT_20 = 20;
    private static final int INT_100 = 100;
    private static final int INT_1000 = 1000;
    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final RString 定数_5 = new RString("5");
    private static final RString 定数_6 = new RString("6");
    private static final RString 定数_7 = new RString("7");
    private static final RString 定数_8 = new RString("8");
    private static final RString 定数_9 = new RString("9");
    private static final RString 定数_10 = new RString("10");
    private static final RString 定数_11 = new RString("11");
    private static final RString 定数_12 = new RString("12");
    private static final RString 特別徴収_厚生労働省 = new RString("1");
    private static final RString 特別徴収_地共済 = new RString("2");
    private static final RString 連番_0001 = new RString("0001");
    private static final RString 連番_0005 = new RString("0005");
    private static final RString 連番_0007 = new RString("0007");
    private static final RString 連番_0009 = new RString("0009");
    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタDac;
    private final DbT2013HokenryoDankaiDac 保険料段階Dac;

    /**
     * コンストラクタです
     */
    FukaKeisanFath() {
        this.処理日付管理マスタDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.保険料段階Dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    }

    /**
     * コンストラクタです
     *
     * @param 処理日付管理マスタDac DbT7022ShoriDateKanriDac
     * @param 保険料段階Dac DbT2013HokenryoDankaiDac
     */
    FukaKeisanFath(DbT7022ShoriDateKanriDac 処理日付管理マスタDac, DbT2013HokenryoDankaiDac 保険料段階Dac) {
        this.処理日付管理マスタDac = 処理日付管理マスタDac;
        this.保険料段階Dac = 保険料段階Dac;
    }

    /**
     * 調定計算(現年度)InputEntity設定のメソッドです。
     *
     * @param kiwariKeisanInput KiwariKeisanInput
     * @param param CalculateChoteiParameter
     */
    protected void setInputEntity(KiwariKeisanInput kiwariKeisanInput, CalculateChoteiParameter param) {
        kiwariKeisanInput.set現在調定年度(param.get賦課年度());
        kiwariKeisanInput.set現在月(get算定月(param.get調定日時()));
        KoseiTsukiHantei hantei = InstanceProvider.create(KoseiTsukiHantei.class);

        Kitsuki 本算定期と月の対応 = hantei.find更正月_本算定期(param.get調定日時().getDate());
        kiwariKeisanInput.set現在期(本算定期と月の対応.get期AsInt());
        kiwariKeisanInput.set現在期区分(Integer.parseInt(本算定期と月の対応.get月処理区分().get区分().toString()));
        kiwariKeisanInput.set特徴停止可能期(get特徴停止可能期(param.get調定日時().getDate()));

        kiwariKeisanInput.set現在特徴期区分(GenzaiTokuchoKiKubun.本算異動.getコード());

        Kitsuki 過年度期と月の対応 = hantei.find過年度更正月(param.get調定日時().getDate());
        kiwariKeisanInput.set現在過年期(new RString(過年度期と月の対応.get期AsInt()));
        kiwariKeisanInput.set現在過年期区分(過年度期と月の対応.get月処理区分().get区分());

        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
        RDate 適用基準日 = RDate.getNowDate();
        RString 現年定例納期数 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_定例納期数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set現年定例納期数(Integer.parseInt(現年定例納期数.toString()));
        RString 普徴仮算定期数 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_仮算定期数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set普徴仮算定期数(Integer.parseInt(普徴仮算定期数.toString()));
        RString 特徴定例納期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_設定納期数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set特徴定例納期数(Integer.parseInt(特徴定例納期数.toString()));
        List<FlexibleDate> 年金支払日List = new ArrayList<>();
        RString 年金支払日_4月 = DbBusinessConfig.getConfigInfo(ConfigNameDBB.特別徴収_年金支払日_4月, 適用基準日, SubGyomuCode.DBB介護賦課).getConfigValue();
        RString 年金支払日_6月 = DbBusinessConfig.getConfigInfo(ConfigNameDBB.特別徴収_年金支払日_6月, 適用基準日, SubGyomuCode.DBB介護賦課).getConfigValue();
        RString 年金支払日_8月 = DbBusinessConfig.getConfigInfo(ConfigNameDBB.特別徴収_年金支払日_8月, 適用基準日, SubGyomuCode.DBB介護賦課).getConfigValue();
        RString 年金支払日_10月 = DbBusinessConfig.getConfigInfo(ConfigNameDBB.特別徴収_年金支払日_10月, 適用基準日, SubGyomuCode.DBB介護賦課).getConfigValue();
        RString 年金支払日_12月 = DbBusinessConfig.getConfigInfo(ConfigNameDBB.特別徴収_年金支払日_12月, 適用基準日, SubGyomuCode.DBB介護賦課).getConfigValue();
        RString 年金支払日_2月 = DbBusinessConfig.getConfigInfo(ConfigNameDBB.特別徴収_年金支払日_2月, 適用基準日, SubGyomuCode.DBB介護賦課).getConfigValue();
        年金支払日List.add(new FlexibleDate(年金支払日_4月));
        年金支払日List.add(new FlexibleDate(年金支払日_6月));
        年金支払日List.add(new FlexibleDate(年金支払日_8月));
        年金支払日List.add(new FlexibleDate(年金支払日_10月));
        年金支払日List.add(new FlexibleDate(年金支払日_12月));
        年金支払日List.add(new FlexibleDate(年金支払日_2月));
        業務コンフィグ情報.set年金支払日(年金支払日List);
        RString 特徴開始前普通徴収_8月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_8月,
                適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴開始前普通徴収_8月)) {
            業務コンフィグ情報.set捕捉分開始前普徴区分(定数_1);
        } else if (定数_0.equals(特徴開始前普通徴収_8月)) {
            業務コンフィグ情報.set捕捉分開始前普徴区分(定数_2);
        }
        RString 特徴開始前普通徴収_10月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_10月,
                適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴開始前普通徴収_10月)) {
            業務コンフィグ情報.set特徴開始前普徴区分(定数_1);
        } else if (定数_0.equals(特徴開始前普通徴収_10月)) {
            業務コンフィグ情報.set特徴開始前普徴区分(定数_2);
        }

        RString 普徴切替方法 = DbBusinessConfig.get(ConfigNameDBB.期割計算_普徴切替方法, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set普徴切替時期別区分(new RString(Integer.parseInt(普徴切替方法.toString())));

        業務コンフィグ情報.set増額時普調切替区分(定数_0);
        RString 捕捉計算区分 = RString.EMPTY;
        if (param.get調定日時().getMonthValue() == INT_10) {
            捕捉計算区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_12月開始, 適用基準日, SubGyomuCode.DBB介護賦課);
        } else if (param.get調定日時().getMonthValue() == INT_12) {
            捕捉計算区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_2月開始, 適用基準日, SubGyomuCode.DBB介護賦課);
        } else if (param.get調定日時().getMonthValue() == INT_2) {
            捕捉計算区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_4月開始, 適用基準日, SubGyomuCode.DBB介護賦課);
        }
        if (定数_1.equals(捕捉計算区分)) {
            業務コンフィグ情報.set捕捉計算区分(定数_1);
        } else if (定数_3.equals(捕捉計算区分)) {
            業務コンフィグ情報.set捕捉計算区分(定数_0);
        }
        RString 特徴減額期割方法 = DbBusinessConfig.get(ConfigNameDBB.期割計算_特徴減額期割方法, 適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴減額期割方法)) {
            業務コンフィグ情報.set併徴現年減額区分(定数_2);
        } else if (定数_2.equals(特徴減額期割方法)) {
            業務コンフィグ情報.set併徴現年減額区分(定数_0);
        }
        RString 特別徴収_期別端数 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別端数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set端数区分特徴期別額(get期別端数区分(特別徴収_期別端数));
        RString 普通徴収_期別端数 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set端数区分普徴期別額(get期別端数区分(普通徴収_期別端数));
        業務コンフィグ情報.set減免処理区分(INT_2);
        業務コンフィグ情報.set特徴依頼送付状況区分_10月(get特徴依頼送付状況区分(param.get賦課年度(), 連番_0001));
        業務コンフィグ情報.set特徴依頼送付状況区分_12月(get特徴依頼送付状況区分(param.get賦課年度(), 連番_0007));
        業務コンフィグ情報.set特徴依頼送付状況区分_2月(get特徴依頼送付状況区分(param.get賦課年度(), 連番_0009));
        業務コンフィグ情報.set普徴月クラス(get普徴月クラスリスト(param.get賦課年度()));
        業務コンフィグ情報.set特徴月テーブル(get特徴月テーブル());
        kiwariKeisanInput.set業務コンフィグ情報(業務コンフィグ情報);
        kiwariKeisanInput.set賦課更正情報(get賦課更正情報(param.get年度分賦課リスト_更正前()));
        kiwariKeisanInput.set変更後_確定年税額(param.get年額保険料());
        kiwariKeisanInput.set減免額(Decimal.ZERO);
        kiwariKeisanInput.set生年月日(FlexibleDate.EMPTY);
        kiwariKeisanInput.set全部喪失年月日(param.get資格の情報() == null ? null : param.get資格の情報().get資格喪失年月日());
        set特徴開始停止区分と期(kiwariKeisanInput, param);
        kiwariKeisanInput.set期別徴収方法区分(get期別徴収方法区分(param.get徴収方法の情報_更正前()));
    }

    /**
     * 算定月の取得のメソッドです。
     *
     * @param 調定日時 YMDHMS
     * @return RString
     */
    protected RString get算定月(YMDHMS 調定日時) {
        int 本算定第１期の期月 = new TokuchoKiUtil().get期月リスト().filtered本算定期間().toList().get(0).get月AsInt();
        KoseiTsukiHantei hantei = InstanceProvider.create(KoseiTsukiHantei.class);
        int 算定月 = hantei.find更正月_本算定期(調定日時.getDate()).get月AsInt();
        if (本算定第１期の期月 > 算定月) {
            return fomate月(本算定第１期の期月);
        } else {
            return fomate月(算定月);
        }
    }

    private RString fomate月(int 月) {
        if (月 <= INT_3) {
            return 定数_10.concat(new RString(月));
        } else {
            return new RString(月).padZeroToLeft(INT_3);
        }
    }

    private int get特徴停止可能期(RDate 調定日時) {
        KoseiTsukiHantei hantei = InstanceProvider.create(KoseiTsukiHantei.class);
        Kitsuki 期月 = hantei.find特徴更正月(調定日時);
        if (期月 != null) {
            int 月 = 期月.get月AsInt();
            if (月 >= INT_4 && 月 <= INT_7) {
                return INT_4;
            } else if (月 >= INT_8 && 月 <= INT_12) {
                return get月08_12(期月);
            }
        }
        return 0;
    }

    private int get月08_12(Kitsuki 期月) {
        int 月 = 期月.get月AsInt();
        if (月 % INT_2 != 0) {
            return 期月.get期AsInt() + INT_2;
        }
        RString 年度内連番;
        if (月 == INT_8) {
            年度内連番 = 連番_0005;
        } else if (月 == INT_10) {
            年度内連番 = 連番_0007;
        } else {
            年度内連番 = 連番_0009;
        }
        DbT7022ShoriDateKanriEntity 処理日付管理マスタ
                = 処理日付管理マスタDac.get処理状況(ShoriName.特徴異動情報作成.get名称(), 年度内連番);
        if (処理日付管理マスタ == null) {
            return 期月.get期AsInt() + INT_1;
        }
        if (処理日付管理マスタ.getKijunTimestamp() == null || 処理日付管理マスタ.getKijunTimestamp().isEmpty()) {
            return 期月.get期AsInt() + INT_1;
        } else {
            return 期月.get期AsInt() + INT_2;
        }
    }

    private int get期別端数区分(RString 期別端数) {
        switch (Integer.parseInt(期別端数.toString())) {
            case INT_1:
                return INT_1;
            case INT_10:
                return INT_2;
            case INT_100:
                return INT_3;
            case INT_1000:
                return INT_4;
            default:
                return 0;
        }
    }

    private int get特徴依頼送付状況区分(FlexibleYear 年度, RString 年度内連番) {
        DbT7022ShoriDateKanriEntity 処理日付管理マスタ
                = 処理日付管理マスタDac.get処理状況(ShoriName.特徴異動情報作成.get名称(), 年度内連番);
        if (処理日付管理マスタ == null) {
            return 0;
        }
        if (処理日付管理マスタ.getKijunTimestamp() == null || 処理日付管理マスタ.getKijunTimestamp().isEmpty()) {
            return 0;
        } else {
            return INT_1;
        }
    }

    private List<FuchoTsukiClass> get普徴月クラスリスト(FlexibleYear 調定年度) {
        List<FuchoTsukiClass> 普徴月クラス = new ArrayList<>();
        普徴月クラス.add(get普徴月クラス(調定年度, 0));
        return 普徴月クラス;
    }

    private FuchoTsukiClass get普徴月クラス(FlexibleYear 調定年度, int idx) {
        FuchoTsukiClass fuchoTsukiClass = new FuchoTsukiClass();
        List<Integer> 普徴月テーブル = new ArrayList<>();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(調定年度.minusYear(idx));
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 期月リスト = 期月リスト_普徴.toList();
        for (Kitsuki 期月 : 期月リスト) {
            普徴月テーブル.add(期月.get月AsInt());
        }

        fuchoTsukiClass.set普徴月テーブル(普徴月テーブル);
        return fuchoTsukiClass;
    }

    private List<Integer> get特徴月テーブル() {
        List<Integer> 特徴月テーブル = new ArrayList<>();
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月情報 = 月期対応取得_特徴.get期月リスト();
        List<Kitsuki> 期月リスト = 期月情報.toList();
        for (Kitsuki 期月 : 期月リスト) {
            特徴月テーブル.add(期月.get月AsInt());
        }
        return 特徴月テーブル;
    }

    private FukaKoseiJohoClass get賦課更正情報(NendobunFukaList 年度分賦課リスト) {
        FukaKoseiJohoClass 賦課更正情報 = new FukaKoseiJohoClass();
        FukaJoho 賦課の情報 = null;
        if (年度分賦課リスト != null) {
            賦課の情報 = 年度分賦課リスト.get現年度();
            if (賦課の情報 != null) {
                賦課更正情報.set課税年度(賦課の情報.get賦課年度());
                賦課更正情報.set変更前_確定年税額(賦課の情報.get確定介護保険料_年額());
            }
        }
        List<ChoteiNendoKibetsuClass> 調定年度期別クラス = new ArrayList<>();
        調定年度期別クラス.add(get調定年度期別クラス(賦課の情報));
        賦課更正情報.set調定年度期別クラス(調定年度期別クラス);
        return 賦課更正情報;
    }

    private ChoteiNendoKibetsuClass get調定年度期別クラス(FukaJoho 賦課の情報) {
        if (賦課の情報 == null) {
            return new ChoteiNendoKibetsuClass();
        }
        ChoteiNendoKibetsuClass 調定年度期別 = new ChoteiNendoKibetsuClass();
        調定年度期別.set調定年度(賦課の情報.get調定年度());
        List<Decimal> 普徴期別額List = new ArrayList<>();
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額01()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額02()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額03()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額04()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額05()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額06()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額07()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額08()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額09()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額10()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額11()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額12()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額13()));
        普徴期別額List.add(nullToZero(賦課の情報.get普徴期別金額14()));
        調定年度期別.set普徴期別額(普徴期別額List);

        List<Decimal> 特徴期別額List = new ArrayList<>();
        特徴期別額List.add(nullToZero(賦課の情報.get特徴期別金額01()));
        特徴期別額List.add(nullToZero(賦課の情報.get特徴期別金額02()));
        特徴期別額List.add(nullToZero(賦課の情報.get特徴期別金額03()));
        特徴期別額List.add(nullToZero(賦課の情報.get特徴期別金額04()));
        特徴期別額List.add(nullToZero(賦課の情報.get特徴期別金額05()));
        特徴期別額List.add(nullToZero(賦課の情報.get特徴期別金額06()));
        調定年度期別.set特徴期別額(特徴期別額List);
        return 調定年度期別;
    }

    private Decimal nullToZero(Decimal decimal) {
        return decimal == null ? Decimal.ZERO : decimal;
    }

    private void set特徴開始停止区分と期(KiwariKeisanInput kiwariKeisanInput, CalculateChoteiParameter param) {
        if (param.get徴収方法の情報_更正前() == null) {
            kiwariKeisanInput.set特徴開始停止区分(0);
            kiwariKeisanInput.set特徴開始停止期(0);
        } else if (ChoteiJiyuCode.年金保険者からの通知.getコード().equals(param.get徴収方法の情報_更正前().get特別徴収停止事由コード())
                || ChoteiJiyuCode.徴収方法修正.getコード().equals(param.get徴収方法の情報_更正前().get特別徴収停止事由コード())) {
            kiwariKeisanInput.set特徴開始停止区分(INT_9);
            set特徴開始停止期(kiwariKeisanInput, param);
        } else if (param.get資格の情報() != null
                && param.get資格の情報().get資格喪失年月日() != null && !param.get資格の情報().get資格喪失年月日().isEmpty()) {
            set資格喪失した場合(kiwariKeisanInput, param);
        } else if (!特別徴収_厚生労働省.equals(param.get徴収方法の情報_更正前().get徴収方法11月())
                && !特別徴収_地共済.equals(param.get徴収方法の情報_更正前().get徴収方法11月())
                && (特別徴収_厚生労働省.equals(param.get徴収方法の情報_更正前().get徴収方法12月())
                || 特別徴収_地共済.equals(param.get徴収方法の情報_更正前().get徴収方法12月()))) {
            kiwariKeisanInput.set特徴開始停止区分(INT_1);
            kiwariKeisanInput.set特徴開始停止期(INT_5);
        } else if (!特別徴収_厚生労働省.equals(param.get徴収方法の情報_更正前().get徴収方法1月())
                && !特別徴収_地共済.equals(param.get徴収方法の情報_更正前().get徴収方法1月())
                && (特別徴収_厚生労働省.equals(param.get徴収方法の情報_更正前().get徴収方法2月())
                || 特別徴収_地共済.equals(param.get徴収方法の情報_更正前().get徴収方法2月()))) {
            kiwariKeisanInput.set特徴開始停止区分(INT_1);
            kiwariKeisanInput.set特徴開始停止期(INT_6);
        }
    }

    private void set特徴開始停止期(KiwariKeisanInput kiwariKeisanInput, CalculateChoteiParameter param) {
        if (param.get徴収方法の情報_更正前() == null) {
            kiwariKeisanInput.set特徴開始停止期(0);
            return;
        }
        List<RString> 徴収方法リスト = new ArrayList<>();
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法4月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法5月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法6月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法7月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法8月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法9月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法10月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法11月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法12月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法1月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法2月());
        徴収方法リスト.add(param.get徴収方法の情報_更正前().get徴収方法3月());
        Map<RString, RString> map = new HashMap<>();
        map.put(定数_1, 定数_1);
        map.put(定数_2, 定数_1);
        map.put(定数_3, 定数_2);
        map.put(定数_4, 定数_2);
        map.put(定数_5, 定数_3);
        map.put(定数_6, 定数_3);
        map.put(定数_7, 定数_4);
        map.put(定数_8, 定数_4);
        map.put(定数_9, 定数_5);
        map.put(定数_10, 定数_5);
        map.put(定数_11, 定数_6);
        map.put(定数_12, 定数_6);
        boolean flag = false;
        for (int i = 0; i < 徴収方法リスト.size(); i++) {
            int 特徴開始停止期 = Integer.parseInt(map.get(new RString(i + INT_1)).toString());
            Decimal 特徴期別金額 = param.get年度分賦課リスト_更正前() == null || param.get年度分賦課リスト_更正前().get現年度() == null
                    ? Decimal.ZERO : param.get年度分賦課リスト_更正前().get現年度().get特徴期別金額(特徴開始停止期);
            if (特徴期別金額 == null) {
                特徴期別金額 = Decimal.ZERO;
            }
            if (Decimal.ZERO.compareTo(特徴期別金額) < 0) {
                if (!flag && (定数_1.equals(徴収方法リスト.get(i)) || 定数_2.equals(徴収方法リスト.get(i)))) {
                    flag = true;
                } else if (flag && 定数_3.equals(徴収方法リスト.get(i))) {
                    kiwariKeisanInput.set特徴開始停止期(特徴開始停止期);
                    break;
                } else if (i == 徴収方法リスト.size() - INT_1) {
                    kiwariKeisanInput.set特徴開始停止期(0);
                }
            } else if (i == 徴収方法リスト.size() - INT_1) {
                kiwariKeisanInput.set特徴開始停止期(0);
            }
        }
    }

    private void set資格喪失した場合(KiwariKeisanInput kiwariKeisanInput, CalculateChoteiParameter param) {
        Tsuki 月 = Tsuki.toValue(new RString(param.get資格の情報().get資格喪失年月日().getMonthValue()).padZeroToLeft(INT_2));
        int 特徴喪失日の特徴期 = new TokuchoKiUtil().get期月リスト().get月の期(月).get期AsInt();
        kiwariKeisanInput.set特徴開始停止区分(INT_8);
        FlexibleDate 年金支払い日 = get年金支払い日(Integer.parseInt(月.getコード().toString()));
        if (ChoteiJiyuCode.死亡.getコード().equals(param.get資格の情報().get資格喪失事由コード())) {
            if (param.get資格の情報().get資格喪失年月日().isBeforeOrEquals(年金支払い日)) {
                kiwariKeisanInput.set特徴開始停止期(特徴喪失日の特徴期);
            } else if (特徴喪失日の特徴期 == INT_6) {
                kiwariKeisanInput.set特徴開始停止期(0);
            } else {
                kiwariKeisanInput.set特徴開始停止期(特徴喪失日の特徴期 + INT_1);
            }
        } else if (特徴喪失日の特徴期 == INT_6) {
            kiwariKeisanInput.set特徴開始停止期(0);
        } else {
            kiwariKeisanInput.set特徴開始停止期(特徴喪失日の特徴期 + INT_1);
        }
    }

    private FlexibleDate get年金支払い日(int 月) {
        switch (月) {
            case INT_4:
            case INT_5:
                return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_4月,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
            case INT_6:
            case INT_7:
                return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_6月,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
            case INT_8:
            case INT_9:
                return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_8月,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
            case INT_10:
            case INT_11:
                return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_10月,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
            case INT_12:
            case INT_1:
                return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_12月,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
            case INT_2:
            case INT_3:
                return new FlexibleDate(DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_2月,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
            default:
                break;
        }
        return null;
    }

    private List<RString> get期別徴収方法区分(ChoshuHoho 徴収方法の情報) {
        List<RString> 期別徴収方法区分 = new ArrayList<>();
        if (徴収方法の情報 != null) {
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法4月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法5月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法6月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法7月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法8月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法9月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法10月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法11月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法12月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法1月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法2月()));
            期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法3月()));
        }
        return 期別徴収方法区分;
    }

    private RString set期別徴収方法(RString 徴収方法) {
        if (特別徴収_厚生労働省.equals(徴収方法) || 特別徴収_地共済.equals(徴収方法)) {
            return 定数_1;
        } else {
            return 定数_0;
        }
    }

    /**
     * 賦課情報変化有無判断のメソッドです。
     *
     * @param 更正前 FukaJoho
     * @param 更正後 FukaJoho
     * @return boolean
     */
    protected boolean is変化有り(FukaJoho 更正前, FukaJoho 更正後) {
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

    /**
     * FlexibleDate変化有無判断のメソッドです。
     *
     * @param 更正前 FlexibleDate
     * @param 更正後 FlexibleDate
     * @return boolean
     */
    protected boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleDate.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleDate.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    /**
     * RString変化有無判断のメソッドです。
     *
     * @param 更正前 RString
     * @param 更正後 RString
     * @return boolean
     */
    protected boolean isRString変更(RString 更正前, RString 更正後) {
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

    /**
     * Decimal変化有無判断のメソッドです。
     *
     * @param 更正前 Decimal
     * @param 更正後 Decimal
     * @return boolean
     */
    protected boolean isDecimal変更(Decimal 更正前, Decimal 更正後) {
        if (更正前 == null) {
            更正前 = Decimal.ZERO;
        }
        if (更正後 == null) {
            更正後 = Decimal.ZERO;
        }
        return !更正後.equals(更正前);
    }

    /**
     * 特徴期別金額の設定メソッドです。
     *
     * @param kibetsu Kibetsu
     * @param 特徴期別金額 List<Decimal>
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    protected void set特徴期別金額(Kibetsu kibetsu, List<Decimal> 特徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set期別金額(kibetsu, 特徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set期別金額(kibetsu, 特徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set期別金額(kibetsu, 特徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set期別金額(kibetsu, 特徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set期別金額(kibetsu, 特徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set期別金額(kibetsu, 特徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            default:
        }
    }

    /**
     * 普徴期別金額の設定メソッドです。
     *
     * @param kibetsu Kibetsu
     * @param 普徴期別金額 List<Decimal>
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    protected void set普徴期別金額(Kibetsu kibetsu, List<Decimal> 普徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set期別金額(kibetsu, 普徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set期別金額(kibetsu, 普徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set期別金額(kibetsu, 普徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set期別金額(kibetsu, 普徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set期別金額(kibetsu, 普徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set期別金額(kibetsu, 普徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            case INT_7:
                set期別金額(kibetsu, 普徴期別金額.get(INT_6), 介護期別RelateEntity);
                break;
            case INT_8:
                set期別金額(kibetsu, 普徴期別金額.get(INT_7), 介護期別RelateEntity);
                break;
            case INT_9:
                set期別金額(kibetsu, 普徴期別金額.get(INT_8), 介護期別RelateEntity);
                break;
            case INT_10:
                set期別金額(kibetsu, 普徴期別金額.get(INT_9), 介護期別RelateEntity);
                break;
            case INT_11:
                set期別金額(kibetsu, 普徴期別金額.get(INT_10), 介護期別RelateEntity);
                break;
            case INT_12:
                set期別金額(kibetsu, 普徴期別金額.get(INT_11), 介護期別RelateEntity);
                break;
            case INT_13:
                set期別金額(kibetsu, 普徴期別金額.get(INT_12), 介護期別RelateEntity);
                break;
            case INT_14:
                set期別金額(kibetsu, 普徴期別金額.get(INT_13), 介護期別RelateEntity);
                break;
            default:
        }
    }

    private void set期別金額(Kibetsu kibetsu, Decimal 期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        if (kibetsu.getChoteiKyotsuList() != null && !kibetsu.getChoteiKyotsuList().isEmpty()) {
            KibetsuEntity kibetsuEntity = new KibetsuEntity();
            kibetsuEntity.set介護期別Entity(kibetsu.toEntity());
            UrT0705ChoteiKyotsuEntity entity = kibetsu.getChoteiKyotsuList().get(0).toEntity();
            entity.setChoteigaku(期別金額);
            List<UrT0705ChoteiKyotsuEntity> entityList = new ArrayList<>();
            entityList.add(entity);
            kibetsuEntity.set調定共通Entity(entityList);
            介護期別RelateEntity.add(kibetsuEntity);
        }
    }

    /**
     * 月別保険料制御情報の設定メソッドです。
     *
     * @param 保険料段階リスト HokenryoDankaiList
     * @return SeigyoJoho
     */
    protected SeigyoJoho get月別保険料制御情報(HokenryoDankaiList 保険料段階リスト) {
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
                保険料段階リスト, 基準年金収入額01, 基準年金収入額02, 基準年金収入額03,
                基準所得金額01, 基準所得金額02, 基準所得金額03, 基準所得金額04, 基準所得金額05, 基準所得金額06,
                基準所得金額07, 基準所得金額08, 基準所得金額09, 基準所得金額10, 基準所得金額11, 基準所得金額12,
                基準所得金額13, 基準所得金額14, 基準所得金額15, 課税層所得段階,
                未申告段階使用有無, 未申告段階インデックス, KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無, 所得調査中段階インデックス, KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無, 課税取消段階インデックス, KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    /**
     * 年額賦課根拠の設定メソッドです。
     *
     * @param 賦課基準日 FlexibleDate
     * @param 資格取得日 FlexibleDate
     * @param 資格喪失日 FlexibleDate
     * @param 月別保険料段階 TsukibetsuHokenryoDankai
     * @param 月別ランク情報 List<MonthShichoson>
     * @return NengakuFukaKonkyo
     */
    protected NengakuFukaKonkyo get年額賦課根拠(FlexibleDate 賦課基準日, FlexibleDate 資格取得日,
            FlexibleDate 資格喪失日, TsukibetsuHokenryoDankai 月別保険料段階, List<MonthShichoson> 月別ランク情報) {
        RString ランク_4月 = RString.EMPTY;
        RString ランク_5月 = RString.EMPTY;
        RString ランク_6月 = RString.EMPTY;
        RString ランク_7月 = RString.EMPTY;
        RString ランク_8月 = RString.EMPTY;
        RString ランク_9月 = RString.EMPTY;
        RString ランク_10月 = RString.EMPTY;
        RString ランク_11月 = RString.EMPTY;
        RString ランク_12月 = RString.EMPTY;
        RString ランク_1月 = RString.EMPTY;
        RString ランク_2月 = RString.EMPTY;
        RString ランク_3月 = RString.EMPTY;
        for (MonthShichoson 月別ランク : 月別ランク情報) {
            if (Tsuki._4月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_4月 = 月別ランク.getランク区分();
            } else if (Tsuki._5月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_5月 = 月別ランク.getランク区分();
            } else if (Tsuki._6月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_6月 = 月別ランク.getランク区分();
            } else if (Tsuki._7月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_7月 = 月別ランク.getランク区分();
            } else if (Tsuki._8月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_8月 = 月別ランク.getランク区分();
            } else if (Tsuki._9月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_9月 = 月別ランク.getランク区分();
            } else if (Tsuki._10月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_10月 = 月別ランク.getランク区分();
            } else if (Tsuki._11月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_11月 = 月別ランク.getランク区分();
            } else if (Tsuki._12月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_12月 = 月別ランク.getランク区分();
            } else if (Tsuki._1月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_1月 = 月別ランク.getランク区分();
            } else if (Tsuki._2月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_2月 = 月別ランク.getランク区分();
            } else if (Tsuki._3月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_3月 = 月別ランク.getランク区分();
            }
        }
        NengakuFukaKonkyoFactory nengakuFukaKonkyo = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
        NengakuFukaKonkyo 年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                賦課基準日, 資格取得日, 資格喪失日, 月別保険料段階,
                ランク_4月, ランク_5月, ランク_6月, ランク_7月, ランク_8月, ランク_9月,
                ランク_10月, ランク_11月, ランク_12月, ランク_1月, ランク_2月, ランク_3月);
        return 年額賦課根拠;
    }

    /**
     * 年額制御情報の設定メソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @return NengakuSeigyoJoho
     */
    protected NengakuSeigyoJoho get年額制御情報(FlexibleYear 賦課年度) {
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

        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<>();
        setランク別制御情報(ランク別制御情報, 賦課年度);

        NengakuSeigyoJohoFactory nengakuSeigyoJohoFactory = InstanceProvider.create(NengakuSeigyoJohoFactory.class);
        NengakuSeigyoJoho 年額制御情報 = nengakuSeigyoJohoFactory.createNengakuSeigyoJoho(
                端数単位,
                HasuChoseiHoho.toValue(端数調整方法),
                端数単位_ランク用,
                HasuChoseiHoho.toValue(端数調整方法_ランク用),
                HasuChoseiTaisho.toValue(端数調整対象),
                ランク別制御情報);
        return 年額制御情報;
    }

    private void setランク別制御情報(Map<RString, RankBetsuKijunKingaku> ランク別制御情報, FlexibleYear 賦課年度) {
        List<DbT2013HokenryoDankaiEntity> 保険料段階List = 保険料段階Dac.get保険料ランク別制御情報(賦課年度);
        if (保険料段階List.isEmpty()) {
            return;
        }
        List<DbT2013HokenryoDankaiEntity> 段階List = new ArrayList<>();
        DbT2013HokenryoDankaiEntity 段階 = 保険料段階List.get(0);
        段階List.add(段階);
        for (int i = INT_1; i < 保険料段階List.size(); i++) {
            if (段階.getRankuKubun().equals(保険料段階List.get(i).getRankuKubun())) {
                段階List.add(保険料段階List.get(i));
            } else {
                RankBetsuKijunKingaku gagu = createRankBetsuKijunKingaku(段階List);
                ランク別制御情報.put(段階.getRankuKubun(), gagu);
                段階List.clear();
                段階List.add(保険料段階List.get(i));
            }
            段階 = 保険料段階List.get(i);
        }
        RankBetsuKijunKingaku gagu = createRankBetsuKijunKingaku(段階List);
        ランク別制御情報.put(段階.getRankuKubun(), gagu);
    }

    private RankBetsuKijunKingaku createRankBetsuKijunKingaku(List<DbT2013HokenryoDankaiEntity> 段階List) {
        RankBetsuKijunKingakuFactory factory = InstanceProvider.create(RankBetsuKijunKingakuFactory.class);
        RankBetsuKijunKingaku 基準金額 = factory.createRankBetsuKijunKingaku(get基準金額(段階List, INT_1),
                get基準金額(段階List, INT_2),
                get基準金額(段階List, INT_3),
                get基準金額(段階List, INT_4),
                get基準金額(段階List, INT_5),
                get基準金額(段階List, INT_6),
                get基準金額(段階List, INT_7),
                get基準金額(段階List, INT_8),
                get基準金額(段階List, INT_9),
                get基準金額(段階List, INT_10),
                get基準金額(段階List, INT_11),
                get基準金額(段階List, INT_12),
                get基準金額(段階List, INT_13),
                get基準金額(段階List, INT_14),
                get基準金額(段階List, INT_15),
                get基準金額(段階List, INT_16),
                get基準金額(段階List, INT_17),
                get基準金額(段階List, INT_18),
                get基準金額(段階List, INT_19),
                get基準金額(段階List, INT_20));
        return 基準金額;
    }

    private Decimal get基準金額(List<DbT2013HokenryoDankaiEntity> 段階List, int index) {
        if (段階List.isEmpty()) {
            return Decimal.ZERO;
        }
        if (index <= 段階List.size()) {
            return 段階List.get(index - INT_1).getHokenryoRitsu();
        }
        return Decimal.ZERO;
    }
}
