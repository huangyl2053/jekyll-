/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotaku.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotaku.SakuseiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001.HanyorisutoPanelDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト 居宅サービス計画
 *
 * @reamsid_L DBC-3091-010 zhangrui
 */
public class HanyorisutoPanelHandler {

    private final HanyorisutoPanelDiv div;
    private static final RString 事務広域 = new RString("111");

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
        ShichosonSecurityJoho ssj = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (ssj != null && ssj.get導入形態コード() != null) {
            if (ssj.get導入形態コード().is広域()) {
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
            div.getRadSakuseiKubun().getSelectedKey();
            div.getRadChusyutuKubun().setSelectedKey(ChushutsuKubun.直近有効データ.getコード());
            div.getRadChusyutuKubun().getSelectedKey();
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, new ReportId("DBC701001_HanyoListKyotakuServiceKeikaku"));
            div.getTxtKijunYMD().setDisabled(true);
        }
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
}
