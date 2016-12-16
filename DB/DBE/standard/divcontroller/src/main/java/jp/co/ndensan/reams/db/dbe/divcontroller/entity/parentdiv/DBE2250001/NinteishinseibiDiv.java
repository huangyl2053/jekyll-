package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ninteishinseibi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteishinseibiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FileTorikomi")
    private FileTorikomiDiv FileTorikomi;
    @JsonProperty("NinteiIchiran")
    private NinteiIchiranDiv NinteiIchiran;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ファイルPath")
    private RString ファイルPath;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFileTorikomi
     * @return FileTorikomi
     */
    @JsonProperty("FileTorikomi")
    public FileTorikomiDiv getFileTorikomi() {
        return FileTorikomi;
    }

    /*
     * setFileTorikomi
     * @param FileTorikomi FileTorikomi
     */
    @JsonProperty("FileTorikomi")
    public void setFileTorikomi(FileTorikomiDiv FileTorikomi) {
        this.FileTorikomi = FileTorikomi;
    }

    /*
     * getNinteiIchiran
     * @return NinteiIchiran
     */
    @JsonProperty("NinteiIchiran")
    public NinteiIchiranDiv getNinteiIchiran() {
        return NinteiIchiran;
    }

    /*
     * setNinteiIchiran
     * @param NinteiIchiran NinteiIchiran
     */
    @JsonProperty("NinteiIchiran")
    public void setNinteiIchiran(NinteiIchiranDiv NinteiIchiran) {
        this.NinteiIchiran = NinteiIchiran;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getファイルPath
     * @return ファイルPath
     */
    @JsonProperty("ファイルPath")
    public RString getファイルPath() {
        return ファイルPath;
    }

    /*
     * setファイルPath
     * @param ファイルPath ファイルPath
     */
    @JsonProperty("ファイルPath")
    public void setファイルPath(RString ファイルPath) {
        this.ファイルPath = ファイルPath;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUplFileTorikomi() {
        return this.getFileTorikomi().getUplFileTorikomi();
    }

    @JsonIgnore
    public void  setUplFileTorikomi(UploadPanel uplFileTorikomi) {
        this.getFileTorikomi().setUplFileTorikomi(uplFileTorikomi);
    }

    @JsonIgnore
    public TextBox getTxtNinzu() {
        return this.getNinteiIchiran().getTxtNinzu();
    }

    @JsonIgnore
    public void  setTxtNinzu(TextBox txtNinzu) {
        this.getNinteiIchiran().setTxtNinzu(txtNinzu);
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaData_Row> getDgNinteiChosaData() {
        return this.getNinteiIchiran().getDgNinteiChosaData();
    }

    @JsonIgnore
    public void  setDgNinteiChosaData(DataGrid<dgNinteiChosaData_Row> dgNinteiChosaData) {
        this.getNinteiIchiran().setDgNinteiChosaData(dgNinteiChosaData);
    }

    // </editor-fold>
}
