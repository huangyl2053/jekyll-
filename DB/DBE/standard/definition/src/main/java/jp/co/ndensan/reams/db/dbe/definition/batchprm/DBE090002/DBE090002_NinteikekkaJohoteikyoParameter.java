/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定情報提供batch用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBE090002_NinteikekkaJohoteikyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = -1572924779386182816L;

    private static final String SHINSEISHOKANRINO = "shinseishoKanriNo";
    private static final String OUTPUTHOHO = "outputHoho";
    private static final String CHKNINTEICHOSAHYO = "chkNinteiChosahyo";
    private static final String CHKTOKKIJIKO = "chkTokkiJiko";
    private static final String CHKSHUJIIIKENSHO = "chkShujiiIkensho";
    private static final String CHKSONOTASHIRYO = "chkSonotaShiryo";
    private static final String CHKICHIJIHANTEIKEKKA = "chkIchijiHanteiKekka";
    private static final String RADNINTEICHOSAMASKING = "radNinteiChosaMasking";
    private static final String RADTOKKIJIKOMASKING = "radTokkiJikoMasking";
    private static final String RADSHUJII = "radShujii";
    private static final String RADSOHOTASHIRYOMASKING = "radSohotaShiryoMasking";
    private static final String RADICHIJIHANTEIMASKING = "radIchijiHanteiMasking";

    @BatchParameter(key = SHINSEISHOKANRINO, name = "申請書管理番号")
    private List<RString> 申請書管理番号;
    @BatchParameter(key = OUTPUTHOHO, name = "出力方法")
    private RString 出力方法;
    @BatchParameter(key = CHKNINTEICHOSAHYO, name = "認定調査票")
    private boolean 認定調査票出力;
    @BatchParameter(key = CHKTOKKIJIKO, name = "特記事項")
    private boolean 特記事項出力;
    @BatchParameter(key = CHKSHUJIIIKENSHO, name = "主治医意見書")
    private boolean 主治医意見書出力;
    @BatchParameter(key = CHKSONOTASHIRYO, name = "その他資料")
    private boolean その他資料出力;
    @BatchParameter(key = CHKICHIJIHANTEIKEKKA, name = "一次判定結果")
    private boolean 一次判定結果出力;
    @BatchParameter(key = RADNINTEICHOSAMASKING, name = "マスキング_認定調査票")
    private RString 認定調査票マスキング区分;
    @BatchParameter(key = RADTOKKIJIKOMASKING, name = "マスキング_特記事項")
    private RString 特記事項マスキング区分;
    @BatchParameter(key = RADSHUJII, name = "マスキング_主治医意見書")
    private RString 主治医意見書マスキング区分;
    @BatchParameter(key = RADSOHOTASHIRYOMASKING, name = "マスキング_その他資料")
    private RString その他資料マスキング区分;
    @BatchParameter(key = RADICHIJIHANTEIMASKING, name = "マスキング_一次判定結果")
    private RString 一次判定結果マスキング区分;

    /**
     * コンストラクタです。
     *
     */
    public DBE090002_NinteikekkaJohoteikyoParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号のリスト
     * @param 出力方法 出力方法
     * @param 認定調査票出力 認定調査票チェックフラグ
     * @param 特記事項出力 特記事項チェックフラグ
     * @param 主治医意見書出力 主治医意見書チェックフラグ
     * @param その他資料出力 その他資料チェックフラグ
     * @param 一次判定結果出力 一次判定結果チェックフラグ
     * @param 認定調査票マスキング区分 マスキング(認定調査票)フラグ
     * @param 特記事項マスキング区分 マスキング(特記事項)フラグ
     * @param 主治医意見書マスキング区分 マスキング(主治医意見書)フラグ
     * @param その他資料マスキング区分 マスキング(その他資料)フラグ
     * @param 一次判定結果マスキング区分 マスキング(一次判定結果)フラグ
     */
    public DBE090002_NinteikekkaJohoteikyoParameter(List<RString> 申請書管理番号, RString 出力方法,
            boolean 認定調査票出力, boolean 特記事項出力, boolean 主治医意見書出力, boolean その他資料出力,
            boolean 一次判定結果出力, RString 認定調査票マスキング区分, RString 特記事項マスキング区分,
            RString 主治医意見書マスキング区分, RString その他資料マスキング区分, RString 一次判定結果マスキング区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.出力方法 = 出力方法;
        this.認定調査票出力 = 認定調査票出力;
        this.特記事項出力 = 特記事項出力;
        this.主治医意見書出力 = 主治医意見書出力;
        this.その他資料出力 = その他資料出力;
        this.一次判定結果出力 = 一次判定結果出力;
        this.認定調査票マスキング区分 = 認定調査票マスキング区分;
        this.特記事項マスキング区分 = 特記事項マスキング区分;
        this.主治医意見書マスキング区分 = 主治医意見書マスキング区分;
        this.その他資料マスキング区分 = その他資料マスキング区分;
        this.一次判定結果マスキング区分 = 一次判定結果マスキング区分;
    }

    /**
     * 要介護認定情報提供作成プロセスパラメータークラス作成
     *
     * @param 特記事項判定日 特記事項判定日
     * @param 総合事業開始区分 総合事業開始区分
     * @param 情報提供資料の特記事項編集パターン 情報提供資料の特記事項編集パターン
     * @param 正常選択肢印刷有無 正常選択肢印刷有無
     * @param 認定調査前回結果印刷有無 認定調査前回結果印刷有無
     * @return 要介護認定情報提供作成プロセスパラメータークラス
     */
    public YokaigoBatchProcessParamter toYokaigoBatchProcessParamter(FlexibleDate 特記事項判定日,
            RString 総合事業開始区分, RString 情報提供資料の特記事項編集パターン,
            RString 正常選択肢印刷有無, RString 認定調査前回結果印刷有無) {
        return new YokaigoBatchProcessParamter(申請書管理番号, 認定調査票出力, 特記事項出力, 主治医意見書出力,
                その他資料出力, 一次判定結果出力, 認定調査票マスキング区分, 特記事項マスキング区分, 主治医意見書マスキング区分,
                その他資料マスキング区分, 一次判定結果マスキング区分, 特記事項判定日, 総合事業開始区分,
                情報提供資料の特記事項編集パターン, 正常選択肢印刷有無, 認定調査前回結果印刷有無);
    }
}
