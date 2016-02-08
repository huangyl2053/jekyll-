package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ServiceTypeCommonChildDiv のクラスファイル
 *
 * @author 自動生成
 */
public class ServiceTypeCommonChildDivDiv extends Panel implements IServiceTypeCommonChildDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("serviceType")
    private RString serviceType;

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
     * getserviceType
     * @return serviceType
     */
    @JsonProperty("serviceType")
    public RString getServiceType() {
        return serviceType;
    }

    /*
     * setserviceType
     * @param serviceType serviceType
     */
    @JsonProperty("serviceType")
    public void setServiceType(RString serviceType) {
        this.serviceType = serviceType;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void clear() {
        getHandler().clear();
    }

    @JsonIgnore
    private ServiceTypeCommonChildHandler getHandler() {
        return new ServiceTypeCommonChildHandler(this);
    }
}
