/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho.TsuchishoKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaJohoTempParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
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
 * 仮算定異動通知書一括発行（バッチ）
 *
 * @reamsid_L DBB-0890-040 xicongwang
 */
public class KarisanteiIdoTsuchishoIkkatsuHakko extends KarisanteiIdoTsuchishoIkkatsuHakkoFath {

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
    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
    private static final RString 定値区分_0 = new RString("0");
    private static final RString 定値区分_1 = new RString("1");
    private static final RString 定数_生活保護対象者をまとめて先頭に出力 = new RString("生活保護対象者をまとめて先頭に出力");
    private static final RString 定数_ページごとに山分け = new RString("ページごとに山分け");
    private static final RString 定値_する = new RString("する");
    private static final RString 定値_しない = new RString("しない");
    private static final RString 代行プリント送付票_帳票名 = new RString("保険料納入通知書（仮算定）");
    private static final RString 代行プリント送付票_処理名 = new RString("仮算定異動通知書一括発行");
    private static final RString 定数_抽出条件 = new RString("抽出条件");
    private static final RString 定数_詳細設定 = new RString("詳細設定");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_出力期 = new RString("出力期");
    private static final RString 定数_対象者 = new RString("対象者");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 帳票タイプ_期毎 = new RString("期毎タイプ");
    private static final RString 帳票タイプ_銀振型4 = new RString("銀振型4期タイプ");
    private static final RString 帳票タイプ_ブック = new RString("ブックタイプ");
    private static final RString 帳票タイプ_コンビニ = new RString("コンビニ収納タイプ");
    private static final RString キー_処理対象 = new RString("処理対象");
    private static final RString キー_通知書プリント条件 = new RString("通知書プリント条件");
    private static final RString 別々に出力 = new RString("0");
    private static final RString ブック開始位置_1 = new RString("01");
    private static final RString ブック開始位置_2 = new RString("02");
    private static final RString ブック開始位置_3 = new RString("03");
    private static final RString ブック開始位置_4 = new RString("04");
    private static final RString ブック開始位置_5 = new RString("05");
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    /**
     * コンストラクタです。
     */
    KarisanteiIdoTsuchishoIkkatsuHakko() {
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * 該当クラスの対象を返す。
     *
     * @return KarisanteiIdoTsuchishoIkkatsuHakko 該当クラスの対象
     */
    public static KarisanteiIdoTsuchishoIkkatsuHakko createInstance() {
        return InstanceProvider.create(KarisanteiIdoTsuchishoIkkatsuHakko.class);
    }

    /**
     * 仮算定異動パラメータの取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 最新調定日時 YMDHMS
     * @return IdofukaJohoTempParameter 仮算定異動パラメータ
     */
    public IdofukaJohoTempParameter get仮算定異動パラメータ(FlexibleYear 調定年度,
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
        return IdofukaJohoTempParameter.createParameter(
                調定年度, 賦課年度, ShoriName.仮算定異動賦課.get名称(), 最新調定日時,
                TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード(),
                TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード(),
                処理日, kozaSearchKey, list, 科目コード);
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
     * 代行プリント送付票を出力するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 帳票ID ReportId
     * @param 発行日 RDate
     * @param 出力期 RString
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力区分 RString
     * @param 山分け区分 RString
     * @param 帳票制御共通情報 DbT7065ChohyoSeigyoKyotsuEntity
     * @param 地方公共団体 Association
     * @param outputOrder IOutputOrder
     * @param 通知書ページ数 Decimal
     */
    public void load代行プリント送付票(FlexibleYear 調定年度, FlexibleYear 賦課年度, ReportId 帳票ID, RDate 発行日,
            RString 出力期, RString 納入通知書対象者, RString 生活保護者先頭出力区分,
            RString 山分け区分, DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報,
            Association 地方公共団体, IOutputOrder outputOrder, Decimal 通知書ページ数) {

        if (帳票制御共通情報 == null || !帳票制御共通情報.getDaikoPrintUmu()) {
            return;
        }

        List<RString> 出力順項目List = new ArrayList<>();
        List<RString> 改ページ項目List = new ArrayList<>();
        set出力順_改頁(outputOrder, 出力順項目List, 改ページ項目List);
        List<Decimal> ページ数List = new ArrayList<>();
        ページ数List.add(通知書ページ数);
        List<RString> 抽出条件List = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_抽出条件);
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(賦課年度.wareki().toDateString()));
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(調定年度.wareki().toDateString()));
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_対象者).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(NotsuKozaShutsuryokuTaisho.toValue(納入通知書対象者).get名称()));
        抽出条件List.add(builder.toRString());

        List<RString> 帳票名List = new ArrayList<>();
        帳票名List.add(代行プリント送付票_帳票名);

        List<RString> 詳細設定List = new ArrayList<>();
        RStringBuilder 詳細設定builder = new RStringBuilder();
        詳細設定builder.append(定数_詳細設定);
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        詳細設定builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(発行日.wareki().toDateString()));
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        詳細設定builder.append(FORMAT_LEFT.concat(定数_出力期).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(出力期) ? RString.EMPTY : 出力期));
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        if (定値区分_0.equals(生活保護者先頭出力区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(生活保護者先頭出力区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        if (定値区分_0.equals(山分け区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(山分け区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        詳細設定List.add(詳細設定builder.toRString());

        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                代行プリント送付票_処理名, 帳票ID.getColumnValue(), 帳票名List, ページ数List, 抽出条件List,
                出力順項目List, 改ページ項目List, 詳細設定List);
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        daikoPrint.print();
    }

    private void set出力順_改頁(IOutputOrder outputOrder, List<RString> 出力順項目List, List<RString> 改ページ項目List) {

        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力順項目List.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改ページ項目List.add(setSortItem.get項目名());
                }
            }
            i = i + INT_1;
        }
    }

    /**
     * 帳票名_特徴仮算定を取得メソッドです。
     *
     * @param 帳票ID RString
     * @return 帳票名_特徴仮算定 RString
     */
    public RString get帳票名_特徴仮算定(RString 帳票ID) {

        if (ReportIdDBB.DBB100003.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100003.getReportName();
        } else if (ReportIdDBB.DBB100004.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100004.getReportName();
        } else if (ReportIdDBB.DBB100005.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100005.getReportName();
        } else if (ReportIdDBB.DBB100006.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100006.getReportName();
        } else if (ReportIdDBB.DBB100008.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100008.getReportName();
        } else if (ReportIdDBB.DBB100009.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100009.getReportName();
        }
        return RString.EMPTY;
    }

    /**
     * 帳票名_変更仮算定を取得メソッドです。
     *
     * @param 帳票ID RString
     * @return 帳票名_変更仮算定 RString
     */
    public RString get帳票名_変更(RString 帳票ID) {

        if (ReportIdDBB.DBB100010.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100010.getReportName();
        } else if (ReportIdDBB.DBB100011.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100011.getReportName();
        }
        return RString.EMPTY;
    }

    /**
     * 帳票名_納入を取得メソッドです。
     *
     * @param 帳票ID RString
     * @return 帳票名_納入 RString
     */
    public RString get帳票名_納入(RString 帳票ID) {

        if (ReportIdDBB.DBB100014.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100014.getReportName();
        } else if (ReportIdDBB.DBB100015.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100015.getReportName();
        } else if (ReportIdDBB.DBB100018.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100018.getReportName();
        } else if (ReportIdDBB.DBB100019.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100019.getReportName();
        } else if (ReportIdDBB.DBB100020.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100020.getReportName();
        } else if (ReportIdDBB.DBB100021.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100021.getReportName();
        } else if (ReportIdDBB.DBB100022.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100022.getReportName();
        } else if (ReportIdDBB.DBB100023.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100023.getReportName();
        } else if (ReportIdDBB.DBB100024.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100024.getReportName();
        } else if (ReportIdDBB.DBB100025.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100025.getReportName();
        } else if (ReportIdDBB.DBB100026.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100026.getReportName();
        } else if (ReportIdDBB.DBB100027.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100027.getReportName();
        } else if (ReportIdDBB.DBB100028.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100028.getReportName();
        } else if (ReportIdDBB.DBB100029.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100029.getReportName();
        }
        return RString.EMPTY;
    }

    /**
     * 出力条件リストを取得するメソッドです。
     *
     * @param 発行日 RDate
     * @param 出力期 RString
     * @param 対象者区分 RString
     * @param 生活保護対象者 RString
     * @param ページごとに山分け RString
     * @return RString 出力条件リスト
     */
    public List<RString> get出力条件リスト(RDate 発行日, RString 出力期, RString 対象者区分, RString 生活保護対象者,
            RString ページごとに山分け) {

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
                .concat(NotsuKozaShutsuryokuTaisho.toValue(対象者区分).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        if (定値区分_0.equals(生活保護対象者)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(生活保護対象者)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        if (定値区分_0.equals(ページごとに山分け)) {
            builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(ページごとに山分け)) {
            builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        出力条件リスト.add(builder.toRString());

        return 出力条件リスト;
    }

    /**
     * 納入通知書の出力期リスト取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 出力方式 RString
     * @param 帳票タイプ RString
     * @param 期月リスト_普徴 KitsukiList
     * @param 仮算定期間 KitsukiList
     * @param 出力期AsInt int
     * @return List<Kitsuki> 出力期リスト
     */
    public List<Kitsuki> get出力期リスト(FlexibleYear 調定年度, RString 出力方式, RString 帳票タイプ,
            KitsukiList 期月リスト_普徴, KitsukiList 仮算定期間, int 出力期AsInt) {

        int 最終期 = 仮算定期間.getLast().get期AsInt();
        if (帳票タイプ_期毎.equals(帳票タイプ) && 別々に出力.equals(出力方式)) {
            最終期 = 出力期AsInt;
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
     * 納入通知書の期月リスト取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 出力方式 RString
     * @param 帳票タイプ RString
     * @param 期月リスト_普徴 KitsukiList
     * @param 仮算定期間 KitsukiList
     * @param 出力期AsInt int
     * @return List<NokiJoho> 期月リスト
     */
    public List<NokiJoho> get期月リスト(FlexibleYear 調定年度, RString 出力方式, RString 帳票タイプ,
            KitsukiList 期月リスト_普徴, KitsukiList 仮算定期間, int 出力期AsInt) {

        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期List = fukaNokiResearcher.get普徴納期ALL();
        int 最終期 = 仮算定期間.getLast().get期AsInt();
        if (帳票タイプ_期毎.equals(帳票タイプ) && 別々に出力.equals(出力方式)) {
            最終期 = 出力期AsInt;
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

    /**
     * 普徴期情報を取得メソッドです。
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
     * 山分け用スプール数を取得するメソッドです。
     *
     * @param 帳票タイプ RString
     * @param 期月List List<NokiJoho>
     * @param 出力期AsInt int
     * @param ページごとに山分け RString
     * @return int 山分け用スプール数
     */
    public int get山分け用スプール数(RString 帳票タイプ, List<NokiJoho> 期月List,
            int 出力期AsInt, RString ページごとに山分け) {
        int 山分け用スプール数 = 0;
        int 月AsInt = 0;
        for (NokiJoho 期月 : 期月List) {
            if (出力期AsInt == 期月.get期月().get期AsInt()) {
                月AsInt = 期月.get期月().get月AsInt();
            }
        }
        if (定値区分_0.equals(ページごとに山分け)) {
            if (帳票タイプ_期毎.equals(帳票タイプ)) {
                山分け用スプール数 = 期月List.size();
            } else if (帳票タイプ_銀振型4.equals(帳票タイプ)) {
                山分け用スプール数 = INT_1;
            } else if (帳票タイプ_ブック.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_ブック(月AsInt, 期月List);
            } else if (帳票タイプ_コンビニ.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_コンビニ(月AsInt, 期月List);
            }
        } else if (定値区分_1.equals(ページごとに山分け)) {
            山分け用スプール数 = INT_1;
        }
        return 山分け用スプール数;
    }

    private int get山分け用スプール数_ブック(int 月AsInt, List<NokiJoho> 普徴納期情報リスト) {

        if (普徴納期情報リスト == null || 普徴納期情報リスト.isEmpty()) {
            return INT_0;
        }
        RString 今回出力期の印字位置 = getブック開始位置(月AsInt);
        if (ブック開始位置_1.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_1(普徴納期情報リスト.size());
        } else if (ブック開始位置_2.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_2(普徴納期情報リスト.size());
        } else if (ブック開始位置_3.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_3(普徴納期情報リスト.size());
        } else if (ブック開始位置_4.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_4(普徴納期情報リスト.size());
        } else if (ブック開始位置_5.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_5(普徴納期情報リスト.size());
        }
        return 0;
    }

    private int get山分け用スプール数Inブック開始位置_1(int 出力期サイズ) {
        return INT_1 <= 出力期サイズ && 出力期サイズ <= INT_5 ? INT_2
                : INT_6 <= 出力期サイズ && 出力期サイズ <= INT_9 ? INT_3
                        : INT_4;
    }

    private int get山分け用スプール数Inブック開始位置_2(int 出力期サイズ) {
        return INT_1 <= 出力期サイズ && 出力期サイズ <= INT_4 ? INT_2
                : INT_5 <= 出力期サイズ && 出力期サイズ <= INT_8 ? INT_3
                        : INT_4;
    }

    private int get山分け用スプール数Inブック開始位置_3(int 出力期サイズ) {
        return INT_1 <= 出力期サイズ && 出力期サイズ <= INT_3 ? INT_2
                : INT_4 <= 出力期サイズ && 出力期サイズ <= INT_7 ? INT_3
                        : INT_4;
    }

    private int get山分け用スプール数Inブック開始位置_4(int 出力期サイズ) {
        return INT_1 <= 出力期サイズ && 出力期サイズ <= INT_2 ? INT_2
                : INT_3 <= 出力期サイズ && 出力期サイズ <= INT_6 ? INT_3
                        : INT_4;
    }

    private int get山分け用スプール数Inブック開始位置_5(int 出力期サイズ) {
        return 出力期サイズ == INT_1 ? INT_2
                : INT_2 <= 出力期サイズ && 出力期サイズ <= INT_5 ? INT_3
                        : INT_6 <= 出力期サイズ && 出力期サイズ <= INT_9 ? INT_4
                                : INT_5;
    }

    private int get山分け用スプール数_コンビニ(int 月AsInt, List<NokiJoho> 普徴納期情報リスト) {

        if (普徴納期情報リスト == null || 普徴納期情報リスト.isEmpty()) {
            return INT_0;
        }
        RString 今回出力期の印字位置 = RString.EMPTY;
        for (NokiJoho 普徴納期情報 : 普徴納期情報リスト) {
            Kitsuki 期月 = 普徴納期情報.get期月();
            if (期月 != null && 期月.get月AsInt() == 月AsInt) {
                今回出力期の印字位置 = getコンビニカット印字位置(期月);
                break;
            }
        }
        int コンビニカット印字位置 = 今回出力期の印字位置.isEmpty() ? 0 : Integer.parseInt(今回出力期の印字位置.toString());
        if (INT_8 <= コンビニカット印字位置) {
            return INT_4;
        } else if (INT_5 <= コンビニカット印字位置 && コンビニカット印字位置 <= INT_7) {
            return INT_3;
        } else if (INT_2 <= コンビニカット印字位置 && コンビニカット印字位置 <= INT_4) {
            return INT_2;
        } else if (INT_1 == コンビニカット印字位置) {
            return INT_1;
        }
        return INT_0;
    }

    private RString getコンビニカット印字位置(Kitsuki 期月) {
        Tsuki 月別 = 期月.get月();
        RDate now = RDate.getNowDate();
        if (Tsuki._4月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置1, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._5月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置2, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._6月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置3, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._7月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置4, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._8月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置5, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._9月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置6, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._10月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置7, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._11月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置8, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._12月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置9, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._1月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置10, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._2月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置11, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._3月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置12, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度4月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置13, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度5月.equals(月別)) {
            return DbBusinessConfig.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置14, now, SubGyomuCode.DBB介護賦課);
        }
        return RString.EMPTY;
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
     * 帳票タイプを取得メソッドです。
     *
     * @param 帳票ID ReportId
     * @return RString 帳票タイプ
     */
    public RString get帳票タイプBy通知書帳票ID(ReportId 帳票ID) {

        RString 帳票タイプ = RString.EMPTY;
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID) || ReportIdDBB.DBB100015.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100028.getReportId().equals(帳票ID) || ReportIdDBB.DBB100029.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_期毎;
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID) || ReportIdDBB.DBB100019.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型4;
        } else if (ReportIdDBB.DBB100020.getReportId().equals(帳票ID) || ReportIdDBB.DBB100021.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100022.getReportId().equals(帳票ID) || ReportIdDBB.DBB100023.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_ブック;
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID) || ReportIdDBB.DBB100025.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100026.getReportId().equals(帳票ID) || ReportIdDBB.DBB100027.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_コンビニ;
        }
        return 帳票タイプ;
    }

    /**
     * 通知書共通情報取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 出力期 RString
     * @return TsuchishoKyotsuEntity 通知書共通情報
     */
    public TsuchishoKyotsuEntity get通知書共通情報(FlexibleYear 調定年度, RString 出力期) {

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        int 最終期 = 仮算定期間.getLast().get期AsInt();
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期List = fukaNokiResearcher.get普徴納期ALL();
        List<Kitsuki> 仮算定期間List = 仮算定期間.toList();
        int 最初期;
        if (RString.isNullOrEmpty(出力期) && 最終期 != 0) {
            最初期 = 仮算定期間List.get(仮算定期間List.size() - INT_1).get期AsInt();
        } else if (!RString.isNullOrEmpty(出力期)) {
            最初期 = Integer.parseInt(出力期.toString());
        } else {
            最初期 = 0;
        }
        KitsukiList 期月リスト = 期月リスト_普徴.subListBy期(最初期, 最終期);
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 期月リスト.toList()) {
            for (Noki 普徴納期 : 普徴納期List) {
                if (期月.get期AsInt() == 普徴納期.get期別() && !定値区分_0.equals(get印字位置(期月.get月AsInt()))) {
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
        for (int index = INT_1; index <= INT_3; index++) {
            Kitsuki 期月情報 = 期月リスト_特徴.get期の最初月(index);
            Noki 特徴納期 = fukaNokiResearcher.get特徴納期(index);
            NokiJoho nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月情報);
            nokiJoho.set納期(特徴納期);
            特徴納期情報リスト.add(nokiJoho);
        }

        TsuchishoKyotsuEntity 通知書共通情報entity = new TsuchishoKyotsuEntity();
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

}
