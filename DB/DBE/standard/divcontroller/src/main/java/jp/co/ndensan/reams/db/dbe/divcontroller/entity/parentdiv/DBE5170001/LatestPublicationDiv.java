package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * LatestPublication のクラスファイル 
 * 
 * @author 自動生成
 */
public class LatestPublicationDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtOperationDate")
    private TextBoxFlexibleDate txtOperationDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtOperationDate
     * @return txtOperationDate
     */
    @JsonProperty("txtOperationDate")
    public TextBoxFlexibleDate getTxtOperationDate() {
        return txtOperationDate;
    }

    /*
     * settxtOperationDate
     * @param txtOperationDate txtOperationDate
     */
    @JsonProperty("txtOperationDate")
    public void setTxtOperationDate(TextBoxFlexibleDate txtOperationDate) {
        this.txtOperationDate = txtOperationDate;
    }

    // </editor-fold>
}
