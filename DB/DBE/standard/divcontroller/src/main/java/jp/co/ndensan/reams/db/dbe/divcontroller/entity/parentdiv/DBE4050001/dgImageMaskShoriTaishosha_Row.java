package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Feb 15 14:04:08 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgImageMaskShoriTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgImageMaskShoriTaishosha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">

    private RString 状態;
    private RString 保険者名称;
    private RString 保険者;
    private RString 被保番号;
    private RString 氏名;
    private TextBoxFlexibleDate 申請日;
    private RString 申請区分;
    private TextBoxFlexibleDate 審査予定日;
    private RString マスク区分;
    private RString 調査票;
    private RString 調査票特記;
    private RString 主治医意見;
    private TextBoxFlexibleDate 意見書受領日;
    private TextBoxFlexibleDate 調査票受領日;
    private RString 申請書管理番号;
    private RString 認定調査依頼履歴番号;
    private RString 主治医意見書作成依頼履歴番号;
    private RString 帳票ID;
    private RString 共有ファイルID;
    private RString マスキング完了済;

    public dgImageMaskShoriTaishosha_Row() {
        super();
        this.状態 = RString.EMPTY;
        this.保険者名称 = RString.EMPTY;
        this.保険者 = RString.EMPTY;
        this.被保番号 = RString.EMPTY;
        this.氏名 = RString.EMPTY;
        this.申請日 = new TextBoxFlexibleDate();
        this.申請区分 = RString.EMPTY;
        this.審査予定日 = new TextBoxFlexibleDate();
        this.マスク区分 = RString.EMPTY;
        this.調査票 = RString.EMPTY;
        this.調査票特記 = RString.EMPTY;
        this.主治医意見 = RString.EMPTY;
        this.意見書受領日 = new TextBoxFlexibleDate();
        this.調査票受領日 = new TextBoxFlexibleDate();
        this.申請書管理番号 = RString.EMPTY;
        this.認定調査依頼履歴番号 = RString.EMPTY;
        this.主治医意見書作成依頼履歴番号 = RString.EMPTY;
        this.帳票ID = RString.EMPTY;
        this.共有ファイルID = RString.EMPTY;
        this.マスキング完了済 = RString.EMPTY;
        this.setOriginalData("状態", 状態);
        this.setOriginalData("保険者名称", 保険者名称);
        this.setOriginalData("保険者", 保険者);
        this.setOriginalData("被保番号", 被保番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("申請日", 申請日);
        this.setOriginalData("申請区分", 申請区分);
        this.setOriginalData("審査予定日", 審査予定日);
        this.setOriginalData("マスク区分", マスク区分);
        this.setOriginalData("調査票", 調査票);
        this.setOriginalData("調査票特記", 調査票特記);
        this.setOriginalData("主治医意見", 主治医意見);
        this.setOriginalData("意見書受領日", 意見書受領日);
        this.setOriginalData("調査票受領日", 調査票受領日);
        this.setOriginalData("申請書管理番号", 申請書管理番号);
        this.setOriginalData("認定調査依頼履歴番号", 認定調査依頼履歴番号);
        this.setOriginalData("主治医意見書作成依頼履歴番号", 主治医意見書作成依頼履歴番号);
        this.setOriginalData("帳票ID", 帳票ID);
        this.setOriginalData("共有ファイルID", 共有ファイルID);
        this.setOriginalData("マスキング完了済", マスキング完了済);
    }

    public dgImageMaskShoriTaishosha_Row(RString 状態, RString 保険者名称, RString 保険者, RString 被保番号, RString 氏名, TextBoxFlexibleDate 申請日, RString 申請区分, TextBoxFlexibleDate 審査予定日, RString マスク区分, RString 調査票, RString 調査票特記, RString 主治医意見, TextBoxFlexibleDate 意見書受領日, TextBoxFlexibleDate 調査票受領日, RString 申請書管理番号, RString 認定調査依頼履歴番号, RString 主治医意見書作成依頼履歴番号, RString 帳票ID, RString 共有ファイルID, RString マスキング完了済) {
        super();
        this.setOriginalData("状態", 状態);
        this.setOriginalData("保険者名称", 保険者名称);
        this.setOriginalData("保険者", 保険者);
        this.setOriginalData("被保番号", 被保番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("申請日", 申請日);
        this.setOriginalData("申請区分", 申請区分);
        this.setOriginalData("審査予定日", 審査予定日);
        this.setOriginalData("マスク区分", マスク区分);
        this.setOriginalData("調査票", 調査票);
        this.setOriginalData("調査票特記", 調査票特記);
        this.setOriginalData("主治医意見", 主治医意見);
        this.setOriginalData("意見書受領日", 意見書受領日);
        this.setOriginalData("調査票受領日", 調査票受領日);
        this.setOriginalData("申請書管理番号", 申請書管理番号);
        this.setOriginalData("認定調査依頼履歴番号", 認定調査依頼履歴番号);
        this.setOriginalData("主治医意見書作成依頼履歴番号", 主治医意見書作成依頼履歴番号);
        this.setOriginalData("帳票ID", 帳票ID);
        this.setOriginalData("共有ファイルID", 共有ファイルID);
        this.setOriginalData("マスキング完了済", マスキング完了済);
        this.状態 = 状態;
        this.保険者名称 = 保険者名称;
        this.保険者 = 保険者;
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.申請日 = 申請日;
        this.申請区分 = 申請区分;
        this.審査予定日 = 審査予定日;
        this.マスク区分 = マスク区分;
        this.調査票 = 調査票;
        this.調査票特記 = 調査票特記;
        this.主治医意見 = 主治医意見;
        this.意見書受領日 = 意見書受領日;
        this.調査票受領日 = 調査票受領日;
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.主治医意見書作成依頼履歴番号 = 主治医意見書作成依頼履歴番号;
        this.帳票ID = 帳票ID;
        this.共有ファイルID = 共有ファイルID;
        this.マスキング完了済 = マスキング完了済;
    }

    public RString get状態() {
        return 状態;
    }

    public RString get保険者名称() {
        return 保険者名称;
    }

    public RString get保険者() {
        return 保険者;
    }

    public RString get被保番号() {
        return 被保番号;
    }

    public RString get氏名() {
        return 氏名;
    }

    public TextBoxFlexibleDate get申請日() {
        return 申請日;
    }

    public RString get申請区分() {
        return 申請区分;
    }

    public TextBoxFlexibleDate get審査予定日() {
        return 審査予定日;
    }

    public RString getマスク区分() {
        return マスク区分;
    }

    public RString get調査票() {
        return 調査票;
    }

    public RString get調査票特記() {
        return 調査票特記;
    }

    public RString get主治医意見() {
        return 主治医意見;
    }

    public TextBoxFlexibleDate get意見書受領日() {
        return 意見書受領日;
    }

    public TextBoxFlexibleDate get調査票受領日() {
        return 調査票受領日;
    }

    public RString get申請書管理番号() {
        return 申請書管理番号;
    }

    public RString get認定調査依頼履歴番号() {
        return 認定調査依頼履歴番号;
    }

    public RString get主治医意見書作成依頼履歴番号() {
        return 主治医意見書作成依頼履歴番号;
    }

    public RString get帳票ID() {
        return 帳票ID;
    }

    public RString get共有ファイルID() {
        return 共有ファイルID;
    }

    public RString getマスキング完了済() {
        return マスキング完了済;
    }

    public void set状態(RString 状態) {
        this.setOriginalData("状態", 状態);
        this.状態 = 状態;
    }

    public void set保険者名称(RString 保険者名称) {
        this.setOriginalData("保険者名称", 保険者名称);
        this.保険者名称 = 保険者名称;
    }

    public void set保険者(RString 保険者) {
        this.setOriginalData("保険者", 保険者);
        this.保険者 = 保険者;
    }

    public void set被保番号(RString 被保番号) {
        this.setOriginalData("被保番号", 被保番号);
        this.被保番号 = 被保番号;
    }

    public void set氏名(RString 氏名) {
        this.setOriginalData("氏名", 氏名);
        this.氏名 = 氏名;
    }

    public void set申請日(TextBoxFlexibleDate 申請日) {
        this.setOriginalData("申請日", 申請日);
        this.申請日 = 申請日;
    }

    public void set申請区分(RString 申請区分) {
        this.setOriginalData("申請区分", 申請区分);
        this.申請区分 = 申請区分;
    }

    public void set審査予定日(TextBoxFlexibleDate 審査予定日) {
        this.setOriginalData("審査予定日", 審査予定日);
        this.審査予定日 = 審査予定日;
    }

    public void setマスク区分(RString マスク区分) {
        this.setOriginalData("マスク区分", マスク区分);
        this.マスク区分 = マスク区分;
    }

    public void set調査票(RString 調査票) {
        this.setOriginalData("調査票", 調査票);
        this.調査票 = 調査票;
    }

    public void set調査票特記(RString 調査票特記) {
        this.setOriginalData("調査票特記", 調査票特記);
        this.調査票特記 = 調査票特記;
    }

    public void set主治医意見(RString 主治医意見) {
        this.setOriginalData("主治医意見", 主治医意見);
        this.主治医意見 = 主治医意見;
    }

    public void set意見書受領日(TextBoxFlexibleDate 意見書受領日) {
        this.setOriginalData("意見書受領日", 意見書受領日);
        this.意見書受領日 = 意見書受領日;
    }

    public void set調査票受領日(TextBoxFlexibleDate 調査票受領日) {
        this.setOriginalData("調査票受領日", 調査票受領日);
        this.調査票受領日 = 調査票受領日;
    }

    public void set申請書管理番号(RString 申請書管理番号) {
        this.setOriginalData("申請書管理番号", 申請書管理番号);
        this.申請書管理番号 = 申請書管理番号;
    }

    public void set認定調査依頼履歴番号(RString 認定調査依頼履歴番号) {
        this.setOriginalData("認定調査依頼履歴番号", 認定調査依頼履歴番号);
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
    }

    public void set主治医意見書作成依頼履歴番号(RString 主治医意見書作成依頼履歴番号) {
        this.setOriginalData("主治医意見書作成依頼履歴番号", 主治医意見書作成依頼履歴番号);
        this.主治医意見書作成依頼履歴番号 = 主治医意見書作成依頼履歴番号;
    }

    public void set帳票ID(RString 帳票ID) {
        this.setOriginalData("帳票ID", 帳票ID);
        this.帳票ID = 帳票ID;
    }

    public void set共有ファイルID(RString 共有ファイルID) {
        this.setOriginalData("共有ファイルID", 共有ファイルID);
        this.共有ファイルID = 共有ファイルID;
    }

    public void setマスキング完了済(RString マスキング完了済) {
        this.setOriginalData("マスキング完了済", マスキング完了済);
        this.マスキング完了済 = マスキング完了済;
    }

    // </editor-fold>
}
