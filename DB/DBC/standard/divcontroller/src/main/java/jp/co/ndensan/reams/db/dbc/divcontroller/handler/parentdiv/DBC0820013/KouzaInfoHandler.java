/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820013;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払い費支給申請決定_口座情報画面
 *
 * @reamsid_L DBC-1030-150 gongliang
 */
public class KouzaInfoHandler {

    private final KouzaInfoPanelDiv div;
    private static final RString 受託なし = new RString("1");
    private static final RString 受託あり = new RString("2");
    private static final RString 窓口払_コード = new RString("1");
    private static final RString 口座払_コード = new RString("2");
    private static final int NUM_0 = 0;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_5 = 5;
    private static final RString 償還払支給申請 = new RString("償還払支給申請");

    /**
     * KouzaInfoHandlerのコンストラクタです。
     *
     * @param div KouzaInfoPanelDiv
     */
    public KouzaInfoHandler(KouzaInfoPanelDiv div) {
        this.div = div;
    }

    /**
     * ヘッダエリアの設定です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void loadヘッダエリア(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
    }

    /**
     * 申請共通エリアの設定する。
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 処理モード RString
     */
    public void load申請共通エリア(FlexibleYearMonth サービス年月, RString 整理番号, RString 処理モード) {
        if (サービス年月 == null) {
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(null);
        } else {
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        }
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
        div.getPanelTwo().getTxtShoriMode().setValue(処理モード);
    }

