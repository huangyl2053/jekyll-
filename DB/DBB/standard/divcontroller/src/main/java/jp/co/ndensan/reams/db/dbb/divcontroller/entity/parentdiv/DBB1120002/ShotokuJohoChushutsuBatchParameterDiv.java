package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShotokuJohoChushutsuBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuJohoChushutsuBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriNendo")
    private TextBoxDate txtShoriNendo;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtTorikomiJotai")
    private TextBox txtTorikomiJotai;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("ToriKomiTaisho")
    private ToriKomiTaishoDiv ToriKomiTaisho;
    @JsonProperty("ShotokuRenkeiJohoIchiran")
    private ShotokuRenkeiJohoIchiranDiv ShotokuRenkeiJohoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriNendo
     * @return txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public TextBoxDate getTxtShoriNendo() {
        return txtShoriNendo;
    }

    /*
     * settxtShoriNendo
     * @param txtShoriNendo txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public void setTxtShoriNendo(TextBoxDate txtShoriNendo) {
        this.txtShoriNendo = txtShoriNendo;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtTorikomiJotai
     * @return txtTorikomiJotai
     */
    @JsonProperty("txtTorikomiJotai")
    public TextBox getTxtTorikomiJotai() {
        return txtTorikomiJotai;
    }

    /*
     * settxtTorikomiJotai
     * @param txtTorikomiJotai txtTorikomiJotai
     */
    @JsonProperty("txtTorikomiJotai")
    public void setTxtTorikomiJotai(TextBox txtTorikomiJotai) {
        this.txtTorikomiJotai = txtTorikomiJotai;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * getToriKomiTaisho
     * @return ToriKomiTaisho
     */
    @JsonProperty("ToriKomiTaisho")
    public ToriKomiTaishoDiv getToriKomiTaisho() {
        return ToriKomiTaisho;
    }

    /*
     * setToriKomiTaisho
     * @param ToriKomiTaisho ToriKomiTaisho
     */
    @JsonProperty("ToriKomiTaisho")
    public void setToriKomiTaisho(ToriKomiTaishoDiv ToriKomiTaisho) {
        this.ToriKomiTaisho = ToriKomiTaisho;
    }

    /*
     * getShotokuRenkeiJohoIchiran
     * @return ShotokuRenkeiJohoIchiran
     */
    @JsonProperty("ShotokuRenkeiJohoIchiran")
    public ShotokuRenkeiJohoIchiranDiv getShotokuRenkeiJohoIchiran() {
        return ShotokuRenkeiJohoIchiran;
    }

    /*
     * setShotokuRenkeiJohoIchiran
     * @param ShotokuRenkeiJohoIchiran ShotokuRenkeiJohoIchiran
     */
    @JsonProperty("ShotokuRenkeiJohoIchiran")
    public void setShotokuRenkeiJohoIchiran(ShotokuRenkeiJohoIchiranDiv ShotokuRenkeiJohoIchiran) {
        this.ShotokuRenkeiJohoIchiran = ShotokuRenkeiJohoIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUplUpload() {
        return this.getToriKomiTaisho().getUplUpload();
    }

    @JsonIgnore
    public void  setUplUpload(UploadPanel uplUpload) {
        this.getToriKomiTaisho().setUplUpload(uplUpload);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getToriKomiTaisho().getBtnUpload();
    }

    @JsonIgnore
    public void  setBtnUpload(Button btnUpload) {
        this.getToriKomiTaisho().setBtnUpload(btnUpload);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getShotokuRenkeiJohoIchiran().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
