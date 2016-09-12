package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkChosa")
    private CheckBoxList chkChosa;
    @JsonProperty("chkShujii")
    private CheckBoxList chkShujii;
    @JsonProperty("chkShinsakai")
    private CheckBoxList chkShinsakai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkChosa
     * @return chkChosa
     */
    @JsonProperty("chkChosa")
    public CheckBoxList getChkChosa() {
        return chkChosa;
    }

    /*
     * setchkChosa
     * @param chkChosa chkChosa
     */
    @JsonProperty("chkChosa")
    public void setChkChosa(CheckBoxList chkChosa) {
        this.chkChosa = chkChosa;
    }

    /*
     * getchkShujii
     * @return chkShujii
     */
    @JsonProperty("chkShujii")
    public CheckBoxList getChkShujii() {
        return chkShujii;
    }

    /*
     * setchkShujii
     * @param chkShujii chkShujii
     */
    @JsonProperty("chkShujii")
    public void setChkShujii(CheckBoxList chkShujii) {
        this.chkShujii = chkShujii;
    }

    /*
     * getchkShinsakai
     * @return chkShinsakai
     */
    @JsonProperty("chkShinsakai")
    public CheckBoxList getChkShinsakai() {
        return chkShinsakai;
    }

    /*
     * setchkShinsakai
     * @param chkShinsakai chkShinsakai
     */
    @JsonProperty("chkShinsakai")
    public void setChkShinsakai(CheckBoxList chkShinsakai) {
        this.chkShinsakai = chkShinsakai;
    }

    // </editor-fold>
}
