package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYearMonth;

/**
 * SogoJigyoKubunShikyuGendogaku のクラスファイル
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class SogoJigyoKubunShikyuGendogakuDiv extends Panel {

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
    public TextBoxYearMonth getTxtTekiyoKaishiYM() {
        return this.getKubunShikyuGendogakuShosai().getTxtTekiyoKaishiYM();
    }

    @JsonIgnore
    public void setTxtTekiyoKaishiYM(TextBoxYearMonth txtTekiyoKaishiYM) {
        this.getKubunShikyuGendogakuShosai().setTxtTekiyoKaishiYM(txtTekiyoKaishiYM);
    }

    @JsonIgnore
    public TextBoxYearMonth getTxtTekiyoShuryoYM() {
        return this.getKubunShikyuGendogakuShosai().getTxtTekiyoShuryoYM();
    }

    @JsonIgnore
    public void setTxtTekiyoShuryoYM(TextBoxYearMonth txtTekiyoShuryoYM) {
        this.getKubunShikyuGendogakuShosai().setTxtTekiyoShuryoYM(txtTekiyoShuryoYM);
    }

    @JsonIgnore
    public HorizontalLine getLinShosai() {
        return this.getKubunShikyuGendogakuShosai().getLinShosai();
    }

    @JsonIgnore
    public void setLinShosai(HorizontalLine linShosai) {
        this.getKubunShikyuGendogakuShosai().setLinShosai(linShosai);
    }

    @JsonIgnore
    public Label getLblMessage2() {
        return this.getKubunShikyuGendogakuShosai().getLblMessage2();
    }

    @JsonIgnore
    public void setLblMessage2(Label lblMessage2) {
        this.getKubunShikyuGendogakuShosai().setLblMessage2(lblMessage2);
    }

    @JsonIgnore
    public tblGendogakuDiv getTblGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku();
    }

    @JsonIgnore
    public void setTblGendogaku(tblGendogakuDiv tblGendogaku) {
        this.getKubunShikyuGendogakuShosai().setTblGendogaku(tblGendogaku);
    }

    @JsonIgnore
    public Label getLblMessage3() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblMessage3();
    }

    @JsonIgnore
    public Label getLblMidashi1() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblMidashi1();
    }

    @JsonIgnore
    public Label getLblMidashi9() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblMidashi9();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien1() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYoShien1();
    }

    @JsonIgnore
    public Label getLblMidashi10() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblMidashi10();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien2() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYoShien2();
    }

    @JsonIgnore
    public Label getLblMidashi5() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblMidashi5();
    }

    @JsonIgnore
    public TextBoxNum getTxtNijiYobo() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtNijiYobo();
    }

    // </editor-fold>
}
