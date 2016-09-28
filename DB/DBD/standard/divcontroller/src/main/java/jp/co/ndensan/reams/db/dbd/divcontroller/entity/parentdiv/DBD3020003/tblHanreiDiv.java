package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
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
 * tblHanrei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblHanreiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celHanreiColorKanno")
    private celHanreiColorKannoAttblHanrei celHanreiColorKanno;
    @JsonProperty("celKanno")
    private celKannoAttblHanrei celKanno;
    @JsonProperty("celHanreiColorMino")
    private celHanreiColorMinoAttblHanrei celHanreiColorMino;
    @JsonProperty("celMino")
    private celMinoAttblHanrei celMino;
    @JsonProperty("celHanreiColorJiko")
    private celHanreiColorJikoAttblHanrei celHanreiColorJiko;
    @JsonProperty("celJiko")
    private celJikoAttblHanrei celJiko;
    @JsonProperty("celHanreiColorKano")
    private celHanreiColorKanoAttblHanrei celHanreiColorKano;
    @JsonProperty("celKano")
    private celKanoAttblHanrei celKano;
    @JsonProperty("celHanreiColorJikoTaishoGai")
    private celHanreiColorJikoTaishoGaiAttblHanrei celHanreiColorJikoTaishoGai;
    @JsonProperty("celJikoTaishoGai")
    private celJikoTaishoGaiAttblHanrei celJikoTaishoGai;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public tblColorKannoDiv getTblColorKanno() {
        return this.celHanreiColorKanno.getTblColorKanno();
    }

    @JsonIgnore
    public Label getLblKanno() {
        return this.celKanno.getLblKanno();
    }

    @JsonIgnore
    public tblColorMinoDiv getTblColorMino() {
        return this.celHanreiColorMino.getTblColorMino();
    }

    @JsonIgnore
    public Label getLblMino() {
        return this.celMino.getLblMino();
    }

    @JsonIgnore
    public tblColorJikoDiv getTblColorJiko() {
        return this.celHanreiColorJiko.getTblColorJiko();
    }

    @JsonIgnore
    public Label getLblJiko() {
        return this.celJiko.getLblJiko();
    }

    @JsonIgnore
    public tblColorKanoDiv getTblColorKano() {
        return this.celHanreiColorKano.getTblColorKano();
    }

    @JsonIgnore
    public Label getLblKano() {
        return this.celKano.getLblKano();
    }

    @JsonIgnore
    public tblColorJikoTaishoGaiDiv getTblColorJikoTaishoGai() {
        return this.celHanreiColorJikoTaishoGai.getTblColorJikoTaishoGai();
    }

    @JsonIgnore
    public Label getLblJikoTaishoGai() {
        return this.celJikoTaishoGai.getLblJikoTaishoGai();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelHanreiColorKanno
     * @return celHanreiColorKanno
     */
    @JsonProperty("celHanreiColorKanno")
    private celHanreiColorKannoAttblHanrei getCelHanreiColorKanno() {
        return celHanreiColorKanno;
    }

    /*
     * setcelHanreiColorKanno
     * @param celHanreiColorKanno celHanreiColorKanno
     */
    @JsonProperty("celHanreiColorKanno")
    private void setCelHanreiColorKanno(celHanreiColorKannoAttblHanrei celHanreiColorKanno) {
        this.celHanreiColorKanno = celHanreiColorKanno;
    }

    /*
     * getcelKanno
     * @return celKanno
     */
    @JsonProperty("celKanno")
    private celKannoAttblHanrei getCelKanno() {
        return celKanno;
    }

    /*
     * setcelKanno
     * @param celKanno celKanno
     */
    @JsonProperty("celKanno")
    private void setCelKanno(celKannoAttblHanrei celKanno) {
        this.celKanno = celKanno;
    }

    /*
     * getcelHanreiColorMino
     * @return celHanreiColorMino
     */
    @JsonProperty("celHanreiColorMino")
    private celHanreiColorMinoAttblHanrei getCelHanreiColorMino() {
        return celHanreiColorMino;
    }

    /*
     * setcelHanreiColorMino
     * @param celHanreiColorMino celHanreiColorMino
     */
    @JsonProperty("celHanreiColorMino")
    private void setCelHanreiColorMino(celHanreiColorMinoAttblHanrei celHanreiColorMino) {
        this.celHanreiColorMino = celHanreiColorMino;
    }

    /*
     * getcelMino
     * @return celMino
     */
    @JsonProperty("celMino")
    private celMinoAttblHanrei getCelMino() {
        return celMino;
    }

    /*
     * setcelMino
     * @param celMino celMino
     */
    @JsonProperty("celMino")
    private void setCelMino(celMinoAttblHanrei celMino) {
        this.celMino = celMino;
    }

    /*
     * getcelHanreiColorJiko
     * @return celHanreiColorJiko
     */
    @JsonProperty("celHanreiColorJiko")
    private celHanreiColorJikoAttblHanrei getCelHanreiColorJiko() {
        return celHanreiColorJiko;
    }

    /*
     * setcelHanreiColorJiko
     * @param celHanreiColorJiko celHanreiColorJiko
     */
    @JsonProperty("celHanreiColorJiko")
    private void setCelHanreiColorJiko(celHanreiColorJikoAttblHanrei celHanreiColorJiko) {
        this.celHanreiColorJiko = celHanreiColorJiko;
    }

    /*
     * getcelJiko
     * @return celJiko
     */
    @JsonProperty("celJiko")
    private celJikoAttblHanrei getCelJiko() {
        return celJiko;
    }

    /*
     * setcelJiko
     * @param celJiko celJiko
     */
    @JsonProperty("celJiko")
    private void setCelJiko(celJikoAttblHanrei celJiko) {
        this.celJiko = celJiko;
    }

    /*
     * getcelHanreiColorKano
     * @return celHanreiColorKano
     */
    @JsonProperty("celHanreiColorKano")
    private celHanreiColorKanoAttblHanrei getCelHanreiColorKano() {
        return celHanreiColorKano;
    }

    /*
     * setcelHanreiColorKano
     * @param celHanreiColorKano celHanreiColorKano
     */
    @JsonProperty("celHanreiColorKano")
    private void setCelHanreiColorKano(celHanreiColorKanoAttblHanrei celHanreiColorKano) {
        this.celHanreiColorKano = celHanreiColorKano;
    }

    /*
     * getcelKano
     * @return celKano
     */
    @JsonProperty("celKano")
    private celKanoAttblHanrei getCelKano() {
        return celKano;
    }

    /*
     * setcelKano
     * @param celKano celKano
     */
    @JsonProperty("celKano")
    private void setCelKano(celKanoAttblHanrei celKano) {
        this.celKano = celKano;
    }

    /*
     * getcelHanreiColorJikoTaishoGai
     * @return celHanreiColorJikoTaishoGai
     */
    @JsonProperty("celHanreiColorJikoTaishoGai")
    private celHanreiColorJikoTaishoGaiAttblHanrei getCelHanreiColorJikoTaishoGai() {
        return celHanreiColorJikoTaishoGai;
    }

    /*
     * setcelHanreiColorJikoTaishoGai
     * @param celHanreiColorJikoTaishoGai celHanreiColorJikoTaishoGai
     */
    @JsonProperty("celHanreiColorJikoTaishoGai")
    private void setCelHanreiColorJikoTaishoGai(celHanreiColorJikoTaishoGaiAttblHanrei celHanreiColorJikoTaishoGai) {
        this.celHanreiColorJikoTaishoGai = celHanreiColorJikoTaishoGai;
    }

    /*
     * getcelJikoTaishoGai
     * @return celJikoTaishoGai
     */
    @JsonProperty("celJikoTaishoGai")
    private celJikoTaishoGaiAttblHanrei getCelJikoTaishoGai() {
        return celJikoTaishoGai;
    }

    /*
     * setcelJikoTaishoGai
     * @param celJikoTaishoGai celJikoTaishoGai
     */
    @JsonProperty("celJikoTaishoGai")
    private void setCelJikoTaishoGai(celJikoTaishoGaiAttblHanrei celJikoTaishoGai) {
        this.celJikoTaishoGai = celJikoTaishoGai;
    }

    // </editor-fold>
}
/**
 * celHanreiColorKanno のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanreiColorKannoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblColorKanno")
    private tblColorKannoDiv tblColorKanno;

    /*
     * gettblColorKanno
     * @return tblColorKanno
     */
    @JsonProperty("tblColorKanno")
    public tblColorKannoDiv getTblColorKanno() {
        return tblColorKanno;
    }

    /*
     * settblColorKanno
     * @param tblColorKanno tblColorKanno
     */
    @JsonProperty("tblColorKanno")
    public void setTblColorKanno(tblColorKannoDiv tblColorKanno) {
        this.tblColorKanno = tblColorKanno;
    }

    // </editor-fold>
}
/**
 * celKanno のクラスファイル 
 * 
 * @author 自動生成
 */
class celKannoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKanno")
    private Label lblKanno;

    /*
     * getlblKanno
     * @return lblKanno
     */
    @JsonProperty("lblKanno")
    public Label getLblKanno() {
        return lblKanno;
    }

    /*
     * setlblKanno
     * @param lblKanno lblKanno
     */
    @JsonProperty("lblKanno")
    public void setLblKanno(Label lblKanno) {
        this.lblKanno = lblKanno;
    }

    // </editor-fold>
}
/**
 * celHanreiColorMino のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanreiColorMinoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblColorMino")
    private tblColorMinoDiv tblColorMino;

    /*
     * gettblColorMino
     * @return tblColorMino
     */
    @JsonProperty("tblColorMino")
    public tblColorMinoDiv getTblColorMino() {
        return tblColorMino;
    }

    /*
     * settblColorMino
     * @param tblColorMino tblColorMino
     */
    @JsonProperty("tblColorMino")
    public void setTblColorMino(tblColorMinoDiv tblColorMino) {
        this.tblColorMino = tblColorMino;
    }

    // </editor-fold>
}
/**
 * celMino のクラスファイル 
 * 
 * @author 自動生成
 */
class celMinoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblMino")
    private Label lblMino;

    /*
     * getlblMino
     * @return lblMino
     */
    @JsonProperty("lblMino")
    public Label getLblMino() {
        return lblMino;
    }

    /*
     * setlblMino
     * @param lblMino lblMino
     */
    @JsonProperty("lblMino")
    public void setLblMino(Label lblMino) {
        this.lblMino = lblMino;
    }

    // </editor-fold>
}
/**
 * celHanreiColorJiko のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanreiColorJikoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblColorJiko")
    private tblColorJikoDiv tblColorJiko;

    /*
     * gettblColorJiko
     * @return tblColorJiko
     */
    @JsonProperty("tblColorJiko")
    public tblColorJikoDiv getTblColorJiko() {
        return tblColorJiko;
    }

    /*
     * settblColorJiko
     * @param tblColorJiko tblColorJiko
     */
    @JsonProperty("tblColorJiko")
    public void setTblColorJiko(tblColorJikoDiv tblColorJiko) {
        this.tblColorJiko = tblColorJiko;
    }

    // </editor-fold>
}
/**
 * celJiko のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblJiko")
    private Label lblJiko;

    /*
     * getlblJiko
     * @return lblJiko
     */
    @JsonProperty("lblJiko")
    public Label getLblJiko() {
        return lblJiko;
    }

    /*
     * setlblJiko
     * @param lblJiko lblJiko
     */
    @JsonProperty("lblJiko")
    public void setLblJiko(Label lblJiko) {
        this.lblJiko = lblJiko;
    }

    // </editor-fold>
}
/**
 * celHanreiColorKano のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanreiColorKanoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblColorKano")
    private tblColorKanoDiv tblColorKano;

    /*
     * gettblColorKano
     * @return tblColorKano
     */
    @JsonProperty("tblColorKano")
    public tblColorKanoDiv getTblColorKano() {
        return tblColorKano;
    }

    /*
     * settblColorKano
     * @param tblColorKano tblColorKano
     */
    @JsonProperty("tblColorKano")
    public void setTblColorKano(tblColorKanoDiv tblColorKano) {
        this.tblColorKano = tblColorKano;
    }

    // </editor-fold>
}
/**
 * celKano のクラスファイル 
 * 
 * @author 自動生成
 */
class celKanoAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKano")
    private Label lblKano;

    /*
     * getlblKano
     * @return lblKano
     */
    @JsonProperty("lblKano")
    public Label getLblKano() {
        return lblKano;
    }

    /*
     * setlblKano
     * @param lblKano lblKano
     */
    @JsonProperty("lblKano")
    public void setLblKano(Label lblKano) {
        this.lblKano = lblKano;
    }

    // </editor-fold>
}
/**
 * celHanreiColorJikoTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanreiColorJikoTaishoGaiAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblColorJikoTaishoGai")
    private tblColorJikoTaishoGaiDiv tblColorJikoTaishoGai;

    /*
     * gettblColorJikoTaishoGai
     * @return tblColorJikoTaishoGai
     */
    @JsonProperty("tblColorJikoTaishoGai")
    public tblColorJikoTaishoGaiDiv getTblColorJikoTaishoGai() {
        return tblColorJikoTaishoGai;
    }

    /*
     * settblColorJikoTaishoGai
     * @param tblColorJikoTaishoGai tblColorJikoTaishoGai
     */
    @JsonProperty("tblColorJikoTaishoGai")
    public void setTblColorJikoTaishoGai(tblColorJikoTaishoGaiDiv tblColorJikoTaishoGai) {
        this.tblColorJikoTaishoGai = tblColorJikoTaishoGai;
    }

    // </editor-fold>
}
/**
 * celJikoTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikoTaishoGaiAttblHanrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblJikoTaishoGai")
    private Label lblJikoTaishoGai;

    /*
     * getlblJikoTaishoGai
     * @return lblJikoTaishoGai
     */
    @JsonProperty("lblJikoTaishoGai")
    public Label getLblJikoTaishoGai() {
        return lblJikoTaishoGai;
    }

    /*
     * setlblJikoTaishoGai
     * @param lblJikoTaishoGai lblJikoTaishoGai
     */
    @JsonProperty("lblJikoTaishoGai")
    public void setLblJikoTaishoGai(Label lblJikoTaishoGai) {
        this.lblJikoTaishoGai = lblJikoTaishoGai;
    }

    // </editor-fold>
}
