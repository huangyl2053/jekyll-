package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * SokujikouseiKiwarigaku のクラスファイル
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujikouseiKiwarigakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKiwarigaku")
    private tblKiwarigakuDiv tblKiwarigaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblKiwarigaku
     * @return tblKiwarigaku
     */
    @JsonProperty("tblKiwarigaku")
    public tblKiwarigakuDiv getTblKiwarigaku() {
        return tblKiwarigaku;
    }

    /*
     * settblKiwarigaku
     * @param tblKiwarigaku tblKiwarigaku
     */
    @JsonProperty("tblKiwarigaku")
    public void setTblKiwarigaku(tblKiwarigakuDiv tblKiwarigaku) {
        this.tblKiwarigaku = tblKiwarigaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTokucho() {
        return this.getTblKiwarigaku().getLblTokucho();
    }

    @JsonIgnore
    public Label getLblFucho() {
        return this.getTblKiwarigaku().getLblFucho();
    }

    @JsonIgnore
    public Label getLblTsuki() {
        return this.getTblKiwarigaku().getLblTsuki();
    }

    @JsonIgnore
    public Label getLblTokuchoKi() {
        return this.getTblKiwarigaku().getLblTokuchoKi();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMae() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMae();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGo() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGo();
    }

    @JsonIgnore
    public Label getLblTokuchoZogen() {
        return this.getTblKiwarigaku().getLblTokuchoZogen();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugaku() {
        return this.getTblKiwarigaku().getLblTokuchoNofugaku();
    }

    @JsonIgnore
    public Label getLblFuchoKi() {
        return this.getTblKiwarigaku().getLblFuchoKi();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMae() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMae();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGo() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGo();
    }

    @JsonIgnore
    public Label getLblFuchoZogen() {
        return this.getTblKiwarigaku().getLblFuchoZogen();
    }

    @JsonIgnore
    public Label getLblFuchoNofugaku() {
        return this.getTblKiwarigaku().getLblFuchoNofugaku();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen() {
        return this.getTblKiwarigaku().getLblFuchoNokigen();
    }

    @JsonIgnore
    public Label getLblTsuki4() {
        return this.getTblKiwarigaku().getLblTsuki4();
    }

    @JsonIgnore
    public Label getLblTokuchoKi04() {
        return this.getTblKiwarigaku().getLblTokuchoKi04();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMaeValue04() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMaeValue04();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGoValue04() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGoValue04();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuchoKoseiGo04() {
        return this.getTblKiwarigaku().getTxtTokuchoKoseiGo04();
    }

    @JsonIgnore
    public Label getLblTokuchoZogenValue04() {
        return this.getTblKiwarigaku().getLblTokuchoZogenValue04();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugakuValue04() {
        return this.getTblKiwarigaku().getLblTokuchoNofugakuValue04();
    }

    @JsonIgnore
    public Label getLblFuchoKi04() {
        return this.getTblKiwarigaku().getLblFuchoKi04();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue04() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue04();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue04() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue04();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo04() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo04();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue04() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue04();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue04() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue04();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue04() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue04();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen04() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen04();
    }

    @JsonIgnore
    public Label getLblTsuki5() {
        return this.getTblKiwarigaku().getLblTsuki5();
    }

    @JsonIgnore
    public Label getLblFuchoKi05() {
        return this.getTblKiwarigaku().getLblFuchoKi05();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue05() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue05();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue05() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue05();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo05() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo05();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue05() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue05();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue05() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue05();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue05() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue05();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen05() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen05();
    }

    @JsonIgnore
    public Label getLblTsuki6() {
        return this.getTblKiwarigaku().getLblTsuki6();
    }

    @JsonIgnore
    public Label getLblTokuchoKi06() {
        return this.getTblKiwarigaku().getLblTokuchoKi06();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMaeValue06() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMaeValue06();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGoValue06() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGoValue06();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuchoKoseiGo06() {
        return this.getTblKiwarigaku().getTxtTokuchoKoseiGo06();
    }

    @JsonIgnore
    public Label getLblTokuchoZogenValue06() {
        return this.getTblKiwarigaku().getLblTokuchoZogenValue06();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugakuValue06() {
        return this.getTblKiwarigaku().getLblTokuchoNofugakuValue06();
    }

    @JsonIgnore
    public Label getLblFuchoKi06() {
        return this.getTblKiwarigaku().getLblFuchoKi06();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue06() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue06();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue06() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue06();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo06() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo06();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue06() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue06();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue06() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue06();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue06() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue06();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen06() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen06();
    }

    @JsonIgnore
    public Label getLblTsuki7() {
        return this.getTblKiwarigaku().getLblTsuki7();
    }

    @JsonIgnore
    public Label getLblFuchoKi07() {
        return this.getTblKiwarigaku().getLblFuchoKi07();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue07() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue07();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue07() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue07();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo07() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo07();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue07() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue07();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue07() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue07();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue07() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue07();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen07() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen07();
    }

    @JsonIgnore
    public Label getLblTsuki8() {
        return this.getTblKiwarigaku().getLblTsuki8();
    }

    @JsonIgnore
    public Label getLblTokuchoKi08() {
        return this.getTblKiwarigaku().getLblTokuchoKi08();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMaeValue08() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMaeValue08();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGoValue08() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGoValue08();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuchoKoseiGo08() {
        return this.getTblKiwarigaku().getTxtTokuchoKoseiGo08();
    }

    @JsonIgnore
    public Label getLblTokuchoZogenValue08() {
        return this.getTblKiwarigaku().getLblTokuchoZogenValue08();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugakuValue08() {
        return this.getTblKiwarigaku().getLblTokuchoNofugakuValue08();
    }

    @JsonIgnore
    public Label getLblFuchoKi08() {
        return this.getTblKiwarigaku().getLblFuchoKi08();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue08() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue08();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue08() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue08();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo08() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo08();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue08() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue08();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue08() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue08();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue08() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue08();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen08() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen08();
    }

    @JsonIgnore
    public Label getLblTsuki9() {
        return this.getTblKiwarigaku().getLblTsuki9();
    }

    @JsonIgnore
    public Label getLblFuchoKi09() {
        return this.getTblKiwarigaku().getLblFuchoKi09();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue09() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue09();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue09() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue09();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo09() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo09();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue09() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue09();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue09() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue09();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue09() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue09();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen09() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen09();
    }

    @JsonIgnore
    public Label getLblTsuki10() {
        return this.getTblKiwarigaku().getLblTsuki10();
    }

    @JsonIgnore
    public Label getLblTokuchoKi10() {
        return this.getTblKiwarigaku().getLblTokuchoKi10();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMaeValue10() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMaeValue10();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGoValue10() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGoValue10();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuchoKoseiGo10() {
        return this.getTblKiwarigaku().getTxtTokuchoKoseiGo10();
    }

    @JsonIgnore
    public Label getLblTokuchoZogenValue10() {
        return this.getTblKiwarigaku().getLblTokuchoZogenValue10();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugakuValue10() {
        return this.getTblKiwarigaku().getLblTokuchoNofugakuValue10();
    }

    @JsonIgnore
    public Label getLblFuchoKi10() {
        return this.getTblKiwarigaku().getLblFuchoKi10();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue10() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue10();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue10() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue10();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo10() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo10();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue10() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue10();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue10() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue10();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue10() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue10();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen10() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen10();
    }

    @JsonIgnore
    public Label getLblTsuki11() {
        return this.getTblKiwarigaku().getLblTsuki11();
    }

    @JsonIgnore
    public Label getLblFuchoKi11() {
        return this.getTblKiwarigaku().getLblFuchoKi11();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue11() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue11();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue11() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue11();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo11() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo11();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue11() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue11();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue11() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue11();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue11() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue11();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen11() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen11();
    }

    @JsonIgnore
    public Label getLblTsuki12() {
        return this.getTblKiwarigaku().getLblTsuki12();
    }

    @JsonIgnore
    public Label getLblTokuchoKi12() {
        return this.getTblKiwarigaku().getLblTokuchoKi12();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMaeValue12() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMaeValue12();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGoValue12() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGoValue12();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuchoKoseiGo12() {
        return this.getTblKiwarigaku().getTxtTokuchoKoseiGo12();
    }

    @JsonIgnore
    public Label getLblTokuchoZogenValue12() {
        return this.getTblKiwarigaku().getLblTokuchoZogenValue12();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugakuValue12() {
        return this.getTblKiwarigaku().getLblTokuchoNofugakuValue12();
    }

    @JsonIgnore
    public Label getLblFuchoKi12() {
        return this.getTblKiwarigaku().getLblFuchoKi12();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue12() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue12();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue12() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue12();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo12() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo12();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue12() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue12();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue12() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue12();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue12() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue12();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen12() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen12();
    }

    @JsonIgnore
    public Label getLblTsuki1() {
        return this.getTblKiwarigaku().getLblTsuki1();
    }

    @JsonIgnore
    public Label getLblFuchoKi01() {
        return this.getTblKiwarigaku().getLblFuchoKi01();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue01() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue01();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue01() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue01();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo01() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo01();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue01() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue01();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue01() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue01();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue01() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue01();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen01() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen01();
    }

    @JsonIgnore
    public Label getLblTsuki2() {
        return this.getTblKiwarigaku().getLblTsuki2();
    }

    @JsonIgnore
    public Label getLblTokuchoKi02() {
        return this.getTblKiwarigaku().getLblTokuchoKi02();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMaeValue02() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMaeValue02();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGoValue02() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGoValue02();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuchoKoseiGo02() {
        return this.getTblKiwarigaku().getTxtTokuchoKoseiGo02();
    }

    @JsonIgnore
    public Label getLblTokuchoZogenValue02() {
        return this.getTblKiwarigaku().getLblTokuchoZogenValue02();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugakuValue02() {
        return this.getTblKiwarigaku().getLblTokuchoNofugakuValue02();
    }

    @JsonIgnore
    public Label getLblFuchoKi02() {
        return this.getTblKiwarigaku().getLblFuchoKi02();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue02() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue02();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue02() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue02();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo02() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo02();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue02() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue02();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue02() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue02();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue02() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue02();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen02() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen02();
    }

    @JsonIgnore
    public Label getLblTsuki3() {
        return this.getTblKiwarigaku().getLblTsuki3();
    }

    @JsonIgnore
    public Label getLblFuchoKi03() {
        return this.getTblKiwarigaku().getLblFuchoKi03();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValue03() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValue03();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue03() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue03();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGo03() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGo03();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValue03() {
        return this.getTblKiwarigaku().getLblFuchoZogenValue03();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValue03() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValue03();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValue03() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValue03();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigen03() {
        return this.getTblKiwarigaku().getTxtFuchoNokigen03();
    }

    @JsonIgnore
    public Label getLblTsukiYoku4() {
        return this.getTblKiwarigaku().getLblTsukiYoku4();
    }

    @JsonIgnore
    public Label getLblFuchoKiYoku04() {
        return this.getTblKiwarigaku().getLblFuchoKiYoku04();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValueYoku04() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValueYoku04();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValue14() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValue14();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGoYoku04() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGoYoku04();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValueYoku04() {
        return this.getTblKiwarigaku().getLblFuchoZogenValueYoku04();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValueYoku04() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValueYoku04();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValueYoku04() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValueYoku04();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigenYoku04() {
        return this.getTblKiwarigaku().getTxtFuchoNokigenYoku04();
    }

    @JsonIgnore
    public Label getLblTsukiYoku5() {
        return this.getTblKiwarigaku().getLblTsukiYoku5();
    }

    @JsonIgnore
    public Label getLblFuchoKiYoku05() {
        return this.getTblKiwarigaku().getLblFuchoKiYoku05();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeValueYoku05() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeValueYoku05();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoValueYoku05() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoValueYoku05();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuchoKoseiGoYoku05() {
        return this.getTblKiwarigaku().getTxtFuchoKoseiGoYoku05();
    }

    @JsonIgnore
    public Label getLblFuchoZogenValueYoku05() {
        return this.getTblKiwarigaku().getLblFuchoZogenValueYoku05();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuValueYoku05() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuValueYoku05();
    }

    @JsonIgnore
    public Label getLblFuchoNokigenValueYoku05() {
        return this.getTblKiwarigaku().getLblFuchoNokigenValueYoku05();
    }

    @JsonIgnore
    public TextBoxDate getTxtFuchoNokigenYoku05() {
        return this.getTblKiwarigaku().getTxtFuchoNokigenYoku05();
    }

    @JsonIgnore
    public Label getLblGokei() {
        return this.getTblKiwarigaku().getLblGokei();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiMaeSum() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiMaeSum();
    }

    @JsonIgnore
    public Label getLblTokuchoKoseiGoSum() {
        return this.getTblKiwarigaku().getLblTokuchoKoseiGoSum();
    }

    @JsonIgnore
    public Label getLblTokuchoZogenSum() {
        return this.getTblKiwarigaku().getLblTokuchoZogenSum();
    }

    @JsonIgnore
    public Label getLblTokuchoNofugakuSum() {
        return this.getTblKiwarigaku().getLblTokuchoNofugakuSum();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiMaeSum() {
        return this.getTblKiwarigaku().getLblFuchoKoseiMaeSum();
    }

    @JsonIgnore
    public Label getLblFuchoKoseiGoSum() {
        return this.getTblKiwarigaku().getLblFuchoKoseiGoSum();
    }

    @JsonIgnore
    public Label getLblFuchoZogenSum() {
        return this.getTblKiwarigaku().getLblFuchoZogenSum();
    }

    @JsonIgnore
    public Label getLblFuchoNofugakuSum() {
        return this.getTblKiwarigaku().getLblFuchoNofugakuSum();
    }

    // </editor-fold>
}
