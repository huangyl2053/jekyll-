package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5720001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JyukyushaDaichoIdoCheckList のクラスファイル 
 * 
 * @author 自動生成
 */
public class JyukyushaDaichoIdoCheckListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JhokenPancel")
    private JhokenPancelDiv JhokenPancel;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJhokenPancel
     * @return JhokenPancel
     */
    @JsonProperty("JhokenPancel")
    public JhokenPancelDiv getJhokenPancel() {
        return JhokenPancel;
    }

    /*
     * setJhokenPancel
     * @param JhokenPancel JhokenPancel
     */
    @JsonProperty("JhokenPancel")
    public void setJhokenPancel(JhokenPancelDiv JhokenPancel) {
        this.JhokenPancel = JhokenPancel;
    }

    /*
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKikan() {
        return this.getJhokenPancel().getLblKikan();
    }

    @JsonIgnore
    public void  setLblKikan(Label lblKikan) {
        this.getJhokenPancel().setLblKikan(lblKikan);
    }

    @JsonIgnore
    public Label getLblZenkai() {
        return this.getJhokenPancel().getLblZenkai();
    }

    @JsonIgnore
    public void  setLblZenkai(Label lblZenkai) {
        this.getJhokenPancel().setLblZenkai(lblZenkai);
    }

    @JsonIgnore
    public TextBoxDateTimeRange getTxtRangeZenkai() {
        return this.getJhokenPancel().getTxtRangeZenkai();
    }

    @JsonIgnore
    public void  setTxtRangeZenkai(TextBoxDateTimeRange txtRangeZenkai) {
        this.getJhokenPancel().setTxtRangeZenkai(txtRangeZenkai);
    }

    @JsonIgnore
    public Label getLblKonkai() {
        return this.getJhokenPancel().getLblKonkai();
    }

    @JsonIgnore
    public void  setLblKonkai(Label lblKonkai) {
        this.getJhokenPancel().setLblKonkai(lblKonkai);
    }

    @JsonIgnore
    public TextBoxDateTimeRange getTxtRangeKonkai() {
        return this.getJhokenPancel().getTxtRangeKonkai();
    }

    @JsonIgnore
    public void  setTxtRangeKonkai(TextBoxDateTimeRange txtRangeKonkai) {
        this.getJhokenPancel().setTxtRangeKonkai(txtRangeKonkai);
    }

    @JsonIgnore
    public Label getLblComment() {
        return this.getJhokenPancel().getLblComment();
    }

    @JsonIgnore
    public void  setLblComment(Label lblComment) {
        this.getJhokenPancel().setLblComment(lblComment);
    }

    @JsonIgnore
    public Space getSp1() {
        return this.getJhokenPancel().getSp1();
    }

    @JsonIgnore
    public void  setSp1(Space sp1) {
        this.getJhokenPancel().setSp1(sp1);
    }

    @JsonIgnore
    public Label getLblTaisho() {
        return this.getJhokenPancel().getLblTaisho();
    }

    @JsonIgnore
    public void  setLblTaisho(Label lblTaisho) {
        this.getJhokenPancel().setLblTaisho(lblTaisho);
    }

    @JsonIgnore
    public DropDownList getDdlShuturtokuTaisho() {
        return this.getJhokenPancel().getDdlShuturtokuTaisho();
    }

    @JsonIgnore
    public void  setDdlShuturtokuTaisho(DropDownList ddlShuturtokuTaisho) {
        this.getJhokenPancel().setDdlShuturtokuTaisho(ddlShuturtokuTaisho);
    }

    // </editor-fold>
}
