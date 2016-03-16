package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IdoTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IdoTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTsuchishoMeisho")
    private DropDownList ddlTsuchishoMeisho;
    @JsonProperty("ddlSakuseiYMD")
    private DropDownList ddlSakuseiYMD;
    @JsonProperty("btnIdoShaCheck")
    private Button btnIdoShaCheck;
    @JsonProperty("txtLastKeisanShoriTime")
    private TextBox txtLastKeisanShoriTime;
    @JsonProperty("dgIdoTaishoshaIchiran")
    private DataGrid<dgIdoTaishoshaIchiran_Row> dgIdoTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTsuchishoMeisho
     * @return ddlTsuchishoMeisho
     */
    @JsonProperty("ddlTsuchishoMeisho")
    public DropDownList getDdlTsuchishoMeisho() {
        return ddlTsuchishoMeisho;
    }

    /*
     * setddlTsuchishoMeisho
     * @param ddlTsuchishoMeisho ddlTsuchishoMeisho
     */
    @JsonProperty("ddlTsuchishoMeisho")
    public void setDdlTsuchishoMeisho(DropDownList ddlTsuchishoMeisho) {
        this.ddlTsuchishoMeisho = ddlTsuchishoMeisho;
    }

    /*
     * getddlSakuseiYMD
     * @return ddlSakuseiYMD
     */
    @JsonProperty("ddlSakuseiYMD")
    public DropDownList getDdlSakuseiYMD() {
        return ddlSakuseiYMD;
    }

    /*
     * setddlSakuseiYMD
     * @param ddlSakuseiYMD ddlSakuseiYMD
     */
    @JsonProperty("ddlSakuseiYMD")
    public void setDdlSakuseiYMD(DropDownList ddlSakuseiYMD) {
        this.ddlSakuseiYMD = ddlSakuseiYMD;
    }

    /*
     * getbtnIdoShaCheck
     * @return btnIdoShaCheck
     */
    @JsonProperty("btnIdoShaCheck")
    public Button getBtnIdoShaCheck() {
        return btnIdoShaCheck;
    }

    /*
     * setbtnIdoShaCheck
     * @param btnIdoShaCheck btnIdoShaCheck
     */
    @JsonProperty("btnIdoShaCheck")
    public void setBtnIdoShaCheck(Button btnIdoShaCheck) {
        this.btnIdoShaCheck = btnIdoShaCheck;
    }

    /*
     * gettxtLastKeisanShoriTime
     * @return txtLastKeisanShoriTime
     */
    @JsonProperty("txtLastKeisanShoriTime")
    public TextBox getTxtLastKeisanShoriTime() {
        return txtLastKeisanShoriTime;
    }

    /*
     * settxtLastKeisanShoriTime
     * @param txtLastKeisanShoriTime txtLastKeisanShoriTime
     */
    @JsonProperty("txtLastKeisanShoriTime")
    public void setTxtLastKeisanShoriTime(TextBox txtLastKeisanShoriTime) {
        this.txtLastKeisanShoriTime = txtLastKeisanShoriTime;
    }

    /*
     * getdgIdoTaishoshaIchiran
     * @return dgIdoTaishoshaIchiran
     */
    @JsonProperty("dgIdoTaishoshaIchiran")
    public DataGrid<dgIdoTaishoshaIchiran_Row> getDgIdoTaishoshaIchiran() {
        return dgIdoTaishoshaIchiran;
    }

    /*
     * setdgIdoTaishoshaIchiran
     * @param dgIdoTaishoshaIchiran dgIdoTaishoshaIchiran
     */
    @JsonProperty("dgIdoTaishoshaIchiran")
    public void setDgIdoTaishoshaIchiran(DataGrid<dgIdoTaishoshaIchiran_Row> dgIdoTaishoshaIchiran) {
        this.dgIdoTaishoshaIchiran = dgIdoTaishoshaIchiran;
    }

    // </editor-fold>
}
