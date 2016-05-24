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
 * SeikatsuhogoDetailSub のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuhogoDetailSubDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyuKikan")
    private JukyuKikanDiv JukyuKikan;
    @JsonProperty("HokenryoDairinofu")
    private HokenryoDairinofuDiv HokenryoDairinofu;
    @JsonProperty("KyugoShisetsu")
    private KyugoShisetsuDiv KyugoShisetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJukyuKikan
     * @return JukyuKikan
     */
    @JsonProperty("JukyuKikan")
    public JukyuKikanDiv getJukyuKikan() {
        return JukyuKikan;
    }

    /*
     * setJukyuKikan
     * @param JukyuKikan JukyuKikan
     */
    @JsonProperty("JukyuKikan")
    public void setJukyuKikan(JukyuKikanDiv JukyuKikan) {
        this.JukyuKikan = JukyuKikan;
    }

    /*
     * getHokenryoDairinofu
     * @return HokenryoDairinofu
     */
    @JsonProperty("HokenryoDairinofu")
    public HokenryoDairinofuDiv getHokenryoDairinofu() {
        return HokenryoDairinofu;
    }

    /*
     * setHokenryoDairinofu
     * @param HokenryoDairinofu HokenryoDairinofu
     */
    @JsonProperty("HokenryoDairinofu")
    public void setHokenryoDairinofu(HokenryoDairinofuDiv HokenryoDairinofu) {
        this.HokenryoDairinofu = HokenryoDairinofu;
    }

    /*
     * getKyugoShisetsu
     * @return KyugoShisetsu
     */
    @JsonProperty("KyugoShisetsu")
    public KyugoShisetsuDiv getKyugoShisetsu() {
        return KyugoShisetsu;
    }

    /*
     * setKyugoShisetsu
     * @param KyugoShisetsu KyugoShisetsu
     */
    @JsonProperty("KyugoShisetsu")
    public void setKyugoShisetsu(KyugoShisetsuDiv KyugoShisetsu) {
        this.KyugoShisetsu = KyugoShisetsu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtJukyushaNo() {
        return this.getJukyuKikan().getTxtJukyushaNo();
    }

    @JsonIgnore
    public void  setTxtJukyushaNo(TextBoxCode txtJukyushaNo) {
        this.getJukyuKikan().setTxtJukyushaNo(txtJukyushaNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtJukyuKaishiYMD() {
        return this.getJukyuKikan().getTxtJukyuKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtJukyuKaishiYMD(TextBoxDate txtJukyuKaishiYMD) {
        this.getJukyuKikan().setTxtJukyuKaishiYMD(txtJukyuKaishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJukyuHaishiYMD() {
        return this.getJukyuKikan().getTxtJukyuHaishiYMD();
    }

    @JsonIgnore
    public void  setTxtJukyuHaishiYMD(TextBoxDate txtJukyuHaishiYMD) {
        this.getJukyuKikan().setTxtJukyuHaishiYMD(txtJukyuHaishiYMD);
    }

    @JsonIgnore
    public RadioButton getRadDairinofuKubun() {
        return this.getHokenryoDairinofu().getRadDairinofuKubun();
    }

    @JsonIgnore
    public void  setRadDairinofuKubun(RadioButton radDairinofuKubun) {
        this.getHokenryoDairinofu().setRadDairinofuKubun(radDairinofuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtDainoNofuYM() {
        return this.getHokenryoDairinofu().getTxtDainoNofuYM();
    }

    @JsonIgnore
    public void  setTxtDainoNofuYM(TextBoxDate txtDainoNofuYM) {
        this.getHokenryoDairinofu().setTxtDainoNofuYM(txtDainoNofuYM);
    }

    @JsonIgnore
    public RadioButton getRadNyutaishoKubun() {
        return this.getKyugoShisetsu().getRadNyutaishoKubun();
    }

    @JsonIgnore
    public void  setRadNyutaishoKubun(RadioButton radNyutaishoKubun) {
        this.getKyugoShisetsu().setRadNyutaishoKubun(radNyutaishoKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtNyutaishoYMD() {
        return this.getKyugoShisetsu().getTxtNyutaishoYMD();
    }

    @JsonIgnore
    public void  setTxtNyutaishoYMD(TextBoxDate txtNyutaishoYMD) {
        this.getKyugoShisetsu().setTxtNyutaishoYMD(txtNyutaishoYMD);
    }

    // </editor-fold>
}
