/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult.Type;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import static jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi.エラーとする;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査取込とイメージ取込で用います。
 * OCRの取込結果を更新する対象の要介護認定申請とそれに関連する情報を保持するデータ(関連データと表現しています)の共通的な処理をまとめたクラスです。
 */
public abstract class RelatedDataBase implements IRelatedData {

    /**
     * 過去の厚労省IF識別コードを持ちます。
     */
    protected static final List<KoroshoIfShikibetsuCode> OLD_KOROSHO_IF_CODES;

    static {
        OLD_KOROSHO_IF_CODES = Collections.unmodifiableList(
                Arrays.asList(KoroshoIfShikibetsuCode.認定ｿﾌﾄ99, KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002,
                        KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用, KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009)
        );
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    protected abstract FlexibleDate get認定申請日();

    /**
     * @return 検索時に指定した申請日と合致する場合、{@code true}.それ以外の場合、{@code false}.
     */
    protected abstract boolean matches指定申請日();

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    protected abstract KoroshoIfShikibetsuCode get厚労省IF識別コード();

    /**
     * @return 論理削除済みの場合、{@code true}.
     */
    protected abstract boolean had論理削除();

    /**
     * @return 依頼済みの場合、{@code true}.
     */
    protected abstract boolean had依頼();

    /**
     * @return 依頼未完了のエラーメッセージで依頼の名称として利用する値
     */
    protected abstract RString get依頼名();

    /**
     * @return 一次判定実施済みの場合、{@code true}.
     */
    protected abstract boolean had一次判定();

    /**
     * {@link RelatedDataBase}生成時の処理状況を持ちます。
     */
    protected interface IContext {

        /**
         * @return 対応する{@link IOcrData}すべて
         */
        List<IOcrData> getOcrData();

        /**
         * @return 一次判定実施済みの申請と対応する内容を取り込んだ際の処理方法
         */
        TreatmentWhenIchijiHanteiZumi get一次判定済時処理();
    }

    /**
     * @param context {@link RelatedDataBase}生成時の処理状況
     * @return バリデーションの結果を保持した{@link IProcessingResults}
     */
    protected IProcessingResults validate(IContext context) {
        if (OLD_KOROSHO_IF_CODES.contains(get厚労省IF識別コード())) {
            return createResults(context.getOcrData(), IProcessingResult.Type.ERROR, OcrTorikomiMessages.過去制度での申請);
        }
        if (!matches指定申請日()) {
            if (had論理削除()) {
                return createResults(context.getOcrData(), IProcessingResult.Type.ERROR, OcrTorikomiMessages.すべての申請情報が論理削除);
            }
            return createResults(context.getOcrData(), IProcessingResult.Type.ERROR, OcrTorikomiMessages.申請日一致なし_直近申請日提示
                    .replaced(OcrTorikomiMessages.toSlashSeparatedSeireki(get認定申請日())));
        }
        if (had論理削除()) {
            return createResults(context.getOcrData(), IProcessingResult.Type.ERROR, OcrTorikomiMessages.削除された申請);
        }
        if (!had依頼()) {
            return createResults(context.getOcrData(), IProcessingResult.Type.ERROR, OcrTorikomiMessages.依頼未完了.replaced(get依頼名().toString()));
        }
        if (had一次判定()) {
            switch (context.get一次判定済時処理()) {
                case エラーとする:
                    return createResults(context.getOcrData(), IProcessingResult.Type.ERROR, OcrTorikomiMessages.一次判定済みの申請_エラー);
                default:
                    return hasToRetryIchijiHantei(context.getOcrData())
                            ? createResults(context.getOcrData(), IProcessingResult.Type.WARNING, OcrTorikomiMessages.一次判定済みの申請_警告_要再判定)
                            : createResults(context.getOcrData(), IProcessingResult.Type.WARNING, OcrTorikomiMessages.一次判定済みの申請_警告);
            }
        }
        return ProcessingResults.EMPTY;
    }

    private static boolean hasToRetryIchijiHantei(Iterable<? extends IOcrData> ocrData) {
        for (IOcrData o : ocrData) {
            if (o.getOCRID().isUsesIchijiHantei()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param ocrData バリデーションの対象
     * @param type 判定結果
     * @param messageToNote メッセージ
     * @return バリデーション結果
     */
    protected static IProcessingResults createResults(Collection<? extends IOcrData> ocrData, Type type, OcrTorikomiMessages messageToNote) {
        return createResults(ocrData, type, messageToNote.originalMessage());
    }

    /**
     * @param ocrData バリデーションの対象
     * @param type 判定結果
     * @param messageToNote メッセージ
     * @return バリデーション結果
     */
    protected static IProcessingResults createResults(Collection<? extends IOcrData> ocrData, Type type, RString messageToNote) {
        ProcessingResults results = new ProcessingResults();
        for (IOcrData o : ocrData) {
            results.add(ProcessingResultFactory.create(type, o, messageToNote));
        }
        return results;
    }

    /**
     * @param fDate 判定対象{@link FlexibleDate}
     * @return
     * 指定の{@link FlexibleDate}が{@code null}でなく、かつ、実在する日付を持つ場合、{@code true}.
     */
    protected static boolean isValid(FlexibleDate fDate) {
        return fDate != null && fDate.isEmpty();
    }

    /**
     * @param bool {@link Boolean}
     * @return 指定の値が{@code null}ではなく、かつ、{@code false}と一致する場合、{@code true}.
     */
    protected static boolean isFalse(Boolean bool) {
        return java.util.Objects.equals(false, bool);
    }
}
