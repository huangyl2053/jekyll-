/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE591001.DBE591001_IryokikanShujiiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiHateiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiOutputPage;
import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiOutputSort;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5910001.IkenshoShujiiIchiranDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * IkenshoShujiiIchiranHandler のクラスファイル 主治医医療機関・主治医一覧表データ検索印刷機能クラスです。
 *
 * @reamsid_L DBE-0260-010 zuotao
 */
public class IkenshoShujiiIchiranHandler {

    private final RString 全市町村 = new RString("全市町村");
    private final IkenshoShujiiIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IkenshoShujiiIchiranDiv
     */
    public IkenshoShujiiIchiranHandler(IkenshoShujiiIchiranDiv div) {
        this.div = div;
    }

    /**
     * 主治医医療機関・主治医一覧表初期化の設定します。
     */
    public void onLoad() {

        div.getCcdHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getDdlOutputSort().setDataSource(set出力順());
        List<KeyValueDataSource> 改頁 = new ArrayList();
        改頁.add(new KeyValueDataSource(ShujiiOutputPage.医療機関コード.getコード(), ShujiiOutputPage.医療機関コード.get名称()));
        改頁.add(new KeyValueDataSource(ShujiiOutputPage.なし.getコード(), ShujiiOutputPage.なし.get名称()));
        div.getDdlNextpage().setDataSource(改頁);

        div.getRadJyokyo().setSelectedKey(ShujiiHateiJokyo.有効のみ.getコード());
        div.getDdlOutputSort().setSelectedKey(ShujiiOutputSort.医療機関コード主治医コード.getコード());
        div.getDdlNextpage().setSelectedKey(ShujiiOutputPage.医療機関コード.getコード());
        div.getDdlNextpage().setDisabled(false);
    }

    /**
     * 出力順変更の設定します。
     *
     * @param outputSort 出力順
     */
    public void onChange_ddlOutputSort(RString outputSort) {

        if (ShujiiOutputSort.医療機関コード主治医コード.getコード().equals(outputSort)
                || ShujiiOutputSort.医療機関コード主治医名称.getコード().equals(outputSort)) {
            div.getDdlNextpage().setDisabled(false);
            div.getDdlNextpage().setSelectedKey(ShujiiOutputPage.医療機関コード.getコード());
        } else {
            div.getDdlNextpage().setDisabled(true);
            div.getDdlNextpage().setSelectedKey(ShujiiOutputPage.なし.getコード());
        }
    }

    /**
     * バッチパラメータを作成します。
     *
     * @return 医療機関・主治医一覧表作成_バッチフロークラスパラメータ
     */
    public DBE591001_IryokikanShujiiParameter onClick_btnReportPublish() {
        RString 市町村コード = div.getCcdHokensha().getSelectedItem().get市町村コード().value();
        RString 市町村名称 = div.getCcdHokensha().getSelectedItem().get市町村名称();

        DBE591001_IryokikanShujiiParameter batchParameter = new DBE591001_IryokikanShujiiParameter();
        batchParameter.setShichosonCode(RString.isNullOrEmpty(市町村コード) ? RString.EMPTY : 市町村コード);
        batchParameter.setShichosonName(RString.isNullOrEmpty(市町村名称) ? 全市町村 : 市町村名称);
        if (RString.isNullOrEmpty(div.getTxtIryoKikanCodeFrom().getValue())) {
            batchParameter.setIryoKikanCodeFrom(new RString("0000000000"));
        } else {
            batchParameter.setIryoKikanCodeFrom(div.getTxtIryoKikanCodeFrom().getValue());
        }
        if (RString.isNullOrEmpty(div.getTxtIryoKikanCodeTo().getValue())) {
            batchParameter.setIryoKikanCodeTo(new RString("9999999999"));
        } else {
            batchParameter.setIryoKikanCodeTo(div.getTxtIryoKikanCodeTo().getValue());
        }
        if (RString.isNullOrEmpty(div.getTxtShujiiCodeFrom().getValue())) {
            batchParameter.setShujiiCodeFrom(new RString("00000000"));
        } else {
            batchParameter.setShujiiCodeFrom(div.getTxtShujiiCodeFrom().getValue());
        }
        if (RString.isNullOrEmpty(div.getTxtShujiiCodeTo().getValue())) {
            batchParameter.setShujiiCodeTo(new RString("99999999"));
        } else {
            batchParameter.setShujiiCodeTo(div.getTxtShujiiCodeTo().getValue());
        }
        batchParameter.setJyokyo(div.getRadJyokyo().getSelectedKey());
        batchParameter.setOutputSort(div.getDdlOutputSort().getSelectedKey());
        batchParameter.setNextpage(div.getDdlNextpage().getSelectedKey());
        return batchParameter;
    }

    private List<KeyValueDataSource> set出力順() {

        List<KeyValueDataSource> 出力順 = new ArrayList();
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関コード主治医コード.getコード(),
                ShujiiOutputSort.医療機関コード主治医コード.get名称()));
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関コード主治医名称.getコード(),
                ShujiiOutputSort.医療機関コード主治医名称.get名称()));
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関名称主治医コード.getコード(),
                ShujiiOutputSort.医療機関名称主治医コード.get名称()));
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関名称主治医名称.getコード(),
                ShujiiOutputSort.医療機関名称主治医名称.get名称()));
        return 出力順;
    }
}
