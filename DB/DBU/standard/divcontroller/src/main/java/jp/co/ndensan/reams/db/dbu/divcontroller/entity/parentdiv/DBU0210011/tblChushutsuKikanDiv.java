package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011;
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
 * tblChushutsuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChushutsuKikanDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celNull1")
    private celNull1AttblChushutsuKikan celNull1;
    @JsonProperty("celStYMD")
    private celStYMDAttblChushutsuKikan celStYMD;
    @JsonProperty("celStTime")
    private celStTimeAttblChushutsuKikan celStTime;
    @JsonProperty("celEdYMD")
    private celEdYMDAttblChushutsuKikan celEdYMD;
    @JsonProperty("celEdTime")
    private celEdTimeAttblChushutsuKikan celEdTime;
    @JsonProperty("celZenken")
    private celZenkenAttblChushutsuKikan celZenken;
    @JsonProperty("celZenkaiChushutsu")
    private celZenkaiChushutsuAttblChushutsuKikan celZenkaiChushutsu;
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private celZenkaiChushutsuFromYMDAttblChushutsuKikan celZenkaiChushutsuFromYMD;
    @JsonProperty("celZenkaiChushutsuFromTime")
    private celZenkaiChushutsuFromTimeAttblChushutsuKikan celZenkaiChushutsuFromTime;
    @JsonProperty("celZenkaiChushutsuToYMD")
    private celZenkaiChushutsuToYMDAttblChushutsuKikan celZenkaiChushutsuToYMD;
    @JsonProperty("celZenkaiChushutsuToTime")
    private celZenkaiChushutsuToTimeAttblChushutsuKikan celZenkaiChushutsuToTime;
    @JsonProperty("celKonkaiChushutsu")
    private celKonkaiChushutsuAttblChushutsuKikan celKonkaiChushutsu;
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private celKonkaiChushutsuFromYMDAttblChushutsuKikan celKonkaiChushutsuFromYMD;
    @JsonProperty("celKonkaiChushutsuFromTime")
    private celKonkaiChushutsuFromTimeAttblChushutsuKikan celKonkaiChushutsuFromTime;
    @JsonProperty("celKonkaiChushutsuToYMD")
    private celKonkaiChushutsuToYMDAttblChushutsuKikan celKonkaiChushutsuToYMD;
    @JsonProperty("celKikanHenko")
    private celKikanHenkoAttblChushutsuKikan celKikanHenko;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblStYMD() {
        return this.celStYMD.getLblStYMD();
    }

    @JsonIgnore
    public Label getLblStTime() {
        return this.celStTime.getLblStTime();
    }

    @JsonIgnore
    public Label getLblEdYMD() {
        return this.celEdYMD.getLblEdYMD();
    }

    @JsonIgnore
    public Label getLblEdTime() {
        return this.celEdTime.getLblEdTime();
    }

    @JsonIgnore
    public ZenkenDiv getZenken() {
        return this.celZenken.getZenken();
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.celZenkaiChushutsu.getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.celZenkaiChushutsuFromYMD.getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.celZenkaiChushutsuFromTime.getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.celZenkaiChushutsuFromTime.getLblKara1();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.celZenkaiChushutsuToYMD.getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.celZenkaiChushutsuToTime.getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.celKonkaiChushutsu.getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.celKonkaiChushutsuFromYMD.getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.celKonkaiChushutsuFromTime.getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.celKonkaiChushutsuFromTime.getLblKara2();
    }

    @JsonIgnore
    public CheckBoxList getChkKikanHenko() {
        return this.celKikanHenko.getChkKikanHenko();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelNull1
     * @return celNull1
     */
    @JsonProperty("celNull1")
    private celNull1AttblChushutsuKikan getCelNull1() {
        return celNull1;
    }

    /*
     * setcelNull1
     * @param celNull1 celNull1
     */
    @JsonProperty("celNull1")
    private void setCelNull1(celNull1AttblChushutsuKikan celNull1) {
        this.celNull1 = celNull1;
    }

    /*
     * getcelStYMD
     * @return celStYMD
     */
    @JsonProperty("celStYMD")
    private celStYMDAttblChushutsuKikan getCelStYMD() {
        return celStYMD;
    }

    /*
     * setcelStYMD
     * @param celStYMD celStYMD
     */
    @JsonProperty("celStYMD")
    private void setCelStYMD(celStYMDAttblChushutsuKikan celStYMD) {
        this.celStYMD = celStYMD;
    }

    /*
     * getcelStTime
     * @return celStTime
     */
    @JsonProperty("celStTime")
    private celStTimeAttblChushutsuKikan getCelStTime() {
        return celStTime;
    }

    /*
     * setcelStTime
     * @param celStTime celStTime
     */
    @JsonProperty("celStTime")
    private void setCelStTime(celStTimeAttblChushutsuKikan celStTime) {
        this.celStTime = celStTime;
    }

    /*
     * getcelEdYMD
     * @return celEdYMD
     */
    @JsonProperty("celEdYMD")
    private celEdYMDAttblChushutsuKikan getCelEdYMD() {
        return celEdYMD;
    }

    /*
     * setcelEdYMD
     * @param celEdYMD celEdYMD
     */
    @JsonProperty("celEdYMD")
    private void setCelEdYMD(celEdYMDAttblChushutsuKikan celEdYMD) {
        this.celEdYMD = celEdYMD;
    }

    /*
     * getcelEdTime
     * @return celEdTime
     */
    @JsonProperty("celEdTime")
    private celEdTimeAttblChushutsuKikan getCelEdTime() {
        return celEdTime;
    }

    /*
     * setcelEdTime
     * @param celEdTime celEdTime
     */
    @JsonProperty("celEdTime")
    private void setCelEdTime(celEdTimeAttblChushutsuKikan celEdTime) {
        this.celEdTime = celEdTime;
    }

    /*
     * getcelZenken
     * @return celZenken
     */
    @JsonProperty("celZenken")
    private celZenkenAttblChushutsuKikan getCelZenken() {
        return celZenken;
    }

    /*
     * setcelZenken
     * @param celZenken celZenken
     */
    @JsonProperty("celZenken")
    private void setCelZenken(celZenkenAttblChushutsuKikan celZenken) {
        this.celZenken = celZenken;
    }

    /*
     * getcelZenkaiChushutsu
     * @return celZenkaiChushutsu
     */
    @JsonProperty("celZenkaiChushutsu")
    private celZenkaiChushutsuAttblChushutsuKikan getCelZenkaiChushutsu() {
        return celZenkaiChushutsu;
    }

    /*
     * setcelZenkaiChushutsu
     * @param celZenkaiChushutsu celZenkaiChushutsu
     */
    @JsonProperty("celZenkaiChushutsu")
    private void setCelZenkaiChushutsu(celZenkaiChushutsuAttblChushutsuKikan celZenkaiChushutsu) {
        this.celZenkaiChushutsu = celZenkaiChushutsu;
    }

    /*
     * getcelZenkaiChushutsuFromYMD
     * @return celZenkaiChushutsuFromYMD
     */
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private celZenkaiChushutsuFromYMDAttblChushutsuKikan getCelZenkaiChushutsuFromYMD() {
        return celZenkaiChushutsuFromYMD;
    }

    /*
     * setcelZenkaiChushutsuFromYMD
     * @param celZenkaiChushutsuFromYMD celZenkaiChushutsuFromYMD
     */
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private void setCelZenkaiChushutsuFromYMD(celZenkaiChushutsuFromYMDAttblChushutsuKikan celZenkaiChushutsuFromYMD) {
        this.celZenkaiChushutsuFromYMD = celZenkaiChushutsuFromYMD;
    }

    /*
     * getcelZenkaiChushutsuFromTime
     * @return celZenkaiChushutsuFromTime
     */
    @JsonProperty("celZenkaiChushutsuFromTime")
    private celZenkaiChushutsuFromTimeAttblChushutsuKikan getCelZenkaiChushutsuFromTime() {
        return celZenkaiChushutsuFromTime;
    }

    /*
     * setcelZenkaiChushutsuFromTime
     * @param celZenkaiChushutsuFromTime celZenkaiChushutsuFromTime
     */
    @JsonProperty("celZenkaiChushutsuFromTime")
    private void setCelZenkaiChushutsuFromTime(celZenkaiChushutsuFromTimeAttblChushutsuKikan celZenkaiChushutsuFromTime) {
        this.celZenkaiChushutsuFromTime = celZenkaiChushutsuFromTime;
    }

    /*
     * getcelZenkaiChushutsuToYMD
     * @return celZenkaiChushutsuToYMD
     */
    @JsonProperty("celZenkaiChushutsuToYMD")
    private celZenkaiChushutsuToYMDAttblChushutsuKikan getCelZenkaiChushutsuToYMD() {
        return celZenkaiChushutsuToYMD;
    }

    /*
     * setcelZenkaiChushutsuToYMD
     * @param celZenkaiChushutsuToYMD celZenkaiChushutsuToYMD
     */
    @JsonProperty("celZenkaiChushutsuToYMD")
    private void setCelZenkaiChushutsuToYMD(celZenkaiChushutsuToYMDAttblChushutsuKikan celZenkaiChushutsuToYMD) {
        this.celZenkaiChushutsuToYMD = celZenkaiChushutsuToYMD;
    }

    /*
     * getcelZenkaiChushutsuToTime
     * @return celZenkaiChushutsuToTime
     */
    @JsonProperty("celZenkaiChushutsuToTime")
    private celZenkaiChushutsuToTimeAttblChushutsuKikan getCelZenkaiChushutsuToTime() {
        return celZenkaiChushutsuToTime;
    }

    /*
     * setcelZenkaiChushutsuToTime
     * @param celZenkaiChushutsuToTime celZenkaiChushutsuToTime
     */
    @JsonProperty("celZenkaiChushutsuToTime")
    private void setCelZenkaiChushutsuToTime(celZenkaiChushutsuToTimeAttblChushutsuKikan celZenkaiChushutsuToTime) {
        this.celZenkaiChushutsuToTime = celZenkaiChushutsuToTime;
    }

    /*
     * getcelKonkaiChushutsu
     * @return celKonkaiChushutsu
     */
    @JsonProperty("celKonkaiChushutsu")
    private celKonkaiChushutsuAttblChushutsuKikan getCelKonkaiChushutsu() {
        return celKonkaiChushutsu;
    }

    /*
     * setcelKonkaiChushutsu
     * @param celKonkaiChushutsu celKonkaiChushutsu
     */
    @JsonProperty("celKonkaiChushutsu")
    private void setCelKonkaiChushutsu(celKonkaiChushutsuAttblChushutsuKikan celKonkaiChushutsu) {
        this.celKonkaiChushutsu = celKonkaiChushutsu;
    }

    /*
     * getcelKonkaiChushutsuFromYMD
     * @return celKonkaiChushutsuFromYMD
     */
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private celKonkaiChushutsuFromYMDAttblChushutsuKikan getCelKonkaiChushutsuFromYMD() {
        return celKonkaiChushutsuFromYMD;
    }

    /*
     * setcelKonkaiChushutsuFromYMD
     * @param celKonkaiChushutsuFromYMD celKonkaiChushutsuFromYMD
     */
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private void setCelKonkaiChushutsuFromYMD(celKonkaiChushutsuFromYMDAttblChushutsuKikan celKonkaiChushutsuFromYMD) {
        this.celKonkaiChushutsuFromYMD = celKonkaiChushutsuFromYMD;
    }

    /*
     * getcelKonkaiChushutsuFromTime
     * @return celKonkaiChushutsuFromTime
     */
    @JsonProperty("celKonkaiChushutsuFromTime")
    private celKonkaiChushutsuFromTimeAttblChushutsuKikan getCelKonkaiChushutsuFromTime() {
        return celKonkaiChushutsuFromTime;
    }

    /*
     * setcelKonkaiChushutsuFromTime
     * @param celKonkaiChushutsuFromTime celKonkaiChushutsuFromTime
     */
    @JsonProperty("celKonkaiChushutsuFromTime")
    private void setCelKonkaiChushutsuFromTime(celKonkaiChushutsuFromTimeAttblChushutsuKikan celKonkaiChushutsuFromTime) {
        this.celKonkaiChushutsuFromTime = celKonkaiChushutsuFromTime;
    }

    /*
     * getcelKonkaiChushutsuToYMD
     * @return celKonkaiChushutsuToYMD
     */
    @JsonProperty("celKonkaiChushutsuToYMD")
    private celKonkaiChushutsuToYMDAttblChushutsuKikan getCelKonkaiChushutsuToYMD() {
        return celKonkaiChushutsuToYMD;
    }

    /*
     * setcelKonkaiChushutsuToYMD
     * @param celKonkaiChushutsuToYMD celKonkaiChushutsuToYMD
     */
    @JsonProperty("celKonkaiChushutsuToYMD")
    private void setCelKonkaiChushutsuToYMD(celKonkaiChushutsuToYMDAttblChushutsuKikan celKonkaiChushutsuToYMD) {
        this.celKonkaiChushutsuToYMD = celKonkaiChushutsuToYMD;
    }

    /*
     * getcelKikanHenko
     * @return celKikanHenko
     */
    @JsonProperty("celKikanHenko")
    private celKikanHenkoAttblChushutsuKikan getCelKikanHenko() {
        return celKikanHenko;
    }

    /*
     * setcelKikanHenko
     * @param celKikanHenko celKikanHenko
     */
    @JsonProperty("celKikanHenko")
    private void setCelKikanHenko(celKikanHenkoAttblChushutsuKikan celKikanHenko) {
        this.celKikanHenko = celKikanHenko;
    }

    // </editor-fold>
}
/**
 * celNull1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull1AttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celStYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celStYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblStYMD")
    private Label lblStYMD;

    /*
     * getlblStYMD
     * @return lblStYMD
     */
    @JsonProperty("lblStYMD")
    public Label getLblStYMD() {
        return lblStYMD;
    }

    /*
     * setlblStYMD
     * @param lblStYMD lblStYMD
     */
    @JsonProperty("lblStYMD")
    public void setLblStYMD(Label lblStYMD) {
        this.lblStYMD = lblStYMD;
    }

    // </editor-fold>
}
/**
 * celStTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celStTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblStTime")
    private Label lblStTime;

    /*
     * getlblStTime
     * @return lblStTime
     */
    @JsonProperty("lblStTime")
    public Label getLblStTime() {
        return lblStTime;
    }

    /*
     * setlblStTime
     * @param lblStTime lblStTime
     */
    @JsonProperty("lblStTime")
    public void setLblStTime(Label lblStTime) {
        this.lblStTime = lblStTime;
    }

    // </editor-fold>
}
/**
 * celEdYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celEdYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblEdYMD")
    private Label lblEdYMD;

    /*
     * getlblEdYMD
     * @return lblEdYMD
     */
    @JsonProperty("lblEdYMD")
    public Label getLblEdYMD() {
        return lblEdYMD;
    }

    /*
     * setlblEdYMD
     * @param lblEdYMD lblEdYMD
     */
    @JsonProperty("lblEdYMD")
    public void setLblEdYMD(Label lblEdYMD) {
        this.lblEdYMD = lblEdYMD;
    }

    // </editor-fold>
}
/**
 * celEdTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celEdTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblEdTime")
    private Label lblEdTime;

    /*
     * getlblEdTime
     * @return lblEdTime
     */
    @JsonProperty("lblEdTime")
    public Label getLblEdTime() {
        return lblEdTime;
    }

    /*
     * setlblEdTime
     * @param lblEdTime lblEdTime
     */
    @JsonProperty("lblEdTime")
    public void setLblEdTime(Label lblEdTime) {
        this.lblEdTime = lblEdTime;
    }

    // </editor-fold>
}
/**
 * celZenken のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkenAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("Zenken")
    private ZenkenDiv Zenken;

    /*
     * getZenken
     * @return Zenken
     */
    @JsonProperty("Zenken")
    public ZenkenDiv getZenken() {
        return Zenken;
    }

    /*
     * setZenken
     * @param Zenken Zenken
     */
    @JsonProperty("Zenken")
    public void setZenken(ZenkenDiv Zenken) {
        this.Zenken = Zenken;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblZenkaiChushutsu")
    private Label lblZenkaiChushutsu;

    /*
     * getlblZenkaiChushutsu
     * @return lblZenkaiChushutsu
     */
    @JsonProperty("lblZenkaiChushutsu")
    public Label getLblZenkaiChushutsu() {
        return lblZenkaiChushutsu;
    }

    /*
     * setlblZenkaiChushutsu
     * @param lblZenkaiChushutsu lblZenkaiChushutsu
     */
    @JsonProperty("lblZenkaiChushutsu")
    public void setLblZenkaiChushutsu(Label lblZenkaiChushutsu) {
        this.lblZenkaiChushutsu = lblZenkaiChushutsu;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuFromYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuFromYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtZenkaiChushutsuFromYMD")
    private TextBoxDate txtZenkaiChushutsuFromYMD;

    /*
     * gettxtZenkaiChushutsuFromYMD
     * @return txtZenkaiChushutsuFromYMD
     */
    @JsonProperty("txtZenkaiChushutsuFromYMD")
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return txtZenkaiChushutsuFromYMD;
    }

    /*
     * settxtZenkaiChushutsuFromYMD
     * @param txtZenkaiChushutsuFromYMD txtZenkaiChushutsuFromYMD
     */
    @JsonProperty("txtZenkaiChushutsuFromYMD")
    public void setTxtZenkaiChushutsuFromYMD(TextBoxDate txtZenkaiChushutsuFromYMD) {
        this.txtZenkaiChushutsuFromYMD = txtZenkaiChushutsuFromYMD;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuFromTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuFromTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtZenkaiChushutsuFromTime")
    private TextBoxTime txtZenkaiChushutsuFromTime;
    @JsonProperty("lblKara1")
    private Label lblKara1;

    /*
     * gettxtZenkaiChushutsuFromTime
     * @return txtZenkaiChushutsuFromTime
     */
    @JsonProperty("txtZenkaiChushutsuFromTime")
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return txtZenkaiChushutsuFromTime;
    }

    /*
     * settxtZenkaiChushutsuFromTime
     * @param txtZenkaiChushutsuFromTime txtZenkaiChushutsuFromTime
     */
    @JsonProperty("txtZenkaiChushutsuFromTime")
    public void setTxtZenkaiChushutsuFromTime(TextBoxTime txtZenkaiChushutsuFromTime) {
        this.txtZenkaiChushutsuFromTime = txtZenkaiChushutsuFromTime;
    }

    /*
     * getlblKara1
     * @return lblKara1
     */
    @JsonProperty("lblKara1")
    public Label getLblKara1() {
        return lblKara1;
    }

    /*
     * setlblKara1
     * @param lblKara1 lblKara1
     */
    @JsonProperty("lblKara1")
    public void setLblKara1(Label lblKara1) {
        this.lblKara1 = lblKara1;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuToYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuToYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtZenkaiChushutsuToYMD")
    private TextBoxDate txtZenkaiChushutsuToYMD;

    /*
     * gettxtZenkaiChushutsuToYMD
     * @return txtZenkaiChushutsuToYMD
     */
    @JsonProperty("txtZenkaiChushutsuToYMD")
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return txtZenkaiChushutsuToYMD;
    }

    /*
     * settxtZenkaiChushutsuToYMD
     * @param txtZenkaiChushutsuToYMD txtZenkaiChushutsuToYMD
     */
    @JsonProperty("txtZenkaiChushutsuToYMD")
    public void setTxtZenkaiChushutsuToYMD(TextBoxDate txtZenkaiChushutsuToYMD) {
        this.txtZenkaiChushutsuToYMD = txtZenkaiChushutsuToYMD;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuToTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuToTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtZenkaiChushutsuToTime")
    private TextBoxTime txtZenkaiChushutsuToTime;

    /*
     * gettxtZenkaiChushutsuToTime
     * @return txtZenkaiChushutsuToTime
     */
    @JsonProperty("txtZenkaiChushutsuToTime")
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return txtZenkaiChushutsuToTime;
    }

    /*
     * settxtZenkaiChushutsuToTime
     * @param txtZenkaiChushutsuToTime txtZenkaiChushutsuToTime
     */
    @JsonProperty("txtZenkaiChushutsuToTime")
    public void setTxtZenkaiChushutsuToTime(TextBoxTime txtZenkaiChushutsuToTime) {
        this.txtZenkaiChushutsuToTime = txtZenkaiChushutsuToTime;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblKonkaiChushutsu")
    private Label lblKonkaiChushutsu;

    /*
     * getlblKonkaiChushutsu
     * @return lblKonkaiChushutsu
     */
    @JsonProperty("lblKonkaiChushutsu")
    public Label getLblKonkaiChushutsu() {
        return lblKonkaiChushutsu;
    }

    /*
     * setlblKonkaiChushutsu
     * @param lblKonkaiChushutsu lblKonkaiChushutsu
     */
    @JsonProperty("lblKonkaiChushutsu")
    public void setLblKonkaiChushutsu(Label lblKonkaiChushutsu) {
        this.lblKonkaiChushutsu = lblKonkaiChushutsu;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsuFromYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuFromYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtKonkaiChushutsuFromYMD")
    private TextBoxDate txtKonkaiChushutsuFromYMD;

    /*
     * gettxtKonkaiChushutsuFromYMD
     * @return txtKonkaiChushutsuFromYMD
     */
    @JsonProperty("txtKonkaiChushutsuFromYMD")
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return txtKonkaiChushutsuFromYMD;
    }

    /*
     * settxtKonkaiChushutsuFromYMD
     * @param txtKonkaiChushutsuFromYMD txtKonkaiChushutsuFromYMD
     */
    @JsonProperty("txtKonkaiChushutsuFromYMD")
    public void setTxtKonkaiChushutsuFromYMD(TextBoxDate txtKonkaiChushutsuFromYMD) {
        this.txtKonkaiChushutsuFromYMD = txtKonkaiChushutsuFromYMD;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsuFromTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuFromTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtKonkaiChushutsuFromTime")
    private TextBoxTime txtKonkaiChushutsuFromTime;
    @JsonProperty("lblKara2")
    private Label lblKara2;

    /*
     * gettxtKonkaiChushutsuFromTime
     * @return txtKonkaiChushutsuFromTime
     */
    @JsonProperty("txtKonkaiChushutsuFromTime")
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return txtKonkaiChushutsuFromTime;
    }

    /*
     * settxtKonkaiChushutsuFromTime
     * @param txtKonkaiChushutsuFromTime txtKonkaiChushutsuFromTime
     */
    @JsonProperty("txtKonkaiChushutsuFromTime")
    public void setTxtKonkaiChushutsuFromTime(TextBoxTime txtKonkaiChushutsuFromTime) {
        this.txtKonkaiChushutsuFromTime = txtKonkaiChushutsuFromTime;
    }

    /*
     * getlblKara2
     * @return lblKara2
     */
    @JsonProperty("lblKara2")
    public Label getLblKara2() {
        return lblKara2;
    }

    /*
     * setlblKara2
     * @param lblKara2 lblKara2
     */
    @JsonProperty("lblKara2")
    public void setLblKara2(Label lblKara2) {
        this.lblKara2 = lblKara2;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsuToYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuToYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celKikanHenko のクラスファイル 
 * 
 * @author 自動生成
 */
class celKikanHenkoAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("chkKikanHenko")
    private CheckBoxList chkKikanHenko;

    /*
     * getchkKikanHenko
     * @return chkKikanHenko
     */
    @JsonProperty("chkKikanHenko")
    public CheckBoxList getChkKikanHenko() {
        return chkKikanHenko;
    }

    /*
     * setchkKikanHenko
     * @param chkKikanHenko chkKikanHenko
     */
    @JsonProperty("chkKikanHenko")
    public void setChkKikanHenko(CheckBoxList chkKikanHenko) {
        this.chkKikanHenko = chkKikanHenko;
    }

    // </editor-fold>
}
