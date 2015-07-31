package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigohokenShikakuKihonJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigohokenShikakuKihonJoho.IKaigohokenShikakuKihonJohoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigohokenShikakuKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigohokenShikakuKihonJohoDiv extends Panel implements IKaigohokenShikakuKihonJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("gdKaigoHokenShikakuKihonJoho")
    private DataGrid<gdKaigoHokenShikakuKihonJoho_Row> gdKaigoHokenShikakuKihonJoho;
    @JsonProperty("btnBack")
    private Button btnBack;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("gdKaigoHokenShikakuKihonJoho")
    public DataGrid<gdKaigoHokenShikakuKihonJoho_Row> getGdKaigoHokenShikakuKihonJoho() {
        return gdKaigoHokenShikakuKihonJoho;
    }

    @JsonProperty("gdKaigoHokenShikakuKihonJoho")
    public void setGdKaigoHokenShikakuKihonJoho(DataGrid<gdKaigoHokenShikakuKihonJoho_Row> gdKaigoHokenShikakuKihonJoho) {
        this.gdKaigoHokenShikakuKihonJoho=gdKaigoHokenShikakuKihonJoho;
    }

    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack=btnBack;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
