package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblChoshuYuyo のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class tblChoshuYuyoDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celJoho")
    private celJohoAttblChoshuYuyo celJoho;
    @JsonProperty("celKiwarigaku")
    private celKiwarigakuAttblChoshuYuyo celKiwarigaku;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TorikeshiJohoDiv getTorikeshiJoho() {
        return this.celJoho.getTorikeshiJoho();
    }

    @JsonIgnore
    public ShinseiJohoDiv getShinseiJoho() {
        return this.celJoho.getShinseiJoho();
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.celJoho.getKetteiJoho();
    }

    @JsonIgnore
    public KiwarigakuDiv getKiwarigaku() {
        return this.celKiwarigaku.getKiwarigaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelJoho
     * @return celJoho
     */
    @JsonProperty("celJoho")
    private celJohoAttblChoshuYuyo getCelJoho() {
        return celJoho;
    }

    /*
     * setcelJoho
     * @param celJoho celJoho
     */
    @JsonProperty("celJoho")
    private void setCelJoho(celJohoAttblChoshuYuyo celJoho) {
        this.celJoho = celJoho;
    }

    /*
     * getcelKiwarigaku
     * @return celKiwarigaku
     */
    @JsonProperty("celKiwarigaku")
    private celKiwarigakuAttblChoshuYuyo getCelKiwarigaku() {
        return celKiwarigaku;
    }

    /*
     * setcelKiwarigaku
     * @param celKiwarigaku celKiwarigaku
     */
    @JsonProperty("celKiwarigaku")
    private void setCelKiwarigaku(celKiwarigakuAttblChoshuYuyo celKiwarigaku) {
        this.celKiwarigaku = celKiwarigaku;
    }

    // </editor-fold>
}

/**
 * celJoho のクラスファイル
 *
 * @author 自動生成
 */
class celJohoAttblChoshuYuyo extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("TorikeshiJoho")
    private TorikeshiJohoDiv TorikeshiJoho;
    @JsonProperty("ShinseiJoho")
    private ShinseiJohoDiv ShinseiJoho;
    @JsonProperty("KetteiJoho")
    private KetteiJohoDiv KetteiJoho;

    /*
     * getTorikeshiJoho
     * @return TorikeshiJoho
     */
    @JsonProperty("TorikeshiJoho")
    public TorikeshiJohoDiv getTorikeshiJoho() {
        return TorikeshiJoho;
    }

    /*
     * setTorikeshiJoho
     * @param TorikeshiJoho TorikeshiJoho
     */
    @JsonProperty("TorikeshiJoho")
    public void setTorikeshiJoho(TorikeshiJohoDiv TorikeshiJoho) {
        this.TorikeshiJoho = TorikeshiJoho;
    }

    /*
     * getShinseiJoho
     * @return ShinseiJoho
     */
    @JsonProperty("ShinseiJoho")
    public ShinseiJohoDiv getShinseiJoho() {
        return ShinseiJoho;
    }

    /*
     * setShinseiJoho
     * @param ShinseiJoho ShinseiJoho
     */
    @JsonProperty("ShinseiJoho")
    public void setShinseiJoho(ShinseiJohoDiv ShinseiJoho) {
        this.ShinseiJoho = ShinseiJoho;
    }

    /*
     * getKetteiJoho
     * @return KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public KetteiJohoDiv getKetteiJoho() {
        return KetteiJoho;
    }

    /*
     * setKetteiJoho
     * @param KetteiJoho KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public void setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.KetteiJoho = KetteiJoho;
    }

    // </editor-fold>
}

/**
 * celKiwarigaku のクラスファイル
 *
 * @author 自動生成
 */
class celKiwarigakuAttblChoshuYuyo extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("Kiwarigaku")
    private KiwarigakuDiv Kiwarigaku;

    /*
     * getKiwarigaku
     * @return Kiwarigaku
     */
    @JsonProperty("Kiwarigaku")
    public KiwarigakuDiv getKiwarigaku() {
        return Kiwarigaku;
    }

    /*
     * setKiwarigaku
     * @param Kiwarigaku Kiwarigaku
     */
    @JsonProperty("Kiwarigaku")
    public void setKiwarigaku(KiwarigakuDiv Kiwarigaku) {
        this.Kiwarigaku = Kiwarigaku;
    }

    // </editor-fold>
}
