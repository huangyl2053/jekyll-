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
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020020.DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukyufu.KogakuKyufu_OshiraseTsuchi_ChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbc.service.core.kogakushikyushinseishoikkatsu.KogakuShikyuShinseishoIkkatsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
    private static final RString HYOJI = new RString("hyoji");
    private static final RString HIHYOJI = new RString("hihyoji");
    private static final RString 帳票分類ID_DBC100068 = new RString("DBC100068_KogakuShikyuShinseisho");
    private static final RString 帳票分類ID_DBC100070 = new RString("DBC100070_KogakuJigyoShikyuShinseisho");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名_提出期限初期 = new RString("提出期限初期");
    private static final RString 項目名_電話番号表示 = new RString("電話番号表示");
    private static final RString 項目名_委任状提出先 = new RString("委任状提出先");
    private static final int BEGININDEX = 0;
    private static final int ENDINDEX = 6;

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
        RDate nowdate = RDate.getNowDate();
        KokuhorenInterfaceKanriManager manager = new KokuhorenInterfaceKanriManager();
        RString 交換情報識別番号 = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御汎用キー = null;
        if (メニューID_DBCMN43001.equals(menuID)) {
            RString 区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, nowdate,
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
            div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().setDataSource(datasource);
            div.getShutsuryokuTaisho().getCcdBunshoNo().initialize(ReportIdDBC.DBC100011.getReportId());
            div.getCcdShuturyokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100011.getReportId());
            帳票制御汎用キー
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getChohyoHanyoKey(
                            SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID_DBC100068), 管理年度, 項目名_提出期限初期);
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            RString 区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額, nowdate,
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
            div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().setDataSource(datasource);
            div.getShutsuryokuTaisho().getCcdBunshoNo().initialize(ReportIdDBC.DBC100072.getReportId());
            div.getCcdShuturyokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200091.getReportId());
            帳票制御汎用キー
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getChohyoHanyoKey(
                            SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID_DBC100070), 管理年度, 項目名_提出期限初期);
        }

        KokuhorenInterfaceKanri result = manager.get国保連インターフェース管理(交換情報識別番号);
        if (result != null) {
            FlexibleYearMonth 処理年月 = result.get処理年月();
            if (処理年月 != null) {
                div.getShinseishoHakkoParameters().getTxtShinsaYM().setValue(new FlexibleDate(処理年月.toString()));
            }
        }

        RString 初回申請基準日 = DbBusinessConfig.get(ConfigNameDBC.高額自動償還_初回申請把握基準日,
                nowdate, SubGyomuCode.DBC介護給付);
        div.getShinseishoHakkoParameters().getTxtShokaiShinseiHakuKijunDate().setValue(new FlexibleDate(初回申請基準日));
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        div.getShutsuryokuTaisho().getTxtSakuseiDate().setValue(nowDate);

        if (帳票制御汎用キー != null) {
            int 提出期限初期の値 = Integer.parseInt(帳票制御汎用キー.get設定値().toString());
            div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().setValue(nowDate.plusDay(提出期限初期の値));
        }

        div.getJidoShokanTaishoJohoSettei().getTxtShinseiDate().setValue(nowDate);
        div.getJidoShokanTaishoJohoSettei().getTxtUketsukeDate().setValue(nowDate);
        div.getJidoShokanTaishoJohoSettei().getTxtKetteiDate().setValue(nowDate);

        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setDisabled(true);
    }

    /**
     * 被保険者番号を選択した際の、サービス年月DDLの値設定のメソッドです。
     *
     * @param menuID RString
     */
    public void setサービス年月DDL(RString menuID) {
        RDate nowdate = RDate.getNowDate();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                nowdate, SubGyomuCode.DBU介護統計報告));
        List<KeyValueDataSource> datasource = new ArrayList<>();
        if (メニューID_DBCMN43001.equals(menuID)) {
            List<KogakuShikyuShinsei> serviceTeikyoYMList
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getServiceTeikyoByDbT3056(被保険者番号, 証記載保険者番号);
            for (KogakuShikyuShinsei kogakuShikyuShinsei : serviceTeikyoYMList) {
                FlexibleYearMonth サービス提供年月 = kogakuShikyuShinsei.getサービス提供年月();
                datasource.add(new KeyValueDataSource(サービス提供年月.toDateString(), サービス提供年月.wareki().toDateString()));
            }
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            List<JigyoKogakuShikyuShinsei> serviceTeikyoYMList
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getServiceTeikyoByDbT3110(被保険者番号, 証記載保険者番号);
            for (JigyoKogakuShikyuShinsei jigyoKogakuShikyuShinsei : serviceTeikyoYMList) {
                FlexibleYearMonth サービス提供年月 = jigyoKogakuShikyuShinsei.getサービス提供年月();
                datasource.add(new KeyValueDataSource(サービス提供年月.toDateString(), サービス提供年月.wareki().toDateString()));
            }
        }
        div.getShinseishoHakkoParameters().getDdlServiceYM().getDataSource().clear();
        if (!datasource.isEmpty()) {
            div.getShinseishoHakkoParameters().getDdlServiceYM().setDataSource(datasource);
            div.getShinseishoHakkoParameters().getDdlServiceYM().setSelectedIndex(BEGININDEX);
        }
    }

    /**
     * バッチパラメータ作成
     *
     * @param menuID RString
     * @return DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter
     */
    public DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter createBatchParameter(RString menuID) {
        DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter
                = new DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter();
        FlexibleYearMonth 処理年月 = FlexibleYearMonth.EMPTY;
        if (!div.getShinseishoHakkoParameters().getRadShinsaYM().getSelectedKey().isEmpty()) {
            FlexibleDate 処理年月日 = div.getShinseishoHakkoParameters().getTxtShinsaYM().getValue();
            処理年月 = new FlexibleYearMonth(処理年月日.toString().substring(BEGININDEX, ENDINDEX));
            parameter.setChushutsuJoken(KogakuKyufu_OshiraseTsuchi_ChushutsuJoken.審査年月);
        } else if (!div.getShinseishoHakkoParameters().getRadHihokenshaNo().getSelectedKey().isEmpty()) {
            RString 年月 = div.getShinseishoHakkoParameters().getDdlServiceYM().getSelectedKey();
            処理年月 = new FlexibleYearMonth(年月.toString().substring(BEGININDEX, ENDINDEX));
            parameter.setChushutsuJoken(KogakuKyufu_OshiraseTsuchi_ChushutsuJoken.被保険者番号);
        } else if (!div.getShinseishoHakkoParameters().getRadHakushiInsatsu().getSelectedKey().isEmpty()) {
            処理年月 = FlexibleYearMonth.EMPTY;
            parameter.setChushutsuJoken(KogakuKyufu_OshiraseTsuchi_ChushutsuJoken.白紙);
        }
        parameter.setShoriYm(処理年月);

        parameter.setSakuseibi(div.getShutsuryokuTaisho().getTxtSakuseiDate().getValue());
        RString 被保険者番号 = RString.EMPTY;
        if (!div.getShinseishoHakkoParameters().getRadHihokenshaNo().getSelectedKey().isEmpty()) {
            被保険者番号 = div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue();
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

        if (div.getCcdShuturyokujun().get出力順ID() != null) {
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
        if (RString.EMPTY.equals(文書番号)) {
            parameter.setBunshoMojiretsu(RString.EMPTY);
        } else {
            parameter.setBunshoMojiretsu(文書番号);
        }
        set受託あり(parameter, menuID);

        ChohyoSeigyoHanyo 帳票制御汎用電話番号表示キー = null;
        ChohyoSeigyoHanyo 帳票制御汎用委任状提出先キー = null;
        if (メニューID_DBCMN43001.equals(menuID)) {
            帳票制御汎用電話番号表示キー = KogakuShikyuShinseishoIkkatsu.createInstance().getChohyoHanyoKey(
                    SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID_DBC100068), 管理年度, 項目名_電話番号表示);
            帳票制御汎用委任状提出先キー = KogakuShikyuShinseishoIkkatsu.createInstance().getChohyoHanyoKey(
                    SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID_DBC100068), 管理年度, 項目名_委任状提出先);
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            帳票制御汎用電話番号表示キー = KogakuShikyuShinseishoIkkatsu.createInstance().getChohyoHanyoKey(
                    SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID_DBC100070), 管理年度, 項目名_電話番号表示);
            帳票制御汎用委任状提出先キー = KogakuShikyuShinseishoIkkatsu.createInstance().getChohyoHanyoKey(
                    SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID_DBC100070), 管理年度, 項目名_委任状提出先);
        }

        if (帳票制御汎用電話番号表示キー != null) {
            parameter.setShinseishoTelNoHyoji(帳票制御汎用電話番号表示キー.get設定値());
        }
        if (帳票制御汎用委任状提出先キー != null) {
            parameter.setIninjoTeishutsusaki(帳票制御汎用委任状提出先キー.get設定値());
        }
        return parameter;
    }

    private void set受託あり(DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter,
            RString menuID) {
        RDate nowdate = RDate.getNowDate();
        RString 高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                nowdate, SubGyomuCode.DBC介護給付);
        RString 事業高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額,
                nowdate, SubGyomuCode.DBC介護給付);
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
