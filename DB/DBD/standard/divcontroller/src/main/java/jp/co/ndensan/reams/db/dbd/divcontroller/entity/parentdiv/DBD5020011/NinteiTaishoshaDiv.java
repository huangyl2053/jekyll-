package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiTaishoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGaitosha")
    private TextBox txtGaitosha;
    @JsonProperty("dgNinteiTaishosha")
    private DataGrid<dgNinteiTaishosha_Row> dgNinteiTaishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGaitosha
     * @return txtGaitosha
     */
    @JsonProperty("txtGaitosha")
    public TextBox getTxtGaitosha() {
        return txtGaitosha;
    }

    /*
     * settxtGaitosha
     * @param txtGaitosha txtGaitosha
     */
    @JsonProperty("txtGaitosha")
    public void setTxtGaitosha(TextBox txtGaitosha) {
        this.txtGaitosha = txtGaitosha;
    }

    /*
     * getdgNinteiTaishosha
     * @return dgNinteiTaishosha
     */
    @JsonProperty("dgNinteiTaishosha")
    public DataGrid<dgNinteiTaishosha_Row> getDgNinteiTaishosha() {
        return dgNinteiTaishosha;
    }

    /*
     * setdgNinteiTaishosha
     * @param dgNinteiTaishosha dgNinteiTaishosha
     */
    @JsonProperty("dgNinteiTaishosha")
    public void setDgNinteiTaishosha(DataGrid<dgNinteiTaishosha_Row> dgNinteiTaishosha) {
        this.dgNinteiTaishosha = dgNinteiTaishosha;
    }

    // </editor-fold>
}
