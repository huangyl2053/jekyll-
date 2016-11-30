package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoFutangakuJohoHosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuJohoHoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutangakuHoseiSearch")
    private JikoFutangakuHoseiSearchDiv JikoFutangakuHoseiSearch;
    @JsonProperty("JikoFutangakuHoseiMadoguchi")
    private JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutangakuHoseiSearch
     * @return JikoFutangakuHoseiSearch
     */
    @JsonProperty("JikoFutangakuHoseiSearch")
    public JikoFutangakuHoseiSearchDiv getJikoFutangakuHoseiSearch() {
        return JikoFutangakuHoseiSearch;
    }

    /*
     * setJikoFutangakuHoseiSearch
     * @param JikoFutangakuHoseiSearch JikoFutangakuHoseiSearch
     */
    @JsonProperty("JikoFutangakuHoseiSearch")
    public void setJikoFutangakuHoseiSearch(JikoFutangakuHoseiSearchDiv JikoFutangakuHoseiSearch) {
        this.JikoFutangakuHoseiSearch = JikoFutangakuHoseiSearch;
    }

    /*
     * getJikoFutangakuHoseiMadoguchi
     * @return JikoFutangakuHoseiMadoguchi
     */
    @JsonProperty("JikoFutangakuHoseiMadoguchi")
    public JikoFutangakuHoseiMadoguchiDiv getJikoFutangakuHoseiMadoguchi() {
        return JikoFutangakuHoseiMadoguchi;
    }

    /*
     * setJikoFutangakuHoseiMadoguchi
     * @param JikoFutangakuHoseiMadoguchi JikoFutangakuHoseiMadoguchi
     */
    @JsonProperty("JikoFutangakuHoseiMadoguchi")
    public void setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi) {
        this.JikoFutangakuHoseiMadoguchi = JikoFutangakuHoseiMadoguchi;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtKakuninJouhouUketoriYM() {
        return this.getJikoFutangakuHoseiSearch().getTxtKakuninJouhouUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKakuninJouhouUketoriYM(TextBoxDate txtKakuninJouhouUketoriYM) {
        this.getJikoFutangakuHoseiSearch().setTxtKakuninJouhouUketoriYM(txtKakuninJouhouUketoriYM);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShiharaiBasho() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtShiharaiBasho();
    }

    @JsonIgnore
    public void  setTxtShiharaiBasho(TextBoxMultiLine txtShiharaiBasho) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtShiharaiBasho(txtShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishiYMD() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtKaishiYMD(txtKaishiYMD);
    }

    @JsonIgnore
    public TextBox getTxtKaishiYoubi() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtKaishiYoubi();
    }

    @JsonIgnore
    public void  setTxtKaishiYoubi(TextBox txtKaishiYoubi) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtKaishiYoubi(txtKaishiYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaishiJikanHH() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtKaishiJikanHH();
    }

    @JsonIgnore
    public void  setTxtKaishiJikanHH(TextBoxNum txtKaishiJikanHH) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtKaishiJikanHH(txtKaishiJikanHH);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaishiJIkanMM() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtKaishiJIkanMM();
    }

    @JsonIgnore
    public void  setTxtKaishiJIkanMM(TextBoxNum txtKaishiJIkanMM) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtKaishiJIkanMM(txtKaishiJIkanMM);
    }

    @JsonIgnore
    public TextBoxDate getTxtShuryoYMD() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtShuryoYMD(TextBoxDate txtShuryoYMD) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtShuryoYMD(txtShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtShuryoYoubi() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtShuryoYoubi();
    }

    @JsonIgnore
    public void  setTxtShuryoYoubi(TextBox txtShuryoYoubi) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtShuryoYoubi(txtShuryoYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtshuryoJikanHH() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtshuryoJikanHH();
    }

    @JsonIgnore
    public void  setTxtshuryoJikanHH(TextBoxNum txtshuryoJikanHH) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtshuryoJikanHH(txtshuryoJikanHH);
    }

    @JsonIgnore
    public TextBoxNum getTxtshuryoJikanMM() {
        return this.getJikoFutangakuHoseiMadoguchi().getTxtshuryoJikanMM();
    }

    @JsonIgnore
    public void  setTxtshuryoJikanMM(TextBoxNum txtshuryoJikanMM) {
        this.getJikoFutangakuHoseiMadoguchi().setTxtshuryoJikanMM(txtshuryoJikanMM);
    }

    @JsonIgnore
    public Label getLblMadoguchiBaraiJoho() {
        return this.getJikoFutangakuHoseiMadoguchi().getLblMadoguchiBaraiJoho();
    }

    @JsonIgnore
    public void  setLblMadoguchiBaraiJoho(Label lblMadoguchiBaraiJoho) {
        this.getJikoFutangakuHoseiMadoguchi().setLblMadoguchiBaraiJoho(lblMadoguchiBaraiJoho);
    }

    // </editor-fold>
}
