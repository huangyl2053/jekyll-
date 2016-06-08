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
 * tblKyufugakuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyufugakuGengakuDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celGengaku0101")
    private celGengaku0101AttblKyufugakuGengaku celGengaku0101;
    @JsonProperty("celGengaku0201")
    private celGengaku0201AttblKyufugakuGengaku celGengaku0201;
    @JsonProperty("celGengaku0301")
    private celGengaku0301AttblKyufugakuGengaku celGengaku0301;
    @JsonProperty("celGengaku0302")
    private celGengaku0302AttblKyufugakuGengaku celGengaku0302;
    @JsonProperty("celGengaku0401")
    private celGengaku0401AttblKyufugakuGengaku celGengaku0401;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblGengaku() {
        return this.celGengaku0101.getLblGengaku();
    }

    @JsonIgnore
    public Label getLblGengakuTainoHanteiJoken() {
        return this.celGengaku0201.getLblGengakuTainoHanteiJoken();
    }

    @JsonIgnore
    public Label getLblGengakuTainohanteiKijunbiLabel() {
        return this.celGengaku0301.getLblGengakuTainohanteiKijunbiLabel();
    }

    @JsonIgnore
    public Label getLblGengakuTainohanteiKijunbi() {
        return this.celGengaku0302.getLblGengakuTainohanteiKijunbi();
    }

    @JsonIgnore
    public Label getLblGengakuTainoHanteiKekka() {
        return this.celGengaku0401.getLblGengakuTainoHanteiKekka();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelGengaku0101
     * @return celGengaku0101
     */
    @JsonProperty("celGengaku0101")
    private celGengaku0101AttblKyufugakuGengaku getCelGengaku0101() {
        return celGengaku0101;
    }

    /*
     * setcelGengaku0101
     * @param celGengaku0101 celGengaku0101
     */
    @JsonProperty("celGengaku0101")
    private void setCelGengaku0101(celGengaku0101AttblKyufugakuGengaku celGengaku0101) {
        this.celGengaku0101 = celGengaku0101;
    }

    /*
     * getcelGengaku0201
     * @return celGengaku0201
     */
    @JsonProperty("celGengaku0201")
    private celGengaku0201AttblKyufugakuGengaku getCelGengaku0201() {
        return celGengaku0201;
    }

    /*
     * setcelGengaku0201
     * @param celGengaku0201 celGengaku0201
     */
    @JsonProperty("celGengaku0201")
    private void setCelGengaku0201(celGengaku0201AttblKyufugakuGengaku celGengaku0201) {
        this.celGengaku0201 = celGengaku0201;
    }

    /*
     * getcelGengaku0301
     * @return celGengaku0301
     */
    @JsonProperty("celGengaku0301")
    private celGengaku0301AttblKyufugakuGengaku getCelGengaku0301() {
        return celGengaku0301;
    }

    /*
     * setcelGengaku0301
     * @param celGengaku0301 celGengaku0301
     */
    @JsonProperty("celGengaku0301")
    private void setCelGengaku0301(celGengaku0301AttblKyufugakuGengaku celGengaku0301) {
        this.celGengaku0301 = celGengaku0301;
    }

    /*
     * getcelGengaku0302
     * @return celGengaku0302
     */
    @JsonProperty("celGengaku0302")
    private celGengaku0302AttblKyufugakuGengaku getCelGengaku0302() {
        return celGengaku0302;
    }

    /*
     * setcelGengaku0302
     * @param celGengaku0302 celGengaku0302
     */
    @JsonProperty("celGengaku0302")
    private void setCelGengaku0302(celGengaku0302AttblKyufugakuGengaku celGengaku0302) {
        this.celGengaku0302 = celGengaku0302;
    }

    /*
     * getcelGengaku0401
     * @return celGengaku0401
     */
    @JsonProperty("celGengaku0401")
    private celGengaku0401AttblKyufugakuGengaku getCelGengaku0401() {
        return celGengaku0401;
    }

    /*
     * setcelGengaku0401
     * @param celGengaku0401 celGengaku0401
     */
    @JsonProperty("celGengaku0401")
    private void setCelGengaku0401(celGengaku0401AttblKyufugakuGengaku celGengaku0401) {
        this.celGengaku0401 = celGengaku0401;
    }

    // </editor-fold>
}
/**
 * celGengaku0101 のクラスファイル 
 * 
 * @author 自動生成
 */
