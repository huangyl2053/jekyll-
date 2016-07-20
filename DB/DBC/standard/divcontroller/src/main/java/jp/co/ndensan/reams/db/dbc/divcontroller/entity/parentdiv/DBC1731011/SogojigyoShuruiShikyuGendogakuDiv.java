package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011;
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
 * SogojigyoShuruiShikyuGendogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogojigyoShuruiShikyuGendogakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgShikyuGendogaku")
    private DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku;
    @JsonProperty("ShuruiShikyuGendogakuShosai")
    private ShuruiShikyuGendogakuShosaiDiv ShuruiShikyuGendogakuShosai;

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
     * getdgShikyuGendogaku
     * @return dgShikyuGendogaku
     */
    @JsonProperty("dgShikyuGendogaku")
    public DataGrid<dgShikyuGendogaku_Row> getDgShikyuGendogaku() {
        return dgShikyuGendogaku;
    }

    /*
     * setdgShikyuGendogaku
     * @param dgShikyuGendogaku dgShikyuGendogaku
     */
    @JsonProperty("dgShikyuGendogaku")
    public void setDgShikyuGendogaku(DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku) {
        this.dgShikyuGendogaku = dgShikyuGendogaku;
    }

    /*
     * getShuruiShikyuGendogakuShosai
     * @return ShuruiShikyuGendogakuShosai
     */
    @JsonProperty("ShuruiShikyuGendogakuShosai")
    public ShuruiShikyuGendogakuShosaiDiv getShuruiShikyuGendogakuShosai() {
        return ShuruiShikyuGendogakuShosai;
    }

    /*
     * setShuruiShikyuGendogakuShosai
     * @param ShuruiShikyuGendogakuShosai ShuruiShikyuGendogakuShosai
     */
    @JsonProperty("ShuruiShikyuGendogakuShosai")
    public void setShuruiShikyuGendogakuShosai(ShuruiShikyuGendogakuShosaiDiv ShuruiShikyuGendogakuShosai) {
        this.ShuruiShikyuGendogakuShosai = ShuruiShikyuGendogakuShosai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtTekiyoKaishiYM() {
        return this.getShuruiShikyuGendogakuShosai().getTxtTekiyoKaishiYM();
    }

    @JsonIgnore
    public void  setTxtTekiyoKaishiYM(TextBoxDate txtTekiyoKaishiYM) {
        this.getShuruiShikyuGendogakuShosai().setTxtTekiyoKaishiYM(txtTekiyoKaishiYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoShuryoYM() {
        return this.getShuruiShikyuGendogakuShosai().getTxtTekiyoShuryoYM();
    }

    @JsonIgnore
    public void  setTxtTekiyoShuryoYM(TextBoxDate txtTekiyoShuryoYM) {
        this.getShuruiShikyuGendogakuShosai().setTxtTekiyoShuryoYM(txtTekiyoShuryoYM);
    }

    @JsonIgnore
    public DropDownList getDdlServiceShurui() {
        return this.getShuruiShikyuGendogakuShosai().getDdlServiceShurui();
    }

    @JsonIgnore
    public void  setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.getShuruiShikyuGendogakuShosai().setDdlServiceShurui(ddlServiceShurui);
    }

    @JsonIgnore
    public HorizontalLine getLinShosai() {
        return this.getShuruiShikyuGendogakuShosai().getLinShosai();
    }

    @JsonIgnore
    public void  setLinShosai(HorizontalLine linShosai) {
        this.getShuruiShikyuGendogakuShosai().setLinShosai(linShosai);
    }

    @JsonIgnore
    public Label getLblMassage1() {
        return this.getShuruiShikyuGendogakuShosai().getLblMassage1();
    }

    @JsonIgnore
    public void  setLblMassage1(Label lblMassage1) {
        this.getShuruiShikyuGendogakuShosai().setLblMassage1(lblMassage1);
    }

    @JsonIgnore
    public tblGendogakuDiv getTblGendogaku() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku();
    }

    @JsonIgnore
    public void  setTblGendogaku(tblGendogakuDiv tblGendogaku) {
        this.getShuruiShikyuGendogakuShosai().setTblGendogaku(tblGendogaku);
    }

    @JsonIgnore
    public Label getLblMidashi5() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getLblMidashi5();
    }

    @JsonIgnore
    public Label getLblMidashi1() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getLblMidashi1();
    }

    @JsonIgnore
    public Label getLblMidashi2() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getLblMidashi2();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien1() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getTxtYoShien1();
    }

    @JsonIgnore
    public Label getLblMidashi3() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getLblMidashi3();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien2() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getTxtYoShien2();
    }

    @JsonIgnore
    public Label getLblMidashi4() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getLblMidashi4();
    }

    @JsonIgnore
    public TextBoxNum getTxtNijiYobo() {
        return this.getShuruiShikyuGendogakuShosai().getTblGendogaku().getTxtNijiYobo();
    }

    // </editor-fold>
}
