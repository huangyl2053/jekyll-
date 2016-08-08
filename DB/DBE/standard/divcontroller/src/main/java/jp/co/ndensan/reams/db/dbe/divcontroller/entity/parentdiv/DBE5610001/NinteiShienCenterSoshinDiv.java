package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001;
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
 * NinteiShienCenterSoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShienCenterSoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("TaishoshaIchiran")
    private TaishoshaIchiranDiv TaishoshaIchiran;
    @JsonProperty("ShutsuryokuJoken")
    private ShutsuryokuJokenDiv ShutsuryokuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getTaishoshaIchiran
     * @return TaishoshaIchiran
     */
    @JsonProperty("TaishoshaIchiran")
    public TaishoshaIchiranDiv getTaishoshaIchiran() {
        return TaishoshaIchiran;
    }

    /*
     * setTaishoshaIchiran
     * @param TaishoshaIchiran TaishoshaIchiran
     */
    @JsonProperty("TaishoshaIchiran")
    public void setTaishoshaIchiran(TaishoshaIchiranDiv TaishoshaIchiran) {
        this.TaishoshaIchiran = TaishoshaIchiran;
    }

    /*
     * getShutsuryokuJoken
     * @return ShutsuryokuJoken
     */
    @JsonProperty("ShutsuryokuJoken")
    public ShutsuryokuJokenDiv getShutsuryokuJoken() {
        return ShutsuryokuJoken;
    }

    /*
     * setShutsuryokuJoken
     * @param ShutsuryokuJoken ShutsuryokuJoken
     */
    @JsonProperty("ShutsuryokuJoken")
    public void setShutsuryokuJoken(ShutsuryokuJokenDiv ShutsuryokuJoken) {
        this.ShutsuryokuJoken = ShutsuryokuJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadDataShutsuryoku() {
        return this.getKensakuJoken().getRadDataShutsuryoku();
    }

    @JsonIgnore
    public void  setRadDataShutsuryoku(RadioButton radDataShutsuryoku) {
        this.getKensakuJoken().setRadDataShutsuryoku(radDataShutsuryoku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteibi() {
        return this.getKensakuJoken().getTxtNijiHanteibi();
    }

    @JsonIgnore
    public void  setTxtNijiHanteibi(TextBoxDateRange txtNijiHanteibi) {
        this.getKensakuJoken().setTxtNijiHanteibi(txtNijiHanteibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtDispMax() {
        return this.getKensakuJoken().getTxtDispMax();
    }

    @JsonIgnore
    public void  setTxtDispMax(TextBoxNum txtDispMax) {
        this.getKensakuJoken().setTxtDispMax(txtDispMax);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return this.getTaishoshaIchiran().getDgTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.getTaishoshaIchiran().setDgTaishoshaIchiran(dgTaishoshaIchiran);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnTaishoshaOutput() {
        return this.getTaishoshaIchiran().getBtnTaishoshaOutput();
    }

    @JsonIgnore
    public void  setBtnTaishoshaOutput(ButtonDownLoad btnTaishoshaOutput) {
        this.getTaishoshaIchiran().setBtnTaishoshaOutput(btnTaishoshaOutput);
    }

    @JsonIgnore
    public RadioButton getRadTennyuShiboJoho() {
        return this.getShutsuryokuJoken().getRadTennyuShiboJoho();
    }

    @JsonIgnore
    public void  setRadTennyuShiboJoho(RadioButton radTennyuShiboJoho) {
        this.getShutsuryokuJoken().setRadTennyuShiboJoho(radTennyuShiboJoho);
    }

    // </editor-fold>
}
