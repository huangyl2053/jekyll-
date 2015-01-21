/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba2030011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.CompleteDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例画面における、完了メッセージDivのイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class Complete {

    /**
     * 住所地特例異動の登録を完了するボタンが押下されたときに実行します。<br/>
     * 完了メッセージに、処理対象者の情報を設定します。
     *
     * @param compDiv {@link CompleteDiv 完了メッセージDiv}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 完了メッセージDivを持つResponseData
     */
    public ResponseData<CompleteDiv> onClick_btnUpdate(CompleteDiv compDiv, KihonJohoDiv kihonDiv) {

        RString messageMain = new RString(UrInformationMessages.保存終了.getMessage().toString());
        RString messageTaishoHihoNo = kihonDiv.getCcdKaigoShikakuKihon().get被保険者番号().getColumnValue();
        IShikibetsuTaisho taisho = kihonDiv.getCcdKaigoAtenaInfo().getShikibetsuTaishoHisory().getLatest();
        RString messageTaishoName = taisho.get氏名().getName().getColumnValue();

        compDiv.getCcdKaigoKanryoMessage().setSuccessMessage(messageMain, messageTaishoHihoNo, messageTaishoName);

        return ResponseDatas.createSettingDataTo(compDiv);
    }
}
