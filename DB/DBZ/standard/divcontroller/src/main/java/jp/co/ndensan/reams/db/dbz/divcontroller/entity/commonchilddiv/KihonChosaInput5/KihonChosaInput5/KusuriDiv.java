package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput5.KihonChosaInput5;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * Kusuri のクラスファイル
 *
 * @reamsid_L DBE-3000-094 wangjie2
 */
public class KusuriDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKusuri")
    private ButtonDialog btnKusuri;
    @JsonProperty("radKusuri")
    private RadioButton radKusuri;
    @JsonProperty("KusuriShinseishoKanriNo")
    private RString KusuriShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKusuri
     * @return btnKusuri
     */
    @JsonProperty("btnKusuri")
    public ButtonDialog getBtnKusuri() {
        return btnKusuri;
    }

    /*
     * setbtnKusuri
     * @param btnKusuri btnKusuri
     */
    @JsonProperty("btnKusuri")
    public void setBtnKusuri(ButtonDialog btnKusuri) {
        this.btnKusuri = btnKusuri;
    }

    /*
     * getradKusuri
     * @return radKusuri
     */
    @JsonProperty("radKusuri")
    public RadioButton getRadKusuri() {
        return radKusuri;
    }

    /*
     * setradKusuri
     * @param radKusuri radKusuri
     */
    @JsonProperty("radKusuri")
    public void setRadKusuri(RadioButton radKusuri) {
        this.radKusuri = radKusuri;
    }

    /*
     * getKusuriShinseishoKanriNo
     * @return KusuriShinseishoKanriNo
     */
    @JsonProperty("KusuriShinseishoKanriNo")
    public RString getKusuriShinseishoKanriNo() {
        return KusuriShinseishoKanriNo;
    }

    /*
     * setKusuriShinseishoKanriNo
     * @param KusuriShinseishoKanriNo KusuriShinseishoKanriNo
     */
    @JsonProperty("KusuriShinseishoKanriNo")
    public void setKusuriShinseishoKanriNo(RString KusuriShinseishoKanriNo) {
        this.KusuriShinseishoKanriNo = KusuriShinseishoKanriNo;
    }

    // </editor-fold>
}
