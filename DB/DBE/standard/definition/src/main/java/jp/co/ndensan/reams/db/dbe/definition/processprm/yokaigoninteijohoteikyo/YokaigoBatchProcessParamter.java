/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoBatchMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定申請者を特定するためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class YokaigoBatchProcessParamter implements IBatchProcessParameter {

    private final List<RString> 申請書管理番号;
    private final boolean 認定調査票出力;
    private final boolean 特記事項出力;
    private final boolean 主治医意見書出力;
    private final boolean その他資料出力;
    private final boolean 一次判定結果出力;
    private final RString 認定調査票マスキング区分;
    private final RString 特記事項マスキング区分;
    private final RString 主治医意見書マスキング区分;
    private final RString その他資料マスキング区分;
    private final RString 一次判定結果マスキング区分;
    private final FlexibleDate 特記事項判定日;
    private final RString 総合事業開始区分;
    private final RString 情報提供資料の特記事項編集パターン;
    private final RString 特記事項符号印刷有無;
    private final RString 正常選択肢印刷有無;
    private final RString 前回との結果比較印刷有無;
    private final RString 前回正常選択肢印刷有無;

//    /**
//     * コンストラクタです。
//     *
//     * @param 申請書管理番号 申請書管理番号のリスト
//     * @param 認定調査票出力 認定調査票チェックフラグ
//     * @param 特記事項出力 特記事項チェックフラグ
//     * @param 主治医意見書出力 主治医意見書チェックフラグ
//     * @param その他資料出力 その他資料チェックフラグ
//     * @param 一次判定結果出力 一次判定結果チェックフラグ
//     * @param 認定調査票マスキング区分 マスキング(認定調査票)フラグ
//     * @param 特記事項マスキング区分 マスキング(特記事項)フラグ
//     * @param 主治医意見書マスキング区分 マスキング(主治医意見書)フラグ
//     * @param その他資料マスキング区分 マスキング(その他資料)フラグ
//     * @param 一次判定結果マスキング区分 マスキング(一次判定結果)フラグ
//     * @param 特記事項判定日 特記事項判定日
//     * @param 総合事業開始区分 総合事業開始区分
//     * @param 情報提供資料の特記事項編集パターン 情報提供資料の特記事項編集パターン
//     * @param 正常選択肢印刷有無 正常選択肢印刷有無
//     * @param 認定調査前回結果印刷有無 認定調査前回結果印刷有無
//     */
//    public YokaigoBatchProcessParamter(List<RString> 申請書管理番号, boolean 認定調査票出力,
//            boolean 特記事項出力, boolean 主治医意見書出力, boolean その他資料出力, boolean 一次判定結果出力,
//            RString 認定調査票マスキング区分, RString 特記事項マスキング区分, RString 主治医意見書マスキング区分,
//            RString その他資料マスキング区分, RString 一次判定結果マスキング区分, FlexibleDate 特記事項判定日,
//            RString 総合事業開始区分, RString 情報提供資料の特記事項編集パターン, RString 正常選択肢印刷有無, RString 認定調査前回結果印刷有無) {
//        this.申請書管理番号 = 申請書管理番号;
//        this.認定調査票出力 = 認定調査票出力;
//        this.特記事項出力 = 特記事項出力;
//        this.主治医意見書出力 = 主治医意見書出力;
//        this.その他資料出力 = その他資料出力;
//        this.一次判定結果出力 = 一次判定結果出力;
//        this.認定調査票マスキング区分 = 認定調査票マスキング区分;
//        this.特記事項マスキング区分 = 特記事項マスキング区分;
//        this.主治医意見書マスキング区分 = 主治医意見書マスキング区分;
//        this.その他資料マスキング区分 = その他資料マスキング区分;
//        this.一次判定結果マスキング区分 = 一次判定結果マスキング区分;
//        this.特記事項判定日 = 特記事項判定日;
//        this.総合事業開始区分 = 総合事業開始区分;
//        this.情報提供資料の特記事項編集パターン = 情報提供資料の特記事項編集パターン;
//        this.正常選択肢印刷有無 = 正常選択肢印刷有無;
//        this.前回との結果比較印刷有無 = RString.EMPTY;
//        this.認定調査前回結果印刷有無 = 認定調査前回結果印刷有無;
//        this.前回正常選択肢印刷有無 = RString.EMPTY;
//    }
    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号のリスト
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
     * @param 特記事項判定日 特記事項判定日
     * @param 総合事業開始区分 総合事業開始区分
     * @param 情報提供資料の特記事項編集パターン 情報提供資料の特記事項編集パターン
     * @param 特記事項符号印刷有無
     * @param 正常選択肢印刷有無 正常選択肢印刷有無
     * @param 前回との結果比較印刷有無
     * @param 前回正常選択肢印刷有無
     */
    public YokaigoBatchProcessParamter(List<RString> 申請書管理番号, boolean 認定調査票出力,
            boolean 特記事項出力, boolean 主治医意見書出力, boolean その他資料出力, boolean 一次判定結果出力,
            RString 認定調査票マスキング区分, RString 特記事項マスキング区分, RString 主治医意見書マスキング区分,
            RString その他資料マスキング区分, RString 一次判定結果マスキング区分, FlexibleDate 特記事項判定日,
            RString 総合事業開始区分, RString 情報提供資料の特記事項編集パターン, RString 特記事項符号印刷有無,
            RString 正常選択肢印刷有無, RString 前回との結果比較印刷有無, RString 前回正常選択肢印刷有無) {
        this.申請書管理番号 = 申請書管理番号;
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
        this.特記事項判定日 = 特記事項判定日;
        this.総合事業開始区分 = 総合事業開始区分;
        this.情報提供資料の特記事項編集パターン = 情報提供資料の特記事項編集パターン;
        this.特記事項符号印刷有無 = 特記事項符号印刷有無;
        this.正常選択肢印刷有無 = 正常選択肢印刷有無;
        this.前回との結果比較印刷有無 = 前回との結果比較印刷有無;
        this.前回正常選択肢印刷有無 = 前回正常選択肢印刷有無;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public YokaigoBatchMybitisParamter toYokaigoBatchMybitisParamter() {
        return YokaigoBatchMybitisParamter.createParam(申請書管理番号, 特記事項マスキング区分);
    }
}
