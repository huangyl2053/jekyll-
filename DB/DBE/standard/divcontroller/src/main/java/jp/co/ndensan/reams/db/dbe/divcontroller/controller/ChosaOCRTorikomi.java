/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 調査票OCR取込み対象者一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ChosaOCRTorikomi {

    /**
     * demoデータのfileNameです。
     */
    private static final RString DEMO_DATA_FILE_NAME = new RString("dbe2060005/NinteichosaOcrTorikomiIchiran.yml");

    /**
     * OCR取込みボタン押下時の処理を表します。
     *
     * @param panel ChosaOcrTorikomiDiv
     * @return ResponseData
     */
    public ResponseData<ChosaOCRTorikomiDiv> fetchOCR(ChosaOCRTorikomiDiv panel) {
        panel.getTxtErrKensu().setValue(countErrKensu());
        panel.getDgChosahyoTorikomiKekka().setDataSource(createRowTorikomiKekkaData());
        return createResponseData(panel);
    }

    /**
     * エラー件数を数えます。(デモデータをとってきます。)
     *
     * @return エラー件数
     */
    private Decimal countErrKensu() {
        List<HashMap> torikomiKekkaData = YamlLoader.DBE.loadAsList(DEMO_DATA_FILE_NAME);
        ControlGenerator cg = new ControlGenerator(torikomiKekkaData.get(0));
        return cg.getAsDecimal("errkensu");
    }

    /**
     * 調査票取込み結果一覧情報を取得します。(デモデータをとってきます。)
     *
     * @return 調査票取込み結果一覧情報
     */
    private List<dgChosahyoTorikomiKekka_Row> createRowTorikomiKekkaData() {
        //<editor-fold defaultstate="collapsed" desc="return 調査票取込み結果一覧情報;">
        List<HashMap> torikomiKekkaData = YamlLoader.DBE.loadAsList(DEMO_DATA_FILE_NAME);
        List<dgChosahyoTorikomiKekka_Row> demoData
                = YamlUtil.convertList(torikomiKekkaData, new YamlUtil.Converter.IConverter<dgChosahyoTorikomiKekka_Row>() {
                    @Override
                    public dgChosahyoTorikomiKekka_Row exec(Map map) {
                        return toDgChosahyoTorikomiKekka_Row(map);
                    }

                    private dgChosahyoTorikomiKekka_Row toDgChosahyoTorikomiKekka_Row(Map map) {
                        ControlGenerator cg = new ControlGenerator(map);
                        return new dgChosahyoTorikomiKekka_Row(
                                new Button(),
                                cg.getAsRString("bango"),
                                cg.getAsRString("okng"),
                                cg.getAsRString("hokensha"),
                                cg.getAsRString("hihokenNo"),
                                cg.getAsTextBoxFlexibleDate("shinseibi"),
                                cg.getAsRString("shinseiKbn"),
                                cg.getAsTextBoxFlexibleDate("chosaJissibi"),
                                cg.getAsTextBoxFlexibleDate("chosahyoJuryobi"));
                    }
                });
        demoData.remove(0);
        return demoData;
        //</editor-fold>
    }

    private ResponseData<ChosaOCRTorikomiDiv> createResponseData(ChosaOCRTorikomiDiv panel) {
        ResponseData<ChosaOCRTorikomiDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }
}
