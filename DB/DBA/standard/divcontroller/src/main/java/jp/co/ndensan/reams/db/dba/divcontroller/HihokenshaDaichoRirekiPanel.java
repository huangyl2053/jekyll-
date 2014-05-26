/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgHihokenshaDaichoIdoRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaDaichoRirekiPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaPanelDiv;
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
     * @param daichoRirekiPanel 被保険者台帳履歴パネル
     * @param gaitoshaPanel 被保険者検索該当者パネル
     * @return response
     */
    public ResponseData<HihokenshaDaichoRirekiPanelDiv> getOnLoadDivData(HihokenshaDaichoRirekiPanelDiv daichoRirekiPanel, HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        ResponseData<HihokenshaDaichoRirekiPanelDiv> response = new ResponseData<>();

        DataGrid<dgHihokenshaDaichoIdoRireki_Row> grid = daichoRirekiPanel.getDgHihokenshaDaichoIdoRireki();
        RString 氏名 = get該当者情報(gaitoshaPanel).getShimei();

        set非表示カラム(grid);
        grid.setDataSource(createIdoRirekiGridDataList(氏名));

        response.data = daichoRirekiPanel;
        return response;
    }

    /**
     * システムを導入した市町村に対応して、非表示にするカラムを設定します。
     * デモを行う南魚沼市は合併市町村であり、広域連合では無いため、広域に関する情報が表示されず、旧市町村の情報が表示される。
     * 実際は、システムから市町村情報を取得して、その情報を元に判定を行う。
     *
     * @param grid grid
     */
    private void set非表示カラム(DataGrid<dgHihokenshaDaichoIdoRireki_Row> grid) {
        if (is広域()) {
            grid.getGridSetting().getColumn("kyuHokensha").setVisible(false);
        }
        if (is合併市町村()) {
            grid.getGridSetting().getColumn("koikinaiTokureiSochimotoHokensha").setVisible(false);
        }
    }

    private boolean is広域() {
        return false;
    }

    private boolean is合併市町村() {
        return true;
    }

    /**
     * 被保台帳履歴情報グリッドに表示する情報を作成して返します。
     *
     * @return 被保台帳履歴情報グリッドのデータ
     */
    private List<dgHihokenshaDaichoIdoRireki_Row> createIdoRirekiGridDataList(RString 氏名) {
        List<dgHihokenshaDaichoIdoRireki_Row> list;

        if (氏名.equals(new RString("電算太郎"))) {
            list = create電算Data();
        } else if (氏名.equals(new RString("山本九十九子"))) {
            list = create山本Data();
        } else {
            list = create喜屋武Data();
        }

        return list;
    }

    private List<dgHihokenshaDaichoIdoRireki_Row> create電算Data() {
        List<dgHihokenshaDaichoIdoRireki_Row> list = new ArrayList<>();
        dgHihokenshaDaichoIdoRireki_Row item;

        item = createIdoRirekiData("第2号", "年齢到達", "20130602", "20130602",
                "", "", "", "20120820",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "電算町", "", "", "0000234123");
        list.add(item);
        item = createIdoRirekiData("第2号", "障害認定", "20090413", "20090420",
                "年齢到達", "20130602", "20130602", "",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "電算町", "", "", "0000214563");
        list.add(item);
        return list;
    }

    private List<dgHihokenshaDaichoIdoRireki_Row> create山本Data() {
        List<dgHihokenshaDaichoIdoRireki_Row> list = new ArrayList<>();
        dgHihokenshaDaichoIdoRireki_Row item;

        item = createIdoRirekiData("第2号", "障害認定", "20070109", "20070110",
                "", "", "", "20120820",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "電算町", "", "", "0000234123");
        list.add(item);
        return list;
    }

    private List<dgHihokenshaDaichoIdoRireki_Row> create喜屋武Data() {
        List<dgHihokenshaDaichoIdoRireki_Row> list = new ArrayList<>();
        dgHihokenshaDaichoIdoRireki_Row item;

        item = createIdoRirekiData("第1号", "年齢到達", "20120912", "20120912",
                "", "", "", "20120820",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "電算町", "", "", "0000234123");
        list.add(item);
        item = createIdoRirekiData("第2号", "障害認定", "20090413", "20090420",
                "年齢到達", "20120912", "20120912", "",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "電算町", "", "", "0000214563");
        list.add(item);
        item = createIdoRirekiData("第2号", "障害認定仮登録", "20090222", "20090223",
                "障害認定", "20090413", "20090420", "",
                "", "", "",
                "", "", "",
                "", "", "",
                "", "電算町", "", "", "0000200654");
        list.add(item);
        return list;
    }

    private dgHihokenshaDaichoIdoRireki_Row createIdoRirekiData(String 被保険者区分, String 取得事由, String 取得届出日, String 取得日,
            String 喪失事由, String 喪失届出日, String 喪失日, String 第1号被保険者年齢到達日, String 変更事由, String 変更届出日,
            String 変更日, String 住所地特例適用事由, String 適用届出日, String 適用日, String 住所地特例解除事由, String 解除届出日,
            String 解除日, String 広住特措置元保険者, String 旧保険者, String 再交付区分, String 再交付事由, String 帳票交付履歴ID) {
        dgHihokenshaDaichoIdoRireki_Row row = new dgHihokenshaDaichoIdoRireki_Row(RString.EMPTY, RString.EMPTY,
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
        row.setJushochitokureiTekiyoJiyu(new RString(住所地特例適用事由));
        row.setTekiyoTodokedeYMD(createDateString(適用届出日));
        row.setTekiyoYMD(createDateString(適用日));
        row.setJushochitokureiKaijoJiyu(new RString(住所地特例解除事由));
        row.setKaijoTodokedeYMD(createDateString(解除届出日));
        row.setKaijoYMD(createDateString(解除日));
        row.setKoikinaiTokureiSochimotoHokensha(new RString(広住特措置元保険者));
        row.setKyuHokensha(new RString(旧保険者));
        row.setSaikofuKubun(new RString(再交付区分));
        row.setSaikohuJiyu(new RString(再交付事由));
        row.setChohyoKofuRirekiID(new RString(帳票交付履歴ID));

        return row;
    }

    private dgHihokenshaSearchGaitosha_Row get該当者情報(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        dgHihokenshaSearchGaitosha_Row gaitoshaGrid;
        if (check未選択(gaitoshaPanel)) {
            gaitoshaGrid = gaitoshaPanel.getDgHihokenshaSearchGaitosha().getDataSource().get(0);
        } else {
            gaitoshaGrid = gaitoshaPanel.getDgHihokenshaSearchGaitosha().getSelectedItems().get(0);
        }
        return gaitoshaGrid;
    }

    private boolean check未選択(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        return gaitoshaPanel.getDgHihokenshaSearchGaitosha().getSelectedItems().isEmpty();
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
