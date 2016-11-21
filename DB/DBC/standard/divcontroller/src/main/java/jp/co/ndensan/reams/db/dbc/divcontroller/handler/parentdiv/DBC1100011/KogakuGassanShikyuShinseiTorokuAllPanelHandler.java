/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoKanyureki;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoDataResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoHoji;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoRelate;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Kokuho_Zokugara;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKeitai;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_SoshitsuJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ShikyushinseishoTorokugamenTitle;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.KanyuRirekiInputDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuAllPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.dgKanyuRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.dgShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassan.KogakuGassanShikyuShinseiToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算支給申請書登録のHandlerです。
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuAllPanelHandler {

    private final KogakuGassanShikyuShinseiTorokuAllPanelDiv div;
    private static final RString DBCMN61001 = new RString("DBCMN61001");
    private static final RString DBCMN61002 = new RString("DBCMN61002");
    private static final RString DBCMN61003 = new RString("DBCMN61003");
    private static final RString DBCMN61004 = new RString("DBCMN61004");
    private static final RString DBCMN61005 = new RString("DBCMN61005");
    private static final RString DBCMN61006 = new RString("DBCMN61006");
    private static final RString DBCMN61007 = new RString("DBCMN61007");
    private static final RString DBCMN61008 = new RString("DBCMN61008");
    private static final RString DBCMN61009 = new RString("DBCMN61009");
    private static final RString DBCMN61010 = new RString("DBCMN61010");
    private static final RString DBCMN61011 = new RString("DBCMN61011");
    private static final RString DBCMN61012 = new RString("DBCMN61012");

    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_11 = 11;
    private static final int INT_2008 = 2008;
    private static final RString 広域市町村モード = new RString("広域市町村モード");
    private static final int 年度_2013 = 2013;
    private static final int 年度_2014 = 2014;
    private static final int 年度_2015 = 2015;
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_4 = new RString("4");
    private static final RString 空白 = new RString("空白");
    private static final RString 所得区分_課税 = new RString("10");
    private static final RString 所得区分_非課税 = new RString("11");
    private static final RString 課税 = new RString("課税");
    private static final RString 非課税 = new RString("非課税");
    private static final RString KEY_0 = new RString("key0");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 照会 = new RString("照会");
    private static final RString RSTRING_99 = new RString("99");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString CODE_003 = new RString("003");
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private static final RString DATE_0401 = new RString("0401");
    private static final RString DATE_0731 = new RString("0731");
    private static final RString DATE_0801 = new RString("0801");

    /**
     * コンストラクタです。
     *
     * @param div TsuuchishoHakkoDiv
     */
    public KogakuGassanShikyuShinseiTorokuAllPanelHandler(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッドです。
     *
     * @param 引き継ぎデータ KogakuGassanShinseishoDataResult
     * @param 照会モード RString
     * @return KogakuGassanShinseishoHoji
     */
    public KogakuGassanShinseishoHoji initialize(KogakuGassanShinseishoDataResult 引き継ぎデータ, RString 照会モード) {
        div.getDgShinseiIchiran().init();
        div.getDgKanyuRirekiIchiran().init();
        ドロップダウンリスト項目セット();
        KogakuGassanShinseishoHoji 高額合算申請書保持 = new KogakuGassanShinseishoHoji();
        boolean 照会WK = false;
        int 申請状態WK;
        int 申請状況WK;
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString メニューID = controlData.getMenuID();
        高額合算申請書保持.setメニューID(メニューID);
        画面タイトルを設定(メニューID);
        申請状態WK = 申請状態を設定(メニューID);
        申請状況WK = 申請状況を設定(メニューID);
        boolean 訂正WK = DBCMN61004.equals(メニューID) || DBCMN61008.equals(メニューID) || DBCMN61012.equals(メニューID);
        高額合算申請書保持.set申請状態(new RString(申請状態WK));
        高額合算申請書保持.set申請状況(new RString(申請状況WK));
        高額合算申請書保持.set訂正フラグ(訂正WK);
        if (申請状態WK == INT_1) {
            div.getTxtShikyuShinseiKubun().setValue(KaigoGassan_ShinseiKbn.新規.get名称());
            新規状態を初期化設定();
            ドロップダウンリスト項目セット();
        } else if (申請状態WK == INT_2 || 申請状態WK == INT_3 || 申請状態WK == INT_0) {
            div.getTxtShikyuShinseiKubun().clearValue();
            変更状態を初期化設定();
            if (照会モード != null) {
                照会WK = true;
            }
            if (引き継ぎデータ != null) {
                高額合算申請書保持 = 高額合算申請書保持Entity作成(高額合算申請書保持, 引き継ぎデータ);
            }
            if (照会WK) {
                照会状態を初期化設定();
            } else {
                申請状態判定(高額合算申請書保持.get申請状態());
            }
            申請情報グリッドへ反映(高額合算申請書保持, true);
            ドロップダウンリスト項目セット();
            if (RSTRING_2.equals(高額合算申請書保持.get申請状況())) {
                div.getTabShinseiTorokuPanel2().setVisible(false);
                div.getTabShinseiTorokuPanel3().setVisible(false);
                div.getTabShinseiTorokuPanel4().setVisible(false);
            } else {
                div.getTabShinseiTorokuPanel2().setVisible(true);
                div.getTabShinseiTorokuPanel3().setVisible(true);
                div.getTabShinseiTorokuPanel4().setVisible(true);
            }
        }
        return 高額合算申請書保持;
    }

    /**
     * 画面タイトルを設定です。
     *
     * @param メニューID RString
     * @return RString
     */
    public RString 画面タイトルを設定(RString メニューID) {
        RString タイトル = RString.EMPTY;
        switch (メニューID.toString()) {
            case "DBCMN61001":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書登録_新規申請.get名称();
                break;
            case "DBCMN61002":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書登録_変更申請.get名称();
                break;
            case "DBCMN61003":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書登録_取下げ申請.get名称();
                break;
            case "DBCMN61004":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書訂正.get名称();
                break;
            case "DBCMN61005":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書_写_登録_新規申請.get名称();
                break;
            case "DBCMN61006":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書_写_登録_変更申請.get名称();
                break;
            case "DBCMN61007":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書_写_登録_取下げ申請.get名称();
                break;
            case "DBCMN61008":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書_写_訂正.get名称();
                break;
            case "DBCMN61009":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.自己負担額証明書交付申請書登録_新規申請.get名称();
                break;
            case "DBCMN61010":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.自己負担額証明書交付申請書登録_変更申請.get名称();
                break;
            case "DBCMN61011":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.自己負担額証明書交付申請書登録_取下げ申請.get名称();
                break;
            case "DBCMN61012":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.自己負担額証明書交付申請書訂正.get名称();
                break;
            default:
                break;
        }
        return タイトル;
    }

    /**
     * 申請登録状態初期表示に設定のイベントです。
     */
    public void 申請登録状態初期表示に設定() {
        申請情報クリア();
        被保険者情報等TABクリア();
        国保後期資格情報TABクリア();
        保険者加入情報パネルクリア();
        設定証記載保険者番号DDL();
        RDate nowDate = RDate.getNowDate();
        RString 保険者番号 = DbBusinessConfig.get(
                ConfigNameDBU.保険者情報_保険者番号, nowDate, SubGyomuCode.DBU介護統計報告);
        if (RString.isNullOrEmpty(保険者番号)) {
            div.getTxtTeishutsuHokenshaNo().clearValue();
        } else {
            div.getTxtTeishutsuHokenshaNo().setValue(保険者番号);
        }
        div.getDdlShokisaiHokenshaNo().setSelectedIndex(INT_0);
        div.getTxtKaigoShikyuShinseishoSeiriBango2().setValue(RSTRING_99);
        div.getTxtRirekiBango().setValue(Decimal.ONE);
        div.getTxtIryoShikyuShinseishoSeiriBango2().setValue(RSTRING_00);
        div.getTxtShikyuShinseiKubun().setValue(KaigoGassan_ShinseiKbn.新規.get名称());
        div.getDdlShikyuShinseiKeitai().setSelectedIndex(INT_0);
        div.getTxtShinseiYMD().setValue(nowDate);
    }

    /**
     * 申請登録状態初期設定のイベントです。
     */
    public void 申請登録状態初期設定() {
        被保険者情報等TABクリア();
        国保後期資格情報TABクリア();
        保険者加入情報パネルクリア();
        設定証記載保険者番号DDL();
        RDate nowDate = RDate.getNowDate();
        RString 保険者番号 = DbBusinessConfig.get(
                ConfigNameDBU.保険者情報_保険者番号, nowDate, SubGyomuCode.DBU介護統計報告);
        if (RString.isNullOrEmpty(保険者番号)) {
            div.getTxtTeishutsuHokenshaNo().clearValue();
        } else {
            div.getTxtTeishutsuHokenshaNo().setValue(保険者番号);
        }
        div.getDdlShokisaiHokenshaNo().setSelectedIndex(INT_0);
        div.getTxtKaigoShikyuShinseishoSeiriBango2().setValue(RSTRING_99);
        div.getTxtRirekiBango().setValue(Decimal.ONE);
        div.getTxtIryoShikyuShinseishoSeiriBango2().setValue(RSTRING_00);
        div.getTxtShikyuShinseiKubun().setValue(KaigoGassan_ShinseiKbn.新規.get名称());
        div.getDdlShikyuShinseiKeitai().setSelectedIndex(INT_0);
        div.getTxtShinseiYMD().setValue(nowDate);
    }

    /**
     * 申請対象年度DDLのイベントです。
     */
    public void onChange_ddlShinseiTaisyoNendo() {
        RString 申請対象年度 = div.getDdlShinseiTaishoNendo().getSelectedValue();
        RString 整理番号１ = RSTRING_4.concat(申請対象年度.substring(INT_2, INT_4));
        div.getTxtKaigoShikyuShinseishoSeiriBango1().setValue(整理番号１);
        div.getTxtIryoShikyuShinseishoSeiriBango1().setValue(整理番号１);
    }

    /**
     * 証記載保険者番号DDLのイベントです。
     */
    public void onChange_ddlShokisaiHokenshaNo() {
        RString モード = null;
        KogakuGassanShikyuShinseiToroku bussiness = KogakuGassanShikyuShinseiToroku.createInstance();
        Map<RString, List<KoikiZenShichosonJoho>> resultMap = bussiness.getHokensyaBango();
        if (resultMap != null && resultMap.get(resultMap.keySet().iterator().next()) != null) {
            モード = resultMap.keySet().iterator().next();
        }
        if (広域市町村モード.equals(モード)) {
            RString 整理番号3 = div.getDdlShokisaiHokenshaNo().getSelectedValue();
            div.getTxtKaigoShikyuShinseishoSeiriBango3().setValue(整理番号3);
        }
    }

    /**
     * 画面内共有子DIV初期化処理新規場合のメソッドです。
     *
     * @param 対象者 TaishoshaKey
     */
    public void 画面内共有子DIV初期化処理新規場合(TaishoshaKey 対象者) {
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 対象者.get識別コード();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        SikyuSinseiJyohoParameter pram = new SikyuSinseiJyohoParameter();
        pram.setHihokenshaNo(被保険者番号);
        pram.setShikibetsuCode(識別コード);
        div.getCcdShiharaiHohoJoho().initialize(pram, 登録);
    }

    /**
     * 新規初期値取得設定のメソッドです。
     */
    public void 新規初期値取得設定() {
        RString 申請対象年度 = div.getDdlShinseiTaishoNendo().getSelectedKey();
        if (new RString(INT_2008).equals(申請対象年度)) {
            div.getTxtTaishoKeisanKikanYMD().setFromValue(new RDate(申請対象年度.concat(DATE_0401).toString()));
        } else {
            div.getTxtTaishoKeisanKikanYMD().setFromValue(new RDate(申請対象年度.concat(DATE_0801).toString()));
        }
        div.getTxtTaishoKeisanKikanYMD().setToValue(
                new RDate(new RString(Integer.parseInt(申請対象年度.toString()) + INT_1).concat(DATE_0731).toString()));
        RDate 計算期間FROM = div.getTxtTaishoKeisanKikanYMD().getFromValue();
        RDate 資格取得年月日 = isNullOrEmptyFlexibleDate(div.getCcdKaigoShikakuKihon().get資格取得年月日());
        if (資格取得年月日 != null && 資格取得年月日.compareTo(計算期間FROM) <= INT_0) {
            div.getTxtKanyuKikanYMD().setFromValue(計算期間FROM);
        } else {
            div.getTxtKanyuKikanYMD().setFromValue(資格取得年月日);
        }
        RDate 計算期間TO = div.getTxtTaishoKeisanKikanYMD().getToValue();
        RDate 資格喪失年月日 = isNullOrEmptyFlexibleDate(div.getCcdKaigoShikakuKihon().get資格喪失年月日());
        if (資格喪失年月日 != null && 計算期間TO.compareTo(資格喪失年月日) <= 0) {
            div.getTxtKanyuKikanYMD().setToValue(計算期間TO);
        } else {
            div.getTxtKanyuKikanYMD().setToValue(資格喪失年月日);
        }
        div.getTxtShikakuSoshitsuYMD().setValue(資格喪失年月日);
        申請情報パネル制御(false);
        申請登録パネル制御(false);
    }

    /**
     * 申請情報グリッド「修正」ボタンのイベントです。
     *
     * @param 高額合算申請書 KogakuGassanShinseishoRelate
     * @param 申請状況 RString
     */
    public void onClick_dgShinseiJohoModify(KogakuGassanShinseishoRelate 高額合算申請書, RString 申請状況) {
        onClick_btnShinseiJohoModoru();
        申請情報データで設定(高額合算申請書);
        申請登録データで設定(高額合算申請書);
        if (!RSTRING_2.equals(申請状況)) {
            国保後期資格情報TABデータで設定(高額合算申請書);
            加入履歴グリッドへ反映(高額合算申請書);
        }
        申請情報パネル制御(false);
        申請登録パネル制御(false);
        画面内共有子DIV初期化処理(高額合算申請書);
        if (RSTRING_2.equals(申請状況)) {
            div.getCcdShiharaiHohoJoho().clear();
        }
    }

    /**
     * 初期化用のメソッドです。
     *
     * @param 高額合算申請書 KogakuGassanShinseishoRelate
     */
    public void initializePanel(KogakuGassanShinseishoRelate 高額合算申請書) {
        申請情報データで設定(高額合算申請書);
        画面内共有子DIV初期化処理(高額合算申請書);
        申請登録データで設定(高額合算申請書);
        国保後期資格情報TABデータで設定(高額合算申請書);
    }

    /**
     * 申請情報グリッド「選択」ボタンのイベントです。
     *
     * @param 高額合算申請書 KogakuGassanShinseisho
     * @param 申請状況 RString
     */
    public void onClick_dgShinseiJohoSelect(KogakuGassanShinseishoRelate 高額合算申請書, RString 申請状況) {
        onClick_btnShinseiJohoModoru();
        申請情報データで設定(高額合算申請書);
        申請登録データで設定(高額合算申請書);
        if (!RSTRING_2.equals(申請状況)) {
            国保後期資格情報TABデータで設定(高額合算申請書);
            加入履歴グリッドへ反映(高額合算申請書);
        }
        申請情報パネル制御(true);
        申請登録パネル制御(true);
        画面内共有子DIV初期化処理(高額合算申請書);
        if (RSTRING_2.equals(申請状況)) {
            div.getCcdShiharaiHohoJoho().clear();
        }
    }

    /**
     * 「加入情報を追加する」ボタンのイベントです。
     */
    public void onClick_btnKanyuJohoTsuika() {
        div.getKanyuRirekiIchiran().setIsOpen(false);
        div.getKanyuRirekiInput().setIsOpen(true);
        div.getTxtKanyuRirekiHokenshaMei().clearValue();
        div.getTxtKanyuRirekiKanyuKikanYMD().clearFromValue();
        div.getTxtKanyuRirekiKanyuKikanYMD().clearToValue();
        div.getTxtJikoFutangakuShomeishoSeiriBango().clearValue();
        加入履歴情報TAB制御(false);
    }

    /**
     * 加入履歴グリッド「修正」ボタンのイベントです。
     */
    public void onClick_dgKanyurekiModify() {
        div.getKanyuRirekiIchiran().setIsOpen(false);
        div.getKanyuRirekiInput().setIsOpen(true);
        保険者加入情報データで設定();
        加入履歴情報TAB制御(false);
    }

    /**
     * 加入履歴グリッド「選択」ボタンのイベントです。
     */
    public void onClick_dgKanyRirekiSelect() {
        div.getKanyuRirekiIchiran().setIsOpen(false);
        div.getKanyuRirekiInput().setIsOpen(true);
        保険者加入情報データで設定();
        加入履歴情報TAB制御(true);
    }

    /**
     * 「加入履歴に戻る」ボタンのイベントです。
     */
    public void onClick_btnKanyuRirekiModoru() {
        div.getKanyuRirekiIchiran().setIsOpen(true);
        div.getKanyuRirekiInput().setIsOpen(false);
        div.getTxtKanyuRirekiHokenshaMei().clearValue();
        div.getTxtKanyuRirekiKanyuKikanYMD().clearFromValue();
        div.getTxtKanyuRirekiKanyuKikanYMD().clearToValue();
        div.getTxtJikoFutangakuShomeishoSeiriBango().clearValue();
    }

    /**
     * 加入歴編集メソッドです。
     *
     * @param 加入歴 KogakuGassanShinseishoKanyureki
     * @param 高額合算申請書 KogakuGassanShinseishoRelate
     * @param 加入歴状態 RString
     * @return KogakuGassanShinseishoHoji
     */
    public KogakuGassanShinseishoRelate 加入歴編集(KogakuGassanShinseishoKanyureki 加入歴,
            KogakuGassanShinseishoRelate 高額合算申請書, RString 加入歴状態) {
        if (修正.equals(加入歴状態)) {
            EntityDataState 状態 = 加入歴.toEntity().getState();
            if (EntityDataState.Deleted.equals(状態)) {
                加入歴.toEntity().setState(EntityDataState.Modified);
                加入歴.toEntity().setIsDeleted(false);
                加入歴 = 加入歴編集(加入歴);
                高額合算申請書 = 高額合算申請書.createBuilderForEdit().set高額合算申請書加入歴(加入歴).build();
            } else {
                加入歴 = 加入歴編集(加入歴);
                高額合算申請書 = 高額合算申請書.createBuilderForEdit().set高額合算申請書加入歴(加入歴).build();
            }
        } else if (追加.equals(加入歴状態) || 加入歴 == null) {
            HihokenshaNo 被保険者番号 = 高額合算申請書.get被保険者番号();
            FlexibleYear 対象年度 = 高額合算申請書.get対象年度();
            HokenshaNo 保険者番号 = 高額合算申請書.get保険者番号();
            RString 整理番号New = 高額合算申請書.get整理番号();
            RString 加入歴番号 = 加入歴番号編集(高額合算申請書.get高額合算申請書加入歴list());
            int 履歴番号 = 高額合算申請書.get履歴番号().intValue();
            KogakuGassanShinseishoKanyureki 加入歴New = new KogakuGassanShinseishoKanyureki(
                    被保険者番号, 対象年度, 保険者番号, 整理番号New, 加入歴番号, 履歴番号);
            加入歴New = 加入歴編集(加入歴New);
            高額合算申請書 = 高額合算申請書.createBuilderForEdit().set高額合算申請書加入歴(加入歴New).build();
        } else if (削除.equals(加入歴状態)) {
            高額合算申請書 = 高額合算申請書.createBuilderForEdit().delete高額合算申請書加入歴(加入歴).build();

        }
        return 高額合算申請書;
    }

    /**
     * 加入履歴グリッドへ反映メソッドです。
     *
     * @param 高額合算申請書 KogakuGassanShinseishoRelate
     */
    public void 加入履歴グリッドへ反映(KogakuGassanShinseishoRelate 高額合算申請書) {
        List<KogakuGassanShinseishoKanyureki> 加入歴リスト = 高額合算申請書.get高額合算申請書加入歴list();
        List<dgKanyuRirekiIchiran_Row> rowList = new ArrayList();
        if (加入歴リスト == null) {
            div.getDgKanyuRirekiIchiran().setDataSource(rowList);
            return;
        }
        for (KogakuGassanShinseishoKanyureki 加入歴 : 加入歴リスト) {
            dgKanyuRirekiIchiran_Row row = new dgKanyuRirekiIchiran_Row();
            EntityDataState 状態 = 加入歴.toEntity().getState();
            if (EntityDataState.Added.equals(状態)) {
                row.setRowState(RowState.Added);
            } else if (EntityDataState.Modified.equals(状態)) {
                row.setRowState(RowState.Modified);
            } else if (EntityDataState.Deleted.equals(状態)) {
                row.setRowState(RowState.Deleted);
            }
            row.setTxtHihokenshaNo(加入歴.get被保険者番号().getColumnValue());
            row.setTxtHokenshaName(加入歴.get保険者名());
            row.setTxtJikofutanSeiriNo(加入歴.get自己負担額証明書整理番号());
            row.setTxtKanyuKaishiYMD(DateConverter.toWarekiHalf_Zero(isNullOrEmptyFlexibleDate(加入歴.get加入期間開始年月日())));
            row.setTxtKanyuKaishiYMDStr(加入歴.get加入期間開始年月日() == null ? null
                    : new RString(加入歴.get加入期間開始年月日().toString()));
            row.setTxtKanyuShuryoYMD(DateConverter.toWarekiHalf_Zero(isNullOrEmptyFlexibleDate(加入歴.get加入期間終了年月日())));
            row.setTxtKanyuShuryoYMDStr(加入歴.get加入期間終了年月日() == null ? null
                    : new RString(加入歴.get加入期間終了年月日().toString()));
            row.setTxtKanyurekiNo(加入歴.get加入歴番号());
            row.setTxtRirekiNo(new RString(加入歴.get履歴番号()));
            row.setTxtTaishoNendo(加入歴.get対象年度().toDateString());
            row.setTxtHokenshaNo(加入歴.get保険者番号().getColumnValue());
            row.setTxtSeiriNo(加入歴.get整理番号());
            rowList.add(row);
        }
        div.getDgKanyuRirekiIchiran().setDataSource(sort加入履歴グリッド(rowList));
    }

    /**
     * 「申請情報に戻る」ボタンのイベントです。
     */
    public void onClick_btnShinseiJohoModoru() {
        被保険者情報等TABクリア();
        国保後期資格情報TABクリア();
        div.getCcdShiharaiHohoJoho().clear();
        保険者加入情報パネルクリア();
    }

    /**
     * 高額合算申請書編集メソッドです。
     *
     * @param 高額合算申請書 KogakuGassanShinseishoRelate
     * @param 高額合算申請書保持 KogakuGassanShinseishoHoji
     * @param 高額合算申請書状態 RString
     * @param 引き継ぎデータ KogakuGassanShinseishoDataResult
     * @return KogakuGassanShinseishoHoji
     */
    public KogakuGassanShinseishoHoji 高額合算申請書編集(KogakuGassanShinseishoRelate 高額合算申請書,
            KogakuGassanShinseishoHoji 高額合算申請書保持, RString 高額合算申請書状態,
            KogakuGassanShinseishoDataResult 引き継ぎデータ) {
        EntityDataState 状態 = 高額合算申請書.toEntity().getState();
        if (修正.equals(高額合算申請書状態)) {
            if (EntityDataState.Deleted.equals(状態)) {
                高額合算申請書.toEntity().setIsDeleted(false);
                高額合算申請書 = 高額合算申請書編集(高額合算申請書, 高額合算申請書保持, 引き継ぎデータ).modifiedModel();
                高額合算申請書保持.add高額合算申請書(高額合算申請書);
            } else {
                高額合算申請書 = 変更判定(高額合算申請書);
                高額合算申請書保持.add高額合算申請書(高額合算申請書);
            }
        } else if (追加.equals(高額合算申請書状態)) {
            高額合算申請書 = 高額合算申請書編集(高額合算申請書, 高額合算申請書保持, 引き継ぎデータ);
            高額合算申請書保持.add高額合算申請書(高額合算申請書);
        } else if (削除.equals(高額合算申請書状態)) {
            if (EntityDataState.Added.equals(状態)) {
                高額合算申請書保持.delete高額合算申請書(高額合算申請書);
            } else if (EntityDataState.Unchanged.equals(状態) || EntityDataState.Modified.equals(状態)) {
                高額合算申請書 = 高額合算申請書.deleted();
                高額合算申請書保持.add高額合算申請書(高額合算申請書);
            }
        }
        return 高額合算申請書保持;
    }

    /**
     * 重複チェックメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return boolean
     */
    public boolean 重複チェック(HihokenshaNo 被保険者番号) {
        List<dgShinseiIchiran_Row> rowList = div.getDgShinseiIchiran().getDataSource();
        for (dgShinseiIchiran_Row row : rowList) {
            if (被保険者番号.getColumnValue().equals(row.getTxtHihokenshaNo())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 加入歴編集メソッドです。
     *
     * @param 加入歴Result KogakuGassanShinseishoKanyureki
     * @return KogakuGassanShinseishoKanyureki
     */
    public KogakuGassanShinseishoKanyureki 加入歴編集(KogakuGassanShinseishoKanyureki 加入歴Result) {
        return 加入歴Result.createBuilderForEdit()
                .set保険者名(div.getKanyuRirekiInput().getTxtKanyuRirekiHokenshaMei().getValue())
                .set加入期間開始年月日(rDateToFixibleDate(div.getKanyuRirekiInput().getTxtKanyuRirekiKanyuKikanYMD().getFromValue()))
                .set加入期間終了年月日(rDateToFixibleDate(div.getKanyuRirekiInput().getTxtKanyuRirekiKanyuKikanYMD().getToValue()))
                .set自己負担額証明書整理番号(div.getTxtJikoFutangakuShomeishoSeiriBango().getValue())
                .build();
    }

    /**
     * 申請情報グリッドへ反映メソッドです。
     *
     * @param 高額合算申請書保持 KogakuGassanShinseishoHoji
     * @param アクセスログ出力 boolean
     */
    public void 申請情報グリッドへ反映(KogakuGassanShinseishoHoji 高額合算申請書保持, boolean アクセスログ出力) {
        List<KogakuGassanShinseishoRelate> 高額合算申請書リスト = 高額合算申請書保持.get高額合算申請書();
        List<dgShinseiIchiran_Row> rowList = new ArrayList();
        List<PersonalData> personalDataList = new ArrayList<>();
        if (高額合算申請書リスト == null) {

            div.getDgShinseiIchiran().setDataSource(rowList);
            return;
        }
        for (KogakuGassanShinseishoRelate item : 高額合算申請書リスト) {
            dgShinseiIchiran_Row row = new dgShinseiIchiran_Row();
            EntityDataState 状態 = item.toEntity().getState();
            if (EntityDataState.Added.equals(状態)) {
                row.setRowState(RowState.Added);
            } else if (EntityDataState.Modified.equals(状態)) {
                row.setRowState(RowState.Modified);
            } else if (EntityDataState.Deleted.equals(状態)) {
                row.setRowState(RowState.Deleted);
            }
            row.setTxtHihokenshaNo(item.get被保険者番号().getColumnValue());
            KogakuGassanShikyuShinseiToroku bussiness = KogakuGassanShikyuShinseiToroku.createInstance();
            IShikibetsuTaisho 被保険者情報 = bussiness.被保険者名の取得(item.get被保険者番号());
            if (被保険者情報 != null) {
                row.setTxtHihokenshaName(被保険者情報.get名称() == null
                        ? null : 被保険者情報.get名称().getName().getColumnValue());
            }
            row.setTxtJikoFutanKeisanYM(item.get自己負担額計算年月() == null
                    ? null : item.get自己負担額計算年月().toDateString());
            row.setTxtKokiHihokenshaNo(item.get後期被保険者番号());
            row.setTxtKokuhoHihokenshashoNo(item.get国保被保険者証番号());
            row.setTxtSaiKeisanKubun(item.get再計算区分());
            row.setTxtSaiSofuFlag(item.get再送フラグ());
            row.setTxtShikyuShinseishoSofuYM(item.get支給申請書情報送付年月() == null
                    ? null : item.get支給申請書情報送付年月().toDateString());
            row.setTxtHokenshaNo(item.get保険者番号().getColumnValue());
            row.setTxtTaishoNendo(item.get対象年度().toDateString());
            row.setTxtSeiriNo(item.get整理番号());
            row.setTxtRirekiNo(new RString(item.get履歴番号().intValue()));
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                    名称_被保険者番号, item.get被保険者番号().getColumnValue());
            PersonalData personalData = PersonalData.of(被保険者情報 == null
                    ? ShikibetsuCode.EMPTY : 被保険者情報.get識別コード(), expandedInfo);
            personalDataList.add(personalData);
            rowList.add(row);
        }
        if (アクセスログ出力) {
            AccessLogger.log(AccessLogType.照会, personalDataList);
        }
        div.getDgShinseiIchiran().setDataSource(sort申請情報グリッド(rowList));
    }

    /**
     * 変更有無チェックメソッドです。
     *
     * @return boolean
     */
    public boolean 変更有無チェック() {
        List<dgShinseiIchiran_Row> 申請情報グリッド = div.getDgShinseiIchiran().getDataSource();
        List<dgKanyuRirekiIchiran_Row> 加入履歴グリッド = div.getDgKanyuRirekiIchiran().getDataSource();
        if (申請情報グリッド != null) {
            for (dgShinseiIchiran_Row row : 申請情報グリッド) {
                if (!RowState.Unchanged.equals(row.getRowState())) {
                    return true;
                }
            }
        }
        if (申請情報グリッド != null) {
            for (dgKanyuRirekiIchiran_Row row : 加入履歴グリッド) {
                if (!RowState.Unchanged.equals(row.getRowState())) {
                    return true;
                }
            }
        }
        return false;
    }

    private KogakuGassanShinseishoRelate 高額合算申請書編集(KogakuGassanShinseishoRelate 高額合算申請書Result,
            KogakuGassanShinseishoHoji 高額合算申請書保持, KogakuGassanShinseishoDataResult 引き継ぎデータ) {
        return 高額合算申請書Result.createBuilderForEdit()
                .set申請状況区分(高額合算申請書保持.get申請状況())
                .set申請年月日(rDateToFixibleDate(div.getTxtShinseiYMD().getValue()))
                .set支給申請書整理番号(引き継ぎデータ == null
                        ? RString.EMPTY.concat(div.getTxtKaigoShikyuShinseishoSeiriBango1().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango2().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue() == null
                                ? RString.EMPTY.padZeroToLeft(INT_6) : div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue())
                        : RString.EMPTY.concat(div.getTxtKaigoShikyuShinseishoSeiriBango1().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango2().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue() == null
                                ? RString.EMPTY.padZeroToLeft(INT_6) : div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango4().getValue() == null
                                ? RString.EMPTY.padZeroToLeft(INT_6) : div.getTxtKaigoShikyuShinseishoSeiriBango4().getValue()))
                .set国保支給申請書整理番号(RString.isNullOrEmpty(div.getTxtIryoShikyuShinseishoSeiriBango2().getValue())
                        && RString.isNullOrEmpty(div.getTxtIryoShikyuShinseishoSeiriBango3().getValue())
                        && RString.isNullOrEmpty(div.getTxtIryoShikyuShinseishoSeiriBango4().getValue())
                        ? RString.EMPTY
                        : RString.EMPTY.concat(div.getTxtIryoShikyuShinseishoSeiriBango1().getValue())
                        .concat(div.getTxtIryoShikyuShinseishoSeiriBango2().getValue())
                        .concat(div.getTxtIryoShikyuShinseishoSeiriBango3().getValue())
                        .concat(div.getTxtIryoShikyuShinseishoSeiriBango4().getValue()))
                .set支給申請区分(高額合算申請書保持.get申請状態())
                .set対象計算期間開始年月日(rDateToFixibleDate(div.getTxtTaishoKeisanKikanYMD().getFromValue()))
                .set対象計算期間終了年月日(rDateToFixibleDate(div.getTxtTaishoKeisanKikanYMD().getToValue()))
                .set支給申請形態(div.getDdlShikyuShinseiKeitai().getSelectedKey())
                .set自己負担額証明書交付申請の有無(Collections.EMPTY_LIST.equals(div.getChkKofuShinseiUmu().getSelectedKeys()) ? RSTRING_1 : RSTRING_2)
                .set所得区分(RString.isNullOrEmpty(div.getDdlShotokuKubun().getSelectedValue()) ? null : div.getDdlShotokuKubun().getSelectedKey())
                .set所得区分_70歳以上の者に係る(div.getDdlOver70ShotokuKubun().getSelectedKey())
                .set資格喪失年月日(rDateToFixibleDate(div.getTxtShikakuSoshitsuYMD().getValue()))
                .set資格喪失事由(div.getDdlShikakuSoshitsuJiyu().getSelectedKey())
                .set加入期間開始年月日(rDateToFixibleDate(div.getTxtKanyuKikanYMD().getFromValue()))
                .set加入期間終了年月日(rDateToFixibleDate(div.getTxtKanyuKikanYMD().getToValue()))
                .set国保保険者番号(div.getTxtKokuhoHokenshaNo().getValue())
                .set国保保険者名称(div.getTxtKokuhoHokenshaMeisho().getValue())
                .set国保被保険者証記号(div.getTxtKokuhoHikonenshaShoKigo().getValue())
                .set国保被保険者証番号(div.getTxtKokuhoHikonenshaShoNo().getValue())
                .set国保世帯番号(div.getTxtKokuhoSetaiNo().getValue())
                .set国保続柄(div.getTxtKokuhoZokugara().getSelectedKey())
                .set国保加入期間開始年月日(rDateToFixibleDate(div.getTxtKokuhoKanyuKikanYMD().getFromValue()))
                .set国保加入期間終了年月日(rDateToFixibleDate(div.getTxtKokuhoKanyuKikanYMD().getToValue()))
                .set後期保険者番号(div.getTxtKokiHokenshaNo().getValue())
                .set後期広域連合名称(div.getTxtKokiKoikiRengoMeisho().getValue())
                .set後期被保険者番号(div.getTxtKokiHihokenshaNo().getValue())
                .set後期加入期間開始年月日(rDateToFixibleDate(div.getTxtKokiKanyuKikanYMD().getFromValue()))
                .set後期加入期間終了年月日(rDateToFixibleDate(div.getTxtKokiKanyuKikanYMD().getToValue()))
                .set支払方法区分(RSTRING_2.equals(高額合算申請書保持.get申請状況()) ? RString.EMPTY
                        : div.getCcdShiharaiHohoJoho().getShiharaiHohoRad())
                .set支払場所(div.getCcdShiharaiHohoJoho().getShiharaiBasho())
                .set支払期間開始年月日(rDateToFixibleDate(div.getCcdShiharaiHohoJoho().getStartYMD()))
                .set支払期間終了年月日(rDateToFixibleDate(div.getCcdShiharaiHohoJoho().getEndYMD()))
                .set支払期間開始時間(div.getCcdShiharaiHohoJoho().getStartHHMM() == null ? null
                        : div.getCcdShiharaiHohoJoho().getStartHHMM().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss))
                .set支払期間終了時間(div.getCcdShiharaiHohoJoho().getEndHHMM() == null ? null
                        : div.getCcdShiharaiHohoJoho().getEndHHMM().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss))
                .set閉庁内容(引き継ぎデータ == null ? null : 高額合算申請書Result.get閉庁内容())
                .set口座ID(RString.isNullOrEmpty(div.getCcdShiharaiHohoJoho().getKozaID()) ? 0L
                        : Long.parseLong(div.getCcdShiharaiHohoJoho().getKozaID().toString()))
                .set備考(div.getTxtBiko().getValue())
                .set支給申請書情報送付年月(引き継ぎデータ == null ? null : 高額合算申請書Result.get支給申請書情報送付年月())
                .set再送フラグ(引き継ぎデータ == null ? null : 高額合算申請書Result.get再送フラグ())
                .set自己負担額計算年月(引き継ぎデータ == null ? null : 高額合算申請書Result.get自己負担額計算年月())
                .set再計算区分(引き継ぎデータ == null ? null : 高額合算申請書Result.get再計算区分())
                .build();
    }

    private void 新規状態を初期化設定() {
        div.getBtnAddShinsei().setVisible(true);
        div.getDdlShokisaiHokenshaNo().setReadOnly(false);
        div.getDgShinseiIchiran().getGridSetting().setIsShowModifyButtonColumn(true);
        div.getDgShinseiIchiran().getGridSetting().setIsShowSelectButtonColumn(false);
        div.getDgShinseiIchiran().getGridSetting().setIsShowDeleteButtonColumn(true);
        div.getDgShinseiIchiran().getGridSetting().setIsShowRowState(true);
        div.getBtnAddKanyuRireki().setVisible(true);
        div.getBtnKakuteiKanyuRireki().setVisible(true);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowModifyButtonColumn(true);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowDeleteButtonColumn(true);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowRowState(true);
        div.getBtnKakuteiShintei().setVisible(true);
        申請情報パネル制御(false);
        申請登録パネル制御(false);
    }

    private void 変更状態を初期化設定() {
        div.getBtnAddShinsei().setVisible(true);
        div.getDdlShokisaiHokenshaNo().setReadOnly(false);
        div.getDgShinseiIchiran().getGridSetting().setIsShowModifyButtonColumn(true);
        div.getDgShinseiIchiran().getGridSetting().setIsShowSelectButtonColumn(false);
        div.getDgShinseiIchiran().getGridSetting().setIsShowDeleteButtonColumn(true);
        div.getDgShinseiIchiran().getGridSetting().setIsShowRowState(true);
        div.getBtnAddKanyuRireki().setVisible(true);
        div.getBtnKakuteiKanyuRireki().setVisible(true);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowModifyButtonColumn(true);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowDeleteButtonColumn(true);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowRowState(true);
        div.getBtnKakuteiShintei().setVisible(true);
        申請情報パネル制御(false);
        申請登録パネル制御(false);
    }

    private void 照会状態を初期化設定() {
        div.getBtnAddShinsei().setVisible(false);
        div.getDdlShokisaiHokenshaNo().setReadOnly(true);
        div.getDgShinseiIchiran().getGridSetting().setIsShowModifyButtonColumn(false);
        div.getDgShinseiIchiran().getGridSetting().setIsShowSelectButtonColumn(true);
        div.getDgShinseiIchiran().getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getDgShinseiIchiran().getGridSetting().setIsShowRowState(false);
        div.getBtnAddKanyuRireki().setVisible(false);
        div.getBtnKakuteiKanyuRireki().setVisible(false);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowModifyButtonColumn(false);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowRowState(false);
        div.getBtnKakuteiShintei().setVisible(false);
        申請情報パネル制御(true);
        申請登録パネル制御(true);
    }

    private void 申請状態判定(RString 申請状態) {
        if (RSTRING_1.equals(申請状態) || RSTRING_2.equals(申請状態)) {
            div.getBtnAddShinsei().setVisible(true);
            div.getDgShinseiIchiran().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getDgShinseiIchiran().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getDgShinseiIchiran().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getDgShinseiIchiran().getGridSetting().setIsShowRowState(true);
            div.getBtnAddKanyuRireki().setVisible(true);
            div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowRowState(true);
        } else if (RSTRING_3.equals(申請状態)) {
            div.getBtnAddShinsei().setVisible(false);
            div.getDgShinseiIchiran().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgShinseiIchiran().getGridSetting().setIsShowSelectButtonColumn(true);
            div.getDgShinseiIchiran().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgShinseiIchiran().getGridSetting().setIsShowRowState(true);
            div.getBtnAddKanyuRireki().setVisible(false);
            div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgKanyuRirekiIchiran().getGridSetting().setIsShowRowState(false);

        }
    }

    private void 申請情報パネル制御(boolean flag) {
        div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(flag);
        div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(flag);
        div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(flag);
        div.getDdlShikyuShinseiKeitai().setReadOnly(flag);
        div.getShinseiDaihyosha().setReadOnly(flag);
        div.getTxtShinseiYMD().setReadOnly(flag);
        div.getChkKofuShinseiUmu().setReadOnly(flag);
    }

    private void 申請登録パネル制御(boolean flag) {
        div.getKogakuGassanShikyuShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikaku().setReadOnly(flag);
        div.getKogakuGassanShikyuShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setReadOnly(flag);
        div.getKogakuGassanShikyuShinseiToroku().getTabShinseiTorokuPanel1().getTxtBiko().setReadOnly(flag);
        div.getKogakuGassanShikyuShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setReadOnly(flag);
        div.getKogakuGassanShikyuShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setReadOnly(flag);
        div.getKogakuGassanShikyuShinseiToroku().getTabShinseiTorokuPanel3().getCcdShiharaiHohoJoho().setReadOnly(flag);
        加入履歴情報TAB制御(flag);
    }

    private void 加入履歴情報TAB制御(boolean flag) {
        KanyuRirekiInputDiv kanyuInfoDiv = div.getKogakuGassanShikyuShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput();
        kanyuInfoDiv.getTxtKanyuRirekiHokenshaMei().setReadOnly(flag);
        kanyuInfoDiv.getTxtKanyuRirekiKanyuKikanYMD().setReadOnly(flag);
        kanyuInfoDiv.getTxtJikoFutangakuShomeishoSeiriBango().setReadOnly(flag);
    }

    private int 申請状態を設定(RString メニューID) {
        if (DBCMN61001.equals(メニューID) || DBCMN61005.equals(メニューID) || DBCMN61009.equals(メニューID)) {
            return INT_1;
        } else if (DBCMN61002.equals(メニューID) || DBCMN61006.equals(メニューID) || DBCMN61010.equals(メニューID)) {
            return INT_2;
        } else if (DBCMN61003.equals(メニューID) || DBCMN61007.equals(メニューID) || DBCMN61011.equals(メニューID)) {
            return INT_3;
        }
        return INT_0;
    }

    private int 申請状況を設定(RString メニューID) {
        if (DBCMN61001.equals(メニューID) || DBCMN61002.equals(メニューID)
                || DBCMN61003.equals(メニューID) || DBCMN61004.equals(メニューID)) {
            return INT_1;
        } else if (DBCMN61009.equals(メニューID) || DBCMN61010.equals(メニューID)
                || DBCMN61011.equals(メニューID) || DBCMN61012.equals(メニューID)) {
            return INT_2;
        } else if (DBCMN61005.equals(メニューID) || DBCMN61006.equals(メニューID)
                || DBCMN61007.equals(メニューID) || DBCMN61008.equals(メニューID)) {
            return INT_3;
        }
        return INT_0;
    }

    private void ドロップダウンリスト項目セット() {
        設定申請対象年度DDL();
        設定支給申請形態DDL();
        設定証記載保険者番号DDL();
        設定所得区分DDL();
        設定70歳以上の者に係る所得区分DDL();
        設定資格喪失事由DDL();
        設定続柄DDL();
    }

    private void 設定申請対象年度DDL() throws IllegalArgumentException {
        int 年度;
        RDate システム日付 = RDate.getNowDate();
        int システム年 = システム日付.getYearValue();
        int システム月 = システム日付.getMonthValue();
        if (システム月 <= INT_7) {
            年度 = システム年 - INT_2;
        } else {
            年度 = システム年 - INT_1;
        }
        List<KeyValueDataSource> dataSource = new ArrayList();
        if (年度 < INT_2008) {
            div.getDdlShinseiTaishoNendo().setDataSource(dataSource);
        } else {
            for (int i = 年度; INT_2008 <= i; i--) {
                KeyValueDataSource data = new KeyValueDataSource();
                data.setKey(new RString(i));
                data.setValue(DateConverter.getWarekiYear(new RYear(i)));
                dataSource.add(data);
            }
            div.getDdlShinseiTaishoNendo().setDataSource(dataSource);
            div.getDdlShinseiTaishoNendo().setSelectedIndex(INT_0);
        }
    }

    private void 設定支給申請形態DDL() {
        List<KeyValueDataSource> sources = new ArrayList<>();
        for (KaigoGassan_ShinseiKeitai tiem : KaigoGassan_ShinseiKeitai.values()) {
            if (tiem.getCode().isEmpty()) {
                continue;
            }
            sources.add(new KeyValueDataSource(tiem.getCode(), tiem.get名称()));
        }
        div.getDdlShikyuShinseiKeitai().setDataSource(sources);
    }

    private void 設定証記載保険者番号DDL() {
        KogakuGassanShikyuShinseiToroku bussiness = KogakuGassanShikyuShinseiToroku.createInstance();
        List<KeyValueDataSource> dataSource = new ArrayList();
        Map<RString, List<KoikiZenShichosonJoho>> resultMap = bussiness.getHokensyaBango();
        if (resultMap != null && resultMap.get(resultMap.keySet().iterator().next()) != null) {
            RString モード = resultMap.keySet().iterator().next();
            if (広域市町村モード.equals(モード)) {
                div.getDdlShokisaiHokenshaNo().setReadOnly(false);
                KeyValueDataSource data = new KeyValueDataSource(RString.EMPTY, RString.EMPTY);
                dataSource.add(data);
            } else {
                div.getDdlShokisaiHokenshaNo().setReadOnly(true);
            }
            List<RString> keyList = new ArrayList();
            for (KoikiZenShichosonJoho item : resultMap.get(resultMap.keySet().iterator().next())) {
                if (!keyList.contains(item.get証記載保険者番号().getColumnValue())) {
                    keyList.add(item.get証記載保険者番号().getColumnValue());
                    KeyValueDataSource datas = new KeyValueDataSource(
                            item.get証記載保険者番号().getColumnValue(), item.get証記載保険者番号().getColumnValue());
                    dataSource.add(datas);
                }
            }
        }
        div.getDdlShokisaiHokenshaNo().setDataSource(dataSource);
        if (resultMap != null && resultMap.get(resultMap.keySet().iterator().next()) != null) {
            RString モード = resultMap.keySet().iterator().next();
            if (!広域市町村モード.equals(モード)) {
                div.getDdlShokisaiHokenshaNo().setSelectedIndex(INT_0);
                RString 証記載保険者番号 = div.getDdlShokisaiHokenshaNo().getSelectedKey();
                div.getTxtKaigoShikyuShinseishoSeiriBango3().setValue(証記載保険者番号);
            }
        } else {
            div.getTxtKaigoShikyuShinseishoSeiriBango3().setValue(RString.EMPTY.padZeroToLeft(INT_6));
        }
    }

    private void 設定所得区分DDL() {
        RString 申請対象年度 = div.getDdlShinseiTaishoNendo().getSelectedKey();
        int 年度 = Integer.parseInt(申請対象年度.toString());
        List<KeyValueDataSource> h25年度以前 = new ArrayList();
        h25年度以前.add(new KeyValueDataSource(空白, RString.EMPTY));
        h25年度以前.add(new KeyValueDataSource(所得区分_課税, 課税));
        h25年度以前.add(new KeyValueDataSource(所得区分_非課税, 非課税));
        h25年度以前.add(new KeyValueDataSource(KaigoGassan_ShotokuKbn.上位所得者.getCode(),
                KaigoGassan_ShotokuKbn.上位所得者.get名称()));
        List<KeyValueDataSource> h26年度以降 = new ArrayList();
        h26年度以降.add(new KeyValueDataSource(空白, RString.EMPTY));
        List<KeyValueDataSource> h27年1月以降 = new ArrayList();
        h27年1月以降.add(new KeyValueDataSource(空白, RString.EMPTY));
        for (KaigoGassan_ShotokuKbn type : KaigoGassan_ShotokuKbn.values()) {
            h27年1月以降.add(new KeyValueDataSource(type.getCode(), type.get名称()));
            if (KaigoGassan_ShotokuKbn.区分ア.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分イ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分ウ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分エ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分オ.get名称().equals(type.get名称())) {
                h26年度以降.add(new KeyValueDataSource(type.getCode(), type.get名称()));
            }
        }
        if (0 <= 年度_2013 - 年度) {
            div.getDdlShotokuKubun().setDataSource(h25年度以前);
        } else if (年度_2014 - 年度 < 0 && 年度_2015 - 年度 <= 0) {
            div.getDdlShotokuKubun().setDataSource(h26年度以降);
        } else {
            div.getDdlShotokuKubun().setDataSource(h27年1月以降);
        }
    }

    private void 設定70歳以上の者に係る所得区分DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (KaigoGassan_Over70_ShotokuKbn tiem : KaigoGassan_Over70_ShotokuKbn.values()) {
            if (tiem.getCode().isEmpty()) {
                continue;
            }
            dataSource.add(new KeyValueDataSource(tiem.getCode(), tiem.get名称()));
        }
        div.getDdlOver70ShotokuKubun().setDataSource(dataSource);
    }

    private void 設定資格喪失事由DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (KaigoGassan_SoshitsuJiyu tiem : KaigoGassan_SoshitsuJiyu.values()) {
            if (tiem.getCode().isEmpty()) {
                continue;
            }
            dataSource.add(new KeyValueDataSource(tiem.getCode(), tiem.get名称()));
        }
        div.getDdlShikakuSoshitsuJiyu().setDataSource(dataSource);
    }

    private void 設定続柄DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (KaigoGassan_Kokuho_Zokugara tiem : KaigoGassan_Kokuho_Zokugara.values()) {
            if (tiem.getCode().isEmpty()) {
                continue;
            }
            dataSource.add(new KeyValueDataSource(tiem.getCode(), tiem.get名称()));
        }
        div.getTxtKokuhoZokugara().setDataSource(dataSource);
    }

    private KogakuGassanShinseishoHoji 高額合算申請書保持Entity作成(
            KogakuGassanShinseishoHoji 高額合算申請書保持, KogakuGassanShinseishoDataResult 引き継ぎデータ) {
        HihokenshaNo 被保険者番号 = 引き継ぎデータ.get被保険者番号();
        FlexibleYear 対象年度 = 引き継ぎデータ.get対象年度();
        HokenshaNo 保険者番号 = 引き継ぎデータ.get保険者番号();
        Decimal 履歴番号 = 引き継ぎデータ.get履歴番号();
        RString 整理番号 = 引き継ぎデータ.get整理番号();
        高額合算申請書保持.set被保険者番号(被保険者番号);
        高額合算申請書保持.set対象年度(対象年度);
        高額合算申請書保持.set保険者番号(保険者番号);
        高額合算申請書保持.set履歴番号(履歴番号);
        高額合算申請書保持.set整理番号(整理番号);
        KogakuGassanShikyuShinseiToroku bussiness = KogakuGassanShikyuShinseiToroku.createInstance();
        List<KogakuGassanShinseishoRelate> 高額合算申請書List
                = bussiness.getKogakuKaigoShinseisho(対象年度, 保険者番号, 整理番号, 履歴番号);
        if (!高額合算申請書List.isEmpty() && RSTRING_0.equals(高額合算申請書保持.get申請状態())) {
            高額合算申請書保持.set申請状態(高額合算申請書List.get(INT_0).get支給申請区分());
        }
        高額合算申請書保持.set高額合算申請書(高額合算申請書List);
        return 高額合算申請書保持;
    }

    private void 申請情報データで設定(KogakuGassanShinseishoRelate 高額合算申請書) {
        RowState state = div.getDgShinseiIchiran().getClickedItem() == null
                ? null : div.getDgShinseiIchiran().getClickedItem().getRowState();
        if (RowState.Added.equals(state)) {
            RDate nowDate = RDate.getNowDate();
            RString 保険者番号 = DbBusinessConfig.get(
                    ConfigNameDBU.保険者情報_保険者番号, nowDate, SubGyomuCode.DBU介護統計報告);
            if (RString.isNullOrEmpty(保険者番号)) {
                div.getTxtTeishutsuHokenshaNo().clearValue();
            } else {
                div.getTxtTeishutsuHokenshaNo().setValue(保険者番号);
            }
            div.getDdlShokisaiHokenshaNo().setSelectedIndex(INT_0);
            div.getTxtKaigoShikyuShinseishoSeiriBango2().setValue(RSTRING_99);
            div.getTxtRirekiBango().setValue(Decimal.ONE);
            div.getTxtIryoShikyuShinseishoSeiriBango2().setValue(RSTRING_00);
            div.getTxtShikyuShinseiKubun().setValue(KaigoGassan_ShinseiKbn.新規.get名称());
            div.getDdlShikyuShinseiKeitai().setSelectedIndex(INT_0);
            div.getTxtShinseiYMD().setValue(nowDate);
            div.getDdlShinseiTaishoNendo().setSelectedIndex(INT_0);
            onChange_ddlShinseiTaisyoNendo();
        } else {
            div.getTxtTeishutsuHokenshaNo().setValue(高額合算申請書.get保険者番号().getColumnValue());
            RString 支給申請書整理番号 = 証記載保険者番号設定(高額合算申請書);
            if (RString.isNullOrEmpty(支給申請書整理番号)) {
                div.getTxtKaigoShikyuShinseishoSeiriBango1().clearValue();
                div.getTxtKaigoShikyuShinseishoSeiriBango2().clearValue();
                div.getTxtKaigoShikyuShinseishoSeiriBango3().clearValue();
                div.getTxtKaigoShikyuShinseishoSeiriBango4().clearValue();
            } else {
                div.getTxtKaigoShikyuShinseishoSeiriBango1().setValue(支給申請書整理番号.substring(INT_0, INT_3));
                div.getTxtKaigoShikyuShinseishoSeiriBango2().setValue(支給申請書整理番号.substring(INT_3, INT_5));
                div.getTxtKaigoShikyuShinseishoSeiriBango3().setValue(支給申請書整理番号.substring(INT_5, INT_11));
                div.getTxtKaigoShikyuShinseishoSeiriBango4().setValue(支給申請書整理番号.substring(INT_11));
            }
            div.getTxtRirekiBango().setValue(高額合算申請書.get履歴番号());
            div.getDdlShinseiTaishoNendo().setSelectedKey(高額合算申請書.get対象年度().toDateString());
            RString 国保支給申請書整理番号 = 高額合算申請書.get国保支給申請書整理番号();
            if (RString.isNullOrEmpty(国保支給申請書整理番号)) {
                div.getTxtIryoShikyuShinseishoSeiriBango1().clearValue();
                div.getTxtIryoShikyuShinseishoSeiriBango2().clearValue();
                div.getTxtIryoShikyuShinseishoSeiriBango3().clearValue();
                div.getTxtIryoShikyuShinseishoSeiriBango4().clearValue();
            } else {
                div.getTxtIryoShikyuShinseishoSeiriBango1().setValue(国保支給申請書整理番号.substring(INT_0, INT_3));
                div.getTxtIryoShikyuShinseishoSeiriBango2().setValue(国保支給申請書整理番号.substring(INT_3, INT_5));
                div.getTxtIryoShikyuShinseishoSeiriBango3().setValue(国保支給申請書整理番号.substring(INT_5, INT_11));
                div.getTxtIryoShikyuShinseishoSeiriBango4().setValue(国保支給申請書整理番号.substring(INT_11));
            }
        }
        if (RString.isNullOrEmpty(高額合算申請書.get支給申請区分())) {
            div.getTxtShikyuShinseiKubun().clearValue();
        } else {
            div.getTxtShikyuShinseiKubun().setValue(
                    KaigoGassan_ShinseiKbn.toValue(高額合算申請書.get支給申請区分()).get名称());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get支給申請形態())) {
            div.getDdlShikyuShinseiKeitai().setSelectedIndex(INT_0);
        } else {
            div.getDdlShikyuShinseiKeitai().setSelectedKey(高額合算申請書.get支給申請形態());
        }
        div.getTxtShinseiYMD().setValue(isNullOrEmptyFlexibleDate(高額合算申請書.get申請年月日()));
        RString 交付申請有無 = 高額合算申請書.get自己負担額証明書交付申請の有無();
        if (RSTRING_2.equals(交付申請有無)) {
            List<RString> dataSource = new ArrayList();
            dataSource.add(KEY_0);
            div.getChkKofuShinseiUmu().setSelectedItemsByKey(dataSource);
            div.getDdlShikyuShinseiKeitai().setRequired(true);
        } else {
            div.getChkKofuShinseiUmu().setSelectedItemsByKey(Collections.EMPTY_LIST);
            div.getDdlShikyuShinseiKeitai().setRequired(false);
        }
        if (高額合算申請書.get申請代表者氏名() == null) {
            div.getTxtDaihyoshaShimei().clearValue();
        } else {
            div.getTxtDaihyoshaShimei().setValue(高額合算申請書.get申請代表者氏名().value());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get申請代表者住所())) {
            div.getTxtDaihyoshaJusho().clearValue();
        } else {
            div.getTxtDaihyoshaJusho().setValue(高額合算申請書.get申請代表者住所());
        }
        if (高額合算申請書.get申請代表者電話番号() == null) {
            div.getTxtDaihyoshaTelNo().clearDomain();
        } else {
            div.getTxtDaihyoshaTelNo().setDomain(高額合算申請書.get申請代表者電話番号());
        }
        if (高額合算申請書.get申請代表者郵便番号() == null) {
            div.getTxtDaihyoshaYubinNo().clearValue();
        } else {
            div.getTxtDaihyoshaYubinNo().setValue(高額合算申請書.get申請代表者郵便番号());
        }
    }

    private RString 証記載保険者番号設定(KogakuGassanShinseishoRelate 高額合算申請書) {
        RString 支給申請書整理番号 = 高額合算申請書.get支給申請書整理番号();
        if (RString.isNullOrEmpty(支給申請書整理番号)) {
            div.getDdlShokisaiHokenshaNo().setSelectedIndex(INT_0);
        } else {
            boolean flg = false;
            RString 証記載保険者番号 = 支給申請書整理番号.substring(INT_5, INT_11);
            List<KeyValueDataSource> dataSource = div.getDdlShokisaiHokenshaNo().getDataSource();
            for (KeyValueDataSource data : dataSource) {
                if (証記載保険者番号.equals(data.getKey())) {
                    flg = true;
                    break;
                }
            }
            if (flg) {
                div.getDdlShokisaiHokenshaNo().setSelectedKey(証記載保険者番号);
            } else {
                div.getDdlShokisaiHokenshaNo().setSelectedIndex(INT_0);
            }
        }
        return 支給申請書整理番号;
    }

    private void 画面内共有子DIV初期化処理(KogakuGassanShinseishoRelate 高額合算申請書) {
        HihokenshaNo 被保険者番号 = 高額合算申請書.get被保険者番号();
        Long 口座ID = 高額合算申請書.get口座ID();
        KogakuGassanShikyuShinseiToroku bussiness = KogakuGassanShikyuShinseiToroku.createInstance();
        IShikibetsuTaisho 被保険者情報 = bussiness.被保険者名の取得(高額合算申請書.get被保険者番号());
        SikyuSinseiJyohoParameter pram = new SikyuSinseiJyohoParameter();
        if (被保険者情報 != null) {
            ShikibetsuCode 最新の識別コード = 被保険者情報.get識別コード();
            div.getCcdKaigoAtenaInfo().initialize(最新の識別コード);
            pram.setShikibetsuCode(最新の識別コード);
        }
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        pram.setHihokenshaNo(被保険者番号);
        pram.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(高額合算申請書.get支払方法区分()));
        pram.setKozaId(口座ID);
        pram.setStartYMD(isNullOrEmptyFlexibleDate(高額合算申請書.get支払期間開始年月日()));
        pram.setStartHHMM(RString.isNullOrEmpty(高額合算申請書.get支払期間開始時間()) ? null
                : new RTime(高額合算申請書.get支払期間開始時間()));
        pram.setEndYMD(isNullOrEmptyFlexibleDate(高額合算申請書.get支払期間終了年月日()));
        pram.setEndHHMM(RString.isNullOrEmpty(高額合算申請書.get支払期間終了時間()) ? null
                : new RTime(高額合算申請書.get支払期間終了時間()));
        pram.setShiharaiBasho(高額合算申請書.get支払場所());
        div.getCcdShiharaiHohoJoho().initialize(pram, div.getTxtShinseiYMD().isReadOnly() ? 照会 : 修正);
    }

    private void 申請登録データで設定(KogakuGassanShinseishoRelate 高額合算申請書) {
        被保険者情報等TABデータで設定(高額合算申請書);
    }

    private void 被保険者情報等TABデータで設定(KogakuGassanShinseishoRelate 高額合算申請書) {
        div.getTabShinseiTorokuPanel1().getTxtKanyuKikanYMD()
                .setFromValue(isNullOrEmptyFlexibleDate(高額合算申請書.get加入期間開始年月日()));
        div.getTabShinseiTorokuPanel1().getTxtKanyuKikanYMD()
                .setToValue(isNullOrEmptyFlexibleDate(高額合算申請書.get加入期間終了年月日()));
        if (RString.isNullOrEmpty(高額合算申請書.get所得区分())) {
            div.getTabShinseiTorokuPanel1().getDdlShotokuKubun().setSelectedIndex(INT_0);
        } else {
            div.getTabShinseiTorokuPanel1().getDdlShotokuKubun().setSelectedKey(高額合算申請書.get所得区分());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get所得区分_70歳以上の者に係る())) {
            div.getTabShinseiTorokuPanel1().getDdlOver70ShotokuKubun().setSelectedIndex(INT_0);
        } else {
            div.getTabShinseiTorokuPanel1().getDdlOver70ShotokuKubun().setSelectedKey(高額合算申請書.get所得区分_70歳以上の者に係る());
        }
        div.getTabShinseiTorokuPanel1().getTxtShikakuSoshitsuYMD()
                .setValue(isNullOrEmptyFlexibleDate(高額合算申請書.get資格喪失年月日()));
        if (RString.isNullOrEmpty(高額合算申請書.get資格喪失事由())) {
            div.getTabShinseiTorokuPanel1().getDdlShikakuSoshitsuJiyu().setSelectedIndex(INT_0);
        } else {
            div.getTabShinseiTorokuPanel1().getDdlShikakuSoshitsuJiyu().setSelectedKey(高額合算申請書.get資格喪失事由());
        }
        div.getTabShinseiTorokuPanel1().getTxtTaishoKeisanKikanYMD()
                .setFromValue(isNullOrEmptyFlexibleDate(高額合算申請書.get対象計算期間開始年月日()));
        div.getTabShinseiTorokuPanel1().getTxtTaishoKeisanKikanYMD()
                .setToValue(isNullOrEmptyFlexibleDate(高額合算申請書.get対象計算期間終了年月日()));
        if (RString.isNullOrEmpty(高額合算申請書.get備考())) {
            div.getTabShinseiTorokuPanel1().getTxtBiko().clearValue();
        } else {
            div.getTabShinseiTorokuPanel1().getTxtBiko().setValue(高額合算申請書.get備考());
        }
    }

    private void 国保後期資格情報TABデータで設定(KogakuGassanShinseishoRelate 高額合算申請書) {
        div.getTabShinseiTorokuPanel2().getTxtKokuhoHokenshaNo().setValue(高額合算申請書.get国保保険者番号());
        if (RString.isNullOrEmpty(高額合算申請書.get国保被保険者証記号())) {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoHikonenshaShoKigo().clearValue();
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoHikonenshaShoKigo().setValue(高額合算申請書.get国保被保険者証記号());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get国保被保険者証番号())) {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoHikonenshaShoNo().clearValue();
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoHikonenshaShoNo().setValue(高額合算申請書.get国保被保険者証番号());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get国保世帯番号())) {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoSetaiNo().clearValue();
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoSetaiNo().setValue(高額合算申請書.get国保世帯番号());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get国保続柄())) {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoZokugara().setSelectedIndex(INT_0);
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoZokugara().setSelectedKey(高額合算申請書.get国保続柄());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get国保保険者名称())) {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoHokenshaMeisho().clearValue();
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokuhoHokenshaMeisho().setValue(高額合算申請書.get国保保険者名称());
        }
        div.getTabShinseiTorokuPanel2().getTxtKokuhoKanyuKikanYMD()
                .setFromValue(isNullOrEmptyFlexibleDate(高額合算申請書.get国保加入期間開始年月日()));
        div.getTabShinseiTorokuPanel2().getTxtKokuhoKanyuKikanYMD()
                .setToValue(isNullOrEmptyFlexibleDate(高額合算申請書.get国保加入期間終了年月日()));
        if (RString.isNullOrEmpty(高額合算申請書.get後期保険者番号())) {
            div.getTabShinseiTorokuPanel2().getTxtKokiHokenshaNo().clearValue();
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokiHokenshaNo().setValue(高額合算申請書.get後期保険者番号());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get後期被保険者番号())) {
            div.getTabShinseiTorokuPanel2().getTxtKokiHihokenshaNo().clearValue();
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokiHihokenshaNo().setValue(高額合算申請書.get後期被保険者番号());
        }
        if (RString.isNullOrEmpty(高額合算申請書.get後期広域連合名称())) {
            div.getTabShinseiTorokuPanel2().getTxtKokiKoikiRengoMeisho().clearValue();
        } else {
            div.getTabShinseiTorokuPanel2().getTxtKokiKoikiRengoMeisho().setValue(高額合算申請書.get後期広域連合名称());
        }
        div.getTabShinseiTorokuPanel2().getTxtKokiKanyuKikanYMD()
                .setFromValue(isNullOrEmptyFlexibleDate(高額合算申請書.get後期加入期間開始年月日()));
        div.getTabShinseiTorokuPanel2().getTxtKokiKanyuKikanYMD()
                .setToValue(isNullOrEmptyFlexibleDate(高額合算申請書.get後期加入期間終了年月日()));
    }

    private void 保険者加入情報パネルクリア() {
        div.getDgKanyuRirekiIchiran().getDataSource().clear();
        div.getTxtKanyuRirekiHokenshaMei().clearValue();
        div.getTxtKanyuRirekiKanyuKikanYMD().clearFromValue();
        div.getTxtKanyuRirekiKanyuKikanYMD().clearToValue();
        div.getTxtJikoFutangakuShomeishoSeiriBango().clearValue();
    }

    private void 保険者加入情報データで設定() {
        dgKanyuRirekiIchiran_Row row = div.getDgKanyuRirekiIchiran().getClickedItem();
        if (RString.isNullOrEmpty(row.getTxtHokenshaName())) {
            div.getTxtKanyuRirekiHokenshaMei().clearValue();
        } else {
            div.getTxtKanyuRirekiHokenshaMei().setValue(row.getTxtHokenshaName());
        }
        if (RString.isNullOrEmpty(row.getTxtKanyuKaishiYMD())) {
            div.getTxtKanyuRirekiKanyuKikanYMD().clearFromValue();
        } else {
            div.getTxtKanyuRirekiKanyuKikanYMD().setFromValue(new RDate(row.getTxtKanyuKaishiYMDStr().toString()));
        }
        if (RString.isNullOrEmpty(row.getTxtKanyuShuryoYMD())) {
            div.getTxtKanyuRirekiKanyuKikanYMD().clearToValue();
        } else {
            div.getTxtKanyuRirekiKanyuKikanYMD().setToValue(new RDate(row.getTxtKanyuShuryoYMDStr().toString()));
        }
        if (RString.isNullOrEmpty(row.getTxtJikofutanSeiriNo())) {
            div.getTxtJikoFutangakuShomeishoSeiriBango().clearValue();
        } else {
            div.getTxtJikoFutangakuShomeishoSeiriBango().setValue(row.getTxtJikofutanSeiriNo());
        }
    }

    private List<dgKanyuRirekiIchiran_Row> sort加入履歴グリッド(List<dgKanyuRirekiIchiran_Row> rowList) {
        if (rowList.isEmpty()) {
            return rowList;
        }
        Collections.sort(rowList, new Comparator<dgKanyuRirekiIchiran_Row>() {
            @Override
            public int compare(dgKanyuRirekiIchiran_Row arg0, dgKanyuRirekiIchiran_Row arg1) {
                if (arg1.getTxtHihokenshaNo().compareTo(arg0.getTxtHihokenshaNo()) == 0) {
                    return arg1.getTxtKanyurekiNo().compareTo(arg0.getTxtKanyurekiNo());
                }
                return arg1.getTxtHihokenshaNo().compareTo(arg0.getTxtHihokenshaNo());
            }
        });
        return rowList;
    }

    private List<dgShinseiIchiran_Row> sort申請情報グリッド(List<dgShinseiIchiran_Row> rowList) {
        if (rowList.isEmpty()) {
            return rowList;
        }
        Collections.sort(rowList, new Comparator<dgShinseiIchiran_Row>() {
            @Override
            public int compare(dgShinseiIchiran_Row arg0, dgShinseiIchiran_Row arg1) {
                return arg1.getTxtHihokenshaNo().compareTo(arg0.getTxtHihokenshaNo());
            }
        });
        return rowList;
    }

    private void 申請情報クリア() {
        div.getTxtTeishutsuHokenshaNo().clearValue();
        div.getDdlShokisaiHokenshaNo().setSelectedIndex(INT_0);
        div.getTxtKaigoShikyuShinseishoSeiriBango1().clearValue();
        div.getTxtKaigoShikyuShinseishoSeiriBango2().clearValue();
        div.getTxtKaigoShikyuShinseishoSeiriBango3().clearValue();
        div.getTxtKaigoShikyuShinseishoSeiriBango4().clearValue();
        div.getTxtRirekiBango().clearValue();
        div.getDdlShinseiTaishoNendo().setSelectedIndex(INT_0);
        div.getTxtIryoShikyuShinseishoSeiriBango1().clearValue();
        div.getTxtIryoShikyuShinseishoSeiriBango2().clearValue();
        div.getTxtIryoShikyuShinseishoSeiriBango3().clearValue();
        div.getTxtIryoShikyuShinseishoSeiriBango4().clearValue();
        div.getTxtShikyuShinseiKubun().clearValue();
        div.getDdlShikyuShinseiKeitai().setSelectedIndex(INT_0);
        div.getTxtShinseiYMD().clearValue();
        div.getChkKofuShinseiUmu().setSelectedItemsByKey(Collections.EMPTY_LIST);
        div.getTxtDaihyoshaShimei().clearValue();
        div.getTxtDaihyoshaJusho().clearValue();
        div.getTxtDaihyoshaTelNo().clearDomain();
        div.getTxtDaihyoshaYubinNo().clearValue();
    }

    private void 被保険者情報等TABクリア() {
        div.getTabShinseiTorokuPanel1().getDdlShotokuKubun().setSelectedIndex(INT_0);
        div.getTabShinseiTorokuPanel1().getTxtKanyuKikanYMD().clearFromValue();
        div.getTabShinseiTorokuPanel1().getTxtKanyuKikanYMD().clearToValue();
        div.getTabShinseiTorokuPanel1().getDdlOver70ShotokuKubun().setSelectedIndex(INT_0);
        div.getTabShinseiTorokuPanel1().getDdlShikakuSoshitsuJiyu().setSelectedIndex(INT_0);
        div.getTabShinseiTorokuPanel1().getTxtShikakuSoshitsuYMD().clearValue();
        div.getTabShinseiTorokuPanel1().getTxtTaishoKeisanKikanYMD().clearFromValue();
        div.getTabShinseiTorokuPanel1().getTxtTaishoKeisanKikanYMD().clearToValue();
        div.getTabShinseiTorokuPanel1().getTxtBiko().clearValue();
    }

    private void 国保後期資格情報TABクリア() {
        div.getTabShinseiTorokuPanel2().getTxtKokuhoHokenshaNo().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokuhoHokenshaMeisho().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokuhoHikonenshaShoKigo().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokuhoHikonenshaShoNo().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokuhoSetaiNo().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokuhoZokugara().setSelectedIndex(INT_0);
        div.getTabShinseiTorokuPanel2().getTxtKokuhoKanyuKikanYMD().clearFromValue();
        div.getTabShinseiTorokuPanel2().getTxtKokuhoKanyuKikanYMD().clearToValue();
        div.getTabShinseiTorokuPanel2().getTxtKokiHokenshaNo().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokiKoikiRengoMeisho().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokiHihokenshaNo().clearValue();
        div.getTabShinseiTorokuPanel2().getTxtKokiKanyuKikanYMD().clearFromValue();
        div.getTabShinseiTorokuPanel2().getTxtKokiKanyuKikanYMD().clearToValue();
    }

    /**
     * 高額合算申請書変更判定メソッドです。
     *
     * @param 高額合算申請書Result KogakuGassanShinseishoRelate
     * @return KogakuGassanShinseishoRelate
     */
    public KogakuGassanShinseishoRelate 高額合算申請書変更判定(KogakuGassanShinseishoRelate 高額合算申請書Result) {
        return 高額合算申請書Result.createBuilderForEdit()
                .set申請年月日(rDateToFixibleDate(div.getTxtShinseiYMD().getValue()))
                .set支給申請書整理番号(RString.EMPTY.concat(div.getTxtKaigoShikyuShinseishoSeiriBango1().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango2().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango4().getValue()))
                .set国保支給申請書整理番号(RString.EMPTY.concat(div.getTxtIryoShikyuShinseishoSeiriBango1().getValue())
                        .concat(div.getTxtIryoShikyuShinseishoSeiriBango2().getValue())
                        .concat(div.getTxtIryoShikyuShinseishoSeiriBango3().getValue())
                        .concat(div.getTxtIryoShikyuShinseishoSeiriBango4().getValue()))
                .set対象計算期間開始年月日(rDateToFixibleDate(div.getTxtTaishoKeisanKikanYMD().getFromValue()))
                .set対象計算期間終了年月日(rDateToFixibleDate(div.getTxtTaishoKeisanKikanYMD().getToValue()))
                .set支給申請形態(div.getDdlShikyuShinseiKeitai().getSelectedKey())
                .set自己負担額証明書交付申請の有無(Collections.EMPTY_LIST.equals(div.getChkKofuShinseiUmu().getSelectedKeys()) ? RSTRING_1 : RSTRING_2)
                .set所得区分(RString.isNullOrEmpty(div.getDdlShotokuKubun().getSelectedValue()) ? null : div.getDdlShotokuKubun().getSelectedKey())
                .set所得区分_70歳以上の者に係る(div.getDdlOver70ShotokuKubun().getSelectedKey())
                .set資格喪失年月日(rDateToFixibleDate(div.getTxtShikakuSoshitsuYMD().getValue()))
                .set資格喪失事由(div.getDdlShikakuSoshitsuJiyu().getSelectedKey())
                .set加入期間開始年月日(rDateToFixibleDate(div.getTxtKanyuKikanYMD().getFromValue()))
                .set加入期間終了年月日(rDateToFixibleDate(div.getTxtKanyuKikanYMD().getToValue()))
                .set国保保険者番号(div.getTxtKokuhoHokenshaNo().getValue())
                .set国保保険者名称(div.getTxtKokuhoHokenshaMeisho().getValue())
                .set国保被保険者証記号(div.getTxtKokuhoHikonenshaShoKigo().getValue())
                .set国保被保険者証番号(div.getTxtKokuhoHikonenshaShoNo().getValue())
                .set国保世帯番号(div.getTxtKokuhoSetaiNo().getValue())
                .set国保続柄(div.getTxtKokuhoZokugara().getSelectedKey())
                .set国保加入期間開始年月日(rDateToFixibleDate(div.getTxtKokuhoKanyuKikanYMD().getFromValue()))
                .set国保加入期間終了年月日(rDateToFixibleDate(div.getTxtKokuhoKanyuKikanYMD().getToValue()))
                .set後期保険者番号(div.getTxtKokiHokenshaNo().getValue())
                .set後期広域連合名称(div.getTxtKokiKoikiRengoMeisho().getValue())
                .set後期被保険者番号(div.getTxtKokiHihokenshaNo().getValue())
                .set後期加入期間開始年月日(rDateToFixibleDate(div.getTxtKokiKanyuKikanYMD().getFromValue()))
                .set後期加入期間終了年月日(rDateToFixibleDate(div.getTxtKokiKanyuKikanYMD().getToValue()))
                .set支払方法区分(div.getCcdShiharaiHohoJoho().getShiharaiHohoRad())
                .set支払場所(div.getCcdShiharaiHohoJoho().getShiharaiBasho())
                .set支払期間開始年月日(rDateToFixibleDate(div.getCcdShiharaiHohoJoho().getStartYMD()))
                .set支払期間終了年月日(rDateToFixibleDate(div.getCcdShiharaiHohoJoho().getEndYMD()))
                .set支払期間開始時間(div.getCcdShiharaiHohoJoho().getStartHHMM() == null ? null
                        : div.getCcdShiharaiHohoJoho().getStartHHMM().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss))
                .set支払期間終了時間(div.getCcdShiharaiHohoJoho().getEndHHMM() == null ? null
                        : div.getCcdShiharaiHohoJoho().getEndHHMM().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss))
                .set口座ID(RString.isNullOrEmpty(div.getCcdShiharaiHohoJoho().getKozaID()) ? 0L
                        : Long.parseLong(div.getCcdShiharaiHohoJoho().getKozaID().toString()))
                .set備考(div.getTxtBiko().getValue())
                .build();
    }

    private RDate isNullOrEmptyFlexibleDate(FlexibleDate date) {
        if (date == null || new RString(date.toString()).isEmpty()) {
            return null;
        }
        return new RDate(date.toString());
    }

    private FlexibleDate rDateToFixibleDate(RDate date) {
        if (date == null || new RString(date.toString()).isEmpty()) {
            return null;
        }
        return new FlexibleDate(date.toString());
    }

    private RString 加入歴番号編集(List<KogakuGassanShinseishoKanyureki> 高額合算申請書加入歴list) {
        if (高額合算申請書加入歴list == null || 高額合算申請書加入歴list.isEmpty()) {
            return RSTRING_1.padZeroToLeft(INT_2);
        }
        return new RString(高額合算申請書加入歴list.size() + INT_1).padZeroToLeft(INT_2);
    }

    private KogakuGassanShinseishoRelate 変更判定(KogakuGassanShinseishoRelate 高額合算申請書) {
        if (高額合算申請書.hasChanged() || 加入歴判定(高額合算申請書.get高額合算申請書加入歴list())) {
            高額合算申請書 = 高額合算申請書.modifiedModel();
        }
        return 高額合算申請書;
    }

    private boolean 加入歴判定(List<KogakuGassanShinseishoKanyureki> 高額合算申請書加入歴list) {
        if (高額合算申請書加入歴list == null) {
            return false;
        }
        boolean 加入歴変更flg = false;
        for (KogakuGassanShinseishoKanyureki item : 高額合算申請書加入歴list) {
            if (item.hasChanged()) {
                加入歴変更flg = true;
                return 加入歴変更flg;
            }
        }
        return 加入歴変更flg;
    }
}
