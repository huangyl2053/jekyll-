/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.ArrayList;
import java.util.List;
import jp.co.hos.common.util.StringUtil;
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
 * 
 * 要介護認定調査督促状の作成クラスです。
 */
public class NinteiChosaTokusokujoReportProcess extends BatchProcessBase<NinteiChosaTokusokujoRelateEntity> {
    
    public static final RString OUT_SHINSEiSHO_KANRINO_LIST;
    private NinteiChosaTokusokujoProcessParameter paramter;
    private static final ReportId REPORT_DBE223001 = new ReportId("DBE223001_NinteiChosaTokusokujo");
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter;
    
    private static final RString 星アイコン = new RString("＊");
    private static final RString 明 = new RString("明");
    private static final RString 大 = new RString("大");
    private static final RString 昭 = new RString("昭");
    
    NinteiChosaTokusokujoBodyItem bodyItem;
    
    static {
        OUT_SHINSEiSHO_KANRINO_LIST = new RString("outShinseishoKanriNoList");
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
        RString TempP_性別男 = RString.EMPTY;
        RString TempP_性別女 = RString.EMPTY;
        RString seibetsuVal = entity.getTemp_性別コード().getColumnValue();
        if (Seibetsu.男.toString().equals(seibetsuVal.toString())) {
            TempP_性別女 = 星アイコン;
        } else {
            TempP_性別男 = 星アイコン;
        }
        
        // 年号の設定
        RString TempP_誕生日明治 = RString.EMPTY;
        RString TempP_誕生日大正 = RString.EMPTY;
        RString TempP_誕生日昭和 = RString.EMPTY;
        RString year = entity.getTemp_生年月日().getYear().wareki().getYear();
        if (year.startsWith(明)) {
            TempP_誕生日大正 = 星アイコン;
            TempP_誕生日昭和 = 星アイコン;
        } else if (year.startsWith(大)) {
            TempP_誕生日明治 = 星アイコン;
            TempP_誕生日昭和 = 星アイコン;
        } else if (year.startsWith(昭)) {
            TempP_誕生日明治 = 星アイコン;
            TempP_誕生日大正 = 星アイコン;
        }
        
        RString TempP_通知文問合せ = RString.EMPTY;  // TODO 一時の利用 #72754
        RString Temp_通知文 = RString.EMPTY;;  // TODO 一時の利用 #72754
        return new NinteiChosaTokusokujoBodyItem(
                new RString(""), // TODO QA CompNinshoshaの利用方法について(CompNinshosha．出力項目．証明発行年月日)
                new RString(""), // CompNinshosha．出力項目．電子公印
                new RString(""),  // TODO shichosonMei QA　rseファイルのレイアウトにこの項目が存在しない
                new RString(""),  // TODO CompNinshosha．出力項目．首長名
                new RString(""),  // TODO CompNinshosha．出力項目．公印省略
                new RString(""),  // TODO CompNinshosha．出力項目．文書番号
                getNowDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString(),
                getLenStr(Temp_通知文, 0, 45), // TODO QA　TsuchishoTeikeibunManagerの利用方法について 「TsuchishoTeikeibunManager．出力項目．通知文」
                getLenStr(Temp_通知文, 45, 45),
                entity.getTemp_申請区分コード() == null ? RString.EMPTY : entity.getTemp_申請区分コード().getColumnValue(),
                getLenStr(entity.getTemp_保険者番号(), 0, 1),
                getLenStr(entity.getTemp_保険者番号(), 1, 1),
                getLenStr(entity.getTemp_保険者番号(), 2, 1),
                getLenStr(entity.getTemp_保険者番号(), 3, 1),
                getLenStr(entity.getTemp_保険者番号(), 4, 1),
                getLenStr(entity.getTemp_保険者番号(), 5, 1),
                getLenStr(entity.getTemp_被保険者番号(), 0, 1),
                getLenStr(entity.getTemp_被保険者番号(), 1, 1),
                getLenStr(entity.getTemp_被保険者番号(), 2, 1),
                getLenStr(entity.getTemp_被保険者番号(), 3, 1),
                getLenStr(entity.getTemp_被保険者番号(), 4, 1),
                getLenStr(entity.getTemp_被保険者番号(), 5, 1),
                getLenStr(entity.getTemp_被保険者番号(), 6, 1),
                getLenStr(entity.getTemp_被保険者番号(), 7, 1),
                getLenStr(entity.getTemp_被保険者番号(), 8, 1),
                getLenStr(entity.getTemp_被保険者番号(), 9, 1),
                entity.getTemp_申請年月日() == null ? RString.EMPTY : entity.getTemp_申請年月日().seireki().toDateString(),
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue(),
                TempP_性別男,
                TempP_性別女,
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),
                TempP_誕生日明治,
                TempP_誕生日大正,
                TempP_誕生日昭和,
                entity.getTemp_生年月日() == null ? RString.EMPTY : entity.getTemp_生年月日().seireki().toDateString(),
                entity.getTemp_被保険者郵便番号() == null ? RString.EMPTY : entity.getTemp_被保険者郵便番号().getEditedYubinNo(),
                entity.getTemp_被保険者住所() == null ? RString.EMPTY : entity.getTemp_被保険者住所().getColumnValue(),
                getLenStr(TempP_通知文問合せ, 0, 45), // TODO QA CompToiawasesakiの利用方法について　「CompToiawasesaki．出力項目．通知文   3」
                getLenStr(TempP_通知文問合せ, 45, 45),
                getLenStr(TempP_通知文問合せ, 90, 45),
                getLenStr(TempP_通知文問合せ, 135, 45),
                getLenStr(TempP_通知文問合せ, 180, 45),
                getLenStr(TempP_通知文問合せ, 225, 45),
                getLenStr(TempP_通知文問合せ, 270, 45),
                getLenStr(TempP_通知文問合せ, 315, 45),
                getLenStr(TempP_通知文問合せ, 360, 45),
                getLenStr(TempP_通知文問合せ, 405, 45),
                getLenStr(TempP_通知文問合せ, 450, 45),
                getLenStr(TempP_通知文問合せ, 495, 45),
                getLenStr(TempP_通知文問合せ, 540, 45),
                getLenStr(TempP_通知文問合せ, 585, 45),
                getLenStr(TempP_通知文問合せ, 630, 45),
                getLenStr(TempP_通知文問合せ, 675, 45),
                getLenStr(TempP_通知文問合せ, 720, 45),
                new RString("")); //TODO 連番 共通部品
    }

    /**
     * 文字列の一部を取得します。
     * @param str 文字列
     * @param startIndex 開始インデックス 
     * @param len 長さ
     * 
     * @return 結果文字列
     */
    private RString getLenStr(RString rstr, int startIndex, int len) {
        String str = "";
        if (rstr != null) {
            str = rstr.toString();
        }
        if (!StringUtil.isNullOrEmpty(str)) {
            if (str.length() >= startIndex + len) {
                return new RString(str.substring(startIndex, startIndex + len));
            } else if (str.length() > startIndex) {
                return new RString(str.substring(startIndex));
            }
        }
        return RString.EMPTY;
    }
}
