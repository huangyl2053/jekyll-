package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TextMasking.TextMasking;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblTextMasking のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTextMaskingDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTableCell1")
    private celTableCell1AttblTextMasking celTableCell1;
    @JsonProperty("celTableCell2")
    private celTableCell2AttblTextMasking celTableCell2;
    @JsonProperty("celTableCell3")
    private celTableCell3AttblTextMasking celTableCell3;
    @JsonProperty("celTableCell6")
    private celTableCell6AttblTextMasking celTableCell6;
    @JsonProperty("celTableCell4")
    private celTableCell4AttblTextMasking celTableCell4;
    @JsonProperty("celTableCell5")
    private celTableCell5AttblTextMasking celTableCell5;
    @JsonProperty("celTableCell7")
    private celTableCell7AttblTextMasking celTableCell7;
    @JsonProperty("celTableCell8")
    private celTableCell8AttblTextMasking celTableCell8;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtChosaKomokuNo() {
        return this.celTableCell1.getTxtChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblHyphen() {
        return this.celTableCell2.getLblHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtChosaKomokuRenban() {
        return this.celTableCell3.getTxtChosaKomokuRenban();
    }

    @JsonIgnore
    public TextBox getTxtChosaKomokuMeisho() {
        return this.celTableCell6.getTxtChosaKomokuMeisho();
    }

    @JsonIgnore
    public Label getLblBeforeMasking() {
        return this.celTableCell4.getLblBeforeMasking();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBeforeMasking() {
        return this.celTableCell5.getTxtBeforeMasking();
    }

    @JsonIgnore
    public Label getLblAfterMasking() {
        return this.celTableCell7.getLblAfterMasking();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtAfterMasking() {
        return this.celTableCell8.getTxtAfterMasking();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTableCell1
     * @return celTableCell1
     */
    @JsonProperty("celTableCell1")
    private celTableCell1AttblTextMasking getCelTableCell1() {
        return celTableCell1;
    }

    /*
     * setcelTableCell1
     * @param celTableCell1 celTableCell1
     */
    @JsonProperty("celTableCell1")
    private void setCelTableCell1(celTableCell1AttblTextMasking celTableCell1) {
        this.celTableCell1 = celTableCell1;
    }

    /*
     * getcelTableCell2
     * @return celTableCell2
     */
    @JsonProperty("celTableCell2")
    private celTableCell2AttblTextMasking getCelTableCell2() {
        return celTableCell2;
    }

    /*
     * setcelTableCell2
     * @param celTableCell2 celTableCell2
     */
    @JsonProperty("celTableCell2")
    private void setCelTableCell2(celTableCell2AttblTextMasking celTableCell2) {
        this.celTableCell2 = celTableCell2;
    }

    /*
     * getcelTableCell3
     * @return celTableCell3
     */
    @JsonProperty("celTableCell3")
    private celTableCell3AttblTextMasking getCelTableCell3() {
        return celTableCell3;
    }

    /*
     * setcelTableCell3
     * @param celTableCell3 celTableCell3
     */
    @JsonProperty("celTableCell3")
    private void setCelTableCell3(celTableCell3AttblTextMasking celTableCell3) {
        this.celTableCell3 = celTableCell3;
    }

    /*
     * getcelTableCell6
     * @return celTableCell6
     */
    @JsonProperty("celTableCell6")
    private celTableCell6AttblTextMasking getCelTableCell6() {
        return celTableCell6;
    }

    /*
     * setcelTableCell6
     * @param celTableCell6 celTableCell6
     */
    @JsonProperty("celTableCell6")
    private void setCelTableCell6(celTableCell6AttblTextMasking celTableCell6) {
        this.celTableCell6 = celTableCell6;
    }

    /*
     * getcelTableCell4
     * @return celTableCell4
     */
    @JsonProperty("celTableCell4")
    private celTableCell4AttblTextMasking getCelTableCell4() {
        return celTableCell4;
    }

    /*
     * setcelTableCell4
     * @param celTableCell4 celTableCell4
     */
    @JsonProperty("celTableCell4")
    private void setCelTableCell4(celTableCell4AttblTextMasking celTableCell4) {
        this.celTableCell4 = celTableCell4;
    }

    /*
     * getcelTableCell5
     * @return celTableCell5
     */
    @JsonProperty("celTableCell5")
    private celTableCell5AttblTextMasking getCelTableCell5() {
        return celTableCell5;
    }

    /*
     * setcelTableCell5
     * @param celTableCell5 celTableCell5
     */
    @JsonProperty("celTableCell5")
    private void setCelTableCell5(celTableCell5AttblTextMasking celTableCell5) {
        this.celTableCell5 = celTableCell5;
    }

    /*
     * getcelTableCell7
     * @return celTableCell7
     */
    @JsonProperty("celTableCell7")
    private celTableCell7AttblTextMasking getCelTableCell7() {
        return celTableCell7;
    }

    /*
     * setcelTableCell7
     * @param celTableCell7 celTableCell7
     */
    @JsonProperty("celTableCell7")
    private void setCelTableCell7(celTableCell7AttblTextMasking celTableCell7) {
        this.celTableCell7 = celTableCell7;
    }

    /*
     * getcelTableCell8
     * @return celTableCell8
     */
    @JsonProperty("celTableCell8")
    private celTableCell8AttblTextMasking getCelTableCell8() {
        return celTableCell8;
    }

    /*
     * setcelTableCell8
     * @param celTableCell8 celTableCell8
     */
    @JsonProperty("celTableCell8")
    private void setCelTableCell8(celTableCell8AttblTextMasking celTableCell8) {
        this.celTableCell8 = celTableCell8;
    }

    // </editor-fold>
}
/**
 * celTableCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell1AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtChosaKomokuNo")
    private TextBox txtChosaKomokuNo;

    /*
     * gettxtChosaKomokuNo
     * @return txtChosaKomokuNo
     */
    @JsonProperty("txtChosaKomokuNo")
    public TextBox getTxtChosaKomokuNo() {
        return txtChosaKomokuNo;
    }

    /*
     * settxtChosaKomokuNo
     * @param txtChosaKomokuNo txtChosaKomokuNo
     */
    @JsonProperty("txtChosaKomokuNo")
    public void setTxtChosaKomokuNo(TextBox txtChosaKomokuNo) {
        this.txtChosaKomokuNo = txtChosaKomokuNo;
    }

    // </editor-fold>
}
/**
 * celTableCell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell2AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblHyphen")
    private Label lblHyphen;

    /*
     * getlblHyphen
     * @return lblHyphen
     */
    @JsonProperty("lblHyphen")
    public Label getLblHyphen() {
        return lblHyphen;
    }

    /*
     * setlblHyphen
     * @param lblHyphen lblHyphen
     */
    @JsonProperty("lblHyphen")
    public void setLblHyphen(Label lblHyphen) {
        this.lblHyphen = lblHyphen;
    }

    // </editor-fold>
}
/**
 * celTableCell3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell3AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtChosaKomokuRenban")
    private TextBoxNum txtChosaKomokuRenban;

    /*
     * gettxtChosaKomokuRenban
     * @return txtChosaKomokuRenban
     */
    @JsonProperty("txtChosaKomokuRenban")
    public TextBoxNum getTxtChosaKomokuRenban() {
        return txtChosaKomokuRenban;
    }

    /*
     * settxtChosaKomokuRenban
     * @param txtChosaKomokuRenban txtChosaKomokuRenban
     */
    @JsonProperty("txtChosaKomokuRenban")
    public void setTxtChosaKomokuRenban(TextBoxNum txtChosaKomokuRenban) {
        this.txtChosaKomokuRenban = txtChosaKomokuRenban;
    }

    // </editor-fold>
}
/**
 * celTableCell6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell6AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtChosaKomokuMeisho")
    private TextBox txtChosaKomokuMeisho;

    /*
     * gettxtChosaKomokuMeisho
     * @return txtChosaKomokuMeisho
     */
    @JsonProperty("txtChosaKomokuMeisho")
    public TextBox getTxtChosaKomokuMeisho() {
        return txtChosaKomokuMeisho;
    }

    /*
     * settxtChosaKomokuMeisho
     * @param txtChosaKomokuMeisho txtChosaKomokuMeisho
     */
    @JsonProperty("txtChosaKomokuMeisho")
    public void setTxtChosaKomokuMeisho(TextBox txtChosaKomokuMeisho) {
        this.txtChosaKomokuMeisho = txtChosaKomokuMeisho;
    }

    // </editor-fold>
}
/**
 * celTableCell4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell4AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblBeforeMasking")
    private Label lblBeforeMasking;

    /*
     * getlblBeforeMasking
     * @return lblBeforeMasking
     */
    @JsonProperty("lblBeforeMasking")
    public Label getLblBeforeMasking() {
        return lblBeforeMasking;
    }

    /*
     * setlblBeforeMasking
     * @param lblBeforeMasking lblBeforeMasking
     */
    @JsonProperty("lblBeforeMasking")
    public void setLblBeforeMasking(Label lblBeforeMasking) {
        this.lblBeforeMasking = lblBeforeMasking;
    }

    // </editor-fold>
}
/**
 * celTableCell5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell5AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtBeforeMasking")
    private TextBoxMultiLine txtBeforeMasking;

    /*
     * gettxtBeforeMasking
     * @return txtBeforeMasking
     */
    @JsonProperty("txtBeforeMasking")
    public TextBoxMultiLine getTxtBeforeMasking() {
        return txtBeforeMasking;
    }

    /*
     * settxtBeforeMasking
     * @param txtBeforeMasking txtBeforeMasking
     */
    @JsonProperty("txtBeforeMasking")
    public void setTxtBeforeMasking(TextBoxMultiLine txtBeforeMasking) {
        this.txtBeforeMasking = txtBeforeMasking;
    }

    // </editor-fold>
}
/**
 * celTableCell7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell7AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblAfterMasking")
    private Label lblAfterMasking;

    /*
     * getlblAfterMasking
     * @return lblAfterMasking
     */
    @JsonProperty("lblAfterMasking")
    public Label getLblAfterMasking() {
        return lblAfterMasking;
    }

    /*
     * setlblAfterMasking
     * @param lblAfterMasking lblAfterMasking
     */
    @JsonProperty("lblAfterMasking")
    public void setLblAfterMasking(Label lblAfterMasking) {
        this.lblAfterMasking = lblAfterMasking;
    }

    // </editor-fold>
}
/**
 * celTableCell8 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell8AttblTextMasking extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtAfterMasking")
    private TextBoxMultiLine txtAfterMasking;

    /*
     * gettxtAfterMasking
     * @return txtAfterMasking
     */
    @JsonProperty("txtAfterMasking")
    public TextBoxMultiLine getTxtAfterMasking() {
        return txtAfterMasking;
    }

    /*
     * settxtAfterMasking
     * @param txtAfterMasking txtAfterMasking
     */
    @JsonProperty("txtAfterMasking")
    public void setTxtAfterMasking(TextBoxMultiLine txtAfterMasking) {
        this.txtAfterMasking = txtAfterMasking;
    }

    // </editor-fold>
}
