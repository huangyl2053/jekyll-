    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShisetsuNyutaishoRirekiKanri;

import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
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
        ValidationMessageControlPairs validPairs = getHandler(requestDiv).onClick_btnAddShisetsuNyutaisho();
        if (validPairs.existsError()) {
            return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
        } else {
            return ResponseData.of(requestDiv).respond();
        }
    }

    /**
     * 「選択」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectBySelectButton_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        dgShisetsuNyutaishoRireki_Row row = requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow();
        getHandler(requestDiv).onSelectBySelectButton_dgShisetsuNyutaishoRireki(row);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「修正」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectByModifyButton_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        dgShisetsuNyutaishoRireki_Row row = requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow();
        getHandler(requestDiv).onSelectByModifyButton_dgShisetsuNyutaishoRireki(row);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「削除」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param requestDiv 施設入退所履歴Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectByDeleteButton_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        dgShisetsuNyutaishoRireki_Row row = requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow();
        getHandler(requestDiv).onSelectByDeleteButton_dgShisetsuNyutaishoRireki(row);
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
//TODO n3327 オフショアで追加された保険者番号のチェックが無い。追加要否の判断が必要。
//        RString 住所地特例フラグ = KaigoHohenShisetsuNyutaishoshaKanriManager.
//                createInstance().get被保険者台帳管理の直近データ(new ShikibetsuCode(requestDiv.getShikibetsuCode()));
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).validateForUpdate(/*住所地特例フラグ*/);
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        } else {
            dgShisetsuNyutaishoRireki_Row row = requestDiv.getDgShisetsuNyutaishoRireki().getActiveRow();
            getHandler(requestDiv).onClick_btnShisetsuNyutaishoKakutei(row);
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 保険者入力ダイアログ画面開く前に処理します。
     *
     * @param div {@link ShisetsuNyutaishoRirekiKanriDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onBeforeOpenDialog_btnSearch(ShisetsuNyutaishoRirekiKanriDiv div) {
        div.setTxtHokensha(div.getTxtHokensha());
        div.setTxtHokensyaMeisho(div.getTxtHokensyaMeisho());
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者入力ダイアログ画面閉じる前に処理します。
     *
     * @param div {@link ShisetsuNyutaishoRirekiKanriDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onOkClose_btnSearch(ShisetsuNyutaishoRirekiKanriDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者コードを入れる、保険者名を自動表示します。
     *
     * @param div {@link ShisetsuNyutaishoRirekiKanriDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> lostfocus_txtHokenshaNo(ShisetsuNyutaishoRirekiKanriDiv div) {
        if (div.getTxtHokensha().getValue().isEmpty()) {
            div.getTxtHokensyaMeisho().setValue(RString.EMPTY);
            return ResponseData.of(div).respond();
        }
        div.getTxtHokensyaMeisho().setValue(get保険者名(div.getTxtHokensha().getValue()));
        return ResponseData.of(div).respond();
    }

    private RString get保険者名(RString 保険者番号) {
        if (!RString.isNullOrEmpty(保険者番号)) {
            Hokensha hokensha = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(new HokenjaNo(保険者番号));
            if (hokensha != null) {
                return hokensha.get保険者名();
            }
        }
        return RString.EMPTY;
    }

    private ShisetsuNyutaishoRirekiKanriHandler getHandler(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        return new ShisetsuNyutaishoRirekiKanriHandler(requestDiv);
    }

    private ShisetsuNyutaishoRirekiKanriValidationHandler getValidationHandler(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        return new ShisetsuNyutaishoRirekiKanriValidationHandler(requestDiv);
    }
}
