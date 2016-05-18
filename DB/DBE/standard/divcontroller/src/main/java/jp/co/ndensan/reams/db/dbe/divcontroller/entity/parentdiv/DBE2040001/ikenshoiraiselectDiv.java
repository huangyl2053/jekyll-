package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ikenshoiraiselect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ikenshoiraiselectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnikenshoiraitaishooutput")
    private Button btnikenshoiraitaishooutput;
    @JsonProperty("CSVButtonDownLoad")
    private ButtonDownLoad CSVButtonDownLoad;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnikenshoiraitaishooutput
     * @return btnikenshoiraitaishooutput
     */
    @JsonProperty("btnikenshoiraitaishooutput")
    public Button getBtnikenshoiraitaishooutput() {
        return btnikenshoiraitaishooutput;
    }

    /*
     * setbtnikenshoiraitaishooutput
     * @param btnikenshoiraitaishooutput btnikenshoiraitaishooutput
     */
    @JsonProperty("btnikenshoiraitaishooutput")
    public void setBtnikenshoiraitaishooutput(Button btnikenshoiraitaishooutput) {
        this.btnikenshoiraitaishooutput = btnikenshoiraitaishooutput;
    }

    /*
     * getCSVButtonDownLoad
     * @return CSVButtonDownLoad
     */
    @JsonProperty("CSVButtonDownLoad")
    public ButtonDownLoad getCSVButtonDownLoad() {
        return CSVButtonDownLoad;
    }

    /*
     * setCSVButtonDownLoad
     * @param CSVButtonDownLoad CSVButtonDownLoad
     */
    @JsonProperty("CSVButtonDownLoad")
    public void setCSVButtonDownLoad(ButtonDownLoad CSVButtonDownLoad) {
        this.CSVButtonDownLoad = CSVButtonDownLoad;
    }

    // </editor-fold>
}
