package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShuturyokuTyouhyou のクラスファイル
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class ShuturyokuTyouhyouDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSyuturyokuTyouhyou")
    private DropDownList ddlSyuturyokuTyouhyou;
    @JsonProperty("chkFDDataSakusei")
    private CheckBoxList chkFDDataSakusei;
    @JsonProperty("txtSakuseibi")
    private TextBoxDate txtSakuseibi;
    @JsonProperty("txtIraibi")
    private TextBoxDate txtIraibi;
    @JsonProperty("txtFurikomiSiteibi")
    private TextBoxDate txtFurikomiSiteibi;
    @JsonProperty("ccdChohyoShusuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShusuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlSyuturyokuTyouhyou
     * @return ddlSyuturyokuTyouhyou
     */
    @JsonProperty("ddlSyuturyokuTyouhyou")
    public DropDownList getDdlSyuturyokuTyouhyou() {
        return ddlSyuturyokuTyouhyou;
    }

    /*
     * setddlSyuturyokuTyouhyou
     * @param ddlSyuturyokuTyouhyou ddlSyuturyokuTyouhyou
     */
    @JsonProperty("ddlSyuturyokuTyouhyou")
    public void setDdlSyuturyokuTyouhyou(DropDownList ddlSyuturyokuTyouhyou) {
        this.ddlSyuturyokuTyouhyou = ddlSyuturyokuTyouhyou;
    }

    /*
     * getchkFDDataSakusei
     * @return chkFDDataSakusei
     */
    @JsonProperty("chkFDDataSakusei")
    public CheckBoxList getChkFDDataSakusei() {
        return chkFDDataSakusei;
    }

    /*
     * setchkFDDataSakusei
     * @param chkFDDataSakusei chkFDDataSakusei
     */
    @JsonProperty("chkFDDataSakusei")
    public void setChkFDDataSakusei(CheckBoxList chkFDDataSakusei) {
        this.chkFDDataSakusei = chkFDDataSakusei;
    }

    /*
     * gettxtSakuseibi
     * @return txtSakuseibi
     */
    @JsonProperty("txtSakuseibi")
    public TextBoxDate getTxtSakuseibi() {
        return txtSakuseibi;
    }

    /*
     * settxtSakuseibi
     * @param txtSakuseibi txtSakuseibi
     */
    @JsonProperty("txtSakuseibi")
    public void setTxtSakuseibi(TextBoxDate txtSakuseibi) {
        this.txtSakuseibi = txtSakuseibi;
    }

    /*
     * gettxtIraibi
     * @return txtIraibi
     */
    @JsonProperty("txtIraibi")
    public TextBoxDate getTxtIraibi() {
        return txtIraibi;
    }

    /*
     * settxtIraibi
     * @param txtIraibi txtIraibi
     */
    @JsonProperty("txtIraibi")
    public void setTxtIraibi(TextBoxDate txtIraibi) {
        this.txtIraibi = txtIraibi;
    }

    /*
     * gettxtFurikomiSiteibi
     * @return txtFurikomiSiteibi
     */
    @JsonProperty("txtFurikomiSiteibi")
    public TextBoxDate getTxtFurikomiSiteibi() {
        return txtFurikomiSiteibi;
    }

    /*
     * settxtFurikomiSiteibi
     * @param txtFurikomiSiteibi txtFurikomiSiteibi
     */
    @JsonProperty("txtFurikomiSiteibi")
    public void setTxtFurikomiSiteibi(TextBoxDate txtFurikomiSiteibi) {
        this.txtFurikomiSiteibi = txtFurikomiSiteibi;
    }

    /*
     * getccdChohyoShusuryokujun
     * @return ccdChohyoShusuryokujun
     */
    @JsonProperty("ccdChohyoShusuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShusuryokujun() {
        return ccdChohyoShusuryokujun;
    }

    // </editor-fold>
}
