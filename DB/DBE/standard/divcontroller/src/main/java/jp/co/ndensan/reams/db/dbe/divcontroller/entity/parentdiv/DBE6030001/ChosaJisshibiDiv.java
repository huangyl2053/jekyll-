package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001;
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
 * ChosaJisshibi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaJisshibiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKijunbi")
    private RadioButton radKijunbi;
    @JsonProperty("txtChosaJisshibi")
    private TextBoxDateRange txtChosaJisshibi;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;
    @JsonProperty("ccdHokensya")
    private HokenshaListDiv ccdHokensya;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKijunbi
     * @return radKijunbi
     */
    @JsonProperty("radKijunbi")
    public RadioButton getRadKijunbi() {
        return radKijunbi;
    }

    /*
     * setradKijunbi
     * @param radKijunbi radKijunbi
     */
    @JsonProperty("radKijunbi")
    public void setRadKijunbi(RadioButton radKijunbi) {
        this.radKijunbi = radKijunbi;
    }

    /*
     * gettxtChosaJisshibi
     * @return txtChosaJisshibi
     */
    @JsonProperty("txtChosaJisshibi")
    public TextBoxDateRange getTxtChosaJisshibi() {
        return txtChosaJisshibi;
    }

    /*
     * settxtChosaJisshibi
     * @param txtChosaJisshibi txtChosaJisshibi
     */
    @JsonProperty("txtChosaJisshibi")
    public void setTxtChosaJisshibi(TextBoxDateRange txtChosaJisshibi) {
        this.txtChosaJisshibi = txtChosaJisshibi;
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
     * getbtnKensakuClear
     * @return btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public Button getBtnKensakuClear() {
        return btnKensakuClear;
    }

    /*
     * setbtnKensakuClear
     * @param btnKensakuClear btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public void setBtnKensakuClear(Button btnKensakuClear) {
        this.btnKensakuClear = btnKensakuClear;
    }

    /*
     * getccdHokensya
     * @return ccdHokensya
     */
    @JsonProperty("ccdHokensya")
    public IHokenshaListDiv getCcdHokensya() {
        return ccdHokensya;
    }

    // </editor-fold>
}
