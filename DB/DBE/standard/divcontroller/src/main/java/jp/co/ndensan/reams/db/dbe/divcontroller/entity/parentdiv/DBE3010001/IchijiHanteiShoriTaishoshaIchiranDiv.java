package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHanteiShoriTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiShoriTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    private DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dgIchijiHanteiTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgIchijiHanteiTaishoshaIchiran
     * @return dgIchijiHanteiTaishoshaIchiran
     */
    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    public DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> getDgIchijiHanteiTaishoshaIchiran() {
        return dgIchijiHanteiTaishoshaIchiran;
    }

    /*
     * setdgIchijiHanteiTaishoshaIchiran
     * @param dgIchijiHanteiTaishoshaIchiran dgIchijiHanteiTaishoshaIchiran
     */
    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    public void setDgIchijiHanteiTaishoshaIchiran(DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dgIchijiHanteiTaishoshaIchiran) {
        this.dgIchijiHanteiTaishoshaIchiran = dgIchijiHanteiTaishoshaIchiran;
    }

    // </editor-fold>
}
