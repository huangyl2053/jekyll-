/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP33001_2_特別徴収仮算定結果一覧表Report
 *
 * @reamsid_L DBB-0700-030 xuhao
 */
public class TokubetsuChoshuKarisanteiKekkaIchiranReport extends Report<TokubetsuChoshuKarisanteiKekkaIchiranSource> {

    private final List<TokuchoKariKeisangoFukaEntity> 特徴仮算定計算後賦課情報EntityList;
    private final FlexibleYear 調定年度;
    private final YMDHMS 調定日時;
    private final List<RString> 並び順List;
    private final List<RString> 改頁List;
    private final List<RString> 住所編集リスト;
    private final List<Decimal> 前年度保険料リスト;

    /**
     *
     * @param 特徴仮算定計算後賦課情報EntityList List<TokuchoKariKeisangoFukaEntity>
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 並び順List List<RString>
     * @param 改頁List List<RString>
     * @param 住所編集リスト List<RString>
     * @param 前年度保険料リスト List<RString>
     */
    public TokubetsuChoshuKarisanteiKekkaIchiranReport(
            List<TokuchoKariKeisangoFukaEntity> 特徴仮算定計算後賦課情報EntityList,
            FlexibleYear 調定年度,
            YMDHMS 調定日時,
            List<RString> 並び順List,
            List<RString> 改頁List,
            List<RString> 住所編集リスト,
            List<Decimal> 前年度保険料リスト) {
        this.特徴仮算定計算後賦課情報EntityList = 特徴仮算定計算後賦課情報EntityList;
        this.調定年度 = 調定年度;
        this.調定日時 = 調定日時;
        this.並び順List = 並び順List;
        this.改頁List = 改頁List;
        this.住所編集リスト = 住所編集リスト;
        this.前年度保険料リスト = 前年度保険料リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKarisanteiKekkaIchiranSource> writer) {
        int index = 0;
        for (TokuchoKariKeisangoFukaEntity entity : 特徴仮算定計算後賦課情報EntityList) {
            RString 住所編集 = 住所編集リスト.get(index);
            Decimal 前年度保険料 = 前年度保険料リスト.get(index);
            index++;
            int 連番 = index;
            TokubetsuChoshuKarisanteiKekkaIchiranEditor editor = new TokubetsuChoshuKarisanteiKekkaIchiranEditor(
                    entity, 調定年度, 調定日時, 並び順List, 改頁List, 連番, 住所編集, 前年度保険料);
            TokubetsuChoshuKarisanteiKekkaIchiranBuilder builder
                    = new TokubetsuChoshuKarisanteiKekkaIchiranBuilder(editor);
            writer.writeLine(builder);
        }

    }

}
