package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001;
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
 * tblTainoKeikoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTainoKeikokuDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel0101")
    private cel0101AttblTainoKeikoku cel0101;
    @JsonProperty("cel0201")
    private cel0201AttblTainoKeikoku cel0201;
    @JsonProperty("cel0301")
    private cel0301AttblTainoKeikoku cel0301;
    @JsonProperty("cel0401")
    private cel0401AttblTainoKeikoku cel0401;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTitle() {
        return this.cel0101.getLblTitle();
    }

    @JsonIgnore
    public Label getLblKeikokuSetsumei() {
        return this.cel0201.getLblKeikokuSetsumei();
    }

    @JsonIgnore
    public tblShiharaiHohoDiv getTblShiharaiHoho() {
        return this.cel0301.getTblShiharaiHoho();
    }

    @JsonIgnore
    public Label getLblShiharaiHohoTainoKikanSetsumei() {
        return this.cel0301.getLblShiharaiHohoTainoKikanSetsumei();
    }

    @JsonIgnore
    public tblKyufugakuGengakuDiv getTblKyufugakuGengaku() {
        return this.cel0401.getTblKyufugakuGengaku();
    }

    @JsonIgnore
    public tblKyufugakuGengaku2Div getTblKyufugakuGengaku2() {
        return this.cel0401.getTblKyufugakuGengaku2();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcel0101
     * @return cel0101
     */
    @JsonProperty("cel0101")
    private cel0101AttblTainoKeikoku getCel0101() {
        return cel0101;
    }

    /*
     * setcel0101
     * @param cel0101 cel0101
     */
    @JsonProperty("cel0101")
    private void setCel0101(cel0101AttblTainoKeikoku cel0101) {
        this.cel0101 = cel0101;
    }

    /*
     * getcel0201
     * @return cel0201
     */
    @JsonProperty("cel0201")
    private cel0201AttblTainoKeikoku getCel0201() {
        return cel0201;
    }

    /*
     * setcel0201
     * @param cel0201 cel0201
     */
    @JsonProperty("cel0201")
    private void setCel0201(cel0201AttblTainoKeikoku cel0201) {
        this.cel0201 = cel0201;
    }

    /*
     * getcel0301
     * @return cel0301
     */
    @JsonProperty("cel0301")
    private cel0301AttblTainoKeikoku getCel0301() {
        return cel0301;
    }

    /*
     * setcel0301
     * @param cel0301 cel0301
     */
    @JsonProperty("cel0301")
    private void setCel0301(cel0301AttblTainoKeikoku cel0301) {
        this.cel0301 = cel0301;
    }

    /*
     * getcel0401
     * @return cel0401
     */
    @JsonProperty("cel0401")
    private cel0401AttblTainoKeikoku getCel0401() {
        return cel0401;
    }

    /*
     * setcel0401
     * @param cel0401 cel0401
     */
    @JsonProperty("cel0401")
    private void setCel0401(cel0401AttblTainoKeikoku cel0401) {
        this.cel0401 = cel0401;
    }

    // </editor-fold>
}
/**
 * cel0101 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel0101AttblTainoKeikoku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblTitle")
    private Label lblTitle;

    /*
     * getlblTitle
     * @return lblTitle
     */
    @JsonProperty("lblTitle")
    public Label getLblTitle() {
        return lblTitle;
    }

    /*
     * setlblTitle
     * @param lblTitle lblTitle
     */
    @JsonProperty("lblTitle")
    public void setLblTitle(Label lblTitle) {
        this.lblTitle = lblTitle;
    }

    // </editor-fold>
}
/**
 * cel0201 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel0201AttblTainoKeikoku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblKeikokuSetsumei")
    private Label lblKeikokuSetsumei;

    /*
     * getlblKeikokuSetsumei
     * @return lblKeikokuSetsumei
     */
    @JsonProperty("lblKeikokuSetsumei")
    public Label getLblKeikokuSetsumei() {
        return lblKeikokuSetsumei;
    }

    /*
     * setlblKeikokuSetsumei
     * @param lblKeikokuSetsumei lblKeikokuSetsumei
     */
    @JsonProperty("lblKeikokuSetsumei")
    public void setLblKeikokuSetsumei(Label lblKeikokuSetsumei) {
        this.lblKeikokuSetsumei = lblKeikokuSetsumei;
    }

    // </editor-fold>
}
/**
 * cel0301 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel0301AttblTainoKeikoku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("tblShiharaiHoho")
    private tblShiharaiHohoDiv tblShiharaiHoho;
    @JsonProperty("lblShiharaiHohoTainoKikanSetsumei")
    private Label lblShiharaiHohoTainoKikanSetsumei;

    /*
     * gettblShiharaiHoho
     * @return tblShiharaiHoho
     */
    @JsonProperty("tblShiharaiHoho")
    public tblShiharaiHohoDiv getTblShiharaiHoho() {
        return tblShiharaiHoho;
    }

    /*
     * settblShiharaiHoho
     * @param tblShiharaiHoho tblShiharaiHoho
     */
    @JsonProperty("tblShiharaiHoho")
    public void setTblShiharaiHoho(tblShiharaiHohoDiv tblShiharaiHoho) {
        this.tblShiharaiHoho = tblShiharaiHoho;
    }

    /*
     * getlblShiharaiHohoTainoKikanSetsumei
     * @return lblShiharaiHohoTainoKikanSetsumei
     */
    @JsonProperty("lblShiharaiHohoTainoKikanSetsumei")
    public Label getLblShiharaiHohoTainoKikanSetsumei() {
        return lblShiharaiHohoTainoKikanSetsumei;
    }

    /*
     * setlblShiharaiHohoTainoKikanSetsumei
     * @param lblShiharaiHohoTainoKikanSetsumei lblShiharaiHohoTainoKikanSetsumei
     */
    @JsonProperty("lblShiharaiHohoTainoKikanSetsumei")
    public void setLblShiharaiHohoTainoKikanSetsumei(Label lblShiharaiHohoTainoKikanSetsumei) {
        this.lblShiharaiHohoTainoKikanSetsumei = lblShiharaiHohoTainoKikanSetsumei;
    }

    // </editor-fold>
}
/**
 * cel0401 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel0401AttblTainoKeikoku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("tblKyufugakuGengaku")
    private tblKyufugakuGengakuDiv tblKyufugakuGengaku;
    @JsonProperty("tblKyufugakuGengaku2")
    private tblKyufugakuGengaku2Div tblKyufugakuGengaku2;

    /*
     * gettblKyufugakuGengaku
     * @return tblKyufugakuGengaku
     */
    @JsonProperty("tblKyufugakuGengaku")
    public tblKyufugakuGengakuDiv getTblKyufugakuGengaku() {
        return tblKyufugakuGengaku;
    }

    /*
     * settblKyufugakuGengaku
     * @param tblKyufugakuGengaku tblKyufugakuGengaku
     */
    @JsonProperty("tblKyufugakuGengaku")
    public void setTblKyufugakuGengaku(tblKyufugakuGengakuDiv tblKyufugakuGengaku) {
        this.tblKyufugakuGengaku = tblKyufugakuGengaku;
    }

    /*
     * gettblKyufugakuGengaku2
     * @return tblKyufugakuGengaku2
     */
    @JsonProperty("tblKyufugakuGengaku2")
    public tblKyufugakuGengaku2Div getTblKyufugakuGengaku2() {
        return tblKyufugakuGengaku2;
    }

    /*
     * settblKyufugakuGengaku2
     * @param tblKyufugakuGengaku2 tblKyufugakuGengaku2
     */
    @JsonProperty("tblKyufugakuGengaku2")
    public void setTblKyufugakuGengaku2(tblKyufugakuGengaku2Div tblKyufugakuGengaku2) {
        this.tblKyufugakuGengaku2 = tblKyufugakuGengaku2;
    }

    // </editor-fold>
}
