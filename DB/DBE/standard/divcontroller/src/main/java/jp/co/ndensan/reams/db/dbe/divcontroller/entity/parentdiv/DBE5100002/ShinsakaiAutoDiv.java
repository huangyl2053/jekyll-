package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiAuto のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiAutoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiAutoBatchParam")
    private ShinsakaiAutoBatchParamDiv ShinsakaiAutoBatchParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiAutoBatchParam
     * @return ShinsakaiAutoBatchParam
     */
    @JsonProperty("ShinsakaiAutoBatchParam")
    public ShinsakaiAutoBatchParamDiv getShinsakaiAutoBatchParam() {
        return ShinsakaiAutoBatchParam;
    }

    /*
     * setShinsakaiAutoBatchParam
     * @param ShinsakaiAutoBatchParam ShinsakaiAutoBatchParam
     */
    @JsonProperty("ShinsakaiAutoBatchParam")
    public void setShinsakaiAutoBatchParam(ShinsakaiAutoBatchParamDiv ShinsakaiAutoBatchParam) {
        this.ShinsakaiAutoBatchParam = ShinsakaiAutoBatchParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgShinsakaiIchiran_Row> getDgShinsakaiIchiran() {
        return this.getShinsakaiAutoBatchParam().getDgShinsakaiIchiran();
    }

    @JsonIgnore
    public void  setDgShinsakaiIchiran(DataGrid<dgShinsakaiIchiran_Row> dgShinsakaiIchiran) {
        this.getShinsakaiAutoBatchParam().setDgShinsakaiIchiran(dgShinsakaiIchiran);
    }

    // </editor-fold>
}
