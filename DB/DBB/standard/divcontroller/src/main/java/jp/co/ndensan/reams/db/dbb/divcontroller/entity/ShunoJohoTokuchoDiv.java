package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgTokucho_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShunoJohoTokucho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShunoJohoTokuchoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokucho")
    private DataGrid<dgTokucho_Row> dgTokucho;
    @JsonProperty("txtTokuChoteiGeoukei")
    private TextBoxNum txtTokuChoteiGeoukei;
    @JsonProperty("txtTokuShunyuGeoukei")
    private TextBoxNum txtTokuShunyuGeoukei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTokucho")
    public DataGrid<dgTokucho_Row> getDgTokucho() {
        return dgTokucho;
    }

    @JsonProperty("dgTokucho")
    public void setDgTokucho(DataGrid<dgTokucho_Row> dgTokucho) {
        this.dgTokucho=dgTokucho;
    }

    @JsonProperty("txtTokuChoteiGeoukei")
    public TextBoxNum getTxtTokuChoteiGeoukei() {
        return txtTokuChoteiGeoukei;
    }

    @JsonProperty("txtTokuChoteiGeoukei")
    public void setTxtTokuChoteiGeoukei(TextBoxNum txtTokuChoteiGeoukei) {
        this.txtTokuChoteiGeoukei=txtTokuChoteiGeoukei;
    }

    @JsonProperty("txtTokuShunyuGeoukei")
    public TextBoxNum getTxtTokuShunyuGeoukei() {
        return txtTokuShunyuGeoukei;
    }

    @JsonProperty("txtTokuShunyuGeoukei")
    public void setTxtTokuShunyuGeoukei(TextBoxNum txtTokuShunyuGeoukei) {
        this.txtTokuShunyuGeoukei=txtTokuShunyuGeoukei;
    }

}
