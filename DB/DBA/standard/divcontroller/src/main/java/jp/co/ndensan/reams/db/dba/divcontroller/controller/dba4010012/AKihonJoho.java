/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba4010012;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010012.KihonJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;

/**
 * 被保険者資格詳細照会画面における、基本情報エリアのDivControllerです。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 FWの仕様（もしくはバグ？）により、別パッケージでも同一名称のDivControllerが存在すると、イベント実行時に動作不良を起こすため一時的に名称の先頭にAを付与
//仕様に対する対応方法が確定した後、もしくは資格取得異動画面の実装時に、元に戻す必要がある。
public class AKihonJoho {

    /**
     * 基本情報の初期化の際に実行します。<br/>
     * 該当者検索画面など、前画面から受け取った情報を元に、宛名と介護資格の情報をそれぞれ設定します。
     *
     * @param div {@link KihonJohoDiv 基本情報Div}
     * @return 基本情報Divを持つResposeData
     */
    public ResponseData<KihonJohoDiv> initialize(KihonJohoDiv div) {
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
