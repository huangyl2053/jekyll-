package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011;
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
 * BatchParamterInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class BatchParamterInfoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chktaishodaicho")
    private CheckBoxList chktaishodaicho;
    @JsonProperty("HLine1")
    private HorizontalLine HLine1;
    @JsonProperty("lblido")
    private Label lblido;
    @JsonProperty("txtzenkaikaishi")
    private TextBoxFlexibleDate txtzenkaikaishi;
    @JsonProperty("txtzenkaishuryo")
    private TextBoxFlexibleDate txtzenkaishuryo;
    @JsonProperty("txtkonkaikaishi")
    private TextBoxFlexibleDate txtkonkaikaishi;
    @JsonProperty("txtkonkaishuryo")
    private TextBoxFlexibleDate txtkonkaishuryo;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchktaishodaicho
     * @return chktaishodaicho
     */
    @JsonProperty("chktaishodaicho")
    public CheckBoxList getChktaishodaicho() {
        return chktaishodaicho;
    }

    /*
     * setchktaishodaicho
     * @param chktaishodaicho chktaishodaicho
     */
    @JsonProperty("chktaishodaicho")
    public void setChktaishodaicho(CheckBoxList chktaishodaicho) {
        this.chktaishodaicho = chktaishodaicho;
    }

    /*
     * getHLine1
     * @return HLine1
     */
    @JsonProperty("HLine1")
    public HorizontalLine getHLine1() {
        return HLine1;
    }

    /*
     * setHLine1
     * @param HLine1 HLine1
     */
    @JsonProperty("HLine1")
    public void setHLine1(HorizontalLine HLine1) {
        this.HLine1 = HLine1;
    }

    /*
     * getlblido
     * @return lblido
     */
    @JsonProperty("lblido")
    public Label getLblido() {
        return lblido;
    }

    /*
     * setlblido
     * @param lblido lblido
     */
    @JsonProperty("lblido")
    public void setLblido(Label lblido) {
        this.lblido = lblido;
    }

    /*
     * gettxtzenkaikaishi
     * @return txtzenkaikaishi
     */
    @JsonProperty("txtzenkaikaishi")
    public TextBoxFlexibleDate getTxtzenkaikaishi() {
        return txtzenkaikaishi;
    }

    /*
     * settxtzenkaikaishi
     * @param txtzenkaikaishi txtzenkaikaishi
     */
    @JsonProperty("txtzenkaikaishi")
    public void setTxtzenkaikaishi(TextBoxFlexibleDate txtzenkaikaishi) {
        this.txtzenkaikaishi = txtzenkaikaishi;
    }

    /*
     * gettxtzenkaishuryo
     * @return txtzenkaishuryo
     */
    @JsonProperty("txtzenkaishuryo")
    public TextBoxFlexibleDate getTxtzenkaishuryo() {
        return txtzenkaishuryo;
    }

    /*
     * settxtzenkaishuryo
     * @param txtzenkaishuryo txtzenkaishuryo
     */
    @JsonProperty("txtzenkaishuryo")
    public void setTxtzenkaishuryo(TextBoxFlexibleDate txtzenkaishuryo) {
        this.txtzenkaishuryo = txtzenkaishuryo;
    }

    /*
     * gettxtkonkaikaishi
     * @return txtkonkaikaishi
     */
    @JsonProperty("txtkonkaikaishi")
    public TextBoxFlexibleDate getTxtkonkaikaishi() {
        return txtkonkaikaishi;
    }

    /*
     * settxtkonkaikaishi
     * @param txtkonkaikaishi txtkonkaikaishi
     */
    @JsonProperty("txtkonkaikaishi")
    public void setTxtkonkaikaishi(TextBoxFlexibleDate txtkonkaikaishi) {
        this.txtkonkaikaishi = txtkonkaikaishi;
    }

    /*
     * gettxtkonkaishuryo
     * @return txtkonkaishuryo
     */
    @JsonProperty("txtkonkaishuryo")
    public TextBoxFlexibleDate getTxtkonkaishuryo() {
        return txtkonkaishuryo;
    }

    /*
     * settxtkonkaishuryo
     * @param txtkonkaishuryo txtkonkaishuryo
     */
    @JsonProperty("txtkonkaishuryo")
    public void setTxtkonkaishuryo(TextBoxFlexibleDate txtkonkaishuryo) {
        this.txtkonkaishuryo = txtkonkaishuryo;
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
