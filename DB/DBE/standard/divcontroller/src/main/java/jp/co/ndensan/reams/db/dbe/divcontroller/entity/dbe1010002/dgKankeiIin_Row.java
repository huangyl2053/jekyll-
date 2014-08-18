package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jul 24 11:13:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgKankeiIin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKankeiIin_Row extends DataRow {

    private RString code;
    private RString name;
    private RString shozokuKikan;
    private RString shozokuKikanCode;
    private RString shozokuKikanMeisho;
    private TextBoxNum kanriNo;

    public dgKankeiIin_Row() {
        super();
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
        this.shozokuKikan = RString.EMPTY;
        this.shozokuKikanCode = RString.EMPTY;
        this.shozokuKikanMeisho = RString.EMPTY;
        this.kanriNo = new TextBoxNum();
    }

    public dgKankeiIin_Row(RString code, RString name, RString shozokuKikan, RString shozokuKikanCode, RString shozokuKikanMeisho, TextBoxNum kanriNo) {
        super();
        this.setOriginalData("code", code);
        this.setOriginalData("name", name);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("shozokuKikanCode", shozokuKikanCode);
        this.setOriginalData("shozokuKikanMeisho", shozokuKikanMeisho);
        this.setOriginalData("kanriNo", kanriNo);
        this.code = code;
        this.name = name;
        this.shozokuKikan = shozokuKikan;
        this.shozokuKikanCode = shozokuKikanCode;
        this.shozokuKikanMeisho = shozokuKikanMeisho;
        this.kanriNo = kanriNo;
    }

    public RString getCode() {
        return code;
    }

    public RString getName() {
        return name;
    }

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public RString getShozokuKikanCode() {
        return shozokuKikanCode;
    }

    public RString getShozokuKikanMeisho() {
        return shozokuKikanMeisho;
    }

    public TextBoxNum getKanriNo() {
        return kanriNo;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setName(RString name) {
        this.setOriginalData("name", name);
        this.name = name;
    }

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

    public void setShozokuKikanCode(RString shozokuKikanCode) {
        this.setOriginalData("shozokuKikanCode", shozokuKikanCode);
        this.shozokuKikanCode = shozokuKikanCode;
    }

    public void setShozokuKikanMeisho(RString shozokuKikanMeisho) {
        this.setOriginalData("shozokuKikanMeisho", shozokuKikanMeisho);
        this.shozokuKikanMeisho = shozokuKikanMeisho;
    }

    public void setKanriNo(TextBoxNum kanriNo) {
        this.setOriginalData("kanriNo", kanriNo);
        this.kanriNo = kanriNo;
    }

}