package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuairuAppurodo のクラスファイル 
 * 
 * @author 自動生成
 */
public class FuairuAppurodoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplTaishoFuairu")
    private UploadPanel uplTaishoFuairu;
    @JsonProperty("btnAppurodo")
    private Button btnAppurodo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplTaishoFuairu
     * @return uplTaishoFuairu
     */
    @JsonProperty("uplTaishoFuairu")
    public UploadPanel getUplTaishoFuairu() {
        return uplTaishoFuairu;
    }

    /*
     * setuplTaishoFuairu
     * @param uplTaishoFuairu uplTaishoFuairu
     */
    @JsonProperty("uplTaishoFuairu")
    public void setUplTaishoFuairu(UploadPanel uplTaishoFuairu) {
        this.uplTaishoFuairu = uplTaishoFuairu;
    }

    /*
     * getbtnAppurodo
     * @return btnAppurodo
     */
    @JsonProperty("btnAppurodo")
    public Button getBtnAppurodo() {
        return btnAppurodo;
    }

    /*
     * setbtnAppurodo
     * @param btnAppurodo btnAppurodo
     */
    @JsonProperty("btnAppurodo")
    public void setBtnAppurodo(Button btnAppurodo) {
        this.btnAppurodo = btnAppurodo;
    }

    // </editor-fold>
}
