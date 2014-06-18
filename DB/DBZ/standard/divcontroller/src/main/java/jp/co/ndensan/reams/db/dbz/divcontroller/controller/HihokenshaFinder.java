/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.divcontroller.demodata.KoikiKoseiShichosonData;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaFinderDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaFinder {

    public enum Mode {

        NORMAL("1"),
        KOIKI("2");
        private final RString value;

        private Mode(String value) {
            this.value = new RString(value);
        }

        public RString value() {
            return this.value;
        }
    }
    private final Criterias criterias = new Criterias();

    /**
     * onLoad
     *
     * @param div HihokenshaFinderDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaFinderDiv> onLoad(HihokenshaFinderDiv div) {
        init(div);
        setMode(Mode.NORMAL, div);
        return _createResponseData(div);
    }

    private void init(HihokenshaFinderDiv div) {
        init_ddlHokensha(div);
        init_SearchCriteriaDetail(div);
    }

    private void init_ddlHokensha(HihokenshaFinderDiv div) {
        div.getSearchCriteriaOfHokensha().getDdlHokensha().
                setDataSource(new KoikiKoseiShichosonData().get広域構成市町村().asKeyValueDataSources());
    }

    private void init_SearchCriteriaDetail(HihokenshaFinderDiv div) {
        div.getSearchCriteriaDetail().setIsOpen(false);
    }

    /**
     * onClick btnToClear
     *
     * @param div HihokenshaFinderDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaFinderDiv> onClick_btnToClear(HihokenshaFinderDiv div) {
        criterias.clearAll(div);
        return _createResponseData(div);
    }

    /**
     * HihokenshaFiderのモードを切り替えます。
     *
     * @param mode Mode
     * @param div HihokemnshaFinderDiv
     */
    public static void setMode(Mode mode, HihokenshaFinderDiv div) {
        switch (mode) {
            case NORMAL:
                changeToNormalMode(div);
                break;
            case KOIKI:
                changeToKoinkiMode(div);
                break;
            default:
                changeToNormalMode(div);
                break;
        }
    }

    private static void changeToNormalMode(HihokenshaFinderDiv div) {
        div.getSearchCriteriaOfHokensha().getDdlHokensha().setDisplayNone(false);
    }

    private static void changeToKoinkiMode(HihokenshaFinderDiv div) {
        div.getSearchCriteriaOfHokensha().getDdlHokensha().setDisplayNone(true);
    }

    /**
     * 内包する編集可能なUI部品の設定値をクリアします。
     *
     * @param div HihokenshaFinderDiv
     */
    public static void clear(HihokenshaFinderDiv div) {
        new Criterias().clearAll(div);
    }

    private static class Criterias {

        private Criterias() {
        }

        private void clearAll(HihokenshaFinderDiv div) {
            clear(div.getSearchCriteriaOfHihokensha());
            clear(div.getSearchCriteriaOfHokensha());
            clear(div.getSearchCriteriaOfKojin());
        }

        private void clear(SearchCriteriaOfHihokenshaDiv div) {
            div.getTxtHihokenshaNo().clearValue();
        }

        private void clear(SearchCriteriaOfHokenshaDiv div) {
            div.getDdlHokensha().setSelectedItem(RString.EMPTY);
        }

        private void clear(SearchCriteriaOfKojinDiv div) {
            div.getTxtBirthDay().clearValue();
            div.getTxtJusho().clearValue();
            div.getTxtKojinNo().clearValue();
            div.getTxtSetaiCode().clearValue();
            div.getTxtShikibetsuCode().clearValue();
            div.getTxtShimei().clearValue();
            div.getTxtYubinNo().clearValue();
            div.getChkGender().setSelectedItems(Collections.EMPTY_LIST);
            //TODO n3327 三浦 凌 値決めうちを修正する。
            div.getDdlJuminShubetsu().setSelectedItem(new RString("key0"));
            div.getDdlSearchPatternForName().setSelectedItem(new RString("1"));
        }
    }

    private ResponseData<HihokenshaFinderDiv> _createResponseData(HihokenshaFinderDiv div) {
        ResponseData<HihokenshaFinderDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
