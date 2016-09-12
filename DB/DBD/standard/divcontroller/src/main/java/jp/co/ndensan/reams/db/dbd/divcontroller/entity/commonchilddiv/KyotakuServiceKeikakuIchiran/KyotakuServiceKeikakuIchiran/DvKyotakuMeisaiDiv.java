package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvKyotakuMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvKyotakuMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyotakuJigyoshaNo")
    private TextBoxCode txtKyotakuJigyoshaNo;
    @JsonProperty("txtKyotakuJigyoshaName")
    private TextBox txtKyotakuJigyoshaName;
    @JsonProperty("txtServiceCode1")
    private TextBoxCode txtServiceCode1;
    @JsonProperty("txtServiceCode2")
    private TextBoxCode txtServiceCode2;
    @JsonProperty("txtServiceName")
    private TextBox txtServiceName;
    @JsonProperty("txtTani")
    private TextBoxNum txtTani;
    @JsonProperty("txtWaribikiTekiyogoRitsu")
    private TextBoxNum txtWaribikiTekiyogoRitsu;
    @JsonProperty("txtWaribikiTekiyogoTani")
    private TextBoxNum txtWaribikiTekiyogoTani;
    @JsonProperty("txtKaisu")
    private TextBoxNum txtKaisu;
    @JsonProperty("txtServiceTani")
    private TextBoxNum txtServiceTani;
    @JsonProperty("linLine3")
    private HorizontalLine linLine3;
    @JsonProperty("txtShuruiGendoChokaTani")
    private TextBoxNum txtShuruiGendoChokaTani;
    @JsonProperty("txtShuruiGendonaiTani")
    private TextBoxNum txtShuruiGendonaiTani;
    @JsonProperty("txtTaniTanka")
    private TextBoxNum txtTaniTanka;
    @JsonProperty("txtKubunGendoChokaTani")
    private TextBoxNum txtKubunGendoChokaTani;
    @JsonProperty("txtKubunGendonaiTani")
    private TextBoxNum txtKubunGendonaiTani;
    @JsonProperty("txtKyufuRitsu")
    private TextBoxNum txtKyufuRitsu;
    @JsonProperty("txtHiyoSogaku")
    private TextBoxNum txtHiyoSogaku;
    @JsonProperty("txtHokenKyufuGaku")
    private TextBoxNum txtHokenKyufuGaku;
    @JsonProperty("txtHokenTaishoRiyoshaFutanGaku")
    private TextBoxNum txtHokenTaishoRiyoshaFutanGaku;
    @JsonProperty("txtZengakuRiyoshaFutanngaku")
    private TextBoxNum txtZengakuRiyoshaFutanngaku;
    @JsonProperty("btnKyotakuServiceShosaiClose")
    private Button btnKyotakuServiceShosaiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKyotakuJigyoshaNo
     * @return txtKyotakuJigyoshaNo
     */
    @JsonProperty("txtKyotakuJigyoshaNo")
    public TextBoxCode getTxtKyotakuJigyoshaNo() {
        return txtKyotakuJigyoshaNo;
    }

    /*
     * settxtKyotakuJigyoshaNo
     * @param txtKyotakuJigyoshaNo txtKyotakuJigyoshaNo
     */
    @JsonProperty("txtKyotakuJigyoshaNo")
    public void setTxtKyotakuJigyoshaNo(TextBoxCode txtKyotakuJigyoshaNo) {
        this.txtKyotakuJigyoshaNo = txtKyotakuJigyoshaNo;
    }

    /*
     * gettxtKyotakuJigyoshaName
     * @return txtKyotakuJigyoshaName
     */
    @JsonProperty("txtKyotakuJigyoshaName")
    public TextBox getTxtKyotakuJigyoshaName() {
        return txtKyotakuJigyoshaName;
    }

    /*
     * settxtKyotakuJigyoshaName
     * @param txtKyotakuJigyoshaName txtKyotakuJigyoshaName
     */
    @JsonProperty("txtKyotakuJigyoshaName")
    public void setTxtKyotakuJigyoshaName(TextBox txtKyotakuJigyoshaName) {
        this.txtKyotakuJigyoshaName = txtKyotakuJigyoshaName;
    }

    /*
     * gettxtServiceCode1
     * @return txtServiceCode1
     */
    @JsonProperty("txtServiceCode1")
    public TextBoxCode getTxtServiceCode1() {
        return txtServiceCode1;
    }

    /*
     * settxtServiceCode1
     * @param txtServiceCode1 txtServiceCode1
     */
    @JsonProperty("txtServiceCode1")
    public void setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.txtServiceCode1 = txtServiceCode1;
    }

    /*
     * gettxtServiceCode2
     * @return txtServiceCode2
     */
    @JsonProperty("txtServiceCode2")
    public TextBoxCode getTxtServiceCode2() {
        return txtServiceCode2;
    }

    /*
     * settxtServiceCode2
     * @param txtServiceCode2 txtServiceCode2
     */
    @JsonProperty("txtServiceCode2")
    public void setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.txtServiceCode2 = txtServiceCode2;
    }

    /*
     * gettxtServiceName
     * @return txtServiceName
     */
    @JsonProperty("txtServiceName")
    public TextBox getTxtServiceName() {
        return txtServiceName;
    }

    /*
     * settxtServiceName
     * @param txtServiceName txtServiceName
     */
    @JsonProperty("txtServiceName")
    public void setTxtServiceName(TextBox txtServiceName) {
        this.txtServiceName = txtServiceName;
    }

    /*
     * gettxtTani
     * @return txtTani
     */
    @JsonProperty("txtTani")
    public TextBoxNum getTxtTani() {
        return txtTani;
    }

    /*
     * settxtTani
     * @param txtTani txtTani
     */
    @JsonProperty("txtTani")
    public void setTxtTani(TextBoxNum txtTani) {
        this.txtTani = txtTani;
    }

    /*
     * gettxtWaribikiTekiyogoRitsu
     * @return txtWaribikiTekiyogoRitsu
     */
    @JsonProperty("txtWaribikiTekiyogoRitsu")
    public TextBoxNum getTxtWaribikiTekiyogoRitsu() {
        return txtWaribikiTekiyogoRitsu;
    }

    /*
     * settxtWaribikiTekiyogoRitsu
     * @param txtWaribikiTekiyogoRitsu txtWaribikiTekiyogoRitsu
     */
    @JsonProperty("txtWaribikiTekiyogoRitsu")
    public void setTxtWaribikiTekiyogoRitsu(TextBoxNum txtWaribikiTekiyogoRitsu) {
        this.txtWaribikiTekiyogoRitsu = txtWaribikiTekiyogoRitsu;
    }

    /*
     * gettxtWaribikiTekiyogoTani
     * @return txtWaribikiTekiyogoTani
     */
    @JsonProperty("txtWaribikiTekiyogoTani")
    public TextBoxNum getTxtWaribikiTekiyogoTani() {
        return txtWaribikiTekiyogoTani;
    }

    /*
     * settxtWaribikiTekiyogoTani
     * @param txtWaribikiTekiyogoTani txtWaribikiTekiyogoTani
     */
    @JsonProperty("txtWaribikiTekiyogoTani")
    public void setTxtWaribikiTekiyogoTani(TextBoxNum txtWaribikiTekiyogoTani) {
        this.txtWaribikiTekiyogoTani = txtWaribikiTekiyogoTani;
    }

    /*
     * gettxtKaisu
     * @return txtKaisu
     */
    @JsonProperty("txtKaisu")
    public TextBoxNum getTxtKaisu() {
        return txtKaisu;
    }

    /*
     * settxtKaisu
     * @param txtKaisu txtKaisu
     */
    @JsonProperty("txtKaisu")
    public void setTxtKaisu(TextBoxNum txtKaisu) {
        this.txtKaisu = txtKaisu;
    }

    /*
     * gettxtServiceTani
     * @return txtServiceTani
     */
    @JsonProperty("txtServiceTani")
    public TextBoxNum getTxtServiceTani() {
        return txtServiceTani;
    }

    /*
     * settxtServiceTani
     * @param txtServiceTani txtServiceTani
     */
    @JsonProperty("txtServiceTani")
    public void setTxtServiceTani(TextBoxNum txtServiceTani) {
        this.txtServiceTani = txtServiceTani;
    }

    /*
     * getlinLine3
     * @return linLine3
     */
    @JsonProperty("linLine3")
    public HorizontalLine getLinLine3() {
        return linLine3;
    }

    /*
     * setlinLine3
     * @param linLine3 linLine3
     */
    @JsonProperty("linLine3")
    public void setLinLine3(HorizontalLine linLine3) {
        this.linLine3 = linLine3;
    }

    /*
     * gettxtShuruiGendoChokaTani
     * @return txtShuruiGendoChokaTani
     */
    @JsonProperty("txtShuruiGendoChokaTani")
    public TextBoxNum getTxtShuruiGendoChokaTani() {
        return txtShuruiGendoChokaTani;
    }

    /*
     * settxtShuruiGendoChokaTani
     * @param txtShuruiGendoChokaTani txtShuruiGendoChokaTani
     */
    @JsonProperty("txtShuruiGendoChokaTani")
    public void setTxtShuruiGendoChokaTani(TextBoxNum txtShuruiGendoChokaTani) {
        this.txtShuruiGendoChokaTani = txtShuruiGendoChokaTani;
    }

    /*
     * gettxtShuruiGendonaiTani
     * @return txtShuruiGendonaiTani
     */
    @JsonProperty("txtShuruiGendonaiTani")
    public TextBoxNum getTxtShuruiGendonaiTani() {
        return txtShuruiGendonaiTani;
    }

    /*
     * settxtShuruiGendonaiTani
     * @param txtShuruiGendonaiTani txtShuruiGendonaiTani
     */
    @JsonProperty("txtShuruiGendonaiTani")
    public void setTxtShuruiGendonaiTani(TextBoxNum txtShuruiGendonaiTani) {
        this.txtShuruiGendonaiTani = txtShuruiGendonaiTani;
    }

    /*
     * gettxtTaniTanka
     * @return txtTaniTanka
     */
    @JsonProperty("txtTaniTanka")
    public TextBoxNum getTxtTaniTanka() {
        return txtTaniTanka;
    }

    /*
     * settxtTaniTanka
     * @param txtTaniTanka txtTaniTanka
     */
    @JsonProperty("txtTaniTanka")
    public void setTxtTaniTanka(TextBoxNum txtTaniTanka) {
        this.txtTaniTanka = txtTaniTanka;
    }

    /*
     * gettxtKubunGendoChokaTani
     * @return txtKubunGendoChokaTani
     */
    @JsonProperty("txtKubunGendoChokaTani")
    public TextBoxNum getTxtKubunGendoChokaTani() {
        return txtKubunGendoChokaTani;
    }

    /*
     * settxtKubunGendoChokaTani
     * @param txtKubunGendoChokaTani txtKubunGendoChokaTani
     */
    @JsonProperty("txtKubunGendoChokaTani")
    public void setTxtKubunGendoChokaTani(TextBoxNum txtKubunGendoChokaTani) {
        this.txtKubunGendoChokaTani = txtKubunGendoChokaTani;
    }

    /*
     * gettxtKubunGendonaiTani
     * @return txtKubunGendonaiTani
     */
    @JsonProperty("txtKubunGendonaiTani")
    public TextBoxNum getTxtKubunGendonaiTani() {
        return txtKubunGendonaiTani;
    }

    /*
     * settxtKubunGendonaiTani
     * @param txtKubunGendonaiTani txtKubunGendonaiTani
     */
    @JsonProperty("txtKubunGendonaiTani")
    public void setTxtKubunGendonaiTani(TextBoxNum txtKubunGendonaiTani) {
        this.txtKubunGendonaiTani = txtKubunGendonaiTani;
    }

    /*
     * gettxtKyufuRitsu
     * @return txtKyufuRitsu
     */
    @JsonProperty("txtKyufuRitsu")
    public TextBoxNum getTxtKyufuRitsu() {
        return txtKyufuRitsu;
    }

    /*
     * settxtKyufuRitsu
     * @param txtKyufuRitsu txtKyufuRitsu
     */
    @JsonProperty("txtKyufuRitsu")
    public void setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.txtKyufuRitsu = txtKyufuRitsu;
    }

    /*
     * gettxtHiyoSogaku
     * @return txtHiyoSogaku
     */
    @JsonProperty("txtHiyoSogaku")
    public TextBoxNum getTxtHiyoSogaku() {
        return txtHiyoSogaku;
    }

    /*
     * settxtHiyoSogaku
     * @param txtHiyoSogaku txtHiyoSogaku
     */
    @JsonProperty("txtHiyoSogaku")
    public void setTxtHiyoSogaku(TextBoxNum txtHiyoSogaku) {
        this.txtHiyoSogaku = txtHiyoSogaku;
    }

    /*
     * gettxtHokenKyufuGaku
     * @return txtHokenKyufuGaku
     */
    @JsonProperty("txtHokenKyufuGaku")
    public TextBoxNum getTxtHokenKyufuGaku() {
        return txtHokenKyufuGaku;
    }

    /*
     * settxtHokenKyufuGaku
     * @param txtHokenKyufuGaku txtHokenKyufuGaku
     */
    @JsonProperty("txtHokenKyufuGaku")
    public void setTxtHokenKyufuGaku(TextBoxNum txtHokenKyufuGaku) {
        this.txtHokenKyufuGaku = txtHokenKyufuGaku;
    }

    /*
     * gettxtHokenTaishoRiyoshaFutanGaku
     * @return txtHokenTaishoRiyoshaFutanGaku
     */
    @JsonProperty("txtHokenTaishoRiyoshaFutanGaku")
    public TextBoxNum getTxtHokenTaishoRiyoshaFutanGaku() {
        return txtHokenTaishoRiyoshaFutanGaku;
    }

    /*
     * settxtHokenTaishoRiyoshaFutanGaku
     * @param txtHokenTaishoRiyoshaFutanGaku txtHokenTaishoRiyoshaFutanGaku
     */
    @JsonProperty("txtHokenTaishoRiyoshaFutanGaku")
    public void setTxtHokenTaishoRiyoshaFutanGaku(TextBoxNum txtHokenTaishoRiyoshaFutanGaku) {
        this.txtHokenTaishoRiyoshaFutanGaku = txtHokenTaishoRiyoshaFutanGaku;
    }

    /*
     * gettxtZengakuRiyoshaFutanngaku
     * @return txtZengakuRiyoshaFutanngaku
     */
    @JsonProperty("txtZengakuRiyoshaFutanngaku")
    public TextBoxNum getTxtZengakuRiyoshaFutanngaku() {
        return txtZengakuRiyoshaFutanngaku;
    }

    /*
     * settxtZengakuRiyoshaFutanngaku
     * @param txtZengakuRiyoshaFutanngaku txtZengakuRiyoshaFutanngaku
     */
    @JsonProperty("txtZengakuRiyoshaFutanngaku")
    public void setTxtZengakuRiyoshaFutanngaku(TextBoxNum txtZengakuRiyoshaFutanngaku) {
        this.txtZengakuRiyoshaFutanngaku = txtZengakuRiyoshaFutanngaku;
    }

    /*
     * getbtnKyotakuServiceShosaiClose
     * @return btnKyotakuServiceShosaiClose
     */
    @JsonProperty("btnKyotakuServiceShosaiClose")
    public Button getBtnKyotakuServiceShosaiClose() {
        return btnKyotakuServiceShosaiClose;
    }

    /*
     * setbtnKyotakuServiceShosaiClose
     * @param btnKyotakuServiceShosaiClose btnKyotakuServiceShosaiClose
     */
    @JsonProperty("btnKyotakuServiceShosaiClose")
    public void setBtnKyotakuServiceShosaiClose(Button btnKyotakuServiceShosaiClose) {
        this.btnKyotakuServiceShosaiClose = btnKyotakuServiceShosaiClose;
    }

    // </editor-fold>
}
