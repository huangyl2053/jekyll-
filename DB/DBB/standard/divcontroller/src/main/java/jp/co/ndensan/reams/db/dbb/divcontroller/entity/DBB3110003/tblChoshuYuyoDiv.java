package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.KetteiJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.KiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.ShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.TablePanel2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.TorikeshiJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblChoshuYuyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoshuYuyoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TableCell1")
    private TableCell1AttblChoshuYuyo TableCell1;
    @JsonProperty("TableCell2")
    private TableCell2AttblChoshuYuyo TableCell2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TorikeshiJohoDiv getTorikeshiJoho() {
        return this.TableCell1.getTorikeshiJoho();
    }

    @JsonIgnore
    public ShinseiJohoDiv getShinseiJoho() {
        return this.TableCell1.getShinseiJoho();
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.TableCell1.getKetteiJoho();
    }

    @JsonIgnore
    public KiwarigakuDiv getKiwarigaku() {
        return this.TableCell2.getKiwarigaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TableCell1")
    private TableCell1AttblChoshuYuyo getTableCell1() {
        return TableCell1;
    }

    @JsonProperty("TableCell1")
    private void setTableCell1(TableCell1AttblChoshuYuyo TableCell1) {
        this.TableCell1=TableCell1;
    }

    @JsonProperty("TableCell2")
    private TableCell2AttblChoshuYuyo getTableCell2() {
        return TableCell2;
    }

    @JsonProperty("TableCell2")
    private void setTableCell2(TableCell2AttblChoshuYuyo TableCell2) {
        this.TableCell2=TableCell2;
    }

}
/**
 * TableCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell1AttblChoshuYuyo extends TableCell {
    @JsonProperty("TorikeshiJoho")
    private TorikeshiJohoDiv TorikeshiJoho;
    @JsonProperty("ShinseiJoho")
    private ShinseiJohoDiv ShinseiJoho;
    @JsonProperty("KetteiJoho")
    private KetteiJohoDiv KetteiJoho;

    @JsonProperty("TorikeshiJoho")
    public TorikeshiJohoDiv getTorikeshiJoho() {
        return TorikeshiJoho;
    }

    @JsonProperty("TorikeshiJoho")
    public void setTorikeshiJoho(TorikeshiJohoDiv TorikeshiJoho) {
        this.TorikeshiJoho=TorikeshiJoho;
    }

    @JsonProperty("ShinseiJoho")
    public ShinseiJohoDiv getShinseiJoho() {
        return ShinseiJoho;
    }

    @JsonProperty("ShinseiJoho")
    public void setShinseiJoho(ShinseiJohoDiv ShinseiJoho) {
        this.ShinseiJoho=ShinseiJoho;
    }

    @JsonProperty("KetteiJoho")
    public KetteiJohoDiv getKetteiJoho() {
        return KetteiJoho;
    }

    @JsonProperty("KetteiJoho")
    public void setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.KetteiJoho=KetteiJoho;
    }

}
/**
 * TableCell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell2AttblChoshuYuyo extends TableCell {
    @JsonProperty("Kiwarigaku")
    private KiwarigakuDiv Kiwarigaku;

    @JsonProperty("Kiwarigaku")
    public KiwarigakuDiv getKiwarigaku() {
        return Kiwarigaku;
    }

    @JsonProperty("Kiwarigaku")
    public void setKiwarigaku(KiwarigakuDiv Kiwarigaku) {
        this.Kiwarigaku=Kiwarigaku;
    }

}
