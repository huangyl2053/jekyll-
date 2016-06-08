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
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001.HanyorisutoPanelDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    public HanyoListKyotakuServiceKeikakuBatchParameter setBatchParameter(HanyorisutoPanelDiv div) {
        HanyoListKyotakuServiceKeikakuBatchParameter bparam = new HanyoListKyotakuServiceKeikakuBatchParameter();
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

}
