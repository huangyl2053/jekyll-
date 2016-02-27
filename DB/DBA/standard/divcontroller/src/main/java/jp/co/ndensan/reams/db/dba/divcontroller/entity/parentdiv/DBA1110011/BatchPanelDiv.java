package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * BatchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class BatchPanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShutsuTaisho")
    private RadioButton radShutsuTaisho;
    @JsonProperty("hrl2")
    private HorizontalLine hrl2;
    @JsonProperty("chkHenshuHoho")
    private CheckBoxList chkHenshuHoho;
    @JsonProperty("hrl3")
    private HorizontalLine hrl3;
    @JsonProperty("lblChushutsuJohen")
    private Label lblChushutsuJohen;
    @JsonProperty("lblKaishibi")
    private Label lblKaishibi;
    @JsonProperty("lblShuryobi")
    private Label lblShuryobi;
    @JsonProperty("lblKoufubi")
    private Label lblKoufubi;
    @JsonProperty("txtKoufubiRange")
    private TextBoxDateRange txtKoufubiRange;
    @JsonProperty("lblKaishubi")
    private Label lblKaishubi;
    @JsonProperty("txtKaishubiRange")
    private TextBoxDateRange txtKaishubiRange;
    @JsonProperty("chkSaishinJoho")
    private CheckBoxList chkSaishinJoho;
    @JsonProperty("hrl4")
    private HorizontalLine hrl4;
    @JsonProperty("lblKoufuJiyu")
    private Label lblKoufuJiyu;
    @JsonProperty("lblKaishuJiyu")
    private Label lblKaishuJiyu;
    @JsonProperty("dgKoufuJiyu")
    private DataGrid<dgKoufuJiyu_Row> dgKoufuJiyu;
    @JsonProperty("dgKaishuJiyu")
    private DataGrid<dgKaishuJiyu_Row> dgKaishuJiyu;
    @JsonProperty("hrl5")
    private HorizontalLine hrl5;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShutsuTaisho
     * @return radShutsuTaisho
     */
    @JsonProperty("radShutsuTaisho")
    public RadioButton getRadShutsuTaisho() {
        return radShutsuTaisho;
    }

    /*
     * setradShutsuTaisho
     * @param radShutsuTaisho radShutsuTaisho
     */
    @JsonProperty("radShutsuTaisho")
    public void setRadShutsuTaisho(RadioButton radShutsuTaisho) {
        this.radShutsuTaisho = radShutsuTaisho;
    }

    /*
     * gethrl2
     * @return hrl2
     */
    @JsonProperty("hrl2")
    public HorizontalLine getHrl2() {
        return hrl2;
    }

    /*
     * sethrl2
     * @param hrl2 hrl2
     */
    @JsonProperty("hrl2")
    public void setHrl2(HorizontalLine hrl2) {
        this.hrl2 = hrl2;
    }

    /*
     * getchkHenshuHoho
     * @return chkHenshuHoho
     */
    @JsonProperty("chkHenshuHoho")
    public CheckBoxList getChkHenshuHoho() {
        return chkHenshuHoho;
    }

    /*
     * setchkHenshuHoho
     * @param chkHenshuHoho chkHenshuHoho
     */
    @JsonProperty("chkHenshuHoho")
    public void setChkHenshuHoho(CheckBoxList chkHenshuHoho) {
        this.chkHenshuHoho = chkHenshuHoho;
    }

    /*
     * gethrl3
     * @return hrl3
     */
    @JsonProperty("hrl3")
    public HorizontalLine getHrl3() {
        return hrl3;
    }

    /*
     * sethrl3
     * @param hrl3 hrl3
     */
    @JsonProperty("hrl3")
    public void setHrl3(HorizontalLine hrl3) {
        this.hrl3 = hrl3;
    }

    /*
     * getlblChushutsuJohen
     * @return lblChushutsuJohen
     */
    @JsonProperty("lblChushutsuJohen")
    public Label getLblChushutsuJohen() {
        return lblChushutsuJohen;
    }

    /*
     * setlblChushutsuJohen
     * @param lblChushutsuJohen lblChushutsuJohen
     */
    @JsonProperty("lblChushutsuJohen")
    public void setLblChushutsuJohen(Label lblChushutsuJohen) {
        this.lblChushutsuJohen = lblChushutsuJohen;
    }

    /*
     * getlblKaishibi
     * @return lblKaishibi
     */
    @JsonProperty("lblKaishibi")
    public Label getLblKaishibi() {
        return lblKaishibi;
    }

    /*
     * setlblKaishibi
     * @param lblKaishibi lblKaishibi
     */
    @JsonProperty("lblKaishibi")
    public void setLblKaishibi(Label lblKaishibi) {
        this.lblKaishibi = lblKaishibi;
    }

    /*
     * getlblShuryobi
     * @return lblShuryobi
     */
    @JsonProperty("lblShuryobi")
    public Label getLblShuryobi() {
        return lblShuryobi;
    }

    /*
     * setlblShuryobi
     * @param lblShuryobi lblShuryobi
     */
    @JsonProperty("lblShuryobi")
    public void setLblShuryobi(Label lblShuryobi) {
        this.lblShuryobi = lblShuryobi;
    }

    /*
     * getlblKoufubi
     * @return lblKoufubi
     */
    @JsonProperty("lblKoufubi")
    public Label getLblKoufubi() {
        return lblKoufubi;
    }

    /*
     * setlblKoufubi
     * @param lblKoufubi lblKoufubi
     */
    @JsonProperty("lblKoufubi")
    public void setLblKoufubi(Label lblKoufubi) {
        this.lblKoufubi = lblKoufubi;
    }

    /*
     * gettxtKoufubiRange
     * @return txtKoufubiRange
     */
    @JsonProperty("txtKoufubiRange")
    public TextBoxDateRange getTxtKoufubiRange() {
        return txtKoufubiRange;
    }

    /*
     * settxtKoufubiRange
     * @param txtKoufubiRange txtKoufubiRange
     */
    @JsonProperty("txtKoufubiRange")
    public void setTxtKoufubiRange(TextBoxDateRange txtKoufubiRange) {
        this.txtKoufubiRange = txtKoufubiRange;
    }

    /*
     * getlblKaishubi
     * @return lblKaishubi
     */
    @JsonProperty("lblKaishubi")
    public Label getLblKaishubi() {
        return lblKaishubi;
    }

    /*
     * setlblKaishubi
     * @param lblKaishubi lblKaishubi
     */
    @JsonProperty("lblKaishubi")
    public void setLblKaishubi(Label lblKaishubi) {
        this.lblKaishubi = lblKaishubi;
    }

    /*
     * gettxtKaishubiRange
     * @return txtKaishubiRange
     */
    @JsonProperty("txtKaishubiRange")
    public TextBoxDateRange getTxtKaishubiRange() {
        return txtKaishubiRange;
    }

    /*
     * settxtKaishubiRange
     * @param txtKaishubiRange txtKaishubiRange
     */
    @JsonProperty("txtKaishubiRange")
    public void setTxtKaishubiRange(TextBoxDateRange txtKaishubiRange) {
        this.txtKaishubiRange = txtKaishubiRange;
    }

    /*
     * getchkSaishinJoho
     * @return chkSaishinJoho
     */
    @JsonProperty("chkSaishinJoho")
    public CheckBoxList getChkSaishinJoho() {
        return chkSaishinJoho;
    }

    /*
     * setchkSaishinJoho
     * @param chkSaishinJoho chkSaishinJoho
     */
    @JsonProperty("chkSaishinJoho")
    public void setChkSaishinJoho(CheckBoxList chkSaishinJoho) {
        this.chkSaishinJoho = chkSaishinJoho;
    }

    /*
     * gethrl4
     * @return hrl4
     */
    @JsonProperty("hrl4")
    public HorizontalLine getHrl4() {
        return hrl4;
    }

    /*
     * sethrl4
     * @param hrl4 hrl4
     */
    @JsonProperty("hrl4")
    public void setHrl4(HorizontalLine hrl4) {
        this.hrl4 = hrl4;
    }

    /*
     * getlblKoufuJiyu
     * @return lblKoufuJiyu
     */
    @JsonProperty("lblKoufuJiyu")
    public Label getLblKoufuJiyu() {
        return lblKoufuJiyu;
    }

    /*
     * setlblKoufuJiyu
     * @param lblKoufuJiyu lblKoufuJiyu
     */
    @JsonProperty("lblKoufuJiyu")
    public void setLblKoufuJiyu(Label lblKoufuJiyu) {
        this.lblKoufuJiyu = lblKoufuJiyu;
    }

    /*
     * getlblKaishuJiyu
     * @return lblKaishuJiyu
     */
    @JsonProperty("lblKaishuJiyu")
    public Label getLblKaishuJiyu() {
        return lblKaishuJiyu;
    }

    /*
     * setlblKaishuJiyu
     * @param lblKaishuJiyu lblKaishuJiyu
     */
    @JsonProperty("lblKaishuJiyu")
    public void setLblKaishuJiyu(Label lblKaishuJiyu) {
        this.lblKaishuJiyu = lblKaishuJiyu;
    }

    /*
     * getdgKoufuJiyu
     * @return dgKoufuJiyu
     */
    @JsonProperty("dgKoufuJiyu")
    public DataGrid<dgKoufuJiyu_Row> getDgKoufuJiyu() {
        return dgKoufuJiyu;
    }

    /*
     * setdgKoufuJiyu
     * @param dgKoufuJiyu dgKoufuJiyu
     */
    @JsonProperty("dgKoufuJiyu")
    public void setDgKoufuJiyu(DataGrid<dgKoufuJiyu_Row> dgKoufuJiyu) {
        this.dgKoufuJiyu = dgKoufuJiyu;
    }

    /*
     * getdgKaishuJiyu
     * @return dgKaishuJiyu
     */
    @JsonProperty("dgKaishuJiyu")
    public DataGrid<dgKaishuJiyu_Row> getDgKaishuJiyu() {
        return dgKaishuJiyu;
    }

    /*
     * setdgKaishuJiyu
     * @param dgKaishuJiyu dgKaishuJiyu
     */
    @JsonProperty("dgKaishuJiyu")
    public void setDgKaishuJiyu(DataGrid<dgKaishuJiyu_Row> dgKaishuJiyu) {
        this.dgKaishuJiyu = dgKaishuJiyu;
    }

    /*
     * gethrl5
     * @return hrl5
     */
    @JsonProperty("hrl5")
    public HorizontalLine getHrl5() {
        return hrl5;
    }

    /*
     * sethrl5
     * @param hrl5 hrl5
     */
    @JsonProperty("hrl5")
    public void setHrl5(HorizontalLine hrl5) {
        this.hrl5 = hrl5;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
