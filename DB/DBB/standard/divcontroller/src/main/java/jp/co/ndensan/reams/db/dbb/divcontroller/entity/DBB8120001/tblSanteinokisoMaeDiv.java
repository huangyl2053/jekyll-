package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;
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
 * tblSanteinokisoMae のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSanteinokisoMaeDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celMae21")
    private celMae21AttblSanteinokisoMae celMae21;
    @JsonProperty("celMae22")
    private celMae22AttblSanteinokisoMae celMae22;
    @JsonProperty("celMae23")
    private celMae23AttblSanteinokisoMae celMae23;
    @JsonProperty("celMae31")
    private celMae31AttblSanteinokisoMae celMae31;
    @JsonProperty("celMae32")
    private celMae32AttblSanteinokisoMae celMae32;
    @JsonProperty("celMae33")
    private celMae33AttblSanteinokisoMae celMae33;
    @JsonProperty("celMae24")
    private celMae24AttblSanteinokisoMae celMae24;
    @JsonProperty("celMae25")
    private celMae25AttblSanteinokisoMae celMae25;
    @JsonProperty("celMae26")
    private celMae26AttblSanteinokisoMae celMae26;
    @JsonProperty("celMae34")
    private celMae34AttblSanteinokisoMae celMae34;
    @JsonProperty("celMae35")
    private celMae35AttblSanteinokisoMae celMae35;
    @JsonProperty("celMae36")
    private celMae36AttblSanteinokisoMae celMae36;
    @JsonProperty("celMae1")
    private celMae1AttblSanteinokisoMae celMae1;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblKikanMae() {
        return this.celMae21.getLblKikanMae();
    }

    @JsonIgnore
    public Label getLblTsukisuMae() {
        return this.celMae22.getLblTsukisuMae();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiMae() {
        return this.celMae23.getLblHokenryoDankaiMae();
    }

    @JsonIgnore
    public Label getLblKikanMae1() {
        return this.celMae31.getLblKikanMae1();
    }

    @JsonIgnore
    public Label getLblTsukisuMae1() {
        return this.celMae32.getLblTsukisuMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiMae1() {
        return this.celMae33.getLblHokenryoDankaiMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuMae() {
        return this.celMae24.getLblHokenryoritsuMae();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuMae() {
        return this.celMae25.getLblHokenryoSanshutsuGakuMae();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuMae() {
        return this.celMae26.getLblHokenryoGakuMae();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuMae1() {
        return this.celMae34.getLblHokenryoritsuMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuMae1() {
        return this.celMae35.getLblHokenryoSanshutsuGakuMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuMae1() {
        return this.celMae36.getLblHokenryoGakuMae1();
    }

    @JsonIgnore
    public Label getLblSanteinoKisoMae1() {
        return this.celMae1.getLblSanteinoKisoMae1();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celMae21")
    private celMae21AttblSanteinokisoMae getCelMae21() {
        return celMae21;
    }

    @JsonProperty("celMae21")
    private void setCelMae21(celMae21AttblSanteinokisoMae celMae21) {
        this.celMae21=celMae21;
    }

    @JsonProperty("celMae22")
    private celMae22AttblSanteinokisoMae getCelMae22() {
        return celMae22;
    }

    @JsonProperty("celMae22")
    private void setCelMae22(celMae22AttblSanteinokisoMae celMae22) {
        this.celMae22=celMae22;
    }

    @JsonProperty("celMae23")
    private celMae23AttblSanteinokisoMae getCelMae23() {
        return celMae23;
    }

    @JsonProperty("celMae23")
    private void setCelMae23(celMae23AttblSanteinokisoMae celMae23) {
        this.celMae23=celMae23;
    }

    @JsonProperty("celMae31")
    private celMae31AttblSanteinokisoMae getCelMae31() {
        return celMae31;
    }

    @JsonProperty("celMae31")
    private void setCelMae31(celMae31AttblSanteinokisoMae celMae31) {
        this.celMae31=celMae31;
    }

    @JsonProperty("celMae32")
    private celMae32AttblSanteinokisoMae getCelMae32() {
        return celMae32;
    }

    @JsonProperty("celMae32")
    private void setCelMae32(celMae32AttblSanteinokisoMae celMae32) {
        this.celMae32=celMae32;
    }

    @JsonProperty("celMae33")
    private celMae33AttblSanteinokisoMae getCelMae33() {
        return celMae33;
    }

    @JsonProperty("celMae33")
    private void setCelMae33(celMae33AttblSanteinokisoMae celMae33) {
        this.celMae33=celMae33;
    }

    @JsonProperty("celMae24")
    private celMae24AttblSanteinokisoMae getCelMae24() {
        return celMae24;
    }

    @JsonProperty("celMae24")
    private void setCelMae24(celMae24AttblSanteinokisoMae celMae24) {
        this.celMae24=celMae24;
    }

    @JsonProperty("celMae25")
    private celMae25AttblSanteinokisoMae getCelMae25() {
        return celMae25;
    }

    @JsonProperty("celMae25")
    private void setCelMae25(celMae25AttblSanteinokisoMae celMae25) {
        this.celMae25=celMae25;
    }

    @JsonProperty("celMae26")
    private celMae26AttblSanteinokisoMae getCelMae26() {
        return celMae26;
    }

    @JsonProperty("celMae26")
    private void setCelMae26(celMae26AttblSanteinokisoMae celMae26) {
        this.celMae26=celMae26;
    }

    @JsonProperty("celMae34")
    private celMae34AttblSanteinokisoMae getCelMae34() {
        return celMae34;
    }

    @JsonProperty("celMae34")
    private void setCelMae34(celMae34AttblSanteinokisoMae celMae34) {
        this.celMae34=celMae34;
    }

    @JsonProperty("celMae35")
    private celMae35AttblSanteinokisoMae getCelMae35() {
        return celMae35;
    }

    @JsonProperty("celMae35")
    private void setCelMae35(celMae35AttblSanteinokisoMae celMae35) {
        this.celMae35=celMae35;
    }

    @JsonProperty("celMae36")
    private celMae36AttblSanteinokisoMae getCelMae36() {
        return celMae36;
    }

    @JsonProperty("celMae36")
    private void setCelMae36(celMae36AttblSanteinokisoMae celMae36) {
        this.celMae36=celMae36;
    }

    @JsonProperty("celMae1")
    private celMae1AttblSanteinokisoMae getCelMae1() {
        return celMae1;
    }

    @JsonProperty("celMae1")
    private void setCelMae1(celMae1AttblSanteinokisoMae celMae1) {
        this.celMae1=celMae1;
    }

}
/**
 * celMae21 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae21AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblKikanMae")
    private Label lblKikanMae;

    @JsonProperty("lblKikanMae")
    public Label getLblKikanMae() {
        return lblKikanMae;
    }

    @JsonProperty("lblKikanMae")
    public void setLblKikanMae(Label lblKikanMae) {
        this.lblKikanMae=lblKikanMae;
    }

}
/**
 * celMae22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae22AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblTsukisuMae")
    private Label lblTsukisuMae;

    @JsonProperty("lblTsukisuMae")
    public Label getLblTsukisuMae() {
        return lblTsukisuMae;
    }

    @JsonProperty("lblTsukisuMae")
    public void setLblTsukisuMae(Label lblTsukisuMae) {
        this.lblTsukisuMae=lblTsukisuMae;
    }

}
/**
 * celMae23 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae23AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoDankaiMae")
    private Label lblHokenryoDankaiMae;

    @JsonProperty("lblHokenryoDankaiMae")
    public Label getLblHokenryoDankaiMae() {
        return lblHokenryoDankaiMae;
    }

    @JsonProperty("lblHokenryoDankaiMae")
    public void setLblHokenryoDankaiMae(Label lblHokenryoDankaiMae) {
        this.lblHokenryoDankaiMae=lblHokenryoDankaiMae;
    }

}
/**
 * celMae31 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae31AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblKikanMae1")
    private Label lblKikanMae1;

    @JsonProperty("lblKikanMae1")
    public Label getLblKikanMae1() {
        return lblKikanMae1;
    }

    @JsonProperty("lblKikanMae1")
    public void setLblKikanMae1(Label lblKikanMae1) {
        this.lblKikanMae1=lblKikanMae1;
    }

}
/**
 * celMae32 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae32AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblTsukisuMae1")
    private Label lblTsukisuMae1;

    @JsonProperty("lblTsukisuMae1")
    public Label getLblTsukisuMae1() {
        return lblTsukisuMae1;
    }

    @JsonProperty("lblTsukisuMae1")
    public void setLblTsukisuMae1(Label lblTsukisuMae1) {
        this.lblTsukisuMae1=lblTsukisuMae1;
    }

}
/**
 * celMae33 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae33AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoDankaiMae1")
    private Label lblHokenryoDankaiMae1;

    @JsonProperty("lblHokenryoDankaiMae1")
    public Label getLblHokenryoDankaiMae1() {
        return lblHokenryoDankaiMae1;
    }

    @JsonProperty("lblHokenryoDankaiMae1")
    public void setLblHokenryoDankaiMae1(Label lblHokenryoDankaiMae1) {
        this.lblHokenryoDankaiMae1=lblHokenryoDankaiMae1;
    }

}
/**
 * celMae24 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae24AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoritsuMae")
    private Label lblHokenryoritsuMae;

    @JsonProperty("lblHokenryoritsuMae")
    public Label getLblHokenryoritsuMae() {
        return lblHokenryoritsuMae;
    }

    @JsonProperty("lblHokenryoritsuMae")
    public void setLblHokenryoritsuMae(Label lblHokenryoritsuMae) {
        this.lblHokenryoritsuMae=lblHokenryoritsuMae;
    }

}
/**
 * celMae25 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae25AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoSanshutsuGakuMae")
    private Label lblHokenryoSanshutsuGakuMae;

    @JsonProperty("lblHokenryoSanshutsuGakuMae")
    public Label getLblHokenryoSanshutsuGakuMae() {
        return lblHokenryoSanshutsuGakuMae;
    }

    @JsonProperty("lblHokenryoSanshutsuGakuMae")
    public void setLblHokenryoSanshutsuGakuMae(Label lblHokenryoSanshutsuGakuMae) {
        this.lblHokenryoSanshutsuGakuMae=lblHokenryoSanshutsuGakuMae;
    }

}
/**
 * celMae26 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae26AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoGakuMae")
    private Label lblHokenryoGakuMae;

    @JsonProperty("lblHokenryoGakuMae")
    public Label getLblHokenryoGakuMae() {
        return lblHokenryoGakuMae;
    }

    @JsonProperty("lblHokenryoGakuMae")
    public void setLblHokenryoGakuMae(Label lblHokenryoGakuMae) {
        this.lblHokenryoGakuMae=lblHokenryoGakuMae;
    }

}
/**
 * celMae34 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae34AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoritsuMae1")
    private Label lblHokenryoritsuMae1;

    @JsonProperty("lblHokenryoritsuMae1")
    public Label getLblHokenryoritsuMae1() {
        return lblHokenryoritsuMae1;
    }

    @JsonProperty("lblHokenryoritsuMae1")
    public void setLblHokenryoritsuMae1(Label lblHokenryoritsuMae1) {
        this.lblHokenryoritsuMae1=lblHokenryoritsuMae1;
    }

}
/**
 * celMae35 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae35AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoSanshutsuGakuMae1")
    private Label lblHokenryoSanshutsuGakuMae1;

    @JsonProperty("lblHokenryoSanshutsuGakuMae1")
    public Label getLblHokenryoSanshutsuGakuMae1() {
        return lblHokenryoSanshutsuGakuMae1;
    }

    @JsonProperty("lblHokenryoSanshutsuGakuMae1")
    public void setLblHokenryoSanshutsuGakuMae1(Label lblHokenryoSanshutsuGakuMae1) {
        this.lblHokenryoSanshutsuGakuMae1=lblHokenryoSanshutsuGakuMae1;
    }

}
/**
 * celMae36 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae36AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblHokenryoGakuMae1")
    private Label lblHokenryoGakuMae1;

    @JsonProperty("lblHokenryoGakuMae1")
    public Label getLblHokenryoGakuMae1() {
        return lblHokenryoGakuMae1;
    }

    @JsonProperty("lblHokenryoGakuMae1")
    public void setLblHokenryoGakuMae1(Label lblHokenryoGakuMae1) {
        this.lblHokenryoGakuMae1=lblHokenryoGakuMae1;
    }

}
/**
 * celMae1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celMae1AttblSanteinokisoMae extends TableCell {
    @JsonProperty("lblSanteinoKisoMae1")
    private Label lblSanteinoKisoMae1;

    @JsonProperty("lblSanteinoKisoMae1")
    public Label getLblSanteinoKisoMae1() {
        return lblSanteinoKisoMae1;
    }

    @JsonProperty("lblSanteinoKisoMae1")
    public void setLblSanteinoKisoMae1(Label lblSanteinoKisoMae1) {
        this.lblSanteinoKisoMae1=lblSanteinoKisoMae1;
    }

}
