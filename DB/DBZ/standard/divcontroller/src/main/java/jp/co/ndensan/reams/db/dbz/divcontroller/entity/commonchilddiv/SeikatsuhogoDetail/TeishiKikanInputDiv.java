package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;
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
 * TeishiKikanInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class TeishiKikanInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeishiKaishiYMD")
    private TextBoxDate txtTeishiKaishiYMD;
    @JsonProperty("txtTeishiShuryoYMD")
    private TextBoxDate txtTeishiShuryoYMD;
    @JsonProperty("TeishiInputSeigyo")
    private TeishiInputSeigyoDiv TeishiInputSeigyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTeishiKaishiYMD
     * @return txtTeishiKaishiYMD
     */
    @JsonProperty("txtTeishiKaishiYMD")
    public TextBoxDate getTxtTeishiKaishiYMD() {
        return txtTeishiKaishiYMD;
    }

    /*
     * settxtTeishiKaishiYMD
     * @param txtTeishiKaishiYMD txtTeishiKaishiYMD
     */
    @JsonProperty("txtTeishiKaishiYMD")
    public void setTxtTeishiKaishiYMD(TextBoxDate txtTeishiKaishiYMD) {
        this.txtTeishiKaishiYMD = txtTeishiKaishiYMD;
    }

    /*
     * gettxtTeishiShuryoYMD
     * @return txtTeishiShuryoYMD
     */
    @JsonProperty("txtTeishiShuryoYMD")
    public TextBoxDate getTxtTeishiShuryoYMD() {
        return txtTeishiShuryoYMD;
    }

    /*
     * settxtTeishiShuryoYMD
     * @param txtTeishiShuryoYMD txtTeishiShuryoYMD
     */
    @JsonProperty("txtTeishiShuryoYMD")
    public void setTxtTeishiShuryoYMD(TextBoxDate txtTeishiShuryoYMD) {
        this.txtTeishiShuryoYMD = txtTeishiShuryoYMD;
    }

    /*
     * getTeishiInputSeigyo
     * @return TeishiInputSeigyo
     */
    @JsonProperty("TeishiInputSeigyo")
    public TeishiInputSeigyoDiv getTeishiInputSeigyo() {
        return TeishiInputSeigyo;
    }

    /*
     * setTeishiInputSeigyo
     * @param TeishiInputSeigyo TeishiInputSeigyo
     */
    @JsonProperty("TeishiInputSeigyo")
    public void setTeishiInputSeigyo(TeishiInputSeigyoDiv TeishiInputSeigyo) {
        this.TeishiInputSeigyo = TeishiInputSeigyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnTeishiInputKakutei() {
        return this.getTeishiInputSeigyo().getBtnTeishiInputKakutei();
    }

    @JsonIgnore
    public void  setBtnTeishiInputKakutei(Button btnTeishiInputKakutei) {
        this.getTeishiInputSeigyo().setBtnTeishiInputKakutei(btnTeishiInputKakutei);
    }

    @JsonIgnore
    public Button getBtnTeishiInputTorikeshi() {
        return this.getTeishiInputSeigyo().getBtnTeishiInputTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTeishiInputTorikeshi(Button btnTeishiInputTorikeshi) {
        this.getTeishiInputSeigyo().setBtnTeishiInputTorikeshi(btnTeishiInputTorikeshi);
    }

    // </editor-fold>
}
