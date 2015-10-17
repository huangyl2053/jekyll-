/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.yukoshinsakaiiininputguide.YukoShinsakaiIinInputGuideDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.yukoshinsakaiiininputguide.dgYukoShinsakaiIin_Row;
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

    /**
     * 共有子Divの読み込み時に実行します。 現在有効な審査会委員の情報をグリッドに表示します。
     *
     * @param inputGuideDiv 有効審査会委員入力ガイド
     * @return レスポンスデータ
     */
    public ResponseData onLoad(YukoShinsakaiIinInputGuideDiv inputGuideDiv) {
        ResponseData<YukoShinsakaiIinInputGuideDiv> response = new ResponseData<>();

        setGridData(inputGuideDiv.getDgYukoShinsakaiIin());

        response.data = inputGuideDiv;
        return response;
    }

    private void setGridData(DataGrid<dgYukoShinsakaiIin_Row> grid) {
        List<dgYukoShinsakaiIin_Row> dataSource = new ArrayList<>();
        // TODO n8300姜　ビルドエラー回避のために暫定対応
//        ShinsakaiIinManager manager = new ShinsakaiIinManager();

//        ShinsakaiIinList shinsakaiIinList = manager.get有効審査会委員List();
//        for (ShinsakaiIin shinsakaiIin : shinsakaiIinList) {
//            dataSource.add(toShinsakaiIinRow(shinsakaiIin));
//        }
        grid.setDataSource(dataSource);
    }

    private dgYukoShinsakaiIin_Row toShinsakaiIinRow(ShinsakaiIin shinsakaiIin) {
        dgYukoShinsakaiIin_Row row = new dgYukoShinsakaiIin_Row(RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setShinsakaiIinCode(shinsakaiIin.get審査会委員コード().value());
        row.getKaishiDate().setValue(shinsakaiIin.get委員着任期間().getFrom());
        row.setGender(shinsakaiIin.get性別().getCommonName());
        row.setJigyoshaCode(shinsakaiIin.get事業者番号().getColumnValue());
        row.setJigyoshaMeisho(new RString("testest"));
        row.setJigyosha(row.getJigyoshaCode().concat(":").concat(row.getJigyoshaMeisho()));
        row.setJusho(shinsakaiIin.get住所().getColumnValue());
        row.setShimei(shinsakaiIin.get氏名().getColumnValue());
        row.setTelNo(shinsakaiIin.get電話番号().getColumnValue());
        return row;
    }

    /**
     * 共有子Divの読み込み時に実行します。 現在有効な審査会委員の情報をグリッドに表示します。
     *
     * @param inputGuideDiv 有効審査会委員入力ガイド
     * @return レスポンスデータ
     */
    public ResponseData onSelectBySelectButton_dgYukoShinsakaiIin(YukoShinsakaiIinInputGuideDiv inputGuideDiv) {
        ResponseData<YukoShinsakaiIinInputGuideDiv> response = new ResponseData<>();

        dgYukoShinsakaiIin_Row row = inputGuideDiv.getDgYukoShinsakaiIin().getSelectedItems().get(0);
        inputGuideDiv.setIinCode(row.getShinsakaiIinCode());
        inputGuideDiv.setIinMeisho(row.getShimei());
        inputGuideDiv.setShozokuKikan(row.getJigyosha());
        inputGuideDiv.setShozokuKikanCode(row.getJigyoshaCode());
        inputGuideDiv.setShozokuKikanMeisho(row.getJigyoshaMeisho());

        response.data = inputGuideDiv;
        return response;
    }
}
