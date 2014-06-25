/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.NinteichosaOCRTorikomiTargetData;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.NinteichosaOCRTorikomiTargetData.OCRSuccessKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

    public ResponseData<ChosaOCRTorikomiDiv> onClick_btnSave(ChosaOCRTorikomiDiv panel) {
        panel.getTxtErrKensu().setValue(countErrKensu());

        List<dgChosahyoTorikomiKekka_Row> arrayData = new ArrayList<>();
        panel.getDgChosahyoTorikomiKekka().setDataSource(arrayData);
        return createResponseData(panel);
    }

    /**
     * エラー件数を数えます。(デモデータをとってきます。)
     *
     * @return エラー件数
     */
    private Decimal countErrKensu() {
        List<dgChosahyoTorikomiKekka_Row> list = createRowTorikomiKekkaData();
        int count_err = 0;
        for (dgChosahyoTorikomiKekka_Row row : list) {
            if (OCRSuccessKubun.NG.toRString().equals(row.getOkOrNg())) {
                count_err++;
            }
        }
        return new Decimal(count_err);
    }

    /**
     * 調査票取込み結果一覧情報を取得します。(デモデータをとってきます。)
     *
     * @return 調査票取込み結果一覧情報
     */
    private List<dgChosahyoTorikomiKekka_Row> createRowTorikomiKekkaData() {
        return new NinteichosaOCRTorikomiTargetData().getAll().asConvertedType();
    }

    private ResponseData<ChosaOCRTorikomiDiv> createResponseData(ChosaOCRTorikomiDiv panel) {
        ResponseData<ChosaOCRTorikomiDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }
}
