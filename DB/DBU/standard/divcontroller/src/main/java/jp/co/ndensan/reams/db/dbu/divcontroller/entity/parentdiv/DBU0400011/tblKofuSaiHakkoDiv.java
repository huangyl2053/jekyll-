package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblKofuSaiHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKofuSaiHakkoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celNull2")
    private celNull2AttblKofuSaiHakko celNull2;
    @JsonProperty("celKofuYMD")
    private celKofuYMDAttblKofuSaiHakko celKofuYMD;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxDate getTxtKofuYMD() {
        return this.celKofuYMD.getTxtKofuYMD();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelNull2
     * @return celNull2
     */
    @JsonProperty("celNull2")
    private celNull2AttblKofuSaiHakko getCelNull2() {
        return celNull2;
    }

    /*
     * setcelNull2
     * @param celNull2 celNull2
     */
    @JsonProperty("celNull2")
    private void setCelNull2(celNull2AttblKofuSaiHakko celNull2) {
        this.celNull2 = celNull2;
    }

    /*
     * getcelKofuYMD
     * @return celKofuYMD
     */
    @JsonProperty("celKofuYMD")
    private celKofuYMDAttblKofuSaiHakko getCelKofuYMD() {
        return celKofuYMD;
    }

    /*
     * setcelKofuYMD
     * @param celKofuYMD celKofuYMD
     */
    @JsonProperty("celKofuYMD")
    private void setCelKofuYMD(celKofuYMDAttblKofuSaiHakko celKofuYMD) {
        this.celKofuYMD = celKofuYMD;
    }

    // </editor-fold>
}
/**
 * celNull2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull2AttblKofuSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celKofuYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celKofuYMDAttblKofuSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKofuYMD")
    private TextBoxDate txtKofuYMD;

    /*
     * gettxtKofuYMD
     * @return txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public TextBoxDate getTxtKofuYMD() {
        return txtKofuYMD;
    }

    /*
     * settxtKofuYMD
     * @param txtKofuYMD txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public void setTxtKofuYMD(TextBoxDate txtKofuYMD) {
        this.txtKofuYMD = txtKofuYMD;
    }

    // </editor-fold>
}
