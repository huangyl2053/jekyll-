package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv;
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
 * ServiceTypeInputCommonChildDiv のクラスファイル
 *
 * @author 自動生成
 */
public class ServiceTypeInputCommonChildDivDiv extends Panel implements IServiceTypeInputCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceType")
    private TextBoxCode txtServiceType;
    @JsonProperty("btnKensaku")
    private ButtonDialog btnKensaku;
    @JsonProperty("txtServiceTypeName")
    private TextBox txtServiceTypeName;
    @JsonProperty("serviceType")
    private RString serviceType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceType
     * @return txtServiceType
     */
    @JsonProperty("txtServiceType")
    public TextBoxCode getTxtServiceType() {
        return txtServiceType;
    }

    /*
     * settxtServiceType
     * @param txtServiceType txtServiceType
     */
    @JsonProperty("txtServiceType")
    public void setTxtServiceType(TextBoxCode txtServiceType) {
        this.txtServiceType = txtServiceType;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public ButtonDialog getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(ButtonDialog btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * gettxtServiceTypeName
     * @return txtServiceTypeName
     */
    @JsonProperty("txtServiceTypeName")
    public TextBox getTxtServiceTypeName() {
        return txtServiceTypeName;
    }

    /*
     * settxtServiceTypeName
     * @param txtServiceTypeName txtServiceTypeName
     */
    @JsonProperty("txtServiceTypeName")
    public void setTxtServiceTypeName(TextBox txtServiceTypeName) {
        this.txtServiceTypeName = txtServiceTypeName;
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
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @JsonIgnore
    private ServiceTypeInputCommonChildHandler getHandler() {
        return new ServiceTypeInputCommonChildHandler(this);
    }
}
