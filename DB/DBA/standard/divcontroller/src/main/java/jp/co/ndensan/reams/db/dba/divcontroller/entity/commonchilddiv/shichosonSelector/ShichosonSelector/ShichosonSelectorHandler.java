package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonSelector.ShichosonSelector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorResult;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * サービス種類検索の抽象Handlerクラスです。
 */
public class ShichosonSelectorHandler {

    private final ShichosonSelectorDiv div;
    private static final RString selectItemKyo = new RString("key0");
    private static final RString selectItemKousei = new RString("key1");
    //TODO 張紅麗　QA57　市町村選択モードの確認　2015/12/02まで
    private static final RString KOUSEI_MODO_KOUSEI = new RString("1");
    private static final RString KOUSEI_MODO_KYU = new RString("0");

    public ShichosonSelectorHandler(ShichosonSelectorDiv div) {
        this.div = div;
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param resultList List<ShichosonSelectorResult>
     */
    public void set構成市町村情報一覧表示グリッド(List<ShichosonSelectorResult> resultList) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (ShichosonSelectorResult result : resultList) {
            if (KOUSEI_MODO_KYU.equals(result.get合併旧市町村区分())) {
                dgShichoson_Row row = new dgShichoson_Row();
                row.setTxtShichosonCode(result.get市町村コード().value());
                row.setTxtShichosonName(result.get市町村名());
                rowList.add(row);
            }
        }
        datagrid.setDataSource(rowList);
    }

    /**
     * 旧市町村モードで呼び出された場合、市町村選択情報リストデータを取得する。
     *
     * @param resultList List<ShichosonSelectorResult>
     */
    public void set旧市町村選択情報一覧表示グリッド(List<ShichosonSelectorResult> resultList) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (ShichosonSelectorResult result : resultList) {
            dgShichoson_Row row = new dgShichoson_Row();
            row.setTxtShichosonCode(result.get市町村コード().value());
            row.setTxtShichosonName(result.get市町村名());
            rowList.add(row);
        }
        datagrid.setDataSource(rowList);
    }

    /**
     * 構成市町村モードで呼び出された場合、構成市町村選択情報の取得を処理する。
     *
     * @param resultList List<ShichosonSelectorResult>
     */
    public void set構成市町村情報By市町村モード(List<ShichosonSelectorResult> resultList) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (ShichosonSelectorResult result : resultList) {
            if (div.getRadShichosonKubun().getSelectedKey().equals(selectItemKyo)
                    && KOUSEI_MODO_KOUSEI.equals(result.get合併旧市町村区分())) {
                dgShichoson_Row row = new dgShichoson_Row();
                row.setTxtShichosonCode(result.get市町村コード().value());
                row.setTxtShichosonName(result.get市町村名());
                rowList.add(row);
            }
            if (div.getRadShichosonKubun().getSelectedKey().equals(selectItemKousei)
                    && KOUSEI_MODO_KYU.equals(result.get合併旧市町村区分())) {
                dgShichoson_Row row = new dgShichoson_Row();
                row.setTxtShichosonCode(result.get市町村コード().value());
                row.setTxtShichosonName(result.get市町村名());
                rowList.add(row);
            }
        }
        datagrid.setDataSource(rowList);
    }

    /**
     * onLoad 一覧表示
     *
     * @param resultList List<ShichosonSelectorResult>
     */
    public void set一覧表示グリッド(List<ShichosonSelectorResult> resultList) {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        RString 構成市町村モード = model.getShichosonModel();
        if (KOUSEI_MODO_KOUSEI.equals(構成市町村モード)) {
            div.getRadShichosonKubun().setDisplayNone(false);
        } else {
            div.getRadShichosonKubun().setDisplayNone(true);
        }
        if (KOUSEI_MODO_KYU.equals(構成市町村モード)) {
            set旧市町村選択情報一覧表示グリッド(resultList);
        }
        if (KOUSEI_MODO_KOUSEI.equals(構成市町村モード)) {
            set構成市町村情報一覧表示グリッド(resultList);
            ShichosonSelectorModel shichosonSelector = new ShichosonSelectorModel();
            shichosonSelector.setList(resultList);
            div.setKyuShichoson(DataPassingConverter.serialize(shichosonSelector));
        }
    }
}
