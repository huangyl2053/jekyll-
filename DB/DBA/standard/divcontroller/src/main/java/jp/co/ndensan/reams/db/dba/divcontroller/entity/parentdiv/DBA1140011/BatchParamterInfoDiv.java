package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun.IKaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * BatchParamterInfo のクラスファイル
 *
 * @author 自動生成
 */
public class BatchParamterInfoDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("lblzenkaikaishi")
    private Label lblzenkaikaishi;
    @JsonProperty("txtzenkaikaishi")
    private TextBoxFlexibleDate txtzenkaikaishi;
    @JsonProperty("lblzenkaikara")
    private Label lblzenkaikara;
    @JsonProperty("txtzenkaishuryo")
    private TextBoxFlexibleDate txtzenkaishuryo;
    @JsonProperty("lblkonkaikaishi")
    private Label lblkonkaikaishi;
    @JsonProperty("txtkonkaikaishi")
    private TextBoxFlexibleDate txtkonkaikaishi;
    @JsonProperty("lblkonkaishuryo")
    private Label lblkonkaishuryo;
    @JsonProperty("txtkonkaishuryo")
    private TextBoxFlexibleDate txtkonkaishuryo;
    @JsonProperty("ccdChohyoShutsurykujun")
    private KaigoChohyoShutsuryokujunDiv ccdChohyoShutsurykujun;

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
     * getlblzenkaikaishi
     * @return lblzenkaikaishi
     */
    @JsonProperty("lblzenkaikaishi")
    public Label getLblzenkaikaishi() {
        return lblzenkaikaishi;
    }

    /*
     * setlblzenkaikaishi
     * @param lblzenkaikaishi lblzenkaikaishi
     */
    @JsonProperty("lblzenkaikaishi")
    public void setLblzenkaikaishi(Label lblzenkaikaishi) {
        this.lblzenkaikaishi = lblzenkaikaishi;
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
     * getlblzenkaikara
     * @return lblzenkaikara
     */
    @JsonProperty("lblzenkaikara")
    public Label getLblzenkaikara() {
        return lblzenkaikara;
    }

    /*
     * setlblzenkaikara
     * @param lblzenkaikara lblzenkaikara
     */
    @JsonProperty("lblzenkaikara")
    public void setLblzenkaikara(Label lblzenkaikara) {
        this.lblzenkaikara = lblzenkaikara;
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
     * getlblkonkaikaishi
     * @return lblkonkaikaishi
     */
    @JsonProperty("lblkonkaikaishi")
    public Label getLblkonkaikaishi() {
        return lblkonkaikaishi;
    }

    /*
     * setlblkonkaikaishi
     * @param lblkonkaikaishi lblkonkaikaishi
     */
    @JsonProperty("lblkonkaikaishi")
    public void setLblkonkaikaishi(Label lblkonkaikaishi) {
        this.lblkonkaikaishi = lblkonkaikaishi;
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
     * getlblkonkaishuryo
     * @return lblkonkaishuryo
     */
    @JsonProperty("lblkonkaishuryo")
    public Label getLblkonkaishuryo() {
        return lblkonkaishuryo;
    }

    /*
     * setlblkonkaishuryo
     * @param lblkonkaishuryo lblkonkaishuryo
     */
    @JsonProperty("lblkonkaishuryo")
    public void setLblkonkaishuryo(Label lblkonkaishuryo) {
        this.lblkonkaishuryo = lblkonkaishuryo;
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
     * getccdChohyoShutsurykujun
     * @return ccdChohyoShutsurykujun
     */
    @JsonProperty("ccdChohyoShutsurykujun")
    public IKaigoChohyoShutsuryokujunDiv getCcdChohyoShutsurykujun() {
        return ccdChohyoShutsurykujun;
    }

    // </editor-fold>
}
