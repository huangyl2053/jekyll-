package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 09 13:22:52 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKaniKaisaiKekka_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKaniKaisaiKekka_Row extends DataRow {

    private Boolean 委員長;
    private Boolean 出欠;
    private RString 氏名;
    private RString 資格;

    public dgKaniKaisaiKekka_Row() {
        super();
    }

    public dgKaniKaisaiKekka_Row(Boolean 委員長, Boolean 出欠, RString 氏名, RString 資格) {
        super();
        this.setOriginalData("委員長", 委員長);
        this.setOriginalData("出欠", 出欠);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("資格", 資格);
        this.委員長 = 委員長;
        this.出欠 = 出欠;
        this.氏名 = 氏名;
        this.資格 = 資格;
    }

    public Boolean get委員長() {
        return 委員長;
    }

    public Boolean get出欠() {
        return 出欠;
    }

    public RString get氏名() {
        return 氏名;
    }

    public RString get資格() {
        return 資格;
    }

    public void set委員長(Boolean 委員長) {
        this.setOriginalData("委員長", 委員長);
        this.委員長 = 委員長;
    }

    public void set出欠(Boolean 出欠) {
        this.setOriginalData("出欠", 出欠);
        this.出欠 = 出欠;
    }

    public void set氏名(RString 氏名) {
        this.setOriginalData("氏名", 氏名);
        this.氏名 = 氏名;
    }

    public void set資格(RString 資格) {
        this.setOriginalData("資格", 資格);
        this.資格 = 資格;
    }

}