package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2400011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblRiyushoSakusei")
    private Label lblRiyushoSakusei;
    @JsonProperty("txtZenkaiRiyushoSakuseiShinseiYMD")
    private TextBoxDateRange txtZenkaiRiyushoSakuseiShinseiYMD;
    @JsonProperty("txtRiyushoSakuseiShinseiYMD")
    private TextBoxDateRange txtRiyushoSakuseiShinseiYMD;
    @JsonProperty("chkShoriTaishoKubun")
    private CheckBoxList chkShoriTaishoKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblRiyushoSakusei
     * @return lblRiyushoSakusei
     */
    @JsonProperty("lblRiyushoSakusei")
    public Label getLblRiyushoSakusei() {
        return lblRiyushoSakusei;
    }

    /*
     * setlblRiyushoSakusei
     * @param lblRiyushoSakusei lblRiyushoSakusei
     */
    @JsonProperty("lblRiyushoSakusei")
    public void setLblRiyushoSakusei(Label lblRiyushoSakusei) {
        this.lblRiyushoSakusei = lblRiyushoSakusei;
    }

    /*
     * gettxtZenkaiRiyushoSakuseiShinseiYMD
     * @return txtZenkaiRiyushoSakuseiShinseiYMD
     */
    @JsonProperty("txtZenkaiRiyushoSakuseiShinseiYMD")
    public TextBoxDateRange getTxtZenkaiRiyushoSakuseiShinseiYMD() {
        return txtZenkaiRiyushoSakuseiShinseiYMD;
    }

    /*
     * settxtZenkaiRiyushoSakuseiShinseiYMD
     * @param txtZenkaiRiyushoSakuseiShinseiYMD txtZenkaiRiyushoSakuseiShinseiYMD
     */
    @JsonProperty("txtZenkaiRiyushoSakuseiShinseiYMD")
    public void setTxtZenkaiRiyushoSakuseiShinseiYMD(TextBoxDateRange txtZenkaiRiyushoSakuseiShinseiYMD) {
        this.txtZenkaiRiyushoSakuseiShinseiYMD = txtZenkaiRiyushoSakuseiShinseiYMD;
    }

    /*
     * gettxtRiyushoSakuseiShinseiYMD
     * @return txtRiyushoSakuseiShinseiYMD
     */
    @JsonProperty("txtRiyushoSakuseiShinseiYMD")
    public TextBoxDateRange getTxtRiyushoSakuseiShinseiYMD() {
        return txtRiyushoSakuseiShinseiYMD;
    }

    /*
     * settxtRiyushoSakuseiShinseiYMD
     * @param txtRiyushoSakuseiShinseiYMD txtRiyushoSakuseiShinseiYMD
     */
    @JsonProperty("txtRiyushoSakuseiShinseiYMD")
    public void setTxtRiyushoSakuseiShinseiYMD(TextBoxDateRange txtRiyushoSakuseiShinseiYMD) {
        this.txtRiyushoSakuseiShinseiYMD = txtRiyushoSakuseiShinseiYMD;
    }

    /*
     * getchkShoriTaishoKubun
     * @return chkShoriTaishoKubun
     */
    @JsonProperty("chkShoriTaishoKubun")
    public CheckBoxList getChkShoriTaishoKubun() {
        return chkShoriTaishoKubun;
    }

    /*
     * setchkShoriTaishoKubun
     * @param chkShoriTaishoKubun chkShoriTaishoKubun
     */
    @JsonProperty("chkShoriTaishoKubun")
    public void setChkShoriTaishoKubun(CheckBoxList chkShoriTaishoKubun) {
        this.chkShoriTaishoKubun = chkShoriTaishoKubun;
    }

    // </editor-fold>
}
