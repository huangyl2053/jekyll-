package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 11:19:53 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgNinteichosaIraiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteichosaIraiList_Row extends DataRow {

    private RString 保険者番号;
    private RString 保険者;
    private RString 支所コード;
    private RString 支所;
    private RString 被保険者番号;
    private RString 識別コード;
    private RString 氏名;
    private RString カナ氏名;
    private RString 氏名Withカナ;
    private TextBoxFlexibleDate 認定申請日;
    private RString 認定申請区分申請時;
    private RString 申請書管理番号;
    private TextBoxFlexibleDate 調査依頼日;
    private TextBoxFlexibleDate 調査依頼書発行日;
    private TextBoxFlexibleDate 調査依頼完了日;
    private TextBoxFlexibleDate 調査期限日;
    private RString 調査依頼区分;
    private RString 調査回数;
    private RString 認定調査履歴番号;
    private RString 調査委託先コード;
    private RString 調査委託先;
    private RString 調査員コード;
    private RString 調査員;
    private RString 前回調査委託先コード;
    private RString 前回調査委託先;
    private RString 前回調査員コード;
    private RString 前回調査員;
    private RString 審査会開催地区コード;
    private RString 審査会開催地区;
    private TextBoxFlexibleDate 督促年月日;
    private RString 督促方法;
    private RString 督促回数;
    private TextBoxFlexibleDate 督促期限日;
    private TextBoxFlexibleDate 督促発行日;
    private RString 住所;
    private RString 郵便番号;
    private RString 入所施設;
    private RString 性別;
    private TextBoxFlexibleDate 生年月日;
    private RString データ出力;
    private Boolean 依頼登録済;
    private Boolean 依頼書発行済;

    public dgNinteichosaIraiList_Row() {
        super();
    }

    public dgNinteichosaIraiList_Row(RString 保険者番号, RString 保険者, RString 支所コード, RString 支所, RString 被保険者番号, RString 識別コード, RString 氏名, RString カナ氏名, RString 氏名Withカナ, TextBoxFlexibleDate 認定申請日, RString 認定申請区分申請時, RString 申請書管理番号, TextBoxFlexibleDate 調査依頼日, TextBoxFlexibleDate 調査依頼書発行日, TextBoxFlexibleDate 調査依頼完了日, TextBoxFlexibleDate 調査期限日, RString 調査依頼区分, RString 調査回数, RString 認定調査履歴番号, RString 調査委託先コード, RString 調査委託先, RString 調査員コード, RString 調査員, RString 前回調査委託先コード, RString 前回調査委託先, RString 前回調査員コード, RString 前回調査員, RString 審査会開催地区コード, RString 審査会開催地区, TextBoxFlexibleDate 督促年月日, RString 督促方法, RString 督促回数, TextBoxFlexibleDate 督促期限日, TextBoxFlexibleDate 督促発行日, RString 住所, RString 郵便番号, RString 入所施設, RString 性別, TextBoxFlexibleDate 生年月日, RString データ出力, Boolean 依頼登録済, Boolean 依頼書発行済) {
        super();
        this.setOriginalData("保険者番号", 保険者番号);
        this.setOriginalData("保険者", 保険者);
        this.setOriginalData("支所コード", 支所コード);
        this.setOriginalData("支所", 支所);
        this.setOriginalData("被保険者番号", 被保険者番号);
        this.setOriginalData("識別コード", 識別コード);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("カナ氏名", カナ氏名);
        this.setOriginalData("氏名Withカナ", 氏名Withカナ);
        this.setOriginalData("認定申請日", 認定申請日);
        this.setOriginalData("認定申請区分申請時", 認定申請区分申請時);
        this.setOriginalData("申請書管理番号", 申請書管理番号);
        this.setOriginalData("調査依頼日", 調査依頼日);
        this.setOriginalData("調査依頼書発行日", 調査依頼書発行日);
        this.setOriginalData("調査依頼完了日", 調査依頼完了日);
        this.setOriginalData("調査期限日", 調査期限日);
        this.setOriginalData("調査依頼区分", 調査依頼区分);
        this.setOriginalData("調査回数", 調査回数);
        this.setOriginalData("認定調査履歴番号", 認定調査履歴番号);
        this.setOriginalData("調査委託先コード", 調査委託先コード);
        this.setOriginalData("調査委託先", 調査委託先);
        this.setOriginalData("調査員コード", 調査員コード);
        this.setOriginalData("調査員", 調査員);
        this.setOriginalData("前回調査委託先コード", 前回調査委託先コード);
        this.setOriginalData("前回調査委託先", 前回調査委託先);
        this.setOriginalData("前回調査員コード", 前回調査員コード);
        this.setOriginalData("前回調査員", 前回調査員);
        this.setOriginalData("審査会開催地区コード", 審査会開催地区コード);
        this.setOriginalData("審査会開催地区", 審査会開催地区);
        this.setOriginalData("督促年月日", 督促年月日);
        this.setOriginalData("督促方法", 督促方法);
        this.setOriginalData("督促回数", 督促回数);
        this.setOriginalData("督促期限日", 督促期限日);
        this.setOriginalData("督促発行日", 督促発行日);
        this.setOriginalData("住所", 住所);
        this.setOriginalData("郵便番号", 郵便番号);
        this.setOriginalData("入所施設", 入所施設);
        this.setOriginalData("性別", 性別);
        this.setOriginalData("生年月日", 生年月日);
        this.setOriginalData("データ出力", データ出力);
        this.setOriginalData("依頼登録済", 依頼登録済);
        this.setOriginalData("依頼書発行済", 依頼書発行済);
        this.保険者番号 = 保険者番号;
        this.保険者 = 保険者;
        this.支所コード = 支所コード;
        this.支所 = 支所;
        this.被保険者番号 = 被保険者番号;
        this.識別コード = 識別コード;
        this.氏名 = 氏名;
        this.カナ氏名 = カナ氏名;
        this.氏名Withカナ = 氏名Withカナ;
        this.認定申請日 = 認定申請日;
        this.認定申請区分申請時 = 認定申請区分申請時;
        this.申請書管理番号 = 申請書管理番号;
        this.調査依頼日 = 調査依頼日;
        this.調査依頼書発行日 = 調査依頼書発行日;
        this.調査依頼完了日 = 調査依頼完了日;
        this.調査期限日 = 調査期限日;
        this.調査依頼区分 = 調査依頼区分;
        this.調査回数 = 調査回数;
        this.認定調査履歴番号 = 認定調査履歴番号;
        this.調査委託先コード = 調査委託先コード;
        this.調査委託先 = 調査委託先;
        this.調査員コード = 調査員コード;
        this.調査員 = 調査員;
        this.前回調査委託先コード = 前回調査委託先コード;
        this.前回調査委託先 = 前回調査委託先;
        this.前回調査員コード = 前回調査員コード;
        this.前回調査員 = 前回調査員;
        this.審査会開催地区コード = 審査会開催地区コード;
        this.審査会開催地区 = 審査会開催地区;
        this.督促年月日 = 督促年月日;
        this.督促方法 = 督促方法;
        this.督促回数 = 督促回数;
        this.督促期限日 = 督促期限日;
        this.督促発行日 = 督促発行日;
        this.住所 = 住所;
        this.郵便番号 = 郵便番号;
        this.入所施設 = 入所施設;
        this.性別 = 性別;
        this.生年月日 = 生年月日;
        this.データ出力 = データ出力;
        this.依頼登録済 = 依頼登録済;
        this.依頼書発行済 = 依頼書発行済;
    }

    public RString get保険者番号() {
        return 保険者番号;
    }

    public RString get保険者() {
        return 保険者;
    }

    public RString get支所コード() {
        return 支所コード;
    }

    public RString get支所() {
        return 支所;
    }

    public RString get被保険者番号() {
        return 被保険者番号;
    }

    public RString get識別コード() {
        return 識別コード;
    }

    public RString get氏名() {
        return 氏名;
    }

    public RString getカナ氏名() {
        return カナ氏名;
    }

    public RString get氏名Withカナ() {
        return 氏名Withカナ;
    }

    public TextBoxFlexibleDate get認定申請日() {
        return 認定申請日;
    }

    public RString get認定申請区分申請時() {
        return 認定申請区分申請時;
    }

    public RString get申請書管理番号() {
        return 申請書管理番号;
    }

    public TextBoxFlexibleDate get調査依頼日() {
        return 調査依頼日;
    }

    public TextBoxFlexibleDate get調査依頼書発行日() {
        return 調査依頼書発行日;
    }

    public TextBoxFlexibleDate get調査依頼完了日() {
        return 調査依頼完了日;
    }

    public TextBoxFlexibleDate get調査期限日() {
        return 調査期限日;
    }

    public RString get調査依頼区分() {
        return 調査依頼区分;
    }

    public RString get調査回数() {
        return 調査回数;
    }

    public RString get認定調査履歴番号() {
        return 認定調査履歴番号;
    }

    public RString get調査委託先コード() {
        return 調査委託先コード;
    }

    public RString get調査委託先() {
        return 調査委託先;
    }

    public RString get調査員コード() {
        return 調査員コード;
    }

    public RString get調査員() {
        return 調査員;
    }

    public RString get前回調査委託先コード() {
        return 前回調査委託先コード;
    }

    public RString get前回調査委託先() {
        return 前回調査委託先;
    }

    public RString get前回調査員コード() {
        return 前回調査員コード;
    }

    public RString get前回調査員() {
        return 前回調査員;
    }

    public RString get審査会開催地区コード() {
        return 審査会開催地区コード;
    }

    public RString get審査会開催地区() {
        return 審査会開催地区;
    }

    public TextBoxFlexibleDate get督促年月日() {
        return 督促年月日;
    }

    public RString get督促方法() {
        return 督促方法;
    }

    public RString get督促回数() {
        return 督促回数;
    }

    public TextBoxFlexibleDate get督促期限日() {
        return 督促期限日;
    }

    public TextBoxFlexibleDate get督促発行日() {
        return 督促発行日;
    }

    public RString get住所() {
        return 住所;
    }

    public RString get郵便番号() {
        return 郵便番号;
    }

    public RString get入所施設() {
        return 入所施設;
    }

    public RString get性別() {
        return 性別;
    }

    public TextBoxFlexibleDate get生年月日() {
        return 生年月日;
    }

    public RString getデータ出力() {
        return データ出力;
    }

    public Boolean get依頼登録済() {
        return 依頼登録済;
    }

    public Boolean get依頼書発行済() {
        return 依頼書発行済;
    }

    public void set保険者番号(RString 保険者番号) {
        this.setOriginalData("保険者番号", 保険者番号);
        this.保険者番号 = 保険者番号;
    }

    public void set保険者(RString 保険者) {
        this.setOriginalData("保険者", 保険者);
        this.保険者 = 保険者;
    }

    public void set支所コード(RString 支所コード) {
        this.setOriginalData("支所コード", 支所コード);
        this.支所コード = 支所コード;
    }

    public void set支所(RString 支所) {
        this.setOriginalData("支所", 支所);
        this.支所 = 支所;
    }

    public void set被保険者番号(RString 被保険者番号) {
        this.setOriginalData("被保険者番号", 被保険者番号);
        this.被保険者番号 = 被保険者番号;
    }

    public void set識別コード(RString 識別コード) {
        this.setOriginalData("識別コード", 識別コード);
        this.識別コード = 識別コード;
    }

    public void set氏名(RString 氏名) {
        this.setOriginalData("氏名", 氏名);
        this.氏名 = 氏名;
    }

    public void setカナ氏名(RString カナ氏名) {
        this.setOriginalData("カナ氏名", カナ氏名);
        this.カナ氏名 = カナ氏名;
    }

    public void set氏名Withカナ(RString 氏名Withカナ) {
        this.setOriginalData("氏名Withカナ", 氏名Withカナ);
        this.氏名Withカナ = 氏名Withカナ;
    }

    public void set認定申請日(TextBoxFlexibleDate 認定申請日) {
        this.setOriginalData("認定申請日", 認定申請日);
        this.認定申請日 = 認定申請日;
    }

    public void set認定申請区分申請時(RString 認定申請区分申請時) {
        this.setOriginalData("認定申請区分申請時", 認定申請区分申請時);
        this.認定申請区分申請時 = 認定申請区分申請時;
    }

    public void set申請書管理番号(RString 申請書管理番号) {
        this.setOriginalData("申請書管理番号", 申請書管理番号);
        this.申請書管理番号 = 申請書管理番号;
    }

    public void set調査依頼日(TextBoxFlexibleDate 調査依頼日) {
        this.setOriginalData("調査依頼日", 調査依頼日);
        this.調査依頼日 = 調査依頼日;
    }

    public void set調査依頼書発行日(TextBoxFlexibleDate 調査依頼書発行日) {
        this.setOriginalData("調査依頼書発行日", 調査依頼書発行日);
        this.調査依頼書発行日 = 調査依頼書発行日;
    }

    public void set調査依頼完了日(TextBoxFlexibleDate 調査依頼完了日) {
        this.setOriginalData("調査依頼完了日", 調査依頼完了日);
        this.調査依頼完了日 = 調査依頼完了日;
    }

    public void set調査期限日(TextBoxFlexibleDate 調査期限日) {
        this.setOriginalData("調査期限日", 調査期限日);
        this.調査期限日 = 調査期限日;
    }

    public void set調査依頼区分(RString 調査依頼区分) {
        this.setOriginalData("調査依頼区分", 調査依頼区分);
        this.調査依頼区分 = 調査依頼区分;
    }

    public void set調査回数(RString 調査回数) {
        this.setOriginalData("調査回数", 調査回数);
        this.調査回数 = 調査回数;
    }

    public void set認定調査履歴番号(RString 認定調査履歴番号) {
        this.setOriginalData("認定調査履歴番号", 認定調査履歴番号);
        this.認定調査履歴番号 = 認定調査履歴番号;
    }

    public void set調査委託先コード(RString 調査委託先コード) {
        this.setOriginalData("調査委託先コード", 調査委託先コード);
        this.調査委託先コード = 調査委託先コード;
    }

    public void set調査委託先(RString 調査委託先) {
        this.setOriginalData("調査委託先", 調査委託先);
        this.調査委託先 = 調査委託先;
    }

    public void set調査員コード(RString 調査員コード) {
        this.setOriginalData("調査員コード", 調査員コード);
        this.調査員コード = 調査員コード;
    }

    public void set調査員(RString 調査員) {
        this.setOriginalData("調査員", 調査員);
        this.調査員 = 調査員;
    }

    public void set前回調査委託先コード(RString 前回調査委託先コード) {
        this.setOriginalData("前回調査委託先コード", 前回調査委託先コード);
        this.前回調査委託先コード = 前回調査委託先コード;
    }

    public void set前回調査委託先(RString 前回調査委託先) {
        this.setOriginalData("前回調査委託先", 前回調査委託先);
        this.前回調査委託先 = 前回調査委託先;
    }

    public void set前回調査員コード(RString 前回調査員コード) {
        this.setOriginalData("前回調査員コード", 前回調査員コード);
        this.前回調査員コード = 前回調査員コード;
    }

    public void set前回調査員(RString 前回調査員) {
        this.setOriginalData("前回調査員", 前回調査員);
        this.前回調査員 = 前回調査員;
    }

    public void set審査会開催地区コード(RString 審査会開催地区コード) {
        this.setOriginalData("審査会開催地区コード", 審査会開催地区コード);
        this.審査会開催地区コード = 審査会開催地区コード;
    }

    public void set審査会開催地区(RString 審査会開催地区) {
        this.setOriginalData("審査会開催地区", 審査会開催地区);
        this.審査会開催地区 = 審査会開催地区;
    }

    public void set督促年月日(TextBoxFlexibleDate 督促年月日) {
        this.setOriginalData("督促年月日", 督促年月日);
        this.督促年月日 = 督促年月日;
    }

    public void set督促方法(RString 督促方法) {
        this.setOriginalData("督促方法", 督促方法);
        this.督促方法 = 督促方法;
    }

    public void set督促回数(RString 督促回数) {
        this.setOriginalData("督促回数", 督促回数);
        this.督促回数 = 督促回数;
    }

    public void set督促期限日(TextBoxFlexibleDate 督促期限日) {
        this.setOriginalData("督促期限日", 督促期限日);
        this.督促期限日 = 督促期限日;
    }

    public void set督促発行日(TextBoxFlexibleDate 督促発行日) {
        this.setOriginalData("督促発行日", 督促発行日);
        this.督促発行日 = 督促発行日;
    }

    public void set住所(RString 住所) {
        this.setOriginalData("住所", 住所);
        this.住所 = 住所;
    }

    public void set郵便番号(RString 郵便番号) {
        this.setOriginalData("郵便番号", 郵便番号);
        this.郵便番号 = 郵便番号;
    }

    public void set入所施設(RString 入所施設) {
        this.setOriginalData("入所施設", 入所施設);
        this.入所施設 = 入所施設;
    }

    public void set性別(RString 性別) {
        this.setOriginalData("性別", 性別);
        this.性別 = 性別;
    }

    public void set生年月日(TextBoxFlexibleDate 生年月日) {
        this.setOriginalData("生年月日", 生年月日);
        this.生年月日 = 生年月日;
    }

    public void setデータ出力(RString データ出力) {
        this.setOriginalData("データ出力", データ出力);
        this.データ出力 = データ出力;
    }

    public void set依頼登録済(Boolean 依頼登録済) {
        this.setOriginalData("依頼登録済", 依頼登録済);
        this.依頼登録済 = 依頼登録済;
    }

    public void set依頼書発行済(Boolean 依頼書発行済) {
        this.setOriginalData("依頼書発行済", 依頼書発行済);
        this.依頼書発行済 = 依頼書発行済;
    }

}