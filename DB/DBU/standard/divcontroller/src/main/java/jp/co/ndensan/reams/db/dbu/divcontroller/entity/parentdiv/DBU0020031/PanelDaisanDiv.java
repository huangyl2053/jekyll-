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
 * PanelDaisan のクラスファイル
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class PanelDaisanDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplDaisan")
    private tplDaisanDiv tplDaisan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplDaisan
     * @return tplDaisan
     */
    @JsonProperty("tplDaisan")
    public tplDaisanDiv getTplDaisan() {
        return tplDaisan;
    }

    /*
     * settplDaisan
     * @param tplDaisan tplDaisan
     */
    @JsonProperty("tplDaisan")
    public void setTplDaisan(tplDaisanDiv tplDaisan) {
        this.tplDaisan = tplDaisan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinseiKensu1() {
        return this.getTplDaisan().getTxtShinseiKensu1();
    }

    @JsonIgnore
    public TextBox getTxtShinseiKensu2() {
        return this.getTplDaisan().getTxtShinseiKensu2();
    }

    @JsonIgnore
    public TextBox getTxtShinseiKensu3() {
        return this.getTplDaisan().getTxtShinseiKensu3();
    }

    @JsonIgnore
    public TextBox getTxtShinseiKensu4() {
        return this.getTplDaisan().getTxtShinseiKensu4();
    }

    @JsonIgnore
    public TextBox getTxtShinseiKensu5() {
        return this.getTplDaisan().getTxtShinseiKensu5();
    }

    @JsonIgnore
    public TextBox getTxtShinseiKensu6() {
        return this.getTplDaisan().getTxtShinseiKensu6();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu1() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu1();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu2() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu2();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu3() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu3();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu4() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu4();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu5() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu5();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu6() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu6();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu7() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu7();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu8() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu8();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu9() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu9();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu10() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu10();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu11() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu11();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaisanKensu12() {
        return this.getTplDaisan().getTxtRiyoshaDaisanKensu12();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu1() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu1();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu2() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu2();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu3() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu3();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu4() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu4();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu5() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu5();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu6() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu6();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu7() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu7();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu8() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu8();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu9() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu9();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu10() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu10();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu11() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu11();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaisanKensu12() {
        return this.getTplDaisan().getTxtNinteiDaisanKensu12();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu1() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu1();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu2() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu2();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu3() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu3();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu4() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu4();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu5() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu5();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu6() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu6();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu7() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu7();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu8() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu8();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu9() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu9();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu10() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu10();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu11() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu11();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDainiKensu12() {
        return this.getTplDaisan().getTxtRiyoshaDainiKensu12();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu1() {
        return this.getTplDaisan().getTxtNinteiDainiKensu1();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu2() {
        return this.getTplDaisan().getTxtNinteiDainiKensu2();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu3() {
        return this.getTplDaisan().getTxtNinteiDainiKensu3();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu4() {
        return this.getTplDaisan().getTxtNinteiDainiKensu4();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu5() {
        return this.getTplDaisan().getTxtNinteiDainiKensu5();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu6() {
        return this.getTplDaisan().getTxtNinteiDainiKensu6();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu7() {
        return this.getTplDaisan().getTxtNinteiDainiKensu7();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu8() {
        return this.getTplDaisan().getTxtNinteiDainiKensu8();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu9() {
        return this.getTplDaisan().getTxtNinteiDainiKensu9();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu10() {
        return this.getTplDaisan().getTxtNinteiDainiKensu10();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu11() {
        return this.getTplDaisan().getTxtNinteiDainiKensu11();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDainiKensu12() {
        return this.getTplDaisan().getTxtNinteiDainiKensu12();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu1() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu1();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu2() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu2();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu3() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu3();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu4() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu4();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu5() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu5();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu6() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu6();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu7() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu7();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu8() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu8();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu9() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu9();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu10() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu10();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu11() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu11();
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaDaiichiKensu12() {
        return this.getTplDaisan().getTxtRiyoshaDaiichiKensu12();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu1() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu1();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu2() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu2();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu3() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu3();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu4() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu4();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu5() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu5();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu6() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu6();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu7() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu7();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu8() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu8();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu9() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu9();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu10() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu10();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu11() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu11();
    }

    @JsonIgnore
    public TextBox getTxtNinteiDaiichiKensu12() {
        return this.getTplDaisan().getTxtNinteiDaiichiKensu12();
    }

    // </editor-fold>
}
