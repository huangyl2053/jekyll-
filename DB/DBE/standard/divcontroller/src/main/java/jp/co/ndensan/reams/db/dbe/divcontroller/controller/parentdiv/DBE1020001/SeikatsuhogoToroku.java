/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.SeikatsuhogoTorokuResult;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.DBE1020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.SeikatsuhogoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001.SeikatsuhogoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001.SeikatsuhogoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.seikatsuhogotoroku.SeikatsuhogoTorokuFinder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KoseiShichosonShishoMasterManager;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private final SeikatsuhogoTorokuFinder finder;

    /**
     * コンストラクタです。
     *
     */
    public SeikatsuhogoToroku() {
        shishoSecurity = ShishoSecurityJoho.createInstance();
        manager = KoseiShichosonShishoMasterManager.createInstance();
        finder = SeikatsuhogoTorokuFinder.createInstance();
    }

    /**
     * みなし2号登録初期化の設定します。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onLoad(SeikatsuhogoTorokuDiv div) {
        RString code = shishoSecurity.getShishoCode(ControlDataHolder.getUserId());
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        List<KoseiShichosonShishoMaster> list = getList(null, code, div);
        SeikatsuhogoTorokuResult result = null;
        if (!RString.isNullOrEmpty(申請書管理番号)) {
            div.getBtnSaiban().setDisabled(true);
            result = finder.get申請情報(申請書管理番号);
        } else {
            div.getBtnSaiban().setDisabled(false);
        }
        getHandler(div).load(result, list);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択されている保険者に該当する支所情報をセットします。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onChange_ddlHokenshaList(SeikatsuhogoTorokuDiv div) {
        List<KoseiShichosonShishoMaster> list = getList(div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                shishoSecurity.getShishoCode(ControlDataHolder.getUserId()), div);
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        for (KoseiShichosonShishoMaster master : list) {
            sourceList.add(new KeyValueDataSource(master.get支所名(), master.get支所コード().value()));
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
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ShinseishoKanriNo 前回申請書管理番号 = ShinseishoKanriNo.EMPTY;
        if (!RString.isNullOrEmpty(申請書管理番号)) {
            前回申請書管理番号 = finder.get前回申請書管理番号(new ShinseishoKanriNo(申請書管理番号));
        }
        ViewStateHolder.put(ViewStateKeys.みなし2号登録情報, getHandler(div).setBusiness(前回申請書管理番号));
        return ResponseData.of(div).forwardWithEventName(DBE1020001TransitionEventName.申請情報入力へ).respond();
    }

    /**
     * 宛名共通検索条件を入力する共有子を閉じるの場合、個人番号と行政区の設定です。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onOkClose_btnAtenaKensaku(SeikatsuhogoTorokuDiv div) {
        if (!RString.isNullOrEmpty(div.getTxtShikibetsuCode().getValue())
                && !div.getTxtShikibetsuCode().getValue().equals(div.getHdnKey_OutShikibetsuCode())) {
            div.getTxtHihokenshaNo().clearValue();
            div.getBtnSaiban().setDisabled(false);
        }
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getHdnKey_OutShikibetsuCode());
        div.getTxtShikibetsuCode().setValue(div.getHdnKey_OutShikibetsuCode());
        IKojin kojin = finder.getPsmData(識別コード);
        if (kojin != null) {
            div.getTxtKojinNo().setValue(kojin.get個人番号().value());
            div.getTxtGyoseiku().setValue(kojin.get行政区画().getGyoseiku().get名称());
            div.setHdnGyoseikuCode(kojin.get行政区画().getGyoseiku().getコード().value());
            if (kojin.get生年月日().toFlexibleDate() != null && !kojin.get生年月日().toFlexibleDate().isEmpty()) {
                div.getTxtBirthYMD().setValue(flexToRdate(kojin.get生年月日().toFlexibleDate()));
            }
            div.getRadSeibetsu().setSelectedKey(kojin.get性別().getCode());
            div.getTxtYubinNo().setValue(kojin.get住所().get郵便番号());
            div.getCcdZenkokuJushoInput().load(kojin.get住所().get全国住所コード());
            div.getTxtTelNo().setDomain(kojin.get連絡先１());
        }
        return ResponseData.of(div).respond();
    }

    private SeikatsuhogoTorokuHandler getHandler(SeikatsuhogoTorokuDiv div) {
        return new SeikatsuhogoTorokuHandler(div);
    }

    private SeikatsuhogoTorokuValidationHandler getValidationHandler(SeikatsuhogoTorokuDiv div) {
        return new SeikatsuhogoTorokuValidationHandler(div);
    }

    private RDate flexToRdate(FlexibleDate before) {
        return new RDate(before.wareki().toDateString().toString());
    }

    private List<KoseiShichosonShishoMaster> getList(LasdecCode 市町村コード, RString 支所コード, SeikatsuhogoTorokuDiv div) {
        List<KoseiShichosonShishoMaster> list = new ArrayList<>();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (!市町村セキュリティ情報.get支所管理有無フラグ()) {
            div.getDdlShisho().setDisabled(true);
        } else {
            if (市町村コード != null) {
                list = manager.get構成市町村支所マスタ一覧By市町村コード(
                        市町村コード, new ShishoCode(支所コード)).records();
            } else {
                list = manager.get構成市町村支所マスタ一覧By支所コード(new ShishoCode(支所コード)).records();
            }
        }
        return list;
    }
}
