/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiKoseiShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiNinteichosa;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChosaChiku;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chikuninteichosain.ChosainJohoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.DBE2020002TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.NinteiChosaScheduleShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.dgNinteiChosaSchedule_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020002.NinteiChosaScheduleShosaiHander;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.chikuninteichosainmapper.ChosainJohoFander;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 認定調査スケジュール登録2クラスです。
 *
 * @reamsid_L DBE-0020-020 lishengli
 */
public class NinteiChosaScheduleShosai {

    private static final Code 選択された時間枠_1 = new Code("1");
    private static final Code 選択された時間枠_2 = new Code("2");
    private static final Code 選択された時間枠_3 = new Code("3");
    private static final Code 選択された時間枠_4 = new Code("4");
    private static final Code 選択された時間枠_5 = new Code("5");
    private static final Code 選択された時間枠_6 = new Code("6");
    private static final Code 選択された時間枠_7 = new Code("7");
    private static final Code 選択された時間枠_8 = new Code("8");
    private static final Code 選択された時間枠_9 = new Code("9");
    private static final Code 選択された時間枠_10 = new Code("10");
    private static final RString モード_1 = new RString("1");
    private static final RString 遷移元画面番号_2 = new RString("2");
    private static final RString 遷移元画面番号_10 = new RString("10");
    private static final int INT_0 = 0;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private FlexibleDate 設定日;
    private Code 地区コード;
    private LasdecCode 保険者;
    private RString 調査員状況;
    private RString 認定調査委託先コード;
    private RString モード;
    private RString 遷移元画面番号;

