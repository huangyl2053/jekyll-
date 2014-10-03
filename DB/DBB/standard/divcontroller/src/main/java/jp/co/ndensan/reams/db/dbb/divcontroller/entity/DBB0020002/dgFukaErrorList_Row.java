package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Oct 03 00:27:24 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgFukaErrorList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFukaErrorList_Row extends DataRow {

    private RString shoriJokyoCode;
    private RString shoriJokyo;
    private TextBoxDate fukaNendo;
    private RString tsuchishoNo;
    private RString errorCode;
    private RString errorDetail;
    private RString hihokenshaNo;
    private RString shikibetsuCode;

    public dgFukaErrorList_Row() {
        super();
        this.shoriJokyoCode = RString.EMPTY;
        this.shoriJokyo = RString.EMPTY;
        this.fukaNendo = new TextBoxDate();
        this.tsuchishoNo = RString.EMPTY;
        this.errorCode = RString.EMPTY;
        this.errorDetail = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
    }

    public dgFukaErrorList_Row(RString shoriJokyoCode, RString shoriJokyo, TextBoxDate fukaNendo, RString tsuchishoNo, RString errorCode, RString errorDetail, RString hihokenshaNo, RString shikibetsuCode) {
        super();
        this.setOriginalData("shoriJokyoCode", shoriJokyoCode);
        this.setOriginalData("shoriJokyo", shoriJokyo);
        this.setOriginalData("fukaNendo", fukaNendo);
        this.setOriginalData("tsuchishoNo", tsuchishoNo);
        this.setOriginalData("errorCode", errorCode);
        this.setOriginalData("errorDetail", errorDetail);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shoriJokyoCode = shoriJokyoCode;
        this.shoriJokyo = shoriJokyo;
        this.fukaNendo = fukaNendo;
        this.tsuchishoNo = tsuchishoNo;
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
    }

    public RString getShoriJokyoCode() {
        return shoriJokyoCode;
    }

    public RString getShoriJokyo() {
        return shoriJokyo;
    }

    public TextBoxDate getFukaNendo() {
        return fukaNendo;
    }

    public RString getTsuchishoNo() {
        return tsuchishoNo;
    }

    public RString getErrorCode() {
        return errorCode;
    }

    public RString getErrorDetail() {
        return errorDetail;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public void setShoriJokyoCode(RString shoriJokyoCode) {
        this.setOriginalData("shoriJokyoCode", shoriJokyoCode);
        this.shoriJokyoCode = shoriJokyoCode;
    }

    public void setShoriJokyo(RString shoriJokyo) {
        this.setOriginalData("shoriJokyo", shoriJokyo);
        this.shoriJokyo = shoriJokyo;
    }

    public void setFukaNendo(TextBoxDate fukaNendo) {
        this.setOriginalData("fukaNendo", fukaNendo);
        this.fukaNendo = fukaNendo;
    }

    public void setTsuchishoNo(RString tsuchishoNo) {
        this.setOriginalData("tsuchishoNo", tsuchishoNo);
        this.tsuchishoNo = tsuchishoNo;
    }

    public void setErrorCode(RString errorCode) {
        this.setOriginalData("errorCode", errorCode);
        this.errorCode = errorCode;
    }

    public void setErrorDetail(RString errorDetail) {
        this.setOriginalData("errorDetail", errorDetail);
        this.errorDetail = errorDetail;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

}