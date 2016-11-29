package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * RiyojokyoTokeihyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyojokyoTokeihyoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BtnBatchParameterSave")
    private ButtonBatchParameterSave BtnBatchParameterSave;
    @JsonProperty("BtnBatchParameterRestore")
    private ButtonBatchParameterRestore BtnBatchParameterRestore;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("SeteJoken")
    private SeteJokenDiv SeteJoken;
    @JsonProperty("Tiku")
    private TikuDiv Tiku;
    @JsonProperty("SetumeMemo")
    private SetumeMemoDiv SetumeMemo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBtnBatchParameterSave
     * @return BtnBatchParameterSave
     */
    @JsonProperty("BtnBatchParameterSave")
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return BtnBatchParameterSave;
    }

    /*
     * setBtnBatchParameterSave
     * @param BtnBatchParameterSave BtnBatchParameterSave
     */
    @JsonProperty("BtnBatchParameterSave")
    public void setBtnBatchParameterSave(ButtonBatchParameterSave BtnBatchParameterSave) {
        this.BtnBatchParameterSave = BtnBatchParameterSave;
    }

    /*
     * getBtnBatchParameterRestore
     * @return BtnBatchParameterRestore
     */
    @JsonProperty("BtnBatchParameterRestore")
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return BtnBatchParameterRestore;
    }

    /*
     * setBtnBatchParameterRestore
     * @param BtnBatchParameterRestore BtnBatchParameterRestore
     */
    @JsonProperty("BtnBatchParameterRestore")
    public void setBtnBatchParameterRestore(ButtonBatchParameterRestore BtnBatchParameterRestore) {
        this.BtnBatchParameterRestore = BtnBatchParameterRestore;
    }

    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getSeteJoken
     * @return SeteJoken
     */
    @JsonProperty("SeteJoken")
    public SeteJokenDiv getSeteJoken() {
        return SeteJoken;
    }

    /*
     * setSeteJoken
     * @param SeteJoken SeteJoken
     */
    @JsonProperty("SeteJoken")
    public void setSeteJoken(SeteJokenDiv SeteJoken) {
        this.SeteJoken = SeteJoken;
    }

    /*
     * getTiku
     * @return Tiku
     */
    @JsonProperty("Tiku")
    public TikuDiv getTiku() {
        return Tiku;
    }

    /*
     * setTiku
     * @param Tiku Tiku
     */
    @JsonProperty("Tiku")
    public void setTiku(TikuDiv Tiku) {
        this.Tiku = Tiku;
    }

    /*
     * getSetumeMemo
     * @return SetumeMemo
     */
    @JsonProperty("SetumeMemo")
    public SetumeMemoDiv getSetumeMemo() {
        return SetumeMemo;
    }

    /*
     * setSetumeMemo
     * @param SetumeMemo SetumeMemo
     */
    @JsonProperty("SetumeMemo")
    public void setSetumeMemo(SetumeMemoDiv SetumeMemo) {
        this.SetumeMemo = SetumeMemo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTaishoYM() {
        return this.getChushutsuJoken().getRadTaishoYM();
    }

    @JsonIgnore
    public void  setRadTaishoYM(RadioButton radTaishoYM) {
        this.getChushutsuJoken().setRadTaishoYM(radTaishoYM);
    }

    @JsonIgnore
    public TextBoxDate getTasyoNengetu() {
        return this.getChushutsuJoken().getTasyoNengetu();
    }

    @JsonIgnore
    public void  setTasyoNengetu(TextBoxDate TasyoNengetu) {
        this.getChushutsuJoken().setTasyoNengetu(TasyoNengetu);
    }

    @JsonIgnore
    public DropDownList getNenreSansyutuKijyun() {
        return this.getSeteJoken().getNenreSansyutuKijyun();
    }

    @JsonIgnore
    public void  setNenreSansyutuKijyun(DropDownList NenreSansyutuKijyun) {
        this.getSeteJoken().setNenreSansyutuKijyun(NenreSansyutuKijyun);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getChikushichosonSelect() {
        return this.getTiku().getChikushichosonSelect();
    }

    @JsonIgnore
    public Label getSetumeLabel1() {
        return this.getSetumeMemo().getSetumeLabel1();
    }

    @JsonIgnore
    public void  setSetumeLabel1(Label SetumeLabel1) {
        this.getSetumeMemo().setSetumeLabel1(SetumeLabel1);
    }

    @JsonIgnore
    public Label getSetumeLabel2() {
        return this.getSetumeMemo().getSetumeLabel2();
    }

    @JsonIgnore
    public void  setSetumeLabel2(Label SetumeLabel2) {
        this.getSetumeMemo().setSetumeLabel2(SetumeLabel2);
    }

    @JsonIgnore
    public Label getSetumeLabel3() {
        return this.getSetumeMemo().getSetumeLabel3();
    }

    @JsonIgnore
    public void  setSetumeLabel3(Label SetumeLabel3) {
        this.getSetumeMemo().setSetumeLabel3(SetumeLabel3);
    }

    @JsonIgnore
    public Label getSetumeLabel5() {
        return this.getSetumeMemo().getSetumeLabel5();
    }

    @JsonIgnore
    public void  setSetumeLabel5(Label SetumeLabel5) {
        this.getSetumeMemo().setSetumeLabel5(SetumeLabel5);
    }

    @JsonIgnore
    public Label getSetumeLabel4() {
        return this.getSetumeMemo().getSetumeLabel4();
    }

    @JsonIgnore
    public void  setSetumeLabel4(Label SetumeLabel4) {
        this.getSetumeMemo().setSetumeLabel4(SetumeLabel4);
    }

    // </editor-fold>
}
