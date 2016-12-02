package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-24_17-05-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaisaibi")
    private TextBoxDate txtShinsakaiKaisaibi;
    @JsonProperty("txtShinsakaiYoteibi")
    private TextBoxDate txtShinsakaiYoteibi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiKaisaibi
     * @return txtShinsakaiKaisaibi
     */
    @JsonProperty("txtShinsakaiKaisaibi")
    public TextBoxDate getTxtShinsakaiKaisaibi() {
        return txtShinsakaiKaisaibi;
    }

    /*
     * settxtShinsakaiKaisaibi
     * @param txtShinsakaiKaisaibi txtShinsakaiKaisaibi
     */
    @JsonProperty("txtShinsakaiKaisaibi")
    public void setTxtShinsakaiKaisaibi(TextBoxDate txtShinsakaiKaisaibi) {
        this.txtShinsakaiKaisaibi = txtShinsakaiKaisaibi;
    }

    /*
     * gettxtShinsakaiYoteibi
     * @return txtShinsakaiYoteibi
     */
    @JsonProperty("txtShinsakaiYoteibi")
    public TextBoxDate getTxtShinsakaiYoteibi() {
        return txtShinsakaiYoteibi;
    }

    /*
     * settxtShinsakaiYoteibi
     * @param txtShinsakaiYoteibi txtShinsakaiYoteibi
     */
    @JsonProperty("txtShinsakaiYoteibi")
    public void setTxtShinsakaiYoteibi(TextBoxDate txtShinsakaiYoteibi) {
        this.txtShinsakaiYoteibi = txtShinsakaiYoteibi;
    }

    // </editor-fold>
}
