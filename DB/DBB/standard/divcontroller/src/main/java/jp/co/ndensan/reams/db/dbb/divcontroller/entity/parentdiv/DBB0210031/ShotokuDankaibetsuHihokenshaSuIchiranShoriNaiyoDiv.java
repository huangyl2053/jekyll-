package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChoteiNendo")
    private DropDownList ddlChoteiNendo;
    @JsonProperty("txtHonsanteiShoriYMD")
    private TextBoxDate txtHonsanteiShoriYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChoteiNendo
     * @return ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public DropDownList getDdlChoteiNendo() {
        return ddlChoteiNendo;
    }

    /*
     * setddlChoteiNendo
     * @param ddlChoteiNendo ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public void setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.ddlChoteiNendo = ddlChoteiNendo;
    }

    /*
     * gettxtHonsanteiShoriYMD
     * @return txtHonsanteiShoriYMD
     */
    @JsonProperty("txtHonsanteiShoriYMD")
    public TextBoxDate getTxtHonsanteiShoriYMD() {
        return txtHonsanteiShoriYMD;
    }

    /*
     * settxtHonsanteiShoriYMD
     * @param txtHonsanteiShoriYMD txtHonsanteiShoriYMD
     */
    @JsonProperty("txtHonsanteiShoriYMD")
    public void setTxtHonsanteiShoriYMD(TextBoxDate txtHonsanteiShoriYMD) {
        this.txtHonsanteiShoriYMD = txtHonsanteiShoriYMD;
    }

    // </editor-fold>
}
