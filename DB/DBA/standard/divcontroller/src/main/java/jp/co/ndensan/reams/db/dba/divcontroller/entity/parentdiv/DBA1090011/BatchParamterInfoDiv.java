package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1090011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * BatchParamterInfo のクラスファイル
 *
 */
public class BatchParamterInfoDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShichoson")
    private DropDownList ddlShichoson;
    @JsonProperty("linShichosonShitei")
    private HorizontalLine linShichosonShitei;
    @JsonProperty("lblIdo")
    private Label lblIdo;
    @JsonProperty("chkTenshutsuSakuseiJiyu")
    private CheckBoxList chkTenshutsuSakuseiJiyu;
    @JsonProperty("lblZenkaiKaishi")
    private Label lblZenkaiKaishi;
    @JsonProperty("txtZenkaiKaishi")
    private TextBoxFlexibleDate txtZenkaiKaishi;
    @JsonProperty("lblZenkaiKara")
    private Label lblZenkaiKara;
    @JsonProperty("txtZenkaiKara")
    private TextBoxFlexibleDate txtZenkaiKara;
    @JsonProperty("linJiyu")
    private HorizontalLine linJiyu;
    @JsonProperty("lblTennyu")
    private Label lblTennyu;
    @JsonProperty("chkTennyuSakuseiJiyu")
    private CheckBoxList chkTennyuSakuseiJiyu;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShichoson
     * @return ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public DropDownList getDdlShichoson() {
        return ddlShichoson;
    }

    /*
     * setddlShichoson
     * @param ddlShichoson ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.ddlShichoson = ddlShichoson;
    }

    /*
     * getlinShichosonShitei
     * @return linShichosonShitei
     */
    @JsonProperty("linShichosonShitei")
    public HorizontalLine getLinShichosonShitei() {
        return linShichosonShitei;
    }

    /*
     * setlinShichosonShitei
     * @param linShichosonShitei linShichosonShitei
     */
    @JsonProperty("linShichosonShitei")
    public void setLinShichosonShitei(HorizontalLine linShichosonShitei) {
        this.linShichosonShitei = linShichosonShitei;
    }

    /*
     * getlblIdo
     * @return lblIdo
     */
    @JsonProperty("lblIdo")
    public Label getLblIdo() {
        return lblIdo;
    }

    /*
     * setlblIdo
     * @param lblIdo lblIdo
     */
    @JsonProperty("lblIdo")
    public void setLblIdo(Label lblIdo) {
        this.lblIdo = lblIdo;
    }

    /*
     * getchkTenshutsuSakuseiJiyu
     * @return chkTenshutsuSakuseiJiyu
     */
    @JsonProperty("chkTenshutsuSakuseiJiyu")
    public CheckBoxList getChkTenshutsuSakuseiJiyu() {
        return chkTenshutsuSakuseiJiyu;
    }

    /*
     * setchkTenshutsuSakuseiJiyu
     * @param chkTenshutsuSakuseiJiyu chkTenshutsuSakuseiJiyu
     */
    @JsonProperty("chkTenshutsuSakuseiJiyu")
    public void setChkTenshutsuSakuseiJiyu(CheckBoxList chkTenshutsuSakuseiJiyu) {
        this.chkTenshutsuSakuseiJiyu = chkTenshutsuSakuseiJiyu;
    }

    /*
     * getlblZenkaiKaishi
     * @return lblZenkaiKaishi
     */
    @JsonProperty("lblZenkaiKaishi")
    public Label getLblZenkaiKaishi() {
        return lblZenkaiKaishi;
    }

    /*
     * setlblZenkaiKaishi
     * @param lblZenkaiKaishi lblZenkaiKaishi
     */
    @JsonProperty("lblZenkaiKaishi")
    public void setLblZenkaiKaishi(Label lblZenkaiKaishi) {
        this.lblZenkaiKaishi = lblZenkaiKaishi;
    }

    /*
     * gettxtZenkaiKaishi
     * @return txtZenkaiKaishi
     */
    @JsonProperty("txtZenkaiKaishi")
    public TextBoxFlexibleDate getTxtZenkaiKaishi() {
        return txtZenkaiKaishi;
    }

    /*
     * settxtZenkaiKaishi
     * @param txtZenkaiKaishi txtZenkaiKaishi
     */
    @JsonProperty("txtZenkaiKaishi")
    public void setTxtZenkaiKaishi(TextBoxFlexibleDate txtZenkaiKaishi) {
        this.txtZenkaiKaishi = txtZenkaiKaishi;
    }

    /*
     * getlblZenkaiKara
     * @return lblZenkaiKara
     */
    @JsonProperty("lblZenkaiKara")
    public Label getLblZenkaiKara() {
        return lblZenkaiKara;
    }

    /*
     * setlblZenkaiKara
     * @param lblZenkaiKara lblZenkaiKara
     */
    @JsonProperty("lblZenkaiKara")
    public void setLblZenkaiKara(Label lblZenkaiKara) {
        this.lblZenkaiKara = lblZenkaiKara;
    }

    /*
     * gettxtZenkaiKara
     * @return txtZenkaiKara
     */
    @JsonProperty("txtZenkaiKara")
    public TextBoxFlexibleDate getTxtZenkaiKara() {
        return txtZenkaiKara;
    }

    /*
     * settxtZenkaiKara
     * @param txtZenkaiKara txtZenkaiKara
     */
    @JsonProperty("txtZenkaiKara")
    public void setTxtZenkaiKara(TextBoxFlexibleDate txtZenkaiKara) {
        this.txtZenkaiKara = txtZenkaiKara;
    }

    /*
     * getlinJiyu
     * @return linJiyu
     */
    @JsonProperty("linJiyu")
    public HorizontalLine getLinJiyu() {
        return linJiyu;
    }

    /*
     * setlinJiyu
     * @param linJiyu linJiyu
     */
    @JsonProperty("linJiyu")
    public void setLinJiyu(HorizontalLine linJiyu) {
        this.linJiyu = linJiyu;
    }

    /*
     * getlblTennyu
     * @return lblTennyu
     */
    @JsonProperty("lblTennyu")
    public Label getLblTennyu() {
        return lblTennyu;
    }

    /*
     * setlblTennyu
     * @param lblTennyu lblTennyu
     */
    @JsonProperty("lblTennyu")
    public void setLblTennyu(Label lblTennyu) {
        this.lblTennyu = lblTennyu;
    }

    /*
     * getchkTennyuSakuseiJiyu
     * @return chkTennyuSakuseiJiyu
     */
    @JsonProperty("chkTennyuSakuseiJiyu")
    public CheckBoxList getChkTennyuSakuseiJiyu() {
        return chkTennyuSakuseiJiyu;
    }

    /*
     * setchkTennyuSakuseiJiyu
     * @param chkTennyuSakuseiJiyu chkTennyuSakuseiJiyu
     */
    @JsonProperty("chkTennyuSakuseiJiyu")
    public void setChkTennyuSakuseiJiyu(CheckBoxList chkTennyuSakuseiJiyu) {
        this.chkTennyuSakuseiJiyu = chkTennyuSakuseiJiyu;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
