package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0710011;
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
 * tblChushutsuJyoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChushutsuJyokenDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChokin")
    private celChokinAttblChushutsuJyoken celChokin;
    @JsonProperty("celKuhaku1")
    private celKuhaku1AttblChushutsuJyoken celKuhaku1;
    @JsonProperty("celKuhaku2")
    private celKuhaku2AttblChushutsuJyoken celKuhaku2;
    @JsonProperty("celKijyunbi")
    private celKijyunbiAttblChushutsuJyoken celKijyunbi;
    @JsonProperty("celKijunYMD")
    private celKijunYMDAttblChushutsuJyoken celKijunYMD;
    @JsonProperty("celKuhaku3")
    private celKuhaku3AttblChushutsuJyoken celKuhaku3;
    @JsonProperty("celHani")
    private celHaniAttblChushutsuJyoken celHani;
    @JsonProperty("celKonkaiKaishibi")
    private celKonkaiKaishibiAttblChushutsuJyoken celKonkaiKaishibi;
    @JsonProperty("celKonkaiShuryobi")
    private celKonkaiShuryobiAttblChushutsuJyoken celKonkaiShuryobi;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public RadioButton getRadChokin() {
        return this.celChokin.getRadChokin();
    }

    @JsonIgnore
    public Space getSpcChokin() {
        return this.celChokin.getSpcChokin();
    }

    @JsonIgnore
    public RadioButton getRadKijyunbi() {
        return this.celKijyunbi.getRadKijyunbi();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return this.celKijunYMD.getTxtKijunYMD();
    }

    @JsonIgnore
    public Space getSpcHani() {
        return this.celHani.getSpcHani();
    }

    @JsonIgnore
    public RadioButton getRadHani() {
        return this.celHani.getRadHani();
    }

    @JsonIgnore
    public Label getLblKaishibi() {
        return this.celKonkaiKaishibi.getLblKaishibi();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiKaishibi() {
        return this.celKonkaiKaishibi.getTxtKonkaiKaishibi();
    }

    @JsonIgnore
    public Label getLblShuryobi() {
        return this.celKonkaiShuryobi.getLblShuryobi();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiShuryobi() {
        return this.celKonkaiShuryobi.getTxtKonkaiShuryobi();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelChokin
     * @return celChokin
     */
    @JsonProperty("celChokin")
    private celChokinAttblChushutsuJyoken getCelChokin() {
        return celChokin;
    }

    /*
     * setcelChokin
     * @param celChokin celChokin
     */
    @JsonProperty("celChokin")
    private void setCelChokin(celChokinAttblChushutsuJyoken celChokin) {
        this.celChokin = celChokin;
    }

    /*
     * getcelKuhaku1
     * @return celKuhaku1
     */
    @JsonProperty("celKuhaku1")
    private celKuhaku1AttblChushutsuJyoken getCelKuhaku1() {
        return celKuhaku1;
    }

    /*
     * setcelKuhaku1
     * @param celKuhaku1 celKuhaku1
     */
    @JsonProperty("celKuhaku1")
    private void setCelKuhaku1(celKuhaku1AttblChushutsuJyoken celKuhaku1) {
        this.celKuhaku1 = celKuhaku1;
    }

    /*
     * getcelKuhaku2
     * @return celKuhaku2
     */
    @JsonProperty("celKuhaku2")
    private celKuhaku2AttblChushutsuJyoken getCelKuhaku2() {
        return celKuhaku2;
    }

    /*
     * setcelKuhaku2
     * @param celKuhaku2 celKuhaku2
     */
    @JsonProperty("celKuhaku2")
    private void setCelKuhaku2(celKuhaku2AttblChushutsuJyoken celKuhaku2) {
        this.celKuhaku2 = celKuhaku2;
    }

    /*
     * getcelKijyunbi
     * @return celKijyunbi
     */
    @JsonProperty("celKijyunbi")
    private celKijyunbiAttblChushutsuJyoken getCelKijyunbi() {
        return celKijyunbi;
    }

    /*
     * setcelKijyunbi
     * @param celKijyunbi celKijyunbi
     */
    @JsonProperty("celKijyunbi")
    private void setCelKijyunbi(celKijyunbiAttblChushutsuJyoken celKijyunbi) {
        this.celKijyunbi = celKijyunbi;
    }

    /*
     * getcelKijunYMD
     * @return celKijunYMD
     */
    @JsonProperty("celKijunYMD")
    private celKijunYMDAttblChushutsuJyoken getCelKijunYMD() {
        return celKijunYMD;
    }

    /*
     * setcelKijunYMD
     * @param celKijunYMD celKijunYMD
     */
    @JsonProperty("celKijunYMD")
    private void setCelKijunYMD(celKijunYMDAttblChushutsuJyoken celKijunYMD) {
        this.celKijunYMD = celKijunYMD;
    }

    /*
     * getcelKuhaku3
     * @return celKuhaku3
     */
    @JsonProperty("celKuhaku3")
    private celKuhaku3AttblChushutsuJyoken getCelKuhaku3() {
        return celKuhaku3;
    }

    /*
     * setcelKuhaku3
     * @param celKuhaku3 celKuhaku3
     */
    @JsonProperty("celKuhaku3")
    private void setCelKuhaku3(celKuhaku3AttblChushutsuJyoken celKuhaku3) {
        this.celKuhaku3 = celKuhaku3;
    }

    /*
     * getcelHani
     * @return celHani
     */
    @JsonProperty("celHani")
    private celHaniAttblChushutsuJyoken getCelHani() {
        return celHani;
    }

    /*
     * setcelHani
     * @param celHani celHani
     */
    @JsonProperty("celHani")
    private void setCelHani(celHaniAttblChushutsuJyoken celHani) {
        this.celHani = celHani;
    }

    /*
     * getcelKonkaiKaishibi
     * @return celKonkaiKaishibi
     */
    @JsonProperty("celKonkaiKaishibi")
    private celKonkaiKaishibiAttblChushutsuJyoken getCelKonkaiKaishibi() {
        return celKonkaiKaishibi;
    }

    /*
     * setcelKonkaiKaishibi
     * @param celKonkaiKaishibi celKonkaiKaishibi
     */
    @JsonProperty("celKonkaiKaishibi")
    private void setCelKonkaiKaishibi(celKonkaiKaishibiAttblChushutsuJyoken celKonkaiKaishibi) {
        this.celKonkaiKaishibi = celKonkaiKaishibi;
    }

    /*
     * getcelKonkaiShuryobi
     * @return celKonkaiShuryobi
     */
    @JsonProperty("celKonkaiShuryobi")
    private celKonkaiShuryobiAttblChushutsuJyoken getCelKonkaiShuryobi() {
        return celKonkaiShuryobi;
    }

    /*
     * setcelKonkaiShuryobi
     * @param celKonkaiShuryobi celKonkaiShuryobi
     */
    @JsonProperty("celKonkaiShuryobi")
    private void setCelKonkaiShuryobi(celKonkaiShuryobiAttblChushutsuJyoken celKonkaiShuryobi) {
        this.celKonkaiShuryobi = celKonkaiShuryobi;
    }

    // </editor-fold>
}
/**
 * celChokin のクラスファイル 
 * 
 * @author 自動生成
 */
class celChokinAttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("radChokin")
    private RadioButton radChokin;
    @JsonProperty("spcChokin")
    private Space spcChokin;

    /*
     * getradChokin
     * @return radChokin
     */
    @JsonProperty("radChokin")
    public RadioButton getRadChokin() {
        return radChokin;
    }

    /*
     * setradChokin
     * @param radChokin radChokin
     */
    @JsonProperty("radChokin")
    public void setRadChokin(RadioButton radChokin) {
        this.radChokin = radChokin;
    }

    /*
     * getspcChokin
     * @return spcChokin
     */
    @JsonProperty("spcChokin")
    public Space getSpcChokin() {
        return spcChokin;
    }

    /*
     * setspcChokin
     * @param spcChokin spcChokin
     */
    @JsonProperty("spcChokin")
    public void setSpcChokin(Space spcChokin) {
        this.spcChokin = spcChokin;
    }

    // </editor-fold>
}
/**
 * celKuhaku1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKuhaku1AttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celKuhaku2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKuhaku2AttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celKijyunbi のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijyunbiAttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("radKijyunbi")
    private RadioButton radKijyunbi;

    /*
     * getradKijyunbi
     * @return radKijyunbi
     */
    @JsonProperty("radKijyunbi")
    public RadioButton getRadKijyunbi() {
        return radKijyunbi;
    }

    /*
     * setradKijyunbi
     * @param radKijyunbi radKijyunbi
     */
    @JsonProperty("radKijyunbi")
    public void setRadKijyunbi(RadioButton radKijyunbi) {
        this.radKijyunbi = radKijyunbi;
    }

    // </editor-fold>
}
/**
 * celKijunYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijunYMDAttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    // </editor-fold>
}
/**
 * celKuhaku3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKuhaku3AttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celHani のクラスファイル 
 * 
 * @author 自動生成
 */
class celHaniAttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("spcHani")
    private Space spcHani;
    @JsonProperty("radHani")
    private RadioButton radHani;

    /*
     * getspcHani
     * @return spcHani
     */
    @JsonProperty("spcHani")
    public Space getSpcHani() {
        return spcHani;
    }

    /*
     * setspcHani
     * @param spcHani spcHani
     */
    @JsonProperty("spcHani")
    public void setSpcHani(Space spcHani) {
        this.spcHani = spcHani;
    }

    /*
     * getradHani
     * @return radHani
     */
    @JsonProperty("radHani")
    public RadioButton getRadHani() {
        return radHani;
    }

    /*
     * setradHani
     * @param radHani radHani
     */
    @JsonProperty("radHani")
    public void setRadHani(RadioButton radHani) {
        this.radHani = radHani;
    }

    // </editor-fold>
}
/**
 * celKonkaiKaishibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiKaishibiAttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblKaishibi")
    private Label lblKaishibi;
    @JsonProperty("txtKonkaiKaishibi")
    private TextBoxFlexibleDate txtKonkaiKaishibi;

    /*
     * getlblKaishibi
     * @return lblKaishibi
     */
    @JsonProperty("lblKaishibi")
    public Label getLblKaishibi() {
        return lblKaishibi;
    }

    /*
     * setlblKaishibi
     * @param lblKaishibi lblKaishibi
     */
    @JsonProperty("lblKaishibi")
    public void setLblKaishibi(Label lblKaishibi) {
        this.lblKaishibi = lblKaishibi;
    }

    /*
     * gettxtKonkaiKaishibi
     * @return txtKonkaiKaishibi
     */
    @JsonProperty("txtKonkaiKaishibi")
    public TextBoxFlexibleDate getTxtKonkaiKaishibi() {
        return txtKonkaiKaishibi;
    }

    /*
     * settxtKonkaiKaishibi
     * @param txtKonkaiKaishibi txtKonkaiKaishibi
     */
    @JsonProperty("txtKonkaiKaishibi")
    public void setTxtKonkaiKaishibi(TextBoxFlexibleDate txtKonkaiKaishibi) {
        this.txtKonkaiKaishibi = txtKonkaiKaishibi;
    }

    // </editor-fold>
}
/**
 * celKonkaiShuryobi のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiShuryobiAttblChushutsuJyoken extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblShuryobi")
    private Label lblShuryobi;
    @JsonProperty("txtKonkaiShuryobi")
    private TextBoxFlexibleDate txtKonkaiShuryobi;

    /*
     * getlblShuryobi
     * @return lblShuryobi
     */
    @JsonProperty("lblShuryobi")
    public Label getLblShuryobi() {
        return lblShuryobi;
    }

    /*
     * setlblShuryobi
     * @param lblShuryobi lblShuryobi
     */
    @JsonProperty("lblShuryobi")
    public void setLblShuryobi(Label lblShuryobi) {
        this.lblShuryobi = lblShuryobi;
    }

    /*
     * gettxtKonkaiShuryobi
     * @return txtKonkaiShuryobi
     */
    @JsonProperty("txtKonkaiShuryobi")
    public TextBoxFlexibleDate getTxtKonkaiShuryobi() {
        return txtKonkaiShuryobi;
    }

    /*
     * settxtKonkaiShuryobi
     * @param txtKonkaiShuryobi txtKonkaiShuryobi
     */
    @JsonProperty("txtKonkaiShuryobi")
    public void setTxtKonkaiShuryobi(TextBoxFlexibleDate txtKonkaiShuryobi) {
        this.txtKonkaiShuryobi = txtKonkaiShuryobi;
    }

    // </editor-fold>
}
