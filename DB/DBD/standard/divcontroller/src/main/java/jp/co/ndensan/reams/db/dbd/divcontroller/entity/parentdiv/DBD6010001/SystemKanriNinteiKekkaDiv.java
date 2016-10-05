package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001;
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
 * SystemKanriNinteiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class SystemKanriNinteiKekkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplSystemKanri")
    private tplSystemKanriDiv tplSystemKanri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplSystemKanri
     * @return tplSystemKanri
     */
    @JsonProperty("tplSystemKanri")
    public tplSystemKanriDiv getTplSystemKanri() {
        return tplSystemKanri;
    }

    /*
     * settplSystemKanri
     * @param tplSystemKanri tplSystemKanri
     */
    @JsonProperty("tplSystemKanri")
    public void setTplSystemKanri(tplSystemKanriDiv tplSystemKanri) {
        this.tplSystemKanri = tplSystemKanri;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho1() {
        return this.getTplSystemKanri().getTxtFukaJoho1();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho2() {
        return this.getTplSystemKanri().getTxtFukaJoho2();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho3() {
        return this.getTplSystemKanri().getTxtFukaJoho3();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho4() {
        return this.getTplSystemKanri().getTxtFukaJoho4();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho5() {
        return this.getTplSystemKanri().getTxtFukaJoho5();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho6() {
        return this.getTplSystemKanri().getTxtFukaJoho6();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho7() {
        return this.getTplSystemKanri().getTxtFukaJoho7();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho8() {
        return this.getTplSystemKanri().getTxtFukaJoho8();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaJoho9() {
        return this.getTplSystemKanri().getTxtFukaJoho9();
    }

    // </editor-fold>
}
