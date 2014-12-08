package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorKannoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorKanoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorMitoraiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorTaishoGaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorToraiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblComment のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblCommentDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTainocolorKanno")
    private celTainocolorKannoAttblComment celTainocolorKanno;
    @JsonProperty("celTainoSetsumeiKanno")
    private celTainoSetsumeiKannoAttblComment celTainoSetsumeiKanno;
    @JsonProperty("celTainocolorMitorai")
    private celTainocolorMitoraiAttblComment celTainocolorMitorai;
    @JsonProperty("celTainoSetsumeiMiTorai")
    private celTainoSetsumeiMiToraiAttblComment celTainoSetsumeiMiTorai;
    @JsonProperty("celTainocolorTorai")
    private celTainocolorToraiAttblComment celTainocolorTorai;
    @JsonProperty("celTainoSetsumeiTorai")
    private celTainoSetsumeiToraiAttblComment celTainoSetsumeiTorai;
    @JsonProperty("celTainocolorTaishoGai")
    private celTainocolorTaishoGaiAttblComment celTainocolorTaishoGai;
    @JsonProperty("celTainoSetsumeiTaishoGai")
    private celTainoSetsumeiTaishoGaiAttblComment celTainoSetsumeiTaishoGai;
    @JsonProperty("celTainocolorKano")
    private celTainocolorKanoAttblComment celTainocolorKano;
    @JsonProperty("celTainoSetsumeiKano")
    private celTainoSetsumeiKanoAttblComment celTainoSetsumeiKano;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TainocolorKannoDiv getTainocolorKanno() {
        return this.celTainocolorKanno.getTainocolorKanno();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiKanno() {
        return this.celTainoSetsumeiKanno.getLblTainoSetsumeiKanno();
    }

    @JsonIgnore
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return this.celTainocolorMitorai.getTainocolorMitorai();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiMiTorai() {
        return this.celTainoSetsumeiMiTorai.getLblTainoSetsumeiMiTorai();
    }

    @JsonIgnore
    public TainocolorToraiDiv getTainocolorTorai() {
        return this.celTainocolorTorai.getTainocolorTorai();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiTorai() {
        return this.celTainoSetsumeiTorai.getLblTainoSetsumeiTorai();
    }

    @JsonIgnore
    public TainocolorTaishoGaiDiv getTainocolorTaishoGai() {
        return this.celTainocolorTaishoGai.getTainocolorTaishoGai();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiTaishoGai() {
        return this.celTainoSetsumeiTaishoGai.getLblTainoSetsumeiTaishoGai();
    }

    @JsonIgnore
    public TainocolorKanoDiv getTainocolorKano() {
        return this.celTainocolorKano.getTainocolorKano();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiKano() {
        return this.celTainoSetsumeiKano.getLblTainoSetsumeiKano();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celTainocolorKanno")
    private celTainocolorKannoAttblComment getCelTainocolorKanno() {
        return celTainocolorKanno;
    }

    @JsonProperty("celTainocolorKanno")
    private void setCelTainocolorKanno(celTainocolorKannoAttblComment celTainocolorKanno) {
        this.celTainocolorKanno=celTainocolorKanno;
    }

    @JsonProperty("celTainoSetsumeiKanno")
    private celTainoSetsumeiKannoAttblComment getCelTainoSetsumeiKanno() {
        return celTainoSetsumeiKanno;
    }

    @JsonProperty("celTainoSetsumeiKanno")
    private void setCelTainoSetsumeiKanno(celTainoSetsumeiKannoAttblComment celTainoSetsumeiKanno) {
        this.celTainoSetsumeiKanno=celTainoSetsumeiKanno;
    }

    @JsonProperty("celTainocolorMitorai")
    private celTainocolorMitoraiAttblComment getCelTainocolorMitorai() {
        return celTainocolorMitorai;
    }

    @JsonProperty("celTainocolorMitorai")
    private void setCelTainocolorMitorai(celTainocolorMitoraiAttblComment celTainocolorMitorai) {
        this.celTainocolorMitorai=celTainocolorMitorai;
    }

    @JsonProperty("celTainoSetsumeiMiTorai")
    private celTainoSetsumeiMiToraiAttblComment getCelTainoSetsumeiMiTorai() {
        return celTainoSetsumeiMiTorai;
    }

    @JsonProperty("celTainoSetsumeiMiTorai")
    private void setCelTainoSetsumeiMiTorai(celTainoSetsumeiMiToraiAttblComment celTainoSetsumeiMiTorai) {
        this.celTainoSetsumeiMiTorai=celTainoSetsumeiMiTorai;
    }

    @JsonProperty("celTainocolorTorai")
    private celTainocolorToraiAttblComment getCelTainocolorTorai() {
        return celTainocolorTorai;
    }

    @JsonProperty("celTainocolorTorai")
    private void setCelTainocolorTorai(celTainocolorToraiAttblComment celTainocolorTorai) {
        this.celTainocolorTorai=celTainocolorTorai;
    }

    @JsonProperty("celTainoSetsumeiTorai")
    private celTainoSetsumeiToraiAttblComment getCelTainoSetsumeiTorai() {
        return celTainoSetsumeiTorai;
    }

    @JsonProperty("celTainoSetsumeiTorai")
    private void setCelTainoSetsumeiTorai(celTainoSetsumeiToraiAttblComment celTainoSetsumeiTorai) {
        this.celTainoSetsumeiTorai=celTainoSetsumeiTorai;
    }

    @JsonProperty("celTainocolorTaishoGai")
    private celTainocolorTaishoGaiAttblComment getCelTainocolorTaishoGai() {
        return celTainocolorTaishoGai;
    }

    @JsonProperty("celTainocolorTaishoGai")
    private void setCelTainocolorTaishoGai(celTainocolorTaishoGaiAttblComment celTainocolorTaishoGai) {
        this.celTainocolorTaishoGai=celTainocolorTaishoGai;
    }

    @JsonProperty("celTainoSetsumeiTaishoGai")
    private celTainoSetsumeiTaishoGaiAttblComment getCelTainoSetsumeiTaishoGai() {
        return celTainoSetsumeiTaishoGai;
    }

    @JsonProperty("celTainoSetsumeiTaishoGai")
    private void setCelTainoSetsumeiTaishoGai(celTainoSetsumeiTaishoGaiAttblComment celTainoSetsumeiTaishoGai) {
        this.celTainoSetsumeiTaishoGai=celTainoSetsumeiTaishoGai;
    }

    @JsonProperty("celTainocolorKano")
    private celTainocolorKanoAttblComment getCelTainocolorKano() {
        return celTainocolorKano;
    }

    @JsonProperty("celTainocolorKano")
    private void setCelTainocolorKano(celTainocolorKanoAttblComment celTainocolorKano) {
        this.celTainocolorKano=celTainocolorKano;
    }

    @JsonProperty("celTainoSetsumeiKano")
    private celTainoSetsumeiKanoAttblComment getCelTainoSetsumeiKano() {
        return celTainoSetsumeiKano;
    }

    @JsonProperty("celTainoSetsumeiKano")
    private void setCelTainoSetsumeiKano(celTainoSetsumeiKanoAttblComment celTainoSetsumeiKano) {
        this.celTainoSetsumeiKano=celTainoSetsumeiKano;
    }

}
/**
 * celTainocolorKanno のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainocolorKannoAttblComment extends TableCell {
    @JsonProperty("TainocolorKanno")
    private TainocolorKannoDiv TainocolorKanno;

    @JsonProperty("TainocolorKanno")
    public TainocolorKannoDiv getTainocolorKanno() {
        return TainocolorKanno;
    }

    @JsonProperty("TainocolorKanno")
    public void setTainocolorKanno(TainocolorKannoDiv TainocolorKanno) {
        this.TainocolorKanno=TainocolorKanno;
    }

}
/**
 * celTainoSetsumeiKanno のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumeiKannoAttblComment extends TableCell {
    @JsonProperty("lblTainoSetsumeiKanno")
    private Label lblTainoSetsumeiKanno;

    @JsonProperty("lblTainoSetsumeiKanno")
    public Label getLblTainoSetsumeiKanno() {
        return lblTainoSetsumeiKanno;
    }

    @JsonProperty("lblTainoSetsumeiKanno")
    public void setLblTainoSetsumeiKanno(Label lblTainoSetsumeiKanno) {
        this.lblTainoSetsumeiKanno=lblTainoSetsumeiKanno;
    }

}
/**
 * celTainocolorMitorai のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainocolorMitoraiAttblComment extends TableCell {
    @JsonProperty("TainocolorMitorai")
    private TainocolorMitoraiDiv TainocolorMitorai;

    @JsonProperty("TainocolorMitorai")
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return TainocolorMitorai;
    }

    @JsonProperty("TainocolorMitorai")
    public void setTainocolorMitorai(TainocolorMitoraiDiv TainocolorMitorai) {
        this.TainocolorMitorai=TainocolorMitorai;
    }

}
/**
 * celTainoSetsumeiMiTorai のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumeiMiToraiAttblComment extends TableCell {
    @JsonProperty("lblTainoSetsumeiMiTorai")
    private Label lblTainoSetsumeiMiTorai;

    @JsonProperty("lblTainoSetsumeiMiTorai")
    public Label getLblTainoSetsumeiMiTorai() {
        return lblTainoSetsumeiMiTorai;
    }

    @JsonProperty("lblTainoSetsumeiMiTorai")
    public void setLblTainoSetsumeiMiTorai(Label lblTainoSetsumeiMiTorai) {
        this.lblTainoSetsumeiMiTorai=lblTainoSetsumeiMiTorai;
    }

}
/**
 * celTainocolorTorai のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainocolorToraiAttblComment extends TableCell {
    @JsonProperty("TainocolorTorai")
    private TainocolorToraiDiv TainocolorTorai;

    @JsonProperty("TainocolorTorai")
    public TainocolorToraiDiv getTainocolorTorai() {
        return TainocolorTorai;
    }

    @JsonProperty("TainocolorTorai")
    public void setTainocolorTorai(TainocolorToraiDiv TainocolorTorai) {
        this.TainocolorTorai=TainocolorTorai;
    }

}
/**
 * celTainoSetsumeiTorai のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumeiToraiAttblComment extends TableCell {
    @JsonProperty("lblTainoSetsumeiTorai")
    private Label lblTainoSetsumeiTorai;

    @JsonProperty("lblTainoSetsumeiTorai")
    public Label getLblTainoSetsumeiTorai() {
        return lblTainoSetsumeiTorai;
    }

    @JsonProperty("lblTainoSetsumeiTorai")
    public void setLblTainoSetsumeiTorai(Label lblTainoSetsumeiTorai) {
        this.lblTainoSetsumeiTorai=lblTainoSetsumeiTorai;
    }

}
/**
 * celTainocolorTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainocolorTaishoGaiAttblComment extends TableCell {
    @JsonProperty("TainocolorTaishoGai")
    private TainocolorTaishoGaiDiv TainocolorTaishoGai;

    @JsonProperty("TainocolorTaishoGai")
    public TainocolorTaishoGaiDiv getTainocolorTaishoGai() {
        return TainocolorTaishoGai;
    }

    @JsonProperty("TainocolorTaishoGai")
    public void setTainocolorTaishoGai(TainocolorTaishoGaiDiv TainocolorTaishoGai) {
        this.TainocolorTaishoGai=TainocolorTaishoGai;
    }

}
/**
 * celTainoSetsumeiTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumeiTaishoGaiAttblComment extends TableCell {
    @JsonProperty("lblTainoSetsumeiTaishoGai")
    private Label lblTainoSetsumeiTaishoGai;

    @JsonProperty("lblTainoSetsumeiTaishoGai")
    public Label getLblTainoSetsumeiTaishoGai() {
        return lblTainoSetsumeiTaishoGai;
    }

    @JsonProperty("lblTainoSetsumeiTaishoGai")
    public void setLblTainoSetsumeiTaishoGai(Label lblTainoSetsumeiTaishoGai) {
        this.lblTainoSetsumeiTaishoGai=lblTainoSetsumeiTaishoGai;
    }

}
/**
 * celTainocolorKano のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainocolorKanoAttblComment extends TableCell {
    @JsonProperty("TainocolorKano")
    private TainocolorKanoDiv TainocolorKano;

    @JsonProperty("TainocolorKano")
    public TainocolorKanoDiv getTainocolorKano() {
        return TainocolorKano;
    }

    @JsonProperty("TainocolorKano")
    public void setTainocolorKano(TainocolorKanoDiv TainocolorKano) {
        this.TainocolorKano=TainocolorKano;
    }

}
/**
 * celTainoSetsumeiKano のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumeiKanoAttblComment extends TableCell {
    @JsonProperty("lblTainoSetsumeiKano")
    private Label lblTainoSetsumeiKano;

    @JsonProperty("lblTainoSetsumeiKano")
    public Label getLblTainoSetsumeiKano() {
        return lblTainoSetsumeiKano;
    }

    @JsonProperty("lblTainoSetsumeiKano")
    public void setLblTainoSetsumeiKano(Label lblTainoSetsumeiKano) {
        this.lblTainoSetsumeiKano=lblTainoSetsumeiKano;
    }

}
