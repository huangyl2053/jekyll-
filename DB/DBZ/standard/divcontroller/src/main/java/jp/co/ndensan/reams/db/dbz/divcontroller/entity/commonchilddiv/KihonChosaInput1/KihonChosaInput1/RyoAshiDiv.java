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
 * RyoAshi のクラスファイル
 *
 * @author 自動生成
 */
public class RyoAshiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnRyoAshi")
    private ButtonDialog btnRyoAshi;
    @JsonProperty("radRyoAshi")
    private RadioButton radRyoAshi;
    @JsonProperty("RyoAshiShinseishoKanriNo")
    private RString RyoAshiShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnRyoAshi
     * @return btnRyoAshi
     */
    @JsonProperty("btnRyoAshi")
    public ButtonDialog getBtnRyoAshi() {
        return btnRyoAshi;
    }

    /*
     * setbtnRyoAshi
     * @param btnRyoAshi btnRyoAshi
     */
    @JsonProperty("btnRyoAshi")
    public void setBtnRyoAshi(ButtonDialog btnRyoAshi) {
        this.btnRyoAshi = btnRyoAshi;
    }

    /*
     * getradRyoAshi
     * @return radRyoAshi
     */
    @JsonProperty("radRyoAshi")
    public RadioButton getRadRyoAshi() {
        return radRyoAshi;
    }

    /*
     * setradRyoAshi
     * @param radRyoAshi radRyoAshi
     */
    @JsonProperty("radRyoAshi")
    public void setRadRyoAshi(RadioButton radRyoAshi) {
        this.radRyoAshi = radRyoAshi;
    }

    /*
     * getRyoAshiShinseishoKanriNo
     * @return RyoAshiShinseishoKanriNo
     */
    @JsonProperty("RyoAshiShinseishoKanriNo")
    public RString getRyoAshiShinseishoKanriNo() {
        return RyoAshiShinseishoKanriNo;
    }

    /*
     * setRyoAshiShinseishoKanriNo
     * @param RyoAshiShinseishoKanriNo RyoAshiShinseishoKanriNo
     */
    @JsonProperty("RyoAshiShinseishoKanriNo")
    public void setRyoAshiShinseishoKanriNo(RString RyoAshiShinseishoKanriNo) {
        this.RyoAshiShinseishoKanriNo = RyoAshiShinseishoKanriNo;
    }

    // </editor-fold>
}
