/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010020Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteiChousaIraiGrid_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 認定調査依頼対象者を一覧および指示ボタンを表示するパネルです。
 *
 * @author N8107 千秋雄
 */
public class DDBE2010020 {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param dDBE2010020p DDBE2010020Div
     * @return DDBE2010020DivのResponseData
     */
    public ResponseData<DDBE2010020Div> getOnLoadData(DDBE2010020Div dDBE2010020p) {
        ResponseData<DDBE2010020Div> response = new ResponseData<>();

        //TODO N8107 千秋雄 ＤＢから対象データの読込み、編集が必要。
        setNinteiIraiData(dDBE2010020p);

        response.data = dDBE2010020p;

        return response;
    }

    /**
     * グリッド情報の初期値をセットします。
     *
     * @param dDBE2010020p DDBE2010020Div
     * @return dgNinteiChousaIraiGrid_RowのrowNinteiIraiData
     */
    private void setNinteiIraiData(DDBE2010020Div dDBE2010020p) {

        List<dgNinteiChousaIraiGrid_Row> arraydata = createRowNinteiIraiTestData();
        DataGrid<dgNinteiChousaIraiGrid_Row> grid = dDBE2010020p.getDgNinteiChousaIraiGrid();
        grid.setDataSource(arraydata);
    }

    private dgNinteiChousaIraiGrid_Row createRowNinteiIraiData(String 依頼年月日, String 依頼書等発行年月日, String 依頼完了年月日, String 市町村コード, String 市町村名,
            String 被保険者番号, String 被保険者氏名, String 住所, String 支所, String 支所コード, String 入所施設, String 認定申請日, String 認定申請申請時区分,
            String 申請書管理番号, String 調査依頼区分, String 調査回数, String 認定調査履歴番号, String 調査期限, String 調査機関コード, String 調査機関,
            String 調査員コード, String 調査員, String 前回調査機関コード, String 前回調査機関, String 前回調査員コード, String 前回調査員, String 審査会開催地区コード, String 審査会開催地区,
            String 督促年月日, String 督促回数, String 督促期限, String 督促発行日, String データ出力有無) {

        dgNinteiChousaIraiGrid_Row rowNinteiIraiData = new dgNinteiChousaIraiGrid_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.FULL_SPACE, RString.EMPTY, RString.FULL_SPACE, RString.FULL_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowNinteiIraiData.set依頼年月日(new RString(依頼年月日));
        rowNinteiIraiData.set依頼書等発行年月日(new RString(依頼書等発行年月日));
        rowNinteiIraiData.set依頼完了年月日(new RString(依頼完了年月日));
        rowNinteiIraiData.set市町村コード(new RString(市町村コード));
        rowNinteiIraiData.set市町村名(new RString(市町村名));
        rowNinteiIraiData.set被保険者番号(new RString(被保険者番号));
        rowNinteiIraiData.set被保険者氏名(new RString(被保険者氏名));
        rowNinteiIraiData.set住所(new RString(住所));
        rowNinteiIraiData.set支所(new RString(支所));
        rowNinteiIraiData.set支所コード(new RString(支所コード));
        rowNinteiIraiData.set入所施設(new RString(入所施設));
        rowNinteiIraiData.set認定申請日(new RString(認定申請日));
        rowNinteiIraiData.set申請書管理番号(new RString(申請書管理番号));
        rowNinteiIraiData.set調査依頼区分(new RString(調査依頼区分));
        rowNinteiIraiData.set調査回数(new RString(調査回数));
        rowNinteiIraiData.set認定調査履歴番号(new RString(認定調査履歴番号));
        rowNinteiIraiData.set調査期限(new RString(調査期限));
        rowNinteiIraiData.set調査機関コード(new RString(調査機関コード));
        rowNinteiIraiData.set調査機関(new RString(調査機関));
        rowNinteiIraiData.set調査員コード(new RString(調査員コード));
        rowNinteiIraiData.set調査員(new RString(調査員));
        rowNinteiIraiData.set前回調査機関コード(new RString(前回調査機関コード));
        rowNinteiIraiData.set前回調査機関(new RString(前回調査機関));
        rowNinteiIraiData.set前回調査員コード(new RString(前回調査員コード));
        rowNinteiIraiData.set前回調査員(new RString(前回調査員));
        rowNinteiIraiData.set審査会開催地区コード(new RString(審査会開催地区コード));
        rowNinteiIraiData.set審査会開催地区(new RString(審査会開催地区));
        rowNinteiIraiData.set督促年月日(new RString(督促年月日));
        rowNinteiIraiData.set督促回数(new RString(督促回数));
        rowNinteiIraiData.set督促期限(new RString(督促期限));
        rowNinteiIraiData.set督促発行日(new RString(督促発行日));
        rowNinteiIraiData.setデータ出力有無(new RString(データ出力有無));

        return rowNinteiIraiData;
    }

