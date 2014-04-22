/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KetteijohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SofujohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKetteiHokenshaDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKetteiKohiDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSofuIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author N3317 塚田 萌
 */
public class Ketteijoho {

    final RString 過去 = new RString("20140201");
    final RString 最新 = new RString("20140401");

    public ResponseData<KetteijohoDiv> onLoad(KetteijohoDiv panel) {
        setDefault取扱年月(panel);
        set決定情報(panel);

        ResponseData<KetteijohoDiv> response = new ResponseData<>();
        response.data = panel;

        return response;
    }

    public ResponseData<KetteijohoDiv> onClick_btnSearch(KetteijohoDiv panel) {
//        set取扱年月(panel, 過去);
        set決定情報(panel);

        ResponseData<KetteijohoDiv> response = new ResponseData<>();
        response.data = panel;

        return response;
    }

    private void setDefault取扱年月(KetteijohoDiv panel) {
//            case 過去:
//                //日付に文字も入れられる→カレンダーがうまく動かない→年月の時はカレンダーを非表示にする？
//                panel.getTxtSofuYM().setValue(new RString("未送付"));
//                break;
        //TODO 最新の情報がある年月を取得・設定する。
        //TextBoxFlexibleDateに年月を入れると01日が勝手に付く。文字列比較をしたいので、日を付与。
        RString recentlyYearMonth = new RString("20140401");
        panel.getTxtToriatsukaiYM().setValue(recentlyYearMonth);
    }

    private void set決定情報(KetteijohoDiv panel) {
        int dataType;
        if (panel.getTxtToriatsukaiYM().getValue().equals(過去)) {
            dataType = 0;
        } else if (panel.getTxtToriatsukaiYM().getValue().equals(最新)) {
            dataType = 1;
        } else {
            dataType = 9;
        }
        set決定保険者情報(panel, dataType);
        set決定公費負担者情報(panel, dataType);
    }

    private void set決定保険者情報(KetteijohoDiv panel, int dataType) {
        if (dataType == 0 || dataType == 1) {
            panel.getKetteiHokensha().getTxtKetteiHokenshaSakuseiYMD().
                    setValue(panel.getTxtToriatsukaiYM().getValue());
        } else {
            panel.getKetteiHokensha().getTxtKetteiHokenshaSakuseiYMD().
                    setValue(new RString(""));
        }
        create決定保険者集計(panel, dataType);
        create決定保険者明細(panel);
    }

    private void set決定公費負担者情報(KetteijohoDiv panel, int dataType) {
        if (dataType == 0 || dataType == 1) {
            panel.getKetteiKohi().getTxtKetteiKohiSakuseiYMD().
                    setValue(panel.getTxtToriatsukaiYM().getValue());
        } else {
            panel.getKetteiKohi().getTxtKetteiKohiSakuseiYMD().
                    setValue(new RString(""));
        }
        create決定公費負担者集計(panel, dataType);
        create決定公費負担者明細(panel);
    }

