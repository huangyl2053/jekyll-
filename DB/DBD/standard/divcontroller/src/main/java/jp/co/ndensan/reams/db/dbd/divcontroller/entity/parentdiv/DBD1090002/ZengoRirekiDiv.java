package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZengoRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZengoRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOutputMaeRireki")
    private Button btnOutputMaeRireki;
    @JsonProperty("btnOutputAtoRireki")
    private Button btnOutputAtoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnOutputMaeRireki
     * @return btnOutputMaeRireki
     */
    @JsonProperty("btnOutputMaeRireki")
    public Button getBtnOutputMaeRireki() {
        return btnOutputMaeRireki;
    }

    /*
     * setbtnOutputMaeRireki
     * @param btnOutputMaeRireki btnOutputMaeRireki
     */
    @JsonProperty("btnOutputMaeRireki")
    public void setBtnOutputMaeRireki(Button btnOutputMaeRireki) {
        this.btnOutputMaeRireki = btnOutputMaeRireki;
    }

    /*
     * getbtnOutputAtoRireki
     * @return btnOutputAtoRireki
     */
    @JsonProperty("btnOutputAtoRireki")
    public Button getBtnOutputAtoRireki() {
        return btnOutputAtoRireki;
    }

    /*
     * setbtnOutputAtoRireki
     * @param btnOutputAtoRireki btnOutputAtoRireki
     */
    @JsonProperty("btnOutputAtoRireki")
    public void setBtnOutputAtoRireki(Button btnOutputAtoRireki) {
        this.btnOutputAtoRireki = btnOutputAtoRireki;
    }

    // </editor-fold>
}
