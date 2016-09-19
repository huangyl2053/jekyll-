/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定申請一括承認（バッチ）_承認処理のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiBatchMainProcessParameter implements IBatchProcessParameter {

    private boolean 非課税時_承認しないフラグ;
    private RString 非課税時_承認しない理由;
    private boolean 配偶者課税時_承認しないフラグ;
    private RString 配偶者課税時_承認しない理由;
    private boolean 預貯金等超過時_承認しないフラグ;
    private RString 預貯金等超過時_理由;
    private FlexibleDate 決定日;
    private FlexibleDate 認定期間_開始日;
    private FlexibleDate 認定期間_終了日;
    private YMDHMS バッチ処理日時;

    /**
     * コンストラクタです。
     *
     * @param 非課税時_承認しないフラグ
     * @param 非課税時_承認しない理由
     * @param 配偶者課税時_承認しないフラグ
     * @param 配偶者課税時_承認しない理由
     * @param 預貯金等超過時_承認しないフラグ
     * @param 預貯金等超過時_理由
     * @param 決定日
     * @param 認定期間_開始日
     * @param 認定期間_終了日
     * @param バッチ処理日時
     */
    public NinteiBatchMainProcessParameter(
            boolean 非課税時_承認しないフラグ,
            RString 非課税時_承認しない理由,
            boolean 配偶者課税時_承認しないフラグ,
            RString 配偶者課税時_承認しない理由,
            boolean 預貯金等超過時_承認しないフラグ,
            RString 預貯金等超過時_理由,
            FlexibleDate 決定日,
            FlexibleDate 認定期間_開始日,
            FlexibleDate 認定期間_終了日,
            YMDHMS バッチ処理日時) {
        this.非課税時_承認しないフラグ = 非課税時_承認しないフラグ;
        this.非課税時_承認しない理由 = 非課税時_承認しない理由;
        this.配偶者課税時_承認しないフラグ = 配偶者課税時_承認しないフラグ;
        this.配偶者課税時_承認しない理由 = 配偶者課税時_承認しない理由;
        this.預貯金等超過時_承認しないフラグ = 預貯金等超過時_承認しないフラグ;
        this.預貯金等超過時_理由 = 預貯金等超過時_理由;
        this.決定日 = 決定日;
        this.認定期間_開始日 = 認定期間_開始日;
        this.認定期間_終了日 = 認定期間_終了日;
        this.バッチ処理日時 = バッチ処理日時;
    }
}
