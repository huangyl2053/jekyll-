/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定通知書一括発行（バッチ）クラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
public class HonsanteiTsuchishoIkkatsuHakko extends HonsanteiTsuchishoIkkatsuHakkoFath {

    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
    private static final int INT_0 = 0;
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
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_出力期 = new RString("出力期");
    private static final RString 定数_対象者 = new RString("対象者");
    private static final RString 定数_生活保護対象者をまとめて先頭に出力 = new RString("生活保護対象者をまとめて先頭に出力");
    private static final RString 定数_ページごとに山分け = new RString("ページごとに山分け");
    private static final RString 定数_特徴期別金額 = new RString("get特徴期別金額");
    private static final RString 定数_普徴期別金額 = new RString("get普徴期別金額");
    private static final RString 定数_選択現金口座 = new RString("getSelectGenkinKoza");
    private static final RString 定数_選択通知書 = new RString("getSelectTsuchisho");
    private static final RString 定数_出力順グループ名 = new RString("getSortGroupName");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定値区分_0 = new RString("0");
    private static final RString 定値区分_1 = new RString("1");
    private static final RString 定値_特別徴収停止事由コード = new RString("T2");
    private static final RString 帳票タイプ_期毎 = new RString("期毎タイプ");
    private static final RString 帳票タイプ_銀振型5 = new RString("銀振型5期タイプ");
    private static final RString 帳票タイプ_銀振型4 = new RString("銀振型4期タイプ");
    private static final RString 帳票タイプ_ブック = new RString("ブックタイプ");
    private static final RString 帳票タイプ_コンビニ = new RString("コンビニ収納タイプ");
    private static final RString 項目名出力期_中期 = new RString("当初出力_中期開始期");
    private static final RString 項目名出力期_後期 = new RString("当初出力_後期開始期");
    private static final RString 別々に出力 = new RString("0");
    private static final RString 全件出力 = new RString("1");
    private static final RString キー_処理対象 = new RString("処理対象");
    private static final RString キー_通知書プリント条件 = new RString("通知書プリント条件");
    private static final RString 定値_する = new RString("する");
    private static final RString 定値_しない = new RString("しない");
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    /**
     * コンストラクタです。
     */
    public HonsanteiTsuchishoIkkatsuHakko() {
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HonsanteiTsuchishoIkkatsuHakko}のインスタンスを返します。
     *
     * @return HonsanteiTsuchishoIkkatsuHakko
     */
    public static HonsanteiTsuchishoIkkatsuHakko createInstance() {
        return InstanceProvider.create(HonsanteiTsuchishoIkkatsuHakko.class);
    }

    /**
     * 出力期リストを取得メソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 別々に出力区分 RString
     * @param 帳票タイプ RString
     * @param 期月リスト_普徴 KitsukiList
     * @param 本算定期間 KitsukiList
     * @param 出力期AsInt int
     * @return 出力期リスト List<Kitsuki>
     */
    public List<Kitsuki> get出力期リスト(FlexibleYear 調定年度, RString 別々に出力区分, RString 帳票タイプ,
            KitsukiList 期月リスト_普徴, KitsukiList 本算定期間, int 出力期AsInt) {

        ChohyoSeigyoHanyo 当初出力_中期開始期 = load帳票制御汎用ByKey(納入通知書_帳票分類ID, 調定年度, 項目名出力期_中期);
        ChohyoSeigyoHanyo 当初出力_後期開始期 = load帳票制御汎用ByKey(納入通知書_帳票分類ID, 調定年度, 項目名出力期_後期);
        int 最終期 = INT_0;
        if (帳票タイプ_期毎.equals(帳票タイプ)) {
            if (別々に出力.equals(別々に出力区分)) {
                最終期 = 出力期AsInt;
            } else if (全件出力.equals(別々に出力区分)) {
                最終期 = 本算定期間.getLast().get期AsInt();
            }
        } else if (別々に出力.equals(別々に出力区分) && 当初出力_中期開始期 != null && !RString.isNullOrEmpty(当初出力_中期開始期.get設定値())
                && 当初出力_後期開始期 != null && !RString.isNullOrEmpty(当初出力_後期開始期.get設定値())) {
            if (出力期AsInt < Integer.parseInt(当初出力_中期開始期.get設定値().toString())) {
                最終期 = Integer.parseInt(当初出力_中期開始期.get設定値().toString()) - INT_1;
            } else if (Integer.parseInt(当初出力_後期開始期.get設定値().toString()) <= 出力期AsInt) {
                最終期 = 本算定期間.getLast().get期AsInt();
            } else {
                最終期 = Integer.parseInt(当初出力_後期開始期.get設定値().toString()) - INT_1;
            }
        } else {
            最終期 = 本算定期間.getLast().get期AsInt();
        }
        KitsukiList 期月リスト = 期月リスト_普徴.subListBy期(出力期AsInt, 最終期);
        List<Kitsuki> kitsukiList = 期月リスト.toList();
        toKitsukiList(kitsukiList);
        return kitsukiList;
    }

