/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.IkenshogetDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・主治医意見書入手のHandlerクラスです。
 *
 * @reamsid_L DBE-0020-060 lishengli
 */
public class IkenshogetHandler {

    private static final RString 意見書入手モード = new RString("意見書入手モード");
    private static final RString SHINSEISHOKANRINO = new RString("ShinseishoKanriNo");
    private final IkenshogetDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IkenshogetDiv
     */
    public IkenshogetHandler(IkenshogetDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・主治医意見書入手の初期化です。
     *
     */
    public void initialize() {
        div.getCcdTaskList().initialize(意見書入手モード);
    }

    /**
     * 要介護認定完了情報更新の処理です。
     */
    public void 要介護認定完了情報更新() {
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
        if (!前排他キーのセット(SHINSEISHOKANRINO)) {
            ErrorMessage errorMessage = new ErrorMessage(UrErrorMessages.排他_他のユーザが使用中.getMessage().getCode(),
                    UrErrorMessages.排他_他のユーザが使用中.getMessage().evaluate());
            throw new ApplicationException(errorMessage);
        }
        List<dgNinteiTaskList_Row> rowList = div.getCcdTaskList().getCheckbox();
        for (dgNinteiTaskList_Row row : rowList) {
            RString 申請書管理番号 = row.getShinseishoKanriNo();
            if (!RString.isNullOrEmpty(申請書管理番号)) {
                NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                        new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit().set主治医意見書登録完了年月日(
                        new FlexibleDate(RDate.getNowDate().toDateString())).build();
                IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
            }
        }
        前排他キーの解除(SHINSEISHOKANRINO);
    }

    private boolean 前排他キーのセット(RString 申請書管理番号) {
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除(RString 申請書管理番号) {
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        RealInitialLocker.release(排他キー);
    }
}