    /**
     * 認定調査スケジュール登録2初期化の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onLoad(NinteiChosaScheduleShosaiDiv div) {

        遷移元画面番号 = ViewStateHolder.get(ViewStateKeys.遷移元画面番号, RString.class);
        RString temp_地区コード = ViewStateHolder.get(ViewStateKeys.地区コード, RString.class);
        if (!RString.isNullOrEmpty(temp_地区コード)) {
            地区コード = new Code(temp_地区コード.toString());
        }
        設定日 = ViewStateHolder.get(ViewStateKeys.設定日, FlexibleDate.class);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        RString temp_保険者 = ViewStateHolder.get(ViewStateKeys.保険者, RString.class);
        if (!RString.isNullOrEmpty(temp_保険者)) {
            保険者 = new LasdecCode(temp_保険者.toString());
        }
        List<ChikuNinteiChosain> 認定調査スケジュールList = new ArrayList<>();
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        List<ChosaChiku> 対象地区List = get対象地区List(保険者);
        ChosainJohoParameter hokensyaParameter = ChosainJohoParameter.createParam_保険者名(地区コード);
        List<ChikuNinteiKoseiShichoson> 保険者List = ChosainJohoFander.createInstance().get保険者(hokensyaParameter).records();
        if (遷移元画面番号_10.equals(遷移元画面番号)) {
            調査員状況 = ViewStateHolder.get(ViewStateKeys.調査員状況02, RString.class);
            認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);
            ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査スケジュール詳細情報(
                    設定日, 調査員状況, 地区コード, 保険者, 認定調査委託先コード);
            認定調査スケジュールList = ChosainJohoFander.createInstance().get認定調査スケジュール詳細情報(parameter).records();
        }
        FlexibleDate viewState_設定日 = ViewStateHolder.get(ViewStateKeys.設定日, FlexibleDate.class);
        RString viewState_地区コード = ViewStateHolder.get(ViewStateKeys.地区コード, RString.class);
        getHandler(div).onLoad(通常件数, 重要件数, モード, 対象地区List,
                認定調査スケジュールList, 保険者List, viewState_設定日, viewState_地区コード);
        return ResponseData.of(div).respond();
    }

    private List<ChosaChiku> get対象地区List(LasdecCode 保険者) {
        List<ChosaChiku> get対象地区List = ChosainJohoFander.createInstance().get対象地区(保険者).records();
        for (ChosaChiku chosaChiku : get対象地区List) {
            UzT0007CodeEntity entity = CodeMaster.getCode(DBECodeShubetsu.調査地区コード.getコード(), new Code(chosaChiku.get調査地区コード()),
                    new FlexibleDate(RDate.getNowDate().toDateString()));
            if (entity != null) {
                chosaChiku.set調査地区名称(entity.getコード名称());
            } else {
                throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage());
            }
        }
        return get対象地区List;
    }

    /**
     * 認定調査スケジュール登録2の対象地区onselectの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_TayisyouTiku(NinteiChosaScheduleShosaiDiv div) {
        設定日 = ViewStateHolder.get(ViewStateKeys.設定日, FlexibleDate.class);
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        if (地区コード == null || 地区コード.isEmpty()) {
            return ResponseData.of(div).respond();
        }
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_保険者名(地区コード);
        List<ChikuNinteiKoseiShichoson> 保険者List = ChosainJohoFander.createInstance().get保険者(parameter).records();
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        getHandler(div).onselect_保険者名称取得(保険者List, 通常件数, 重要件数);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査スケジュール登録2の保険者onselectの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_Hokensya(NinteiChosaScheduleShosaiDiv div) {
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        LasdecCode 市町村コード = new LasdecCode(div.getDdlHokensha().getSelectedKey().toString());
        if (地区コード == null || 地区コード.isEmpty()
                || 市町村コード.isEmpty()) {
            return ResponseData.of(div).respond();
        }
        RString temp_保険者 = ViewStateHolder.get(ViewStateKeys.保険者, RString.class);
        if (!RString.isNullOrEmpty(temp_保険者)) {
            保険者 = new LasdecCode(temp_保険者.toString());
        }
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査委託先名称(地区コード, 市町村コード);
        List<ChikuNinteiNinteichosa> 認定調査委託先名List = ChosainJohoFander.createInstance().get認定調査委託先名称(parameter).records();
        List<ChosaChiku> 対象地区List = get対象地区List(保険者);
        getHandler(div).onSelect_Hokensya(対象地区List, 認定調査委託先名List, 地区コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査スケジュール登録2の検索するボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_BtnKensaku(NinteiChosaScheduleShosaiDiv div) {
        保険者 = new LasdecCode(div.getDdlHokensha().getSelectedKey());
        認定調査委託先コード = div.getDdlninteiChosaItakusaki().getSelectedKey();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (保険者 == null || 保険者.isEmpty() || 認定調査委託先コード == null || 認定調査委託先コード.isEmpty()) {
            getHandler(div).保険者選択されていないのチェック(validationMessages);
            getHandler(div).認定調査委託先選択されていないのチェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        調査員状況 = div.getRadChosainJokyo().getSelectedValue();
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査スケジュール詳細情報(設定日, 調査員状況, 地区コード, 保険者, 認定調査委託先コード);
        List<ChikuNinteiChosain> 認定調査スケジュールList = ChosainJohoFander.createInstance().get認定調査スケジュール詳細情報検索(parameter).records();
        if (認定調査スケジュールList == null || 認定調査スケジュールList.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrInformationMessages.該当データなし.getMessage().getCode(),
                        UrInformationMessages.該当データなし.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrInformationMessages.該当データなし.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getNchosainScheduleIchiran().setIsOpen(false);
                return ResponseData.of(div).respond();
            } else {
                div.getNchosainScheduleIchiran().setIsOpen(false);
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).set認定調査スケジュール詳細情報(認定調査スケジュールList);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査スケジュール登録2の前日へボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnZenji(NinteiChosaScheduleShosaiDiv div) {
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        設定日 = 設定日.minusDay(1);
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        getHandler(div).onSelect前日(設定日, 通常件数, 重要件数);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査スケジュール登録2の次日へボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnTugihi(NinteiChosaScheduleShosaiDiv div) {
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        設定日 = 設定日.plusDay(1);
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(設定日, 地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        getHandler(div).onSelect次日(設定日, 通常件数, 重要件数);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査スケジュール登録2のメモを表示するボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnMemoHyouji(NinteiChosaScheduleShosaiDiv div) {
        設定日 = div.getTxtSetteiDate().getValue();
        ViewStateHolder.put(ViewStateKeys.地区コード, div.getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.設定日, 設定日);
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.メモ入力).respond();
    }

    /**
     * 認定調査スケジュール登録2の戻るボタンの処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onSelect_BtnModoRu(NinteiChosaScheduleShosaiDiv div) {
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール一覧に戻る).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_該当者一覧に戻る).respond();
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン1の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo1(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame1();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_1, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン2の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo2(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame2();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_2, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン3の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo3(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame3();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_3, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン4の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo4(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame4();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_4, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン5の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo5(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame5();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_5, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン6の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo6(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame6();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_6, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン7の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo7(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame7();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_7, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン8の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo8(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame8();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_8, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン9の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo9(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame9();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_9, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    /**
     * 認定調査スケジュール登録2の編集ボタン10の処理です。
     *
     * @param div NinteiChosaScheduleShosaiDiv
     * @return ResponseData<NinteiChosaScheduleShosaiDiv>
     */
    public ResponseData<NinteiChosaScheduleShosaiDiv> onClick_selectMemo10(NinteiChosaScheduleShosaiDiv div) {

        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        RString 認定調査予定時間 = row.getChosaTimeFrame10();
        onClick_selectHansyou(div, 認定調査予定時間, 認定調査員コード, 選択された時間枠_10, row);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        if (モード_1.equals(モード)) {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.更新モード_スケジュール入力).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE2020002TransitionEventName.未定モード_スケジュール入力).respond();
        }
    }

    private RString 時間の処理(RString 時間) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(時間.split(":").get(0))
                .append(時間.split(":").get(1)).toRString();
    }

    private void onClick_selectHansyou(NinteiChosaScheduleShosaiDiv div,
            RString 認定調査予定時間,
            RString 認定調査員コード,
            Code 選択された時間枠,
            dgNinteiChosaSchedule_Row row) {
        地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        保険者 = new LasdecCode(div.getDdlHokensha().getSelectedKey());
        認定調査委託先コード = div.getDdlninteiChosaItakusaki().getSelectedKey();
        設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        RString 認定調査予定開始時間 = new RString("");
        RString 認定調査予定終了時間 = new RString("");
        if (認定調査予定時間 != null && !認定調査予定時間.isEmpty()) {
            認定調査予定開始時間 = 時間の処理(認定調査予定時間.substring(INT_0, INT_5));
            認定調査予定終了時間 = 時間の処理(認定調査予定時間.substring(INT_6));
        }
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_申請書管理番号(
                設定日,
                地区コード,
                保険者,
                認定調査委託先コード,
                認定調査員コード,
                認定調査予定開始時間,
                認定調査予定終了時間,
                選択された時間枠);
        NinteichosaSchedule 申請書管理番号 = ChosainJohoFander.createInstance().get申請書管理番号(parameter);
        if (申請書管理番号 == null) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号2, RString.EMPTY);
        } else {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号2, 申請書管理番号.get申請書管理番号().value());
        }
        ViewStateHolder.put(ViewStateKeys.地区コード, 地区コード.value());
        ViewStateHolder.put(ViewStateKeys.設定日, 設定日);
        ViewStateHolder.put(ViewStateKeys.保険者, 保険者.value());
        ViewStateHolder.put(ViewStateKeys.調査員状況02, row.getYoyakuJokyo());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, 認定調査委託先コード);
        ViewStateHolder.put(ViewStateKeys.時間枠, 選択された時間枠.value());
        ViewStateHolder.put(ViewStateKeys.認定調査員コード, 認定調査員コード);
        ViewStateHolder.put(ViewStateKeys.予約可否, row.getYoyakuKahi());
        ViewStateHolder.put(ViewStateKeys.予約状況, row.getYoyakuJokyo());
        ViewStateHolder.put(ViewStateKeys.市町村コード, row.getShichosonCode());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_モード, モード);
        ViewStateHolder.put(ViewStateKeys.画面番号, 遷移元画面番号_2);

        ViewStateHolder.put(ViewStateKeys.対象者区分, ViewStateHolder.get(ViewStateKeys.対象者区分, RString.class));
        RString 申請書管理番号3 = ViewStateHolder.get(ViewStateKeys.申請書管理番号3, RString.class);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号3, 申請書管理番号3);
    }

    private NinteiChosaScheduleShosaiHander getHandler(NinteiChosaScheduleShosaiDiv div) {
        return new NinteiChosaScheduleShosaiHander(div);
    }
}
