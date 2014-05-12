/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010020Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010040Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteiChousaIraiGrid_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 認定調査依頼対象一覧に対し印刷・完了・データ出力の指示ボタンを表示するパネルです。
 *
 * @author N8107 千秋雄
 */
public class DDBE2010040 {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param dDBE2010040p DDBE2010040Div
     * @param dDBE2010020p DDBE2010040Div
     * @return DDBE2010040DivのResponseData
     */
    public ResponseData getOnLoadData(DDBE2010040Div dDBE2010040p, DDBE2010020Div dDBE2010020p) {
        ResponseData response = new ResponseData<>();

        dDBE2010040p.getTextBoxKanryoYMD().setValue(RDate.getNowDate());
        response.data = dDBE2010040p;

        return response;
    }

    /**
     * 完了ボタンが押下されたときの動作です。
     *
     * @param dDBE2010040p DDBE2010040Div
     * @param dDBE2010020p DDBE2010040Div
     * @return DDBE2010040DivのResponseData
     */
    public ResponseData onClickChosaKanryo(DDBE2010040Div dDBE2010040p, DDBE2010020Div dDBE2010020p) {
        //TODO N8107 千秋雄 ＤＢへの更新処理および再度読み込みし編集する処理を組み込む。
        ResponseData response = new ResponseData<>();

        List<dgNinteiChousaIraiGrid_Row> list = dDBE2010020p.getDgNinteiChousaIraiGrid().getDataSource();
        List<dgNinteiChousaIraiGrid_Row> selectChosairai = dDBE2010020p.getDgNinteiChousaIraiGrid().getSelectedItems();

        for (dgNinteiChousaIraiGrid_Row chosairai : selectChosairai) {

            chosairai.set依頼完了年月日((dDBE2010040p.getTextBoxKanryoYMD().getText()));

//            dDBE2010030p.getTextBoxIraisaki().setValue(chosairai.get前回調査機関コード());
//            dDBE2010030p.getTextBoxIraisakiMei().setValue(chosairai.get前回調査機関());
        }
        dDBE2010020p.getDgNinteiChousaIraiGrid().setDataSource(list);
        response.data = dDBE2010020p;
        return response;
    }

}
