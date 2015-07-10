package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoToiawaseDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.InjiNaiyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.RirekiHyojiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgToiawaseakiRireki_Row;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChoikiInputDiv;

/**
 * KaigoToiawase のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoToiawaseDiv extends Panel implements IKaigoToiawaseDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHakkoBusho")
    private DropDownList ddlHakkoBusho;
    @JsonProperty("InjiNaiyo")
    private InjiNaiyoDiv InjiNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHakkoBusho")
    public DropDownList getDdlHakkoBusho() {
        return ddlHakkoBusho;
    }

    @JsonProperty("ddlHakkoBusho")
    public void setDdlHakkoBusho(DropDownList ddlHakkoBusho) {
        this.ddlHakkoBusho=ddlHakkoBusho;
    }

    @JsonProperty("InjiNaiyo")
    public InjiNaiyoDiv getInjiNaiyo() {
        return InjiNaiyo;
    }

    @JsonProperty("InjiNaiyo")
    public void setInjiNaiyo(InjiNaiyoDiv InjiNaiyo) {
        this.InjiNaiyo=InjiNaiyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlBusho() {
        return this.getInjiNaiyo().getDdlBusho();
    }

    @JsonIgnore
    public void  setDdlBusho(DropDownList ddlBusho) {
        this.getInjiNaiyo().setDdlBusho(ddlBusho);
    }

    @JsonIgnore
    public DropDownList getDllBushomeiKuhakuUMu() {
        return this.getInjiNaiyo().getDllBushomeiKuhakuUMu();
    }

    @JsonIgnore
    public void  setDllBushomeiKuhakuUMu(DropDownList dllBushomeiKuhakuUMu) {
        this.getInjiNaiyo().setDllBushomeiKuhakuUMu(dllBushomeiKuhakuUMu);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getInjiNaiyo().getTxtName();
    }

    @JsonIgnore
    public void  setTxtName(TextBox txtName) {
        this.getInjiNaiyo().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBox getTxtTelNo() {
        return this.getInjiNaiyo().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBox txtTelNo) {
        this.getInjiNaiyo().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBox getTxtNaisenNo() {
        return this.getInjiNaiyo().getTxtNaisenNo();
    }

    @JsonIgnore
    public void  setTxtNaisenNo(TextBox txtNaisenNo) {
        this.getInjiNaiyo().setTxtNaisenNo(txtNaisenNo);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getInjiNaiyo().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getInjiNaiyo().setLin1(lin1);
    }

    @JsonIgnore
    public DropDownList getDdlKenmeiFuyo() {
        return this.getInjiNaiyo().getDdlKenmeiFuyo();
    }

    @JsonIgnore
    public void  setDdlKenmeiFuyo(DropDownList ddlKenmeiFuyo) {
        this.getInjiNaiyo().setDdlKenmeiFuyo(ddlKenmeiFuyo);
    }

    @JsonIgnore
    public DropDownList getDdlShichoshonMei() {
        return this.getInjiNaiyo().getDdlShichoshonMei();
    }

    @JsonIgnore
    public void  setDdlShichoshonMei(DropDownList ddlShichoshonMei) {
        this.getInjiNaiyo().setDdlShichoshonMei(ddlShichoshonMei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getInjiNaiyo().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getInjiNaiyo().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJusho() {
        return this.getInjiNaiyo().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxMultiLine txtJusho) {
        this.getInjiNaiyo().setTxtJusho(txtJusho);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
