/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0600021;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.ShichosonResult;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.DBC0600021StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.DBC0600021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.YoguKonyuhiShikyuShinseiPnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600021.YoguKonyuhiShikyuShinseiPnlTotalHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600021.YoguKonyuhiShikyuShinseiPnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 画面設計_DBCMN51001_福祉用具購入費支給申請_明細登録
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class YoguKonyuhiShikyuShinseiPnlTotal {

    private static final RString NUM2 = new RString("2");
    private static final RString NUM1 = new RString("1");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 処理モード登録 = new RString("処理モード登録");
    private static final RString 処理モード修正 = new RString("処理モード修正");
    private static final RString 処理モード削除 = new RString("処理モード削除");
    private static final RString 処理モード選択 = new RString("処理モード選択");
    private static final RString 参照 = new RString("参照");
    private static final RString 審査 = new RString("審査");
    private static final RString 償還払給付費 = new RString("001");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onLoad(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getKaigoCommonPanel().getCcdAtenaInfo().onLoad(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getKaigoCommonPanel().getCcdShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getKaigoCommonPanel().getCcdShikakuKihon().setDisplayNone(true);
        }

        PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.支給申請情報検索キー,
                PnlTotalParameter.class);
        getHandler(div).get申請者区分リスト();
        ShokanShinsei shshResult = null;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).set登録モード();
            ServiceShuruiCode サービス種類 = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getServiceShuruiCode(被保険者番号, new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                                    getTxtTeikyoYM().getValue().getYearMonth().toString()));
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtServiceCode().setValue(サービス種類.value());
            RString 証明書コード = RString.EMPTY;
            if (new RString("41").equals(サービス種類.value())) {
                証明書コード = new RString("212C");
            }
            if (new RString("44").equals(サービス種類.value())) {
                証明書コード = new RString("21C2");
            }
            RString 証明書略称 = FukushiyoguKonyuhiShikyuShinsei.createInstance().getYoshikiName(
                    証明書コード, new FlexibleYearMonth(div.
                            getYoguKonyuhiShikyuShinseiContentsPanel().
                            getTxtTeikyoYM().getValue().getYearMonth().toString()));
            RStringBuilder builder = new RStringBuilder();
            builder.append(証明書コード);
            builder.append(new RString(" "));
            builder.append(証明書略称);
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(builder.toRString());
            ViewStateHolder.put(ViewStateKeys.証明書, div.
                    getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().getValue());
            ViewStateHolder.put(ViewStateKeys.様式番号, 証明書コード);
        } else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).set修正モード();
        } else if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).set削除モード();
        } else if (参照.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).set参照モード();

        } else if (審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).set審査モード();
        }
        if (!登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            FlexibleYearMonth サービス提供年月 = parameter.getTeikyoYM();
            RString 整理番号 = parameter.getSerialNo();
            RString 様式番号 = parameter.getYoshikiNo();
            JigyoshaNo 事業者番号 = parameter.getJigyosyaNo();
            RString 明細番号 = parameter.getMeisaiNo();
            ViewStateHolder.put(ViewStateKeys.事業者番号, 事業者番号);
            ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス提供年月);
            ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
            ShokanKihon shokankihon = FukushiyoguKonyuhiShikyuShinsei.createInstance().getShokanSeikyuKihon(
                    被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            ViewStateHolder.put(ViewStateKeys.福祉償還払請求基本, shokankihon);
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDataSource(
                    getHandler(div).get保険者(サービス提供年月));
            if (shokankihon == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            List<ShokanFukushiYoguHanbaihi> shfuhalist = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanFukushiYoguHanbaihi(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            ViewStateHolder.put(ViewStateKeys.福祉用具販売費, (Serializable) shfuhalist);
            SokanbaraiShiharaiKekkaResult maeResult = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShiharaiKekkaAll(被保険者番号, サービス提供年月);
            shshResult = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShinsei(被保険者番号, サービス提供年月, 整理番号);
            ViewStateHolder.put(ViewStateKeys.福祉償還払支給申請, shshResult);
            HokenKyufuRitsu hokenkyufuritsu = JutakuKaishuJizenShinsei.createInstance().
                    getKyufuritsu(被保険者番号, サービス提供年月);
            ShokanShukei shokanShukei = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShukei(被保険者番号, サービス提供年月, 整理番号);
            ViewStateHolder.put(ViewStateKeys.福祉償還払請求集計, shokanShukei);
            RString 略称 = FukushiyoguKonyuhiShikyuShinsei.createInstance().getYoshikiName(
                    様式番号, サービス提供年月);
            getHandler(div).get証明書(shokankihon, 略称);
            RString 証明書 = div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().getValue();
            ViewStateHolder.put(ViewStateKeys.証明書, 証明書);
            getHandler(div).支給申請内容エリア(shokankihon, shshResult);
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().
                    setDataSource(getHandler(div).get種目());
            if (maeResult != null) {
                //TODO QA623
//            getHandler(div).今までの支払結果情報(maeResult);
//            getHandler(div).今回登録済みの支払結果情報(nowResult);
                maeResult.hashCode();
            }
            if (!shfuhalist.isEmpty()) {
                getHandler(div).福祉用具販売費情報(shfuhalist);
            }
            getHandler(div).get給付率(hokenkyufuritsu);
            ViewStateHolder.put(ViewStateKeys.給付率, hokenkyufuritsu);
        }
        SikyuSinseiJyohoParameter para = new SikyuSinseiJyohoParameter();
        if (shshResult != null) {
            para.setShikibetsuCode(識別コード);
            para.setHihokenshaNo(shshResult.get被保険者番号());
            para.setShikyushinseiServiceYM(shshResult.getサービス提供年月());
            para.setShikyushinseiSeiriNo(shshResult.get整理番号());
            para.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(shshResult.get支払方法区分コード()));
            para.setKeiyakuNo(shshResult.get受領委任契約番号());
            if (shshResult.get支払期間開始年月日() != null) {
                para.setStartYMD(new RDate(shshResult.get支払期間開始年月日().toString()));
            }
            if (shshResult.get支払期間終了年月日() != null) {
                para.setEndYMD(new RDate(shshResult.get支払期間終了年月日().toString()));
            }
            para.setStartHHMM(new RTime(shshResult.get支払窓口開始時間()));
            para.setEndHHMM(new RTime(shshResult.get支払窓口終了時間()));
            para.setKozaId(shshResult.get口座ID());
            para.setShiharaiBasho(shshResult.get支払場所());
            getHandler(div).償還払支給申請情報(shshResult);
            支払方法情報状態(div, para);
        }
//        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            償還払支給判定結果を取得する();
//        }

        YoguKonyuhiShikyuShinseiPnlTotalParameter 画面データ = getHandler(div).set画面データ();
        ViewStateHolder.put(ViewStateKeys.福祉用具購入費支給申請_明細登録画面データ, 画面データ);
        return createResponse(div);
    }

    private void 支払方法情報状態(YoguKonyuhiShikyuShinseiPnlTotalDiv div, SikyuSinseiJyohoParameter para) {
        if (参照.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                || 削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdShiharaiHohoInfo().initialize(
                    para, new KamokuCode(償還払給付費), 参照);
        } else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdShiharaiHohoInfo().initialize(
                    para, new KamokuCode(償還払給付費), 修正);
        } else if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdShiharaiHohoInfo().initialize(
                    para, new KamokuCode(償還払給付費), 登録);
        }
    }

    /**
     * 提供（購入）年月onFocusout
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onFocusout(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.
                getYoguKonyuhiShikyuShinseiContentsPanel().
                getTxtTeikyoYM().getValue().getYearMonth().toString());
        // サービス種類取得
        ServiceShuruiCode サービス種類 = FukushiyoguKonyuhiShikyuShinsei.
                createInstance().getServiceShuruiCode(被保険者番号, サービス提供年月);
        // 5.1　取得されたデータを画面のサービス種類（hidden)に設定する。　（保存の時に使うため）
        RString 証明書コード = RString.EMPTY;
        if (new RString("41").equals(サービス種類.value())) {
            証明書コード = new RString("212C");
        }
        if (new RString("44").equals(サービス種類.value())) {
            証明書コード = new RString("21C2");
        }
        // TODO  パラメータ：証明書コード
        RString 証明書略称 = FukushiyoguKonyuhiShikyuShinsei.createInstance().getYoshikiName(証明書コード, サービス提供年月);
        RStringBuilder builder = new RStringBuilder();
        builder.append(証明書コード);
        builder.append(new RString(" "));
        builder.append(証明書略称);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(builder.toRString());
        List<ShichosonResult> 保険者リスト = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getHokensyaList(被保険者番号, サービス提供年月);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShichosonResult result : 保険者リスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource(result.
                    get証記載保険者番号().value(), result.get市町村名称());
            dataSourceList.add(dataSource);
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDataSource(dataSourceList);

//        ShokanKihon shokankihon = FukushiyoguKonyuhiShikyuShinsei.createInstance().getShokanSeikyuKihon(
//                被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//        RString 略称 = FukushiyoguKonyuhiShikyuShinsei.createInstance().getYoshikiName(
//                様式番号, サービス提供年月);
//        getHandler(div).get証明書(shokankihon, 略称);
        RString 証明書 = div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().getValue();
        ViewStateHolder.put(ViewStateKeys.証明書, 証明書);
        return createResponse(div);

    }

    /**
     * 明細を確定する」ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnModifyDetail(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        RString モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (処理モード登録.equals(モード)
                || 処理モード削除.equals(モード)) {
            ValidationMessageControlPairs validPairs = getHandler(div).確定チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHandler(div).readOnly福祉用具購入費明細(false);
        dgSeikyuDetail_Row row;
        if (処理モード登録.equals(モード)) {
            row = new dgSeikyuDetail_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        getHandler(div).modifyRow(row);
        //TODO
//        getHandler(div).今回の支払状況連動();
        return createResponse(div);
    }

    /**
     * 「明細を追加する」ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnAddDetail(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
//        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        getHandler(div).readOnly福祉用具購入費明細(false);
        // TODO  明細のモード（hidden)：登録
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード登録);
        getHandler(div).clear福祉用具購入費明細();
        return createResponse(div);
    }

    /**
     * 「入力内容をクリアする」ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnClear(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        getHandler(div).clear福祉用具購入費明細();
        getHandler(div).readOnly福祉用具購入費明細(true);
//        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnClear().setDisabled(true);
        return createResponse(div);
    }

    /**
     * 福祉用具購入費グリッドの選択ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onSelectBySelectButton(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
//        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        getHandler(div).set福祉用具購入費明細();
        getHandler(div).readOnly福祉用具購入費明細(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnModifyDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnClear().setDisabled(true);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード選択);
        return createResponse(div);
    }

    /**
     * 福祉用具購入費グリッドの修正ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onSelectByModifyButton(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
//        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        getHandler(div).set福祉用具購入費明細();
        getHandler(div).readOnly福祉用具購入費明細(false);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード修正);
        return createResponse(div);
    }

    /**
     * 福祉用具購入費グリッドの削除ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onSelectByDeleteButton(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
//        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        getHandler(div).set福祉用具購入費明細();
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード削除);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().setDisabled(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnModifyDetail().setDisabled(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnClear().setDisabled(false);
        return createResponse(div);
    }

    /**
     * onClick_btnFree事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnFree(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        boolean flag = true;
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る).respond();
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                || 修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            flag = getHandler(div).is内容変更状態();
        }
        if (審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            審査場合(div);

        }
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            //TODO
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る).respond();
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る).respond();
        }

        return createResponse(div);
    }

    /**
     * 領収年月日 onFocusout
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onFocusout_txtRyosyuYMD(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        //TODO自己決定
        HokenKyufuRitsu 給付率 = JutakuKaishuJizenShinsei.createInstance().getKyufuritsu(
                new HihokenshaNo(div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号()),
                new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getPnlShinsesyaJoho().getTxtRyosyuYMD().getValue().getYearMonth().toString()));
        getHandler(div).get給付率(給付率);
        return createResponse(div);
    }

    private ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> 審査場合(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            //TODO
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る)
                        .parameter(new RString("一覧に戻る"));
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る)
                    .parameter(new RString("一覧に戻る"));
        }

        return createResponse(div);
    }

    /**
     * 「本人情報をコピーする」ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnHonninJohoCopy(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        getHandler(div).set申請者情報();
        return createResponse(div);
    }

    /**
     * onClick_btnSave事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnSave(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return 保存処理(div, 削除);
        } else {
            boolean flag = getHandler(div).is内容変更状態();
            if (flag) {
                ValidationMessageControlPairs validPairs = getHandler(div).保存チェック();
                if (validPairs.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(validPairs).respond();
                }
                RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
                return 保存処理(div, 状態);
            } else {
                return notChanges(div);
            }
        }

    }

    /**
     * 「申請事業者参考」ボタンを押した後のメソッドです。
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onBeforeOpenDialog_btnJigyosha(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        JigyoshaMode jigyoshaMode = new JigyoshaMode();
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.code());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者・施設選択入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onOkClose_btnJigyosha(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getJigyoshaMode(), JigyoshaMode.class);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya().setValue(
                jigyoshaMode.getJigyoshaNo().value());
        return ResponseData.of(div).respond();
    }

    private ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> 保存処理(YoguKonyuhiShikyuShinseiPnlTotalDiv div, RString 状態) {
        try {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).保存処理();
                if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                        || 修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                            UrQuestionMessages.確認_汎用.getMessage().replace("決定情報の登録を続きます").evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ViewStateHolder.put(ViewStateKeys.被保険者番号,
                        new HihokenshaNo(div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号()));
                ViewStateHolder.put(ViewStateKeys.サービス提供年月,
                        new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                                getTxtTeikyoYM().getValue().getYearMonth().toString()));
                ViewStateHolder.put(ViewStateKeys.事業者番号,
                        new JigyoshaNo(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue()));
                ViewStateHolder.put(ViewStateKeys.給付率,
                        new HokenKyufuRitsu(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().getValue()));
                return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.決定情報).respond();
            }
            if (!new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
                div.getPnlKeteiJohoMsg().getCcdMessage().setMessage(
                        new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号(),
                        div.getKaigoCommonPanel().getCcdAtenaInfo().get氏名漢字(),
                        true);
                return ResponseData.of(div).setState(DBC0600021StateName.successSaved);
            }
            return ResponseData.of(div).respond();
        } catch (Exception e) {
            e.toString();
            div.getPnlKeteiJohoMsg().getCcdMessage().setMessage(
                    new RString(UrErrorMessages.異常終了.getMessage().evaluate()),
                    div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号(),
                    div.getKaigoCommonPanel().getCcdAtenaInfo().get氏名漢字(),
                    false);
            return ResponseData.of(div).setState(DBC0600021StateName.successSaved);
        }
    }

    private ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> notChanges(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    private void 償還払支給判定結果を取得する() {
        RString 受託区分 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
        PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.支給申請情報検索キー,
                PnlTotalParameter.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = parameter.getTeikyoYM();
        RString 整理番号 = parameter.getSerialNo();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        ShokanShinsei shshResult = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getShokanShinsei(被保険者番号, サービス提供年月, 整理番号);
        List<KyufujissekiKihon> kyufulist = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getKyufuJissekiKihonList(様式番号, new HokenshaNo(shshResult.get証記載保険者番号().value()),
                        被保険者番号, サービス提供年月, 整理番号, 明細番号);
        ShokanHanteiKekka shokanhanteike = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getShokanHanteiKekka(被保険者番号, サービス提供年月, 整理番号);
        ViewStateHolder.put(ViewStateKeys.償還払支給判定結果, shokanhanteike);
        if (shokanhanteike == null && NUM2.equals(受託区分)) {
            throw new ApplicationException(
                    UrErrorMessages.更新不可.getMessage().
                    replace("国保連合会より送付されてくる決定情報がまだ取り込まなかった"));
        } else if (shokanhanteike != null && NUM2.equals(受託区分) && NUM1.equals(shokanhanteike.
                get支給_不支給決定区分()) && (kyufulist == null || kyufulist.isEmpty())) {
            //TODO 画面モードを照会モードに変更する
            throw new ApplicationException(
                    UrErrorMessages.更新不可.getMessage().
                    replace("国保連合会より送付されてくる決定情報がまだ取り込まなかった"));

        } else if (shokanhanteike != null && NUM2.equals(受託区分) && kyufulist.size() > 0) {
            int i = 0;
            int 後保険請求額 = 0;
            FlexibleYearMonth max審査年月 = getMax審査年月(kyufulist);
            for (KyufujissekiKihon kylist : kyufulist) {
                int t = i;
                int y = 後保険請求額;
                i = (max審査年月 == kylist.get審査年月()) ? t + 1 : t;
                後保険請求額 = (max審査年月 == kylist.get審査年月()) ? kylist.get後_保険_特定診療費請求額().intValue() : 0;
                if (i > 1) {
                    throw new ApplicationException(
                            DbcErrorMessages.給付実績複数件取得.getMessage());
                }
            }
            if (i == 1 && 後保険請求額 != shshResult.get保険給付額()) {
                //TODO B)  上記A)以外の場合
                throw new ApplicationException(
                        UrErrorMessages.更新不可.getMessage().
                        replace("国保連合会より送付されてくる決定情報がまだ取り込まなかった"));
            }
        }

    }

    private FlexibleYearMonth getMax審査年月(List<KyufujissekiKihon> kyufulist) {

        FlexibleYearMonth max審査年月 = kyufulist.get(0).get審査年月();
        for (KyufujissekiKihon kylist : kyufulist) {
            FlexibleYearMonth 審査年月 = kylist.get審査年月();
            max審査年月 = max審査年月.compareTo(審査年月) > 0 ? max審査年月 : 審査年月;
        }
        return max審査年月;

    }

    private ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> createResponse(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    private YoguKonyuhiShikyuShinseiPnlTotalHandler getHandler(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        return new YoguKonyuhiShikyuShinseiPnlTotalHandler(div);
    }

//    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_(
//            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
//        boolean flag = FukushiyoguKonyuhiShikyuGendogaku.createInstance().chkKonyuhiShikyuGendogaku(被保険者番号,
//                サービス提供年月,
//                整理番号,
//                事業者番号,
//                様式番号,
//                明細番号,
//                今回の保険対象費用額);
//
//    }
}
