package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran1_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran2_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsaShienTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaShienTaishoshaIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShinsaKekkaNyuryokuStart")
    private Button btnShinsaKekkaNyuryokuStart;
    @JsonProperty("btnShinsaKekkaNyuryokuEnd")
    private Button btnShinsaKekkaNyuryokuEnd;
    @JsonProperty("dgShinsaTaishoshaIchiran1")
    private DataGrid<dgShinsaTaishoshaIchiran1_Row> dgShinsaTaishoshaIchiran1;
    @JsonProperty("dgShinsaTaishoshaIchiran2")
    private DataGrid<dgShinsaTaishoshaIchiran2_Row> dgShinsaTaishoshaIchiran2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnShinsaKekkaNyuryokuStart")
    public Button getBtnShinsaKekkaNyuryokuStart() {
        return btnShinsaKekkaNyuryokuStart;
    }

    @JsonProperty("btnShinsaKekkaNyuryokuStart")
    public void setBtnShinsaKekkaNyuryokuStart(Button btnShinsaKekkaNyuryokuStart) {
        this.btnShinsaKekkaNyuryokuStart=btnShinsaKekkaNyuryokuStart;
    }

    @JsonProperty("btnShinsaKekkaNyuryokuEnd")
    public Button getBtnShinsaKekkaNyuryokuEnd() {
        return btnShinsaKekkaNyuryokuEnd;
    }

    @JsonProperty("btnShinsaKekkaNyuryokuEnd")
    public void setBtnShinsaKekkaNyuryokuEnd(Button btnShinsaKekkaNyuryokuEnd) {
        this.btnShinsaKekkaNyuryokuEnd=btnShinsaKekkaNyuryokuEnd;
    }

    @JsonProperty("dgShinsaTaishoshaIchiran1")
    public DataGrid<dgShinsaTaishoshaIchiran1_Row> getDgShinsaTaishoshaIchiran1() {
        return dgShinsaTaishoshaIchiran1;
    }

    @JsonProperty("dgShinsaTaishoshaIchiran1")
    public void setDgShinsaTaishoshaIchiran1(DataGrid<dgShinsaTaishoshaIchiran1_Row> dgShinsaTaishoshaIchiran1) {
        this.dgShinsaTaishoshaIchiran1=dgShinsaTaishoshaIchiran1;
    }

    @JsonProperty("dgShinsaTaishoshaIchiran2")
    public DataGrid<dgShinsaTaishoshaIchiran2_Row> getDgShinsaTaishoshaIchiran2() {
        return dgShinsaTaishoshaIchiran2;
    }

    @JsonProperty("dgShinsaTaishoshaIchiran2")
    public void setDgShinsaTaishoshaIchiran2(DataGrid<dgShinsaTaishoshaIchiran2_Row> dgShinsaTaishoshaIchiran2) {
        this.dgShinsaTaishoshaIchiran2=dgShinsaTaishoshaIchiran2;
    }

}
