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
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.ShichosonResult;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogushohin.FukushiyoguShohinMode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.DBC0600021StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.DBC0600021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.YoguKonyuhiShikyuShinseiPnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600021.YoguKonyuhiShikyuShinseiPnlTotalHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600021.YoguKonyuhiShikyuShinseiPnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiYoguKounyuhiDouituHinmokuChofukuHantei;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuGendogaku;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 画面設計_DBCMN51001_福祉用具購入費支給申請_明細登録
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class YoguKonyuhiShikyuShinseiPnlTotal {

    private static final RString BLANK = new RString("0");
    private static final RString NUM2 = new RString("2");
    private static final RString NUM3 = new RString("0000000000");
    private static final RString NUM1 = new RString("1");
    private static final RString NUM41 = new RString("41");
    private static final RString NUM44 = new RString("44");
    private static final RString 証明書コード1 = new RString("21C1");
    private static final RString 証明書コード2 = new RString("21C2");
    private static final RString 保存確認 = new RString("保存確認");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 処理モード登録 = new RString("処理モード登録");
    private static final RString 処理モード修正 = new RString("処理モード修正");
    private static final RString 処理モード削除 = new RString("処理モード削除");
    private static final RString 処理モード選択 = new RString("処理モード選択");
    private static final RString 参照 = new RString("参照");
    private static final RString 照会 = new RString("照会");
    private static final RString 審査 = new RString("審査");
    private static final RString 品目コード = new RString("品目コード");
    private static final RString 決定情報 = new RString("決定情報の登録を続きます");
    private static final RString 福祉用具購入費明細情報が0件 = new RString("福祉用具購入費明細情報が0件");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onLoad(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getKaigoCommonPanel().getCcdAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getKaigoCommonPanel().getCcdShikakuKihon().initialize(被保険者番号);
        } else {
            div.getKaigoCommonPanel().getCcdShikakuKihon().setDisplayNone(true);
        }
        PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.検索キー,
                PnlTotalParameter.class);
        getHandler(div).get申請者区分リスト();
        ShokanShinsei shshResult = null;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).set登録モード();
            FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getTxtTeikyoYM().getValue().getYearMonth().toString());
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス提供年月);
            RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString();
            JigyoshaNo 事業者番号 = new JigyoshaNo(NUM3);
            ViewStateHolder.put(ViewStateKeys.事業者番号, 事業者番号);
            ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
            ServiceShuruiCode サービス種類 = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getServiceShuruiCode(被保険者番号, new FlexibleYearMonth(div.
                                    getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().
                                    getValue().getYearMonth().toString()));
            RString 証明書コード = RString.EMPTY;
            if (NUM41.equals(サービス種類.value())) {
                証明書コード = 証明書コード1;
            }
            if (NUM44.equals(サービス種類.value())) {
                証明書コード = 証明書コード2;
            }
            RString 証明書略称 = FukushiyoguKonyuhiShikyuShinsei.createInstance().getYoshikiName(
                    証明書コード, new FlexibleYearMonth(div.
                            getYoguKonyuhiShikyuShinseiContentsPanel().
                            getTxtTeikyoYM().getValue().getYearMonth().toString()));
            RStringBuilder builder = new RStringBuilder();
            builder.append(証明書コード);
            builder.append(RString.HALF_SPACE);
            builder.append(証明書略称);
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(builder.toRString());
            ViewStateHolder.put(ViewStateKeys.証明書, div.
                    getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().getValue());
            ViewStateHolder.put(ViewStateKeys.様式番号, 証明書コード);
            SokanbaraiShiharaiKekkaResult maeResult = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShiharaiKekkaAll(被保険者番号, ViewStateHolder.get(
                                    ViewStateKeys.サービス提供年月, FlexibleYearMonth.class));
            if (maeResult != null) {
                getHandler(div).登録前回支払結果情報(maeResult);
            }
            支払方法情報登録状態(div, 識別コード);
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
            SokanbaraiShiharaiKekkaResult nowResult = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShiharaiKekka(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            getHandler(div).登録以外前回支払結果情報(maeResult, nowResult);
            getHandler(div).今回支払結果情報(nowResult);
            shshResult = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShinsei(被保険者番号, サービス提供年月, 整理番号);
            ViewStateHolder.put(ViewStateKeys.福祉償還払支給申請, shshResult);
            ShokanShukei shokanShukei = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShukei(被保険者番号, サービス提供年月, 整理番号);
            ViewStateHolder.put(ViewStateKeys.福祉償還払請求集計, shokanShukei);
            RString 略称 = FukushiyoguKonyuhiShikyuShinsei.createInstance().getYoshikiName(
                    様式番号, サービス提供年月);
            getHandler(div).get証明書(shokankihon, 略称);
            RString 証明書 = div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().getValue();
            ViewStateHolder.put(ViewStateKeys.証明書, 証明書);
            getHandler(div).支給申請内容エリア(shokankihon, shshResult);
            if (!shfuhalist.isEmpty()) {
                getHandler(div).福祉用具販売費情報(shfuhalist);
            }
            onLoad国保連再送付(div);
            償還払支給判定結果を取得する(div);
            ViewStateHolder.put(ViewStateKeys.給付率, new HokenKyufuRitsu(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().getValue()));
        }
        if (shshResult != null) {
            getHandler(div).償還払支給申請情報(shshResult);
            支払方法情報登録外状態(div, shshResult, 識別コード);
        }
        onLoad審査方法(div);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().
                setDataSource(getHandler(div).get種目());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().setSelectedKey(BLANK);
        ServiceShuruiCode サービス種類 = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getServiceShuruiCode(被保険者番号, new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                                getTxtTeikyoYM().getValue().getYearMonth().toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtServiceCode().setValue(サービス種類.value());
        YoguKonyuhiShikyuShinseiPnlTotalParameter 画面データ = getHandler(div).set画面データ();
        ViewStateHolder.put(ViewStateKeys.明細データ, 画面データ);
        return createResponse(div);
    }

    private void onLoad国保連再送付(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        ShokanShinsei shshResult = ViewStateHolder.get(ViewStateKeys.福祉償還払支給申請, ShokanShinsei.class);
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (shshResult != null && shshResult.get送付年月() != null && 受託区分.equals(NUM2)) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().setVisible(true);
        } else {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().setDisplayNone(true);
        }

    }

    private void onLoad審査方法(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託区分 != null && 受託区分.equals(NUM1)) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                    getRadShinsaMethod().setSelectedKey(NUM2);
        } else if (受託区分 != null && 受託区分.equals(NUM2)) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                    getRadShinsaMethod().setSelectedKey(NUM1);
        }
    }

    private void 支払方法情報登録状態(YoguKonyuhiShikyuShinseiPnlTotalDiv div,
            ShikibetsuCode 識別コード) {
        SikyuSinseiJyohoParameter para = new SikyuSinseiJyohoParameter();
        para.setShikibetsuCode(識別コード);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdShiharaiHohoInfo().initialize(
                para, 登録);
    }

    private void 支払方法情報登録外状態(YoguKonyuhiShikyuShinseiPnlTotalDiv div,
            ShokanShinsei shshResult,
            ShikibetsuCode 識別コード) {
        SikyuSinseiJyohoParameter para = new SikyuSinseiJyohoParameter();
        para.setShikibetsuCode(識別コード);
        para.setHihokenshaNo(shshResult.get被保険者番号());
        para.setShikyushinseiServiceYM(shshResult.getサービス提供年月());
        para.setShikyushinseiSeiriNo(shshResult.get整理番号());
        if (shshResult.get支払方法区分コード() != null) {
            para.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(shshResult.get支払方法区分コード()));
        }
        para.setKeiyakuNo(shshResult.get受領委任契約番号());
        if (shshResult.get支払期間開始年月日() != null) {
            para.setStartYMD(new RDate(shshResult.get支払期間開始年月日().toString()));
        }
        if (shshResult.get支払期間終了年月日() != null) {
            para.setEndYMD(new RDate(shshResult.get支払期間終了年月日().toString()));
        }
        if (shshResult.get支払窓口開始時間() != null) {
            para.setStartHHMM(new RTime(shshResult.get支払窓口開始時間()));
        }
        if (shshResult.get支払窓口終了時間() != null) {
            para.setEndHHMM(new RTime(shshResult.get支払窓口終了時間()));
        }
        para.setKozaId(shshResult.get口座ID());
        para.setShiharaiBasho(shshResult.get支払場所());
        if (参照.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                || 削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdShiharaiHohoInfo().initialize(
                    para, 照会);
        } else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                || 審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdShiharaiHohoInfo().initialize(
                    para, 修正);
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
        ServiceShuruiCode サービス種類 = FukushiyoguKonyuhiShikyuShinsei.
                createInstance().getServiceShuruiCode(被保険者番号, サービス提供年月);
        RString 証明書コード = RString.EMPTY;
        if (NUM41.equals(サービス種類.value())) {
            証明書コード = 証明書コード1;
        }
        if (NUM44.equals(サービス種類.value())) {
            証明書コード = 証明書コード2;
        }
        RString 証明書略称 = FukushiyoguKonyuhiShikyuShinsei.
                createInstance().getYoshikiName(証明書コード, サービス提供年月);
        RStringBuilder builder = new RStringBuilder();
        builder.append(証明書コード);
        builder.append(RString.HALF_SPACE);
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
        if (!dataSourceList.isEmpty()) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().
                    setSelectedKey(dataSourceList.get(0).getKey());
        }
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
        ValidationMessageControlPairs validPairs = getHandler(div).確定チェック(モード);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).readOnly福祉用具購入費明細(false);
        dgSeikyuDetail_Row row;
        if (処理モード登録.equals(モード)) {
            row = new dgSeikyuDetail_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        getHandler(div).modifyRow(row, モード);
        getHandler(div).clear福祉用具購入費明細();
        getHandler(div).今回の支払状況連動();
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
        getHandler(div).readOnly福祉用具購入費明細(false);
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
        if (!登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.検索キー,
                    PnlTotalParameter.class);
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            FlexibleYearMonth サービス提供年月 = parameter.getTeikyoYM();
            RString 整理番号 = parameter.getSerialNo();
            RString 様式番号 = parameter.getYoshikiNo();
            JigyoshaNo 事業者番号 = parameter.getJigyosyaNo();
            RString 明細番号 = parameter.getMeisaiNo();
            ShokanKihon shokankihon = FukushiyoguKonyuhiShikyuShinsei.createInstance().getShokanSeikyuKihon(
                    被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (shokankihon == null) {
                return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る).respond();
            }
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                || 参照.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る).respond();
        }
        YoguKonyuhiShikyuShinseiPnlTotalParameter para = ViewStateHolder.get(
                ViewStateKeys.明細データ, YoguKonyuhiShikyuShinseiPnlTotalParameter.class);
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)) || 登録.equals(
                ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            flag = getHandler(div).is内容変更状態(para);
        }
        if (審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            flag = getHandler(div).is内容変更状態(para);

        }
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0600021TransitionEventName.一覧に戻る).respond();
            } else {
                ResponseData.of(div).respond();
            }
        } else {
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
        HokenKyufuRitsu 給付率;
        try {
            給付率 = JutakuKaishuJizenShinsei.createInstance().getKyufuritsu(
                    new HihokenshaNo(div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号()),
                    new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                            getPnlShinsesyaJoho().getTxtRyosyuYMD().getValue().getYearMonth().toString()));
        } catch (Exception e) {
            給付率 = null;
        }
        getHandler(div).get給付率(給付率);
        ViewStateHolder.put(ViewStateKeys.給付率, new HokenKyufuRitsu(
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().getValue()));
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
        JigyoshaNo 事業者番号 = null;
        RString 整理番号;
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().getValue().getYearMonth().toString());
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        } else {
            整理番号 = div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().getValue();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue() != null) {
            事業者番号 = new JigyoshaNo(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue());
        }
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        List<ShokanFukushiYoguHanbaihi> list = getHandler(div).getGridData(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号);
        FukushiYoguKounyuhiDouituHinmokuChofukuHantei entity = new FukushiYoguKounyuhiDouituHinmokuChofukuHantei();
        boolean flag = entity.chkHinmokuCodePerYear(被保険者番号, サービス提供年月, list, 整理番号);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return 保存処理(div);
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource() == null
                || div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource().isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().
                    replace(福祉用具購入費明細情報が0件.toString()));
        }
        YoguKonyuhiShikyuShinseiPnlTotalParameter para = ViewStateHolder.get(
                ViewStateKeys.明細データ, YoguKonyuhiShikyuShinseiPnlTotalParameter.class);
        if (!getHandler(div).is内容変更状態(para)) {
            return notChanges(div);
        }
        if (flag) {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(品目コード.toString()));
        }
        ValidationMessageControlPairs validPairs;
        if (!ResponseHolder.isWarningIgnoredRequest() && !保存確認.equals(div.getCheckflag())) {
            validPairs = getHandler(div).保存チェック(true, 被保険者番号, サービス提供年月, 様式番号, 整理番号);
        } else {
            validPairs = getHandler(div).保存チェック(false, 被保険者番号, サービス提供年月, 様式番号, 整理番号);
        }

        if (validPairs != null && validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return 保存処理(div);
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
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
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

    /**
     * 「商品名入力ガイド
     *
     * @param div 住宅改修費支給申請_申請情報登録DIV
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onBeforeOpenDialog_btnShohinmei(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「商品名入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onOkClose_btnShohinmei(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        FukushiyoguShohinMode jigyoshaMode = DataPassingConverter.deserialize(div.
                getYoguKonyuhiShikyuShinseiContentsPanel().
                getFukushiyoguShohinMode(), FukushiyoguShohinMode.class);
        if (jigyoshaMode != null && jigyoshaMode.getShohinmei() != null && !jigyoshaMode.getShohinmei().isEmpty()) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtShohinName().
                    setValue(jigyoshaMode.getShohinmei());
        }
        if (jigyoshaMode != null && jigyoshaMode.getSeizoJigyoshamei() != null
                && !jigyoshaMode.getSeizoJigyoshamei().isEmpty()) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtSeizoJigyosha().
                    setValue(jigyoshaMode.getSeizoJigyoshamei());
        }
        if (jigyoshaMode != null && jigyoshaMode.getHinmokuCode() != null && !jigyoshaMode.getHinmokuCode().isEmpty()) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHinmokuCode().
                    setValue(jigyoshaMode.getHinmokuCode());
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> 保存処理(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        try {
            if (!保存確認.equals(div.getCheckflag())) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                div.setCheckflag(保存確認);
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.検索キー,
                        PnlTotalParameter.class);
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
                ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
                RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
                RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
                ShokanKihon shokankihon = ViewStateHolder.get(ViewStateKeys.福祉償還払請求基本, ShokanKihon.class);
                ShokanShinsei shshResult = ViewStateHolder.get(ViewStateKeys.福祉償還払支給申請, ShokanShinsei.class);
                ShokanShukei shokanShukei = ViewStateHolder.get(ViewStateKeys.福祉償還払請求集計, ShokanShukei.class);
                List<ShokanFukushiYoguHanbaihi> shkonlist = ViewStateHolder.get(
                        ViewStateKeys.福祉用具販売費, List.class);
                ShokanHanteiKekka 償還払支給判定結果 = ViewStateHolder.get(
                        ViewStateKeys.償還払支給判定結果, ShokanHanteiKekka.class);
                getHandler(div).保存処理(parameter, 被保険者番号, 識別コード, 状態, 整理番号,
                        shokankihon, shshResult, shokanShukei, shkonlist, 償還払支給判定結果);
                if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                        || 修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                            UrQuestionMessages.確認_汎用.getMessage().replace(決定情報.toString()).evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                } else {
                    div.getPnlKeteiJohoMsg().getCcdMessage().setMessage(
                            UrInformationMessages.保存終了,
                            div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号(),
                            div.getKaigoCommonPanel().getCcdAtenaInfo().get氏名漢字(),
                            true);
                    return ResponseData.of(div).setState(DBC0600021StateName.successSaved);
                }
            } else {
                div.setCheckflag(RString.EMPTY);
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
                        UrInformationMessages.保存終了,
                        div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号(),
                        div.getKaigoCommonPanel().getCcdAtenaInfo().get氏名漢字(),
                        true);
                return ResponseData.of(div).setState(DBC0600021StateName.successSaved);
            }
            return ResponseData.of(div).respond();
        } catch (Exception e) {
            e.toString();
            div.getPnlKeteiJohoMsg().getCcdMessage().setMessage(
                    UrErrorMessages.異常終了,
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

    private void 償還払支給判定結果を取得する(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.検索キー,
                PnlTotalParameter.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = parameter.getTeikyoYM();
        RString 整理番号 = parameter.getSerialNo();
        RString 様式番号 = parameter.getYoshikiNo();
        ShokanShinsei shshResult = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getShokanShinsei(被保険者番号, サービス提供年月, 整理番号);
        ShokanHanteiKekka shokanhanteike = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                getShokanHanteiKekka(被保険者番号, サービス提供年月, 整理番号);
        ViewStateHolder.put(ViewStateKeys.償還払支給判定結果, shokanhanteike);
        RString モード = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (shokanhanteike == null && NUM2.equals(受託区分) && 修正.equals(モード)) {
            getHandler(div).set参照モード();
        } else if (shokanhanteike != null && NUM2.equals(受託区分) && NUM1.equals(shokanhanteike.
                get支給_不支給決定区分())) {
            List<KyufujissekiKihon> kyufulist = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getKyufuJissekiKihonList(
                            様式番号,
                            new HokenshaNo(shshResult.get証記載保険者番号().value()),
                            被保険者番号,
                            サービス提供年月,
                            整理番号,
                            KyufuJissekiKubun.償還.getコード());
            if (kyufulist == null || kyufulist.isEmpty()) {
                getHandler(div).set参照モード();
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().setDisabled(false);
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShiharaiHoho().setDisabled(false);

            } else {
                償還払支給判定結果を取得2する(div, kyufulist, shshResult);
            }
        }

    }

    private void 償還払支給判定結果を取得2する(YoguKonyuhiShikyuShinseiPnlTotalDiv div,
            List<KyufujissekiKihon> kyufulist,
            ShokanShinsei shshResult) {
        int i = 0;
        int 後保険請求額 = 0;
        FlexibleYearMonth max審査年月 = getMax審査年月(kyufulist);
        for (KyufujissekiKihon kylist : kyufulist) {
            int t = i;
            i = (max審査年月 == kylist.get審査年月()) ? t + 1 : t;
            if (kylist.get後_保険_請求額() != null) {
                後保険請求額 = (max審査年月 == kylist.get審査年月()) ? kylist.get後_保険_請求額().intValue() : 0;
            }
        }
        if (i > 0 && kyufulist.size() > 1) {
            throw new ApplicationException(DbcErrorMessages.給付実績複数件取得.getMessage());
        } else {
            if (後保険請求額 == shshResult.get保険給付額()) {
                div.getPnlButton().getBtnKetteiJoho().setDisabled(false);
                shshResult.get審査結果();
            } else {
                getHandler(div).set参照モード();
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().setDisabled(false);
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShiharaiHoho().setDisabled(false);
                div.getPnlButton().getBtnKetteiJoho().setDisabled(false);
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

    /**
     * 「過去の福祉用具購入費を確定する」ボタンのメソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnKakoFukushiyogukonyuhiKakutei(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        JigyoshaNo 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, JigyoshaNo.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 明細番号 = null;
        SokanbaraiShiharaiKekkaResult 今までの支払結果 = FukushiyoguKonyuhiShikyuShinsei.createInstance()
                .getShokanShiharaiKekkaAll(被保険者番号, サービス提供年月);
        Decimal 費用額合計;
        Decimal 保険対象費用額;
        Decimal 保険給付額;
        Decimal 利用者負担額;
        if (今までの支払結果 == null) {
            getHandler(div).set前回までの支払結果(Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO);
            ShokanShinsei 償還払支給申請情報 = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShinsei(被保険者番号, サービス提供年月, 整理番号);
            if (償還払支給申請情報 != null) {
                getHandler(div).償還払支給申請情報(償還払支給申請情報);
                支払方法情報登録外状態(div, 償還払支給申請情報, 識別コード);
            }
        } else if (処理モード修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            費用額合計 = 今までの支払結果.get費用額合計();
            保険対象費用額 = 今までの支払結果.get保険対象費用額();
            保険給付額 = new Decimal(今までの支払結果.get保険給付額());
            利用者負担額 = new Decimal(今までの支払結果.get利用者負担額());
            getHandler(div).set前回までの支払結果(費用額合計, 保険対象費用額, 保険給付額, 利用者負担額);
        } else {
            SokanbaraiShiharaiKekkaResult 今回登録済みの支払結果 = FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    getShokanShiharaiKekka(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            Decimal 今費用額合計 = 今までの支払結果.get費用額合計() == null ? Decimal.ZERO : 今までの支払結果.get費用額合計();
            Decimal 今回登録済費用額合計 = 今回登録済みの支払結果.get費用額合計() == null ? Decimal.ZERO
                    : 今回登録済みの支払結果.get費用額合計();
            費用額合計 = 今費用額合計.subtract(今回登録済費用額合計);
            Decimal 今保険対象費用額 = 今までの支払結果.get保険対象費用額() == null ? Decimal.ZERO
                    : 今までの支払結果.get保険対象費用額();
            Decimal 今回登録済保険対象費用額 = 今回登録済みの支払結果.get保険対象費用額() == null ? Decimal.ZERO
                    : 今回登録済みの支払結果.get保険対象費用額();
            保険対象費用額 = 今保険対象費用額.subtract(今回登録済保険対象費用額);
            保険給付額 = new Decimal(今までの支払結果.get保険給付額() - 今回登録済みの支払結果.get保険給付額());
            利用者負担額 = new Decimal(今までの支払結果.get利用者負担額() - 今回登録済みの支払結果.get利用者負担額());
            getHandler(div).set前回までの支払結果(費用額合計, 保険対象費用額, 保険給付額, 利用者負担額);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「限度額をチェックする」ボタンのメソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> onClick_btnCheckGendogaku(
            YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        JigyoshaNo 事業者番号 = null;
        RString 整理番号;
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        } else {
            整理番号 = div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().getValue();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue() != null) {
            事業者番号 = new JigyoshaNo(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue());
        }
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 明細番号 = null;
        boolean flag = FukushiyoguKonyuhiShikyuGendogaku.createInstance().chkKonyuhiShikyuGendogaku(被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHokenTaishoHiyogakuGokei()
                .getValue());
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!flag && !ResponseHolder.isWarningIgnoredRequest()) {
            validPairs = getHandler(div).限度額チェック();
        }
        if (validPairs != null && validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<ShokanFukushiYoguHanbaihi> list = getHandler(div).getGridData(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号);
        FukushiYoguKounyuhiDouituHinmokuChofukuHantei entity = new FukushiYoguKounyuhiDouituHinmokuChofukuHantei();
        flag = entity.chkHinmokuCodePerYear(被保険者番号, サービス提供年月, list, 整理番号);
        boolean flag3 = getHandler(div).check品目コード();
        if (flag || !flag3) {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace("品目コード"));
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<YoguKonyuhiShikyuShinseiPnlTotalDiv> createResponse(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    private YoguKonyuhiShikyuShinseiPnlTotalHandler getHandler(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        return new YoguKonyuhiShikyuShinseiPnlTotalHandler(div);
    }

}