    private void create決定保険者集計(KetteijohoDiv panel, int dataType) {
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell11().
                setValue(dataType == 0 ? new RString("-245") : (dataType == 1 ? new RString("0") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell12().
                setValue(dataType == 0 ? new RString("-528957") : (dataType == 1 ? new RString("0") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell13().
                setValue(dataType == 0 ? new RString("-4941623") : (dataType == 1 ? new RString("0") : new RString("")));

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell21().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-245") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell22().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-528957") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell23().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-4941623") : new RString("")));

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell31().
                setValue(dataType == 0 ? new RString("-1") : (dataType == 1 ? new RString("0") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell32().
                setValue(dataType == 0 ? new RString("-42780") : (dataType == 1 ? new RString("0") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell33().
                setValue(dataType == 0 ? new RString("-30690") : (dataType == 1 ? new RString("0") : new RString("")));

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell41().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-1") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell42().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-42780") : new RString("")));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell43().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-30690") : new RString("")));
    }

    private void create決定公費負担者集計(KetteijohoDiv panel, int dataType) {
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell11().
                setValue(dataType == 0 ? new RString("-15") : (dataType == 1 ? new RString("0") : new RString("")));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell12().
                setValue(dataType == 0 ? new RString("-69407") : (dataType == 1 ? new RString("0") : new RString("")));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell13().
                setValue(dataType == 0 ? new RString("-48588") : (dataType == 1 ? new RString("0") : new RString("")));

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell21().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-15") : new RString("")));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell22().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-15") : new RString("")));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell23().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-15") : new RString("")));

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell31().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-407") : new RString("")));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell32().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-69407") : new RString("")));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell33().
                setValue(dataType == 0 ? new RString("0") : (dataType == 1 ? new RString("-69407") : new RString("")));
    }

    private void create決定保険者明細(KetteijohoDiv panel) {
        List<dgKetteiHokenshaDetail_Row> list;

        //TODO 送付年月をキーにして該当情報を取得・設定する。
        list = create決定保険者明細List();
        list = get決定保険者明細By取扱年月(panel.getTxtToriatsukaiYM(), list);

        DataGrid<dgKetteiHokenshaDetail_Row> grid = panel.getKetteiHokensha().
                getKetteiHokenshaDetail().getDgKetteiHokenshaDetail();
        grid.setDataSource(list);
    }

    private void create決定公費負担者明細(KetteijohoDiv panel) {
        List<dgKetteiKohiDetail_Row> list;

        //TODO 送付年月をキーにして該当情報を取得・設定する。
        list = create決定公費負担者明細List();
        list = get決定公費負担者明細By取扱年月(panel.getTxtToriatsukaiYM(), list);

        DataGrid<dgKetteiKohiDetail_Row> grid = panel.getKetteiKohi().
                getKetteiKohiDetail().getDgKetteiKohiDetail();
        grid.setDataSource(list);
    }

    private List<dgKetteiHokenshaDetail_Row> get決定保険者明細By取扱年月(
            TextBoxFlexibleDate 取扱年月, List<dgKetteiHokenshaDetail_Row> list) {

        List<dgKetteiHokenshaDetail_Row> selectedList = new ArrayList<>();
        for (dgKetteiHokenshaDetail_Row row : list) {
            //デモでは取扱年月とサービス提供年月が一致したものを抽出する
            //TextBoxFlexibleDateに年月を入れると01日が勝手に付く。文字列比較をしたいので、日を付与。
            RString srt = row.getTxtHokenshaServiceTeikyoYM().getValue().concat("01");
            if (srt.equals(取扱年月.getValue())) {
                selectedList.add(row);
            }
        }
        return selectedList;
    }

    private List<dgKetteiKohiDetail_Row> get決定公費負担者明細By取扱年月(
            TextBoxFlexibleDate 取扱年月, List<dgKetteiKohiDetail_Row> list) {

        List<dgKetteiKohiDetail_Row> selectedList = new ArrayList<>();
        for (dgKetteiKohiDetail_Row row : list) {
            //デモでは取扱年月とサービス提供年月が一致したものを抽出する
            //TextBoxFlexibleDateに年月を入れると01日が勝手に付く。文字列比較をしたいので、日を付与。
            RString srt = row.getTxtKohiServiceTeikyoYM().getValue().concat("01");
            if (srt.equals(取扱年月.getValue())) {
                selectedList.add(row);
            }
        }
        return selectedList;
    }

    private List<dgKetteiHokenshaDetail_Row> create決定保険者明細List() {
        List<dgKetteiHokenshaDetail_Row> list = new ArrayList<>();
        dgKetteiHokenshaDetail_Row row;

        row = createRow保険者("0000000001", "ひまわり", "0000000011", "最新　一郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201404", "11:訪問介護", "300", "10000", "");
        list.add(row);

        row = createRow保険者("0000000001", "ひまわり", "0000000012", "最新　二郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201404", "11:訪問介護", "300", "10000", "");
        list.add(row);

        row = createRow保険者("0000000001", "ひまわり", "0000000013", "過去　一郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201402", "11:訪問介護", "300", "10000", "");
        list.add(row);

        row = createRow保険者("0000000001", "ひまわり", "0000000014", "過去　二郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201402", "11:訪問介護", "300", "10000", "");
        list.add(row);

        return list;
    }

    private List<dgKetteiKohiDetail_Row> create決定公費負担者明細List() {
        List<dgKetteiKohiDetail_Row> list = new ArrayList<>();
        dgKetteiKohiDetail_Row row;

        row = createRow公費負担者("0000000001", "ひまわり", "0000000011", "最新　一郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201404", "11:訪問介護", "300", "10000", "0000001", "00000001", "");
        list.add(row);

        row = createRow公費負担者("0000000001", "ひまわり", "0000000012", "最新　二郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201404", "11:訪問介護", "300", "10000", "0000001", "00000001", "");
        list.add(row);

        row = createRow公費負担者("0000000001", "ひまわり", "0000000013", "過去　一郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201402", "11:訪問介護", "300", "10000", "0000001", "00000001", "");
        list.add(row);

        row = createRow公費負担者("0000000001", "ひまわり", "0000000014", "過去　二郎",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201402", "11:訪問介護", "300", "10000", "0000001", "00000001", "");
        list.add(row);

        return list;
    }

    private dgKetteiHokenshaDetail_Row createRow保険者(String 事業者番号, String 事業者名,
            String 被保番号, String 氏名, String 様式, String 申立理由,
            String サービス提供年月, String サービス種類, String 単位数, String 負担額, String 証記載保険者番号) {

        dgKetteiHokenshaDetail_Row row = new dgKetteiHokenshaDetail_Row(
                new TextBoxCode(), new TextBox(), new TextBoxCode(), new TextBox(),
                new TextBox(), new TextBox(), new TextBoxFlexibleDate(), new TextBox(),
                new TextBoxNum(), new TextBoxNum(), new TextBoxCode());

        row.getTxtHokenshaJigyoshaNo().setValue(new RString(事業者番号));
        row.getTxtHokenshaJigyoshaName().setValue(new RString(事業者名));
        row.getTxtHokenshaHihoNo().setValue(new RString(被保番号));
        row.getTxtHokenshaHihoName().setValue(new RString(氏名));
        row.getTxtHokenshaStyle().setValue(new RString(様式));
        row.getTxtHokenshaMoshitateRiyu().setValue(new RString(申立理由));
        row.getTxtHokenshaServiceTeikyoYM().setValue(new RString(サービス提供年月));
        row.getTxtHokenshaServiceType().setValue(new RString(サービス種類));
        row.getTxtHokenshaTanisu().setValue(new RString(単位数));
        row.getTxtHokenshaFutangaku().setValue(new RString(負担額));
        row.getTxtHokenshaShokisaiHokenshaNo().setValue(new RString(証記載保険者番号));

        return row;
    }

    private dgKetteiKohiDetail_Row createRow公費負担者(String 事業者番号, String 事業者名,
            String 被保番号, String 氏名, String 様式, String 申立理由,
            String サービス提供年月, String サービス種類, String 単位数, String 負担額,
            String 公費受給者番号, String 公費負担者番号, String 証記載保険者番号) {

        dgKetteiKohiDetail_Row row = new dgKetteiKohiDetail_Row(
                new TextBoxCode(), new TextBox(), new TextBoxCode(), new TextBox(),
                new TextBox(), new TextBox(), new TextBoxFlexibleDate(), new TextBox(),
                new TextBoxNum(), new TextBoxNum(), new TextBoxCode(), new TextBoxCode(), new TextBoxCode());

        row.getTxtKohiJigyoshaNo().setValue(new RString(事業者番号));
        row.getTxtKohiJigyoshaName().setValue(new RString(事業者名));
        row.getTxtKohiHihoNo().setValue(new RString(被保番号));
        row.getTxtKohiHihoName().setValue(new RString(氏名));
        row.getTxtKohiStyle().setValue(new RString(様式));
        row.getTxtKohiMoshitateRiyu().setValue(new RString(申立理由));
        row.getTxtKohiServiceTeikyoYM().setValue(new RString(サービス提供年月));
        row.getTxtKohiServiceType().setValue(new RString(サービス種類));
        row.getTxtKohiTanisu().setValue(new RString(単位数));
        row.getTxtKohiFutangaku().setValue(new RString(負担額));
        row.getTxtKohiJukyushaNo().setValue(new RString(公費受給者番号));
        row.getTxtKohiFutanshaNo().setValue(new RString(公費負担者番号));
        row.getTxtHokenshaShokisaiHokenshaNo().setValue(new RString(証記載保険者番号));

        return row;
    }
}
