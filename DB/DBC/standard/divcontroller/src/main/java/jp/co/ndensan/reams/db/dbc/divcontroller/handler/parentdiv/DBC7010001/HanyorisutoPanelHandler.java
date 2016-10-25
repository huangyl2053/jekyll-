/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyotaku.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyotaku.SakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710010.DBC710010_HanyoListKyotakuServiceKeikakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001.HanyorisutoPanelDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト 居宅サービス計画
 *
 * @reamsid_L DBC-3091-010 zhangrui
 */
public class HanyorisutoPanelHandler {

    private final HanyorisutoPanelDiv div;
    private static final RString 帳票ID = new RString("DBC701001_HanyoListKyotakuServiceKeikaku");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final ReportId REPORTID = new ReportId("DBC701001_HanyoListKyotakuServiceKeikaku");
    private static final RString KEY_構成市町村コード = new RString("構成市町村コード");
    private static final RString KEY_作成区分 = new RString("作成区分");
    private static final RString KEY_抽出区分 = new RString("抽出区分");
    private static final RString KEY_基準年月日 = new RString("基準年月日");
    private static final RString KEY_支援事業者番号 = new RString("支援事業者番号");
    private static final RString KEY_項目名付加 = new RString("csv項目名付加");
    private static final RString KEY_連番付加 = new RString("csv連番付加");
    private static final RString KEY_日付スラッシュ編集 = new RString("csv日付スラッシュ編集");
    private static final RString KEY_改頁出力順ID = new RString("改頁出力順ID");

    /**
     * HanyorisutoPanelDiv取得します。
     *
     * @param div 画面DIV
     */
    public HanyorisutoPanelHandler(HanyorisutoPanelDiv div) {
        this.div = div;
    }

