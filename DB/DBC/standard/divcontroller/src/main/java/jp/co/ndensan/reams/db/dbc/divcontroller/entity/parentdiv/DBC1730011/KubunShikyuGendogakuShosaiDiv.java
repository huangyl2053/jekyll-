package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYearMonth;

/**
 * KubunShikyuGendogakuShosai のクラスファイル
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class KubunShikyuGendogakuShosaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoKaishiYM")
    private TextBoxYearMonth txtTekiyoKaishiYM;
    @JsonProperty("txtTekiyoShuryoYM")
    private TextBoxYearMonth txtTekiyoShuryoYM;
    @JsonProperty("linShosai")
    private HorizontalLine linShosai;
    @JsonProperty("lblMessage2")
    private Label lblMessage2;
    @JsonProperty("tblGendogaku")
    private tblGendogakuDiv tblGendogaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoKaishiYM
     * @return txtTekiyoKaishiYM
     */
    @JsonProperty("txtTekiyoKaishiYM")
    public TextBoxYearMonth getTxtTekiyoKaishiYM() {
        return txtTekiyoKaishiYM;
    }

    /*
     * settxtTekiyoKaishiYM
     * @param txtTekiyoKaishiYM txtTekiyoKaishiYM
     */
    @JsonProperty("txtTekiyoKaishiYM")
    public void setTxtTekiyoKaishiYM(TextBoxYearMonth txtTekiyoKaishiYM) {
        this.txtTekiyoKaishiYM = txtTekiyoKaishiYM;
    }

    /*
     * gettxtTekiyoShuryoYM
     * @return txtTekiyoShuryoYM
     */
    @JsonProperty("txtTekiyoShuryoYM")
    public TextBoxYearMonth getTxtTekiyoShuryoYM() {
        return txtTekiyoShuryoYM;
    }

    /*
     * settxtTekiyoShuryoYM
     * @param txtTekiyoShuryoYM txtTekiyoShuryoYM
     */
    @JsonProperty("txtTekiyoShuryoYM")
    public void setTxtTekiyoShuryoYM(TextBoxYearMonth txtTekiyoShuryoYM) {
        this.txtTekiyoShuryoYM = txtTekiyoShuryoYM;
    }

    /*
     * getlinShosai
     * @return linShosai
     */
    @JsonProperty("linShosai")
    public HorizontalLine getLinShosai() {
        return linShosai;
    }

    /*
     * setlinShosai
     * @param linShosai linShosai
     */
    @JsonProperty("linShosai")
    public void setLinShosai(HorizontalLine linShosai) {
        this.linShosai = linShosai;
    }

    /*
     * getlblMessage2
     * @return lblMessage2
     */
    @JsonProperty("lblMessage2")
    public Label getLblMessage2() {
        return lblMessage2;
    }

    /*
     * setlblMessage2
     * @param lblMessage2 lblMessage2
     */
    @JsonProperty("lblMessage2")
    public void setLblMessage2(Label lblMessage2) {
        this.lblMessage2 = lblMessage2;
    }

    /*
     * gettblGendogaku
     * @return tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public tblGendogakuDiv getTblGendogaku() {
        return tblGendogaku;
    }

    /*
     * settblGendogaku
     * @param tblGendogaku tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public void setTblGendogaku(tblGendogakuDiv tblGendogaku) {
        this.tblGendogaku = tblGendogaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblMessage3() {
        return this.getTblGendogaku().getLblMessage3();
    }

    @JsonIgnore
    public Label getLblMidashi1() {
        return this.getTblGendogaku().getLblMidashi1();
    }

    @JsonIgnore
    public Label getLblMidashi9() {
        return this.getTblGendogaku().getLblMidashi9();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien1() {
        return this.getTblGendogaku().getTxtYoShien1();
    }

    @JsonIgnore
    public Label getLblMidashi10() {
        return this.getTblGendogaku().getLblMidashi10();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien2() {
        return this.getTblGendogaku().getTxtYoShien2();
    }

    @JsonIgnore
    public Label getLblMidashi5() {
        return this.getTblGendogaku().getLblMidashi5();
    }

    @JsonIgnore
    public TextBoxNum getTxtNijiYobo() {
        return this.getTblGendogaku().getTxtNijiYobo();
    }

    // </editor-fold>
}
