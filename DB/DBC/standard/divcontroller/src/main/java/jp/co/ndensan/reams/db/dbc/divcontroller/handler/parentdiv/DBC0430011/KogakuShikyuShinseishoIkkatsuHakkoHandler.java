/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0430011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KogakuKaigoServicehiOshiraseHakko.KogakuKaigoServicehiOshiraseHakkoParameter;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.KogakuShikyuShinseishoIkkatsu.KogakuShikyuShinseishoIkkatsu;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額サービス費給付お知らせ通知書作成のハンドラクラスです。
 *
 * @reamsid DBC-0430-011 zhengshenlei
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
    private static final RString SHINSEIKEY = new RString("shinseishoHakko");
    private static final RString OSHIRASEKEY = new RString("oshiraseTsuchiHakko");
    private static final RString 交換情報識別番号_201 = new RString("201");
    private static final RString 交換情報識別番号_202 = new RString("202");
    private static final RString 交換情報識別番号_331 = new RString("331");
    private static final RString 交換情報識別番号_335 = new RString("335");
    private static final int DAY_9 = 9;
    private static final RString EM = new RString("指定した被保険者の、高額介護サービス支給申請情報がありません。");

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
        if (メニューID_DBCMN43001.equals(menuID)) {
            RString 区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, RDate.getNowDate(),
                    SubGyomuCode.DBC介護給付);
            List<KeyValueDataSource> radShinsaYM = new ArrayList<>();
            if (NUM_1.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(審査年月, 審査年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
            } else if (NUM_2.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(受取年月, 受取年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
            }
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            RString 区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額, RDate.getNowDate(),
                    SubGyomuCode.DBC介護給付);
            List<KeyValueDataSource> radShinsaYM = new ArrayList<>();
            if (NUM_1.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(審査年月, 審査年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
            } else if (NUM_2.equals(区分)) {
                radShinsaYM.add(new KeyValueDataSource(受取年月, 受取年月));
                div.getShinseishoHakkoParameters().getRadShinsaYM().setDataSource(radShinsaYM);
            }
        }
        List<KeyValueDataSource> datasource = new ArrayList<>();
        datasource.add(new KeyValueDataSource(SHINSEIKEY, 高額介護サービス費支給申請書を発行する));
        datasource.add(new KeyValueDataSource(OSHIRASEKEY, 高額介護サービス費給付お知らせ通知を発行する));
        div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().setSelectedItems(datasource);

        KokuhorenInterfaceKanriManager manager = InstanceProvider.create(KokuhorenInterfaceKanriManager.class);
        RString 交換情報識別番号 = RString.EMPTY;
        if (メニューID_DBCMN43001.equals(menuID)) {
            if (NUM_1.equals(DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付))) {
                交換情報識別番号 = 交換情報識別番号_201;
            } else if (NUM_2.equals(DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付))) {
                交換情報識別番号 = 交換情報識別番号_331;
            }
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            if (NUM_1.equals(DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付))) {
                交換情報識別番号 = 交換情報識別番号_202;
            } else if (NUM_2.equals(DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付))) {
                交換情報識別番号 = 交換情報識別番号_335;
            }

        }
        KokuhorenInterfaceKanri result = manager.get国保連インターフェース管理(交換情報識別番号);
        if (result != null) {
            FlexibleYearMonth 処理年月 = result.get処理年月();
            if (処理年月 != null) {
                RStringBuilder 年月 = new RStringBuilder(処理年月.toDateString());
                div.getShinseishoHakkoParameters().getTxtShinsaYM().setValue(new FlexibleDate(年月.toRString()));
            }
        }

        RString 初回申請把握基準日 = DbBusinessConfig.get(ConfigNameDBC.高額自動償還_初回申請把握基準日,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        div.getShinseishoHakkoParameters().getTxtShokaiShinseiHakuKijunDate().setValue(new FlexibleDate(初回申請把握基準日));

        div.getShutsuryokuTaisho().getTxtSakuseiDate().setValue(FlexibleDate.getNowDate());
        div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().setValue(FlexibleDate.getNowDate().plusDay(DAY_9));
        div.getJidoShokanTaishoJohoSettei().getTxtShinseiDate().setValue(FlexibleDate.getNowDate());
        div.getJidoShokanTaishoJohoSettei().getTxtUketsukeDate().setValue(FlexibleDate.getNowDate());
        div.getJidoShokanTaishoJohoSettei().getTxtKetteiDate().setValue(FlexibleDate.getNowDate());

        if (メニューID_DBCMN43001.equals(menuID)) {
            div.getShutsuryokuTaisho().getCcdBunshoNo().initialize(ReportIdDBC.DBC100011.getReportId());
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            div.getShutsuryokuTaisho().getCcdBunshoNo().initialize(ReportIdDBC.DBC100072.getReportId());
        }

        div.getCcdShuturyokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200091.getReportId());
    }

    /**
     * 3．被保険者番号を選択した際の、サービス年月DDLの値設定のメソッドです。
     *
     * @param menuID RString
     */
    public void setサービス年月DDL(RString menuID) {
        if (div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.入力値が不正.getMessage().replace(EM.toString()));
        }
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        List<KeyValueDataSource> datasource = new ArrayList<>();
        if (メニューID_DBCMN43001.equals(menuID)) {
            List<KogakuShikyuShinsei> serviceTeikyoYMList
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getServiceTeikyoByDbT3056(被保険者番号, 証記載保険者番号);
            for (KogakuShikyuShinsei ym : serviceTeikyoYMList) {
                FlexibleYearMonth サービス提供年月 = ym.getサービス提供年月();
                RString ymdata = DateConverter.toWarekiHalf_Zero(new RDate(サービス提供年月.toString()));
                datasource.add(new KeyValueDataSource(サービス提供年月.toDateString(), ymdata));
            }
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            List<JigyoKogakuShikyuShinsei> serviceTeikyoYMList
                    = KogakuShikyuShinseishoIkkatsu.createInstance().getServiceTeikyoByDbT3110(被保険者番号, 証記載保険者番号);
            for (JigyoKogakuShikyuShinsei ym : serviceTeikyoYMList) {
                FlexibleYearMonth サービス提供年月 = ym.getサービス提供年月();
                RString ymdata = DateConverter.toWarekiHalf_Zero(new RDate(サービス提供年月.toString()));
                datasource.add(new KeyValueDataSource(サービス提供年月.toDateString(), ymdata));
            }
        }
        div.getShinseishoHakkoParameters().getDdlServiceYM().setDataSource(datasource);
    }

    /**
     * 4.　バッチパラメータ作成
     *
     * @param menuID RString
     * @return KogakuKaigoServicehiOshiraseHakkoParameter parameter
     */
    public KogakuKaigoServicehiOshiraseHakkoParameter createBatchParameter(RString menuID) {
        KogakuKaigoServicehiOshiraseHakkoParameter parameter = new KogakuKaigoServicehiOshiraseHakkoParameter();
        FlexibleYearMonth 処理年月 = FlexibleYearMonth.EMPTY;
        if (!div.getShinseishoHakkoParameters().getRadShinsaYM().getSelectedKey().isEmpty()) {
            処理年月 = new FlexibleYearMonth(div.getShinseishoHakkoParameters().getTxtShinsaYM().getValue().toString());
            parameter.set抽出条件(KogakuKaigoServicehiOshiraseHakkoParameter.ShutsuryokuJoken.審査年月.get名称());
        } else if (!div.getShinseishoHakkoParameters().getRadHihokenshaNo().getSelectedKey().isEmpty()) {
            処理年月 = new FlexibleYearMonth(div.getShinseishoHakkoParameters().getDdlServiceYM().getLabelRText());
            parameter.set抽出条件(KogakuKaigoServicehiOshiraseHakkoParameter.ShutsuryokuJoken.被保険者番号.get名称());
        } else if (!div.getShinseishoHakkoParameters().getRadHakushiInsatsu().getSelectedKey().isEmpty()) {
            処理年月 = FlexibleYearMonth.EMPTY;
            parameter.set抽出条件(KogakuKaigoServicehiOshiraseHakkoParameter.ShutsuryokuJoken.白紙.get名称());
        }
        parameter.set処理年月(処理年月);

        parameter.set作成日(div.getShutsuryokuTaisho().getTxtSakuseiDate().getValue());
        HihokenshaNo 被保険者番号;
        if (!div.getShinseishoHakkoParameters().getRadHihokenshaNo().getSelectedKey().isEmpty()) {
            被保険者番号 = new HihokenshaNo(div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue().toString());
        } else {
            被保険者番号 = HihokenshaNo.EMPTY;
        }
        parameter.set被保険者番号(被保険者番号);

        if (!div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().getSelectedItems().isEmpty()) {
            List<KeyValueDataSource> alist = div.getShutsuryokuTaisho().getChkShutsuryokuTaisho().getSelectedItems();
            List<RString> rsList = new ArrayList<>();
            for (KeyValueDataSource kv : alist) {
                rsList.add(kv.getKey());
            }
            if (rsList.contains(SHINSEIKEY)) {
                parameter.set申請書発行(true);
            } else {
                parameter.set申請書発行(false);
            }
            if (rsList.contains(OSHIRASEKEY)) {
                parameter.setお知らせ通知書発行(true);
            } else {
                parameter.setお知らせ通知書発行(false);
            }
        }

        if (div.getShutsuryokuTaisho().getChkHakkoIchiranhyoHakko().isAllSelected()) {
            parameter.set金融機関表示(true);
        } else {
            parameter.set金融機関表示(false);
        }

        if (!(null == div.getCcdShuturyokujun().get出力順ID())) {
            parameter.set出力順ID(div.getCcdShuturyokujun().get出力順ID());
        }
        parameter.set申請日(div.getJidoShokanTaishoJohoSettei().getTxtShinseiDate().getValue());
        parameter.set受付日(div.getJidoShokanTaishoJohoSettei().getTxtUketsukeDate().getValue());
        parameter.set決定日(div.getJidoShokanTaishoJohoSettei().getTxtKetteiDate().getValue());
        if (!div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().getValue().isEmpty()) {
            parameter.set申請書提出期限(div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().getValue());
        }
        parameter.setメニューID(menuID);

        RString 文書番号 = div.getShutsuryokuTaisho().getCcdBunshoNo().get文書番号();
        if (文書番号.equals(RString.EMPTY)) {
            parameter.set文書番号文字列(RString.EMPTY);
        } else {
            parameter.set文書番号文字列(文書番号);
        }

        RString 高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 事業高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (メニューID_DBCMN43001.equals(menuID)) {
            if (NUM_1.equals(高額)) {
                parameter.set受託あり(false);
            } else if (NUM_2.equals(高額)) {
                parameter.set受託あり(true);
            }
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            if (NUM_1.equals(事業高額)) {
                parameter.set受託あり(false);
            } else if (NUM_2.equals(事業高額)) {
                parameter.set受託あり(true);
            }
        }
        return parameter;
    }

    /**
     * 前排他を設定のメソッドです。
     *
     * @return Boolean
     */
    public Boolean 前排他キーのセット() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他を解除のメソッドです。
     */
    public void 前排他を解除する() {
        LockingKey key = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        RealInitialLocker.release(key);
    }

}
