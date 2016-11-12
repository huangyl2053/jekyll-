package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * ServiceTypeCommonChildDiv のクラスファイル
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
 */
public class ServiceTypeCommonChildDivDiv extends Panel implements IServiceTypeCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgServiceType")
    private DataGrid<dgServiceType_Row> dgServiceType;
    @JsonProperty("btnYameru")
    private Button btnYameru;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hdnServiceType")
    private RString hdnServiceType;
    @JsonProperty("hdnServiceTypeName")
    private RString hdnServiceTypeName;
    @JsonProperty("hdnServiceRyakusho")
    private RString hdnServiceRyakusho;
    @JsonProperty("hdnServiceModel")
    private RString hdnServiceModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgServiceType
     * @return dgServiceType
     */
    @JsonProperty("dgServiceType")
    public DataGrid<dgServiceType_Row> getDgServiceType() {
        return dgServiceType;
    }

    /*
     * setdgServiceType
     * @param dgServiceType dgServiceType
     */
    @JsonProperty("dgServiceType")
    public void setDgServiceType(DataGrid<dgServiceType_Row> dgServiceType) {
        this.dgServiceType = dgServiceType;
    }

    /*
     * getbtnYameru
     * @return btnYameru
     */
    @JsonProperty("btnYameru")
    public Button getBtnYameru() {
        return btnYameru;
    }

    /*
     * setbtnYameru
     * @param btnYameru btnYameru
     */
    @JsonProperty("btnYameru")
    public void setBtnYameru(Button btnYameru) {
        this.btnYameru = btnYameru;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * gethdnServiceType
     * @return hdnServiceType
     */
    @JsonProperty("hdnServiceType")
    public RString getHdnServiceType() {
        return hdnServiceType;
    }

    /*
     * sethdnServiceType
     * @param hdnServiceType hdnServiceType
     */
    @JsonProperty("hdnServiceType")
    public void setHdnServiceType(RString hdnServiceType) {
        this.hdnServiceType = hdnServiceType;
    }

    /*
     * gethdnServiceTypeName
     * @return hdnServiceTypeName
     */
    @JsonProperty("hdnServiceTypeName")
    public RString getHdnServiceTypeName() {
        return hdnServiceTypeName;
    }

    /*
     * sethdnServiceTypeName
     * @param hdnServiceTypeName hdnServiceTypeName
     */
    @JsonProperty("hdnServiceTypeName")
    public void setHdnServiceTypeName(RString hdnServiceTypeName) {
        this.hdnServiceTypeName = hdnServiceTypeName;
    }

    /*
     * gethdnServiceRyakusho
     * @return hdnServiceRyakusho
     */
    @JsonProperty("hdnServiceRyakusho")
    public RString getHdnServiceRyakusho() {
        return hdnServiceRyakusho;
    }

    /*
     * sethdnServiceRyakusho
     * @param hdnServiceRyakusho hdnServiceRyakusho
     */
    @JsonProperty("hdnServiceRyakusho")
    public void setHdnServiceRyakusho(RString hdnServiceRyakusho) {
        this.hdnServiceRyakusho = hdnServiceRyakusho;
    }

    /*
     * gethdnServiceModel
     * @return hdnServiceModel
     */
    @JsonProperty("hdnServiceModel")
    public RString getHdnServiceModel() {
        return hdnServiceModel;
    }

    /*
     * sethdnServiceModel
     * @param hdnServiceModel hdnServiceModel
     */
    @JsonProperty("hdnServiceModel")
    public void setHdnServiceModel(RString hdnServiceModel) {
        this.hdnServiceModel = hdnServiceModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
