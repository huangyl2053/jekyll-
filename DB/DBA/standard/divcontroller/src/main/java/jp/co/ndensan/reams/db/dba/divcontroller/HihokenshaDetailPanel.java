/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaDetailPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaDetailTabDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.IryoHokenGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.RoreiFukushiGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SeikatsuHogoGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SetaiShokaiGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShinseishoTodokedeGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShisetsuNyutaishoGrid_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;

/**
 * 被保険者照会画面下部の、被保険者に関連する詳細な情報を表示するパネルです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDetailPanel {
    //TODO n8178 城間篤人 検索画面ができた後、そこから遷移するように修正予定。現在は決めうちでテストデータを用意している。 2014年5月

    /**
     * Divに対して値を設定します。
     *
     * @param detailPanel 被保険者詳細パネル
     * @param gaitoshaPanel 被保険者検索該当者パネル
     * @return response
     */
    public ResponseData<HihokenshaDetailPanelDiv> getOnLoadDivData(HihokenshaDetailPanelDiv detailPanel, HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        ResponseData<HihokenshaDetailPanelDiv> response = new ResponseData<>();

        HihokenshaDetailTabDiv tab = detailPanel.getHihokenshaDetailTab();
        RString 名称 = get該当者情報(gaitoshaPanel).getShimei();

        setShisetsuNyutaishoGrid(tab, 名称);
        setSetaiShokaiGrid(tab, 名称);
        setRoreiFukushiGrid(tab, 名称);
        setIryoHokenGrid(tab, 名称);
        setShinseiJohoGrid(tab, 名称);
        setSeikatsuHogoGrid(tab, 名称);

        response.data = detailPanel;
        return response;
    }

    /**
     * 施設入退所タブパネル内のグリッドに表示するデータを作成して、引数から渡したタブにセットします。
     *
     * @param tab タブ
     */
    private void setShisetsuNyutaishoGrid(HihokenshaDetailTabDiv tab, RString 名称) {
        List<ShisetsuNyutaishoGrid_Row> list = createShisetsuNyutaishoList(名称);
        tab.getShisetsuNyutaishoTabPanel().getShisetsuNyutaishoGrid().setDataSource(list);
        tab.getShisetsuNyutaishoTabPanel().setVisible(!list.isEmpty());
    }

    private List<ShisetsuNyutaishoGrid_Row> createShisetsuNyutaishoList(RString 名称) {
        List<ShisetsuNyutaishoGrid_Row> list = new ArrayList<>();
        ShisetsuNyutaishoGrid_Row item;

        if (名称.equals(new RString("電算太郎"))) {
            item = createShisetsuNyutaishoData("19900219", "19900228", "", "",
                    "指定介護療養型医療施設", "0000001254", "電算介護療養支援センター", "デンサンカイゴリョウヨウシエンセンター", "電算市高松2201-1");
            list.add(item);
        } else if (名称.equals(new RString("山本九十九子"))) {
        } else {
            item = createShisetsuNyutaishoData("19900219", "19900228", "", "",
                    "指定介護療養型医療施設", "0000001254", "電算介護療養支援センター", "デンサンカイゴリョウヨウシエンセンター", "電算市高松2201-1");
            list.add(item);
            item = createShisetsuNyutaishoData("19800101", "19800112", "19900219", "19900228",
                    "指定介護療養型医療施設", "0000001012", "電算総合支援センター", "デンサンソウゴウシエンセンター", "電算市稲葉1000-1");
            list.add(item);
        }

        return list;
    }

    private ShisetsuNyutaishoGrid_Row createShisetsuNyutaishoData(String 入所処理日, String 入所日, String 退所処理日, String 退所日,
            String 事業者種別, String 事業者番号, String 施設名称, String 施設カナ名称, String 所在地住所) {
        ShisetsuNyutaishoGrid_Row row = new ShisetsuNyutaishoGrid_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setNyushoShoriYMD(createDateString(入所処理日));
        row.setNyushoYMD(createDateString(入所日));
        row.setTaishoShoriYMD(createDateString(退所処理日));
        row.setTaishoYMD(createDateString(退所日));
        row.setJigyoshaShubetsu(new RString(事業者種別));
        row.setJigyoshaNo(new RString(事業者番号));
        row.setShisetsuMeisho(new RString(施設名称));
        row.setShisetsuKanaMeisho(new RString(施設カナ名称));
        row.setShozaichiJusho(new RString(所在地住所));
        return row;
    }

    /**
     * 世帯情報タブパネル内のグリッドに表示するデータを作成して、引数から渡したタブにセットします。
     *
     * @param tab タブ
     */
    private void setSetaiShokaiGrid(HihokenshaDetailTabDiv tab, RString 名称) {
        List<SetaiShokaiGrid_Row> list = createSetaiList(名称);
        tab.getSetaiShokaiTabPanel().getSetaiShokaiGrid().setDataSource(list);
        tab.getSetaiShokaiTabPanel().setVisible(!list.isEmpty());
    }

    private List<SetaiShokaiGrid_Row> createSetaiList(RString 名称) {
        List<SetaiShokaiGrid_Row> list = new ArrayList<>();
        SetaiShokaiGrid_Row item;

        if (名称.equals(new RString("電算太郎"))) {
            item = createSetaiData("0000708123", "電算太郎", "男", "19420101", "世帯主", "", "000001200034567");
            list.add(item);
            item = createSetaiData("0000345723", "電算妙子", "女", "19430101", "妻", "", "000001200045590");
            list.add(item);
            item = createSetaiData("0010204123", "電算勤", "男", "19650101", "子", "", "000001200345988");
            list.add(item);
        } else if (名称.equals(new RString("山本九十九子"))) {
            item = createSetaiData("0000125723", "山本九十九子", "女", "19600101", "本人", "", "000008760045590");
            list.add(item);
            item = createSetaiData("0000124123", "山本百舌朗", "男", "19650208", "世帯主", "", "0000087600345988");
            list.add(item);
        } else {

        }

        return list;
    }

    private SetaiShokaiGrid_Row createSetaiData(String 被保番号, String 氏名, String 性別, String 生年月日,
            String 続柄, String 住民種別, String 識別コード) {
        SetaiShokaiGrid_Row row = new SetaiShokaiGrid_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setHihokenshaNo(new RString(被保番号));
        row.setShimei(new RString(氏名));
        row.setGender(new RString(性別));
        row.setDateOfBirth(createDateString(生年月日));
        row.setZokugara(new RString(続柄));
        row.setJuminShubetsu(new RString(住民種別));
        row.setShikibetsuCode(new RString(識別コード));
        return row;
    }

    /**
     * 生活保護タブパネル内のグリッドに表示するデータを作成して、引数から渡したタブにセットします。
     *
     * @param tab タブ
     */
    private void setSeikatsuHogoGrid(HihokenshaDetailTabDiv tab, RString 名称) {
        List<SeikatsuHogoGrid_Row> list = createSeikatsuHogoList(名称);
        tab.getSeikatsuHogoTabPanel().getSeikatsuHogoGrid().setDataSource(list);
        tab.getSeikatsuHogoTabPanel().setVisible(!list.isEmpty());
    }

    private List<SeikatsuHogoGrid_Row> createSeikatsuHogoList(RString 名称) {
        List<SeikatsuHogoGrid_Row> list = new ArrayList<>();
        SeikatsuHogoGrid_Row item;

        if (名称.equals(new RString("電算太郎"))) {
            item = createSeikatsuHogoData("09010901", "20090413", "20110420", "生活扶助");
            list.add(item);
        }

        return list;
    }

    private SeikatsuHogoGrid_Row createSeikatsuHogoData(String 受給者番号, String 開始日, String 廃止日, String 生活保護種別) {
        SeikatsuHogoGrid_Row row = new SeikatsuHogoGrid_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setJukyushaNo(new RString(受給者番号));
        row.setKaishiYMD(createDateString(開始日));
        row.setHaishiYMD(createDateString(廃止日));
        row.setSeikatsuHogoShubetsu(new RString(生活保護種別));
        return row;
    }

    /**
     * 老齢福祉タブパネル内のグリッドに表示するデータを作成して、引数から渡したタブにセットします。
     *
     * @param tab タブ
     */
    private void setRoreiFukushiGrid(HihokenshaDetailTabDiv tab, RString 名称) {
        List<RoreiFukushiGrid_Row> list = createRoreiFukushiList(名称);
        tab.getRoreiFukushiTabPanel().getRoreiFukushiGrid().setDataSource(list);
        tab.getRoreiFukushiTabPanel().setVisible(!list.isEmpty());
    }

    private List<RoreiFukushiGrid_Row> createRoreiFukushiList(RString 名称) {
        List<RoreiFukushiGrid_Row> list = new ArrayList<>();
        RoreiFukushiGrid_Row item;

        if (名称.equals(new RString("喜屋武三郎"))) {
            item = createRoreiFukushiData("09010901", "20090413", "20110420");
            list.add(item);
        } else {

        }

        return list;
    }

    private RoreiFukushiGrid_Row createRoreiFukushiData(String 受給者番号, String 開始日, String 廃止日) {
        RoreiFukushiGrid_Row row = new RoreiFukushiGrid_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setJukyushaNo(new RString(受給者番号));
        row.setKaishiYMD(createDateString(開始日));
        row.setHaishiYMD(createDateString(廃止日));
        return row;
    }

    /**
     * 医療保険タブパネル内のグリッドに表示するデータを作成して、引数から渡したタブにセットします。
     *
     * @param tab タブ
     */
    private void setIryoHokenGrid(HihokenshaDetailTabDiv tab, RString 名称) {
        List<IryoHokenGrid_Row> list = createIryoHokenList(名称);
        tab.getIryoHokenTabPanel().getIryoHokenGrid().setDataSource(list);
        tab.getIryoHokenTabPanel().setVisible(!list.isEmpty());
    }

    private List<IryoHokenGrid_Row> createIryoHokenList(RString 名称) {
        List<IryoHokenGrid_Row> list = new ArrayList<>();
        IryoHokenGrid_Row item;

        if (名称.equals(new RString("山本九十九子"))) {
            item = createIryoHokenData("国民健康保険", "0001002890", "長野市", "00100289", "20020627", "");
            list.add(item);
        }

        return list;
    }

    private IryoHokenGrid_Row createIryoHokenData(String 種別, String 保険者番号, String 保険者名称, String 記号番号, String 加入日, String 脱退日) {
        IryoHokenGrid_Row row = new IryoHokenGrid_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setShubetsu(new RString(種別));
        row.setHokenshaNo(new RString(保険者番号));
        row.setMeisho(new RString(保険者名称));
        row.setKigoNo(new RString(記号番号));
        row.setKanyuYMD(createDateString(加入日));
        row.setDattaiYMD(createDateString(脱退日));
        return row;
    }

    /**
     * 申請情報タブパネル内のグリッドに表示するデータを作成して、引数から渡したタブにセットします。
     *
     * @param tab タブ
     */
    private void setShinseiJohoGrid(HihokenshaDetailTabDiv tab, RString 名称) {
        List<ShinseishoTodokedeGrid_Row> list = createShinseiJohoList(名称);
        tab.getShinseiInfoTabPanel().getShinseishoTodokedeGrid().setDataSource(list);
        tab.getShinseiInfoTabPanel().setVisible(!list.isEmpty());
    }

    private List<ShinseishoTodokedeGrid_Row> createShinseiJohoList(RString 名称) {
        List<ShinseishoTodokedeGrid_Row> list = new ArrayList<>();
        ShinseishoTodokedeGrid_Row item;

        if (名称.equals(new RString("電算太郎"))) {
            item = createShinseiJohoData("20100808", "140012", "介護");
            list.add(item);
        } else if (名称.equals(new RString("喜屋武三郎"))) {
            item = createShinseiJohoData("20080123", "122890", "介護");
            list.add(item);
            item = createShinseiJohoData("20071104", "112010", "介護");
            list.add(item);
        }

        return list;
    }

    private ShinseishoTodokedeGrid_Row createShinseiJohoData(String 届出日, String 申請書管理番号, String 届出種別) {
        ShinseishoTodokedeGrid_Row row = new ShinseishoTodokedeGrid_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setTodokedeYMD(new RString(届出日));
        row.setShinseishoKanriNo(new RString(申請書管理番号));
        row.setTodokedeShubetsu(new RString(届出種別));
        return row;
    }

    private HihokenshaSearchGaitoshaGrid_Row get該当者情報(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        HihokenshaSearchGaitoshaGrid_Row gaitoshaGrid;
        if (check未選択(gaitoshaPanel)) {
            gaitoshaGrid = gaitoshaPanel.getHihokenshaSearchGaitoshaGrid().getDataSource().get(0);
        } else {
            gaitoshaGrid = gaitoshaPanel.getHihokenshaSearchGaitoshaGrid().getSelectedItems().get(0);
        }
        return gaitoshaGrid;
    }

    private boolean check未選択(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        return gaitoshaPanel.getHihokenshaSearchGaitoshaGrid().getSelectedItems().isEmpty();
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
