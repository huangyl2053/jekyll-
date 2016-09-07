package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YokaigoNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigoNinteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDay")
    private TextBoxDateRange txtShinseiDay;
    @JsonProperty("txtNinteiDay")
    private TextBoxDateRange txtNinteiDay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDay
     * @return txtShinseiDay
     */
    @JsonProperty("txtShinseiDay")
    public TextBoxDateRange getTxtShinseiDay() {
        return txtShinseiDay;
    }

    /*
     * settxtShinseiDay
     * @param txtShinseiDay txtShinseiDay
     */
    @JsonProperty("txtShinseiDay")
    public void setTxtShinseiDay(TextBoxDateRange txtShinseiDay) {
        this.txtShinseiDay = txtShinseiDay;
    }

    /*
     * gettxtNinteiDay
     * @return txtNinteiDay
     */
    @JsonProperty("txtNinteiDay")
    public TextBoxDateRange getTxtNinteiDay() {
        return txtNinteiDay;
    }

    /*
     * settxtNinteiDay
     * @param txtNinteiDay txtNinteiDay
     */
    @JsonProperty("txtNinteiDay")
    public void setTxtNinteiDay(TextBoxDateRange txtNinteiDay) {
        this.txtNinteiDay = txtNinteiDay;
    }

    // </editor-fold>
}
