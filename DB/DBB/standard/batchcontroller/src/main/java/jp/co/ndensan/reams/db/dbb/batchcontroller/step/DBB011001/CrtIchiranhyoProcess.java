/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 一覧表作成processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class CrtIchiranhyoProcess extends BatchKeyBreakBase<TokuchoKariKeisangoFukaEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select特別徴収仮算定結果一覧表");
    private final ReportId 帳票分類Id = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_3 = 3;
    private static final int INT_5 = 5;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200002");
    private static final RString EUCファイル名 = new RString("TokubetsuChoshuKarisanteiKekkaIchiranData.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 継続 = new RString("継続");
    private static final RString 開始月_6月 = new RString("6月");
    private static final RString 特徴停止 = new RString("特徴停止");
    private TokuchoKarisanteiFukaProcessParameter processParameter;
    RString 市町村コード;
    RString 市町村名称;
    RString 住所編集;
    Decimal 前年度保険料;
    List<RString> 並び順List;
    List<RString> 改頁List;
    int 連番;
    int 連番_CSV;
    FileSpoolManager manager;
    RString spoolWorkPath;
    RString eucFilePath;

    private BatchReportWriter<TokubetsuChoshuKarisanteiKekkaIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<TokubetsuChoshuKarisanteiKekkaIchiranSource> reportSourceWriter_一覧表;
    private CsvListWriter csvListWriter;

    @Override
    protected void initialize() {
        市町村コード = RString.EMPTY;
        市町村名称 = RString.EMPTY;
        住所編集 = RString.EMPTY;
        前年度保険料 = Decimal.ZERO;
        並び順List = new ArrayList<>();
        改頁List = new ArrayList<>();
        連番 = INT_0;
        連番_CSV = INT_1;
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);
    }

    @Override
    protected void beforeExecute() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        市町村名称 = association.get市町村名();
        if (association.get地方公共団体コード() != null) {
            市町村コード = association.get地方公共団体コード().value();
        }
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 帳票分類Id, Long.parseLong(processParameter.get出力順ID().toString()));
        if (並び順 != null) {
            get並び順List(並び順);
        }
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoKarisanteiFukaMyBatisParameter parameter = new TokuchoKarisanteiFukaMyBatisParameter();
        RString 出力順 = get出力順(帳票分類Id, processParameter.get出力順ID());
        parameter.set出力順(出力順);
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<TokubetsuChoshuKarisanteiKekkaIchiranSource> breaker = new TokubetsuChoshuKarisanteiKekkaIchiranPageBreak(改頁List);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB200002.getReportId().value(), SubGyomuCode.DBB介護賦課).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void keyBreakProcess(TokuchoKariKeisangoFukaEntity entity) {
    }

    @Override
    protected void usualProcess(TokuchoKariKeisangoFukaEntity entity) {
        連番 = 連番 + 1;
        set住所編集(entity);
        TokubetsuChoshuKarisanteiKekkaIchiranReport 一覧表report = new TokubetsuChoshuKarisanteiKekkaIchiranReport(市町村コード, 市町村名称,
                entity, processParameter.get調定年度(), processParameter.get調定日時(), 並び順List, 改頁List, 住所編集, 前年度保険料, 連番);
        一覧表report.writeBy(reportSourceWriter_一覧表);
        csvListWriter.writeLine(getCSVData(entity, processParameter.get調定日時(), 連番_CSV));
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
        manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        TokuchoKariSanteiFukaManagerBatch.createInstance().loadバッチ出力条件リスト(processParameter.get調定年度(), processParameter.get賦課年度(),
                Long.parseLong(processParameter.get出力順ID().toString()),
                new RString(String.valueOf(reportSourceWriter_一覧表.pageCount().value())));
        batchReportWriter_一覧表.close();
    }

    private void set住所編集(TokuchoKariKeisangoFukaEntity entity) {
        IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu 帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBB介護賦課, 帳票分類Id);
        住所編集 = JushoHenshu.editJusho(帳票制御共通, 宛名情報,
                AssociationFinderFactory.createInstance().getAssociation());
        if (entity.get前年度保険料段階() != null && !entity.get前年度保険料段階().isEmpty()) {
            HokenryoDankai 保険料段階 = new HokenryoDankaiSettings().getCurrent保険料段階List().getBy段階区分(entity.get前年度保険料段階());
            前年度保険料 = 保険料段階.get保険料率();
        }
    }

    private void get並び順List(IOutputOrder 並び順) {
        for (int i = INT_0; i < INT_5; i++) {
            if (i < 並び順.get設定項目リスト().size()) {
                並び順List.add(並び順.get設定項目リスト().get(i).get項目名());
                if (並び順.get設定項目リスト().get(i).is改頁項目()) {
                    改頁List.add(並び順.get設定項目リスト().get(i).get項目名());
                }
            } else {
                break;
            }
        }
    }

    private List<RString> getCSVData(TokuchoKariKeisangoFukaEntity entity, YMDHMS 調定日時, int 連番) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(new RString(String.valueOf(連番)));
        if (調定日時 == null || 調定日時.isEmpty()) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(調定日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
            bodyList.add(調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        }
        if (isNull(entity.get宛名())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(get郵便番号(entity.get宛名().getYubinNo()));
            bodyList.add(住所編集);
            bodyList.add(get住所(entity.get宛名().getJusho()));
            bodyList.add(get番地(entity.get宛名().getBanchi()));
            bodyList.add(get行政区コード(entity.get宛名().getGyoseikuCode()));
            bodyList.add(entity.get宛名().getGyoseikuName());
            bodyList.add(get生年月日(entity.get宛名().getSeinengappiYMD()));
            IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            bodyList.add(宛名情報.get性別().getCommonName());
        }
        RString 特別徴収停止事由コード = entity.get特別徴収停止事由コード();
        Decimal 特徴期期別金額01 = entity.get特徴期期別金額01();
        Decimal 特徴期期別金額02 = entity.get特徴期期別金額02();
        Decimal 特徴期期別金額03 = entity.get特徴期期別金額03();
        bodyList.add(get開始月(特別徴収停止事由コード, 特徴期期別金額01, 特徴期期別金額02, 特徴期期別金額03));
        RString 前年度保険料段階_CSV = entity.get前年度保険料段階();
        if (前年度保険料段階_CSV != null && !前年度保険料段階_CSV.isEmpty()) {
            HokenryoDankaiList 保険料段階リスト = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
            bodyList.add(保険料段階リスト.getBy段階区分(前年度保険料段階_CSV).get表記());
            RString 前年度保険料_CSV = DecimalFormatter.toコンマ区切りRString(保険料段階リスト.getBy段階区分(前年度保険料段階_CSV).get保険料率(), INT_0);
            bodyList.add(前年度保険料_CSV);
        } else {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(get通知書番号(entity.get通知書番号()));
        bodyList.add(get世帯コード(entity.get世帯コード()));
        bodyList.add(get漢字氏名(entity.get宛名().getKanjiShimei()));
        bodyList.add(get特別徴収業務者コード(entity.get特別徴収義務者コード()));
        if (entity.get特別徴収義務者コード() != null) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    entity.get特別徴収義務者コード()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(entity.get仮徴収_年金コード());
        RString 特別徴収対象年金コード = RString.EMPTY;
        if (entity.get仮徴収_年金コード() != null && !entity.get仮徴収_年金コード().isEmpty()) {
            特別徴収対象年金コード = entity.get仮徴収_年金コード().substring(INT_0, INT_3);
        }
        if (特別徴収対象年金コード != null) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(特別徴収対象年金コード)));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (entity.get特別徴収停止事由コード() == null || entity.get特別徴収停止事由コード().isEmpty()) {
            set特徴期期別金額01(entity, bodyList);
            set特徴期期別金額02(entity, bodyList);
            set特徴期期別金額03(entity, bodyList);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(特徴停止);
            if (entity.get特別徴収停止事由コード() != null) {
                bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.特別徴収停止事由.getコード(),
                        new Code(entity.get特別徴収停止事由コード())));
            } else {
                bodyList.add(RString.EMPTY);
            }
        }
        for (int j = INT_0; j < bodyList.size(); j++) {
            if (bodyList.get(j) == null) {
                bodyList.remove(bodyList.get(j));
                bodyList.add(j, RString.EMPTY);
            }
        }
        return bodyList;
    }

    private void set特徴期期別金額03(TokuchoKariKeisangoFukaEntity entity, List<RString> bodyList) {
        if (entity.get特徴期期別金額03() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(entity.get特徴期期別金額03(), INT_0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void set特徴期期別金額02(TokuchoKariKeisangoFukaEntity entity, List<RString> bodyList) {
        if (entity.get特徴期期別金額02() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(entity.get特徴期期別金額02(), INT_0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void set特徴期期別金額01(TokuchoKariKeisangoFukaEntity entity, List<RString> bodyList) {
        if (entity.get特徴期期別金額01() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(entity.get特徴期期別金額01(), INT_0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private boolean isNull(Object 項目) {
        return 項目 == null;
    }

    private RString get郵便番号(YubinNo 郵便番号) {
        if (郵便番号 == null) {
            return RString.EMPTY;
        }
        return 郵便番号.value();
    }

    private RString get住所(AtenaJusho 住所) {
        if (住所 == null) {
            return RString.EMPTY;
        }
        return 住所.value();
    }

    private RString get番地(AtenaBanchi 番地) {
        if (番地 == null) {
            return RString.EMPTY;
        }
        return 番地.value();
    }

    private RString get行政区コード(GyoseikuCode 行政区コード) {
        if (行政区コード == null) {
            return RString.EMPTY;
        }
        return 行政区コード.value();
    }

    private RString get生年月日(FlexibleDate 生年月日) {
        if (生年月日 == null) {
            return RString.EMPTY;
        }
        return new RString(生年月日.toString());
    }

    private RString get開始月(RString 特別徴収停止事由コード,
            Decimal 特徴期期別金額01,
            Decimal 特徴期期別金額02,
            Decimal 特徴期期別金額03) {
        if (特別徴収停止事由コード == null || 特別徴収停止事由コード.isEmpty()) {
            if (set開始月_継続(特徴期期別金額01, 特徴期期別金額02, 特徴期期別金額03)) {
                return 継続;
            }
            if (set開始月_6月(特徴期期別金額01, 特徴期期別金額02, 特徴期期別金額03)) {
                return 開始月_6月;
            }
        }
        return RString.EMPTY;
    }

    private boolean set開始月_6月(Decimal 特徴期期別金額01, Decimal 特徴期期別金額02, Decimal 特徴期期別金額03) {
        return 特徴期期別金額01 != null && 特徴期期別金額02 != null && 特徴期期別金額03 != null && 特徴期期別金額01.equals(Decimal.ZERO)
                && INT_0 < 特徴期期別金額02.intValue() && INT_0 < 特徴期期別金額03.intValue();
    }

    private boolean set開始月_継続(Decimal 特徴期期別金額01, Decimal 特徴期期別金額02, Decimal 特徴期期別金額03) {
        return 特徴期期別金額01 != null && 特徴期期別金額02 != null && 特徴期期別金額03 != null && INT_0 < 特徴期期別金額01.intValue()
                && INT_0 < 特徴期期別金額02.intValue() && INT_0 < 特徴期期別金額03.intValue();
    }

    private RString get通知書番号(TsuchishoNo 通知書番号) {
        if (通知書番号 == null) {
            return RString.EMPTY;
        }
        return 通知書番号.value();
    }

    private RString get世帯コード(SetaiCode 世帯コード) {
        if (世帯コード == null) {
            return RString.EMPTY;
        }
        return 世帯コード.value();
    }

    private RString get漢字氏名(AtenaMeisho 漢字氏名) {
        if (漢字氏名 == null) {
            return RString.EMPTY;
        }
        return 漢字氏名.value();
    }

    private RString get特別徴収業務者コード(Code 特別徴収業務者コード) {
        if (特別徴収業務者コード == null) {
            return RString.EMPTY;
        }
        return 特別徴収業務者コード.value();
    }

    private RString get出力順(ReportId 帳票分類ID, RString 出力順ID) {

        if (RString.isNullOrEmpty(出力順ID)) {
            return RString.EMPTY;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        if (outputOrder == null) {
            return RString.EMPTY;
        }
        return MyBatisOrderByClauseCreator.create(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.class, outputOrder);
    }
}
