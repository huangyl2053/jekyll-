package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed May 07 11:21:15 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;


/**
 * dgShinsakaiShinsainIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiShinsainIchiran_Row extends DataRow {

    private TextBoxNum Ｎｏ;
    private RString 審査員番号;
    private RString 氏名;
    private RString 性別;
    private RString 資格;
    private RString 審査員区分;
    private DropDownList 議長区分;
    private DropDownList 出欠区分;

    public dgShinsakaiShinsainIchiran_Row() {
        super();
    }

    public dgShinsakaiShinsainIchiran_Row(TextBoxNum Ｎｏ, RString 審査員番号, RString 氏名, RString 性別, RString 資格, RString 審査員区分, DropDownList 議長区分, DropDownList 出欠区分) {
        super();
        this.setOriginalData("Ｎｏ", Ｎｏ);
        this.setOriginalData("審査員番号", 審査員番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("性別", 性別);
        this.setOriginalData("資格", 資格);
        this.setOriginalData("審査員区分", 審査員区分);
        this.setOriginalData("議長区分", 議長区分);
        this.setOriginalData("出欠区分", 出欠区分);
        this.Ｎｏ = Ｎｏ;
        this.審査員番号 = 審査員番号;
        this.氏名 = 氏名;
        this.性別 = 性別;
        this.資格 = 資格;
        this.審査員区分 = 審査員区分;
        this.議長区分 = 議長区分;
        this.出欠区分 = 出欠区分;
    }

    public TextBoxNum getＮｏ() {
        return Ｎｏ;
    }

    public RString get審査員番号() {
        return 審査員番号;
    }

    public RString get氏名() {
        return 氏名;
    }

    public RString get性別() {
        return 性別;
    }

    public RString get資格() {
        return 資格;
    }

    public RString get審査員区分() {
        return 審査員区分;
    }

    public DropDownList get議長区分() {
        return 議長区分;
    }

    public DropDownList get出欠区分() {
        return 出欠区分;
    }

    public void setＮｏ(TextBoxNum Ｎｏ) {
        this.setOriginalData("Ｎｏ", Ｎｏ);
        this.Ｎｏ = Ｎｏ;
    }

    public void set審査員番号(RString 審査員番号) {
        this.setOriginalData("審査員番号", 審査員番号);
        this.審査員番号 = 審査員番号;
    }

    public void set氏名(RString 氏名) {
        this.setOriginalData("氏名", 氏名);
        this.氏名 = 氏名;
    }

    public void set性別(RString 性別) {
        this.setOriginalData("性別", 性別);
        this.性別 = 性別;
    }

    public void set資格(RString 資格) {
        this.setOriginalData("資格", 資格);
        this.資格 = 資格;
    }

    public void set審査員区分(RString 審査員区分) {
        this.setOriginalData("審査員区分", 審査員区分);
        this.審査員区分 = 審査員区分;
    }

    public void set議長区分(DropDownList 議長区分) {
        this.setOriginalData("議長区分", 議長区分);
        this.議長区分 = 議長区分;
    }

    public void set出欠区分(DropDownList 出欠区分) {
        this.setOriginalData("出欠区分", 出欠区分);
        this.出欠区分 = 出欠区分;
    }

}