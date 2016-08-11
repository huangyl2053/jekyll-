package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoNinteisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoNinteishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShogaishaKojoShinseisha")
    private ShogaishaKojoShinseishaDiv ShogaishaKojoShinseisha;
    @JsonProperty("btnHakko")
    private Button btnHakko;
    @JsonProperty("NinteishoPrintSetting")
    private PrintContentsSettingDiv NinteishoPrintSetting;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShogaishaKojoShinseisha
     * @return ShogaishaKojoShinseisha
     */
    @JsonProperty("ShogaishaKojoShinseisha")
    public ShogaishaKojoShinseishaDiv getShogaishaKojoShinseisha() {
        return ShogaishaKojoShinseisha;
    }

    /*
     * setShogaishaKojoShinseisha
     * @param ShogaishaKojoShinseisha ShogaishaKojoShinseisha
     */
    @JsonProperty("ShogaishaKojoShinseisha")
    public void setShogaishaKojoShinseisha(ShogaishaKojoShinseishaDiv ShogaishaKojoShinseisha) {
        this.ShogaishaKojoShinseisha = ShogaishaKojoShinseisha;
    }

    /*
     * getbtnHakko
     * @return btnHakko
     */
    @JsonProperty("btnHakko")
    public Button getBtnHakko() {
        return btnHakko;
    }

    /*
     * setbtnHakko
     * @param btnHakko btnHakko
     */
    @JsonProperty("btnHakko")
    public void setBtnHakko(Button btnHakko) {
        this.btnHakko = btnHakko;
    }

    /*
     * getNinteishoPrintSetting
     * @return NinteishoPrintSetting
     */
    @JsonProperty("NinteishoPrintSetting")
    public IPrintContentsSettingDiv getNinteishoPrintSetting() {
        return NinteishoPrintSetting;
    }

    // </editor-fold>
}
