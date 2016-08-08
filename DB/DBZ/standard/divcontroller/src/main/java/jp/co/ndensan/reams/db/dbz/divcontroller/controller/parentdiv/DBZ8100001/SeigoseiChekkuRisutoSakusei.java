/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ8100001;

import jp.co.ndensan.reams.db.dbz.definition.batchprm.seigoseichekkurisutosakusei.SeigoseiChekkuBatchParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ8100001.SeigoseiChekkuRisutoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 整合性チェックリストのコントローラです。
 *
 * @reamsid_L DBA-5800-010 zhangzhiming
 */
public class SeigoseiChekkuRisutoSakusei {

    /**
     * 画面初期化処理です。
     *
     * @param div SeigoseiChekkuRisutoSakuseiDiv
     * @return ResponseData<SeigoseiChekkuRisutoSakuseiDiv>
     */
    public ResponseData<SeigoseiChekkuRisutoSakuseiDiv> onLoad(SeigoseiChekkuRisutoSakuseiDiv div) {
        div.getTxtShoriKijyunbi().setValue(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンをクリック、バッチパラメータの設定します。
     *
     * @param div SeigoseiChekkuRisutoSakuseiDiv
     * @return ResponseData<SeigoseiChekkuRisutoSakuseiDiv>
     */
    public ResponseData<SeigoseiChekkuBatchParameter> onClick_btnJikoou(SeigoseiChekkuRisutoSakuseiDiv div) {
        SeigoseiChekkuBatchParameter parameter = new SeigoseiChekkuBatchParameter();
        parameter.set年齢到達の設定日(new FlexibleDate(div.getTxtShoriKijyunbi().getValue().toDateString()));
        return ResponseData.of(parameter).respond();
    }
}
