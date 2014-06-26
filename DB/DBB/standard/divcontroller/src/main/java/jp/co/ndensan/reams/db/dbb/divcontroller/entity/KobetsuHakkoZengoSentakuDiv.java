package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tblKobetsuHakkoFukakonkyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tblKobetsuHakkoKiwariGakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KobetsuHakkoZengoSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuHakkoZengoSentakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlInjiKouseiAto")
    private DropDownList ddlInjiKouseiAto;
    @JsonProperty("ddlInjiKouseiMae")
    private DropDownList ddlInjiKouseiMae;
    @JsonProperty("tblKobetsuHakkoFukakonkyo")
    private tblKobetsuHakkoFukakonkyoDiv tblKobetsuHakkoFukakonkyo;
    @JsonProperty("tblKobetsuHakkoKiwariGaku")
    private tblKobetsuHakkoKiwariGakuDiv tblKobetsuHakkoKiwariGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlInjiKouseiAto")
    public DropDownList getDdlInjiKouseiAto() {
        return ddlInjiKouseiAto;
    }

    @JsonProperty("ddlInjiKouseiAto")
    public void setDdlInjiKouseiAto(DropDownList ddlInjiKouseiAto) {
        this.ddlInjiKouseiAto=ddlInjiKouseiAto;
    }

    @JsonProperty("ddlInjiKouseiMae")
    public DropDownList getDdlInjiKouseiMae() {
        return ddlInjiKouseiMae;
    }

    @JsonProperty("ddlInjiKouseiMae")
    public void setDdlInjiKouseiMae(DropDownList ddlInjiKouseiMae) {
        this.ddlInjiKouseiMae=ddlInjiKouseiMae;
    }

    @JsonProperty("tblKobetsuHakkoFukakonkyo")
    public tblKobetsuHakkoFukakonkyoDiv getTblKobetsuHakkoFukakonkyo() {
        return tblKobetsuHakkoFukakonkyo;
    }

    @JsonProperty("tblKobetsuHakkoFukakonkyo")
    public void setTblKobetsuHakkoFukakonkyo(tblKobetsuHakkoFukakonkyoDiv tblKobetsuHakkoFukakonkyo) {
        this.tblKobetsuHakkoFukakonkyo=tblKobetsuHakkoFukakonkyo;
    }

    @JsonProperty("tblKobetsuHakkoKiwariGaku")
    public tblKobetsuHakkoKiwariGakuDiv getTblKobetsuHakkoKiwariGaku() {
        return tblKobetsuHakkoKiwariGaku;
    }

    @JsonProperty("tblKobetsuHakkoKiwariGaku")
    public void setTblKobetsuHakkoKiwariGaku(tblKobetsuHakkoKiwariGakuDiv tblKobetsuHakkoKiwariGaku) {
        this.tblKobetsuHakkoKiwariGaku=tblKobetsuHakkoKiwariGaku;
    }

}
