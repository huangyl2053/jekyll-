/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0710021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.DBC0710021StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.DBC0710021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.JutakuGaisuDataParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.JutakuGaisuViewStateHolderParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShokanharaKeteiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHanntei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuyaokaigojyotaisandannkaihantei.JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 住宅改修費支給申請_申請情報登録クラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class JutakuKaishuShinseiJyohoToroku {

    private static final RString 画面モード_審査 = new RString("審査モード");
    private static final RString 画面モード_照会 = new RString("照会モード");
    private static final RString モード_照会 = new RString("照会");
    private static final RString 画面モード_削除 = new RString("削除モード");
    private static final RString 画面モード_取消 = new RString("取消モード");
    private static final RString 画面モード_登録 = new RString("登録モード");
    private static final RString 画面モード_修正 = new RString("修正モード");
    private static final RString 画面モード_事前申請 = new RString("事前申請登録モード");
    private static final RString 画面モード_以外 = new RString("以外");
    private static final RString 要介護状態区分3段階変更による = new RString("threeUp");
    private static final RString 住宅住所変更による = new RString("changeAddress");
    private static final RString エラー_RPLC_MSG_1 = new RString("受給認定有効期間外の");
    private static final RString エラー_RPLC_MSG_2 = new RString("入力");
    private static final RString 領収日_RPLC_MSG = new RString("領収日");
    private static final RString サービス提供年月_RPLC_MSG = new RString("サービス提供年月");
    private static final RString 給付実績連動_受託なし = new RString("1");
    private static final RString 給付実績緋連動_受託あり = new RString("2");
    private static final RString 償還払決定情報を登録 = new RString("償還払決定情報を登録して");

    /**
     * 画面ロードメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return 画面初期化
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onLoad(JutakuKaishuShinseiJyohoTorokuDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);

        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().initialize(識別コード);
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().initialize(識別コード);
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        JutakuGaisuViewStateHolderParameter param = new JutakuGaisuViewStateHolderParameter();
        param.set償還払申請一覧_サービス年月(ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class));
        param.set償還払申請一覧_被保険者番号(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        param.set償還払申請一覧_整理番号(ViewStateHolder.get(ViewStateKeys.整理番号, RString.class));
        handler.onLoad(識別コード, 被保険者番号, サービス提供年月, 整理番号, 画面モード, param);
        ViewStateHolder.put(ViewStateKeys.申請情報, param);
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
        ViewStateHolder.put(ViewStateKeys.処理モード, モード_照会);
        return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to住宅改修費事前申請登録).respond();
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
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        ShokanharaKeteiJyohoParameter 引き継ぎデータEntity = new ShokanharaKeteiJyohoParameter();
        引き継ぎデータEntity.set画面モード(画面モード);
        引き継ぎデータEntity.set識別コード(識別コード);
        引き継ぎデータEntity.set被保険者番号(被保険者番号);
        引き継ぎデータEntity.setサービス提供年月(サービス提供年月);
        引き継ぎデータEntity.set整理番号(整理番号);

        ValidationMessageControlPairs valid = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, 画面モード, null, false).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        ValidationMessageControlPairs valid2 = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, 画面モード, handler.住宅改修内容一覧チェック(), false).validate住宅改修内容();
        if (valid2.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid2).respond();
        }

        boolean 内容変更 = new RString(DbzQuestionMessages.内容変更なし処理中止確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode());
        boolean 判断基準 = new RString(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode());
        boolean 限度額 = new RString(DbcInformationMessages.限度額チェック前.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode());
        boolean 削除の確認 = new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode());
        boolean 保存の確認 = new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode());
        boolean 確認_汎用 = new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode());
        JutakuGaisuViewStateHolderParameter param = ViewStateHolder.get(ViewStateKeys.申請情報,
                JutakuGaisuViewStateHolderParameter.class);
        if (!handler.is画面データが変更(画面モード, param)) {
            if (isCheckデータ変更(内容変更, 判断基準, 限度額, 削除の確認, 保存の確認, 確認_汎用)) {
                QuestionMessage message = new QuestionMessage(
                        DbzQuestionMessages.内容変更なし処理中止確認.getMessage().getCode(),
                        DbzQuestionMessages.内容変更なし処理中止確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (内容変更 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }

        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
        if (画面モード_修正.equals(画面モード)
                && 領収日.getYearMonth().isBefore(画面提供着工年月.getYearMonth())) {
            if (isCheckFive(判断基準, 限度額, 削除の確認, 保存の確認, 確認_汎用)) {
                QuestionMessage message = new QuestionMessage(
                        DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
                        DbzQuestionMessages.判断基準より前の日付.getMessage().replace(
                                領収日_RPLC_MSG.toString(), サービス提供年月_RPLC_MSG.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (判断基準 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }

        boolean is確認対象変更有 = handler.is確認対象変更有無チェック(param);
        if (is確認対象変更有) {
            if (isCheckFour(限度額, 削除の確認, 保存の確認, 確認_汎用)) {
                return ResponseData.of(div).addMessage(DbcInformationMessages.限度額チェック前.getMessage()).respond();
            }
            if (限度額 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }
        return to内容保存(div, 画面モード, 引き継ぎデータEntity, handler, 削除の確認, 保存の確認, 確認_汎用, param);
    }

    private boolean isCheckFour(boolean 限度額, boolean 削除の確認, boolean 保存の確認, boolean 確認_汎用) {
        return isCheckTow(限度額, 削除の確認) && !保存の確認 && !確認_汎用;
    }

    private boolean isCheckFive(boolean 判断基準, boolean 限度額, boolean 削除の確認, boolean 保存の確認,
            boolean 確認_汎用) {
        return isCheckFour(判断基準, 限度額, 削除の確認, 保存の確認) && !確認_汎用;
    }

    private boolean isCheckデータ変更(boolean 内容変更, boolean 判断基準, boolean 限度額, boolean 削除の確認,
            boolean 保存の確認, boolean 確認_汎用) {
        return isCheckFive(内容変更, 判断基準, 限度額, 削除の確認, 保存の確認) && !確認_汎用;
    }

    private ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> to内容保存(
            JutakuKaishuShinseiJyohoTorokuDiv div,
            RString 画面モード,
            ShokanharaKeteiJyohoParameter 引き継ぎデータEntity,
            JutakuKaishuShinseiJyohoTorokuHandler handler,
            boolean 削除の確認,
            boolean 保存の確認,
            boolean 確認_汎用, JutakuGaisuViewStateHolderParameter param) {

        if (画面モード_削除.equals(画面モード)) {
            if (isCheckTow(削除の確認, 確認_汎用)) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        } else {
            if (isCheckTow(保存の確認, 確認_汎用)) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (is確認結果(削除の確認, 保存の確認)) {
            param.set住宅改修内容一覧_検索結果(ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_検索結果, Models.class));
            getHandler(div).save(引き継ぎデータEntity, param);
        } else if ((削除の確認 || 保存の確認) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (is状態Check(画面モード)) {
            set完了状態(div);
            return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
        } else if (is状態CheckTow(画面モード)) {
            RString 償還 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            if (is償還が給付実績連動_受託なし(償還, 確認_汎用)) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(償還払決定情報を登録.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (給付実績緋連動_受託あり.equals(償還)) {
                set完了状態(div);
                return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
            }
        } else if (画面モード_修正.equals(画面モード)) {
            if (isCheckTow(div.getBtnShokanKetteiJyoho().isDisabled(), 確認_汎用)) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(償還払決定情報を登録.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (div.getBtnShokanKetteiJyoho().isDisabled()) {
                set完了状態(div);
                return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
            }
        }
        if (確認_汎用 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.set画面遷移パラメータ(引き継ぎデータEntity.get識別コード(),
                    引き継ぎデータEntity.get被保険者番号(), 画面モード_修正, param);
            ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報).respond();
        }
        if (確認_汎用 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            set完了状態(div);
            return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
        }
        return ResponseData.of(div).respond();
    }

    private boolean is償還が給付実績連動_受託なし(RString 償還, boolean 確認_汎用) {
        return 給付実績連動_受託なし.equals(償還) && !確認_汎用;
    }

    private boolean is確認結果(boolean 削除の確認, boolean 保存の確認) {
        return (削除の確認 || 保存の確認) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes;
    }

    private boolean is状態CheckTow(RString 画面モード) {
        return 画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード);
    }

    private boolean is状態Check(RString 画面モード) {
        return 画面モード_審査.equals(画面モード) || 画面モード_削除.equals(画面モード)
                || 画面モード_取消.equals(画面モード);
    }

    private boolean isCheckTow(boolean 削除の確認, boolean 確認_汎用) {
        return !削除の確認 && !確認_汎用;
    }

    private void set完了状態(JutakuKaishuShinseiJyohoTorokuDiv div) {
        div.getJutakuShikyuShinseiKanryoPanel().getKanryoMessage().setMessage(new RString(
                UrInformationMessages.保存終了.getMessage().evaluate()),
                div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().get被保険者番号(),
                div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get氏名漢字(),
                true);
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
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
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
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
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
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        handler.get作成事業者名();
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
            if (画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード)) {
                div.getCommHeadPanel().getTxtSeiriNo().setValue(Saiban.get(
                        SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード(), 画面提供着工年月.getYearValue()).nextString());
            }
            JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
            handler.証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード, true);
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
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        if (領収日 != null) {
            FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(領収日.getYearMonth().toString());
            JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
            YokaigoNinteiJyoho 要介護認定情報 = 住宅改修費事前申請.getYokaigoNinteiJyoho(
                    被保険者番号, サービス提供年月);
            if (要介護認定情報 == null) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace(
                        エラー_RPLC_MSG_1.toString(), エラー_RPLC_MSG_2.toString()));
            }
            List<RString> 要介護認定状態区分コードリスト = new ArrayList<>();
            Code 要介護認定状態区分コード = 要介護認定情報.get要介護認定状態区分コード();
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.非該当.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援_経過的要介護.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援1.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援2.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護1.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護2.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護3.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護4.getCode());
            要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護5.getCode());
            if (!要介護認定状態区分コードリスト.contains(要介護認定状態区分コード.getKey())) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace(
                        エラー_RPLC_MSG_1.toString(), エラー_RPLC_MSG_2.toString()));
            }
            if (YoKaigoJotaiKubun.非該当.getCode().equals(要介護認定状態区分コード.getKey())
                    && !要介護認定情報.is旧措置者フラグ()) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace(
                        エラー_RPLC_MSG_1.toString(), エラー_RPLC_MSG_2.toString()));
            }
            if (領収日.getYearMonth().equals(画面提供着工年月.getYearMonth())) {
                return ResponseData.of(div).respond();
            } else if (!ResponseHolder.isReRequest()) {
                FlexibleYearMonth 年月 = new FlexibleYearMonth(領収日.getYearMonth().toString());
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().getCode(),
                        DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().replace(
                                年月.wareki().firstYear(FirstYear.ICHI_NEN).toDateString().toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getCommHeadPanel().getTxtTeikyoYM().setValue(領収日);
            } else if (new RString(DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
            HokenKyufuRitsu 給付率 = 住宅改修費事前申請.getKyufuritsu(被保険者番号,
                    new FlexibleYearMonth(領収日.getYearMonth().toString()));
            div.getTxtKyufuritsu().setValue(給付率.value());
            JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
            handler.証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード, true);
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
        JutakuGaisuViewStateHolderParameter param = ViewStateHolder.get(ViewStateKeys.申請情報, JutakuGaisuViewStateHolderParameter.class);
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
                handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード, param);
                ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
                        .respond();
            }
        } else if (画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード)) {
            handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード_修正, param);
            ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
                    .respond();
        } else {
            handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード, param);
            ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
                    .respond();
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

        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        ValidationMessageControlPairs valid = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, RString.FULL_SPACE, null, false).validate住宅改修内容();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        ValidationMessageControlPairs valid2 = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, null, handler.住宅改修内容一覧チェック(), false).validate住宅改修内容();
        if (valid2.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid2).respond();
        }
        JutakuGaisuViewStateHolderParameter param = ViewStateHolder.get(ViewStateKeys.申請情報,
                JutakuGaisuViewStateHolderParameter.class);
        handler.過去の住宅改修費取得と支払結果の設定(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                param);
        ViewStateHolder.put(ViewStateKeys.申請情報, param);
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
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        ValidationMessageControlPairs valid = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, null, null, true).validate住宅改修内容();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        ValidationMessageControlPairs valid2 = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, null, handler.住宅改修内容一覧チェック(), true).validate住宅改修内容();
        if (valid2.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid2).respond();
        }
        Decimal 費用額合計 = handler.費用額合計の取得();
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHiyoTotalNow().setValue(費用額合計);
        JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager manager
                = JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager.createInstance();
        FlexibleYearMonth 画面提供着工年月 = new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toDateString());
        boolean 要介護状態３段階変更の判定 = manager.checkYaokaigoJyotaiSandannkai(被保険者番号, 画面提供着工年月);
        List<RString> 要介護状態区分３段階変更チェック = div.getJutakuKaishuShinseiContents()
                .getJutakuKaishuShinseiResetInfo().getChkResetInfo().getSelectedKeys();
        boolean 限度額リセット対象 = new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage()
                .getCode()).equals(ResponseHolder.getMessageCode());
        boolean 限度額リセット対象外 = new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage()
                .getCode()).equals(ResponseHolder.getMessageCode());
        boolean 改修住所_限度額リセット対象 = new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage()
                .getCode()).equals(ResponseHolder.getMessageCode());
        boolean 改修住所_限度額リセット対象外 = new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象外
                .getMessage().getCode()).equals(ResponseHolder.getMessageCode());
        boolean 住宅改修限度額確認 = new RString(DbcWarningMessages.住宅改修限度額確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        if (is要介護状態３段階変更(要介護状態３段階変更の判定, 要介護状態区分３段階変更チェック)) {
            if (is限度額リセット対象(限度額リセット対象, 改修住所_限度額リセット対象,
                    改修住所_限度額リセット対象外, 住宅改修限度額確認)) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().getCode(),
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            to限度額リセット対象(要介護状態区分３段階変更チェック, div, 限度額リセット対象);
        } else if (!要介護状態３段階変更の判定 && (!要介護状態区分３段階変更チェック.isEmpty()
                && 要介護状態区分３段階変更チェック.contains(要介護状態区分3段階変更による))) {
            if (is限度額リセット対象(限度額リセット対象外, 改修住所_限度額リセット対象,
                    改修住所_限度額リセット対象外, 住宅改修限度額確認)) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            to限度額リセット対象外(要介護状態区分３段階変更チェック, div, 限度額リセット対象外);
        }
        List<dgGaisyuList_Row> gridList = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        JutakuKaishuJyusyoChofukuHanntei chofukuHanntei = JutakuKaishuJyusyoChofukuHanntei.createInstance();
        boolean is改修住所重複 = chofukuHanntei.checkKaishuJyusyoChofukuToroku(被保険者番号,
                画面提供着工年月, gridList.get(0).getTxtJutakuAddress());
        if (is改修住所変更(is改修住所重複, 要介護状態区分３段階変更チェック)) {
            if (is改修住所_限度額リセット対象(改修住所_限度額リセット対象, 住宅改修限度額確認)) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            to改修住所_限度額リセット対象(要介護状態区分３段階変更チェック, div, 改修住所_限度額リセット対象);
        } else if (is改修住所重複 && (!要介護状態区分３段階変更チェック.isEmpty()
                && 要介護状態区分３段階変更チェック.contains(住宅住所変更による))) {
            if (is改修住所_限度額リセット対象(改修住所_限度額リセット対象外, 住宅改修限度額確認)) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            to改修住所_限度額リセット対象外(要介護状態区分３段階変更チェック, div, 改修住所_限度額リセット対象外);
        }
        boolean 限度額チェック = handler.is限度額を超えない(被保険者番号, ViewStateHolder.get(
                ViewStateKeys.整理番号, RString.class));
        if (is改修住所_限度額リセット対象(限度額チェック, 住宅改修限度額確認)) {
            QuestionMessage message = new QuestionMessage(
                    DbcWarningMessages.住宅改修限度額確認.getMessage().getCode(),
                    DbcWarningMessages.住宅改修限度額確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcWarningMessages.住宅改修限度額確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        handler.支払結果の設定(被保険者番号);
        JutakuGaisuViewStateHolderParameter param = ViewStateHolder.get(ViewStateKeys.申請情報,
                JutakuGaisuViewStateHolderParameter.class);
        JutakuGaisuDataParameter 住宅改修データ = new JutakuGaisuDataParameter();
        住宅改修データ.set限度額リセット(要介護状態区分３段階変更チェック);
        住宅改修データ.set住宅改修データ(handler.get住宅改修内容一覧データ(
                div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList().get住宅改修内容一覧()));
        param.set住宅改修データ(住宅改修データ);
        ViewStateHolder.put(ViewStateKeys.申請情報, param);
        return ResponseData.of(div).respond();
    }

    private boolean is改修住所変更(boolean is改修住所重複, List<RString> 要介護状態区分３段階変更チェック) {
        return !is改修住所重複 && (要介護状態区分３段階変更チェック.isEmpty()
                || !要介護状態区分３段階変更チェック.contains(住宅住所変更による));
    }

    private boolean is要介護状態３段階変更(boolean 要介護状態３段階変更の判定,
            List<RString> 要介護状態区分３段階変更チェック) {
        return 要介護状態３段階変更の判定 && (要介護状態区分３段階変更チェック.isEmpty()
                || !要介護状態区分３段階変更チェック.contains(要介護状態区分3段階変更による));
    }

    private boolean is改修住所_限度額リセット対象(boolean 改修住所_限度額リセット対象, boolean 住宅改修限度額確認) {
        return !改修住所_限度額リセット対象 && !住宅改修限度額確認;
    }

    private boolean is限度額リセット対象(boolean 限度額リセット対象,
            boolean 改修住所_限度額リセット対象,
            boolean 改修住所_限度額リセット対象外,
            boolean 住宅改修限度額確認) {
        return is改修住所_限度額リセット対象(限度額リセット対象, 改修住所_限度額リセット対象)
                && !改修住所_限度額リセット対象外
                && !住宅改修限度額確認;
    }

    private void to改修住所_限度額リセット対象外(List<RString> 要介護状態区分３段階変更チェック,
            JutakuKaishuShinseiJyohoTorokuDiv div,
            boolean 改修住所_限度額リセット対象外) {
        if (改修住所_限度額リセット対象外 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護状態区分３段階変更チェック.remove(住宅住所変更による);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private void to改修住所_限度額リセット対象(List<RString> 要介護状態区分３段階変更チェック,
            JutakuKaishuShinseiJyohoTorokuDiv div,
            boolean 改修住所_限度額リセット対象) {
        if (改修住所_限度額リセット対象 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護状態区分３段階変更チェック.add(住宅住所変更による);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private void to限度額リセット対象外(List<RString> 要介護状態区分３段階変更チェック,
            JutakuKaishuShinseiJyohoTorokuDiv div,
            boolean 限度額リセット対象外) {
        if (限度額リセット対象外 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護状態区分３段階変更チェック.remove(要介護状態区分3段階変更による);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private void to限度額リセット対象(List<RString> 要介護状態区分３段階変更チェック,
            JutakuKaishuShinseiJyohoTorokuDiv div,
            boolean 限度額リセット対象) {
        if (限度額リセット対象 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護状態区分３段階変更チェック.add(要介護状態区分3段階変更による);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private JutakuKaishuShinseiJyohoTorokuHandler getHandler(JutakuKaishuShinseiJyohoTorokuDiv div) {
        return JutakuKaishuShinseiJyohoTorokuHandler.of(div);
    }

    private JutakuKaishuShinseiJyohoTorokuValidationHandler getJutakuKaishuShinseiJyohoTorokuValidationHandler(
            JutakuKaishuShinseiJyohoTorokuDiv div, RString 画面モード, RString 住宅改修内容チェックエラーメッセージ,
            boolean is給付率) {
        if (画面モード != null || 住宅改修内容チェックエラーメッセージ != null) {
            return new JutakuKaishuShinseiJyohoTorokuValidationHandler(
                    画面モード, div, 住宅改修内容チェックエラーメッセージ, is給付率);
        } else {
            return new JutakuKaishuShinseiJyohoTorokuValidationHandler(div);
        }
    }
}
