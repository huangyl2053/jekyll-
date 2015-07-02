package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020006;
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
 * SettingDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class SettingDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabSetting")
    private tabSettingDiv tabSetting;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnDelete")
    private Button btnDelete;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabSetting")
    public tabSettingDiv getTabSetting() {
        return tabSetting;
    }

    @JsonProperty("tabSetting")
    public void setTabSetting(tabSettingDiv tabSetting) {
        this.tabSetting=tabSetting;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    @JsonProperty("btnDelete")
    public Button getBtnDelete() {
        return btnDelete;
    }

    @JsonProperty("btnDelete")
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete=btnDelete;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtSetteiYMD() {
        return this.getTabSetting().getTxtSetteiYMD();
    }

    @JsonIgnore
    public TextBox getTxtJikanWaku() {
        return this.getTabSetting().getTxtJikanWaku();
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiJikan() {
        return this.getTabSetting().getTxtKaishiJikan();
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoJikan() {
        return this.getTabSetting().getTxtShuryoJikan();
    }

    @JsonIgnore
    public RadioButton getRadYoyaku() {
        return this.getTabSetting().getRadYoyaku();
    }

    @JsonIgnore
    public TextBox getTxtBiko() {
        return this.getTabSetting().getTxtBiko();
    }

    // </editor-fold>
}
