package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;
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
 * KataAshi のクラスファイル
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KataAshiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKataAshi")
    private ButtonDialog btnKataAshi;
    @JsonProperty("radKataAshi")
    private RadioButton radKataAshi;
    @JsonProperty("KataAshiShinseishoKanriNo")
    private RString KataAshiShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKataAshi
     * @return btnKataAshi
     */
    @JsonProperty("btnKataAshi")
    public ButtonDialog getBtnKataAshi() {
        return btnKataAshi;
    }

    /*
     * setbtnKataAshi
     * @param btnKataAshi btnKataAshi
     */
    @JsonProperty("btnKataAshi")
    public void setBtnKataAshi(ButtonDialog btnKataAshi) {
        this.btnKataAshi = btnKataAshi;
    }

    /*
     * getradKataAshi
     * @return radKataAshi
     */
    @JsonProperty("radKataAshi")
    public RadioButton getRadKataAshi() {
        return radKataAshi;
    }

    /*
     * setradKataAshi
     * @param radKataAshi radKataAshi
     */
    @JsonProperty("radKataAshi")
    public void setRadKataAshi(RadioButton radKataAshi) {
        this.radKataAshi = radKataAshi;
    }

    /*
     * getKataAshiShinseishoKanriNo
     * @return KataAshiShinseishoKanriNo
     */
    @JsonProperty("KataAshiShinseishoKanriNo")
    public RString getKataAshiShinseishoKanriNo() {
        return KataAshiShinseishoKanriNo;
    }

    /*
     * setKataAshiShinseishoKanriNo
     * @param KataAshiShinseishoKanriNo KataAshiShinseishoKanriNo
     */
    @JsonProperty("KataAshiShinseishoKanriNo")
    public void setKataAshiShinseishoKanriNo(RString KataAshiShinseishoKanriNo) {
        this.KataAshiShinseishoKanriNo = KataAshiShinseishoKanriNo;
    }

    // </editor-fold>
}
