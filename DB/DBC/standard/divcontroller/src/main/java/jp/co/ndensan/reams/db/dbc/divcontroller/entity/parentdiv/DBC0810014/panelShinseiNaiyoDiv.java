package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShinseiNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShinseiNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdServiceTeikyoShomeisyo")
    private DataGrid<dgdServiceTeikyoShomeisyo_Row> dgdServiceTeikyoShomeisyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdServiceTeikyoShomeisyo
     * @return dgdServiceTeikyoShomeisyo
     */
    @JsonProperty("dgdServiceTeikyoShomeisyo")
    public DataGrid<dgdServiceTeikyoShomeisyo_Row> getDgdServiceTeikyoShomeisyo() {
        return dgdServiceTeikyoShomeisyo;
    }

    /*
     * setdgdServiceTeikyoShomeisyo
     * @param dgdServiceTeikyoShomeisyo dgdServiceTeikyoShomeisyo
     */
    @JsonProperty("dgdServiceTeikyoShomeisyo")
    public void setDgdServiceTeikyoShomeisyo(DataGrid<dgdServiceTeikyoShomeisyo_Row> dgdServiceTeikyoShomeisyo) {
        this.dgdServiceTeikyoShomeisyo = dgdServiceTeikyoShomeisyo;
    }

    // </editor-fold>
}
