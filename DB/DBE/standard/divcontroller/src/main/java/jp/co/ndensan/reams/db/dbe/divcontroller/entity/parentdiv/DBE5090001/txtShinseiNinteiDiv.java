package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * txtShinseiNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class txtShinseiNinteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("rdoShinseiNintei")
    private RadioButton rdoShinseiNintei;
    @JsonProperty("txtKijunYMD")
    private TextBoxDateRange txtKijunYMD;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getrdoShinseiNintei
     * @return rdoShinseiNintei
     */
    @JsonProperty("rdoShinseiNintei")
    public RadioButton getRdoShinseiNintei() {
        return rdoShinseiNintei;
    }

    /*
     * setrdoShinseiNintei
     * @param rdoShinseiNintei rdoShinseiNintei
     */
    @JsonProperty("rdoShinseiNintei")
    public void setRdoShinseiNintei(RadioButton rdoShinseiNintei) {
        this.rdoShinseiNintei = rdoShinseiNintei;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDateRange getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDateRange txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
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

    // </editor-fold>
}
