package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5210001;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.DBE5210001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001.ShinsakaiKaisaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikaisaikekka.ShinsakaiKaisaiKekkaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 介護認定審査会開催結果登録するクラスです。
 *
 * @reamsid_L DBE-0160-010 wangxiaodong
 */
public class ShinsakaiKaisaiKekka {

    private static final int LENGTH_開催番号 = 8;
    private final ShinsakaiKaisaiKekkaFinder service;
    private final ShinsakaiKaisaiYoteiJohoManager manager;
    private final ShinsakaiOnseiJohoManager onseiJohoManager;
    private static final RString 新規モード文言 = new RString("新規モード");
    private static final RString 更新モード文言 = new RString("更新モード");

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiKekka() {
        service = ShinsakaiKaisaiKekkaFinder.createInstance();
        manager = ShinsakaiKaisaiYoteiJohoManager.createInstance();
        onseiJohoManager = new ShinsakaiOnseiJohoManager();
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param div 介護認定審査会開催結果登録div
     * @return ResponseData<ShinsakaiKaisaiKekkaDiv>
     */
    public ResponseData<ShinsakaiKaisaiKekkaDiv> onLoad(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> responseData = new ResponseData<>();
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        List<ShinsakaiKaisaiYoteiJohoBusiness> saiYoteiJoho = service.getヘッドエリア内容検索(開催番号).records();
        div.getShinsakaiKaisaiInfo().getDdlKaisaiBasho().setDataSource(service.get開催会場());
        List<ShinsakaiOnseiJoho2> 音声情報リスト = onseiJohoManager.get介護認定審査会音声情報(開催番号);
        ShinsakaiKaisaiKekkaHandler handler = getHandler(div);
        handler.onLoad(saiYoteiJoho, 音声情報リスト);
        onClick_btnCalcShoyoTime(div);
        handler.setDisabled();
        List<ShinsakaiWariateIinJohoBusiness> list = service.get審査会委員一覧検索(開催番号).records();
        if (list.isEmpty()) {
            handler.set審査会登録入力不可();
        } else {
            handler.initialize(list);
        }

        List<ShinsakaiKaisaiYoteiJoho2> yoteiJohoList = service.get審査会委員(開催番号).records();
        Models<ShinsakaiKaisaiYoteiJoho2Identifier, ShinsakaiKaisaiYoteiJoho2> shinsakaiKaisaiYoteiJoho = Models.create(yoteiJohoList);
        ViewStateHolder.put(ViewStateKeys.審査会開催結果登録, shinsakaiKaisaiYoteiJoho);

        responseData.data = div;
        return responseData;
    }

    /**
     * 音声ファイルを追加 ボタンを押下 音声ファイル取込を行う。
     *
     * @param div 介護認定審査会開催結果登録div
     * @param files 音声ファイル
     * @return responseData
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ShinsakaiKaisaiKekkaDiv> onClick_btnRemoveIin(ShinsakaiKaisaiKekkaDiv div, FileData[] files) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        ShinsakaiKaisaiKekkaHandler handler = getHandler(div);
        int 連番 = service.get連番(開催番号);
        for (FileData file : files) {
            try {
                byte[] array = Files.readAllBytes(Paths.get(file.getFilePath().toString()));
                ShinsakaiOnseiJoho2 shinsakaiOnseiJoho = new ShinsakaiOnseiJoho2(開催番号, 連番 + 1);
                ShinsakaiOnseiJoho2Builder shinsakaiOnseiJohoBuilder = shinsakaiOnseiJoho.createBuilderForEdit();
                shinsakaiOnseiJohoBuilder.set審査会音声ファイル(array);
                shinsakaiOnseiJoho = shinsakaiOnseiJohoBuilder.build();
                onseiJohoManager.save介護認定審査会音声情報(shinsakaiOnseiJoho);
                handler.add音声情報(shinsakaiOnseiJoho, RDateTime.now());
            } catch (IOException ex) {
                return ResponseData.of(div).addMessage(UrErrorMessages.指定ファイルが存在しない.getMessage()).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 開催時間を委員一覧に反映するボタンが押されたときのイベントです。
     *
     * @param div 介護認定審査会開催結果登録div
     * @return responseData
     */
    public ResponseData<ShinsakaiKaisaiKekkaDiv> onClick_btnReflectKaisaiTimeToShinsakaiIinIchiran(ShinsakaiKaisaiKekkaDiv div) {
        ShinsakaiKaisaiKekkaHandler handler = getHandler(div);
        RTime 開催開始時刻 = handler.get開催開始時刻();
        if (開催開始時刻 != null) {
            handler.set委員一覧出席時刻(開催開始時刻);
        }
        RTime 開催終了時刻 = handler.get開催終了時刻();
        if (開催終了時刻 != null) {
            handler.set委員一覧退席時刻(開催終了時刻);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 所要時間を計算するボタンが押されたときのイベントです。
     *
     * @param div 介護認定審査会開催結果登録div
     * @return responseData
     */
    public ResponseData<ShinsakaiKaisaiKekkaDiv> onClick_btnCalcShoyoTime(ShinsakaiKaisaiKekkaDiv div) {
        ShinsakaiKaisaiKekkaHandler handler = getHandler(div);
        long 所要時間 = handler.get所要時間from開催期間();
        handler.set所要時間(所要時間);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧Gridの「削除」ボタンを押下 ＤＢ介護認定審査会割当委員情報」より物理削除です。
     *
     * @param div 介護認定審査会開催結果登録div
     * @return responseData
     */
    public ResponseData onClick_DeleteButton(ShinsakaiKaisaiKekkaDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        ResponseData<ShinsakaiKaisaiKekkaDiv> responseData = new ResponseData<>();
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class).padRight(" ", LENGTH_開催番号);
            Models<ShinsakaiKaisaiYoteiJoho2Identifier, ShinsakaiKaisaiYoteiJoho2> yoteiJohoModel
                    = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
            ShinsakaiKaisaiYoteiJoho2Identifier kaisaiYoteiJohoIdentifier = new ShinsakaiKaisaiYoteiJoho2Identifier(開催番号);
            ShinsakaiKaisaiYoteiJoho2 shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(kaisaiYoteiJohoIdentifier);
            ShinsakaiWariateIinJoho2Identifier wariateIinJohoIdentifier = new ShinsakaiWariateIinJoho2Identifier(
                    開催番号, div.getDgShinsakaiIinIchiran().getClickedItem().getShinsakjaiIinCode());
            ShinsakaiWariateIinJoho2 shinsakaiWariateIinJoho = shinsakaiKaisaiYoteiJoho.getShinsakaiWariateIinJoho2(wariateIinJohoIdentifier);
            shinsakaiWariateIinJoho = shinsakaiWariateIinJoho.deleted();
            ShinsakaiKaisaiYoteiJoho2Builder kaisaiYoteiJohoBuilder = shinsakaiKaisaiYoteiJoho.createBuilderForEdit();
            kaisaiYoteiJohoBuilder.setShinsakaiWariateIinJoho2(shinsakaiWariateIinJoho);
            div.getDgShinsakaiIinIchiran().getDataSource().remove(div.getDgShinsakaiIinIchiran().getClickedItem());
            ViewStateHolder.put(ViewStateKeys.審査会開催結果登録, yoteiJohoModel);
        }
        responseData.data = div;
        return responseData;
    }

    /**
     * 保存」ボタンを押下 介護認定審査会結果情報更新処理です。
     *
     * @param div 介護認定審査会開催結果登録div
     * @return ResponseData<ShinsakaiKaisaiKekkaDiv>
     */
    public ResponseData onClick_btnUpdate(ShinsakaiKaisaiKekkaDiv div) {
        ShinsakaiKaisaiValidationHandler validationHandler = getValidationHandler(div);
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class).padRight(" ", LENGTH_開催番号);
        ShinsakaiKaisaiYoteiJoho2 結果情報 = null;
        if (div.getModel().equals(更新モード文言)) {
            結果情報 = getKekkaJoho(div, 開催番号);
        }
        ValidationMessageControlPairs validationMessages = validationHandler.validate(結果情報);
        if (!ResponseHolder.isReRequest()) {
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        if (!ResponseHolder.isReRequest() || ResponseHolder.getButtonType() == null) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if ((ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                || ResponseHolder.isWarningIgnoredRequest()) {
            setYotei(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("審査会開催結果登録")).respond();
        }
        if ((ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                || ResponseHolder.isWarningIgnoredRequest()) {
            return ResponseData.of(div).forwardWithEventName(DBE5210001TransitionEventName.審査会一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧に戻る」ボタンをクリックの場合、 審査会一覧画面に戻る。
     *
     * @param div 介護認定審査会開催結果登録div
     * @return ResponseData<ShinsakaiKaisaiKekkaDiv>
     */
    public ResponseData<ShinsakaiKaisaiKekkaDiv> onClick_btnRetuen(ShinsakaiKaisaiKekkaDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE5210001TransitionEventName.審査会一覧に戻る).respond();
    }

    private void setYotei(ShinsakaiKaisaiKekkaDiv div) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class).padRight(" ", LENGTH_開催番号);
        if (新規モード文言.equals(div.getModel())) {
            manager.updateBy開催無(getYoteiJoho(div, 開催番号));
        }
        if (更新モード文言.equals(div.getModel())) {
            manager.updateBy開催(getKekkaJoho(div, 開催番号));
        }
    }

    private ShinsakaiKaisaiYoteiJoho2 getYoteiJoho(ShinsakaiKaisaiKekkaDiv div, RString 開催番号) {
        Models<ShinsakaiKaisaiYoteiJoho2Identifier, ShinsakaiKaisaiYoteiJoho2> yoteiJohoModel
                = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
        ShinsakaiKaisaiYoteiJoho2Identifier kaisaiYoteiJohoIdentifier = new ShinsakaiKaisaiYoteiJoho2Identifier(開催番号);
        ShinsakaiKaisaiYoteiJoho2 shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(kaisaiYoteiJohoIdentifier);
        ShinsakaiKaisaiKekkaJoho2 shinsakaiKaisaiKekkaJoho = new ShinsakaiKaisaiKekkaJoho2(開催番号);
        ShinsakaiKaisaiKekkaJoho2Builder kaisaiKekkaJohoBuilder = shinsakaiKaisaiKekkaJoho.createBuilderForEdit();
        shinsakaiKaisaiKekkaJoho = set介護認定審査会開催結果情報(div, kaisaiKekkaJohoBuilder);
        shinsakaiKaisaiYoteiJoho = set介護認定審査会割当委員情報(div, 開催番号, shinsakaiKaisaiYoteiJoho);
        ShinsakaiKaisaiYoteiJoho2Builder kaisaiYoteiJohoBuilder = shinsakaiKaisaiYoteiJoho.createBuilderForEdit();
        kaisaiYoteiJohoBuilder.set介護認定審査会進捗状況(new Code(ShinsakaiShinchokuJokyo.完了.getコード()));
        kaisaiYoteiJohoBuilder.setShinsakaiKaisaiKekkaJoho(shinsakaiKaisaiKekkaJoho);
        shinsakaiKaisaiYoteiJoho = kaisaiYoteiJohoBuilder.build();
        return shinsakaiKaisaiYoteiJoho.modifiedModel();

    }

    private ShinsakaiKaisaiYoteiJoho2 getKekkaJoho(ShinsakaiKaisaiKekkaDiv div, RString 開催番号) {
        Models<ShinsakaiKaisaiYoteiJoho2Identifier, ShinsakaiKaisaiYoteiJoho2> yoteiJohoModel
                = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
        ShinsakaiKaisaiYoteiJoho2 shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(new ShinsakaiKaisaiYoteiJoho2Identifier(開催番号));
        ShinsakaiKaisaiKekkaJoho2 shinsakaiKaisaiKekkaJoho = shinsakaiKaisaiYoteiJoho
                .getShinsakaiKaisaiKekkaJoho(new ShinsakaiKaisaiKekkaJoho2Identifier(開催番号));
        shinsakaiKaisaiKekkaJoho = set介護認定審査会開催結果情報(div, shinsakaiKaisaiKekkaJoho.createBuilderForEdit()).modifiedModel();
        shinsakaiKaisaiYoteiJoho = set介護認定審査会割当委員情報(div, 開催番号, shinsakaiKaisaiYoteiJoho);
        shinsakaiKaisaiYoteiJoho.createBuilderForEdit().setShinsakaiKaisaiKekkaJoho(shinsakaiKaisaiKekkaJoho);
        return shinsakaiKaisaiYoteiJoho;

    }

    private ShinsakaiKaisaiKekkaJoho2 set介護認定審査会開催結果情報(ShinsakaiKaisaiKekkaDiv div,
            ShinsakaiKaisaiKekkaJoho2Builder kaisaiKekkaJohoBuilder) {
        kaisaiKekkaJohoBuilder.set合議体番号(Integer.parseInt(div.getGogitaiNo().toString()));
        kaisaiKekkaJohoBuilder.set介護認定審査会開催年月日(div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().getValue());
        kaisaiKekkaJohoBuilder.set介護認定審査会開始時刻(timeToStr(div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getValue()));
        kaisaiKekkaJohoBuilder.set介護認定審査会終了時刻(timeToStr(div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getValue()));
        kaisaiKekkaJohoBuilder.set介護認定審査会開催場所コード(div.getShinsakaiKaisaiInfo().getDdlKaisaiBasho().getSelectedKey());
        kaisaiKekkaJohoBuilder.set所要時間合計(Integer.valueOf(String.valueOf(div.getShinsakaiKaisaiInfo().getTxtShoyoTime().getValue())));
        kaisaiKekkaJohoBuilder.set介護認定審査会実施人数(div.getShinsakaiKaisaiInfo().getTxtJissiSu().getValue().intValue());

        return kaisaiKekkaJohoBuilder.build();
    }

    private ShinsakaiKaisaiYoteiJoho2 set介護認定審査会割当委員情報(ShinsakaiKaisaiKekkaDiv div,
            RString 開催番号,
            ShinsakaiKaisaiYoteiJoho2 shinsakaiKaisaiYoteiJoho) {
        for (dgShinsakaiIinIchiran_Row row : div.getDgShinsakaiIinIchiran().getDataSource()) {
            ShinsakaiWariateIinJoho2 shinsakaiWariateIinJoho = shinsakaiKaisaiYoteiJoho.getShinsakaiWariateIinJoho2(
                    new ShinsakaiWariateIinJoho2Identifier(開催番号, row.getShinsakjaiIinCode()));
            ShinsakaiWariateIinJoho2Builder shinsakaiWariateIinJohoBuilder = shinsakaiWariateIinJoho.createBuilderForEdit();
            shinsakaiWariateIinJohoBuilder.set介護認定審査会議長区分コード(new Code(row.getGichoKubun().getSelectedKey()));
            shinsakaiWariateIinJohoBuilder.set介護認定審査会開催年月日(div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().getValue());
            shinsakaiWariateIinJohoBuilder.set委員出席(Boolean.valueOf(row.getShukketsuKubun().getSelectedKey().toString()));
            shinsakaiWariateIinJohoBuilder.set委員出席時間(row.getShussekiTime().getText().substring(0, 4).replace(":", ""));
            shinsakaiWariateIinJohoBuilder.set委員早退有無(Boolean.valueOf(row.getSotaiUmu().getSelectedKey().toString()));
            shinsakaiWariateIinJohoBuilder.set委員退席時間(row.getTaisekiTime().getText().substring(0, 4).replace(":", ""));
            shinsakaiWariateIinJohoBuilder.set委員遅刻有無(Boolean.valueOf(row.getChikokuUmu().getSelectedKey().toString()));
            ShinsakaiKaisaiYoteiJoho2Builder kaisaiYoteiJohoBuilder = shinsakaiKaisaiYoteiJoho.createBuilderForEdit();
            kaisaiYoteiJohoBuilder.setShinsakaiWariateIinJoho2(shinsakaiWariateIinJohoBuilder.build().modifiedModel());
            shinsakaiKaisaiYoteiJoho = kaisaiYoteiJohoBuilder.build();
        }
        return shinsakaiKaisaiYoteiJoho;
    }

    private ShinsakaiKaisaiValidationHandler getValidationHandler(ShinsakaiKaisaiKekkaDiv div) {
        return new ShinsakaiKaisaiValidationHandler(div);
    }

    private ShinsakaiKaisaiKekkaHandler getHandler(ShinsakaiKaisaiKekkaDiv div) {
        return new ShinsakaiKaisaiKekkaHandler(div);
    }

    private RString timeToStr(RTime time) {
        if (time == null) {
            return RString.EMPTY;
        }
        int hour = time.getHour();
        int min = time.getMinute();
        return new RString(String.valueOf(hour)).padZeroToLeft(2).concat(new RString(String.valueOf(min)).padZeroToLeft(2));
    }

}
