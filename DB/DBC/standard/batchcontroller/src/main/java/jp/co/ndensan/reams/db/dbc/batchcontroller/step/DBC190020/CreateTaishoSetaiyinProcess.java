/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoReport;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoHakkoChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.CreateTaishoSetaiyinProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.CreateTaishoSetaiyinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiyinCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票出力、CSV作成 のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
public class CreateTaishoSetaiyinProcess extends BatchProcessBase<CreateTaishoSetaiyinEntity> {

    private InsTaishoSeitaiyinTempProcessParameter parameter;

    private static final RString 首長名印字位置_1 = new RString("1");
    private static final RString MESSAGE_その他 = new RString("その他");
    private static final RString MESSAGE_人 = new RString("人");
    private static final RString MESSAGE_該当データなし = new RString("該当データなし");

    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_30 = 30;
    private static final int INT_80 = 80;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString RSTRING_1 = new RString("1");

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.get宛先宛名");

    private CreateTaishoSetaiyinProcessMybatisParameter para;
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString チェック項目名 = new RString("jusho");
    private static final RString 定数_住所 = new RString("住所");
    private static final RString ファイル名_前 = new RString("KijunShunyugakuTekiyoShinseishoHakkoIchiran_");
    private static final RString 記号_ = new RString("_");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200088");

    private ChohyoSeigyoKyotsu 帳票制御共通;
    private boolean is公印に掛ける;
    private boolean is公印を省略;
    private CreateTaishoSetaiyinEntity exEntity;
    private static int index;
    private static int index164;
    private RString 出力ファイル名;

    private List<RString> 出力順リスト;
    private List<RString> 改頁項目リスト;
    private List<RString> 改頁項目名リスト;
    private IOutputOrder 並び順;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private int 通番 = 1;
    private int 改頁通番 = 1;
    private NinshoshaSource 確認書認証者情報;
    private List<CreateTaishoSetaiyinEntity> createTaishoSetaiyinList;
    private boolean 文字切れflag = false;
    private boolean flag = false;
    private boolean 対象世帯員fla = false;
    private RString タイトル;
    private RString 通知文１;
    private RString 通知文２;
    private RString 通知文64;
    private Ninshosha 認証者;
    private Association 地方公共団体;

    private BatchReportWriter<KijunShunyugakuTekiyoOshiraseTsuchishoSource> dBC100063ReportWriter0;
    private ReportSourceWriter<KijunShunyugakuTekiyoOshiraseTsuchishoSource> dBC100063SourceWriter0;

    private IBatchReportWriterWithCheckList<KijunShunyugakuTekiyoShinseishoSource> dBC100064ReportWriter1;
    private ReportSourceWriter<KijunShunyugakuTekiyoShinseishoSource> dBC100064SourceWriter1;

    private BatchReportWriter<KijunShunyugakuTekiyoShinseishoSource> dBC100064ReportWriter0;
    private ReportSourceWriter<KijunShunyugakuTekiyoShinseishoSource> dBC100064SourceWriter0;

    private BatchReportWriter<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> dBC200088ReportWriter;
    private ReportSourceWriter<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> dBC200088SourceWriter;
    private CsvWriter eucCsvWriter;
    private int maxLenth;

    @Override
    protected void initialize() {
        super.initialize();
        createTaishoSetaiyinList = new ArrayList();
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        this.para = new CreateTaishoSetaiyinProcessMybatisParameter(shikibetsuTaishoPSMSearchKey);

        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100063.getReportId());
        is公印に掛ける = false;
        is公印を省略 = false;
        if (首長名印字位置_1.equals(帳票制御共通.get首長名印字位置())) {
            is公印に掛ける = true;
        }
        if (!帳票制御共通.is電子公印印字有無()) {
            is公印を省略 = true;
        }
        index = 1;
        index164 = 1;

        RString 市町村コード = Association.getLasdecCode().getColumnValue();
        出力ファイル名 = ファイル名_前.concat(parameter.get処理年月日().toString()).concat(記号_).concat(市町村コード).concat(ファイル名_後);

