/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * {@link INinteiChosahyoServiceJokyoAccessor}を生成します。
 */
public class NinteiChosahyoServiceJokyoAccessorFactory {

    private NinteiChosahyoServiceJokyoAccessorFactory() {
    }

    /**
     * @param ocrChosa 対象の{@link OcrChosa}
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return
     * 指定の{@link OcrChosa}について、指定の厚労省IFコードに対応する要素を参照する{@link INinteiChosahyoServiceJokyoAccessor}
     */
    public static INinteiChosahyoServiceJokyoAccessor createInstance(OcrChosa ocrChosa, RString 厚労省IF識別コード) {
        Objects.requireNonNull(ocrChosa);
        switch (KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード)) {
            case 認定ｿﾌﾄ2009_SP3:
                return new NinteiChosahyoServiceJokyoAccessorFactory._09B(ocrChosa);
            default:
                throw new IllegalArgumentException(new RStringBuilder()
                        .append("指定の厚労省IF識別コードは不正です。：'")
                        .append(厚労省IF識別コード)
                        .append("'")
                        .toString());
        }
    }

    private static class _09B implements INinteiChosahyoServiceJokyoAccessor {

        private final OcrChosa ocrChosa;

        public _09B(OcrChosa ocrChosa) {
            this.ocrChosa = ocrChosa;
        }

        @Override
        public Optional<Integer> valueOf(int 連番) {
            switch (CKGaikyoChosahyouServiceJyouk09B.toValue(new RString(連番))) {
                case 訪問介護:
                    return toInteger(ocrChosa.get訪問介護の回数());
                case 訪問入浴介護:
                    return toInteger(ocrChosa.get訪問入浴介護の回数());
                case 訪問看護:
                    return toInteger(ocrChosa.get訪問看護の回数());
                case 訪問リハビリ:
                    return toInteger(ocrChosa.get訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数());
                case 居宅療養管理指導:
                    return toInteger(ocrChosa.get居宅療養管理指導の回数());
                case 通所介護:
                    return toInteger(ocrChosa.get通所看護の回数());
                case 通所リハビリ:
                    return toInteger(ocrChosa.get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数());
                case 短期入所生活介護:
                    return toInteger(ocrChosa.get短期入所生活介護の日数());
                case 短期入所療養介護:
                    return toInteger(ocrChosa.get短期入所療養介護の日数());
                case 特定施設入居者生活介護:
                    return toInteger(ocrChosa.get特定施設入所者生活介護の日数());
                case 福祉用具貸与:
                    return toInteger(ocrChosa.get福祉用具貸与の品目());
                case 福祉用具購入:
                    return toInteger(ocrChosa.get福祉用具購入の品目());
                case 夜間対応型訪問介護:
                    return toInteger(ocrChosa.get夜間対応型訪問介護の日数());
                case 認知症対応型通所介護:
                    return toInteger(ocrChosa.get認知症対応型通所介護の日数());
                case 小規模多機能型居宅介護:
                    return toInteger(ocrChosa.get小規模多機能型居宅介護の日数());
                case 認知症対応型共同生活介護:
                    return toInteger(ocrChosa.get認知症対応型共同生活介護の日数());
                case 地域密着型特定施設入居者生活介護:
                    return toInteger(ocrChosa.get地域密着型特定施設入居者生活介護の日数());
                case 地域密着型介護老人福祉施設入所者生活介護:
                    return toInteger(ocrChosa.get地域密着型介護老人福祉施設入居者生活介護の日数());
                case 定期巡回_随時対応型訪問介護看護:
                    return toInteger(ocrChosa.get随時対応型訪問介護看護());
                case 看護小規模多機能型居宅介護:
                    return toInteger(ocrChosa.get看護小規模多機能型居宅介護());
                default:
            }
            return Optional.empty();
        }
    }

    private static Optional<Integer> toInteger(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return Optional.empty();
        }
        return Optional.of(Integer.valueOf(value.toString()));
    }
}
