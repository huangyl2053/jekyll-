/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900031;

import jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku.BenmeiTorokuMeisaiJoho;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.BenmeiTorokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明登録マスタ画面のハンドラクラスです。
 *
 * @reamsid_L DBU-1080-020 lijia
 *
 */
public class BenmeiTorokuPanelHandler {

    private final BenmeiTorokuPanelDiv panelDiv;
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param panelDiv 弁明登録情報Div
     */
    public BenmeiTorokuPanelHandler(BenmeiTorokuPanelDiv panelDiv) {
        this.panelDiv = panelDiv;
    }

    /**
     * 画面初期化処理します。
     *
     * @param benmeiTorokuMeisaiJoho 弁明登録情報
     * @param viewState 表示状態
     * @param 弁明書作成日 FlexibleDate
     */
    public void initialize(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho, RString viewState, FlexibleDate 弁明書作成日) {
        if (viewState.equals(修正)) {
            if (benmeiTorokuMeisaiJoho != null && 弁明書作成日 != null && !弁明書作成日.isEmpty()) {
                panelDiv.setProcessState(修正);
                get画面初期の更新モードの表示制御();
                get弁明登録明細情報のnull処理(benmeiTorokuMeisaiJoho);
            } else {
                panelDiv.setProcessState(状態_登録);
                get画面初期の更新モードの表示制御();
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().clearValue();
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setValue(RString.EMPTY);
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setValue(RString.EMPTY);
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setValue(RString.EMPTY);
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().clearValue();
            }
        } else if (viewState.equals(削除)) {
            panelDiv.setProcessState(削除);
            get画面初期の削除モードの表示制御();
            get弁明登録明細情報のnull処理(benmeiTorokuMeisaiJoho);
        }
    }

    private void get画面初期の更新モードの表示制御() {
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().setDisabled(false);
    }

    private void get画面初期の削除モードの表示制御() {
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().setDisabled(true);
    }

    private void get弁明登録明細情報のnull処理(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho) {
        if (benmeiTorokuMeisaiJoho.getBemmeishoSakuseiYMD() == null) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().clearValue();
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().setValue(
                    new RDate(benmeiTorokuMeisaiJoho.getBemmeishoSakuseiYMD().toString()));
        }
        if (benmeiTorokuMeisaiJoho.getBemmeisha() == null) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setValue(RString.EMPTY);
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setValue(benmeiTorokuMeisaiJoho.getBemmeisha());
        }
        if (benmeiTorokuMeisaiJoho.getShinsaseikyuKankeiShobunNaiyo() == null) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setValue(RString.EMPTY);
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setValue(
                    benmeiTorokuMeisaiJoho.getShinsaseikyuKankeiShobunNaiyo());
        }
        if (benmeiTorokuMeisaiJoho.getBemmeiNaiyo() == null) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setValue(RString.EMPTY);
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setValue(benmeiTorokuMeisaiJoho.getBemmeiNaiyo());
        }
        if (benmeiTorokuMeisaiJoho.getBemmeishoTeishutsuYMD() == null || benmeiTorokuMeisaiJoho.getBemmeishoTeishutsuYMD().isEmpty()) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().clearValue();
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().setValue(
                    new RDate(benmeiTorokuMeisaiJoho.getBemmeishoTeishutsuYMD().toString()));
        }
    }
}
