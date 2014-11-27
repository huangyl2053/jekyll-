package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.Panel3Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaiItaku1Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaiShokuhiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaiTakaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaikyuheruDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TablePanel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class TablePanel1Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TableCell25")
    private TableCell25AtTablePanel1 TableCell25;
    @JsonProperty("TableCell26")
    private TableCell26AtTablePanel1 TableCell26;
    @JsonProperty("TableCell1")
    private TableCell1AtTablePanel1 TableCell1;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public kaikyuheruDiv getKaikyuheru() {
        return this.TableCell25.getKaikyuheru();
    }

    @JsonIgnore
    public kaiItaku1Div getKaiItaku1() {
        return this.TableCell25.getKaiItaku1();
    }

    @JsonIgnore
    public Panel3Div getPanel3() {
        return this.TableCell26.getPanel3();
    }

    @JsonIgnore
    public kaiShokuhiDiv getKaiShokuhi() {
        return this.TableCell1.getKaiShokuhi();
    }

    @JsonIgnore
    public kaiTakaDiv getKaiTaka() {
        return this.TableCell1.getKaiTaka();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TableCell25")
    private TableCell25AtTablePanel1 getTableCell25() {
        return TableCell25;
    }

    @JsonProperty("TableCell25")
    private void setTableCell25(TableCell25AtTablePanel1 TableCell25) {
        this.TableCell25=TableCell25;
    }

    @JsonProperty("TableCell26")
    private TableCell26AtTablePanel1 getTableCell26() {
        return TableCell26;
    }

    @JsonProperty("TableCell26")
    private void setTableCell26(TableCell26AtTablePanel1 TableCell26) {
        this.TableCell26=TableCell26;
    }

    @JsonProperty("TableCell1")
    private TableCell1AtTablePanel1 getTableCell1() {
        return TableCell1;
    }

    @JsonProperty("TableCell1")
    private void setTableCell1(TableCell1AtTablePanel1 TableCell1) {
        this.TableCell1=TableCell1;
    }

}
/**
 * TableCell25 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell25AtTablePanel1 extends TableCell {
    @JsonProperty("kaikyuheru")
    private kaikyuheruDiv kaikyuheru;
    @JsonProperty("kaiItaku1")
    private kaiItaku1Div kaiItaku1;

    @JsonProperty("kaikyuheru")
    public kaikyuheruDiv getKaikyuheru() {
        return kaikyuheru;
    }

    @JsonProperty("kaikyuheru")
    public void setKaikyuheru(kaikyuheruDiv kaikyuheru) {
        this.kaikyuheru=kaikyuheru;
    }

    @JsonProperty("kaiItaku1")
    public kaiItaku1Div getKaiItaku1() {
        return kaiItaku1;
    }

    @JsonProperty("kaiItaku1")
    public void setKaiItaku1(kaiItaku1Div kaiItaku1) {
        this.kaiItaku1=kaiItaku1;
    }

}
/**
 * TableCell26 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell26AtTablePanel1 extends TableCell {
    @JsonProperty("Panel3")
    private Panel3Div Panel3;

    @JsonProperty("Panel3")
    public Panel3Div getPanel3() {
        return Panel3;
    }

    @JsonProperty("Panel3")
    public void setPanel3(Panel3Div Panel3) {
        this.Panel3=Panel3;
    }

}
/**
 * TableCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell1AtTablePanel1 extends TableCell {
    @JsonProperty("kaiShokuhi")
    private kaiShokuhiDiv kaiShokuhi;
    @JsonProperty("kaiTaka")
    private kaiTakaDiv kaiTaka;

    @JsonProperty("kaiShokuhi")
    public kaiShokuhiDiv getKaiShokuhi() {
        return kaiShokuhi;
    }

    @JsonProperty("kaiShokuhi")
    public void setKaiShokuhi(kaiShokuhiDiv kaiShokuhi) {
        this.kaiShokuhi=kaiShokuhi;
    }

    @JsonProperty("kaiTaka")
    public kaiTakaDiv getKaiTaka() {
        return kaiTaka;
    }

    @JsonProperty("kaiTaka")
    public void setKaiTaka(kaiTakaDiv kaiTaka) {
        this.kaiTaka=kaiTaka;
    }

}
