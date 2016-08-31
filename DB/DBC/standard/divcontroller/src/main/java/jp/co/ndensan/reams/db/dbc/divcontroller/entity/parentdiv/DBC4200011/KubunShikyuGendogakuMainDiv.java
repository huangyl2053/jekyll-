package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;
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
 * KubunShikyuGendogakuMain のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendogakuMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KubunShikyuGendogakuIchiran")
    private KubunShikyuGendogakuIchiranDiv KubunShikyuGendogakuIchiran;
    @JsonProperty("KubunShikyuGendogakuShosai")
    private KubunShikyuGendogakuShosaiDiv KubunShikyuGendogakuShosai;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKubunShikyuGendogakuIchiran
     * @return KubunShikyuGendogakuIchiran
     */
    @JsonProperty("KubunShikyuGendogakuIchiran")
    public KubunShikyuGendogakuIchiranDiv getKubunShikyuGendogakuIchiran() {
        return KubunShikyuGendogakuIchiran;
    }

    /*
     * setKubunShikyuGendogakuIchiran
     * @param KubunShikyuGendogakuIchiran KubunShikyuGendogakuIchiran
     */
    @JsonProperty("KubunShikyuGendogakuIchiran")
    public void setKubunShikyuGendogakuIchiran(KubunShikyuGendogakuIchiranDiv KubunShikyuGendogakuIchiran) {
        this.KubunShikyuGendogakuIchiran = KubunShikyuGendogakuIchiran;
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
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAddShikyuGendogaku() {
        return this.getKubunShikyuGendogakuIchiran().getBtnAddShikyuGendogaku();
    }

    @JsonIgnore
    public void setBtnAddShikyuGendogaku(Button btnAddShikyuGendogaku) {
        this.getKubunShikyuGendogakuIchiran().setBtnAddShikyuGendogaku(btnAddShikyuGendogaku);
    }

    @JsonIgnore
    public DataGrid<dgShikyuGendogaku_Row> getDgShikyuGendogaku() {
        return this.getKubunShikyuGendogakuIchiran().getDgShikyuGendogaku();
    }

    @JsonIgnore
    public void setDgShikyuGendogaku(DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku) {
        this.getKubunShikyuGendogakuIchiran().setDgShikyuGendogaku(dgShikyuGendogaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoKikanRange() {
        return this.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange();
    }

    @JsonIgnore
    public void setTxtTekiyoKikanRange(TextBoxDateRange txtTekiyoKikanRange) {
        this.getKubunShikyuGendogakuShosai().setTxtTekiyoKikanRange(txtTekiyoKikanRange);
    }

    @JsonIgnore
    public HorizontalLine getLin01() {
        return this.getKubunShikyuGendogakuShosai().getLin01();
    }

    @JsonIgnore
    public void setLin01(HorizontalLine lin01) {
        this.getKubunShikyuGendogakuShosai().setLin01(lin01);
    }

    @JsonIgnore
    public Label getLbl01() {
        return this.getKubunShikyuGendogakuShosai().getLbl01();
    }

    @JsonIgnore
    public void setLbl01(Label lbl01) {
        this.getKubunShikyuGendogakuShosai().setLbl01(lbl01);
    }

    @JsonIgnore
    public RadioButton getRadTableKubun() {
        return this.getKubunShikyuGendogakuShosai().getRadTableKubun();
    }

    @JsonIgnore
    public void setRadTableKubun(RadioButton radTableKubun) {
        this.getKubunShikyuGendogakuShosai().setRadTableKubun(radTableKubun);
    }

    @JsonIgnore
    public Space getSpc01() {
        return this.getKubunShikyuGendogakuShosai().getSpc01();
    }

    @JsonIgnore
    public void setSpc01(Space spc01) {
        this.getKubunShikyuGendogakuShosai().setSpc01(spc01);
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
    public Label getLblYokaigo1() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblYokaigo1();
    }

    @JsonIgnore
    public Label getLblYokaigo2() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblYokaigo2();
    }

    @JsonIgnore
    public Label getLblYokaigo3() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblYokaigo3();
    }

    @JsonIgnore
    public Label getLblYokaigo4() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblYokaigo4();
    }

    @JsonIgnore
    public Label getLblYokaigo5() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblYokaigo5();
    }

    @JsonIgnore
    public Label getLblKeikaKaigo() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblKeikaKaigo();
    }

    @JsonIgnore
    public Label getLblYoshien1() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblYoshien1();
    }

    @JsonIgnore
    public Label getLblYoshien2() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getLblYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo1ShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYokaigo1ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo2ShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYokaigo2ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo3ShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYokaigo3ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo4ShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYokaigo4ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo5ShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYokaigo5ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikaKaigoShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtKeikaKaigoShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoshien1ShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYoshien1ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoshien2ShikyuGendogaku() {
        return this.getKubunShikyuGendogakuShosai().getTblGendogaku().getTxtYoshien2ShikyuGendogaku();
    }

    @JsonIgnore
    public KubunShikyuGendogakuShosaiFooterDiv getKubunShikyuGendogakuShosaiFooter() {
        return this.getKubunShikyuGendogakuShosai().getKubunShikyuGendogakuShosaiFooter();
    }

    @JsonIgnore
    public void setKubunShikyuGendogakuShosaiFooter(KubunShikyuGendogakuShosaiFooterDiv KubunShikyuGendogakuShosaiFooter) {
        this.getKubunShikyuGendogakuShosai().setKubunShikyuGendogakuShosaiFooter(KubunShikyuGendogakuShosaiFooter);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getKubunShikyuGendogakuShosai().getKubunShikyuGendogakuShosaiFooter().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getKubunShikyuGendogakuShosai().getKubunShikyuGendogakuShosaiFooter().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
