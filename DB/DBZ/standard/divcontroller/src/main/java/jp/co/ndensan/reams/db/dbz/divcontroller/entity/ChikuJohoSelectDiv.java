package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IChikuJohoSelectDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.Chikiku1SelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.Chikiku2SelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.Chikiku3SelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ChoikiSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.GyoseikuSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TanitsuShichosonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.koikiShichosonDiv;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;

/**
 * ChikuJohoSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChikuJohoSelectDiv extends Panel implements IChikuJohoSelectDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TanitsuShichoson")
    private TanitsuShichosonDiv TanitsuShichoson;
    @JsonProperty("koikiShichoson")
    private koikiShichosonDiv koikiShichoson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TanitsuShichoson")
    public TanitsuShichosonDiv getTanitsuShichoson() {
        return TanitsuShichoson;
    }

    @JsonProperty("TanitsuShichoson")
    public void setTanitsuShichoson(TanitsuShichosonDiv TanitsuShichoson) {
        this.TanitsuShichoson=TanitsuShichoson;
    }

    @JsonProperty("koikiShichoson")
    public koikiShichosonDiv getKoikiShichoson() {
        return koikiShichoson;
    }

    @JsonProperty("koikiShichoson")
    public void setKoikiShichoson(koikiShichosonDiv koikiShichoson) {
        this.koikiShichoson=koikiShichoson;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlChiku() {
        return this.getTanitsuShichoson().getDdlChiku();
    }

    @JsonIgnore
    public void  setDdlChiku(DropDownList ddlChiku) {
        this.getTanitsuShichoson().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public DropDownList getDdlKyushichosonTanitsu() {
        return this.getTanitsuShichoson().getDdlKyushichosonTanitsu();
    }

    @JsonIgnore
    public void  setDdlKyushichosonTanitsu(DropDownList ddlKyushichosonTanitsu) {
        this.getTanitsuShichoson().setDdlKyushichosonTanitsu(ddlKyushichosonTanitsu);
    }

    @JsonIgnore
    public ChoikiSelectDiv getChoikiSelect() {
        return this.getTanitsuShichoson().getChoikiSelect();
    }

    @JsonIgnore
    public void  setChoikiSelect(ChoikiSelectDiv ChoikiSelect) {
        this.getTanitsuShichoson().setChoikiSelect(ChoikiSelect);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdChoikiInputSt() {
        return this.getTanitsuShichoson().getChoikiSelect().getCcdChoikiInputSt();
    }

    @JsonIgnore
    public Label getLblKaraChoiki() {
        return this.getTanitsuShichoson().getChoikiSelect().getLblKaraChoiki();
    }

    @JsonIgnore
    public void  setLblKaraChoiki(Label lblKaraChoiki) {
        this.getTanitsuShichoson().getChoikiSelect().setLblKaraChoiki(lblKaraChoiki);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdChoikiInputEd() {
        return this.getTanitsuShichoson().getChoikiSelect().getCcdChoikiInputEd();
    }

    @JsonIgnore
    public GyoseikuSelectDiv getGyoseikuSelect() {
        return this.getTanitsuShichoson().getGyoseikuSelect();
    }

    @JsonIgnore
    public void  setGyoseikuSelect(GyoseikuSelectDiv GyoseikuSelect) {
        this.getTanitsuShichoson().setGyoseikuSelect(GyoseikuSelect);
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuInputSt() {
        return this.getTanitsuShichoson().getGyoseikuSelect().getCcdGyoseikuInputSt();
    }

    @JsonIgnore
    public Label getLblKaraGyoseiku() {
        return this.getTanitsuShichoson().getGyoseikuSelect().getLblKaraGyoseiku();
    }

    @JsonIgnore
    public void  setLblKaraGyoseiku(Label lblKaraGyoseiku) {
        this.getTanitsuShichoson().getGyoseikuSelect().setLblKaraGyoseiku(lblKaraGyoseiku);
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuInputEd() {
        return this.getTanitsuShichoson().getGyoseikuSelect().getCcdGyoseikuInputEd();
    }

    @JsonIgnore
    public Chikiku1SelectDiv getChikiku1Select() {
        return this.getTanitsuShichoson().getChikiku1Select();
    }

    @JsonIgnore
    public void  setChikiku1Select(Chikiku1SelectDiv Chikiku1Select) {
        this.getTanitsuShichoson().setChikiku1Select(Chikiku1Select);
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1InputSt() {
        return this.getTanitsuShichoson().getChikiku1Select().getCcdChiku1InputSt();
    }

    @JsonIgnore
    public Label getLblKaraChiku1() {
        return this.getTanitsuShichoson().getChikiku1Select().getLblKaraChiku1();
    }

    @JsonIgnore
    public void  setLblKaraChiku1(Label lblKaraChiku1) {
        this.getTanitsuShichoson().getChikiku1Select().setLblKaraChiku1(lblKaraChiku1);
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1InputEd() {
        return this.getTanitsuShichoson().getChikiku1Select().getCcdChiku1InputEd();
    }

    @JsonIgnore
    public Chikiku2SelectDiv getChikiku2Select() {
        return this.getTanitsuShichoson().getChikiku2Select();
    }

    @JsonIgnore
    public void  setChikiku2Select(Chikiku2SelectDiv Chikiku2Select) {
        this.getTanitsuShichoson().setChikiku2Select(Chikiku2Select);
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2InputSt() {
        return this.getTanitsuShichoson().getChikiku2Select().getCcdChiku2InputSt();
    }

    @JsonIgnore
    public Label getLblKaraChiku2() {
        return this.getTanitsuShichoson().getChikiku2Select().getLblKaraChiku2();
    }

    @JsonIgnore
    public void  setLblKaraChiku2(Label lblKaraChiku2) {
        this.getTanitsuShichoson().getChikiku2Select().setLblKaraChiku2(lblKaraChiku2);
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2InputEd() {
        return this.getTanitsuShichoson().getChikiku2Select().getCcdChiku2InputEd();
    }

    @JsonIgnore
    public Chikiku3SelectDiv getChikiku3Select() {
        return this.getTanitsuShichoson().getChikiku3Select();
    }

    @JsonIgnore
    public void  setChikiku3Select(Chikiku3SelectDiv Chikiku3Select) {
        this.getTanitsuShichoson().setChikiku3Select(Chikiku3Select);
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3InputSt() {
        return this.getTanitsuShichoson().getChikiku3Select().getCcdChiku3InputSt();
    }

    @JsonIgnore
    public Label getLblKaraChiku3() {
        return this.getTanitsuShichoson().getChikiku3Select().getLblKaraChiku3();
    }

    @JsonIgnore
    public void  setLblKaraChiku3(Label lblKaraChiku3) {
        this.getTanitsuShichoson().getChikiku3Select().setLblKaraChiku3(lblKaraChiku3);
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3InputEd() {
        return this.getTanitsuShichoson().getChikiku3Select().getCcdChiku3InputEd();
    }

    @JsonIgnore
    public DropDownList getDdlShichoson() {
        return this.getKoikiShichoson().getDdlShichoson();
    }

    @JsonIgnore
    public void  setDdlShichoson(DropDownList ddlShichoson) {
        this.getKoikiShichoson().setDdlShichoson(ddlShichoson);
    }

    @JsonIgnore
    public DropDownList getDdlKyushichosonKoiki() {
        return this.getKoikiShichoson().getDdlKyushichosonKoiki();
    }

    @JsonIgnore
    public void  setDdlKyushichosonKoiki(DropDownList ddlKyushichosonKoiki) {
        this.getKoikiShichoson().setDdlKyushichosonKoiki(ddlKyushichosonKoiki);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
