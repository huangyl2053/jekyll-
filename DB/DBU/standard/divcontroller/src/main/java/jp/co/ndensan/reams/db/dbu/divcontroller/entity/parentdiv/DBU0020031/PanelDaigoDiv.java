package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * PanelDaigo のクラスファイル
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class PanelDaigoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplDaigoIchi")
    private tplDaigoIchiDiv tplDaigoIchi;
    @JsonProperty("tplDaigoNi")
    private tplDaigoNiDiv tplDaigoNi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplDaigoIchi
     * @return tplDaigoIchi
     */
    @JsonProperty("tplDaigoIchi")
    public tplDaigoIchiDiv getTplDaigoIchi() {
        return tplDaigoIchi;
    }

    /*
     * settplDaigoIchi
     * @param tplDaigoIchi tplDaigoIchi
     */
    @JsonProperty("tplDaigoIchi")
    public void setTplDaigoIchi(tplDaigoIchiDiv tplDaigoIchi) {
        this.tplDaigoIchi = tplDaigoIchi;
    }

    /*
     * gettplDaigoNi
     * @return tplDaigoNi
     */
    @JsonProperty("tplDaigoNi")
    public tplDaigoNiDiv getTplDaigoNi() {
        return tplDaigoNi;
    }

    /*
     * settplDaigoNi
     * @param tplDaigoNi tplDaigoNi
     */
    @JsonProperty("tplDaigoNi")
    public void setTplDaigoNi(tplDaigoNiDiv tplDaigoNi) {
        this.tplDaigoNi = tplDaigoNi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKensu522() {
        return this.getTplDaigoIchi().getTxtKensu522();
    }

    @JsonIgnore
    public TextBox getTxtKensu532() {
        return this.getTplDaigoIchi().getTxtKensu532();
    }

    @JsonIgnore
    public TextBox getTxtKensu533() {
        return this.getTplDaigoIchi().getTxtKensu533();
    }

    @JsonIgnore
    public TextBox getTxtKensu542() {
        return this.getTplDaigoIchi().getTxtKensu542();
    }

    @JsonIgnore
    public TextBox getTxtKensu543() {
        return this.getTplDaigoIchi().getTxtKensu543();
    }

    @JsonIgnore
    public TextBox getTxtKensu552() {
        return this.getTplDaigoIchi().getTxtKensu552();
    }

    @JsonIgnore
    public TextBox getTxtKensu553() {
        return this.getTplDaigoIchi().getTxtKensu553();
    }

    @JsonIgnore
    public TextBox getTxtKensu562() {
        return this.getTplDaigoIchi().getTxtKensu562();
    }

    @JsonIgnore
    public TextBox getTxtKensu563() {
        return this.getTplDaigoIchi().getTxtKensu563();
    }

    @JsonIgnore
    public TextBox getTxtKensu572() {
        return this.getTplDaigoIchi().getTxtKensu572();
    }

    @JsonIgnore
    public TextBox getTxtKensu573() {
        return this.getTplDaigoIchi().getTxtKensu573();
    }

    @JsonIgnore
    public TextBox getTxtKensu582() {
        return this.getTplDaigoIchi().getTxtKensu582();
    }

    @JsonIgnore
    public TextBox getTxtKensu583() {
        return this.getTplDaigoIchi().getTxtKensu583();
    }

    @JsonIgnore
    public TextBox getTxtShinseiKensu() {
        return this.getTplDaigoNi().getTxtShinseiKensu();
    }

    @JsonIgnore
    public TextBox getTxtGengakuNinteiKensu() {
        return this.getTplDaigoNi().getTxtGengakuNinteiKensu();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiGengaku() {
        return this.getTplDaigoNi().getTxtNinteiKensuGenzaiGengaku();
    }

    @JsonIgnore
    public TextBox getTxtMenjoNinteiKensu() {
        return this.getTplDaigoNi().getTxtMenjoNinteiKensu();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiMenjo() {
        return this.getTplDaigoNi().getTxtNinteiKensuGenzaiMenjo();
    }

    // </editor-fold>
}
