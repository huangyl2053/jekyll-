package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RofukuNenkinState;
import jp.co.ndensan.reams.db.dbz.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * RofukuNenkinDialogButton のクラスファイル
 *
 * @author 自動生成
 */
public class RofukuNenkinDialogButtonDiv extends Panel implements IRofukuNenkinDialogButtonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnRofukuNenkin")
    private ButtonDialog btnRofukuNenkin;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("saveData")
    private RString saveData;
    @JsonProperty("gridData")
    private RString gridData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnRofukuNenkin
     * @return btnRofukuNenkin
     */
    @JsonProperty("btnRofukuNenkin")
    public ButtonDialog getBtnRofukuNenkin() {
        return btnRofukuNenkin;
    }

    /*
     * setbtnRofukuNenkin
     * @param btnRofukuNenkin btnRofukuNenkin
     */
    @JsonProperty("btnRofukuNenkin")
    public void setBtnRofukuNenkin(ButtonDialog btnRofukuNenkin) {
        this.btnRofukuNenkin = btnRofukuNenkin;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(HihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode, RofukuNenkinState state) {
        this.setShikibetsuCode(shikibetsuCode.value());
        this.setHihokenshaNo(hihokenshaNo.value());
        this.setMode(state.getStateValue());
    }

    @Override
    public int save() {
        if (this.getSaveData() == null || this.getSaveData().isEmpty()) {
            return 0;
        }

        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                = DataPassingConverter.deserialize(this.getSaveData(), Models.class);
        if (roreiFukushiNenkinJukyusha == null) {
            return 0;
        }
        RoreiFukushiNenkinJukyushaManager manager = RoreiFukushiNenkinJukyushaManager.createInstance();
        return manager.save老齢福祉年金受給者All(roreiFukushiNenkinJukyusha);
    }
}
