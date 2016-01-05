/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1130011;

import jp.co.ndensan.reams.db.dba.definition.batchprm.idochecklist.IdoCheckListBatchParameter;
import jp.co.ndensan.reams.db.dba.business.core.idochecklist.IdoCheckListParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1130011.IdochekkurisutoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1130011.IdochekkurisutoHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1130011.IdochekkurisutoValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.idochecklist.IdoCheckListFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 異動チェックリストのコントローラです。
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
        getHandler(div).setLoad(service.getKaisiShuryobi());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、バッチを起動します。
     *
     * @param div 異動チェックリストDIV
     * @return ResponseData<IdochekkurisutoDiv>
     */
    public ResponseData<IdochekkurisutoDiv> onClick_BatchRegister(IdochekkurisutoDiv div) {

        if (div.getTxtkonkaishuryo().getValue().isBefore(div.getTxtkonkaikaishi().getValue())) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().getKashiAfterShuryoMsg()).respond();
        }

        if (div.getTxtkonkaishuryo().getValue().isEmpty()
                && div.getTxtkonkaikaishi().getValue().isEmpty()) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().getRequiredKashiShuryoMsg()).respond();
        }

        IdoCheckListParameter param = IdoCheckListParameter.createIdoCheckListParameter(
                div.getTxtzenkaikaishi().getValue(),
                div.getTxtzenkaishuryo().getValue(),
                div.getTxtkonkaikaishi().getValue(),
                div.getTxtkonkaishuryo().getValue(),
                div.getChktaishodaicho().getSelectedKeys(),
                div.getCcdChohyoShutsuryokujun().getCcdChohyoShutsuryokujun().get出力順ID(),
                div.getChktaishodaicho().isAllSelected());

        IdoCheckListBatchParameter batchParam = service.getIdoCheckListBatchParameter(param);

        return ResponseData.of(div).respond();
    }

    private IdochekkurisutoHandler getHandler(IdochekkurisutoDiv div) {
        return new IdochekkurisutoHandler(div);
    }

    private IdochekkurisutoValidationHandler getValidationHandler() {
        return new IdochekkurisutoValidationHandler();
    }
}
