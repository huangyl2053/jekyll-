/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *  * {@link INinteiChosahyoChosaItemAccessor}を生成します。
 */
public final class NinteiChosahyoChosaItemAccessorFactory {

    private NinteiChosahyoChosaItemAccessorFactory() {
    }

    /**
     * @param ocrChosa 対象の{@link OcrChosa}
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return
     * 指定の{@link OcrChosa}について、指定の厚労省IFコードに対応する要素を参照する{@link INinteiChosahyoChosaItemAccessor}
     */
    public static INinteiChosahyoChosaItemAccessor createInstance(OcrChosa ocrChosa, RString 厚労省IF識別コード) {
        Objects.requireNonNull(ocrChosa);
        switch (KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード)) {
            case 認定ｿﾌﾄ2009_SP3:
                return new NinteiChosahyoChosaItemAccessorFactory._IFCode09B(ocrChosa);
            default:
                throw new IllegalArgumentException(new RStringBuilder()
                        .append("指定の厚労省IF識別コードは不正です。：'")
                        .append(厚労省IF識別コード)
                        .append("'")
                        .toString());
        }
    }

    private static class _IFCode09B implements INinteiChosahyoChosaItemAccessor {

        private final OcrChosa ocrChosa;

        public _IFCode09B(OcrChosa ocrChosa) {
            this.ocrChosa = ocrChosa;
        }

        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        private static final String OCR_チェックあり = "1";
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        private static final String OCR_チェックなし = "0";

        private static RString toChosaAnser01(RString value) {
            switch (value.toString()) {
                case OCR_チェックあり:
                    return ChosaAnser01.ある.getコード();
                case OCR_チェックなし:
                    return ChosaAnser01.ない.getコード();
                default:
                    return RString.EMPTY;
            }
        }

        @Override
        @SuppressWarnings("checkstyle:cyclomaticcomplexity")
        public RString valueOf(int 連番) {
            //CHECKSTYLE IGNORE MagicNumber FOR NEXT 152 LINES
            switch (NinteichosaKomokuMapping09B.toValue(new RString(連番))) {
                case 麻痺等_左上肢:
                    return toChosaAnser01(ocrChosa.get麻痺().substringEmptyOnError(1, 2));
                case 麻痺等_右上肢:
                    return toChosaAnser01(ocrChosa.get麻痺().substringEmptyOnError(2, 3));
                case 麻痺等_左下肢:
                    return toChosaAnser01(ocrChosa.get麻痺().substringEmptyOnError(3, 4));
                case 麻痺等_右下肢:
                    return toChosaAnser01(ocrChosa.get麻痺().substringEmptyOnError(4, 5));
                case 麻痺等_その他:
                    return toChosaAnser01(ocrChosa.get麻痺().substringEmptyOnError(5, 6));
                case 拘縮_肩関節:
                    return toChosaAnser01(ocrChosa.get拘縮().substringEmptyOnError(1, 2));
                case 拘縮_股関節:
                    return toChosaAnser01(ocrChosa.get拘縮().substringEmptyOnError(2, 3));
                case 拘縮_膝関節:
                    return toChosaAnser01(ocrChosa.get拘縮().substringEmptyOnError(3, 4));
                case 拘縮_その他:
                    return toChosaAnser01(ocrChosa.get拘縮().substringEmptyOnError(4, 5));
                case 寝返り:
                    return ocrChosa.get寝返り();
                case 起き上がり:
                    return ocrChosa.get起き上がり();
                case 座位保持:
                    return ocrChosa.get座位保持();
                case 両足での立位:
                    return ocrChosa.get両足での立位();
                case 歩行:
                    return ocrChosa.get歩行();
                case 立ち上がり:
                    return ocrChosa.get立ち上がり();
                case 片足での立位:
                    return ocrChosa.get片足での立位();
                case 洗身:
                    return ocrChosa.get洗身();
                case つめ切り:
                    return ocrChosa.getつめ切り();
                case 視力:
                    return ocrChosa.get視力();
                case 聴力:
                    return ocrChosa.get聴力();
                case 移乗:
                    return ocrChosa.get移乗();
                case 移動:
                    return ocrChosa.get移動();
                case えん下:
                    return ocrChosa.getえん下();
                case 食事摂取:
                    return ocrChosa.get食事摂取();
                case 排尿:
                    return ocrChosa.get排尿();
                case 排便:
                    return ocrChosa.get排便();
                case 口腔清潔:
                    return ocrChosa.get口腔清潔();
                case 洗顔:
                    return ocrChosa.get洗顔();
                case 整髪:
                    return ocrChosa.get整髪();
                case 上衣の着脱:
                    return ocrChosa.get上衣の着脱();
                case ズボン等の着脱:
                    return ocrChosa.getズボン等の着脱();
                case 外出頻度:
                    return ocrChosa.get外出頻度();
                case 意思の伝達:
                    return ocrChosa.get意思の疎通();
                case 毎日の日課を理解:
                    return ocrChosa.get毎日の日課を理解();
                case 生年月日をいう:
                    return ocrChosa.get生年月日をいう();
                case 短期記憶:
                    return ocrChosa.get短期記憶();
                case 自分の名前をいう:
                    return ocrChosa.get自分の名前をいう();
                case 今の季節を理解:
                    return ocrChosa.get今の季節を理解();
                case 場所の理解:
                    return ocrChosa.get場所の理解();
                case 常時の徘徊:
                    return ocrChosa.get徘徊();
                case 外出して戻れない:
                    return ocrChosa.get外出して戻れない();
                case 被害的:
                    return ocrChosa.get被害的();
                case 作話:
                    return ocrChosa.get作話();
                case 感情が不安定:
                    return ocrChosa.get感情が不安定();
                case 昼夜逆転:
                    return ocrChosa.get昼夜逆転();
                case 同じ話をする:
                    return ocrChosa.get同じ話をする();
                case 大声を出す:
                    return ocrChosa.get大声を出す();
                case 介護に抵抗:
                    return ocrChosa.get介護に抵抗();
                case 落ち着きなし:
                    return ocrChosa.get落ち着きなし();
                case 一人で出たがる:
                    return ocrChosa.get一人で出たがる();
                case 収集癖:
                    return ocrChosa.get収集癖();
                case 物や衣類を壊す:
                    return ocrChosa.get物や衣類を壊す();
                case ひどい物忘れ:
                    return ocrChosa.getひどい物忘れ();
                case 独り言_独り笑い:
                    return ocrChosa.get独り言();
                case 自分勝手に行動する:
                    return ocrChosa.get自分勝手に行動する();
                case 話がまとまらない:
                    return ocrChosa.get話がまとまらない();
                case 薬の内服:
                    return ocrChosa.get薬の内服();
                case 金銭の管理:
                    return ocrChosa.get金銭の管理();
                case 日常の意思決定:
                    return ocrChosa.get日常の意思決定();
                case 集団への不適応:
                    return ocrChosa.get集団への不適応();
                case 買い物:
                    return ocrChosa.get買い物();
                case 簡単な調理:
                    return ocrChosa.get簡単な調理();
                case 点滴の管理:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(0, 1));
                case 中心静脈栄養:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(1, 2));
                case 透析:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(2, 3));
                case ストーマの処置:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(3, 4));
                case 酸素療法:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(4, 5));
                case レスピレーター:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(5, 6));
                case 気管切開の処置:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(6, 7));
                case 疼痛の看護:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(7, 8));
                case 経管栄養:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(8, 9));
                case モニター測定:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(9, 10));
                case じょくそうの処置:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(10, 11));
                case カテーテル:
                    return toChosaAnser01(ocrChosa.get過去14日間に受けた治療().substringEmptyOnError(11, 12));
                default:
            }
            return RString.EMPTY;
        }
    }
}
