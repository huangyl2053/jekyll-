package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Aug 08 13:54:03 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKyotakuServiceRirekiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKyotakuServiceRirekiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private TextBoxDate taishoYM;
    private RString sakuseiKubun;
    private TextBoxDate tekiyoKaishiYMD;
    private TextBoxDate tekiyoShuryoYMD;
    private TextBoxDate todokedeYMD;
    private RString todokedeKubun;
    private TextBoxDate koshinYMD;

    public dgKyotakuServiceRirekiIchiran_Row() {
        super();
        this.taishoYM = new TextBoxDate();
        this.sakuseiKubun = RString.EMPTY;
        this.tekiyoKaishiYMD = new TextBoxDate();
        this.tekiyoShuryoYMD = new TextBoxDate();
        this.todokedeYMD = new TextBoxDate();
        this.todokedeKubun = RString.EMPTY;
        this.koshinYMD = new TextBoxDate();
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("todokedeKubun", todokedeKubun);
        this.setOriginalData("koshinYMD", koshinYMD);
    }

    public dgKyotakuServiceRirekiIchiran_Row(TextBoxDate taishoYM, RString sakuseiKubun, TextBoxDate tekiyoKaishiYMD, TextBoxDate tekiyoShuryoYMD, TextBoxDate todokedeYMD, RString todokedeKubun, TextBoxDate koshinYMD) {
        super();
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("todokedeKubun", todokedeKubun);
        this.setOriginalData("koshinYMD", koshinYMD);
        this.taishoYM = taishoYM;
        this.sakuseiKubun = sakuseiKubun;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.todokedeYMD = todokedeYMD;
        this.todokedeKubun = todokedeKubun;
        this.koshinYMD = koshinYMD;
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

    public RString getTodokedeKubun() {
        return todokedeKubun;
    }

    public TextBoxDate getKoshinYMD() {
        return koshinYMD;
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

    public void setTodokedeKubun(RString todokedeKubun) {
        this.setOriginalData("todokedeKubun", todokedeKubun);
        this.todokedeKubun = todokedeKubun;
    }

    public void setKoshinYMD(TextBoxDate koshinYMD) {
        this.setOriginalData("koshinYMD", koshinYMD);
        this.koshinYMD = koshinYMD;
    }

    // </editor-fold>
}
