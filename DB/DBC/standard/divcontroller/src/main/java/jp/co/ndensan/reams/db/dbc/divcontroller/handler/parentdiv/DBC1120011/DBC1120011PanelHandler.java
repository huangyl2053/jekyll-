/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1120011;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1120011.DBC1120011PanelDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMN62006_自己負担額計算（一括）のクラスです。
 *
 * @reamsid_L DBC-2060-010 chenyadong
 */
public class DBC1120011PanelHandler {

    private final DBC1120011PanelDiv div;
    private final RString NUM_1 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     */
    public DBC1120011PanelHandler(DBC1120011PanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     */
    public void initialize() {
        Association 市町村コードTemp = AssociationFinderFactory.createInstance().getAssociation();
        ShoriDateKanri 処理日付管理マスタ;
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        処理日付管理マスタ = manager.get処理日付管理マスタ(SubGyomuCode.DBC介護給付, 市町村コードTemp.get地方公共団体コード(),
                ShoriName.事業分自己負担額計算.get名称());
        if (処理日付管理マスタ != null) {
            RDate 前回対象開始年月日Temp = new RDate(処理日付管理マスタ.get対象開始年月日().toString());
            RDate 前回対象終了年月日Temp = new RDate(処理日付管理マスタ.get対象終了年月日().toString());
            div.getTxtZenkaiTaishoYMD().setFromValue(前回対象開始年月日Temp);
            div.getTxtZenkaiTaishoYMD().setToValue(前回対象終了年月日Temp);
            if (!div.getTxtZenkaiTaishoYMD().getToValue().toString().isEmpty()) {
                RDate 申請対象開始日 = div.getTxtZenkaiTaishoYMD().getToValue().plusDay(Integer.parseInt(NUM_1.toString()));
                div.getTxtShinseiTaishoYMD().setFromValue(申請対象開始日);
            } else {
                div.getTxtShinseiTaishoYMD().setFromValue(null);
            }
            div.getTxtShinseiTaishoYMD().setToValue(RDate.getNowDate());
        } else {
            div.getTxtZenkaiTaishoYMD().setFromValue(null);
            div.getTxtZenkaiTaishoYMD().setToValue(null);
            div.getTxtShinseiTaishoYMD().setFromValue(null);
            div.getTxtShinseiTaishoYMD().setToValue(null);
        }
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200029.getReportId());
    }

     //TODO QA.1044
    /**
     * 出力CHKのonOpen事件です。
     */
    public void onOpen出力CHK() {
        if (div.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().isIsPublish()) {
            div.getCcdChohyoShutsuryokujun().setDisabled(false);
        } else {
            div.getCcdChohyoShutsuryokujun().setDisabled(true);
        }
    }

    /**
     * 出力CHKのonClose事件です。
     */
    public void onClose出力CHK() {
        if (div.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().isIsPublish()) {
            div.getCcdChohyoShutsuryokujun().setDisabled(false);
        } else {
            div.getCcdChohyoShutsuryokujun().setDisabled(true);
        }
    }
}
