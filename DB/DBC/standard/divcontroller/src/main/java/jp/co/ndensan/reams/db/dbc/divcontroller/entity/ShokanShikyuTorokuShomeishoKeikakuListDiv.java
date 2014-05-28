package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoKeikakuListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeishoKeikakuList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoKeikakuListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKeikakuhiJigyoshaKubunH2104")
    private DropDownList ddlKeikakuhiJigyoshaKubunH2104;
    @JsonProperty("radKeikakuhiShinsaHohoH2104")
    private RadioButton radKeikakuhiShinsaHohoH2104;
    @JsonProperty("txtKeikakuhiTodokedeYMDH2104")
    private TextBoxDate txtKeikakuhiTodokedeYMDH2104;
    @JsonProperty("txtKeikakuhiSenmoninNoH2104")
    private TextBoxCode txtKeikakuhiSenmoninNoH2104;
    @JsonProperty("txtKeikakuhiTanisuTankaH2104")
    private TextBoxNum txtKeikakuhiTanisuTankaH2104;
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuListInfo")
    private ServiceTeikyoShomeishoKeikakuListDiv ShokanShikyuTorokuShomeishoKeikakuListInfo;
    @JsonProperty("txtKeikakuhiGokeiTanisu")
    private TextBoxNum txtKeikakuhiGokeiTanisu;
    @JsonProperty("txtKeikakuhiSeikyuKingakuH2104")
    private TextBoxNum txtKeikakuhiSeikyuKingakuH2104;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlKeikakuhiJigyoshaKubunH2104")
    public DropDownList getDdlKeikakuhiJigyoshaKubunH2104() {
        return ddlKeikakuhiJigyoshaKubunH2104;
    }

    @JsonProperty("ddlKeikakuhiJigyoshaKubunH2104")
    public void setDdlKeikakuhiJigyoshaKubunH2104(DropDownList ddlKeikakuhiJigyoshaKubunH2104) {
        this.ddlKeikakuhiJigyoshaKubunH2104=ddlKeikakuhiJigyoshaKubunH2104;
    }

    @JsonProperty("radKeikakuhiShinsaHohoH2104")
    public RadioButton getRadKeikakuhiShinsaHohoH2104() {
        return radKeikakuhiShinsaHohoH2104;
    }

    @JsonProperty("radKeikakuhiShinsaHohoH2104")
    public void setRadKeikakuhiShinsaHohoH2104(RadioButton radKeikakuhiShinsaHohoH2104) {
        this.radKeikakuhiShinsaHohoH2104=radKeikakuhiShinsaHohoH2104;
    }

    @JsonProperty("txtKeikakuhiTodokedeYMDH2104")
    public TextBoxDate getTxtKeikakuhiTodokedeYMDH2104() {
        return txtKeikakuhiTodokedeYMDH2104;
    }

    @JsonProperty("txtKeikakuhiTodokedeYMDH2104")
    public void setTxtKeikakuhiTodokedeYMDH2104(TextBoxDate txtKeikakuhiTodokedeYMDH2104) {
        this.txtKeikakuhiTodokedeYMDH2104=txtKeikakuhiTodokedeYMDH2104;
    }

    @JsonProperty("txtKeikakuhiSenmoninNoH2104")
    public TextBoxCode getTxtKeikakuhiSenmoninNoH2104() {
        return txtKeikakuhiSenmoninNoH2104;
    }

    @JsonProperty("txtKeikakuhiSenmoninNoH2104")
    public void setTxtKeikakuhiSenmoninNoH2104(TextBoxCode txtKeikakuhiSenmoninNoH2104) {
        this.txtKeikakuhiSenmoninNoH2104=txtKeikakuhiSenmoninNoH2104;
    }

    @JsonProperty("txtKeikakuhiTanisuTankaH2104")
    public TextBoxNum getTxtKeikakuhiTanisuTankaH2104() {
        return txtKeikakuhiTanisuTankaH2104;
    }

    @JsonProperty("txtKeikakuhiTanisuTankaH2104")
    public void setTxtKeikakuhiTanisuTankaH2104(TextBoxNum txtKeikakuhiTanisuTankaH2104) {
        this.txtKeikakuhiTanisuTankaH2104=txtKeikakuhiTanisuTankaH2104;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuListInfo")
    public ServiceTeikyoShomeishoKeikakuListDiv getShokanShikyuTorokuShomeishoKeikakuListInfo() {
        return ShokanShikyuTorokuShomeishoKeikakuListInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuListInfo")
    public void setShokanShikyuTorokuShomeishoKeikakuListInfo(ServiceTeikyoShomeishoKeikakuListDiv ShokanShikyuTorokuShomeishoKeikakuListInfo) {
        this.ShokanShikyuTorokuShomeishoKeikakuListInfo=ShokanShikyuTorokuShomeishoKeikakuListInfo;
    }

    @JsonProperty("txtKeikakuhiGokeiTanisu")
    public TextBoxNum getTxtKeikakuhiGokeiTanisu() {
        return txtKeikakuhiGokeiTanisu;
    }

    @JsonProperty("txtKeikakuhiGokeiTanisu")
    public void setTxtKeikakuhiGokeiTanisu(TextBoxNum txtKeikakuhiGokeiTanisu) {
        this.txtKeikakuhiGokeiTanisu=txtKeikakuhiGokeiTanisu;
    }

    @JsonProperty("txtKeikakuhiSeikyuKingakuH2104")
    public TextBoxNum getTxtKeikakuhiSeikyuKingakuH2104() {
        return txtKeikakuhiSeikyuKingakuH2104;
    }

    @JsonProperty("txtKeikakuhiSeikyuKingakuH2104")
    public void setTxtKeikakuhiSeikyuKingakuH2104(TextBoxNum txtKeikakuhiSeikyuKingakuH2104) {
        this.txtKeikakuhiSeikyuKingakuH2104=txtKeikakuhiSeikyuKingakuH2104;
    }

}
