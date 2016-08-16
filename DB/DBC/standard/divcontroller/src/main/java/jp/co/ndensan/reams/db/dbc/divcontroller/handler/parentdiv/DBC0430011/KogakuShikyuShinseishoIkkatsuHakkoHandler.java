/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0430011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020020.DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shunyugaku.ShutsuryokuJoken;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbc.service.core.kogakushikyushinseishoikkatsu.KogakuShikyuShinseishoIkkatsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 高額サービス費給付お知らせ通知書作成です。
 *
 * @reamsid_L DBC-4770-010 zhengshenlei
 */
public class KogakuShikyuShinseishoIkkatsuHakkoHandler {

    private final KogakuShikyuShinseishoIkkatsuHakkoDiv div;
    private static final RString メニューID_DBCMN43001 = new RString("DBCMN43001");
    private static final RString メニューID_DBCMNL3001 = new RString("DBCMNL3001");
    private static final RString NUM_1 = new RString("1");
    private static final RString NUM_2 = new RString("2");
    private static final RString 審査年月 = new RString("審査年月");
    private static final RString 受取年月 = new RString("受取年月");
    private static final RString 高額介護サービス費支給申請書を発行する
            = new RString("高額介護サービス費支給申請書を発行する");
    private static final RString 高額介護サービス費給付お知らせ通知を発行する
            = new RString("高額介護サービス費給付お知らせ通知を発行する");
    private static final RString 事業高額介護サービス費支給申請書を発行する
            = new RString("事業高額介護サービス費支給申請書を発行する");
    private static final RString 事業高額介護サービス費給付お知らせ通知を発行する
            = new RString("事業高額介護サービス費給付お知らせ通知を発行する");
    private static final RString SHINSEIKEY = new RString("shinseishoHakko");
    private static final RString OSHIRASEKEY = new RString("oshiraseTsuchiHakko");
    private static final RString 交換情報識別番号_201 = new RString("201");
    private static final RString 交換情報識別番号_202 = new RString("202");
    private static final RString 交換情報識別番号_331 = new RString("331");
    private static final RString 交換情報識別番号_335 = new RString("335");
    private static final int DAY_9 = 9;
    private static final RString HYOJI = new RString("hyoji");
    private static final RString HIHYOJI = new RString("hihyoji");
    RDate NOWDATE = RDate.getNowDate();

