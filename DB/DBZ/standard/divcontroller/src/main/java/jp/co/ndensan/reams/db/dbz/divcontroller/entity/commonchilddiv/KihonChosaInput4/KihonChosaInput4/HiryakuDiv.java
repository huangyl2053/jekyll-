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
 * Hiryaku のクラスファイル
 *
 * @author 自動生成
 */
public class HiryakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHiryaku")
    private ButtonDialog btnHiryaku;
    @JsonProperty("radbtnHiryaku")
    private RadioButton radbtnHiryaku;
    @JsonProperty("HiryakuShinseishoKanriNo")
    private RString HiryakuShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHiryaku
     * @return btnHiryaku
     */
    @JsonProperty("btnHiryaku")
    public ButtonDialog getBtnHiryaku() {
        return btnHiryaku;
    }

    /*
     * setbtnHiryaku
     * @param btnHiryaku btnHiryaku
     */
    @JsonProperty("btnHiryaku")
    public void setBtnHiryaku(ButtonDialog btnHiryaku) {
        this.btnHiryaku = btnHiryaku;
    }

    /*
     * getradbtnHiryaku
     * @return radbtnHiryaku
     */
    @JsonProperty("radbtnHiryaku")
    public RadioButton getRadbtnHiryaku() {
        return radbtnHiryaku;
    }

    /*
     * setradbtnHiryaku
     * @param radbtnHiryaku radbtnHiryaku
     */
    @JsonProperty("radbtnHiryaku")
    public void setRadbtnHiryaku(RadioButton radbtnHiryaku) {
        this.radbtnHiryaku = radbtnHiryaku;
    }

    /*
     * getHiryakuShinseishoKanriNo
     * @return HiryakuShinseishoKanriNo
     */
    @JsonProperty("HiryakuShinseishoKanriNo")
    public RString getHiryakuShinseishoKanriNo() {
        return HiryakuShinseishoKanriNo;
    }

    /*
     * setHiryakuShinseishoKanriNo
     * @param HiryakuShinseishoKanriNo HiryakuShinseishoKanriNo
     */
    @JsonProperty("HiryakuShinseishoKanriNo")
    public void setHiryakuShinseishoKanriNo(RString HiryakuShinseishoKanriNo) {
        this.HiryakuShinseishoKanriNo = HiryakuShinseishoKanriNo;
    }

    // </editor-fold>
}
