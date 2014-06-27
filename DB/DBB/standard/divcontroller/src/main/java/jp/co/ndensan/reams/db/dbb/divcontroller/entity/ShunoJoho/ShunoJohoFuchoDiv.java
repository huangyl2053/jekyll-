package jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShunoJoho;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShunoJoho.dgFucho_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShunoJohoFucho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShunoJohoFuchoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgFucho")
    private DataGrid<dgFucho_Row> dgFucho;
    @JsonProperty("txtFuChoteiGeoukei")
    private TextBoxNum txtFuChoteiGeoukei;
    @JsonProperty("txtFuShunyuGeoukei")
    private TextBoxNum txtFuShunyuGeoukei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgFucho")
    public DataGrid<dgFucho_Row> getDgFucho() {
        return dgFucho;
    }

    @JsonProperty("dgFucho")
    public void setDgFucho(DataGrid<dgFucho_Row> dgFucho) {
        this.dgFucho=dgFucho;
    }

    @JsonProperty("txtFuChoteiGeoukei")
    public TextBoxNum getTxtFuChoteiGeoukei() {
        return txtFuChoteiGeoukei;
    }

    @JsonProperty("txtFuChoteiGeoukei")
    public void setTxtFuChoteiGeoukei(TextBoxNum txtFuChoteiGeoukei) {
        this.txtFuChoteiGeoukei=txtFuChoteiGeoukei;
    }

    @JsonProperty("txtFuShunyuGeoukei")
    public TextBoxNum getTxtFuShunyuGeoukei() {
        return txtFuShunyuGeoukei;
    }

    @JsonProperty("txtFuShunyuGeoukei")
    public void setTxtFuShunyuGeoukei(TextBoxNum txtFuShunyuGeoukei) {
        this.txtFuShunyuGeoukei=txtFuShunyuGeoukei;
    }

}
