package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvShuruiGendoKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvShuruiGendoKakuninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShuruiGendoKakunin")
    private DataGrid<dgShuruiGendoKakunin_Row> dgShuruiGendoKakunin;
    @JsonProperty("btnShuruiGendoGakuKakuninClose")
    private Button btnShuruiGendoGakuKakuninClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShuruiGendoKakunin
     * @return dgShuruiGendoKakunin
     */
    @JsonProperty("dgShuruiGendoKakunin")
    public DataGrid<dgShuruiGendoKakunin_Row> getDgShuruiGendoKakunin() {
        return dgShuruiGendoKakunin;
    }

    /*
     * setdgShuruiGendoKakunin
     * @param dgShuruiGendoKakunin dgShuruiGendoKakunin
     */
    @JsonProperty("dgShuruiGendoKakunin")
    public void setDgShuruiGendoKakunin(DataGrid<dgShuruiGendoKakunin_Row> dgShuruiGendoKakunin) {
        this.dgShuruiGendoKakunin = dgShuruiGendoKakunin;
    }

    /*
     * getbtnShuruiGendoGakuKakuninClose
     * @return btnShuruiGendoGakuKakuninClose
     */
    @JsonProperty("btnShuruiGendoGakuKakuninClose")
    public Button getBtnShuruiGendoGakuKakuninClose() {
        return btnShuruiGendoGakuKakuninClose;
    }

    /*
     * setbtnShuruiGendoGakuKakuninClose
     * @param btnShuruiGendoGakuKakuninClose btnShuruiGendoGakuKakuninClose
     */
    @JsonProperty("btnShuruiGendoGakuKakuninClose")
    public void setBtnShuruiGendoGakuKakuninClose(Button btnShuruiGendoGakuKakuninClose) {
        this.btnShuruiGendoGakuKakuninClose = btnShuruiGendoGakuKakuninClose;
    }

    // </editor-fold>
}
