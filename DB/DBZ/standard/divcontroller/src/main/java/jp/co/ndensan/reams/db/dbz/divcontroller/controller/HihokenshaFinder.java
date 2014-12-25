/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.KaigoFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.KaigoFinderDetailDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IAtenaFinderDiv;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * HihokenshaFinderDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaFinder {

    private static final RString 全年度 = new RString("全年度");

    /**
     * 画面表示時に呼び出される処理です。
     *
     * @param div HihokenshaFinderDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaFinderDiv> onLoad(HihokenshaFinderDiv div) {
        ResponseData<HihokenshaFinderDiv> response = new ResponseData<>();

        init(div);

        response.data = div;
        return response;
    }

    /**
     * 「条件をクリアする」ボタンクリック時に呼び出される処理です。
     *
     * @param div HihokenshaFinderDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaFinderDiv> onClick_btnClear(HihokenshaFinderDiv div) {
        ResponseData<HihokenshaFinderDiv> response = new ResponseData<>();

        clear(div);

        response.data = div;
        return response;
    }

    private void init(HihokenshaFinderDiv div) {
        if (div.getMode_表示モード() == HihokenshaFinderDiv.表示モード.賦課系) {
            init賦課年度(div);
        }
        div.load最近処理者();
    }

    private void init賦課年度(HihokenshaFinderDiv div) {

        FlexibleYear 開始年度;
        FlexibleYear 終了年度;

        HizukeConfig config = new HizukeConfig();
        FukaSearchMenu menu = FukaSearchMenu.toValue(UrControlDataFactory.createInstance().getMenuID());
        if (menu.is更新()) {
            開始年度 = config.get調定年度();
            終了年度 = config.get調定年度();
        } else if (menu.is所得入力()) {
            開始年度 = config.get所得年度();
            終了年度 = config.get当初年度();
        } else if (menu.is即時更正()) {
            開始年度 = config.get調定年度();
            終了年度 = config.get遡及年度();
        } else {
            開始年度 = config.get調定年度();
            終了年度 = config.get当初年度();
        }

        List<KeyValueDataSource> 賦課年度List = create賦課年度List(開始年度, 終了年度);

        if (menu.is賦課照会()) {
            賦課年度List.add(0, new KeyValueDataSource(FlexibleYear.MAX.toDateString(), 全年度));
        }

        div.getKaigoFinder().getDdlFukaNendo().setDataSource(賦課年度List);
    }

    private List<KeyValueDataSource> create賦課年度List(FlexibleYear 開始年度, FlexibleYear 終了年度) {

        int start;
        int end;

        if (開始年度 == null && 終了年度 == null) {
            return Collections.EMPTY_LIST;
        } else if (開始年度 == null) {
            start = 終了年度.getYearValue();
            end = start;
        } else if (終了年度 == null) {
            start = 開始年度.getYearValue();
            end = start;
        } else {
            start = 開始年度.getYearValue();
            end = 終了年度.getYearValue();
            if (終了年度.isBefore(開始年度)) {
                start = 終了年度.getYearValue();
                end = 開始年度.getYearValue();
            }
        }

        List<KeyValueDataSource> 賦課年度List = new ArrayList<>();
        for (int year = start; year <= end; year++) {
            FlexibleYear 賦課年度 = new FlexibleYear(Integer.toString(year));
            賦課年度List.add(new KeyValueDataSource(賦課年度.toDateString(), 賦課年度.wareki().toDateString()));
        }

        return 賦課年度List;
    }

    private void clear(HihokenshaFinderDiv div) {
        clear介護条件(div.getKaigoFinder());
        clear宛名条件(div.getCcdAtenaFinder());
    }

    private void clear介護条件(KaigoFinderDiv div) {
        div.getDdlHokensha().setSelectedItem(RString.EMPTY);
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtTuchishoNo().clearValue();
        div.getDdlFukaNendo().setSelectedItem(new RString("key0"));
        clear介護詳細条件(div.getKaigoFinderDetail());
    }

    private void clear介護詳細条件(KaigoFinderDetailDiv div) {
        div.getChkHihokenshaDaicho().setSelectedItems(Collections.EMPTY_LIST);
        div.getChkJukyushaDaicho().setSelectedItems(Collections.EMPTY_LIST);
        div.getChkJushochiTokureisha().setSelectedItems(Collections.EMPTY_LIST);
        div.getRadMinashiNigo().setSelectedItem(new RString("1"));
        div.getChkMinashiNigo().setSelectedItems(Collections.EMPTY_LIST);
    }

    private void clear宛名条件(IAtenaFinderDiv div) {
        div.clear();
    }
}
