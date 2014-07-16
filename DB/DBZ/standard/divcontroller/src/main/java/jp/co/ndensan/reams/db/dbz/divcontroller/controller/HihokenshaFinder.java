/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.divcontroller.demodata.KoikiKoseiShichosonData;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaFinderDiv;
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
        div.getSearchCriteriaOfHihokensha().getDdlHokensha().
                setDataSource(new KoikiKoseiShichosonData().get広域構成市町村().asKeyValueDataSources());
    }

    private void init_SearchCriteriaDetail(HihokenshaFinderDiv div) {
        div.getSearchCriteriaOfHihokensha().getSearchCriteriaDetail().setIsOpen(false);
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
        div.getSearchCriteriaOfHihokensha().getDdlHokensha().setDisplayNone(true);
    }

    private static void changeToKoinkiMode(HihokenshaFinderDiv div) {
        div.getSearchCriteriaOfHihokensha().getDdlHokensha().setDisplayNone(false);
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
            clear(div.getSearchCriteriaOfHihokensha().getSearchCriteriaDetail());
            clear(div.getKaigoAtenaFinder());
        }

        private void clear(SearchCriteriaOfHihokenshaDiv div) {
            div.getDdlHokensha().setSelectedItem(RString.EMPTY);
            div.getTxtHihokenshaNo().clearValue();
            div.getTxtTuchishoNo().clearValue();
            div.getDdlFukaNendo().setSelectedItem(new RString("key0"));
        }
        
        private void clear(SearchCriteriaDetailDiv div) {
            div.getChkHihokensha().setSelectedItems(Collections.EMPTY_LIST);
            div.getRadMinashiNigo().setSelectedItem(new RString("1"));
            div.getChkMinashiNigo().setSelectedItems(Collections.EMPTY_LIST);            
        }
        
        private void clear(AtenaFinderDiv div) {
            div.getTxtAtenaMeisho().clearValue();
            div.getTxtSeinenGappi().clearValue();
        }        
    }

    private ResponseData<HihokenshaFinderDiv> _createResponseData(HihokenshaFinderDiv div) {
        ResponseData<HihokenshaFinderDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
