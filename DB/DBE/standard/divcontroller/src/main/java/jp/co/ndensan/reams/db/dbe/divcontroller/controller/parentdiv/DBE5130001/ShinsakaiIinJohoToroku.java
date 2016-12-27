package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinderBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.DBE5130001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.KozaMitorokuShinsakaiIinCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuideModel;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護認定審査会委員情報登録のコントローラです。
 *
 * @reamsid_L DBE-0110-010 wangxiaodong
 */
public class ShinsakaiIinJohoToroku {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString KEY_廃止 = new RString("key0");
    private static final RString 調査員モード = new RString("Chosain");
    private static final RString 主治医モード = new RString("ShujiiMode");
    private static final RString 文字連結 = new RString("・");
    private static final RString ハイフン = new RString("-");
    private static final int INT_3 = 3;
    private static final int INT_7 = 7;
    private static final RString CSVファイル名 = new RString("口座情報未登録機関一覧表（審査会委員）.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
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

        div.getDgShinsaInJohoIchiran().init();
        createHandOf(div).load();
        return ResponseData.of(div).setState(DBE5130001StateName.検索);
    }

    /**
     * 「検索する」ボタンを押下、審査会委員情報を取得します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKensaku(ShinsakaiIinJohoTorokuDiv div) {

        List<ShinsakaiIinJoho> 審査会委員一覧情報 = manager.get審査会委員一覧(
                div.getRadHyojiJoken().getSelectedKey(), div.getTxtDispMax().getValue()).records();
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報 = Models.create(審査会委員一覧情報);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報, 介護認定審査会委員情報);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報);
        div.getDgShinsaInJohoIchiran().setDataSource(createHandOf(div).setShinsaInJohoIchiranDiv(審査会委員一覧情報));
        return ResponseData.of(div).respond();
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

        審査会委員一覧修正ボタンHandler(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員一覧の削除」アイコンをクリック処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnDeleteShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        審査会委員一覧削除ボタンHandler(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員を追加する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShinsakaiIinAdd(ShinsakaiIinJohoTorokuDiv div) {

        審査会委員追加ボタンHandler(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「所属機関を追加する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShozokuKikanAdd(ShinsakaiIinJohoTorokuDiv div) {

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

        return ResponseData.of(div).respond();
    }

    /**
     * 所属機関一覧Gridの削除ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnDeleteShozokuKikanIchiran(ShinsakaiIinJohoTorokuDiv div) {
        div.getDgShozokuKikanIchiran().getDataSource().remove(div.getDgShozokuKikanIchiran().getClickedItem());
        createHandOf(div).set所属機関追加ボタンBy一覧();
        return ResponseData.of(div).respond();
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
        createHandOf(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力内容を確定する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnToroku(ShinsakaiIinJohoTorokuDiv div) {
        ValidationMessageControlPairs validationMessages
                = getValidationHandler(div).審査会委員情報入力チェック(div.getShinsakaiIinJohoTorokuInput().getStatus());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> models = ViewStateHolder.get(ViewStateKeys.介護認定審査会委員情報更新, Models.class);
        RString イベント状態 = div.getShinsakaiIinJohoTorokuInput().getStatus();
        if (状態_追加.equals(イベント状態)) {
            ShinsakaiIinJoho shinsakaiJoho = new ShinsakaiIinJoho(div.getTxtShinsainCode().getValue());
            shinsakaiJoho = createHandOf(div).setShinsakaiJoho(shinsakaiJoho);
            models.add(shinsakaiJoho);
        } else if (状態_修正.equals(イベント状態)) {
            ShinsakaiIinJohoIdentifier key = new ShinsakaiIinJohoIdentifier(div.getTxtShinsainCode().getValue());
            ShinsakaiIinJoho shinsakaiJoho = createHandOf(div).setShinsakaiJoho(models.get(key).modifiedModel());
            shinsakaiJoho = shinsakaiJoho.modifiedModel();
            models.add(shinsakaiJoho);

        } else if (状態_削除.equals(イベント状態)) {
            ShinsakaiIinJohoIdentifier key = new ShinsakaiIinJohoIdentifier(div.getTxtShinsainCode().getValue());
            RString jotai = div.getDgShinsaInJohoIchiran().getActiveRow().getStatus();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                ShinsakaiIinJoho shinsakaiJoho = createHandOf(div).setShinsakaiJoho(models.get(key).deleted());
                models.add(shinsakaiJoho);
            }
        }
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, models);
        createHandOf(div).setShinsakiToIchiran(イベント状態);
        return responseWithSettingState(div);
    }

    /**
     * 「入力内容を取消する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnDelete(ShinsakaiIinJohoTorokuDiv div) {

        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);

        if (!状態_削除.equals(div.getShinsakaiIinJohoTorokuInput().getStatus())
                && handler.hasChanged合議体詳細情報()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            responseWithSettingState(div);
        } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return responseWithSettingState(div);
    }

    /**
     * 再検索するボタン押下で検索状態に戻ります。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return ResponseData<ShinsakaiIinJohoTorokuDiv>
     */
    public ResponseData<ShinsakaiIinJohoTorokuDiv> onClick_btnReSearch(ShinsakaiIinJohoTorokuDiv div) {

        if (isUpdate(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()
                        .getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getKensakuJoken().setDisabled(false);
                return ResponseData.of(div).setState(DBE5130001StateName.検索);
            }
        } else {
            div.getKensakuJoken().setDisplayNone(false);
            div.getKensakuJoken().setDisabled(false);
            createHandOf(div).load();
            return ResponseData.of(div).setState(DBE5130001StateName.検索);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧に戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShinsakaiIinJohoTorokuDiv> onClick_btnBackIchiran(ShinsakaiIinJohoTorokuDiv div) {
        div.getShinsakaiIinJohoIchiran().setDisabled(false);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        return responseWithSettingState(div);
    }

    private ResponseData<ShinsakaiIinJohoTorokuDiv> responseWithSettingState(ShinsakaiIinJohoTorokuDiv div) {
        div.getShinsakaiIinJohoIchiran().setDisabled(false);
        if (isUpdate(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource())) {
            return ResponseData.of(div).setState(DBE5130001StateName.審査会一覧);
        }
        return ResponseData.of(div).setState(DBE5130001StateName.審査会一覧_保存ボタン非活性);
    }

    private Boolean isUpdate(List<dgShinsaInJohoIchiran_Row> ichiranList) {
        for (dgShinsaInJohoIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getStatus())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 口座情報未登録一覧（審査会委員）を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShinsakaiIinJohoTorokuDiv>
     */
    public IDownLoadServletResponse onClick_btnKozaMitorokuCSV(ShinsakaiIinJohoTorokuDiv div, IDownLoadServletResponse response) {

        getValidationHandler(div).validateForKozaMitorokuCsv();
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<KozaMitorokuShinsakaiIinCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgShinsaInJohoIchiran_Row> dataList = div.getDgShinsaInJohoIchiran().getDataSource();
            for (dgShinsaInJohoIchiran_Row row : dataList) {
                if (isOutKozaMitorokuCsv(row)) {
                    csvWriter.writeLine(getKozaMitorokuCsvData(row));
                }
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);

    }

    private Boolean isOutKozaMitorokuCsv(dgShinsaInJohoIchiran_Row row) {
        if (row.getKinyuKikanCode() == null || row.getKinyuKikanCode().isEmpty()) {
            return true;
        }
        return false;
    }

    private KozaMitorokuShinsakaiIinCsvEntity getKozaMitorokuCsvData(dgShinsaInJohoIchiran_Row row) {
        RString 担当地区名称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                DBECodeShubetsu.審査会地区コード.getコード(),
                new Code(row.getShinsakaiChikuCode()));
        KozaMitorokuShinsakaiIinCsvEntity data = new KozaMitorokuShinsakaiIinCsvEntity(
                row.getShinsainCode(),
                row.getShimei(),
                row.getKanaShimei(),
                editコード名称(row.getShikakuCodeCode(), row.getShikakuCode()),
                editコード名称(row.getShinsakaiChikuCode(), 担当地区名称),
                editCsv日付(row.getShinsakaiIinKaishiYMD().getValue()),
                editCsv日付(row.getShinsakaiIinShuryoYMD().getValue()),
                Edit郵便番号(row.getYubinNo()),
                row.getJusho(),
                row.getTelNo1(),
                row.getFaxNo(),
                editCsv日付(row.getHaishiYMD().getValue()));
        return data;
    }

    private RString editコード名称(RString コード, RString 名称) {
        return コード.isEmpty() ? RString.EMPTY : コード.concat(文字連結).concat(名称);
    }

    private RString editCsv日付(RDate 年月日) {
        if (年月日 != null) {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString Edit郵便番号(RString 編集前郵便番号) {
        RString 郵便番号 = 編集前郵便番号.replace(ハイフン, RString.EMPTY);
        if (郵便番号.length() == INT_7) {
            return 郵便番号.substring(0, INT_3).concat(ハイフン).concat(郵便番号.substring(INT_3));
        }
        return 郵便番号;
    }

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnSave(ShinsakaiIinJohoTorokuDiv div) {

        getValidationHandler(div).validateForUpdate();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            審査会委員情報更新();
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE5130001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private void 審査会委員情報更新() {
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> models
                = ViewStateHolder.get(ViewStateKeys.介護認定審査会委員情報更新, Models.class);
        Iterator<ShinsakaiIinJoho> 審査会委員情報 = models.iterator();
        while (審査会委員情報.hasNext()) {
            ShinsakaiIinJoho shinsakaiIinJoho = 審査会委員情報.next();
            if (EntityDataState.Deleted.equals(shinsakaiIinJoho.toEntity().getState())) {
                manager.deletePhysical(shinsakaiIinJoho);
                continue;
            }
            if (EntityDataState.Modified.equals(shinsakaiIinJoho.toEntity().getState())) {
                Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報
                        = ViewStateHolder.get(ViewStateKeys.介護認定審査会委員情報, Models.class);
                manager.saveOrDeletePhysical(
                        介護認定審査会委員情報.get(shinsakaiIinJoho.identifier()).getKaigoNinteiShinsakaiIinShozokuKikanJohoList(),
                        shinsakaiIinJoho);
                continue;
            }
            manager.insert(shinsakaiIinJoho);
        }
    }

    private void set所属機関一覧情報(ShinsakaiIinJohoTorokuDiv div) {
        List<ShozokuKikanIchiranFinderBusiness> 所属機関一覧 = finder.get所属機関一覧情報(
                ShinsakaiIinJohoMapperParameter.createParamByShinsakaiIinCode(
                        div.getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode())).records();
        div.getDgShozokuKikanIchiran().setDataSource(createHandOf(div).setShozokuKikanIchiranDiv(所属機関一覧));
        setDisabledBy所属機関コード(div);
    }

    private void set審査会委員情報詳細(ShinsakaiIinJohoTorokuDiv div) {
        setDdlDataSource(div);
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.setDivShinsakaiIinJoho();
        handler.setDivRenrakusakiKinyuKikan();
    }

    private void setDdlDataSource(ShinsakaiIinJohoTorokuDiv div) {
        div.getDdlShikakuCode().setDataSource(manager.get資格コードList());
        div.getDdlYusoKubun().setDataSource(manager.get審査員郵送区分List());
    }

    private void 審査会委員一覧修正ボタンHandler(ShinsakaiIinJohoTorokuDiv div) {
        div.getShinsakaiIinJohoTorokuInput().setStatus(状態_修正);
        set審査会委員情報詳細(div);
        set所属機関一覧情報(div);
        createHandOf(div).setShinsakaiIinJohoSyosai();
        createHandOf(div).set部品状態_修正ボタン();
    }

    private void 審査会委員一覧削除ボタンHandler(ShinsakaiIinJohoTorokuDiv div) {
        div.getShinsakaiIinJohoTorokuInput().setStatus(状態_削除);
        set審査会委員情報詳細(div);
        set所属機関一覧情報(div);
        createHandOf(div).setShinsakaiIinJohoSyosai();
        createHandOf(div).set部品状態_削除ボタン();
    }

    private void 審査会委員追加ボタンHandler(ShinsakaiIinJohoTorokuDiv div) {
        div.getShinsakaiIinJohoTorokuInput().setStatus(状態_追加);
        setDdlDataSource(div);
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.set部品状態_追加ボタン();
        handler.clear審査会委員詳細情報();
        handler.clear連絡先金融機関();
        handler.setShinsakaiIinJohoSyosaiEmpty();
        div.getDgShozokuKikanIchiran().getDataSource().clear();
    }

    private void setDisabledBy所属機関コード(ShinsakaiIinJohoTorokuDiv div) {
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("ninteiItakusakiCode")).getCellDetails().setDisabled(true);
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("shujiiIryoKikanCode")).getCellDetails().setDisabled(true);
        div.getDgShozokuKikanIchiran().getGridSetting().getColumn(new RString("sonotaKikanCode")).getCellDetails().setDisabled(true);
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
                    = getValidationHandler(div).審査会委員開始日終了日の大小チェック();
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ShinsakaiIinJohoTorokuHandler createHandOf(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuHandler(div);
    }

    private ShinsakaiIinJohoTorokuValidationHandler getValidationHandler(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuValidationHandler(div);
    }

}
