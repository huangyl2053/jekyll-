package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * このコードはツールによって生成されました。
 */
public interface IShisetsuNyutaishoRirekiKanriDiv {

    Button getBtnAddShisetsuNyutaisho();

    DataGrid<dgShisetsuNyutaishoRireki_Row> getDgShisetsuNyutaishoRireki();

    RString getInputMode();

    RString getSelectRow();
}
