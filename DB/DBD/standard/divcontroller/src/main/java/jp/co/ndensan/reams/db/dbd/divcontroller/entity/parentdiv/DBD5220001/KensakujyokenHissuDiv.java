package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakujyokenHissu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakujyokenHissuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cblShinseiKubun")
    private CheckBoxList cblShinseiKubun;
    @JsonProperty("cblHakkoUmu")
    private CheckBoxList cblHakkoUmu;
    @JsonProperty("radMinashiNigo")
    private RadioButton radMinashiNigo;
    @JsonProperty("txtKeikaNissu")
    private TextBoxNum txtKeikaNissu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcblShinseiKubun
     * @return cblShinseiKubun
     */
    @JsonProperty("cblShinseiKubun")
    public CheckBoxList getCblShinseiKubun() {
        return cblShinseiKubun;
    }

    /*
     * setcblShinseiKubun
     * @param cblShinseiKubun cblShinseiKubun
     */
    @JsonProperty("cblShinseiKubun")
    public void setCblShinseiKubun(CheckBoxList cblShinseiKubun) {
        this.cblShinseiKubun = cblShinseiKubun;
    }

    /*
     * getcblHakkoUmu
     * @return cblHakkoUmu
     */
    @JsonProperty("cblHakkoUmu")
    public CheckBoxList getCblHakkoUmu() {
        return cblHakkoUmu;
    }

    /*
     * setcblHakkoUmu
     * @param cblHakkoUmu cblHakkoUmu
     */
    @JsonProperty("cblHakkoUmu")
    public void setCblHakkoUmu(CheckBoxList cblHakkoUmu) {
        this.cblHakkoUmu = cblHakkoUmu;
    }

    /*
     * getradMinashiNigo
     * @return radMinashiNigo
     */
    @JsonProperty("radMinashiNigo")
    public RadioButton getRadMinashiNigo() {
        return radMinashiNigo;
    }

    /*
     * setradMinashiNigo
     * @param radMinashiNigo radMinashiNigo
     */
    @JsonProperty("radMinashiNigo")
    public void setRadMinashiNigo(RadioButton radMinashiNigo) {
        this.radMinashiNigo = radMinashiNigo;
    }

    /*
     * gettxtKeikaNissu
     * @return txtKeikaNissu
     */
    @JsonProperty("txtKeikaNissu")
    public TextBoxNum getTxtKeikaNissu() {
        return txtKeikaNissu;
    }

    /*
     * settxtKeikaNissu
     * @param txtKeikaNissu txtKeikaNissu
     */
    @JsonProperty("txtKeikaNissu")
    public void setTxtKeikaNissu(TextBoxNum txtKeikaNissu) {
        this.txtKeikaNissu = txtKeikaNissu;
    }

    // </editor-fold>
}
