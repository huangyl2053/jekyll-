package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SelectResults のクラスファイル 
 * 
 * @author 自動生成
 */
public class SelectResultsDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIchijiHanteiZumi")
    private DataGrid<dgIchijiHanteiZumi_Row> dgIchijiHanteiZumi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgIchijiHanteiZumi
     * @return dgIchijiHanteiZumi
     */
    @JsonProperty("dgIchijiHanteiZumi")
    public DataGrid<dgIchijiHanteiZumi_Row> getDgIchijiHanteiZumi() {
        return dgIchijiHanteiZumi;
    }

    /*
     * setdgIchijiHanteiZumi
     * @param dgIchijiHanteiZumi dgIchijiHanteiZumi
     */
    @JsonProperty("dgIchijiHanteiZumi")
    public void setDgIchijiHanteiZumi(DataGrid<dgIchijiHanteiZumi_Row> dgIchijiHanteiZumi) {
        this.dgIchijiHanteiZumi = dgIchijiHanteiZumi;
    }

    // </editor-fold>
}
