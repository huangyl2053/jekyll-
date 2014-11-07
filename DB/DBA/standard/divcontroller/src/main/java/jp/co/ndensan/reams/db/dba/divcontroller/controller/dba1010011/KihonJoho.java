/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba1010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 資格取得異動の画面における、基本情報のDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class KihonJoho {

    /**
     * 基本情報の初期化の際に実行します。<br/>
     * 該当者検索画面など、前画面から受け取った情報を元に、宛名と介護資格の情報をそれぞれ設定します。
     *
     * @param div {@link KihonJohoDiv 基本情報Div}
     * @return 基本情報Divを持つResposeData
     */
    public ResponseData initialize(KihonJohoDiv div) {
        //TODO #52997
        //1, 宛名情報の設定を行います。
        //  AtenaShokaiSimpleDivが持つload(IAtenaSearchKey)を利用して、初期設定を行ってください。
        //  実装例は以下のURLにあります。参考にしてください。
        //  http://zrtechwiki/techwiki/index.php/URA.AtenaShokaiSimple
        //
        //2, 資格基本情報の設定を行います。
        //  KaigoShikakuKihonDivが持つload(ShikibetsuCode)を利用して、初期設定を行ってください。
        //
        return ResponseDatas.createSettingDataTo(div);
    }
}
