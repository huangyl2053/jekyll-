package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.IRoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RofukuNenkinDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class RofukuNenkinDialogDiv extends Panel implements IRofukuNenkinDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdRofukuNenkinRireki")
    private RoreiFukushiNenkinShokaiDiv ccdRofukuNenkinRireki;
    @JsonProperty("btnClose")
    private Button btnClose;
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
     * getccdRofukuNenkinRireki
     * @return ccdRofukuNenkinRireki
     */
    @JsonProperty("ccdRofukuNenkinRireki")
    public IRoreiFukushiNenkinShokaiDiv getCcdRofukuNenkinRireki() {
        return ccdRofukuNenkinRireki;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
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

}
