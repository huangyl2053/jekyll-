/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5140001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiKaisaiYoteiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiKaisaiYoteiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohoshinsakai.GogitaiJohoShinsaRelateBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe5140001.ShinsakaiKaisaiYoteiJohoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001.ShinsakaiKaisaiYoteiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001.dgKaisaiYoteiNyuryokuran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001.dgShinsakaiKaisaiGogitaiJoho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001.dgShinsakaiKaisaiYoteiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140001.ShinsakaiKaisaiYoteiTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikaisaiyoteitoroku.ShinsakaiKaisaiYoteiTorokuManager;
import jp.co.ndensan.reams.db.dbe.service.shinsakai.GogitaiManager;
import jp.co.ndensan.reams.db.dbe.service.shinsakai.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.HolidayAccessor;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.entities.UzV0002HolidayListEntity;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護認定審査会開催予定登録1のコントローラです。
 */
public class ShinsakaiKaisaiYoteiToroku {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final RString MARU = new RString("○○");
    private static final RString 審査会名称 = new RString("第○○審査会");
    private static final RString 汎用キー = new RString("審査会開催番号");
    private static final RString NENNDO = new RString("年");
    private static final RString GETSU = new RString("月");
    private static final RString 分割 = new RString("-");
    private static final RString FUNN = new RString(":");
    private static final RString 中止 = new RString("2");
    private static final RString BREAK = new RString("<br/>");
    private static final RString 種類 = new RString("精");
    private static final RString FONT_RED_ZEN = new RString("<font color='#FF0000'>");
    private static final RString FONT_RED_GO = new RString("</font>");
    private static final int 月_12 = 12;
    private static final RString モード_月 = new RString("月切");
    private static final RString モード_初期化 = new RString("初期化");
    private static final QuestionMessage HAKIMESSAGE = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());
    private static final WarningMessage 操作可否 = new WarningMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode(),
            UrWarningMessages.未保存情報の破棄確認.getMessage().replace("審議会開催予定").evaluate());
    private final ShinsakaiKaisaiYoteiJohoManager yoteiJohoManager;
    private final GogitaiManager gogitaiManager;
