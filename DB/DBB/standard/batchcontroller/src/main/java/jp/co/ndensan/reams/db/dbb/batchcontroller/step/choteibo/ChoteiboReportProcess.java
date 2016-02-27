/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.choteibo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboReport;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DanKai;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiChoteigakuShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuShokei;
import jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo.ChoteiboProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportId.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ChoteigakuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DanKaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DangatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiTksaiToFusaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GenmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiBubunEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiBubunSoukeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuShokeiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.NaiheisyaKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.NendoDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.SaishutsuKampuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.SonotaBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.TokuchoKibetusDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ZengatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.choteibo.IChoteiboSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.choteibo.ChoteiboShukei;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 調定簿作成帳票用Processクラスです。
 */
public class ChoteiboReportProcess extends SimpleBatchProcessBase {

    private static final int 当月フラグ = 1;
    private static final int 前月フラグ = 0;
    private static final int 第1期 = 1;
    private static final int 第2期 = 2;
    private static final int 第3期 = 3;
    private static final int 第4期 = 4;
    private static final int 第5期 = 5;
    private static final int 第6期 = 6;
    private static final int 第7期 = 7;
    private static final int 第8期 = 8;
    private static final int 第9期 = 9;
    private static final int 第10期 = 10;
    private static final int 第11期 = 11;
    private static final int 第12期 = 12;
    private static final int 第13期 = 13;
    private static final int 第14期 = 14;
    private static final RString SHORINENDO_NAME = new RString("【処理年度】");
    private static final RString STARTCHOTEINICHIJI_NAME = new RString("【開始調定日時】");
    private static final RString ENDCHOTEINICHIJI_NAME = new RString("【終了調定日時】");
    private static final RString JOBNO_NAME = new RString("【ジョブ番号】");
    private static final RString BREAKKEY_NENDOTITLE = new RString("nendoTitle");
    private static final RString KEY_CHOTEINENDO = new RString("choteiNendo");
    private static final RString KEY_FUKANENDO = new RString("fukaNendo");
    private static final RString KEY_CHUSHUTSUSTYMD = new RString("chushutsuStYMD");
    private static final RString KEY_CHUSHUTSUENDYMD = new RString("chushutsuEdYMD");
    private static final RString KEY_CHUSHUHOUHOU = new RString("choshuHouhou");
    private static final RString KEY_DANNENDO = new RString("danNendo");
    private static final RString KEY_ZENNENDO = new RString("zenNendo");
    private static final RString KEY_ZENZENNENDO = new RString("zenzenNendo");
    private static final RString KEY_DOGETSUFLG = new RString("dogetsuFlag");
    private IChoteiboSakuseiMapper choteiboSakuseiMapper;
    private HokenryoDankaiSettings 保険料段階取得Mgr;
    private List<NendoDataEntity> 年度データリスト;
    private List<GokeiDataEntity> 合計データリスト;
    @BatchWriter
    private BatchReportWriter<ChoteiboSource> batchReportWriter;
    private ReportSourceWriter<ChoteiboSource> reportSourceWriter;
    private ChoteiboProcessParameter parameter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        choteiboSakuseiMapper = getMapper(IChoteiboSakuseiMapper.class);
        保険料段階取得Mgr = new HokenryoDankaiSettings();
        年度データリスト = new ArrayList<>();
        合計データリスト = new ArrayList<>();
        createTempTable();
    }

    @Override
    protected void process() {
        当年度の賦課情報の取得();
        前年度の賦課情報の取得();
        前々年度の賦課情報の取得();
        合計部分の情報の取得();
        帳票用Entityリストを作成する();
        作成したdataを帳票に引き渡す();
        バッチ出力条件リストの出力();
    }

    @Override
    protected void afterExecute() {
        dropTempTable();
        batchReportWriter.close();
    }

    /**
     * 一時テーブルを作成します。
     */
    public void createTempTable() {
        choteiboSakuseiMapper.createTmpKibetsu();
        choteiboSakuseiMapper.createTmpDankai();
        choteiboSakuseiMapper.createTmpKibetsuShokei();
        choteiboSakuseiMapper.createTmpDankaiShokei();
        choteiboSakuseiMapper.createTmpKibetsuGokei();
        choteiboSakuseiMapper.createTmpDankaiGokei();
        choteiboSakuseiMapper.createTmpGokeiBubun();
        choteiboSakuseiMapper.createTmpGokeiBubunSoukei();
    }

    private void 当年度の賦課情報の取得() {
        create年度データ(
                parameter.getShoriNendo(),
                parameter.getShoriNendo(),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
    }

    private void 前年度の賦課情報の取得() {
        create年度データ(
                parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(1),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
    }

    private void 前々年度の賦課情報の取得() {
        create年度データ(
                parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(2),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
    }

    private void 帳票用Entityリストを作成する() {
        List<NendoDataEntity> 当年度データリスト = get年度データリスト(
                parameter.getShoriNendo(),
                parameter.getShoriNendo());
        List<NendoDataEntity> 前年度データリスト = get年度データリスト(
                parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(1));
        List<NendoDataEntity> 前々年度データリスト = get年度データリスト(
                parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(2));
        年度データリスト = new ArrayList<>();
        年度データリスト.addAll(当年度データリスト);
        年度データリスト.addAll(前年度データリスト);
        年度データリスト.addAll(前々年度データリスト);
        合計データリスト = get合計データリスト();
    }

    private void 作成したdataを帳票に引き渡す() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB3001.getReportId().value())
                .addBreak(new BreakerCatalog<ChoteiboSource>().simplePageBreaker(BREAKKEY_NENDOTITLE))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        ChoteiboReport report = ChoteiboReport.createForm(
                parameter.getShoriNendo(), parameter.getChushutsuStYMD(), parameter.getChushutsuEdYMD(),
                年度データリスト, 合計データリスト);
//        report.set当年度処理日付(処理日付管理マスタMgr.get抽出調定日時(
//                SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(), parameter.getShoriNendo()));
//        report.set前年度処理日付(処理日付管理マスタMgr.get抽出調定日時(
//                SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(), parameter.getShoriNendo().minusYear(1)));
//        report.set前々年度処理日付(処理日付管理マスタMgr.get抽出調定日時(
//                SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(), parameter.getShoriNendo().minusYear(2)));
        report.set当年度保険料段階リスト(保険料段階取得Mgr.get保険料段階ListIn(parameter.getShoriNendo()));
//        report.set前年度保険料段階リスト(保険料段階取得Mgr.get保険料段階ListIn(parameter.getShoriNendo().minusYear(1)));
//        report.set前々年度保険料段階リスト(保険料段階取得Mgr.get保険料段階ListIn(parameter.getShoriNendo().minusYear(2)));
        report.writeBy(reportSourceWriter);
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RStringBuilder builder = new RStringBuilder();
        builder.append(JOBNO_NAME);
        builder.append(" ");
        builder.append(JobContextHolder.getJobId());
        RString ジョブ番号 = builder.toRString();
        RString 帳票名 = ReportIdDBB.DBB3001.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = new RString("-");
        List<RString> 出力条件 = new ArrayList<>();
        builder.append(SHORINENDO_NAME);
        builder.append(parameter.getShoriNendo().wareki().toDateString());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(STARTCHOTEINICHIJI_NAME);
        builder.append(parameter.getChushutsuStYMD().wareki().toDateString());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(ENDCHOTEINICHIJI_NAME);
        builder.append(parameter.getChushutsuEdYMD().wareki().toDateString());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB3001.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    /**
     * 一時テーブルを削除します。
     */
    public void dropTempTable() {
        choteiboSakuseiMapper.dropTmpKibetsu();
        choteiboSakuseiMapper.dropTmpDankai();
        choteiboSakuseiMapper.dropTmpKibetsuShokei();
        choteiboSakuseiMapper.dropTmpDankaiShokei();
        choteiboSakuseiMapper.dropTmpKibetsuGokei();
        choteiboSakuseiMapper.dropTmpDankaiGokei();
        choteiboSakuseiMapper.dropTmpGokeiBubun();
        choteiboSakuseiMapper.dropTmpGokeiBubunSoukei();
    }

    /**
     * 年度データリストを作成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    public void create年度データ(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        insert期別情報一時テーブル(調定年度, 賦課年度, 開始調定日時, 終了調定日時);
        insert段階情報一時テーブル(調定年度, 賦課年度, 開始調定日時, 終了調定日時);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.code(), 当月フラグ);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.code(), 前月フラグ);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.code(), 当月フラグ);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.code(), 前月フラグ);

        update内併徴者数(調定年度, 賦課年度);

        insert期別小計一時テーブル(調定年度, 賦課年度);

        update調定額の小計(調定年度, 賦課年度);

        insert合計一時テーブル(調定年度, 賦課年度);

        update調定額の合計(調定年度, 賦課年度);

        update減免の件数と減免額(調定年度, 賦課年度, 開始調定日時, 終了調定日時);

        update歳出還付の件数と金額(調定年度, 賦課年度);
    }

    /**
     * 合計データリストを作成します。
     *
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void 合計部分の情報の取得() {
        FlexibleYear 調定年度 = parameter.getShoriNendo();
        FlexibleYear 当年度 = 調定年度;
        FlexibleYear 前年度 = 調定年度.minusYear(1);
        FlexibleYear 前々年度 = 調定年度.minusYear(2);
        insert合計部分一時テーブル_特別徴収(調定年度, 当年度, 前年度, 前々年度);
        insert合計部分一時テーブル_普通徴収(調定年度, 当年度, 前年度, 前々年度);
        update当月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度);
        update前月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度);
        update段階の特徴と普徴者数(調定年度, 当年度, 前年度, 前々年度);

        insert合計部分総計一時テーブル(調定年度, 当年度, 前年度, 前々年度);
        updateその他部分のデータ(調定年度, 当年度, 前年度, 前々年度);
    }

    /**
     * 期別情報一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    private void insert期別情報一時テーブル(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUTSUSTYMD.toString(), 開始調定日時);
        param.put(KEY_CHUSHUTSUENDYMD.toString(), 終了調定日時);
        List<KibetsuDataEntity> kibetsuData = choteiboSakuseiMapper.get期別のデータ(param);
        for (KibetsuDataEntity entity : kibetsuData) {
            KibetsuEntity kibetsuEntity = new KibetsuEntity();
            kibetsuEntity.setChoteiNendo(entity.getChoteiNendo());
            kibetsuEntity.setFukaNendo(entity.getFukaNendo());
            kibetsuEntity.setTsuchishoNo(entity.getTsuchishoNo());
            kibetsuEntity.setRirekiNo(entity.getRirekiNo());
            kibetsuEntity.setHihokenshaNo(entity.getHihokenshaNo());
            kibetsuEntity.setChoshuHouhou(entity.getChoshuHouhou());
            kibetsuEntity.setKi(entity.getKi());
            kibetsuEntity.setChoteiId(entity.getChoteiId());
            switch (entity.getKi()) {
                case 第1期:
                    kibetsuEntity.setDai1kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第2期:
                    kibetsuEntity.setDai2kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第3期:
                    kibetsuEntity.setDai3kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第4期:
                    kibetsuEntity.setDai4kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第5期:
                    kibetsuEntity.setDai5kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第6期:
                    kibetsuEntity.setDai6kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第7期:
                    kibetsuEntity.setDai7kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第8期:
                    kibetsuEntity.setDai8kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第9期:
                    kibetsuEntity.setDai9kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第10期:
                    kibetsuEntity.setDai10kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第11期:
                    kibetsuEntity.setDai11kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第12期:
                    kibetsuEntity.setDai12kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第13期:
                    kibetsuEntity.setDai13kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第14期:
                    kibetsuEntity.setDai14kiChoteiGaku(entity.getChoteigaku());
                    break;
                default:
                    break;
            }
            choteiboSakuseiMapper.insertTmpKibetsu(kibetsuEntity);
        }
    }

    /**
     * 段階情報一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    private void insert段階情報一時テーブル(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUTSUSTYMD.toString(), 開始調定日時);
        param.put(KEY_CHUSHUTSUENDYMD.toString(), 終了調定日時);
        List<DankaiDataEntity> dogetsudankaiData = choteiboSakuseiMapper.get当月末の段階データ(param);
        for (DankaiDataEntity entity : dogetsudankaiData) {
            DanKaiEntity dankaiEntity = new DanKaiEntity();
            dankaiEntity.setChoteiNendo(entity.getChoteiNendo());
            dankaiEntity.setFukaNendo(entity.getFukaNendo());
            dankaiEntity.setTsuchishoNo(entity.getTsuchishoNo());
            dankaiEntity.setRirekiNo(entity.getRirekiNo());
            dankaiEntity.setHihokenshaNo(entity.getHihokenshaNo());
            dankaiEntity.setDankai(entity.getDankai());
            dankaiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            dankaiEntity.setChoteiId(entity.getChoteiId());
            dankaiEntity.setDogetsuFlag(1);
            dankaiEntity.setZengetsusueChoteigaku(null);
            dankaiEntity.setFueChoteigaku(null);
            dankaiEntity.setGenChoteigaku(null);
            dankaiEntity.setDogetsusueChoteigaku(entity.getChoteigaku());
            choteiboSakuseiMapper.insertTmpDankai(dankaiEntity);
        }

        List<DankaiDataEntity> zengetsudankaiData = choteiboSakuseiMapper.get前月末の段階データ(param);
        for (DankaiDataEntity entity : zengetsudankaiData) {
            DanKaiEntity dankaiEntity = new DanKaiEntity();
            dankaiEntity.setChoteiNendo(entity.getChoteiNendo());
            dankaiEntity.setFukaNendo(entity.getFukaNendo());
            dankaiEntity.setTsuchishoNo(entity.getTsuchishoNo());
            dankaiEntity.setRirekiNo(entity.getRirekiNo());
            dankaiEntity.setHihokenshaNo(entity.getHihokenshaNo());
            dankaiEntity.setDankai(entity.getDankai());
            dankaiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            dankaiEntity.setChoteiId(entity.getChoteiId());
            dankaiEntity.setDogetsuFlag(0);
            dankaiEntity.setZengetsusueChoteigaku(entity.getChoteigaku());
            dankaiEntity.setFueChoteigaku(null);
            dankaiEntity.setGenChoteigaku(null);
            dankaiEntity.setDogetsusueChoteigaku(null);
            choteiboSakuseiMapper.insertTmpDankai(dankaiEntity);
        }
    }

    /**
     * 段階小計一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     */
    private void insert段階小計一時テーブル(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            int 当月フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUHOUHOU.toString(), 徴収方法);
        param.put(KEY_DOGETSUFLG.toString(), 当月フラグ);
        List<DankaiKensuEntity> dankaiKensu = choteiboSakuseiMapper.get所得段階の件数(param);
        for (DankaiKensuEntity entity : dankaiKensu) {
            DankaiShokeiEntity dankaiShokeiEntity = new DankaiShokeiEntity();
            dankaiShokeiEntity.setChoteiNendo(調定年度);
            dankaiShokeiEntity.setFukaNendo(賦課年度);
            dankaiShokeiEntity.setChoshuHouhou(徴収方法);
            dankaiShokeiEntity.setDankai(entity.getDankai());
            dankaiShokeiEntity.setDogetsuFlag(当月フラグ);
            if (当月フラグ == 1) {
                dankaiShokeiEntity.setDogetsusueKensu(entity.getDankaiKensu());
            } else if (当月フラグ == 0) {
                dankaiShokeiEntity.setZengetsusueKensu(entity.getDankaiKensu());
            }
            if (ChoshuHohoKibetsu.特別徴収.code().equals(徴収方法)) {
                dankaiShokeiEntity.setTokuchosyaKensu(entity.getDankaiKensu());
            } else if (ChoshuHohoKibetsu.普通徴収.code().equals(徴収方法)) {
                dankaiShokeiEntity.setFuchosyaKensu(entity.getDankaiKensu());
            }
            choteiboSakuseiMapper.insertTmpDankaiShokei(dankaiShokeiEntity);
        }
    }

    /**
     * 内併徴者数に段階小計一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update内併徴者数(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<NaiheisyaKensuEntity> naiheisyaKensu = choteiboSakuseiMapper.get内併徴者数(param);
        for (NaiheisyaKensuEntity entity : naiheisyaKensu) {
            choteiboSakuseiMapper.update内併徴者数(entity);
        }
    }

    /**
     * 期別小計一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void insert期別小計一時テーブル(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<KibetsuShokei> kibetsuShokei = ChoteiboShukei.kibetsuChoteigakuShokei(
                create期別リスト(調定年度, 賦課年度));
        for (KibetsuShokei entity : kibetsuShokei) {
            KibetsuShokeiEntity kibetsuShokeiEntity = new KibetsuShokeiEntity();
            kibetsuShokeiEntity.setChoteiNendo(entity.getChoteiNendo());
            kibetsuShokeiEntity.setFukaNendo(entity.getFukaNendo());
            kibetsuShokeiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            kibetsuShokeiEntity.setDai1kiChoteigakuCount(entity.getDai1kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai2kiChoteigakuCount(entity.getDai2kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai3kiChoteigakuCount(entity.getDai3kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai4kiChoteigakuCount(entity.getDai4kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai5kiChoteigakuCount(entity.getDai5kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai6kiChoteigakuCount(entity.getDai6kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai7kiChoteigakuCount(entity.getDai7kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai8kiChoteigakuCount(entity.getDai8kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai9kiChoteigakuCount(entity.getDai9kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai10kiChoteigakuCount(entity.getDai10kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai11kiChoteigakuCount(entity.getDai11kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai12kiChoteigakuCount(entity.getDai12kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai13kiChoteigakuCount(entity.getDai13kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai14kiChoteigakuCount(entity.getDai14kiChoteiGakuCount());
            choteiboSakuseiMapper.insertTmpKibetsuShokei(kibetsuShokeiEntity);
        }
    }

    /**
     * 調定額の小計に段階小計一時テーブルに更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update調定額の小計(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<DankaiChoteigakuShokei> shokeiList = ChoteiboShukei.dankaiChoteigakuShokei(
                create段階リスト(調定年度, 賦課年度));
        for (DankaiChoteigakuShokei shokei : shokeiList) {
            choteiboSakuseiMapper.update調定額の小計(shokei);
        }
    }

    /**
     * 期別リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<KiBetsu>
     */
    private List<Kibetsu> create期別リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<Kibetsu> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<KibetsuEntity> kiBetsuEntity = choteiboSakuseiMapper.select期別情報(param);
        for (KibetsuEntity entity : kiBetsuEntity) {
            Kibetsu kibetsu = Kibetsu.createParam(
                    entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getTsuchishoNo(),
                    entity.getRirekiNo(),
                    entity.getHihokenshaNo(),
                    entity.getChoshuHouhou(),
                    entity.getKi(),
                    entity.getChoteiId(),
                    entity.getDai1kiChoteiGaku(),
                    entity.getDai2kiChoteiGaku(),
                    entity.getDai3kiChoteiGaku(),
                    entity.getDai4kiChoteiGaku(),
                    entity.getDai5kiChoteiGaku(),
                    entity.getDai6kiChoteiGaku(),
                    entity.getDai7kiChoteiGaku(),
                    entity.getDai8kiChoteiGaku(),
                    entity.getDai9kiChoteiGaku(),
                    entity.getDai10kiChoteiGaku(),
                    entity.getDai11kiChoteiGaku(),
                    entity.getDai12kiChoteiGaku(),
                    entity.getDai13kiChoteiGaku(),
                    entity.getDai14kiChoteiGaku()
            );
            list.add(kibetsu);
        }
        return list;
    }

    /**
     * 段階リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<DanKai>
     */
    private List<DanKai> create段階リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<DanKai> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<DanKaiEntity> danKaiList = choteiboSakuseiMapper.select段階情報(param);
        for (DanKaiEntity entity : danKaiList) {
            DanKai dankai = DanKai.createParam(entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getTsuchishoNo(),
                    entity.getRirekiNo(),
                    entity.getHihokenshaNo(),
                    entity.getDankai(),
                    entity.getChoshuHouhou(),
                    entity.getChoteiId(),
                    entity.getDogetsuFlag(),
                    entity.getZengetsusueChoteigaku(),
                    entity.getFueChoteigaku(),
                    entity.getGenChoteigaku(),
                    entity.getDogetsusueChoteigaku()
            );
            list.add(dankai);
        }
        return list;
    }

    /**
     * 期別小計リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<KibetsuShokei>
     */
    private List<KibetsuShokei> create期別小計リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<KibetsuShokei> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<KibetsuShokeiEntity> kibetsuShokeiList = choteiboSakuseiMapper.select期別小計情報(param);
        for (KibetsuShokeiEntity entity : kibetsuShokeiList) {
            KibetsuShokei kibetsuShokei = KibetsuShokei.createParam(entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getChoshuHouhou(),
                    entity.getDai1kiChoteigakuCount(),
                    entity.getDai2kiChoteigakuCount(),
                    entity.getDai3kiChoteigakuCount(),
                    entity.getDai4kiChoteigakuCount(),
                    entity.getDai5kiChoteigakuCount(),
                    entity.getDai6kiChoteigakuCount(),
                    entity.getDai7kiChoteigakuCount(),
                    entity.getDai8kiChoteigakuCount(),
                    entity.getDai9kiChoteigakuCount(),
                    entity.getDai10kiChoteigakuCount(),
                    entity.getDai11kiChoteigakuCount(),
                    entity.getDai12kiChoteigakuCount(),
                    entity.getDai13kiChoteigakuCount(),
                    entity.getDai14kiChoteigakuCount()
            );
            list.add(kibetsuShokei);
        }
        return list;
    }

    /**
     * 段階小計リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<DankaiShokei>
     */
    private List<DankaiShokei> create段階小計リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<DankaiShokei> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<DankaiShokeiEntity> dankaiShokeiList = choteiboSakuseiMapper.select段階小計情報(param);
        for (DankaiShokeiEntity entity : dankaiShokeiList) {
            DankaiShokei dankaiShokei = DankaiShokei.createParam(entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getChoshuHouhou(),
                    entity.getDankai(),
                    entity.getDogetsuFlag(),
                    entity.getZengetsusueKensu(),
                    entity.getZengetsusueChoteigakuCount(),
                    entity.getFueKensu(),
                    entity.getFueChoteigakuCount(),
                    entity.getGenKensu(),
                    entity.getGenChoteigakuCount(),
                    entity.getDogetsusueKensu(),
                    entity.getDogetsusueChoteigakuCount(),
                    entity.getTokuchosyaKensu(),
                    entity.getFuchosyaKensu(),
                    entity.getNaiheisyaKensu());
            list.add(dankaiShokei);
        }
        return list;
    }

    /**
     * 期別/段階合計一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void insert合計一時テーブル(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<Gokei> gokeiList = new ArrayList<>();
        Gokei gokei = Gokei.createParam(create期別小計リスト(調定年度, 賦課年度),
                create段階小計リスト(調定年度, 賦課年度));
        gokeiList.add(gokei);
        List<Gokeigo> gokeigoList = ChoteiboShukei.choteiboDataGokei(gokeiList);
        for (Gokeigo list : gokeigoList) {
            List<KibetsuGokeigo> kibetsuGokeigoList = list.getKibetsuGokeigoList();
            for (KibetsuGokeigo param : kibetsuGokeigoList) {
                KibetsuGokeiEntity kibetsuGokeiEntity = new KibetsuGokeiEntity();
                kibetsuGokeiEntity.setChoteiNendo(param.getChoteiNendo());
                kibetsuGokeiEntity.setFukaNendo(param.getFukaNendo());
                kibetsuGokeiEntity.setChoshuHouhou(param.getChoshuHouhou());
                kibetsuGokeiEntity.setTobetsuChoteigakuCount(param.getTobetsuChoteiGakuCount());
                kibetsuGokeiEntity.setFutsuChoteigakuCount(param.getFutsuChoteiGakuCount());
                kibetsuGokeiEntity.setTobetsuTofutsuChoteigakuCount(param.getTobetsuTofutsuChoteiGakuCount());
                kibetsuGokeiEntity.setGenmenCount(null);
                kibetsuGokeiEntity.setGenmenChoteigaku(null);
                kibetsuGokeiEntity.setTkSaishutsuKampuCount(null);
                kibetsuGokeiEntity.setTkSaishutsuKampuChoteigaku(null);
                kibetsuGokeiEntity.setFuSaishutsuKampuCount(null);
                kibetsuGokeiEntity.setFuSaishutsuKampuChoteigaku(null);
                choteiboSakuseiMapper.insertTmpKibetsuGokei(kibetsuGokeiEntity);
            }

            List<DankaiGokeigo> dankaiGokeigoList = list.getDankaiGokeigoList();
            for (DankaiGokeigo param : dankaiGokeigoList) {
                DankaiGokeiEntity dankaiGokeiEntity = new DankaiGokeiEntity();
                dankaiGokeiEntity.setChoteiNendo(param.getChoteiNendo());
                dankaiGokeiEntity.setFukaNendo(param.getFukaNendo());
                dankaiGokeiEntity.setChoshuHouhou(param.getChoshuHouhou());
                if (null != param.getDogetsuFlag()) {
                    dankaiGokeiEntity.setDogetsuFlag(param.getDogetsuFlag());
                }
                dankaiGokeiEntity.setZengetsusueKensuCount(param.getZengetsusueKensuCount());
                dankaiGokeiEntity.setZengetsusueChoteigakuCount(param.getZengetsusueChoteigakuCount());
                dankaiGokeiEntity.setFueZennbuKennsuuGokei(null);
                dankaiGokeiEntity.setFueZennbuChoteigakuGokei(null);
                dankaiGokeiEntity.setGenZennbuKennsuuGokei(null);
                dankaiGokeiEntity.setGenZennbuChoteigakuGokei(null);
                dankaiGokeiEntity.setDogetsusueKensuCount(param.getDogetsusueKensuCount());
                dankaiGokeiEntity.setDogetsusueChoteigakuCount(param.getDogetsusueChoteigakuCount());
                dankaiGokeiEntity.setTokuchosyaKensuCount(param.getTokuchosyaKensuCount());
                dankaiGokeiEntity.setFuchosyaKensuCount(param.getFuchosyaKensuCount());
                dankaiGokeiEntity.setNaiheisyaKensuCount(param.getNaiheisyaKensuCount());
                choteiboSakuseiMapper.insertTmpDankaiGokei(dankaiGokeiEntity);
            }
        }
    }

    /**
     * 調定額の合計に段階合計一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update調定額の合計(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<ChoteigakuGokeiEntity> tmpFueEntity = choteiboSakuseiMapper.get増の全部調定額の合計(param);
        for (ChoteigakuGokeiEntity entity : tmpFueEntity) {
            choteiboSakuseiMapper.update増の調定額の合計(entity);
        }

        List<ChoteigakuGokeiEntity> tmpGenEntity = choteiboSakuseiMapper.get減の全部調定額の合計(param);
        for (ChoteigakuGokeiEntity entity : tmpGenEntity) {
            choteiboSakuseiMapper.update減の調定額の合計(entity);
        }
    }

    /**
     * 減免の件数と減免額に減免の件数と減免額を更新します
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    private void update減免の件数と減免額(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUTSUSTYMD.toString(), 開始調定日時);
        param.put(KEY_CHUSHUTSUENDYMD.toString(), 終了調定日時);
        List<GenmenEntity> denmenEntity = choteiboSakuseiMapper.get減免の件数と減免額(param);
        for (GenmenEntity entity : denmenEntity) {
            choteiboSakuseiMapper.update減免の件数と減免額(entity);
        }
    }

    /**
     * 期別合計一時テーブルに歳出還付の件数と歳出還付の調定額の更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update歳出還付の件数と金額(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);

        List<SaishutsuKampuEntity> tmpTkEntity = choteiboSakuseiMapper.get特徴歳出還付情報(param);
        for (SaishutsuKampuEntity entity : tmpTkEntity) {
            choteiboSakuseiMapper.update特徴歳出還付(entity);
        }
        List<SaishutsuKampuEntity> tmpFuEntity = choteiboSakuseiMapper.get普徴歳出還付情報(param);
        for (SaishutsuKampuEntity entity : tmpFuEntity) {
            choteiboSakuseiMapper.update普徴歳出還付(entity);
        }
    }

    /**
     * 「特別徴収」の場合、期別のデータに合計部分一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void insert合計部分一時テーブル_特別徴収(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_CHUSHUHOUHOU.toString(), ChoshuHohoKibetsu.特別徴収.code());

        List<TokuchoKibetusDataEntity> tokuchoKibetusDataList = choteiboSakuseiMapper.get特徴期別のデータ(param);
        for (TokuchoKibetusDataEntity entity : tokuchoKibetusDataList) {
            GokeiBubunEntity gokeiBubunEntity = new GokeiBubunEntity();
            gokeiBubunEntity.setChoshuHouhou(entity.getChoshuHouhou());
            gokeiBubunEntity.setChoteigaku4GatsuCount(entity.getDai1kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku6GatsuCount(entity.getDai2kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku8GatsuCount(entity.getDai3kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku10GatsuCount(entity.getDai4kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku12GatsuCount(entity.getDai5kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku2GatsuCount(entity.getDai6kiChoteigakuGokei());
            choteiboSakuseiMapper.insertTmpGokeiBubun(gokeiBubunEntity);
        }
    }

    /**
     * 「普通徴収」の場合、期別のデータに合計部分一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 徴収方法 徴収方法
     */
    private void insert合計部分一時テーブル_普通徴収(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_CHUSHUHOUHOU.toString(), ChoshuHohoKibetsu.普通徴収.code());

        List<KibetsuShokeiEntity> kibetsuShokeiList = choteiboSakuseiMapper.get普徴期別小計情報(param);
        List<KibetsuShokeiGokeiEntity> kibetsuShokeiGokeiList = choteiboSakuseiMapper.get期別小計の合計情報(param);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KanendoKiUtil 月期対応取得_過年度 = new KanendoKiUtil();
        KitsukiList 期月リスト_過年度 = 月期対応取得_過年度.get期月リスト();
        GokeiBubunEntity gokeiBubunEntity = new GokeiBubunEntity();
        gokeiBubunEntity.setChoshuHouhou(ChoshuHohoKibetsu.普通徴収.code());
        for (KibetsuShokeiEntity entity : kibetsuShokeiList) {
            int 期 = 期月リスト_普徴.get月の期(Tsuki._4月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._4月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._5月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._5月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._6月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._6月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._7月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._7月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._8月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._8月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._9月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._9月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._10月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._10月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._11月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._11月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._12月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._12月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._1月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._1月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._2月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._2月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._3月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._3月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki.翌年度4月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki.翌年度4月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki.翌年度5月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki.翌年度5月, entity.get調定額の小計By期別(期));
        }
        for (KibetsuShokeiGokeiEntity entity : kibetsuShokeiGokeiList) {
            int 期 = 期月リスト_過年度.get月の期(Tsuki._4月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._4月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._5月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._5月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._6月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._6月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._7月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._7月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._8月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._8月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._9月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._9月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._10月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._10月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._11月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._11月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._12月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._12月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._1月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._1月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._2月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._2月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._3月).get期AsInt();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._3月, entity.get調定額の合計By期別(期));
