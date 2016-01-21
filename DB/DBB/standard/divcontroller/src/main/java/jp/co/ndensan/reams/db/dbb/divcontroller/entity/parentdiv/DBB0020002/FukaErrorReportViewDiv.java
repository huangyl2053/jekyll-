package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.InternalReportKihon.IInternalReportKihonDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.InternalReportKihon.InternalReportKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaErrorReportView のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaErrorReportViewDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgFukaErrorList")
    private DataGrid<dgFukaErrorList_Row> dgFukaErrorList;
    @JsonProperty("FukaErrorShoriButton")
    private FukaErrorShoriButtonDiv FukaErrorShoriButton;
    @JsonProperty("ccdFukaErrorCommon")
    private InternalReportKihonDiv ccdFukaErrorCommon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgFukaErrorList
     * @return dgFukaErrorList
     */
    @JsonProperty("dgFukaErrorList")
    public DataGrid<dgFukaErrorList_Row> getDgFukaErrorList() {
        return dgFukaErrorList;
    }

    /*
     * setdgFukaErrorList
     * @param dgFukaErrorList dgFukaErrorList
     */
    @JsonProperty("dgFukaErrorList")
    public void setDgFukaErrorList(DataGrid<dgFukaErrorList_Row> dgFukaErrorList) {
        this.dgFukaErrorList = dgFukaErrorList;
    }

    /*
     * getFukaErrorShoriButton
     * @return FukaErrorShoriButton
     */
    @JsonProperty("FukaErrorShoriButton")
    public FukaErrorShoriButtonDiv getFukaErrorShoriButton() {
        return FukaErrorShoriButton;
    }

    /*
     * setFukaErrorShoriButton
     * @param FukaErrorShoriButton FukaErrorShoriButton
     */
    @JsonProperty("FukaErrorShoriButton")
    public void setFukaErrorShoriButton(FukaErrorShoriButtonDiv FukaErrorShoriButton) {
        this.FukaErrorShoriButton = FukaErrorShoriButton;
    }

    /*
     * getccdFukaErrorCommon
     * @return ccdFukaErrorCommon
     */
    @JsonProperty("ccdFukaErrorCommon")
    public IInternalReportKihonDiv getCcdFukaErrorCommon() {
        return ccdFukaErrorCommon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnMishori() {
        return this.getFukaErrorShoriButton().getBtnMishori();
    }

    @JsonIgnore
    public void  setBtnMishori(Button btnMishori) {
        this.getFukaErrorShoriButton().setBtnMishori(btnMishori);
    }

    @JsonIgnore
    public Button getBtnFukaKosei() {
        return this.getFukaErrorShoriButton().getBtnFukaKosei();
    }

    @JsonIgnore
    public void  setBtnFukaKosei(Button btnFukaKosei) {
        this.getFukaErrorShoriButton().setBtnFukaKosei(btnFukaKosei);
    }

    @JsonIgnore
    public Button getBtnShikakuFuseigo() {
        return this.getFukaErrorShoriButton().getBtnShikakuFuseigo();
    }

    @JsonIgnore
    public void  setBtnShikakuFuseigo(Button btnShikakuFuseigo) {
        this.getFukaErrorShoriButton().setBtnShikakuFuseigo(btnShikakuFuseigo);
    }

    // </editor-fold>
}
