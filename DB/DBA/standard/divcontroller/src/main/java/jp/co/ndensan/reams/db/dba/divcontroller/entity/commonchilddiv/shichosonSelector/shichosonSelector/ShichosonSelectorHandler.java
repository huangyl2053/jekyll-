package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonSelector.shichosonSelector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 市町村選択情報のHandler作成
 */
public class ShichosonSelectorHandler {

    private final ShichosonSelectorDiv div;
    private static final RString key0 = new RString("key0");
    private static final RString key1 = new RString("key1");
    private static final RString 旧市町村1 = new RString("1");
    private static final RString 旧市町村2 = new RString("0");

    public ShichosonSelectorHandler(ShichosonSelectorDiv div) {
        this.div = div;
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param 構成市町村選択情報
     */
    public void set構成市町村情報一覧表示グリッド(List<DbT7051KoseiShichosonMasterEntity> 構成市町村選択情報) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (DbT7051KoseiShichosonMasterEntity entity : 構成市町村選択情報) {
            if (旧市町村2.equals(entity.getGappeiKyuShichosonKubun())) {
                dgShichoson_Row row = new dgShichoson_Row();
                row.setTxtShichosonCode(entity.getShichosonCode().value());
                row.setTxtShichosonName(entity.getShichosonMeisho());
                rowList.add(row);
            }
        }
        datagrid.setDataSource(rowList);
    }

    /**
     * 旧市町村モードで呼び出された場合、市町村選択情報リストデータを取得する。
     *
     * @param 旧市町村選択情報
     */
    public void set旧市町村選択情報一覧表示グリッド(List<DbT7056GappeiShichosonEntity> 旧市町村選択情報) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (DbT7056GappeiShichosonEntity entity : 旧市町村選択情報) {
            dgShichoson_Row row = new dgShichoson_Row();
            row.setTxtShichosonCode(entity.getKyuShichosonCode().value());
            row.setTxtShichosonName(entity.getKyuShichosonMeisho());
            rowList.add(row);
        }
        datagrid.setDataSource(rowList);
    }

    /**
     * 構成市町村モードで呼び出された場合、構成市町村選択情報の取得を処理する。
     *
     * @param 旧市町村
     */
    public void onClick_旧市町村ラジオボタン(List<DbT7051KoseiShichosonMasterEntity> 旧市町村) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (DbT7051KoseiShichosonMasterEntity entity : 旧市町村) {
            if (div.getRadShichosonKubun().getSelectedKey().equals(key0)) {
                if (旧市町村1.equals(entity.getGappeiKyuShichosonKubun())) {
                    dgShichoson_Row row = new dgShichoson_Row();
                    row.setTxtShichosonCode(entity.getShichosonCode().value());
                    row.setTxtShichosonName(entity.getShichosonMeisho());
                    rowList.add(row);
                }
            }

            if (div.getRadShichosonKubun().getSelectedKey().equals(key1)) {
                if (旧市町村2.equals(entity.getGappeiKyuShichosonKubun())) {
                    dgShichoson_Row row = new dgShichoson_Row();
                    row.setTxtShichosonCode(entity.getShichosonCode().value());
                    row.setTxtShichosonName(entity.getShichosonMeisho());
                    rowList.add(row);
                }
            }

        }
        datagrid.setDataSource(rowList);
    }
}