    /**
     * 登録モードの初期化メソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 国保連送付フラグ Boolean
     */
    public void load登録(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            Boolean 国保連送付フラグ) {
        RString config = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託なし.equals(config)) {
            div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(false);
        } else if (受託あり.equals(config) && 国保連送付フラグ) {
            ShokanHanteiKekka shokanHanteiKekka = SyokanbaraihiShikyuShinseiKetteManager
                    .createInstance().getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
            if (shokanHanteiKekka != null) {
                div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(false);
            } else {
                div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(true);
            }
        }
    }

    /**
     * 申請既存チェックです。
     *
     * @param 整理番号 RString
     * @param サービス年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     */
    public void 申請既存チェック(RString 整理番号, FlexibleYearMonth サービス年月, HihokenshaNo 被保険者番号) {
        List<ShokanShinsei> entity = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (entity == null || entity.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace(償還払支給申請.toString()));
        }
    }

    /**
     * 画面内容の変更有無チェックです。
     *
     * @param entityView ViewStateの償還払い費支給申請決定_口座情報
     * @return 画面内容の変更
     */
    public Boolean 変更有無チェック(ShokanShinsei entityView) {
        IShiharaiHohoJyohoDiv 支払方法情報共有DIV = div.getPnlCommon().getCcdShinseiNaiyo();
        if (checkObject(entityView.get支払方法区分コード(), 支払方法情報共有DIV.getShiharaiHohoRad()) == 1) {
            return true;
        }
        int i = 0;
        if (窓口払_コード.equals(支払方法情報共有DIV.getShiharaiHohoRad())) {
            i = i + checkObject(entityView.get支払場所(), 支払方法情報共有DIV.getShiharaiBasho());
            i = i + checkDate(支払方法情報共有DIV.getStartYMD(), entityView.get支払期間開始年月日());
            i = i + checkDate(支払方法情報共有DIV.getEndYMD(), entityView.get支払期間終了年月日());
            RString 支払窓口開始時間 = null;
            RTime 支払窓口開始時間div = 支払方法情報共有DIV.getStartHHMM();
            if (支払窓口開始時間div != null) {
                RString 支払窓口開始時間R = new RString(支払窓口開始時間div.toString());
                RStringBuilder builder = new RStringBuilder();
                builder.append(支払窓口開始時間R.substring(NUM_0, NUM_2));
                builder.append(支払窓口開始時間R.substring(NUM_3, NUM_5));
                支払窓口開始時間 = builder.toRString();
            }
            i = i + checkObject(支払窓口開始時間, entityView.get支払窓口開始時間());
            RString 支払窓口終了時間 = null;
            RTime 支払窓口終了時間div = 支払方法情報共有DIV.getEndHHMM();
            if (支払窓口終了時間div != null) {
                RString 支払窓口終了時間R = new RString(支払窓口終了時間div.toString());
                RStringBuilder builder = new RStringBuilder();
                builder.append(支払窓口終了時間R.substring(NUM_0, NUM_2));
                builder.append(支払窓口終了時間R.substring(NUM_3, NUM_5));
                支払窓口終了時間 = builder.toRString();
            }
            i = i + checkObject(支払窓口終了時間, entityView.get支払窓口終了時間());
            return i > 0;
        } else if (口座払_コード.equals(支払方法情報共有DIV.getShiharaiHohoRad())) {
            return !new RString(String.valueOf(entityView.get口座ID())).equals(支払方法情報共有DIV.getKozaID());
        } else {
            return checkObject(支払方法情報共有DIV.getKeiyakuNo(), entityView.get受領委任契約番号()) > 0;
        }

    }

    /**
     * 「申請を保存する」ボタン 登録、修正の場合です。
     *
     * @param entityView ViewStateの償還払い費支給申請決定_口座情報
     * @param 整理番号 RString
     * @param サービス年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     */
    public void 保存_修正(ShokanShinsei entityView, RString 整理番号, FlexibleYearMonth サービス年月, HihokenshaNo 被保険者番号) {
        IShiharaiHohoJyohoDiv 支払方法情報共有DIV = div.getPnlCommon().getCcdShinseiNaiyo();
        RString 支払方法区分コード = 支払方法情報共有DIV.getShiharaiHohoRad();
        if (窓口払_コード.equals(支払方法区分コード)) {
            RString 支払場所 = 支払方法情報共有DIV.getShiharaiBasho();
            FlexibleDate 支払期間開始年月日 = FlexibleDate.EMPTY;
            RDate 支払期間開始年月日div = 支払方法情報共有DIV.getStartYMD();
            if (支払期間開始年月日div != null) {
                支払期間開始年月日 = new FlexibleDate(支払期間開始年月日div.toString());
            }
            FlexibleDate 支払期間終了年月日 = FlexibleDate.EMPTY;
            RDate 支払期間終了年月日div = 支払方法情報共有DIV.getEndYMD();
            if (支払期間終了年月日div != null) {
                支払期間終了年月日 = new FlexibleDate(支払期間終了年月日div.toString());
            }
            RString 支払窓口開始時間 = RString.EMPTY;
            RTime 支払窓口開始時間div = 支払方法情報共有DIV.getStartHHMM();
            if (支払窓口開始時間div != null) {
                RString 支払窓口開始時間R = new RString(支払窓口開始時間div.toString());
                RStringBuilder builder = new RStringBuilder();
                builder.append(支払窓口開始時間R.substring(NUM_0, NUM_2));
                builder.append(支払窓口開始時間R.substring(NUM_3, NUM_5));
                支払窓口開始時間 = builder.toRString();
            }
            RString 支払窓口終了時間 = RString.EMPTY;
            RTime 支払窓口終了時間div = 支払方法情報共有DIV.getEndHHMM();
            if (支払窓口終了時間div != null) {
                RString 支払窓口終了時間R = new RString(支払窓口終了時間div.toString());
                RStringBuilder builder = new RStringBuilder();
                builder.append(支払窓口終了時間R.substring(NUM_0, NUM_2));
                builder.append(支払窓口終了時間R.substring(NUM_3, NUM_5));
                支払窓口終了時間 = builder.toRString();
            }
            entityView = entityView.createBuilderForEdit()
                    .set被保険者番号(被保険者番号)
                    .setサービス提供年月(サービス年月)
                    .set整理番号(整理番号)
                    .set支払場所(支払場所)
                    .set支払方法区分コード(支払方法区分コード)
                    .set支払期間開始年月日(支払期間開始年月日)
                    .set支払期間終了年月日(支払期間終了年月日)
                    .set支払窓口開始時間(支払窓口開始時間)
                    .set支払窓口終了時間(支払窓口終了時間).build();
        } else if (口座払_コード.equals(支払方法区分コード)) {
            long 口座Id = 0;
            RString 口座IdDiv = 支払方法情報共有DIV.getKozaID();
            if (口座IdDiv != null) {
                口座Id = Long.valueOf(口座IdDiv.toString());
            }
            entityView = entityView.createBuilderForEdit()
                    .set被保険者番号(被保険者番号)
                    .setサービス提供年月(サービス年月)
                    .set整理番号(整理番号)
                    .set支払方法区分コード(支払方法区分コード)
                    .set口座ID(口座Id).build();
        } else {
            RString 受領委任契約番号 = 支払方法情報共有DIV.getKeiyakuNo();
            entityView = entityView.createBuilderForEdit()
                    .set被保険者番号(被保険者番号)
                    .setサービス提供年月(サービス年月)
                    .set整理番号(整理番号)
                    .set支払方法区分コード(支払方法区分コード)
                    .set受領委任契約番号(受領委任契約番号).build();
        }
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updDbT3034ShokanShinsei(entityView);
    }

    /**
     * 「申請を保存する」ボタン 削除モードの場合です。
     *
     * @param 整理番号 RString
     * @param 識別コード ShikibetsuCode
     * @param サービス年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     */
    public void 保存_削除(RString 整理番号, ShikibetsuCode 識別コード, FlexibleYearMonth サービス年月, HihokenshaNo 被保険者番号) {
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().delDbT3034ShokanShinsei(被保険者番号, サービス年月, 整理番号, 識別コード);
    }

    /**
     * 償還払支給申請詳細データ取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return 償還払支給申請
     */
    public ShokanShinsei get償還払支給申請(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {
        List<ShokanShinsei> 支給申請一覧情報リスト = InstanceProvider.create(ShokanbaraiJyokyoShokai.class)
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (支給申請一覧情報リスト.isEmpty()) {
            return new ShokanShinsei(被保険者番号, サービス年月, 整理番号);
        }
        return 支給申請一覧情報リスト.get(0);
    }

    private int checkObject(RString obj1, RString obj2) {
        if ((obj1 == null || obj1.isEmpty()) && (obj2 == null || obj2.isEmpty())) {
            return 0;
        } else if (obj1 != null && obj1.equals(obj2)) {
            return 0;
        }
        return 1;
    }

    private int checkDate(RDate date, FlexibleDate flexibledate) {
        if (date == null && flexibledate == null) {
            return 0;
        } else if (date != null && new FlexibleDate(date.toString()).equals(flexibledate)) {
            return 0;
        }
        return 1;
    }

}
