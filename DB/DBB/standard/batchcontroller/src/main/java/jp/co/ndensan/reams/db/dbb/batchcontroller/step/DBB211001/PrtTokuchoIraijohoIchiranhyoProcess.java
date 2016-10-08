/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran.DBB200019_TokubetsuChoshuIraiJohoIchiranEnum;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.PrtTokuchoIraijohoIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.tokuchosoufujohosakuseibatch.TokubetsuChoshuIraiJohoIchiranDataCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuChoIraiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NenkinHokenshaHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特徴依頼情報一覧表の発行します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class PrtTokuchoIraijohoIchiranhyoProcess extends BatchKeyBreakBase<TokuChoIraiIchiran> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get依頼情報出力対象データ");
    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
    private static final RString 出力ファイル名 = new RString("TokubetsuChoshuIraiJohoIchiranData.csv");
    private static final RString 出力ファイル名_出力条件 = new RString("特別徴収依頼情報一覧表");
    private static final RString 出力ファイル名_NO_DATA = new RString("-");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200019");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 年金保険者名称_厚労省 = new RString("厚労省");
    private static final RString 年金保険者名称_地共済 = new RString("地共済");
    private static final RString CSV出力有無_無り = new RString("なし");
    private static final RString CSV出力有無_有り = new RString("あり");

    private PrtTokuchoIraijohoIchiranhyoProcessParameter parameter;
    private IOutputOrder suturyokujun;
    private RString 特別徴収依頼情報一覧表ＣＳＶFilePath;
    private PrtTokuchoIraijohoIchiranhyoProcessCore processCore;
    private FileSpoolManager manager;
    private boolean isHasData;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private Association 地方公共団体;
    private RString 保険者情報_保険者番号;
    private RString 保険者情報_保険者名称;

    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuIraiJohoIchiranSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuIraiJohoIchiranSource> reportSourceWriter;

    @BatchWriter
    CsvWriter<TokubetsuChoshuIraiJohoIchiranDataCSVEntity> 特別徴収依頼情報一覧表ＣＳＶ;

    @Override
    protected void initialize() {
        isHasData = false;
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (!RString.isNullOrEmpty(parameter.get出力順ID())) {
            suturyokujun = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBB介護賦課,
                    new ReportId(parameter.get帳票ID()), Long.valueOf(parameter.get出力順ID().toString()));
        }
        processCore = new PrtTokuchoIraijohoIchiranhyoProcessCore(suturyokujun);
        帳票制御共通情報 = get帳票制御共通情報();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        保険者情報_保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                parameter.getシステム日時().getDate(), SubGyomuCode.DBU介護統計報告);
        保険者情報_保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称,
                parameter.getシステム日時().getDate(), SubGyomuCode.DBU介護統計報告);
    }

    @Override
    protected IBatchReader createReader() {
        RString 出力順 = MyBatisOrderByClauseCreator.create(
                DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.class, suturyokujun);
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
                if (i != list.size() - 1) {
                    rStringBuilder.append(MIDDLE_FORMAT);
                }
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectOutputDataMyBatisParameter(出力順, 処理日, 科目コード));
    }

    @Override
    protected void createWriter() {
        if (!processCore.is改頁()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200019.getReportId().value()).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200019.getReportId().value()).addBreak(
                    new PrtTokuchoIraijohoIchiranhyoProcessPageBreak(processCore.改頁項())).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        特別徴収依頼情報一覧表ＣＳＶFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        特別徴収依頼情報一覧表ＣＳＶ = BatchWriters.csvWriter(TokubetsuChoshuIraiJohoIchiranDataCSVEntity.class).
                filePath(特別徴収依頼情報一覧表ＣＳＶFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(TokuChoIraiIchiran t) {
    }

    @Override
    protected void usualProcess(TokuChoIraiIchiran t) {
        isHasData = true;
        IAtesaki 宛先情報 = null;
        if (t.get宛先() != null) {
            宛先情報 = AtesakiFactory.createInstance(t.get宛先());
        }

        RString 行政区コード = 行政区コードの編集(宛先情報, 帳票制御共通情報);
        HyojiCodes 表示コード = get表示コード(t, 帳票制御共通情報);
        RString 年金保険者名称 = 年金保険者名称の編集(t.get対象者情報().getDtTokubetsuChoshuGimushaCode());
        TokubetsuChoshuIraiJohoIchiranEntity 特徴依頼情報Entity = 特徴依頼情報Entityを作成(行政区コード,
                表示コード, 年金保険者名称, t.get対象者情報(), t.get市町村名称());
        TokubetsuChoshuIraiJohoIchiranReport report = new TokubetsuChoshuIraiJohoIchiranReport(
                特徴依頼情報Entity, processCore.出力順項(), processCore.get改頁項名(),
                parameter.getシステム日時().getRDateTime());
        report.writeBy(reportSourceWriter);
        TokubetsuChoshuIraiJohoIchiranDataCSVEntity cSVEntity = csvEntityの編集(行政区コード, 表示コード,
                年金保険者名称, t.get対象者情報(), t.get市町村名称());
        特別徴収依頼情報一覧表ＣＳＶ.writeLine(cSVEntity);
    }

    @Override
    protected void afterExecute() {
        特別徴収依頼情報一覧表ＣＳＶ.close();
        List<RString> 出力条件リスト = parameter.get出力条件リスト();
        int 出力ページ数 = reportSourceWriter.pageCount().value();
        RString 帳票名 = ReportIdDBB.DBB200019.getReportName();
        RString csv出力有無 = CSV出力有無_無り;
        RString csvファイル名 = 出力ファイル名_NO_DATA;
        if (isHasData) {
            manager.spool(特別徴収依頼情報一覧表ＣＳＶFilePath);
            csv出力有無 = CSV出力有無_有り;
            csvファイル名 = 出力ファイル名_出力条件;
        }
        loadバッチ出力条件リスト(出力条件リスト, new ReportId(parameter.get帳票ID()),
                出力ページ数, csv出力有無, csvファイル名, 帳票名);

    }

    private ChohyoSeigyoKyotsu get帳票制御共通情報() {
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        return chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBB介護賦課,
                new ReportId(parameter.get帳票ID()));
    }

    private RString 行政区コードの編集(IAtesaki 宛先情報, ChohyoSeigyoKyotsu 帳票制御共通情報) {

        EditedAtesaki 編集後宛先 = null;
        if (宛先情報 != null && 地方公共団体 != null
                && 帳票制御共通情報 != null) {

            編集後宛先 = JushoHenshu.create編集後宛先(宛先情報, 地方公共団体, 帳票制御共通情報);
        }
        if (編集後宛先 != null && 編集後宛先.get行政区コード() != null) {
            return 編集後宛先.get行政区コード().value();
        } else {
            return RString.EMPTY;
        }
    }

    private HyojiCodes get表示コード(TokuChoIraiIchiran 特徴依頼一覧Entity, ChohyoSeigyoKyotsu 帳票制御共通情報) {
        HyojiCodes 表示コード = null;
        HyojiCodeResearcher researcher = new HyojiCodeResearcher();
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = 特徴依頼一覧Entity.get宛名();
        ChoikiCode 町域コード = ChoikiCode.EMPTY;
        GyoseikuCode 行政区コー = GyoseikuCode.EMPTY;
        ChikuCode 地区コード１ = ChikuCode.EMPTY;
        ChikuCode 地区コード２ = ChikuCode.EMPTY;
        ChikuCode 地区コード３ = ChikuCode.EMPTY;
        if (isNotNull(宛名情報)) {
            町域コード = 宛名情報.getChoikiCode();
            行政区コー = 宛名情報.getGyoseikuCode();
            地区コード１ = 宛名情報.getChikuCode1();
            地区コード２ = 宛名情報.getChikuCode2();
            地区コード３ = 宛名情報.getChikuCode3();
        }
        if (isNotNull(帳票制御共通情報)) {
            表示コード = researcher.create表示コード情報(帳票制御共通情報.toEntity(),
                    町域コード != null ? 町域コード.value() : RString.EMPTY,
                    行政区コー != null ? 行政区コー.value() : RString.EMPTY,
                    地区コード１ != null ? 地区コード１.value() : RString.EMPTY,
                    地区コード２ != null ? 地区コード２.value() : RString.EMPTY,
                    地区コード３ != null ? 地区コード３.value() : RString.EMPTY,
                    (isNotNull(特徴依頼一覧Entity.get納組()) && isNotNull(特徴依頼一覧Entity.get納組().getNokumi()))
                    ? 特徴依頼一覧Entity.get納組().getNokumi().getNokumiCode() : RString.EMPTY);
        }
        return 表示コード;
    }

    private RString 年金保険者名称の編集(Code dT特徴義務者コード) {
        NenkinHokenshaHantei 年金保険者判定クラス = new NenkinHokenshaHantei();
        if (isNotNull(dT特徴義務者コード)
                && 年金保険者判定クラス.is厚労省(dT特徴義務者コード.value())) {
            return 年金保険者名称_厚労省;
        } else {
            return 年金保険者名称_地共済;
        }
    }

    private TokubetsuChoshuIraiJohoIchiranEntity 特徴依頼情報Entityを作成(RString 行政区コード,
            HyojiCodes 表示コード, RString 年金保険者名称,
            UeT0511NenkinTokuchoKaifuJohoEntity 特徴依頼追加情報, RString 市町村名称) {
        TokubetsuChoshuIraiJohoIchiranEntity 特徴依頼情報Entity = new TokubetsuChoshuIraiJohoIchiranEntity();
        特徴依頼情報Entity.set年金保険者名称(年金保険者名称);
        特徴依頼情報Entity.set市町村コード(特徴依頼追加情報.getKoseiCityCode());
        特徴依頼情報Entity.set市町村名称(市町村名称);
        特徴依頼情報Entity.set保険者番号(保険者情報_保険者番号);
        特徴依頼情報Entity.set保険者名称(保険者情報_保険者名称);
        if (isNotNull(表示コード)) {
            特徴依頼情報Entity.set表示コード名称1(表示コード.get表示コード名１());
            特徴依頼情報Entity.set表示コード名称2(表示コード.get表示コード名２());
            特徴依頼情報Entity.set表示コード名称3(表示コード.get表示コード名３());
            特徴依頼情報Entity.set表示コード1(表示コード.get表示コード１());
            特徴依頼情報Entity.set表示コード2(表示コード.get表示コード２());
            特徴依頼情報Entity.set表示コード3(表示コード.get表示コード３());
        }
        特徴依頼情報Entity.set被保険者番号(特徴依頼追加情報.getHihokenshaNo());
        特徴依頼情報Entity.set年金番号(特徴依頼追加情報.getKisoNenkinNo());
        特徴依頼情報Entity.setカナ氏名(特徴依頼追加情報.getDtKanaShimei());
        特徴依頼情報Entity.set生年月日(特徴依頼追加情報.getDtBirthDay());
        特徴依頼情報Entity.set行政区コード(行政区コード);
        特徴依頼情報Entity.set金額1(特徴依頼追加情報.getDtKakushuKingaku1());
        特徴依頼情報Entity.set金額2(特徴依頼追加情報.getDtKakushuKingaku2());
        特徴依頼情報Entity.set金額3(特徴依頼追加情報.getDtKakushuKingaku3());
        ShikibetsuCode 識別コード = 特徴依頼追加情報.getShikibetsuCode();
        if (識別コード != null) {
            特徴依頼情報Entity.set識別コード(識別コード.value());
        } else {
            特徴依頼情報Entity.set識別コード(RString.EMPTY);
        }
        特徴依頼情報Entity.set年金コード(特徴依頼追加情報.getNenkinCode());
        特徴依頼情報Entity.set漢字氏名(特徴依頼追加情報.getDtKanjiShimei());
        特徴依頼情報Entity.set性別(特徴依頼追加情報.getDtSeibetsu());
        特徴依頼情報Entity.set郵便番号(特徴依頼追加情報.getDtYubinNo());
        特徴依頼情報Entity.set住所(特徴依頼追加情報.getDtKanaJusho());

        return 特徴依頼情報Entity;
    }

    private TokubetsuChoshuIraiJohoIchiranDataCSVEntity csvEntityの編集(RString 行政区コード,
            HyojiCodes 表示コード, RString 年金保険者名称,
            UeT0511NenkinTokuchoKaifuJohoEntity 特徴依頼追加情報, RString 市町村名称) {

        RString 作成日 = parameter.getシステム日時().getRDateTime().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.getシステム日時().getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
        TokubetsuChoshuIraiJohoIchiranDataCSVEntity csvEntity = new TokubetsuChoshuIraiJohoIchiranDataCSVEntity();
        csvEntity.set作成日時(作成日);
        csvEntity.set作成時刻(作成時);
        csvEntity.set年金保険者名称(年金保険者名称);
        csvEntity.set市町村コード(特徴依頼追加情報.getKoseiCityCode());
        csvEntity.set市町村名称(市町村名称);
        csvEntity.set保険者番号(保険者情報_保険者番号);
        csvEntity.set保険者名称(保険者情報_保険者名称);
        if (isNotNull(表示コード)) {
            csvEntity.set表示コード名称1(表示コード.get表示コード名１());
            csvEntity.set表示コード名称2(表示コード.get表示コード名２());
            csvEntity.set表示コード名称3(表示コード.get表示コード名３());
            csvEntity.set表示コード1(表示コード.get表示コード１());
            csvEntity.set表示コード2(表示コード.get表示コード２());
            csvEntity.set表示コード3(表示コード.get表示コード３());
        }
        csvEntity.set被保険者番号(特徴依頼追加情報.getHihokenshaNo());
        csvEntity.set年金番号(特徴依頼追加情報.getKisoNenkinNo());
        csvEntity.setカナ氏名(特徴依頼追加情報.getDtKanaShimei());
        csvEntity.set生年月日(特徴依頼追加情報.getDtBirthDay());
        csvEntity.set行政区コード(行政区コード);
        csvEntity.set金額1(金額の編集(特徴依頼追加情報.getDtKakushuKingaku1()));
        csvEntity.set金額2(金額の編集(特徴依頼追加情報.getDtKakushuKingaku2()));
        csvEntity.set金額3(金額の編集(特徴依頼追加情報.getDtKakushuKingaku3()));
        ShikibetsuCode 識別コード = 特徴依頼追加情報.getShikibetsuCode();
        if (識別コード != null) {
            csvEntity.set識別コード(識別コード.value());
        } else {
            csvEntity.set識別コード(RString.EMPTY);
        }
        csvEntity.set年金コード(特徴依頼追加情報.getNenkinCode());
        csvEntity.set漢字氏名(特徴依頼追加情報.getDtKanjiShimei());
        csvEntity.set性別(特徴依頼追加情報.getDtSeibetsu());
        csvEntity.set郵便番号(特徴依頼追加情報.getDtYubinNo());
        csvEntity.set住所(特徴依頼追加情報.getDtKanaJusho());

        return csvEntity;
    }

    private RString 金額の編集(RString 金額) {
        Decimal 編集金額 = Decimal.ZERO;
        if (!RString.isNullOrEmpty(金額)) {
            編集金額 = new Decimal(金額.toString());
        }
        return DecimalFormatter.toコンマ区切りRString(編集金額, 0);
    }

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト,
            ReportId 帳票ID, int 出力ページ数, RString csv出力有無, RString csvファイル名, RString 帳票名) {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                new RString(String.valueOf(出力ページ数)),
                csv出力有無,
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private boolean isNotNull(Object o) {
        return o != null;
    }

}
