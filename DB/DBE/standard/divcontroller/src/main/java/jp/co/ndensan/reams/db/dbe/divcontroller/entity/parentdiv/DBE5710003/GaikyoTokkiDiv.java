package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GaikyoTokki のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaikyoTokkiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkGaikyoTokki")
    private CheckBoxList chkGaikyoTokki;
    @JsonProperty("radGaikyoTokkiDeleteTarget")
    private RadioButton radGaikyoTokkiDeleteTarget;
    @JsonProperty("GaikyoTokkiMessage1")
    private GaikyoTokkiMessage1Div GaikyoTokkiMessage1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkGaikyoTokki
     * @return chkGaikyoTokki
     */
    @JsonProperty("chkGaikyoTokki")
    public CheckBoxList getChkGaikyoTokki() {
        return chkGaikyoTokki;
    }

    /*
     * setchkGaikyoTokki
     * @param chkGaikyoTokki chkGaikyoTokki
     */
    @JsonProperty("chkGaikyoTokki")
    public void setChkGaikyoTokki(CheckBoxList chkGaikyoTokki) {
        this.chkGaikyoTokki = chkGaikyoTokki;
    }

    /*
     * getradGaikyoTokkiDeleteTarget
     * @return radGaikyoTokkiDeleteTarget
     */
    @JsonProperty("radGaikyoTokkiDeleteTarget")
    public RadioButton getRadGaikyoTokkiDeleteTarget() {
        return radGaikyoTokkiDeleteTarget;
    }

    /*
     * setradGaikyoTokkiDeleteTarget
     * @param radGaikyoTokkiDeleteTarget radGaikyoTokkiDeleteTarget
     */
    @JsonProperty("radGaikyoTokkiDeleteTarget")
    public void setRadGaikyoTokkiDeleteTarget(RadioButton radGaikyoTokkiDeleteTarget) {
        this.radGaikyoTokkiDeleteTarget = radGaikyoTokkiDeleteTarget;
    }

    /*
     * getGaikyoTokkiMessage1
     * @return GaikyoTokkiMessage1
     */
    @JsonProperty("GaikyoTokkiMessage1")
    public GaikyoTokkiMessage1Div getGaikyoTokkiMessage1() {
        return GaikyoTokkiMessage1;
    }

    /*
     * setGaikyoTokkiMessage1
     * @param GaikyoTokkiMessage1 GaikyoTokkiMessage1
     */
    @JsonProperty("GaikyoTokkiMessage1")
    public void setGaikyoTokkiMessage1(GaikyoTokkiMessage1Div GaikyoTokkiMessage1) {
        this.GaikyoTokkiMessage1 = GaikyoTokkiMessage1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblGaikyoTokkiMessage1() {
        return this.getGaikyoTokkiMessage1().getLblGaikyoTokkiMessage1();
    }

    @JsonIgnore
    public void  setLblGaikyoTokkiMessage1(Label lblGaikyoTokkiMessage1) {
        this.getGaikyoTokkiMessage1().setLblGaikyoTokkiMessage1(lblGaikyoTokkiMessage1);
    }

    // </editor-fold>
}
