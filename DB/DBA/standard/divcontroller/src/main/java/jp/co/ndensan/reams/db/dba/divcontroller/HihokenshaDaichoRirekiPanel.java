/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaDaichoIdoRirekiGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaDaichoRirekiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 被保険者照会画面中部の、被保険者台帳の移動履歴をグリッドで表示するパネルです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoRirekiPanel {
    //TODO n8178 城間篤人 検索画面ができた後、そこから遷移するように修正予定。現在は決めうちでテストデータを用意している。 2014年5月

    /**
     * 被保険者台帳の履歴情報を表示するパネルに対して値を設定します。
     *
     * @param panel panel
     * @return response
     */
    public ResponseData<HihokenshaDaichoRirekiPanelDiv> getOnLoadDivData(HihokenshaDaichoRirekiPanelDiv panel) {
        ResponseData<HihokenshaDaichoRirekiPanelDiv> response = new ResponseData<>();

        DataGrid<HihokenshaDaichoIdoRirekiGrid_Row> grid = panel.getHihokenshaDaichoIdoRirekiGrid();
        grid.setDataSource(createIdoRirekiGridDataList());
        response.data = panel;
        System.out.println(response.data.getHihokenshaDaichoIdoRirekiGrid().getDataSource().get(0).getShutokuTodokedeYMD());
        return response;
    }

    /**
     * 被保台帳履歴情報グリッドに表示する情報を作成して返します。
     *
     * @return 被保台帳履歴情報グリッドのデータ
     */
    private List<HihokenshaDaichoIdoRirekiGrid_Row> createIdoRirekiGridDataList() {
        List<HihokenshaDaichoIdoRirekiGrid_Row> list = new ArrayList<>();
        HihokenshaDaichoIdoRirekiGrid_Row item;

        item = createIdoRirekiData("第1号", "年齢到達", "20120912", "20120912",
                "", "", "", "20120820",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "", "", "", "0000234123");
        list.add(item);
        item = createIdoRirekiData("第2号", "障害認定", "20090413", "20090420",
                "年齢到達", "20120912", "20120912", "",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "", "", "", "0000214563");
        list.add(item);
        item = createIdoRirekiData("第2号", "障害認定仮登録", "20090222", "20090223",
                "障害認定", "20090413", "20090420", "",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "", "", "", "0000200654");
        list.add(item);
        return list;
    }

    private HihokenshaDaichoIdoRirekiGrid_Row createIdoRirekiData(String 被保険者区分, String 取得事由, String 取得届出日, String 取得日,
            String 喪失事由, String 喪失届出日, String 喪失日, String 第1号被保険者年齢到達日, String 変更事由, String 変更届出日,
            String 変更日, String 住所地特例適応事由, String 適応届出日, String 適応日, String 住所地特例解除事由, String 解除届出日,
            String 解除日, String 広住特措置元市町村, String 旧市町村コード, String 再交付区分, String 再交付事由, String 帳票交付履歴ID) {
        HihokenshaDaichoIdoRirekiGrid_Row row = new HihokenshaDaichoIdoRirekiGrid_Row(RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setHihokenshaKubun(new RString(被保険者区分));
        row.setShutokuJiyu(new RString(取得事由));
        row.setShutokuTodokedeYMD(createDateString(取得届出日));
        row.setShutokuYMD(createDateString(取得日));
        row.setSoshitsuJiyu(new RString(喪失事由));
        row.setSoshitsuTodokedeYMD(createDateString(喪失届出日));
        row.setSoshitsuYMD(createDateString(喪失日));
        row.setIchigoHihokenshaNenreiTotatsuYMD(createDateString(第1号被保険者年齢到達日));
        row.setHenkoJiyu(new RString(変更事由));
        row.setHenkoTodokedeYMD(createDateString(変更届出日));
        row.setHenkoYMD(createDateString(変更日));
        row.setJushochitokureiTekioJiyu(new RString(住所地特例適応事由));
        row.setTekioTodokedeYMD(createDateString(適応届出日));
        row.setTekioYMD(createDateString(適応日));
        row.setJushochitokureiKaijoJiyu(new RString(住所地特例解除事由));
        row.setKaijoTodokedeYMD(createDateString(解除届出日));
        row.setKaijoYMD(createDateString(解除日));
        row.setKoikinaiTokureiSochimotoShichoson(new RString(広住特措置元市町村));
        row.setKyuShichosonCode(new RString(旧市町村コード));
        row.setSaikofuKubun(new RString(再交付区分));
        row.setSaikohuJiyu(new RString(再交付事由));
        row.setChohyoKofuRirekiID(new RString(帳票交付履歴ID));
        return row;
    }

    private RString createDateString(String str) {
        FlexibleDate ymd = new FlexibleDate(str);
        return createDateString(ymd);
    }

    private RString createDateString(FlexibleDate ymd) {
        Wareki wareki = ymd.wareki(DateRoundingType.同月の暦上日);
        wareki.separator(Separator.PERIOD);
        wareki.eraType(EraType.KANJI_RYAKU);
        return wareki.toDateString();
    }
}
