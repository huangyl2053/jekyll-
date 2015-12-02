package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * JukyuSikakuShomeishoHakko のクラスファイル
 *
 * @author 自動生成
 */
public class JukyuSikakuShomeishoHakkoDiv extends Panel implements IJukyuSikakuShomeishoHakkoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlJukyushaJoho1")
    private pnlJukyushaJoho1Div pnlJukyushaJoho1;
    @JsonProperty("pnlJukyushaJoho2")
    private pnlJukyushaJoho2Div pnlJukyushaJoho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlJukyushaJoho1
     * @return pnlJukyushaJoho1
     */
    @JsonProperty("pnlJukyushaJoho1")
    public pnlJukyushaJoho1Div getPnlJukyushaJoho1() {
        return pnlJukyushaJoho1;
    }

    /*
     * setpnlJukyushaJoho1
     * @param pnlJukyushaJoho1 pnlJukyushaJoho1
     */
    @JsonProperty("pnlJukyushaJoho1")
    public void setPnlJukyushaJoho1(pnlJukyushaJoho1Div pnlJukyushaJoho1) {
        this.pnlJukyushaJoho1 = pnlJukyushaJoho1;
    }

    /*
     * getpnlJukyushaJoho2
     * @return pnlJukyushaJoho2
     */
    @JsonProperty("pnlJukyushaJoho2")
    public pnlJukyushaJoho2Div getPnlJukyushaJoho2() {
        return pnlJukyushaJoho2;
    }

    /*
     * setpnlJukyushaJoho2
     * @param pnlJukyushaJoho2 pnlJukyushaJoho2
     */
    @JsonProperty("pnlJukyushaJoho2")
    public void setPnlJukyushaJoho2(pnlJukyushaJoho2Div pnlJukyushaJoho2) {
        this.pnlJukyushaJoho2 = pnlJukyushaJoho2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKofubi() {
        return this.getPnlJukyushaJoho1().getTxtKofubi();
    }

    @JsonIgnore
    public void setTxtKofubi(TextBox txtKofubi) {
        this.getPnlJukyushaJoho1().setTxtKofubi(txtKofubi);
    }

    @JsonIgnore
    public TextBox getTxtIdoYotebi() {
        return this.getPnlJukyushaJoho1().getTxtIdoYotebi();
    }

    @JsonIgnore
    public void setTxtIdoYotebi(TextBox txtIdoYotebi) {
        this.getPnlJukyushaJoho1().setTxtIdoYotebi(txtIdoYotebi);
    }

    @JsonIgnore
    public TextBox getTxtYokaigoJotaiKubun() {
        return this.getPnlJukyushaJoho1().getTxtYokaigoJotaiKubun();
    }

    @JsonIgnore
    public void setTxtYokaigoJotaiKubun(TextBox txtYokaigoJotaiKubun) {
        this.getPnlJukyushaJoho1().setTxtYokaigoJotaiKubun(txtYokaigoJotaiKubun);
    }

    @JsonIgnore
    public TextBox getTxtShinsebi() {
        return this.getPnlJukyushaJoho1().getTxtShinsebi();
    }

    @JsonIgnore
    public void setTxtShinsebi(TextBox txtShinsebi) {
        this.getPnlJukyushaJoho1().setTxtShinsebi(txtShinsebi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtdrYukokikan() {
        return this.getPnlJukyushaJoho1().getTxtdrYukokikan();
    }

    @JsonIgnore
    public void setTxtdrYukokikan(TextBoxDateRange txtdrYukokikan) {
        this.getPnlJukyushaJoho1().setTxtdrYukokikan(txtdrYukokikan);
    }

    @JsonIgnore
    public CheckBoxList getCblInji() {
        return this.getPnlJukyushaJoho1().getCblInji();
    }

    @JsonIgnore
    public void setCblInji(CheckBoxList cblInji) {
        this.getPnlJukyushaJoho1().setCblInji(cblInji);
    }

    @JsonIgnore
    public Label getLblShinsakaiYikan() {
        return this.getPnlJukyushaJoho2().getLblShinsakaiYikan();
    }

    @JsonIgnore
    public void setLblShinsakaiYikan(Label lblShinsakaiYikan) {
        this.getPnlJukyushaJoho2().setLblShinsakaiYikan(lblShinsakaiYikan);
    }

    @JsonIgnore
    public TextBoxMultiLine getTbmShinsakaiYikan() {
        return this.getPnlJukyushaJoho2().getTbmShinsakaiYikan();
    }

    @JsonIgnore
    public void setTbmShinsakaiYikan(TextBoxMultiLine tbmShinsakaiYikan) {
        this.getPnlJukyushaJoho2().setTbmShinsakaiYikan(tbmShinsakaiYikan);
    }

    @JsonIgnore
    public Label getLblBiko() {
        return this.getPnlJukyushaJoho2().getLblBiko();
    }

    @JsonIgnore
    public void setLblBiko(Label lblBiko) {
        this.getPnlJukyushaJoho2().setLblBiko(lblBiko);
    }

    @JsonIgnore
    public TextBoxMultiLine getTbmBiko() {
        return this.getPnlJukyushaJoho2().getTbmBiko();
    }

    @JsonIgnore
    public void setTbmBiko(TextBoxMultiLine tbmBiko) {
        this.getPnlJukyushaJoho2().setTbmBiko(tbmBiko);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private JukyuSikakuShomeishoHakkoHandler getHandler() {
        return new JukyuSikakuShomeishoHakkoHandler(this);
    }

    @Override
    public void initialize(RString 被保険者番号) {
        getHandler().initialize(JukyuShikakuShomeishoHakkoParameter.createSearchParameter_受給資格証明書発行情報(被保険者番号));
    }
}
