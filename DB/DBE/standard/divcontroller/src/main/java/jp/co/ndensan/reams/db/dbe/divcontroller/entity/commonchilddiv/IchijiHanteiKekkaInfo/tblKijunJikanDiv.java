package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaInfo;
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
 * tblKijunJikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKijunJikanDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celShokujiHeader")
    private celShokujiHeaderAttblKijunJikan celShokujiHeader;
    @JsonProperty("celHaisetsuHeader")
    private celHaisetsuHeaderAttblKijunJikan celHaisetsuHeader;
    @JsonProperty("celIdoHeader")
    private celIdoHeaderAttblKijunJikan celIdoHeader;
    @JsonProperty("celSeiketsuHojiHeader")
    private celSeiketsuHojiHeaderAttblKijunJikan celSeiketsuHojiHeader;
    @JsonProperty("celKansetsuCareHeader")
    private celKansetsuCareHeaderAttblKijunJikan celKansetsuCareHeader;
    @JsonProperty("celBpsdKanrenHeader")
    private celBpsdKanrenHeaderAttblKijunJikan celBpsdKanrenHeader;
    @JsonProperty("celKinoKunrenHeader")
    private celKinoKunrenHeaderAttblKijunJikan celKinoKunrenHeader;
    @JsonProperty("celIryoKanrenHeader")
    private celIryoKanrenHeaderAttblKijunJikan celIryoKanrenHeader;
    @JsonProperty("celNinchishoKasanHeader")
    private celNinchishoKasanHeaderAttblKijunJikan celNinchishoKasanHeader;
    @JsonProperty("celShokuji")
    private celShokujiAttblKijunJikan celShokuji;
    @JsonProperty("celHaisetsu")
    private celHaisetsuAttblKijunJikan celHaisetsu;
    @JsonProperty("celIdo")
    private celIdoAttblKijunJikan celIdo;
    @JsonProperty("celSeiketsuHoji")
    private celSeiketsuHojiAttblKijunJikan celSeiketsuHoji;
    @JsonProperty("celKansetsuCare")
    private celKansetsuCareAttblKijunJikan celKansetsuCare;
    @JsonProperty("celBpsdKanren")
    private celBpsdKanrenAttblKijunJikan celBpsdKanren;
    @JsonProperty("celKinoKunren")
    private celKinoKunrenAttblKijunJikan celKinoKunren;
    @JsonProperty("celIryoKanren")
    private celIryoKanrenAttblKijunJikan celIryoKanren;
    @JsonProperty("celNinchishoKasan")
    private celNinchishoKasanAttblKijunJikan celNinchishoKasan;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShokuji() {
        return this.celShokujiHeader.getLblShokuji();
    }

    @JsonIgnore
    public Label getLblHaisetsu() {
        return this.celHaisetsuHeader.getLblHaisetsu();
    }

    @JsonIgnore
    public Label getLblIdo() {
        return this.celIdoHeader.getLblIdo();
    }

    @JsonIgnore
    public Label getLblSeiketsuhoji() {
        return this.celSeiketsuHojiHeader.getLblSeiketsuhoji();
    }

    @JsonIgnore
    public Label getLblKansetsuCare() {
        return this.celKansetsuCareHeader.getLblKansetsuCare();
    }

    @JsonIgnore
    public Label getLblBpsdKanren() {
        return this.celBpsdKanrenHeader.getLblBpsdKanren();
    }

    @JsonIgnore
    public Label getLblKinoKunren() {
        return this.celKinoKunrenHeader.getLblKinoKunren();
    }

    @JsonIgnore
    public Label getLblIryoKanren() {
        return this.celIryoKanrenHeader.getLblIryoKanren();
    }

    @JsonIgnore
    public Label getLblNinchishoKasan() {
        return this.celNinchishoKasanHeader.getLblNinchishoKasan();
    }

    @JsonIgnore
    public TextBox getTxtShokuji() {
        return this.celShokuji.getTxtShokuji();
    }

    @JsonIgnore
    public TextBox getTxtHaisetsu() {
        return this.celHaisetsu.getTxtHaisetsu();
    }

    @JsonIgnore
    public TextBox getTxtIdo() {
        return this.celIdo.getTxtIdo();
    }

    @JsonIgnore
    public TextBox getTxtSeiketsuHoji() {
        return this.celSeiketsuHoji.getTxtSeiketsuHoji();
    }

    @JsonIgnore
    public TextBox getTxtKansetsuCare() {
        return this.celKansetsuCare.getTxtKansetsuCare();
    }

    @JsonIgnore
    public TextBox getTxtBpsdKanren() {
        return this.celBpsdKanren.getTxtBpsdKanren();
    }

    @JsonIgnore
    public TextBox getTxtKinoKunren() {
        return this.celKinoKunren.getTxtKinoKunren();
    }

    @JsonIgnore
    public TextBox getTxtIryoKanren() {
        return this.celIryoKanren.getTxtIryoKanren();
    }

    @JsonIgnore
    public TextBox getTxtNinchishoKasan() {
        return this.celNinchishoKasan.getTxtNinchishoKasan();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelShokujiHeader
     * @return celShokujiHeader
     */
    @JsonProperty("celShokujiHeader")
    private celShokujiHeaderAttblKijunJikan getCelShokujiHeader() {
        return celShokujiHeader;
    }

    /*
     * setcelShokujiHeader
     * @param celShokujiHeader celShokujiHeader
     */
    @JsonProperty("celShokujiHeader")
    private void setCelShokujiHeader(celShokujiHeaderAttblKijunJikan celShokujiHeader) {
        this.celShokujiHeader = celShokujiHeader;
    }

    /*
     * getcelHaisetsuHeader
     * @return celHaisetsuHeader
     */
    @JsonProperty("celHaisetsuHeader")
    private celHaisetsuHeaderAttblKijunJikan getCelHaisetsuHeader() {
        return celHaisetsuHeader;
    }

    /*
     * setcelHaisetsuHeader
     * @param celHaisetsuHeader celHaisetsuHeader
     */
    @JsonProperty("celHaisetsuHeader")
    private void setCelHaisetsuHeader(celHaisetsuHeaderAttblKijunJikan celHaisetsuHeader) {
        this.celHaisetsuHeader = celHaisetsuHeader;
    }

    /*
     * getcelIdoHeader
     * @return celIdoHeader
     */
    @JsonProperty("celIdoHeader")
    private celIdoHeaderAttblKijunJikan getCelIdoHeader() {
        return celIdoHeader;
    }

    /*
     * setcelIdoHeader
     * @param celIdoHeader celIdoHeader
     */
    @JsonProperty("celIdoHeader")
    private void setCelIdoHeader(celIdoHeaderAttblKijunJikan celIdoHeader) {
        this.celIdoHeader = celIdoHeader;
    }

    /*
     * getcelSeiketsuHojiHeader
     * @return celSeiketsuHojiHeader
     */
    @JsonProperty("celSeiketsuHojiHeader")
    private celSeiketsuHojiHeaderAttblKijunJikan getCelSeiketsuHojiHeader() {
        return celSeiketsuHojiHeader;
    }

    /*
     * setcelSeiketsuHojiHeader
     * @param celSeiketsuHojiHeader celSeiketsuHojiHeader
     */
    @JsonProperty("celSeiketsuHojiHeader")
    private void setCelSeiketsuHojiHeader(celSeiketsuHojiHeaderAttblKijunJikan celSeiketsuHojiHeader) {
        this.celSeiketsuHojiHeader = celSeiketsuHojiHeader;
    }

    /*
     * getcelKansetsuCareHeader
     * @return celKansetsuCareHeader
     */
    @JsonProperty("celKansetsuCareHeader")
    private celKansetsuCareHeaderAttblKijunJikan getCelKansetsuCareHeader() {
        return celKansetsuCareHeader;
    }

    /*
     * setcelKansetsuCareHeader
     * @param celKansetsuCareHeader celKansetsuCareHeader
     */
    @JsonProperty("celKansetsuCareHeader")
    private void setCelKansetsuCareHeader(celKansetsuCareHeaderAttblKijunJikan celKansetsuCareHeader) {
        this.celKansetsuCareHeader = celKansetsuCareHeader;
    }

    /*
     * getcelBpsdKanrenHeader
     * @return celBpsdKanrenHeader
     */
    @JsonProperty("celBpsdKanrenHeader")
    private celBpsdKanrenHeaderAttblKijunJikan getCelBpsdKanrenHeader() {
        return celBpsdKanrenHeader;
    }

    /*
     * setcelBpsdKanrenHeader
     * @param celBpsdKanrenHeader celBpsdKanrenHeader
     */
    @JsonProperty("celBpsdKanrenHeader")
    private void setCelBpsdKanrenHeader(celBpsdKanrenHeaderAttblKijunJikan celBpsdKanrenHeader) {
        this.celBpsdKanrenHeader = celBpsdKanrenHeader;
    }

    /*
     * getcelKinoKunrenHeader
     * @return celKinoKunrenHeader
     */
    @JsonProperty("celKinoKunrenHeader")
    private celKinoKunrenHeaderAttblKijunJikan getCelKinoKunrenHeader() {
        return celKinoKunrenHeader;
    }

    /*
     * setcelKinoKunrenHeader
     * @param celKinoKunrenHeader celKinoKunrenHeader
     */
    @JsonProperty("celKinoKunrenHeader")
    private void setCelKinoKunrenHeader(celKinoKunrenHeaderAttblKijunJikan celKinoKunrenHeader) {
        this.celKinoKunrenHeader = celKinoKunrenHeader;
    }

    /*
     * getcelIryoKanrenHeader
     * @return celIryoKanrenHeader
     */
    @JsonProperty("celIryoKanrenHeader")
    private celIryoKanrenHeaderAttblKijunJikan getCelIryoKanrenHeader() {
        return celIryoKanrenHeader;
    }

    /*
     * setcelIryoKanrenHeader
     * @param celIryoKanrenHeader celIryoKanrenHeader
     */
    @JsonProperty("celIryoKanrenHeader")
    private void setCelIryoKanrenHeader(celIryoKanrenHeaderAttblKijunJikan celIryoKanrenHeader) {
        this.celIryoKanrenHeader = celIryoKanrenHeader;
    }

    /*
     * getcelNinchishoKasanHeader
     * @return celNinchishoKasanHeader
     */
    @JsonProperty("celNinchishoKasanHeader")
    private celNinchishoKasanHeaderAttblKijunJikan getCelNinchishoKasanHeader() {
        return celNinchishoKasanHeader;
    }

    /*
     * setcelNinchishoKasanHeader
     * @param celNinchishoKasanHeader celNinchishoKasanHeader
     */
    @JsonProperty("celNinchishoKasanHeader")
    private void setCelNinchishoKasanHeader(celNinchishoKasanHeaderAttblKijunJikan celNinchishoKasanHeader) {
        this.celNinchishoKasanHeader = celNinchishoKasanHeader;
    }

    /*
     * getcelShokuji
     * @return celShokuji
     */
    @JsonProperty("celShokuji")
    private celShokujiAttblKijunJikan getCelShokuji() {
        return celShokuji;
    }

    /*
     * setcelShokuji
     * @param celShokuji celShokuji
     */
    @JsonProperty("celShokuji")
    private void setCelShokuji(celShokujiAttblKijunJikan celShokuji) {
        this.celShokuji = celShokuji;
    }

    /*
     * getcelHaisetsu
     * @return celHaisetsu
     */
    @JsonProperty("celHaisetsu")
    private celHaisetsuAttblKijunJikan getCelHaisetsu() {
        return celHaisetsu;
    }

    /*
     * setcelHaisetsu
     * @param celHaisetsu celHaisetsu
     */
    @JsonProperty("celHaisetsu")
    private void setCelHaisetsu(celHaisetsuAttblKijunJikan celHaisetsu) {
        this.celHaisetsu = celHaisetsu;
    }

    /*
     * getcelIdo
     * @return celIdo
     */
    @JsonProperty("celIdo")
    private celIdoAttblKijunJikan getCelIdo() {
        return celIdo;
    }

    /*
     * setcelIdo
     * @param celIdo celIdo
     */
    @JsonProperty("celIdo")
    private void setCelIdo(celIdoAttblKijunJikan celIdo) {
        this.celIdo = celIdo;
    }

    /*
     * getcelSeiketsuHoji
     * @return celSeiketsuHoji
     */
    @JsonProperty("celSeiketsuHoji")
    private celSeiketsuHojiAttblKijunJikan getCelSeiketsuHoji() {
        return celSeiketsuHoji;
    }

    /*
     * setcelSeiketsuHoji
     * @param celSeiketsuHoji celSeiketsuHoji
     */
    @JsonProperty("celSeiketsuHoji")
    private void setCelSeiketsuHoji(celSeiketsuHojiAttblKijunJikan celSeiketsuHoji) {
        this.celSeiketsuHoji = celSeiketsuHoji;
    }

    /*
     * getcelKansetsuCare
     * @return celKansetsuCare
     */
    @JsonProperty("celKansetsuCare")
    private celKansetsuCareAttblKijunJikan getCelKansetsuCare() {
        return celKansetsuCare;
    }

    /*
     * setcelKansetsuCare
     * @param celKansetsuCare celKansetsuCare
     */
    @JsonProperty("celKansetsuCare")
    private void setCelKansetsuCare(celKansetsuCareAttblKijunJikan celKansetsuCare) {
        this.celKansetsuCare = celKansetsuCare;
    }

    /*
     * getcelBpsdKanren
     * @return celBpsdKanren
     */
    @JsonProperty("celBpsdKanren")
    private celBpsdKanrenAttblKijunJikan getCelBpsdKanren() {
        return celBpsdKanren;
    }

    /*
     * setcelBpsdKanren
     * @param celBpsdKanren celBpsdKanren
     */
    @JsonProperty("celBpsdKanren")
    private void setCelBpsdKanren(celBpsdKanrenAttblKijunJikan celBpsdKanren) {
        this.celBpsdKanren = celBpsdKanren;
    }

    /*
     * getcelKinoKunren
     * @return celKinoKunren
     */
    @JsonProperty("celKinoKunren")
    private celKinoKunrenAttblKijunJikan getCelKinoKunren() {
        return celKinoKunren;
    }

    /*
     * setcelKinoKunren
     * @param celKinoKunren celKinoKunren
     */
    @JsonProperty("celKinoKunren")
    private void setCelKinoKunren(celKinoKunrenAttblKijunJikan celKinoKunren) {
        this.celKinoKunren = celKinoKunren;
    }

    /*
     * getcelIryoKanren
     * @return celIryoKanren
     */
    @JsonProperty("celIryoKanren")
    private celIryoKanrenAttblKijunJikan getCelIryoKanren() {
        return celIryoKanren;
    }

    /*
     * setcelIryoKanren
     * @param celIryoKanren celIryoKanren
     */
    @JsonProperty("celIryoKanren")
    private void setCelIryoKanren(celIryoKanrenAttblKijunJikan celIryoKanren) {
        this.celIryoKanren = celIryoKanren;
    }

    /*
     * getcelNinchishoKasan
     * @return celNinchishoKasan
     */
    @JsonProperty("celNinchishoKasan")
    private celNinchishoKasanAttblKijunJikan getCelNinchishoKasan() {
        return celNinchishoKasan;
    }

    /*
     * setcelNinchishoKasan
     * @param celNinchishoKasan celNinchishoKasan
     */
    @JsonProperty("celNinchishoKasan")
    private void setCelNinchishoKasan(celNinchishoKasanAttblKijunJikan celNinchishoKasan) {
        this.celNinchishoKasan = celNinchishoKasan;
    }

    // </editor-fold>
}
/**
 * celShokujiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokujiHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblShokuji")
    private Label lblShokuji;

    /*
     * getlblShokuji
     * @return lblShokuji
     */
    @JsonProperty("lblShokuji")
    public Label getLblShokuji() {
        return lblShokuji;
    }

    /*
     * setlblShokuji
     * @param lblShokuji lblShokuji
     */
    @JsonProperty("lblShokuji")
    public void setLblShokuji(Label lblShokuji) {
        this.lblShokuji = lblShokuji;
    }

    // </editor-fold>
}
/**
 * celHaisetsuHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celHaisetsuHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblHaisetsu")
    private Label lblHaisetsu;

    /*
     * getlblHaisetsu
     * @return lblHaisetsu
     */
    @JsonProperty("lblHaisetsu")
    public Label getLblHaisetsu() {
        return lblHaisetsu;
    }

    /*
     * setlblHaisetsu
     * @param lblHaisetsu lblHaisetsu
     */
    @JsonProperty("lblHaisetsu")
    public void setLblHaisetsu(Label lblHaisetsu) {
        this.lblHaisetsu = lblHaisetsu;
    }

    // </editor-fold>
}
/**
 * celIdoHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celIdoHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblIdo")
    private Label lblIdo;

    /*
     * getlblIdo
     * @return lblIdo
     */
    @JsonProperty("lblIdo")
    public Label getLblIdo() {
        return lblIdo;
    }

    /*
     * setlblIdo
     * @param lblIdo lblIdo
     */
    @JsonProperty("lblIdo")
    public void setLblIdo(Label lblIdo) {
        this.lblIdo = lblIdo;
    }

    // </editor-fold>
}
/**
 * celSeiketsuHojiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celSeiketsuHojiHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblSeiketsuhoji")
    private Label lblSeiketsuhoji;

    /*
     * getlblSeiketsuhoji
     * @return lblSeiketsuhoji
     */
    @JsonProperty("lblSeiketsuhoji")
    public Label getLblSeiketsuhoji() {
        return lblSeiketsuhoji;
    }

    /*
     * setlblSeiketsuhoji
     * @param lblSeiketsuhoji lblSeiketsuhoji
     */
    @JsonProperty("lblSeiketsuhoji")
    public void setLblSeiketsuhoji(Label lblSeiketsuhoji) {
        this.lblSeiketsuhoji = lblSeiketsuhoji;
    }

    // </editor-fold>
}
/**
 * celKansetsuCareHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celKansetsuCareHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblKansetsuCare")
    private Label lblKansetsuCare;

    /*
     * getlblKansetsuCare
     * @return lblKansetsuCare
     */
    @JsonProperty("lblKansetsuCare")
    public Label getLblKansetsuCare() {
        return lblKansetsuCare;
    }

    /*
     * setlblKansetsuCare
     * @param lblKansetsuCare lblKansetsuCare
     */
    @JsonProperty("lblKansetsuCare")
    public void setLblKansetsuCare(Label lblKansetsuCare) {
        this.lblKansetsuCare = lblKansetsuCare;
    }

    // </editor-fold>
}
/**
 * celBpsdKanrenHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celBpsdKanrenHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblBpsdKanren")
    private Label lblBpsdKanren;

    /*
     * getlblBpsdKanren
     * @return lblBpsdKanren
     */
    @JsonProperty("lblBpsdKanren")
    public Label getLblBpsdKanren() {
        return lblBpsdKanren;
    }

    /*
     * setlblBpsdKanren
     * @param lblBpsdKanren lblBpsdKanren
     */
    @JsonProperty("lblBpsdKanren")
    public void setLblBpsdKanren(Label lblBpsdKanren) {
        this.lblBpsdKanren = lblBpsdKanren;
    }

    // </editor-fold>
}
/**
 * celKinoKunrenHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celKinoKunrenHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblKinoKunren")
    private Label lblKinoKunren;

    /*
     * getlblKinoKunren
     * @return lblKinoKunren
     */
    @JsonProperty("lblKinoKunren")
    public Label getLblKinoKunren() {
        return lblKinoKunren;
    }

    /*
     * setlblKinoKunren
     * @param lblKinoKunren lblKinoKunren
     */
    @JsonProperty("lblKinoKunren")
    public void setLblKinoKunren(Label lblKinoKunren) {
        this.lblKinoKunren = lblKinoKunren;
    }

    // </editor-fold>
}
/**
 * celIryoKanrenHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celIryoKanrenHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblIryoKanren")
    private Label lblIryoKanren;

    /*
     * getlblIryoKanren
     * @return lblIryoKanren
     */
    @JsonProperty("lblIryoKanren")
    public Label getLblIryoKanren() {
        return lblIryoKanren;
    }

    /*
     * setlblIryoKanren
     * @param lblIryoKanren lblIryoKanren
     */
    @JsonProperty("lblIryoKanren")
    public void setLblIryoKanren(Label lblIryoKanren) {
        this.lblIryoKanren = lblIryoKanren;
    }

    // </editor-fold>
}
/**
 * celNinchishoKasanHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchishoKasanHeaderAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblNinchishoKasan")
    private Label lblNinchishoKasan;

    /*
     * getlblNinchishoKasan
     * @return lblNinchishoKasan
     */
    @JsonProperty("lblNinchishoKasan")
    public Label getLblNinchishoKasan() {
        return lblNinchishoKasan;
    }

    /*
     * setlblNinchishoKasan
     * @param lblNinchishoKasan lblNinchishoKasan
     */
    @JsonProperty("lblNinchishoKasan")
    public void setLblNinchishoKasan(Label lblNinchishoKasan) {
        this.lblNinchishoKasan = lblNinchishoKasan;
    }

    // </editor-fold>
}
/**
 * celShokuji のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokujiAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtShokuji")
    private TextBox txtShokuji;

    /*
     * gettxtShokuji
     * @return txtShokuji
     */
    @JsonProperty("txtShokuji")
    public TextBox getTxtShokuji() {
        return txtShokuji;
    }

    /*
     * settxtShokuji
     * @param txtShokuji txtShokuji
     */
    @JsonProperty("txtShokuji")
    public void setTxtShokuji(TextBox txtShokuji) {
        this.txtShokuji = txtShokuji;
    }

    // </editor-fold>
}
/**
 * celHaisetsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celHaisetsuAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtHaisetsu")
    private TextBox txtHaisetsu;

    /*
     * gettxtHaisetsu
     * @return txtHaisetsu
     */
    @JsonProperty("txtHaisetsu")
    public TextBox getTxtHaisetsu() {
        return txtHaisetsu;
    }

    /*
     * settxtHaisetsu
     * @param txtHaisetsu txtHaisetsu
     */
    @JsonProperty("txtHaisetsu")
    public void setTxtHaisetsu(TextBox txtHaisetsu) {
        this.txtHaisetsu = txtHaisetsu;
    }

    // </editor-fold>
}
/**
 * celIdo のクラスファイル 
 * 
 * @author 自動生成
 */
class celIdoAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtIdo")
    private TextBox txtIdo;

    /*
     * gettxtIdo
     * @return txtIdo
     */
    @JsonProperty("txtIdo")
    public TextBox getTxtIdo() {
        return txtIdo;
    }

    /*
     * settxtIdo
     * @param txtIdo txtIdo
     */
    @JsonProperty("txtIdo")
    public void setTxtIdo(TextBox txtIdo) {
        this.txtIdo = txtIdo;
    }

    // </editor-fold>
}
/**
 * celSeiketsuHoji のクラスファイル 
 * 
 * @author 自動生成
 */
class celSeiketsuHojiAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtSeiketsuHoji")
    private TextBox txtSeiketsuHoji;

    /*
     * gettxtSeiketsuHoji
     * @return txtSeiketsuHoji
     */
    @JsonProperty("txtSeiketsuHoji")
    public TextBox getTxtSeiketsuHoji() {
        return txtSeiketsuHoji;
    }

    /*
     * settxtSeiketsuHoji
     * @param txtSeiketsuHoji txtSeiketsuHoji
     */
    @JsonProperty("txtSeiketsuHoji")
    public void setTxtSeiketsuHoji(TextBox txtSeiketsuHoji) {
        this.txtSeiketsuHoji = txtSeiketsuHoji;
    }

    // </editor-fold>
}
/**
 * celKansetsuCare のクラスファイル 
 * 
 * @author 自動生成
 */
class celKansetsuCareAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtKansetsuCare")
    private TextBox txtKansetsuCare;

    /*
     * gettxtKansetsuCare
     * @return txtKansetsuCare
     */
    @JsonProperty("txtKansetsuCare")
    public TextBox getTxtKansetsuCare() {
        return txtKansetsuCare;
    }

    /*
     * settxtKansetsuCare
     * @param txtKansetsuCare txtKansetsuCare
     */
    @JsonProperty("txtKansetsuCare")
    public void setTxtKansetsuCare(TextBox txtKansetsuCare) {
        this.txtKansetsuCare = txtKansetsuCare;
    }

    // </editor-fold>
}
/**
 * celBpsdKanren のクラスファイル 
 * 
 * @author 自動生成
 */
class celBpsdKanrenAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtBpsdKanren")
    private TextBox txtBpsdKanren;

    /*
     * gettxtBpsdKanren
     * @return txtBpsdKanren
     */
    @JsonProperty("txtBpsdKanren")
    public TextBox getTxtBpsdKanren() {
        return txtBpsdKanren;
    }

    /*
     * settxtBpsdKanren
     * @param txtBpsdKanren txtBpsdKanren
     */
    @JsonProperty("txtBpsdKanren")
    public void setTxtBpsdKanren(TextBox txtBpsdKanren) {
        this.txtBpsdKanren = txtBpsdKanren;
    }

    // </editor-fold>
}
/**
 * celKinoKunren のクラスファイル 
 * 
 * @author 自動生成
 */
class celKinoKunrenAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtKinoKunren")
    private TextBox txtKinoKunren;

    /*
     * gettxtKinoKunren
     * @return txtKinoKunren
     */
    @JsonProperty("txtKinoKunren")
    public TextBox getTxtKinoKunren() {
        return txtKinoKunren;
    }

    /*
     * settxtKinoKunren
     * @param txtKinoKunren txtKinoKunren
     */
    @JsonProperty("txtKinoKunren")
    public void setTxtKinoKunren(TextBox txtKinoKunren) {
        this.txtKinoKunren = txtKinoKunren;
    }

    // </editor-fold>
}
/**
 * celIryoKanren のクラスファイル 
 * 
 * @author 自動生成
 */
class celIryoKanrenAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtIryoKanren")
    private TextBox txtIryoKanren;

    /*
     * gettxtIryoKanren
     * @return txtIryoKanren
     */
    @JsonProperty("txtIryoKanren")
    public TextBox getTxtIryoKanren() {
        return txtIryoKanren;
    }

    /*
     * settxtIryoKanren
     * @param txtIryoKanren txtIryoKanren
     */
    @JsonProperty("txtIryoKanren")
    public void setTxtIryoKanren(TextBox txtIryoKanren) {
        this.txtIryoKanren = txtIryoKanren;
    }

    // </editor-fold>
}
/**
 * celNinchishoKasan のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchishoKasanAttblKijunJikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtNinchishoKasan")
    private TextBox txtNinchishoKasan;

    /*
     * gettxtNinchishoKasan
     * @return txtNinchishoKasan
     */
    @JsonProperty("txtNinchishoKasan")
    public TextBox getTxtNinchishoKasan() {
        return txtNinchishoKasan;
    }

    /*
     * settxtNinchishoKasan
     * @param txtNinchishoKasan txtNinchishoKasan
     */
    @JsonProperty("txtNinchishoKasan")
    public void setTxtNinchishoKasan(TextBox txtNinchishoKasan) {
        this.txtNinchishoKasan = txtNinchishoKasan;
    }

    // </editor-fold>
}
