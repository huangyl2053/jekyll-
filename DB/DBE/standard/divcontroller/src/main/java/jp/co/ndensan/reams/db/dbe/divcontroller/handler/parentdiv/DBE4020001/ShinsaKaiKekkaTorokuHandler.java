/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・審査会結果登録のコントローラです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
public class ShinsaKaiKekkaTorokuHandler {

    private final ShinsaKaiKekkaTorokuDiv div;
    private final RString 二次判定モード = new RString("二次判定モード");
    private final RString 使用 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 審査会結果登録Div
     */
    public ShinsaKaiKekkaTorokuHandler(ShinsaKaiKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・審査会結果登録の初期化を設定します。
     *
     */
    public void onLoad() {
        div.getCcdTaskList().initialize(二次判定モード);
        活性非活性の設定();
    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     */
    public void 要介護認定完了更新() {
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models
                = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
        FlexibleDate 割当完了年月日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<dgNinteiTaskList_Row> 選択データ = div.getCcdTaskList().getCheckbox();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(データ.getShinseishoKanriNo());
            NinteiKanryoJohoIdentifier 要介護認定完了識別子 = new NinteiKanryoJohoIdentifier(申請書管理番号);
            NinteiKanryoJoho 要介護認定完了
                    = models.get(要介護認定完了識別子).createBuilderForEdit().set認定審査会完了年月日(割当完了年月日).build();
            ShinsakaiTorokuManager.createInstance().要介護認定完了更新(要介護認定完了.toEntity());
        }
    }

    private void 活性非活性の設定() {
        RDate 適用基準日 = RDate.getNowDate();
        RString モバイル審査会使用有無 = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会使用有無, 適用基準日, SubGyomuCode.DBE認定支援);
        RString 審査会結果OCR使用有無 = DbBusinessConfig.get(ConfigNameDBE.審査会結果OCR使用有無, 適用基準日, SubGyomuCode.DBE認定支援);
        if (使用.equals(モバイル審査会使用有無)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnMobileToroku"), false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnMobileToroku"), true);
        }
        if (使用.equals(審査会結果OCR使用有無)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnOCRToroku"), false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnOCRToroku"), true);
        }
    }
}
