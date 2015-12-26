package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.shinsakaiiinjohotoroku;

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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ShinsakaiIinJohoToroku のクラスファイル 介護認定審査会委員情報を登録・修正・削除する機能、 削除の場合は論理削除を行う。
 */
public class ShinsakaiIinJohoToroku {

    private static final RString 新規モード = new RString("新規");
    private static final RString 更新モード = new RString("更新");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     */
    public ResponseData onLoad(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        ShinsakaiIinJohoManager service = ShinsakaiIinJohoManager.createInstance();

        div.getDgShinsaInJohoIchiran().init();
        div.getDdlShikakuCode().setDataSource(service.get資格コードList());
        div.getDdlYusoKubun().setDataSource(service.get審査員郵送区分List());
        createHandOf(div).load();

        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報更新 = Models.create(new ArrayList<ShinsakaiIinJoho>());
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報更新);
        response.data = div;
        return response;
    }

    /**
     * 「検索する」ボタンを押下、審査会委員情報を取得する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnKensaku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        ShinsakaiIinJohoManager service = ShinsakaiIinJohoManager.createInstance();
        List<ShinsakaiIinJoho> 審査会委員一覧情報 = service.get審査会委員一覧(div.getRadHyojiJoken().getSelectedKey());

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
     * @return レスポンス
     */
    public ResponseData onClick_shinsaInJohoIchiranGyo(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!(新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))
                || 更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class)))) {
            set審査会委員情報詳細(div);
            set所属機関一覧情報(div);
        }
        response.data = div;
        return response;
    }

    /**
     * 廃止フラグを選択変更処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
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
     * @return レスポンス
     */
    public ResponseData onDoubleClick_shinsaInJohoIchiranGyo(ShinsakaiIinJohoTorokuDiv div) {
        return onClick_btnModifyShinsaInJohoIchiran(div);
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタン処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnModifyShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))
                || 更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            boolean hasChanged合議体詳細情報 = createHandOf(div).hasChanged合議体詳細情報();
            if (hasChanged合議体詳細情報) {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
                    if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                        審査会委員一覧修正ボタンHandler(div);
                    }
                }
            }
        } else {
            審査会委員一覧修正ボタンHandler(div);
        }

        response.data = div;
        return response;
    }

    /**
     * 「審査会委員一覧の削除」アイコンをクリック処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnDeleteShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
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
                    介護認定審査会委員情報更新.add(介護認定審査会委員情報.get(identifier));
                    ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報更新);
                }
            }
        }
        response.data = div;
        return response;
    }

    /**
     * 「審査会委員を追加する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnShinsakaiIinAdd(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))
                || 更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
                if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    審査会委員追加ボタンHandler(div);
                }
            }
        } else {
            審査会委員追加ボタンHandler(div);
        }
        response.data = div;
        return response;
    }

    /**
     * 「補助入力ボタン」ボタン押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnShinsakaiChikuCode(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 「所属機関を追加する」ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnShozokuKikanAdd(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        div.getDgShozokuKikanIchiran().getDataSource().add(new dgShozokuKikanIchiran_Row());
        response.data = div;
        return response;
    }

    /**
     * 所属機関一覧Gridの削除ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnDeleteShozokuKikanIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getDgShozokuKikanIchiran().getDataSource().remove(div.getDgShozokuKikanIchiran().getClickedItem());
            }
        }
        response.data = div;
        return response;
    }

    /**
     * 認定調査委託先コード補助入力ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnNiteiChosaItakusakiGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 主治医医療機関コード補助入力ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnShujiiIryoKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * その他機関コード補助入力ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnSonotaKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 「入力内容を更新する」ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnToroku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        審査会委員情報入力チェック(div);
        RString 状態 = RString.EMPTY;
        if (新規モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            状態 = 状態_追加;
            div.getDgShinsaInJohoIchiran().setDataSource(set審査会委員一覧By新規モード(div));
        } else if (更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            if (!状態_追加.equals(div.getDgShinsaInJohoIchiran().getActiveRow().getStatus())) {
                状態 = 状態_修正;
            } else {
                状態 = 状態_追加;
            }
            div.getDgShinsaInJohoIchiran().setDataSource(set審査会委員一覧By更新モード(div));
        }

        ShinsakaiIinJoho shinsakaiIinJoho = setViewStateBy審査会委員情報(div);
        if (状態_修正.equals(状態)) {
            shinsakaiIinJoho = shinsakaiIinJoho.modifiedModel();
        } else if (状態_削除.equals(状態)) {
            shinsakaiIinJoho = shinsakaiIinJoho.deleted();
        } else if (状態_追加.equals(div.getDgShinsaInJohoIchiran().getActiveRow().getStatus())) {
            shinsakaiIinJoho.toEntity().setState(EntityDataState.Added);
        }
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報更新
                = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                        ViewStateKeys.介護認定審査会委員情報更新, Models.class);
        介護認定審査会委員情報更新.add(shinsakaiIinJoho);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報更新);
        onClick_btnToroku状態設定(div);

        response.data = div;
        return response;
    }

    /**
     * 「入力内容を取消する」ボタン押下。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnDelete(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
                handler.clear審査会委員詳細情報();
                handler.shozokuKikanIchiranDiv_init();
                handler.renrakusakiKinyuKikanDiv_init();
            }
        }
        response.data = div;
        return response;
    }

    /**
     * 「口座情報を登録する」ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnKozaJohoToroku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        // TODO ダイアログを表示する.
        // 口座情報照会ダイアログを表示する
        response.data = div;
        return response;
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param div 介護認定審査会委員情報
     * @return レスポンス
     */
    public ResponseData onClick_btnSave(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                審査会委員情報更新();
                onClick_btnSave状態設定(div);
            }
        }
        response.data = div;
        return response;
    }

    private void 審査会委員情報入力チェック(ShinsakaiIinJohoTorokuDiv div) {

        if (!更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            boolean is重複コード = createHandOf(div).is重複コード();
            if (is重複コード) {
                throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace("審査会委員コード"));
            } else {
                int count = ShinsakaiIinJohoManager.createInstance().get審査会委員カウント(
                        new ShinsakaiIinJohoMapperParameter(div.getTxtShinsainCode().getValue()));
                if (0 < count) {
                    throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace("審査会委員コード"));
                }
            }
        }
        if (div.getTxtShinsaIinYMDTo().getValue().isBefore(div.getTxtShinsaIinYMDTo().getValue())) {
            throw new ApplicationException(UrErrorMessages.終了日が開始日以前.getMessage());
        }
        UzT0007CodeEntity 地区コード = CodeMaster.getCode(new CodeShubetsu("5001"), div.getCcdshinsakaiChikuCode().getCode());
        if (地区コード == null) {
            throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage().replace("審査会委員コード"));
        }
    }

    private ShinsakaiIinJoho setViewStateBy審査会委員情報(ShinsakaiIinJohoTorokuDiv div) {
        ShinsakaiIinJoho shinsakaiIinJoho = new ShinsakaiIinJoho(div.getTxtShinsainCode().getValue());
        if (更新モード.equals(ViewStateHolder.get(ViewStateKeys.モード, RString.class))) {
            Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報
                    = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                            ViewStateKeys.介護認定審査会委員情報, Models.class);
            shinsakaiIinJoho = 介護認定審査会委員情報.get(shinsakaiIinJoho.identifier());
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
            builder.set証記載保険者番号(new ShoKisaiHokenshaNo(所属機関一覧Grid.get(i).getShokisaiHokenshaNo()));
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
        div.getBtnToroku().setDisabled(true);
        div.getBtnDelete().setDisabled(true);
        ViewStateHolder.put(ViewStateKeys.モード, RString.EMPTY);
    }

    private void 審査会委員情報更新() {
        ShinsakaiIinJohoManager manager = ShinsakaiIinJohoManager.createInstance();
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報更新
                = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                        ViewStateKeys.介護認定審査会委員情報更新, Models.class);
        Iterator<ShinsakaiIinJoho> 審査会委員情報 = 介護認定審査会委員情報更新.iterator();
        while (審査会委員情報.hasNext()) {
            ShinsakaiIinJoho shinsakaiIinJoho = 審査会委員情報.next();
            if (EntityDataState.Modified.equals(shinsakaiIinJoho.toEntity().getState())) {
                Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報
                        = (Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho>) ViewStateHolder.get(
                                ViewStateKeys.介護認定審査会委員情報, Models.class);
                manager.deletePhysical介護認定審査会委員所属機関情報(介護認定審査会委員情報.get(
                        shinsakaiIinJoho.identifier()).getKaigoNinteiShinsakaiIinShozokuKikanJohoList());
            }
            manager.save(shinsakaiIinJoho);
        }
    }

    private void onClick_btnSave状態設定(ShinsakaiIinJohoTorokuDiv div) {
        onClick_btnKensaku(div);
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.shinsakaiIinJohoDiv_init();
        handler.shozokuKikanIchiranDiv_init();
        handler.renrakusakiKinyuKikanDiv_init();
        div.getBtnToroku().setDisabled(true);
        div.getBtnDelete().setDisabled(true);
    }

    private List<dgShinsaInJohoIchiran_Row> set審査会委員一覧By新規モード(ShinsakaiIinJohoTorokuDiv div) {
        List<dgShinsaInJohoIchiran_Row> 審査会委員一覧情報 = div.getDgShinsaInJohoIchiran().getDataSource();

        dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
        row.setStatus(状態_追加);
        row.setShinsainCode(div.getTxtShinsainCode().getValue());
        row.getShinsakaiIinKaishiYMD().setValue(div.getTxtShinsaIinYMDFrom().getValue());
        row.getShinsakaiIinShuryoYMD().setValue(div.getTxtShinsaIinYMDTo().getValue());
        row.setShimei(div.getTxtShimei().getValue());
        row.setKanaShimei(div.getTxtKanaShimei().getValue());
        row.setSeibetsu(Seibetsu.toValue(div.getRadSeibetsu().getSelectedKey()).get名称());
        if (div.getTxtBirthYMD().getValue().isEmpty()) {
            row.getBarthYMD().setValue(null);
        } else {
            row.getBarthYMD().setValue(new RDate(div.getTxtBirthYMD().getValue().toString()));
        }
        row.setShikakuCode(div.getDdlShikakuCode().getSelectedValue());
        row.setBiko(div.getTxtBiko().getValue());
        row.setJokyo(div.getTxtHaishiFlag().getValue());
        row.setYubinNo(div.getTxtYubinNo().getValue().value());
        row.setYusoKubun(div.getDdlYusoKubun().getSelectedKey());
        row.setJusho(div.getTxtJusho().getDomain().value());
        row.getHaishiYMD().setValue(div.getTxtHaishiYMD().getValue());
        row.setTelNo1(div.getTxtTelNo1().getDomain().value());
        row.setFaxNo(div.getTxtFaxNo().getDomain().value());
        審査会委員一覧情報.add(row);
        return 審査会委員一覧情報;
    }

    private List<dgShinsaInJohoIchiran_Row> set審査会委員一覧By更新モード(ShinsakaiIinJohoTorokuDiv div) {
        List<dgShinsaInJohoIchiran_Row> 審査会委員一覧情報 = div.getDgShinsaInJohoIchiran().getDataSource();
        int count = div.getDgShinsaInJohoIchiran().getGridSetting().selectedRowCount();
        dgShinsaInJohoIchiran_Row row = 審査会委員一覧情報.get(count);

        if (!状態_追加.equals(row.getStatus())) {
            row.setStatus(状態_修正);
        }
        row.setShinsainCode(div.getTxtShinsainCode().getValue());
        row.getShinsakaiIinKaishiYMD().setValue(div.getTxtShinsaIinYMDFrom().getValue());
        row.getShinsakaiIinShuryoYMD().setValue(div.getTxtShinsaIinYMDTo().getValue());
        row.setShimei(div.getTxtShimei().getValue());
        row.setKanaShimei(div.getTxtKanaShimei().getValue());
        row.setSeibetsu(Seibetsu.toValue(div.getRadSeibetsu().getSelectedKey()).get名称());
        if (div.getTxtBirthYMD().getValue().isEmpty()) {
            row.getBarthYMD().setValue(null);
        } else {
            row.getBarthYMD().setValue(new RDate(div.getTxtBirthYMD().getValue().toString()));
        }
        row.setShikakuCode(div.getDdlShikakuCode().getSelectedValue());
        row.setBiko(div.getTxtBiko().getValue());
        row.setJokyo(div.getTxtHaishiFlag().getValue());
        row.setYubinNo(div.getTxtYubinNo().getValue().value());
        row.setYusoKubun(div.getDdlYusoKubun().getSelectedKey());
        row.setJusho(div.getTxtJusho().getDomain().value());
        row.getHaishiYMD().setValue(div.getTxtHaishiYMD().getValue());
        row.setTelNo1(div.getTxtTelNo1().getDomain().value());
        row.setFaxNo(div.getTxtFaxNo().getDomain().value());
        審査会委員一覧情報.set(count, row);
        return 審査会委員一覧情報;
    }

    private void set所属機関一覧情報(ShinsakaiIinJohoTorokuDiv div) {
        List<ShozokuKikanIchiranFinderBusiness> 所属機関一覧 = ShozokuKikanIchiranFinder.createInstance()
                .get所属機関一覧情報(new ShinsakaiIinJohoMapperParameter(
                                div.getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode()));
        div.getDgShozokuKikanIchiran().setDataSource(createHandOf(div).setShozokuKikanIchiranDiv(所属機関一覧));
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
        div.getDgShozokuKikanIchiran().getDataSource().add(new dgShozokuKikanIchiran_Row());
    }

    private ShinsakaiIinJohoTorokuHandler createHandOf(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuHandler(div);
    }
}
