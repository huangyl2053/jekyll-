/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010050Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TPichiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIraisakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIraisumiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgMiIraiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 認定調査依頼（手動）を表示するパネルです。
 *
 * @author N8107 千秋雄
 */
public class DDBE2010050 {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param dDBE2010050p DDBE2010050Div
     * @return DDBE2010050DivのResponseData
     */
    public ResponseData getOnLoadData(DDBE2010050Div dDBE2010050p) {
        ResponseData response = new ResponseData<>();

        //TODO N8107 千秋雄 ＤＢから対象データの読込み、編集が必要。
        setIraisakiData(dDBE2010050p);

        dDBE2010050p.getTPichiran().getDdIraiKubun().setSelectedItem(new RString("初回"));
        RDate date = RDate.getNowDate();
        dDBE2010050p.getTPichiran().getTextBoxchosaIraiYMD().setValue(date);
        date = date.plusDay(7);
        dDBE2010050p.getTPichiran().getTextBoxchosaKigenYMD().setValue(date);
        setTedouData(dDBE2010050p);

        response.data = dDBE2010050p;
        return response;
    }

    /**
     * 依頼先を選択されたときの動作をセットします。
     *
     * @param dDBE2010050p DDBE2010050Div
     * @return SampleDDBE2010050DivのResponseData
     */
    public ResponseData onClickselectedIrai(DDBE2010050Div dDBE2010050p) {
        //TODO N8107 千秋雄 ＤＢから対象データの読込み、編集が必要。
        ResponseData response = new ResponseData<>();

        setChosainData(dDBE2010050p);
        setIraisumiData(dDBE2010050p);

        response.data = dDBE2010050p;
        return response;
    }

    /**
     * 調査依頼を割付けるときの動作をセットします。
     *
     * @param dDBE2010050p DDBE2010050Div
     * @return SampleDDBE2010050DivのResponseData
     */
    public ResponseData onclickWaritsuke(DDBE2010050Div dDBE2010050p) {

        ResponseData response = new ResponseData<>();

        List<dgIraisumiIchiran_Row> iraisumilist = dDBE2010050p.getTPichiran().getDgIraisumiIchiran().getDataSource();
        Button btn = new Button();

        List<dgMiIraiIchiran_Row> selectMiIrai = dDBE2010050p.getTPichiran().getDgMiIraiIchiran().getSelectedItems();

        for (dgMiIraiIchiran_Row miirai : selectMiIrai) {
            iraisumilist.add(createIraisumiIchiran("予定", btn, miirai.get保険者番号().toString(), miirai.get保険者().toString(), miirai.get支所().toString(), miirai.get支所コード().toString(),
                    miirai.get被保険者番号().toString(), miirai.get被保険者氏名().toString(), miirai.get住所().toString(), miirai.get認定申請日().toString(), miirai.get認定申請区分().toString(),
                    dDBE2010050p.getTPichiran().getDdIraiKubun().toString(), dDBE2010050p.getTPichiran().getTextBoxchosaIraiYMD().toString(), dDBE2010050p.getTPichiran().getTextBoxchosaKigenYMD().toString(),
                    dDBE2010050p.getTPichiran().getDgIraisakiIchiran().getClickedItem().get依頼先番号().toString(), dDBE2010050p.getTPichiran().getDgIraisakiIchiran().getClickedItem().get依頼先名().toString(),
                    dDBE2010050p.getTPichiran().getDgChosainIchiran().getClickedItem().get介護調査員番号().toString(), dDBE2010050p.getTPichiran().getDgChosainIchiran().getClickedItem().get調査員氏名().toString(),
                    miirai.get前回調査機関コード().toString(), miirai.get前回調査機関().toString(), miirai.get前回調査員コード().toString(), miirai.get前回調査員().toString(), "", ""));
        }
        dDBE2010050p.getTPichiran().getDgIraisumiIchiran().setDataSource(iraisumilist);
        response.data = dDBE2010050p;
        return response;
    }

