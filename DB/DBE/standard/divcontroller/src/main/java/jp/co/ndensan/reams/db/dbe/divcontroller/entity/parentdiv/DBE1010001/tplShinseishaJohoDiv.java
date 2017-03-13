package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShinseishaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinseishaJohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlShinseishaJoho")
    private pnlShinseishaJohoDiv pnlShinseishaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlShinseishaJoho
     * @return pnlShinseishaJoho
     */
    @JsonProperty("pnlShinseishaJoho")
    public pnlShinseishaJohoDiv getPnlShinseishaJoho() {
        return pnlShinseishaJoho;
    }

    /*
     * setpnlShinseishaJoho
     * @param pnlShinseishaJoho pnlShinseishaJoho
     */
    @JsonProperty("pnlShinseishaJoho")
    public void setPnlShinseishaJoho(pnlShinseishaJohoDiv pnlShinseishaJoho) {
        this.pnlShinseishaJoho = pnlShinseishaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxAtenaMeisho getTxtJohoAtenaMeisho() {
        return this.getPnlShinseishaJoho().getTxtJohoAtenaMeisho();
    }

    @JsonIgnore
    public void  setTxtJohoAtenaMeisho(TextBoxAtenaMeisho txtJohoAtenaMeisho) {
        this.getPnlShinseishaJoho().setTxtJohoAtenaMeisho(txtJohoAtenaMeisho);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtJohoAtenaKanaMeisho() {
        return this.getPnlShinseishaJoho().getTxtJohoAtenaKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtJohoAtenaKanaMeisho(TextBoxAtenaKanaMeisho txtJohoAtenaKanaMeisho) {
        this.getPnlShinseishaJoho().setTxtJohoAtenaKanaMeisho(txtJohoAtenaKanaMeisho);
    }

    @JsonIgnore
    public TextBoxDate getTxtJohoBirthday() {
        return this.getPnlShinseishaJoho().getTxtJohoBirthday();
    }

    @JsonIgnore
    public void  setTxtJohoBirthday(TextBoxDate txtJohoBirthday) {
        this.getPnlShinseishaJoho().setTxtJohoBirthday(txtJohoBirthday);
    }

    @JsonIgnore
    public RadioButton getRadJohoSeibetsu() {
        return this.getPnlShinseishaJoho().getRadJohoSeibetsu();
    }

    @JsonIgnore
    public void  setRadJohoSeibetsu(RadioButton radJohoSeibetsu) {
        this.getPnlShinseishaJoho().setRadJohoSeibetsu(radJohoSeibetsu);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtJohoYubinNo() {
        return this.getPnlShinseishaJoho().getTxtJohoYubinNo();
    }

    @JsonIgnore
    public void  setTxtJohoYubinNo(TextBoxYubinNo txtJohoYubinNo) {
        this.getPnlShinseishaJoho().setTxtJohoYubinNo(txtJohoYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJohoJusho() {
        return this.getPnlShinseishaJoho().getTxtJohoJusho();
    }

    @JsonIgnore
    public void  setTxtJohoJusho(TextBoxJusho txtJohoJusho) {
        this.getPnlShinseishaJoho().setTxtJohoJusho(txtJohoJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJohoTelNo() {
        return this.getPnlShinseishaJoho().getTxtJohoTelNo();
    }

    @JsonIgnore
    public void  setTxtJohoTelNo(TextBoxTelNo txtJohoTelNo) {
        this.getPnlShinseishaJoho().setTxtJohoTelNo(txtJohoTelNo);
    }

    @JsonIgnore
    public TextBox getTxtJohoNenrei() {
        return this.getPnlShinseishaJoho().getTxtJohoNenrei();
    }

    @JsonIgnore
    public void  setTxtJohoNenrei(TextBox txtJohoNenrei) {
        this.getPnlShinseishaJoho().setTxtJohoNenrei(txtJohoNenrei);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdShozokuShichoson() {
        return this.getPnlShinseishaJoho().getCcdShozokuShichoson();
    }

    // </editor-fold>
}
