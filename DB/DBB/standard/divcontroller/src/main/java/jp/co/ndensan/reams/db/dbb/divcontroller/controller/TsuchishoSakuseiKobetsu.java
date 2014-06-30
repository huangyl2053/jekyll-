/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001.TsuchishoSakuseiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3412
 */
public class TsuchishoSakuseiKobetsu {

    public ResponseData<TsuchishoSakuseiKobetsuDiv> onLoad_TsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsuDiv panel) {
        ResponseData<TsuchishoSakuseiKobetsuDiv> response = new ResponseData<>();

        init(panel);

        List<dgChohyoSentaku_Row> arrayData = new ArrayList<>();

        arrayData.add(set_dgChohyoSentaku_Row(new RString("決定通知書")));
        arrayData.add(set_dgChohyoSentaku_Row(new RString("変更兼特徴中止通知書")));
        arrayData.add(set_dgChohyoSentaku_Row(new RString("納入通知書")));
        arrayData.add(set_dgChohyoSentaku_Row(new RString("郵便振替納付書")));
        arrayData.add(set_dgChohyoSentaku_Row(new RString("賦課台帳")));

        panel.getDgChohyoSentaku().setDataSource(arrayData);

        response.data = panel;
        return response;
    }

    private dgChohyoSentaku_Row set_dgChohyoSentaku_Row(RString s) {
        dgChohyoSentaku_Row row = new dgChohyoSentaku_Row(RString.EMPTY);
        row.setTxtChohyoSentaku(s);
        return row;
    }

    private void init(TsuchishoSakuseiKobetsuDiv panel) {
        panel.getTokuKaishiTsuchiKobetsu().setIsOpen(false);
        
        panel.getKetteiTsuchiKobetsu().setIsOpen(false);
        panel.getKetteiTsuchiKobetsu().setIsPublish(false);

        panel.getHenkoTsuchiKobetsu().setIsOpen(false);
        panel.getHenkoTsuchiKobetsu().setIsPublish(false);

        panel.getNotsuKobetsu().setIsOpen(false);
        panel.getNotsuKobetsu().setIsPublish(false);

        panel.getGemmenTsuchiKobetsu().setIsOpen(false);
        
        panel.getYufuriKobetsu().setIsOpen(false);
        panel.getYufuriKobetsu().setIsPublish(false);
        
        panel.getChoshuYuyoTsuchiKobetsu().setIsOpen(false);

        panel.getFukadaichoKobetsu().setIsOpen(false);
        panel.getFukadaichoKobetsu().setIsPublish(false);
    }

    public ResponseData<TsuchishoSakuseiKobetsuDiv> onSelect_dgChohyoSentaku_Row(TsuchishoSakuseiKobetsuDiv panel) { 

        ResponseData<TsuchishoSakuseiKobetsuDiv> response = new ResponseData<>();

        change_KetteiTsuchiKobetsu(panel);
        change_HenkoTsuchiKobetsu(panel);
        change_NotsuKobetsu(panel);
        change_YufuriKobetsu(panel);
        change_FukadaichoKobetsu(panel);

        response.data = panel;
        return response;
    }
    
    private void change_KetteiTsuchiKobetsu(TsuchishoSakuseiKobetsuDiv panel) {

        if (panel.getDgChohyoSentaku().getClickedItem().getTxtChohyoSentaku().equals(new RString("決定通知書"))) {
            if (panel.getKetteiTsuchiKobetsu().isIsOpen() == false) {
                panel.getKetteiTsuchiKobetsu().setIsOpen(true);
            } else {
                panel.getKetteiTsuchiKobetsu().setIsOpen(false);
            }
            if (panel.getKetteiTsuchiKobetsu().isIsPublish() == false) {
                panel.getKetteiTsuchiKobetsu().setIsPublish(true);
            } else {
                panel.getKetteiTsuchiKobetsu().setIsPublish(false);
            }
        }
    }

    private void change_HenkoTsuchiKobetsu(TsuchishoSakuseiKobetsuDiv panel) {

        if (panel.getDgChohyoSentaku().getClickedItem().getTxtChohyoSentaku().equals(new RString("変更兼特徴中止通知書"))) {
            if (panel.getHenkoTsuchiKobetsu().isIsOpen() == false) {
                panel.getHenkoTsuchiKobetsu().setIsOpen(true);
            } else {
                panel.getHenkoTsuchiKobetsu().setIsOpen(false);
            }
            if (panel.getHenkoTsuchiKobetsu().isIsPublish() == false) {
                panel.getHenkoTsuchiKobetsu().setIsPublish(true);
            } else {
                panel.getHenkoTsuchiKobetsu().setIsPublish(false);
            }
        }
    }

    private void change_NotsuKobetsu(TsuchishoSakuseiKobetsuDiv panel) {

        if (panel.getDgChohyoSentaku().getClickedItem().getTxtChohyoSentaku().equals(new RString("納入通知書"))) {
            if (panel.getNotsuKobetsu().isIsOpen() == false) {
                panel.getNotsuKobetsu().setIsOpen(true);
            } else {
                panel.getNotsuKobetsu().setIsOpen(false);
            }
            if (panel.getNotsuKobetsu().isIsPublish() == false) {
                panel.getNotsuKobetsu().setIsPublish(true);
            } else {
                panel.getNotsuKobetsu().setIsPublish(false);
            }
        }
    }

    private void change_YufuriKobetsu(TsuchishoSakuseiKobetsuDiv panel) {

        if (panel.getDgChohyoSentaku().getClickedItem().getTxtChohyoSentaku().equals(new RString("郵便振替納付書"))) {
            if (panel.getYufuriKobetsu().isIsOpen() == false) {
                panel.getYufuriKobetsu().setIsOpen(true);
            } else {
                panel.getYufuriKobetsu().setIsOpen(false);
            }
            if (panel.getYufuriKobetsu().isIsPublish() == false) {
                panel.getYufuriKobetsu().setIsPublish(true);
            } else {
                panel.getYufuriKobetsu().setIsPublish(false);
            }
        }
    }

    private void change_FukadaichoKobetsu(TsuchishoSakuseiKobetsuDiv panel) {

        if (panel.getDgChohyoSentaku().getClickedItem().getTxtChohyoSentaku().equals(new RString("賦課台帳"))) {
            if (panel.getFukadaichoKobetsu().isIsOpen() == false) {
                panel.getFukadaichoKobetsu().setIsOpen(true);
            } else {
                panel.getFukadaichoKobetsu().setIsOpen(false);
            }
            if (panel.getFukadaichoKobetsu().isIsPublish() == false) {
                panel.getFukadaichoKobetsu().setIsPublish(true);
            } else {
                panel.getFukadaichoKobetsu().setIsPublish(false);
            }
        }
    }

}
