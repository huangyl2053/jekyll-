package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanGuide.ShujiiIryokikanGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HokenshaList")
    private HokenshaListDiv HokenshaList;
    @JsonProperty("txtIryoKikanCodeFrom")
    private TextBoxCode txtIryoKikanCodeFrom;
    @JsonProperty("txtIryoKikanCodeTo")
    private TextBoxCode txtIryoKikanCodeTo;
    @JsonProperty("radIryoKikanJokyo")
    private RadioButton radIryoKikanJokyo;
    @JsonProperty("txtIryoKikanName")
    private TextBox txtIryoKikanName;
    @JsonProperty("txtIryoKikanKanaMeisho")
    private TextBox txtIryoKikanKanaMeisho;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHokenshaList
     * @return HokenshaList
     */
    @JsonProperty("HokenshaList")
    public IHokenshaListDiv getHokenshaList() {
        return HokenshaList;
    }

    /*
     * gettxtIryoKikanCodeFrom
     * @return txtIryoKikanCodeFrom
     */
    @JsonProperty("txtIryoKikanCodeFrom")
    public TextBoxCode getTxtIryoKikanCodeFrom() {
        return txtIryoKikanCodeFrom;
    }

    /*
     * settxtIryoKikanCodeFrom
     * @param txtIryoKikanCodeFrom txtIryoKikanCodeFrom
     */
    @JsonProperty("txtIryoKikanCodeFrom")
    public void setTxtIryoKikanCodeFrom(TextBoxCode txtIryoKikanCodeFrom) {
        this.txtIryoKikanCodeFrom = txtIryoKikanCodeFrom;
    }

    /*
     * gettxtIryoKikanCodeTo
     * @return txtIryoKikanCodeTo
     */
    @JsonProperty("txtIryoKikanCodeTo")
    public TextBoxCode getTxtIryoKikanCodeTo() {
        return txtIryoKikanCodeTo;
    }

    /*
     * settxtIryoKikanCodeTo
     * @param txtIryoKikanCodeTo txtIryoKikanCodeTo
     */
    @JsonProperty("txtIryoKikanCodeTo")
    public void setTxtIryoKikanCodeTo(TextBoxCode txtIryoKikanCodeTo) {
        this.txtIryoKikanCodeTo = txtIryoKikanCodeTo;
    }

    /*
     * getradIryoKikanJokyo
     * @return radIryoKikanJokyo
     */
    @JsonProperty("radIryoKikanJokyo")
    public RadioButton getRadIryoKikanJokyo() {
        return radIryoKikanJokyo;
    }

    /*
     * setradIryoKikanJokyo
     * @param radIryoKikanJokyo radIryoKikanJokyo
     */
    @JsonProperty("radIryoKikanJokyo")
    public void setRadIryoKikanJokyo(RadioButton radIryoKikanJokyo) {
        this.radIryoKikanJokyo = radIryoKikanJokyo;
    }

    /*
     * gettxtIryoKikanName
     * @return txtIryoKikanName
     */
    @JsonProperty("txtIryoKikanName")
    public TextBox getTxtIryoKikanName() {
        return txtIryoKikanName;
    }

    /*
     * settxtIryoKikanName
     * @param txtIryoKikanName txtIryoKikanName
     */
    @JsonProperty("txtIryoKikanName")
    public void setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.txtIryoKikanName = txtIryoKikanName;
    }

    /*
     * gettxtIryoKikanKanaMeisho
     * @return txtIryoKikanKanaMeisho
     */
    @JsonProperty("txtIryoKikanKanaMeisho")
    public TextBox getTxtIryoKikanKanaMeisho() {
        return txtIryoKikanKanaMeisho;
    }

    /*
     * settxtIryoKikanKanaMeisho
     * @param txtIryoKikanKanaMeisho txtIryoKikanKanaMeisho
     */
    @JsonProperty("txtIryoKikanKanaMeisho")
    public void setTxtIryoKikanKanaMeisho(TextBox txtIryoKikanKanaMeisho) {
        this.txtIryoKikanKanaMeisho = txtIryoKikanKanaMeisho;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    // </editor-fold>
}
