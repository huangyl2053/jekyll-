package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiGokeiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiMeisaiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuJissekiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyufuJissekiListHihokenshaNo")
    private TextBox txtKyufuJissekiListHihokenshaNo;
    @JsonProperty("txtKyufuJissekiListJuminShubetsu")
    private TextBox txtKyufuJissekiListJuminShubetsu;
    @JsonProperty("txtKyufuJissekiListYokaigodo")
    private TextBox txtKyufuJissekiListYokaigodo;
    @JsonProperty("txtKyufuJissekiListNinteiYukoKikan")
    private TextBoxDateRange txtKyufuJissekiListNinteiYukoKikan;
    @JsonProperty("txtKyufuJissekiListName")
    private TextBox txtKyufuJissekiListName;
    @JsonProperty("txtKyufuJissekiListSeibetsu")
    private TextBox txtKyufuJissekiListSeibetsu;
    @JsonProperty("txtKyufuJissekiListSeinengappi")
    private TextBox txtKyufuJissekiListSeinengappi;
    @JsonProperty("dgKyufuJissekiMeisaiList")
    private DataGrid<dgKyufuJissekiMeisaiList_Row> dgKyufuJissekiMeisaiList;
    @JsonProperty("dgKyufuJissekiGokeiList")
    private DataGrid<dgKyufuJissekiGokeiList_Row> dgKyufuJissekiGokeiList;
    @JsonProperty("btnKyufuJissekiResearch")
    private Button btnKyufuJissekiResearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKyufuJissekiListHihokenshaNo")
    public TextBox getTxtKyufuJissekiListHihokenshaNo() {
        return txtKyufuJissekiListHihokenshaNo;
    }

    @JsonProperty("txtKyufuJissekiListHihokenshaNo")
    public void setTxtKyufuJissekiListHihokenshaNo(TextBox txtKyufuJissekiListHihokenshaNo) {
        this.txtKyufuJissekiListHihokenshaNo=txtKyufuJissekiListHihokenshaNo;
    }

    @JsonProperty("txtKyufuJissekiListJuminShubetsu")
    public TextBox getTxtKyufuJissekiListJuminShubetsu() {
        return txtKyufuJissekiListJuminShubetsu;
    }

    @JsonProperty("txtKyufuJissekiListJuminShubetsu")
    public void setTxtKyufuJissekiListJuminShubetsu(TextBox txtKyufuJissekiListJuminShubetsu) {
        this.txtKyufuJissekiListJuminShubetsu=txtKyufuJissekiListJuminShubetsu;
    }

    @JsonProperty("txtKyufuJissekiListYokaigodo")
    public TextBox getTxtKyufuJissekiListYokaigodo() {
        return txtKyufuJissekiListYokaigodo;
    }

    @JsonProperty("txtKyufuJissekiListYokaigodo")
    public void setTxtKyufuJissekiListYokaigodo(TextBox txtKyufuJissekiListYokaigodo) {
        this.txtKyufuJissekiListYokaigodo=txtKyufuJissekiListYokaigodo;
    }

    @JsonProperty("txtKyufuJissekiListNinteiYukoKikan")
    public TextBoxDateRange getTxtKyufuJissekiListNinteiYukoKikan() {
        return txtKyufuJissekiListNinteiYukoKikan;
    }

    @JsonProperty("txtKyufuJissekiListNinteiYukoKikan")
    public void setTxtKyufuJissekiListNinteiYukoKikan(TextBoxDateRange txtKyufuJissekiListNinteiYukoKikan) {
        this.txtKyufuJissekiListNinteiYukoKikan=txtKyufuJissekiListNinteiYukoKikan;
    }

    @JsonProperty("txtKyufuJissekiListName")
    public TextBox getTxtKyufuJissekiListName() {
        return txtKyufuJissekiListName;
    }

    @JsonProperty("txtKyufuJissekiListName")
    public void setTxtKyufuJissekiListName(TextBox txtKyufuJissekiListName) {
        this.txtKyufuJissekiListName=txtKyufuJissekiListName;
    }

    @JsonProperty("txtKyufuJissekiListSeibetsu")
    public TextBox getTxtKyufuJissekiListSeibetsu() {
        return txtKyufuJissekiListSeibetsu;
    }

    @JsonProperty("txtKyufuJissekiListSeibetsu")
    public void setTxtKyufuJissekiListSeibetsu(TextBox txtKyufuJissekiListSeibetsu) {
        this.txtKyufuJissekiListSeibetsu=txtKyufuJissekiListSeibetsu;
    }

    @JsonProperty("txtKyufuJissekiListSeinengappi")
    public TextBox getTxtKyufuJissekiListSeinengappi() {
        return txtKyufuJissekiListSeinengappi;
    }

    @JsonProperty("txtKyufuJissekiListSeinengappi")
    public void setTxtKyufuJissekiListSeinengappi(TextBox txtKyufuJissekiListSeinengappi) {
        this.txtKyufuJissekiListSeinengappi=txtKyufuJissekiListSeinengappi;
    }

    @JsonProperty("dgKyufuJissekiMeisaiList")
    public DataGrid<dgKyufuJissekiMeisaiList_Row> getDgKyufuJissekiMeisaiList() {
        return dgKyufuJissekiMeisaiList;
    }

    @JsonProperty("dgKyufuJissekiMeisaiList")
    public void setDgKyufuJissekiMeisaiList(DataGrid<dgKyufuJissekiMeisaiList_Row> dgKyufuJissekiMeisaiList) {
        this.dgKyufuJissekiMeisaiList=dgKyufuJissekiMeisaiList;
    }

    @JsonProperty("dgKyufuJissekiGokeiList")
    public DataGrid<dgKyufuJissekiGokeiList_Row> getDgKyufuJissekiGokeiList() {
        return dgKyufuJissekiGokeiList;
    }

    @JsonProperty("dgKyufuJissekiGokeiList")
    public void setDgKyufuJissekiGokeiList(DataGrid<dgKyufuJissekiGokeiList_Row> dgKyufuJissekiGokeiList) {
        this.dgKyufuJissekiGokeiList=dgKyufuJissekiGokeiList;
    }

    @JsonProperty("btnKyufuJissekiResearch")
    public Button getBtnKyufuJissekiResearch() {
        return btnKyufuJissekiResearch;
    }

    @JsonProperty("btnKyufuJissekiResearch")
    public void setBtnKyufuJissekiResearch(Button btnKyufuJissekiResearch) {
        this.btnKyufuJissekiResearch=btnKyufuJissekiResearch;
    }

}
