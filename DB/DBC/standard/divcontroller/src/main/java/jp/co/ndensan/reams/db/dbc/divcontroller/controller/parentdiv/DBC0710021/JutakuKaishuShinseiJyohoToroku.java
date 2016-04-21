/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0710021;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.DBC0710021StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.DBC0710021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.JutakuGaisuDataParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShikyuShiseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShokanharaKeteiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHanntei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuyaokaigojyotaisandannkaihantei.JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager;
import jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.IsKyuSoti;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 住宅改修費支給申請_申請情報登録クラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class JutakuKaishuShinseiJyohoToroku {

    private final RString 画面モード_審査 = new RString("審査モード");
    private final RString 画面モード_照会 = new RString("照会モード");
    private final RString 画面モード_削除 = new RString("削除モード");
    private final RString 画面モード_取消 = new RString("取消モード");
    private final RString 画面モード_登録 = new RString("登録モード");
    private final RString 画面モード_修正 = new RString("修正モード");
    private final RString 画面モード_事前申請 = new RString("事前申請モード");
    private final RString 画面モード_以外 = new RString("以外");
    private final Code 非該当 = new Code("01");
    private final Code 要支援1 = new Code("12");
    private final Code 要支援2 = new Code("13");
    private final Code 要支援_経過的要介護 = new Code("11");
    private final Code 要介護1 = new Code("21");
    private final Code 要介護2 = new Code("22");
    private final Code 要介護3 = new Code("23");
    private final Code 要介護4 = new Code("24");
    private final Code 要介護5 = new Code("25");
    private final RString 給付実績連動_受託なし = new RString("1");
    private final RString 給付実績連動_受託あり = new RString("2");
    private final RString 要介護状態区分3段階変更による = new RString("threeUp");
    private final RString 住宅住所変更による = new RString("changeAddress");
    private final RString エラー_RPLC_MSG_1 = new RString("受給認定有効期間外の");
    private final RString エラー_RPLC_MSG_2 = new RString("入力");

    /**
     * 画面ロードメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return 画面初期化
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onLoad(JutakuKaishuShinseiJyohoTorokuDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RDate サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, RDate.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);

        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().onLoad(識別コード);
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().onLoad(識別コード);
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        handler.onLoad(識別コード, 被保険者番号,
                サービス提供年月 != null ? new FlexibleYearMonth(サービス提供年月.getYearMonth().toDateString()) : null,
                整理番号, 画面モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「事前申請を確認する｣ボタンを押した後のメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnShowJizenShinsei(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.表示モード, 画面モード_照会);
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        RString 整理番号 = div.getTxtSeiriNo().getValue();
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, new FlexibleYearMonth(
                画面提供着工年月.getYearMonth().toDateString()));
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to住宅改修費事前申請登録).respond();
    }

    /**
     * 提供（着工）年月変更後のメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_teikyoYMonFocus(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
        handler.証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 画面の保存するメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnAddShikyuShinsei(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RDate サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, RDate.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        ShokanharaKeteiJyohoParameter 引き継ぎデータEntity = new ShokanharaKeteiJyohoParameter();
        引き継ぎデータEntity.set画面モード(画面モード);
        引き継ぎデータEntity.set識別コード(識別コード);
        引き継ぎデータEntity.set被保険者番号(被保険者番号);
        引き継ぎデータEntity.setサービス提供年月(
                サービス提供年月 != null ? new FlexibleYearMonth(サービス提供年月.getYearMonth().toDateString()) : null);
        引き継ぎデータEntity.set整理番号(整理番号);
        // 入力チェック
        ValidationMessageControlPairs valid = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, 画面モード).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        // データ変更確認
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        if (!handler.is画面データが変更()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbzQuestionMessages.内容変更なし処理中止確認.getMessage().getCode(),
                        DbzQuestionMessages.内容変更なし処理中止確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbzQuestionMessages.内容変更なし処理中止確認.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            } else if (new RString(DbzQuestionMessages.内容変更なし処理中止確認.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {

            }
        }
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
//        RDate 申請日 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().getValue();
//        RDate 申請日年月 = new RDate(申請日.getYearMonth().toString());
//        RString 償還 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
//        if (給付実績連動_受託なし.equals(償還)) {
//            if (!申請日年月.equals(画面提供着工年月)) {
////                throw new ApplicationException(DbcErrorMessages.申請日不一致.getMessage());
//            }
//        }
        // 領収日チェック
        RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
        if (領収日.getYearMonth().isBeforeOrEquals(画面提供着工年月.getYearMonth())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
                        DbzQuestionMessages.判断基準より前の日付.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        // is確認対象変更有無チェック TODO
        JutakuGaisuDataParameter 住宅改修データ = ViewStateHolder.get(
                ViewStateKeys.住宅改修データ_画面メモリ, JutakuGaisuDataParameter.class);
        if (住宅改修データ != null) {
            boolean is確認対象変更有 = handler.is確認対象変更有無チェック(住宅改修データ);
            if (is確認対象変更有) {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(
                            DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
                }
                if (new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode()).equals(
                        ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    return ResponseData.of(div).respond();
                }
            }
        }
        // 操作可否確認
        if (画面モード_削除.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if ((new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                || new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(
                        ResponseHolder.getMessageCode()))
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.save(引き継ぎデータEntity);
            // １１．保存完了の確認
            // １１．１　画面モードが審査モード、削除モード、取消モード
            if (画面モード_審査.equals(画面モード) || 画面モード_削除.equals(画面モード)
                    || 画面モード_取消.equals(画面モード)) {
                div.getJutakuShikyuShinseiKanryoPanel().getKanryoMessage().setMessage(new RString(
                        UrInformationMessages.保存終了.getMessage().evaluate()),
                        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get氏名漢字(),
                        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().get被保険者番号(), true);
                return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
                // １１．２　画面モードが登録モード、事前申請登録モード
            } else if (画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード)) {
//                if (給付実績連動_受託なし.equals(償還)) {
//                    if (!ResponseHolder.isReRequest()) {
//                        QuestionMessage message = new QuestionMessage(
//                                DbcQuestionMessages.償還払決定情報登録.getMessage().getCode(),
//                                DbcQuestionMessages.償還払決定情報登録.getMessage().evaluate());
//                        return ResponseData.of(div).addMessage(message).respond();
//                    }
//                    if (new RString(DbcQuestionMessages.償還払決定情報登録.getMessage().getCode()).equals(
//                            ResponseHolder.getMessageCode())
//                            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                        handler.set画面遷移パラメータ(引き継ぎデータEntity, 画面モード_修正);
//                        return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
//                                .respond();
//                    }
//                    if (new RString(DbcQuestionMessages.償還払決定情報登録.getMessage().getCode()).equals(
//                            ResponseHolder.getMessageCode())
//                            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
//                        return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
//                    }
//                } else if (給付実績連動_受託あり.equals(償還)) {
//                    return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
//                }
                // １１．３　画面モードが修正モード
            } else if (画面モード_修正.equals(画面モード)) {
                if (!div.getBtnShokanKetteiJyoho().isDisabled()) {
//                    if (!ResponseHolder.isReRequest()) {
//                        QuestionMessage message = new QuestionMessage(
//                                DbcQuestionMessages.償還払決定情報登録.getMessage().getCode(),
//                                DbcQuestionMessages.償還払決定情報登録.getMessage().evaluate());
//                        return ResponseData.of(div).addMessage(message).respond();
//                    }
//                    if (new RString(DbcQuestionMessages.償還払決定情報登録.getMessage().getCode()).equals(
//                            ResponseHolder.getMessageCode())
//                            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                        handler.set画面遷移パラメータ(引き継ぎデータEntity, 画面モード);
//                        return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
//                                .respond();
//                    }
                } else {
                    return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
                }
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請事業者参考」ボタンを押した後のメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onBeforeOpenDialog_btnJigyosha(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        JigyoshaMode jigyoshaMode = new JigyoshaMode();
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.code());
        div.setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者・施設選択入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onOkClose_btnJigyosha(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo().setValue(
                jigyoshaMode.getJigyoshaNo().value());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().setValue(
                jigyoshaMode.getJigyoshaName().value());
        return ResponseData.of(div).respond();
    }

    /**
     * 「作成事業者参考」ボタンを押した後のメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onBeforeOpenDialog_btnSakuSeiJigyosha(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        JigyoshaMode jigyoshaMode = new JigyoshaMode();
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.code());
        div.setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者・施設選択入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onOkClose_btnSakuSeiJigyosha(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().setValue(
                jigyoshaMode.getJigyoshaNo().value());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().setDomain(
                jigyoshaMode.getJigyoshaName());
        return ResponseData.of(div).respond();
    }

    /**
     * 本人情報をコピーするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnCopyInfoOfAtena(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        // TODO 電話番号
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        handler.set本人情報();
        return ResponseData.of(div).respond();
    }

    /**
     * 申請一覧へ戻るのメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnCancel(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (画面モード_審査.equals(画面モード)) {
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).
                        parameter(画面モード_審査);
            } else if (画面モード_照会.equals(画面モード)) {
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).
                        parameter(画面モード_照会);
            } else {
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).
                        parameter(画面モード_以外);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 個人検索へ戻るのメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnBackToSearch(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to個人検索).
                    respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 作成事業者onBlurするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_creationJigyoshaNoonBlur(
            JutakuKaishuShinseiJyohoTorokuDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 提供（着工）年月onBlurするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_teikyoYMonBlur(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        if (画面提供着工年月 != null) {
            JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
            handler.証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 領収日チェックするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_ryoshuYMDonFocus(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikyuShiseiJyohoParameter 引き継ぎデータEntity = new ShikyuShiseiJyohoParameter();
        RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        if (領収日 != null) {
            FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(領収日.getYearMonth().toString());
            JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
            YokaigoNinteiJyoho 要介護認定情報 = 住宅改修費事前申請.getYokaigoNinteiJyoho(
                    被保険者番号, サービス提供年月);
            // １０．１　取得した要介護認定状態区分コードが以下の場合、受給認定が有効としてチェックする
            if (要介護認定情報 == null) {
//                throw new ApplicationException(DbcErrorMessages.受給認定有効期間外で入力不可.getMessage());
            }
            if (非該当.equals(要介護認定情報.get要介護認定状態区分コード())) {
                要介護認定情報.set旧措置者フラグ(IsKyuSoti.旧措置適用.is適用());
            } else if (要支援_経過的要介護.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要支援1.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要支援2.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護1.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護2.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護3.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護4.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護5.equals(要介護認定情報.get要介護認定状態区分コード())) {
                boolean 受給認定 = true;
            } else {
                throw new ApplicationException(DbcErrorMessages.実行不可.getMessage().replace(
                        エラー_RPLC_MSG_1.toString(), エラー_RPLC_MSG_2.toString()));
            }

            // １０．２　画面．提供（着工）年月が画面．領収日の年月と一致する場合、処理終了
            if (領収日.getYearMonth().equals(画面提供着工年月.getYearMonth())) {
                return ResponseData.of(div).respond();
            } else {
                // TODO
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(
                            DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().getCode(),
                            DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().replace(
                                    領収日.getYearMonth().toString()).evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().getCode()).equals(
                        ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
// １０．３．１　｢はい｣をクリックされる場合、提供（着工）年月を領収日の年月に設定する
                    div.getCommHeadPanel().getTxtTeikyoYM().setValue(領収日);
                } else if (new RString(DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().getCode()).equals(
                        ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                    return ResponseData.of(div).respond();
                }
            }
// １０．４　給付率の再設定
            HokenKyufuRitsu 給付率 = 住宅改修費事前申請.getKyufuritsu(被保険者番号,
                    new FlexibleYearMonth(領収日.getYearMonth().toString()));
            div.getTxtKyufuritsu().setValue(給付率.value());
            // １０．５　画面．提供（着工）年月が変更されたので、証明書を再設定する
            JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
            handler.証明書表示設定(住宅改修費支給申請, 被保険者番号, 引き継ぎデータEntity.get画面モード());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「償還払決定情報」ボタン押したするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnShokaiKeteiJoho(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        if (画面モード_修正.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード);
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
                        .respond();
            }
        } else if (画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード)) {
            handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード_修正);
        } else {
            handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「過去の住宅改修費を確認する」ボタン押したするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnRireki(
            JutakuKaishuShinseiJyohoTorokuDiv div) {

        ValidationMessageControlPairs valid = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, null).validate住宅改修内容();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「限度額をチェックする」ボタン押したするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnCheckGendogaku(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth 画面提供着工年月 = new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toDateString());
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        // 1 入力チェック
//        handler.住宅改修内容のチェック();

        ValidationMessageControlPairs valid = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, null).validate住宅改修内容();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        // 2 費用額合計の設定
//        handler.費用額合計の取得();
        // 3 限度額リセット有効性チェック
        // ７．１　要介護状態３段階変更の有効性チェック
        JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager manager
                = JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager.createInstance();
        boolean 要介護状態３段階変更の判定 = manager.checkYaokaigoJyotaiSandannkai(
                被保険者番号,
                画面提供着工年月);
        List<RString> 要介護状態区分３段階変更チェック = div.getJutakuKaishuShinseiContents()
                .getJutakuKaishuShinseiResetInfo().getChkResetInfo().getSelectedKeys();
//        if (要介護状態３段階変更の判定
//                && (要介護状態区分３段階変更チェック == null || 要介護状態区分３段階変更チェック.contains(
//        要介護状態区分3段階変更による))) {
//
//        } else if (!要介護状態３段階変更の判定 && 要介護状態区分３段階変更チェック != null) {
//
//        }
        if (要介護状態３段階変更の判定 && (要介護状態区分３段階変更チェック.isEmpty()
                || !要介護状態区分３段階変更チェック.contains(要介護状態区分3段階変更による))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().getCode(),
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                要介護状態区分３段階変更チェック.add(要介護状態区分3段階変更による);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
                return ResponseData.of(div).respond();
            }
        } else if (!要介護状態３段階変更の判定 && (!要介護状態区分３段階変更チェック.isEmpty()
                && 要介護状態区分３段階変更チェック.contains(要介護状態区分3段階変更による))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                要介護状態区分３段階変更チェック.remove(要介護状態区分3段階変更による);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
                return ResponseData.of(div).respond();
            }
        }
        // ７．２　改修住所変更による限度額リセットチェック
        JutakuKaishuJyusyoChofukuHanntei chofukuHanntei = JutakuKaishuJyusyoChofukuHanntei.createInstance();
//        chofukuHanntei.checkKaishuJyusyoChofukuToroku(被保険者番号,
//                画面提供着工年月, 表示モード);
//        RString 住宅住所変更チェック = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
//                .getChkResetInfo().getSelectedKeys().get(1);
        if (要介護状態区分３段階変更チェック.isEmpty()
                || !要介護状態区分３段階変更チェック.contains(住宅住所変更による)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                要介護状態区分３段階変更チェック.add(住宅住所変更による);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
                return ResponseData.of(div).respond();
            }
        } else if (!要介護状態区分３段階変更チェック.isEmpty()
                && 要介護状態区分３段階変更チェック.contains(住宅住所変更による)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                要介護状態区分３段階変更チェック.remove(住宅住所変更による);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
                return ResponseData.of(div).respond();
            }
        }
        // 4 限度額のチェック
        boolean 限度額チェック = handler.is限度額を超えない();
        if (!限度額チェック) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbcWarningMessages.ダミーメッセージ.getMessage().getCode(),
                        DbcWarningMessages.ダミーメッセージ.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcWarningMessages.ダミーメッセージ.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }
        // 5.　支払結果の設定
        handler.支払結果の設定();
        // 6 確認対象の保存 TODO
        JutakuGaisuDataParameter 住宅改修データ = new JutakuGaisuDataParameter();
        住宅改修データ.set限度額リセット(要介護状態区分３段階変更チェック);
        ViewStateHolder.put(ViewStateKeys.住宅改修データ_画面メモリ, 住宅改修データ);
        return ResponseData.of(div).respond();
    }

    private JutakuKaishuShinseiJyohoTorokuHandler getHandler(JutakuKaishuShinseiJyohoTorokuDiv div) {
        return JutakuKaishuShinseiJyohoTorokuHandler.of(div);
    }

    private JutakuKaishuShinseiJyohoTorokuValidationHandler getJutakuKaishuShinseiJyohoTorokuValidationHandler(
            JutakuKaishuShinseiJyohoTorokuDiv div, RString 画面モード) {
        if (画面モード != null) {
            return new JutakuKaishuShinseiJyohoTorokuValidationHandler(画面モード, div);
        } else {
            return new JutakuKaishuShinseiJyohoTorokuValidationHandler(div);
        }
    }
}
