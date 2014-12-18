package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.Panel3Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.TablePanel1Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaiItaku1Div;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaiShokuhiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaiTakaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.kaikyuheruDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * kaiPanel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class kaiPanel1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TablePanel1")
    private TablePanel1Div TablePanel1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TablePanel1")
    public TablePanel1Div getTablePanel1() {
        return TablePanel1;
    }

    @JsonProperty("TablePanel1")
    public void setTablePanel1(TablePanel1Div TablePanel1) {
        this.TablePanel1=TablePanel1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public kaikyuheruDiv getKaikyuheru() {
        return this.getTablePanel1().getKaikyuheru();
    }

    @JsonIgnore
    public RadioButton getRadioButton1() {
        return this.getTablePanel1().getKaikyuheru().getRadioButton1();
    }

    @JsonIgnore
    public void  setRadioButton1(RadioButton RadioButton1) {
        this.getTablePanel1().getKaikyuheru().setRadioButton1(RadioButton1);
    }

    @JsonIgnore
    public TextBox getTextBox16() {
        return this.getTablePanel1().getKaikyuheru().getTextBox16();
    }

    @JsonIgnore
    public void  setTextBox16(TextBox TextBox16) {
        this.getTablePanel1().getKaikyuheru().setTextBox16(TextBox16);
    }

    @JsonIgnore
    public kaiItaku1Div getKaiItaku1() {
        return this.getTablePanel1().getKaiItaku1();
    }

    @JsonIgnore
    public Panel3Div getPanel3() {
        return this.getTablePanel1().getPanel3();
    }

    @JsonIgnore
    public kaiShokuhiDiv getKaiShokuhi() {
        return this.getTablePanel1().getKaiShokuhi();
    }

    @JsonIgnore
    public kaiTakaDiv getKaiTaka() {
        return this.getTablePanel1().getKaiTaka();
    }

}
