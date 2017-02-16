package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SchedulePrintOption のクラスファイル 
 * 
 * @author 自動生成
 */
public class SchedulePrintOptionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-10_08-47-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShinsakaiScheduleKagami")
    private CheckBoxList chkShinsakaiScheduleKagami;
    @JsonProperty("txtNendo")
    private TextBoxDate txtNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShinsakaiScheduleKagami
     * @return chkShinsakaiScheduleKagami
     */
    @JsonProperty("chkShinsakaiScheduleKagami")
    public CheckBoxList getChkShinsakaiScheduleKagami() {
        return chkShinsakaiScheduleKagami;
    }

    /*
     * setchkShinsakaiScheduleKagami
     * @param chkShinsakaiScheduleKagami chkShinsakaiScheduleKagami
     */
    @JsonProperty("chkShinsakaiScheduleKagami")
    public void setChkShinsakaiScheduleKagami(CheckBoxList chkShinsakaiScheduleKagami) {
        this.chkShinsakaiScheduleKagami = chkShinsakaiScheduleKagami;
    }

    /*
     * gettxtNendo
     * @return txtNendo
     */
    @JsonProperty("txtNendo")
    public TextBoxDate getTxtNendo() {
        return txtNendo;
    }

    /*
     * settxtNendo
     * @param txtNendo txtNendo
     */
    @JsonProperty("txtNendo")
    public void setTxtNendo(TextBoxDate txtNendo) {
        this.txtNendo = txtNendo;
    }

    // </editor-fold>
}
