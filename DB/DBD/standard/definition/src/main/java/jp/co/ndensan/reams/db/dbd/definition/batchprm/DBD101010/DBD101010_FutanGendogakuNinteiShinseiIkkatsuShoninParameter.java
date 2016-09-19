/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD101010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDZ00001.DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchKekkaHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchKekkaListShutsuryokuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchMainProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchTaishoTokuteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定申請一括承認のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter extends BatchParameterBase {

    @BatchParameter(key = "作成年度", name = "作成年度")
    private FlexibleYear 作成年度;
    @BatchParameter(key = "認定期間_開始日", name = "認定期間_開始日")
    private FlexibleDate 認定期間_開始日;
    @BatchParameter(key = "認定期間_終了日", name = "認定期間_終了日")
    private FlexibleDate 認定期間_終了日;
    @BatchParameter(key = "決定日", name = "決定日")
    private FlexibleDate 決定日;
    @BatchParameter(key = "申請日開始", name = "申請日開始")
    private FlexibleDate 申請日開始;
    @BatchParameter(key = "申請日終了", name = "申請日終了")
    private FlexibleDate 申請日終了;
    @BatchParameter(key = "非課税時_承認しないフラグ", name = "非課税時_承認しないフラグ")
    private boolean 非課税時_承認しないフラグ;
    @BatchParameter(key = "非課税時_承認しない理由", name = "非課税時_承認しない理由")
    private RString 非課税時_承認しない理由;
    @BatchParameter(key = "配偶者課税時_承認しないフラグ", name = "配偶者課税時_承認しないフラグ")
    private boolean 配偶者課税時_承認しないフラグ;
    @BatchParameter(key = "配偶者課税時_承認しない理由", name = "配偶者課税時_承認しない理由")
    private RString 配偶者課税時_承認しない理由;
    @BatchParameter(key = "預貯金等超過時_承認しないフラグ", name = "預貯金等超過時_承認しないフラグ")
    private boolean 預貯金等超過時_承認しないフラグ;
    @BatchParameter(key = "預貯金等超過時_理由", name = "預貯金等超過時_理由")
    private RString 預貯金等超過時_理由;
    @BatchParameter(key = "テスト処理", name = "テスト処理")
    private boolean テスト処理;
    @BatchParameter(key = "確認リスト出力", name = "確認リスト出力")
    private boolean 確認リスト出力;
    @BatchParameter(key = "発行日", name = "発行日")
    private FlexibleDate 発行日;
    @BatchParameter(key = "改頁出力順ID", name = "改頁出力順ID")
    private RString 改頁出力順ID;
    @BatchParameter(key = "帳票ID", name = "帳票ID")
    private RString 帳票ID;

    /**
     * 処理対象の特定のprocessパラメータを作成。
     *
     * @param バッチ処理日時 YMDHMS
     * @return NinteiBatchTaishoTokuteiProcessParameter
     */
    public NinteiBatchTaishoTokuteiProcessParameter toNinteiBatchTaishoTokuteiProcessParameter(YMDHMS バッチ処理日時) {
        return new NinteiBatchTaishoTokuteiProcessParameter(バッチ処理日時, 決定日, 作成年度, テスト処理, 申請日開始, 申請日終了);
    }

    /**
     * 減免減額対象者判定用根拠作成のprocessパラメータを作成。
     *
     * @return GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter
     */
    public DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter toGemmenGengakuTaishoShaHanteiYoukonSakuseiParameter() {
        return new DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter(作成年度);
    }

    /**
     * 承認処理のprocessパラメータを作成。
     *
     * @param バッチ処理日時 YMDHMS
     * @return NinteiBatchMainProcessParameter
     */
    public NinteiBatchMainProcessParameter toNinteiBatchMainProcessParameter(YMDHMS バッチ処理日時) {
        return new NinteiBatchMainProcessParameter(
                非課税時_承認しないフラグ,
                非課税時_承認しない理由,
                配偶者課税時_承認しないフラグ,
                配偶者課税時_承認しない理由,
                預貯金等超過時_承認しないフラグ,
                預貯金等超過時_理由,
                決定日,
                認定期間_開始日,
                認定期間_終了日,
                バッチ処理日時
        );
    }

    /**
     * 結果一覧出力のprocessパラメータを作成。
     *
     * @param バッチ処理日時
     * @return NinteiBatchKekkaListShutsuryokuProcessParameter
     */
    public NinteiBatchKekkaListShutsuryokuProcessParameter toNinteiBatchKekkaListShutsuryokuProcessParameter(YMDHMS バッチ処理日時) {
        return new NinteiBatchKekkaListShutsuryokuProcessParameter(
                作成年度,
                認定期間_開始日,
                認定期間_終了日,
                決定日,
                申請日開始,
                申請日終了,
                非課税時_承認しないフラグ,
                非課税時_承認しない理由,
                配偶者課税時_承認しないフラグ,
                配偶者課税時_承認しない理由,
                預貯金等超過時_承認しないフラグ,
                預貯金等超過時_理由,
                テスト処理,
                確認リスト出力,
                発行日,
                改頁出力順ID,
                帳票ID,
                バッチ処理日時);
    }

    /**
     * 一括認定結果反映のprocessパラメータを作成。
     *
     * @return NinteiBatchKekkaHanteiProcessParameter
     */
    public NinteiBatchKekkaHanteiProcessParameter toNinteiBatchKekkaHanteiProcessParameter() {
        return new NinteiBatchKekkaHanteiProcessParameter(テスト処理);
    }
}
