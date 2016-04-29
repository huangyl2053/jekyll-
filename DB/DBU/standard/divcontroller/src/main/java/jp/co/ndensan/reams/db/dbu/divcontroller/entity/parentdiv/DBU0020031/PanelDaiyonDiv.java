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
 * PanelDaiyon のクラスファイル
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class PanelDaiyonDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplDaiyon")
    private tplDaiyonDiv tplDaiyon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplDaiyon
     * @return tplDaiyon
     */
    @JsonProperty("tplDaiyon")
    public tplDaiyonDiv getTplDaiyon() {
        return tplDaiyon;
    }

    /*
     * settplDaiyon
     * @param tplDaiyon tplDaiyon
     */
    @JsonProperty("tplDaiyon")
    public void setTplDaiyon(tplDaiyonDiv tplDaiyon) {
        this.tplDaiyon = tplDaiyon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinseiKensuRiyosha() {
        return this.getTplDaiyon().getTxtShinseiKensuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtGengakuNinteiKensuRiyosha() {
        return this.getTplDaiyon().getTxtGengakuNinteiKensuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiGengakuRiyosha() {
        return this.getTplDaiyon().getTxtNinteiKensuGenzaiGengakuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtMenjoNinteiKensuRiyosha() {
        return this.getTplDaiyon().getTxtMenjoNinteiKensuRiyosha();
    }

    @JsonIgnore
    public TextBox getTxtNinteiKensuGenzaiMenjoRiyosha() {
        return this.getTplDaiyon().getTxtNinteiKensuGenzaiMenjoRiyosha();
    }

    // </editor-fold>
}
