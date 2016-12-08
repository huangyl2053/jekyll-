package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.ninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.ninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinderBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuideModel;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護認定審査会委員情報登録のコントローラです。
 *
 * @reamsid_L DBE-0110-010 wangxiaodong
 */
public class ShinsakaiIinJohoToroku {

    private static final RString 新規モード = new RString("新規");
    private static final RString 更新モード = new RString("更新");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString KEY_廃止 = new RString("key0");
    private static final RString 審査員 = new RString("001");
    private static final RString 調査員モード = new RString("Chosain");
    private static final RString 主治医モード = new RString("IryoKikanMode");
    private final ShinsakaiIinJohoManager manager;
    private final ShozokuKikanIchiranFinder finder;
    private final KoikiShichosonJohoFinder shichosonJohoFinder;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinJohoToroku() {
        manager = ShinsakaiIinJohoManager.createInstance();
        finder = ShozokuKikanIchiranFinder.createInstance();
        shichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onLoad(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        div.getDgShinsaInJohoIchiran().init();
        div.getDdlShikakuCode().setDataSource(manager.get資格コードList());
        div.getDdlYusoKubun().setDataSource(manager.get審査員郵送区分List());
        createHandOf(div).load();
        init介護認定審査会委員情報更新();

        response.data = div;
        return response;
    }

    /**
     * 「検索する」ボタンを押下、審査会委員情報を取得します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKensaku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        List<ShinsakaiIinJoho> 審査会委員一覧情報 = manager.get審査会委員一覧(
                div.getRadHyojiJoken().getSelectedKey(), div.getTxtDispMax().getValue()).records();
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報 = Models.create(審査会委員一覧情報);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報, 介護認定審査会委員情報);
        div.getDgShinsaInJohoIchiran().setDataSource(createHandOf(div).setShinsaInJohoIchiranDiv(審査会委員一覧情報));
        response.data = div;
        return response;
    }

    /**
     * 審査会委員一覧Gridの行クリックの処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_shinsaInJohoIchiranGyo(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!(新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))
                || 更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)))) {
            set審査会委員情報詳細(div);
            set所属機関一覧情報(div);
            div.getDgShozokuKikanIchiran().setDisabled(true);
        }
        response.data = div;
        return response;
    }

    /**
     * 廃止フラグを選択変更処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onChange_haishiFlag(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (KEY_廃止.equals(div.getDdlHaishiFlag().getSelectedKey())) {
            div.getTxtHaishiYMD().setReadOnly(false);
            div.getTxtHaishiYMD().setRequired(true);
        } else {
            div.getTxtHaishiYMD().clearValue();
            div.getTxtHaishiYMD().setReadOnly(true);
        }
        response.data = div;
        return response;
    }

    /**
     * 審査会委員一覧Gridの行ダブルクリック処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onDoubleClick_shinsaInJohoIchiranGyo(ShinsakaiIinJohoTorokuDiv div) {
        return onClick_btnModifyShinsaInJohoIchiran(div);
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタン処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnModifyShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if ((新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && createHandOf(div).has審査会委員詳細情報入力())
                || (更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && createHandOf(div).hasChanged合議体詳細情報())) {
            return 合議体詳細情報変更確認(div);
        }
        審査会委員一覧修正ボタンHandler(div);
        response.data = div;
        return response;
    }

    /**
     * 「審査会委員一覧の削除」アイコンをクリック処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnDeleteShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報更新
                    = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                            ViewStateKeys.介護認定審査会委員情報更新, Models.class);
            ShinsakaiIinJohoIdentifier identifier
                    = new ShinsakaiIinJohoIdentifier(div.getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode());
            if (状態_追加.equals(div.getDgShinsaInJohoIchiran().getClickedItem().getStatus())) {
                div.getDgShinsaInJohoIchiran().getDataSource().remove(div.getDgShinsaInJohoIchiran().getClickedItem());
                介護認定審査会委員情報更新.deleteOrRemove(identifier);
                ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報更新);
            } else {
                div.getDgShinsaInJohoIchiran().getClickedItem().setStatus(状態_削除);
                Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報
                        = ViewStateHolder.get(ViewStateKeys.介護認定審査会委員情報, Models.class);
                介護認定審査会委員情報更新.add(介護認定審査会委員情報.get(identifier).deleted());
                ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報更新);
            }
        }
        response.data = div;
        return response;
    }

    /**
     * 「審査会委員を追加する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShinsakaiIinAdd(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if ((新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && createHandOf(div).has審査会委員詳細情報入力())
                || (更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && createHandOf(div).hasChanged合議体詳細情報())) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                審査会委員追加ボタンHandler(div);
            }
        } else {
            審査会委員追加ボタンHandler(div);
        }
        response.data = div;
        return response;
    }

    /**
     * 「所属機関を追加する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShozokuKikanAdd(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        List<dgShozokuKikanIchiran_Row> 所属機関 = new ArrayList<>();

        List<KoikiZenShichosonJoho> 広域全市町村 = shichosonJohoFinder.getZenShichosonJoho().records();
        for (KoikiZenShichosonJoho en : 広域全市町村) {
            dgShozokuKikanIchiran_Row row = new dgShozokuKikanIchiran_Row();
            row.setShokisaiHokenshaNo(en.get証記載保険者番号().value());
            row.setHokenshaName(en.get市町村名称());
            row.setShichosonCode(en.get市町村コード().value());
            所属機関.add(row);
        }
        div.getDgShozokuKikanIchiran().setDataSource(所属機関);
        createHandOf(div).set所属機関追加ボタンBy一覧();
        setDisabledBy所属機関コード(div);

        response.data = div;
        return response;
    }

    /**
     * 所属機関一覧Gridの削除ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnDeleteShozokuKikanIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getDgShozokuKikanIchiran().getDataSource().remove(div.getDgShozokuKikanIchiran().getClickedItem());
        }
        createHandOf(div).set所属機関追加ボタンBy一覧();

        response.data = div;
        return response;
    }

    /**
     * 認定調査委託先コード補助入力ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnNiteiChosaItakusakiGuide(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        KijuntsukiShichosonjohoiDataPassModel 認定調査委託先 = new KijuntsukiShichosonjohoiDataPassModel();
        認定調査委託先.set対象モード(調査員モード);
        認定調査委託先.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        認定調査委託先.set市町村コード(div.getDgShozokuKikanIchiran().getClickedItem().getShichosonCode());
        div.setHdnDataPass(DataPassingConverter.serialize(認定調査委託先));

        response.data = div;
        return response;
    }

    /**
     * 認定調査委託先コード補助入力ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onOkClose_btnNiteiChosaItakusakiGuide(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        KijuntsukiShichosonjohoiDataPassModel 認定調査委託先 = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        if (!createHandOf(div).is認定調査委託先存在(認定調査委託先)) {
            div.getDgShozokuKikanIchiran().getClickedItem().setNinteiChosainCode(認定調査委託先.get調査員コード());
            div.getDgShozokuKikanIchiran().getClickedItem().getNinteiItakusakiCode().setValue(認定調査委託先.get委託先コード());
            div.getDgShozokuKikanIchiran().getClickedItem().getNinteiChosaItakusakiName().setValue(認定調査委託先.get委託先名());
        }

        response.data = div;
        return response;
    }

    /**
     * 主治医医療機関コード補助入力画面引数を設定します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnShujiiIryoKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        ShujiiIryokikanandshujiiDataPassModel 主治医医療機関 = new ShujiiIryokikanandshujiiDataPassModel();
        主治医医療機関.set対象モード(主治医モード);
        主治医医療機関.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        主治医医療機関.set市町村コード(div.getDgShozokuKikanIchiran().getClickedItem().getShichosonCode());
        主治医医療機関.set主治医医療機関コード(div.getDgShozokuKikanIchiran().getClickedItem().getShujiiIryoKikanCode().getValue());
        div.setHdnDataPass(DataPassingConverter.serialize(主治医医療機関));

        response.data = div;
        return response;
    }

    /**
     * 主治医医療機関コード補助入力画面から、主治医医療機関情報を取得します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onOkClose_btnShujiiIryoKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        ShujiiIryokikanandshujiiDataPassModel 主治医医療機関 = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        if (!createHandOf(div).is主治医医療機関存在(主治医医療機関)) {
            div.getDgShozokuKikanIchiran().getClickedItem().setShujiiCode(主治医医療機関.get主治医コード());
            div.getDgShozokuKikanIchiran().getClickedItem().getShujiiIryoKikanCode().setValue(主治医医療機関.get主治医医療機関コード());
            div.getDgShozokuKikanIchiran().getClickedItem().getShujiiIryoKikanName().setValue(主治医医療機関.get主治医医療機関名称());
        }

        response.data = div;
        return response;
    }

    /**
     * その他機関コード補助入力ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnSonotaKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * その他機関コード補助入力画面から、その他機関情報を取得します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onOkClose_btnSonotaKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        SoNoTaKikanGuideModel その他機関 = ViewStateHolder.get(ViewStateKeys.その他機関選択ガイド_モード, SoNoTaKikanGuideModel.class);
        if (!createHandOf(div).isその他機関存在(その他機関)) {
            div.getDgShozokuKikanIchiran().getClickedItem().getSonotaKikanCode().setValue(その他機関.getその他機関コード());
            div.getDgShozokuKikanIchiran().getClickedItem().getSonotaKikanName().setValue(その他機関.getその他機関名称());
        }

        response.data = div;
        return response;
    }
    
    /**
     * 検索条件入力値をクリアする
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnClear(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.clear検索条件();
        response.data = div;
        return response;
    }

    /**
     * 「入力内容を更新する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnToroku(ShinsakaiIinJohoTorokuDiv div) {
        ValidationMessageControlPairs validationMessages
                = new ShinsakaiIinJohoTorokuValidationHandler(div).審査会委員情報入力チェック(
                        更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)));
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        RString 状態 = RString.EMPTY;
        if (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            状態 = 状態_追加;
            div.getDgShinsaInJohoIchiran().setDataSource(createHandOf(div).set審査会委員一覧By新規モード());
        } else if (更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            if (!状態_追加.equals(div.getDgShinsaInJohoIchiran().getActiveRow().getStatus())) {
                状態 = 状態_修正;
            } else {
                状態 = 状態_追加;
            }
            div.getDgShinsaInJohoIchiran().setDataSource(createHandOf(div).set審査会委員一覧By更新モード());
        }
        ShinsakaiIinJoho shinsakaiIinJoho = setViewStateBy審査会委員情報(div, 状態);
        if (状態_修正.equals(状態)) {
            shinsakaiIinJoho = shinsakaiIinJoho.modifiedModel();
        } else if (状態_削除.equals(状態)) {
            shinsakaiIinJoho = shinsakaiIinJoho.deleted();
        } else if (状態_追加.equals(状態)) {
            shinsakaiIinJoho.toEntity().setState(EntityDataState.Added);
        }
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報更新
                = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                        ViewStateKeys.介護認定審査会委員情報更新, Models.class);
        if (状態_追加.equals(状態)) {
            介護認定審査会委員情報更新.deleteOrRemove(shinsakaiIinJoho.identifier());
        }
        介護認定審査会委員情報更新.add(shinsakaiIinJoho);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報更新);
        onClick_btnToroku状態設定(div);
        response.data = div;
        return response;
    }

    /**
     * 「入力内容を取消する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnDelete(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        if (((更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && handler.hasChanged合議体詳細情報())
                || (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && handler.has審査会委員詳細情報入力()))
                && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if ((更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && !handler.hasChanged合議体詳細情報())
                || (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)) && !handler.has審査会委員詳細情報入力())
                || (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            div.getBtnShinsakaiIinAdd().setDisabled(false);
            handler.shinsakaiIinJohoDiv_init();
            handler.shozokuKikanIchiranDiv_init();
            handler.renrakusakiKinyuKikanDiv_init();
            ViewStateHolder.put(ViewStateKeys.モード, RString.EMPTY);
        }
        response.data = div;
        return response;
    }

    /**
     * 「口座情報を登録する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnKozaJohoToroku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        div.setHdnSubGyomuCode(SubGyomuCode.DBE認定支援.value());
        div.setHdnShikibetsuCode(審査員);

        response.data = div;
        return response;
    }

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnSave(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            審査会委員情報更新();
            init介護認定審査会委員情報更新();
            onClick_btnSave状態設定(div);
        }
        response.data = div;
        return response;
    }

    private ResponseData 合議体詳細情報変更確認(ShinsakaiIinJohoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            審査会委員一覧修正ボタンHandler(div);
        }
        return ResponseData.of(div).respond();
    }

    private ShinsakaiIinJoho setViewStateBy審査会委員情報(ShinsakaiIinJohoTorokuDiv div, RString 状態) {
        ShinsakaiIinJoho shinsakaiIinJoho = new ShinsakaiIinJoho(div.getTxtShinsainCode().getValue());
        if (更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            if (状態_追加.equals(状態)) {
                Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報
                        = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                                ViewStateKeys.介護認定審査会委員情報更新, Models.class);
                shinsakaiIinJoho = 介護認定審査会委員情報.get(shinsakaiIinJoho.identifier());
            } else {
                Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報
                        = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                                ViewStateKeys.介護認定審査会委員情報, Models.class);
                shinsakaiIinJoho = 介護認定審査会委員情報.get(shinsakaiIinJoho.identifier());
            }
        }
        shinsakaiIinJoho.getKaigoNinteiShinsakaiIinShozokuKikanJohoList().clear();
        ShinsakaiIinJohoBuilder shinsakaiIinJohoBuilder = shinsakaiIinJoho.createBuilderForEdit();
        shinsakaiIinJohoBuilder.set介護認定審査会委員開始年月日(new FlexibleDate(div.getTxtShinsaIinYMDFrom().getValue().toDateString()));
        shinsakaiIinJohoBuilder.set介護認定審査会委員終了年月日(new FlexibleDate(div.getTxtShinsaIinYMDTo().getValue().toDateString()));
        shinsakaiIinJohoBuilder.set介護認定審査会委員氏名(new AtenaMeisho(div.getTxtShimei().getValue()));
        shinsakaiIinJohoBuilder.set介護認定審査会委員氏名カナ(new AtenaKanaMeisho(div.getTxtKanaShimei().getValue()));
        shinsakaiIinJohoBuilder.set生年月日(div.getTxtBirthYMD().getValue());
        shinsakaiIinJohoBuilder.set性別(div.getRadSeibetsu().getSelectedKey());
        shinsakaiIinJohoBuilder.set介護認定審査員資格コード(new Code(div.getDdlShikakuCode().getSelectedKey()));
        shinsakaiIinJohoBuilder.set担当地区コード(new ChikuCode(div.getCcdshinsakaiChikuCode().getCode().getKey()));
        shinsakaiIinJohoBuilder.set備考(div.getTxtBiko().getValue());
        shinsakaiIinJohoBuilder.set郵便番号(div.getTxtYubinNo().getValue());
        shinsakaiIinJohoBuilder.set審査員郵送区分(div.getDdlYusoKubun().getSelectedKey());
        shinsakaiIinJohoBuilder.set住所(div.getTxtJusho().getDomain());
        if (KEY_廃止.equals(div.getDdlHaishiFlag().getSelectedKey())) {
            shinsakaiIinJohoBuilder.set廃止フラグ(true);
            shinsakaiIinJohoBuilder.set廃止年月日(div.getTxtHaishiYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(div.getTxtHaishiYMD().getValue().toDateString()));
        } else {
            shinsakaiIinJohoBuilder.set廃止フラグ(false);
        }
        shinsakaiIinJohoBuilder.set電話番号(div.getTxtTelNo1().getDomain());
        shinsakaiIinJohoBuilder.setFAX番号(div.getTxtFaxNo().getDomain());
        return setViewStateBy所属機関一覧(div, shinsakaiIinJohoBuilder);
    }

    private ShinsakaiIinJoho setViewStateBy所属機関一覧(ShinsakaiIinJohoTorokuDiv div, ShinsakaiIinJohoBuilder shinsakaiIinJohoBuilder) {
        List<dgShozokuKikanIchiran_Row> 所属機関一覧Grid = div.getDgShozokuKikanIchiran().getDataSource();
        for (int i = 0; i < 所属機関一覧Grid.size(); i++) {
            KaigoNinteiShinsakaiIinShozokuKikanJoho 所属機関 = new KaigoNinteiShinsakaiIinShozokuKikanJoho(
                    div.getTxtShinsainCode().getValue(), i + 1);
            KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder builder = 所属機関.createBuilderForEdit();
            builder.set証記載保険者番号(new ShoKisaiHokenshaNo(所属機関一覧Grid.get(i).getShokisaiHokenshaNo()));
            builder.set主治医医療機関コード(所属機関一覧Grid.get(i).getShujiiIryoKikanCode().getValue());
            builder.set主治医コード(所属機関一覧Grid.get(i).getShujiiCode());
            builder.set認定調査委託先コード(所属機関一覧Grid.get(i).getNinteiItakusakiCode().getValue());
            builder.set認定調査員コード(所属機関一覧Grid.get(i).getNinteiChosainCode());
            builder.setその他機関コード(所属機関一覧Grid.get(i).getSonotaKikanCode().getValue());
            所属機関 = builder.build();
            所属機関.toEntity().setState(EntityDataState.Added);
            shinsakaiIinJohoBuilder.setKaigoNinteiShinsakaiIinShozokuKikanJoho(所属機関);
        }
        return shinsakaiIinJohoBuilder.build();
    }

    private void onClick_btnToroku状態設定(ShinsakaiIinJohoTorokuDiv div) {
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.shinsakaiIinJohoDiv_init();
        handler.shozokuKikanIchiranDiv_init();
        handler.renrakusakiKinyuKikanDiv_init();
        div.getBtnShinsakaiIinAdd().setDisabled(false);
        div.getBtnToroku().setDisabled(true);
        div.getBtnDelete().setDisabled(true);
        div.getBtnKozaJohoToroku().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        ViewStateHolder.put(ViewStateKeys.モード, RString.EMPTY);
    }

    private void 審査会委員情報更新() {
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報更新
                = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                        ViewStateKeys.介護認定審査会委員情報更新, Models.class);
        Iterator<ShinsakaiIinJoho> 審査会委員情報 = 介護認定審査会委員情報更新.iterator();
        while (審査会委員情報.hasNext()) {
            ShinsakaiIinJoho shinsakaiIinJoho = 審査会委員情報.next();
            if (EntityDataState.Deleted.equals(shinsakaiIinJoho.toEntity().getState())) {
                manager.deletePhysical(shinsakaiIinJoho);
                continue;
            }
            if (EntityDataState.Modified.equals(shinsakaiIinJoho.toEntity().getState())) {
                Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報
                        = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                                ViewStateKeys.介護認定審査会委員情報, Models.class);
                manager.saveOrDeletePhysical(
                        介護認定審査会委員情報.get(shinsakaiIinJoho.identifier()).getKaigoNinteiShinsakaiIinShozokuKikanJohoList(),
                        shinsakaiIinJoho);
                continue;
            }
            manager.insert(shinsakaiIinJoho);
        }
    }

    private void onClick_btnSave状態設定(ShinsakaiIinJohoTorokuDiv div) {
        onClick_btnKensaku(div);
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.shinsakaiIinJohoDiv_init();
        handler.shozokuKikanIchiranDiv_init();
        handler.renrakusakiKinyuKikanDiv_init();
        div.getBtnShinsakaiIinAdd().setDisabled(false);
        div.getBtnToroku().setDisabled(true);
        div.getBtnDelete().setDisabled(true);
    }

    private void init介護認定審査会委員情報更新() {
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報更新 = Models.create(new ArrayList<ShinsakaiIinJoho>());
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報更新);
    }

    private void set所属機関一覧情報(ShinsakaiIinJohoTorokuDiv div) {
        List<ShozokuKikanIchiranFinderBusiness> 所属機関一覧 = finder.get所属機関一覧情報(
                ShinsakaiIinJohoMapperParameter.createParamByShinsakaiIinCode(
                        div.getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode())).records();
        div.getDgShozokuKikanIchiran().setDataSource(createHandOf(div).setShozokuKikanIchiranDiv(所属機関一覧));
        setDisabledBy所属機関コード(div);
    }

    private void set審査会委員情報詳細(ShinsakaiIinJohoTorokuDiv div) {
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.setDivShinsakaiIinJoho();
        handler.setDivRenrakusakiKinyuKikan();
    }

    private void 審査会委員一覧修正ボタンHandler(ShinsakaiIinJohoTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.モード, 更新モード);
        set審査会委員情報詳細(div);
        set所属機関一覧情報(div);
        createHandOf(div).setShinsakaiIinJohoSyosai();
        createHandOf(div).set部品状態_修正ボタン();
    }

    private void 審査会委員追加ボタンHandler(ShinsakaiIinJohoTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.モード, 新規モード);
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.set部品状態_追加ボタン();
        handler.clear審査会委員詳細情報();
        handler.clear連絡先金融機関();
        div.getDgShozokuKikanIchiran().getDataSource().clear();
    }

    private void setDisabledBy所属機関コード(ShinsakaiIinJohoTorokuDiv div) {
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("ninteiItakusakiCode")).getCellDetails().setDisabled(true);
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("shujiiIryoKikanCode")).getCellDetails().setDisabled(true);
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("sonotaKikanCode")).getCellDetails().setDisabled(true);
    }

    private ShinsakaiIinJohoTorokuHandler createHandOf(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuHandler(div);
    }

    /**
     * 審査会委員開始日・終了日の大小チェック。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return ResponseData<ShinsakaiIinJohoTorokuDiv>
     */
    public ResponseData<ShinsakaiIinJohoTorokuDiv> onBlur_TxtShinsaIinYMD(ShinsakaiIinJohoTorokuDiv div) {
        
        if (!RString.isNullOrEmpty(div.getTxtShinsaIinYMDTo().getText()) && !RString.isNullOrEmpty(div.getTxtShinsaIinYMDFrom().getText())) {
            ValidationMessageControlPairs validationMessages
                    = new ShinsakaiIinJohoTorokuValidationHandler(div).審査会委員開始日終了日の大小チェック();
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        return ResponseData.of(div).respond();
    }
    
}
