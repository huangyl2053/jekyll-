/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt22006.NinteiBatchKekkaListShutsuryokuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定申請一括承認（バッチ）_結果一覧出力のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiBatchKekkaListShutsuryokuProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 作成年度;
    private FlexibleDate 認定期間_開始日;
    private FlexibleDate 認定期間_終了日;
    private FlexibleDate 決定日;
    private FlexibleDate 申請日開始;
    private FlexibleDate 申請日終了;
    private boolean 非課税時_承認しないフラグ;
    private RString 非課税時_承認しない理由;
    private boolean 配偶者課税時_承認しないフラグ;
    private RString 配偶者課税時_承認しない理由;
    private boolean 預貯金等超過時_承認しないフラグ;
    private RString 預貯金等超過時_理由;
    private boolean テスト処理;
    private boolean 確認リスト出力;
    private FlexibleDate 発行日;
    private RString 改頁出力順ID;
    private RString 帳票ID;
    private YMDHMS バッチ処理日時;

    /**
     * コンストラクタです。
     *
     * @param 作成年度
     * @param 認定期間_開始日
     * @param 認定期間_終了日
     * @param 決定日
     * @param 申請日開始
     * @param 申請日終了
     * @param 非課税時_承認しないフラグ
     * @param 非課税時_承認しない理由
     * @param 配偶者課税時_承認しないフラグ
     * @param 配偶者課税時_承認しない理由
     * @param 預貯金等超過時_承認しないフラグ
     * @param 預貯金等超過時_理由
     * @param テスト処理
     * @param 確認リスト出力
     * @param 発行日
     * @param 改頁出力順ID
     * @param 帳票ID
     * @param バッチ処理日時
     */
    public NinteiBatchKekkaListShutsuryokuProcessParameter(
            FlexibleYear 作成年度,
            FlexibleDate 認定期間_開始日,
            FlexibleDate 認定期間_終了日,
            FlexibleDate 決定日,
            FlexibleDate 申請日開始,
            FlexibleDate 申請日終了,
            boolean 非課税時_承認しないフラグ,
            RString 非課税時_承認しない理由,
            boolean 配偶者課税時_承認しないフラグ,
            RString 配偶者課税時_承認しない理由,
            boolean 預貯金等超過時_承認しないフラグ,
            RString 預貯金等超過時_理由,
            boolean テスト処理,
            boolean 確認リスト出力,
            FlexibleDate 発行日,
            RString 改頁出力順ID,
            RString 帳票ID,
            YMDHMS バッチ処理日時) {
        this.作成年度 = 作成年度;
        this.認定期間_開始日 = 認定期間_開始日;
        this.認定期間_終了日 = 認定期間_終了日;
        this.決定日 = 決定日;
        this.申請日開始 = 申請日開始;
        this.申請日終了 = 申請日終了;
        this.非課税時_承認しないフラグ = 非課税時_承認しないフラグ;
        this.非課税時_承認しない理由 = 非課税時_承認しない理由;
        this.配偶者課税時_承認しないフラグ = 配偶者課税時_承認しないフラグ;
        this.配偶者課税時_承認しない理由 = 配偶者課税時_承認しない理由;
        this.預貯金等超過時_承認しないフラグ = 預貯金等超過時_承認しないフラグ;
        this.預貯金等超過時_理由 = 預貯金等超過時_理由;
        this.テスト処理 = テスト処理;
        this.確認リスト出力 = 確認リスト出力;
        this.発行日 = 発行日;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.バッチ処理日時 = バッチ処理日時;
    }

    /**
     * バッチMybatisパラメターを取得します。
     *
     * @return NinteiBatchKekkaListShutsuryokuMybatisParameter
     */
    public NinteiBatchKekkaListShutsuryokuMybatisParameter toNinteiBatchKekkaListShutsuryokuMybatisParameter() {
        return new NinteiBatchKekkaListShutsuryokuMybatisParameter(認定期間_開始日, 認定期間_終了日);
    }
}
