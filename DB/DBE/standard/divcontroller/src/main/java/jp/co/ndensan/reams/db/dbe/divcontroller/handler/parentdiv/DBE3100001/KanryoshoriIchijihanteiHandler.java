/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.KanryoshoriIchijihanteiDiv;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・一次判定のHandlerクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihanteiHandler {

    private static final RString 一次判定モード = new RString("一次判定モード");
    private final KanryoshoriIchijihanteiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KanryoshoriIchijihanteiDiv
     */
    public KanryoshoriIchijihanteiHandler(KanryoshoriIchijihanteiDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・一次判定の初期化です。
     *
     */
    public void initialize() {
        div.getCcdNinteiTaskList().initialize(一次判定モード);
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        return ninteiKanryoJoho.createBuilderForEdit().set要介護認定一次判定完了年月日(FlexibleDate.getNowDate()).build();

    }

}
