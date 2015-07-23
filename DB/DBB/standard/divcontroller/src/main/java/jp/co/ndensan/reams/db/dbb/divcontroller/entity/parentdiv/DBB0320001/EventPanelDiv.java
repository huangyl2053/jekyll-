package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * EventPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class EventPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnForRirekiFirst")
    private Button btnForRirekiFirst;
    @JsonProperty("btnForRirekiSecond")
    private Button btnForRirekiSecond;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnForRirekiFirst")
    public Button getBtnForRirekiFirst() {
        return btnForRirekiFirst;
    }

    @JsonProperty("btnForRirekiFirst")
    public void setBtnForRirekiFirst(Button btnForRirekiFirst) {
        this.btnForRirekiFirst=btnForRirekiFirst;
    }

    @JsonProperty("btnForRirekiSecond")
    public Button getBtnForRirekiSecond() {
        return btnForRirekiSecond;
    }

    @JsonProperty("btnForRirekiSecond")
    public void setBtnForRirekiSecond(Button btnForRirekiSecond) {
        this.btnForRirekiSecond=btnForRirekiSecond;
    }

    // </editor-fold>
}
