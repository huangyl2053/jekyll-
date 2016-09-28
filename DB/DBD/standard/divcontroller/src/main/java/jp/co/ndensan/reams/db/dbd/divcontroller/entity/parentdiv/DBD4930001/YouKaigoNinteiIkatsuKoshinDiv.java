package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4930001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YouKaigoNinteiIkatsuKoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class YouKaigoNinteiIkatsuKoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNinteibi")
    private Label lblNinteibi;
    @JsonProperty("radSetteiHoushiki")
    private RadioButton radSetteiHoushiki;
    @JsonProperty("txtNinteibi")
    private TextBoxDate txtNinteibi;
    @JsonProperty("lblMemo1")
    private Label lblMemo1;
    @JsonProperty("lblMemo2")
    private Label lblMemo2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblNinteibi
     * @return lblNinteibi
     */
    @JsonProperty("lblNinteibi")
    public Label getLblNinteibi() {
        return lblNinteibi;
    }

    /*
     * setlblNinteibi
     * @param lblNinteibi lblNinteibi
     */
    @JsonProperty("lblNinteibi")
    public void setLblNinteibi(Label lblNinteibi) {
        this.lblNinteibi = lblNinteibi;
    }

    /*
     * getradSetteiHoushiki
     * @return radSetteiHoushiki
     */
    @JsonProperty("radSetteiHoushiki")
    public RadioButton getRadSetteiHoushiki() {
        return radSetteiHoushiki;
    }

    /*
     * setradSetteiHoushiki
     * @param radSetteiHoushiki radSetteiHoushiki
     */
    @JsonProperty("radSetteiHoushiki")
    public void setRadSetteiHoushiki(RadioButton radSetteiHoushiki) {
        this.radSetteiHoushiki = radSetteiHoushiki;
    }

    /*
     * gettxtNinteibi
     * @return txtNinteibi
     */
    @JsonProperty("txtNinteibi")
    public TextBoxDate getTxtNinteibi() {
        return txtNinteibi;
    }

    /*
     * settxtNinteibi
     * @param txtNinteibi txtNinteibi
     */
    @JsonProperty("txtNinteibi")
    public void setTxtNinteibi(TextBoxDate txtNinteibi) {
        this.txtNinteibi = txtNinteibi;
    }

    /*
     * getlblMemo1
     * @return lblMemo1
     */
    @JsonProperty("lblMemo1")
    public Label getLblMemo1() {
        return lblMemo1;
    }

    /*
     * setlblMemo1
     * @param lblMemo1 lblMemo1
     */
    @JsonProperty("lblMemo1")
    public void setLblMemo1(Label lblMemo1) {
        this.lblMemo1 = lblMemo1;
    }

    /*
     * getlblMemo2
     * @return lblMemo2
     */
    @JsonProperty("lblMemo2")
    public Label getLblMemo2() {
        return lblMemo2;
    }

    /*
     * setlblMemo2
     * @param lblMemo2 lblMemo2
     */
    @JsonProperty("lblMemo2")
    public void setLblMemo2(Label lblMemo2) {
        this.lblMemo2 = lblMemo2;
    }

    // </editor-fold>
}
