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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
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

    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString 首長名印字位置_1 = new RString("1");
    private static final RString MESSAGE = new RString("基準収入額適用申請のお知らせ");
    private static final RString MESSAGE_その他 = new RString("その他　（同一世帯コードの世帯員情報件数-3）人");
    private static final RString MESSAGE_該当データなし = new RString("該当データなし");

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
    private static final int INT_16 = 16;
    private static final int INT_17 = 17;
    private static final int INT_18 = 18;
    private static final int INT_19 = 19;
    private static final int INT_20 = 20;
    private static final int INT_21 = 21;
    private static final int INT_22 = 22;
    private static final int INT_23 = 23;
    private static final int INT_24 = 24;
    private static final int INT_25 = 25;
    private static final int INT_50 = 50;
    private static final int INT_80 = 80;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString RSTRING_1 = new RString("1");

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.get宛先宛名");

    private CreateTaishoSetaiyinProcessMybatisParameter para;
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString チェック項目名 = new RString("住所");
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
    private NinshoshaSource 確認書認証者情報;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter taiShoTableWriter;

    @BatchWriter
    private IBatchReportWriterWithCheckList<KijunShunyugakuTekiyoOshiraseTsuchishoSource> dBC100063ReportWriter1;
    private ReportSourceWriter<KijunShunyugakuTekiyoOshiraseTsuchishoSource> dBC100063SourceWriter1;
    @BatchWriter
    private BatchReportWriter<KijunShunyugakuTekiyoShinseishoSource> dBC100064ReportWriter1;
    private ReportSourceWriter<KijunShunyugakuTekiyoShinseishoSource> dBC100064SourceWriter1;
    @BatchWriter
    private IBatchReportWriterWithCheckList<KijunShunyugakuTekiyoOshiraseTsuchishoSource> dBC100063ReportWriter0;
    private ReportSourceWriter<KijunShunyugakuTekiyoOshiraseTsuchishoSource> dBC100063SourceWriter0;
    @BatchWriter
    private BatchReportWriter<KijunShunyugakuTekiyoShinseishoSource> dBC100064ReportWriter0;
    private ReportSourceWriter<KijunShunyugakuTekiyoShinseishoSource> dBC100064SourceWriter0;

    @BatchWriter
    private BatchReportWriter<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> dBC200088ReportWriter;
    private ReportSourceWriter<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> dBC200088SourceWriter;

    private CsvWriter eucCsvWriter;

    @Override
    protected void initialize() {
        super.initialize();
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
        index = 0;
        index164 = 0;

        RString 市町村コード = Association.getLasdecCode().getColumnValue();
        出力ファイル名 = ファイル名_前.concat(parameter.get処理年月日().toString()).concat(記号_).concat(市町村コード).concat(ファイル名_後);

        改頁項目リスト = new ArrayList<>();
        改頁項目名リスト = new ArrayList<>();
        出力順リスト = new ArrayList<>();
        並び順 = get並び順(ReportIdDBC.DBC100064.getReportId(), parameter.get出力順ID());

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

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, para);

    }

    @Override
    protected void createWriter() {
        this.taiShoTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, TaishoSetaiinEntity.class);

        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBC介護給付,
                parameter.get市町村コード(), parameter.get市町村名());
        CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目.class, チェック項目.class);

        dBC100063ReportWriter1 = BatchWriters
                .batchReportWriterWithCheckList(KijunShunyugakuTekiyoOshiraseTsuchishoSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdDBC.DBC100063.getReportId().value())
                .build();

        dBC100063SourceWriter1 = new ReportSourceWriter<>(dBC100063ReportWriter1);
        dBC100064ReportWriter1 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100064.getReportId().value()).create();
        dBC100064SourceWriter1 = new ReportSourceWriter<>(dBC100064ReportWriter1);

        dBC100063ReportWriter0 = BatchWriters
                .batchReportWriterWithCheckList(KijunShunyugakuTekiyoOshiraseTsuchishoSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdDBC.DBC100063.getReportId().value())
                .build();
        dBC100063SourceWriter0 = new ReportSourceWriter<>(dBC100063ReportWriter0);

        dBC100064ReportWriter0 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100064.getReportId().value()).create();
        dBC100064SourceWriter0 = new ReportSourceWriter<>(dBC100064ReportWriter0);

        PageBreaker<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> breaker = new KijunShunyugakuTekiyoShinseishoHakkoIchiranPageBreak(改頁項目リスト);
        dBC200088ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200088.getReportId().value()).addBreak(breaker).create();
        dBC200088SourceWriter = new ReportSourceWriter<>(dBC200088ReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID,
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

        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), this.parameter.get作成日());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        確認書認証者情報 = NinshoshaSourceBuilderFactory.createInstance(認証者, 地方公共団体, dBC100063SourceWriter1.getImageFolderPath(),
                new RDate(this.parameter.get作成日().toString()), is公印に掛ける, is公印を省略, KenmeiFuyoKubunType.付与なし).buildSource();

    }

    @Override
    protected void process(CreateTaishoSetaiyinEntity entity) {
        KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 申請一覧Entity;
        if (0 == index) {
            this.exEntity = entity;
            index++;
            index164++;
        } else {
            IAtesaki 宛先 = AtesakiFactory.createInstance(this.exEntity.get宛先());
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(this.exEntity.get宛名());
            TaishoSetaiinEntity 対象世帯員 = this.exEntity.get対象世帯員();
            if (null != 宛先) {
                対象世帯員.setAtenaInnjiKubun(RSTRING_1);
            }
            IJusho 住所 = 宛名.get住所();
            int 文字列長 = 住所.get住所().length() + 住所.get方書().getColumnValue().length() + 住所.get番地().toString().length();
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity = new KijunShunyugakuTekiyoShinseishoEntity();
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity1 = new KijunShunyugakuTekiyoShinseishoEntity();
            this.基準収入額適用お知ら(kijunEntity, 宛先);
            this.基準収入額適用申請書(kijunEntity1, 宛名);

            this.write帳票(文字列長, 対象世帯員, kijunEntity, kijunEntity1);

            if (this.parameter.get一覧表CSV出力フラグ() && ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(this.parameter.get抽出条件())) {
                TaishoSetaiyinCsvEntity 申請書発行一覧CSV = this.get申請書発行一覧CSV(対象世帯員);
                eucCsvWriter.writeLine(申請書発行一覧CSV);
            }
            taiShoTableWriter.update(対象世帯員);

            if (isChangeShotaiCode(exEntity.get対象世帯員(), entity.get対象世帯員())) {
                index = 1;
                index164 = 1;
            }
            this.exEntity = entity;
        }
        if (this.parameter.get一覧表CSV出力フラグ() && ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(this.parameter.get抽出条件())) {
            申請一覧Entity = this.set申請一覧Entity(entity);
            KijunShunyugakuTekiyoShinseishoHakkoIchiranReport 申請一覧Report = new KijunShunyugakuTekiyoShinseishoHakkoIchiranReport(
                    申請一覧Entity, parameter.get市町村コード().code市町村RString(), parameter.get市町村名(), 出力順リスト, 改頁項目リスト, parameter.get処理年度());
            申請一覧Report.writeBy(dBC200088SourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        if (null != this.exEntity) {
            IAtesaki 宛先 = AtesakiFactory.createInstance(this.exEntity.get宛先());
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(this.exEntity.get宛名());
            TaishoSetaiinEntity 対象世帯員 = this.exEntity.get対象世帯員();
            if (null != 宛先) {
                対象世帯員.setAtenaInnjiKubun(RSTRING_1);
            }
            IJusho 住所 = 宛名.get住所();
            int 文字列長 = 住所.get住所().length() + 住所.get方書().getColumnValue().length() + 住所.get番地().toString().length();
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity = new KijunShunyugakuTekiyoShinseishoEntity();
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity1 = new KijunShunyugakuTekiyoShinseishoEntity();
            this.基準収入額適用お知ら(kijunEntity, 宛先);
            this.基準収入額適用申請書(kijunEntity1, 宛名);

            this.write帳票(文字列長, 対象世帯員, kijunEntity, kijunEntity1);

            if (this.parameter.get一覧表CSV出力フラグ() && ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(this.parameter.get抽出条件())) {
                TaishoSetaiyinCsvEntity 申請書発行一覧CSV = this.get申請書発行一覧CSV(対象世帯員);
                eucCsvWriter.writeLine(申請書発行一覧CSV);
            }
            taiShoTableWriter.update(対象世帯員);
        }

        eucCsvWriter.close();
        manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
    }

    private void write帳票(int 文字列長, TaishoSetaiinEntity 対象世帯員,
            KijunShunyugakuTekiyoShinseishoEntity kijunEntity, KijunShunyugakuTekiyoShinseishoEntity kijunEntity1) {
        if (INT_80 < 文字列長) {
            対象世帯員.setInnjiGirisiamojiKubun(true);
            if (this.parameter.getお知らせ通知書出力フラグ() && RSTRING_1.equals(対象世帯員.getShuturyokuUmu())) {
                KijunShunyugakuTekiyoOshiraseTsuchishoReport kijunReport
                        = new KijunShunyugakuTekiyoOshiraseTsuchishoReport(kijunEntity);
                kijunReport.writeBy(dBC100063SourceWriter1);
                index++;
            }
            if (this.parameter.get申請書出力フラグ() && RSTRING_1.equals(対象世帯員.getShuturyokuUmu())) {
                KijunShunyugakuTekiyoShinseishoReport dbc64Report = new KijunShunyugakuTekiyoShinseishoReport(kijunEntity1);
                dbc64Report.writeBy(dBC100064SourceWriter1);
                index164++;
            }
        } else {
            対象世帯員.setInnjiGirisiamojiKubun(false);
            if (this.parameter.getお知らせ通知書出力フラグ() && RSTRING_1.equals(対象世帯員.getShuturyokuUmu())) {
                KijunShunyugakuTekiyoOshiraseTsuchishoReport kijunReport
                        = new KijunShunyugakuTekiyoOshiraseTsuchishoReport(kijunEntity);
                kijunReport.writeBy(dBC100063SourceWriter0);
                index++;
            }
            if (this.parameter.get申請書出力フラグ() && RSTRING_1.equals(対象世帯員.getShuturyokuUmu())) {
                KijunShunyugakuTekiyoShinseishoReport dbc64Report = new KijunShunyugakuTekiyoShinseishoReport(kijunEntity1);
                dbc64Report.writeBy(dBC100064SourceWriter0);
                index164++;
            }

        }

    }

    private boolean isChangeShotaiCode(TaishoSetaiinEntity ex対象世帯員, TaishoSetaiinEntity 対象世帯員) {
        return !ex対象世帯員.getShotaiCode().equals(対象世帯員.getShotaiCode());

    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private void 基準収入額適用お知ら(KijunShunyugakuTekiyoShinseishoEntity kijunEntity, IAtesaki 宛先) {
        if (index == 1) {
            ReportAtesakiEditor editor = new SofubutsuAtesakiEditorBuilder(宛先).build();
            SofubutsuAtesakiSource compSofubutsuAtesakiソース = new SofubutsuAtesakiSourceBuilder(editor).buildSource();
            kijunEntity.setAtesakiSource(compSofubutsuAtesakiソース);
            kijunEntity.setNinshoshaSource(確認書認証者情報);
            kijunEntity.set文書番号(this.parameter.get文書番号());
            kijunEntity.setタイトル(MESSAGE);
            kijunEntity.set被保険者番号１(getColumnValue(exEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity.set被保険者名カナ１(exEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity.set被保険者氏名１(exEntity.get対象世帯員().getHihokenshaName());
            kijunEntity.set識別コード１(exEntity.get対象世帯員().getShikibetsuCode());
            RString 通知文１ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100063.getReportId(), KamokuCode.EMPTY, INT_1, INT_1, parameter.get世帯員把握基準日());
            kijunEntity.set通知文１(通知文１.substringReturnAsPossible(INT_0, INT_1));
            kijunEntity.set通知文２(通知文１.substringReturnAsPossible(INT_1, INT_2));
            kijunEntity.set通知文３(通知文１.substringReturnAsPossible(INT_2, INT_3));
            kijunEntity.set通知文4(通知文１.substringReturnAsPossible(INT_3, INT_4));
            RString 通知文２ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100063.getReportId(), KamokuCode.EMPTY, INT_1, INT_2, parameter.get世帯員把握基準日());
            kijunEntity.set通知文5(通知文２.substringReturnAsPossible(INT_0, INT_1));
            kijunEntity.set通知文6(通知文２.substringReturnAsPossible(INT_1, INT_2));
            kijunEntity.set通知文7(通知文２.substringReturnAsPossible(INT_2, INT_3));
            kijunEntity.set通知文８(通知文２.substringReturnAsPossible(INT_3, INT_4));
            kijunEntity.set通知文９(通知文２.substringReturnAsPossible(INT_4, INT_5));
            kijunEntity.set通知文１０(通知文２.substringReturnAsPossible(INT_5, INT_6));
            kijunEntity.set通知文１１(通知文２.substringReturnAsPossible(INT_6, INT_7));
            kijunEntity.set通知文１２(通知文２.substringReturnAsPossible(INT_7, INT_8));
            kijunEntity.set通知文１３(通知文２.substringReturnAsPossible(INT_8, INT_9));
            kijunEntity.set通知文１４(通知文２.substringReturnAsPossible(INT_9, INT_10));
            kijunEntity.set通知文１５(通知文２.substringReturnAsPossible(INT_10, INT_11));
            kijunEntity.set通知文１６(通知文２.substringReturnAsPossible(INT_11, INT_12));
            kijunEntity.set通知文１７(通知文２.substringReturnAsPossible(INT_12, INT_13));
            kijunEntity.set通知文１８(通知文２.substringReturnAsPossible(INT_13, INT_14));
            kijunEntity.set通知文１９(通知文２.substringReturnAsPossible(INT_14, INT_15));
            kijunEntity.set通知文２０(通知文２.substringReturnAsPossible(INT_15, INT_16));
            kijunEntity.set通知文２１(通知文２.substringReturnAsPossible(INT_16, INT_17));
            kijunEntity.set通知文２２(通知文２.substringReturnAsPossible(INT_17, INT_18));
            kijunEntity.set通知文２３(通知文２.substringReturnAsPossible(INT_18, INT_19));
            kijunEntity.set通知文２４(通知文２.substringReturnAsPossible(INT_19, INT_20));
            kijunEntity.set通知文２５(通知文２.substringReturnAsPossible(INT_20, INT_21));
            kijunEntity.set通知文２６(通知文２.substringReturnAsPossible(INT_21, INT_22));
            kijunEntity.set通知文２７(通知文２.substringReturnAsPossible(INT_22, INT_23));
            kijunEntity.set通知文２８(通知文２.substringReturnAsPossible(INT_23, INT_24));
            kijunEntity.set通知文２９(通知文２.substringReturnAsPossible(INT_24, INT_25));
        } else if (index == INT_2) {
            kijunEntity.set被保険者番号２(getColumnValue(exEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity.set被保険者名カナ２(exEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity.set被保険者氏名２(exEntity.get対象世帯員().getHihokenshaName());
            kijunEntity.set識別コード２(exEntity.get対象世帯員().getShikibetsuCode());
        } else if (index == INT_3) {
            kijunEntity.set被保険者番号３(getColumnValue(exEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity.set被保険者名カナ３(exEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity.set被保険者氏名３(exEntity.get対象世帯員().getHihokenshaName());
            kijunEntity.set識別コード３(exEntity.get対象世帯員().getShikibetsuCode());
        } else if (INT_3 < index) {
            kijunEntity.setその他被保険者(MESSAGE_その他);
        }

    }

    private void 基準収入額適用申請書(KijunShunyugakuTekiyoShinseishoEntity kijunEntity1, IShikibetsuTaisho 宛名) {
        if (index164 == 1) {

            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険,
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), this.parameter.get作成日());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            RString 申請先 = 認証者.get市町村付与名称(地方公共団体);
            kijunEntity1.set申請先(申請先);

            kijunEntity1.set被保険者番号１(getColumnValue(exEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity1.set被保険者名カナ１(exEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity1.set被保険者氏名１(exEntity.get対象世帯員().getHihokenshaName());
            kijunEntity1.set被保険者生年月日１(exEntity.get対象世帯員().getSeinengappiYMD());
            kijunEntity1.set被保険者性別１(exEntity.get対象世帯員().getSex());
            IJusho 宛名住所 = 宛名.get住所();
            RString 住所 = 宛名住所.get住所()
                    .concat(宛名住所.get方書().getColumnValue()).concat(宛名住所.get番地().toString());
            kijunEntity1.set住所１(住所.substringReturnAsPossible(INT_0, INT_50));
            kijunEntity1.set住所２(住所.substringReturnAsPossible(INT_50));
            kijunEntity1.set連絡先(exEntity.get対象世帯員().getRennrakusaki());
            RString 通知文１ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100064.getReportId(), KamokuCode.EMPTY, INT_1).get(INT_1);
            kijunEntity1.set通知文１(通知文１);
            RString 通知文２ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100064.getReportId(), KamokuCode.EMPTY, INT_1).get(INT_2);
            if (通知文２ != null) {
                kijunEntity1.set通知文２(通知文２.substringReturnAsPossible(INT_0, INT_1));
                kijunEntity1.set通知文３(通知文２.substringReturnAsPossible(INT_1, INT_2));
                kijunEntity1.set通知文4(通知文２.substringReturnAsPossible(INT_2, INT_3));
                kijunEntity1.set通知文5(通知文２.substringReturnAsPossible(INT_3, INT_4));
                kijunEntity1.set通知文6(通知文２.substringReturnAsPossible(INT_4, INT_5));
                kijunEntity1.set通知文7(通知文２.substringReturnAsPossible(INT_5, INT_6));
                kijunEntity1.set通知文８(通知文２.substringReturnAsPossible(INT_6, INT_7));
                kijunEntity1.set通知文９(通知文２.substringReturnAsPossible(INT_7, INT_8));
                kijunEntity1.set通知文１０(通知文２.substringReturnAsPossible(INT_8, INT_9));
                kijunEntity1.set通知文１１(通知文２.substringReturnAsPossible(INT_9, INT_10));
                kijunEntity1.set通知文１２(通知文２.substringReturnAsPossible(INT_10, INT_11));
                kijunEntity1.set通知文１３(通知文２.substringReturnAsPossible(INT_11, INT_12));
            }
            RString 年度 = parameter.get処理年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
            kijunEntity1.set収入元号(年度.substringReturnAsPossible(INT_0, INT_2));
            kijunEntity1.set収入年(年度.substringReturnAsPossible(INT_2));
        } else if (index164 == INT_2) {
            kijunEntity1.set被保険者番号２(getColumnValue(exEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity1.set被保険者名カナ２(exEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity1.set被保険者氏名２(exEntity.get対象世帯員().getHihokenshaName());
            kijunEntity1.set被保険者生年月日２(exEntity.get対象世帯員().getSeinengappiYMD());
            kijunEntity1.set被保険者性別２(exEntity.get対象世帯員().getSex());
        } else if (index164 == INT_3) {
            kijunEntity1.set被保険者番号３(getColumnValue(exEntity.get対象世帯員().getHihokenshaNo()));
            kijunEntity1.set被保険者名カナ３(exEntity.get対象世帯員().getHihokenshaKana());
            kijunEntity1.set被保険者氏名３(exEntity.get対象世帯員().getHihokenshaName());
            kijunEntity1.set被保険者生年月日３(exEntity.get対象世帯員().getSeinengappiYMD());
            kijunEntity1.set被保険者性別３(exEntity.get対象世帯員().getSex());
        } else if (INT_3 < index164) {
            kijunEntity1.setその他被保険者(MESSAGE_その他);
        }

    }

    private enum 特定項目 implements ISpecificKey {

        key1(KijunShunyugakuTekiyoOshiraseTsuchishoSource.ITEM_HIHOKENSHANO1, 定数_被保険者番号.toString());

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

    private TaishoSetaiyinCsvEntity get申請書発行一覧CSV(TaishoSetaiinEntity 対象世帯員) {
        TaishoSetaiyinCsvEntity csvEntity = new TaishoSetaiyinCsvEntity();
        csvEntity.set世帯コード(対象世帯員.getShotaiCode());
        csvEntity.set処理年度(doFlexibleYear編集(対象世帯員.getShoriNendo()));
        csvEntity.set世帯課税区分(対象世帯員.getSetaikazeiKubun());
        csvEntity.set総収入額(doDecimal編集(対象世帯員.getSoushuu()));
        csvEntity.setメッセージ(対象世帯員.getMessage());
        csvEntity.set出力有無(対象世帯員.getShuturyokuUmu());
        csvEntity.set年少扶養控除_16歳未満人数(対象世帯員.getNennshouLess16Num());
        csvEntity.set年少扶養控除_16歳から18歳人数(対象世帯員.getNennshouLess16_18Num());
        csvEntity.setランク市町村コード(対象世帯員.getRannkuShichosonCode());
        csvEntity.set世帯員把握基準日(doFlexibleDate編集(対象世帯員.getShotaikijunDay()));
        csvEntity.set世帯員把握基準日2(doFlexibleDate編集(対象世帯員.getShotaikijunDay2()));
        csvEntity.set更新時履歴番号(対象世帯員.getKoushinnNo());
        csvEntity.set印字文字欠け区分(対象世帯員.getInnjiGirisiamojiKubun());
        if (!RString.isNullOrEmpty(対象世帯員.getHihokenshaNo().getColumnValue())) {
            csvEntity.set被保険者番号(対象世帯員.getHihokenshaNo().getColumnValue());
            csvEntity.set識別コード(対象世帯員.getShikibetsuCode().getColumnValue());
            csvEntity.set市町村コード(対象世帯員.getShichosonCode());
            csvEntity.set住所地特例フラグ(対象世帯員.getJushochiTokureiFlag());
            csvEntity.set課税区分(対象世帯員.getKazeiKubun());
            csvEntity.set課税所得(doDecimal編集(対象世帯員.getKazeiShotokuGaku()));
            csvEntity.set課税所得_控除後(doDecimal編集(対象世帯員.getKazeiShotokuGakuAfter()));
            csvEntity.set年金収入(doDecimal編集(対象世帯員.getNenkinShunyuGaku()));
            csvEntity.setその他の合計所得(doDecimal編集(対象世帯員.getSonotanoGoukeiShotokuKingakuGoukei()));
            csvEntity.set編集続柄コード(対象世帯員.getHennshuuZokugaraCode());
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
            csvEntity.set宛名_印字者区分(対象世帯員.getAtenaInnjiKubun());
        } else {
            csvEntity.set氏名(MESSAGE_該当データなし);
        }

        return csvEntity;
    }

    private RString doDecimal編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toRString(number, 0);
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
        if (exEntity.get宛名() != null && entity.get宛名() != null) {
            IShikibetsuTaisho ex宛名 = ShikibetsuTaishoFactory.createKojin(exEntity.get宛名());
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            if (!ex宛名.get住所().get郵便番号().equals(宛名.get住所().get郵便番号())) {
                flag = true;
            } else if (!ex宛名.get住所().get町域コード().equals(宛名.get住所().get町域コード())) {
                flag = true;
            } else if (!ex宛名.get行政区画().getGyoseiku().getコード().equals(宛名.get行政区画().getGyoseiku().getコード())) {
                flag = true;
            } else if (!ex宛名.get世帯コード().equals(宛名.get世帯コード())) {
                flag = true;
            }
        } else if (!exEntity.get対象世帯員().getShichosonCode().equals(entity.get対象世帯員().getShichosonCode())) {
            flag = true;
        }
        return flag;
    }

    private KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity set申請一覧Entity(CreateTaishoSetaiyinEntity entity) {
        KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 申請一覧Entity = new KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity();
        if (1 == index) {
            申請一覧Entity.set通番(new RString(通番));
            申請一覧Entity.set世帯番号(entity.get対象世帯員().getShotaiCode());
            通番++;
        } else if (this.isChangeShotaiCode(exEntity.get対象世帯員(), entity.get対象世帯員()) || is改頁(exEntity, entity)) {
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
        申請一覧Entity.set課税所得(entity.get対象世帯員().getKazeiShotokuGaku());
        申請一覧Entity.set課税所得_控除後(entity.get対象世帯員().getKazeiShotokuGakuAfter());
        申請一覧Entity.set年金収入(entity.get対象世帯員().getNenkinShunyuGaku());
        申請一覧Entity.setその他合計所得(entity.get対象世帯員().getSonotanoGoukeiShotokuKingakuGoukei());
        申請一覧Entity.set合計(this.合計(entity.get対象世帯員().getNenkinShunyuGaku(), entity.get対象世帯員().getSonotanoGoukeiShotokuKingakuGoukei()));
        申請一覧Entity.set要介護度(entity.get対象世帯員().getNijiHanteiYokaigoJotaiKubunCode());
        申請一覧Entity.set認定開始日(entity.get対象世帯員().getNinteiYukoKikanKaishiYMD());
        申請一覧Entity.set認定終了日(entity.get対象世帯員().getNinteiYukoKikanShuryoYMD());

        if (entity.get宛名() != null) {
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            申請一覧Entity.set郵便番号(宛名.get住所().get郵便番号().getColumnValue());
            申請一覧Entity.set町域コード(宛名.get住所().get町域コード().getColumnValue());
            申請一覧Entity.set行政区コード(宛名.get行政区画().getGyoseiku().getコード().getColumnValue());
            申請一覧Entity.set世帯コード(宛名.get世帯コード().getColumnValue());
            申請一覧Entity.set市町村コード(entity.get対象世帯員().getShichosonCode());
        }

        return 申請一覧Entity;

    }

    private Decimal 合計(Decimal a, Decimal b) {
        if (a != null && b != null) {
            return a.add(b);
        } else if (b == null) {
            return a;
        } else if (a == null) {
            return b;
        } else {
            return null;
        }

    }

}
