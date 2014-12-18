package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist;

import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 共有子Div「証回収状況List」で、外部に公開する処理をまとめたインターフェースです。
 */
public interface IShoKaishuJokyoListDiv {

    /**
     * 証回収状況Listを返します。
     *
     * @return 証回収状況List
     */
    DataGrid<dgShoKaishuJokyo_Row> getDgShoKaishuJokyo();
}
