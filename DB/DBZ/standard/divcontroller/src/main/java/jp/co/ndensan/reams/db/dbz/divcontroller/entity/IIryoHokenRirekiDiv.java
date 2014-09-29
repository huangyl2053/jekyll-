package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IryoHokenRirekiDiv.DisplayMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IryoHokenRirekiDiv.WidthMode;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * このコードはツールによって生成されました。
 */
public interface IIryoHokenRirekiDiv {

    DataGrid<dgIryoHokenRireki_Row> getDgIryoHokenRireki();

    void setDgIryoHokenRireki(DataGrid<dgIryoHokenRireki_Row> dgIryoHokenRireki);

    /**
     * 状態（登録・照会）モードを設定します。
     *
     * @return
     */
    DisplayMode getMode_DisplayMode();

    void setMode_DisplayMode(IryoHokenRirekiDiv.DisplayMode value);

    /**
     * 状態（幅）モードを設定します。
     *
     * @return
     */
    WidthMode getMode_WidthMode();

    void setMode_WidthMode(IryoHokenRirekiDiv.WidthMode value);

    /**
     * この共有DiVを初期します。
     */
    void initialize();

    /**
     * 追加ボタンを設定します。
     */
    void onClick_btnAddIryoHoken();

    /**
     * 保存ボタンを設定します。
     */
    void onClick_btnAddUpdate();

    /**
     * この共有DiVに設定されているデータを全てクリアします。
     */
    void clear();
}
