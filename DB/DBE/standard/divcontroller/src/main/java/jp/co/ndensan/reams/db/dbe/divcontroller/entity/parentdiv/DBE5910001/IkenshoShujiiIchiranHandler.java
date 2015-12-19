/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshoshujiiichiran.IkenshoShujiiIchiranParameter;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji.ShujiiOutputPage;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji.ShujiiOutputSort;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyukeitaiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * IkenshoShujiiIchiranHandler のクラスファイル 主治医医療機関・主治医一覧表データ検索印刷機能
 */
public class IkenshoShujiiIchiranHandler {

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
     * 主治医医療機関・主治医一覧表初期化の設定します
     *
     * @param 導入形態コード 導入形態コード
     */
    public void onLoad(RString 導入形態コード) {

        // TODO 左涛 QA153　「市町村ドロップダウンリスト」の表示内容および設定方法の確認　12/25まで
        //div.getDdlShichosonCode().setSelectedValue(RString.EMPTY);
        div.getRadJyokyo().setSelectedKey(new RString("1"));
        if (DonyukeitaiCode.事務広域.getコード().equals(導入形態コード) || DonyukeitaiCode.事務構成市町村.getコード().equals(導入形態コード)
                || DonyukeitaiCode.認定広域.getコード().equals(導入形態コード)) {
            // div.getDdlShichosonCode().setSelectedValue(RString.EMPTY);
        } else if (DonyukeitaiCode.事務単一.getコード().equals(導入形態コード) || DonyukeitaiCode.認定単一.getコード().equals(導入形態コード)) {
            div.getDdlShichosonCode().setSelectedValue(RString.EMPTY);
        }

        List<KeyValueDataSource> 出力順 = new ArrayList();
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関コード主治医コード.getコード(), ShujiiOutputSort.医療機関コード主治医コード.get名称()));
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関コード主治医名称.getコード(), ShujiiOutputSort.医療機関コード主治医名称.get名称()));
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関名称主治医コード.getコード(), ShujiiOutputSort.医療機関名称主治医コード.get名称()));
        出力順.add(new KeyValueDataSource(ShujiiOutputSort.医療機関名称主治医名称.getコード(), ShujiiOutputSort.医療機関名称主治医名称.get名称()));
        div.getDdlOutputSort().setDataSource(出力順);

        List<KeyValueDataSource> 改頁 = new ArrayList();
        改頁.add(new KeyValueDataSource(ShujiiOutputPage.医療機関コード.getコード(), ShujiiOutputPage.医療機関コード.get名称()));
        改頁.add(new KeyValueDataSource(ShujiiOutputPage.なし.getコード(), ShujiiOutputPage.なし.get名称()));
        div.getDdlNextpage().setDataSource(改頁);

        div.getDdlOutputSort().setSelectedKey(ShujiiOutputPage.医療機関コード.getコード());
        div.getDdlNextpage().setSelectedKey(ShujiiOutputPage.医療機関コード.getコード());
        div.getDdlNextpage().setReadOnly(false);
    }

    /**
     * 出力順変更の設定します
     *
     * @param outputSort 出力順
     */
    public void onChange_ddlOutputSort(RString outputSort) {

        if (ShujiiOutputSort.医療機関コード主治医コード.getコード().equals(outputSort)
                || ShujiiOutputSort.医療機関コード主治医名称.getコード().equals(outputSort)) {
            div.getDdlNextpage().setReadOnly(false);
        } else {
            div.getDdlNextpage().setReadOnly(true);
            div.getDdlNextpage().setSelectedKey(ShujiiOutputPage.なし.getコード());
        }
    }

    /**
     * バッチパラメータを作成します
     *
     * @return 医療機関・主治医一覧表作成_バッチフロークラスパラメータ
     */
    public IkenshoShujiiIchiranParameter onClick_btnReportPublish() {
        IkenshoShujiiIchiranParameter batchParameter = new IkenshoShujiiIchiranParameter();
        batchParameter.setShichosonCode(div.getDdlShichosonCode().getSelectedKey());
        batchParameter.setShichosonName(div.getDdlShichosonCode().getSelectedValue());
        batchParameter.setIryoKikanCodeFrom(div.getTxtIryoKikanCodeFrom().getValue());
        batchParameter.setIryoKikanCodeTo(div.getTxtIryoKikanCodeTo().getValue());
        batchParameter.setShujiiCodeFrom(div.getTxtShujiiCodeFrom().getValue());
        batchParameter.setShujiiCodeTo(div.getTxtShujiiCodeTo().getValue());
        batchParameter.setJyokyo(div.getTxtShujiiCodeTo().getValue());
        return batchParameter;
    }
}
