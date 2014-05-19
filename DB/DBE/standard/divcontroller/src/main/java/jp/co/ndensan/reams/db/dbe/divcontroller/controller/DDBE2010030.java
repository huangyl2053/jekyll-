/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010020Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010030Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteiChousaIraiGrid_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選択された被保険者に対する調査依頼を一括で指示するパネルです。
 *
 * @author N8107 千秋雄
 */
public class DDBE2010030 {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param dDBE2010030p DDBE2010030Div
     * @param dDBE2010020p DDBE2010020Div
     * @return DDBE2010030DivのResponseData
     */
    public ResponseData getOnLoadData(DDBE2010030Div dDBE2010030p, DDBE2010020Div dDBE2010020p) {
        ResponseData response = new ResponseData<>();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        dDBE2010030p.getDDIraikubun().setSelectedItem(new RString("初回"));
        dDBE2010030p.getTextChosaKaisu().setValue(new RString("01"));
        dDBE2010030p.getTextBoxIraisaki().setValue(new RString("K111111111"));
        dDBE2010030p.getTextBoxIraisakiMei().setValue(new RString("電算市"));
        RDate date = RDate.getNowDate();
        dDBE2010030p.getTextBoxIraiYMD().setValue(date);
        date = date.plusDay(7);
        dDBE2010030p.getTextBoxKigenYMD().setValue(date);

        response.data = dDBE2010030p;
        return response;
    }

    /**
     * 更新ボタンが読み込まれた際の動作
     *
     * @param dDBE2010030p DDBE2010030Div
     * @param dDBE2010020p DDBE2010030Div
     * @return DDBE2010020DivのResponseData
     */
    public ResponseData onClickNinteiChoseIraiHozon(DDBE2010030Div dDBE2010030p, DDBE2010020Div dDBE2010020p) {
        //TODO N8107 千秋雄 ＤＢへの更新処理および再度読み込みし編集する処理を組み込む。
        ResponseData response = new ResponseData<>();

        List<dgNinteiChousaIraiGrid_Row> list = dDBE2010020p.getDgNinteiChousaIraiGrid().getDataSource();
        List<dgNinteiChousaIraiGrid_Row> selectChosairai = dDBE2010020p.getDgNinteiChousaIraiGrid().getSelectedItems();

        for (dgNinteiChousaIraiGrid_Row chosairai : selectChosairai) {

            chosairai.set調査機関コード(dDBE2010030p.getTextBoxIraisaki().getValue());
            chosairai.set調査員(dDBE2010030p.getTextBoxChosainMei().getValue());
            chosairai.set調査員コード(dDBE2010030p.getTextBoxChosain().getValue());
            chosairai.set調査機関(dDBE2010030p.getTextBoxIraisakiMei().getValue());
            chosairai.set調査回数(dDBE2010030p.getTextChosaKaisu().getValue());
            chosairai.set調査依頼区分(dDBE2010030p.getDDIraikubun().getSelectedValue());
            chosairai.set依頼年月日(dDBE2010030p.getTextBoxIraiYMD().getText());
            chosairai.set調査期限(dDBE2010030p.getTextBoxKigenYMD().getText());

//            dDBE2010030p.getTextBoxIraisaki().setValue(chosairai.get前回調査機関コード());
//            dDBE2010030p.getTextBoxIraisakiMei().setValue(chosairai.get前回調査機関());
        }
        dDBE2010020p.getDgNinteiChousaIraiGrid().setDataSource(list);
        response.data = dDBE2010020p;
        return response;
    }
}
