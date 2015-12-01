package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonselector.ShichosonSelector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.shichosonselector.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
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
    //TODO QA57
    private static final RString KOUSEI_MODO_KOUSEI = new RString("1");
    private static final RString KOUSEI_MODO_KYU = new RString("0");

    public ShichosonSelectorHandler(ShichosonSelectorDiv div) {
        this.div = div;
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param 構成市町村選択情報 List<DbT7051KoseiShichosonMasterEntity>
     */
    public void set構成市町村情報一覧表示グリッド(List<DbT7051KoseiShichosonMasterEntity> 構成市町村選択情報) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (DbT7051KoseiShichosonMasterEntity entity : 構成市町村選択情報) {
            if (KOUSEI_MODO_KYU.equals(entity.getGappeiKyuShichosonKubun())) {
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
     * @param 旧市町村選択情報 List<DbT7056GappeiShichosonEntity>
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
     * @param 旧市町村 List<DbT7051KoseiShichosonMasterEntity>
     */
    public void set構成市町村情報By市町村モード(List<DbT7051KoseiShichosonMasterEntity> 旧市町村) {

        DataGrid<dgShichoson_Row> datagrid = div.getDgShichoson();
        List<dgShichoson_Row> rowList = new ArrayList();
        for (DbT7051KoseiShichosonMasterEntity entity : 旧市町村) {
            if (div.getRadShichosonKubun().getSelectedKey().equals(selectItemKyo)) {
                if (KOUSEI_MODO_KOUSEI.equals(entity.getGappeiKyuShichosonKubun())) {
                    dgShichoson_Row row = new dgShichoson_Row();
                    row.setTxtShichosonCode(entity.getShichosonCode().value());
                    row.setTxtShichosonName(entity.getShichosonMeisho());
                    rowList.add(row);
                }
            }

            if (div.getRadShichosonKubun().getSelectedKey().equals(selectItemKousei)) {
                if (KOUSEI_MODO_KYU.equals(entity.getGappeiKyuShichosonKubun())) {
                    dgShichoson_Row row = new dgShichoson_Row();
                    row.setTxtShichosonCode(entity.getShichosonCode().value());
                    row.setTxtShichosonName(entity.getShichosonMeisho());
                    rowList.add(row);
                }
            }

        }
        datagrid.setDataSource(rowList);
    }

    /**
     * onLoad 一覧表示
     *
     * @param DbT7056List List<DbT7056GappeiShichosonEntity>
     * @param DbT7051List List<DbT7051KoseiShichosonMasterEntity>
     */
    public void set一覧表示グリッド(List<DbT7056GappeiShichosonEntity> DbT7056List, List<DbT7051KoseiShichosonMasterEntity> DbT7051List) {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        RString 構成市町村モード = model.getShichosonModel();
        if (KOUSEI_MODO_KOUSEI.equals(構成市町村モード)) {
            div.getRadShichosonKubun().setDisplayNone(false);
        } else {
            div.getRadShichosonKubun().setDisplayNone(true);
        }
        if (KOUSEI_MODO_KYU.equals(構成市町村モード)) {
            set旧市町村選択情報一覧表示グリッド(DbT7056List);
        }
        if (KOUSEI_MODO_KOUSEI.equals(構成市町村モード)) {
            set構成市町村情報一覧表示グリッド(DbT7051List);
            ShichosonSelectorModel shichosonSelector = new ShichosonSelectorModel();
            shichosonSelector.setList(DbT7051List);
            div.setKyuShichoson(DataPassingConverter.serialize(shichosonSelector));
        }
    }
}
