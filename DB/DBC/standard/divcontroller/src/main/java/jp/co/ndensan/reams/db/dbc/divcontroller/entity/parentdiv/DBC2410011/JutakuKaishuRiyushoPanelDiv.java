package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuRiyushoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuRiyushoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRiyushoSakuseiYMD")
    private TextBoxDate txtRiyushoSakuseiYMD;
    @JsonProperty("txtRiyushoSakuseishaMeiKana")
    private TextBoxKana txtRiyushoSakuseishaMeiKana;
    @JsonProperty("txtRiyushoSakuseishaMei")
    private TextBox txtRiyushoSakuseishaMei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRiyushoSakuseiYMD
     * @return txtRiyushoSakuseiYMD
     */
    @JsonProperty("txtRiyushoSakuseiYMD")
    public TextBoxDate getTxtRiyushoSakuseiYMD() {
        return txtRiyushoSakuseiYMD;
    }

    /*
     * settxtRiyushoSakuseiYMD
     * @param txtRiyushoSakuseiYMD txtRiyushoSakuseiYMD
     */
    @JsonProperty("txtRiyushoSakuseiYMD")
    public void setTxtRiyushoSakuseiYMD(TextBoxDate txtRiyushoSakuseiYMD) {
        this.txtRiyushoSakuseiYMD = txtRiyushoSakuseiYMD;
    }

    /*
     * gettxtRiyushoSakuseishaMeiKana
     * @return txtRiyushoSakuseishaMeiKana
     */
    @JsonProperty("txtRiyushoSakuseishaMeiKana")
    public TextBoxKana getTxtRiyushoSakuseishaMeiKana() {
        return txtRiyushoSakuseishaMeiKana;
    }

    /*
     * settxtRiyushoSakuseishaMeiKana
     * @param txtRiyushoSakuseishaMeiKana txtRiyushoSakuseishaMeiKana
     */
    @JsonProperty("txtRiyushoSakuseishaMeiKana")
    public void setTxtRiyushoSakuseishaMeiKana(TextBoxKana txtRiyushoSakuseishaMeiKana) {
        this.txtRiyushoSakuseishaMeiKana = txtRiyushoSakuseishaMeiKana;
    }

    /*
     * gettxtRiyushoSakuseishaMei
     * @return txtRiyushoSakuseishaMei
     */
    @JsonProperty("txtRiyushoSakuseishaMei")
    public TextBox getTxtRiyushoSakuseishaMei() {
        return txtRiyushoSakuseishaMei;
    }

    /*
     * settxtRiyushoSakuseishaMei
     * @param txtRiyushoSakuseishaMei txtRiyushoSakuseishaMei
     */
    @JsonProperty("txtRiyushoSakuseishaMei")
    public void setTxtRiyushoSakuseishaMei(TextBox txtRiyushoSakuseishaMei) {
        this.txtRiyushoSakuseishaMei = txtRiyushoSakuseishaMei;
    }

    // </editor-fold>
}
