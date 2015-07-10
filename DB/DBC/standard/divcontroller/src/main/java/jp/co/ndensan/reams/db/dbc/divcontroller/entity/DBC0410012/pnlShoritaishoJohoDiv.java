package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012.KakuninJikoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * pnlShoritaishoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlShoritaishoJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShoritaishoJobo")
    private Label lblShoritaishoJobo;
    @JsonProperty("DogetsuKagobun")
    private CheckBoxList DogetsuKagobun;
    @JsonProperty("Tsujobun")
    private CheckBoxList Tsujobun;
    @JsonProperty("KakuninJiko")
    private KakuninJikoDiv KakuninJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShoritaishoJobo")
    public Label getLblShoritaishoJobo() {
        return lblShoritaishoJobo;
    }

    @JsonProperty("lblShoritaishoJobo")
    public void setLblShoritaishoJobo(Label lblShoritaishoJobo) {
        this.lblShoritaishoJobo=lblShoritaishoJobo;
    }

    @JsonProperty("DogetsuKagobun")
    public CheckBoxList getDogetsuKagobun() {
        return DogetsuKagobun;
    }

    @JsonProperty("DogetsuKagobun")
    public void setDogetsuKagobun(CheckBoxList DogetsuKagobun) {
        this.DogetsuKagobun=DogetsuKagobun;
    }

    @JsonProperty("Tsujobun")
    public CheckBoxList getTsujobun() {
        return Tsujobun;
    }

    @JsonProperty("Tsujobun")
    public void setTsujobun(CheckBoxList Tsujobun) {
        this.Tsujobun=Tsujobun;
    }

    @JsonProperty("KakuninJiko")
    public KakuninJikoDiv getKakuninJiko() {
        return KakuninJiko;
    }

    @JsonProperty("KakuninJiko")
    public void setKakuninJiko(KakuninJikoDiv KakuninJiko) {
        this.KakuninJiko=KakuninJiko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKakuninJiko1() {
        return this.getKakuninJiko().getLblKakuninJiko1();
    }

    @JsonIgnore
    public void  setLblKakuninJiko1(Label lblKakuninJiko1) {
        this.getKakuninJiko().setLblKakuninJiko1(lblKakuninJiko1);
    }

    @JsonIgnore
    public Label getLblKakuninJiko2() {
        return this.getKakuninJiko().getLblKakuninJiko2();
    }

    @JsonIgnore
    public void  setLblKakuninJiko2(Label lblKakuninJiko2) {
        this.getKakuninJiko().setLblKakuninJiko2(lblKakuninJiko2);
    }

    @JsonIgnore
    public Label getLblKakuninJiko3() {
        return this.getKakuninJiko().getLblKakuninJiko3();
    }

    @JsonIgnore
    public void  setLblKakuninJiko3(Label lblKakuninJiko3) {
        this.getKakuninJiko().setLblKakuninJiko3(lblKakuninJiko3);
    }

}
