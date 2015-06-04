package jp.co.ndensan.reams.db.dbd.divcontroller.entity.TestZenkaiNinteiKekkaJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TestZenkaiNinteiKekkaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TestZenkaiNinteiKekkaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txthdnShinseishoKanriNo")
    private TextBox txthdnShinseishoKanriNo;
    @JsonProperty("txthdnDatabaseSubGyomuCode")
    private TextBox txthdnDatabaseSubGyomuCode;
    @JsonProperty("btnSetinput")
    private Button btnSetinput;
    @JsonProperty("Hline1")
    private HorizontalLine Hline1;
    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    private ZenkaiNinteiKekkaJohoDiv ccdZenkaiNinteiKekkaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txthdnShinseishoKanriNo")
    public TextBox getTxthdnShinseishoKanriNo() {
        return txthdnShinseishoKanriNo;
    }

    @JsonProperty("txthdnShinseishoKanriNo")
    public void setTxthdnShinseishoKanriNo(TextBox txthdnShinseishoKanriNo) {
        this.txthdnShinseishoKanriNo=txthdnShinseishoKanriNo;
    }

    @JsonProperty("txthdnDatabaseSubGyomuCode")
    public TextBox getTxthdnDatabaseSubGyomuCode() {
        return txthdnDatabaseSubGyomuCode;
    }

    @JsonProperty("txthdnDatabaseSubGyomuCode")
    public void setTxthdnDatabaseSubGyomuCode(TextBox txthdnDatabaseSubGyomuCode) {
        this.txthdnDatabaseSubGyomuCode=txthdnDatabaseSubGyomuCode;
    }

    @JsonProperty("btnSetinput")
    public Button getBtnSetinput() {
        return btnSetinput;
    }

    @JsonProperty("btnSetinput")
    public void setBtnSetinput(Button btnSetinput) {
        this.btnSetinput=btnSetinput;
    }

    @JsonProperty("Hline1")
    public HorizontalLine getHline1() {
        return Hline1;
    }

    @JsonProperty("Hline1")
    public void setHline1(HorizontalLine Hline1) {
        this.Hline1=Hline1;
    }

    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return ccdZenkaiNinteiKekkaJoho;
    }

    // </editor-fold>
}
