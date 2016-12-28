/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE514002;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedulekagami.IKaigoNinteiShinsakaiScheduleKagamiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;

/**
 *
 * 介護認定審査会スケジュール表_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-0130-100 yaodongsheng
 */
public class ShinsakaiScheduleKagamiProcess extends BatchProcessBase<KaigoNinteiShinsakaiScheduleKagamiRelateEntity> {

    private static final int KEY = 2;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedulekagami."
            + "IKaigoNinteiShinsakaiScheduleKagamiMapper.get出力明細一覧");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE514002.getReportId();
    private NinshoshaSource compNinshosha;
    private Map<Integer, RString> 通知文Map;
    private IKaigoNinteiShinsakaiScheduleKagamiMapper kagamiMapper;
    private KaigoNinteiShinsakaiScheduleKagamiProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ShinsaschedulekagamiReportSource> batchWriter;
    private ReportSourceWriter<ShinsaschedulekagamiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        kagamiMapper = getMapper(IKaigoNinteiShinsakaiScheduleKagamiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toKaigoNinteiShinsakaiScheduleMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void beforeExecute() {
        compNinshosha = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_ID, FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_ID, KamokuCode.EMPTY, 1);
    }

    @Override
    protected void process(KaigoNinteiShinsakaiScheduleKagamiRelateEntity entity) {
        ShinsaschedulekagamiReport report = new ShinsaschedulekagamiReport(setItem(entity));
        report.writeBy(reportSourceWriter);
    }

    private ShinsaschedulekagamiItem setItem(KaigoNinteiShinsakaiScheduleKagamiRelateEntity entity) {
        RString 宛名機関名 = RString.EMPTY;
        if (!RString.isNullOrEmpty(entity.getShujiiIryokikanCode())) {
            宛名機関名 = kagamiMapper.get医療機関名称(entity.getShujiiIryokikanCode());
        } else if (!RString.isNullOrEmpty(entity.getNinteichosaItakusakiCode())) {
            宛名機関名 = kagamiMapper.get事業者名称(entity.getNinteichosaItakusakiCode());
        } else if (!RString.isNullOrEmpty(entity.getSonotaKikanCode())) {
            宛名機関名 = kagamiMapper.get機関名称(entity.getSonotaKikanCode());
        }
        CustomerBarCode barcode = new CustomerBarCode();
        RString customerBarCode = barcode.convertCustomerBarCode(entity.getYubinNo(), entity.getJushoText()).getCustomerBarCode();
        return new ShinsaschedulekagamiItem(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会スケジュール表鑑,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援),
                processParamter.getShinsakaiKaisaiKikanFrom(), processParamter.getShinsakaiKaisaiKikanTo(), compNinshosha.denshiKoin,
                compNinshosha.hakkoYMD, compNinshosha.koinMojiretsu, compNinshosha.koinShoryaku, compNinshosha.ninshoshaShimeiKakeru,
                compNinshosha.ninshoshaShimeiKakenai, compNinshosha.ninshoshaYakushokuMei, compNinshosha.ninshoshaYakushokuMei1,
                compNinshosha.ninshoshaYakushokuMei2, customerBarCode, new YubinNo(entity.getYubinNo()).getEditedYubinNo(),
                entity.getJushoText(), 宛名機関名, entity.getShimeiText(),
                ChohyoAtesakiKeisho.toValue(DbBusinessConfig.get(
                                ConfigNameDBE.介護認定審査会スケジュール表鏡_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援)).get名称(),
                通知文Map.get(1), 通知文Map.get(KEY));
    }

    @Override
    protected void afterExecute() {
        RString 帳票ID = REPORT_ID.value();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 帳票名 = ReportIdDBE.DBE514001.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("-");
        List<RString> 出力条件 = create出力条件();
        OutputJokenhyoFactory.createInstance(
                new ReportOutputJokenhyoItem(帳票ID, 導入団体コード, 市町村名, ジョブ番号, 帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件))
                .print();
    }

    private List<RString> create出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append("【介護認定審査会開催予定期間】");
        builder.append(ConvertDate(processParamter.getShinsakaiKaisaiKikanFrom()))
                .append(" ～ ").append(ConvertDate(processParamter.getShinsakaiKaisaiKikanTo()));
        出力条件.add(builder.toRString());
        return 出力条件;
    }

    private RString ConvertYear(RString year) {
        if (RString.isNullOrEmpty(year)) {
            return RString.EMPTY;
        }
        if (!FlexibleYear.canConvert(year)) {
            return year;
        }
        return new FlexibleYear(year).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.NONE).toDateString();
    }

    private RString ConvertDate(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        if (!FlexibleDate.canConvert(date)) {
            return date;
        }
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.NONE).toDateString();
    }
}
