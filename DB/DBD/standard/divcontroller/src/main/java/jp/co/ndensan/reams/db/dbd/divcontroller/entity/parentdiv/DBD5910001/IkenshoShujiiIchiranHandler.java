/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author LINGHUHANG
 */
public class IkenshoShujiiIchiranHandler {

    private final IkenshoShujiiIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public IkenshoShujiiIchiranHandler(IkenshoShujiiIchiranDiv div) {
        this.div = div;
    }

    /**
     * サービスコード検索一覧初期化の設定します。
     *
     */
    public void onLoad() {

        //div.getDdlShichosonCode().setSelectedValue(RString.EMPTY);
        div.getTxtIryoKikanCodeFrom().setValue(RString.EMPTY);
        div.getTxtIryoKikanCodeTo().setValue(RString.EMPTY);
        div.getTxtShujiiCodeFrom().setValue(RString.EMPTY);
        div.getTxtShujiiCodeTo().setValue(RString.EMPTY);
        if (div.getRadJyokyo().getSelectedKey().toString().equals("key0")) {
            div.getRadJyokyo().setVisible(true);
        }
        if (div.getRadJyokyo().getSelectedKey().toString().equals("key1")) {
            div.getRadJyokyo().setVisible(false);
        }
        if (div.getRadJyokyo().getSelectedKey().toString().equals("key2")) {
            div.getRadJyokyo().setVisible(false);
        }
//        KeyValueDataSource key = new KeyValueDataSource(new RString("key0"), new RString("有効のみ"));
//        div.getRadJyokyo().getDataSource().add(key);

        List<KeyValueDataSource> shikakuCodeList = new ArrayList<>();
        KeyValueDataSource temp = new KeyValueDataSource();
        temp.setKey(RString.EMPTY);
        temp.setValue(RString.EMPTY);
        shikakuCodeList.add(temp);
        div.getDdlOutputSort().setDataSource(shikakuCodeList);
        div.getDdlOutputSort().setSelectedKey(new RString("key0"));
        div.getDdlOutputSort().setSelectedValue(new RString("有効のみ"));
        div.getDdlNextpage().setSelectedValue(new RString("医療機関コード"));

    }

}
