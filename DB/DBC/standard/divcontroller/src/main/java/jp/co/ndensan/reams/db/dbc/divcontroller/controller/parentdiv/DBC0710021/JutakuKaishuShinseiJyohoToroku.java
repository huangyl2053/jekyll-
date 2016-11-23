/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0710021;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
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
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
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
    private static final RString 参照 = new RString("参照");
    private static final RString モード_照会 = new RString("照会");
    private static final RString 画面モード_削除 = new RString("削除モード");
    private static final RString 画面モード_取消 = new RString("取消モード");
    private static final RString 画面モード_登録 = new RString("登録モード");
    private static final RString 画面モード_修正 = new RString("修正モード");
    private static final RString 画面モード_事前申請 = new RString("事前申請登録モード");
    private static final RString 画面モード_以外 = new RString("以外");
    private static final RString 要介護状態区分3段階変更による = new RString("threeUp");
    private static final RString 住宅住所変更による = new RString("changeAddress");
    private static final RString 領収日_RPLC_MSG = new RString("領収日");
    private static final RString サービス提供年月_RPLC_MSG = new RString("サービス提供年月");
    private static final RString 給付実績連動_受託なし = new RString("1");
    private static final RString 給付実績緋連動_受託あり = new RString("2");
    private static final RString 受託区分_1 = new RString("1");
    private static final RString 償還払決定情報を登録 = new RString("償還払決定情報を登録して");
    private static final int 前ゼロ付き10桁 = 10;
    private static final int INDEX_6 = 6;
    private static final RString YES = new RString("1");
    private static final RString NO = new RString("0");
    private static final RString 申請を保存する = new RString("btnAddShikyuShinsei");
    private static final RString 遷移元 = new RString("DBC0710021");
    private final RString 排他キー = new RString("DBCHihokenshaNo");

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
        if (!画面モード_照会.equals(画面モード)) {
            LockingKey 排他キー = new LockingKey(this.排他キー.concat(被保険者番号.getColumnValue()));
            if (!RealInitialLocker.tryGetLock(排他キー)) {
                throw new PessimisticLockingException();
            }
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        }
        div.setDisabled(false);
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().initialize(識別コード);
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().initialize(識別コード);
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        JutakuGaisuViewStateHolderParameter param = new JutakuGaisuViewStateHolderParameter();
        param.set償還払申請一覧_サービス年月(ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class));
        param.set償還払申請一覧_被保険者番号(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        param.set償還払申請一覧_整理番号(ViewStateHolder.get(ViewStateKeys.整理番号, RString.class));
        Map<RString, FlexibleYearMonth> 事前Map
                = handler.onLoad(識別コード, 被保険者番号, サービス提供年月, 整理番号, 画面モード, param);
        if (事前Map != null) {
            RString 事前申請整理番号 = 事前Map.keySet().iterator().next();
            FlexibleYearMonth 事前サービス提供年月 = 事前Map.get(事前申請整理番号);
            ViewStateHolder.put(ViewStateKeys.整理番号, 事前申請整理番号);
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, 事前サービス提供年月);
        }
        ViewStateHolder.put(ViewStateKeys.申請情報, param);
        if (div.getTxtTeikyoYM().getValue() != null) {
            ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_サービス年月,
                    new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().toDateString().substring(0, INDEX_6)));
        } else {
            ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_サービス年月, null);
        }
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
        if (!画面モード_取消.equals(画面モード) && !画面モード_削除.equals(画面モード)) {
            ValidationMessageControlPairs valid2 = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                    div, 画面モード, handler.住宅改修内容一覧チェック(), false).validate住宅改修内容();
            if (valid2.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid2).respond();
            }
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
        boolean 保存終了 = new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(
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
        return to内容保存(div, 画面モード, 引き継ぎデータEntity, handler, 削除の確認, 保存の確認, 保存終了, 確認_汎用, 被保険者番号, param);
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
            boolean 保存終了,
            boolean 確認_汎用,
            HihokenshaNo 被保険者番号,
            JutakuGaisuViewStateHolderParameter param) {

        if (画面モード_削除.equals(画面モード)) {
            if (isCheckTow(削除の確認, 確認_汎用) && !保存終了) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        } else if (isCheckTow(保存の確認, 確認_汎用) && !保存終了) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (is確認結果(削除の確認, 保存の確認)) {
            param.set住宅改修内容一覧_検索結果(ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_検索結果, Models.class));
            getHandler(div).save(引き継ぎデータEntity, param);
            排他キーRelease(被保険者番号.getColumnValue());
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
            RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            if (isCheckTow(!受託区分_1.equals(受託区分), 確認_汎用)) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(償還払決定情報を登録.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (!確認_汎用 && div.getBtnShokanKetteiJyoho().isDisabled()) {
                set完了状態(div);
                return ResponseData.of(div).setState(DBC0710021StateName.KanryoMessage);
            }
        } else if (!保存終了 && 画面モード_審査.equals(画面モード)) {
            InformationMessage infoMessage = new InformationMessage(
                    UrInformationMessages.保存終了.getMessage().getCode(),
                    UrInformationMessages.保存終了.getMessage().evaluate());
            return ResponseData.of(div).addMessage(infoMessage).respond();
        }
        if (保存終了 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_遷移元, 遷移元);
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).respond();
        }
        if (確認_汎用 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.set画面遷移パラメータ(引き継ぎデータEntity.get識別コード(),
                    引き継ぎデータEntity.get被保険者番号(), 画面モード_修正, param);
            ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
            排他キーRelease(被保険者番号.getColumnValue());
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報).parameter(画面モード_登録);
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
        return 画面モード_削除.equals(画面モード)
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
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaName().setPlaceHolder(
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
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (画面モード.equals(ResponseHolder.getState())) {
            排他キーRelease(被保険者番号.getColumnValue());
            ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_遷移元, 遷移元);
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            排他キーRelease(被保険者番号.getColumnValue());
            ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_遷移元, 遷移元);
            if (画面モード_審査.equals(画面モード)) {
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).respond();
            } else if (画面モード_照会.equals(画面モード)) {
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).respond();
            } else {
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to申請一覧).
                        parameter(画面モード_以外);
            }
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
        FlexibleYearMonth old提供着工年月 = ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_サービス年月, FlexibleYearMonth.class);

        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        if (画面提供着工年月 != null) {
            JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
            handler.証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード, true);
            handler.保険者ドロップダウンリストを再セット(画面提供着工年月);
        }

        if ((画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード))
                && 画面提供着工年月 != null
                && (old提供着工年月 == null
                || !old提供着工年月.toDateString().equals(画面提供着工年月.getYearMonth().toDateString()))) {
            div.getCommHeadPanel().getTxtSeiriNo().setValue(Saiban.get(
                    SubGyomuCode.DBZ介護共通, SaibanHanyokeyName.償還整理番号.get名称(),
                    new FlexibleYear(画面提供着工年月.getNendo().toDateString())).nextString().padZeroToLeft(前ゼロ付き10桁));
        }

        if (div.getTxtTeikyoYM().getValue() != null) {
            ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_サービス年月,
                    new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().toDateString().substring(0, INDEX_6)));
        } else {
            ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_サービス年月, null);
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
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        JutakuKaishuShinseiJyohoTorokuHandler handler = getHandler(div);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        if (領収日 == null) {
            return ResponseData.of(div).respond();
        }
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(領収日.getYearMonth().toString());
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        YokaigoNinteiJyoho 要介護認定情報 = 住宅改修費事前申請.getYokaigoNinteiJyoho(
                被保険者番号, サービス提供年月);
        if (要介護認定情報 != null) {
            Code 要介護認定状態区分コード = 要介護認定情報.get要介護認定状態区分コード();
            div.getCommHeadPanel().set要介護認定情報(要介護認定状態区分コード.getColumnValue());
            set旧措置者フラグ(要介護認定情報, div);
        } else {
            div.getCommHeadPanel().set要介護認定情報(null);
        }
        getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                div, null, handler.住宅改修内容一覧チェック(), false).validate受給認定が無効チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (領収日.getYearMonth().equals(画面提供着工年月.getYearMonth())) {
            return ResponseData.of(div).respond();
        } else if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs valid3 = 領収日変更チェック(画面モード, div);
            if (valid3 != null && valid3.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid3).respond();
            }
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
            return onClick_teikyoYMonBlur(div);
        } else if (new RString(DbcQuestionMessages.領収日不一致_提供年月変更確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        HokenKyufuRitsu 給付率 = 住宅改修費事前申請.getKyufuritsu(被保険者番号,
                new FlexibleYearMonth(領収日.getYearMonth().toString()));
        div.getTxtKyufuritsu().setValue(給付率.value());
        JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
        handler.証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請日変更チェックするメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_TxtShinseiYMD_OnChange(
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        if (画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード) || 画面モード_修正.equals(画面モード) || 画面モード_審査.equals(画面モード)) {
            ValidationMessageControlPairs pairs = getJutakuKaishuShinseiJyohoTorokuValidationHandler(
                    div, 画面モード, null, false).validate申請日変更チェック();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs 領収日変更チェック(RString 画面モード, JutakuKaishuShinseiJyohoTorokuDiv div) {
        if (画面モード_登録.equals(画面モード) || 画面モード_修正.equals(画面モード) || 画面モード_審査.equals(画面モード)) {
            return getJutakuKaishuShinseiJyohoTorokuValidationHandler(div, 画面モード, null, false).validate領収日変更チェック();
        }
        return null;
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

                画面モード = set画面モード(param, 画面モード);

                handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード, param);
                ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
                排他キーRelease(被保険者番号.getColumnValue());
                return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
                        .parameter(画面モード_登録);
            }
        } else if (画面モード_登録.equals(画面モード) || 画面モード_事前申請.equals(画面モード)) {
            handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード_修正, param);
            ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
            排他キーRelease(被保険者番号.getColumnValue());
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
                    .parameter(画面モード_登録);
        } else {
            handler.set画面遷移パラメータ(識別コード, 被保険者番号, 画面モード, param);
            ViewStateHolder.put(ViewStateKeys.検索キー, param.get償還払決定情報());
            if (!画面モード_照会.equals(画面モード)) {
                排他キーRelease(被保険者番号.getColumnValue());
            }
            return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to償還払決定情報)
                    .parameter(画面モード_照会);
        }
        return ResponseData.of(div).respond();
    }

    private void 排他キーRelease(RString 被保険者番号) {
        RString 元画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        if (!画面モード_照会.equals(元画面モード)) {
            LockingKey 排他キー = new LockingKey(this.排他キー.concat(被保険者番号));
            RealInitialLocker.release(排他キー);
        }
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
        div.getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalNow().setValue(費用額合計);
        JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager manager
                = JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager.createInstance();
        FlexibleYearMonth 終了サービス提供年月 = new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toDateString());

        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        ShiharaiKekkaResult 最新住宅改修費支払結果 = 住宅改修費事前申請.getKakoJutakuKaishuHi(被保険者番号,
                new FlexibleYearMonth(div.getCommHeadPanel().getTxtTeikyoYM().getValue().getYearMonth().toDateString()));
        handler.前回まで支払結果の初期化(最新住宅改修費支払結果);
        boolean 要介護状態３段階変更の判定 = true;
        if (ResponseHolder.isReRequest()) {
            要介護状態３段階変更の判定 = ViewStateHolder.get(ViewStateKeys.要介護状態３段階変更, Boolean.class);
        } else {
            要介護状態３段階変更の判定 = manager.checkYaokaigoJyotaiSandannkai(
                    被保険者番号,
                    最新住宅改修費支払結果.get開始サービス提供年月(),
                    終了サービス提供年月);
            ViewStateHolder.put(ViewStateKeys.要介護状態３段階変更, 要介護状態３段階変更の判定);
        }
        List<RString> 要介護状態区分３段階変更チェック = div
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
        } else if (is要介護状態３段階変更flag(要介護状態３段階変更の判定, 要介護状態区分３段階変更チェック)) {
            if (is限度額リセット対象(限度額リセット対象外, 改修住所_限度額リセット対象,
                    改修住所_限度額リセット対象外, 住宅改修限度額確認)) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            to限度額リセット対象外(要介護状態区分３段階変更チェック, div, 限度額リセット対象外);
        }
        RString 改修住宅住所 = editor改修住宅住所(div);
        JutakuKaishuJyusyoChofukuHanntei chofukuHanntei = JutakuKaishuJyusyoChofukuHanntei.createInstance();
        boolean is改修住所重複 = true;
        if (ResponseHolder.isReRequest() && (改修住所_限度額リセット対象 || 改修住所_限度額リセット対象外)) {
            is改修住所重複 = ViewStateHolder.get(ViewStateKeys.改修住所重複, Boolean.class);
        } else {
            is改修住所重複 = chofukuHanntei.checkKaishuJyusyoChofukuToroku(被保険者番号,
                    最新住宅改修費支払結果.get開始サービス提供年月(), 終了サービス提供年月, 改修住宅住所);
            ViewStateHolder.put(ViewStateKeys.改修住所重複, 要介護状態３段階変更の判定);
        }
        if (is改修住所変更(is改修住所重複, 要介護状態区分３段階変更チェック)) {
            if (is改修住所_限度額リセット対象(改修住所_限度額リセット対象, 住宅改修限度額確認)) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            to改修住所_限度額リセット対象(要介護状態区分３段階変更チェック, div, 改修住所_限度額リセット対象);
        } else if (is要介護状態区分３段階変更flag(is改修住所重複, 要介護状態区分３段階変更チェック)) {
            if (is改修住所_限度額リセット対象(改修住所_限度額リセット対象外, 住宅改修限度額確認)) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            to改修住所_限度額リセット対象外(要介護状態区分３段階変更チェック, div, 改修住所_限度額リセット対象外);
        }
        boolean 限度額チェック = is改修住所重複 || 要介護状態３段階変更の判定;

        handler.支払結果の設定(被保険者番号, 限度額チェック);
        JutakuGaisuViewStateHolderParameter param = ViewStateHolder.get(ViewStateKeys.申請情報,
                JutakuGaisuViewStateHolderParameter.class);
        JutakuGaisuDataParameter 住宅改修データ = new JutakuGaisuDataParameter();
        住宅改修データ.set限度額リセット(要介護状態区分３段階変更チェック);
        住宅改修データ.set住宅改修データ(handler.get住宅改修内容一覧データ(
                div.getCcdJutakugaisyunaiyoList().get住宅改修内容一覧()));
        param.set住宅改修データ(住宅改修データ);
        ViewStateHolder.put(ViewStateKeys.申請情報, param);
        return ResponseData.of(div).respond();
    }

    /**
     * 「参考」ボタンをクリックします。
     *
     * @param div JutakuKaishuShinseiJyohoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuShinseiJyohoTorokuDiv> onClick_btnKeiyakuNo(JutakuKaishuShinseiJyohoTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 参照);
        return ResponseData.of(div).forwardWithEventName(DBC0710021TransitionEventName.to受領委任契約番号検索).respond();
    }

    private boolean is要介護状態区分３段階変更flag(boolean is改修住所重複, List<RString> 要介護状態区分３段階変更チェック) {
        return is改修住所重複 && (要介護状態区分３段階変更チェック != null && !要介護状態区分３段階変更チェック.isEmpty()
                && 要介護状態区分３段階変更チェック.contains(住宅住所変更による));
    }

    private boolean is要介護状態３段階変更flag(boolean 要介護状態３段階変更の判定,
            List<RString> 要介護状態区分３段階変更チェック) {
        return !要介護状態３段階変更の判定 && (要介護状態区分３段階変更チェック != null
                && !要介護状態区分３段階変更チェック.isEmpty()
                && 要介護状態区分３段階変更チェック.contains(要介護状態区分3段階変更による));
    }

    private RString editor改修住宅住所(JutakuKaishuShinseiJyohoTorokuDiv div) {
        List<dgGaisyuList_Row> gridList = div.getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        RString 改修住宅住所 = null;
        if (gridList != null && !gridList.isEmpty()) {
            改修住宅住所 = gridList.get(0).getTxtJutakuAddress();
        }
        return 改修住宅住所;
    }

    private boolean is改修住所変更(boolean is改修住所重複, List<RString> 要介護状態区分３段階変更チェック) {
        return !is改修住所重複 && (要介護状態区分３段階変更チェック == null || 要介護状態区分３段階変更チェック.isEmpty()
                || !要介護状態区分３段階変更チェック.contains(住宅住所変更による));
    }

    private boolean is要介護状態３段階変更(boolean 要介護状態３段階変更の判定,
            List<RString> 要介護状態区分３段階変更チェック) {
        return 要介護状態３段階変更の判定 && (要介護状態区分３段階変更チェック == null || 要介護状態区分３段階変更チェック.isEmpty()
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
            div.getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private void to改修住所_限度額リセット対象(List<RString> 要介護状態区分３段階変更チェック,
            JutakuKaishuShinseiJyohoTorokuDiv div,
            boolean 改修住所_限度額リセット対象) {
        if (改修住所_限度額リセット対象 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護状態区分３段階変更チェック.add(住宅住所変更による);
            div.getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private void to限度額リセット対象外(List<RString> 要介護状態区分３段階変更チェック,
            JutakuKaishuShinseiJyohoTorokuDiv div,
            boolean 限度額リセット対象外) {
        if (限度額リセット対象外 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護状態区分３段階変更チェック.remove(要介護状態区分3段階変更による);
            div.getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private void to限度額リセット対象(List<RString> 要介護状態区分３段階変更チェック,
            JutakuKaishuShinseiJyohoTorokuDiv div,
            boolean 限度額リセット対象) {
        if (限度額リセット対象 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護状態区分３段階変更チェック.add(要介護状態区分3段階変更による);
            div.getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().setSelectedItemsByKey(要介護状態区分３段階変更チェック);
        }
    }

    private JutakuKaishuShinseiJyohoTorokuHandler getHandler(JutakuKaishuShinseiJyohoTorokuDiv div) {
        return JutakuKaishuShinseiJyohoTorokuHandler.of(div);
    }

    private JutakuKaishuShinseiJyohoTorokuValidationHandler getJutakuKaishuShinseiJyohoTorokuValidationHandler(
            JutakuKaishuShinseiJyohoTorokuDiv div, RString 画面モード, RString 住宅改修内容チェックエラーメッセージ,
            boolean is給付率) {
        if (!RString.isNullOrEmpty(画面モード) || !RString.isNullOrEmpty(住宅改修内容チェックエラーメッセージ)) {
            return new JutakuKaishuShinseiJyohoTorokuValidationHandler(
                    画面モード, div, 住宅改修内容チェックエラーメッセージ, is給付率);
        } else {
            return new JutakuKaishuShinseiJyohoTorokuValidationHandler(div);
        }
    }

    private RString set画面モード(JutakuGaisuViewStateHolderParameter param, RString 画面モード) {
        if (param.get償還払支給判定結果() == null) {
            return 画面モード_修正;
        } else {
            return 画面モード;

        }
    }

    private void set旧措置者フラグ(YokaigoNinteiJyoho 要介護認定情報, JutakuKaishuShinseiJyohoTorokuDiv div) {
        if (要介護認定情報.is旧措置者フラグ()) {
            div.getCommHeadPanel().setIs旧措置者フラグ(YES);
        } else {
            div.getCommHeadPanel().setIs旧措置者フラグ(NO);
        }
    }
}
