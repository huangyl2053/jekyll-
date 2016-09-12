package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 18 12:53:32 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgKyotakuServiceRirekiIchiran_Row のクラスファイル
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
public class dgKyotakuServiceRirekiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBoxDate taishoYM;
    private RString sakuseiKubun;
    private TextBoxDate tekiyoKaishiYMD;
    private TextBoxDate tekiyoShuryoYMD;
    private TextBoxDate todokedeYMD;
    private TextBoxDate koshinYMD;
    private RString rirekiNo;
    private RString kyotakuSogoJigyoKubun;

    public dgKyotakuServiceRirekiIchiran_Row() {
        super();
        this.taishoYM = new TextBoxDate();
        this.sakuseiKubun = RString.EMPTY;
        this.tekiyoKaishiYMD = new TextBoxDate();
        this.tekiyoShuryoYMD = new TextBoxDate();
        this.todokedeYMD = new TextBoxDate();
        this.koshinYMD = new TextBoxDate();
        this.rirekiNo = RString.EMPTY;
        this.kyotakuSogoJigyoKubun = RString.EMPTY;
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("koshinYMD", koshinYMD);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("kyotakuSogoJigyoKubun", kyotakuSogoJigyoKubun);
    }

    public dgKyotakuServiceRirekiIchiran_Row(TextBoxDate taishoYM, RString sakuseiKubun, TextBoxDate tekiyoKaishiYMD, TextBoxDate tekiyoShuryoYMD, TextBoxDate todokedeYMD, TextBoxDate koshinYMD, RString rirekiNo, RString kyotakuSogoJigyoKubun) {
        super();
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("koshinYMD", koshinYMD);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("kyotakuSogoJigyoKubun", kyotakuSogoJigyoKubun);
        this.taishoYM = taishoYM;
        this.sakuseiKubun = sakuseiKubun;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.todokedeYMD = todokedeYMD;
        this.koshinYMD = koshinYMD;
        this.rirekiNo = rirekiNo;
        this.kyotakuSogoJigyoKubun = kyotakuSogoJigyoKubun;
    }

    public TextBoxDate getTaishoYM() {
        return taishoYM;
    }

    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    public TextBoxDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public TextBoxDate getTodokedeYMD() {
        return todokedeYMD;
    }

    public TextBoxDate getKoshinYMD() {
        return koshinYMD;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getKyotakuSogoJigyoKubun() {
        return kyotakuSogoJigyoKubun;
    }

    public void setTaishoYM(TextBoxDate taishoYM) {
        this.setOriginalData("taishoYM", taishoYM);
        this.taishoYM = taishoYM;
    }

    public void setSakuseiKubun(RString sakuseiKubun) {
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.sakuseiKubun = sakuseiKubun;
    }

    public void setTekiyoKaishiYMD(TextBoxDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setTodokedeYMD(TextBoxDate todokedeYMD) {
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.todokedeYMD = todokedeYMD;
    }

    public void setKoshinYMD(TextBoxDate koshinYMD) {
        this.setOriginalData("koshinYMD", koshinYMD);
        this.koshinYMD = koshinYMD;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setKyotakuSogoJigyoKubun(RString kyotakuSogoJigyoKubun) {
        this.setOriginalData("kyotakuSogoJigyoKubun", kyotakuSogoJigyoKubun);
        this.kyotakuSogoJigyoKubun = kyotakuSogoJigyoKubun;
    }

    // </editor-fold>
}
