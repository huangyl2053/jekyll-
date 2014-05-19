package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 12 11:14:01 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinIchiran_Row extends DataRow {

    private TextBoxNum Ｎｏ;
    private Boolean 有効無効;
    private RString 審査員コード;
    private RString 審査員氏名;
    private RString 性別;
    private RString 資格;
    private RString 所属機関;

    public dgShinsakaiIinIchiran_Row() {
        super();
    }

    public dgShinsakaiIinIchiran_Row(TextBoxNum Ｎｏ, Boolean 有効無効, RString 審査員コード, RString 審査員氏名, RString 性別, RString 資格, RString 所属機関) {
        super();
        this.setOriginalData("Ｎｏ", Ｎｏ);
        this.setOriginalData("有効無効", 有効無効);
        this.setOriginalData("審査員コード", 審査員コード);
        this.setOriginalData("審査員氏名", 審査員氏名);
        this.setOriginalData("性別", 性別);
        this.setOriginalData("資格", 資格);
        this.setOriginalData("所属機関", 所属機関);
        this.Ｎｏ = Ｎｏ;
        this.有効無効 = 有効無効;
        this.審査員コード = 審査員コード;
        this.審査員氏名 = 審査員氏名;
        this.性別 = 性別;
        this.資格 = 資格;
        this.所属機関 = 所属機関;
    }

    public TextBoxNum getＮｏ() {
        return Ｎｏ;
    }

    public Boolean get有効無効() {
        return 有効無効;
    }

    public RString get審査員コード() {
        return 審査員コード;
    }

    public RString get審査員氏名() {
        return 審査員氏名;
    }

    public RString get性別() {
        return 性別;
    }

    public RString get資格() {
        return 資格;
    }

    public RString get所属機関() {
        return 所属機関;
    }

    public void setＮｏ(TextBoxNum Ｎｏ) {
        this.setOriginalData("Ｎｏ", Ｎｏ);
        this.Ｎｏ = Ｎｏ;
    }

    public void set有効無効(Boolean 有効無効) {
        this.setOriginalData("有効無効", 有効無効);
        this.有効無効 = 有効無効;
    }

    public void set審査員コード(RString 審査員コード) {
        this.setOriginalData("審査員コード", 審査員コード);
        this.審査員コード = 審査員コード;
    }

    public void set審査員氏名(RString 審査員氏名) {
        this.setOriginalData("審査員氏名", 審査員氏名);
        this.審査員氏名 = 審査員氏名;
    }

    public void set性別(RString 性別) {
        this.setOriginalData("性別", 性別);
        this.性別 = 性別;
    }

    public void set資格(RString 資格) {
        this.setOriginalData("資格", 資格);
        this.資格 = 資格;
    }

    public void set所属機関(RString 所属機関) {
        this.setOriginalData("所属機関", 所属機関);
        this.所属機関 = 所属機関;
    }

}