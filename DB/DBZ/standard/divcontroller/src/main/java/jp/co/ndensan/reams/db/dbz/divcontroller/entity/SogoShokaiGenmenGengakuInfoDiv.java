package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiGenmenGengakuFutanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiGenmenGengakuTechoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiGenmenGengakuInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiGenmenGengakuInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGenmenShinseiYMD")
    private TextBoxDate txtGenmenShinseiYMD;
    @JsonProperty("txtGenmenKyuSochiUmu")
    private TextBox txtGenmenKyuSochiUmu;
    @JsonProperty("SogoShokaiGenmenGengakuTecho")
    private SogoShokaiGenmenGengakuTechoDiv SogoShokaiGenmenGengakuTecho;
    @JsonProperty("txtGenmenSeihoUmu")
    private TextBox txtGenmenSeihoUmu;
    @JsonProperty("txtGenmenSeihoTokureiUmu")
    private TextBox txtGenmenSeihoTokureiUmu;
    @JsonProperty("txtGenmenRofukuUmu")
    private TextBox txtGenmenRofukuUmu;
    @JsonProperty("txtGenmenFutanDankai")
    private TextBox txtGenmenFutanDankai;
    @JsonProperty("txtGenmenKyokaiKubun")
    private TextBox txtGenmenKyokaiKubun;
    @JsonProperty("txtGenmenGekihenDanwaKubun")
    private TextBox txtGenmenGekihenDanwaKubun;
    @JsonProperty("SogoShokaiGenmenGengakuFutan")
    private SogoShokaiGenmenGengakuFutanDiv SogoShokaiGenmenGengakuFutan;
    @JsonProperty("txtGenmenFutanHyojunKubun")
    private TextBox txtGenmenFutanHyojunKubun;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtGenmenShinseiYMD")
    public TextBoxDate getTxtGenmenShinseiYMD() {
        return txtGenmenShinseiYMD;
    }

    @JsonProperty("txtGenmenShinseiYMD")
    public void setTxtGenmenShinseiYMD(TextBoxDate txtGenmenShinseiYMD) {
        this.txtGenmenShinseiYMD=txtGenmenShinseiYMD;
    }

    @JsonProperty("txtGenmenKyuSochiUmu")
    public TextBox getTxtGenmenKyuSochiUmu() {
        return txtGenmenKyuSochiUmu;
    }

    @JsonProperty("txtGenmenKyuSochiUmu")
    public void setTxtGenmenKyuSochiUmu(TextBox txtGenmenKyuSochiUmu) {
        this.txtGenmenKyuSochiUmu=txtGenmenKyuSochiUmu;
    }

    @JsonProperty("SogoShokaiGenmenGengakuTecho")
    public SogoShokaiGenmenGengakuTechoDiv getSogoShokaiGenmenGengakuTecho() {
        return SogoShokaiGenmenGengakuTecho;
    }

    @JsonProperty("SogoShokaiGenmenGengakuTecho")
    public void setSogoShokaiGenmenGengakuTecho(SogoShokaiGenmenGengakuTechoDiv SogoShokaiGenmenGengakuTecho) {
        this.SogoShokaiGenmenGengakuTecho=SogoShokaiGenmenGengakuTecho;
    }

    @JsonProperty("txtGenmenSeihoUmu")
    public TextBox getTxtGenmenSeihoUmu() {
        return txtGenmenSeihoUmu;
    }

    @JsonProperty("txtGenmenSeihoUmu")
    public void setTxtGenmenSeihoUmu(TextBox txtGenmenSeihoUmu) {
        this.txtGenmenSeihoUmu=txtGenmenSeihoUmu;
    }

    @JsonProperty("txtGenmenSeihoTokureiUmu")
    public TextBox getTxtGenmenSeihoTokureiUmu() {
        return txtGenmenSeihoTokureiUmu;
    }

    @JsonProperty("txtGenmenSeihoTokureiUmu")
    public void setTxtGenmenSeihoTokureiUmu(TextBox txtGenmenSeihoTokureiUmu) {
        this.txtGenmenSeihoTokureiUmu=txtGenmenSeihoTokureiUmu;
    }

    @JsonProperty("txtGenmenRofukuUmu")
    public TextBox getTxtGenmenRofukuUmu() {
        return txtGenmenRofukuUmu;
    }

    @JsonProperty("txtGenmenRofukuUmu")
    public void setTxtGenmenRofukuUmu(TextBox txtGenmenRofukuUmu) {
        this.txtGenmenRofukuUmu=txtGenmenRofukuUmu;
    }

    @JsonProperty("txtGenmenFutanDankai")
    public TextBox getTxtGenmenFutanDankai() {
        return txtGenmenFutanDankai;
    }

    @JsonProperty("txtGenmenFutanDankai")
    public void setTxtGenmenFutanDankai(TextBox txtGenmenFutanDankai) {
        this.txtGenmenFutanDankai=txtGenmenFutanDankai;
    }

    @JsonProperty("txtGenmenKyokaiKubun")
    public TextBox getTxtGenmenKyokaiKubun() {
        return txtGenmenKyokaiKubun;
    }

    @JsonProperty("txtGenmenKyokaiKubun")
    public void setTxtGenmenKyokaiKubun(TextBox txtGenmenKyokaiKubun) {
        this.txtGenmenKyokaiKubun=txtGenmenKyokaiKubun;
    }

    @JsonProperty("txtGenmenGekihenDanwaKubun")
    public TextBox getTxtGenmenGekihenDanwaKubun() {
        return txtGenmenGekihenDanwaKubun;
    }

    @JsonProperty("txtGenmenGekihenDanwaKubun")
    public void setTxtGenmenGekihenDanwaKubun(TextBox txtGenmenGekihenDanwaKubun) {
        this.txtGenmenGekihenDanwaKubun=txtGenmenGekihenDanwaKubun;
    }

    @JsonProperty("SogoShokaiGenmenGengakuFutan")
    public SogoShokaiGenmenGengakuFutanDiv getSogoShokaiGenmenGengakuFutan() {
        return SogoShokaiGenmenGengakuFutan;
    }

    @JsonProperty("SogoShokaiGenmenGengakuFutan")
    public void setSogoShokaiGenmenGengakuFutan(SogoShokaiGenmenGengakuFutanDiv SogoShokaiGenmenGengakuFutan) {
        this.SogoShokaiGenmenGengakuFutan=SogoShokaiGenmenGengakuFutan;
    }

    @JsonProperty("txtGenmenFutanHyojunKubun")
    public TextBox getTxtGenmenFutanHyojunKubun() {
        return txtGenmenFutanHyojunKubun;
    }

    @JsonProperty("txtGenmenFutanHyojunKubun")
    public void setTxtGenmenFutanHyojunKubun(TextBox txtGenmenFutanHyojunKubun) {
        this.txtGenmenFutanHyojunKubun=txtGenmenFutanHyojunKubun;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

}
