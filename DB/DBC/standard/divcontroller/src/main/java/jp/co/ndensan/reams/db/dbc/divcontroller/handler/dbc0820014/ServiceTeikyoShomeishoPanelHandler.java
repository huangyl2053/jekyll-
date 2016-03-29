/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.ServiceTeikyoShomeishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.dgdServiceTeikyoShomeisyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 償還払い費支給申請決定_サービス提供証明書のHandlerです。
 */
public class ServiceTeikyoShomeishoPanelHandler {

    private final ServiceTeikyoShomeishoPanelDiv div;
    private static final RString 受託なし = new RString("1");
    private static final RString 受託あり = new RString("2");
    private static final RString 登録モード = new RString("登録");
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 画面モード_新規 = new RString("新規");
    private static final RString 処理モード_参照 = new RString("参照");
    private static final RString 処理モード_修正 = new RString("修正");
    private static final RString 処理モード_登録 = new RString("登録");
    private static final RString 証明書BLANK = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     */
    public ServiceTeikyoShomeishoPanelHandler(ServiceTeikyoShomeishoPanelDiv div) {
        this.div = div;
    }

    /**
     * 宛名情報と資格系基本情報データを取得する。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void load宛名と基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        // TODO QA529 「介護宛名情報」と「介護資格系基本情報」の取得のパラメータ問題があります。
        div.getPanelOne().getCcdKaigoAtenaInfo().onLoad(識別コード);
        div.getPanelOne().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
    }

    /**
     * ボタンエリアの初期化です。
     *
     * @param 画面モード 画面モード
     * @param 国保連送付フラグ 国保連送付フラグ
     */
    public void loadボタンエリア(RString 画面モード, Boolean 国保連送付フラグ) {
        if (登録モード.equals(画面モード)) {
            RString config = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
            if (受託なし.equals(config)) {
                div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(false);
            } else if (受託あり.equals(config) && 国保連送付フラグ) {
                div.getPanelShinseiNaiyo().setDisabled(true);
                div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getGridSetting().setIsShowDeleteButtonColumn(false);
                div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getGridSetting().setIsShowModifyButtonColumn(false);
            }
        }
    }

    /**
     * 申請共通エリアの初期化です。
     *
     * @param 画面モード 画面モード
     * @param 償還払支給申請 償還払支給申請
     */
    public void load申請共通エリア(RString 画面モード, ShokanShinsei 償還払支給申請) {
        if (登録モード.equals(画面モード)) {
            set申請共通エリア(null, 画面モード_新規);
        } else if (修正モード.equals(画面モード)) {
            set申請共通エリア(償還払支給申請, 処理モード_修正);
        } else if (削除モード.equals(画面モード)) {
            set申請共通エリア(null, 処理モード_参照);
        }
    }

    /**
     * 申請明細エリアの初期化です。
     *
     * @param 画面モード 画面モード
     * @param 償還払支給申請 償還払支給申請
     * @param 証明書リスト 証明書リスト
     * @param 証明書一覧情報 証明書一覧情報
     */
    public void load申請明細エリア(RString 画面モード,
            ShokanShinsei 償還払支給申請,
            List<ShikibetsuNoKanri> 証明書リスト,
            List<ServiceTeikyoShomeishoResult> 証明書一覧情報) {
        if (償還払支給申請.get申請年月日() != null) {
            div.getPanelShinseiNaiyo().getTxtShinseibi().setValue(new RDate(償還払支給申請.get申請年月日().toString()));
        }
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(証明書BLANK, RString.EMPTY);
        dataSourceList.add(dataSourceBlank);
        for (ShikibetsuNoKanri 識別番号管理 : 証明書リスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource(識別番号管理.get識別番号(), 識別番号管理.get名称());
            dataSourceList.add(dataSource);
        }
        div.getPanelShinseiNaiyo().getDdlShomeisho().setDataSource(dataSourceList);
        div.getPanelShinseiNaiyo().getDdlShomeisho().setSelectedKey(証明書BLANK);
        List<dgdServiceTeikyoShomeisyo_Row> rowDataList = new ArrayList<>();
        for (ServiceTeikyoShomeishoResult 証明書情報 : 証明書一覧情報) {
            dgdServiceTeikyoShomeisyo_Row row = new dgdServiceTeikyoShomeisyo_Row();
            row.setData1(証明書情報.getServiceTeikyoShomeisho().getJigyoshaNo().getColumnValue());
            row.setData2(証明書情報.getServiceTeikyoShomeisho().getJigyoshaName().getColumnValue());
            row.setData3(証明書情報.getServiceTeikyoShomeisho().getMeisanNo());
            row.setData4(証明書情報.getServiceTeikyoShomeisho().getYoshikiNo());
            rowDataList.add(row);
        }
        div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().setDataSource(rowDataList);
        set申請明細エリア表示制御(画面モード);
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
        List<ShokanShinsei> 支給申請一覧情報リスト = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (支給申請一覧情報リスト.isEmpty()) {
            return new ShokanShinsei(被保険者番号, サービス年月, 整理番号);
        }
        ViewStateHolder.put(ViewStateKeys.償還払支給申請詳細データ, 支給申請一覧情報リスト.get(0));
        return 支給申請一覧情報リスト.get(0);
    }

