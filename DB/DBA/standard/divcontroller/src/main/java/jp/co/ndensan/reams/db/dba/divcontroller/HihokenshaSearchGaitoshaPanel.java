/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;

/**
 * 検索条件に該当した被保険者をグリッドで表示するパネルです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaSearchGaitoshaPanel {
    //TODO n8178 城間篤人 検索画面ができた後、そこから遷移するように修正予定。現在は決めうちでテストデータを用意している。 2014年5月

    /**
     * Panelに表示される情報に対して値を設定します。
     *
     * @param gaitoshaPanel gaitoshaPanel
     * @param searchPanel searchPanel
     * @return response
     */
    public ResponseData<HihokenshaSearchGaitoshaPanelDiv> getOnLoadDivData(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel,
            HihokenshaSearchPanelDiv searchPanel) {
        ResponseData<HihokenshaSearchGaitoshaPanelDiv> response = new ResponseData<>();

        setHihokienshaSearchGaitoshaGrid(gaitoshaPanel.getDgHihokenshaSearchGaitosha(), searchPanel);
        gaitoshaPanel.setIsOpen(true);
        response.data = gaitoshaPanel;

        return response;
    }

    /**
     * 検索パネルの入力を元に、使用するテストデータを選択し、グリッドに設定します。
     *
     * @param hihokenshaSearchGaitoshaGrid 設定するグリッド
     * @param searchPanel 検索パネル
     */
    private void setHihokienshaSearchGaitoshaGrid(DataGrid<dgHihokenshaSearchGaitosha_Row> hihokenshaSearchGaitoshaGrid,
            HihokenshaSearchPanelDiv searchPanel) {
        DropDownList dropDown = searchPanel.getMaeShorishaRirekiPanel().getDdlMaeShorishaRireki();

        if (dropDown.getSelectedItem().equals(new RString("noData")) || dropDown.getSelectedValue().isEmpty()) {
            hihokenshaSearchGaitoshaGrid.setDataSource(createHihokenshaSearchHukusuGaitosha());
        } else {
            hihokenshaSearchGaitoshaGrid.setDataSource(createHihokenshaSearchGaitosha());
        }
    }

    /**
     * 検索にヒットした該当者が1件だった場合のテストデータを生成します。
     *
     * @return 該当者リスト(1件)
     */
    private List<dgHihokenshaSearchGaitosha_Row> createHihokenshaSearchGaitosha() {
        List<dgHihokenshaSearchGaitosha_Row> list = new ArrayList<>();
        dgHihokenshaSearchGaitosha_Row item;

        item = createHihokenshaSearchGaitoshaData("0000011111", "喜屋武三郎", "19380623", "75",
                "男", "電算市南風原1-12-45", "000001019011009", "キャンサブロウ", "311", "電算", "電算介護組合",
                "000001011100234", "00010123459", "098-123-4567", "098-987-6543", "要介護度3", "19701212", "",
                "0000010091", "302011", "電算町");
        list.add(item);

        return list;
    }

    /**
     * 検索にヒットした該当者が複数いた場合のテストデータを生成します。
     *
     * @return 該当者リスト(2件)
     */
    private List<dgHihokenshaSearchGaitosha_Row> createHihokenshaSearchHukusuGaitosha() {
        List<dgHihokenshaSearchGaitosha_Row> list = new ArrayList<>();
        dgHihokenshaSearchGaitosha_Row item;

        item = createHihokenshaSearchGaitoshaData("0000022222", "電算太郎", "19480101", "66",
                "男", "電算市稲葉2201-1", "000001019012345", "デンサンタロウ", "312", "電算", "電算介護組合",
                "000001011100256", "00010140019", "080-1111-2222", "098-456-7686", "要介護度2", "19800808", "",
                "0000020092", "302011", "電算町");
        list.add(item);
        item = createHihokenshaSearchGaitoshaData("0000033333", "山本九十九子", "19650212", "49",
                "女", "電算市出雲12-3-1", "000001019012654", "ヤマモトツクモコ", "313", "電算", "電算介護組合",
                "000001011100278", "00010182019", "080-2222-3333", "080-5555-6666", "要支援1", "19940202", "19960108",
                "0000020092", "302011", "電算町");
        list.add(item);

        return list;
    }

    private dgHihokenshaSearchGaitosha_Row createHihokenshaSearchGaitoshaData(String 被保険者番号, String 氏名, String 生年月日, String 年齢,
            String 性別, String 住所, String 識別コード, String フリガナ, String 住所コード, String 行政区, String 組合, String 世帯コード,
            String 住民票コード, String 連絡先1, String 連絡先2, String 要介護度, String 認定期間開始, String 認定期間終了, String 旧被保険者番号, String 旧市町村コード, String 旧市町村) {
        dgHihokenshaSearchGaitosha_Row row = new dgHihokenshaSearchGaitosha_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setHihokenshaNo(new RString(被保険者番号));
        row.setShimei(new RString(氏名));
        row.setDateOfBirth(createDateString(生年月日));
        row.setAge(new RString(年齢));
        row.setGender(new RString(性別));
        row.setJusho(new RString(住所));
        row.setShikibetsuCode(new RString(識別コード));
        row.setHurikana(new RString(フリガナ));
        row.setJushoCode(new RString(住所コード));
        row.setGyoseiku(new RString(行政区));
        row.setKumiai(new RString(組合));
        row.setSetaiCode(new RString(世帯コード));
        row.setJuminhyoCode(new RString(住民票コード));
        row.setRenrakusaki1(new RString(連絡先1));
        row.setRenrakusaki2(new RString(連絡先2));
        row.setYokaigodo(new RString(要介護度));
        row.setNinteiKikanKaishi(new RString(認定期間開始));
        row.setNinteiKikanShuryo(new RString(認定期間終了));
        row.setKyuHihokenshaNo(new RString(旧被保険者番号));
        row.setKyuShichosonCode(new RString(旧市町村コード));
        row.setKyuShichoson(new RString(旧市町村));
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
