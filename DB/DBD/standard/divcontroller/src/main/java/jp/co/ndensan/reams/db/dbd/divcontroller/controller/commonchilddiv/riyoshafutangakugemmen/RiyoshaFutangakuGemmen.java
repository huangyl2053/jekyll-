/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.riyoshafutangakugemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmenHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 【共有子Div】 利用者負担額減免のDivControllerです。
 *
 * @reamsid_L DBD-3560-060 wangjie2
 */
public class RiyoshaFutangakuGemmen {

    /**
     * 画面初期化です。
     *
     * @param div RiyoshaFutangakuGemmenDiv
     * @return ResponseData<RiyoshaFutangakuGemmenDiv>
     */
    public ResponseData<RiyoshaFutangakuGemmenDiv> onLoad(RiyoshaFutangakuGemmenDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (null == div.getHihokenshaNo() || div.getHihokenshaNo().isEmpty()) {
                throw new SystemException("被保険者番号が設定されていません。");
            }
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHihokenshaNo());
            List<RiyoshaFutangakuGengaku> 申請一覧情報 = div.initializa(被保険者番号);
            if (申請一覧情報.isEmpty()) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_申請情報なし.getMessage()).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるを押下します。
     *
     * @param div RiyoshaFutangakuGemmenDiv
     * @return ResponseData<RiyoshaFutangakuGemmenDiv>
     */
    public ResponseData<RiyoshaFutangakuGemmenDiv> onClick_BtnClose(RiyoshaFutangakuGemmenDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 詳細を選択します。
     *
     * @param div RiyoshaFutangakuGemmenDiv
     * @return ResponseData<RiyoshaFutangakuGemmenDiv>
     */
    public ResponseData<RiyoshaFutangakuGemmenDiv> onSelect_dgShakaiFukushiHojinKeigenList(RiyoshaFutangakuGemmenDiv div) {
        getHandler(div).一覧の詳細表示();
        return ResponseData.of(div).respond();
    }

    private RiyoshaFutangakuGemmenHandler getHandler(RiyoshaFutangakuGemmenDiv div) {
        return new RiyoshaFutangakuGemmenHandler(div);
    }

}
