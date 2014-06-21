package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri May 23 16:56:03 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinsaTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsaTaishoshaIchiran_Row extends DataRow {

    private Button 選択;
    private RString 順;
    private RString 保険者番号;
    private RString 市町村;
    private RString 被保番号;
    private RString 氏名;
    private RString カナ氏名;
    private RString 性別;
    private TextBoxFlexibleDate 申請日;
    private RString 前回要介護度;
    private RString 前回有効期間;
    private TextBoxFlexibleDate 前回有効期間開始日;
    private TextBoxFlexibleDate 前回有効期間終了日;
    private RString 一次判定結果;
    private RString 認定結果;
    private RString 有効期間月数;
    private TextBoxFlexibleDate 開始日;
    private TextBoxFlexibleDate 終了日;
    private RString 申請区分;
    private RString 生年月日;
    private RString 年齢;

    public dgShinsaTaishoshaIchiran_Row() {
        super();
    }

    public dgShinsaTaishoshaIchiran_Row(Button 選択, RString 順, RString 保険者番号, RString 市町村, RString 被保番号, RString 氏名, RString カナ氏名, RString 性別, TextBoxFlexibleDate 申請日, RString 前回要介護度, RString 前回有効期間, TextBoxFlexibleDate 前回有効期間開始日, TextBoxFlexibleDate 前回有効期間終了日, RString 一次判定結果, RString 認定結果, RString 有効期間月数, TextBoxFlexibleDate 開始日, TextBoxFlexibleDate 終了日, RString 申請区分, RString 生年月日, RString 年齢) {
        super();
        this.setOriginalData("選択", 選択);
        this.setOriginalData("順", 順);
        this.setOriginalData("保険者番号", 保険者番号);
        this.setOriginalData("市町村", 市町村);
        this.setOriginalData("被保番号", 被保番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("カナ氏名", カナ氏名);
        this.setOriginalData("性別", 性別);
        this.setOriginalData("申請日", 申請日);
        this.setOriginalData("前回要介護度", 前回要介護度);
        this.setOriginalData("前回有効期間", 前回有効期間);
        this.setOriginalData("前回有効期間開始日", 前回有効期間開始日);
        this.setOriginalData("前回有効期間終了日", 前回有効期間終了日);
        this.setOriginalData("一次判定結果", 一次判定結果);
        this.setOriginalData("認定結果", 認定結果);
        this.setOriginalData("有効期間月数", 有効期間月数);
        this.setOriginalData("開始日", 開始日);
        this.setOriginalData("終了日", 終了日);
        this.setOriginalData("申請区分", 申請区分);
        this.setOriginalData("生年月日", 生年月日);
        this.setOriginalData("年齢", 年齢);
        this.選択 = 選択;
        this.順 = 順;
        this.保険者番号 = 保険者番号;
        this.市町村 = 市町村;
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.カナ氏名 = カナ氏名;
        this.性別 = 性別;
        this.申請日 = 申請日;
        this.前回要介護度 = 前回要介護度;
        this.前回有効期間 = 前回有効期間;
        this.前回有効期間開始日 = 前回有効期間開始日;
        this.前回有効期間終了日 = 前回有効期間終了日;
        this.一次判定結果 = 一次判定結果;
        this.認定結果 = 認定結果;
        this.有効期間月数 = 有効期間月数;
        this.開始日 = 開始日;
        this.終了日 = 終了日;
        this.申請区分 = 申請区分;
        this.生年月日 = 生年月日;
        this.年齢 = 年齢;
    }

    public Button get選択() {
        return 選択;
    }

    public RString get順() {
        return 順;
    }

    public RString get保険者番号() {
        return 保険者番号;
    }

    public RString get市町村() {
        return 市町村;
    }

    public RString get被保番号() {
        return 被保番号;
    }

    public RString get氏名() {
        return 氏名;
    }

    public RString getカナ氏名() {
        return カナ氏名;
    }

    public RString get性別() {
        return 性別;
    }

    public TextBoxFlexibleDate get申請日() {
        return 申請日;
    }

    public RString get前回要介護度() {
        return 前回要介護度;
    }

    public RString get前回有効期間() {
        return 前回有効期間;
    }

    public TextBoxFlexibleDate get前回有効期間開始日() {
        return 前回有効期間開始日;
    }

    public TextBoxFlexibleDate get前回有効期間終了日() {
        return 前回有効期間終了日;
    }

    public RString get一次判定結果() {
        return 一次判定結果;
    }

    public RString get認定結果() {
        return 認定結果;
    }

    public RString get有効期間月数() {
        return 有効期間月数;
    }

    public TextBoxFlexibleDate get開始日() {
        return 開始日;
    }

    public TextBoxFlexibleDate get終了日() {
        return 終了日;
    }

    public RString get申請区分() {
        return 申請区分;
    }

    public RString get生年月日() {
        return 生年月日;
    }

    public RString get年齢() {
        return 年齢;
    }

    public void set選択(Button 選択) {
        this.setOriginalData("選択", 選択);
        this.選択 = 選択;
    }

    public void set順(RString 順) {
        this.setOriginalData("順", 順);
        this.順 = 順;
    }

    public void set保険者番号(RString 保険者番号) {
        this.setOriginalData("保険者番号", 保険者番号);
        this.保険者番号 = 保険者番号;
    }

    public void set市町村(RString 市町村) {
        this.setOriginalData("市町村", 市町村);
        this.市町村 = 市町村;
    }

    public void set被保番号(RString 被保番号) {
        this.setOriginalData("被保番号", 被保番号);
        this.被保番号 = 被保番号;
    }

    public void set氏名(RString 氏名) {
        this.setOriginalData("氏名", 氏名);
        this.氏名 = 氏名;
    }

    public void setカナ氏名(RString カナ氏名) {
        this.setOriginalData("カナ氏名", カナ氏名);
        this.カナ氏名 = カナ氏名;
    }

    public void set性別(RString 性別) {
        this.setOriginalData("性別", 性別);
        this.性別 = 性別;
    }

    public void set申請日(TextBoxFlexibleDate 申請日) {
        this.setOriginalData("申請日", 申請日);
        this.申請日 = 申請日;
    }

    public void set前回要介護度(RString 前回要介護度) {
        this.setOriginalData("前回要介護度", 前回要介護度);
        this.前回要介護度 = 前回要介護度;
    }

    public void set前回有効期間(RString 前回有効期間) {
        this.setOriginalData("前回有効期間", 前回有効期間);
        this.前回有効期間 = 前回有効期間;
    }

    public void set前回有効期間開始日(TextBoxFlexibleDate 前回有効期間開始日) {
        this.setOriginalData("前回有効期間開始日", 前回有効期間開始日);
        this.前回有効期間開始日 = 前回有効期間開始日;
    }

    public void set前回有効期間終了日(TextBoxFlexibleDate 前回有効期間終了日) {
        this.setOriginalData("前回有効期間終了日", 前回有効期間終了日);
        this.前回有効期間終了日 = 前回有効期間終了日;
    }

    public void set一次判定結果(RString 一次判定結果) {
        this.setOriginalData("一次判定結果", 一次判定結果);
        this.一次判定結果 = 一次判定結果;
    }

    public void set認定結果(RString 認定結果) {
        this.setOriginalData("認定結果", 認定結果);
        this.認定結果 = 認定結果;
    }

    public void set有効期間月数(RString 有効期間月数) {
        this.setOriginalData("有効期間月数", 有効期間月数);
        this.有効期間月数 = 有効期間月数;
    }

    public void set開始日(TextBoxFlexibleDate 開始日) {
        this.setOriginalData("開始日", 開始日);
        this.開始日 = 開始日;
    }

    public void set終了日(TextBoxFlexibleDate 終了日) {
        this.setOriginalData("終了日", 終了日);
        this.終了日 = 終了日;
    }

    public void set申請区分(RString 申請区分) {
        this.setOriginalData("申請区分", 申請区分);
        this.申請区分 = 申請区分;
    }

    public void set生年月日(RString 生年月日) {
        this.setOriginalData("生年月日", 生年月日);
        this.生年月日 = 生年月日;
    }

    public void set年齢(RString 年齢) {
        this.setOriginalData("年齢", 年齢);
        this.年齢 = 年齢;
    }

}