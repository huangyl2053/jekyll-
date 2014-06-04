package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.dgShokanShikyuKetteiInfoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuKetteiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiInfoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShokanShikyuKetteiInfoList")
    private DataGrid<dgShokanShikyuKetteiInfoList_Row> dgShokanShikyuKetteiInfoList;
    @JsonProperty("radKetteiShikyuKubun")
    private RadioButton radKetteiShikyuKubun;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("txtKetteiZogenTanisu")
    private TextBoxNum txtKetteiZogenTanisu;
    @JsonProperty("txtKetteiZogenRiyu")
    private TextBox txtKetteiZogenRiyu;
    @JsonProperty("txtKetteiFushikyuRiyu")
    private TextBox txtKetteiFushikyuRiyu;
    @JsonProperty("txtKetteiShiharaiGokei")
    private TextBoxNum txtKetteiShiharaiGokei;
    @JsonProperty("txtKetteiHokenGokei")
    private TextBoxNum txtKetteiHokenGokei;
    @JsonProperty("txtKetteiJikoGokei")
    private TextBoxNum txtKetteiJikoGokei;
    @JsonProperty("txtKetteiSagakuGokei")
    private TextBoxNum txtKetteiSagakuGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShokanShikyuKetteiInfoList")
    public DataGrid<dgShokanShikyuKetteiInfoList_Row> getDgShokanShikyuKetteiInfoList() {
        return dgShokanShikyuKetteiInfoList;
    }

    @JsonProperty("dgShokanShikyuKetteiInfoList")
    public void setDgShokanShikyuKetteiInfoList(DataGrid<dgShokanShikyuKetteiInfoList_Row> dgShokanShikyuKetteiInfoList) {
        this.dgShokanShikyuKetteiInfoList=dgShokanShikyuKetteiInfoList;
    }

    @JsonProperty("radKetteiShikyuKubun")
    public RadioButton getRadKetteiShikyuKubun() {
        return radKetteiShikyuKubun;
    }

    @JsonProperty("radKetteiShikyuKubun")
    public void setRadKetteiShikyuKubun(RadioButton radKetteiShikyuKubun) {
        this.radKetteiShikyuKubun=radKetteiShikyuKubun;
    }

    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD=txtKetteiYMD;
    }

    @JsonProperty("txtKetteiZogenTanisu")
    public TextBoxNum getTxtKetteiZogenTanisu() {
        return txtKetteiZogenTanisu;
    }

    @JsonProperty("txtKetteiZogenTanisu")
    public void setTxtKetteiZogenTanisu(TextBoxNum txtKetteiZogenTanisu) {
        this.txtKetteiZogenTanisu=txtKetteiZogenTanisu;
    }

    @JsonProperty("txtKetteiZogenRiyu")
    public TextBox getTxtKetteiZogenRiyu() {
        return txtKetteiZogenRiyu;
    }

    @JsonProperty("txtKetteiZogenRiyu")
    public void setTxtKetteiZogenRiyu(TextBox txtKetteiZogenRiyu) {
        this.txtKetteiZogenRiyu=txtKetteiZogenRiyu;
    }

    @JsonProperty("txtKetteiFushikyuRiyu")
    public TextBox getTxtKetteiFushikyuRiyu() {
        return txtKetteiFushikyuRiyu;
    }

    @JsonProperty("txtKetteiFushikyuRiyu")
    public void setTxtKetteiFushikyuRiyu(TextBox txtKetteiFushikyuRiyu) {
        this.txtKetteiFushikyuRiyu=txtKetteiFushikyuRiyu;
    }

    @JsonProperty("txtKetteiShiharaiGokei")
    public TextBoxNum getTxtKetteiShiharaiGokei() {
        return txtKetteiShiharaiGokei;
    }

    @JsonProperty("txtKetteiShiharaiGokei")
    public void setTxtKetteiShiharaiGokei(TextBoxNum txtKetteiShiharaiGokei) {
        this.txtKetteiShiharaiGokei=txtKetteiShiharaiGokei;
    }

    @JsonProperty("txtKetteiHokenGokei")
    public TextBoxNum getTxtKetteiHokenGokei() {
        return txtKetteiHokenGokei;
    }

    @JsonProperty("txtKetteiHokenGokei")
    public void setTxtKetteiHokenGokei(TextBoxNum txtKetteiHokenGokei) {
        this.txtKetteiHokenGokei=txtKetteiHokenGokei;
    }

    @JsonProperty("txtKetteiJikoGokei")
    public TextBoxNum getTxtKetteiJikoGokei() {
        return txtKetteiJikoGokei;
    }

    @JsonProperty("txtKetteiJikoGokei")
    public void setTxtKetteiJikoGokei(TextBoxNum txtKetteiJikoGokei) {
        this.txtKetteiJikoGokei=txtKetteiJikoGokei;
    }

    @JsonProperty("txtKetteiSagakuGokei")
    public TextBoxNum getTxtKetteiSagakuGokei() {
        return txtKetteiSagakuGokei;
    }

    @JsonProperty("txtKetteiSagakuGokei")
    public void setTxtKetteiSagakuGokei(TextBoxNum txtKetteiSagakuGokei) {
        this.txtKetteiSagakuGokei=txtKetteiSagakuGokei;
    }

}
