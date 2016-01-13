/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0900031;

import jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku.BenmeiTorokuMeisaiJoho;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.BenmeiTorokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明登録マスタ画面のハンドラクラスです。
 *
 */
public class BenmeiTorokuPanelHandler {

    private final BenmeiTorokuPanelDiv panelDiv;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

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
     */
    public void initialize(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho, RString viewState) {
        if (viewState.equals(状態_修正)) {
            if (benmeiTorokuMeisaiJoho != null) {
                panelDiv.setProcessState(状態_修正);
                get画面初期の更新モードの表示制御();
                get弁明登録明細情報のnull処理1(benmeiTorokuMeisaiJoho);
                get弁明登録明細情報のnull処理2(benmeiTorokuMeisaiJoho);
            } else {
                panelDiv.setProcessState(状態_追加);
                get画面初期の更新モードの表示制御();
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().clearValue();
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setValue(RString.EMPTY);
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setValue(RString.EMPTY);
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setValue(RString.EMPTY);
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().clearValue();
            }
        } else if (viewState.equals(状態_削除)) {
            panelDiv.setProcessState(状態_削除);
            get画面初期の削除モードの表示制御();
            get弁明登録明細情報のnull処理1(benmeiTorokuMeisaiJoho);
            get弁明登録明細情報のnull処理2(benmeiTorokuMeisaiJoho);
        }
    }

    private void get画面初期の更新モードの表示制御() {
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setDisabled(false);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().setDisabled(false);
    }

    private void get画面初期の削除モードの表示制御() {
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setDisabled(true);
        panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().setDisabled(true);
    }

    private void get弁明登録明細情報のnull処理1(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho) {
        if (benmeiTorokuMeisaiJoho.getBemmeishoSakuseiYMD() == null) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().clearValue();
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().setValue(
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
    }

    private void get弁明登録明細情報のnull処理2(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho) {
        if (benmeiTorokuMeisaiJoho.getBemmeiNaiyo() == null) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setValue(RString.EMPTY);
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().setValue(benmeiTorokuMeisaiJoho.getBemmeiNaiyo());
        }
        if (benmeiTorokuMeisaiJoho.getBemmeishoTeishutsuYMD() == null) {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().clearValue();
        } else {
            panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().setValue(
                    new RDate(benmeiTorokuMeisaiJoho.getBemmeishoTeishutsuYMD().toString()));
        }
    }
}
