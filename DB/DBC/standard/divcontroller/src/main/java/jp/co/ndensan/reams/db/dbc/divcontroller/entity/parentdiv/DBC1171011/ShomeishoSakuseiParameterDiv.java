package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1171011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShomeishoSakuseiParameter のクラスファイル
 *
 * @reamsid_L DBC-2380-010 yuqingzhang
 */
public class ShomeishoSakuseiParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutanShomeishoSakusei")
    private JikoFutanShomeishoSakuseiDiv JikoFutanShomeishoSakusei;
    @JsonProperty("JikoFutanShomeishoSakuseiPrint")
    private JikoFutanShomeishoSakuseiPrintDiv JikoFutanShomeishoSakuseiPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutanShomeishoSakusei
     * @return JikoFutanShomeishoSakusei
     */
    @JsonProperty("JikoFutanShomeishoSakusei")
    public JikoFutanShomeishoSakuseiDiv getJikoFutanShomeishoSakusei() {
        return JikoFutanShomeishoSakusei;
    }

    /*
     * setJikoFutanShomeishoSakusei
     * @param JikoFutanShomeishoSakusei JikoFutanShomeishoSakusei
     */
    @JsonProperty("JikoFutanShomeishoSakusei")
    public void setJikoFutanShomeishoSakusei(JikoFutanShomeishoSakuseiDiv JikoFutanShomeishoSakusei) {
        this.JikoFutanShomeishoSakusei = JikoFutanShomeishoSakusei;
    }

    /*
     * getJikoFutanShomeishoSakuseiPrint
     * @return JikoFutanShomeishoSakuseiPrint
     */
    @JsonProperty("JikoFutanShomeishoSakuseiPrint")
    public JikoFutanShomeishoSakuseiPrintDiv getJikoFutanShomeishoSakuseiPrint() {
        return JikoFutanShomeishoSakuseiPrint;
    }

    /*
     * setJikoFutanShomeishoSakuseiPrint
     * @param JikoFutanShomeishoSakuseiPrint JikoFutanShomeishoSakuseiPrint
     */
    @JsonProperty("JikoFutanShomeishoSakuseiPrint")
    public void setJikoFutanShomeishoSakuseiPrint(JikoFutanShomeishoSakuseiPrintDiv JikoFutanShomeishoSakuseiPrint) {
        this.JikoFutanShomeishoSakuseiPrint = JikoFutanShomeishoSakuseiPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJikoFutangaku() {
        return this.getJikoFutanShomeishoSakusei().getRadJikoFutangaku();
    }

    @JsonIgnore
    public void setRadJikoFutangaku(RadioButton radJikoFutangaku) {
        this.getJikoFutanShomeishoSakusei().setRadJikoFutangaku(radJikoFutangaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtZenkaiTaishoDate() {
        return this.getJikoFutanShomeishoSakusei().getTxtZenkaiTaishoDate();
    }

    @JsonIgnore
    public void setTxtZenkaiTaishoDate(TextBoxDateRange txtZenkaiTaishoDate) {
        this.getJikoFutanShomeishoSakusei().setTxtZenkaiTaishoDate(txtZenkaiTaishoDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiDate() {
        return this.getJikoFutanShomeishoSakusei().getTxtShinseiDate();
    }

    @JsonIgnore
    public void setTxtShinseiDate(TextBoxDateRange txtShinseiDate) {
        this.getJikoFutanShomeishoSakusei().setTxtShinseiDate(txtShinseiDate);
    }

    @JsonIgnore
    public RadioButton getRadKokuhoren() {
        return this.getJikoFutanShomeishoSakusei().getRadKokuhoren();
    }

    @JsonIgnore
    public void setRadKokuhoren(RadioButton radKokuhoren) {
        this.getJikoFutanShomeishoSakusei().setRadKokuhoren(radKokuhoren);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriDate() {
        return this.getJikoFutanShomeishoSakusei().getTxtUketoriDate();
    }

    @JsonIgnore
    public void setTxtUketoriDate(TextBoxDate txtUketoriDate) {
        this.getJikoFutanShomeishoSakusei().setTxtUketoriDate(txtUketoriDate);
    }

    @JsonIgnore
    public Space getSpcInsho() {
        return this.getJikoFutanShomeishoSakusei().getSpcInsho();
    }

    @JsonIgnore
    public void setSpcInsho(Space spcInsho) {
        this.getJikoFutanShomeishoSakusei().setSpcInsho(spcInsho);
    }

    @JsonIgnore
    public DropDownList getDdlInsho() {
        return this.getJikoFutanShomeishoSakusei().getDdlInsho();
    }

    @JsonIgnore
    public void setDdlInsho(DropDownList ddlInsho) {
        this.getJikoFutanShomeishoSakusei().setDdlInsho(ddlInsho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakkoDate() {
        return this.getJikoFutanShomeishoSakuseiPrint().getTxtHakkoDate();
    }

    @JsonIgnore
    public void setTxtHakkoDate(TextBoxFlexibleDate txtHakkoDate) {
        this.getJikoFutanShomeishoSakuseiPrint().setTxtHakkoDate(txtHakkoDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return this.getJikoFutanShomeishoSakuseiPrint().getCcdBunshoBango();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getJikoFutanShomeishoSakuseiPrint().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
