package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho.ShinsakaiIinJohoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.DBE5130001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinTorokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.KozaMitorokuShinsakaiIinCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuideModel;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;

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
    private static final RString CSVファイル名 = new RString("介護認定審査会員登録.csv");
    private static final RString 口座情報未登録_CSVファイル名 = new RString("口座情報未登録機関一覧表.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private final ShinsakaiIinJohoManager manager;
    private static final RString KEY_1 = new RString("key1");
    private static final RString 普通 = new RString("普通");
    private static final RString 当座 = new RString("当座");
    private static final RString 納税準備 = new RString("納税準備");
    private static final RString 貯蓄 = new RString("貯蓄");
    private static final RString その他 = new RString("その他");

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinJohoToroku() {
        manager = ShinsakaiIinJohoManager.createInstance();
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
        createHandOf(div).clearKensakuJoken();
        return ResponseData.of(div).setState(DBE5130001StateName.検索);
    }

    /**
     * 「検索する」ボタンを押下、審査会委員情報を取得します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKensaku(ShinsakaiIinJohoTorokuDiv div) {

        RString 審査会委員コードFrom = RString.EMPTY;
        RString 審査会委員コードTo = RString.EMPTY;

        if (!div.getTxtShinsakaiIinCodeFrom().getValue().isNullOrEmpty()
                && !div.getTxtShinsakaiIinCodeTo().getValue().isNullOrEmpty()) {

            if (Long.valueOf(div.getTxtShinsakaiIinCodeFrom().getValue().toString())
                    > Long.valueOf(div.getTxtShinsakaiIinCodeTo().getValue().toString())) {
                審査会委員コードFrom = div.getTxtShinsakaiIinCodeTo().getValue();
                審査会委員コードTo = div.getTxtShinsakaiIinCodeFrom().getValue();
            } else {
                審査会委員コードFrom = div.getTxtShinsakaiIinCodeFrom().getValue();
                審査会委員コードTo = div.getTxtShinsakaiIinCodeTo().getValue();
            }
        }
        boolean is全ての審査会委員 = false;
        if (KEY_1.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is全ての審査会委員 = true;
        }
        ShinsakaiIinJohoTorokuMapperParameter parameter = ShinsakaiIinJohoTorokuMapperParameter.createParamByShinsakaiIinTorokuList(is全ての審査会委員,
                div.getTxtDispMax().getValue(),
                審査会委員コードFrom,
                審査会委員コードTo,
                div.getDdlShinsainShikakuMeisho().getSelectedKey(),
                div.getTxtShinsakaiIinName().getValue(),
                div.getDdlShinsakaiIinMeisho().getSelectedKey(),
                div.getTxtShinsakaiIinKanaName().getValue(),
                div.getDdlShinsakaiIinKanaMeisho().getSelectedKey());
        List<ShinsakaiIinJoho> 審査会委員一覧情報 = manager.get審査会委員一覧(parameter).records();
        Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> 介護認定審査会委員情報 = Models.create(審査会委員一覧情報);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報, 介護認定審査会委員情報);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, 介護認定審査会委員情報);
        div.getDgShinsaInJohoIchiran().setDataSource(createHandOf(div).setShinsaInJohoIchiranDiv(審査会委員一覧情報));
        div.getDgShinsaInJohoIchiran().getGridSetting().setLimitRowCount(div.getTxtDispMax().getValue().intValue());
        List<ShinsakaiIinJoho> 審査会委員一覧情報件数 = manager.get審査会委員一覧件数(parameter).records();
        div.getDgShinsaInJohoIchiran().getGridSetting().setSelectedRowCount(審査会委員一覧情報件数.size());
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
        dgShinsaInJohoIchiran_Row row = div.getDgShinsaInJohoIchiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員登録情報, row);
        createHandOf(div).審査会委員一覧修正ボタンHandler(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員一覧の削除」アイコンをクリック処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnDeleteShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        getValidationHandler(div).削除可否チェック(div.getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode());
        createHandOf(div).審査会委員一覧削除ボタンHandler(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員を追加する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShinsakaiIinAdd(ShinsakaiIinJohoTorokuDiv div) {
        createHandOf(div).審査会委員追加ボタンHandler(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「所属機関を追加する」ボタンを押下します。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShozokuKikanAdd(ShinsakaiIinJohoTorokuDiv div) {
        createHandOf(div).set所属機関行();
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
        認定調査委託先.set対象モード(new RString(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Itakusaki.toString()));
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
            div.getDgShozokuKikanIchiran().getClickedItem().setNinteiChosainCode(RString.EMPTY);
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
        主治医医療機関.set対象モード(new RString(ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.IryoKikanMode.toString()));
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
            div.getDgShozokuKikanIchiran().getClickedItem().setShujiiCode(RString.EMPTY);
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

        SoNoTaKikanGuideModel その他機関 = new SoNoTaKikanGuideModel();
        その他機関.set業務分類(GyomuBunrui.介護認定);
        その他機関.set市町村コード(div.getDgShozokuKikanIchiran().getClickedItem().getShichosonCode());
        その他機関.setその他機関コード(div.getDgShozokuKikanIchiran().getClickedItem().getSonotaKikanCode().getValue());
        ViewStateHolder.put(ViewStateKeys.その他機関選択ガイド_モード, その他機関);

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
        createHandOf(div).clearKensakuJoken();
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
        RString jotai = RString.EMPTY;
        if (状態_追加.equals(イベント状態)) {
            ShinsakaiIinJoho shinsakaiJoho = new ShinsakaiIinJoho(div.getTxtShinsainCode().getValue());
            shinsakaiJoho = createHandOf(div).setShinsakaiJoho(shinsakaiJoho);
            models.add(shinsakaiJoho);
        } else if (状態_修正.equals(イベント状態)) {
            jotai = div.getDgShinsaInJohoIchiran().getActiveRow().getStatus();
            ShinsakaiIinJohoIdentifier key = new ShinsakaiIinJohoIdentifier(div.getTxtShinsainCode().getValue());
            ShinsakaiIinJoho shinsakaiJoho = createHandOf(div).setShinsakaiJoho(models.get(key).modifiedModel());
            shinsakaiJoho = shinsakaiJoho.modifiedModel();
            models.add(shinsakaiJoho);
        } else if (状態_削除.equals(イベント状態)) {
            ShinsakaiIinJohoIdentifier key = new ShinsakaiIinJohoIdentifier(div.getTxtShinsainCode().getValue());
            jotai = div.getDgShinsaInJohoIchiran().getActiveRow().getStatus();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                ShinsakaiIinJoho shinsakaiJoho = createHandOf(div).setShinsakaiJoho(models.get(key).deleted());
                models.add(shinsakaiJoho);
            }
        }
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員情報更新, models);
        createHandOf(div).setShinsakiToIchiran(イベント状態, jotai);
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
        div.getBtnToroku().setDisabled(false);
        div.getTxtBirthYMD().clearValue();
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
     * ＣＳＶを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShinsakaiIinJohoTorokuDiv>
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(ShinsakaiIinJohoTorokuDiv div, IDownLoadServletResponse response) {

        getValidationHandler(div).validateForCsv();
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<ShinsakaiIinTorokuCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
            List<dgShinsaInJohoIchiran_Row> dataList = div.getDgShinsaInJohoIchiran().getDataSource();
            for (dgShinsaInJohoIchiran_Row row : dataList) {
                csvWriter.writeLine(getCsvData(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    private ShinsakaiIinTorokuCsvEntity getCsvData(dgShinsaInJohoIchiran_Row row) {
        RString BirthYMD = RString.EMPTY;
        RString 審査会委員開始日 = RString.EMPTY;
        RString 審査会委員終了日 = RString.EMPTY;
        if (!(row.getBarthYMD().getValue() == null) && !row.getBarthYMD().getValue().toDateString().isEmpty()) {
            BirthYMD = editCsv日付(row.getBarthYMD().getValue());
        }
        if (!(row.getShinsakaiIinKaishiYMD().getValue() == null) && !row.getShinsakaiIinKaishiYMD().getValue().toDateString().isEmpty()) {
            審査会委員開始日 = editCsv日付(row.getShinsakaiIinKaishiYMD().getValue());
        }
        if (!(row.getShinsakaiIinShuryoYMD().getValue() == null) && !row.getShinsakaiIinShuryoYMD().getValue().toDateString().isEmpty()) {
            審査会委員終了日 = editCsv日付(row.getShinsakaiIinShuryoYMD().getValue());
        }
        KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
        List<KinyuKikan> 金融機関情報 = kinyuKikanManager.getValidKinyuKikansOn(FlexibleDate.getNowDate());
        ShinsakaiIinTorokuCsvEntity data = new ShinsakaiIinTorokuCsvEntity(
                row.getShinsainCode(),
                審査会委員開始日,
                審査会委員終了日,
                row.getShimei(),
                row.getKanaShimei(),
                row.getSeibetsu(),
                BirthYMD,
                row.getShikakuCodeCode(),
                row.getShikakuCode(),
                row.getJokyo(),
                row.getBiko(),
                row.getKinyuKikanCode(),
                getKinyuKikanMeisho(金融機関情報, row.getKinyuKikanCode()),
                row.getKinyuKikanShitenCode(),
                getShitenMeisho(金融機関情報, row.getKinyuKikanCode(), row.getKinyuKikanShitenCode()),
                set預金種別(row.getYokinShubetsu()),
                row.getKozaNo(),
                row.getKozaMeigininKana(),
                row.getKozaMeiginin()
        );
        return data;
    }

    private RString set預金種別(RString 預金種別コード) {
        if (!預金種別コード.isEmpty()) {
            switch (預金種別コード.toInt()) {
                case 1:
                    return 普通;
                case 2:
                    return 当座;
                case 3:
                    return 納税準備;
                case 4:
                    return 貯蓄;
                case 9:
                    return その他;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 口座情報未登録一覧を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShinsakaiIinJohoTorokuDiv>
     */
    public IDownLoadServletResponse onClick_btnKozaMitorokuCSV(ShinsakaiIinJohoTorokuDiv div, IDownLoadServletResponse response) {

        getValidationHandler(div).validateForCsv();
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 口座情報未登録_CSVファイル名);
        try (CsvWriter<KozaMitorokuShinsakaiIinCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
            List<dgShinsaInJohoIchiran_Row> dataList = div.getDgShinsaInJohoIchiran().getDataSource();
            for (dgShinsaInJohoIchiran_Row row : dataList) {
                if (isOutKozaMitorokuCsv(row)) {
                    csvWriter.writeLine(getKozaMitorokuCsvData(row));
                }
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(口座情報未登録_CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, 口座情報未登録_CSVファイル名), response);

    }

    private Boolean isOutKozaMitorokuCsv(dgShinsaInJohoIchiran_Row row) {
        return row.getKinyuKikanCode() == null || row.getKinyuKikanCode().isEmpty();
    }

    private KozaMitorokuShinsakaiIinCsvEntity getKozaMitorokuCsvData(dgShinsaInJohoIchiran_Row row) {
        RString BirthYMD = RString.EMPTY;
        RString 審査会委員開始日 = RString.EMPTY;
        RString 審査会委員終了日 = RString.EMPTY;
        if (!(row.getBarthYMD().getValue() == null) && !row.getBarthYMD().getValue().toDateString().isEmpty()) {
            BirthYMD = editCsv日付(row.getBarthYMD().getValue());
        }
        if (!(row.getShinsakaiIinKaishiYMD().getValue() == null) && !row.getShinsakaiIinKaishiYMD().getValue().toDateString().isEmpty()) {
            審査会委員開始日 = editCsv日付(row.getShinsakaiIinKaishiYMD().getValue());
        }
        if (!(row.getShinsakaiIinShuryoYMD().getValue() == null) && !row.getShinsakaiIinShuryoYMD().getValue().toDateString().isEmpty()) {
            審査会委員終了日 = editCsv日付(row.getShinsakaiIinShuryoYMD().getValue());
        }
        KozaMitorokuShinsakaiIinCsvEntity data = new KozaMitorokuShinsakaiIinCsvEntity(
                row.getShinsainCode(),
                審査会委員開始日,
                審査会委員終了日,
                row.getShimei(),
                row.getKanaShimei(),
                row.getSeibetsu(),
                BirthYMD,
                row.getShikakuCodeCode(),
                row.getShikakuCode(),
                row.getJokyo(),
                row.getBiko());
        return data;
    }

    private RString editCsv日付(RDate 年月日) {
        if (年月日 != null) {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
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
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createHandOf(div).審査会委員情報更新();
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE5130001StateName.完了);
        }
        return ResponseData.of(div).respond();
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

    /**
     * 金融機関名を取得します。
     *
     * @param 金融機関情報 List<KinyuKikan>
     * @param kinyuKikanCode RString
     *
     * @return 支店名　RString
     */
    private RString getKinyuKikanMeisho(List<KinyuKikan> 金融機関情報, RString kinyuKikanCode) {
        RString 金融機関名 = RString.EMPTY;
        if (金融機関情報 == null) {
            return 金融機関名;
        }
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if (new RString(kinyuKikanJoho.get金融機関コード().toString()).equals(kinyuKikanCode)) {
                金融機関名 = kinyuKikanJoho.get金融機関名称();
            }
        }
        return 金融機関名;
    }

    /**
     * 金融機関支店名を取得します。
     *
     * @param 金融機関情報 List<List<KinyuKikan>
     * @param kinyuKikanCode RString
     * @param kinyuKikanShitenCode RString
     *
     * @return 支店名　RString
     */
    private RString getShitenMeisho(List<KinyuKikan> 金融機関情報, RString kinyuKikanCode, RString kinyuKikanShitenCode) {
        List<KinyuKikanShiten> 支店リスト = new ArrayList<>();
        RString 支店名 = RString.EMPTY;
        if (金融機関情報 == null) {
            return 支店名;
        }
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if (new RString(kinyuKikanJoho.get金融機関コード().toString()).equals(kinyuKikanCode)) {
                支店リスト = kinyuKikanJoho.get支店リスト();
            }
        }
        for (KinyuKikanShiten shiten : 支店リスト) {
            if (new RString(shiten.get支店コード().toString()).equals(kinyuKikanShitenCode)) {
                支店名 = shiten.get支店名称();
            }
        }
        return 支店名;
    }

    private ShinsakaiIinJohoTorokuHandler createHandOf(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuHandler(div);
    }

    private ShinsakaiIinJohoTorokuValidationHandler getValidationHandler(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuValidationHandler(div);
    }

}
