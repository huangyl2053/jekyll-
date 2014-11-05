package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv.DataGridWidth;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv.BtnDisplayMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv.DisplayType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv.HokenshaJohoDisplayMode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * このコードはツールによって生成されました。
 */
public interface IShikakuTokusoRirekiDiv {

    public Button getBtnAdd();

    public void setBtnAdd(Button btnAdd);

    public DataGrid<dgShikakuShutokuRireki_Row> getDgShikakuShutokuRireki();

    public void setDgShikakuShutokuRireki(DataGrid<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki);

    public RString getMode();

    public void setMode(RString mode);

    public DataGridWidth getMode_DataGridWidth();

    public void setMode_DataGridWidth(DataGridWidth value);

    public HokenshaJohoDisplayMode getMode_HokenshaJohoDisplayMode();

    public void setMode_HokenshaJohoDisplayMode(HokenshaJohoDisplayMode value);

    public DisplayType getMode_DisplayType();

    public void setMode_DisplayType(DisplayType value);

    public BtnDisplayMode getMode_BtnDisplayMode();

    public void setMode_BtnDisplayMode(BtnDisplayMode value);

}
