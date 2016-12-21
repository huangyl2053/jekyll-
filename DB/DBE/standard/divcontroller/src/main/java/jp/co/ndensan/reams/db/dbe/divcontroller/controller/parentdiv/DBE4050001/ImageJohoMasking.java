/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4050001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001.ImageJohoMaskingHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * イメージ情報マスキングのコントローラです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMasking {

    /**
     * コンストラクタです。
     *
     */
    public ImageJohoMasking() {
    }

    /**
     * イメージ情報マスキング初期化の設定します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onLoad(ImageJohoMaskingDiv div) {
        getHandler(div).初期表示();
        ShinseishoKanriNoList shinseishoKanriNoList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ShinseishoKanriNoList.class);
        if (shinseishoKanriNoList != null) {
            getHandler(div).set検索用パラメーター(shinseishoKanriNoList);
            List<ImageJohoMaskingResult> resultList = getHandler(div).get対象者();
            if (!ResponseHolder.isReRequest() && resultList.isEmpty()) {
                throw new ApplicationException(UrInformationMessages.該当データなし.getMessage());
            }
            getHandler(div).setDataGrid(resultList);
            return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面検索条件より、処理対象者データを取得する
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnTaishoKensaku(ImageJohoMaskingDiv div) {
        getHandler(div).set検索用パラメーター(null);
        List<ImageJohoMaskingResult> resultList = getHandler(div).get対象者();
        if (!ResponseHolder.isReRequest() && resultList.isEmpty()) {
            throw new ApplicationException(UrInformationMessages.該当データなし.getMessage());
        }
        getHandler(div).setDataGrid(resultList);
        return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
    }

    /**
     * 検索条件入力値をクリアする
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnClear(ImageJohoMaskingDiv div) {
        getHandler(div).clear();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンを押下の場合、イメージ情報パネルが表示する。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onSelectBySelectButton_dgImageMaskShoriTaishosha(ImageJohoMaskingDiv div) {
        getHandler(div).setMeisai();
        getHandler(div).ボタンsetDisabled();
        return ResponseData.of(div).setState(DBE4050001StateName.イメージ情報表示);
    }

    /**
     * 取消するボタンを選択する場合、今回編集したマスキングイメージを破棄します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnTorikeshi(ImageJohoMaskingDiv div) {
        getHandler(div).deleteEditedData();
        getHandler(div).ボタンsetDisabled();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下の場合、マスクデータを追加する。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnUpdate(ImageJohoMaskingDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).更新処理();
            return ResponseData.of(div).setState(DBE4050001StateName.完了表示);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * マスキングするボタンを押下すると、原本に対してマスキング処理を行います
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onBefore_onClickbtnMaskingGenpon(ImageJohoMaskingDiv div) {
        div.setHiddenImagePath(div.getDgImageMaskingTaisho().getActiveRow().getImagePath());
        return ResponseData.of(div).respond();
    }

    /**
     * マスキング編集ボタンを押下すると、マスキングデータに対してマスキング処理を行います
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onBefore_onClickbtnMaskingMask(ImageJohoMaskingDiv div) {
        if (div.getDgImageMaskingTaisho().getActiveRow().getEditImagePath().isEmpty()) {
            div.setHiddenImagePath(div.getDgImageMaskingTaisho().getActiveRow().getMaskImagePath());
        } else {
            div.setHiddenImagePath(div.getDgImageMaskingTaisho().getActiveRow().getEditImagePath());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * イメージマスキングダイアログでデータが保存された時の処理です
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onOkClose(ImageJohoMaskingDiv div) {
        RString newImagePath = div.getHiddenImagePath();
        getHandler(div).row更新(newImagePath);
        getHandler(div).ボタンsetDisabled();
        return ResponseData.of(div).respond();
    }

    /**
     * データグリッド上で編集したいイメージを選択した時の処理です
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onSelect_dgImageMaskingTaisho(ImageJohoMaskingDiv div) {
        getHandler(div).ボタン制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存後の完了画面から続けて処理を行う際のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnContinue(ImageJohoMaskingDiv div) {
        getHandler(div).get対象者();
        return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
    }

    /**
     * 保存後の完了画面で完了を選んだ際のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnComplete(ImageJohoMaskingDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE4050001TransitionEventName.完了処理に戻る).respond();
    }

    private ImageJohoMaskingHandler getHandler(ImageJohoMaskingDiv div) {
        return new ImageJohoMaskingHandler(div);
    }

}