    /**
     * 調査依頼を割付けるときの動作をセットします。
     *
     * @param dDBE2010050p DDBE2010050Div
     * @return SampleDDBE2010050DivのResponseData
     */
    public ResponseData onclickKaijo(DDBE2010050Div dDBE2010050p) {

        ResponseData response = new ResponseData<>();

        List<dgMiIraiIchiran_Row> miIrailist = dDBE2010050p.getTPichiran().getDgMiIraiIchiran().getDataSource();

        List<dgIraisumiIchiran_Row> selectIraisumi = dDBE2010050p.getTPichiran().getDgIraisumiIchiran().getSelectedItems();

        for (dgIraisumiIchiran_Row Iraisumi : selectIraisumi) {
            miIrailist.add(createMiIraiIchiran("予定", Iraisumi.get保険者番号().toString(), Iraisumi.get保険者().toString(), Iraisumi.get支所コード().toString(), Iraisumi.get支所().toString(),
                    Iraisumi.get被保険者番号().toString(), Iraisumi.get氏名().toString(), Iraisumi.get住所().toString(), "", "", Iraisumi.get認定申請日().toString(), Iraisumi.get認定申請区分().toString(),
                    "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        dDBE2010050p.getTPichiran().getDgMiIraiIchiran().setDataSource(miIrailist);
        response.data = dDBE2010050p;
        return response;
    }

    private dgMiIraiIchiran_Row createMiIraiIchiran(String 状況, String 保険者番号, String 保険者, String 支所コード, String 支所, String 被保険者番号, String 被保険者氏名,
            String 住所, String 性別, String 入所施設, String 認定申請日, String 認定申請区分, String 前回調査機関, String 前回調査機関コード, String 前回調査員, String 前回調査員コード,
            String 前々回調査機関, String 前々回調査機関コード, String 前々回調査員, String 前々回調査員コード, String 前々々回調査機関, String 前々々回調査機関コード, String 前々々回調査員, String 前々々回調査員コード,
            String 前々々々回調査機関, String 前々々々回調査機関コード, String 前々々々回調査員, String 前々々々回調査員コード, String 前々々々々回調査機関, String 前々々々々回調査機関コード, String 前々々々々回調査員, String 前々々々々回調査員コード,
            String 依頼書等発行年月日) {
        dgMiIraiIchiran_Row MiIraiData = new dgMiIraiIchiran_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        return MiIraiData;
    }

    private dgIraisumiIchiran_Row createIraisumiIchiran(String 状況, Button 詳細, String 保険者番号, String 保険者, String 支所, String 支所コード, String 被保険者番号, String 氏名, String 住所,
            String 認定申請日, String 認定申請区分, String 調査依頼区分, String 調査依頼日, String 調査期限, String 調査機関コード, String 調査機関, String 調査員コード, String 調査員,
            String 前回調査機関コード, String 前回調査機関, String 前回調査員コード, String 前回調査員, String 督促日, String 督促回数) {
        Button btn = new Button();
        dgIraisumiIchiran_Row IraisumiData = new dgIraisumiIchiran_Row(RString.EMPTY, btn, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        return IraisumiData;
    }

    /**
     * グリッド情報の初期値をセットします。
     *
     * @param dDBE2010050p DDBE2010050Div
     * @return DDBE2010050DivのResponseData
     */
    private void setTedouData(DDBE2010050Div dDBE2010050p) {

        List<dgMiIraiIchiran_Row> arraydata = createRowMiIraiIchiranTestData();
        DataGrid<dgMiIraiIchiran_Row> grid = dDBE2010050p.getTPichiran().getDgMiIraiIchiran();
        grid.setDataSource(arraydata);

    }

    private dgMiIraiIchiran_Row createRowNinteiMiiraiData(String 状況, String 保険者番号, String 保険者, String 支所コード, String 支所, String 被保険者番号, String 被保険者氏名,
            String 住所, String 性別, String 入所施設, String 認定申請日, String 認定申請区分, String 前回調査機関, String 前回調査機関コード, String 前回調査員, String 前回調査員コード,
            String 前々回調査機関, String 前々回調査機関コード, String 前々回調査員, String 前々回調査員コード, String 前々々回調査機関, String 前々々回調査機関コード, String 前々々回調査員, String 前々々回調査員コード,
            String 前々々々回調査機関, String 前々々々回調査機関コード, String 前々々々回調査員, String 前々々々回調査員コード, String 前々々々々回調査機関, String 前々々々々回調査機関コード, String 前々々々々回調査員, String 前々々々々回調査員コード,
            String 依頼書等発行年月日) {

        dgMiIraiIchiran_Row rowNinteiMiiraiData = new dgMiIraiIchiran_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowNinteiMiiraiData.set状況((new RString(状況)));
        rowNinteiMiiraiData.set保険者番号(new RString(保険者番号));
        rowNinteiMiiraiData.set保険者(new RString(保険者));
        rowNinteiMiiraiData.set支所(new RString(支所));
        rowNinteiMiiraiData.set支所コード(new RString(支所コード));
        rowNinteiMiiraiData.set被保険者番号(new RString(被保険者番号));
        rowNinteiMiiraiData.set被保険者氏名(new RString(被保険者氏名));
        rowNinteiMiiraiData.set住所(new RString(住所));
        rowNinteiMiiraiData.set性別(new RString(性別));
        rowNinteiMiiraiData.set入所施設(new RString(入所施設));
        rowNinteiMiiraiData.set依頼書等発行年月日(new RString(依頼書等発行年月日));
        rowNinteiMiiraiData.set認定申請日(new RString(認定申請日));
        rowNinteiMiiraiData.set認定申請区分(new RString(認定申請区分));
        rowNinteiMiiraiData.set前回調査機関コード(new RString(前回調査機関コード));
        rowNinteiMiiraiData.set前回調査機関(new RString(前回調査機関));
        rowNinteiMiiraiData.set前回調査員コード(new RString(前回調査員コード));
        rowNinteiMiiraiData.set前回調査員(new RString(前回調査員));
        rowNinteiMiiraiData.set前々回調査機関コード(new RString(前々回調査機関コード));
        rowNinteiMiiraiData.set前々回調査機関(new RString(前々回調査機関));
        rowNinteiMiiraiData.set前々回調査員コード(new RString(前々回調査員コード));
        rowNinteiMiiraiData.set前々回調査員(new RString(前々回調査員));
        rowNinteiMiiraiData.set前々々回調査機関コード(new RString(前々々回調査機関コード));
        rowNinteiMiiraiData.set前々々回調査機関(new RString(前々々回調査機関));
        rowNinteiMiiraiData.set前々々回調査員コード(new RString(前々々回調査員コード));
        rowNinteiMiiraiData.set前々々回調査員(new RString(前々々回調査員));
        rowNinteiMiiraiData.set前々々々回調査機関コード(new RString(前々々々回調査機関コード));
        rowNinteiMiiraiData.set前々々々回調査機関(new RString(前々々々回調査機関));
        rowNinteiMiiraiData.set前々々々回調査員コード(new RString(前々々々回調査員コード));
        rowNinteiMiiraiData.set前々々々回調査員(new RString(前々々々回調査員));
        rowNinteiMiiraiData.set前々々々々回調査機関コード(new RString(前々々々々回調査機関コード));
        rowNinteiMiiraiData.set前々々々々回調査機関(new RString(前々々々々回調査機関));
        rowNinteiMiiraiData.set前々々々々回調査員コード(new RString(前々々々々回調査員コード));
        rowNinteiMiiraiData.set前々々々々回調査員(new RString(前々々々々回調査員));
        rowNinteiMiiraiData.set依頼書等発行年月日(new RString(依頼書等発行年月日));

        return rowNinteiMiiraiData;
    }

    /**
     * グリッド情報のテストデータ
     *
     * @return dgNinteiChousaIraiGridのArrayList
     */
    private List<dgMiIraiIchiran_Row> createRowMiIraiIchiranTestData() {
        List<dgMiIraiIchiran_Row> arrayData = new ArrayList<>();
        dgMiIraiIchiran_Row item;

        //*市町村コード, 市町村名, 支所コード, 支所, 被保険者番号, 被保険者氏名,住所, 性別, 入所施設, 認定申請日, 認定申請区分,  前回調査機関, 前回調査機関コード, 前回調査員, 前回調査員コード, 前々回調査機関, 前々回調査機関コード, 前々回調査員, 前々回調査員コード, 前々々回調査機関, 前々々回調査機関コード, 前々々回調査員, 前々々回調査員コード, 前々々々回調査機関, 前々々々回調査機関コード, 前々々々回調査員, 前々々々回調査員コード, 前々々々々回調査機関, 前々々々々回調査機関コード, 前々々々々回調査員, 前々々々々回調査員コード, 依頼書等発行年月日
        item = createRowNinteiMiiraiData("", "666666", "電算市", "", "電算支所", "1000000001", "電算　太郎", "電算市電算町１－１", "男", "", "20140628", "01", "K111111111", "前回調査機関", "C0000000001", "前回調査員", "K111111112", "前々回調査機関", "C0000000002", "前々々回調査員", "K111111113", "前々々回調査機関", "C0000000003", "前々々回調査員", "K111111114", "前々々々回調査機関", "C0000000004", "前々々々回調査員", "K111111115", "前々々々々回調査機関", "C0000000004", "前々々々々回調査員", "20130606");
        arrayData.add(item);
        item = createRowNinteiMiiraiData("", "666666", "電算市", "", "電算支所", "1000000002", "電　算太郎", "電算市電算町１－２", "男", "", "20140628", "01", "K111111111", "前回調査機関", "C0000000001", "前回調査員", "K111111112", "前々回調査機関", "C0000000002", "前々々回調査員", "K111111113", "前々々回調査機関", "C0000000003", "前々々回調査員", "K111111114", "前々々々回調査機関", "C0000000004", "前々々々回調査員", "K111111115", "前々々々々回調査機関", "C0000000004", "前々々々々回調査員", "20130606");
        arrayData.add(item);
        item = createRowNinteiMiiraiData("", "666666", "電算市", "", "電算支所", "1000000003", "電算　浜子", "電算市電算町１－４", "女", "", "20140628", "01", "K111111111", "前回調査機関", "C0000000001", "前回調査員", "K111111112", "前々回調査機関", "C0000000002", "前々々回調査員", "K111111113", "前々々回調査機関", "C0000000003", "前々々回調査員", "K111111114", "前々々々回調査機関", "C0000000004", "前々々々回調査員", "K111111115", "前々々々々回調査機関", "C0000000004", "前々々々々回調査員", "20130606");
        arrayData.add(item);
        item = createRowNinteiMiiraiData("", "666666", "電算市", "", "電算支所", "1000000004", "電　太郎", "電算市電算町１－７", "男", "", "20140628", "01", "K111111111", "前回調査機関", "C0000000001", "前回調査員", "K111111112", "前々回調査機関", "C0000000002", "前々々回調査員", "K111111113", "前々々回調査機関", "C0000000003", "前々々回調査員", "K111111114", "前々々々回調査機関", "C0000000004", "前々々々回調査員", "K111111115", "前々々々々回調査機関", "C0000000004", "前々々々々回調査員", "20130606");
        arrayData.add(item);
        item = createRowNinteiMiiraiData("", "666666", "電算市", "", "電算支所", "1000000005", "算　太郎", "電算市電算町１－８", "男", "", "20140628", "01", "K111111111", "前回調査機関", "C0000000001", "前回調査員", "K111111112", "前々回調査機関", "C0000000002", "前々々回調査員", "K111111113", "前々々回調査機関", "C0000000003", "前々々回調査員", "K111111114", "前々々々回調査機関", "C0000000004", "前々々々回調査員", "K111111115", "前々々々々回調査機関", "C0000000004", "前々々々々回調査員", "20130606");
        arrayData.add(item);
        item = createRowNinteiMiiraiData("", "666666", "電算市", "", "電算支所", "1000000006", "電算　一太郎", "電算市電算町１－１０", "男", "電算施設", "20140628", "01", "K111111111", "前回調査機関", "C0000000001", "前回調査員", "K111111112", "前々回調査機関", "C0000000002", "前々々回調査員", "K111111113", "前々々回調査機関", "C0000000003", "前々々回調査員", "K111111114", "前々々々回調査機関", "C0000000004", "前々々々回調査員", "K111111115", "前々々々々回調査機関", "C0000000004", "前々々々々回調査員", "20130606");
        arrayData.add(item);
        item = createRowNinteiMiiraiData("", "666666", "電算市", "S0001", "電算支所", "1000000007", "電算　花子", "電算市電算町１－１５", "女", "", "20140628", "01", "K111111111", "前回調査機関", "C0000000001", "前回調査員", "K111111112", "前々回調査機関", "C0000000002", "前々々回調査員", "K111111113", "前々々回調査機関", "C0000000003", "前々々回調査員", "K111111114", "前々々々回調査機関", "C0000000004", "前々々々回調査員", "K111111115", "前々々々々回調査機関", "C0000000004", "前々々々々回調査員", "20130606");
        arrayData.add(item);

        return arrayData;
    }

    /**
     * 依頼済情報をセットします。
     *
     * @param dDBE2010050p DDBE2010050Div
     * @return DDBE2010050DivのResponseData
     */
    private void setIraisumiData(DDBE2010050Div dDBE2010050p) {

        List<dgIraisumiIchiran_Row> arraydata = createRowIraisumiIchiranTestData();
        DataGrid<dgIraisumiIchiran_Row> grid = dDBE2010050p.getTPichiran().getDgIraisumiIchiran();
        grid.setDataSource(arraydata);

    }

    private dgIraisumiIchiran_Row createRowNinteiIraisumiData(String 状況, Button 詳細, String 保険者番号, String 保険者, String 支所, String 支所コード, String 被保険者番号, String 氏名, String 住所,
            String 認定申請日, String 認定申請区分, String 調査依頼区分, String 調査依頼日, String 調査期限, String 調査機関コード, String 調査機関, String 調査員コード, String 調査員,
            String 前回調査機関コード, String 前回調査機関, String 前回調査員コード, String 前回調査員, String 督促日, String 督促回数) {

        Button btn = new Button();
        dgIraisumiIchiran_Row rowNinteiIraisumiData = new dgIraisumiIchiran_Row(RString.EMPTY, btn, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowNinteiIraisumiData.set状況((new RString(状況)));
        rowNinteiIraisumiData.set保険者番号((new RString(保険者番号)));
        rowNinteiIraisumiData.set保険者((new RString(保険者)));
        rowNinteiIraisumiData.set支所(new RString(支所));
        rowNinteiIraisumiData.set支所コード(new RString(支所コード));
        rowNinteiIraisumiData.set被保険者番号(new RString(被保険者番号));
        rowNinteiIraisumiData.set氏名(new RString(氏名));
        rowNinteiIraisumiData.set住所(new RString(住所));
        rowNinteiIraisumiData.set認定申請日(new RString(認定申請日));
        rowNinteiIraisumiData.set認定申請区分(new RString(認定申請区分));
        rowNinteiIraisumiData.set調査依頼区分(new RString(調査依頼区分));
        rowNinteiIraisumiData.set調査依頼日(new RString(調査依頼日));
        rowNinteiIraisumiData.set調査期限(new RString(調査期限));
        rowNinteiIraisumiData.set調査機関コード(new RString(調査機関コード));
        rowNinteiIraisumiData.set調査機関(new RString(調査機関));
        rowNinteiIraisumiData.set調査員コード(new RString(調査員コード));
        rowNinteiIraisumiData.set調査員(new RString(調査員));
        rowNinteiIraisumiData.set前回調査機関コード(new RString(前回調査機関コード));
        rowNinteiIraisumiData.set前回調査機関(new RString(前回調査機関));
        rowNinteiIraisumiData.set前回調査員コード(new RString(前回調査員コード));
        rowNinteiIraisumiData.set前回調査員(new RString(前回調査員));
        rowNinteiIraisumiData.set督促日(new RString(督促日));
        rowNinteiIraisumiData.set督促回数(new RString(督促回数));
        return rowNinteiIraisumiData;
    }

    /**
     * グリッド情報のテストデータ
     *
     * @return dgNinteiChousaIraiGridのArrayList
     */
    private List<dgIraisumiIchiran_Row> createRowIraisumiIchiranTestData() {
        List<dgIraisumiIchiran_Row> arrayData = new ArrayList<>();
        dgIraisumiIchiran_Row item;
        Button btn = new Button();
        //*状況, 詳細, 市町村コード, 市町村名, 支所, 支所コード, 被保険者番号, 氏名, 住所, 認定申請日, 認定申請区分, 調査依頼区分, 調査依頼日, 調査期限, 調査機関コード, 調査機関, 調査員コード, 調査員, 前回調査機関コード, 前回調査機関, 前回調査員コード, 前回調査員, 督促日, 督促回数
        item = createRowNinteiIraisumiData("依頼済", btn, "666666", "電算市", "電算支所", "", "1000000011", "電算　一太郎", "電算市電算町１１－１", "20140428", "01", "01", "20140501", "20140510", "K111111111", "調査機関", "C0000000001", "調査員", "K111111111", "前回調査機関", "C0000000002", "前回調査員", "", "0");
        arrayData.add(item);
        item = createRowNinteiIraisumiData("依頼済", btn, "666666", "電算市", "電算支所", "", "1000000011", "電算　二太郎", "電算市電算町１２－１", "20140428", "01", "01", "20140501", "20140510", "K111111111", "調査機関", "C0000000001", "調査員", "K111111111", "前回調査機関", "C0000000002", "前回調査員", "", "0");
        arrayData.add(item);
        item = createRowNinteiIraisumiData("依頼済", btn, "666666", "電算市", "電算支所", "", "1000000011", "電算　三太郎", "電算市電算町１３－１", "20140428", "01", "01", "20140501", "20140510", "K111111111", "調査機関", "C0000000001", "調査員", "K111111111", "前回調査機関", "C0000000002", "前回調査員", "", "0");
        arrayData.add(item);

        return arrayData;
    }

    /**
     * グリッド情報の初期値をセットします。
     *
     * @param dDBE2010050p SampleDDBE2010060Div
     * @return SampleDDBE2010050DivのResponseData
     */
    private void setIraisakiData(DDBE2010050Div dDBE2010050p) {

        List<dgIraisakiIchiran_Row> arraydata = createRowIraisakiIchiranTestData();
        DataGrid<dgIraisakiIchiran_Row> grid = dDBE2010050p.getTPichiran().getDgIraisakiIchiran();
        grid.setDataSource(arraydata);
    }

    private dgIraisakiIchiran_Row createRowIraisakiData(String 依頼先番号, String 依頼先名, String 割付定員, String 割付済人数, String 割付地区) {

        dgIraisakiIchiran_Row rowIraisakiData = new dgIraisakiIchiran_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        rowIraisakiData.set依頼先番号((new RString(依頼先番号)));
        rowIraisakiData.set依頼先名((new RString(依頼先名)));
        rowIraisakiData.set割付定員(new RString(割付定員));
        rowIraisakiData.set割付済人数(new RString(割付済人数));
        rowIraisakiData.set割付地区(new RString(割付地区));

        return rowIraisakiData;
    }

    /**
     * グリッド情報のテストデータ
     *
     * @return dgNinteiChousaIraiGridのArrayList
     */
    private List<dgIraisakiIchiran_Row> createRowIraisakiIchiranTestData() {
        List<dgIraisakiIchiran_Row> arrayData = new ArrayList<>();
        dgIraisakiIchiran_Row item;

        //*依頼先番号, 依頼先名, 割付定員, 割付済人数, 割付地区
        item = createRowIraisakiData("K1111111111", "調査事業者１", "100", "50", "");
        arrayData.add(item);
        item = createRowIraisakiData("K1111111112", "調査事業者２", "50", "0", "");
        arrayData.add(item);
        item = createRowIraisakiData("K1111111113", "調査事業者３", "77", "0", "");
        arrayData.add(item);
        item = createRowIraisakiData("K1111111114", "調査事業者４", "88", "0", "");
        arrayData.add(item);
        item = createRowIraisakiData("K1111111115", "調査事業者５", "10", "0", "");
        arrayData.add(item);
        item = createRowIraisakiData("K1111111116", "調査事業者６", "25", "0", "");
        arrayData.add(item);
        item = createRowIraisakiData("K1111111117", "調査事業者７", "30", "0", "");
        arrayData.add(item);

        return arrayData;
    }

    private void setChosainData(DDBE2010050Div dDBE2010050p) {

        List<dgChosainIchiran_Row> arraydata = createRowChosainIchiranTestData(dDBE2010050p);
        DataGrid<dgChosainIchiran_Row> grid = dDBE2010050p.getTPichiran().getDgChosainIchiran();
        dgIraisakiIchiran_Row selectIraisaki = dDBE2010050p.getTPichiran().getDgIraisakiIchiran().getClickedItem();
        grid.setDataSource(arraydata);
    }

    private dgChosainIchiran_Row createRowChosainData(String 介護調査員番号, String 調査員氏名, String 割付済人数, String 地区コード, String 地区) {

        dgChosainIchiran_Row rowChosainData = new dgChosainIchiran_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        rowChosainData.set介護調査員番号(new RString(介護調査員番号));
        rowChosainData.set調査員氏名(new RString(調査員氏名));
        rowChosainData.set割付済人数(new RString(割付済人数));
        rowChosainData.set地区コード(new RString(地区コード));
        rowChosainData.set地区(new RString(地区));

        return rowChosainData;
    }

    /**
     * グリッド情報のテストデータ
     *
     * @return dgNinteiChousaIraiGridのArrayList
     */
    private List<dgChosainIchiran_Row> createRowChosainIchiranTestData(DDBE2010050Div dDBE2010050p) {
        List<dgChosainIchiran_Row> arrayData = new ArrayList<>();
        dgChosainIchiran_Row item;

        //*依頼先番号, 依頼先名, 割付定員, 割付済人数, 割付地区
        item = createRowChosainData("C1111111111", "調査員１", "1", "A", "電算Ａ");
        arrayData.add(item);
        item = createRowChosainData("C1111111112", "調査員２", "0", "B", "電算Ｂ");
        arrayData.add(item);
        item = createRowChosainData("C1111111113", "調査員３", "0", "C", "電算Ｃ");
        arrayData.add(item);
        item = createRowChosainData("C1111111114", "調査員４", "0", "D", "電算Ｄ");
        arrayData.add(item);
        item = createRowChosainData("C1111111115", "調査員５", "1", "E", "電算Ｅ");
        arrayData.add(item);
        item = createRowChosainData("C1111111116", "調査員６", "0", "F", "電算Ｆ");
        arrayData.add(item);
        item = createRowChosainData("C1111111117", "調査員７", "0", "G", "電算Ｇ");
        arrayData.add(item);

        return arrayData;
    }
}
