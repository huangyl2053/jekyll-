/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・介護認定審査会登録のコントローラです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiTorokuHandler {

//    private final RString 審査会登録モード = new RString("審査会登録モード");
    private final ShinsakaiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会登録Div
     */
    public ShinsakaiTorokuHandler(ShinsakaiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・介護認定審査会登録の初期化を設定します。
     *
     */
    public void onLoad() {
//        div.getCcdTaskList().initialize(審査会登録モード);
    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     * @param models models
     */
    public void 要介護認定完了更新(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models) {
        FlexibleDate 割当完了年月日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<dgNinteiTaskList_Row> 選択データ = div.getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(データ.getShinseishoKanriNo());
            NinteiKanryoJohoIdentifier 要介護認定完了識別子 = new NinteiKanryoJohoIdentifier(申請書管理番号);
            NinteiKanryoJoho 要介護認定完了
                    = models.get(要介護認定完了識別子).createBuilderForEdit().set認定審査会割当完了年月日(割当完了年月日).build();
            ShinsakaiTorokuManager.createInstance().要介護認定完了更新(要介護認定完了.toEntity());
        }
    }
}
