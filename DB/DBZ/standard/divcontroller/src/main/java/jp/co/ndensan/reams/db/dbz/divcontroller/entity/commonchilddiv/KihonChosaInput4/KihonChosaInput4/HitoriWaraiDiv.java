package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;
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
 * HitoriWarai のクラスファイル
 *
 * @reamsid_L DBE-3000-093 wangjie2
 */
public class HitoriWaraiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHitoriWarai")
    private ButtonDialog btnHitoriWarai;
    @JsonProperty("radHitoriWarai")
    private RadioButton radHitoriWarai;
    @JsonProperty("HitoriWaraiShinseishoKanriNo")
    private RString HitoriWaraiShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHitoriWarai
     * @return btnHitoriWarai
     */
    @JsonProperty("btnHitoriWarai")
    public ButtonDialog getBtnHitoriWarai() {
        return btnHitoriWarai;
    }

    /*
     * setbtnHitoriWarai
     * @param btnHitoriWarai btnHitoriWarai
     */
    @JsonProperty("btnHitoriWarai")
    public void setBtnHitoriWarai(ButtonDialog btnHitoriWarai) {
        this.btnHitoriWarai = btnHitoriWarai;
    }

    /*
     * getradHitoriWarai
     * @return radHitoriWarai
     */
    @JsonProperty("radHitoriWarai")
    public RadioButton getRadHitoriWarai() {
        return radHitoriWarai;
    }

    /*
     * setradHitoriWarai
     * @param radHitoriWarai radHitoriWarai
     */
    @JsonProperty("radHitoriWarai")
    public void setRadHitoriWarai(RadioButton radHitoriWarai) {
        this.radHitoriWarai = radHitoriWarai;
    }

    /*
     * getHitoriWaraiShinseishoKanriNo
     * @return HitoriWaraiShinseishoKanriNo
     */
    @JsonProperty("HitoriWaraiShinseishoKanriNo")
    public RString getHitoriWaraiShinseishoKanriNo() {
        return HitoriWaraiShinseishoKanriNo;
    }

    /*
     * setHitoriWaraiShinseishoKanriNo
     * @param HitoriWaraiShinseishoKanriNo HitoriWaraiShinseishoKanriNo
     */
    @JsonProperty("HitoriWaraiShinseishoKanriNo")
    public void setHitoriWaraiShinseishoKanriNo(RString HitoriWaraiShinseishoKanriNo) {
        this.HitoriWaraiShinseishoKanriNo = HitoriWaraiShinseishoKanriNo;
    }

    // </editor-fold>
}
