package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 26 17:42:41 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;


/**
 * dgNinteiTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiTaishosha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString 被保険者番号;
    private RString 氏名;
    private RString 判定;
    private RString 申請申;
    private RString 申請法;
    private TextBoxFlexibleDate 申請日;
    private RString 取込日時;
    private TextBoxFlexibleDate 一次判定日;
    private RString 一次判定;
    private TextBoxFlexibleDate 二次判定日;
    private RString 二次判定;
    private TextBoxFlexibleDate 適用開始日;
    private TextBoxFlexibleDate 適用終了日;
    private Button 消し込み;
    private RString 更新key;

    public dgNinteiTaishosha_Row() {
        super();
        this.被保険者番号 = RString.EMPTY;
        this.氏名 = RString.EMPTY;
        this.判定 = RString.EMPTY;
        this.申請申 = RString.EMPTY;
        this.申請法 = RString.EMPTY;
        this.申請日 = new TextBoxFlexibleDate();
        this.取込日時 = RString.EMPTY;
        this.一次判定日 = new TextBoxFlexibleDate();
        this.一次判定 = RString.EMPTY;
        this.二次判定日 = new TextBoxFlexibleDate();
        this.二次判定 = RString.EMPTY;
        this.適用開始日 = new TextBoxFlexibleDate();
        this.適用終了日 = new TextBoxFlexibleDate();
        this.消し込み = new Button();
        this.更新key = RString.EMPTY;
        this.setOriginalData("被保険者番号", 被保険者番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("判定", 判定);
        this.setOriginalData("申請申", 申請申);
        this.setOriginalData("申請法", 申請法);
        this.setOriginalData("申請日", 申請日);
        this.setOriginalData("取込日時", 取込日時);
        this.setOriginalData("一次判定日", 一次判定日);
        this.setOriginalData("一次判定", 一次判定);
        this.setOriginalData("二次判定日", 二次判定日);
        this.setOriginalData("二次判定", 二次判定);
        this.setOriginalData("適用開始日", 適用開始日);
        this.setOriginalData("適用終了日", 適用終了日);
        this.setOriginalData("消し込み", 消し込み);
        this.setOriginalData("更新key", 更新key);
    }

    public dgNinteiTaishosha_Row(RString 被保険者番号, RString 氏名, RString 判定, RString 申請申, RString 申請法, TextBoxFlexibleDate 申請日, RString 取込日時, TextBoxFlexibleDate 一次判定日, RString 一次判定, TextBoxFlexibleDate 二次判定日, RString 二次判定, TextBoxFlexibleDate 適用開始日, TextBoxFlexibleDate 適用終了日, Button 消し込み, RString 更新key) {
        super();
        this.setOriginalData("被保険者番号", 被保険者番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("判定", 判定);
        this.setOriginalData("申請申", 申請申);
        this.setOriginalData("申請法", 申請法);
        this.setOriginalData("申請日", 申請日);
        this.setOriginalData("取込日時", 取込日時);
        this.setOriginalData("一次判定日", 一次判定日);
        this.setOriginalData("一次判定", 一次判定);
        this.setOriginalData("二次判定日", 二次判定日);
        this.setOriginalData("二次判定", 二次判定);
        this.setOriginalData("適用開始日", 適用開始日);
        this.setOriginalData("適用終了日", 適用終了日);
        this.setOriginalData("消し込み", 消し込み);
        this.setOriginalData("更新key", 更新key);
        this.被保険者番号 = 被保険者番号;
        this.氏名 = 氏名;
        this.判定 = 判定;
        this.申請申 = 申請申;
        this.申請法 = 申請法;
        this.申請日 = 申請日;
        this.取込日時 = 取込日時;
        this.一次判定日 = 一次判定日;
        this.一次判定 = 一次判定;
        this.二次判定日 = 二次判定日;
        this.二次判定 = 二次判定;
        this.適用開始日 = 適用開始日;
        this.適用終了日 = 適用終了日;
        this.消し込み = 消し込み;
        this.更新key = 更新key;
    }

    public RString get被保険者番号() {
        return 被保険者番号;
    }

    public RString get氏名() {
        return 氏名;
    }

    public RString get判定() {
        return 判定;
    }

    public RString get申請申() {
        return 申請申;
    }

    public RString get申請法() {
        return 申請法;
    }

    public TextBoxFlexibleDate get申請日() {
        return 申請日;
    }

    public RString get取込日時() {
        return 取込日時;
    }

    public TextBoxFlexibleDate get一次判定日() {
        return 一次判定日;
    }

    public RString get一次判定() {
        return 一次判定;
    }

    public TextBoxFlexibleDate get二次判定日() {
        return 二次判定日;
    }

    public RString get二次判定() {
        return 二次判定;
    }

    public TextBoxFlexibleDate get適用開始日() {
        return 適用開始日;
    }

    public TextBoxFlexibleDate get適用終了日() {
        return 適用終了日;
    }

    public Button get消し込み() {
        return 消し込み;
    }

    public RString get更新key() {
        return 更新key;
    }

    public void set被保険者番号(RString 被保険者番号) {
        this.setOriginalData("被保険者番号", 被保険者番号);
        this.被保険者番号 = 被保険者番号;
    }

    public void set氏名(RString 氏名) {
        this.setOriginalData("氏名", 氏名);
        this.氏名 = 氏名;
    }

    public void set判定(RString 判定) {
        this.setOriginalData("判定", 判定);
        this.判定 = 判定;
    }

    public void set申請申(RString 申請申) {
        this.setOriginalData("申請申", 申請申);
        this.申請申 = 申請申;
    }

    public void set申請法(RString 申請法) {
        this.setOriginalData("申請法", 申請法);
        this.申請法 = 申請法;
    }

    public void set申請日(TextBoxFlexibleDate 申請日) {
        this.setOriginalData("申請日", 申請日);
        this.申請日 = 申請日;
    }

    public void set取込日時(RString 取込日時) {
        this.setOriginalData("取込日時", 取込日時);
        this.取込日時 = 取込日時;
    }

    public void set一次判定日(TextBoxFlexibleDate 一次判定日) {
        this.setOriginalData("一次判定日", 一次判定日);
        this.一次判定日 = 一次判定日;
    }

    public void set一次判定(RString 一次判定) {
        this.setOriginalData("一次判定", 一次判定);
        this.一次判定 = 一次判定;
    }

    public void set二次判定日(TextBoxFlexibleDate 二次判定日) {
        this.setOriginalData("二次判定日", 二次判定日);
        this.二次判定日 = 二次判定日;
    }

    public void set二次判定(RString 二次判定) {
        this.setOriginalData("二次判定", 二次判定);
        this.二次判定 = 二次判定;
    }

    public void set適用開始日(TextBoxFlexibleDate 適用開始日) {
        this.setOriginalData("適用開始日", 適用開始日);
        this.適用開始日 = 適用開始日;
    }

    public void set適用終了日(TextBoxFlexibleDate 適用終了日) {
        this.setOriginalData("適用終了日", 適用終了日);
        this.適用終了日 = 適用終了日;
    }

    public void set消し込み(Button 消し込み) {
        this.setOriginalData("消し込み", 消し込み);
        this.消し込み = 消し込み;
    }

    public void set更新key(RString 更新key) {
        this.setOriginalData("更新key", 更新key);
        this.更新key = 更新key;
    }

    // </editor-fold>
}
