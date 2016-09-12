/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010003;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.IkenshoKakuninshoDiv;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 *
 * @reamsid_L DBD-5790-010 x_zhaowen
 */
public class IkenshoKakuninshoHandler {
    
    private final IkenshoKakuninshoDiv div;

    /**
     * コンストラクタです。
     * 
     * @param div IkenshoKakuninshoDiv
     */
    public IkenshoKakuninshoHandler(IkenshoKakuninshoDiv div) {
        this.div = div;
    }
    
    /**
     * 主治医意見書確認書画面の初期化
     * 
     * @param taishoshaKey TaishoshaKey
     */
    public void initialize(TaishoshaKey taishoshaKey) {
        div.getPanelKakuninsho().getCcdKaigoAtenaInfo().initialize(taishoshaKey.get識別コード());
        div.getPanelKakuninsho().getCcdKaigoShikakuKihon().initialize(taishoshaKey.get被保険者番号());
        div.getPanelShosaiEria().getCcdBunshoBangoInput().initialize(ReportId.EMPTY);
    }
}
