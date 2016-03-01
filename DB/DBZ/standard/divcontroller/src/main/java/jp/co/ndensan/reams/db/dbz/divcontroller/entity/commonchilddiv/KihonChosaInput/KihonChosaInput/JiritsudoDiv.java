package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
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
 * Jiritsudo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JiritsudoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShogaiKoreisha")
    private ShogaiKoreishaDiv ShogaiKoreisha;
    @JsonProperty("NinchishaJiritsudo")
    private NinchishaJiritsudoDiv NinchishaJiritsudo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShogaiKoreisha
     * @return ShogaiKoreisha
     */
    @JsonProperty("ShogaiKoreisha")
    public ShogaiKoreishaDiv getShogaiKoreisha() {
        return ShogaiKoreisha;
    }

    /*
     * setShogaiKoreisha
     * @param ShogaiKoreisha ShogaiKoreisha
     */
    @JsonProperty("ShogaiKoreisha")
    public void setShogaiKoreisha(ShogaiKoreishaDiv ShogaiKoreisha) {
        this.ShogaiKoreisha = ShogaiKoreisha;
    }

    /*
     * getNinchishaJiritsudo
     * @return NinchishaJiritsudo
     */
    @JsonProperty("NinchishaJiritsudo")
    public NinchishaJiritsudoDiv getNinchishaJiritsudo() {
        return NinchishaJiritsudo;
    }

    /*
     * setNinchishaJiritsudo
     * @param NinchishaJiritsudo NinchishaJiritsudo
     */
    @JsonProperty("NinchishaJiritsudo")
    public void setNinchishaJiritsudo(NinchishaJiritsudoDiv NinchishaJiritsudo) {
        this.NinchishaJiritsudo = NinchishaJiritsudo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnShogaiKoreisha() {
        return this.getShogaiKoreisha().getBtnShogaiKoreisha();
    }

    @JsonIgnore
    public void  setBtnShogaiKoreisha(Button btnShogaiKoreisha) {
        this.getShogaiKoreisha().setBtnShogaiKoreisha(btnShogaiKoreisha);
    }

    @JsonIgnore
    public RadioButton getRadShogaiKoreisha() {
        return this.getShogaiKoreisha().getRadShogaiKoreisha();
    }

    @JsonIgnore
    public void  setRadShogaiKoreisha(RadioButton radShogaiKoreisha) {
        this.getShogaiKoreisha().setRadShogaiKoreisha(radShogaiKoreisha);
    }

    @JsonIgnore
    public Button getBtnNinchishaJiritsudo() {
        return this.getNinchishaJiritsudo().getBtnNinchishaJiritsudo();
    }

    @JsonIgnore
    public void  setBtnNinchishaJiritsudo(Button btnNinchishaJiritsudo) {
        this.getNinchishaJiritsudo().setBtnNinchishaJiritsudo(btnNinchishaJiritsudo);
    }

    @JsonIgnore
    public RadioButton getRadNinchishaJiritsudo() {
        return this.getNinchishaJiritsudo().getRadNinchishaJiritsudo();
    }

    @JsonIgnore
    public void  setRadNinchishaJiritsudo(RadioButton radNinchishaJiritsudo) {
        this.getNinchishaJiritsudo().setRadNinchishaJiritsudo(radNinchishaJiritsudo);
    }

    // </editor-fold>
}
