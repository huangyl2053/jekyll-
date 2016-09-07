/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.MaskingDiv;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・マスキングのHandlerクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
public class MaskingHandler {

    private static final RString マスキングモード = new RString("マスキングモード");
    private final MaskingDiv div;

    /**
     * コンストラクタです。
     *
     * @param div MaskingDiv
     */
    public MaskingHandler(MaskingDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・マスキングの初期化です。
     */
    public void initialize() {
        div.getDgYokaigoNinteiTaskList().initialize(マスキングモード);
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return 要介護認定完了情報
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        return ninteiKanryoJoho.createBuilderForEdit().setマスキング完了年月日(
                new FlexibleDate(RDate.getNowDate().toDateString())).build();
    }

}
