/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.SeikatsuhogoDetail;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seikatsuhogorireki.SeikaatsuhogoDataModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail.SeikatsuhogoDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail.SeikatsuhogoDetailHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail.SeikatsuhogoDetailValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 生活保護明細のコントローラです。
 *
 * @reamsid_L DBZ-4510-010 xuyannan
 */
public class SeikatsuhogoDetail {

    private static final RString 表示モード_新規 = new RString("新規");
    private static final RString 表示モード_修正 = new RString("修正");
    private static final RString 表示モード_削除 = new RString("削除");
    private static final RString 表示モード_照会 = new RString("照会");

    /**
     * 生活保護明細の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onLoad(SeikatsuhogoDetailDiv div) {
        SeikaatsuhogoDataModel 生活保護受給Object = DataPassingConverter.deserialize(div.getHdnDataPass(), SeikaatsuhogoDataModel.class);
        getHandler(div).onLoad(生活保護受給Object);
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加する」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_AddRow(SeikatsuhogoDetailDiv div) {
        getHandler(div).データ編集(表示モード_新規);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択アイコン」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_Select(SeikatsuhogoDetailDiv div) {
        getHandler(div).データ編集(表示モード_照会);
        return ResponseData.of(div).respond();
    }

    /**
     * 「行の修正」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_Modify(SeikatsuhogoDetailDiv div) {
        getHandler(div).データ編集(表示モード_修正);
        return ResponseData.of(div).respond();
    }

    /**
     * 「行の削除」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_Delete(SeikatsuhogoDetailDiv div) {
        getHandler(div).データ編集(表示モード_削除);
        return ResponseData.of(div).respond();
    }

    /**
     * 「明細を取消する」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_DetailAirCancel(SeikatsuhogoDetailDiv div) {
        getHandler(div).onbtn_DetailAirCancel();
        return ResponseData.of(div).respond();
    }

    /**
     * 「明細を確定する」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_DetailAirOK(SeikatsuhogoDetailDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForDetailKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onbtn_DetailAirOK();
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 「（生活保護停止期間明細エリア）取消する」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_Cancel(SeikatsuhogoDetailDiv div) {
        getHandler(div).onbtn_Cancel();
        return ResponseData.of(div).respond();
    }

    /**
     * 「（生活保護停止期間明細エリア）確定する」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuhogoDetailDiv>
     */
    public ResponseData<SeikatsuhogoDetailDiv> onbtn_OK(SeikatsuhogoDetailDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onbtn_OK(div.getHdnHyoujiMode());
        return ResponseData.of(div).respond();
    }

    private SeikatsuhogoDetailHandler getHandler(SeikatsuhogoDetailDiv div) {
        return new SeikatsuhogoDetailHandler(div);
    }

    private SeikatsuhogoDetailValidationHandler getValidationHandler(SeikatsuhogoDetailDiv div) {
        return new SeikatsuhogoDetailValidationHandler(div);
    }
}
