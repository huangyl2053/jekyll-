package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuGendogakuMain のクラスファイル
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShikyuGendogakuMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuGendogakuIchiran")
    private ShokanShikyuGendogakuIchiranDiv ShokanShikyuGendogakuIchiran;
    @JsonProperty("ShokanShikyuGendogakuShosai")
    private ShokanShikyuGendogakuShosaiDiv ShokanShikyuGendogakuShosai;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShokanShikyuGendogakuIchiran
     * @return ShokanShikyuGendogakuIchiran
     */
    @JsonProperty("ShokanShikyuGendogakuIchiran")
    public ShokanShikyuGendogakuIchiranDiv getShokanShikyuGendogakuIchiran() {
        return ShokanShikyuGendogakuIchiran;
    }

    /*
     * setShokanShikyuGendogakuIchiran
     * @param ShokanShikyuGendogakuIchiran ShokanShikyuGendogakuIchiran
     */
    @JsonProperty("ShokanShikyuGendogakuIchiran")
    public void setShokanShikyuGendogakuIchiran(ShokanShikyuGendogakuIchiranDiv ShokanShikyuGendogakuIchiran) {
        this.ShokanShikyuGendogakuIchiran = ShokanShikyuGendogakuIchiran;
    }

    /*
     * getShokanShikyuGendogakuShosai
     * @return ShokanShikyuGendogakuShosai
     */
    @JsonProperty("ShokanShikyuGendogakuShosai")
    public ShokanShikyuGendogakuShosaiDiv getShokanShikyuGendogakuShosai() {
        return ShokanShikyuGendogakuShosai;
    }

    /*
     * setShokanShikyuGendogakuShosai
     * @param ShokanShikyuGendogakuShosai ShokanShikyuGendogakuShosai
     */
    @JsonProperty("ShokanShikyuGendogakuShosai")
    public void setShokanShikyuGendogakuShosai(ShokanShikyuGendogakuShosaiDiv ShokanShikyuGendogakuShosai) {
        this.ShokanShikyuGendogakuShosai = ShokanShikyuGendogakuShosai;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAddShikyuGendogaku() {
        return this.getShokanShikyuGendogakuIchiran().getBtnAddShikyuGendogaku();
    }

    @JsonIgnore
    public void setBtnAddShikyuGendogaku(Button btnAddShikyuGendogaku) {
        this.getShokanShikyuGendogakuIchiran().setBtnAddShikyuGendogaku(btnAddShikyuGendogaku);
    }

    @JsonIgnore
    public DataGrid<dgShikyuGendogaku_Row> getDgShikyuGendogaku() {
        return this.getShokanShikyuGendogakuIchiran().getDgShikyuGendogaku();
    }

    @JsonIgnore
    public void setDgShikyuGendogaku(DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku) {
        this.getShokanShikyuGendogakuIchiran().setDgShikyuGendogaku(dgShikyuGendogaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoKikanRange() {
        return this.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange();
    }

    @JsonIgnore
    public void setTxtTekiyoKikanRange(TextBoxDateRange txtTekiyoKikanRange) {
        this.getShokanShikyuGendogakuShosai().setTxtTekiyoKikanRange(txtTekiyoKikanRange);
    }

    @JsonIgnore
    public HorizontalLine getLin01() {
        return this.getShokanShikyuGendogakuShosai().getLin01();
    }

    @JsonIgnore
    public void setLin01(HorizontalLine lin01) {
        this.getShokanShikyuGendogakuShosai().setLin01(lin01);
    }

    @JsonIgnore
    public Label getLblMassage2() {
        return this.getShokanShikyuGendogakuShosai().getLblMassage2();
    }

    @JsonIgnore
    public void setLblMassage2(Label lblMassage2) {
        this.getShokanShikyuGendogakuShosai().setLblMassage2(lblMassage2);
    }

    @JsonIgnore
    public RadioButton getRadTableKubun() {
        return this.getShokanShikyuGendogakuShosai().getRadTableKubun();
    }

    @JsonIgnore
    public void setRadTableKubun(RadioButton radTableKubun) {
        this.getShokanShikyuGendogakuShosai().setRadTableKubun(radTableKubun);
    }

    @JsonIgnore
    public Space getSpc01() {
        return this.getShokanShikyuGendogakuShosai().getSpc01();
    }

    @JsonIgnore
    public void setSpc01(Space spc01) {
        this.getShokanShikyuGendogakuShosai().setSpc01(spc01);
    }

    @JsonIgnore
    public tblGendogakuDiv getTblGendogaku() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku();
    }

    @JsonIgnore
    public void setTblGendogaku(tblGendogakuDiv tblGendogaku) {
        this.getShokanShikyuGendogakuShosai().setTblGendogaku(tblGendogaku);
    }

    @JsonIgnore
    public Label getLblKyotakuKaigo() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getLblKyotakuKaigo();
    }

    @JsonIgnore
    public Label getLblKyotakuShien() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getLblKyotakuShien();
    }

    @JsonIgnore
    public Label getLblKyotakuKaigoFukushiYogu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getLblKyotakuKaigoFukushiYogu();
    }

    @JsonIgnore
    public Label getLblKyotakuKaigoJutakuKaishu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getLblKyotakuKaigoJutakuKaishu();
    }

    @JsonIgnore
    public Label getLblKyotakuShienFukushiYogu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getLblKyotakuShienFukushiYogu();
    }

    @JsonIgnore
    public Label getLblKyotakuShienJutakuKaishu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getLblKyotakuShienJutakuKaishu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuKaigoFukushiYogu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getTxtKyotakuKaigoFukushiYogu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuKaigoJutakuKaishu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getTxtKyotakuKaigoJutakuKaishu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuShienFukushiYogu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getTxtKyotakuShienFukushiYogu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuShienJutakuKaishu() {
        return this.getShokanShikyuGendogakuShosai().getTblGendogaku().getTxtKyotakuShienJutakuKaishu();
    }

    @JsonIgnore
    public ShokanShikyuGendogakuShosaiFooterDiv getShokanShikyuGendogakuShosaiFooter() {
        return this.getShokanShikyuGendogakuShosai().getShokanShikyuGendogakuShosaiFooter();
    }

    @JsonIgnore
    public void setShokanShikyuGendogakuShosaiFooter(ShokanShikyuGendogakuShosaiFooterDiv ShokanShikyuGendogakuShosaiFooter) {
        this.getShokanShikyuGendogakuShosai().setShokanShikyuGendogakuShosaiFooter(ShokanShikyuGendogakuShosaiFooter);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getShokanShikyuGendogakuShosai().getShokanShikyuGendogakuShosaiFooter().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getShokanShikyuGendogakuShosai().getShokanShikyuGendogakuShosaiFooter().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
