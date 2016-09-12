package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * TokuchoDoteiShori のクラスファイル
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class TokuchoDoteiShoriDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiShoriNaiyo")
    private KonkaiShoriNaiyoDiv KonkaiShoriNaiyo;
    @JsonProperty("TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel")
    private TokuchoTaishoshaDoteiShoriKakuninTanitsuPanelDiv TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel;
    @JsonProperty("TokuchoTaishoshaDoteiShoriKakuninKoikiPanel")
    private TokuchoTaishoshaDoteiShoriKakuninKoikiPanelDiv TokuchoTaishoshaDoteiShoriKakuninKoikiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKonkaiShoriNaiyo
     * @return KonkaiShoriNaiyo
     */
    @JsonProperty("KonkaiShoriNaiyo")
    public KonkaiShoriNaiyoDiv getKonkaiShoriNaiyo() {
        return KonkaiShoriNaiyo;
    }

    /*
     * setKonkaiShoriNaiyo
     * @param KonkaiShoriNaiyo KonkaiShoriNaiyo
     */
    @JsonProperty("KonkaiShoriNaiyo")
    public void setKonkaiShoriNaiyo(KonkaiShoriNaiyoDiv KonkaiShoriNaiyo) {
        this.KonkaiShoriNaiyo = KonkaiShoriNaiyo;
    }

    /*
     * getTokuchoTaishoshaDoteiShoriKakuninTanitsuPanel
     * @return TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel
     */
    @JsonProperty("TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel")
    public TokuchoTaishoshaDoteiShoriKakuninTanitsuPanelDiv getTokuchoTaishoshaDoteiShoriKakuninTanitsuPanel() {
        return TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel;
    }

    /*
     * setTokuchoTaishoshaDoteiShoriKakuninTanitsuPanel
     * @param TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel
     */
    @JsonProperty("TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel")
    public void setTokuchoTaishoshaDoteiShoriKakuninTanitsuPanel(TokuchoTaishoshaDoteiShoriKakuninTanitsuPanelDiv TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel) {
        this.TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel = TokuchoTaishoshaDoteiShoriKakuninTanitsuPanel;
    }

    /*
     * getTokuchoTaishoshaDoteiShoriKakuninKoikiPanel
     * @return TokuchoTaishoshaDoteiShoriKakuninKoikiPanel
     */
    @JsonProperty("TokuchoTaishoshaDoteiShoriKakuninKoikiPanel")
    public TokuchoTaishoshaDoteiShoriKakuninKoikiPanelDiv getTokuchoTaishoshaDoteiShoriKakuninKoikiPanel() {
        return TokuchoTaishoshaDoteiShoriKakuninKoikiPanel;
    }

    /*
     * setTokuchoTaishoshaDoteiShoriKakuninKoikiPanel
     * @param TokuchoTaishoshaDoteiShoriKakuninKoikiPanel TokuchoTaishoshaDoteiShoriKakuninKoikiPanel
     */
    @JsonProperty("TokuchoTaishoshaDoteiShoriKakuninKoikiPanel")
    public void setTokuchoTaishoshaDoteiShoriKakuninKoikiPanel(TokuchoTaishoshaDoteiShoriKakuninKoikiPanelDiv TokuchoTaishoshaDoteiShoriKakuninKoikiPanel) {
        this.TokuchoTaishoshaDoteiShoriKakuninKoikiPanel = TokuchoTaishoshaDoteiShoriKakuninKoikiPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShutokuM() {
        return this.getKonkaiShoriNaiyo().getTxtShutokuM();
    }

    @JsonIgnore
    public void setTxtShutokuM(TextBoxDate txtShutokuM) {
        this.getKonkaiShoriNaiyo().setTxtShutokuM(txtShutokuM);
    }

    @JsonIgnore
    public TextBoxDate getTxtHosokuM1() {
        return this.getKonkaiShoriNaiyo().getTxtHosokuM1();
    }

    @JsonIgnore
    public void setTxtHosokuM1(TextBoxDate txtHosokuM1) {
        this.getKonkaiShoriNaiyo().setTxtHosokuM1(txtHosokuM1);
    }

    @JsonIgnore
    public HosokuMKoikiPanelDiv getHosokuMKoikiPanel() {
        return this.getKonkaiShoriNaiyo().getHosokuMKoikiPanel();
    }

    @JsonIgnore
    public void setHosokuMKoikiPanel(HosokuMKoikiPanelDiv HosokuMKoikiPanel) {
        this.getKonkaiShoriNaiyo().setHosokuMKoikiPanel(HosokuMKoikiPanel);
    }

    @JsonIgnore
    public TextBox getTxtHosokuM2() {
        return this.getKonkaiShoriNaiyo().getHosokuMKoikiPanel().getTxtHosokuM2();
    }

    @JsonIgnore
    public void setTxtHosokuM2(TextBox txtHosokuM2) {
        this.getKonkaiShoriNaiyo().getHosokuMKoikiPanel().setTxtHosokuM2(txtHosokuM2);
    }

    @JsonIgnore
    public TextBox getTxtHosokuM3() {
        return this.getKonkaiShoriNaiyo().getHosokuMKoikiPanel().getTxtHosokuM3();
    }

    @JsonIgnore
    public void setTxtHosokuM3(TextBox txtHosokuM3) {
        this.getKonkaiShoriNaiyo().getHosokuMKoikiPanel().setTxtHosokuM3(txtHosokuM3);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishiM() {
        return this.getKonkaiShoriNaiyo().getTxtKaishiM();
    }

    @JsonIgnore
    public void setTxtKaishiM(TextBoxDate txtKaishiM) {
        this.getKonkaiShoriNaiyo().setTxtKaishiM(txtKaishiM);
    }

    @JsonIgnore
    public DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row> getDgTokuchoTaishoshaDoteiShoriKakuninTanitsu() {
        return this.getTokuchoTaishoshaDoteiShoriKakuninTanitsuPanel().getDgTokuchoTaishoshaDoteiShoriKakuninTanitsu();
    }

    @JsonIgnore
    public void setDgTokuchoTaishoshaDoteiShoriKakuninTanitsu(DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row> dgTokuchoTaishoshaDoteiShoriKakuninTanitsu) {
        this.getTokuchoTaishoshaDoteiShoriKakuninTanitsuPanel().setDgTokuchoTaishoshaDoteiShoriKakuninTanitsu(dgTokuchoTaishoshaDoteiShoriKakuninTanitsu);
    }

    @JsonIgnore
    public DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row> getDgTokuchoTaishoshaDoteiShoriKakuninKoiki() {
        return this.getTokuchoTaishoshaDoteiShoriKakuninKoikiPanel().getDgTokuchoTaishoshaDoteiShoriKakuninKoiki();
    }

    @JsonIgnore
    public void setDgTokuchoTaishoshaDoteiShoriKakuninKoiki(DataGrid<dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row> dgTokuchoTaishoshaDoteiShoriKakuninKoiki) {
        this.getTokuchoTaishoshaDoteiShoriKakuninKoikiPanel().setDgTokuchoTaishoshaDoteiShoriKakuninKoiki(dgTokuchoTaishoshaDoteiShoriKakuninKoiki);
    }

    // </editor-fold>
}
