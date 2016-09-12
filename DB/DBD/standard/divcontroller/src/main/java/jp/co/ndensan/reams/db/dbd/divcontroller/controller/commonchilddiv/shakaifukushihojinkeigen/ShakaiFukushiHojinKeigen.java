/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.shakaifukushihojinkeigen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigenHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 【共有子Div】 社会福祉法人軽減のDivControllerです。
 *
 * @reamsid_L DBD-3560-050 wangjie2
 */
public class ShakaiFukushiHojinKeigen {

    /**
     * 画面初期化です。
     *
     * @param div ShakaiFukushiHojinKeigenDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenDiv> onLoad(ShakaiFukushiHojinKeigenDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (null == div.getHihokenshaNo() || div.getHihokenshaNo().isEmpty()) {
                throw new SystemException("被保険者番号が設定されていません。");
            }
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHihokenshaNo());
            List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報 = div.initializa(被保険者番号);
            if (申請一覧情報.isEmpty()) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_申請情報なし.getMessage()).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるを押下します。
     *
     * @param div ShakaiFukushiHojinKeigenDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenDiv> onClick_BtnClose(ShakaiFukushiHojinKeigenDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 詳細を選択します。
     *
     * @param div ShakaiFukushiHojinKeigenDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenDiv> onSelect_dgShakaiFukushiHojinKeigenList(ShakaiFukushiHojinKeigenDiv div) {
        getHandler(div).一覧の詳細表示();
        return ResponseData.of(div).respond();
    }

    private ShakaiFukushiHojinKeigenHandler getHandler(ShakaiFukushiHojinKeigenDiv div) {
        return new ShakaiFukushiHojinKeigenHandler(div);
    }

}
