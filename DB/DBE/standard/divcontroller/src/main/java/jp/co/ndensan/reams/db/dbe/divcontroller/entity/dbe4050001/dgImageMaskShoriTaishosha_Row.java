package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 24 18:29:06 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgImageMaskShoriTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgImageMaskShoriTaishosha_Row extends DataRow {

    private Button 処理;
    private RString 保険者;
    private RString 被保番号;
    private RString 氏名;
    private TextBoxFlexibleDate 申請日;
    private RString 申請区分;
    private TextBoxFlexibleDate 審査予定日;
    private RString マスク区分;
    private TextBoxFlexibleDate 意見書受領日;
    private TextBoxFlexibleDate 調査票受領日;
    private RString 保険者番号;
    private RString 被保険者区分;
    private TextBoxFlexibleDate 生年月日;
    private RString 年齢;
    private RString 前回認定結果;
    private TextBoxFlexibleDate 前回認定期間開始日;
    private TextBoxFlexibleDate 前回認定期間終了日;

    public dgImageMaskShoriTaishosha_Row() {
        super();
        this.処理 = new Button();
        this.保険者 = RString.EMPTY;
        this.被保番号 = RString.EMPTY;
        this.氏名 = RString.EMPTY;
        this.申請日 = new TextBoxFlexibleDate();
        this.申請区分 = RString.EMPTY;
        this.審査予定日 = new TextBoxFlexibleDate();
        this.マスク区分 = RString.EMPTY;
        this.意見書受領日 = new TextBoxFlexibleDate();
        this.調査票受領日 = new TextBoxFlexibleDate();
        this.保険者番号 = RString.EMPTY;
        this.被保険者区分 = RString.EMPTY;
        this.生年月日 = new TextBoxFlexibleDate();
        this.年齢 = RString.EMPTY;
        this.前回認定結果 = RString.EMPTY;
        this.前回認定期間開始日 = new TextBoxFlexibleDate();
        this.前回認定期間終了日 = new TextBoxFlexibleDate();
    }

    public dgImageMaskShoriTaishosha_Row(Button 処理, RString 保険者, RString 被保番号, RString 氏名, TextBoxFlexibleDate 申請日, RString 申請区分, TextBoxFlexibleDate 審査予定日, RString マスク区分, TextBoxFlexibleDate 意見書受領日, TextBoxFlexibleDate 調査票受領日, RString 保険者番号, RString 被保険者区分, TextBoxFlexibleDate 生年月日, RString 年齢, RString 前回認定結果, TextBoxFlexibleDate 前回認定期間開始日, TextBoxFlexibleDate 前回認定期間終了日) {
        super();
        this.setOriginalData("処理", 処理);
        this.setOriginalData("保険者", 保険者);
        this.setOriginalData("被保番号", 被保番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("申請日", 申請日);
        this.setOriginalData("申請区分", 申請区分);
        this.setOriginalData("審査予定日", 審査予定日);
        this.setOriginalData("マスク区分", マスク区分);
        this.setOriginalData("意見書受領日", 意見書受領日);
        this.setOriginalData("調査票受領日", 調査票受領日);
        this.setOriginalData("保険者番号", 保険者番号);
        this.setOriginalData("被保険者区分", 被保険者区分);
        this.setOriginalData("生年月日", 生年月日);
        this.setOriginalData("年齢", 年齢);
        this.setOriginalData("前回認定結果", 前回認定結果);
        this.setOriginalData("前回認定期間開始日", 前回認定期間開始日);
        this.setOriginalData("前回認定期間終了日", 前回認定期間終了日);
        this.処理 = 処理;
        this.保険者 = 保険者;
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.申請日 = 申請日;
        this.申請区分 = 申請区分;
        this.審査予定日 = 審査予定日;
        this.マスク区分 = マスク区分;
        this.意見書受領日 = 意見書受領日;
        this.調査票受領日 = 調査票受領日;
        this.保険者番号 = 保険者番号;
        this.被保険者区分 = 被保険者区分;
        this.生年月日 = 生年月日;
        this.年齢 = 年齢;
        this.前回認定結果 = 前回認定結果;
        this.前回認定期間開始日 = 前回認定期間開始日;
        this.前回認定期間終了日 = 前回認定期間終了日;
    }

    public Button get処理() {
        return 処理;
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

    public TextBoxFlexibleDate get意見書受領日() {
        return 意見書受領日;
    }

    public TextBoxFlexibleDate get調査票受領日() {
        return 調査票受領日;
    }

    public RString get保険者番号() {
        return 保険者番号;
    }

    public RString get被保険者区分() {
        return 被保険者区分;
    }

    public TextBoxFlexibleDate get生年月日() {
        return 生年月日;
    }

    public RString get年齢() {
        return 年齢;
    }

    public RString get前回認定結果() {
        return 前回認定結果;
    }

    public TextBoxFlexibleDate get前回認定期間開始日() {
        return 前回認定期間開始日;
    }

    public TextBoxFlexibleDate get前回認定期間終了日() {
        return 前回認定期間終了日;
    }

    public void set処理(Button 処理) {
        this.setOriginalData("処理", 処理);
        this.処理 = 処理;
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

    public void set意見書受領日(TextBoxFlexibleDate 意見書受領日) {
        this.setOriginalData("意見書受領日", 意見書受領日);
        this.意見書受領日 = 意見書受領日;
    }

    public void set調査票受領日(TextBoxFlexibleDate 調査票受領日) {
        this.setOriginalData("調査票受領日", 調査票受領日);
        this.調査票受領日 = 調査票受領日;
    }

    public void set保険者番号(RString 保険者番号) {
        this.setOriginalData("保険者番号", 保険者番号);
        this.保険者番号 = 保険者番号;
    }

    public void set被保険者区分(RString 被保険者区分) {
        this.setOriginalData("被保険者区分", 被保険者区分);
        this.被保険者区分 = 被保険者区分;
    }

    public void set生年月日(TextBoxFlexibleDate 生年月日) {
        this.setOriginalData("生年月日", 生年月日);
        this.生年月日 = 生年月日;
    }

    public void set年齢(RString 年齢) {
        this.setOriginalData("年齢", 年齢);
        this.年齢 = 年齢;
    }

    public void set前回認定結果(RString 前回認定結果) {
        this.setOriginalData("前回認定結果", 前回認定結果);
        this.前回認定結果 = 前回認定結果;
    }

    public void set前回認定期間開始日(TextBoxFlexibleDate 前回認定期間開始日) {
        this.setOriginalData("前回認定期間開始日", 前回認定期間開始日);
        this.前回認定期間開始日 = 前回認定期間開始日;
    }

    public void set前回認定期間終了日(TextBoxFlexibleDate 前回認定期間終了日) {
        this.setOriginalData("前回認定期間終了日", 前回認定期間終了日);
        this.前回認定期間終了日 = 前回認定期間終了日;
    }

}