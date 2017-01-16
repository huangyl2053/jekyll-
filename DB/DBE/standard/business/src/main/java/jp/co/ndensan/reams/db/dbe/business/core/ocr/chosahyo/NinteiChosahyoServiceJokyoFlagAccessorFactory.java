/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag.ServiceJokyoFlag09B;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * {@link INinteiChosahyoServiceJokyoFlagAccessor}を生成します。
 */
public final class NinteiChosahyoServiceJokyoFlagAccessorFactory {

    private NinteiChosahyoServiceJokyoFlagAccessorFactory() {
    }

    /**
     * @param ocrChosa 対象の{@link OcrChosa}
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return
     * 指定の{@link OcrChosa}について、指定の厚労省IFコードに対応する要素を参照する{@link INinteiChosahyoServiceJokyoFlagAccessor}
     */
    public static INinteiChosahyoServiceJokyoFlagAccessor createInstance(OcrChosa ocrChosa, RString 厚労省IF識別コード) {
        Objects.requireNonNull(ocrChosa);
        switch (KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード)) {
            case 認定ｿﾌﾄ2009_SP3:
                return new NinteiChosahyoServiceJokyoFlagAccessorFactory._09B(ocrChosa);
            default:
                throw new IllegalArgumentException(new RStringBuilder()
                        .append("指定の厚労省IF識別コードは不正です。：'")
                        .append(厚労省IF識別コード)
                        .append("'")
                        .toString());
        }
    }

    private static class _09B implements INinteiChosahyoServiceJokyoFlagAccessor {

        private final OcrChosa ocrChosa;

        public _09B(OcrChosa ocrChosa) {
            this.ocrChosa = ocrChosa;
        }

        @Override
        public Optional<Boolean> valueOf(int 連番) {
            switch (ServiceJokyoFlag09B.toValue(連番)) {
                case 住宅改修:
                    return toBoolean(ocrChosa.get住宅改修());
                default:
                    return Optional.empty();
            }
        }
    }

    private static final String OCR_有 = "1";
    private static final String OCR_無 = "2";

    private static Optional<Boolean> toBoolean(RString value) {
        switch (value.toString()) {
            case OCR_有:
                return Optional.of(true);
            case OCR_無:
                return Optional.of(false);
            default:
                return Optional.empty();
        }
    }
}
