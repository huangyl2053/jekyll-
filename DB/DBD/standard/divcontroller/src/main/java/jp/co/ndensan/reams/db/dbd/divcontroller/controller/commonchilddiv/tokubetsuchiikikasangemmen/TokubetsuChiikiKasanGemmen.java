/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.tokubetsuchiikikasangemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmenHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 【共有子Div】 特別地域加算減免のDivControllerです。
 *
 * @reamsid_L DBD-3560-070 wangjie2
 */
public class TokubetsuChiikiKasanGemmen {

    /**
     * 画面初期化です。
     *
     * @param div TokubetsuChiikiKasanGemmenDiv
     * @return ResponseData<TokubetsuChiikiKasanGemmenDiv>
     */
    public ResponseData<TokubetsuChiikiKasanGemmenDiv> onLoad(TokubetsuChiikiKasanGemmenDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (null == div.getHihokenshaNo() || div.getHihokenshaNo().isEmpty()) {
                throw new SystemException("被保険者番号が設定されていません。");
            }
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHihokenshaNo());
            List<TokubetsuchiikiKasanGemmen> 申請一覧情報 = div.initializa(被保険者番号);
            if (申請一覧情報.isEmpty()) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_申請情報なし.getMessage()).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるを押下します。
     *
     * @param div TokubetsuChiikiKasanGemmenDiv
     * @return ResponseData<TokubetsuChiikiKasanGemmenDiv>
     */
    public ResponseData<TokubetsuChiikiKasanGemmenDiv> onClick_BtnClose(TokubetsuChiikiKasanGemmenDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 詳細を選択します。
     *
     * @param div TokubetsuChiikiKasanGemmenDiv
     * @return ResponseData<TokubetsuChiikiKasanGemmenDiv>
     */
    public ResponseData<TokubetsuChiikiKasanGemmenDiv> onSelect_dgShakaiFukushiHojinKeigenList(TokubetsuChiikiKasanGemmenDiv div) {
        getHandler(div).一覧の詳細表示();
        return ResponseData.of(div).respond();
    }

    private TokubetsuChiikiKasanGemmenHandler getHandler(TokubetsuChiikiKasanGemmenDiv div) {
        return new TokubetsuChiikiKasanGemmenHandler(div);
    }

}
