package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.FukaErrorShoriButtonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.dgFukaErrorList_Row;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.InternalReportKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaErrorReportView のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaErrorReportViewDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdFukaErrorCommon")
    private InternalReportKihonDiv ccdFukaErrorCommon;
    @JsonProperty("dgFukaErrorList")
    private DataGrid<dgFukaErrorList_Row> dgFukaErrorList;
    @JsonProperty("btnCsvDownload")
    private ButtonDownLoad btnCsvDownload;
    @JsonProperty("FukaErrorShoriButton")
    private FukaErrorShoriButtonDiv FukaErrorShoriButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdFukaErrorCommon")
    public InternalReportKihonDiv getCcdFukaErrorCommon() {
        return ccdFukaErrorCommon;
    }

    @JsonProperty("ccdFukaErrorCommon")
    public void setCcdFukaErrorCommon(InternalReportKihonDiv ccdFukaErrorCommon) {
        this.ccdFukaErrorCommon=ccdFukaErrorCommon;
    }

    @JsonProperty("dgFukaErrorList")
    public DataGrid<dgFukaErrorList_Row> getDgFukaErrorList() {
        return dgFukaErrorList;
    }

    @JsonProperty("dgFukaErrorList")
    public void setDgFukaErrorList(DataGrid<dgFukaErrorList_Row> dgFukaErrorList) {
        this.dgFukaErrorList=dgFukaErrorList;
    }

    @JsonProperty("btnCsvDownload")
    public ButtonDownLoad getBtnCsvDownload() {
        return btnCsvDownload;
    }

    @JsonProperty("btnCsvDownload")
    public void setBtnCsvDownload(ButtonDownLoad btnCsvDownload) {
        this.btnCsvDownload=btnCsvDownload;
    }

    @JsonProperty("FukaErrorShoriButton")
    public FukaErrorShoriButtonDiv getFukaErrorShoriButton() {
        return FukaErrorShoriButton;
    }

    @JsonProperty("FukaErrorShoriButton")
    public void setFukaErrorShoriButton(FukaErrorShoriButtonDiv FukaErrorShoriButton) {
        this.FukaErrorShoriButton=FukaErrorShoriButton;
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

}
