package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoState;
import jp.co.ndensan.reams.db.dbz.service.core.kaigohohenshisetsunyutaishoshakanri.KaigoHohenShisetsuNyutaishoshaKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * ShisetsuNyutaishoDialogButton のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetsuNyutaishoDialogButtonDiv extends Panel implements IShisetsuNyutaishoDialogButtonDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShisetsuNyutaisho")
    private ButtonDialog btnShisetsuNyutaisho;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("daichoShubetsu")
    private RString daichoShubetsu;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("gridData")
    private RString gridData;
    @JsonProperty("saveData")
    private RString saveData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShisetsuNyutaisho
     * @return btnShisetsuNyutaisho
     */
    @JsonProperty("btnShisetsuNyutaisho")
    public ButtonDialog getBtnShisetsuNyutaisho() {
        return btnShisetsuNyutaisho;
    }

    /*
     * setbtnShisetsuNyutaisho
     * @param btnShisetsuNyutaisho btnShisetsuNyutaisho
     */
    @JsonProperty("btnShisetsuNyutaisho")
    public void setBtnShisetsuNyutaisho(ButtonDialog btnShisetsuNyutaisho) {
        this.btnShisetsuNyutaisho = btnShisetsuNyutaisho;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * getdaichoShubetsu
     * @return daichoShubetsu
     */
    @JsonProperty("daichoShubetsu")
    public RString getDaichoShubetsu() {
        return daichoShubetsu;
    }

    /*
     * setdaichoShubetsu
     * @param daichoShubetsu daichoShubetsu
     */
    @JsonProperty("daichoShubetsu")
    public void setDaichoShubetsu(RString daichoShubetsu) {
        this.daichoShubetsu = daichoShubetsu;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * getgridData
     * @return gridData
     */
    @JsonProperty("gridData")
    public RString getGridData() {
        return gridData;
    }

    /*
     * setgridData
     * @param gridData gridData
     */
    @JsonProperty("gridData")
    public void setGridData(RString gridData) {
        this.gridData = gridData;
    }

    /*
     * getsaveData
     * @return saveData
     */
    @JsonProperty("saveData")
    public RString getSaveData() {
        return saveData;
    }

    /*
     * setsaveData
     * @param saveData saveData
     */
    @JsonProperty("saveData")
    public void setSaveData(RString saveData) {
        this.saveData = saveData;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShikibetsuCode shikibetsuCode, RString daichoShubetsu, ShisetsuNyutaishoState state) {
        this.setShikibetsuCode(shikibetsuCode.value());
        this.setDaichoShubetsu(daichoShubetsu);
        this.setMode(state.getStateValue());
    }

    @Override
    public void initialize(ShikibetsuCode shikibetsuCode, RString daichoShubetsu, ShisetsuNyutaishoState state,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Models) {
        initialize(shikibetsuCode, daichoShubetsu, state);
        this.setSaveData(DataPassingConverter.serialize(施設入退所情報Models));
    }

    @Override
    public int save() {
        if (this.getSaveData() == null || this.getSaveData().isEmpty()) {
            return 0;
        }

        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model = DataPassingConverter.deserialize(this.getSaveData(), Models.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode(this.getShikibetsuCode());

        return KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().save(施設入退所情報Model, 識別コード);
    }

    @Override
    public Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> get施設入退所データ() {
        if (this.getSaveData() == null || this.getSaveData().isEmpty()) {
            return Models.create(new ArrayList<ShisetsuNyutaisho>());
        }

        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model = DataPassingConverter.deserialize(this.getSaveData(), Models.class);
        return 施設入退所情報Model;
    }
}
