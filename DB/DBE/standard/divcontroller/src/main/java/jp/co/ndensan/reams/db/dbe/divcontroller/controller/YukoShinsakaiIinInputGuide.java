/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.yukoshinsakaiiininputguide.YukoShinsakaiIinInputGuideDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.yukoshinsakaiiininputguide.dgYukoShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiIinDac;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.realservice.ShinsakaiIinManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 現在有効な審査会委員の一覧を表示し、選択することができる入力補助ダイアログの処理です。
 *
 * @author n8178 城間篤人
 */
public class YukoShinsakaiIinInputGuide {

    public ResponseData onLoad(YukoShinsakaiIinInputGuideDiv inputGuideDiv) {
        ResponseData<YukoShinsakaiIinInputGuideDiv> response = new ResponseData<>();

        setGridData(inputGuideDiv.getDgYukoShinsakaiIin());

        response.data = inputGuideDiv;
        return response;
    }

    private void setGridData(DataGrid<dgYukoShinsakaiIin_Row> grid) {
        List<dgYukoShinsakaiIin_Row> dataSource = new ArrayList<>();
        ShinsakaiIinManager manager = new ShinsakaiIinManager();

        ShinsakaiIinList shinsakaiIinList = manager.get有効審査会委員List();
        for (ShinsakaiIin shinsakaiIin : shinsakaiIinList) {
            dataSource.add(toShinsakaiIinRow(shinsakaiIin));
        }

        grid.setDataSource(dataSource);
    }

    private dgYukoShinsakaiIin_Row toShinsakaiIinRow(ShinsakaiIin shinsakaiIin) {
        dgYukoShinsakaiIin_Row row = new dgYukoShinsakaiIin_Row(RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setShinsakaiIinCode(shinsakaiIin.get審査会委員コード().value());
        row.getKaishiDate().setValue(shinsakaiIin.get委員着任期間().getFrom());
        row.setGender(shinsakaiIin.get性別().getCommonName());
        row.setJigyosha(shinsakaiIin.get事業者番号().getColumnValue());
        row.setJusho(shinsakaiIin.get住所().getColumnValue());
        row.setShimei(shinsakaiIin.get氏名().getColumnValue());
        row.setTelNo(shinsakaiIin.get電話番号().getColumnValue());
        return row;
    }
}
