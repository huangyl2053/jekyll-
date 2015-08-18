package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IgakutekiKanriHitsuyosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IgakutekiKanriHitsuyoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIgakutekiKanriHitsuyosei")
    private CheckBoxList chkIgakutekiKanriHitsuyosei;
    @JsonProperty("chkSonotaIryoService")
    private CheckBoxList chkSonotaIryoService;
    @JsonProperty("txtShonotaIryoServiceShosai")
    private TextBox txtShonotaIryoServiceShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkIgakutekiKanriHitsuyosei")
    public CheckBoxList getChkIgakutekiKanriHitsuyosei() {
        return chkIgakutekiKanriHitsuyosei;
    }

    @JsonProperty("chkIgakutekiKanriHitsuyosei")
    public void setChkIgakutekiKanriHitsuyosei(CheckBoxList chkIgakutekiKanriHitsuyosei) {
        this.chkIgakutekiKanriHitsuyosei=chkIgakutekiKanriHitsuyosei;
    }

    @JsonProperty("chkSonotaIryoService")
    public CheckBoxList getChkSonotaIryoService() {
        return chkSonotaIryoService;
    }

    @JsonProperty("chkSonotaIryoService")
    public void setChkSonotaIryoService(CheckBoxList chkSonotaIryoService) {
        this.chkSonotaIryoService=chkSonotaIryoService;
    }

    @JsonProperty("txtShonotaIryoServiceShosai")
    public TextBox getTxtShonotaIryoServiceShosai() {
        return txtShonotaIryoServiceShosai;
    }

    @JsonProperty("txtShonotaIryoServiceShosai")
    public void setTxtShonotaIryoServiceShosai(TextBox txtShonotaIryoServiceShosai) {
        this.txtShonotaIryoServiceShosai=txtShonotaIryoServiceShosai;
    }

    // </editor-fold>
}
