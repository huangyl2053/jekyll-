package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RenrakuhyoHakkoshaPanel のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class RenrakuhyoHakkoshaPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRenrakuhyoHakkoshaMei")
    private TextBox txtRenrakuhyoHakkoshaMei;
    @JsonProperty("txtRenrakuhyoHakkoshaYubinNo")
    private TextBoxYubinNo txtRenrakuhyoHakkoshaYubinNo;
    @JsonProperty("txtRenrakuhyoHakkoshaJusho")
    private TextBox txtRenrakuhyoHakkoshaJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRenrakuhyoHakkoshaMei
     * @return txtRenrakuhyoHakkoshaMei
     */
    @JsonProperty("txtRenrakuhyoHakkoshaMei")
    public TextBox getTxtRenrakuhyoHakkoshaMei() {
        return txtRenrakuhyoHakkoshaMei;
    }

    /*
     * settxtRenrakuhyoHakkoshaMei
     * @param txtRenrakuhyoHakkoshaMei txtRenrakuhyoHakkoshaMei
     */
    @JsonProperty("txtRenrakuhyoHakkoshaMei")
    public void setTxtRenrakuhyoHakkoshaMei(TextBox txtRenrakuhyoHakkoshaMei) {
        this.txtRenrakuhyoHakkoshaMei = txtRenrakuhyoHakkoshaMei;
    }

    /*
     * gettxtRenrakuhyoHakkoshaYubinNo
     * @return txtRenrakuhyoHakkoshaYubinNo
     */
    @JsonProperty("txtRenrakuhyoHakkoshaYubinNo")
    public TextBoxYubinNo getTxtRenrakuhyoHakkoshaYubinNo() {
        return txtRenrakuhyoHakkoshaYubinNo;
    }

    /*
     * settxtRenrakuhyoHakkoshaYubinNo
     * @param txtRenrakuhyoHakkoshaYubinNo txtRenrakuhyoHakkoshaYubinNo
     */
    @JsonProperty("txtRenrakuhyoHakkoshaYubinNo")
    public void setTxtRenrakuhyoHakkoshaYubinNo(TextBoxYubinNo txtRenrakuhyoHakkoshaYubinNo) {
        this.txtRenrakuhyoHakkoshaYubinNo = txtRenrakuhyoHakkoshaYubinNo;
    }

    /*
     * gettxtRenrakuhyoHakkoshaJusho
     * @return txtRenrakuhyoHakkoshaJusho
     */
    @JsonProperty("txtRenrakuhyoHakkoshaJusho")
    public TextBox getTxtRenrakuhyoHakkoshaJusho() {
        return txtRenrakuhyoHakkoshaJusho;
    }

    /*
     * settxtRenrakuhyoHakkoshaJusho
     * @param txtRenrakuhyoHakkoshaJusho txtRenrakuhyoHakkoshaJusho
     */
    @JsonProperty("txtRenrakuhyoHakkoshaJusho")
    public void setTxtRenrakuhyoHakkoshaJusho(TextBox txtRenrakuhyoHakkoshaJusho) {
        this.txtRenrakuhyoHakkoshaJusho = txtRenrakuhyoHakkoshaJusho;
    }

    // </editor-fold>
}