class celGengaku0101AttblKyufugakuGengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblGengaku")
    private Label lblGengaku;

    /*
     * getlblGengaku
     * @return lblGengaku
     */
    @JsonProperty("lblGengaku")
    public Label getLblGengaku() {
        return lblGengaku;
    }

    /*
     * setlblGengaku
     * @param lblGengaku lblGengaku
     */
    @JsonProperty("lblGengaku")
    public void setLblGengaku(Label lblGengaku) {
        this.lblGengaku = lblGengaku;
    }

    // </editor-fold>
}
/**
 * celGengaku0201 のクラスファイル 
 * 
 * @author 自動生成
 */
class celGengaku0201AttblKyufugakuGengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblGengakuTainoHanteiJoken")
    private Label lblGengakuTainoHanteiJoken;

    /*
     * getlblGengakuTainoHanteiJoken
     * @return lblGengakuTainoHanteiJoken
     */
    @JsonProperty("lblGengakuTainoHanteiJoken")
    public Label getLblGengakuTainoHanteiJoken() {
        return lblGengakuTainoHanteiJoken;
    }

    /*
     * setlblGengakuTainoHanteiJoken
     * @param lblGengakuTainoHanteiJoken lblGengakuTainoHanteiJoken
     */
    @JsonProperty("lblGengakuTainoHanteiJoken")
    public void setLblGengakuTainoHanteiJoken(Label lblGengakuTainoHanteiJoken) {
        this.lblGengakuTainoHanteiJoken = lblGengakuTainoHanteiJoken;
    }

    // </editor-fold>
}
/**
 * celGengaku0301 のクラスファイル 
 * 
 * @author 自動生成
 */
class celGengaku0301AttblKyufugakuGengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblGengakuTainohanteiKijunbiLabel")
    private Label lblGengakuTainohanteiKijunbiLabel;

    /*
     * getlblGengakuTainohanteiKijunbiLabel
     * @return lblGengakuTainohanteiKijunbiLabel
     */
    @JsonProperty("lblGengakuTainohanteiKijunbiLabel")
    public Label getLblGengakuTainohanteiKijunbiLabel() {
        return lblGengakuTainohanteiKijunbiLabel;
    }

    /*
     * setlblGengakuTainohanteiKijunbiLabel
     * @param lblGengakuTainohanteiKijunbiLabel lblGengakuTainohanteiKijunbiLabel
     */
    @JsonProperty("lblGengakuTainohanteiKijunbiLabel")
    public void setLblGengakuTainohanteiKijunbiLabel(Label lblGengakuTainohanteiKijunbiLabel) {
        this.lblGengakuTainohanteiKijunbiLabel = lblGengakuTainohanteiKijunbiLabel;
    }

    // </editor-fold>
}
/**
 * celGengaku0302 のクラスファイル 
 * 
 * @author 自動生成
 */
class celGengaku0302AttblKyufugakuGengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblGengakuTainohanteiKijunbi")
    private Label lblGengakuTainohanteiKijunbi;

    /*
     * getlblGengakuTainohanteiKijunbi
     * @return lblGengakuTainohanteiKijunbi
     */
    @JsonProperty("lblGengakuTainohanteiKijunbi")
    public Label getLblGengakuTainohanteiKijunbi() {
        return lblGengakuTainohanteiKijunbi;
    }

    /*
     * setlblGengakuTainohanteiKijunbi
     * @param lblGengakuTainohanteiKijunbi lblGengakuTainohanteiKijunbi
     */
    @JsonProperty("lblGengakuTainohanteiKijunbi")
    public void setLblGengakuTainohanteiKijunbi(Label lblGengakuTainohanteiKijunbi) {
        this.lblGengakuTainohanteiKijunbi = lblGengakuTainohanteiKijunbi;
    }

    // </editor-fold>
}
/**
 * celGengaku0401 のクラスファイル 
 * 
 * @author 自動生成
 */
class celGengaku0401AttblKyufugakuGengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblGengakuTainoHanteiKekka")
    private Label lblGengakuTainoHanteiKekka;

    /*
     * getlblGengakuTainoHanteiKekka
     * @return lblGengakuTainoHanteiKekka
     */
    @JsonProperty("lblGengakuTainoHanteiKekka")
    public Label getLblGengakuTainoHanteiKekka() {
        return lblGengakuTainoHanteiKekka;
    }

    /*
     * setlblGengakuTainoHanteiKekka
     * @param lblGengakuTainoHanteiKekka lblGengakuTainoHanteiKekka
     */
    @JsonProperty("lblGengakuTainoHanteiKekka")
    public void setLblGengakuTainoHanteiKekka(Label lblGengakuTainoHanteiKekka) {
        this.lblGengakuTainoHanteiKekka = lblGengakuTainoHanteiKekka;
    }

    // </editor-fold>
}
