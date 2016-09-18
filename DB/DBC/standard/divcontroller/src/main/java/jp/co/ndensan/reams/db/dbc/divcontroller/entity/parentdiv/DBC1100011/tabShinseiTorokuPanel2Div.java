package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * tabShinseiTorokuPanel2 のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class tabShinseiTorokuPanel2Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuhoShikaku")
    private KokuhoShikakuDiv KokuhoShikaku;
    @JsonProperty("KokiShikaku")
    private KokiShikakuDiv KokiShikaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuhoShikaku
     * @return KokuhoShikaku
     */
    @JsonProperty("KokuhoShikaku")
    public KokuhoShikakuDiv getKokuhoShikaku() {
        return KokuhoShikaku;
    }

    /*
     * setKokuhoShikaku
     * @param KokuhoShikaku KokuhoShikaku
     */
    @JsonProperty("KokuhoShikaku")
    public void setKokuhoShikaku(KokuhoShikakuDiv KokuhoShikaku) {
        this.KokuhoShikaku = KokuhoShikaku;
    }

    /*
     * getKokiShikaku
     * @return KokiShikaku
     */
    @JsonProperty("KokiShikaku")
    public KokiShikakuDiv getKokiShikaku() {
        return KokiShikaku;
    }

    /*
     * setKokiShikaku
     * @param KokiShikaku KokiShikaku
     */
    @JsonProperty("KokiShikaku")
    public void setKokiShikaku(KokiShikakuDiv KokiShikaku) {
        this.KokiShikaku = KokiShikaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaNo() {
        return this.getKokuhoShikaku().getTxtKokuhoHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenshaNo(TextBox txtKokuhoHokenshaNo) {
        this.getKokuhoShikaku().setTxtKokuhoHokenshaNo(txtKokuhoHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaMeisho() {
        return this.getKokuhoShikaku().getTxtKokuhoHokenshaMeisho();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenshaMeisho(TextBox txtKokuhoHokenshaMeisho) {
        this.getKokuhoShikaku().setTxtKokuhoHokenshaMeisho(txtKokuhoHokenshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoKigo() {
        return this.getKokuhoShikaku().getTxtKokuhoHikonenshaShoKigo();
    }

    @JsonIgnore
    public void setTxtKokuhoHikonenshaShoKigo(TextBox txtKokuhoHikonenshaShoKigo) {
        this.getKokuhoShikaku().setTxtKokuhoHikonenshaShoKigo(txtKokuhoHikonenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoNo() {
        return this.getKokuhoShikaku().getTxtKokuhoHikonenshaShoNo();
    }

    @JsonIgnore
    public void setTxtKokuhoHikonenshaShoNo(TextBox txtKokuhoHikonenshaShoNo) {
        this.getKokuhoShikaku().setTxtKokuhoHikonenshaShoNo(txtKokuhoHikonenshaShoNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoSetaiNo() {
        return this.getKokuhoShikaku().getTxtKokuhoSetaiNo();
    }

    @JsonIgnore
    public void setTxtKokuhoSetaiNo(TextBox txtKokuhoSetaiNo) {
        this.getKokuhoShikaku().setTxtKokuhoSetaiNo(txtKokuhoSetaiNo);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoZokugara() {
        return this.getKokuhoShikaku().getTxtKokuhoZokugara();
    }

    @JsonIgnore
    public void setTxtKokuhoZokugara(DropDownList txtKokuhoZokugara) {
        this.getKokuhoShikaku().setTxtKokuhoZokugara(txtKokuhoZokugara);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoKanyuKikanYMD() {
        return this.getKokuhoShikaku().getTxtKokuhoKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKokuhoKanyuKikanYMD(TextBoxDateRange txtKokuhoKanyuKikanYMD) {
        this.getKokuhoShikaku().setTxtKokuhoKanyuKikanYMD(txtKokuhoKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtKokiHokenshaNo() {
        return this.getKokiShikaku().getTxtKokiHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokiHokenshaNo(TextBox txtKokiHokenshaNo) {
        this.getKokiShikaku().setTxtKokiHokenshaNo(txtKokiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokiKoikiRengoMeisho() {
        return this.getKokiShikaku().getTxtKokiKoikiRengoMeisho();
    }

    @JsonIgnore
    public void setTxtKokiKoikiRengoMeisho(TextBox txtKokiKoikiRengoMeisho) {
        this.getKokiShikaku().setTxtKokiKoikiRengoMeisho(txtKokiKoikiRengoMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokiHihokenshaNo() {
        return this.getKokiShikaku().getTxtKokiHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokiHihokenshaNo(TextBox txtKokiHihokenshaNo) {
        this.getKokiShikaku().setTxtKokiHihokenshaNo(txtKokiHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiKanyuKikanYMD() {
        return this.getKokiShikaku().getTxtKokiKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKokiKanyuKikanYMD(TextBoxDateRange txtKokiKanyuKikanYMD) {
        this.getKokiShikaku().setTxtKokiKanyuKikanYMD(txtKokiKanyuKikanYMD);
    }

    // </editor-fold>
}
