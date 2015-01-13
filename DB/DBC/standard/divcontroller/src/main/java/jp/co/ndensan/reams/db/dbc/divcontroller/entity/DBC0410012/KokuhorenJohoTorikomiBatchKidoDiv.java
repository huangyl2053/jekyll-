package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012.KakuninJikoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012.pnlChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012.pnlShoritaishoJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012.pnlShutsuryokuJunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KokuhorenJohoTorikomiBatchKido のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuhorenJohoTorikomiBatchKidoDiv extends PanelBatchParameter {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlChushutsuJoken")
    private pnlChushutsuJokenDiv pnlChushutsuJoken;
    @JsonProperty("pnlShoritaishoJoho")
    private pnlShoritaishoJohoDiv pnlShoritaishoJoho;
    @JsonProperty("pnlShutsuryokuJun")
    private pnlShutsuryokuJunDiv pnlShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("pnlChushutsuJoken")
    public pnlChushutsuJokenDiv getPnlChushutsuJoken() {
        return pnlChushutsuJoken;
    }

    @JsonProperty("pnlChushutsuJoken")
    public void setPnlChushutsuJoken(pnlChushutsuJokenDiv pnlChushutsuJoken) {
        this.pnlChushutsuJoken=pnlChushutsuJoken;
    }

    @JsonProperty("pnlShoritaishoJoho")
    public pnlShoritaishoJohoDiv getPnlShoritaishoJoho() {
        return pnlShoritaishoJoho;
    }

    @JsonProperty("pnlShoritaishoJoho")
    public void setPnlShoritaishoJoho(pnlShoritaishoJohoDiv pnlShoritaishoJoho) {
        this.pnlShoritaishoJoho=pnlShoritaishoJoho;
    }

    @JsonProperty("pnlShutsuryokuJun")
    public pnlShutsuryokuJunDiv getPnlShutsuryokuJun() {
        return pnlShutsuryokuJun;
    }

    @JsonProperty("pnlShutsuryokuJun")
    public void setPnlShutsuryokuJun(pnlShutsuryokuJunDiv pnlShutsuryokuJun) {
        this.pnlShutsuryokuJun=pnlShutsuryokuJun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChushutsuJoken() {
        return this.getPnlChushutsuJoken().getLblChushutsuJoken();
    }

    @JsonIgnore
    public void  setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.getPnlChushutsuJoken().setLblChushutsuJoken(lblChushutsuJoken);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriJoken() {
        return this.getPnlChushutsuJoken().getTxtShoriJoken();
    }

    @JsonIgnore
    public void  setTxtShoriJoken(TextBoxDate txtShoriJoken) {
        this.getPnlChushutsuJoken().setTxtShoriJoken(txtShoriJoken);
    }

    @JsonIgnore
    public TextBox getTxtSaishoriKubun() {
        return this.getPnlChushutsuJoken().getTxtSaishoriKubun();
    }

    @JsonIgnore
    public void  setTxtSaishoriKubun(TextBox txtSaishoriKubun) {
        this.getPnlChushutsuJoken().setTxtSaishoriKubun(txtSaishoriKubun);
    }

    @JsonIgnore
    public TextBox getTxtKokanShikibetsuNo() {
        return this.getPnlChushutsuJoken().getTxtKokanShikibetsuNo();
    }

    @JsonIgnore
    public void  setTxtKokanShikibetsuNo(TextBox txtKokanShikibetsuNo) {
        this.getPnlChushutsuJoken().setTxtKokanShikibetsuNo(txtKokanShikibetsuNo);
    }

    @JsonIgnore
    public Label getLblShoritaishoJobo() {
        return this.getPnlShoritaishoJoho().getLblShoritaishoJobo();
    }

    @JsonIgnore
    public void  setLblShoritaishoJobo(Label lblShoritaishoJobo) {
        this.getPnlShoritaishoJoho().setLblShoritaishoJobo(lblShoritaishoJobo);
    }

    @JsonIgnore
    public CheckBoxList getDogetsuKagobun() {
        return this.getPnlShoritaishoJoho().getDogetsuKagobun();
    }

    @JsonIgnore
    public void  setDogetsuKagobun(CheckBoxList DogetsuKagobun) {
        this.getPnlShoritaishoJoho().setDogetsuKagobun(DogetsuKagobun);
    }

    @JsonIgnore
    public CheckBoxList getTsujobun() {
        return this.getPnlShoritaishoJoho().getTsujobun();
    }

    @JsonIgnore
    public void  setTsujobun(CheckBoxList Tsujobun) {
        this.getPnlShoritaishoJoho().setTsujobun(Tsujobun);
    }

    @JsonIgnore
    public KakuninJikoDiv getKakuninJiko() {
        return this.getPnlShoritaishoJoho().getKakuninJiko();
    }

    @JsonIgnore
    public void  setKakuninJiko(KakuninJikoDiv KakuninJiko) {
        this.getPnlShoritaishoJoho().setKakuninJiko(KakuninJiko);
    }

    @JsonIgnore
    public Label getLblKakuninJiko1() {
        return this.getPnlShoritaishoJoho().getKakuninJiko().getLblKakuninJiko1();
    }

    @JsonIgnore
    public void  setLblKakuninJiko1(Label lblKakuninJiko1) {
        this.getPnlShoritaishoJoho().getKakuninJiko().setLblKakuninJiko1(lblKakuninJiko1);
    }

    @JsonIgnore
    public Label getLblKakuninJiko2() {
        return this.getPnlShoritaishoJoho().getKakuninJiko().getLblKakuninJiko2();
    }

    @JsonIgnore
    public void  setLblKakuninJiko2(Label lblKakuninJiko2) {
        this.getPnlShoritaishoJoho().getKakuninJiko().setLblKakuninJiko2(lblKakuninJiko2);
    }

    @JsonIgnore
    public Label getLblKakuninJiko3() {
        return this.getPnlShoritaishoJoho().getKakuninJiko().getLblKakuninJiko3();
    }

    @JsonIgnore
    public void  setLblKakuninJiko3(Label lblKakuninJiko3) {
        this.getPnlShoritaishoJoho().getKakuninJiko().setLblKakuninJiko3(lblKakuninJiko3);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCommonShutsuryokuJun() {
        return this.getPnlShutsuryokuJun().getCommonShutsuryokuJun();
    }

}