    private void toKitsukiList(List<Kitsuki> kitsukiList) {
        Collections.sort(kitsukiList, new Comparator<Kitsuki>() {
            @Override
            public int compare(Kitsuki arg0, Kitsuki arg1) {
                if (arg0.get期AsInt() < arg1.get期AsInt()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

    /**
     * 帳票タイプを取得するメソッドです。
     *
     * @param 帳票ID ReportId
     * @return RString 帳票タイプ
     */
    public RString get帳票タイプ(ReportId 帳票ID) {

        RString 帳票タイプ = RString.EMPTY;
        if (ReportIdDBB.DBB100045.getReportId().equals(帳票ID) || ReportIdDBB.DBB100046.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100063.getReportId().equals(帳票ID) || ReportIdDBB.DBB100064.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_期毎;
        } else if (ReportIdDBB.DBB100053.getReportId().equals(帳票ID) || ReportIdDBB.DBB100054.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型5;
        } else if (ReportIdDBB.DBB100051.getReportId().equals(帳票ID) || ReportIdDBB.DBB100052.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型4;
        } else if (ReportIdDBB.DBB100055.getReportId().equals(帳票ID) || ReportIdDBB.DBB100056.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100057.getReportId().equals(帳票ID) || ReportIdDBB.DBB100058.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_ブック;
        } else if (ReportIdDBB.DBB100059.getReportId().equals(帳票ID) || ReportIdDBB.DBB100060.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100061.getReportId().equals(帳票ID) || ReportIdDBB.DBB100062.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_コンビニ;
        }
        return 帳票タイプ;
    }

    /**
     * 帳票タイプを取得するメソッドです。
     *
     * @param 発行日 RDate
     * @param 出力期 RString
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力区分 RString
     * @param 山分け区分 RString
     * @return RString 出力条件リスト
     */
    public List<RString> get出力条件リスト(RDate 発行日, RString 出力期, RString 納入通知書対象者, RString 生活保護者先頭出力区分,
            RString 山分け区分) {

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力期).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(出力期) ? RString.EMPTY : 出力期));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_対象者).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(NotsuKozaShutsuryokuTaisho.toValue(納入通知書対象者).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        if (定値区分_0.equals(生活保護者先頭出力区分)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(生活保護者先頭出力区分)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        if (定値区分_0.equals(山分け区分)) {
            builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(山分け区分)) {
            builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        出力条件リスト.add(builder.toRString());

        return 出力条件リスト;
    }

    /**
     * 納入通知書の期月リスト取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 別々に出力区分 RString
     * @param 帳票タイプ RString
     * @param 期月リスト_普徴 KitsukiList
     * @param 本算定期間 KitsukiList
     * @param 出力期AsInt int
     * @return List<NokiJoho> 期月リスト
     */
    public List<NokiJoho> get期月リスト(FlexibleYear 調定年度, RString 別々に出力区分, RString 帳票タイプ,
            KitsukiList 期月リスト_普徴, KitsukiList 本算定期間, int 出力期AsInt) {

        ChohyoSeigyoHanyo 当初出力_中期開始期 = load帳票制御汎用ByKey(納入通知書_帳票分類ID, 調定年度, 項目名出力期_中期);
        ChohyoSeigyoHanyo 当初出力_後期開始期 = load帳票制御汎用ByKey(納入通知書_帳票分類ID, 調定年度, 項目名出力期_後期);
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期List = fukaNokiResearcher.get普徴納期ALL();
        int 最終期 = INT_0;
        if (帳票タイプ_期毎.equals(帳票タイプ)) {
            if (別々に出力.equals(別々に出力区分)) {
                最終期 = 出力期AsInt;
            } else if (全件出力.equals(別々に出力区分)) {
                最終期 = 本算定期間.getLast().get期AsInt();
            }
        } else if (別々に出力.equals(別々に出力区分) && 当初出力_中期開始期 != null && !RString.isNullOrEmpty(当初出力_中期開始期.get設定値())
                && 当初出力_後期開始期 != null && !RString.isNullOrEmpty(当初出力_後期開始期.get設定値())) {
            if (出力期AsInt < Integer.parseInt(当初出力_中期開始期.get設定値().toString())) {
                最終期 = Integer.parseInt(当初出力_中期開始期.get設定値().toString()) - INT_1;
            } else if (Integer.parseInt(当初出力_後期開始期.get設定値().toString()) <= 出力期AsInt) {
                最終期 = 本算定期間.getLast().get期AsInt();
            } else {
                最終期 = Integer.parseInt(当初出力_後期開始期.get設定値().toString()) - INT_1;
            }
        } else {
            最終期 = 本算定期間.getLast().get期AsInt();
        }
        KitsukiList 期月リスト = 期月リスト_普徴.subListBy期(出力期AsInt, 最終期);
        List<Kitsuki> 期月List = 期月リスト.toList();
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 期月List) {
            NokiJoho 普徴納期情報 = new NokiJoho();
            普徴納期情報.set期月(期月);
            普徴納期情報.set納期(get納期By期月(期月, 普徴納期List));
            普徴納期情報リスト.add(普徴納期情報);
        }
        return 普徴納期情報リスト;
    }

    private Noki get納期By期月(Kitsuki 期月, List<Noki> 賦課納期) {
        if (null == 賦課納期 || null == 期月) {
            return null;
        }
        for (Noki 納期 : 賦課納期) {
            if (期月.get期AsInt() == 納期.get期別()) {
                return 納期;
            }
        }
        return null;
    }

    /**
     * 山分け用スプール数を取得するメソッドです。
     *
     * @param 帳票タイプ RString
     * @param 期月List List<NokiJoho>
     * @param 本算定期間 KitsukiList
     * @param 出力期AsInt int
     * @param 山分け区分 RString
     * @return int 山分け用スプール数
     */
    public int get山分け用スプール数(RString 帳票タイプ, List<NokiJoho> 期月List, KitsukiList 本算定期間,
            int 出力期AsInt, RString 山分け区分) {

        int 山分け用スプール数 = 0;
        if (定値区分_0.equals(山分け区分)) {
            if (帳票タイプ_期毎.equals(帳票タイプ)) {
                山分け用スプール数 = 期月List.isEmpty() ? 0 : 期月List.size();
            } else if (帳票タイプ_銀振型5.equals(帳票タイプ) || 帳票タイプ_銀振型4.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_銀振型(期月List, 本算定期間);
            } else if (帳票タイプ_ブック.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_ブック(出力期AsInt, 期月List);
            } else if (帳票タイプ_コンビニ.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_コンビニ(出力期AsInt, 期月List);
            }
        } else if (定値区分_1.equals(山分け区分)) {
            山分け用スプール数 = INT_1;
        }
        return 山分け用スプール数;
    }

    private int get山分け用スプール数_銀振型(List<NokiJoho> 期月List, KitsukiList 本算定期間) {
        int 山分け用スプール数 = 1;
        本算定期間.toList();
        for (NokiJoho 期月 : 期月List) {
            if (定値区分_0.equals(get印字位置(期月.get期月().get月AsInt()))) {
                期月List.remove(期月);
            }
        }
        Collections.sort(期月List, new Comparator<NokiJoho>() {
            @Override
            public int compare(NokiJoho arg0, NokiJoho arg1) {
                if (arg0.get期月().get期AsInt() < arg1.get期月().get期AsInt()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        int 銀振印字位置Para = 0;
        for (int i = 0; i < 期月List.size() - 1; i++) {
            int 銀振印字位置 = Integer.parseInt(get印字位置(期月List.get(i).get期月().get月AsInt()).toString());
            if (銀振印字位置 <= 銀振印字位置Para) {
                山分け用スプール数 = 山分け用スプール数 + 1;
            }
            銀振印字位置Para = 銀振印字位置;
        }
        return 山分け用スプール数;
    }

    private int get山分け用スプール数_ブック(int 出力期AsInt, List<NokiJoho> 期月List) {

        int ブック開始位置 = 0;
        for (NokiJoho 期月 : 期月List) {
            if (出力期AsInt == 期月.get期月().get期AsInt()) {
                ブック開始位置 = Integer.parseInt(getブック開始位置(期月.get期月().get月AsInt()).toString());
            }
        }
        int 出力期リスト_サイズ = 期月List.size();
        if (出力期リスト_サイズ == INT_0) {
            return INT_0;
        }
        switch (ブック開始位置) {
            case INT_1:
                return set山分け用スプール数_ブック開始位置1(出力期リスト_サイズ);
            case INT_2:
                return set山分け用スプール数_ブック開始位置2(出力期リスト_サイズ);
            case INT_3:
                if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_3) {
                    return INT_2;
                } else if (INT_4 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_7) {
                    return INT_3;
                } else {
                    return INT_4;
                }
            case INT_4:
                if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_2) {
                    return INT_2;
                } else if (INT_3 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_6) {
                    return INT_3;
                } else {
                    return INT_4;
                }
            case INT_5:
                return set山分け用スプール数_ブック開始位置5(出力期リスト_サイズ);
            default:
                return INT_0;
        }
    }

    private int get山分け用スプール数_コンビニ(int 出力期AsInt, List<NokiJoho> 期月List) {
        int 山分け用スプール数 = 0;
        int コンビニカット印字位置 = 0;
        for (NokiJoho 期月 : 期月List) {
            if (出力期AsInt == 期月.get期月().get期AsInt()) {
                コンビニカット印字位置 = Integer.parseInt(getコンビニカット印字位置(期月.get期月().get月AsInt()).toString());
            }
        }
        if (コンビニカット印字位置 == 1) {
            山分け用スプール数 = INT_1;
        } else if (INT_2 <= コンビニカット印字位置 && コンビニカット印字位置 <= INT_4) {
            山分け用スプール数 = INT_2;
        } else if (INT_5 <= コンビニカット印字位置 && コンビニカット印字位置 <= INT_7) {
            山分け用スプール数 = INT_3;
        } else if (INT_8 <= コンビニカット印字位置) {
            山分け用スプール数 = INT_4;
        }
        return 山分け用スプール数;
    }

    private int set山分け用スプール数_ブック開始位置1(int 出力期リスト_サイズ) {
        if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_5) {
            return INT_2;
        } else if (INT_6 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_9) {
            return INT_3;
        } else {
            return INT_4;
        }
    }

    private int set山分け用スプール数_ブック開始位置2(int 出力期リスト_サイズ) {
        if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_4) {
            return INT_2;
        } else if (INT_5 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_8) {
            return INT_3;
        } else {
            return INT_4;
        }
    }

    private int set山分け用スプール数_ブック開始位置5(int 出力期リスト_サイズ) {
        if (出力期リスト_サイズ == 1) {
            return INT_2;
        } else if (INT_2 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_5) {
            return INT_3;
        } else if (INT_6 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_9) {
            return INT_4;
        } else {
            return INT_5;
        }
    }

    private RString getコンビニカット印字位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_15:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    private RString getブック開始位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_15:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    /**
     * 普徴期情報を取得するメソッドです。
     *
     * @param 出力期 RString
     * @return Map<String, RString> 普徴期情報
     */
    public Map<String, RString> get普徴期情報(RString 出力期) {

        RString 普徴期情報_通知書プリント条件;
        RString 普徴期情報_処理対象;
        RDate 運用日 = RDate.getNowDate();
        switch (Integer.parseInt(出力期.toString())) {
            case INT_1:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件1, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件2, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件3, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_4:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件4, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件5, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件6, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件7, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件8, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件9, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件10, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件11, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件12, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_13:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件13, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件14, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                普徴期情報_通知書プリント条件 = RString.EMPTY;
                普徴期情報_処理対象 = RString.EMPTY;
                break;
        }
        Map<String, RString> map = new HashMap<>();
        map.put(キー_処理対象.toString(), 普徴期情報_処理対象);
        map.put(キー_通知書プリント条件.toString(), 普徴期情報_通知書プリント条件);
        return map;
    }

    /**
     * 選択通知書No取得するメソッドです。
     *
     * @param 仮算定最初期 int
     * @param 仮算定最終期 int
     * @param 本算定最初期 int
     * @param 本算定最終期 int
     * @param tmpResult HonsanteiTsuchishoTempResult
     * @return int get選択通知書No
     */
    public int get選択通知書No(int 仮算定最初期, int 仮算定最終期, int 本算定最初期, int 本算定最終期,
            HonsanteiTsuchishoTempResult tmpResult) {

        FukaAtena 賦課の情報_更正前 = tmpResult.get賦課の情報_更正前();
        FukaJoho 賦課の情報_更正後 = tmpResult.get賦課の情報_更正後().get賦課情報();
        Decimal 更正後_普徴本算定額 = get普徴期別金額合計(賦課の情報_更正後, 本算定最初期, 本算定最終期);
        if (賦課の情報_更正前 == null) {
            if (定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_9;
            } else {
                return INT_0;
            }
        }
        ChoshuHoho 徴収方法情報_更正前 = tmpResult.get徴収方法情報_更正前();
        Decimal 更正前_普徴特徴仮算定額合計 = null;
        RString 徴収方法更正前_特別徴収停止事由コード = RString.EMPTY;
        if (徴収方法情報_更正前 != null) {
            徴収方法更正前_特別徴収停止事由コード = 徴収方法情報_更正前.get特別徴収停止事由コード();
        }

        Decimal 更正前_特徴仮算定額 = get特徴期別金額合計(賦課の情報_更正前.get賦課情報(), INT_1, INT_3);
        Decimal 更正前_普徴仮算定額 = get普徴期別金額合計(賦課の情報_更正前.get賦課情報(), 仮算定最初期, 仮算定最終期);
        if (更正前_特徴仮算定額 == null && 更正前_普徴仮算定額 == null) {
            更正前_普徴特徴仮算定額合計 = null;
        } else if (更正前_特徴仮算定額 != null && 更正前_普徴仮算定額 == null) {
            更正前_普徴特徴仮算定額合計 = 更正前_特徴仮算定額;
        } else if (更正前_特徴仮算定額 == null && 更正前_普徴仮算定額 != null) {
            更正前_普徴特徴仮算定額合計 = 更正前_普徴仮算定額;
        } else if (更正前_特徴仮算定額 != null && 更正前_普徴仮算定額 != null) {
            更正前_普徴特徴仮算定額合計 = 更正前_特徴仮算定額.add(更正前_普徴仮算定額);
        }
        Decimal 更正後_特徴本算定額 = get特徴期別金額合計(賦課の情報_更正後, INT_4, INT_6);

        int 選択通知書No = get選択通知書No_部分(賦課の情報_更正後, 更正前_普徴特徴仮算定額合計,
                更正前_特徴仮算定額, 更正後_特徴本算定額, 徴収方法更正前_特別徴収停止事由コード);
        if (選択通知書No != 0) {
            return 選択通知書No;
        }

        if (定値区分_0.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正前_普徴仮算定額))
                && 定値区分_1.equals(get判定結果(更正後_特徴本算定額))) {
            return INT_8;
        }
        選択通知書No = get選択通知書No_部分(賦課の情報_更正後, 更正前_特徴仮算定額, 更正前_普徴仮算定額, 更正後_特徴本算定額, 更正後_普徴本算定額);
        if (選択通知書No != 0) {
            return 選択通知書No;
        }

        return 0;
    }

    private int get選択通知書No_部分(FukaJoho 賦課の情報_更正後, Decimal 更正前_普徴特徴仮算定額合計, Decimal 更正前_特徴仮算定額,
            Decimal 更正後_特徴本算定額, RString 徴収方法更正前_特別徴収停止事由コード) {

        if (賦課の情報_更正後.get資格喪失日() == null || 賦課の情報_更正後.get資格喪失日().isEmpty()) {
            if ((更正前_普徴特徴仮算定額合計 == null && 賦課の情報_更正後.get減免前介護保険料_年額() == null)
                    || (更正前_普徴特徴仮算定額合計 != null
                    && 更正前_普徴特徴仮算定額合計.equals(賦課の情報_更正後.get減免前介護保険料_年額()))) {
                return INT_1;
            }
            if (更正前_普徴特徴仮算定額合計 != null && 賦課の情報_更正後.get減免前介護保険料_年額() != null
                    && (更正前_普徴特徴仮算定額合計.compareTo(賦課の情報_更正後.get減免前介護保険料_年額()) == INT_1)
                    && 定値区分_1.equals(get判定結果(賦課の情報_更正後.get減免前介護保険料_年額()))) {
                return INT_2;
            }
        }

        return get選択通知書No_部分1(賦課の情報_更正後, 更正前_普徴特徴仮算定額合計, 更正前_特徴仮算定額,
                更正後_特徴本算定額, 徴収方法更正前_特別徴収停止事由コード);
    }

    private int get選択通知書No_部分1(FukaJoho 賦課の情報_更正後, Decimal 更正前_普徴特徴仮算定額合計, Decimal 更正前_特徴仮算定額,
            Decimal 更正後_特徴本算定額, RString 徴収方法更正前_特別徴収停止事由コード) {

        if ((更正前_普徴特徴仮算定額合計 == null && 賦課の情報_更正後.get減免前介護保険料_年額() == null)
                || (更正前_普徴特徴仮算定額合計 != null
                && 更正前_普徴特徴仮算定額合計.equals(賦課の情報_更正後.get減免前介護保険料_年額()))) {
            return INT_3;
        }
        if (更正前_普徴特徴仮算定額合計 != null && 賦課の情報_更正後.get減免前介護保険料_年額() != null
                && (更正前_普徴特徴仮算定額合計.compareTo(賦課の情報_更正後.get減免前介護保険料_年額()) == INT_1)
                && 定値区分_1.equals(get判定結果(賦課の情報_更正後.get減免前介護保険料_年額()))) {
            return INT_4;
        }
        if (Decimal.ZERO.equals(賦課の情報_更正後.get減免前介護保険料_年額())) {
            return INT_5;
        }
        if (定値区分_1.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正後_特徴本算定額))) {
            if (!定値_特別徴収停止事由コード.equals(徴収方法更正前_特別徴収停止事由コード)) {
                return INT_6;
            } else {
                return INT_7;
            }
        }
        return INT_0;
    }

    private int get選択通知書No_部分(FukaJoho 賦課の情報_更正後, Decimal 更正前_特徴仮算定額, Decimal 更正前_普徴仮算定額,
            Decimal 更正後_特徴本算定額, Decimal 更正後_普徴本算定額) {

        if (賦課の情報_更正後.get資格喪失日() == null || 賦課の情報_更正後.get資格喪失日().isEmpty()) {
            if (定値区分_1.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_0.equals(get判定結果(更正後_特徴本算定額))
                    && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_10;
            }
            if (定値区分_0.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正前_普徴仮算定額))
                    && 定値区分_0.equals(get判定結果(更正後_特徴本算定額)) && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_11;
            }
        } else {
            if (定値区分_1.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_0.equals(get判定結果(更正後_特徴本算定額))
                    && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_12;
            }
            if (定値区分_0.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正前_普徴仮算定額))
                    && 定値区分_0.equals(get判定結果(更正後_特徴本算定額)) && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_13;
            }
        }
        return 0;
    }

    private RString get判定結果(Decimal 金額) {
        if (金額 == null) {
            return RString.EMPTY;
        }
        if (金額.compareTo(Decimal.ZERO) == INT_1) {
            return 定値区分_1;
        } else if (金額.compareTo(Decimal.ZERO) == 0) {
            return 定値区分_0;
        }
        return RString.EMPTY;
    }

    /**
     * 通知書共通情報取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 出力期 RString
     * @return HonsanteiTsuchishoInfo 通知書共通情報
     */
    public HonsanteiTsuchishoInfo get通知書共通情報(FlexibleYear 調定年度, RString 出力期) {

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 本算定期間 = 期月リスト_普徴.filtered本算定期間();
        int 最終期 = 本算定期間.getLast().get期AsInt();
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期List = fukaNokiResearcher.get普徴納期ALL();
        List<Kitsuki> 本算定期間List = 本算定期間.toList();
        int 最初期;
        if (RString.isNullOrEmpty(出力期)) {
            最初期 = 本算定期間List.get(本算定期間List.size() - INT_1).get期AsInt();
        } else {
            最初期 = Integer.parseInt(出力期.toString());
        }
        KitsukiList 期月リスト = 期月リスト_普徴.subListBy期(最初期, 最終期);
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 期月リスト.toList()) {
            for (Noki 普徴納期 : 普徴納期List) {
                if (期月.get期AsInt() == 普徴納期.get期別() && !定値_ゼロ.equals(get印字位置(期月.get月AsInt()))) {
                    NokiJoho nokiJoho = new NokiJoho();
                    nokiJoho.set期月(期月);
                    nokiJoho.set納期(普徴納期);
                    普徴納期情報リスト.add(nokiJoho);
                }
            }
        }

        List<NokiJoho> 特徴納期情報リスト = new ArrayList<>();
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        for (int index = INT_1; index <= INT_6; index++) {
            Kitsuki 期月情報 = 期月リスト_特徴.get期の最初月(index);
            Noki 特徴納期 = fukaNokiResearcher.get特徴納期(index);
            NokiJoho nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月情報);
            nokiJoho.set納期(特徴納期);
            特徴納期情報リスト.add(nokiJoho);
        }

        HonsanteiTsuchishoInfo 通知書共通情報entity = new HonsanteiTsuchishoInfo();
        通知書共通情報entity.set普徴納期情報リスト(普徴納期情報リスト);
        通知書共通情報entity.set特徴納期情報リスト(特徴納期情報リスト);
        return 通知書共通情報entity;
    }

    private RString get印字位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_15:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    /**
     * 帳票制御共通情報取得メソッドです。
     *
     * @param 帳票分類ID ReportId
     * @return ChohyoSeigyoKyotsu 帳票制御共通情報
     */
    public ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類ID) {

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    /**
     * 帳票制御汎用取得メソッドです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo load帳票制御汎用ByKey(ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(SubGyomuCode.DBB介護賦課, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    /**
     * 本算定通知書パラメータの取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 最新調定日時 YMDHMS
     * @return HonsanteiTsuchishoIkkatsuHakkoParameter 本算定通知書パラメータ
     */
    public HonsanteiTsuchishoIkkatsuHakkoParameter get本算定通知書パラメータ(FlexibleYear 調定年度,
            FlexibleYear 賦課年度, YMDHMS 最新調定日時) {

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 本算定期間 = 期月リスト_普徴.filtered本算定期間();
        FukaNokiResearcher 賦課納期取得 = FukaNokiResearcher.createInstance();
        Noki 納期 = 賦課納期取得.get普徴納期(本算定期間.toList().get(0).get期AsInt());

        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set基準日(new FlexibleDate(納期.get納期限().toDateString()));
        IKozaSearchKey kozaSearchKey = builder.build();
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護保険料_普通徴収 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        List<KamokuCode> list = new ArrayList<>();
        list.add(介護保険料_普通徴収.getコード());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        for (int i = 0; i < list.size(); i++) {
            rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
            if (i != list.size() - 1) {
                rStringBuilder.append(MIDDLE_FORMAT);
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        return HonsanteiTsuchishoIkkatsuHakkoParameter.createSelectByKeyParam(調定年度, 賦課年度,
                処理日, kozaSearchKey, list, 科目コード, 最新調定日時);
    }

    /**
     * バッチ出力条件リストの出力メソッドです。
     *
     * @param 出力条件リスト List<RString>
     * @param 帳票ID ReportId
     * @param 出力ページ数 RString
     * @param csv出力有無 RString
     * @param csvファイル名 RString
     * @param 帳票名 RString
     */
    public void loadバッチ出力条件リスト(List<RString> 出力条件リスト, ReportId 帳票ID, RString 出力ページ数,
            RString csv出力有無, RString csvファイル名, RString 帳票名) {

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    /**
     * 特徴開始通知書(本算定）の帳票名を取得するメソッドです。
     *
     * @param 帳票ID RString
     * @return RString 帳票名
     */
    public RString get帳票名_特徴(RString 帳票ID) {

        if (ReportIdDBB.DBB100032.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100032.getReportName();
        } else if (ReportIdDBB.DBB100033.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100033.getReportName();
        } else if (ReportIdDBB.DBB100034.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100034.getReportName();
        } else if (ReportIdDBB.DBB100035.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100035.getReportName();
        } else if (ReportIdDBB.DBB100036.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100036.getReportName();
        } else if (ReportIdDBB.DBB100037.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100037.getReportName();
        } else if (ReportIdDBB.DBB100038.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100038.getReportName();
        }
        return RString.EMPTY;
    }

    /**
     * 決定通知書の帳票名を取得するメソッドです。
     *
     * @param 帳票ID RString
     * @return RString 帳票名
     */
    public RString get帳票名_決定(RString 帳票ID) {

        if (ReportIdDBB.DBB100039.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100039.getReportName();
        } else if (ReportIdDBB.DBB100040.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100040.getReportName();
        }
        return RString.EMPTY;
    }

    /**
     * 変更通知書の帳票名を取得するメソッドです。
     *
     * @param 帳票ID RString
     * @return RString 帳票名
     */
    public RString get帳票名_変更(RString 帳票ID) {

        if (ReportIdDBB.DBB100042.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100042.getReportName();
        } else if (ReportIdDBB.DBB100043.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100043.getReportName();
        }
        return RString.EMPTY;
    }

    /**
     * 納入通知書の帳票名を取得するメソッドです。
     *
     * @param 帳票ID RString
     * @return RString 帳票名
     */
    public RString get帳票名_納入(RString 帳票ID) {

        if (ReportIdDBB.DBB100045.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100045.getReportName();
        } else if (ReportIdDBB.DBB100046.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100046.getReportName();
        } else if (ReportIdDBB.DBB100053.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100053.getReportName();
        } else if (ReportIdDBB.DBB100054.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100054.getReportName();
        } else if (ReportIdDBB.DBB100051.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100051.getReportName();
        } else if (ReportIdDBB.DBB100052.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100052.getReportName();
        } else if (ReportIdDBB.DBB100056.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100056.getReportName();
        } else if (ReportIdDBB.DBB100058.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100058.getReportName();
        } else if (ReportIdDBB.DBB100055.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100055.getReportName();
        } else if (ReportIdDBB.DBB100057.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100057.getReportName();
        } else if (ReportIdDBB.DBB100061.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100061.getReportName();
        } else if (ReportIdDBB.DBB100062.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100062.getReportName();
        } else if (ReportIdDBB.DBB100059.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100059.getReportName();
        } else if (ReportIdDBB.DBB100060.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100060.getReportName();
        } else if (ReportIdDBB.DBB100063.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100063.getReportName();
        } else if (ReportIdDBB.DBB100064.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100064.getReportName();
        }
        return RString.EMPTY;
    }

    private Decimal get特徴期別金額合計(FukaJoho fukaJoho, int start, int end) {
        Decimal 特徴仮算定保険料 = Decimal.ZERO;
        if (fukaJoho == null) {
            return null;
        }
        boolean 区分 = false;
        for (int i = start; i <= end; i++) {
            if (i == INT_0 || INT_6 < i) {
                continue;
            }
            RStringBuilder sb = new RStringBuilder(定数_特徴期別金額.toString());
            sb.append(new RString(i).padZeroToLeft(INT_2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                if ((Decimal) getMethod.invoke(fukaJoho) != null) {
                    区分 = true;
                    特徴仮算定保険料 = 特徴仮算定保険料.add((Decimal) getMethod.invoke(fukaJoho));
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!区分) {
            return null;
        }
        return 特徴仮算定保険料;
    }

    private Decimal get普徴期別金額合計(FukaJoho fukaJoho, int start, int end) {
        Decimal 普徴納付済額 = Decimal.ZERO;
        if (fukaJoho == null) {
            return null;
        }
        boolean 区分 = false;
        for (int i = start; i <= end; i++) {
            if (i == INT_0 || INT_14 < i) {
                continue;
            }
            RStringBuilder sb = new RStringBuilder(定数_普徴期別金額.toString());
            sb.append(new RString(i).padZeroToLeft(INT_2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                if ((Decimal) getMethod.invoke(fukaJoho) != null) {
                    区分 = true;
                    普徴納付済額 = 普徴納付済額.add((Decimal) getMethod.invoke(fukaJoho));
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!区分) {
            return null;
        }
        return 普徴納付済額;
    }

    /**
     * 選択現金口座取得するメソッドです。
     *
     * @param entity DbT2014TsuchishoUchiwakeJokenEntity
     * @param index int
     * @return RString 選択現金口座
     */
    public RString get選択現金口座(DbT2014TsuchishoUchiwakeJokenEntity entity, int index) {

        RString 選択現金口座 = RString.EMPTY;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_選択現金口座.toString());
        sb.append(new RString(index).padZeroToLeft(INT_2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            選択現金口座 = (RString) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 選択現金口座;
    }

    /**
     * 選択通知書取得するメソッドです。
     *
     * @param entity DbT2014TsuchishoUchiwakeJokenEntity
     * @param index int
     * @return RString 選択通知書
     */
    public RString get選択通知書(DbT2014TsuchishoUchiwakeJokenEntity entity, int index) {

        RString 選択通知書 = RString.EMPTY;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_選択通知書.toString());
        sb.append(new RString(index).padZeroToLeft(INT_2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            選択通知書 = (RString) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 選択通知書;
    }

    /**
     * 選出力順グループ名取得するメソッドです。
     *
     * @param entity DbT2014TsuchishoUchiwakeJokenEntity
     * @param index int
     * @return RString 出力順グループ名
     */
    public RString get出力順グループ名(DbT2014TsuchishoUchiwakeJokenEntity entity, int index) {

        RString 出力順グループ名 = RString.EMPTY;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_出力順グループ名.toString());
        sb.append(new RString(index).padZeroToLeft(INT_2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            出力順グループ名 = (RString) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 出力順グループ名;
    }

}
