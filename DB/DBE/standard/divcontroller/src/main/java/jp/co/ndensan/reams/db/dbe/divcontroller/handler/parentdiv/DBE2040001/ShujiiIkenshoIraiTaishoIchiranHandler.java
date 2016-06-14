/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・主治医意見書依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0320-010 lishengli
 */
public class ShujiiIkenshoIraiTaishoIchiranHandler {

    private static final RString 意見書依頼モード = new RString("意見書依頼モード");
    private final ShujiiIkenshoIraiTaishoIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ShujiiIkenshoIraiTaishoIchiranHandler(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・主治医意見書入手の初期化です。
     *
     */
    public void initialize() {
        div.getCcdTaskList().initialize(意見書依頼モード);
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     */
    public void 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit().set主治医意見書作成依頼完了年月日(
                new FlexibleDate(RDate.getNowDate().toDateString())).build();
        IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
    }
}
