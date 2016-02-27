/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5210001;

import java.io.File;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho.ShinsakaiOnseiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.DBE5210001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001.ShinsakaiKaisaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikaisaikekka.ShinsakaiKaisaiKekkaFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.ByteReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 介護認定審査会開催結果登録するクラスです。
 *
 */
public class ShinsakaiKaisaiKekka {

    private static final int BYTE_1024 = 1024;
    private final ShinsakaiKaisaiKekkaFinder service;
    private final ShinsakaiKaisaiYoteiJohoManager manager;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiKekka() {
        service = ShinsakaiKaisaiKekkaFinder.createInstance();
        manager = ShinsakaiKaisaiYoteiJohoManager.createInstance();
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
        getHandler(div).onLoad(saiYoteiJoho);
        getHandler(div).setDisabled();
        List<ShinsakaiWariateIinJohoBusiness> list = service.get審査会委員一覧検索(開催番号).records();
        getHandler(div).initialize(list);
        SearchResult<ShinsakaiKaisaiYoteiJoho> yoteiJohoList = service.get審査会委員(開催番号);
        Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> shinsakaiKaisaiYoteiJoho
                = Models.create(yoteiJohoList.records());
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
        int 連番 = service.get連番(開催番号);
        for (FileData file : files) {
            ByteReader byteReader = new ByteReader(file.getFilePath().concat(File.separator).concat(file.getFileName()));
            byte[] array = new byte[BYTE_1024];
            byteReader.read(array);
            ShinsakaiKaisaiYoteiJoho shinsakaiKaisaiYoteiJoho = new ShinsakaiKaisaiYoteiJoho(開催番号);
            ShinsakaiOnseiJoho shinsakaiOnseiJoho = new ShinsakaiOnseiJoho(開催番号, 連番);
            ShinsakaiOnseiJohoBuilder shinsakaiOnseiJohoBuilder = shinsakaiOnseiJoho.createBuilderForEdit();
            shinsakaiOnseiJohoBuilder.set審査会音声ファイル(array);
            shinsakaiOnseiJoho = shinsakaiOnseiJohoBuilder.build();
            ShinsakaiKaisaiYoteiJohoBuilder kaisaiYoteiJohoBuilder = shinsakaiKaisaiYoteiJoho.createBuilderForEdit();
            kaisaiYoteiJohoBuilder.setShinsakaiOnseiJoho(shinsakaiOnseiJoho);
            shinsakaiKaisaiYoteiJoho = kaisaiYoteiJohoBuilder.build();
            manager.save(shinsakaiKaisaiYoteiJoho);
        }
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
            RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
            Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> yoteiJohoModel
                    = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
            ShinsakaiKaisaiYoteiJohoIdentifier kaisaiYoteiJohoIdentifier = new ShinsakaiKaisaiYoteiJohoIdentifier(開催番号);
            ShinsakaiKaisaiYoteiJoho shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(kaisaiYoteiJohoIdentifier);
            ShinsakaiWariateIinJohoIdentifier wariateIinJohoIdentifier = new ShinsakaiWariateIinJohoIdentifier(
                    開催番号, div.getDgShinsakaiIinIchiran().getClickedItem().getShinsakjaiIinCode());
            ShinsakaiWariateIinJoho shinsakaiWariateIinJoho
                    = shinsakaiKaisaiYoteiJoho.getShinsakaiWariateIinJoho(wariateIinJohoIdentifier);
            shinsakaiWariateIinJoho = shinsakaiWariateIinJoho.deleted();
            ShinsakaiKaisaiYoteiJohoBuilder kaisaiYoteiJohoBuilder = shinsakaiKaisaiYoteiJoho.createBuilderForEdit();
            kaisaiYoteiJohoBuilder.setShinsakaiWariateIinJoho(shinsakaiWariateIinJoho);
            kaisaiYoteiJohoBuilder.build();
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
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).yoteiStartToKaisaiEndTimeCheck());
        validationMessages.add(getValidationHandler(div).出席時間Check());
        validationMessages.add(getValidationHandler(div).退席時間Check());
        validationMessages.add(getValidationHandler(div).議長複数Check());
        validationMessages.add(getValidationHandler(div).議長出席Check());
        validationMessages.add(getValidationHandler(div).全員が遅刻Check());
        validationMessages.add(getValidationHandler(div).全員が早退Check());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {

            setYotei(div);
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.正常終了.getMessage().replace("審査会開催結果登録")).respond();
        }
        onLoad(div);
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
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> yoteiJohoModel
                = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
        if (new RString("新規モード").equals(div.getModel())) {
            setYoteiJoho(div);
        }
        if (new RString("更新モード").equals(div.getModel())) {
            setKekkaJoho(div);
        }
        ShinsakaiKaisaiYoteiJohoIdentifier kaisaiYoteiJohoIdentifier = new ShinsakaiKaisaiYoteiJohoIdentifier(開催番号);
        ShinsakaiKaisaiYoteiJoho shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(kaisaiYoteiJohoIdentifier);
        ShinsakaiWariateIinJohoManager shinsakaiWariateIinJohoManager = ShinsakaiWariateIinJohoManager.createInstance();
        for (ShinsakaiWariateIinJoho shinsakaiWariateIinJoho : shinsakaiKaisaiYoteiJoho.getShinsakaiWariateIinJohoList()) {
            if (shinsakaiWariateIinJoho.toEntity().getState() == EntityDataState.Deleted) {
                shinsakaiWariateIinJohoManager.deletePhysical(shinsakaiWariateIinJoho);
            }
        }
        setWariateIinJoho(div);
    }

    private void setYoteiJoho(ShinsakaiKaisaiKekkaDiv div) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> yoteiJohoModel
                = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
        ShinsakaiKaisaiYoteiJohoIdentifier kaisaiYoteiJohoIdentifier = new ShinsakaiKaisaiYoteiJohoIdentifier(開催番号);
        ShinsakaiKaisaiYoteiJoho shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(kaisaiYoteiJohoIdentifier);
        ShinsakaiKaisaiKekkaJoho shinsakaiKaisaiKekkaJoho = new ShinsakaiKaisaiKekkaJoho(開催番号);
        ShinsakaiKaisaiKekkaJohoBuilder kaisaiKekkaJohoBuilder = shinsakaiKaisaiKekkaJoho.createBuilderForEdit();
        kaisaiKekkaJohoBuilder.set介護認定審査会開催年月日(div.getTxtKaisaiBi().getValue());
        kaisaiKekkaJohoBuilder.set介護認定審査会開始時刻(timeToStr(div.getTxtKaisaiStartTime().getValue()));
        kaisaiKekkaJohoBuilder.set介護認定審査会終了時刻(timeToStr(div.getTxtKaisaiEndTime().getValue()));
        kaisaiKekkaJohoBuilder.set介護認定審査会開催場所コード(div.getDdlKaisaiBasho().getSelectedKey());
        kaisaiKekkaJohoBuilder.set所要時間合計(Integer.valueOf(String.valueOf(div.getTxtShoyoTime().getValue())));
        kaisaiKekkaJohoBuilder.set介護認定審査会実施人数(div.getTxtJissiSu().getValue().intValue());
        shinsakaiKaisaiKekkaJoho = kaisaiKekkaJohoBuilder.build();
        ShinsakaiKaisaiYoteiJohoBuilder kaisaiYoteiJohoBuilder = shinsakaiKaisaiYoteiJoho.createBuilderForEdit();
        kaisaiYoteiJohoBuilder.set介護認定審査会進捗状況(new Code("3"));
        kaisaiYoteiJohoBuilder.setShinsakaiKaisaiKekkaJoho(shinsakaiKaisaiKekkaJoho);
        shinsakaiKaisaiYoteiJoho = kaisaiYoteiJohoBuilder.build();
        shinsakaiKaisaiYoteiJoho = shinsakaiKaisaiYoteiJoho.modifiedModel();
        manager.save(shinsakaiKaisaiYoteiJoho);
    }

    private void setKekkaJoho(ShinsakaiKaisaiKekkaDiv div) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> yoteiJohoModel
                = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
        ShinsakaiKaisaiYoteiJohoIdentifier kaisaiYoteiJohoIdentifier = new ShinsakaiKaisaiYoteiJohoIdentifier(開催番号);
        ShinsakaiKaisaiYoteiJoho shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(kaisaiYoteiJohoIdentifier);
        ShinsakaiKaisaiKekkaJohoIdentifier kaisaiKekkaJohoIdentifier = new ShinsakaiKaisaiKekkaJohoIdentifier(開催番号);
        ShinsakaiKaisaiKekkaJoho shinsakaiKaisaiKekkaJoho
                = shinsakaiKaisaiYoteiJoho.getShinsakaiKaisaiKekkaJoho(kaisaiKekkaJohoIdentifier);
        ShinsakaiKaisaiKekkaJohoBuilder kaisaiKekkaJohoBuilder = shinsakaiKaisaiKekkaJoho.createBuilderForEdit();
        kaisaiKekkaJohoBuilder.set介護認定審査会開催年月日(div.getTxtKaisaiBi().getValue());
        kaisaiKekkaJohoBuilder.set介護認定審査会開始時刻(timeToStr(div.getTxtKaisaiStartTime().getValue()));
        kaisaiKekkaJohoBuilder.set介護認定審査会終了時刻(timeToStr(div.getTxtKaisaiEndTime().getValue()));
        kaisaiKekkaJohoBuilder.set介護認定審査会開催場所コード(div.getDdlKaisaiBasho().getSelectedKey());
        kaisaiKekkaJohoBuilder.set所要時間合計(Integer.valueOf(String.valueOf(div.getTxtShoyoTime().getValue())));
        kaisaiKekkaJohoBuilder.set介護認定審査会実施人数(div.getTxtJissiSu().getValue().intValue());
        shinsakaiKaisaiKekkaJoho = kaisaiKekkaJohoBuilder.build();
        shinsakaiKaisaiKekkaJoho = shinsakaiKaisaiKekkaJoho.modifiedModel();
        ShinsakaiKaisaiKekkaJohoManager kekkaJohoManager = ShinsakaiKaisaiKekkaJohoManager.createInstance();
        kekkaJohoManager.save介護認定審査会開催結果情報(shinsakaiKaisaiKekkaJoho);
    }

    private void setWariateIinJoho(ShinsakaiKaisaiKekkaDiv div) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> yoteiJohoModel
                = ViewStateHolder.get(ViewStateKeys.審査会開催結果登録, Models.class);
        for (dgShinsakaiIinIchiran_Row row : div.getDgShinsakaiIinIchiran().getDataSource()) {
            ShinsakaiKaisaiYoteiJohoIdentifier kaisaiYoteiJohoIdentifier = new ShinsakaiKaisaiYoteiJohoIdentifier(開催番号);
            ShinsakaiKaisaiYoteiJoho shinsakaiKaisaiYoteiJoho = yoteiJohoModel.get(kaisaiYoteiJohoIdentifier);
            ShinsakaiWariateIinJohoIdentifier wariateIinJohoIdentifier
                    = new ShinsakaiWariateIinJohoIdentifier(開催番号, row.getShinsakjaiIinCode());
            ShinsakaiWariateIinJoho shinsakaiWariateIinJoho
                    = shinsakaiKaisaiYoteiJoho.getShinsakaiWariateIinJoho(wariateIinJohoIdentifier);
            ShinsakaiWariateIinJohoBuilder shinsakaiWariateIinJohoBuilder
                    = shinsakaiWariateIinJoho.createBuilderForEdit();
            shinsakaiWariateIinJohoBuilder.set介護認定審査会議長区分コード(new Code(row.getGichoKubun().getSelectedKey()));
            shinsakaiWariateIinJohoBuilder.set介護認定審査会開催年月日(div.getTxtKaisaiBi().getValue());
            shinsakaiWariateIinJohoBuilder.set委員出席(Boolean.valueOf(row.getShukketsuKubun().getSelectedKey().toString()));
            shinsakaiWariateIinJohoBuilder.set委員出席時間(row.getShussekiTime());
            shinsakaiWariateIinJohoBuilder.set委員早退有無(Boolean.valueOf(row.getSotaiUmu().getSelectedKey().toString()));
            shinsakaiWariateIinJohoBuilder.set委員退席時間(row.getTaisekiTime());
            shinsakaiWariateIinJohoBuilder.set委員遅刻有無(Boolean.valueOf(row.getChikokuUmu().getSelectedKey().toString()));
            shinsakaiWariateIinJoho = shinsakaiWariateIinJohoBuilder.build();
            shinsakaiWariateIinJoho = shinsakaiWariateIinJoho.modifiedModel();
            ShinsakaiWariateIinJohoManager shinsakaiWariateIinJohoManager = ShinsakaiWariateIinJohoManager.createInstance();
            shinsakaiWariateIinJohoManager.save介護認定審査会割当委員情報(shinsakaiWariateIinJoho);
        }
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
