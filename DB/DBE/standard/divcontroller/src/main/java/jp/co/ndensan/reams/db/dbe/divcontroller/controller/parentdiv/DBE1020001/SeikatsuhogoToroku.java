/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.Minashi2shisaiJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.DBE1020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.SeikatsuhogoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001.SeikatsuhogoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001.SeikatsuhogoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.KoseiShichosonShishoMasterManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * みなし2号登録のコントローラです。
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
public class SeikatsuhogoToroku {

    private final ShishoSecurityJoho shishoSecurity;
    private final KoseiShichosonShishoMasterManager manager;

    /**
     * コンストラクタです。
     *
     */
    public SeikatsuhogoToroku() {
        shishoSecurity = ShishoSecurityJoho.createInstance();
        manager = KoseiShichosonShishoMasterManager.createInstance();
    }

    /**
     * みなし2号登録初期化の設定します。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onLoad(SeikatsuhogoTorokuDiv div) {
        RString code = shishoSecurity.getShishoCode(ControlDataHolder.getUserId());
        Minashi2shisaiJoho business = ViewStateHolder.get(ViewStateKeys.みなし2号登録情報, Minashi2shisaiJoho.class);
        List<KoseiShichosonShishoMaster> list = new ArrayList<>();
        if (business != null) {
            list = manager.get構成市町村支所マスタ一覧By市町村コード(
                    business.get保険者().get市町村コード()).records();
        }
        getHandler(div).load(business, code, list);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択されている保険者に該当する支所情報をセットします。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onChange_ddlHokenshaList(SeikatsuhogoTorokuDiv div) {
        List<KoseiShichosonShishoMaster> list = manager.get構成市町村支所マスタ一覧By市町村コード(
                div.getCcdHokenshaList().getSelectedItem().get市町村コード()).records();
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        for (KoseiShichosonShishoMaster master : list) {
            sourceList.add(new KeyValueDataSource(master.get支所コード().value(), master.get支所コード().value()));
        }
        div.getDdlShisho().setDataSource(sourceList);
        return ResponseData.of(div).respond();
    }

    /**
     * みなし２号被保険者番号を採番する　ボタン、自動採番を行う
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onClick_btnSaiban(SeikatsuhogoTorokuDiv div) {
        RString 被保険者番号 = Saiban.get(SubGyomuCode.DBE認定支援, SaibanHanyokeyName.みなし2号被保険者番号自動採番.getコード()).nextString();
        div.getTxtHihokenshaNo().setValue(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 前回みなし２号申請者を検索するボタン押下の場合、申請者検索画面へ遷移する。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onClick_btnZenkaiSeikatsuhogoshaKensaku(SeikatsuhogoTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).allCheck());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.みなし2号登録情報, getHandler(div).setBusiness());

        return ResponseData.of(div).forwardWithEventName(DBE1020001TransitionEventName.前回生活保護者を検索する).respond();
    }

    /**
     * 申請情報入力へボタン押下の場合、審査依頼受付／みなし２号審査受付画面へ遷移する。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onClick_btnToNinteiShinseiToroku(SeikatsuhogoTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).allCheck());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.みなし2号登録情報, getHandler(div).setBusiness());
        return ResponseData.of(div).forwardWithEventName(DBE1020001TransitionEventName.申請情報入力へ).respond();
    }

    private SeikatsuhogoTorokuHandler getHandler(SeikatsuhogoTorokuDiv div) {
        return new SeikatsuhogoTorokuHandler(div);
    }

    private SeikatsuhogoTorokuValidationHandler getValidationHandler(SeikatsuhogoTorokuDiv div) {
        return new SeikatsuhogoTorokuValidationHandler(div);
    }
}
