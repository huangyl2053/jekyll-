/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaInputGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * {@link HokenshaInputGuideDiv}のHandlerクラスです。
 *
 * @reamsid_L DBA-0180-010 lishengli
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
        List<RString> list = new ArrayList<>();
        for (KenCodeJigyoshaInputGuide guide : kenCodeList) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            RStringBuilder 県コード = new RStringBuilder();
            dataSource.setKey(guide.get都道府県住所コード());
            県コード.append(guide.get都道府県住所コード());
            県コード.append(RString.HALF_SPACE);
            県コード.append(guide.get都道府県名());
            dataSource.setValue(県コード.toRString());
            if (!list.contains(guide.get都道府県住所コード())) {
                dataSourceList.add(dataSource);
            }
            list.add(guide.get都道府県住所コード());
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