        改頁項目リスト = new ArrayList<>();
        改頁項目名リスト = new ArrayList<>();
        出力順リスト = new ArrayList<>();
        並び順 = get並び順(ReportIdDBC.DBC100075.getReportId(), parameter.get出力順ID());

        RString 出力順 = MyBatisOrderByClauseCreator
                .create(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.class, 並び順);
        para.setTemp_出力順(出力順);
        for (ISetSortItem item : 並び順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                改頁項目リスト.add(item.get項目ID());
                改頁項目名リスト.add(item.get項目名());
            }
            出力順リスト.add(item.get項目名());
        }

        タイトル = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100063.getReportId(), KamokuCode.EMPTY, INT_1, INT_1, parameter.get世帯員把握基準日());
        通知文１ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100063.getReportId(), KamokuCode.EMPTY, INT_1, INT_2, parameter.get世帯員把握基準日());
        通知文２ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100063.getReportId(), KamokuCode.EMPTY, INT_1, INT_3, parameter.get世帯員把握基準日());
        認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), this.parameter.get作成日());
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        通知文64 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100064.getReportId(), KamokuCode.EMPTY, INT_1).get(INT_1);
        maxLenth = KijunShunyugakuTekiyoShinseishoSource.JUSHO1_MAXLENGTH;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, para);

    }

    @Override
    protected void createWriter() {

        if (ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(this.parameter.get抽出条件())) {
            PageBreaker<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> breaker
                    = new KijunShunyugakuTekiyoShinseishoHakkoIchiranPageBreak(改頁項目リスト);
            dBC200088ReportWriter
                    = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200088.getReportId().value()).addBreak(breaker).create();
            dBC200088SourceWriter = new ReportSourceWriter<>(dBC200088ReportWriter);

            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                    UzUDE0831EucAccesslogFileType.Csv);
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                    出力ファイル名);
            eucCsvWriter = BatchWriters.csvWriter(TaishoSetaiyinCsvEntity.class).
                    filePath(eucFilePath).
                    setDelimiter(コンマ).
                    setEnclosure(ダブル引用符).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();

        }

    }

    @Override
    protected void process(CreateTaishoSetaiyinEntity entity) {
        IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先());
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        TaishoSetaiinEntity 対象世帯員 = entity.get対象世帯員();
        対象世帯員.setAtenaInnjiKubun(null == 宛先 ? RString.EMPTY : RSTRING_1);
        対象世帯員.setRennrakusaki(getColumnValue(宛名.get連絡先１()));
        IJusho 住所 = 宛名.get住所();
        if (!flag || isChangeShotaiCode(this.exEntity.get対象世帯員(), entity.get対象世帯員())) {
            int 文字列長 = 住所.get住所().length() + getColumnValue(住所.get方書()).length() + getColumnValue(住所.get番地().getBanchi()).length();
            if (INT_80 < 文字列長) {
                対象世帯員.setInnjiGirisiamojiKubun(true);
            } else {
                対象世帯員.setInnjiGirisiamojiKubun(false);
            }
            if (INT_80 < 文字列長 && RSTRING_1.equals(entity.get対象世帯員().getShuturyokuUmu())) {
                文字切れflag = true;
            }
        }

        if (RSTRING_1.equals(entity.get対象世帯員().getShuturyokuUmu())) {
            対象世帯員fla = true;
        }

        if (this.parameter.get一覧表CSV出力フラグ() && ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(this.parameter.get抽出条件())) {
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 申請一覧Entity = this.set申請一覧Entity(entity);
            KijunShunyugakuTekiyoShinseishoHakkoIchiranReport 申請一覧Report = new KijunShunyugakuTekiyoShinseishoHakkoIchiranReport(
                    申請一覧Entity, parameter.get市町村コード().getColumnValue(), parameter.get市町村名(), 出力順リスト, 改頁項目名リスト, parameter.get処理年度());
            申請一覧Report.writeBy(dBC200088SourceWriter);
            TaishoSetaiyinCsvEntity 申請書発行一覧CSV = this.get申請書発行一覧CSV(entity.get対象世帯員());
            eucCsvWriter.writeLine(申請書発行一覧CSV);
        }

        flag = true;
        this.createTaishoSetaiyinList.add(entity);
        this.exEntity = entity;
        改頁通番++;

    }

    @Override
    protected void afterExecute() {
        if (ShinseishoHakkoChushutsuJoken.白紙印刷.getコード().equals(this.parameter.get抽出条件())) {
            dBC100063ReportWriter0 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100063.getReportId().value()).create();
            dBC100063SourceWriter0 = new ReportSourceWriter<>(dBC100063ReportWriter0);

            dBC100064ReportWriter0 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100064.getReportId().value()).create();
            dBC100064SourceWriter0 = new ReportSourceWriter<>(dBC100064ReportWriter0);

            確認書認証者情報 = NinshoshaSourceBuilderFactory.createInstance(認証者, 地方公共団体, dBC100063ReportWriter0.getImageFolderPath(),
                    new RDate(this.parameter.get作成日().toString()), is公印に掛ける, is公印を省略, KenmeiFuyoKubunType.付与なし).buildSource();

            KijunShunyugakuTekiyoShinseishoEntity kijunEntity = new KijunShunyugakuTekiyoShinseishoEntity();
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity1 = new KijunShunyugakuTekiyoShinseishoEntity();

            kijunEntity.set文書番号(this.parameter.get文書番号());
            kijunEntity.setNinshoshaSource(確認書認証者情報);
            kijunEntity.setタイトル(タイトル);
            kijunEntity.set通知文１(通知文１);
            kijunEntity.set通知文２(通知文２);

            RString 申請先 = 認証者.get市町村付与名称(地方公共団体);
            kijunEntity1.set申請先(申請先);
            kijunEntity1.set通知文１(通知文64);
            RString 年度 = parameter.get処理年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
            kijunEntity1.set収入元号(年度.substringReturnAsPossible(INT_0, INT_2));
            kijunEntity1.set収入年(年度.substringReturnAsPossible(INT_2));

            KijunShunyugakuTekiyoOshiraseTsuchishoReport kijunReport
                    = new KijunShunyugakuTekiyoOshiraseTsuchishoReport(kijunEntity);
            kijunReport.writeBy(dBC100063SourceWriter0);
            KijunShunyugakuTekiyoShinseishoReport dbc64Report = new KijunShunyugakuTekiyoShinseishoReport(kijunEntity1);
            dbc64Report.writeBy(dBC100064SourceWriter0);

        } else if (対象世帯員fla) {
            if (文字切れflag) {
                ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBC介護給付,
                        parameter.get市町村コード(), parameter.get市町村名());
                CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目.class, チェック項目.class);

                dBC100064ReportWriter1 = BatchWriters
                        .batchReportWriterWithCheckList(KijunShunyugakuTekiyoShinseishoSource.class)
                        .checkListInfo(info)
                        .checkListLineItemSet(pairs)
                        .reportId(ReportIdDBC.DBC100064.getReportId())
                        .build();
                dBC100064SourceWriter1 = new ReportSourceWriter<>(dBC100064ReportWriter1);

            }
            dBC100063ReportWriter0 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100063.getReportId().value()).create();
            dBC100063SourceWriter0 = new ReportSourceWriter<>(dBC100063ReportWriter0);

            確認書認証者情報 = NinshoshaSourceBuilderFactory.createInstance(認証者, 地方公共団体, dBC100063ReportWriter0.getImageFolderPath(),
                    new RDate(this.parameter.get作成日().toString()), is公印に掛ける, is公印を省略, KenmeiFuyoKubunType.付与なし).buildSource();

            dBC100064ReportWriter0 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100064.getReportId().value()).create();
            dBC100064SourceWriter0 = new ReportSourceWriter<>(dBC100064ReportWriter0);

        }

        if (!flag && this.parameter.get一覧表CSV出力フラグ() && ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(this.parameter.get抽出条件())) {
            TaishoSetaiyinCsvEntity 申請書発行一覧CSV = this.get申請書発行一覧CSV(null);
            eucCsvWriter.writeLine(申請書発行一覧CSV);
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 収入額適用申請書一覧表 = this.set申請一覧Entity(null);
            KijunShunyugakuTekiyoShinseishoHakkoIchiranReport 申請一覧Report = new KijunShunyugakuTekiyoShinseishoHakkoIchiranReport(
                    収入額適用申請書一覧表, parameter.get市町村コード().getColumnValue(), parameter.get市町村名(), 出力順リスト, 改頁項目名リスト, parameter.get処理年度());
            申請一覧Report.writeBy(dBC200088SourceWriter);
        }

        List<CreateTaishoSetaiyinEntity> taishoSetaiyinList = new ArrayList();
        for (int i = 0; i < this.createTaishoSetaiyinList.size(); i++) {
            taishoSetaiyinList.add(createTaishoSetaiyinList.get(i));
            if (i == this.createTaishoSetaiyinList.size() - 1) {
                this.write帳票(taishoSetaiyinList);
            } else if (isChangeShotaiCode(this.createTaishoSetaiyinList.get(i).get対象世帯員(),
                    this.createTaishoSetaiyinList.get(i + 1).get対象世帯員())) {
                this.write帳票(taishoSetaiyinList);
                taishoSetaiyinList.clear();
            }
        }

        if (null != dBC200088ReportWriter) {
            dBC200088ReportWriter.close();
        }

        if (null != dBC100064ReportWriter1) {
            dBC100064ReportWriter1.close();
        }
        if (null != dBC100063ReportWriter0) {
            dBC100063ReportWriter0.close();
        }
        if (null != dBC100064ReportWriter0) {
            dBC100064ReportWriter0.close();
        }

        if (null != eucCsvWriter) {
            eucCsvWriter.close();
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        }
    }

    private void write帳票(List<CreateTaishoSetaiyinEntity> taishoSetaiyinList) {
        if (RSTRING_1.equals(taishoSetaiyinList.get(INT_0).get対象世帯員().getShuturyokuUmu())) {
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity = new KijunShunyugakuTekiyoShinseishoEntity();
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity1 = new KijunShunyugakuTekiyoShinseishoEntity();

            for (CreateTaishoSetaiyinEntity taiEntity : taishoSetaiyinList) {
                IAtesaki 宛先 = AtesakiFactory.createInstance(taiEntity.get宛先());
                IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(taiEntity.get宛名());
                this.基準収入額適用お知ら(taiEntity, kijunEntity, 宛先, taishoSetaiyinList.size());
                this.基準収入額適用申請書(taiEntity, kijunEntity1, 宛名);
                if (INT_3 < taishoSetaiyinList.size() && index164 == INT_3) {
                    this.write申請書出力帳票(kijunEntity1);
                    kijunEntity1 = new KijunShunyugakuTekiyoShinseishoEntity();
                    index164 = INT_0;
                }
                index++;
                index164++;
            }
            if (index164 != INT_1) {
                this.write申請書出力帳票(kijunEntity1);
            }
            this.writeお知らせ通知書帳票(kijunEntity);
            index = 1;
            index164 = 1;
        }
    }

    private void writeお知らせ通知書帳票(KijunShunyugakuTekiyoShinseishoEntity kijunEntity) {
        if (this.parameter.getお知らせ通知書出力フラグ()) {
            KijunShunyugakuTekiyoOshiraseTsuchishoReport kijunReport
                    = new KijunShunyugakuTekiyoOshiraseTsuchishoReport(kijunEntity);
            kijunReport.writeBy(dBC100063SourceWriter0);
            index++;
        }
    }

    private void write申請書出力帳票(KijunShunyugakuTekiyoShinseishoEntity kijunEntity1) {
        int 住所 = kijunEntity1.get住所１().length();
        if (null != kijunEntity1.get住所２()) {
            住所 = 住所 + kijunEntity1.get住所２().length();
        }
        if (INT_80 < 住所) {
            if (this.parameter.get申請書出力フラグ()) {
                KijunShunyugakuTekiyoShinseishoReport dbc64Report = new KijunShunyugakuTekiyoShinseishoReport(kijunEntity1);
                dbc64Report.writeBy(dBC100064SourceWriter1);
            }
        } else if (this.parameter.get申請書出力フラグ()) {
            KijunShunyugakuTekiyoShinseishoReport dbc64Report = new KijunShunyugakuTekiyoShinseishoReport(kijunEntity1);
            dbc64Report.writeBy(dBC100064SourceWriter0);
        }

    }

    private void 基準収入額適用お知ら(CreateTaishoSetaiyinEntity taiEntity, KijunShunyugakuTekiyoShinseishoEntity kijunEntity, IAtesaki 宛先, int 世帯員情報件数) {
        if (index == 1) {
            ReportAtesakiEditor editor = new SofubutsuAtesakiEditorBuilder(宛先).build();
            SofubutsuAtesakiSource compSofubutsuAtesakiソース = new SofubutsuAtesakiSourceBuilder(editor).buildSource();
            kijunEntity.setAtesakiSource(compSofubutsuAtesakiソース);
            kijunEntity.setNinshoshaSource(確認書認証者情報);
            kijunEntity.set文書番号(this.parameter.get文書番号());
            kijunEntity.setタイトル(タイトル);
            kijunEntity.set被保険者番号１(getColumnValue(taiEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity.set被保険者名カナ１(taiEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity.set被保険者氏名１(taiEntity.get対象世帯員().getHihokenshaName());
            kijunEntity.set識別コード１(taiEntity.get対象世帯員().getShikibetsuCode());
            kijunEntity.set通知文１(通知文１);
            kijunEntity.set通知文２(通知文２);
        } else if (index == INT_2) {
            kijunEntity.set被保険者番号２(getColumnValue(taiEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity.set被保険者名カナ２(taiEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity.set被保険者氏名２(taiEntity.get対象世帯員().getHihokenshaName());
            kijunEntity.set識別コード２(taiEntity.get対象世帯員().getShikibetsuCode());
        } else if (index == INT_3) {
            kijunEntity.set被保険者番号３(getColumnValue(taiEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity.set被保険者名カナ３(taiEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity.set被保険者氏名３(taiEntity.get対象世帯員().getHihokenshaName());
            kijunEntity.set識別コード３(taiEntity.get対象世帯員().getShikibetsuCode());
        } else if (INT_4 == index) {
            kijunEntity.setその他被保険者(MESSAGE_その他.concat(new RString(世帯員情報件数 - INT_3)).concat(MESSAGE_人));
        }

    }

    private void 基準収入額適用申請書(CreateTaishoSetaiyinEntity taiEntity, KijunShunyugakuTekiyoShinseishoEntity kijunEntity1, IShikibetsuTaisho 宛名) {
        if (index164 == INT_1) {
            RString 申請先 = 認証者.get市町村付与名称(地方公共団体);
            kijunEntity1.set申請先(申請先);

            kijunEntity1.set被保険者番号１(getColumnValue(taiEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity1.set被保険者名カナ１(taiEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity1.set被保険者氏名１(taiEntity.get対象世帯員().getHihokenshaName());
            kijunEntity1.set被保険者生年月日１(taiEntity.get対象世帯員().getSeinengappiYMD());
            kijunEntity1.set被保険者性別１(taiEntity.get対象世帯員().getSex());
            RString 住所 = JushoHenshu.editJusho(帳票制御共通, 宛名, 地方公共団体);
            kijunEntity1.set住所１(住所.substringReturnAsPossible(INT_0, maxLenth));
            kijunEntity1.set住所２(住所.substringReturnAsPossible(maxLenth));
            kijunEntity1.set連絡先(taiEntity.get対象世帯員().getRennrakusaki());
            kijunEntity1.set通知文１(通知文64);
            RString 年度 = parameter.get処理年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
            kijunEntity1.set収入元号(年度.substringReturnAsPossible(INT_0, INT_2));
            kijunEntity1.set収入年(年度.substringReturnAsPossible(INT_2));
        } else if (index164 == INT_2) {
            kijunEntity1.set被保険者番号２(getColumnValue(taiEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity1.set被保険者名カナ２(taiEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity1.set被保険者氏名２(taiEntity.get対象世帯員().getHihokenshaName());
            kijunEntity1.set被保険者生年月日２(taiEntity.get対象世帯員().getSeinengappiYMD());
            kijunEntity1.set被保険者性別２(taiEntity.get対象世帯員().getSex());
        } else if (index164 == INT_3) {
            kijunEntity1.set被保険者番号３(getColumnValue(taiEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity1.set被保険者名カナ３(taiEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity1.set被保険者氏名３(taiEntity.get対象世帯員().getHihokenshaName());
            kijunEntity1.set被保険者生年月日３(taiEntity.get対象世帯員().getSeinengappiYMD());
            kijunEntity1.set被保険者性別３(taiEntity.get対象世帯員().getSex());
        }

    }

    private TaishoSetaiyinCsvEntity get申請書発行一覧CSV(TaishoSetaiinEntity 対象世帯員) {
        TaishoSetaiyinCsvEntity csvEntity = new TaishoSetaiyinCsvEntity();
        if (null != 対象世帯員) {
            csvEntity.set世帯コード(対象世帯員.getShotaiCode());
            csvEntity.set処理年度(doFlexibleYear編集(対象世帯員.getShoriNendo()));
            csvEntity.set世帯課税区分(対象世帯員.getSetaikazeiKubun());
            csvEntity.set総収入額(doDecimal編集(対象世帯員.getSoushuu()));
            csvEntity.set年少扶養控除_16歳未満人数(対象世帯員.getNennshouLess16Num());
            csvEntity.set年少扶養控除_16歳から18歳人数(対象世帯員.getNennshouLess16_18Num());
            csvEntity.setランク市町村コード(対象世帯員.getRannkuShichosonCode());
            csvEntity.set世帯員把握基準日(doFlexibleDate編集(対象世帯員.getShotaikijunDay()));
            csvEntity.set被保険者番号(getColumnValue(対象世帯員.getHihokenshaNo()));
            csvEntity.set識別コード(getColumnValue(対象世帯員.getShikibetsuCode()));
            csvEntity.set市町村コード(対象世帯員.getShichosonCode());
            csvEntity.set住所地特例フラグ(対象世帯員.getJushochiTokureiFlag());
            csvEntity.set課税区分(対象世帯員.getKazeiKubun());
            csvEntity.set課税所得(doDecimal編集(対象世帯員.getKazeiShotokuGaku()));
            csvEntity.set課税所得_控除後(doDecimal編集(対象世帯員.getKazeiShotokuGakuAfter()));
            csvEntity.set年金収入(doDecimal編集(対象世帯員.getNenkinShunyuGaku()));
            csvEntity.setその他の合計所得(doDecimal編集(対象世帯員.getSonotanoGoukeiShotokuKingakuGoukei()));
            csvEntity.set続柄コード(対象世帯員.getHennshuuZokugaraCode());
            csvEntity.set宛名データ種別_1231(対象世帯員.getAtenaDateDhubetsu_kijunDay());
            csvEntity.set宛名データ種別_基準日(対象世帯員.getAtenaDateDhubetsu_kijunDay());
            csvEntity.set氏名(対象世帯員.getHihokenshaName());
            csvEntity.set氏名カナ(対象世帯員.getHihokenshaKana());
            csvEntity.set性別(対象世帯員.getSex());
            csvEntity.set生年月日(doFlexibleDate編集(対象世帯員.getSeinengappiYMD()));
            csvEntity.set資格区分(対象世帯員.getHihokennshaKubun());
            csvEntity.set受給区分(対象世帯員.getJukyuKubun());
            csvEntity.set要介護度(対象世帯員.getNijiHanteiYokaigoJotaiKubunCode());
            csvEntity.set認定開始日(doFlexibleDate編集(対象世帯員.getNinteiYukoKikanKaishiYMD()));
            csvEntity.set認定終了日(doFlexibleDate編集(対象世帯員.getNinteiYukoKikanShuryoYMD()));
            csvEntity.set適用開始日(doFlexibleDate編集(対象世帯員.getTekiyoKaishiYMD()));
            csvEntity.set適用終了日(doFlexibleDate編集(対象世帯員.getTekiyoShuryoYMD()));
        } else {
            csvEntity.set氏名(MESSAGE_該当データなし);
        }

        return csvEntity;
    }

    private KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity set申請一覧Entity(CreateTaishoSetaiyinEntity entity) {
        KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 申請一覧Entity = new KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity();
        if (null != entity) {
            if (INT_1 == 通番) {
                申請一覧Entity.set通番(new RString(通番));
                申請一覧Entity.set世帯番号(entity.get対象世帯員().getShotaiCode());
                通番++;
            } else if (is改頁(exEntity, entity) || this.isChangeShotaiCode(exEntity.get対象世帯員(), entity.get対象世帯員())) {
                申請一覧Entity.set通番(new RString(通番));
                通番++;
                申請一覧Entity.set世帯番号(entity.get対象世帯員().getShotaiCode());
            }
            申請一覧Entity.set年度(parameter.get処理年度());
            申請一覧Entity.set世帯課税(entity.get対象世帯員().getSetaikazeiKubun());
            申請一覧Entity.set総合計(entity.get対象世帯員().getSoushuu());
            申請一覧Entity.set被保番号(getColumnValue(entity.get対象世帯員().getHihokenshaNo()));
            申請一覧Entity.set氏名(entity.get対象世帯員().getHihokenshaName());
            申請一覧Entity.set識別コード(entity.get対象世帯員().getShikibetsuCode());
            申請一覧Entity.set年齢(entity.get対象世帯員().getAge());
            申請一覧Entity.set生年月日(entity.get対象世帯員().getSeinengappiYMD());
            申請一覧Entity.set課税所得(doDecimal(entity.get対象世帯員().getKazeiShotokuGaku()));
            申請一覧Entity.set課税所得_控除後(doDecimal(entity.get対象世帯員().getKazeiShotokuGakuAfter()));
            申請一覧Entity.set年金収入(doDecimal(entity.get対象世帯員().getNenkinShunyuGaku()));
            申請一覧Entity.setその他合計所得(doDecimal(entity.get対象世帯員().getSonotanoGoukeiShotokuKingakuGoukei()));
            申請一覧Entity.set合計(this.合計(entity.get対象世帯員().getNenkinShunyuGaku(), entity.get対象世帯員().getSonotanoGoukeiShotokuKingakuGoukei()));
            申請一覧Entity.set要介護度(entity.get対象世帯員().getNijiHanteiYokaigoJotaiKubunCode());
            申請一覧Entity.set認定開始日(entity.get対象世帯員().getNinteiYukoKikanKaishiYMD());
            申請一覧Entity.set認定終了日(entity.get対象世帯員().getNinteiYukoKikanShuryoYMD());

            if (entity.get宛名() != null) {
                IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
                IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先());
                申請一覧Entity.set郵便番号(getColumnValue(宛先.get宛先住所().get郵便番号()));
                申請一覧Entity.set町域コード(getColumnValue(宛先.get宛先住所().get町域コード()));
                申請一覧Entity.set行政区コード(getColumnValue(宛先.get宛先行政区().getコード()));
                申請一覧Entity.set世帯コード(getColumnValue(宛名.get世帯コード()));
            }
            申請一覧Entity.set市町村コード(doRString編集(entity.get対象世帯員().getShichosonCode()));

        } else {
            申請一覧Entity.set氏名(MESSAGE_該当データなし);
        }
        return 申請一覧Entity;

    }

    private IOutputOrder get並び順(ReportId 帳票分類ID, RString 出力順ID) {
        if (RString.isNullOrEmpty(出力順ID)) {
            return null;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        return outputOrder;
    }

    private boolean is改頁(CreateTaishoSetaiyinEntity exEntity, CreateTaishoSetaiyinEntity entity) {
        boolean flag = false;
        IShikibetsuTaisho ex宛名 = ShikibetsuTaishoFactory.createKojin(exEntity.get宛名());
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        IAtesaki ex宛先 = AtesakiFactory.createInstance(exEntity.get宛先());
        IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先());
        if (this.改頁項目リスト.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.郵便番号.get項目ID())
                && !getColumnValue(ex宛先.get宛先住所().get郵便番号()).equals(getColumnValue(宛先.get宛先住所().get郵便番号()))) {
            flag = true;
        } else if (this.改頁項目リスト.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.町域コード.get項目ID())
                && !getColumnValue(ex宛先.get宛先住所().get町域コード()).equals(getColumnValue(宛先.get宛先住所().get町域コード()))) {
            flag = true;
        } else if (this.改頁項目リスト.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.行政区コード.get項目ID())
                && !getColumnValue(ex宛先.get宛先行政区().getコード()).equals(getColumnValue(宛先.get宛先行政区().getコード()))) {
            flag = true;
        } else if (this.改頁項目リスト.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.世帯コード.get項目ID())
                && !getColumnValue(ex宛名.get世帯コード()).equals(getColumnValue(宛名.get世帯コード()))) {
            flag = true;
        } else if (this.改頁項目リスト.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.市町村コード.get項目ID())
                && !doRString編集(exEntity.get対象世帯員().getShichosonCode()).equals(doRString編集(entity.get対象世帯員().getShichosonCode()))) {
            flag = true;
        }

        if (INT_1 != 改頁通番 && 改頁通番 % INT_30 == INT_1) {
            flag = true;
        }
        if (flag) {
            改頁通番 = INT_1;
        }
        return flag;

    }

    private boolean isChangeShotaiCode(TaishoSetaiinEntity ex対象世帯員, TaishoSetaiinEntity 対象世帯員) {
        return !ex対象世帯員.getShotaiCode().equals(対象世帯員.getShotaiCode());

    }

    private enum チェック項目 implements ICheckTarget {

        target1(チェック項目名.toString(), 定数_住所.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }

    private enum 特定項目 implements ISpecificKey {

        key1(KijunShunyugakuTekiyoShinseishoSource.ITEM_HIHOKENSHANO1, 定数_被保険者番号.toString());

        private final RString itemName;

        private final RString printName;

        private 特定項目(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private RString doDecimal編集(Decimal number) {
        if (null == number) {
            return new RString(INT_0);
        }
        return DecimalFormatter.toRString(number, 0);
    }

    private RString doRString編集(RString s) {
        if (null == s) {
            return RString.EMPTY;
        }
        return s;
    }

    private Decimal doDecimal(Decimal number) {
        if (null == number) {
            return Decimal.ZERO;
        }
        return number;
    }

    private RString doFlexibleDate編集(FlexibleDate day) {
        if (null == day) {
            return RString.EMPTY;
        }
        return new RString(day.toString());
    }

    private RString doFlexibleYear編集(FlexibleYear year) {
        if (null == year) {
            return RString.EMPTY;
        }
        return new RString(year.toString());
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private Decimal 合計(Decimal a, Decimal b) {
        if (a != null && b != null) {
            return a.add(b);
        } else if (b == null) {
            return a;
        } else if (a == null) {
            return b;
        } else {
            return Decimal.ZERO;
        }

    }

}
