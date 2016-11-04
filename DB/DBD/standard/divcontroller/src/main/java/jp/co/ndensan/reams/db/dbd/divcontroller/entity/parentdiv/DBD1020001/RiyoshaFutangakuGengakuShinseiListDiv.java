package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyoshaFutangakuGengakuShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutangakuGengakuShinseiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnInputNew")
    private Button btnInputNew;
    @JsonProperty("ddlShinseiIchiran")
    private DataGrid<ddlShinseiIchiran_Row> ddlShinseiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnInputNew
     * @return btnInputNew
     */
    @JsonProperty("btnInputNew")
    public Button getBtnInputNew() {
        return btnInputNew;
    }

    /*
     * setbtnInputNew
     * @param btnInputNew btnInputNew
     */
    @JsonProperty("btnInputNew")
    public void setBtnInputNew(Button btnInputNew) {
        this.btnInputNew = btnInputNew;
    }

    /*
     * getddlShinseiIchiran
     * @return ddlShinseiIchiran
     */
    @JsonProperty("ddlShinseiIchiran")
    public DataGrid<ddlShinseiIchiran_Row> getDdlShinseiIchiran() {
        return ddlShinseiIchiran;
    }

    /*
     * setddlShinseiIchiran
     * @param ddlShinseiIchiran ddlShinseiIchiran
     */
    @JsonProperty("ddlShinseiIchiran")
    public void setDdlShinseiIchiran(DataGrid<ddlShinseiIchiran_Row> ddlShinseiIchiran) {
        this.ddlShinseiIchiran = ddlShinseiIchiran;
    }

    // </editor-fold>
}
