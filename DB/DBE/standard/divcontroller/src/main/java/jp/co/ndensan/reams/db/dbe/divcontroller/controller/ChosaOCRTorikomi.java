/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.NinteichosaOCRTorikomiTargetData;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.NinteichosaOCRTorikomiTargetData.OCRSuccessKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;

/**
 * 調査票OCR取込み対象者一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ChosaOCRTorikomi {

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
     * btnCommonSaveOCRCOntentを押下した時の処理です。
     *
     * @param panel ChosaOcrTorikomiDiv
     * @return ResponseData
     */
    public ResponseData<ChosaOCRTorikomiDiv> onCLick_btnCommonSaveOCRContent(ChosaOCRTorikomiDiv panel) {
        panel.getDgChosahyoTorikomiKekka().setDataSource(Collections.EMPTY_LIST);
        panel.getTxtErrKensu().clearValue();
        ResponseData<ChosaOCRTorikomiDiv> response = createResponseData(panel);
        response.addMessage(new InformationMessage("I", "保存しました。"));
        return response;
    }

    /**
     * エラー件数を数えます。
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
