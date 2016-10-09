package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelHanteikijun のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelHanteikijunDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunbi")
    private TextBoxDate txtKijunbi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunbi
     * @return txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public TextBoxDate getTxtKijunbi() {
        return txtKijunbi;
    }

    /*
     * settxtKijunbi
     * @param txtKijunbi txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public void setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.txtKijunbi = txtKijunbi;
    }

    // </editor-fold>
}