//    private final MonthlyShinsakaiKaisaiYoteiJoho monthYoteJoho;
    private final ShinsakaiKaisaiYoteiTorokuManager yoteiTorokuManager;
    private static List<RString> 時間枠;
    private static List<ShinsakaiKaisaiYoteiJohoParameter> yoteiJohoEntityList = new ArrayList<>();
    private static List<ShinsakaiKaisaiYoteiJohoParameter> yoteiJohoEntityList2 = new ArrayList<>();
    private ShinsakaiKaisaiYoteiTorokuDiv div;
    private RString モード = RString.EMPTY;
    private RDate date;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiYoteiToroku() {
        this.yoteiJohoManager = InstanceProvider.create(ShinsakaiKaisaiYoteiJohoManager.class);
        this.gogitaiManager = InstanceProvider.create(GogitaiManager.class);
//        this.monthYoteJoho = InstanceProvider.create(MonthlyShinsakaiKaisaiYoteiJoho.class);
        this.yoteiTorokuManager = InstanceProvider.create(ShinsakaiKaisaiYoteiTorokuManager.class);
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onLoad(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        init();
        return ResponseData.of(div).respond();
    }

    /**
     * 前月へ　ボタン。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_MonthBefore(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        date = RDate.getNowDate();
        if (!ResponseHolder.isReRequest()) {
            if (!is保存()) {
                return ResponseData.of(div).addMessage(HAKIMESSAGE).respond();
            } else {
                setMonthBefore();
            }
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setMonthBefore();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 次月へ　ボタン。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_MonthAfter(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        date = RDate.getNowDate();
        if (!ResponseHolder.isReRequest()) {
            if (!is保存()) {
                return ResponseData.of(div).addMessage(HAKIMESSAGE).respond();
            } else {
                setMonthAfter();
            }
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setMonthAfter();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催予定一覧Gridの「選択」ボタン。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_OnSelect(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        if (!ResponseHolder.isReRequest()) {
            if (isKoshin(div.getDgKaisaiYoteiNyuryokuran().getDataSource())) {
                return ResponseData.of(div).addMessage(HAKIMESSAGE).respond();
            } else {
                setOnselect();
            }
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setOnselect();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 前日へ　ボタン。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_DayBefore(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        if (div.getTxtSeteibi().getValue() == null) {
            return ResponseData.of(div).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            if (isKoshin(div.getDgKaisaiYoteiNyuryokuran().getDataSource())) {
                return ResponseData.of(div).addMessage(HAKIMESSAGE).respond();
            } else {
                setDayBefore();
            }
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setDayBefore();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 次日へ　ボタン。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_DayAfter(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        if (div.getTxtSeteibi().getValue() == null) {
            return ResponseData.of(div).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            if (isKoshin(div.getDgKaisaiYoteiNyuryokuran().getDataSource())) {
                return ResponseData.of(div).addMessage(HAKIMESSAGE).respond();
            } else {
                setDayAfter();
            }
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setDayAfter();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「中止」ボタン1。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnCencel1(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler = new ShinsakaiKaisaiYoteiTorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = validationHandler.予定進捗状況チェック(INDEX_1, yoteiJohoEntityList2);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        set中止(div.getDgKaisaiYoteiNyuryokuran().getActiveRow().getKaisaiGogitai1());
        return ResponseData.of(div).respond();
    }

    /**
     * 「中止」ボタン2。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnCencel2(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler = new ShinsakaiKaisaiYoteiTorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = validationHandler.予定進捗状況チェック(INDEX_2, yoteiJohoEntityList2);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        set中止(div.getDgKaisaiYoteiNyuryokuran().getActiveRow().getKaisaiGogitai2());
        return ResponseData.of(div).respond();
    }

    /**
     * 「中止」ボタン3。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnCencel3(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler = new ShinsakaiKaisaiYoteiTorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = validationHandler.予定進捗状況チェック(INDEX_3, yoteiJohoEntityList2);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        set中止(div.getDgKaisaiYoteiNyuryokuran().getActiveRow().getKaisaiGogitai3());
        return ResponseData.of(div).respond();
    }

    /**
     * 「中止」ボタン4。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnCencel4(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler = new ShinsakaiKaisaiYoteiTorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = validationHandler.予定進捗状況チェック(INDEX_4, yoteiJohoEntityList2);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        set中止(div.getDgKaisaiYoteiNyuryokuran().getActiveRow().getKaisaiGogitai4());
        return ResponseData.of(div).respond();
    }

    /**
     * 「「開催予定詳細をクリアする」ボタン。<br/>
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnClear(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        List<ShinsakaiKaisaiYoteiJohoParameter> removeList = new ArrayList<>();
        for (ShinsakaiKaisaiYoteiJohoParameter entity2 : yoteiJohoEntityList2) {
            if (!entity2.is存在()) {
                removeList.add(entity2);
            } else {
                setClear(entity2);
            }
        }
        yoteiJohoEntityList2.removeAll(removeList);
        set介護認定審査会開催予定一覧(div.getTxtSeteibi().getValue().getYearMonth().toDateString());
        clear入力();
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会開催予定を登録する」ボタン<br/>。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnToroku(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler = new ShinsakaiKaisaiYoteiTorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = getTorokuCheck(validationHandler);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        setToroku();
        set介護認定審査会開催予定一覧(getLblMonth(div.getLblMonth().getText()));
        clear入力();
        return ResponseData.of(div).respond();
    }

    /**
     * 「週コピーする」ボタン<br/>。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnWeekCopy(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler = new ShinsakaiKaisaiYoteiTorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = getWeekCopyCheck(validationHandler);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
//        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
//                .equals(ResponseHolder.getMessageCode())
//                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//            //TODO 待確認
//        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「開催番号を付番する」ボタン<br/>。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnKaisaiBangoFuban(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        set番号();
        set介護認定審査会開催予定一覧(getLblMonth(div.getLblMonth().getText()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員を割付する」ボタン<br/>。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_BtnShinsakaiIinWaritsuke(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler = new ShinsakaiKaisaiYoteiTorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = get審査会委員割付Check(validationHandler);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return get操作可否();
        }
        if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「スケジュール表を発行する」ボタン<br/>。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_Hako(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        if (!ResponseHolder.isReRequest()) {
            return get操作可否();
        }
        if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン<br/>。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     * @return　ResponseData<ShinsakaiKaisaiYoteiTorokuDiv>
     */
    public ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> onClick_Hozon(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            //TODO 前排他制御
            set番号();
            Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> models
                    = ViewStateHolder.get(ViewStateKeys.介護認定審査会開催予定情報, Models.class);
            for (ShinsakaiKaisaiYoteiJohoParameter parameter : yoteiJohoEntityList2) {
                if (!parameter.is存在()) {
                    ShinsakaiKaisaiYoteiJoho yoteiJoho = new ShinsakaiKaisaiYoteiJoho(parameter.get開催番号().trim());
                    ShinsakaiKaisaiYoteiJohoBuilder builder = yoteiJoho.createBuilderForEdit();
                    builder.set介護認定審査会予定定員(parameter.get予定定員());
                    builder.set介護認定審査会進捗状況(new Code(parameter.get介護認定審査会進捗状況()));
                    builder.set介護認定審査会開催予定場所コード(parameter.get催予定場所コード());
                    builder.set合議体番号(parameter.get合議体番号());
                    builder.set介護認定審査会委員定員(parameter.get委員定員());
                    builder.set介護認定審査会開催予定年月日(parameter.get日付());
                    builder.set介護認定審査会終了予定時刻(parameter.get終了予定時刻());
                    builder.set介護認定審査会自動割当定員(parameter.get自動割当定員());
                    builder.set介護認定審査会開催番号(parameter.get開催番号());
                    builder.set介護認定審査会開始予定時刻(parameter.get開始予定時刻());
                    builder.set介護認定審査会資料作成年月日(FlexibleDate.EMPTY);
                    builder.set介護認定審査会割当済み人数(INDEX_0);
                    builder.set資料作成済フラグ(false);
                    builder.setモバイルデータ出力年月日(FlexibleDate.EMPTY);
                    yoteiJoho.toEntity().setState(EntityDataState.Added);
                    yoteiTorokuManager.insertOrUpdate(builder.build());
                } else if (parameter.is存在() && parameter.is変更()) {
                    ShinsakaiKaisaiYoteiJohoIdentifier key = new ShinsakaiKaisaiYoteiJohoIdentifier(parameter.get開催番号().trim());
                    ShinsakaiKaisaiYoteiJoho yoteiJoho = models.get(key);
                    ShinsakaiKaisaiYoteiJohoBuilder builder = yoteiJoho.createBuilderForEdit();
                    builder.set介護認定審査会進捗状況(new Code(中止));
                    yoteiJoho.toEntity().setState(EntityDataState.Modified);
                    yoteiTorokuManager.insertOrUpdate(builder.build());
                }
            }
        }
        init();
        return ResponseData.of(div).respond();
    }

    private void setClear(ShinsakaiKaisaiYoteiJohoParameter entity2) {
        for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList) {
            if (entity.get開催番号().equals(entity2.get開催番号())) {
                entity2.set介護認定審査会進捗状況(entity.get介護認定審査会進捗状況());
                entity2.set変更(false);
                break;
            }
        }
    }

    private ResponseData<ShinsakaiKaisaiYoteiTorokuDiv> get操作可否() {
        int count = 0;
        for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList2) {
            if (entity.is変更() || !entity.is存在()) {
                count++;
            }
        }
        if (count != 0) {
            return ResponseData.of(div).addMessage(操作可否).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private void clear入力() {
        div.getTxtSeteibi().setValue(null);
        List<dgKaisaiYoteiNyuryokuran_Row> rowList = div.getDgKaisaiYoteiNyuryokuran().getDataSource();
        for (dgKaisaiYoteiNyuryokuran_Row row : rowList) {
            row.getKaisaiGogitai1().setValue(RString.EMPTY);
            row.getKaisaiGogitai2().setValue(RString.EMPTY);
            row.getKaisaiGogitai3().setValue(RString.EMPTY);
            row.getKaisaiGogitai4().setValue(RString.EMPTY);
            row.getKaisaiGogitai1().setDisabled(true);
            row.getKaisaiGogitai2().setDisabled(true);
            row.getKaisaiGogitai3().setDisabled(true);
            row.getKaisaiGogitai4().setDisabled(true);
            row.getBtnCencel1().setDisabled(true);
            row.getBtnCencel().setDisabled(true);
            row.getBtnCencel3().setDisabled(true);
            row.getBtnCencel4().setDisabled(true);
        }
        div.getDgKaisaiYoteiNyuryokuran().setDataSource(rowList);
    }

    private void set番号() {
        List<ShinsakaiKaisaiYoteiJohoParameter> shinkiList = new ArrayList<>();
        for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList2) {
            if (!entity.is存在() && 審査会名称.equals(entity.get審査会名称())) {
                shinkiList.add(entity);
            }
        }
        if (!shinkiList.isEmpty()) {
            Collections.sort(shinkiList, new Comparator<ShinsakaiKaisaiYoteiJohoParameter>() {
                @Override
                public int compare(ShinsakaiKaisaiYoteiJohoParameter entity1, ShinsakaiKaisaiYoteiJohoParameter entity2) {
                    return entity1.get日付().compareTo(entity2.get日付());
                }
            });
            for (ShinsakaiKaisaiYoteiJohoParameter entity : shinkiList) {
                RString 開催番号 = Saiban.get(SubGyomuCode.DBE認定支援, 汎用キー).nextString();
                entity.set開催番号(開催番号);
                entity.set審査会名称(entity.get審査会名称().replace(MARU, 開催番号));
            }
            for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList2) {
                set内部番号(shinkiList, entity);
            }
        }
    }

    private void set内部番号(List<ShinsakaiKaisaiYoteiJohoParameter> shinkiList, ShinsakaiKaisaiYoteiJohoParameter entity) {
        for (ShinsakaiKaisaiYoteiJohoParameter shinkiEntity : shinkiList) {
            if (entity.get日付().equals(shinkiEntity.get日付()) && entity.get開始予定時刻().equals(shinkiEntity.get開始予定時刻())
                    && entity.get終了予定時刻().equals(shinkiEntity.get終了予定時刻())) {
                entity.set開催番号(shinkiEntity.get開催番号());
                entity.set審査会名称(shinkiEntity.get審査会名称());
            }
        }
    }

    private boolean isKoshin(List<dgKaisaiYoteiNyuryokuran_Row> nyuryokuranRowList) {
        for (dgKaisaiYoteiNyuryokuran_Row dgNyuryokuRow : nyuryokuranRowList) {
            if ((!dgNyuryokuRow.getKaisaiGogitai1().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai1().getValue().isEmpty())
                    || (!dgNyuryokuRow.getKaisaiGogitai2().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai2().getValue().isEmpty())
                    || (!dgNyuryokuRow.getKaisaiGogitai3().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai3().getValue().isEmpty())
                    || (!dgNyuryokuRow.getKaisaiGogitai4().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai4().getValue().isEmpty())) {
                return true;
            }
        }
        return false;
    }

    private boolean is保存() {
        for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList2) {
            if (!entity.is存在() || entity.is変更()) {
                return false;
            }
        }
        return true;
    }

    private RString getLblMonth(RString formatMonth) {
        return formatMonth.replace(NENNDO, RString.EMPTY).replace(GETSU, RString.EMPTY);
    }

    private RString setLblMonth(RYearMonth month) {
        return month.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString setLblMonth(FlexibleYearMonth month) {
        return month.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private ValidationMessageControlPairs getTorokuCheck(ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler) {
        ValidationMessageControlPairs validPairs = validationHandler.保存可否Check();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.合議体存在Check();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.合議体重複チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.設定日未選択チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.審査会の1日最大登録件数チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        return validPairs;
    }

    private void setToroku() {
        FlexibleDate setibi = new FlexibleDate(div.getTxtSeteibi().getValue().toDateString());
        List<ShinsakaiKaisaiYoteiJohoParameter> removeEntity = new ArrayList<>();
        for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList2) {
            if (setibi.equals(entity.get日付()) && !entity.is存在()) {
                removeEntity.add(entity);
            }
        }
        yoteiJohoEntityList2.removeAll(removeEntity);
        List<dgKaisaiYoteiNyuryokuran_Row> nyuryokuranRowList = div.getDgKaisaiYoteiNyuryokuran().getDataSource();
        for (dgKaisaiYoteiNyuryokuran_Row row : nyuryokuranRowList) {
            if (!row.getKaisaiGogitai1().getValue().isEmpty() && !row.getKaisaiGogitai1().isDisabled()) {
                内部AddEntity(row, Integer.valueOf(row.getKaisaiGogitai1().getValue().toString()));
            }
            if (!row.getKaisaiGogitai2().getValue().isEmpty() && !row.getKaisaiGogitai2().isDisabled()) {
                内部AddEntity(row, Integer.valueOf(row.getKaisaiGogitai2().getValue().toString()));
            }
            if (!row.getKaisaiGogitai3().getValue().isEmpty() && !row.getKaisaiGogitai3().isDisabled()) {
                内部AddEntity(row, Integer.valueOf(row.getKaisaiGogitai3().getValue().toString()));
            }
            if (!row.getKaisaiGogitai4().getValue().isEmpty() && !row.getKaisaiGogitai4().isDisabled()) {
                内部AddEntity(row, Integer.valueOf(row.getKaisaiGogitai4().getValue().toString()));
            }
        }
    }

    private void 内部AddEntity(dgKaisaiYoteiNyuryokuran_Row row, int 合議体番号) {
        RString 開始時間 = row.getKaisaiTime().getValue().split(分割.toString()).get(0).replace(FUNN, RString.EMPTY);
        RString 終了時間 = row.getKaisaiTime().getValue().split(分割.toString()).get(1).replace(FUNN, RString.EMPTY);
        ShinsakaiKaisaiYoteiJohoBusiness yoteiJohoBusiness = yoteiJohoManager.save開催予定情報(
                div.getTxtSeteibi().getValue().toDateString(),
                開始時間, 終了時間, 合議体番号);
        ShinsakaiKaisaiYoteiJohoParameter entity = new ShinsakaiKaisaiYoteiJohoParameter();
        entity.set予定定員(yoteiJohoBusiness.get予定定員());
        entity.set介護認定審査会進捗状況(yoteiJohoBusiness.get介護認定審査会進捗状況());
        entity.set合議体番号(yoteiJohoBusiness.get合議体番号());
        entity.set委員定員(yoteiJohoBusiness.get委員定員());
        entity.set開始予定時刻(yoteiJohoBusiness.get予定開始時間());
        entity.set終了予定時刻(yoteiJohoBusiness.get予定終了時間());
        entity.set日付(yoteiJohoBusiness.get開催予定日());
        entity.set自動割当定員(yoteiJohoBusiness.get自動割当定員());
        entity.set催予定場所コード(yoteiJohoBusiness.get催予定場所コード() == null ? RString.EMPTY : yoteiJohoBusiness.get催予定場所コード());
        entity.set開催番号(yoteiJohoBusiness.get開催番号());
        entity.set審査会名称(yoteiJohoBusiness.get審査会名称());
        yoteiJohoEntityList2.add(entity);
    }

    private ValidationMessageControlPairs getWeekCopyCheck(ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler) {
        ValidationMessageControlPairs validPairs = validationHandler.週コピーから日チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.週コピー開始日チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.週コピー開始日以降予定チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        return validPairs;
    }

    private ValidationMessageControlPairs get審査会委員割付Check(ShinsakaiKaisaiYoteiTorokuValidationHandler validationHandler) {
        ValidationMessageControlPairs validPairs = validationHandler.合議体未選択チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.審査会番号付番チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.割付可能チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        return validPairs;
    }

    private void init() {
        date = RDate.getNowDate();
        RString 年月 = date.getYearMonth().toDateString();
        div.getLblMonth().setText(setLblMonth(date.getYearMonth()));
        モード = モード_初期化;
        set介護認定審査会開催予定一覧(年月);
        SearchResult<GogitaiJohoShinsaRelateBusiness> gogitaiBusinessList = gogitaiManager.get合議体情報();
        set合議体情報(gogitaiBusinessList);
        div.getTxtSeteibi().setValue(date);
        if (date.getDayValue() == 1) {
            div.getBtnDayBefore().setDisabled(true);
        }
        if (date.getDayValue() == date.getLastDay()) {
            div.getBtnDayAfter().setDisabled(true);
        }
        div.getTxtSeteibi().setDisabled(true);
        set開催予定入力欄(date.toDateString());
    }

    private void setMonthBefore() {
        Seireki date1 = new FlexibleDate(getLblMonth(div.getLblMonth().getText())).seireki();
        FlexibleDate date2;
        if (Integer.parseInt(date1.getMonth().toString()) == 1) {
            date2 = new FlexibleDate(Integer.parseInt(date1.getYear().toString()) - 1, 月_12, 1);
        } else {
            date2 = new FlexibleDate(Integer.parseInt(date1.getYear().toString()), Integer.parseInt(date1.getMonth().toString()) - 1, 1);
        }
        div.getLblMonth().setText(setLblMonth(date2.getYearMonth()));
        モード = モード_月;
        set介護認定審査会開催予定一覧(date2.getYearMonth().toDateString());
        clear入力();
    }

    private void setMonthAfter() {
        Seireki date1 = new FlexibleDate(getLblMonth(div.getLblMonth().getText())).seireki();
        FlexibleDate date2;
        if (Integer.parseInt(date1.getMonth().toString()) == 1) {
            date2 = new FlexibleDate(Integer.parseInt(date1.getYear().toString()) + 1, 1, 1);
        } else {
            date2 = new FlexibleDate(Integer.parseInt(date1.getYear().toString()), Integer.parseInt(date1.getMonth().toString()) + 1, 1);
        }
        div.getLblMonth().setText(setLblMonth(date2.getYearMonth()));
        モード = モード_月;
        set介護認定審査会開催予定一覧(date2.getYearMonth().toDateString());
        clear入力();
    }

    private void setOnselect() {
        div.getDgShinsakaiKaisaiYoteiIchiran().getGridSetting().selectedRowCount();
        dgShinsakaiKaisaiYoteiIchiran_Row dgYoteiRow = div.getDgShinsakaiKaisaiYoteiIchiran().getSelectedItems().get(0);
        FlexibleDate seteibi = new FlexibleDate(getLblMonth(div.getLblMonth().getText()));
        RDate setibichi = new RDate(seteibi.getYearValue(), seteibi.getMonthValue(), Integer.valueOf(dgYoteiRow.getKaisaiYoteibi().toString()));
        div.getTxtSeteibi().setValue(setibichi);
        set開催予定入力欄(setibichi.toDateString());
    }

    private void set中止(TextBox kaisaiGogitai) {
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RString 開催時間 = getFormat時間枠(div.getDgKaisaiYoteiNyuryokuran().getActiveRow().getKaisaiTime().getValue());
            RString 開催合議体 = new RString(kaisaiGogitai.getValue().toString());
            set内部中止(開催時間, 開催合議体);
            set介護認定審査会開催予定一覧(div.getTxtSeteibi().getValue().getYearMonth().toDateString());
        }
    }

    private void set内部中止(RString 開催時間, RString 開催合議体) {
        for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList2) {
            if (new RString(entity.get日付().toString()).equals(div.getTxtSeteibi().getValue().toDateString())
                    && get検索時間枠(entity.get開始予定時刻(), entity.get終了予定時刻()).equals(開催時間)
                    && entity.get合議体番号() == Integer.valueOf(開催合議体.toString())) {
                entity.set介護認定審査会進捗状況(中止);
                entity.set変更(true);
                break;
            }
        }
    }

    private void set介護認定審査会開催予定一覧(RString 年月) {
        List<dgShinsakaiKaisaiYoteiIchiran_Row> dgShinsakaRowList = new ArrayList<>();
        getConfig時間枠();
        FlexibleDate zenbuDate = new FlexibleDate(Integer.parseInt(年月.substring(0, 4).toString()), Integer.parseInt(年月.substring(4).toString()), 1);
        List<UzV0002HolidayListEntity> holiDay = HolidayAccessor.getHolidayList();
        int dayCount = zenbuDate.getLastDay();
        if (モード.equals(モード_月) || モード.equals(モード_初期化)) {
            yoteiJohoEntityList = new ArrayList<>();
            yoteiJohoEntityList2 = new ArrayList<>();
            SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> yoteiJohoGetsuBusinessList = yoteiJohoManager.search審査会開催予定情報Of指定月(年月);
            List<ShinsakaiKaisaiYoteiJoho> yoteiJoho = yoteiTorokuManager.get介護認定審査会開催予定情報(年月).records();
            Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> chikuNinteiChosain = Models.create(yoteiJoho);
            ViewStateHolder.put(ViewStateKeys.介護認定審査会開催予定情報, chikuNinteiChosain);
            for (ShinsakaiKaisaiYoteiJohoBusiness business : yoteiJohoGetsuBusinessList.records()) {
                ShinsakaiKaisaiYoteiJohoParameter entity = new ShinsakaiKaisaiYoteiJohoParameter();
                entity.set開催番号(business.get開催番号());
                entity.set日付(business.get開催予定日());
                entity.set開始予定時刻(business.get予定開始時間());
                entity.set終了予定時刻(business.get予定終了時間());
                entity.set介護認定審査会進捗状況(business.get介護認定審査会進捗状況());
                entity.set合議体番号(business.get合議体番号());
                entity.set審査会名称(business.get審査会名称());
                entity.set存在(true);
                yoteiJohoEntityList.add(entity);
                ShinsakaiKaisaiYoteiJohoParameter 内部entity = new ShinsakaiKaisaiYoteiJohoParameter();
                内部entity.set予定定員(entity.get予定定員());
                内部entity.set介護認定審査会進捗状況(entity.get介護認定審査会進捗状況());
                内部entity.set催予定場所コード(entity.get催予定場所コード());
                内部entity.set合議体番号(entity.get合議体番号());
                内部entity.set委員定員(entity.get委員定員());
                内部entity.set存在(entity.is存在());
                内部entity.set審査会名称(entity.get審査会名称());
                内部entity.set日付(entity.get日付());
                内部entity.set終了予定時刻(entity.get終了予定時刻());
                内部entity.set自動割当定員(entity.get自動割当定員());
                内部entity.set開催番号(entity.get開催番号());
                内部entity.set開始予定時刻(entity.get開始予定時刻());
                yoteiJohoEntityList2.add(内部entity);
            }
            for (int i = 0; i < dayCount; i++) {
                dgShinsakaiKaisaiYoteiIchiran_Row dgShinsakaRow = new dgShinsakaiKaisaiYoteiIchiran_Row();
                dgShinsakaRow.setKaisaiYoteibi(new RString(String.valueOf(i + 1)));
                dgShinsakaRow.setKaisaiYoteiYobi(new RString(zenbuDate.getDayOfWeek().getShortTerm()));
                setHoliday(zenbuDate, holiDay, dgShinsakaRow);
                set審査会名称用(yoteiJohoGetsuBusinessList, zenbuDate, dgShinsakaRow);
                setSelected(zenbuDate, dgShinsakaRow);
                dgShinsakaRowList.add(dgShinsakaRow);
                zenbuDate = zenbuDate.plusDay(1);
            }
        } else {
            for (int i = 0; i < dayCount; i++) {
                dgShinsakaiKaisaiYoteiIchiran_Row dgShinsakaRow = new dgShinsakaiKaisaiYoteiIchiran_Row();
                dgShinsakaRow.setKaisaiYoteibi(new RString(String.valueOf(i + 1)));
                setHoliday(zenbuDate, holiDay, dgShinsakaRow);
                set内部審査会名称用(dgShinsakaRow, zenbuDate);
                dgShinsakaRowList.add(dgShinsakaRow);
                zenbuDate = zenbuDate.plusDay(1);
            }
        }
        div.getDgShinsakaiKaisaiYoteiIchiran().setDataSource(dgShinsakaRowList);
    }

    private void setSelected(FlexibleDate zenbuDate, dgShinsakaiKaisaiYoteiIchiran_Row dgShinsakaRow) {
        if (モード.equals(モード_初期化) && date.toDateString().equals(new RString(zenbuDate.toString()))) {
            dgShinsakaRow.setSelected(true);
        } else {
            dgShinsakaRow.setSelected(false);
        }
    }

    private void set審査会名称用(SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> yoteiJohoGetsuBusinessList,
            FlexibleDate zenbuDate, dgShinsakaiKaisaiYoteiIchiran_Row dgShinsakaRow) {
        RString juKo = RString.EMPTY;
        RStringBuilder 審査会名称作成 = new RStringBuilder();
        int index = -1;
        RStringBuilder juKoyo = new RStringBuilder();
        for (ShinsakaiKaisaiYoteiJohoBusiness business : yoteiJohoGetsuBusinessList.records()) {
            if (juKo.equals(juKoyo.append(new RString(business.get開催予定日().toString())).append(
                    business.get予定開始時間()).append(business.get予定終了時間()).toRString())) {
                setBreak(審査会名称作成, business.get介護認定審査会進捗状況(), business.get審査会名称());
            } else {
                set審査会名称(dgShinsakaRow, index, 審査会名称作成.toRString());
                index = -1;
                審査会名称作成 = new RStringBuilder();
                index = set審査会名称作成(zenbuDate, 審査会名称作成, business, index);
                juKo = juKoyo.toRString();
            }
            juKoyo = new RStringBuilder();
            set審査会名称(dgShinsakaRow, index, 審査会名称作成.toRString());
        }
    }

    private void set内部審査会名称用(dgShinsakaiKaisaiYoteiIchiran_Row dgShinsakaRow, FlexibleDate zenbuDate) {
        RString juKo = RString.EMPTY;
        RStringBuilder 審査会名称作成 = new RStringBuilder();
        int index = -1;
        RStringBuilder juKoyo = new RStringBuilder();
        for (ShinsakaiKaisaiYoteiJohoParameter entity : yoteiJohoEntityList2) {
            if (juKo.equals(juKoyo.append(entity.get日付().toString()).append(
                    entity.get開始予定時刻()).append(entity.get終了予定時刻()).toRString())) {
                setBreak(審査会名称作成, entity.get介護認定審査会進捗状況(), entity.get審査会名称());
            } else {
                set審査会名称(dgShinsakaRow, index, 審査会名称作成.toRString());
                index = -1;
                審査会名称作成 = new RStringBuilder();
                index = set審査会名称作成(zenbuDate, 審査会名称作成, entity, index);
                juKo = juKoyo.toRString();
            }
            juKoyo = new RStringBuilder();
            set審査会名称(dgShinsakaRow, index, 審査会名称作成.toRString());
        }
    }

    private void setBreak(RStringBuilder 審査会名称作成, RString 進捗状況, RString 審査会名称) {
        if (中止.equals(進捗状況)) {
            審査会名称作成.append(BREAK).append(FONT_RED_ZEN).append(審査会名称).append(FONT_RED_GO);
        } else {
            審査会名称作成.append(BREAK).append(審査会名称);
        }
    }

    private int set審査会名称作成(FlexibleDate zenbuDate, RStringBuilder 審査会名称作成, ShinsakaiKaisaiYoteiJohoBusiness business, int index) {
        for (int j = 0; j < 時間枠.size(); j++) {
            if (zenbuDate.equals(business.get開催予定日()) && 時間枠.get(j).equals(
                    get検索時間枠(business.get予定開始時間(), business.get予定終了時間()))) {
                set審査会一番(審査会名称作成, business.get介護認定審査会進捗状況(), business.get審査会名称());
                index = j;
                break;
            }
        }
        return index;
    }

    private int set審査会名称作成(FlexibleDate zenbuDate, RStringBuilder 審査会名称作成, ShinsakaiKaisaiYoteiJohoParameter entity, int index) {
        for (int j = 0; j < 時間枠.size(); j++) {
            if (zenbuDate.equals(entity.get日付()) && 時間枠.get(j).equals(
                    get検索時間枠(entity.get開始予定時刻(), entity.get終了予定時刻()))) {
                set審査会一番(審査会名称作成, entity.get介護認定審査会進捗状況(), entity.get審査会名称());
                index = j;
                break;
            }
        }
        return index;
    }

    private void set審査会一番(RStringBuilder 審査会名称作成, RString 進捗状況, RString 審査会名称) {
        if (中止.equals(進捗状況)) {
            審査会名称作成.append(FONT_RED_ZEN).append(審査会名称).append(FONT_RED_GO);
        } else {
            審査会名称作成.append(審査会名称);
        }
    }

    private void setHoliday(FlexibleDate zenbuDate, List<UzV0002HolidayListEntity> holiDay, dgShinsakaiKaisaiYoteiIchiran_Row dgShinsakaRow) {
        dgShinsakaRow.setKaisaiYoteiYobi(new RString(zenbuDate.getDayOfWeek().getShortTerm()));
        for (UzV0002HolidayListEntity entity : holiDay) {
            if (new RString(zenbuDate.toString()).equals(entity.getHolidayDate().toDateString())) {
                dgShinsakaRow.setSaijitsu(entity.getDescription());
            }
        }
    }

    private void set合議体情報(SearchResult<GogitaiJohoShinsaRelateBusiness> gogitaiBusinessList) {
        List<dgShinsakaiKaisaiGogitaiJoho_Row> gogitaiJohoRowList = new ArrayList<>();
        int number = -1;
        int no = 1;
        for (GogitaiJohoShinsaRelateBusiness business : gogitaiBusinessList.records()) {
            if (number == business.get合議体番号()) {
                no = no + 1;
                set審査会委員氏名(gogitaiJohoRowList, no, business.get介護認定審査会委員氏名());
            } else {
                set合議体情報用(business, gogitaiJohoRowList);
                number = business.get合議体番号();
                no = 1;
            }
        }
        div.getDgShinsakaiKaisaiGogitaiJoho().setDataSource(gogitaiJohoRowList);
    }

    private void set合議体情報用(GogitaiJohoShinsaRelateBusiness business,
            List<dgShinsakaiKaisaiGogitaiJoho_Row> gogitaiJohoRowList) {
        dgShinsakaiKaisaiGogitaiJoho_Row gogitaiJohoRow = new dgShinsakaiKaisaiGogitaiJoho_Row();
        gogitaiJohoRow.setNumber(new RString(String.valueOf(business.get合議体番号())));
        gogitaiJohoRow.setGogitaiMeisho(business.get合議体名称());
        if (business.is合議体精神科医存在フラグ()) {
            gogitaiJohoRow.setShurui(種類);
        }
        gogitaiJohoRow.setShinsakaiIin1(business.get介護認定審査会委員氏名());
        gogitaiJohoRowList.add(gogitaiJohoRow);
    }

    private void set開催予定入力欄(RString 指定日) {
        SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> yoteiJohoNichiBusinessList = yoteiJohoManager.search審査会開催予定情報Of指定日(
                指定日);
        List<dgKaisaiYoteiNyuryokuran_Row> nyuryokuranRowList = new ArrayList<>();
        for (RString 開催時間 : 時間枠) {
            if (!開催時間.isEmpty()) {

                dgKaisaiYoteiNyuryokuran_Row nyuryokuranRow = new dgKaisaiYoteiNyuryokuran_Row();
                setNyuryokuran(yoteiJohoNichiBusinessList, 開催時間, nyuryokuranRow, 指定日);
                nyuryokuranRow.getKaisaiTime().setDisabled(true);
                nyuryokuranRowList.add(nyuryokuranRow);
            } else {
                dgKaisaiYoteiNyuryokuran_Row nyuryokuranRow = new dgKaisaiYoteiNyuryokuran_Row();
                setZenbuDisabled(nyuryokuranRow);
                nyuryokuranRowList.add(nyuryokuranRow);
            }
        }

        div.getDgKaisaiYoteiNyuryokuran().setDataSource(nyuryokuranRowList);
    }

    private void setNyuryokuran(SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> yoteiJohoNichiBusinessList,
            RString 開催時間, dgKaisaiYoteiNyuryokuran_Row nyuryokuranRow, RString 指定日) {
        int no = 1;
        for (ShinsakaiKaisaiYoteiJohoBusiness business : yoteiJohoNichiBusinessList.records()) {
            if (開催時間.equals(get検索時間枠(business.get予定開始時間(), business.get予定終了時間()))) {
                set開催合議体(nyuryokuranRow, no, new RString(String.valueOf(business.get合議体番号())));
                no = no + 1;
            }
        }
        for (ShinsakaiKaisaiYoteiJohoParameter parameter : yoteiJohoEntityList2) {
            if (new RString(parameter.get日付().toString()).equals(指定日)
                    && 開催時間.equals(get検索時間枠(parameter.get開始予定時刻(), parameter.get終了予定時刻())) && !parameter.is存在()) {
                set開催合議体(nyuryokuranRow, no, new RString(String.valueOf(parameter.get合議体番号())));
                no = no + 1;
            }
        }
        RString format = 開催時間.insert(INDEX_2, FUNN.toString()).insert(INDEX_5, 分割.toString()).insert(INDEX_8, FUNN.toString());
        nyuryokuranRow.getKaisaiTime().setValue(format);
        if (no == INDEX_1) {
            nyuryokuranRow.getKaisaiGogitai1().setDisabled(false);
            nyuryokuranRow.getKaisaiGogitai2().setDisabled(false);
            nyuryokuranRow.getKaisaiGogitai3().setDisabled(false);
            nyuryokuranRow.getKaisaiGogitai4().setDisabled(false);
            nyuryokuranRow.getBtnCencel1().setDisabled(true);
            nyuryokuranRow.getBtnCencel().setDisabled(true);
            nyuryokuranRow.getBtnCencel3().setDisabled(true);
            nyuryokuranRow.getBtnCencel4().setDisabled(true);
        } else if (no == INDEX_2) {
            nyuryokuranRow.getKaisaiGogitai1().setDisabled(true);
            nyuryokuranRow.getKaisaiGogitai2().setDisabled(false);
            nyuryokuranRow.getKaisaiGogitai3().setDisabled(false);
            nyuryokuranRow.getKaisaiGogitai4().setDisabled(false);
            nyuryokuranRow.getBtnCencel().setDisabled(true);
            nyuryokuranRow.getBtnCencel3().setDisabled(true);
            nyuryokuranRow.getBtnCencel4().setDisabled(true);
        } else if (no == INDEX_3) {
            nyuryokuranRow.getKaisaiGogitai1().setDisabled(true);
            nyuryokuranRow.getKaisaiGogitai2().setDisabled(true);
            nyuryokuranRow.getKaisaiGogitai3().setDisabled(false);
            nyuryokuranRow.getKaisaiGogitai4().setDisabled(false);
            nyuryokuranRow.getBtnCencel3().setDisabled(true);
            nyuryokuranRow.getBtnCencel4().setDisabled(true);
        } else if (no == INDEX_4) {
            nyuryokuranRow.getKaisaiGogitai1().setDisabled(true);
            nyuryokuranRow.getKaisaiGogitai2().setDisabled(true);
            nyuryokuranRow.getKaisaiGogitai3().setDisabled(true);
            nyuryokuranRow.getKaisaiGogitai4().setDisabled(false);
            nyuryokuranRow.getBtnCencel4().setDisabled(true);
        } else if (no == INDEX_5) {
            setZenbuDisabled(nyuryokuranRow);
        }
    }

    private void setZenbuDisabled(dgKaisaiYoteiNyuryokuran_Row nyuryokuranRow) {
        nyuryokuranRow.getBtnCencel1().setDisabled(true);
        nyuryokuranRow.getBtnCencel().setDisabled(true);
        nyuryokuranRow.getBtnCencel3().setDisabled(true);
        nyuryokuranRow.getBtnCencel4().setDisabled(true);
    }

    private void setDayBefore() {
        RDate seteiDay = div.getTxtSeteibi().getValue();
        seteiDay = seteiDay.minusDay(1);
        if (seteiDay.getDayValue() == 1) {
            div.getBtnDayBefore().setDisabled(true);
        }
        div.getTxtSeteibi().setValue(seteiDay);
        set開催予定入力欄(seteiDay.toDateString());
        div.getDgShinsakaiKaisaiYoteiIchiran().getDataSource().get(seteiDay.getDayValue()).setSelected(false);
        div.getDgShinsakaiKaisaiYoteiIchiran().getDataSource().get(seteiDay.getDayValue() - 1).setSelected(true);
    }

    private void setDayAfter() {
        RDate seteiDay = div.getTxtSeteibi().getValue();
        seteiDay = seteiDay.plusDay(1);
        if (seteiDay.getDayValue() == seteiDay.getLastDay()) {
            div.getBtnDayAfter().setDisabled(true);
        }
        div.getTxtSeteibi().setValue(seteiDay);
        set開催予定入力欄(seteiDay.toDateString());
        div.getDgShinsakaiKaisaiYoteiIchiran().getDataSource().get(seteiDay.getDayValue() - 2).setSelected(false);
        div.getDgShinsakaiKaisaiYoteiIchiran().getDataSource().get(seteiDay.getDayValue() - 1).setSelected(true);
    }

    private void set審査会委員氏名(List<dgShinsakaiKaisaiGogitaiJoho_Row> gogitaiJohoRowList, int no, RString 審査会委員氏名) {
        int index = gogitaiJohoRowList.size() - 1;
        switch (no) {
            case INDEX_2:
                gogitaiJohoRowList.get(index).setShinsakaiIin2(審査会委員氏名);
                break;
            case INDEX_3:
                gogitaiJohoRowList.get(index).setShinsakaiIin3(審査会委員氏名);
                break;
            case INDEX_4:
                gogitaiJohoRowList.get(index).setShinsakaiIin4(審査会委員氏名);
                break;
            case INDEX_5:
                gogitaiJohoRowList.get(index).setShinsakaiIin5(審査会委員氏名);
                break;
            case INDEX_6:
                gogitaiJohoRowList.get(index).setShinsakaiIin6(審査会委員氏名);
                break;
            case INDEX_7:
                gogitaiJohoRowList.get(index).setShinsakaiIin7(審査会委員氏名);
                break;
            case INDEX_8:
                gogitaiJohoRowList.get(index).setShinsakaiIin8(審査会委員氏名);
                break;
            case INDEX_9:
                gogitaiJohoRowList.get(index).setShinsakaiIin9(審査会委員氏名);
                break;
            case INDEX_10:
                gogitaiJohoRowList.get(index).setShinsakaiIin10(審査会委員氏名);
                break;
            default:
                break;
        }
    }

    private void set審査会名称(dgShinsakaiKaisaiYoteiIchiran_Row dgShinsakaRow, int j, RString 審査会名称) {
        switch (j) {
            case INDEX_0:
                dgShinsakaRow.setKaisaiGogitai1(審査会名称);
                break;
            case INDEX_1:
                dgShinsakaRow.setKaisaiGogitai2(審査会名称);
                break;
            case INDEX_2:
                dgShinsakaRow.setKaisaiGogitai3(審査会名称);
                break;
            case INDEX_3:
                dgShinsakaRow.setKaisaiGogitai4(審査会名称);
                break;
            case INDEX_4:
                dgShinsakaRow.setKaisaiGogitai5(審査会名称);
                break;
            case INDEX_5:
                dgShinsakaRow.setKaisaiGogitai6(審査会名称);
                break;
            case INDEX_6:
                dgShinsakaRow.setKaisaiGogitai7(審査会名称);
                break;
            case INDEX_7:
                dgShinsakaRow.setKaisaiGogitai8(審査会名称);
                break;
            case INDEX_8:
                dgShinsakaRow.setKaisaiGogitai9(審査会名称);
                break;
            case INDEX_9:
                dgShinsakaRow.setKaisaiGogitai10(審査会名称);
                break;
            default:
                break;
        }
    }

    private void set開催合議体(dgKaisaiYoteiNyuryokuran_Row dgNyuryokuranRow, int j, RString 開催合議体) {
        switch (j) {
            case INDEX_1:
                dgNyuryokuranRow.getKaisaiGogitai1().setValue(開催合議体);
                break;
            case INDEX_2:
                dgNyuryokuranRow.getKaisaiGogitai2().setValue(開催合議体);
                break;
            case INDEX_3:
                dgNyuryokuranRow.getKaisaiGogitai3().setValue(開催合議体);
                break;
            case INDEX_4:
                dgNyuryokuranRow.getKaisaiGogitai4().setValue(開催合議体);
                break;
            default:
                break;
        }
    }

    private RString get検索時間枠(RString 予定開始時間, RString 予定終了時間) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(予定開始時間).append(予定終了時間);
        return builder.toRString();
    }

    private RString getFormat時間枠(RString format時間枠) {
        return format時間枠.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
    }

    private void getConfig時間枠() {
        時間枠 = new ArrayList<>();
        for (int i = 0; i < INDEX_10; i++) {
            時間枠.add(RString.EMPTY);
        }
        RString 時間枠1 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠1, SubGyomuCode.DBE認定支援);
        if (時間枠1 != null && !時間枠1.isEmpty()) {
            時間枠1 = 時間枠1.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_0, 時間枠1);
        }
        RString 時間枠2 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠2, SubGyomuCode.DBE認定支援);
        if (時間枠2 != null && !時間枠2.isEmpty()) {
            時間枠2 = 時間枠2.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_1, 時間枠2);
        }
        RString 時間枠3 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠3, SubGyomuCode.DBE認定支援);
        if (時間枠3 != null && !時間枠3.isEmpty()) {
            時間枠3 = 時間枠3.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_2, 時間枠3);
        }
        RString 時間枠4 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠4, SubGyomuCode.DBE認定支援);
        if (時間枠4 != null && !時間枠4.isEmpty()) {
            時間枠4 = 時間枠4.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_3, 時間枠4);
        }
        RString 時間枠5 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠5, SubGyomuCode.DBE認定支援);
        if (時間枠5 != null && !時間枠5.isEmpty()) {
            時間枠5 = 時間枠5.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_4, 時間枠5);
        }
        RString 時間枠6 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠6, SubGyomuCode.DBE認定支援);
        if (時間枠6 != null && !時間枠6.isEmpty()) {
            時間枠6 = 時間枠6.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_5, 時間枠6);
        }
        RString 時間枠7 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠7, SubGyomuCode.DBE認定支援);
        if (時間枠7 != null && !時間枠7.isEmpty()) {
            時間枠7 = 時間枠7.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_6, 時間枠7);
        }
        RString 時間枠8 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠8, SubGyomuCode.DBE認定支援);
        if (時間枠8 != null && !時間枠8.isEmpty()) {
            時間枠8 = 時間枠8.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_7, 時間枠8);
        }
        RString 時間枠9 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠9, SubGyomuCode.DBE認定支援);
        if (時間枠9 != null && !時間枠9.isEmpty()) {
            時間枠9 = 時間枠9.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_8, 時間枠9);
        }
        RString 時間枠10 = BusinessConfig.get(ConfigNameDBE.審査会スケジュール時間枠10, SubGyomuCode.DBE認定支援);
        if (時間枠10 != null && !時間枠10.isEmpty()) {
            時間枠10 = 時間枠10.replace(分割, RString.EMPTY).replace(FUNN, RString.EMPTY);
            時間枠.set(INDEX_9, 時間枠10);
        }
    }
}