    /**
     * ViewStateに情報を設定する。
     */
    public void putViewState() {
        // TODO QA528 ViewStateの設定。
        ShoukanharaihishinseikensakuParameter parameter = ViewStateHolder
                .get(ViewStateKeys.償還払費申請検索キー, ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = null;
        if (div.getPanelTwo().getTxtServiceTeikyoYM() != null) {
            サービス年月 = new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().toString());
        }
        RString 整理番号 = div.getPanelTwo().getTxtSeiriBango().getValue();
        ShoukanharaihishinseikensakuParameter par = new ShoukanharaihishinseikensakuParameter(
                被保険者番号,
                サービス年月,
                整理番号,
                parameter.getJigyoshaNo(),
                parameter.getYoshikiNo(),
                parameter.getMeisaiNo(),
                parameter.getKyufuritsu());
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
    }

    /**
     * 「追加する」ボタンと「グリッドの修正」ボタン ViewStateに情報を設定する。
     *
     * @param 処理モード 処理モード
     */
    public void putViewStateDown(RString 処理モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toString());
        RDate 申請日 = div.getPanelShinseiNaiyo().getTxtShinseibi().getValue();
        RString 整理番号 = div.getPanelTwo().getTxtSeiriBango().getValue();
        dgdServiceTeikyoShomeisyo_Row row = div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow();
        JigyoshaNo 事業者番号 = JigyoshaNo.EMPTY;
        RString 事業者番号_入力 = div.getPanelShinseiNaiyo().getCcdShisetsuJoho().getNyuryokuShisetsuKodo();
        RString 事業者番号_当該行 = row.getData1();
        if (処理モード_登録.equals(処理モード) && 事業者番号_入力 != null) {
            事業者番号 = new JigyoshaNo(事業者番号_入力);
        } else if (事業者番号_当該行 != null) {
            事業者番号 = new JigyoshaNo(事業者番号_当該行);
        }
        RString 様式番号 = RString.EMPTY;
        if (処理モード_登録.equals(処理モード)) {
            様式番号 = div.getPanelShinseiNaiyo().getDdlShomeisho().getSelectedValue();
        } else {
            様式番号 = row.getData4();
        }
        RString 明細番号 = null;
        if (!処理モード_登録.equals(処理モード)) {
            明細番号 = row.getData3();
        }
        ShoukanharaihishinseimeisaikensakuParameter parameter = new ShoukanharaihishinseimeisaikensakuParameter(
                被保険者番号, サービス年月, 申請日, 整理番号, 事業者番号, 様式番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード);
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, parameter);
    }

    /**
     * 「口座情報」ボタンを押下する、チェックです。
     *
     * @return 申請既存チェック
     */
    public Boolean 申請既存チェック() {
        // TODO QA528 申請既存チェックは設計書の里にありません。
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        List<ShokanShinsei> 支給申請一覧情報リスト = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (支給申請一覧情報リスト == null || 支給申請一覧情報リスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace("支給申請").evaluate());
        }
        return true;
    }

    /**
     * 「追加する」ボタンを押下する、チェックです。
     *
     * @return 証明書選択チェック
     */
    public Boolean 証明書選択チェック() {
        if (証明書BLANK.equals(div.getPanelShinseiNaiyo().getDdlShomeisho().getSelectedKey())) {
            throw new ApplicationException(UrErrorMessages.選択されていない
                    .getMessage().replace("証明書").evaluate());
        }
        return true;
    }

    /**
     * 「追加する」ボタンを押下する、チェックです。
     *
     * @return サービス提供証明書の存在チェック
     */
    public Boolean サービス提供証明書の存在チェック() {
        // TODO QA530 viewStateの償還払費証明書検索キーの取得。
        ShoukanharaihishinseikensakuParameter parameter = ViewStateHolder
                .get(ViewStateKeys.償還払費申請検索キー, ShoukanharaihishinseikensakuParameter.class);
        JigyoshaNo 事業者番号 = new JigyoshaNo(div.getPanelShinseiNaiyo().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        RString 様式番号 = div.getPanelShinseiNaiyo().getDdlShomeisho().getSelectedValue();
        int 証明書件数 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShikibetsuNoKanri(
                parameter.getHiHokenshaNo(),
                parameter.getServiceTeikyoYM(),
                parameter.getSeiriNp(),
                事業者番号,
                様式番号);
        if (証明書件数 > 0) {
            throw new ApplicationException(UrErrorMessages.選択されていない
                    .getMessage().replace("証明書").evaluate());
        }
        return true;
    }

    private void set申請共通エリア(ShokanShinsei 償還払支給申請, RString 処理モード) {
        if (償還払支給申請 != null) {
            if (償還払支給申請.getサービス提供年月() != null) {
                div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(償還払支給申請.getサービス提供年月().toString()));
            }
            div.getPanelTwo().getTxtSeiriBango().setValue(償還払支給申請.get整理番号());
        }
        div.getPanelTwo().getTxtShoriMode().setValue(処理モード);
    }

    private void set申請明細エリア表示制御(RString 画面モード) {
        if (登録モード.equals(画面モード)) {
            div.getPanelShinseiNaiyo().getTxtShinseibi().setDisabled(true);
            // TODO QA528 事業者名の非活性
            div.getPanelShinseiNaiyo().getCcdShisetsuJoho().setDisabled(false);
        } else if (削除モード.equals(画面モード)) {
            div.getPanelShinseiNaiyo().setDisabled(true);
        }
    }
}
