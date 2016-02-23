package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KokuhorenJohoTorikomiBatchKido のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuhorenJohoTorikomiBatchKidoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-63">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle")
    private Label lblTitle;
    @JsonProperty("pnlChushutsuJoken")
    private pnlChushutsuJokenDiv pnlChushutsuJoken;
    @JsonProperty("pnlShoritaishoJoho")
    private pnlShoritaishoJohoDiv pnlShoritaishoJoho;
    @JsonProperty("pnlShutsuryokuJun")
    private pnlShutsuryokuJunDiv pnlShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTitle
     * @return lblTitle
     */
    @JsonProperty("lblTitle")
    public Label getLblTitle() {
        return lblTitle;
    }

    /*
     * setlblTitle
     * @param lblTitle lblTitle
     */
    @JsonProperty("lblTitle")
    public void setLblTitle(Label lblTitle) {
        this.lblTitle = lblTitle;
    }

    /*
     * getpnlChushutsuJoken
     * @return pnlChushutsuJoken
     */
    @JsonProperty("pnlChushutsuJoken")
    public pnlChushutsuJokenDiv getPnlChushutsuJoken() {
        return pnlChushutsuJoken;
    }

    /*
     * setpnlChushutsuJoken
     * @param pnlChushutsuJoken pnlChushutsuJoken
     */
    @JsonProperty("pnlChushutsuJoken")
    public void setPnlChushutsuJoken(pnlChushutsuJokenDiv pnlChushutsuJoken) {
        this.pnlChushutsuJoken = pnlChushutsuJoken;
    }

    /*
     * getpnlShoritaishoJoho
     * @return pnlShoritaishoJoho
     */
    @JsonProperty("pnlShoritaishoJoho")
    public pnlShoritaishoJohoDiv getPnlShoritaishoJoho() {
        return pnlShoritaishoJoho;
    }

    /*
     * setpnlShoritaishoJoho
     * @param pnlShoritaishoJoho pnlShoritaishoJoho
     */
    @JsonProperty("pnlShoritaishoJoho")
    public void setPnlShoritaishoJoho(pnlShoritaishoJohoDiv pnlShoritaishoJoho) {
        this.pnlShoritaishoJoho = pnlShoritaishoJoho;
    }

    /*
     * getpnlShutsuryokuJun
     * @return pnlShutsuryokuJun
     */
    @JsonProperty("pnlShutsuryokuJun")
    public pnlShutsuryokuJunDiv getPnlShutsuryokuJun() {
        return pnlShutsuryokuJun;
    }

    /*
     * setpnlShutsuryokuJun
     * @param pnlShutsuryokuJun pnlShutsuryokuJun
     */
    @JsonProperty("pnlShutsuryokuJun")
    public void setPnlShutsuryokuJun(pnlShutsuryokuJunDiv pnlShutsuryokuJun) {
        this.pnlShutsuryokuJun = pnlShutsuryokuJun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChushutsuJoken() {
        return this.getPnlChushutsuJoken().getLblChushutsuJoken();
    }

    @JsonIgnore
    public void  setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.getPnlChushutsuJoken().setLblChushutsuJoken(lblChushutsuJoken);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriJoken() {
        return this.getPnlChushutsuJoken().getTxtShoriJoken();
    }

    @JsonIgnore
    public void  setTxtShoriJoken(TextBoxDate txtShoriJoken) {
        this.getPnlChushutsuJoken().setTxtShoriJoken(txtShoriJoken);
    }

    @JsonIgnore
    public TextBox getTxtSaishoriKubun() {
        return this.getPnlChushutsuJoken().getTxtSaishoriKubun();
    }

    @JsonIgnore
    public void  setTxtSaishoriKubun(TextBox txtSaishoriKubun) {
        this.getPnlChushutsuJoken().setTxtSaishoriKubun(txtSaishoriKubun);
    }

    @JsonIgnore
    public TextBox getTxtKokanShikibetsuNo() {
        return this.getPnlChushutsuJoken().getTxtKokanShikibetsuNo();
    }

    @JsonIgnore
    public void  setTxtKokanShikibetsuNo(TextBox txtKokanShikibetsuNo) {
        this.getPnlChushutsuJoken().setTxtKokanShikibetsuNo(txtKokanShikibetsuNo);
    }

    @JsonIgnore
    public Label getLblShoritaishoJobo() {
        return this.getPnlShoritaishoJoho().getLblShoritaishoJobo();
    }

    @JsonIgnore
    public void  setLblShoritaishoJobo(Label lblShoritaishoJobo) {
        this.getPnlShoritaishoJoho().setLblShoritaishoJobo(lblShoritaishoJobo);
    }

    @JsonIgnore
    public CheckBoxList getChkDogetsuKagobun() {
        return this.getPnlShoritaishoJoho().getChkDogetsuKagobun();
    }

    @JsonIgnore
    public void  setChkDogetsuKagobun(CheckBoxList chkDogetsuKagobun) {
        this.getPnlShoritaishoJoho().setChkDogetsuKagobun(chkDogetsuKagobun);
    }

    @JsonIgnore
    public CheckBoxList getChkTsujobun() {
        return this.getPnlShoritaishoJoho().getChkTsujobun();
    }

    @JsonIgnore
    public void  setChkTsujobun(CheckBoxList chkTsujobun) {
        this.getPnlShoritaishoJoho().setChkTsujobun(chkTsujobun);
    }

    @JsonIgnore
    public KakuninJikoDiv getKakuninJiko() {
        return this.getPnlShoritaishoJoho().getKakuninJiko();
    }

    @JsonIgnore
    public void  setKakuninJiko(KakuninJikoDiv KakuninJiko) {
        this.getPnlShoritaishoJoho().setKakuninJiko(KakuninJiko);
    }

    @JsonIgnore
    public Label getLblKakuninJiko1() {
        return this.getPnlShoritaishoJoho().getKakuninJiko().getLblKakuninJiko1();
    }

    @JsonIgnore
    public void  setLblKakuninJiko1(Label lblKakuninJiko1) {
        this.getPnlShoritaishoJoho().getKakuninJiko().setLblKakuninJiko1(lblKakuninJiko1);
    }

    @JsonIgnore
    public Label getLblKakuninJiko2() {
        return this.getPnlShoritaishoJoho().getKakuninJiko().getLblKakuninJiko2();
    }

    @JsonIgnore
    public void  setLblKakuninJiko2(Label lblKakuninJiko2) {
        this.getPnlShoritaishoJoho().getKakuninJiko().setLblKakuninJiko2(lblKakuninJiko2);
    }

    @JsonIgnore
    public Label getLblKakuninJiko3() {
        return this.getPnlShoritaishoJoho().getKakuninJiko().getLblKakuninJiko3();
    }

    @JsonIgnore
    public void  setLblKakuninJiko3(Label lblKakuninJiko3) {
        this.getPnlShoritaishoJoho().getKakuninJiko().setLblKakuninJiko3(lblKakuninJiko3);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdShutsuryokuJun() {
        return this.getPnlShutsuryokuJun().getCcdShutsuryokuJun();
    }

    // </editor-fold>
}
