/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09B;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * {@link INinteiChosahyoShisetsuRiyoAccessor}を生成します。
 */
public class NinteiChosahyoShisetsuRiyoAccessorFactory {

    private NinteiChosahyoShisetsuRiyoAccessorFactory() {
    }

    /**
     * @param ocrChosa 対象の{@link OcrChosa}
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return
     * 指定の{@link OcrChosa}について、指定の厚労省IFコードに対応する要素を参照する{@link INinteiChosahyoShisetsuRiyoAccessor}
     */
    public static INinteiChosahyoShisetsuRiyoAccessor createInstance(OcrChosa ocrChosa, RString 厚労省IF識別コード) {
        Objects.requireNonNull(ocrChosa);
        switch (KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード)) {
            case 認定ｿﾌﾄ2009_SP3:
                return new NinteiChosahyoShisetsuRiyoAccessorFactory._09B(ocrChosa);
            default:
                throw new IllegalArgumentException(new RStringBuilder()
                        .append("指定の厚労省IF識別コードは不正です。：'")
                        .append(厚労省IF識別コード)
                        .append("'")
                        .toString());
        }
    }

    private static class _09B implements INinteiChosahyoShisetsuRiyoAccessor {

        private final OcrChosa ocrChosa;

        public _09B(OcrChosa ocrChosa) {
            this.ocrChosa = ocrChosa;
        }

        @Override
        public Optional<Boolean> valueOf(int 連番) {
            if (RString.isNullOrEmpty(ocrChosa.get施設利用の有無())) {
                return Optional.empty();
            }
            switch (GaikyoChosahyouNiteichosahyouSisetuRiy09B.toValue(new RString(連番))) {
                case 居宅:
                    return OcrShisetsuRiyo.居宅.equalsCode(ocrChosa.get施設利用の有無());
                case 介護老人福祉施設:
                    return OcrShisetsuRiyo.介護老人福祉施設.equalsCode(ocrChosa.get施設利用の有無());
                case 介護老人保健施設:
                    return OcrShisetsuRiyo.介護老人保健施設.equalsCode(ocrChosa.get施設利用の有無());
                case 介護療養型医療施設:
                    return OcrShisetsuRiyo.介護療養型医療施設.equalsCode(ocrChosa.get施設利用の有無());
                case 認知症対応型共同生活介護適用施設:
                    return OcrShisetsuRiyo.認知症対応型共同生活介護適用施設.equalsCode(ocrChosa.get施設利用の有無());
                case 特定施設入所者生活介護適用施設:
                    return OcrShisetsuRiyo.特定施設入所者生活介護適用施設.equalsCode(ocrChosa.get施設利用の有無());
                case 医療機関_療養:
                    return OcrShisetsuRiyo.医療機関_療養.equalsCode(ocrChosa.get施設利用の有無());
                case 医療機関_療養以外:
                    return OcrShisetsuRiyo.医療機関_療養以外.equalsCode(ocrChosa.get施設利用の有無());
                case その他の施設:
                    return OcrShisetsuRiyo.その他の施設.equalsCode(ocrChosa.get施設利用の有無());
                default:
            }
            return Optional.empty();
        }
    }

    private enum OcrShisetsuRiyo {

        居宅("0"),
        介護老人福祉施設("1"),
        介護老人保健施設("2"),
        介護療養型医療施設("3"),
        認知症対応型共同生活介護適用施設("4"),
        特定施設入所者生活介護適用施設("5"),
        医療機関_療養("6"),
        医療機関_療養以外("7"),
        その他の施設("8");
        private final RString code;

        private OcrShisetsuRiyo(String code) {
            this.code = new RString(code);
        }

        private Optional<Boolean> equalsCode(RString code) {
            return Optional.of(Objects.equals(this.code, code));
        }
    }

}