//            期 = 期月リスト_過年度.get月の期(Tsuki.翌年度4月).get期AsInt();
//            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki.翌年度4月, entity.get調定額の合計By期別(期));
//            期 = 期月リスト_過年度.get月の期(Tsuki.翌年度5月).get期AsInt();
//            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki.翌年度5月, entity.get調定額の合計By期別(期));
        }
        choteiboSakuseiMapper.insertTmpGokeiBubun(gokeiBubunEntity);
    }

    /**
     * 当月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 当月フラグ 当月フラグ
     */
    private void update当月末の段階のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_DOGETSUFLG.toString(), 当月フラグ);

        List<DangatsuDankaiDataEntity> dangatsuDankaiDataList = choteiboSakuseiMapper.get当月末の段階のデータ(param);
        for (DangatsuDankaiDataEntity entity : dangatsuDankaiDataList) {
            choteiboSakuseiMapper.update当月末の段階のデータ(entity);
        }
    }

    /**
     * 前月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 当月フラグ 当月フラグ
     */
    private void update前月末の段階のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_DOGETSUFLG.toString(), 前月フラグ);

        List<ZengatsuDankaiDataEntity> zengatsuDankaiDataList = choteiboSakuseiMapper.get前月末の段階のデータ(param);
        for (ZengatsuDankaiDataEntity entity : zengatsuDankaiDataList) {
            choteiboSakuseiMapper.update前月末の段階のデータ(entity);
        }
    }

    /**
     * 所得段階の特徴/普徴者数の集計に合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void update段階の特徴と普徴者数(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);

        List<DankaiTksaiToFusaiKensuEntity> dankaiTksaiToFusaiKensuList
                = choteiboSakuseiMapper.get段階の特徴と普徴者数(param);
        for (DankaiTksaiToFusaiKensuEntity entity : dankaiTksaiToFusaiKensuList) {
            choteiboSakuseiMapper.update段階の特徴と普徴者数(entity);
        }
    }

    /**
     * 期別部分の集計に合計部分総計一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void insert合計部分総計一時テーブル(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);

        List<KibetsuBubunDataEntity> kibetsuBubunDataList = choteiboSakuseiMapper.get期別部分のデータ(param);
        for (KibetsuBubunDataEntity entity : kibetsuBubunDataList) {
            GokeiBubunSoukeiEntity gokeiBubunSoukeiEntity = new GokeiBubunSoukeiEntity();
            gokeiBubunSoukeiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            gokeiBubunSoukeiEntity.setTobetsuChoteigakuSoukei(entity.getTobetsuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setFutsuChoteigakuSoukei(entity.getFutsuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setTobetsuTofutsuChoteigakuSoukei(entity.getTobetsuTofutsuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setGenmenSoukei(entity.getGenmenSoukei());
            gokeiBubunSoukeiEntity.setGenmenChoteigakuSoukei(entity.getGenmenChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setTkSaishutsuKampuSoukei(entity.getTkSaishutsuKampuSoukei());
            gokeiBubunSoukeiEntity.setTkSaishutsuKampuChoteigakuSoukei(entity.getTkSaishutsuKampuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setFuSaishutsuKampuSoukei(entity.getFuSaishutsuKampuSoukei());
            gokeiBubunSoukeiEntity.setFuSaishutsuKampuChoteigakuSoukei(entity.getFuSaishutsuKampuChoteigakuSoukei());
            choteiboSakuseiMapper.insertTmpGokeiBubunSoukei(gokeiBubunSoukeiEntity);
        }
    }

    /**
     * その他部分の集計に合計部分総計一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void updateその他部分のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);

        List<SonotaBubunDataEntity> sonotaBubunDataList = choteiboSakuseiMapper.getその他部分のデータ(param);
        for (SonotaBubunDataEntity entity : sonotaBubunDataList) {
            choteiboSakuseiMapper.updateその他部分のデータ(entity);
        }
    }

    private List<GokeiDataEntity> get合計データリスト() {
        List<GokeiDataEntity> 合計データリスト = new ArrayList<>();
        List<GokeiBubunEntity> 合計部分情報リスト = choteiboSakuseiMapper.selectAll合計部分情報();
        List<GokeiBubunSoukeiEntity> 合計部分総計情報リスト = choteiboSakuseiMapper.selectAll合計部分総計情報();
        for (GokeiBubunSoukeiEntity 合計部分総計情報 : 合計部分総計情報リスト) {
            GokeiDataEntity 合計データ = new GokeiDataEntity();
            合計データ.set徴収方法(合計部分総計情報.getChoshuHouhou());
            合計データ.set当月フラグ(合計部分総計情報.getDogetsuFlag());
            合計データ.set特別徴収の調定額の総計(合計部分総計情報.getTobetsuChoteigakuSoukei());
            合計データ.set普通徴収の調定額の総計(合計部分総計情報.getFutsuChoteigakuSoukei());
            合計データ.set特徴と普徴の総計(合計部分総計情報.getTobetsuTofutsuChoteigakuSoukei());
            合計データ.set前月末の全部件数の総計(合計部分総計情報.getZengetsusueKensuSoukei());
            合計データ.set前月末の全部調定額の総計(合計部分総計情報.getZengetsusueChoteigakuSoukei());
            合計データ.set増の全部件数の総計(合計部分総計情報.getFueZennbuKennsuuSoukei());
            合計データ.set増の全部調定額の総計(合計部分総計情報.getFueZennbuChoteigakuSoukei());
            合計データ.set減の全部件数の総計(合計部分総計情報.getGenZennbuKennsuuSoukei());
            合計データ.set減の全部調定額の総計(合計部分総計情報.getGenZennbuChoteigakuSoukei());
            合計データ.set当月末の全部件数の総計(合計部分総計情報.getDogetsusueKensuSoukei());
            合計データ.set当月末の全部調定額の総計(合計部分総計情報.getDogetsusueChoteigakuSoukei());
            合計データ.set特徴者数の総計(合計部分総計情報.getTokuchosyaKensuSoukei());
            合計データ.set普徴者数の総計(合計部分総計情報.getFuchosyaKensuSoukei());
            合計データ.set内併徴者数の総計(合計部分総計情報.getNaiheisyaKensuSoukei());
            合計データ.set減免の件数の総計(合計部分総計情報.getGenmenSoukei());
            合計データ.set減免の調定額の総計(合計部分総計情報.getGenmenChoteigakuSoukei());
            合計データ.set特徴歳出還付の件数の総計(合計部分総計情報.getTkSaishutsuKampuSoukei());
            合計データ.set特徴歳出還付の調定額の総計(合計部分総計情報.getTkSaishutsuKampuChoteigakuSoukei());
            合計データ.set普徴歳出還付の件数の総計(合計部分総計情報.getFuSaishutsuKampuSoukei());
            合計データ.set普徴歳出還付の調定額の総計(合計部分総計情報.getFuSaishutsuKampuChoteigakuSoukei());
            List<DankaiShokeiEntity> 合計の段階リスト = new ArrayList<>();
            for (GokeiBubunEntity 合計部分情報 : 合計部分情報リスト) {
                if (null == 合計データ.get徴収方法() || null == 合計部分情報.getChoshuHouhou()) {
                    continue;
                }
                if (合計データ.get徴収方法().equals(合計部分情報.getChoshuHouhou())
                        && 合計データ.get当月フラグ() == 合計部分情報.getDogetsuFlag()) {
                    合計データ.set_10月の調定額の小計(合計部分情報.getChoteigaku10GatsuCount());
                    合計データ.set_11月の調定額の小計(合計部分情報.getChoteigaku11GatsuCount());
                    合計データ.set_12月の調定額の小計(合計部分情報.getChoteigaku12GatsuCount());
                    合計データ.set_1月の調定額の小計(合計部分情報.getChoteigaku1GatsuCount());
                    合計データ.set_2月の調定額の小計(合計部分情報.getChoteigaku2GatsuCount());
                    合計データ.set_3月の調定額の小計(合計部分情報.getChoteigaku3GatsuCount());
                    合計データ.set_4月の調定額の小計(合計部分情報.getChoteigaku4GatsuCount());
                    合計データ.set_5月の調定額の小計(合計部分情報.getChoteigaku5GatsuCount());
                    合計データ.set_6月の調定額の小計(合計部分情報.getChoteigaku6GatsuCount());
                    合計データ.set_7月の調定額の小計(合計部分情報.getChoteigaku7GatsuCount());
                    合計データ.set_8月の調定額の小計(合計部分情報.getChoteigaku8GatsuCount());
                    合計データ.set_9月の調定額の小計(合計部分情報.getChoteigaku9GatsuCount());
                    合計データ.set翌_4月の調定額の小計(合計部分情報.getChoteigaku4GatsuCountYoku());
                    合計データ.set翌_5月の調定額の小計(合計部分情報.getChoteigaku5GatsuCountYoku());
                    DankaiShokeiEntity 合計の段階 = new DankaiShokeiEntity();
                    合計の段階.setChoshuHouhou(合計部分情報.getChoshuHouhou());
                    合計の段階.setDogetsuFlag(合計部分情報.getDogetsuFlag());
                    合計の段階.setDankai(合計部分情報.getDankai());
                    合計の段階.setZengetsusueKensu(合計部分情報.getZengetsusueKensuCount());
                    合計の段階.setZengetsusueChoteigakuCount(合計部分情報.getZengetsusueChoteigakuCount());
                    合計の段階.setFueKensu(合計部分情報.getFueKensuCount());
                    合計の段階.setFueChoteigakuCount(合計部分情報.getFueChoteigakuCount());
                    合計の段階.setGenKensu(合計部分情報.getGenKensuCount());
                    合計の段階.setGenChoteigakuCount(合計部分情報.getGenChoteigakuCount());
                    合計の段階.setDogetsusueKensu(合計部分情報.getDogetsusueKensuCount());
                    合計の段階.setDogetsusueChoteigakuCount(合計部分情報.getDogetsusueChoteigakuCount());
                    合計の段階.setTokuchosyaKensu(合計部分情報.getTokuchosyaKensuCount());
                    合計の段階.setFuchosyaKensu(合計部分情報.getFuchosyaKensuCount());
                    合計の段階.setNaiheisyaKensu(合計部分情報.getNaiheisyaKensuCount());
                    合計の段階リスト.add(合計の段階);
                }
            }
            合計データ.set合計の段階リスト(合計の段階リスト);
            合計データリスト.add(合計データ);
        }
        return 合計データリスト;
    }

    private List<NendoDataEntity> get年度データリスト(FlexibleYear choteiNendo, FlexibleYear fukaNendo) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), choteiNendo);
        param.put(KEY_FUKANENDO.toString(), fukaNendo);
        List<NendoDataEntity> 年度データリスト = new ArrayList<>();
        List<KibetsuShokeiEntity> 期別小計リスト = choteiboSakuseiMapper.select期別小計情報(param);
        List<DankaiShokeiEntity> 段階小計リスト = choteiboSakuseiMapper.select段階小計情報(param);
        List<KibetsuGokeiEntity> 期別合計リスト = choteiboSakuseiMapper.select期別合計情報(param);
        List<DankaiGokeiEntity> 段階合計リスト = choteiboSakuseiMapper.select段階合計情報(param);
        NendoDataEntity 年度特別徴収データ = new NendoDataEntity();
        年度特別徴収データ.set徴収方法(ChoshuHohoKibetsu.特別徴収.code());
        年度特別徴収データ.set調定年度(choteiNendo);
        年度特別徴収データ.set賦課年度(fukaNendo);
        NendoDataEntity 年度普通徴収データ = new NendoDataEntity();
        年度普通徴収データ.set徴収方法(ChoshuHohoKibetsu.普通徴収.code());
        年度普通徴収データ.set調定年度(choteiNendo);
        年度普通徴収データ.set賦課年度(fukaNendo);
        add期別小計To年度データ(年度特別徴収データ, 期別小計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add期別小計To年度データ(年度普通徴収データ, 期別小計リスト, ChoshuHohoKibetsu.普通徴収.code());
        add段階小計リストTo年度データ(年度特別徴収データ, 段階小計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add段階小計リストTo年度データ(年度普通徴収データ, 段階小計リスト, ChoshuHohoKibetsu.普通徴収.code());
        add期別合計To年度データ(年度特別徴収データ, 期別合計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add期別合計To年度データ(年度普通徴収データ, 期別合計リスト, ChoshuHohoKibetsu.普通徴収.code());
        add段階合計To年度データ(年度特別徴収データ, 段階合計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add段階合計To年度データ(年度普通徴収データ, 段階合計リスト, ChoshuHohoKibetsu.普通徴収.code());
        年度データリスト.add(年度特別徴収データ);
        年度データリスト.add(年度普通徴収データ);
        return 年度データリスト;
    }

    private void add段階合計To年度データ(
            NendoDataEntity 年度データ,
            List<DankaiGokeiEntity> 段階合計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 段階合計リスト) {
            return;
        }

        for (DankaiGokeiEntity 段階合計 : 段階合計リスト) {
            if (null == 段階合計.getChoshuHouhou() || 徴収方法.equals(段階合計.getChoshuHouhou())) {
                continue;
            }
            if (当月フラグ == 段階合計.getDogetsuFlag()) {
                年度データ.set当月末の全部件数の合計(段階合計.getDogetsusueKensuCount());
                年度データ.set当月末の全部調定額の合計(段階合計.getDogetsusueChoteigakuCount());
                年度データ.set当月末の全部件数の合計(段階合計.getDogetsusueKensuCount());
                年度データ.set当月末の全部調定額の合計(段階合計.getDogetsusueChoteigakuCount());
            } else if (前月フラグ == 段階合計.getDogetsuFlag()) {
                年度データ.set前月末の全部件数の合計(段階合計.getZengetsusueKensuCount());
                年度データ.set前月末の全部調定額の合計(段階合計.getZengetsusueChoteigakuCount());
                年度データ.set前月末の全部件数の合計(段階合計.getZengetsusueKensuCount());
                年度データ.set前月末の全部調定額の合計(段階合計.getZengetsusueChoteigakuCount());
            }
            年度データ.set増の全部件数の合計(段階合計.getFueZennbuKennsuuGokei());
            年度データ.set増の全部調定額の合計(段階合計.getFueZennbuChoteigakuGokei());
            年度データ.set減の全部件数の合計(段階合計.getGenZennbuKennsuuGokei());
            年度データ.set減の全部調定額の合計(段階合計.getGenZennbuChoteigakuGokei());
            年度データ.set内併徴者数の合計(段階合計.getNaiheisyaKensuCount());
            if (ChoshuHohoKibetsu.特別徴収.code().equals(段階合計.getChoshuHouhou())) {
                年度データ.set特徴者数の合計(段階合計.getTokuchosyaKensuCount());
            } else if (ChoshuHohoKibetsu.普通徴収.code().equals(段階合計.getChoshuHouhou())) {
                年度データ.set普徴者数の合計(段階合計.getFuchosyaKensuCount());
            }
        }
    }

    private void add期別合計To年度データ(
            NendoDataEntity 年度データ,
            List<KibetsuGokeiEntity> 期別合計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 期別合計リスト) {
            return;
        }
        for (KibetsuGokeiEntity 期別合計 : 期別合計リスト) {
            if (null != 期別合計.getTobetsuTofutsuChoteigakuCount()) {
                年度データ.set特徴と普徴の合計(期別合計.getTobetsuTofutsuChoteigakuCount());
            }
            if (null != 期別合計.getGenmenCount()) {
                年度データ.set減免の件数(期別合計.getGenmenCount());
            }
            if (null != 期別合計.getGenmenChoteigaku()) {
                年度データ.set減免の調定額(期別合計.getGenmenChoteigaku());
            }
            if (null != 期別合計.getChoshuHouhou()
                    && ChoshuHohoKibetsu.特別徴収.code().equals(徴収方法)
                    && 徴収方法.equals(期別合計.getChoshuHouhou())) {
                年度データ.set特別徴収の調定額の合計(期別合計.getTobetsuChoteigakuCount());
                年度データ.set特徴歳出還付の件数(期別合計.getTkSaishutsuKampuCount());
                年度データ.set特徴歳出還付の調定額(期別合計.getTkSaishutsuKampuChoteigaku());
            } else if (null != 期別合計.getChoshuHouhou()
                    && ChoshuHohoKibetsu.普通徴収.code().equals(徴収方法)
                    && 徴収方法.equals(期別合計.getChoshuHouhou())) {
                年度データ.set普通徴収の調定額の合計(期別合計.getFutsuChoteigakuCount());
                年度データ.set普徴歳出還付の件数(期別合計.getFutsuChoteigakuCount());
                年度データ.set普徴歳出還付の調定額(期別合計.getFuSaishutsuKampuChoteigaku());
            }
        }
    }

    private void add段階小計リストTo年度データ(
            NendoDataEntity 年度データ,
            List<DankaiShokeiEntity> 段階小計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 段階小計リスト) {
            return;
        }
        List<DankaiShokeiEntity> result段階小計リスト = new ArrayList<>();
        for (DankaiShokeiEntity 段階小計 : 段階小計リスト) {
            if (null != 段階小計.getChoshuHouhou() && 徴収方法.equals(段階小計.getChoshuHouhou())) {
                result段階小計リスト.add(段階小計);
            }
        }
        年度データ.set段階小計リスト(result段階小計リスト);
    }

    private void add期別小計To年度データ(
            NendoDataEntity 年度データ,
            List<KibetsuShokeiEntity> 期別小計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 期別小計リスト) {
            return;
        }
        for (KibetsuShokeiEntity 期別小計 : 期別小計リスト) {
            if (null != 期別小計.getChoshuHouhou() && 徴収方法.equals(期別小計.getChoshuHouhou())) {
                年度データ.set第1期の調定額の小計(期別小計.getDai1kiChoteigakuCount());
                年度データ.set第2期の調定額の小計(期別小計.getDai2kiChoteigakuCount());
                年度データ.set第3期の調定額の小計(期別小計.getDai3kiChoteigakuCount());
                年度データ.set第4期の調定額の小計(期別小計.getDai4kiChoteigakuCount());
                年度データ.set第5期の調定額の小計(期別小計.getDai5kiChoteigakuCount());
                年度データ.set第6期の調定額の小計(期別小計.getDai6kiChoteigakuCount());
                年度データ.set第7期の調定額の小計(期別小計.getDai7kiChoteigakuCount());
                年度データ.set第8期の調定額の小計(期別小計.getDai8kiChoteigakuCount());
                年度データ.set第9期の調定額の小計(期別小計.getDai9kiChoteigakuCount());
                年度データ.set第10期の調定額の小計(期別小計.getDai10kiChoteigakuCount());
                年度データ.set第11期の調定額の小計(期別小計.getDai11kiChoteigakuCount());
                年度データ.set第12期の調定額の小計(期別小計.getDai12kiChoteigakuCount());
                年度データ.set第13期の調定額の小計(期別小計.getDai13kiChoteigakuCount());
                年度データ.set第14期の調定額の小計(期別小計.getDai14kiChoteigakuCount());
            }
        }
    }
}
