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

    private final RString 市町村コード;
    private final RString 市町村名称;
    private final TokuchoKariKeisangoFukaEntity 特徴仮算定計算後賦課情報Entity;
    private final FlexibleYear 調定年度;
    private final YMDHMS 調定日時;
    private final List<RString> 並び順List;
    private final List<RString> 改頁List;
    private final RString 住所編集;
    private final Decimal 前年度保険料;
    private final int 連番;

    /**
     *
     * @param 市町村名称 RString
     * @param 市町村コード RString
     * @param 特徴仮算定計算後賦課情報Entity List<TokuchoKariKeisangoFukaEntity>
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 並び順List List<RString>
     * @param 改頁List List<RString>
     * @param 住所編集 RString
     * @param 前年度保険料 RString
     * @param 連番 int
     */
    public TokubetsuChoshuKarisanteiKekkaIchiranReport(
            RString 市町村名称,
            RString 市町村コード,
            TokuchoKariKeisangoFukaEntity 特徴仮算定計算後賦課情報Entity,
            FlexibleYear 調定年度,
            YMDHMS 調定日時,
            List<RString> 並び順List,
            List<RString> 改頁List,
            RString 住所編集,
            Decimal 前年度保険料,
            int 連番) {
        this.市町村名称 = 市町村名称;
        this.市町村コード = 市町村コード;
        this.特徴仮算定計算後賦課情報Entity = 特徴仮算定計算後賦課情報Entity;
        this.調定年度 = 調定年度;
        this.調定日時 = 調定日時;
        this.並び順List = 並び順List;
        this.改頁List = 改頁List;
        this.住所編集 = 住所編集;
        this.前年度保険料 = 前年度保険料;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKarisanteiKekkaIchiranSource> writer) {
        TokubetsuChoshuKarisanteiKekkaIchiranEditor editor = new TokubetsuChoshuKarisanteiKekkaIchiranEditor(
                市町村コード, 市町村名称, 特徴仮算定計算後賦課情報Entity, 調定年度, 調定日時, 並び順List, 改頁List, 連番, 住所編集, 前年度保険料);
        TokubetsuChoshuKarisanteiKekkaIchiranBuilder builder
                = new TokubetsuChoshuKarisanteiKekkaIchiranBuilder(editor);
        writer.writeLine(builder);

    }

}
