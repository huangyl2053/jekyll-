package jp.co.ndensan.reams.db.dbe.divcontroller.entity.ichijiHanteiKekkaInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblKijunJikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKijunJikanDiv extends TablePanel {
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
    @JsonProperty("celShokuji")
    private celShokujiAttblKijunJikan celShokuji;
    @JsonProperty("celHaisetsu")
    private celHaisetsuAttblKijunJikan celHaisetsu;
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
    public TextBox getTxtShokuji() {
        return this.celShokuji.getTxtShokuji();
    }

    @JsonIgnore
    public TextBox getTxtHaisetsu() {
        return this.celHaisetsu.getTxtHaisetsu();
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
    @JsonProperty("celShokujiHeader")
    private celShokujiHeaderAttblKijunJikan getCelShokujiHeader() {
        return celShokujiHeader;
    }

    @JsonProperty("celShokujiHeader")
    private void setCelShokujiHeader(celShokujiHeaderAttblKijunJikan celShokujiHeader) {
        this.celShokujiHeader=celShokujiHeader;
    }

    @JsonProperty("celHaisetsuHeader")
    private celHaisetsuHeaderAttblKijunJikan getCelHaisetsuHeader() {
        return celHaisetsuHeader;
    }

    @JsonProperty("celHaisetsuHeader")
    private void setCelHaisetsuHeader(celHaisetsuHeaderAttblKijunJikan celHaisetsuHeader) {
        this.celHaisetsuHeader=celHaisetsuHeader;
    }

    @JsonProperty("celShokuji")
    private celShokujiAttblKijunJikan getCelShokuji() {
        return celShokuji;
    }

    @JsonProperty("celShokuji")
    private void setCelShokuji(celShokujiAttblKijunJikan celShokuji) {
        this.celShokuji=celShokuji;
    }

    @JsonProperty("celHaisetsu")
    private celHaisetsuAttblKijunJikan getCelHaisetsu() {
        return celHaisetsu;
    }

    @JsonProperty("celHaisetsu")
    private void setCelHaisetsu(celHaisetsuAttblKijunJikan celHaisetsu) {
        this.celHaisetsu=celHaisetsu;
    }

    @JsonProperty("celIdoHeader")
    private celIdoHeaderAttblKijunJikan getCelIdoHeader() {
        return celIdoHeader;
    }

    @JsonProperty("celIdoHeader")
    private void setCelIdoHeader(celIdoHeaderAttblKijunJikan celIdoHeader) {
        this.celIdoHeader=celIdoHeader;
    }

    @JsonProperty("celSeiketsuHojiHeader")
    private celSeiketsuHojiHeaderAttblKijunJikan getCelSeiketsuHojiHeader() {
        return celSeiketsuHojiHeader;
    }

    @JsonProperty("celSeiketsuHojiHeader")
    private void setCelSeiketsuHojiHeader(celSeiketsuHojiHeaderAttblKijunJikan celSeiketsuHojiHeader) {
        this.celSeiketsuHojiHeader=celSeiketsuHojiHeader;
    }

    @JsonProperty("celKansetsuCareHeader")
    private celKansetsuCareHeaderAttblKijunJikan getCelKansetsuCareHeader() {
        return celKansetsuCareHeader;
    }

    @JsonProperty("celKansetsuCareHeader")
    private void setCelKansetsuCareHeader(celKansetsuCareHeaderAttblKijunJikan celKansetsuCareHeader) {
        this.celKansetsuCareHeader=celKansetsuCareHeader;
    }

    @JsonProperty("celBpsdKanrenHeader")
    private celBpsdKanrenHeaderAttblKijunJikan getCelBpsdKanrenHeader() {
        return celBpsdKanrenHeader;
    }

    @JsonProperty("celBpsdKanrenHeader")
    private void setCelBpsdKanrenHeader(celBpsdKanrenHeaderAttblKijunJikan celBpsdKanrenHeader) {
        this.celBpsdKanrenHeader=celBpsdKanrenHeader;
    }

    @JsonProperty("celKinoKunrenHeader")
    private celKinoKunrenHeaderAttblKijunJikan getCelKinoKunrenHeader() {
        return celKinoKunrenHeader;
    }

    @JsonProperty("celKinoKunrenHeader")
    private void setCelKinoKunrenHeader(celKinoKunrenHeaderAttblKijunJikan celKinoKunrenHeader) {
        this.celKinoKunrenHeader=celKinoKunrenHeader;
    }

    @JsonProperty("celIryoKanrenHeader")
    private celIryoKanrenHeaderAttblKijunJikan getCelIryoKanrenHeader() {
        return celIryoKanrenHeader;
    }

    @JsonProperty("celIryoKanrenHeader")
    private void setCelIryoKanrenHeader(celIryoKanrenHeaderAttblKijunJikan celIryoKanrenHeader) {
        this.celIryoKanrenHeader=celIryoKanrenHeader;
    }

    @JsonProperty("celNinchishoKasanHeader")
    private celNinchishoKasanHeaderAttblKijunJikan getCelNinchishoKasanHeader() {
        return celNinchishoKasanHeader;
    }

    @JsonProperty("celNinchishoKasanHeader")
    private void setCelNinchishoKasanHeader(celNinchishoKasanHeaderAttblKijunJikan celNinchishoKasanHeader) {
        this.celNinchishoKasanHeader=celNinchishoKasanHeader;
    }

    @JsonProperty("celIdo")
    private celIdoAttblKijunJikan getCelIdo() {
        return celIdo;
    }

    @JsonProperty("celIdo")
    private void setCelIdo(celIdoAttblKijunJikan celIdo) {
        this.celIdo=celIdo;
    }

    @JsonProperty("celSeiketsuHoji")
    private celSeiketsuHojiAttblKijunJikan getCelSeiketsuHoji() {
        return celSeiketsuHoji;
    }

    @JsonProperty("celSeiketsuHoji")
    private void setCelSeiketsuHoji(celSeiketsuHojiAttblKijunJikan celSeiketsuHoji) {
        this.celSeiketsuHoji=celSeiketsuHoji;
    }

    @JsonProperty("celKansetsuCare")
    private celKansetsuCareAttblKijunJikan getCelKansetsuCare() {
        return celKansetsuCare;
    }

    @JsonProperty("celKansetsuCare")
    private void setCelKansetsuCare(celKansetsuCareAttblKijunJikan celKansetsuCare) {
        this.celKansetsuCare=celKansetsuCare;
    }

    @JsonProperty("celBpsdKanren")
    private celBpsdKanrenAttblKijunJikan getCelBpsdKanren() {
        return celBpsdKanren;
    }

    @JsonProperty("celBpsdKanren")
    private void setCelBpsdKanren(celBpsdKanrenAttblKijunJikan celBpsdKanren) {
        this.celBpsdKanren=celBpsdKanren;
    }

    @JsonProperty("celKinoKunren")
    private celKinoKunrenAttblKijunJikan getCelKinoKunren() {
        return celKinoKunren;
    }

    @JsonProperty("celKinoKunren")
    private void setCelKinoKunren(celKinoKunrenAttblKijunJikan celKinoKunren) {
        this.celKinoKunren=celKinoKunren;
    }

    @JsonProperty("celIryoKanren")
    private celIryoKanrenAttblKijunJikan getCelIryoKanren() {
        return celIryoKanren;
    }

    @JsonProperty("celIryoKanren")
    private void setCelIryoKanren(celIryoKanrenAttblKijunJikan celIryoKanren) {
        this.celIryoKanren=celIryoKanren;
    }

    @JsonProperty("celNinchishoKasan")
    private celNinchishoKasanAttblKijunJikan getCelNinchishoKasan() {
        return celNinchishoKasan;
    }

    @JsonProperty("celNinchishoKasan")
    private void setCelNinchishoKasan(celNinchishoKasanAttblKijunJikan celNinchishoKasan) {
        this.celNinchishoKasan=celNinchishoKasan;
    }

}
/**
 * celShokujiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokujiHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblShokuji")
    private Label lblShokuji;

    @JsonProperty("lblShokuji")
    public Label getLblShokuji() {
        return lblShokuji;
    }

    @JsonProperty("lblShokuji")
    public void setLblShokuji(Label lblShokuji) {
        this.lblShokuji=lblShokuji;
    }

}
/**
 * celHaisetsuHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celHaisetsuHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblHaisetsu")
    private Label lblHaisetsu;

    @JsonProperty("lblHaisetsu")
    public Label getLblHaisetsu() {
        return lblHaisetsu;
    }

    @JsonProperty("lblHaisetsu")
    public void setLblHaisetsu(Label lblHaisetsu) {
        this.lblHaisetsu=lblHaisetsu;
    }

}
/**
 * celShokuji のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokujiAttblKijunJikan extends TableCell {
    @JsonProperty("txtShokuji")
    private TextBox txtShokuji;

    @JsonProperty("txtShokuji")
    public TextBox getTxtShokuji() {
        return txtShokuji;
    }

    @JsonProperty("txtShokuji")
    public void setTxtShokuji(TextBox txtShokuji) {
        this.txtShokuji=txtShokuji;
    }

}
/**
 * celHaisetsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celHaisetsuAttblKijunJikan extends TableCell {
    @JsonProperty("txtHaisetsu")
    private TextBox txtHaisetsu;

    @JsonProperty("txtHaisetsu")
    public TextBox getTxtHaisetsu() {
        return txtHaisetsu;
    }

    @JsonProperty("txtHaisetsu")
    public void setTxtHaisetsu(TextBox txtHaisetsu) {
        this.txtHaisetsu=txtHaisetsu;
    }

}
/**
 * celIdoHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celIdoHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblIdo")
    private Label lblIdo;

    @JsonProperty("lblIdo")
    public Label getLblIdo() {
        return lblIdo;
    }

    @JsonProperty("lblIdo")
    public void setLblIdo(Label lblIdo) {
        this.lblIdo=lblIdo;
    }

}
/**
 * celSeiketsuHojiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celSeiketsuHojiHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblSeiketsuhoji")
    private Label lblSeiketsuhoji;

    @JsonProperty("lblSeiketsuhoji")
    public Label getLblSeiketsuhoji() {
        return lblSeiketsuhoji;
    }

    @JsonProperty("lblSeiketsuhoji")
    public void setLblSeiketsuhoji(Label lblSeiketsuhoji) {
        this.lblSeiketsuhoji=lblSeiketsuhoji;
    }

}
/**
 * celKansetsuCareHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celKansetsuCareHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblKansetsuCare")
    private Label lblKansetsuCare;

    @JsonProperty("lblKansetsuCare")
    public Label getLblKansetsuCare() {
        return lblKansetsuCare;
    }

    @JsonProperty("lblKansetsuCare")
    public void setLblKansetsuCare(Label lblKansetsuCare) {
        this.lblKansetsuCare=lblKansetsuCare;
    }

}
/**
 * celBpsdKanrenHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celBpsdKanrenHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblBpsdKanren")
    private Label lblBpsdKanren;

    @JsonProperty("lblBpsdKanren")
    public Label getLblBpsdKanren() {
        return lblBpsdKanren;
    }

    @JsonProperty("lblBpsdKanren")
    public void setLblBpsdKanren(Label lblBpsdKanren) {
        this.lblBpsdKanren=lblBpsdKanren;
    }

}
/**
 * celKinoKunrenHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celKinoKunrenHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblKinoKunren")
    private Label lblKinoKunren;

    @JsonProperty("lblKinoKunren")
    public Label getLblKinoKunren() {
        return lblKinoKunren;
    }

    @JsonProperty("lblKinoKunren")
    public void setLblKinoKunren(Label lblKinoKunren) {
        this.lblKinoKunren=lblKinoKunren;
    }

}
/**
 * celIryoKanrenHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celIryoKanrenHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblIryoKanren")
    private Label lblIryoKanren;

    @JsonProperty("lblIryoKanren")
    public Label getLblIryoKanren() {
        return lblIryoKanren;
    }

    @JsonProperty("lblIryoKanren")
    public void setLblIryoKanren(Label lblIryoKanren) {
        this.lblIryoKanren=lblIryoKanren;
    }

}
/**
 * celNinchishoKasanHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchishoKasanHeaderAttblKijunJikan extends TableCell {
    @JsonProperty("lblNinchishoKasan")
    private Label lblNinchishoKasan;

    @JsonProperty("lblNinchishoKasan")
    public Label getLblNinchishoKasan() {
        return lblNinchishoKasan;
    }

    @JsonProperty("lblNinchishoKasan")
    public void setLblNinchishoKasan(Label lblNinchishoKasan) {
        this.lblNinchishoKasan=lblNinchishoKasan;
    }

}
/**
 * celIdo のクラスファイル 
 * 
 * @author 自動生成
 */
class celIdoAttblKijunJikan extends TableCell {
    @JsonProperty("txtIdo")
    private TextBox txtIdo;

    @JsonProperty("txtIdo")
    public TextBox getTxtIdo() {
        return txtIdo;
    }

    @JsonProperty("txtIdo")
    public void setTxtIdo(TextBox txtIdo) {
        this.txtIdo=txtIdo;
    }

}
/**
 * celSeiketsuHoji のクラスファイル 
 * 
 * @author 自動生成
 */
class celSeiketsuHojiAttblKijunJikan extends TableCell {
    @JsonProperty("txtSeiketsuHoji")
    private TextBox txtSeiketsuHoji;

    @JsonProperty("txtSeiketsuHoji")
    public TextBox getTxtSeiketsuHoji() {
        return txtSeiketsuHoji;
    }

    @JsonProperty("txtSeiketsuHoji")
    public void setTxtSeiketsuHoji(TextBox txtSeiketsuHoji) {
        this.txtSeiketsuHoji=txtSeiketsuHoji;
    }

}
/**
 * celKansetsuCare のクラスファイル 
 * 
 * @author 自動生成
 */
class celKansetsuCareAttblKijunJikan extends TableCell {
    @JsonProperty("txtKansetsuCare")
    private TextBox txtKansetsuCare;

    @JsonProperty("txtKansetsuCare")
    public TextBox getTxtKansetsuCare() {
        return txtKansetsuCare;
    }

    @JsonProperty("txtKansetsuCare")
    public void setTxtKansetsuCare(TextBox txtKansetsuCare) {
        this.txtKansetsuCare=txtKansetsuCare;
    }

}
/**
 * celBpsdKanren のクラスファイル 
 * 
 * @author 自動生成
 */
class celBpsdKanrenAttblKijunJikan extends TableCell {
    @JsonProperty("txtBpsdKanren")
    private TextBox txtBpsdKanren;

    @JsonProperty("txtBpsdKanren")
    public TextBox getTxtBpsdKanren() {
        return txtBpsdKanren;
    }

    @JsonProperty("txtBpsdKanren")
    public void setTxtBpsdKanren(TextBox txtBpsdKanren) {
        this.txtBpsdKanren=txtBpsdKanren;
    }

}
/**
 * celKinoKunren のクラスファイル 
 * 
 * @author 自動生成
 */
class celKinoKunrenAttblKijunJikan extends TableCell {
    @JsonProperty("txtKinoKunren")
    private TextBox txtKinoKunren;

    @JsonProperty("txtKinoKunren")
    public TextBox getTxtKinoKunren() {
        return txtKinoKunren;
    }

    @JsonProperty("txtKinoKunren")
    public void setTxtKinoKunren(TextBox txtKinoKunren) {
        this.txtKinoKunren=txtKinoKunren;
    }

}
/**
 * celIryoKanren のクラスファイル 
 * 
 * @author 自動生成
 */
class celIryoKanrenAttblKijunJikan extends TableCell {
    @JsonProperty("txtIryoKanren")
    private TextBox txtIryoKanren;

    @JsonProperty("txtIryoKanren")
    public TextBox getTxtIryoKanren() {
        return txtIryoKanren;
    }

    @JsonProperty("txtIryoKanren")
    public void setTxtIryoKanren(TextBox txtIryoKanren) {
        this.txtIryoKanren=txtIryoKanren;
    }

}
/**
 * celNinchishoKasan のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchishoKasanAttblKijunJikan extends TableCell {
    @JsonProperty("txtNinchishoKasan")
    private TextBox txtNinchishoKasan;

    @JsonProperty("txtNinchishoKasan")
    public TextBox getTxtNinchishoKasan() {
        return txtNinchishoKasan;
    }

    @JsonProperty("txtNinchishoKasan")
    public void setTxtNinchishoKasan(TextBox txtNinchishoKasan) {
        this.txtNinchishoKasan=txtNinchishoKasan;
    }

}
