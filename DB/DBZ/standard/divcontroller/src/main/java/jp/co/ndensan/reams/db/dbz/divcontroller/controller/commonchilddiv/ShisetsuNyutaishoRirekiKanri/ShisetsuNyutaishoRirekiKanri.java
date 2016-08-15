/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShisetsuNyutaishoRirekiKanri;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 施設入退所履歴のクラス。
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public class ShisetsuNyutaishoRirekiKanri {

    /**
     * 画面初期化を表示する。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onLoad(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        if (!RString.isNullOrEmpty(requestDiv.getSyokikaMode())) {
            requestDiv.set表示モード(requestDiv.getSyokikaMode());
            getHandler(requestDiv).initialize(new ShikibetsuCode(requestDiv.getShikibetsuCode()));
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「追加する」ボタンを押下する場合、施設入退所情報パネルを活性します。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onClick_btnAddShisetsuNyutaisho(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        getHandler(requestDiv).onClick_btnAddShisetsuNyutaisho();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「選択」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectBySelectButton_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        getHandler(requestDiv).onSelectBySelectButton_dgShisetsuNyutaishoRireki(requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow());
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「修正」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectByModifyButton_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        getHandler(requestDiv).onSelectByModifyButton_dgShisetsuNyutaishoRireki(requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow());
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「削除」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectByDeleteButton_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        getHandler(requestDiv).onSelectByDeleteButton_dgShisetsuNyutaishoRireki(requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow());
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「取消する」ボタンを押下する場合、明細エリアの全項目がクリアされる。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onClick_btnShisetsuNyutaishoTorikeshi(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        getHandler(requestDiv).onClick_btnShisetsuNyutaishoTorikeshi();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「確定する」ボタンを押下する場合、明細エリアの入力内容を一覧グリッドに反映させる。。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onClick_btnShisetsuNyutaishoKakutei(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).validateForUpdate();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        } else {
            dgShisetsuNyutaishoRireki_Row row = requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow();
            getHandler(requestDiv).onClick_btnShisetsuNyutaishoKakutei(row);
        }
        return ResponseData.of(requestDiv).respond();
    }

    private ShisetsuNyutaishoRirekiKanriHandler getHandler(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        return new ShisetsuNyutaishoRirekiKanriHandler(requestDiv);
    }

    private ShisetsuNyutaishoRirekiKanriValidationHandler getValidationHandler(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        return new ShisetsuNyutaishoRirekiKanriValidationHandler(requestDiv);
    }
}
