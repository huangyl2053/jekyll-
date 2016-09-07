/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.GetsureiShoriDiv;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・センター送信のHandlerクラスです。
 *
 * @reamsid_L DBE-1520-010 lishengli
 */
public class GetsureiShoriHandler {

    private static final RString 月例処理モード = new RString("月例処理モード");
    private final GetsureiShoriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div GetsureiShoriDiv
     */
    public GetsureiShoriHandler(GetsureiShoriDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・センター送信の初期化です。
     */
    public void initialize() {
        div.getCcdNinteiTaskList().initialize(月例処理モード);
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return 要介護認定完了情報
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        return ninteiKanryoJoho.createBuilderForEdit().setセンター送信年月日(
                new FlexibleDate(RDate.getNowDate().toDateString())).build();
    }

}
