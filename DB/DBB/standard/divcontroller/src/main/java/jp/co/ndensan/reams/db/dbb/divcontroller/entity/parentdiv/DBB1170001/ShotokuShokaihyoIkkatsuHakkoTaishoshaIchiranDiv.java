package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiran のクラスファイル
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public class ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("TaishoshaIchiran")
    private TaishoshaIchiranDiv TaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChushutsuStYMD() {
        return this.getChushutsuJoken().getLblChushutsuStYMD();
    }

    @JsonIgnore
    public void setLblChushutsuStYMD(Label lblChushutsuStYMD) {
        this.getChushutsuJoken().setLblChushutsuStYMD(lblChushutsuStYMD);
    }

    @JsonIgnore
    public Label getLblChushutsuStTime() {
        return this.getChushutsuJoken().getLblChushutsuStTime();
    }

    @JsonIgnore
    public void setLblChushutsuStTime(Label lblChushutsuStTime) {
        this.getChushutsuJoken().setLblChushutsuStTime(lblChushutsuStTime);
    }

    @JsonIgnore
    public Label getLblChushutsuEdYMD() {
        return this.getChushutsuJoken().getLblChushutsuEdYMD();
    }

    @JsonIgnore
    public void setLblChushutsuEdYMD(Label lblChushutsuEdYMD) {
        this.getChushutsuJoken().setLblChushutsuEdYMD(lblChushutsuEdYMD);
    }

    @JsonIgnore
    public Label getLblChushutsuEdTime() {
        return this.getChushutsuJoken().getLblChushutsuEdTime();
    }

    @JsonIgnore
    public void setLblChushutsuEdTime(Label lblChushutsuEdTime) {
        this.getChushutsuJoken().setLblChushutsuEdTime(lblChushutsuEdTime);
    }

    @JsonIgnore
    public TextBoxYear getTxtChushutsuKijunNendo() {
        return this.getChushutsuJoken().getTxtChushutsuKijunNendo();
    }

    @JsonIgnore
    public void setTxtChushutsuKijunNendo(TextBoxYear txtChushutsuKijunNendo) {
        this.getChushutsuJoken().setTxtChushutsuKijunNendo(txtChushutsuKijunNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtChushutsuStYMD() {
        return this.getChushutsuJoken().getTxtChushutsuStYMD();
    }

    @JsonIgnore
    public void setTxtChushutsuStYMD(TextBoxDate txtChushutsuStYMD) {
        this.getChushutsuJoken().setTxtChushutsuStYMD(txtChushutsuStYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtChushutsuStTime() {
        return this.getChushutsuJoken().getTxtChushutsuStTime();
    }

    @JsonIgnore
    public void setTxtChushutsuStTime(TextBoxTime txtChushutsuStTime) {
        this.getChushutsuJoken().setTxtChushutsuStTime(txtChushutsuStTime);
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getChushutsuJoken().getLblKara();
    }

    @JsonIgnore
    public void setLblKara(Label lblKara) {
        this.getChushutsuJoken().setLblKara(lblKara);
    }

    @JsonIgnore
    public TextBoxDate getTxtChushutsuEdYMD() {
        return this.getChushutsuJoken().getTxtChushutsuEdYMD();
    }

    @JsonIgnore
    public void setTxtChushutsuEdYMD(TextBoxDate txtChushutsuEdYMD) {
        this.getChushutsuJoken().setTxtChushutsuEdYMD(txtChushutsuEdYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtChushutsuEdTime() {
        return this.getChushutsuJoken().getTxtChushutsuEdTime();
    }

    @JsonIgnore
    public void setTxtChushutsuEdTime(TextBoxTime txtChushutsuEdTime) {
        this.getChushutsuJoken().setTxtChushutsuEdTime(txtChushutsuEdTime);
    }

    @JsonIgnore
    public Button getBtnChushutsu() {
        return this.getChushutsuJoken().getBtnChushutsu();
    }

    @JsonIgnore
    public void setBtnChushutsu(Button btnChushutsu) {
        this.getChushutsuJoken().setBtnChushutsu(btnChushutsu);
    }

    @JsonIgnore
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return this.getTaishoshaIchiran().getDgTaishoshaIchiran();
    }

    @JsonIgnore
    public void setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.getTaishoshaIchiran().setDgTaishoshaIchiran(dgTaishoshaIchiran);
    }

    // </editor-fold>
}
