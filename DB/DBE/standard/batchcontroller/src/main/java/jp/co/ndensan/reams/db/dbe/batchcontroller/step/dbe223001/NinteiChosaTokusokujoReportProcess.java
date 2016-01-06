/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokujoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.DbeMapperInterfaces;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.NinteiChosaTokusokujoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001.NinteiChosaTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査督促状の作成クラスです。
 */
public class NinteiChosaTokusokujoReportProcess extends BatchProcessBase<NinteiChosaTokusokujoRelateEntity> {
    
   /**
     * OutputParameter用キー outShinseishoKanriNoList
     */
    public static final RString OUT_SHINSEISHO_KANRINO_LIST;
    private NinteiChosaTokusokujoProcessParameter paramter;
    private static final ReportId REPORT_DBE223001 = new ReportId("DBE223001_NinteiChosaTokusokujo");
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter;
    
    private NinteiChosaTokusokujoBodyItem bodyItem;
    
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
        return new BatchDbReader(DbeMapperInterfaces.要介護認定調査督促状データの抽出.getFullPath(), paramter.toNinteiChosaTokusokujoMybatisParameter());
    }
    
    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223001.value(), SubGyomuCode.DBE認定支援).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }
 
    @Override
    protected void process(NinteiChosaTokusokujoRelateEntity entity) {
        shinseishoKanriNoList.add(entity.getTemp_申請書管理番号().getColumnValue());
        bodyItem = setBodyItem(entity);
    }

    @Override
    protected void afterProcess() {
        NinteiChosaTokusokujoReport report = NinteiChosaTokusokujoReport.createFrom(bodyItem);
        report.writeBy(reportSourceWriter);
    }
    
    @Override
    protected void afterExecute() {
        outShinseishoKanriNoList.setValue(shinseishoKanriNoList);
    }
    
    private NinteiChosaTokusokujoBodyItem setBodyItem(NinteiChosaTokusokujoRelateEntity entity) {
        
        // 性別の設定
        RString tempP_性別男 = RString.EMPTY;
        RString tempP_性別女 = RString.EMPTY;
        RString seibetsuVal = entity.getTemp_性別コード().getColumnValue();
        if (Seibetsu.男.getコード().toString().equals(seibetsuVal.toString())) {
            tempP_性別女 = 星アイコン;
        } else {
            tempP_性別男 = 星アイコン;
        }
        
        // 年号の設定
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
        
        RString tempP_通知文問合せ = RString.EMPTY;  // TODO 一時の利用 #72754
        RString temp_通知文 = RString.EMPTY;  // TODO 一時の利用 #72754
        int 保険者番号の桁 = 0;
        int 被保険者番号の桁 = 0;
        int 通知文問合せの行数 = 0;
        return new NinteiChosaTokusokujoBodyItem(
                new RString(""), // TODO QA CompNinshoshaの利用方法について(CompNinshosha．出力項目．証明発行年月日)
                new RString(""), // CompNinshosha．出力項目．電子公印
                new RString(""),  // TODO shichosonMei QA　rseファイルのレイアウトにこの項目が存在しない
                new RString(""),  // TODO CompNinshosha．出力項目．首長名
                new RString(""),  // TODO CompNinshosha．出力項目．公印省略
                new RString(""),  // TODO CompNinshosha．出力項目．文書番号
                getNowDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString(),
                getLenStr(temp_通知文, 四十五 * 0, 四十五), // TODO QA　TsuchishoTeikeibunManagerの利用方法について 「TsuchishoTeikeibunManager．出力項目．通知文」
                getLenStr(temp_通知文, 四十五 * 1, 四十五),
                entity.getTemp_申請区分コード() == null ? RString.EMPTY : entity.getTemp_申請区分コード().getColumnValue(),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
                getLenStr(entity.getTemp_保険者番号(), 一 * 保険者番号の桁++, 一),
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
                entity.getTemp_申請年月日() == null ? RString.EMPTY : entity.getTemp_申請年月日().seireki().toDateString(),
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue(),
                tempP_性別男,
                tempP_性別女,
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),
                tempP_誕生日明治,
                tempP_誕生日大正,
                tempP_誕生日昭和,
                entity.getTemp_生年月日() == null ? RString.EMPTY : entity.getTemp_生年月日().seireki().toDateString(),
                entity.getTemp_被保険者郵便番号() == null ? RString.EMPTY : entity.getTemp_被保険者郵便番号().getEditedYubinNo(),
                entity.getTemp_被保険者住所() == null ? RString.EMPTY : entity.getTemp_被保険者住所().getColumnValue(),
                getLenStr(tempP_通知文問合せ, 四十五 * 通知文問合せの行数++, 四十五), // TODO QA CompToiawasesakiの利用方法について　「CompToiawasesaki．出力項目．通知文   3」
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
                new RString("")); //TODO 連番 共通部品
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
