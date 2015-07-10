package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ModoruDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorKannoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorKanoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorMitoraiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorTaishoGaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorToraiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgTainoShosaiInfo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblCommentDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TainoGengakuShosaiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoGengakuShosaiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkHyojiKirikae")
    private CheckBoxList chkHyojiKirikae;
    @JsonProperty("txtNendo")
    private TextBoxDate txtNendo;
    @JsonProperty("dgTainoShosaiInfo")
    private DataGrid<dgTainoShosaiInfo_Row> dgTainoShosaiInfo;
    @JsonProperty("tblComment")
    private tblCommentDiv tblComment;
    @JsonProperty("Modoru")
    private ModoruDiv Modoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkHyojiKirikae")
    public CheckBoxList getChkHyojiKirikae() {
        return chkHyojiKirikae;
    }

    @JsonProperty("chkHyojiKirikae")
    public void setChkHyojiKirikae(CheckBoxList chkHyojiKirikae) {
        this.chkHyojiKirikae=chkHyojiKirikae;
    }

    @JsonProperty("txtNendo")
    public TextBoxDate getTxtNendo() {
        return txtNendo;
    }

    @JsonProperty("txtNendo")
    public void setTxtNendo(TextBoxDate txtNendo) {
        this.txtNendo=txtNendo;
    }

    @JsonProperty("dgTainoShosaiInfo")
    public DataGrid<dgTainoShosaiInfo_Row> getDgTainoShosaiInfo() {
        return dgTainoShosaiInfo;
    }

    @JsonProperty("dgTainoShosaiInfo")
    public void setDgTainoShosaiInfo(DataGrid<dgTainoShosaiInfo_Row> dgTainoShosaiInfo) {
        this.dgTainoShosaiInfo=dgTainoShosaiInfo;
    }

    @JsonProperty("tblComment")
    public tblCommentDiv getTblComment() {
        return tblComment;
    }

    @JsonProperty("tblComment")
    public void setTblComment(tblCommentDiv tblComment) {
        this.tblComment=tblComment;
    }

    @JsonProperty("Modoru")
    public ModoruDiv getModoru() {
        return Modoru;
    }

    @JsonProperty("Modoru")
    public void setModoru(ModoruDiv Modoru) {
        this.Modoru=Modoru;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TainocolorKannoDiv getTainocolorKanno() {
        return this.getTblComment().getTainocolorKanno();
    }

    @JsonIgnore
    public Label getLblColorWhite() {
        return this.getTblComment().getTainocolorKanno().getLblColorWhite();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiKanno() {
        return this.getTblComment().getLblTainoSetsumeiKanno();
    }

    @JsonIgnore
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return this.getTblComment().getTainocolorMitorai();
    }

    @JsonIgnore
    public Label getLblDummyYellow() {
        return this.getTblComment().getTainocolorMitorai().getLblDummyYellow();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiMiTorai() {
        return this.getTblComment().getLblTainoSetsumeiMiTorai();
    }

    @JsonIgnore
    public TainocolorToraiDiv getTainocolorTorai() {
        return this.getTblComment().getTainocolorTorai();
    }

    @JsonIgnore
    public Label getLblDummyRed() {
        return this.getTblComment().getTainocolorTorai().getLblDummyRed();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiTorai() {
        return this.getTblComment().getLblTainoSetsumeiTorai();
    }

    @JsonIgnore
    public TainocolorTaishoGaiDiv getTainocolorTaishoGai() {
        return this.getTblComment().getTainocolorTaishoGai();
    }

    @JsonIgnore
    public Label getLblLightSalmon() {
        return this.getTblComment().getTainocolorTaishoGai().getLblLightSalmon();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiTaishoGai() {
        return this.getTblComment().getLblTainoSetsumeiTaishoGai();
    }

    @JsonIgnore
    public TainocolorKanoDiv getTainocolorKano() {
        return this.getTblComment().getTainocolorKano();
    }

    @JsonIgnore
    public Label getLblDummyGreen() {
        return this.getTblComment().getTainocolorKano().getLblDummyGreen();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiKano() {
        return this.getTblComment().getLblTainoSetsumeiKano();
    }

    @JsonIgnore
    public Button getBtnModoru() {
        return this.getModoru().getBtnModoru();
    }

    @JsonIgnore
    public void  setBtnModoru(Button btnModoru) {
        this.getModoru().setBtnModoru(btnModoru);
    }

}
