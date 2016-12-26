package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HasseiJotaiTaishoHoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HasseiJotaiTaishoHoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkHasseiShojo")
    private CheckBoxList chkHasseiShojo;
    @JsonProperty("Dummy01")
    private Space Dummy01;
    @JsonProperty("chkJotaiSonota")
    private CheckBoxList chkJotaiSonota;
    @JsonProperty("txtSonotaJotaiShosai")
    private TextBox txtSonotaJotaiShosai;
    @JsonProperty("txtTaishoHoushin")
    private TextBox txtTaishoHoushin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkHasseiShojo
     * @return chkHasseiShojo
     */
    @JsonProperty("chkHasseiShojo")
    public CheckBoxList getChkHasseiShojo() {
        return chkHasseiShojo;
    }

    /*
     * setchkHasseiShojo
     * @param chkHasseiShojo chkHasseiShojo
     */
    @JsonProperty("chkHasseiShojo")
    public void setChkHasseiShojo(CheckBoxList chkHasseiShojo) {
        this.chkHasseiShojo = chkHasseiShojo;
    }

    /*
     * getDummy01
     * @return Dummy01
     */
    @JsonProperty("Dummy01")
    public Space getDummy01() {
        return Dummy01;
    }

    /*
     * setDummy01
     * @param Dummy01 Dummy01
     */
    @JsonProperty("Dummy01")
    public void setDummy01(Space Dummy01) {
        this.Dummy01 = Dummy01;
    }

    /*
     * getchkJotaiSonota
     * @return chkJotaiSonota
     */
    @JsonProperty("chkJotaiSonota")
    public CheckBoxList getChkJotaiSonota() {
        return chkJotaiSonota;
    }

    /*
     * setchkJotaiSonota
     * @param chkJotaiSonota chkJotaiSonota
     */
    @JsonProperty("chkJotaiSonota")
    public void setChkJotaiSonota(CheckBoxList chkJotaiSonota) {
        this.chkJotaiSonota = chkJotaiSonota;
    }

    /*
     * gettxtSonotaJotaiShosai
     * @return txtSonotaJotaiShosai
     */
    @JsonProperty("txtSonotaJotaiShosai")
    public TextBox getTxtSonotaJotaiShosai() {
        return txtSonotaJotaiShosai;
    }

    /*
     * settxtSonotaJotaiShosai
     * @param txtSonotaJotaiShosai txtSonotaJotaiShosai
     */
    @JsonProperty("txtSonotaJotaiShosai")
    public void setTxtSonotaJotaiShosai(TextBox txtSonotaJotaiShosai) {
        this.txtSonotaJotaiShosai = txtSonotaJotaiShosai;
    }

    /*
     * gettxtTaishoHoushin
     * @return txtTaishoHoushin
     */
    @JsonProperty("txtTaishoHoushin")
    public TextBox getTxtTaishoHoushin() {
        return txtTaishoHoushin;
    }

    /*
     * settxtTaishoHoushin
     * @param txtTaishoHoushin txtTaishoHoushin
     */
    @JsonProperty("txtTaishoHoushin")
    public void setTxtTaishoHoushin(TextBox txtTaishoHoushin) {
        this.txtTaishoHoushin = txtTaishoHoushin;
    }

    // </editor-fold>
}
