package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2310001;
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
 * ShoriJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokuchoSeidokanIFSakuseiShoriNaiyo")
    private TokuchoSeidokanIFSakuseiShoriNaiyoDiv TokuchoSeidokanIFSakuseiShoriNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokuchoSeidokanIFSakuseiShoriNaiyo
     * @return TokuchoSeidokanIFSakuseiShoriNaiyo
     */
    @JsonProperty("TokuchoSeidokanIFSakuseiShoriNaiyo")
    public TokuchoSeidokanIFSakuseiShoriNaiyoDiv getTokuchoSeidokanIFSakuseiShoriNaiyo() {
        return TokuchoSeidokanIFSakuseiShoriNaiyo;
    }

    /*
     * setTokuchoSeidokanIFSakuseiShoriNaiyo
     * @param TokuchoSeidokanIFSakuseiShoriNaiyo TokuchoSeidokanIFSakuseiShoriNaiyo
     */
    @JsonProperty("TokuchoSeidokanIFSakuseiShoriNaiyo")
    public void setTokuchoSeidokanIFSakuseiShoriNaiyo(TokuchoSeidokanIFSakuseiShoriNaiyoDiv TokuchoSeidokanIFSakuseiShoriNaiyo) {
        this.TokuchoSeidokanIFSakuseiShoriNaiyo = TokuchoSeidokanIFSakuseiShoriNaiyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtChoteiNendo() {
        return this.getTokuchoSeidokanIFSakuseiShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void  setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.getTokuchoSeidokanIFSakuseiShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public DropDownList getDdlKaishiYM() {
        return this.getTokuchoSeidokanIFSakuseiShoriNaiyo().getDdlKaishiYM();
    }

    @JsonIgnore
    public void  setDdlKaishiYM(DropDownList ddlKaishiYM) {
        this.getTokuchoSeidokanIFSakuseiShoriNaiyo().setDdlKaishiYM(ddlKaishiYM);
    }

    // </editor-fold>
}
