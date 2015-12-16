/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaInputGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * {@link HokenshaInputGuideDiv}のHandlerクラスです。
 */
public class HokenshaInputGuideHandler {

    private final HokenshaInputGuideDiv div;

    public HokenshaInputGuideHandler(HokenshaInputGuideDiv div) {
        this.div = div;
    }

    public void on保険者検索(List<Hokensha> hokenjaList, List<KenCodeJigyoshaInputGuide> kenCodeList, RString kenCode) {
        set保険者(hokenjaList);
        clear();
        List<KeyValueDataSource> list = new ArrayList<>();
        for (KenCodeJigyoshaInputGuide guide : kenCodeList) {
            KeyValueDataSource DataSource = new KeyValueDataSource();
            DataSource.setKey(guide.get都道府県住所コード());
            DataSource.setValue(guide.get都道府県名());
            list.add(DataSource);
        }
        div.getDdlHokenshaKenCode().setDataSource(list);
        div.getDdlHokenshaKenCode().setSelectedKey(kenCode);
    }

    public void on保険者を表示する(List<Hokensha> hokenjaList) {

        set保険者(hokenjaList);
    }

    public void on選択(HokenshaInputGuideDiv div) {
        dgSearchResultHokensha_Row row = div.getSearchResultHokensha().getDgSearchResultHokensha().getActiveRow();
        div.setHokenshaMeisho(row.getHokenshaMeisho());
        div.setHokenshaNo(row.getHokenshaNo());
    }

    private void set保険者(List<Hokensha> hokenjaList) {

        List<dgSearchResultHokensha_Row> list = new ArrayList<>();
        for (Hokensha guide : hokenjaList) {
            dgSearchResultHokensha_Row row = new dgSearchResultHokensha_Row();
            row.setHokenshaMeisho(guide.get保険者名());
            row.setHokenshaNo(guide.get保険者番号().value());
            row.setHokensha(guide.get保険者名());
            list.add(row);
        }
        div.getSearchResultHokensha().getDgSearchResultHokensha().setDataSource(list);
    }

    private void clear() {
        div.getDdlHokenshaKenCode().getDataSource().clear();
    }
}
