package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * shinsakaiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class shinsakaiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-13_17-59-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKensakuKaisaiYoteiYmd")
    private TextBoxDateRange txtKensakuKaisaiYoteiYmd;
    @JsonProperty("btnSearchShinsakai")
    private Button btnSearchShinsakai;
    @JsonProperty("txtShinsakaiMaxHyojiKensu")
    private TextBoxNum txtShinsakaiMaxHyojiKensu;
    @JsonProperty("dgShinsakaiList")
    private DataGrid<dgShinsakaiList_Row> dgShinsakaiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKensakuKaisaiYoteiYmd
     * @return txtKensakuKaisaiYoteiYmd
     */
    @JsonProperty("txtKensakuKaisaiYoteiYmd")
    public TextBoxDateRange getTxtKensakuKaisaiYoteiYmd() {
        return txtKensakuKaisaiYoteiYmd;
    }

    /*
     * settxtKensakuKaisaiYoteiYmd
     * @param txtKensakuKaisaiYoteiYmd txtKensakuKaisaiYoteiYmd
     */
    @JsonProperty("txtKensakuKaisaiYoteiYmd")
    public void setTxtKensakuKaisaiYoteiYmd(TextBoxDateRange txtKensakuKaisaiYoteiYmd) {
        this.txtKensakuKaisaiYoteiYmd = txtKensakuKaisaiYoteiYmd;
    }

    /*
     * getbtnSearchShinsakai
     * @return btnSearchShinsakai
     */
    @JsonProperty("btnSearchShinsakai")
    public Button getBtnSearchShinsakai() {
        return btnSearchShinsakai;
    }

    /*
     * setbtnSearchShinsakai
     * @param btnSearchShinsakai btnSearchShinsakai
     */
    @JsonProperty("btnSearchShinsakai")
    public void setBtnSearchShinsakai(Button btnSearchShinsakai) {
        this.btnSearchShinsakai = btnSearchShinsakai;
    }

    /*
     * gettxtShinsakaiMaxHyojiKensu
     * @return txtShinsakaiMaxHyojiKensu
     */
    @JsonProperty("txtShinsakaiMaxHyojiKensu")
    public TextBoxNum getTxtShinsakaiMaxHyojiKensu() {
        return txtShinsakaiMaxHyojiKensu;
    }

    /*
     * settxtShinsakaiMaxHyojiKensu
     * @param txtShinsakaiMaxHyojiKensu txtShinsakaiMaxHyojiKensu
     */
    @JsonProperty("txtShinsakaiMaxHyojiKensu")
    public void setTxtShinsakaiMaxHyojiKensu(TextBoxNum txtShinsakaiMaxHyojiKensu) {
        this.txtShinsakaiMaxHyojiKensu = txtShinsakaiMaxHyojiKensu;
    }

    /*
     * getdgShinsakaiList
     * @return dgShinsakaiList
     */
    @JsonProperty("dgShinsakaiList")
    public DataGrid<dgShinsakaiList_Row> getDgShinsakaiList() {
        return dgShinsakaiList;
    }

    /*
     * setdgShinsakaiList
     * @param dgShinsakaiList dgShinsakaiList
     */
    @JsonProperty("dgShinsakaiList")
    public void setDgShinsakaiList(DataGrid<dgShinsakaiList_Row> dgShinsakaiList) {
        this.dgShinsakaiList = dgShinsakaiList;
    }

    // </editor-fold>
}
