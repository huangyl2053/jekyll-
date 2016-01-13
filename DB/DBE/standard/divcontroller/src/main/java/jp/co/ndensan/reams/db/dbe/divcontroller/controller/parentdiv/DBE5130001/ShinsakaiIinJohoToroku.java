package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinderBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会委員情報登録のコントローラです。
 */
public class ShinsakaiIinJohoToroku {

    private static final RString 新規モード = new RString("新規");
    private static final RString 更新モード = new RString("更新");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private final ShinsakaiIinJohoManager manager;
    private final ShozokuKikanIchiranFinder finder;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinJohoToroku() {
        manager = ShinsakaiIinJohoManager.createInstance();
        finder = ShozokuKikanIchiranFinder.createInstance();
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

        List<ShinsakaiIinJoho> 審査会委員一覧情報 = manager.get審査会委員一覧(div.getRadHyojiJoken().getSelectedKey()).records();
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
    // TODO QA-68
    public ResponseData onChange_haishiFlag(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
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

        if (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))
                || 更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
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
        if (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))
                || 更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
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
     * 「補助入力ボタン」ボタン押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShinsakaiChikuCode(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
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
        dgShozokuKikanIchiran_Row row = new dgShozokuKikanIchiran_Row();
        row.getNinteiItakusakiCode().setDisabled(true);
        row.getShujiiIryoKikanCode().setDisabled(true);
        row.getSonotaKikanCode().setDisabled(true);
        div.getDgShozokuKikanIchiran().getDataSource().add(row);
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
        response.data = div;
        return response;
    }

    /**
     * 認定調査委託先コード補助入力ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnNiteiChosaItakusakiGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 主治医医療機関コード補助入力ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShujiiIryoKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * その他機関コード補助入力ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnSonotaKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
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
                = new ShinsakaiIinJohoTorokuValidationHandler(div).審査会委員情報入力チェック();
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

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
            handler.clear審査会委員詳細情報();
            handler.shozokuKikanIchiranDiv_init();
            handler.renrakusakiKinyuKikanDiv_init();
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
    public ResponseData onClick_btnKozaJohoToroku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        // TODO ダイアログを表示する.
        // 口座情報照会ダイアログを表示する
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
        boolean hasChanged合議体詳細情報 = createHandOf(div).hasChanged合議体詳細情報();
        if (hasChanged合議体詳細情報) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                審査会委員一覧修正ボタンHandler(div);
            }
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
        // TODO QA-68
        shinsakaiIinJohoBuilder.set廃止フラグ(false);
        if (new RString("0").equals(div.getTxtHaishiFlag().getValue())) {
            shinsakaiIinJohoBuilder.set廃止年月日(new FlexibleDate(div.getTxtHaishiYMD().getValue().toDateString()));
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
//          TODO 画面で保険者番号入力不可
//          builder.set証記載保険者番号(new ShoKisaiHokenshaNo(所属機関一覧Grid.get(i).getShokisaiHokenshaNo()));
            builder.set証記載保険者番号(new ShoKisaiHokenshaNo(new RString("000001")));
            builder.set認定調査委託先コード(所属機関一覧Grid.get(i).getNinteiItakusakiCode().getValue());
            builder.set主治医医療機関コード(所属機関一覧Grid.get(i).getShujiiIryoKikanCode().getValue());
            builder.setその他機関コード(所属機関一覧Grid.get(i).getSonotaKikanCode().getValue());
            // TODO QA-250
            builder.set認定調査員コード(new RString("111"));
            builder.set主治医コード(new RString("111"));
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
                manager.deletePhysical介護認定審査会委員所属機関情報(介護認定審査会委員情報.get(
                        shinsakaiIinJoho.identifier()).getKaigoNinteiShinsakaiIinShozokuKikanJohoList());
                manager.save(shinsakaiIinJoho);
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
        List<ShozokuKikanIchiranFinderBusiness> 所属機関一覧 = new ArrayList<>();
//        if (状態_追加.equals(div.getDgShinsaInJohoIchiran().getClickedItem().getStatus())) {
//          TODO QA-381,QA250
        所属機関一覧 = finder.get所属機関一覧情報(new ShinsakaiIinJohoMapperParameter(
                div.getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode())).records();
        div.getDgShozokuKikanIchiran().setDataSource(createHandOf(div).setShozokuKikanIchiranDiv(所属機関一覧));
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("ninteiItakusakiCode")).getCellDetails().setDisabled(true);
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("shujiiIryoKikanCode")).getCellDetails().setDisabled(true);
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("sonotaKikanCode")).getCellDetails().setDisabled(true);
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
        createHandOf(div).set部品状態_修正ボタン();
    }

    private void 審査会委員追加ボタンHandler(ShinsakaiIinJohoTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.モード, 新規モード);
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.set部品状態_追加ボタン();
        handler.clear審査会委員詳細情報();
        handler.clear連絡先金融機関();
        div.getDgShozokuKikanIchiran().getDataSource().clear();
        dgShozokuKikanIchiran_Row row = new dgShozokuKikanIchiran_Row();
        row.getNinteiItakusakiCode().setDisabled(true);
        row.getShujiiIryoKikanCode().setDisabled(true);
        row.getSonotaKikanCode().setDisabled(true);
        div.getDgShozokuKikanIchiran().getDataSource().add(row);
    }

    private ShinsakaiIinJohoTorokuHandler createHandOf(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuHandler(div);
    }
}
