package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelTekiyoRireki のクラスファイル
 *
 */
public class panelTekiyoRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("datagridTekiyoJogai")
    private DataGrid<datagridTekiyoJogai_Row> datagridTekiyoJogai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdatagridTekiyoJogai
     * @return datagridTekiyoJogai
     */
    @JsonProperty("datagridTekiyoJogai")
    public DataGrid<datagridTekiyoJogai_Row> getDatagridTekiyoJogai() {
        return datagridTekiyoJogai;
    }

    /*
     * setdatagridTekiyoJogai
     * @param datagridTekiyoJogai datagridTekiyoJogai
     */
    @JsonProperty("datagridTekiyoJogai")
    public void setDatagridTekiyoJogai(DataGrid<datagridTekiyoJogai_Row> datagridTekiyoJogai) {
        this.datagridTekiyoJogai = datagridTekiyoJogai;
    }

    // </editor-fold>
}
