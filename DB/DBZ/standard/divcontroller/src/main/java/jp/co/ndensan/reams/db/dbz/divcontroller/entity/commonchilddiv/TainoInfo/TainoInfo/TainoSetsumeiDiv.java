package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TainoInfo.TainoInfo;
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
 * TainoSetsumei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoSetsumeiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTainoSetsumei1")
    private celTainoSetsumei1AtTainoSetsumei celTainoSetsumei1;
    @JsonProperty("celTainoSetsumei2")
    private celTainoSetsumei2AtTainoSetsumei celTainoSetsumei2;
    @JsonProperty("celTainoSetsumei3")
    private celTainoSetsumei3AtTainoSetsumei celTainoSetsumei3;
    @JsonProperty("celTainoSetsumei4")
    private celTainoSetsumei4AtTainoSetsumei celTainoSetsumei4;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TainocolorKannoDiv getTainocolorKanno() {
        return this.celTainoSetsumei1.getTainocolorKanno();
    }

    @JsonIgnore
    public TainocolorMinoDiv getTainocolorMino() {
        return this.celTainoSetsumei1.getTainocolorMino();
    }

    @JsonIgnore
    public Label getLblMassage1() {
        return this.celTainoSetsumei2.getLblMassage1();
    }

    @JsonIgnore
    public Label getLblMassage2() {
        return this.celTainoSetsumei2.getLblMassage2();
    }

    @JsonIgnore
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return this.celTainoSetsumei3.getTainocolorMitorai();
    }

    @JsonIgnore
    public TainocolorKanoDiv getTainocolorKano() {
        return this.celTainoSetsumei3.getTainocolorKano();
    }

    @JsonIgnore
    public Label getLblMassage3() {
        return this.celTainoSetsumei4.getLblMassage3();
    }

    @JsonIgnore
    public Label getLblMassage4() {
        return this.celTainoSetsumei4.getLblMassage4();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTainoSetsumei1
     * @return celTainoSetsumei1
     */
    @JsonProperty("celTainoSetsumei1")
    private celTainoSetsumei1AtTainoSetsumei getCelTainoSetsumei1() {
        return celTainoSetsumei1;
    }

    /*
     * setcelTainoSetsumei1
     * @param celTainoSetsumei1 celTainoSetsumei1
     */
    @JsonProperty("celTainoSetsumei1")
    private void setCelTainoSetsumei1(celTainoSetsumei1AtTainoSetsumei celTainoSetsumei1) {
        this.celTainoSetsumei1 = celTainoSetsumei1;
    }

    /*
     * getcelTainoSetsumei2
     * @return celTainoSetsumei2
     */
    @JsonProperty("celTainoSetsumei2")
    private celTainoSetsumei2AtTainoSetsumei getCelTainoSetsumei2() {
        return celTainoSetsumei2;
    }

    /*
     * setcelTainoSetsumei2
     * @param celTainoSetsumei2 celTainoSetsumei2
     */
    @JsonProperty("celTainoSetsumei2")
    private void setCelTainoSetsumei2(celTainoSetsumei2AtTainoSetsumei celTainoSetsumei2) {
        this.celTainoSetsumei2 = celTainoSetsumei2;
    }

    /*
     * getcelTainoSetsumei3
     * @return celTainoSetsumei3
     */
    @JsonProperty("celTainoSetsumei3")
    private celTainoSetsumei3AtTainoSetsumei getCelTainoSetsumei3() {
        return celTainoSetsumei3;
    }

    /*
     * setcelTainoSetsumei3
     * @param celTainoSetsumei3 celTainoSetsumei3
     */
    @JsonProperty("celTainoSetsumei3")
    private void setCelTainoSetsumei3(celTainoSetsumei3AtTainoSetsumei celTainoSetsumei3) {
        this.celTainoSetsumei3 = celTainoSetsumei3;
    }

    /*
     * getcelTainoSetsumei4
     * @return celTainoSetsumei4
     */
    @JsonProperty("celTainoSetsumei4")
    private celTainoSetsumei4AtTainoSetsumei getCelTainoSetsumei4() {
        return celTainoSetsumei4;
    }

    /*
     * setcelTainoSetsumei4
     * @param celTainoSetsumei4 celTainoSetsumei4
     */
    @JsonProperty("celTainoSetsumei4")
    private void setCelTainoSetsumei4(celTainoSetsumei4AtTainoSetsumei celTainoSetsumei4) {
        this.celTainoSetsumei4 = celTainoSetsumei4;
    }

    // </editor-fold>
}
/**
 * celTainoSetsumei1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumei1AtTainoSetsumei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    @JsonProperty("TainocolorKanno")
    private TainocolorKannoDiv TainocolorKanno;
    @JsonProperty("TainocolorMino")
    private TainocolorMinoDiv TainocolorMino;

    /*
     * getTainocolorKanno
     * @return TainocolorKanno
     */
    @JsonProperty("TainocolorKanno")
    public TainocolorKannoDiv getTainocolorKanno() {
        return TainocolorKanno;
    }

    /*
     * setTainocolorKanno
     * @param TainocolorKanno TainocolorKanno
     */
    @JsonProperty("TainocolorKanno")
    public void setTainocolorKanno(TainocolorKannoDiv TainocolorKanno) {
        this.TainocolorKanno = TainocolorKanno;
    }

    /*
     * getTainocolorMino
     * @return TainocolorMino
     */
    @JsonProperty("TainocolorMino")
    public TainocolorMinoDiv getTainocolorMino() {
        return TainocolorMino;
    }

    /*
     * setTainocolorMino
     * @param TainocolorMino TainocolorMino
     */
    @JsonProperty("TainocolorMino")
    public void setTainocolorMino(TainocolorMinoDiv TainocolorMino) {
        this.TainocolorMino = TainocolorMino;
    }

    // </editor-fold>
}
/**
 * celTainoSetsumei2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumei2AtTainoSetsumei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    @JsonProperty("lblMassage1")
    private Label lblMassage1;
    @JsonProperty("lblMassage2")
    private Label lblMassage2;

    /*
     * getlblMassage1
     * @return lblMassage1
     */
    @JsonProperty("lblMassage1")
    public Label getLblMassage1() {
        return lblMassage1;
    }

    /*
     * setlblMassage1
     * @param lblMassage1 lblMassage1
     */
    @JsonProperty("lblMassage1")
    public void setLblMassage1(Label lblMassage1) {
        this.lblMassage1 = lblMassage1;
    }

    /*
     * getlblMassage2
     * @return lblMassage2
     */
    @JsonProperty("lblMassage2")
    public Label getLblMassage2() {
        return lblMassage2;
    }

    /*
     * setlblMassage2
     * @param lblMassage2 lblMassage2
     */
    @JsonProperty("lblMassage2")
    public void setLblMassage2(Label lblMassage2) {
        this.lblMassage2 = lblMassage2;
    }

    // </editor-fold>
}
/**
 * celTainoSetsumei3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumei3AtTainoSetsumei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    @JsonProperty("TainocolorMitorai")
    private TainocolorMitoraiDiv TainocolorMitorai;
    @JsonProperty("TainocolorKano")
    private TainocolorKanoDiv TainocolorKano;

    /*
     * getTainocolorMitorai
     * @return TainocolorMitorai
     */
    @JsonProperty("TainocolorMitorai")
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return TainocolorMitorai;
    }

    /*
     * setTainocolorMitorai
     * @param TainocolorMitorai TainocolorMitorai
     */
    @JsonProperty("TainocolorMitorai")
    public void setTainocolorMitorai(TainocolorMitoraiDiv TainocolorMitorai) {
        this.TainocolorMitorai = TainocolorMitorai;
    }

    /*
     * getTainocolorKano
     * @return TainocolorKano
     */
    @JsonProperty("TainocolorKano")
    public TainocolorKanoDiv getTainocolorKano() {
        return TainocolorKano;
    }

    /*
     * setTainocolorKano
     * @param TainocolorKano TainocolorKano
     */
    @JsonProperty("TainocolorKano")
    public void setTainocolorKano(TainocolorKanoDiv TainocolorKano) {
        this.TainocolorKano = TainocolorKano;
    }

    // </editor-fold>
}
/**
 * celTainoSetsumei4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTainoSetsumei4AtTainoSetsumei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    @JsonProperty("lblMassage3")
    private Label lblMassage3;
    @JsonProperty("lblMassage4")
    private Label lblMassage4;

    /*
     * getlblMassage3
     * @return lblMassage3
     */
    @JsonProperty("lblMassage3")
    public Label getLblMassage3() {
        return lblMassage3;
    }

    /*
     * setlblMassage3
     * @param lblMassage3 lblMassage3
     */
    @JsonProperty("lblMassage3")
    public void setLblMassage3(Label lblMassage3) {
        this.lblMassage3 = lblMassage3;
    }

    /*
     * getlblMassage4
     * @return lblMassage4
     */
    @JsonProperty("lblMassage4")
    public Label getLblMassage4() {
        return lblMassage4;
    }

    /*
     * setlblMassage4
     * @param lblMassage4 lblMassage4
     */
    @JsonProperty("lblMassage4")
    public void setLblMassage4(Label lblMassage4) {
        this.lblMassage4 = lblMassage4;
    }

    // </editor-fold>
}
