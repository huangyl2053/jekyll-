package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * HeijunkaHenkoTsuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeijunkaHenkoTsuchiDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHeijunkaHenkoTsuchiHakkobi")
    private TextBoxDate txtHeijunkaHenkoTsuchiHakkobi;
    @JsonProperty("radShutsuryokuTaisho")
    private RadioButton radShutsuryokuTaisho;
    @JsonProperty("txtBunshoBango1")
    private TextBoxNum txtBunshoBango1;
    @JsonProperty("txtBunshoBango2")
    private TextBoxNum txtBunshoBango2;
    @JsonProperty("txtBunshoBango3")
    private TextBox txtBunshoBango3;
    @JsonProperty("txtBunshoBango4")
    private TextBoxNum txtBunshoBango4;
    @JsonProperty("btnBangoShutoku")
    private Button btnBangoShutoku;
    @JsonProperty("ShutsuryokuJunHeijunkaHenkouTsuchi")
    private ChohyoShutsuryokujunDiv ShutsuryokuJunHeijunkaHenkouTsuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHeijunkaHenkoTsuchiHakkobi")
    public TextBoxDate getTxtHeijunkaHenkoTsuchiHakkobi() {
        return txtHeijunkaHenkoTsuchiHakkobi;
    }

    @JsonProperty("txtHeijunkaHenkoTsuchiHakkobi")
    public void setTxtHeijunkaHenkoTsuchiHakkobi(TextBoxDate txtHeijunkaHenkoTsuchiHakkobi) {
        this.txtHeijunkaHenkoTsuchiHakkobi=txtHeijunkaHenkoTsuchiHakkobi;
    }

    @JsonProperty("radShutsuryokuTaisho")
    public RadioButton getRadShutsuryokuTaisho() {
        return radShutsuryokuTaisho;
    }

    @JsonProperty("radShutsuryokuTaisho")
    public void setRadShutsuryokuTaisho(RadioButton radShutsuryokuTaisho) {
        this.radShutsuryokuTaisho=radShutsuryokuTaisho;
    }

    @JsonProperty("txtBunshoBango1")
    public TextBoxNum getTxtBunshoBango1() {
        return txtBunshoBango1;
    }

    @JsonProperty("txtBunshoBango1")
    public void setTxtBunshoBango1(TextBoxNum txtBunshoBango1) {
        this.txtBunshoBango1=txtBunshoBango1;
    }

    @JsonProperty("txtBunshoBango2")
    public TextBoxNum getTxtBunshoBango2() {
        return txtBunshoBango2;
    }

    @JsonProperty("txtBunshoBango2")
    public void setTxtBunshoBango2(TextBoxNum txtBunshoBango2) {
        this.txtBunshoBango2=txtBunshoBango2;
    }

    @JsonProperty("txtBunshoBango3")
    public TextBox getTxtBunshoBango3() {
        return txtBunshoBango3;
    }

    @JsonProperty("txtBunshoBango3")
    public void setTxtBunshoBango3(TextBox txtBunshoBango3) {
        this.txtBunshoBango3=txtBunshoBango3;
    }

    @JsonProperty("txtBunshoBango4")
    public TextBoxNum getTxtBunshoBango4() {
        return txtBunshoBango4;
    }

    @JsonProperty("txtBunshoBango4")
    public void setTxtBunshoBango4(TextBoxNum txtBunshoBango4) {
        this.txtBunshoBango4=txtBunshoBango4;
    }

    @JsonProperty("btnBangoShutoku")
    public Button getBtnBangoShutoku() {
        return btnBangoShutoku;
    }

    @JsonProperty("btnBangoShutoku")
    public void setBtnBangoShutoku(Button btnBangoShutoku) {
        this.btnBangoShutoku=btnBangoShutoku;
    }

    @JsonProperty("ShutsuryokuJunHeijunkaHenkouTsuchi")
    public IChohyoShutsuryokujunDiv getShutsuryokuJunHeijunkaHenkouTsuchi() {
        return ShutsuryokuJunHeijunkaHenkouTsuchi;
    }

    // </editor-fold>
}
