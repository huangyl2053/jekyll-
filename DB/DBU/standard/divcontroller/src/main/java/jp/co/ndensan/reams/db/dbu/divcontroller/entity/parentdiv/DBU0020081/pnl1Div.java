package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * pnl1 のクラスファイル
 *
 * @reamsid_L DBU-1100-070 yebangqiang
 */
public class pnl1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabMain")
    private tabMainDiv tabMain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabMain
     * @return tabMain
     */
    @JsonProperty("tabMain")
    public tabMainDiv getTabMain() {
        return tabMain;
    }

    /*
     * settabMain
     * @param tabMain tabMain
     */
    @JsonProperty("tabMain")
    public void setTabMain(tabMainDiv tabMain) {
        this.tabMain = tabMain;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tpl1Div getTpl1() {
        return this.getTabMain().getTpl1();
    }

    @JsonIgnore
    public void setTpl1(tpl1Div tpl1) {
        this.getTabMain().setTpl1(tpl1);
    }

    @JsonIgnore
    public tbp1Div getTbp1() {
        return this.getTabMain().getTpl1().getTbp1();
    }

    @JsonIgnore
    public void setTbp1(tbp1Div tbp1) {
        this.getTabMain().getTpl1().setTbp1(tbp1);
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiFukushiGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiFukushiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiHokenGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiRyoyoGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiMitchakuGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiMitchakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiHokenGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SyokuhiTankiRyoyoGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SyokuhiTankiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiFukushiGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiFukushiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiHokenGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiRyoyoGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiMitchakuGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiMitchakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiHokenGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1KyojuhiTankiRyoyoGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1KyojuhiTankiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiYoboYoshien1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiYoboYoshien2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiYoboYoshienKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiKaigoKeikateki() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiKaigoYokaigo1() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiKaigoYokaigo2() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiKaigoYokaigo3() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiKaigoYokaigo4() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiKaigoYokaigo5() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiKaigoYokaigoKei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt1SokeiGokei() {
        return this.getTabMain().getTpl1().getTbp1().getTxt1SokeiGokei();
    }

    @JsonIgnore
    public tpl2Div getTpl2() {
        return this.getTabMain().getTpl2();
    }

    @JsonIgnore
    public void setTpl2(tpl2Div tpl2) {
        this.getTabMain().setTpl2(tpl2);
    }

    @JsonIgnore
    public tbp2Div getTbp2() {
        return this.getTabMain().getTpl2().getTbp2();
    }

    @JsonIgnore
    public void setTbp2(tbp2Div tbp2) {
        this.getTabMain().getTpl2().setTbp2(tbp2);
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiFukushiGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiFukushiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiHokenGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiRyoyoGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiMitchakuGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiMitchakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiHokenGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SyokuhiTankiRyoyoGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SyokuhiTankiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiFukushiGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiFukushiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiHokenGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiRyoyoGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiMitchakuGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiMitchakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiHokenGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiHokenGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2KyojuhiTankiRyoyoGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2KyojuhiTankiRyoyoGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiYoboYoshien1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiYoboYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiYoboYoshien2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiYoboYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiYoboYoshienKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiYoboYoshienKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiKaigoKeikateki() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiKaigoKeikateki();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiKaigoYokaigo1() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiKaigoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiKaigoYokaigo2() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiKaigoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiKaigoYokaigo3() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiKaigoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiKaigoYokaigo4() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiKaigoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiKaigoYokaigo5() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiKaigoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiKaigoYokaigoKei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiKaigoYokaigoKei();
    }

    @JsonIgnore
    public TextBoxNum getTxt2SokeiGokei() {
        return this.getTabMain().getTpl2().getTbp2().getTxt2SokeiGokei();
    }

    // </editor-fold>
}