    /**
     * コンストラクタです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoHanlder
     */
    public KogakuShikyuShinseishoIkkatsuHakkoHandler(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化イベントメソッドです。
     *
     * @param menuID RString
     */
    public void initialize(RString menuID) {
        KokuhorenInterfaceKanriManager manager = new KokuhorenInterfaceKanriManager();
        RString 交換情報識別番号 = RString.EMPTY;
        if (メニューID_DBCMN43001.equals(menuID)) {
            RString 区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, NOWDATE,
                    SubGyomuCode.DBC介護給付);
            List<KeyValueDataSource> radShinsaYM = new ArrayList<>();
            if (NUM_1.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(審査年月, 審査年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
                div.getShinseishoHakkoParameters().getRadShinsaYM().setSelectedKey(審査年月);
                交換情報識別番号 = 交換情報識別番号_201;
            } else if (NUM_2.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(受取年月, 受取年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
                div.getShinseishoHakkoParameters().getRadShinsaYM().setSelectedKey(受取年月);
                交換情報識別番号 = 交換情報識別番号_331;
            }
            List<KeyValueDataSource> datasource = new ArrayList<>();
            datasource.add(new KeyValueDataSource(SHINSEIKEY, 高額介護サービス費支給申請書を発行する));
            datasource.add(new KeyValueDataSource(OSHIRASEKEY, 高額介護サービス費給付お知らせ通知を発行する));
            div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().setSelectedItems(datasource);
            div.getShutsuryokuTaisho().getCcdBunshoNo().initialize(ReportIdDBC.DBC100011.getReportId());
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            RString 区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額, NOWDATE,
                    SubGyomuCode.DBC介護給付);
            List<KeyValueDataSource> radShinsaYM = new ArrayList<>();
            if (NUM_1.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(審査年月, 審査年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
                div.getShinseishoHakkoParameters().getRadShinsaYM().setSelectedKey(審査年月);
                交換情報識別番号 = 交換情報識別番号_202;
            } else if (NUM_2.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(受取年月, 受取年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
                div.getShinseishoHakkoParameters().getRadShinsaYM().setSelectedKey(受取年月);
                交換情報識別番号 = 交換情報識別番号_335;
            }
            List<KeyValueDataSource> datasource = new ArrayList<>();
            datasource.add(new KeyValueDataSource(SHINSEIKEY, 事業高額介護サービス費支給申請書を発行する));
            datasource.add(new KeyValueDataSource(OSHIRASEKEY, 事業高額介護サービス費給付お知らせ通知を発行する));
            div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().setSelectedItems(datasource);
            div.getShutsuryokuTaisho().getCcdBunshoNo().initialize(ReportIdDBC.DBC100072.getReportId());
        }

        KokuhorenInterfaceKanri result = manager.get国保連インターフェース管理(交換情報識別番号);
        if (result != null) {
            FlexibleYearMonth 処理年月 = result.get処理年月();
            if (処理年月 != null) {
                div.getShinseishoHakkoParameters().getTxtShinsaYM().setValue(new FlexibleDate(処理年月.toString()));
            }
        }

        RString 初回申請日 = DbBusinessConfig.get(ConfigNameDBC.高額自動償還_初回申請把握基準日,
                NOWDATE, SubGyomuCode.DBC介護給付);
        div.getShinseishoHakkoParameters().getTxtShokaiShinseiHakuKijunDate().setValue(new FlexibleDate(初回申請日));
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        div.getShutsuryokuTaisho().getTxtSakuseiDate().setValue(nowDate);
        div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().setValue(nowDate.plusDay(DAY_9));
        div.getJidoShokanTaishoJohoSettei().getTxtShinseiDate().setValue(nowDate);
        div.getJidoShokanTaishoJohoSettei().getTxtUketsukeDate().setValue(nowDate);
        div.getJidoShokanTaishoJohoSettei().getTxtKetteiDate().setValue(nowDate);

        div.getCcdShuturyokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200091.getReportId());
        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setReadOnly(true);
    }

    /**
     * 3．被保険者番号を選択した際の、サービス年月DDLの値設定のメソッドです。
     *
     * @param menuID RString
     */
    public void setサービス年月DDL(RString menuID) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                NOWDATE, SubGyomuCode.DBU介護統計報告));
        List<KeyValueDataSource> datasource = new ArrayList<>();
        if (メニューID_DBCMN43001.equals(menuID)) {
            List<KogakuShikyuShinsei> serviceTeikyoYMList
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getServiceTeikyoByDbT3056(被保険者番号, 証記載保険者番号);
            if (serviceTeikyoYMList.isEmpty()) {
                throw new ApplicationException(DbcErrorMessages.被保険者の高額介護サービス支給申請情報が無い.getMessage());
            }
            for (KogakuShikyuShinsei kogakuShikyuShinsei : serviceTeikyoYMList) {
                FlexibleYearMonth サービス提供年月 = kogakuShikyuShinsei.getサービス提供年月();
                datasource.add(new KeyValueDataSource(サービス提供年月.toDateString(), サービス提供年月.wareki().toDateString()));
            }
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            List<JigyoKogakuShikyuShinsei> serviceTeikyoYMList
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getServiceTeikyoByDbT3110(被保険者番号, 証記載保険者番号);
            if (serviceTeikyoYMList.isEmpty()) {
                throw new ApplicationException(DbcErrorMessages.被保険者の高額介護サービス支給申請情報が無い.getMessage());
            }
            for (JigyoKogakuShikyuShinsei jigyoKogakuShikyuShinsei : serviceTeikyoYMList) {
                FlexibleYearMonth サービス提供年月 = jigyoKogakuShikyuShinsei.getサービス提供年月();
                datasource.add(new KeyValueDataSource(サービス提供年月.toDateString(), サービス提供年月.wareki().toDateString()));
            }
        }
        div.getShinseishoHakkoParameters().getDdlServiceYM().setDataSource(datasource);
    }

    /**
     * 4.　バッチパラメータ作成
     *
     * @param menuID RString
     * @return DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter
     */
    public DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter createBatchParameter(RString menuID) {
        DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter
                = new DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter();
        FlexibleYearMonth 処理年月 = FlexibleYearMonth.EMPTY;
        if (!div.getShinseishoHakkoParameters().getRadShinsaYM().getSelectedKey().isEmpty()) {
            処理年月 = new FlexibleYearMonth(div.getShinseishoHakkoParameters().getTxtShinsaYM().getValue().toString());
            parameter.setChushutsuJoken(ShutsuryokuJoken.審査年月);
        } else if (!div.getShinseishoHakkoParameters().getRadHihokenshaNo().getSelectedKey().isEmpty()) {
            処理年月 = new FlexibleYearMonth(div.getShinseishoHakkoParameters().getDdlServiceYM().getLabelRText());
            parameter.setChushutsuJoken(ShutsuryokuJoken.被保険者番号);
        } else if (!div.getShinseishoHakkoParameters().getRadHakushiInsatsu().getSelectedKey().isEmpty()) {
            処理年月 = FlexibleYearMonth.EMPTY;
            parameter.setChushutsuJoken(ShutsuryokuJoken.白紙);
        }
        parameter.setShoriYm(処理年月);

        parameter.setSakuseibi(div.getShutsuryokuTaisho().getTxtSakuseiDate().getValue());
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        if (!div.getShinseishoHakkoParameters().getRadHihokenshaNo().getSelectedKey().isEmpty()) {
            被保険者番号 = new HihokenshaNo(div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue().toString());
        }
        parameter.setHihokenshaNo(被保険者番号);

        List<KeyValueDataSource> alist = div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().getSelectedItems();
        List<RString> rsList = new ArrayList<>();
        for (KeyValueDataSource datesorcelist : alist) {
            rsList.add(datesorcelist.getKey());
        }
        if (rsList.contains(SHINSEIKEY)) {
            parameter.setShinseishoHakko(true);
        } else {
            parameter.setShinseishoHakko(false);
        }
        if (rsList.contains(OSHIRASEKEY)) {
            parameter.setOshiraseTsuchishoHakko(true);
        } else {
            parameter.setOshiraseTsuchishoHakko(false);
        }

        if (div.getShutsuryokuTaisho().getChkHakkoIchiranhyoHakko().isAllSelected()) {
            parameter.setHakkoIchiranhyoHakko(true);
        } else {
            parameter.setHakkoIchiranhyoHakko(false);
        }

        if (HYOJI.equals(div.getShutsuryokuTaisho().getRadKinyoKikanmeiHyoji().getSelectedKey())) {
            parameter.setKinyuKikanHyoji(true);
        } else if (HIHYOJI.equals(div.getShutsuryokuTaisho().getRadKinyoKikanmeiHyoji().getSelectedKey())) {
            parameter.setKinyuKikanHyoji(false);
        }

        if (!(div.getCcdShuturyokujun().get出力順ID() == null)) {
            parameter.setShutsuryokujunId(div.getCcdShuturyokujun().get出力順ID());
        }
        parameter.setShiseibi(div.getJidoShokanTaishoJohoSettei().getTxtShinseiDate().getValue());
        parameter.setUketsukebi(div.getJidoShokanTaishoJohoSettei().getTxtUketsukeDate().getValue());
        parameter.setKeteibi(div.getJidoShokanTaishoJohoSettei().getTxtKetteiDate().getValue());
        if (!div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().getValue().isEmpty()) {
            parameter.setShinseishoTeishutsuKigen(div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().getValue());
        }
        parameter.setMenuId(menuID);

        RString 文書番号 = div.getShutsuryokuTaisho().getCcdBunshoNo().get文書番号();
        if (文書番号.equals(RString.EMPTY)) {
            parameter.setBunshoMojiretsu(RString.EMPTY);
        } else {
            parameter.setBunshoMojiretsu(文書番号);
        }
        set受託あり(parameter, menuID);
        return parameter;
    }

    private void set受託あり(DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter,
            RString menuID) {
        RString 高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                NOWDATE, SubGyomuCode.DBC介護給付);
        RString 事業高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額,
                NOWDATE, SubGyomuCode.DBC介護給付);
        if (メニューID_DBCMN43001.equals(menuID)) {
            if (NUM_1.equals(高額)) {
                parameter.setJutakuAri(false);
            } else if (NUM_2.equals(高額)) {
                parameter.setJutakuAri(true);
            }
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            if (NUM_1.equals(事業高額)) {
                parameter.setJutakuAri(false);
            } else if (NUM_2.equals(事業高額)) {
                parameter.setJutakuAri(true);
            }
        }
    }
}
