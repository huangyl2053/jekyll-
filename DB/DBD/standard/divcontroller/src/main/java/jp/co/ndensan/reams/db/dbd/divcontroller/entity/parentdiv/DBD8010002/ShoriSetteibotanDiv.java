package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriSetteibotan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriSetteibotanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShoriSettei")
    private Button btnShoriSettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShoriSettei
     * @return btnShoriSettei
     */
    @JsonProperty("btnShoriSettei")
    public Button getBtnShoriSettei() {
        return btnShoriSettei;
    }

    /*
     * setbtnShoriSettei
     * @param btnShoriSettei btnShoriSettei
     */
    @JsonProperty("btnShoriSettei")
    public void setBtnShoriSettei(Button btnShoriSettei) {
        this.btnShoriSettei = btnShoriSettei;
    }

    // </editor-fold>
}
