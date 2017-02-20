package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001;
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
 * CreateTarget のクラスファイル 
 * 
 * @author 自動生成
 */
public class CreateTargetDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Ninteishinseibi")
    private NinteishinseibiDiv Ninteishinseibi;
    @JsonProperty("ichiran")
    private ichiranDiv ichiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteishinseibi
     * @return Ninteishinseibi
     */
    @JsonProperty("Ninteishinseibi")
    public NinteishinseibiDiv getNinteishinseibi() {
        return Ninteishinseibi;
    }

    /*
     * setNinteishinseibi
     * @param Ninteishinseibi Ninteishinseibi
     */
    @JsonProperty("Ninteishinseibi")
    public void setNinteishinseibi(NinteishinseibiDiv Ninteishinseibi) {
        this.Ninteishinseibi = Ninteishinseibi;
    }

    /*
     * getichiran
     * @return ichiran
     */
    @JsonProperty("ichiran")
    public ichiranDiv getIchiran() {
        return ichiran;
    }

    /*
     * setichiran
     * @param ichiran ichiran
     */
    @JsonProperty("ichiran")
    public void setIchiran(ichiranDiv ichiran) {
        this.ichiran = ichiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public txtShinseiNinteiDiv getTxtShinseiNintei() {
        return this.getNinteishinseibi().getTxtShinseiNintei();
    }

    @JsonIgnore
    public void  setTxtShinseiNintei(txtShinseiNinteiDiv txtShinseiNintei) {
        this.getNinteishinseibi().setTxtShinseiNintei(txtShinseiNintei);
    }

    @JsonIgnore
    public RadioButton getRdoShinseiNintei() {
        return this.getNinteishinseibi().getTxtShinseiNintei().getRdoShinseiNintei();
    }

    @JsonIgnore
    public void  setRdoShinseiNintei(RadioButton rdoShinseiNintei) {
        this.getNinteishinseibi().getTxtShinseiNintei().setRdoShinseiNintei(rdoShinseiNintei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKijunYMD() {
        return this.getNinteishinseibi().getTxtShinseiNintei().getTxtKijunYMD();
    }

    @JsonIgnore
    public void  setTxtKijunYMD(TextBoxDateRange txtKijunYMD) {
        this.getNinteishinseibi().getTxtShinseiNintei().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getNinteishinseibi().getTxtShinseiNintei().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getNinteishinseibi().getTxtShinseiNintei().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public RadioButton getRdoSyutsuryoku() {
        return this.getNinteishinseibi().getRdoSyutsuryoku();
    }

    @JsonIgnore
    public void  setRdoSyutsuryoku(RadioButton rdoSyutsuryoku) {
        this.getNinteishinseibi().setRdoSyutsuryoku(rdoSyutsuryoku);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getNinteishinseibi().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getNinteishinseibi().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensakuClear() {
        return this.getNinteishinseibi().getBtnKensakuClear();
    }

    @JsonIgnore
    public void  setBtnKensakuClear(Button btnKensakuClear) {
        this.getNinteishinseibi().setBtnKensakuClear(btnKensakuClear);
    }

    @JsonIgnore
    public DataGrid<dgCreateTargetSummary_Row> getDgCreateTargetSummary() {
        return this.getIchiran().getDgCreateTargetSummary();
    }

    @JsonIgnore
    public void  setDgCreateTargetSummary(DataGrid<dgCreateTargetSummary_Row> dgCreateTargetSummary) {
        this.getIchiran().setDgCreateTargetSummary(dgCreateTargetSummary);
    }

    // </editor-fold>
}
