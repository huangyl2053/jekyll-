package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KubunShikyuGendogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KubunShikyuGendogakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DgSerShurui")
    private DgSerShuruiDiv DgSerShurui;
    @JsonProperty("ServiceShuruiShousai")
    private ServiceShuruiShousaiDiv ServiceShuruiShousai;
    @JsonProperty("Kanryo")
    private KanryoDiv Kanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDgSerShurui
     * @return DgSerShurui
     */
    @JsonProperty("DgSerShurui")
    public DgSerShuruiDiv getDgSerShurui() {
        return DgSerShurui;
    }

    /*
     * setDgSerShurui
     * @param DgSerShurui DgSerShurui
     */
    @JsonProperty("DgSerShurui")
    public void setDgSerShurui(DgSerShuruiDiv DgSerShurui) {
        this.DgSerShurui = DgSerShurui;
    }

    /*
     * getServiceShuruiShousai
     * @return ServiceShuruiShousai
     */
    @JsonProperty("ServiceShuruiShousai")
    public ServiceShuruiShousaiDiv getServiceShuruiShousai() {
        return ServiceShuruiShousai;
    }

    /*
     * setServiceShuruiShousai
     * @param ServiceShuruiShousai ServiceShuruiShousai
     */
    @JsonProperty("ServiceShuruiShousai")
    public void setServiceShuruiShousai(ServiceShuruiShousaiDiv ServiceShuruiShousai) {
        this.ServiceShuruiShousai = ServiceShuruiShousai;
    }

    /*
     * getKanryo
     * @return Kanryo
     */
    @JsonProperty("Kanryo")
    public KanryoDiv getKanryo() {
        return Kanryo;
    }

    /*
     * setKanryo
     * @param Kanryo Kanryo
     */
    @JsonProperty("Kanryo")
    public void setKanryo(KanryoDiv Kanryo) {
        this.Kanryo = Kanryo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnTsuika() {
        return this.getDgSerShurui().getBtnTsuika();
    }

    @JsonIgnore
    public void  setBtnTsuika(Button btnTsuika) {
        this.getDgSerShurui().setBtnTsuika(btnTsuika);
    }

    @JsonIgnore
    public DataGrid<dgServiceShurui_Row> getDgServiceShurui() {
        return this.getDgSerShurui().getDgServiceShurui();
    }

    @JsonIgnore
    public void  setDgServiceShurui(DataGrid<dgServiceShurui_Row> dgServiceShurui) {
        this.getDgSerShurui().setDgServiceShurui(dgServiceShurui);
    }

    // </editor-fold>
}
