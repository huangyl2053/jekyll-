/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000015.DBCMNK4001PanelAllDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 画面設計_DBCMNK4001_更正対象給付実績一覧のハンドラクラスです。
 *
 * @reamsid_L DBC-4960-010 dongqianjing
 */
public class DBCMNK4001PanelAllHandler {

    private final DBCMNK4001PanelAllDiv div;

    /**
     * コンストラクタです。
     *
     * @param div DBCMNK4001PanelAllDiv
     */
    public DBCMNK4001PanelAllHandler(DBCMNK4001PanelAllDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     */
    public void initialize() {
        // div.getTxtKonkaiShuryoDate().setReadOnly(true);
        /*RString 処理済年度 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理済年度,
         RDate.getNowDate(), SubGyomuCode.DBC介護給付);*/
        YMDHMS 前回抽出期間開始 = null;
        YMDHMS 前回抽出期間終了 = null;
        YMDHMS 今回抽出期間開始 = null;
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri 抽出期間 = manager.get抽出期間();
        if (抽出期間 != null) {
            前回抽出期間開始 = 抽出期間.get対象開始日時();
            前回抽出期間終了 = 抽出期間.get対象終了日時();
            今回抽出期間開始 = 抽出期間.get対象終了日時();
        }
        if (前回抽出期間開始 != null) {
            RDate 前回開始年月日 = 前回抽出期間開始.getDate();
            RTime 前回開始時刻 = 前回抽出期間開始.getRDateTime().getTime();
            div.getTxtZenkaiKaishiDate().setValue(前回開始年月日);
            div.getTxtZenkaiKaishiTime().setValue(前回開始時刻);
        }
        if (前回抽出期間終了 != null) {
            RDate 前回終了年月日 = 前回抽出期間終了.getDate();
            RTime 前回終了時刻 = 前回抽出期間終了.getRDateTime().getTime();
            div.getTxtZenkaiShuryoDate().setValue(前回終了年月日);
            div.getTxtZenkaiShuryoTime().setValue(前回終了時刻);
        }
        if (今回抽出期間開始 != null) {
            RDate 今回開始年月日 = 今回抽出期間開始.getDate();
            RTime 今回開始時刻 = 今回抽出期間開始.getRDateTime().getTime();
            div.getTxtKonkaiKaishiDate().setValue(今回開始年月日);
            div.getTxtKonkaiKaishiTime().setValue(今回開始時刻);
        }
        div.getTxtKonkaiShuryoDate().setValue(RDate.getNowDate());
        div.getTxtKonkaiShuryoTime().setValue(RDate.getNowTime());
    }

}
