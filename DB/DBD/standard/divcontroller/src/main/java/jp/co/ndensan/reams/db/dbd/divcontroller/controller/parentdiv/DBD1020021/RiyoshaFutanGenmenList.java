/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1020021;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD201010.DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020021.RiyoshaFutanGenmenListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020021.RiyoshaFutanGenmenListHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 利用者負担額減免認定者リスト画面のDivControllerです。
 *
 * @reamsid_L DBD-3980-010 xuejm
 */
public class RiyoshaFutanGenmenList {

    /**
     * 画面初期化処理です。
     *
     * @param div RiyoshaFutanGenmenListDiv
     * @return ResponseData<RiyoshaFutanGenmenListDiv>
     */
    public ResponseData<RiyoshaFutanGenmenListDiv> onLoad(RiyoshaFutanGenmenListDiv div) {
        createhandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「該当者リスト」と「認定者リスト」ラジオを操作です。
     *
     * @param div RiyoshaFutanGenmenListDiv
     * @return ResponseData<RiyoshaFutanGenmenListDiv>
     */
    public ResponseData<RiyoshaFutanGenmenListDiv> radTaishoList_onChange(RiyoshaFutanGenmenListDiv div) {
        createhandler(div).radTaishoList_onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「リスト作成を実行する」ボタンを押下のバッチパラメータ作成。
     *
     * @param div RiyoshaFutanGenmenListDiv
     * @return ResponseData<DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter>
     */
    public ResponseData<DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter> onClick_btnBatchExecute(RiyoshaFutanGenmenListDiv div) {
        RiyoshaFutangakuGemmenNinteishaList riyoshafutan = new RiyoshaFutangakuGemmenNinteishaList();
        return ResponseData.of(riyoshafutan.createRiyoshaFutangakuGemmenNinteishaIchiranParameter(div)).respond();
    }

    private RiyoshaFutanGenmenListHandler createhandler(RiyoshaFutanGenmenListDiv div) {
        return new RiyoshaFutanGenmenListHandler(div);
    }
}
