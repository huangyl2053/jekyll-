package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011;
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
 * tblkonkaiInfoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblkonkaiInfoInputDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celNull1")
    private celNull1AttblkonkaiInfoInput celNull1;
    @JsonProperty("celStYMD")
    private celStYMDAttblkonkaiInfoInput celStYMD;
    @JsonProperty("celStTime")
    private celStTimeAttblkonkaiInfoInput celStTime;
    @JsonProperty("celEdYMD")
    private celEdYMDAttblkonkaiInfoInput celEdYMD;
    @JsonProperty("celEdTime")
    private celEdTimeAttblkonkaiInfoInput celEdTime;
    @JsonProperty("celZenken")
    private celZenkenAttblkonkaiInfoInput celZenken;
    @JsonProperty("celZenkaiChushutsu")
    private celZenkaiChushutsuAttblkonkaiInfoInput celZenkaiChushutsu;
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private celZenkaiChushutsuFromYMDAttblkonkaiInfoInput celZenkaiChushutsuFromYMD;
    @JsonProperty("celZenkaiChushutsuFromTime")
    private celZenkaiChushutsuFromTimeAttblkonkaiInfoInput celZenkaiChushutsuFromTime;
    @JsonProperty("celZenkaiChushutsuToYMD")
    private celZenkaiChushutsuToYMDAttblkonkaiInfoInput celZenkaiChushutsuToYMD;
    @JsonProperty("celZenkaiChushutsuToTime")
    private celZenkaiChushutsuToTimeAttblkonkaiInfoInput celZenkaiChushutsuToTime;
    @JsonProperty("celKonkaiChushutsu")
    private celKonkaiChushutsuAttblkonkaiInfoInput celKonkaiChushutsu;
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private celKonkaiChushutsuFromYMDAttblkonkaiInfoInput celKonkaiChushutsuFromYMD;
    @JsonProperty("celKonkaiChushutsuFromTime")
    private celKonkaiChushutsuFromTimeAttblkonkaiInfoInput celKonkaiChushutsuFromTime;
    @JsonProperty("celButton")
    private celButtonAttblkonkaiInfoInput celButton;
    @JsonProperty("celNull2")
    private celNull2AttblkonkaiInfoInput celNull2;
    @JsonProperty("celNull3")
    private celNull3AttblkonkaiInfoInput celNull3;
    @JsonProperty("celNull4")
    private celNull4AttblkonkaiInfoInput celNull4;
    @JsonProperty("celBtn")
    private celBtnAttblkonkaiInfoInput celBtn;

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
    public Label getLblKara() {
        return this.celZenkaiChushutsuFromTime.getLblKara();
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
    public Button getBtnKakutei() {
        return this.celBtn.getBtnKakutei();
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.celBtn.getBtnClose();
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
    private celNull1AttblkonkaiInfoInput getCelNull1() {
        return celNull1;
    }

    /*
     * setcelNull1
     * @param celNull1 celNull1
     */
    @JsonProperty("celNull1")
    private void setCelNull1(celNull1AttblkonkaiInfoInput celNull1) {
        this.celNull1 = celNull1;
    }

    /*
     * getcelStYMD
     * @return celStYMD
     */
    @JsonProperty("celStYMD")
    private celStYMDAttblkonkaiInfoInput getCelStYMD() {
        return celStYMD;
    }

    /*
     * setcelStYMD
     * @param celStYMD celStYMD
     */
    @JsonProperty("celStYMD")
    private void setCelStYMD(celStYMDAttblkonkaiInfoInput celStYMD) {
        this.celStYMD = celStYMD;
    }

    /*
     * getcelStTime
     * @return celStTime
     */
    @JsonProperty("celStTime")
    private celStTimeAttblkonkaiInfoInput getCelStTime() {
        return celStTime;
    }

    /*
     * setcelStTime
     * @param celStTime celStTime
     */
    @JsonProperty("celStTime")
    private void setCelStTime(celStTimeAttblkonkaiInfoInput celStTime) {
        this.celStTime = celStTime;
    }

    /*
     * getcelEdYMD
     * @return celEdYMD
     */
    @JsonProperty("celEdYMD")
    private celEdYMDAttblkonkaiInfoInput getCelEdYMD() {
        return celEdYMD;
    }

    /*
     * setcelEdYMD
     * @param celEdYMD celEdYMD
     */
    @JsonProperty("celEdYMD")
    private void setCelEdYMD(celEdYMDAttblkonkaiInfoInput celEdYMD) {
        this.celEdYMD = celEdYMD;
    }

    /*
     * getcelEdTime
     * @return celEdTime
     */
    @JsonProperty("celEdTime")
    private celEdTimeAttblkonkaiInfoInput getCelEdTime() {
        return celEdTime;
    }

    /*
     * setcelEdTime
     * @param celEdTime celEdTime
     */
    @JsonProperty("celEdTime")
    private void setCelEdTime(celEdTimeAttblkonkaiInfoInput celEdTime) {
        this.celEdTime = celEdTime;
    }

    /*
     * getcelZenken
     * @return celZenken
     */
    @JsonProperty("celZenken")
    private celZenkenAttblkonkaiInfoInput getCelZenken() {
        return celZenken;
    }

    /*
     * setcelZenken
     * @param celZenken celZenken
     */
    @JsonProperty("celZenken")
    private void setCelZenken(celZenkenAttblkonkaiInfoInput celZenken) {
        this.celZenken = celZenken;
    }

    /*
     * getcelZenkaiChushutsu
     * @return celZenkaiChushutsu
     */
    @JsonProperty("celZenkaiChushutsu")
    private celZenkaiChushutsuAttblkonkaiInfoInput getCelZenkaiChushutsu() {
        return celZenkaiChushutsu;
    }

    /*
     * setcelZenkaiChushutsu
     * @param celZenkaiChushutsu celZenkaiChushutsu
     */
    @JsonProperty("celZenkaiChushutsu")
    private void setCelZenkaiChushutsu(celZenkaiChushutsuAttblkonkaiInfoInput celZenkaiChushutsu) {
        this.celZenkaiChushutsu = celZenkaiChushutsu;
    }

    /*
     * getcelZenkaiChushutsuFromYMD
     * @return celZenkaiChushutsuFromYMD
     */
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private celZenkaiChushutsuFromYMDAttblkonkaiInfoInput getCelZenkaiChushutsuFromYMD() {
        return celZenkaiChushutsuFromYMD;
    }

    /*
     * setcelZenkaiChushutsuFromYMD
     * @param celZenkaiChushutsuFromYMD celZenkaiChushutsuFromYMD
     */
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private void setCelZenkaiChushutsuFromYMD(celZenkaiChushutsuFromYMDAttblkonkaiInfoInput celZenkaiChushutsuFromYMD) {
        this.celZenkaiChushutsuFromYMD = celZenkaiChushutsuFromYMD;
    }

    /*
     * getcelZenkaiChushutsuFromTime
     * @return celZenkaiChushutsuFromTime
     */
    @JsonProperty("celZenkaiChushutsuFromTime")
    private celZenkaiChushutsuFromTimeAttblkonkaiInfoInput getCelZenkaiChushutsuFromTime() {
        return celZenkaiChushutsuFromTime;
    }

    /*
     * setcelZenkaiChushutsuFromTime
     * @param celZenkaiChushutsuFromTime celZenkaiChushutsuFromTime
     */
    @JsonProperty("celZenkaiChushutsuFromTime")
    private void setCelZenkaiChushutsuFromTime(celZenkaiChushutsuFromTimeAttblkonkaiInfoInput celZenkaiChushutsuFromTime) {
        this.celZenkaiChushutsuFromTime = celZenkaiChushutsuFromTime;
    }

    /*
     * getcelZenkaiChushutsuToYMD
     * @return celZenkaiChushutsuToYMD
     */
    @JsonProperty("celZenkaiChushutsuToYMD")
    private celZenkaiChushutsuToYMDAttblkonkaiInfoInput getCelZenkaiChushutsuToYMD() {
        return celZenkaiChushutsuToYMD;
    }

    /*
     * setcelZenkaiChushutsuToYMD
     * @param celZenkaiChushutsuToYMD celZenkaiChushutsuToYMD
     */
    @JsonProperty("celZenkaiChushutsuToYMD")
    private void setCelZenkaiChushutsuToYMD(celZenkaiChushutsuToYMDAttblkonkaiInfoInput celZenkaiChushutsuToYMD) {
        this.celZenkaiChushutsuToYMD = celZenkaiChushutsuToYMD;
    }

    /*
     * getcelZenkaiChushutsuToTime
     * @return celZenkaiChushutsuToTime
     */
    @JsonProperty("celZenkaiChushutsuToTime")
    private celZenkaiChushutsuToTimeAttblkonkaiInfoInput getCelZenkaiChushutsuToTime() {
        return celZenkaiChushutsuToTime;
    }

    /*
     * setcelZenkaiChushutsuToTime
     * @param celZenkaiChushutsuToTime celZenkaiChushutsuToTime
     */
    @JsonProperty("celZenkaiChushutsuToTime")
    private void setCelZenkaiChushutsuToTime(celZenkaiChushutsuToTimeAttblkonkaiInfoInput celZenkaiChushutsuToTime) {
        this.celZenkaiChushutsuToTime = celZenkaiChushutsuToTime;
    }

    /*
     * getcelKonkaiChushutsu
     * @return celKonkaiChushutsu
     */
    @JsonProperty("celKonkaiChushutsu")
    private celKonkaiChushutsuAttblkonkaiInfoInput getCelKonkaiChushutsu() {
        return celKonkaiChushutsu;
    }

    /*
     * setcelKonkaiChushutsu
     * @param celKonkaiChushutsu celKonkaiChushutsu
     */
    @JsonProperty("celKonkaiChushutsu")
    private void setCelKonkaiChushutsu(celKonkaiChushutsuAttblkonkaiInfoInput celKonkaiChushutsu) {
        this.celKonkaiChushutsu = celKonkaiChushutsu;
    }

    /*
     * getcelKonkaiChushutsuFromYMD
     * @return celKonkaiChushutsuFromYMD
     */
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private celKonkaiChushutsuFromYMDAttblkonkaiInfoInput getCelKonkaiChushutsuFromYMD() {
        return celKonkaiChushutsuFromYMD;
    }

    /*
     * setcelKonkaiChushutsuFromYMD
     * @param celKonkaiChushutsuFromYMD celKonkaiChushutsuFromYMD
     */
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private void setCelKonkaiChushutsuFromYMD(celKonkaiChushutsuFromYMDAttblkonkaiInfoInput celKonkaiChushutsuFromYMD) {
        this.celKonkaiChushutsuFromYMD = celKonkaiChushutsuFromYMD;
    }

    /*
     * getcelKonkaiChushutsuFromTime
     * @return celKonkaiChushutsuFromTime
     */
    @JsonProperty("celKonkaiChushutsuFromTime")
    private celKonkaiChushutsuFromTimeAttblkonkaiInfoInput getCelKonkaiChushutsuFromTime() {
        return celKonkaiChushutsuFromTime;
    }

    /*
     * setcelKonkaiChushutsuFromTime
     * @param celKonkaiChushutsuFromTime celKonkaiChushutsuFromTime
     */
    @JsonProperty("celKonkaiChushutsuFromTime")
    private void setCelKonkaiChushutsuFromTime(celKonkaiChushutsuFromTimeAttblkonkaiInfoInput celKonkaiChushutsuFromTime) {
        this.celKonkaiChushutsuFromTime = celKonkaiChushutsuFromTime;
    }

    /*
     * getcelButton
     * @return celButton
     */
    @JsonProperty("celButton")
    private celButtonAttblkonkaiInfoInput getCelButton() {
        return celButton;
    }

    /*
     * setcelButton
     * @param celButton celButton
     */
    @JsonProperty("celButton")
    private void setCelButton(celButtonAttblkonkaiInfoInput celButton) {
        this.celButton = celButton;
    }

    /*
     * getcelNull2
     * @return celNull2
     */
    @JsonProperty("celNull2")
    private celNull2AttblkonkaiInfoInput getCelNull2() {
        return celNull2;
    }

    /*
     * setcelNull2
     * @param celNull2 celNull2
     */
    @JsonProperty("celNull2")
    private void setCelNull2(celNull2AttblkonkaiInfoInput celNull2) {
        this.celNull2 = celNull2;
    }

    /*
     * getcelNull3
     * @return celNull3
     */
    @JsonProperty("celNull3")
    private celNull3AttblkonkaiInfoInput getCelNull3() {
        return celNull3;
    }

    /*
     * setcelNull3
     * @param celNull3 celNull3
     */
    @JsonProperty("celNull3")
    private void setCelNull3(celNull3AttblkonkaiInfoInput celNull3) {
        this.celNull3 = celNull3;
    }

    /*
     * getcelNull4
     * @return celNull4
     */
    @JsonProperty("celNull4")
    private celNull4AttblkonkaiInfoInput getCelNull4() {
        return celNull4;
    }

    /*
     * setcelNull4
     * @param celNull4 celNull4
     */
    @JsonProperty("celNull4")
    private void setCelNull4(celNull4AttblkonkaiInfoInput celNull4) {
        this.celNull4 = celNull4;
    }

    /*
     * getcelBtn
     * @return celBtn
     */
    @JsonProperty("celBtn")
    private celBtnAttblkonkaiInfoInput getCelBtn() {
        return celBtn;
    }

    /*
     * setcelBtn
     * @param celBtn celBtn
     */
    @JsonProperty("celBtn")
    private void setCelBtn(celBtnAttblkonkaiInfoInput celBtn) {
        this.celBtn = celBtn;
    }

    // </editor-fold>
}
/**
 * celNull1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull1AttblkonkaiInfoInput extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celStYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celStYMDAttblkonkaiInfoInput extends TableCell {
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
class celStTimeAttblkonkaiInfoInput extends TableCell {
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
class celEdYMDAttblkonkaiInfoInput extends TableCell {
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
class celEdTimeAttblkonkaiInfoInput extends TableCell {
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
class celZenkenAttblkonkaiInfoInput extends TableCell {
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
class celZenkaiChushutsuAttblkonkaiInfoInput extends TableCell {
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
class celZenkaiChushutsuFromYMDAttblkonkaiInfoInput extends TableCell {
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
class celZenkaiChushutsuFromTimeAttblkonkaiInfoInput extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtZenkaiChushutsuFromTime")
    private TextBoxTime txtZenkaiChushutsuFromTime;
    @JsonProperty("lblKara")
    private Label lblKara;

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
     * getlblKara
     * @return lblKara
     */
    @JsonProperty("lblKara")
    public Label getLblKara() {
        return lblKara;
    }

    /*
     * setlblKara
     * @param lblKara lblKara
     */
    @JsonProperty("lblKara")
    public void setLblKara(Label lblKara) {
        this.lblKara = lblKara;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuToYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuToYMDAttblkonkaiInfoInput extends TableCell {
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
class celZenkaiChushutsuToTimeAttblkonkaiInfoInput extends TableCell {
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
class celKonkaiChushutsuAttblkonkaiInfoInput extends TableCell {
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
class celKonkaiChushutsuFromYMDAttblkonkaiInfoInput extends TableCell {
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
class celKonkaiChushutsuFromTimeAttblkonkaiInfoInput extends TableCell {
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
 * celButton のクラスファイル 
 * 
 * @author 自動生成
 */
class celButtonAttblkonkaiInfoInput extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celNull2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull2AttblkonkaiInfoInput extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celNull3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull3AttblkonkaiInfoInput extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celNull4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull4AttblkonkaiInfoInput extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    // </editor-fold>
}
/**
 * celBtn のクラスファイル 
 * 
 * @author 自動生成
 */
class celBtnAttblkonkaiInfoInput extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
}
