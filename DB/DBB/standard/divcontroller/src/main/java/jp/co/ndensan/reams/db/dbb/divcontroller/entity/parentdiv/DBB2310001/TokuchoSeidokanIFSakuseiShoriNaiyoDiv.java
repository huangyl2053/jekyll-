package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuchoSeidokanIFSakuseiShoriNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoSeidokanIFSakuseiShoriNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxDate txtChoteiNendo;
    @JsonProperty("ddlKaishiYM")
    private DropDownList ddlKaishiYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBoxDate getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * getddlKaishiYM
     * @return ddlKaishiYM
     */
    @JsonProperty("ddlKaishiYM")
    public DropDownList getDdlKaishiYM() {
        return ddlKaishiYM;
    }

    /*
     * setddlKaishiYM
     * @param ddlKaishiYM ddlKaishiYM
     */
    @JsonProperty("ddlKaishiYM")
    public void setDdlKaishiYM(DropDownList ddlKaishiYM) {
        this.ddlKaishiYM = ddlKaishiYM;
    }

    // </editor-fold>
}
