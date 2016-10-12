package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HosokuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HosokuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    private TextBox txtRiyoshaFutanDankai;
    @JsonProperty("btnDispSetaiJoho")
    private Button btnDispSetaiJoho;
    @JsonProperty("btnCloseSetaiJoho")
    private Button btnCloseSetaiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRiyoshaFutanDankai
     * @return txtRiyoshaFutanDankai
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    public TextBox getTxtRiyoshaFutanDankai() {
        return txtRiyoshaFutanDankai;
    }

    /*
     * settxtRiyoshaFutanDankai
     * @param txtRiyoshaFutanDankai txtRiyoshaFutanDankai
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    public void setTxtRiyoshaFutanDankai(TextBox txtRiyoshaFutanDankai) {
        this.txtRiyoshaFutanDankai = txtRiyoshaFutanDankai;
    }

    /*
     * getbtnDispSetaiJoho
     * @return btnDispSetaiJoho
     */
    @JsonProperty("btnDispSetaiJoho")
    public Button getBtnDispSetaiJoho() {
        return btnDispSetaiJoho;
    }

    /*
     * setbtnDispSetaiJoho
     * @param btnDispSetaiJoho btnDispSetaiJoho
     */
    @JsonProperty("btnDispSetaiJoho")
    public void setBtnDispSetaiJoho(Button btnDispSetaiJoho) {
        this.btnDispSetaiJoho = btnDispSetaiJoho;
    }

    /*
     * getbtnCloseSetaiJoho
     * @return btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public Button getBtnCloseSetaiJoho() {
        return btnCloseSetaiJoho;
    }

    /*
     * setbtnCloseSetaiJoho
     * @param btnCloseSetaiJoho btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public void setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.btnCloseSetaiJoho = btnCloseSetaiJoho;
    }

    // </editor-fold>
}
