/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5110001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511003.DBD511003_KoshinMiShinseishaHaakuParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.KoshinShinseishaHaakuListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新未申請者把握リスト作成画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1420-010 wangjie2
 */
public class KoshinShinseishaHaakuListHandler {

    private final KoshinShinseishaHaakuListDiv div;
    private final RString 未申請者全て_KEY = new RString("all");

    /**
     * コンストラクタです。
     *
     * @param div 更新未申請者把握リスト作成のコントロールdiv
     */
    public KoshinShinseishaHaakuListHandler(KoshinShinseishaHaakuListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        div.getRadPrintSelect().setSelectedKey(未申請者全て_KEY);
        div.getTxtInsatsuDate().setReadOnly(true);
        div.getTxtInsatsuDateFrom().setReadOnly(true);
        div.getTxtInsatsuDateTo().setReadOnly(true);
        div.getTxtInsatsuDate().clearDomain();
        div.getTxtInsatsuDateFrom().clearDomain();
        div.getTxtInsatsuDateTo().clearDomain();
    }

    /**
     * 未申請者状態です。
     *
     */
    public void 未申請者状態() {
        div.getTxtInsatsuDate().setReadOnly(true);
        div.getTxtInsatsuDateFrom().setReadOnly(true);
        div.getTxtInsatsuDateTo().setReadOnly(true);
    }

    /**
     * 対象期間状態です。
     *
     */
    public void 対象期間状態() {
        div.getTxtInsatsuDate().setReadOnly(false);
        div.getTxtInsatsuDateFrom().setReadOnly(true);
        div.getTxtInsatsuDateTo().setReadOnly(true);
    }

    /**
     * 範囲指定状態です。
     *
     */
    public void 範囲指定状態() {
        div.getTxtInsatsuDate().setReadOnly(true);
        div.getTxtInsatsuDateFrom().setReadOnly(false);
        div.getTxtInsatsuDateTo().setReadOnly(false);
    }

    /**
     * 画面側からバッチパラメータを取得します。
     *
     * @return バッチパラメータ
     */
    public DBD511003_KoshinMiShinseishaHaakuParameter getParameter() {
        DBD511003_KoshinMiShinseishaHaakuParameter parameter = new DBD511003_KoshinMiShinseishaHaakuParameter();
        parameter.set印刷範囲指定(div.getRadPrintSelect().getSelectedValue());
        parameter.set認定有効期間_終了月(div.getTxtInsatsuDate().getDomain());
        parameter.set認定有効期間_終了月_To(div.getTxtInsatsuDateTo().getDomain());
        parameter.set認定有効期間_終了月_From(div.getTxtInsatsuDateFrom().getDomain());
        return parameter;
    }

}
