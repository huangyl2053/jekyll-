package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuIryo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuIryoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShochiNaiyo")
    private ShochiNaiyoDiv ShochiNaiyo;
    @JsonProperty("TokiTaiou")
    private TokiTaiouDiv TokiTaiou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShochiNaiyo
     * @return ShochiNaiyo
     */
    @JsonProperty("ShochiNaiyo")
    public ShochiNaiyoDiv getShochiNaiyo() {
        return ShochiNaiyo;
    }

    /*
     * setShochiNaiyo
     * @param ShochiNaiyo ShochiNaiyo
     */
    @JsonProperty("ShochiNaiyo")
    public void setShochiNaiyo(ShochiNaiyoDiv ShochiNaiyo) {
        this.ShochiNaiyo = ShochiNaiyo;
    }

    /*
     * getTokiTaiou
     * @return TokiTaiou
     */
    @JsonProperty("TokiTaiou")
    public TokiTaiouDiv getTokiTaiou() {
        return TokiTaiou;
    }

    /*
     * setTokiTaiou
     * @param TokiTaiou TokiTaiou
     */
    @JsonProperty("TokiTaiou")
    public void setTokiTaiou(TokiTaiouDiv TokiTaiou) {
        this.TokiTaiou = TokiTaiou;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnShochiNaiyo() {
        return this.getShochiNaiyo().getBtnShochiNaiyo();
    }

    @JsonIgnore
    public void  setBtnShochiNaiyo(ButtonDialog btnShochiNaiyo) {
        this.getShochiNaiyo().setBtnShochiNaiyo(btnShochiNaiyo);
    }

    @JsonIgnore
    public CheckBoxList getChkShochiNaiyo() {
        return this.getShochiNaiyo().getChkShochiNaiyo();
    }

    @JsonIgnore
    public void  setChkShochiNaiyo(CheckBoxList chkShochiNaiyo) {
        this.getShochiNaiyo().setChkShochiNaiyo(chkShochiNaiyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTokiTaiou() {
        return this.getTokiTaiou().getBtnTokiTaiou();
    }

    @JsonIgnore
    public void  setBtnTokiTaiou(ButtonDialog btnTokiTaiou) {
        this.getTokiTaiou().setBtnTokiTaiou(btnTokiTaiou);
    }

    @JsonIgnore
    public CheckBoxList getChkTokiTaiou() {
        return this.getTokiTaiou().getChkTokiTaiou();
    }

    @JsonIgnore
    public void  setChkTokiTaiou(CheckBoxList chkTokiTaiou) {
        this.getTokiTaiou().setChkTokiTaiou(chkTokiTaiou);
    }

    // </editor-fold>
}
