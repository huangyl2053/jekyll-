package jp.co.ndensan.reams.db.dbe.divcontroller.entity.shozokuChosainList;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 18 15:23:18 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShozokuChosainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShozokuChosainList_Row extends DataRow {

    private Button btnToBindChosain;
    private RString chosainNo;
    private RString chosainName;
    private RString waritsukeNum;
    private RString chiku;
    private RString chousaItakusakiNo;

    public dgShozokuChosainList_Row() {
        super();
        this.btnToBindChosain = new Button();
        this.chosainNo = RString.EMPTY;
        this.chosainName = RString.EMPTY;
        this.waritsukeNum = RString.EMPTY;
        this.chiku = RString.EMPTY;
        this.chousaItakusakiNo = RString.EMPTY;
    }

    public dgShozokuChosainList_Row(Button btnToBindChosain, RString chosainNo, RString chosainName, RString waritsukeNum, RString chiku, RString chousaItakusakiNo) {
        super();
        this.setOriginalData("btnToBindChosain", btnToBindChosain);
        this.setOriginalData("chosainNo", chosainNo);
        this.setOriginalData("chosainName", chosainName);
        this.setOriginalData("waritsukeNum", waritsukeNum);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("chousaItakusakiNo", chousaItakusakiNo);
        this.btnToBindChosain = btnToBindChosain;
        this.chosainNo = chosainNo;
        this.chosainName = chosainName;
        this.waritsukeNum = waritsukeNum;
        this.chiku = chiku;
        this.chousaItakusakiNo = chousaItakusakiNo;
    }

    public Button getBtnToBindChosain() {
        return btnToBindChosain;
    }

    public RString getChosainNo() {
        return chosainNo;
    }

    public RString getChosainName() {
        return chosainName;
    }

    public RString getWaritsukeNum() {
        return waritsukeNum;
    }

    public RString getChiku() {
        return chiku;
    }

    public RString getChousaItakusakiNo() {
        return chousaItakusakiNo;
    }

    public void setBtnToBindChosain(Button btnToBindChosain) {
        this.setOriginalData("btnToBindChosain", btnToBindChosain);
        this.btnToBindChosain = btnToBindChosain;
    }

    public void setChosainNo(RString chosainNo) {
        this.setOriginalData("chosainNo", chosainNo);
        this.chosainNo = chosainNo;
    }

    public void setChosainName(RString chosainName) {
        this.setOriginalData("chosainName", chosainName);
        this.chosainName = chosainName;
    }

    public void setWaritsukeNum(RString waritsukeNum) {
        this.setOriginalData("waritsukeNum", waritsukeNum);
        this.waritsukeNum = waritsukeNum;
    }

    public void setChiku(RString chiku) {
        this.setOriginalData("chiku", chiku);
        this.chiku = chiku;
    }

    public void setChousaItakusakiNo(RString chousaItakusakiNo) {
        this.setOriginalData("chousaItakusakiNo", chousaItakusakiNo);
        this.chousaItakusakiNo = chousaItakusakiNo;
    }

}