package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
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
 * tblSeikyuKettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSeikyuKetteiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celSeikyuKettei1")
    private celSeikyuKettei1AttblSeikyuKettei celSeikyuKettei1;
    @JsonProperty("celSeikyuKettei2")
    private celSeikyuKettei2AttblSeikyuKettei celSeikyuKettei2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.celSeikyuKettei1.getTxtKetteiYMD();
    }

    @JsonIgnore
    public RadioButton getRadShikyuFushikyuKubun() {
        return this.celSeikyuKettei1.getRadShikyuFushikyuKubun();
    }

    @JsonIgnore
    public TextBoxDate getTxtTesuryoShiharaiYoteiYMD() {
        return this.celSeikyuKettei1.getTxtTesuryoShiharaiYoteiYMD();
    }

    @JsonIgnore
    public Space getSpaSeikyuKettei() {
        return this.celSeikyuKettei2.getSpaSeikyuKettei();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return this.celSeikyuKettei2.getTxtFushikyuRiyu();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelSeikyuKettei1
     * @return celSeikyuKettei1
     */
    @JsonProperty("celSeikyuKettei1")
    private celSeikyuKettei1AttblSeikyuKettei getCelSeikyuKettei1() {
        return celSeikyuKettei1;
    }

    /*
     * setcelSeikyuKettei1
     * @param celSeikyuKettei1 celSeikyuKettei1
     */
    @JsonProperty("celSeikyuKettei1")
    private void setCelSeikyuKettei1(celSeikyuKettei1AttblSeikyuKettei celSeikyuKettei1) {
        this.celSeikyuKettei1 = celSeikyuKettei1;
    }

    /*
     * getcelSeikyuKettei2
     * @return celSeikyuKettei2
     */
    @JsonProperty("celSeikyuKettei2")
    private celSeikyuKettei2AttblSeikyuKettei getCelSeikyuKettei2() {
        return celSeikyuKettei2;
    }

    /*
     * setcelSeikyuKettei2
     * @param celSeikyuKettei2 celSeikyuKettei2
     */
    @JsonProperty("celSeikyuKettei2")
    private void setCelSeikyuKettei2(celSeikyuKettei2AttblSeikyuKettei celSeikyuKettei2) {
        this.celSeikyuKettei2 = celSeikyuKettei2;
    }

    // </editor-fold>
}
/**
 * celSeikyuKettei1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSeikyuKettei1AttblSeikyuKettei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("radShikyuFushikyuKubun")
    private RadioButton radShikyuFushikyuKubun;
    @JsonProperty("txtTesuryoShiharaiYoteiYMD")
    private TextBoxDate txtTesuryoShiharaiYoteiYMD;

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * getradShikyuFushikyuKubun
     * @return radShikyuFushikyuKubun
     */
    @JsonProperty("radShikyuFushikyuKubun")
    public RadioButton getRadShikyuFushikyuKubun() {
        return radShikyuFushikyuKubun;
    }

    /*
     * setradShikyuFushikyuKubun
     * @param radShikyuFushikyuKubun radShikyuFushikyuKubun
     */
    @JsonProperty("radShikyuFushikyuKubun")
    public void setRadShikyuFushikyuKubun(RadioButton radShikyuFushikyuKubun) {
        this.radShikyuFushikyuKubun = radShikyuFushikyuKubun;
    }

    /*
     * gettxtTesuryoShiharaiYoteiYMD
     * @return txtTesuryoShiharaiYoteiYMD
     */
    @JsonProperty("txtTesuryoShiharaiYoteiYMD")
    public TextBoxDate getTxtTesuryoShiharaiYoteiYMD() {
        return txtTesuryoShiharaiYoteiYMD;
    }

    /*
     * settxtTesuryoShiharaiYoteiYMD
     * @param txtTesuryoShiharaiYoteiYMD txtTesuryoShiharaiYoteiYMD
     */
    @JsonProperty("txtTesuryoShiharaiYoteiYMD")
    public void setTxtTesuryoShiharaiYoteiYMD(TextBoxDate txtTesuryoShiharaiYoteiYMD) {
        this.txtTesuryoShiharaiYoteiYMD = txtTesuryoShiharaiYoteiYMD;
    }

    // </editor-fold>
}
/**
 * celSeikyuKettei2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSeikyuKettei2AttblSeikyuKettei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("spaSeikyuKettei")
    private Space spaSeikyuKettei;
    @JsonProperty("txtFushikyuRiyu")
    private TextBoxMultiLine txtFushikyuRiyu;

    /*
     * getspaSeikyuKettei
     * @return spaSeikyuKettei
     */
    @JsonProperty("spaSeikyuKettei")
    public Space getSpaSeikyuKettei() {
        return spaSeikyuKettei;
    }

    /*
     * setspaSeikyuKettei
     * @param spaSeikyuKettei spaSeikyuKettei
     */
    @JsonProperty("spaSeikyuKettei")
    public void setSpaSeikyuKettei(Space spaSeikyuKettei) {
        this.spaSeikyuKettei = spaSeikyuKettei;
    }

    /*
     * gettxtFushikyuRiyu
     * @return txtFushikyuRiyu
     */
    @JsonProperty("txtFushikyuRiyu")
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return txtFushikyuRiyu;
    }

    /*
     * settxtFushikyuRiyu
     * @param txtFushikyuRiyu txtFushikyuRiyu
     */
    @JsonProperty("txtFushikyuRiyu")
    public void setTxtFushikyuRiyu(TextBoxMultiLine txtFushikyuRiyu) {
        this.txtFushikyuRiyu = txtFushikyuRiyu;
    }

    // </editor-fold>
}
