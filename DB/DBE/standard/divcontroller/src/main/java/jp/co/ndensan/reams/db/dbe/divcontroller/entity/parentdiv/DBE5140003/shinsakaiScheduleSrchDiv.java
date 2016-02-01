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
 * shinsakaiScheduleSrch のクラスファイル 
 * 
 * @author 自動生成
 */
public class shinsakaiScheduleSrchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiKikan")
    private TextBoxDateRange txtShinsakaiKaisaiYoteiKikan;
    @JsonProperty("chkShinsakaiSchedule")
    private CheckBoxList chkShinsakaiSchedule;
    @JsonProperty("chkShinsakaiScheduleKagami")
    private CheckBoxList chkShinsakaiScheduleKagami;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiKaisaiYoteiKikan
     * @return txtShinsakaiKaisaiYoteiKikan
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiKikan")
    public TextBoxDateRange getTxtShinsakaiKaisaiYoteiKikan() {
        return txtShinsakaiKaisaiYoteiKikan;
    }

    /*
     * settxtShinsakaiKaisaiYoteiKikan
     * @param txtShinsakaiKaisaiYoteiKikan txtShinsakaiKaisaiYoteiKikan
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiKikan")
    public void setTxtShinsakaiKaisaiYoteiKikan(TextBoxDateRange txtShinsakaiKaisaiYoteiKikan) {
        this.txtShinsakaiKaisaiYoteiKikan = txtShinsakaiKaisaiYoteiKikan;
    }

    /*
     * getchkShinsakaiSchedule
     * @return chkShinsakaiSchedule
     */
    @JsonProperty("chkShinsakaiSchedule")
    public CheckBoxList getChkShinsakaiSchedule() {
        return chkShinsakaiSchedule;
    }

    /*
     * setchkShinsakaiSchedule
     * @param chkShinsakaiSchedule chkShinsakaiSchedule
     */
    @JsonProperty("chkShinsakaiSchedule")
    public void setChkShinsakaiSchedule(CheckBoxList chkShinsakaiSchedule) {
        this.chkShinsakaiSchedule = chkShinsakaiSchedule;
    }

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

    // </editor-fold>
}
