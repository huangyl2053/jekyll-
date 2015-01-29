package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.Chikiku1SelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.Chikiku2SelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.Chikiku3SelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ChoikiSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.GyoseikuSelectDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.Chiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.Chiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TanitsuShichoson のクラスファイル 
 * 
 * @author 自動生成
 */
public class TanitsuShichosonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("ddlKyushichosonTanitsu")
    private DropDownList ddlKyushichosonTanitsu;
    @JsonProperty("ChoikiSelect")
    private ChoikiSelectDiv ChoikiSelect;
    @JsonProperty("GyoseikuSelect")
    private GyoseikuSelectDiv GyoseikuSelect;
    @JsonProperty("Chikiku1Select")
    private Chikiku1SelectDiv Chikiku1Select;
    @JsonProperty("Chikiku2Select")
    private Chikiku2SelectDiv Chikiku2Select;
    @JsonProperty("Chikiku3Select")
    private Chikiku3SelectDiv Chikiku3Select;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlChiku")
    public DropDownList getDdlChiku() {
        return ddlChiku;
    }

    @JsonProperty("ddlChiku")
    public void setDdlChiku(DropDownList ddlChiku) {
        this.ddlChiku=ddlChiku;
    }

    @JsonProperty("ddlKyushichosonTanitsu")
    public DropDownList getDdlKyushichosonTanitsu() {
        return ddlKyushichosonTanitsu;
    }

    @JsonProperty("ddlKyushichosonTanitsu")
    public void setDdlKyushichosonTanitsu(DropDownList ddlKyushichosonTanitsu) {
        this.ddlKyushichosonTanitsu=ddlKyushichosonTanitsu;
    }

    @JsonProperty("ChoikiSelect")
    public ChoikiSelectDiv getChoikiSelect() {
        return ChoikiSelect;
    }

    @JsonProperty("ChoikiSelect")
    public void setChoikiSelect(ChoikiSelectDiv ChoikiSelect) {
        this.ChoikiSelect=ChoikiSelect;
    }

    @JsonProperty("GyoseikuSelect")
    public GyoseikuSelectDiv getGyoseikuSelect() {
        return GyoseikuSelect;
    }

    @JsonProperty("GyoseikuSelect")
    public void setGyoseikuSelect(GyoseikuSelectDiv GyoseikuSelect) {
        this.GyoseikuSelect=GyoseikuSelect;
    }

    @JsonProperty("Chikiku1Select")
    public Chikiku1SelectDiv getChikiku1Select() {
        return Chikiku1Select;
    }

    @JsonProperty("Chikiku1Select")
    public void setChikiku1Select(Chikiku1SelectDiv Chikiku1Select) {
        this.Chikiku1Select=Chikiku1Select;
    }

    @JsonProperty("Chikiku2Select")
    public Chikiku2SelectDiv getChikiku2Select() {
        return Chikiku2Select;
    }

    @JsonProperty("Chikiku2Select")
    public void setChikiku2Select(Chikiku2SelectDiv Chikiku2Select) {
        this.Chikiku2Select=Chikiku2Select;
    }

    @JsonProperty("Chikiku3Select")
    public Chikiku3SelectDiv getChikiku3Select() {
        return Chikiku3Select;
    }

    @JsonProperty("Chikiku3Select")
    public void setChikiku3Select(Chikiku3SelectDiv Chikiku3Select) {
        this.Chikiku3Select=Chikiku3Select;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IChoikiInputDiv getCcdChoikiInputSt() {
        return this.getChoikiSelect().getCcdChoikiInputSt();
    }

    @JsonIgnore
    public Label getLblKaraChoiki() {
        return this.getChoikiSelect().getLblKaraChoiki();
    }

    @JsonIgnore
    public void  setLblKaraChoiki(Label lblKaraChoiki) {
        this.getChoikiSelect().setLblKaraChoiki(lblKaraChoiki);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdChoikiInputEd() {
        return this.getChoikiSelect().getCcdChoikiInputEd();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuInputSt() {
        return this.getGyoseikuSelect().getCcdGyoseikuInputSt();
    }

    @JsonIgnore
    public Label getLblKaraGyoseiku() {
        return this.getGyoseikuSelect().getLblKaraGyoseiku();
    }

    @JsonIgnore
    public void  setLblKaraGyoseiku(Label lblKaraGyoseiku) {
        this.getGyoseikuSelect().setLblKaraGyoseiku(lblKaraGyoseiku);
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuInputEd() {
        return this.getGyoseikuSelect().getCcdGyoseikuInputEd();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1InputSt() {
        return this.getChikiku1Select().getCcdChiku1InputSt();
    }

    @JsonIgnore
    public Label getLblKaraChiku1() {
        return this.getChikiku1Select().getLblKaraChiku1();
    }

    @JsonIgnore
    public void  setLblKaraChiku1(Label lblKaraChiku1) {
        this.getChikiku1Select().setLblKaraChiku1(lblKaraChiku1);
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1InputEd() {
        return this.getChikiku1Select().getCcdChiku1InputEd();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2InputSt() {
        return this.getChikiku2Select().getCcdChiku2InputSt();
    }

    @JsonIgnore
    public Label getLblKaraChiku2() {
        return this.getChikiku2Select().getLblKaraChiku2();
    }

    @JsonIgnore
    public void  setLblKaraChiku2(Label lblKaraChiku2) {
        this.getChikiku2Select().setLblKaraChiku2(lblKaraChiku2);
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2InputEd() {
        return this.getChikiku2Select().getCcdChiku2InputEd();
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3InputSt() {
        return this.getChikiku3Select().getCcdChiku3InputSt();
    }

    @JsonIgnore
    public Label getLblKaraChiku3() {
        return this.getChikiku3Select().getLblKaraChiku3();
    }

    @JsonIgnore
    public void  setLblKaraChiku3(Label lblKaraChiku3) {
        this.getChikiku3Select().setLblKaraChiku3(lblKaraChiku3);
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3InputEd() {
        return this.getChikiku3Select().getCcdChiku3InputEd();
    }

}
