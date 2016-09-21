package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011;
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
 * ShichosonTokubetuKyufuServiceTouroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShichosonTokubetuKyufuServiceTourokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgServiceNaiyo")
    private DataGrid<dgServiceNaiyo_Row> dgServiceNaiyo;
    @JsonProperty("KubunShikyuGendogakuShosai")
    private KubunShikyuGendogakuShosaiDiv KubunShikyuGendogakuShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTsuika
     * @return btnTsuika
     */
    @JsonProperty("btnTsuika")
    public Button getBtnTsuika() {
        return btnTsuika;
    }

    /*
     * setbtnTsuika
     * @param btnTsuika btnTsuika
     */
    @JsonProperty("btnTsuika")
    public void setBtnTsuika(Button btnTsuika) {
        this.btnTsuika = btnTsuika;
    }

    /*
     * getdgServiceNaiyo
     * @return dgServiceNaiyo
     */
    @JsonProperty("dgServiceNaiyo")
    public DataGrid<dgServiceNaiyo_Row> getDgServiceNaiyo() {
        return dgServiceNaiyo;
    }

    /*
     * setdgServiceNaiyo
     * @param dgServiceNaiyo dgServiceNaiyo
     */
    @JsonProperty("dgServiceNaiyo")
    public void setDgServiceNaiyo(DataGrid<dgServiceNaiyo_Row> dgServiceNaiyo) {
        this.dgServiceNaiyo = dgServiceNaiyo;
    }

    /*
     * getKubunShikyuGendogakuShosai
     * @return KubunShikyuGendogakuShosai
     */
    @JsonProperty("KubunShikyuGendogakuShosai")
    public KubunShikyuGendogakuShosaiDiv getKubunShikyuGendogakuShosai() {
        return KubunShikyuGendogakuShosai;
    }

    /*
     * setKubunShikyuGendogakuShosai
     * @param KubunShikyuGendogakuShosai KubunShikyuGendogakuShosai
     */
    @JsonProperty("KubunShikyuGendogakuShosai")
    public void setKubunShikyuGendogakuShosai(KubunShikyuGendogakuShosaiDiv KubunShikyuGendogakuShosai) {
        this.KubunShikyuGendogakuShosai = KubunShikyuGendogakuShosai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtServiceCode1() {
        return this.getKubunShikyuGendogakuShosai().getTxtServiceCode1();
    }

    @JsonIgnore
    public void  setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.getKubunShikyuGendogakuShosai().setTxtServiceCode1(txtServiceCode1);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode2() {
        return this.getKubunShikyuGendogakuShosai().getTxtServiceCode2();
    }

    @JsonIgnore
    public void  setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.getKubunShikyuGendogakuShosai().setTxtServiceCode2(txtServiceCode2);
    }

    @JsonIgnore
    public TextBox getTxtServiceMeisho() {
        return this.getKubunShikyuGendogakuShosai().getTxtServiceMeisho();
    }

    @JsonIgnore
    public void  setTxtServiceMeisho(TextBox txtServiceMeisho) {
        this.getKubunShikyuGendogakuShosai().setTxtServiceMeisho(txtServiceMeisho);
    }

    @JsonIgnore
    public TextBox getTxtServiceRyakusho() {
        return this.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho();
    }

    @JsonIgnore
    public void  setTxtServiceRyakusho(TextBox txtServiceRyakusho) {
        this.getKubunShikyuGendogakuShosai().setTxtServiceRyakusho(txtServiceRyakusho);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoKaishiYM() {
        return this.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM();
    }

    @JsonIgnore
    public void  setTxtYukoKaishiYM(TextBoxDate txtYukoKaishiYM) {
        this.getKubunShikyuGendogakuShosai().setTxtYukoKaishiYM(txtYukoKaishiYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoShuryoYM() {
        return this.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM();
    }

    @JsonIgnore
    public void  setTxtYukoShuryoYM(TextBoxDate txtYukoShuryoYM) {
        this.getKubunShikyuGendogakuShosai().setTxtYukoShuryoYM(txtYukoShuryoYM);
    }

    @JsonIgnore
    public RadioButton getRadKubun() {
        return this.getKubunShikyuGendogakuShosai().getRadKubun();
    }

    @JsonIgnore
    public void  setRadKubun(RadioButton radKubun) {
        this.getKubunShikyuGendogakuShosai().setRadKubun(radKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanni() {
        return this.getKubunShikyuGendogakuShosai().getTxtTanni();
    }

    @JsonIgnore
    public void  setTxtTanni(TextBoxNum txtTanni) {
        this.getKubunShikyuGendogakuShosai().setTxtTanni(txtTanni);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku();
    }

    @JsonIgnore
    public void  setTxtShikyuGendogaku(TextBoxNum txtShikyuGendogaku) {
        this.getKubunShikyuGendogakuShosai().setTxtShikyuGendogaku(txtShikyuGendogaku);
    }

    // </editor-fold>
}
