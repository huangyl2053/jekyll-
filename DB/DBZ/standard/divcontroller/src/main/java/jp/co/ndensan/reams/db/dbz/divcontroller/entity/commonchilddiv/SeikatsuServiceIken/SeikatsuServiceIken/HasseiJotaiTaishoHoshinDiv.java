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
 * HasseiJotaiTaishoHoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HasseiJotaiTaishoHoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkHasseiShojo")
    private CheckBoxList chkHasseiShojo;
    @JsonProperty("chkJotaiSonota")
    private CheckBoxList chkJotaiSonota;
    @JsonProperty("txtSonotaJotaiShosai")
    private TextBox txtSonotaJotaiShosai;
    @JsonProperty("txtTaishoHoushin")
    private TextBox txtTaishoHoushin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkHasseiShojo")
    public CheckBoxList getChkHasseiShojo() {
        return chkHasseiShojo;
    }

    @JsonProperty("chkHasseiShojo")
    public void setChkHasseiShojo(CheckBoxList chkHasseiShojo) {
        this.chkHasseiShojo=chkHasseiShojo;
    }

    @JsonProperty("chkJotaiSonota")
    public CheckBoxList getChkJotaiSonota() {
        return chkJotaiSonota;
    }

    @JsonProperty("chkJotaiSonota")
    public void setChkJotaiSonota(CheckBoxList chkJotaiSonota) {
        this.chkJotaiSonota=chkJotaiSonota;
    }

    @JsonProperty("txtSonotaJotaiShosai")
    public TextBox getTxtSonotaJotaiShosai() {
        return txtSonotaJotaiShosai;
    }

    @JsonProperty("txtSonotaJotaiShosai")
    public void setTxtSonotaJotaiShosai(TextBox txtSonotaJotaiShosai) {
        this.txtSonotaJotaiShosai=txtSonotaJotaiShosai;
    }

    @JsonProperty("txtTaishoHoushin")
    public TextBox getTxtTaishoHoushin() {
        return txtTaishoHoushin;
    }

    @JsonProperty("txtTaishoHoushin")
    public void setTxtTaishoHoushin(TextBox txtTaishoHoushin) {
        this.txtTaishoHoushin=txtTaishoHoushin;
    }

    // </editor-fold>
}
