package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KaigohokenryoIchiranDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KogakuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KyojuhiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KyufugakugengakuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.kaiShokuhiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.tblKyufugakugengakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JiffukeishaHigaito のクラスファイル 
 * 
 * @author 自動生成
 */
public class JiffukeishaHigaitoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyufugakugengaku")
    private tblKyufugakugengakuDiv tblKyufugakugengaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyufugakugengaku")
    public tblKyufugakugengakuDiv getTblKyufugakugengaku() {
        return tblKyufugakugengaku;
    }

    @JsonProperty("tblKyufugakugengaku")
    public void setTblKyufugakugengaku(tblKyufugakugengakuDiv tblKyufugakugengaku) {
        this.tblKyufugakugengaku=tblKyufugakugengaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KyufugakugengakuDiv getKyufugakugengaku() {
        return this.getTblKyufugakugengaku().getKyufugakugengaku();
    }

    @JsonIgnore
    public RadioButton getRadUmu() {
        return this.getTblKyufugakugengaku().getKyufugakugengaku().getRadUmu();
    }

    @JsonIgnore
    public void  setRadUmu(RadioButton radUmu) {
        this.getTblKyufugakugengaku().getKyufugakugengaku().setRadUmu(radUmu);
    }

    @JsonIgnore
    public TextBox getTxtKyufugakugengaku() {
        return this.getTblKyufugakugengaku().getKyufugakugengaku().getTxtKyufugakugengaku();
    }

    @JsonIgnore
    public void  setTxtKyufugakugengaku(TextBox txtKyufugakugengaku) {
        this.getTblKyufugakugengaku().getKyufugakugengaku().setTxtKyufugakugengaku(txtKyufugakugengaku);
    }

    @JsonIgnore
    public KyojuhiDiv getKyojuhi() {
        return this.getTblKyufugakugengaku().getKyojuhi();
    }

    @JsonIgnore
    public KaigohokenryoIchiranDiv getKaigohokenryoIchiran() {
        return this.getTblKyufugakugengaku().getKaigohokenryoIchiran();
    }

    @JsonIgnore
    public kaiShokuhiDiv getKaiShokuhi() {
        return this.getTblKyufugakugengaku().getKaiShokuhi();
    }

    @JsonIgnore
    public KogakuDiv getKogaku() {
        return this.getTblKyufugakugengaku().getKogaku();
    }

}
