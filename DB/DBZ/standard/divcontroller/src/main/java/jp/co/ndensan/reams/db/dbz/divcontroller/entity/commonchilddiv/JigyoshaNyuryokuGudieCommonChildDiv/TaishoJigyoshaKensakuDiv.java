package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishoJigyoshaKensaku のクラスファイル 
 * 
 * @reamsid_L DBA-0140-010 houtianpeng
 */
public class TaishoJigyoshaKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KennsakuJyokenn")
    private KennsakuJyokennDiv KennsakuJyokenn;
    @JsonProperty("OtherTokureiShisetsu")
    private OtherTokureiShisetsuDiv OtherTokureiShisetsu;
    @JsonProperty("txtMaxHyojiKensu")
    private TextBoxNum txtMaxHyojiKensu;
    @JsonProperty("btnTaishoJigyoshaKensaku")
    private Button btnTaishoJigyoshaKensaku;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnYameru")
    private Button btnYameru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKennsakuJyokenn
     * @return KennsakuJyokenn
     */
    @JsonProperty("KennsakuJyokenn")
    public KennsakuJyokennDiv getKennsakuJyokenn() {
        return KennsakuJyokenn;
    }

    /*
     * setKennsakuJyokenn
     * @param KennsakuJyokenn KennsakuJyokenn
     */
    @JsonProperty("KennsakuJyokenn")
    public void setKennsakuJyokenn(KennsakuJyokennDiv KennsakuJyokenn) {
        this.KennsakuJyokenn = KennsakuJyokenn;
    }

    /*
     * getOtherTokureiShisetsu
     * @return OtherTokureiShisetsu
     */
    @JsonProperty("OtherTokureiShisetsu")
    public OtherTokureiShisetsuDiv getOtherTokureiShisetsu() {
        return OtherTokureiShisetsu;
    }

    /*
     * setOtherTokureiShisetsu
     * @param OtherTokureiShisetsu OtherTokureiShisetsu
     */
    @JsonProperty("OtherTokureiShisetsu")
    public void setOtherTokureiShisetsu(OtherTokureiShisetsuDiv OtherTokureiShisetsu) {
        this.OtherTokureiShisetsu = OtherTokureiShisetsu;
    }

    /*
     * gettxtMaxHyojiKensu
     * @return txtMaxHyojiKensu
     */
    @JsonProperty("txtMaxHyojiKensu")
    public TextBoxNum getTxtMaxHyojiKensu() {
        return txtMaxHyojiKensu;
    }

    /*
     * settxtMaxHyojiKensu
     * @param txtMaxHyojiKensu txtMaxHyojiKensu
     */
    @JsonProperty("txtMaxHyojiKensu")
    public void setTxtMaxHyojiKensu(TextBoxNum txtMaxHyojiKensu) {
        this.txtMaxHyojiKensu = txtMaxHyojiKensu;
    }

    /*
     * getbtnTaishoJigyoshaKensaku
     * @return btnTaishoJigyoshaKensaku
     */
    @JsonProperty("btnTaishoJigyoshaKensaku")
    public Button getBtnTaishoJigyoshaKensaku() {
        return btnTaishoJigyoshaKensaku;
    }

    /*
     * setbtnTaishoJigyoshaKensaku
     * @param btnTaishoJigyoshaKensaku btnTaishoJigyoshaKensaku
     */
    @JsonProperty("btnTaishoJigyoshaKensaku")
    public void setBtnTaishoJigyoshaKensaku(Button btnTaishoJigyoshaKensaku) {
        this.btnTaishoJigyoshaKensaku = btnTaishoJigyoshaKensaku;
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
     * getbtnYameru
     * @return btnYameru
     */
    @JsonProperty("btnYameru")
    public Button getBtnYameru() {
        return btnYameru;
    }

    /*
     * setbtnYameru
     * @param btnYameru btnYameru
     */
    @JsonProperty("btnYameru")
    public void setBtnYameru(Button btnYameru) {
        this.btnYameru = btnYameru;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKennCode() {
        return this.getKennsakuJyokenn().getServiceJigyosha().getDdlKennCode();
    }

    @JsonIgnore
    public void  setDdlKennCode(DropDownList ddlKennCode) {
        this.getKennsakuJyokenn().getServiceJigyosha().setDdlKennCode(ddlKennCode);
    }

    @JsonIgnore
    public DropDownList getDdlJigyoshaKubun() {
        return this.getKennsakuJyokenn().getServiceJigyosha().getDdlJigyoshaKubun();
    }

    @JsonIgnore
    public void  setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.getKennsakuJyokenn().getServiceJigyosha().setDdlJigyoshaKubun(ddlJigyoshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlGunshiCode() {
        return this.getKennsakuJyokenn().getServiceJigyosha().getDdlGunshiCode();
    }

    @JsonIgnore
    public void  setDdlGunshiCode(DropDownList ddlGunshiCode) {
        this.getKennsakuJyokenn().getServiceJigyosha().setDdlGunshiCode(ddlGunshiCode);
    }

    @JsonIgnore
    public DropDownList getDdlServiceShurui() {
        return this.getKennsakuJyokenn().getServiceJigyosha().getDdlServiceShurui();
    }

    @JsonIgnore
    public void  setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.getKennsakuJyokenn().getServiceJigyosha().setDdlServiceShurui(ddlServiceShurui);
    }

    @JsonIgnore
    public RadioButton getRadKannaiKanngaiKubun() {
        return this.getOtherTokureiShisetsu().getRadKannaiKanngaiKubun();
    }

    @JsonIgnore
    public void  setRadKannaiKanngaiKubun(RadioButton radKannaiKanngaiKubun) {
        this.getOtherTokureiShisetsu().setRadKannaiKanngaiKubun(radKannaiKanngaiKubun);
    }

    // </editor-fold>
}
