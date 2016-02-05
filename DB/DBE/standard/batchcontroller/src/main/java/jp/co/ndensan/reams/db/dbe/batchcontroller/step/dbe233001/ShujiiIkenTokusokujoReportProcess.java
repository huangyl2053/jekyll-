/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe233001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.ShujiiIkenTokusokujoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書督促状発行_バッチフ処理クラスです
 */
public class ShujiiIkenTokusokujoReportProcess extends BatchProcessBase<ShujiiIkenTokusokujoRelateEntity> {

    public static final RString OUT_SHINSEISHO_KANRINO_LIST;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001."
            + "IDbe233001RelateMapper.select主治医意見書督促状ByKey");
    private static final ReportId REPORT_DBE233001 = new ReportId("DBE233001_ShujiiIkenshoSakuseiTokusokujo");
    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> reportSourceWriter;
    private ShujiiIkenTokusokujoProcessParamter processPrm;
    private ShujiiIkenshoSakuseiTokusokujoItem bodyItem;

    private static final RString 星アイコン = new RString("＊");
    private static final RString 明 = new RString("明");
    private static final RString 大 = new RString("大");
    private static final RString 昭 = new RString("昭");
    private static final int 四十五 = 45;
    private static final int 一 = 45;

    static {
        OUT_SHINSEISHO_KANRINO_LIST = new RString("outShinseishoKanriNoList");
    }
    private OutputParameter<List<RString>> outShinseishoKanriNoList;
    private List<RString> shinseishoKanriNoList;

    @Override
    protected void initialize() {
        shinseishoKanriNoList = new ArrayList<>();
        outShinseishoKanriNoList = new OutputParameter<>();
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toShujiiIkenTokusokujoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE233001.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ShujiiIkenTokusokujoRelateEntity entity) {
        shinseishoKanriNoList.add(entity.getTemp_申請書管理番号().getColumnValue());
        bodyItem = setBodyItem(entity);
    }

    @Override
    protected void afterProcess() {
        ShujiiIkenshoSakuseiTokusokujoReport report = ShujiiIkenshoSakuseiTokusokujoReport.createFrom(bodyItem);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        outShinseishoKanriNoList.setValue(shinseishoKanriNoList);
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
        // TODO QA639 Redmine： (CompNinshoshaの利用方法(CompNinshoshaの出力項目))
        RString tempP_通知文問合せ = RString.EMPTY;
        RString temp_通知文 = RString.EMPTY;
        int 保険者番号の桁 = 0;
        int 被保険者番号の桁 = 0;
        int 通知文問合せの行数 = 0;
        return new ShujiiIkenshoSakuseiTokusokujoItem(
                new RString(""),
                new RString(""),
                RDate.getNowDate(),
                new RString(""),
                new RString(""),
                new RString(""),
                new RString(""),
                getLenStr(temp_通知文, 四十五 * 0, 四十五),
                getLenStr(temp_通知文, 四十五 * 1, 四十五),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_被保険者番号(), 一 * 被保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                entity.getTemp_申請区分コード() == null ? RString.EMPTY : entity.getTemp_申請区分コード().getColumnValue(),
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue(),
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),
                new RDate(entity.getTemp_申請年月日().toString()),
                entity.getTemp_被保険者郵便番号() == null ? RString.EMPTY : entity.getTemp_被保険者郵便番号().getEditedYubinNo(),
                entity.getTemp_被保険者住所() == null ? RString.EMPTY : entity.getTemp_被保険者住所().getColumnValue(),
                new RDate(entity.getTemp_生年月日().toString()),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五),
                new RString(""),
                tempP_性別男,
                tempP_性別女,
                tempP_誕生日明治,
                tempP_誕生日大正,
                tempP_誕生日昭和);
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
