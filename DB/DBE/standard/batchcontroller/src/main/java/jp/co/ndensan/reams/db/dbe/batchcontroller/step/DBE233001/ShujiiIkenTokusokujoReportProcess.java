/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE233001;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoOutputJokenhyoEditor;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiIkenTokusokujoHakkoReportProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001.IDbe233001RelateMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;

/**
 * 主治医意見書督促状発行_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
public class ShujiiIkenTokusokujoReportProcess extends BatchProcessBase<ShujiiIkenTokusokujoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001."
            + "IDbe233001RelateMapper.select主治医意見書督促状ByKey");
    private static final ReportId REPORT_DBE233001 = ReportIdDBE.DBE233001.getReportId();
    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5301ShujiiIkenshoIraiJohoEntity> dbT5301Writer;

    private ShujiiIkenTokusokujoHakkoReportProcessParameter processPrm;
    ShujiiIkenshoSakuseiTokusokujoItem bodyItem;

    private static final RString 星アイコン = new RString("＊");
    private static final RString 明 = new RString("明");
    private static final RString 大 = new RString("大");
    private static final RString 昭 = new RString("昭");
    private final int パターン番号_1 = 1;
    private static final int 一桁 = 1;
    IDbe233001RelateMapper mapper;

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IDbe233001RelateMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toShujiiIkenTokusokujoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE233001.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
        dbT5301Writer = new BatchPermanentTableWriter<>(DbT5301ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    protected void process(ShujiiIkenTokusokujoRelateEntity entity) {
        bodyItem = setBodyItem(entity);
        ShujiiIkenshoSakuseiTokusokujoReport report = new ShujiiIkenshoSakuseiTokusokujoReport(bodyItem);
        report.writeBy(reportSourceWriter);

        DbT5301ShujiiIkenshoIraiJohoEntity dbT5301Entity = entity.get主治医意見書依頼情報();
        dbT5301Entity.setIkenshoSakuseiTokusokuYMD(processPrm.getTemp_督促日());
        dbT5301Entity.setIkenshoSakuseiTokusokuHoho(new RString(processPrm.getTemp_督促方法()));
        dbT5301Entity.setIkenshoTokusokuKaisu(dbT5301Entity.getIkenshoTokusokuKaisu() + 1);
        dbT5301Entity.setIkenshoTokusokuMemo(processPrm.getTemp_督促メモ());
        dbT5301Writer.update(dbT5301Entity);
    }

    @Override
    protected void afterExecute() {
        ShujiiIkenshoSakuseiTokusokujoOutputJokenhyoEditor outputJokenhyoEditor
                = new ShujiiIkenshoSakuseiTokusokujoOutputJokenhyoEditor(processPrm);
        List<RString> 条件リスト = outputJokenhyoEditor.edit();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ = new ReportOutputJokenhyoItem(
                REPORT_DBE233001.value(),
                association.get地方公共団体コード().value(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ReportInfo.getReportName(SubGyomuCode.DBE認定支援, REPORT_DBE233001.value()),
                new RString(batchWrite.getPageCount()),
                new RString("なし"),
                RString.EMPTY,
                条件リスト);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private ShujiiIkenshoSakuseiTokusokujoItem setBodyItem(ShujiiIkenTokusokujoRelateEntity entity) {

        RString tempP_性別男 = RString.EMPTY;
        RString tempP_性別女 = RString.EMPTY;
        RString seibetsuVal = entity.getTemp_性別コード().getColumnValue();
        if (Seibetsu.男.getコード().toString().equals(seibetsuVal.toString())) {
            tempP_性別女 = 星アイコン;
        } else {
            tempP_性別男 = 星アイコン;
        }
        RString tempP_誕生日明治 = RString.EMPTY;
        RString tempP_誕生日大正 = RString.EMPTY;
        RString tempP_誕生日昭和 = RString.EMPTY;
        RString year = entity.getTemp_生年月日().getYear().wareki().getYear();
        if (year.startsWith(明)) {
            tempP_誕生日大正 = 星アイコン;
            tempP_誕生日昭和 = 星アイコン;
        } else if (year.startsWith(大)) {
            tempP_誕生日明治 = 星アイコン;
            tempP_誕生日昭和 = 星アイコン;
        } else if (year.startsWith(昭)) {
            tempP_誕生日明治 = 星アイコン;
            tempP_誕生日大正 = 星アイコン;
        }
        NinshoshaSource source = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_DBE233001, processPrm.getTemp_基準日(),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_DBE233001, KamokuCode.EMPTY, パターン番号_1);

        YubinNo yubinNo = entity.getTemp_事業者郵便番号();
        RString 宛名郵便番号 = RString.EMPTY;
        if (yubinNo != null) {
            宛名郵便番号 = yubinNo.getColumnValue();
        }
        RString 宛名住所 = entity.getTemp_事業者住所() == null ? RString.EMPTY : entity.getTemp_事業者住所();
        CustomerBarCode barcode = new CustomerBarCode();
        RString 宛名名称付与 = RString.EMPTY;
        if (!RString.isNullOrEmpty(宛名郵便番号) && !RString.isNullOrEmpty(宛名住所)) {
            CustomerBarCodeResult result = barcode.convertCustomerBarCode(宛名郵便番号, 宛名住所);
            宛名名称付与 = result.getCustomerBarCode();
        }
        int 保険者番号の桁 = 0;
        int 被保険者番号の桁 = 0;
        return new ShujiiIkenshoSakuseiTokusokujoItem(
                ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, REPORT_DBE233001, processPrm.getTemp_基準日()),
                source.denshiKoin,
                source.hakkoYMD,
                source.koinMojiretsu,
                source.koinShoryaku,
                source.ninshoshaShimeiKakeru,
                source.ninshoshaYakushokuMei,
                source.ninshoshaShimeiKakenai,
                source.ninshoshaYakushokuMei1,
                source.ninshoshaYakushokuMei2,
                new RString("1"),
                宛名名称付与,
                宛名郵便番号,
                宛名住所,
                entity.getTemp_診療科名称() == null ? RString.EMPTY : entity.getTemp_診療科名称(),
                entity.getTemp_主治医氏名() == null ? RString.EMPTY : entity.getTemp_主治医氏名(),
                ChohyoAtesakiKeisho.toValue(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称,
                                RDate.getNowDate(), SubGyomuCode.DBE認定支援)).get名称(),
                RString.EMPTY,
                通知文.get(1),
                通知文.get(2),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                entity.getTemp_申請区分コード() == null
                ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(entity.getTemp_申請区分コード().getColumnValue()).get名称(),
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue(),
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),
                entity.getTemp_申請年月日() == null ? null : new RDate(entity.getTemp_申請年月日().toString()),
                entity.getTemp_被保険者郵便番号() == null ? RString.EMPTY : entity.getTemp_被保険者郵便番号().getEditedYubinNo(),
                entity.getTemp_被保険者住所() == null ? RString.EMPTY : entity.getTemp_被保険者住所().getColumnValue(),
                entity.getTemp_生年月日() == null ? null : new RDate(entity.getTemp_生年月日().toString()),
                new RString("1"),
                tempP_性別男,
                tempP_性別女,
                tempP_誕生日明治,
                tempP_誕生日大正,
                tempP_誕生日昭和,
                entity.getTemp_処理名());
    }

    private RString getLenStr(RString rstr, int startIndex, int len) {

        if (!RString.isNullOrEmpty(rstr)) {
            if (rstr.length() >= startIndex + len) {
                return rstr.substring(startIndex, startIndex + len);
            } else if (rstr.length() > startIndex) {
                return rstr.substring(startIndex);
            }
        }
        return RString.EMPTY;
    }
}
