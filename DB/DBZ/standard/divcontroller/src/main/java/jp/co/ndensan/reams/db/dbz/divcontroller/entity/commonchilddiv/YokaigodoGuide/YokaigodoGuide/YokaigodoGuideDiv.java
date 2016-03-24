package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigodoGuide.YokaigodoGuide;
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
 * YokaigodoGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigodoGuideDiv extends Panel implements IYokaigodoGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgYokaigodoGuide")
    private DataGrid<dgYokaigodoGuide_Row> dgYokaigodoGuide;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("kijunYMD")
    private RString kijunYMD;
    @JsonProperty("code")
    private RString code;
    @JsonProperty("meisho")
    private RString meisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgYokaigodoGuide
     * @return dgYokaigodoGuide
     */
    @JsonProperty("dgYokaigodoGuide")
    public DataGrid<dgYokaigodoGuide_Row> getDgYokaigodoGuide() {
        return dgYokaigodoGuide;
    }

    /*
     * setdgYokaigodoGuide
     * @param dgYokaigodoGuide dgYokaigodoGuide
     */
    @JsonProperty("dgYokaigodoGuide")
    public void setDgYokaigodoGuide(DataGrid<dgYokaigodoGuide_Row> dgYokaigodoGuide) {
        this.dgYokaigodoGuide = dgYokaigodoGuide;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * getkijunYMD
     * @return kijunYMD
     */
    @JsonProperty("kijunYMD")
    public RString getKijunYMD() {
        return kijunYMD;
    }

    /*
     * setkijunYMD
     * @param kijunYMD kijunYMD
     */
    @JsonProperty("kijunYMD")
    public void setKijunYMD(RString kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /*
     * getcode
     * @return code
     */
    @JsonProperty("code")
    public RString getCode() {
        return code;
    }

    /*
     * setcode
     * @param code code
     */
    @JsonProperty("code")
    public void setCode(RString code) {
        this.code = code;
    }

    /*
     * getmeisho
     * @return meisho
     */
    @JsonProperty("meisho")
    public RString getMeisho() {
        return meisho;
    }

    /*
     * setmeisho
     * @param meisho meisho
     */
    @JsonProperty("meisho")
    public void setMeisho(RString meisho) {
        this.meisho = meisho;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
