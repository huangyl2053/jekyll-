/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba1010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.CompleteDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ResponseDataCreator;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 資格取得画面における、完了メッセージのDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class Complete {

    /**
     * 基本情報の初期化の際に実行します。<br/>
     * 該当者検索画面など、前画面から受け取った情報を元に、宛名と介護資格の情報をそれぞれ設定します。
     *
     * @param completeDiv {@link CompleteDiv 完了メッセージDiv}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 完了メッセージDivを持つResposeData
     */
    public ResponseData initialize(CompleteDiv completeDiv, KihonJohoDiv kihonDiv) {
        //TODO #52997
        //1, メッセージを設定します。
        //  messageMain：URZI00001（保存は正常に終了しました）
        //  messageTaisho1：被保険者番号
        //  messageTaisho2：漢字氏名
        //
        //被保険者番号と漢字氏名は、KihonJohoDivから受け取って設定してください。
        return ResponseDataCreator.create(completeDiv);
    }

}
