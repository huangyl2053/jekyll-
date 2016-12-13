package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijihanteiKekkaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NijihanteiKekkaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTaishoshaIchiran")
    private DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran;
    @JsonProperty("ShinseishoKanriNo")
    private RString ShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTaishoshaIchiran
     * @return dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return dgTaishoshaIchiran;
    }

    /*
     * setdgTaishoshaIchiran
     * @param dgTaishoshaIchiran dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public void setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.dgTaishoshaIchiran = dgTaishoshaIchiran;
    }

    /*
     * getShinseishoKanriNo
     * @return ShinseishoKanriNo
     */
    @JsonProperty("ShinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return ShinseishoKanriNo;
    }

    /*
     * setShinseishoKanriNo
     * @param ShinseishoKanriNo ShinseishoKanriNo
     */
    @JsonProperty("ShinseishoKanriNo")
    public void setShinseishoKanriNo(RString ShinseishoKanriNo) {
        this.ShinseishoKanriNo = ShinseishoKanriNo;
    }

    // </editor-fold>
}
