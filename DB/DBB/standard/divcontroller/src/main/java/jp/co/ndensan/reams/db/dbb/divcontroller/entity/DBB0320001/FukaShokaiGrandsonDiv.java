package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukakonkyoAndKiwariDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.InjiNaiyoSetteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.SetaiinShotokuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.TokuchoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaShokaiGrandson のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaShokaiGrandsonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtKoseiM")
    private TextBox txtKoseiM;
    @JsonProperty("txtKoseiYMD")
    private TextBox txtKoseiYMD;
    @JsonProperty("btnRirekiHyoji")
    private ButtonDialog btnRirekiHyoji;
    @JsonProperty("linFukashokai1")
    private HorizontalLine linFukashokai1;
    @JsonProperty("btnFukakonkyoKiwari")
    private ButtonDialog btnFukakonkyoKiwari;
    @JsonProperty("btnSetaiinnShotoku")
    private ButtonDialog btnSetaiinnShotoku;
    @JsonProperty("btnTokucho")
    private ButtonDialog btnTokucho;
    @JsonProperty("btnGemmen")
    private ButtonDialog btnGemmen;
    @JsonProperty("btnChoshuYuyo")
    private ButtonDialog btnChoshuYuyo;
    @JsonProperty("btnRentaiNofuGimusha")
    private ButtonDialog btnRentaiNofuGimusha;
    @JsonProperty("btnInjiNaiyoSettei")
    private ButtonDialog btnInjiNaiyoSettei;
    @JsonProperty("FukakonkyoAndKiwari")
    private FukakonkyoAndKiwariDiv FukakonkyoAndKiwari;
    @JsonProperty("SetaiinShotoku")
    private SetaiinShotokuDiv SetaiinShotoku;
    @JsonProperty("Tokucho")
    private TokuchoDiv Tokucho;
    @JsonProperty("InjiNaiyoSettei")
    private InjiNaiyoSetteiDiv InjiNaiyoSettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtKoseiM")
    public TextBox getTxtKoseiM() {
        return txtKoseiM;
    }

    @JsonProperty("txtKoseiM")
    public void setTxtKoseiM(TextBox txtKoseiM) {
        this.txtKoseiM=txtKoseiM;
    }

    @JsonProperty("txtKoseiYMD")
    public TextBox getTxtKoseiYMD() {
        return txtKoseiYMD;
    }

    @JsonProperty("txtKoseiYMD")
    public void setTxtKoseiYMD(TextBox txtKoseiYMD) {
        this.txtKoseiYMD=txtKoseiYMD;
    }

    @JsonProperty("btnRirekiHyoji")
    public ButtonDialog getBtnRirekiHyoji() {
        return btnRirekiHyoji;
    }

    @JsonProperty("btnRirekiHyoji")
    public void setBtnRirekiHyoji(ButtonDialog btnRirekiHyoji) {
        this.btnRirekiHyoji=btnRirekiHyoji;
    }

    @JsonProperty("linFukashokai1")
    public HorizontalLine getLinFukashokai1() {
        return linFukashokai1;
    }

    @JsonProperty("linFukashokai1")
    public void setLinFukashokai1(HorizontalLine linFukashokai1) {
        this.linFukashokai1=linFukashokai1;
    }

    @JsonProperty("btnFukakonkyoKiwari")
    public ButtonDialog getBtnFukakonkyoKiwari() {
        return btnFukakonkyoKiwari;
    }

    @JsonProperty("btnFukakonkyoKiwari")
    public void setBtnFukakonkyoKiwari(ButtonDialog btnFukakonkyoKiwari) {
        this.btnFukakonkyoKiwari=btnFukakonkyoKiwari;
    }

    @JsonProperty("btnSetaiinnShotoku")
    public ButtonDialog getBtnSetaiinnShotoku() {
        return btnSetaiinnShotoku;
    }

    @JsonProperty("btnSetaiinnShotoku")
    public void setBtnSetaiinnShotoku(ButtonDialog btnSetaiinnShotoku) {
        this.btnSetaiinnShotoku=btnSetaiinnShotoku;
    }

    @JsonProperty("btnTokucho")
    public ButtonDialog getBtnTokucho() {
        return btnTokucho;
    }

    @JsonProperty("btnTokucho")
    public void setBtnTokucho(ButtonDialog btnTokucho) {
        this.btnTokucho=btnTokucho;
    }

    @JsonProperty("btnGemmen")
    public ButtonDialog getBtnGemmen() {
        return btnGemmen;
    }

    @JsonProperty("btnGemmen")
    public void setBtnGemmen(ButtonDialog btnGemmen) {
        this.btnGemmen=btnGemmen;
    }

    @JsonProperty("btnChoshuYuyo")
    public ButtonDialog getBtnChoshuYuyo() {
        return btnChoshuYuyo;
    }

    @JsonProperty("btnChoshuYuyo")
    public void setBtnChoshuYuyo(ButtonDialog btnChoshuYuyo) {
        this.btnChoshuYuyo=btnChoshuYuyo;
    }

    @JsonProperty("btnRentaiNofuGimusha")
    public ButtonDialog getBtnRentaiNofuGimusha() {
        return btnRentaiNofuGimusha;
    }

    @JsonProperty("btnRentaiNofuGimusha")
    public void setBtnRentaiNofuGimusha(ButtonDialog btnRentaiNofuGimusha) {
        this.btnRentaiNofuGimusha=btnRentaiNofuGimusha;
    }

    @JsonProperty("btnInjiNaiyoSettei")
    public ButtonDialog getBtnInjiNaiyoSettei() {
        return btnInjiNaiyoSettei;
    }

    @JsonProperty("btnInjiNaiyoSettei")
    public void setBtnInjiNaiyoSettei(ButtonDialog btnInjiNaiyoSettei) {
        this.btnInjiNaiyoSettei=btnInjiNaiyoSettei;
    }

    @JsonProperty("FukakonkyoAndKiwari")
    public FukakonkyoAndKiwariDiv getFukakonkyoAndKiwari() {
        return FukakonkyoAndKiwari;
    }

    @JsonProperty("FukakonkyoAndKiwari")
    public void setFukakonkyoAndKiwari(FukakonkyoAndKiwariDiv FukakonkyoAndKiwari) {
        this.FukakonkyoAndKiwari=FukakonkyoAndKiwari;
    }

    @JsonProperty("SetaiinShotoku")
    public SetaiinShotokuDiv getSetaiinShotoku() {
        return SetaiinShotoku;
    }

    @JsonProperty("SetaiinShotoku")
    public void setSetaiinShotoku(SetaiinShotokuDiv SetaiinShotoku) {
        this.SetaiinShotoku=SetaiinShotoku;
    }

    @JsonProperty("Tokucho")
    public TokuchoDiv getTokucho() {
        return Tokucho;
    }

    @JsonProperty("Tokucho")
    public void setTokucho(TokuchoDiv Tokucho) {
        this.Tokucho=Tokucho;
    }

    @JsonProperty("InjiNaiyoSettei")
    public InjiNaiyoSetteiDiv getInjiNaiyoSettei() {
        return InjiNaiyoSettei;
    }

    @JsonProperty("InjiNaiyoSettei")
    public void setInjiNaiyoSettei(InjiNaiyoSetteiDiv InjiNaiyoSettei) {
        this.InjiNaiyoSettei=InjiNaiyoSettei;
    }

}
