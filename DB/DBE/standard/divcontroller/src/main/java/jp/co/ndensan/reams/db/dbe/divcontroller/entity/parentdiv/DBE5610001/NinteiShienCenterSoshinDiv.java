package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001;
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
 * NinteiShienCenterSoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShienCenterSoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShutsuryokuJoken")
    private ShutsuryokuJokenDiv ShutsuryokuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getShutsuryokuJoken
     * @return ShutsuryokuJoken
     */
    @JsonProperty("ShutsuryokuJoken")
    public ShutsuryokuJokenDiv getShutsuryokuJoken() {
        return ShutsuryokuJoken;
    }

    /*
     * setShutsuryokuJoken
     * @param ShutsuryokuJoken ShutsuryokuJoken
     */
    @JsonProperty("ShutsuryokuJoken")
    public void setShutsuryokuJoken(ShutsuryokuJokenDiv ShutsuryokuJoken) {
        this.ShutsuryokuJoken = ShutsuryokuJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadDataShutsuryoku() {
        return this.getKensakuJoken().getRadDataShutsuryoku();
    }

    @JsonIgnore
    public void  setRadDataShutsuryoku(RadioButton radDataShutsuryoku) {
        this.getKensakuJoken().setRadDataShutsuryoku(radDataShutsuryoku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteibi() {
        return this.getKensakuJoken().getTxtNijiHanteibi();
    }

    @JsonIgnore
    public void  setTxtNijiHanteibi(TextBoxDateRange txtNijiHanteibi) {
        this.getKensakuJoken().setTxtNijiHanteibi(txtNijiHanteibi);
    }

    @JsonIgnore
    public RadioButton getRadTennyuShiboJoho() {
        return this.getShutsuryokuJoken().getRadTennyuShiboJoho();
    }

    @JsonIgnore
    public void  setRadTennyuShiboJoho(RadioButton radTennyuShiboJoho) {
        this.getShutsuryokuJoken().setRadTennyuShiboJoho(radTennyuShiboJoho);
    }

    // </editor-fold>
}
