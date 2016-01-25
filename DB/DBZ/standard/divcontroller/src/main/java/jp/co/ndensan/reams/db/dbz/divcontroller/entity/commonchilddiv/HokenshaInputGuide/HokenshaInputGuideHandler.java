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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * {@link HokenshaInputGuideDiv}のHandlerクラスです。
 */
public class HokenshaInputGuideHandler {

    private final HokenshaInputGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public HokenshaInputGuideHandler(HokenshaInputGuideDiv div) {
        this.div = div;
    }

    /**
     *
     * 「保険者検索」ボタンを設定します。
     *
     * @param hokenshaList
     * @param kenCodeList
     * @param kenCode
     */
    public void on保険者検索(List<Hokensha> hokenshaList, List<KenCodeJigyoshaInputGuide> kenCodeList, RString kenCode) {
        set保険者(hokenshaList);
        div.getDdlHokenshaKenCode().getDataSource().clear();
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (KenCodeJigyoshaInputGuide guide : kenCodeList) {
            KeyValueDataSource DataSource = new KeyValueDataSource();
            RStringBuilder 県コード = new RStringBuilder();
            DataSource.setKey(guide.get都道府県住所コード());
            県コード.append(guide.get都道府県住所コード());
            県コード.append(RString.HALF_SPACE);
            県コード.append(guide.get都道府県名());
            DataSource.setValue(県コード.toRString());
            dataSourceList.add(DataSource);
        }
        div.getDdlHokenshaKenCode().setDataSource(dataSourceList);
        for (KenCodeJigyoshaInputGuide guide : kenCodeList) {
            if (guide.get都道府県住所コード().equals(kenCode)) {
                div.getDdlHokenshaKenCode().setSelectedKey(kenCode);
            }
        }
    }

    /**
     * 「保険者を表示する」ボタンを設定します。
     *
     * @param hokenshaList
     */
    public void on保険者を表示する(List<Hokensha> hokenshaList) {
        set保険者(hokenshaList);
    }

    /**
     * 「選択」ボタンを設定します。
     *
     * @param div
     */
    public void on選択(HokenshaInputGuideDiv div) {
        dgSearchResultHokensha_Row row = div.getSearchResultHokensha().getDgSearchResultHokensha().getActiveRow();
        div.setHokenshaMeisho(row.getHokenshaMeisho());
        div.setHokenshaNo(row.getHokenshaNo());
    }

    private void set保険者(List<Hokensha> hokenshaList) {

        List<dgSearchResultHokensha_Row> rowList = new ArrayList<>();
        for (Hokensha guide : hokenshaList) {
            dgSearchResultHokensha_Row row = new dgSearchResultHokensha_Row();
            row.setHokenshaMeisho(guide.get保険者名());
            row.setHokenshaNo(guide.get保険者番号().value());
            row.setHokensha(guide.get保険者名());
            rowList.add(row);
        }
        div.getSearchResultHokensha().getDgSearchResultHokensha().setDataSource(rowList);
    }
}
