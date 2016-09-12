package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaNoSaiban のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaNoSaibanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShisho")
    private DropDownList ddlShisho;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("btnSaiban")
    private Button btnSaiban;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShisho
     * @return ddlShisho
     */
    @JsonProperty("ddlShisho")
    public DropDownList getDdlShisho() {
        return ddlShisho;
    }

    /*
     * setddlShisho
     * @param ddlShisho ddlShisho
     */
    @JsonProperty("ddlShisho")
    public void setDdlShisho(DropDownList ddlShisho) {
        this.ddlShisho = ddlShisho;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getbtnSaiban
     * @return btnSaiban
     */
    @JsonProperty("btnSaiban")
    public Button getBtnSaiban() {
        return btnSaiban;
    }

    /*
     * setbtnSaiban
     * @param btnSaiban btnSaiban
     */
    @JsonProperty("btnSaiban")
    public void setBtnSaiban(Button btnSaiban) {
        this.btnSaiban = btnSaiban;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
