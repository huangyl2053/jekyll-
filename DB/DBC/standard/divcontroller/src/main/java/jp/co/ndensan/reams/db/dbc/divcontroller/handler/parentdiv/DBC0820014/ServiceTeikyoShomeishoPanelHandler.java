/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.ServiceTeikyoShomeishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.dgdServiceTeikyoShomeisyo_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
    private static final RString 受託なし = new RString("1");
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
    private static final int 定数_十 = 10;

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
     * @param 国保連送付フラグ 国保連送付フラグ
     */
    public void loadボタンエリア(Boolean 国保連送付フラグ) {
        RString config = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託なし.equals(config)) {
            div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(false);
        } else if (受託あり.equals(config) && 国保連送付フラグ) {
            div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(true);
            div.getPanelShinseiNaiyo().setDisabled(true);
            div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getGridSetting().setIsShowModifyButtonColumn(false);
        } else {
            div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(true);
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
            set申請共通エリア(画面モード_新規, null, null);
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
     */
    public void load申請明細エリア(RString 処理モード,
            RDate 申請日,
            List<ShikibetsuNoKanri> 証明書リスト,
            List<ServiceTeikyoShomeishoResult> 証明書一覧情報) {
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
        for (ServiceTeikyoShomeishoResult 証明書情報 : 証明書一覧情報) {
            dgdServiceTeikyoShomeisyo_Row row = new dgdServiceTeikyoShomeisyo_Row();
            JigyoshaNo jigyoshaNo = 証明書情報.getServiceTeikyoShomeisho().getJigyoshaNo();
            if (jigyoshaNo != null) {
                row.setData1(jigyoshaNo.getColumnValue());
            }
            AtenaMeisho jigyoshaName = 証明書情報.getServiceTeikyoShomeisho().getJigyoshaName();
            if (jigyoshaName != null) {
                row.setData2(jigyoshaName.getColumnValue());
            }
            row.setData3(証明書情報.getServiceTeikyoShomeisho().getMeisanNo());
            row.setData4(証明書情報.getServiceTeikyoShomeisho().getYoshikiNo());
            rowDataList.add(row);
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
     * 「追加する」ボタンを押下する、事業者番号入力有無と桁数チェックです。
     */
    public void 事業者番号チェック() {
        RString 事業者番号_入力 = div.getPanelShinseiNaiyo().getCcdShisetsuJoho().getNyuryokuShisetsuKodo();
        if (事業者番号_入力 == null || 事業者番号_入力.isEmpty()) {
            // TODO DBCErrorMessage.事業者番号未入力がありません。
            throw new ApplicationException(DbcErrorMessages.対象年月入力不正
                    .getMessage().replace(証明書.toString()).evaluate());
        }
        if (定数_十 < 事業者番号_入力.length()) {
            // TODO DBCErrorMessage.事業者番号未入力がありません。
            throw new ApplicationException(DbcErrorMessages.対象年月入力不正
                    .getMessage().replace(証明書.toString()).evaluate());
        }
    }

    /**
     * 「追加する」ボタンを押下する、チェックです。
     *
     * @param 整理番号 RString
     * @param サービス年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @return サービス提供証明書の存在チェック
     */
    public Boolean サービス提供証明書の存在チェック(RString 整理番号, FlexibleYearMonth サービス年月, HihokenshaNo 被保険者番号) {
        JigyoshaNo 事業者番号 = new JigyoshaNo(div.getPanelShinseiNaiyo().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        RString 様式番号 = div.getPanelShinseiNaiyo().getDdlShomeisho().getSelectedKey();
        int 証明書件数 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShikibetsuNoKanri(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号);
        if (証明書件数 > 0) {
            throw new ApplicationException(UrErrorMessages.既に登録済
                    .getMessage().replace(証明書.toString()).evaluate());
        }
        return true;
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
