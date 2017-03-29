/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0120001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaitaishosha.ShinsakaiTaishoshaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaitaishosha.TaishoshaIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001.DBE0120001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001.ShinsakaiTaishoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0120001.ShinsakaiTaishoshaHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0120001.ShinsakaiTaishoshaValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitaisho.ShinsakaiTaishoshaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会個人別状況照会クラスです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
public class ShinsakaiTaishosha {

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiTaishoshaDiv>
     */
    public ResponseData<ShinsakaiTaishoshaDiv> onLoad(ShinsakaiTaishoshaDiv div) {
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        ShinsakaiTaishoshaHandler handler = getHandler(div);
        TaishoshaIchiranMapperParameter param = handler.createTaishoshaIchiranParam();
        List<ShinsakaiTaishoshaBusiness> 審査会対象者一覧 = ShinsakaiTaishoshaFinder.createInstance().get情報(param).records();
        ShinsakaiTaishoshaBusiness 予定情報 = ShinsakaiTaishoshaFinder.createInstance().get予定情報と結果情報(審査会開催番号);
        handler.onLoad(予定情報, 審査会対象者一覧);
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei(審査会対象者一覧);
        if (!ResponseHolder.isReRequest() && validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addMessage(DbeInformationMessages.対象者の割り当てがありません.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「要介護認定個人状況照会」画面へ遷移します。
     *
     * @param div ShinsakaiTaishoshaDiv
     * @return ResponseData
     */
    public ResponseData<ShinsakaiTaishoshaDiv> btn_Shokai(ShinsakaiTaishoshaDiv div) {
        dgTaishoshaIchiran_Row row = div.getDgTaishoshaIchiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, row.getShinseishoKanriNo());
        return ResponseData.of(div).forwardWithEventName(DBE0120001TransitionEventName.対象者選択).respond();
    }

    /**
     * 保険者の値が変更された際の動作です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShinsakaiTaishoshaDiv> onChange_ccdHokensha(ShinsakaiTaishoshaDiv div) {
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        ShinsakaiTaishoshaHandler handler = getHandler(div);
        TaishoshaIchiranMapperParameter param = handler.createTaishoshaIchiranParam();
        List<ShinsakaiTaishoshaBusiness> 審査会対象者一覧 = ShinsakaiTaishoshaFinder.createInstance().get情報(param).records();
        ShinsakaiTaishoshaBusiness 予定情報 = ShinsakaiTaishoshaFinder.createInstance().get予定情報と結果情報(審査会開催番号);
        handler.onLoad(予定情報, 審査会対象者一覧);
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei(審査会対象者一覧);
        if (!ResponseHolder.isReRequest() && validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addMessage(DbeInformationMessages.対象者の割り当てがありません.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShinsakaiTaishoshaValidationHandler getValidationHandler(ShinsakaiTaishoshaDiv div) {
        return new ShinsakaiTaishoshaValidationHandler(div);
    }

    private ShinsakaiTaishoshaHandler getHandler(ShinsakaiTaishoshaDiv div) {
        return new ShinsakaiTaishoshaHandler(div);
    }
}
