package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tbShinsakaiIinBetuTanka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbShinsakaiIinBetuTankaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBetuTsuika")
    private Button btnBetuTsuika;
    @JsonProperty("dgShinsakaiIinBetuTanka")
    private DataGrid<dgShinsakaiIinBetuTanka_Row> dgShinsakaiIinBetuTanka;
    @JsonProperty("shinsakaiIinBetuTankaMeisai")
    private shinsakaiIinBetuTankaMeisaiDiv shinsakaiIinBetuTankaMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBetuTsuika
     * @return btnBetuTsuika
     */
    @JsonProperty("btnBetuTsuika")
    public Button getBtnBetuTsuika() {
        return btnBetuTsuika;
    }

    /*
     * setbtnBetuTsuika
     * @param btnBetuTsuika btnBetuTsuika
     */
    @JsonProperty("btnBetuTsuika")
    public void setBtnBetuTsuika(Button btnBetuTsuika) {
        this.btnBetuTsuika = btnBetuTsuika;
    }

    /*
     * getdgShinsakaiIinBetuTanka
     * @return dgShinsakaiIinBetuTanka
     */
    @JsonProperty("dgShinsakaiIinBetuTanka")
    public DataGrid<dgShinsakaiIinBetuTanka_Row> getDgShinsakaiIinBetuTanka() {
        return dgShinsakaiIinBetuTanka;
    }

    /*
     * setdgShinsakaiIinBetuTanka
     * @param dgShinsakaiIinBetuTanka dgShinsakaiIinBetuTanka
     */
    @JsonProperty("dgShinsakaiIinBetuTanka")
    public void setDgShinsakaiIinBetuTanka(DataGrid<dgShinsakaiIinBetuTanka_Row> dgShinsakaiIinBetuTanka) {
        this.dgShinsakaiIinBetuTanka = dgShinsakaiIinBetuTanka;
    }

    /*
     * getshinsakaiIinBetuTankaMeisai
     * @return shinsakaiIinBetuTankaMeisai
     */
    @JsonProperty("shinsakaiIinBetuTankaMeisai")
    public shinsakaiIinBetuTankaMeisaiDiv getShinsakaiIinBetuTankaMeisai() {
        return shinsakaiIinBetuTankaMeisai;
    }

    /*
     * setshinsakaiIinBetuTankaMeisai
     * @param shinsakaiIinBetuTankaMeisai shinsakaiIinBetuTankaMeisai
     */
    @JsonProperty("shinsakaiIinBetuTankaMeisai")
    public void setShinsakaiIinBetuTankaMeisai(shinsakaiIinBetuTankaMeisaiDiv shinsakaiIinBetuTankaMeisai) {
        this.shinsakaiIinBetuTankaMeisai = shinsakaiIinBetuTankaMeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtBetuKaishiYM() {
        return this.getShinsakaiIinBetuTankaMeisai().getTxtBetuKaishiYM();
    }

    @JsonIgnore
    public void  setTxtBetuKaishiYM(TextBoxFlexibleYearMonth txtBetuKaishiYM) {
        this.getShinsakaiIinBetuTankaMeisai().setTxtBetuKaishiYM(txtBetuKaishiYM);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtBetuShuryoYM() {
        return this.getShinsakaiIinBetuTankaMeisai().getTxtBetuShuryoYM();
    }

    @JsonIgnore
    public void  setTxtBetuShuryoYM(TextBoxFlexibleYearMonth txtBetuShuryoYM) {
        this.getShinsakaiIinBetuTankaMeisai().setTxtBetuShuryoYM(txtBetuShuryoYM);
    }

    @JsonIgnore
    public TextBox getTxtShinsaIinKodo() {
        return this.getShinsakaiIinBetuTankaMeisai().getTxtShinsaIinKodo();
    }

    @JsonIgnore
    public void  setTxtShinsaIinKodo(TextBox txtShinsaIinKodo) {
        this.getShinsakaiIinBetuTankaMeisai().setTxtShinsaIinKodo(txtShinsaIinKodo);
    }

    @JsonIgnore
    public TextBoxNum getTxtBetuTanka() {
        return this.getShinsakaiIinBetuTankaMeisai().getTxtBetuTanka();
    }

    @JsonIgnore
    public void  setTxtBetuTanka(TextBoxNum txtBetuTanka) {
        this.getShinsakaiIinBetuTankaMeisai().setTxtBetuTanka(txtBetuTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtBetuSonotaTanka() {
        return this.getShinsakaiIinBetuTankaMeisai().getTxtBetuSonotaTanka();
    }

    @JsonIgnore
    public void  setTxtBetuSonotaTanka(TextBoxNum txtBetuSonotaTanka) {
        this.getShinsakaiIinBetuTankaMeisai().setTxtBetuSonotaTanka(txtBetuSonotaTanka);
    }

    @JsonIgnore
    public Button getBtnBetuKousin() {
        return this.getShinsakaiIinBetuTankaMeisai().getBtnBetuKousin();
    }

    @JsonIgnore
    public void  setBtnBetuKousin(Button btnBetuKousin) {
        this.getShinsakaiIinBetuTankaMeisai().setBtnBetuKousin(btnBetuKousin);
    }

    @JsonIgnore
    public Button getBtnBetuTorikesu() {
        return this.getShinsakaiIinBetuTankaMeisai().getBtnBetuTorikesu();
    }

    @JsonIgnore
    public void  setBtnBetuTorikesu(Button btnBetuTorikesu) {
        this.getShinsakaiIinBetuTankaMeisai().setBtnBetuTorikesu(btnBetuTorikesu);
    }

    // </editor-fold>
}
