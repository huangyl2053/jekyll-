package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon.IKaigoFukaKihonDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * KaigoFukaKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoFukaKihonDiv extends Panel implements IKaigoFukaKihonDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTsuchishoNo")
    private TextBox txtTsuchishoNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtHokenryoDankai")
    private TextBox txtHokenryoDankai;
    @JsonProperty("txtShutokuYmd")
    private TextBoxFlexibleDate txtShutokuYmd;
    @JsonProperty("txtShutokuJiyu")
    private TextBox txtShutokuJiyu;
    @JsonProperty("txtSoshitsuYmd")
    private TextBoxFlexibleDate txtSoshitsuYmd;
    @JsonProperty("txtSoshitsuJiyu")
    private TextBox txtSoshitsuJiyu;
    @JsonProperty("btnHihoRireki")
    private ButtonDialog btnHihoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTsuchishoNo")
    public TextBox getTxtTsuchishoNo() {
        return txtTsuchishoNo;
    }

    @JsonProperty("txtTsuchishoNo")
    public void setTxtTsuchishoNo(TextBox txtTsuchishoNo) {
        this.txtTsuchishoNo=txtTsuchishoNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtHokenryoDankai")
    public TextBox getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    @JsonProperty("txtHokenryoDankai")
    public void setTxtHokenryoDankai(TextBox txtHokenryoDankai) {
        this.txtHokenryoDankai=txtHokenryoDankai;
    }

    @JsonProperty("txtShutokuYmd")
    public TextBoxFlexibleDate getTxtShutokuYmd() {
        return txtShutokuYmd;
    }

    @JsonProperty("txtShutokuYmd")
    public void setTxtShutokuYmd(TextBoxFlexibleDate txtShutokuYmd) {
        this.txtShutokuYmd=txtShutokuYmd;
    }

    @JsonProperty("txtShutokuJiyu")
    public TextBox getTxtShutokuJiyu() {
        return txtShutokuJiyu;
    }

    @JsonProperty("txtShutokuJiyu")
    public void setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.txtShutokuJiyu=txtShutokuJiyu;
    }

    @JsonProperty("txtSoshitsuYmd")
    public TextBoxFlexibleDate getTxtSoshitsuYmd() {
        return txtSoshitsuYmd;
    }

    @JsonProperty("txtSoshitsuYmd")
    public void setTxtSoshitsuYmd(TextBoxFlexibleDate txtSoshitsuYmd) {
        this.txtSoshitsuYmd=txtSoshitsuYmd;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu=txtSoshitsuJiyu;
    }

    @JsonProperty("btnHihoRireki")
    public ButtonDialog getBtnHihoRireki() {
        return btnHihoRireki;
    }

    @JsonProperty("btnHihoRireki")
    public void setBtnHihoRireki(ButtonDialog btnHihoRireki) {
        this.btnHihoRireki=btnHihoRireki;
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(TsuchishoNo 通知書番号, FlexibleYear 賦課年度, LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        getHandler().load(通知書番号, 賦課年度, 市町村コード, 識別コード);
    }

    @JsonIgnore
    public KaigoFukaKihonHandler getHandler() {
        return new KaigoFukaKihonHandler(this);
    }
}