    /**
     * グリッド情報のテストデータ
     *
     * @return dgNinteiChousaIraiGridのArrayList
     */
    private List<dgNinteiChousaIraiGrid_Row> createRowNinteiIraiTestData() {
        List<dgNinteiChousaIraiGrid_Row> arrayData = new ArrayList<>();
        dgNinteiChousaIraiGrid_Row item;

        //*依頼年月日, 依頼書等発行年月日, 依頼完了年月日, 市町村コード, 市町村名,被保険者番号, 被保険者氏名, 住所, 支所, 支所コード, 入所施設, 認定申請日, 認定申請申請時区分,申請書管理番号,調査依頼区分,調査回数,認定調査履歴番号,調査機関コード,調査機関,調査員コード,調査員,前回調査機関コード,前回調査機関,前回調査員コード,前回調査員,審査会開催地区コード,審査会開催地区,督促年月日,督促回数,督促期限,督促発行日,データ出力有無
        item = createRowNinteiIraiData("", "", "", "666666", "電算市", "1000000001", "電算　太郎", "電算市電算町１－１", "", "", "", "20140628", "01", "S111111111", "", "", "", "", "", "", "", "", "K111111111", "電算市", "C111111112", "電算市調査員２", "", "", "", "", "", "", "未出力");
        arrayData.add(item);
        item = createRowNinteiIraiData("", "", "", "666666", "電算市", "1000000002", "電　算太郎", "電算市電算町１－２", "", "", "", "20140628", "01", "S111111111", "", "", "", "", "", "", "", "", "K111111111", "電算市", "C111111112", "電算市調査員２", "", "", "", "", "", "", "未出力");
        arrayData.add(item);
        item = createRowNinteiIraiData("", "", "", "666666", "電算市", "1000000003", "電算　浜子", "電算市電算町１－４", "", "", "", "20140628", "01", "S111111111", "", "", "", "", "", "", "", "", "K111111111", "電算市", "C111111112", "電算市調査員２", "", "", "", "", "", "", "未出力");
        arrayData.add(item);
        item = createRowNinteiIraiData("", "", "", "666666", "電算市", "1000000004", "電　太郎", "電算市電算町１－７", "", "", "", "20140628", "01", "S111111111", "", "", "", "", "", "", "", "", "K111111111", "電算市", "C111111112", "電算市調査員２", "", "", "", "", "", "", "未出力");
        arrayData.add(item);
        item = createRowNinteiIraiData("", "", "", "666666", "電算市", "1000000005", "算　太郎", "電算市電算町１－８", "", "", "", "20140628", "01", "S111111111", "", "", "", "", "", "", "", "", "K111111111", "電算市", "C111111112", "電算市調査員２", "", "", "", "", "", "", "未出力");
        arrayData.add(item);
        item = createRowNinteiIraiData("", "", "", "666666", "電算市", "1000000006", "電算　一太郎", "電算市電算町１－１０", "", "", "電算施設", "20140628", "01", "S111111111", "", "", "", "", "", "", "", "", "K111111111", "電算市", "C111111112", "電算市調査員２", "", "", "", "", "", "", "未出力");
        arrayData.add(item);
        item = createRowNinteiIraiData("", "", "", "666666", "電算市", "1000000007", "電算　花子", "電算市電算町１－１５", "電算支所", "55555", "", "20140628", "01", "S111111111", "", "", "", "", "", "", "", "", "H111111112", "施設Ａ", "D111111112", "施設調査員１", "", "", "", "", "", "", "未出力");
        arrayData.add(item);

        return arrayData;
    }
}
