/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.createtsukibetsusuiihyo.ReportDateHensyu;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuGoukey;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsukibetsusuiihyo.TsukibetsuSuiihyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 月別推移表作成帳票用Processクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class FutuChoushuProcess extends BatchProcessBase<KoumokuGoukey> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get普通徴収帳票データの取得");
    private static final ReportId 帳票ID = ReportIdDBB.DBB300002.getReportId();
    private static final RString 処理年度 = new RString("処理年度");
    private static final RString 調定基準日 = new RString("調定基準日");
    private static final RString 各月資格基準日 = new RString("各月資格基準日");
    private static final RString 年齢開始 = new RString("年齢開始");
    private static final RString 年齢終了 = new RString("年齢終了");
    private static final RString 年齢基準日 = new RString("年齢基準日");
    private static final RString 生年月日開始 = new RString("生年月日開始");
    private static final RString 生年月日終了 = new RString("生年月日終了");
    private static final RString 選択対象 = new RString("選択対象");
    private static final RString 市町村 = new RString("市町村");
    private static final int INT_8 = 8;
    private List<KoumokuGoukey> koumokuGoukeyList;
    private List<RString> 表記List;
    private CreateTsukibetsuSuiihyoProcessParameter processPrm;
    private CreateTsukibetsuSuiihyoMyBatisParameter mybatisPrm;
    private ICreateTsukibetsuSuiihyoMapper iCreateTsukibetsuSuiihyoMapper;
    private static final RString TABLE_合計部分項目一時テーブル = new RString("TmpGokeyBubunKoumoku_Ichi");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 合計部分項目一時テーブル;
    @BatchWriter
    private BatchReportWriter<TsukibetsuSuiihyoReportSource> batchReportWriter;
    private ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        iCreateTsukibetsuSuiihyoMapper = getMapper(ICreateTsukibetsuSuiihyoMapper.class);
        HokenryoDankaiSettings hokenryoDankaiSettings = new HokenryoDankaiSettings();
        HokenryoDankaiList hokenryoDankaiList = hokenryoDankaiSettings.get保険料段階ListIn(processPrm.getChoteiNendo());
        表記List = hokenryoDankaiList.to表記List();
        koumokuGoukeyList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        合計部分項目一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_合計部分項目一時テーブル,
                KoumokuGoukey.class);
    }

    @Override
    protected void process(KoumokuGoukey koumokuGoukey) {
        koumokuGoukeyList.add(koumokuGoukey);
    }

    @Override
    protected void afterExecute() {
        get合計部分の項目();
        TsukibetsuSuiihyoReport report = new TsukibetsuSuiihyoReport(getTsukibetsuSuiihyoEntity(koumokuGoukeyList));
        outputJokenhyoFactory();
        report.writeBy(reportSourceWriter);
    }

    private TsukibetsuSuiihyoEntity getTsukibetsuSuiihyoEntity(List<KoumokuGoukey> list) {
        ReportDateHensyu reportDateHensyu = new ReportDateHensyu();
        return reportDateHensyu.getTsukibetsuSuiihyoEntity(list,
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getEra(),
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().substring(2),
                new RString("普通徴収"),
                AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue(), 表記List);
    }

    private void outputJokenhyoFactory() {
        int pageCnt = 1;
        if (koumokuGoukeyList != null && !koumokuGoukeyList.isEmpty()) {
            pageCnt = pageCnt + 1;
        }
        List<KoumokuGoukey> 特別徴収List = iCreateTsukibetsuSuiihyoMapper.get特別徴収帳票データの取得();
        if (特別徴収List != null && !特別徴収List.isEmpty()) {
            pageCnt = pageCnt + 1;
        }
        List<KoumokuGoukey> 合計List = iCreateTsukibetsuSuiihyoMapper.get合計帳票データの取得();
        if (合計List != null && !合計List.isEmpty()) {
            pageCnt = pageCnt + 1;
        }
        List<GemmenJyoho> 減免List = iCreateTsukibetsuSuiihyoMapper.get減免帳票データの取得();
        if (減免List != null && !減免List.isEmpty()) {
            pageCnt = pageCnt + 1;
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString("56"),
                ReportIdDBB.DBB300002.getReportName(),
                new RString(String.valueOf(pageCnt)),
                new RString("なし"),
                new RString("ー"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        FlexibleYear 調定年度 = mybatisPrm.getChoteiNendo();
        出力条件.add(get条件(処理年度, 調定年度.wareki().toDateString()));
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        if (!RString.isNullOrEmpty(mybatisPrm.getChoteiKijunNichiji())) {
            基準日 = new FlexibleDate(mybatisPrm.getChoteiKijunNichiji().substring(0, INT_8));
        }
        出力条件.add(get条件(調定基準日, 基準日.wareki().toDateString()));
        出力条件.add(get条件(各月資格基準日, mybatisPrm.getKakutukiShikakuKijunNichi()));
        出力条件.add(get条件(年齢開始, mybatisPrm.getAgeStart()));
        出力条件.add(get条件(年齢終了, mybatisPrm.getAgeEnd()));
        出力条件.add(get条件(年齢基準日, mybatisPrm.getAgeKijunNi().wareki().toDateString()));
        FlexibleDate 開始生年月日 = new FlexibleDate(mybatisPrm.getSeinengappiYMDStart());
        FlexibleDate 終了生年月日 = new FlexibleDate(mybatisPrm.getSeinengappiYMDEnd());
        出力条件.add(get条件(生年月日開始, 開始生年月日.wareki().toDateString()));
        出力条件.add(get条件(生年月日終了, 終了生年月日.wareki().toDateString()));
        出力条件.add(get条件(選択対象, mybatisPrm.getSentakuTaisho()));
        RStringBuilder 市町村コード_名 = new RStringBuilder();
        市町村コード_名.append(mybatisPrm.getShichosonCode());
        市町村コード_名.append(" ");
        市町村コード_名.append(mybatisPrm.getShichosonMeisho());
        出力条件.add(get条件(市町村, 市町村コード_名.toRString()));
        return 出力条件;
    }

    private RString get条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append("【");
        条件.append(バッチパラメータ名);
        条件.append("】");
        条件.append(値);
        return 条件.toRString();
    }

    private void get合計部分の項目() {
        KoumokuGoukey koumokuGoukey = iCreateTsukibetsuSuiihyoMapper.get項目合計一時テーブル合計データの取得();
        if (koumokuGoukey != null) {
            koumokuGoukey.setHokenryoDankai(new RString("合計"));
            合計部分項目一時テーブル.insert(koumokuGoukey);
        }
    }
}
