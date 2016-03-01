package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishoJigyoshaKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoJigyoshaKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KennsakuJyokenn")
    private KennsakuJyokennDiv KennsakuJyokenn;
    @JsonProperty("ServiceJigyosha")
    private ServiceJigyoshaDiv ServiceJigyosha;
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
     * getServiceJigyosha
     * @return ServiceJigyosha
     */
    @JsonProperty("ServiceJigyosha")
    public ServiceJigyoshaDiv getServiceJigyosha() {
        return ServiceJigyosha;
    }

    /*
     * setServiceJigyosha
     * @param ServiceJigyosha ServiceJigyosha
     */
    @JsonProperty("ServiceJigyosha")
    public void setServiceJigyosha(ServiceJigyoshaDiv ServiceJigyosha) {
        this.ServiceJigyosha = ServiceJigyosha;
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

    // </editor-fold>
}
