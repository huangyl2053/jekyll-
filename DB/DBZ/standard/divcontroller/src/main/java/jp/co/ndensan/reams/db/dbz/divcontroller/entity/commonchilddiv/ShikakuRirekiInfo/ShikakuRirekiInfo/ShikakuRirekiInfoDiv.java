package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuRirekiInfo.ShikakuRirekiInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuRirekiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuRirekiInfoDiv extends Panel implements IShikakuRirekiInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShikakuRirekiInfo")
    private DataGrid<dgShikakuRirekiInfo_Row> dgShikakuRirekiInfo;
    @JsonProperty("BtnClose")
    private Button BtnClose;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShikakuRirekiInfo
     * @return dgShikakuRirekiInfo
     */
    @JsonProperty("dgShikakuRirekiInfo")
    public DataGrid<dgShikakuRirekiInfo_Row> getDgShikakuRirekiInfo() {
        return dgShikakuRirekiInfo;
    }

    /*
     * setdgShikakuRirekiInfo
     * @param dgShikakuRirekiInfo dgShikakuRirekiInfo
     */
    @JsonProperty("dgShikakuRirekiInfo")
    public void setDgShikakuRirekiInfo(DataGrid<dgShikakuRirekiInfo_Row> dgShikakuRirekiInfo) {
        this.dgShikakuRirekiInfo = dgShikakuRirekiInfo;
    }

    /*
     * getBtnClose
     * @return BtnClose
     */
    @JsonProperty("BtnClose")
    public Button getBtnClose() {
        return BtnClose;
    }

    /*
     * setBtnClose
     * @param BtnClose BtnClose
     */
    @JsonProperty("BtnClose")
    public void setBtnClose(Button BtnClose) {
        this.BtnClose = BtnClose;
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
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
