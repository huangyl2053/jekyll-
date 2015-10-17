package jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv.IKaigoJigyoshaServiceListDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv.dgKaigoJigyoshaService_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoJigyoshaServiceList のクラスファイル 
 * 
 * @author 自動生成
 * @jpName
 * @bizDomain 介護
 * @category DAメニュー
 * @subCategory 介護事業者登録
 * @mainClass
 * @reference
 */
public class KaigoJigyoshaServiceListDiv extends Panel implements IKaigoJigyoshaServiceListDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKaigoJigyoshaService")
    private DataGrid<dgKaigoJigyoshaService_Row> dgKaigoJigyoshaService;
    @JsonProperty("btnSet")
    private Button btnSet;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKaigoJigyoshaService")
    public DataGrid<dgKaigoJigyoshaService_Row> getDgKaigoJigyoshaService() {
        return dgKaigoJigyoshaService;
    }

    @JsonProperty("dgKaigoJigyoshaService")
    public void setDgKaigoJigyoshaService(DataGrid<dgKaigoJigyoshaService_Row> dgKaigoJigyoshaService) {
        this.dgKaigoJigyoshaService=dgKaigoJigyoshaService;
    }

    @JsonProperty("btnSet")
    public Button getBtnSet() {
        return btnSet;
    }

    @JsonProperty("btnSet")
    public void setBtnSet(Button btnSet) {
        this.btnSet=btnSet;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