    /**
     * initialize事件ことです。
     *
     * @param div HanyorisutoPanelDiv
     */
    public void initialize(HanyorisutoPanelDiv div) {
        ShichosonSecurityJoho shichosonsecurityjoho
                = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonsecurityjoho == null) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (shichosonsecurityjoho.get導入形態コード() != null
                && shichosonsecurityjoho.get導入形態コード().is広域()) {
            div.getCcdHokensya().setVisible(true);
            div.getCcdHokensya().setDisabled(false);
            div.getCcdHokensya().loadHokenshaList();
        } else {
            div.getCcdHokensya().setVisible(false);
            div.getCcdHokensya().setDisabled(true);
        }
        List<KeyValueDataSource> sakuseikubunlist = new ArrayList();
        for (SakuseiKubun sakuseikubun : SakuseiKubun.values()) {
            KeyValueDataSource source = new KeyValueDataSource(sakuseikubun.getコード(), sakuseikubun.get名称());
            sakuseikubunlist.add(source);
        }
        div.getRadSakuseiKubun().setDataSource(sakuseikubunlist);
        List<KeyValueDataSource> chushutsukubunlist = new ArrayList();
        for (ChushutsuKubun chushutsukubun : ChushutsuKubun.values()) {
            KeyValueDataSource source = new KeyValueDataSource(chushutsukubun.getコード(), chushutsukubun.get名称());
            chushutsukubunlist.add(source);
        }
        div.getRadChusyutuKubun().setDataSource(chushutsukubunlist);
        div.getRadSakuseiKubun().setSelectedKey(SakuseiKubun.すべて.getコード());
        div.getRadChusyutuKubun().setSelectedKey(ChushutsuKubun.直近有効データ.getコード());
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, new ReportId(帳票ID));
        div.getTxtKijunYMD().setDisabled(true);
    }

    /**
     * 抽出区分表示制御を処理します。
     *
     */
    public void set抽出区分表示制御処理() {
        if (ChushutsuKubun.直近有効データ.getコード().equals(div.getRadChusyutuKubun().getSelectedKey())
                || ChushutsuKubun.全データ.getコード().equals(div.getRadChusyutuKubun().getSelectedKey())) {
            div.getTxtKijunYMD().setDisabled(true);
        } else if (ChushutsuKubun.全有効データ.getコード().equals(div.getRadChusyutuKubun().getSelectedKey())) {
            div.getTxtKijunYMD().setDisabled(false);
        }
    }

    /**
     * setBatchParameterのメソッドです。
     *
     * @param div HanyorisutoPanelDiv
     * @return HanyoListKyotakuServiceKeikakuBatchParameter
     */
    public DBC710010_HanyoListKyotakuServiceKeikakuParameter setBatchParameter(HanyorisutoPanelDiv div) {
        DBC710010_HanyoListKyotakuServiceKeikakuParameter bparam = new DBC710010_HanyoListKyotakuServiceKeikakuParameter();
        if (div.getCcdHokensya().isVisible()) {
            bparam.set構成市町村コード(div.getCcdHokensya().getSelectedItem().get市町村コード());
        }
        bparam.set作成区分(div.getRadSakuseiKubun().getSelectedKey());
        RString radchusyutukubunkey = div.getRadChusyutuKubun().getSelectedKey();
        bparam.set抽出区分(radchusyutukubunkey);
        FlexibleDate 基準年月日 = div.getTxtKijunYMD().getValue() == null
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtKijunYMD().getValue().toString());
        if (ChushutsuKubun.全有効データ.getコード().equals(radchusyutukubunkey)) {
            bparam.set基準年月日(基準年月日);
        } else {
            bparam.set基準年月日(null);
        }
        bparam.set支援事業者番号(div.getTxtSienJigyosyano().getValue());
        bparam.set改頁出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID() == null
                ? RString.EMPTY : new RString(div.getCcdChohyoShutsuryokujun().get出力順ID().toString()));
        bparam.set出力項目ID(div.getCcdChohyoShutsuryokukoumoku().get出力項目ID());
        List<RString> list = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        bparam.setCsv項目名付加(list.contains(ONE));
        bparam.setCsv連番付加(list.contains(TWO));
        bparam.setCsv日付スラッシュ編集(list.contains(THREE));
        return bparam;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     */
    public void pamaRestore() {

        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        LasdecCode 構成市町村コード = restoreBatchParameterMap.getParameterValue(LasdecCode.class, KEY_構成市町村コード);
        if (構成市町村コード != null) {
            if (構成市町村コード.isEmpty()) {
                div.getCcdHokensya().loadHokenshaList();
            } else {
                div.getCcdHokensya().setSelectedShichosonIfExist(構成市町村コード);
            }
        }
        RString 作成区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_作成区分);
        if (作成区分 != null && !作成区分.isEmpty()) {
            div.getRadSakuseiKubun().setSelectedKey(作成区分);
        }
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_抽出区分);
        if (抽出区分 != null && !抽出区分.isEmpty()) {
            div.getRadChusyutuKubun().setSelectedKey(抽出区分);
        }
        FlexibleDate 基準年月日 = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_基準年月日);
        div.getTxtKijunYMD().clearValue();
        if (基準年月日 != null && !基準年月日.isEmpty()) {
            div.getTxtKijunYMD().setValue(new RDate(基準年月日.toString()));
        }
        div.getTxtSienJigyosyano().clearValue();
        RString 支援事業者番号 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_支援事業者番号);
        if (支援事業者番号 != null && !支援事業者番号.isEmpty()) {
            div.getTxtSienJigyosyano().setValue(支援事業者番号);
        }
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean csv項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_項目名付加);
        if (csv項目名付加) {
            csv編集方法リスト.add(ONE);
        }
        boolean csv連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_連番付加);
        if (csv連番付加) {
            csv編集方法リスト.add(TWO);
        }
        boolean csv日付スラッシュ編集 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_日付スラッシュ編集);
        if (csv日付スラッシュ編集) {
            csv編集方法リスト.add(THREE);
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        RString 改頁出力順ID = restoreBatchParameterMap.getParameterValue(RString.class, KEY_改頁出力順ID);
        if (改頁出力順ID != null && !改頁出力順ID.isEmpty()) {
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, REPORTID,
                    Long.valueOf(改頁出力順ID.toString()));
        }
        set抽出区分表示制御処理();
    }

}
