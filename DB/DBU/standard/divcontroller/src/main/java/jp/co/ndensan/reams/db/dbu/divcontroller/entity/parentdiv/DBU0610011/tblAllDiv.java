package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0610011;
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
 * tblAll のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblAllDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("calKara")
    private calKaraAttblAll calKara;
    @JsonProperty("celJukyu")
    private celJukyuAttblAll celJukyu;
    @JsonProperty("celLine")
    private celLineAttblAll celLine;
    @JsonProperty("celLineKara")
    private celLineKaraAttblAll celLineKara;
    @JsonProperty("celFuka")
    private celFukaAttblAll celFuka;
    @JsonProperty("celKara")
    private celKaraAttblAll celKara;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public tblShikakuDiv getTblShikaku() {
        return this.calKara.getTblShikaku();
    }

    @JsonIgnore
    public tblJukyuDiv getTblJukyu() {
        return this.celJukyu.getTblJukyu();
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.celLine.getLin2();
    }

    @JsonIgnore
    public tblFukaDiv getTblFuka() {
        return this.celFuka.getTblFuka();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcalKara
     * @return calKara
     */
    @JsonProperty("calKara")
    private calKaraAttblAll getCalKara() {
        return calKara;
    }

    /*
     * setcalKara
     * @param calKara calKara
     */
    @JsonProperty("calKara")
    private void setCalKara(calKaraAttblAll calKara) {
        this.calKara = calKara;
    }

    /*
     * getcelJukyu
     * @return celJukyu
     */
    @JsonProperty("celJukyu")
    private celJukyuAttblAll getCelJukyu() {
        return celJukyu;
    }

    /*
     * setcelJukyu
     * @param celJukyu celJukyu
     */
    @JsonProperty("celJukyu")
    private void setCelJukyu(celJukyuAttblAll celJukyu) {
        this.celJukyu = celJukyu;
    }

    /*
     * getcelLine
     * @return celLine
     */
    @JsonProperty("celLine")
    private celLineAttblAll getCelLine() {
        return celLine;
    }

    /*
     * setcelLine
     * @param celLine celLine
     */
    @JsonProperty("celLine")
    private void setCelLine(celLineAttblAll celLine) {
        this.celLine = celLine;
    }

    /*
     * getcelLineKara
     * @return celLineKara
     */
    @JsonProperty("celLineKara")
    private celLineKaraAttblAll getCelLineKara() {
        return celLineKara;
    }

    /*
     * setcelLineKara
     * @param celLineKara celLineKara
     */
    @JsonProperty("celLineKara")
    private void setCelLineKara(celLineKaraAttblAll celLineKara) {
        this.celLineKara = celLineKara;
    }

    /*
     * getcelFuka
     * @return celFuka
     */
    @JsonProperty("celFuka")
    private celFukaAttblAll getCelFuka() {
        return celFuka;
    }

    /*
     * setcelFuka
     * @param celFuka celFuka
     */
    @JsonProperty("celFuka")
    private void setCelFuka(celFukaAttblAll celFuka) {
        this.celFuka = celFuka;
    }

    /*
     * getcelKara
     * @return celKara
     */
    @JsonProperty("celKara")
    private celKaraAttblAll getCelKara() {
        return celKara;
    }

    /*
     * setcelKara
     * @param celKara celKara
     */
    @JsonProperty("celKara")
    private void setCelKara(celKaraAttblAll celKara) {
        this.celKara = celKara;
    }

    // </editor-fold>
}
/**
 * calKara のクラスファイル 
 * 
 * @author 自動生成
 */
class calKaraAttblAll extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblShikaku")
    private tblShikakuDiv tblShikaku;

    /*
     * gettblShikaku
     * @return tblShikaku
     */
    @JsonProperty("tblShikaku")
    public tblShikakuDiv getTblShikaku() {
        return tblShikaku;
    }

    /*
     * settblShikaku
     * @param tblShikaku tblShikaku
     */
    @JsonProperty("tblShikaku")
    public void setTblShikaku(tblShikakuDiv tblShikaku) {
        this.tblShikaku = tblShikaku;
    }

    // </editor-fold>
}
/**
 * celJukyu のクラスファイル 
 * 
 * @author 自動生成
 */
class celJukyuAttblAll extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblJukyu")
    private tblJukyuDiv tblJukyu;

    /*
     * gettblJukyu
     * @return tblJukyu
     */
    @JsonProperty("tblJukyu")
    public tblJukyuDiv getTblJukyu() {
        return tblJukyu;
    }

    /*
     * settblJukyu
     * @param tblJukyu tblJukyu
     */
    @JsonProperty("tblJukyu")
    public void setTblJukyu(tblJukyuDiv tblJukyu) {
        this.tblJukyu = tblJukyu;
    }

    // </editor-fold>
}
/**
 * celLine のクラスファイル 
 * 
 * @author 自動生成
 */
class celLineAttblAll extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lin2")
    private HorizontalLine lin2;

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    // </editor-fold>
}
/**
 * celLineKara のクラスファイル 
 * 
 * @author 自動生成
 */
class celLineKaraAttblAll extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    // </editor-fold>
}
/**
 * celFuka のクラスファイル 
 * 
 * @author 自動生成
 */
class celFukaAttblAll extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("tblFuka")
    private tblFukaDiv tblFuka;

    /*
     * gettblFuka
     * @return tblFuka
     */
    @JsonProperty("tblFuka")
    public tblFukaDiv getTblFuka() {
        return tblFuka;
    }

    /*
     * settblFuka
     * @param tblFuka tblFuka
     */
    @JsonProperty("tblFuka")
    public void setTblFuka(tblFukaDiv tblFuka) {
        this.tblFuka = tblFuka;
    }

    // </editor-fold>
}
/**
 * celKara のクラスファイル 
 * 
 * @author 自動生成
 */
class celKaraAttblAll extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    // </editor-fold>
}
