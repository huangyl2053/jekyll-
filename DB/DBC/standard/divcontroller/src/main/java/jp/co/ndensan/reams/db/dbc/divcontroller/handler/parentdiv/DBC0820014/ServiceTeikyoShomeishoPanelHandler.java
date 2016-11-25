/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShomeishoGridList;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.ServiceTeikyoShomeishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.dgdServiceTeikyoShomeisyo_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteFath;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 償還払い費支給申請決定_サービス提供証明書のHandlerです。
 *
 * @reamsid_L DBC-1030-130 gongliang
 */
public class ServiceTeikyoShomeishoPanelHandler {

    private final ServiceTeikyoShomeishoPanelDiv div;
    private static final RString 受託あり = new RString("2");
    private static final RString 証明書BLANK = new RString("0");
    private static final RString 証明書 = new RString("証明書");
    private static final RString 支給申請 = new RString("償還払支給申請");
    private static final RString 登録モード = new RString("登録");
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 画面モード_新規 = new RString("新規");
    private static final RString 処理モード_参照 = new RString("参照");
    private static final RString 処理モード_修正 = new RString("修正");
    private static final RString チェック区分 = new RString("1");
    private static final RString 処理区分_0 = new RString("0");
    private static final RString 処理_削除 = new RString("削除");
    private static final RString 一日時点 = new RString("01");

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
        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
    }

    /**
     * ボタンエリアの初期化です。
     *
     * @param 画面モード RString
     */
    public void loadボタンエリア(RString 画面モード) {
        RString config = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託あり.equals(config) && 登録モード.equals(画面モード)) {
            div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(true);
        } else {
            div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(false);
        }
    }

    /**
     * 申請共通エリアの初期化です。
     *
     * @param 処理モード RString
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     */
    public void load申請共通エリア(RString 処理モード, FlexibleYearMonth サービス年月, RString 整理番号) {
        if (登録モード.equals(処理モード)) {
            set申請共通エリア(画面モード_新規, サービス年月, 整理番号);
        } else if (修正モード.equals(処理モード)) {
            set申請共通エリア(処理モード_修正, サービス年月, 整理番号);
        } else if (削除モード.equals(処理モード)) {
            set申請共通エリア(処理モード_参照, サービス年月, 整理番号);
        }
    }

    /**
     * 申請明細エリアの初期化です。
     *
     * @param 処理モード 処理モード
     * @param 申請日 申請日
     * @param 証明書リスト 証明書リスト
     * @param 証明書一覧情報 証明書一覧情報
     * @param 償還払ViewStateDB情報 償還払ViewStateDB情報
     * @param サービス年月 サービス年月
     */
    public void load申請明細エリア(RString 処理モード,
            RDate 申請日,
            List<ShikibetsuNoKanri> 証明書リスト,
            List<ServiceTeikyoShomeishoResult> 証明書一覧情報,
            DbJohoViewState 償還払ViewStateDB情報,
            FlexibleYearMonth サービス年月) {
        div.getPanelShinseiNaiyo().getTxtShinseibi().setValue(申請日);
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
        ArrayList<ShomeishoGridList> 証明書グリッドList = 償還払ViewStateDB情報.get証明書グリッドリスト();
        if (証明書グリッドList != null && !証明書グリッドList.isEmpty()) {
            for (ShomeishoGridList shomeishoGrid : 証明書グリッドList) {
                dgdServiceTeikyoShomeisyo_Row row = new dgdServiceTeikyoShomeisyo_Row();
                row.setShori(shomeishoGrid.get処理());
                row.setData1(shomeishoGrid.get事業者番号());
                row.setData2(SyokanbaraihiShikyuShinseiKetteFath.createInstance()
                        .get介護事業者(new JigyoshaNo(shomeishoGrid.get事業者番号()), new FlexibleDate(サービス年月.toDateString().concat(一日時点))));
                row.setData3(shomeishoGrid.get明細());
                row.setData4(shomeishoGrid.getサービス提供証明書());
                row.setShoriKubun(shomeishoGrid.get処理区分());
                rowDataList.add(row);
            }
        } else {
            for (ServiceTeikyoShomeishoResult 証明書情報 : 証明書一覧情報) {
                dgdServiceTeikyoShomeisyo_Row row = new dgdServiceTeikyoShomeisyo_Row();
                row.setShori(RString.EMPTY);
                JigyoshaNo jigyoshaNo = 証明書情報.getServiceTeikyoShomeisho().getJigyoshaNo();
                if (jigyoshaNo != null) {
                    row.setData1(jigyoshaNo.getColumnValue());
                    row.setData2(SyokanbaraihiShikyuShinseiKetteFath.createInstance()
                            .get介護事業者(jigyoshaNo, new FlexibleDate(サービス年月.toDateString().concat(一日時点))));
                }
                row.setData3(証明書情報.getServiceTeikyoShomeisho().getMeisanNo());
                row.setData4(証明書情報.getServiceTeikyoShomeisho().getYoshikiNo());
                row.setShoriKubun(処理区分_0);
                rowDataList.add(row);
            }
        }
        div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().setDataSource(rowDataList);
        set申請明細エリア表示制御(処理モード);
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
        return 支給申請一覧情報リスト.get(0);
    }

    /**
     * 「口座情報」ボタンを押下する、チェックです。
     *
     * @param 整理番号 RString
     * @param サービス年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @return 申請既存チェック
     */
    public Boolean 申請既存チェック(RString 整理番号, FlexibleYearMonth サービス年月, HihokenshaNo 被保険者番号) {
        List<ShokanShinsei> 支給申請一覧情報リスト = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (支給申請一覧情報リスト == null || 支給申請一覧情報リスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace(支給申請.toString()).evaluate());
        }
        return true;
    }

    /**
     * 「追加する」ボタンを押下する、チェックです。
     *
     */
    public void 証明書選択チェック() {
        if (証明書BLANK.equals(div.getPanelShinseiNaiyo().getDdlShomeisho().getSelectedKey())) {
            throw new ApplicationException(UrErrorMessages.選択されていない
                    .getMessage().replace(証明書.toString()).evaluate());
        }
    }

    /**
     * 「追加する」ボタンを押下する、チェックです。
     *
     * @param 整理番号 RString
     * @param サービス年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @param 償還払ViewStateDB情報 DbJohoViewState
     * @return サービス提供証明書の存在チェック
     */
    public Boolean サービス提供証明書の存在チェック(RString 整理番号, FlexibleYearMonth サービス年月,
            HihokenshaNo 被保険者番号, DbJohoViewState 償還払ViewStateDB情報) {
        JigyoshaNo 事業者番号 = new JigyoshaNo(div.getPanelShinseiNaiyo().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        RString 様式番号 = div.getPanelShinseiNaiyo().getDdlShomeisho().getSelectedKey();
        int 証明書件数 = SyokanbaraihiShikyuShinseiKetteFath.createInstance().getShikibetsuNoKanri(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号,
                チェック区分);
        if (証明書件数 > 0) {
            throw new ApplicationException(UrErrorMessages.既に登録済
                    .getMessage().replace(証明書.toString()).evaluate());
        }
        if (null != 償還払ViewStateDB情報) {
            List<ShokanKihon> 償還払請求基本データList = new ArrayList<>();
            List<ShokanServicePlan200904Result> 償還払請求サービス計画200904データList = new ArrayList<>();
            List<ShokanServicePlan200604Result> 償還払請求サービス計画200604データList = new ArrayList<>();
            List<ShokanServicePlan200004Result> 償還払請求サービス計画200004データList = new ArrayList<>();
            if (null != 償還払ViewStateDB情報.get償還払請求基本データList() && !償還払ViewStateDB情報.get償還払請求基本データList().isEmpty()) {
                償還払請求基本データList = 償還払ViewStateDB情報.get償還払請求基本データList();
            }
            if (null != 償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList()
                    && !償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList().isEmpty()) {
                償還払請求サービス計画200904データList = 償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList();
            }
            if (null != 償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList()
                    && !償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList().isEmpty()) {
                償還払請求サービス計画200604データList = 償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList();
            }
            if (null != 償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList()
                    && !償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList().isEmpty()) {
                償還払請求サービス計画200004データList = 償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList();
            }
            int 証明書件数ViewState = SyokanbaraihiShikyuShinseiKetteFath.createInstance().getShomeishoKensu(
                    被保険者番号,
                    サービス年月,
                    整理番号,
                    事業者番号,
                    様式番号,
                    チェック区分,
                    償還払請求基本データList,
                    償還払請求サービス計画200904データList,
                    償還払請求サービス計画200604データList,
                    償還払請求サービス計画200004データList);
            if (証明書件数ViewState > 0) {
                throw new ApplicationException(UrErrorMessages.既に登録済
                        .getMessage().replace(証明書.toString()).evaluate());
            }
        }
        return true;
    }

    /**
     * 削除済チェックです
     *
     * @return 削除済チェック
     */
    public Boolean 削除済チェック() {
        return 処理_削除.equals(div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow().getShori());
    }

    /**
     * 償還払ViewStateDB情報に明細情報を削除する
     *
     * @param 償還払ViewStateDB情報 DbJohoViewState
     * @param removeKey ShoukanharaihishinseimeisaikensakuParameter
     * @return DbJohoViewState
     */
    public DbJohoViewState 明細削除_償還払情報クリア(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get証明書グリッドリスト() && !償還払ViewStateDB情報.get証明書グリッドリスト().isEmpty()) {
            ShomeishoGridList 証明書グリッドremove = new ShomeishoGridList();
            for (ShomeishoGridList 証明書グリッド : 償還払ViewStateDB情報.get証明書グリッドリスト()) {
                if (証明書グリッド.get事業者番号().equals(removeKey.get事業者番号().value())
                        && 証明書グリッド.get明細().equals(removeKey.get明細番号())
                        && 証明書グリッド.getサービス提供証明書().equals(removeKey.get様式番号())) {
                    証明書グリッドremove = 証明書グリッド;
                }
            }
            償還払ViewStateDB情報.get証明書グリッドリスト().remove(証明書グリッドremove);
        }

        if (null != 償還払ViewStateDB情報.get償還払請求基本データList() && !償還払ViewStateDB情報.get償還払請求基本データList().isEmpty()) {
            ArrayList<ShokanKihon> 償還払請求基本データremove = new ArrayList<>();
            for (ShokanKihon 償還払請求基本データ : 償還払ViewStateDB情報.get償還払請求基本データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求基本データ.get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求基本データ.getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求基本データ.get居宅サービス計画事業者番号())
                        && removeKey.get整理番号().equals(償還払請求基本データ.get整理番号())
                        && removeKey.get明細番号().equals(償還払請求基本データ.get明細番号())
                        && removeKey.get様式番号().equals(償還払請求基本データ.get様式番号())) {
                    償還払請求基本データremove.add(償還払請求基本データ);
                }
            }
            for (ShokanKihon 償還払請求基本データ : 償還払請求基本データremove) {
                償還払ViewStateDB情報.get償還払請求基本データList().remove(償還払請求基本データ);
            }
        }
        償還払ViewStateDB情報 = remove住所地特例データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求明細データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求特定診療費データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove特別療養費データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = removeサービス計画明細200904(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = removeサービス計画明細200604(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = removeサービス計画明細200004(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求特定入所者介護サービス費用データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求社会福祉法人軽減額データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求所定疾患施設療養費等データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求緊急時施設療養データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求集計データ(償還払ViewStateDB情報, removeKey);
        償還払ViewStateDB情報 = remove償還払請求食事費用データ(償還払ViewStateDB情報, removeKey);
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove住所地特例データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get住所地特例データList() && !償還払ViewStateDB情報.get住所地特例データList().isEmpty()) {
            ArrayList<ShokanMeisaiJushochiTokureiResult> 住所地特例データremove = new ArrayList<>();
            for (ShokanMeisaiJushochiTokureiResult 住所地特例データ : 償還払ViewStateDB情報.get住所地特例データList()) {
                if (removeKey.get被保険者番号().equals(住所地特例データ.getEntity().get被保険者番号())
                        && removeKey.getサービス年月().equals(住所地特例データ.getEntity().getサービス提供年月())
                        && removeKey.get事業者番号().equals(住所地特例データ.getEntity().get事業者番号())
                        && removeKey.get整理番号().equals(住所地特例データ.getEntity().get整理番号())
                        && removeKey.get明細番号().equals(住所地特例データ.getEntity().get明細番号())
                        && removeKey.get様式番号().equals(住所地特例データ.getEntity().get様式番号())) {
                    住所地特例データremove.add(住所地特例データ);
                }
            }
            for (ShokanMeisaiJushochiTokureiResult 住所地特例データ : 住所地特例データremove) {
                償還払ViewStateDB情報.get住所地特例データList().remove(住所地特例データ);
            }
        }

        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求明細データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求明細データList() && !償還払ViewStateDB情報.get償還払請求明細データList().isEmpty()) {
            ArrayList<ShokanMeisaiResult> 償還払請求明細データremove = new ArrayList<>();
            for (ShokanMeisaiResult 償還払請求明細データ : 償還払ViewStateDB情報.get償還払請求明細データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求明細データ.getEntity().get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求明細データ.getEntity().getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求明細データ.getEntity().get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求明細データ.getEntity().get整理番号())
                        && removeKey.get明細番号().equals(償還払請求明細データ.getEntity().get明細番号())
                        && removeKey.get様式番号().equals(償還払請求明細データ.getEntity().get様式番号())) {
                    償還払請求明細データremove.add(償還払請求明細データ);
                }
            }
            for (ShokanMeisaiResult 償還払請求明細データ : 償還払請求明細データremove) {
                償還払ViewStateDB情報.get償還払請求明細データList().remove(償還払請求明細データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求特定診療費データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求特定診療費データList() && !償還払ViewStateDB情報.get償還払請求特定診療費データList().isEmpty()) {
            ArrayList<ShokanTokuteiShinryohi> 償還払請求特定診療費データremove = new ArrayList<>();
            for (ShokanTokuteiShinryohi 償還払請求特定診療費データ : 償還払ViewStateDB情報.get償還払請求特定診療費データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求特定診療費データ.get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求特定診療費データ.getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求特定診療費データ.get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求特定診療費データ.get整理番号())
                        && removeKey.get明細番号().equals(償還払請求特定診療費データ.get明細番号())
                        && removeKey.get様式番号().equals(償還払請求特定診療費データ.get様式番号())) {
                    償還払請求特定診療費データremove.add(償還払請求特定診療費データ);
                }
            }
            for (ShokanTokuteiShinryohi 償還払請求特定診療費データ : 償還払請求特定診療費データremove) {
                償還払ViewStateDB情報.get償還払請求特定診療費データList().remove(償還払請求特定診療費データ);
            }
        }

        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove特別療養費データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get特別療養費データList() && !償還払ViewStateDB情報.get特別療養費データList().isEmpty()) {
            ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データremove = new ArrayList<>();
            for (ShokanTokuteiShinryoTokubetsuRyoyo 特別療養費データ : 償還払ViewStateDB情報.get特別療養費データList()) {
                if (removeKey.get被保険者番号().equals(特別療養費データ.get被保険者番号())
                        && removeKey.getサービス年月().equals(特別療養費データ.getサービス提供年月())
                        && removeKey.get事業者番号().equals(特別療養費データ.get事業者番号())
                        && removeKey.get整理番号().equals(特別療養費データ.get整理番号())
                        && removeKey.get明細番号().equals(特別療養費データ.get明細番号())
                        && removeKey.get様式番号().equals(特別療養費データ.get様式番号())) {
                    特別療養費データremove.add(特別療養費データ);
                }
            }
            for (ShokanTokuteiShinryoTokubetsuRyoyo 特別療養費データ : 特別療養費データremove) {
                償還払ViewStateDB情報.get特別療養費データList().remove(特別療養費データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState removeサービス計画明細200904(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList() && !償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList().isEmpty()) {
            ArrayList<ShokanServicePlan200904Result> 償還払請求サービス計画200904データremove = new ArrayList<>();
            for (ShokanServicePlan200904Result 償還払請求サービス計画200904データ : 償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList()) {
                if (removeKey.get被保険者番号().equals(償還払請求サービス計画200904データ.getEntity().get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求サービス計画200904データ.getEntity().getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求サービス計画200904データ.getEntity().get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求サービス計画200904データ.getEntity().get整理番号())
                        && removeKey.get明細番号().equals(償還払請求サービス計画200904データ.getEntity().get明細番号())
                        && removeKey.get様式番号().equals(償還払請求サービス計画200904データ.getEntity().get様式番号())) {
                    償還払請求サービス計画200904データremove.add(償還払請求サービス計画200904データ);
                }
            }
            for (ShokanServicePlan200904Result 償還払請求サービス計画200904データ : 償還払請求サービス計画200904データremove) {
                償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList().remove(償還払請求サービス計画200904データ);
            }
        }

        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState removeサービス計画明細200604(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList() && !償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList().isEmpty()) {
            ArrayList<ShokanServicePlan200604Result> 償還払請求サービス計画200604データremove = new ArrayList<>();
            for (ShokanServicePlan200604Result 償還払請求サービス計画200604データ : 償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList()) {
                if (removeKey.get被保険者番号().equals(償還払請求サービス計画200604データ.getEntity().get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求サービス計画200604データ.getEntity().getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求サービス計画200604データ.getEntity().get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求サービス計画200604データ.getEntity().get整理番号())
                        && removeKey.get明細番号().equals(償還払請求サービス計画200604データ.getEntity().get明細番号())
                        && removeKey.get様式番号().equals(償還払請求サービス計画200604データ.getEntity().get様式番号())) {
                    償還払請求サービス計画200604データremove.add(償還払請求サービス計画200604データ);
                }
            }
            for (ShokanServicePlan200604Result 償還払請求サービス計画200604データ : 償還払請求サービス計画200604データremove) {
                償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList().remove(償還払請求サービス計画200604データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState removeサービス計画明細200004(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList() && !償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList().isEmpty()) {
            ArrayList<ShokanServicePlan200004Result> 償還払請求サービス計画200004データremove = new ArrayList<>();
            for (ShokanServicePlan200004Result 償還払請求サービス計画200004データ : 償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList()) {
                if (removeKey.get被保険者番号().equals(償還払請求サービス計画200004データ.getEntity().get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求サービス計画200004データ.getEntity().getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求サービス計画200004データ.getEntity().get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求サービス計画200004データ.getEntity().get整理番号())
                        && removeKey.get明細番号().equals(償還払請求サービス計画200004データ.getEntity().get明細番号())
                        && removeKey.get様式番号().equals(償還払請求サービス計画200004データ.getEntity().get様式番号())) {
                    償還払請求サービス計画200004データremove.add(償還払請求サービス計画200004データ);
                }
            }
            for (ShokanServicePlan200004Result 償還払請求サービス計画200004データ : 償還払請求サービス計画200004データremove) {
                償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList().remove(償還払請求サービス計画200004データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求特定入所者介護サービス費用データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求特定入所者介護サービス費用データList() && !償還払ViewStateDB情報.get償還払請求特定入所者介護サービス費用データList().isEmpty()) {
            ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データremove = new ArrayList<>();
            for (ShokanTokuteiNyushoshaKaigoServiceHiyo 償還払請求特定入所者介護サービス費用データ : 償還払ViewStateDB情報.get償還払請求特定入所者介護サービス費用データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求特定入所者介護サービス費用データ.get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求特定入所者介護サービス費用データ.getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求特定入所者介護サービス費用データ.get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求特定入所者介護サービス費用データ.get整理番号())
                        && removeKey.get明細番号().equals(償還払請求特定入所者介護サービス費用データ.get明細番号())
                        && removeKey.get様式番号().equals(償還払請求特定入所者介護サービス費用データ.get様式番号())) {
                    償還払請求特定入所者介護サービス費用データremove.add(償還払請求特定入所者介護サービス費用データ);
                }
            }
            for (ShokanTokuteiNyushoshaKaigoServiceHiyo 償還払請求特定入所者介護サービス費用データ : 償還払請求特定入所者介護サービス費用データremove) {
                償還払ViewStateDB情報.get償還払請求特定入所者介護サービス費用データList().remove(償還払請求特定入所者介護サービス費用データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求社会福祉法人軽減額データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求社会福祉法人軽減額データList() && !償還払ViewStateDB情報.get償還払請求社会福祉法人軽減額データList().isEmpty()) {
            ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> 償還払請求社会福祉法人軽減額データremove = new ArrayList<>();
            for (ShokanShakaiFukushiHojinKeigengakuResult 償還払請求社会福祉法人軽減額データ : 償還払ViewStateDB情報.get償還払請求社会福祉法人軽減額データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求社会福祉法人軽減額データ.getShokanShakai().get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求社会福祉法人軽減額データ.getShokanShakai().getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求社会福祉法人軽減額データ.getShokanShakai().get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求社会福祉法人軽減額データ.getShokanShakai().get整理番号())
                        && removeKey.get明細番号().equals(償還払請求社会福祉法人軽減額データ.getShokanShakai().get明細番号())
                        && removeKey.get様式番号().equals(償還払請求社会福祉法人軽減額データ.getShokanShakai().get様式番号())) {
                    償還払請求社会福祉法人軽減額データremove.add(償還払請求社会福祉法人軽減額データ);
                }
            }
            for (ShokanShakaiFukushiHojinKeigengakuResult 償還払請求社会福祉法人軽減額データ : 償還払請求社会福祉法人軽減額データremove) {
                償還払ViewStateDB情報.get償還払請求社会福祉法人軽減額データList().remove(償還払請求社会福祉法人軽減額データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求所定疾患施設療養費等データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求所定疾患施設療養費等データList() && !償還払ViewStateDB情報.get償還払請求所定疾患施設療養費等データList().isEmpty()) {
            ArrayList<ShokanShoteiShikkanShisetsuRyoyo> 償還払請求所定疾患施設療養費等データremove = new ArrayList<>();
            for (ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等データ : 償還払ViewStateDB情報.get償還払請求所定疾患施設療養費等データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求所定疾患施設療養費等データ.get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求所定疾患施設療養費等データ.getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求所定疾患施設療養費等データ.get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求所定疾患施設療養費等データ.get整理番号())
                        && removeKey.get明細番号().equals(償還払請求所定疾患施設療養費等データ.get明細番号())
                        && removeKey.get様式番号().equals(償還払請求所定疾患施設療養費等データ.get様式番号())) {
                    償還払請求所定疾患施設療養費等データremove.add(償還払請求所定疾患施設療養費等データ);
                }
            }
            for (ShokanShoteiShikkanShisetsuRyoyo 償還払請求所定疾患施設療養費等データ : 償還払請求所定疾患施設療養費等データremove) {
                償還払ViewStateDB情報.get償還払請求所定疾患施設療養費等データList().remove(償還払請求所定疾患施設療養費等データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求緊急時施設療養データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求緊急時施設療養データList() && !償還払ViewStateDB情報.get償還払請求緊急時施設療養データList().isEmpty()) {
            ArrayList<ShokanKinkyuShisetsuRyoyo> 償還払請求緊急時施設療養データremove = new ArrayList<>();
            for (ShokanKinkyuShisetsuRyoyo 償還払請求緊急時施設療養データ : 償還払ViewStateDB情報.get償還払請求緊急時施設療養データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求緊急時施設療養データ.get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求緊急時施設療養データ.getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求緊急時施設療養データ.get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求緊急時施設療養データ.get整理番号())
                        && removeKey.get明細番号().equals(償還払請求緊急時施設療養データ.get明細番号())
                        && removeKey.get様式番号().equals(償還払請求緊急時施設療養データ.get様式番号())) {
                    償還払請求緊急時施設療養データremove.add(償還払請求緊急時施設療養データ);
                }
            }
            for (ShokanKinkyuShisetsuRyoyo 償還払請求緊急時施設療養データ : 償還払請求緊急時施設療養データremove) {
                償還払ViewStateDB情報.get償還払請求緊急時施設療養データList().remove(償還払請求緊急時施設療養データ);
            }
        }

        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求集計データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求集計データList() && !償還払ViewStateDB情報.get償還払請求集計データList().isEmpty()) {
            ArrayList<ShokanShukeiResult> 償還払請求集計データremove = new ArrayList<>();
            for (ShokanShukeiResult 償還払請求集計データ : 償還払ViewStateDB情報.get償還払請求集計データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求集計データ.getShukei().get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求集計データ.getShukei().getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求集計データ.getShukei().get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求集計データ.getShukei().get整理番号())
                        && removeKey.get明細番号().equals(償還払請求集計データ.getShukei().get明細番号())
                        && removeKey.get様式番号().equals(償還払請求集計データ.getShukei().get様式番号())) {
                    償還払請求集計データremove.add(償還払請求集計データ);
                }
            }
            for (ShokanShukeiResult 償還払請求集計データ : 償還払請求集計データremove) {
                償還払ViewStateDB情報.get償還払請求集計データList().remove(償還払請求集計データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState remove償還払請求食事費用データ(DbJohoViewState 償還払ViewStateDB情報, ShoukanharaihishinseimeisaikensakuParameter removeKey) {
        if (null != 償還払ViewStateDB情報.get償還払請求食事費用データList() && !償還払ViewStateDB情報.get償還払請求食事費用データList().isEmpty()) {
            ArrayList<ShokanShokujiHiyo> 償還払請求食事費用データremove = new ArrayList<>();
            for (ShokanShokujiHiyo 償還払請求食事費用データ : 償還払ViewStateDB情報.get償還払請求食事費用データList()) {
                if (removeKey.get被保険者番号().equals(償還払請求食事費用データ.get被保険者番号())
                        && removeKey.getサービス年月().equals(償還払請求食事費用データ.getサービス提供年月())
                        && removeKey.get事業者番号().equals(償還払請求食事費用データ.get事業者番号())
                        && removeKey.get整理番号().equals(償還払請求食事費用データ.get整理番号())
                        && removeKey.get明細番号().equals(償還払請求食事費用データ.get明細番号())
                        && removeKey.get様式番号().equals(償還払請求食事費用データ.get様式番号())) {
                    償還払請求食事費用データremove.add(償還払請求食事費用データ);
                }
            }
            for (ShokanShokujiHiyo 償還払請求食事費用データ : 償還払請求食事費用データremove) {
                償還払ViewStateDB情報.get償還払請求食事費用データList().remove(償還払請求食事費用データ);
            }
        }
        return 償還払ViewStateDB情報;
    }

    private void set申請共通エリア(RString 処理モード, FlexibleYearMonth サービス年月, RString 整理番号) {
        if (サービス年月 != null) {
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        }
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
        div.getPanelTwo().getTxtShoriMode().setValue(処理モード);
    }

    private void set申請明細エリア表示制御(RString 処理モード) {
        if (登録モード.equals(処理モード)) {
            div.getPanelShinseiNaiyo().getTxtShinseibi().setDisabled(true);
        } else if (削除モード.equals(処理モード)) {
            div.getPanelShinseiNaiyo().getDdlShomeisho().setDisabled(true);
            div.getPanelShinseiNaiyo().getCcdShisetsuJoho().setDisabled(true);
            div.getPanelShinseiNaiyo().getBtnAdd().setDisabled(true);
            div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().setDisabled(true);
        }
    }
}
