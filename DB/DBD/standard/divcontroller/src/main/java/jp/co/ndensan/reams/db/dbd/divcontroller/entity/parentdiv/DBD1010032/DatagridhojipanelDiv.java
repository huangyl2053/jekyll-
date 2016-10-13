package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Datagridhojipanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DatagridhojipanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiNendo")
    private TextBoxFlexibleYear txtSakuseiNendo;
    @JsonProperty("txtKettaiYMD")
    private TextBoxFlexibleDate txtKettaiYMD;
    @JsonProperty("chkTestKubun")
    private CheckBoxList chkTestKubun;
    @JsonProperty("radHyojiNaiyo")
    private RadioButton radHyojiNaiyo;
    @JsonProperty("dgNinteiIchiran")
    private DataGrid<dgNinteiIchiran_Row> dgNinteiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiNendo
     * @return txtSakuseiNendo
     */
    @JsonProperty("txtSakuseiNendo")
    public TextBoxFlexibleYear getTxtSakuseiNendo() {
        return txtSakuseiNendo;
    }

    /*
     * settxtSakuseiNendo
     * @param txtSakuseiNendo txtSakuseiNendo
     */
    @JsonProperty("txtSakuseiNendo")
    public void setTxtSakuseiNendo(TextBoxFlexibleYear txtSakuseiNendo) {
        this.txtSakuseiNendo = txtSakuseiNendo;
    }

    /*
     * gettxtKettaiYMD
     * @return txtKettaiYMD
     */
    @JsonProperty("txtKettaiYMD")
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return txtKettaiYMD;
    }

    /*
     * settxtKettaiYMD
     * @param txtKettaiYMD txtKettaiYMD
     */
    @JsonProperty("txtKettaiYMD")
    public void setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.txtKettaiYMD = txtKettaiYMD;
    }

    /*
     * getchkTestKubun
     * @return chkTestKubun
     */
    @JsonProperty("chkTestKubun")
    public CheckBoxList getChkTestKubun() {
        return chkTestKubun;
    }

    /*
     * setchkTestKubun
     * @param chkTestKubun chkTestKubun
     */
    @JsonProperty("chkTestKubun")
    public void setChkTestKubun(CheckBoxList chkTestKubun) {
        this.chkTestKubun = chkTestKubun;
    }

    /*
     * getradHyojiNaiyo
     * @return radHyojiNaiyo
     */
    @JsonProperty("radHyojiNaiyo")
    public RadioButton getRadHyojiNaiyo() {
        return radHyojiNaiyo;
    }

    /*
     * setradHyojiNaiyo
     * @param radHyojiNaiyo radHyojiNaiyo
     */
    @JsonProperty("radHyojiNaiyo")
    public void setRadHyojiNaiyo(RadioButton radHyojiNaiyo) {
        this.radHyojiNaiyo = radHyojiNaiyo;
    }

    /*
     * getdgNinteiIchiran
     * @return dgNinteiIchiran
     */
    @JsonProperty("dgNinteiIchiran")
    public DataGrid<dgNinteiIchiran_Row> getDgNinteiIchiran() {
        return dgNinteiIchiran;
    }

    /*
     * setdgNinteiIchiran
     * @param dgNinteiIchiran dgNinteiIchiran
     */
    @JsonProperty("dgNinteiIchiran")
    public void setDgNinteiIchiran(DataGrid<dgNinteiIchiran_Row> dgNinteiIchiran) {
        this.dgNinteiIchiran = dgNinteiIchiran;
    }

    // </editor-fold>
}
