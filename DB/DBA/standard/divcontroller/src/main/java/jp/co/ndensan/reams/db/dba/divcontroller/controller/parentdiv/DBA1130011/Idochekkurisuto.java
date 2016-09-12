/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1130011;

import jp.co.ndensan.reams.db.dba.business.core.idochecklist.IdoCheckListParameter;
import jp.co.ndensan.reams.db.dba.definition.batchprm.idochecklist.IdoCheckListBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1130011.IdochekkurisutoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1130011.IdochekkurisutoHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1130011.IdochekkurisutoValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.idochecklist.IdoCheckListFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 異動チェックリストのコントローラです。
 *
 * @reamsid_L DBA-0530-010 chengsanyuan
 */
public class Idochekkurisuto {

    private final IdoCheckListFinder service;

    /**
     * コンストラクタです。
     *
     */
    public Idochekkurisuto() {
        this.service = IdoCheckListFinder.createInstance();
    }

    /**
     * 異動チェックリスト初期化の設定します。
     *
     * @param div 異動チェックリストDIV
     * @return ResponseData<IdochekkurisutoDiv>
     */
    public ResponseData<IdochekkurisutoDiv> onLoad(IdochekkurisutoDiv div) {
         if (service.getKaisiShuryobi().records().isEmpty()) {
            getHandler(div).setLoad(null);
        } else {
            getHandler(div).setLoad(service.getKaisiShuryobi().records().get(0));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div 異動チェックリストDIV
     * @return ResponseData<IdochekkurisutoDiv>
     */
    public ResponseData<IdochekkurisutoDiv> onClick_btnCheck(IdochekkurisutoDiv div) {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).checkKashiAfterShuryoMsg());

        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、バッチを起動します。
     *
     * @param div 異動チェックリストDIV
     * @return ResponseData<IdochekkurisutoDiv>
     */
    public ResponseData<IdoCheckListBatchParameter> onClick_BatchRegister(IdochekkurisutoDiv div) {
        IdoCheckListParameter param = IdoCheckListParameter.createIdoCheckListParameter(
                div.getTxtzenkaikaishi().getValue(),
                div.getTxtzenkaishuryo().getValue(),
                div.getTxtkonkaikaishi().getValue(),
                div.getTxtkonkaishuryo().getValue(),
                div.getChktaishodaicho().getSelectedKeys(),
                div.getCcdChohyoShutsuryokujun().get出力順ID(),
                div.getChktaishodaicho().isAllSelected());

        IdoCheckListBatchParameter batchParam = service.getIdoCheckListBatchParameter(param);

        return ResponseData.of(batchParam).respond();
    }

    private IdochekkurisutoHandler getHandler(IdochekkurisutoDiv div) {
        return new IdochekkurisutoHandler(div);
    }

    private IdochekkurisutoValidationHandler getValidationHandler(IdochekkurisutoDiv div) {
        return new IdochekkurisutoValidationHandler(div);
    }
}
