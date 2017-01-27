package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseishaWaritsukeKaijo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaWaritsukeKaijoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIkenshoSakuseiIraiDay")
    private TextBoxDate txtIkenshoSakuseiIraiDay;
    @JsonProperty("btnWaritsuke")
    private Button btnWaritsuke;
    @JsonProperty("btnKaijo")
    private Button btnKaijo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIkenshoSakuseiIraiDay
     * @return txtIkenshoSakuseiIraiDay
     */
    @JsonProperty("txtIkenshoSakuseiIraiDay")
    public TextBoxDate getTxtIkenshoSakuseiIraiDay() {
        return txtIkenshoSakuseiIraiDay;
    }

    /*
     * settxtIkenshoSakuseiIraiDay
     * @param txtIkenshoSakuseiIraiDay txtIkenshoSakuseiIraiDay
     */
    @JsonProperty("txtIkenshoSakuseiIraiDay")
    public void setTxtIkenshoSakuseiIraiDay(TextBoxDate txtIkenshoSakuseiIraiDay) {
        this.txtIkenshoSakuseiIraiDay = txtIkenshoSakuseiIraiDay;
    }

    /*
     * getbtnWaritsuke
     * @return btnWaritsuke
     */
    @JsonProperty("btnWaritsuke")
    public Button getBtnWaritsuke() {
        return btnWaritsuke;
    }

    /*
     * setbtnWaritsuke
     * @param btnWaritsuke btnWaritsuke
     */
    @JsonProperty("btnWaritsuke")
    public void setBtnWaritsuke(Button btnWaritsuke) {
        this.btnWaritsuke = btnWaritsuke;
    }

    /*
     * getbtnKaijo
     * @return btnKaijo
     */
    @JsonProperty("btnKaijo")
    public Button getBtnKaijo() {
        return btnKaijo;
    }

    /*
     * setbtnKaijo
     * @param btnKaijo btnKaijo
     */
    @JsonProperty("btnKaijo")
    public void setBtnKaijo(Button btnKaijo) {
        this.btnKaijo = btnKaijo;
    }

    // </editor-fold>
}
