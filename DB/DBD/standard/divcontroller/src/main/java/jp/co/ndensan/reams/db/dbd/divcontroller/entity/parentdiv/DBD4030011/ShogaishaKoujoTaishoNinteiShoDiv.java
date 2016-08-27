package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKoujoTaishoNinteiSho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKoujoTaishoNinteiShoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TyusyutuJyokenPanel")
    private TyusyutuJyokenPanelDiv TyusyutuJyokenPanel;
    @JsonProperty("ShogaishaKojoNinteishoOutput")
    private ShogaishaKojoNinteishoOutputDiv ShogaishaKojoNinteishoOutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTyusyutuJyokenPanel
     * @return TyusyutuJyokenPanel
     */
    @JsonProperty("TyusyutuJyokenPanel")
    public TyusyutuJyokenPanelDiv getTyusyutuJyokenPanel() {
        return TyusyutuJyokenPanel;
    }

    /*
     * setTyusyutuJyokenPanel
     * @param TyusyutuJyokenPanel TyusyutuJyokenPanel
     */
    @JsonProperty("TyusyutuJyokenPanel")
    public void setTyusyutuJyokenPanel(TyusyutuJyokenPanelDiv TyusyutuJyokenPanel) {
        this.TyusyutuJyokenPanel = TyusyutuJyokenPanel;
    }

    /*
     * getShogaishaKojoNinteishoOutput
     * @return ShogaishaKojoNinteishoOutput
     */
    @JsonProperty("ShogaishaKojoNinteishoOutput")
    public ShogaishaKojoNinteishoOutputDiv getShogaishaKojoNinteishoOutput() {
        return ShogaishaKojoNinteishoOutput;
    }

    /*
     * setShogaishaKojoNinteishoOutput
     * @param ShogaishaKojoNinteishoOutput ShogaishaKojoNinteishoOutput
     */
    @JsonProperty("ShogaishaKojoNinteishoOutput")
    public void setShogaishaKojoNinteishoOutput(ShogaishaKojoNinteishoOutputDiv ShogaishaKojoNinteishoOutput) {
        this.ShogaishaKojoNinteishoOutput = ShogaishaKojoNinteishoOutput;
    }

    // </editor-fold>
}
