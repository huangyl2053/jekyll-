package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenjiRiyoshaFutanWariaiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenjiRiyoshaFutanWariaiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PanelAll")
    private PanelAllDiv PanelAll;
    @JsonProperty("NenjipnlNote")
    private NenjipnlNoteDiv NenjipnlNote;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPanelAll
     * @return PanelAll
     */
    @JsonProperty("PanelAll")
    public PanelAllDiv getPanelAll() {
        return PanelAll;
    }

    /*
     * setPanelAll
     * @param PanelAll PanelAll
     */
    @JsonProperty("PanelAll")
    public void setPanelAll(PanelAllDiv PanelAll) {
        this.PanelAll = PanelAll;
    }

    /*
     * getNenjipnlNote
     * @return NenjipnlNote
     */
    @JsonProperty("NenjipnlNote")
    public NenjipnlNoteDiv getNenjipnlNote() {
        return NenjipnlNote;
    }

    /*
     * setNenjipnlNote
     * @param NenjipnlNote NenjipnlNote
     */
    @JsonProperty("NenjipnlNote")
    public void setNenjipnlNote(NenjipnlNoteDiv NenjipnlNote) {
        this.NenjipnlNote = NenjipnlNote;
    }

    // </editor-fold>
}
