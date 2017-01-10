/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * {@link IIkenshoIkenKomokuAccessor}を生成します。
 */
public final class IkenshoIkenKomokuAccessorFactory {

    private IkenshoIkenKomokuAccessorFactory() {
    }

    /**
     * @param ocrIken 対象の{@link OcrIken}
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return
     * 指定の{@link OcrIken}について、指定の厚労省IFコードに対応する要素を参照する{@link IIkenshoIkenKomokuAccessor}
     */
    public static IIkenshoIkenKomokuAccessor createInstance(OcrIken ocrIken, RString 厚労省IF識別コード) {
        Objects.requireNonNull(ocrIken);
        switch (KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード)) {
            case 認定ｿﾌﾄ2009_SP3:
                return new _09B(ocrIken);
            default:
                throw new IllegalArgumentException(new RStringBuilder()
                        .append("指定の厚労省IF識別コードは不正です。：'")
                        .append(厚労省IF識別コード)
                        .append("'")
                        .toString());
        }
    }

    private static class _09B implements IIkenshoIkenKomokuAccessor {

        private final OcrIken oi;

        public _09B(OcrIken oi) {
            this.oi = oi;
        }

        @Override
        public RString valueOf(int 連番) {
            switch (IkenshoKomokuMapping09B.toValue(new RString(連番))) {
                case 点滴の管理:
                    return oi.get処置内容().substringEmptyOnError(0, 1);
                case ストーマの処置:
                    return oi.get処置内容().substringEmptyOnError(1, 2);
                case 気管切開の処置:
                    return oi.get処置内容().substringEmptyOnError(2, 3);
                case 中心静脈栄養:
                    return oi.get処置内容().substringEmptyOnError(3, 4);
                case 酸素療法:
                    return oi.get処置内容().substringEmptyOnError(4, 5);
                case 疼痛の看護:
                    return oi.get処置内容().substringEmptyOnError(5, 6);
                case 透析:
                    return oi.get処置内容().substringEmptyOnError(6, 7);
                case レスピレーター:
                    return oi.get処置内容().substringEmptyOnError(7, 8);
                case 経管栄養:
                    return oi.get処置内容().substringEmptyOnError(8);
                case モニター測定:
                    return oi.get特別な対応().substringEmptyOnError(0, 1);
                case じょくそうの処置:
                    return oi.get特別な対応().substringEmptyOnError(1);
                case カテーテル:
                    return oi.getカテーテル();
                case 寝たきり度:
                    return oi.get障害高齢者の自立度();
                case 認知症高齢者の日常生活自立度:
                    return to記載なし(oi.get認知症高齢者の自立度());
                case 短期記憶:
                    return to記載なし(oi.get短期記憶());
                case 認知能力:
                    return to記載なし(oi.get認知能力());
                case 伝達能力:
                    return to記載なし(oi.get伝達能力());
                case 認知症の周辺症状:
                    return oi.get問題行動の有無();
                case 幻視_幻聴:
                    return oi.get問題行動().substringEmptyOnError(0, 1);
                case 火の不始末:
                    return oi.get問題行動().substringEmptyOnError(1, 2);
                case 妄想:
                    return oi.get問題行動().substringEmptyOnError(2, 3);
                case 不潔行為:
                    return oi.get問題行動().substringEmptyOnError(3, 4);
                case 昼夜逆転:
                    return oi.get問題行動().substringEmptyOnError(4, 5);
                case 異食行動:
                    return oi.get問題行動().substringEmptyOnError(5, 6);
                case 暴言:
                    return oi.get問題行動().substringEmptyOnError(6, 7);
                case 性的問題行動:
                    return oi.get問題行動().substringEmptyOnError(7, 8);
                case 暴行:
                    return oi.get問題行動().substringEmptyOnError(8, 9);
                case その他:
                    return oi.get問題行動().substringEmptyOnError(9, 10);
                case 介護への抵抗:
                    return oi.get問題行動().substringEmptyOnError(10, 11);
                case 徘徊_認知症の周辺症状:
                    return oi.get問題行動().substringEmptyOnError(11);
                case その他の精神_神経症状:
                    return oi.get精神神経症状();
                case 専門医受診の有無:
                    return oi.get専門科医受診();
                case 利き腕:
                    return oi.get利き腕();
                case 過去6カ月の体重の変化:
                    return oi.get過去6ヶ月間の体重の変化();
                case 四肢欠損:
                    return oi.get四肢欠損();
                case 麻痺:
                    return oi.get麻痺();
                case 麻痺_右上肢:
                    return oi.get麻痺右上肢();
                case 麻痺_右上肢_程度:
                    return oi.get麻痺右上肢程度();
                case 麻痺_左上肢:
                    return oi.get麻痺左上肢();
                case 麻痺_左上肢_程度:
                    return oi.get麻痺左上肢程度();
                case 麻痺_右下肢:
                    return oi.get麻痺右下肢();
                case 麻痺_右下肢_程度:
                    return oi.get麻痺右下肢程度();
                case 麻痺_左下肢:
                    return oi.get麻痺左下肢();
                case 麻痺_左下肢_程度:
                    return oi.get麻痺左下肢程度();
                case 麻痺_その他:
                    return oi.get麻痺その他();
                case 麻痺_その他_程度:
                    return oi.get麻痺その他程度();
                case 筋力の低下:
                    return oi.get筋力低下();
                case 筋力の低下_程度:
                    return oi.get筋力低下程度();
                case 関節の拘縮:
                    return oi.get間接の拘縮();
                case 関節の拘縮_程度:
                    return oi.get間接の拘縮程度();
                case 関節の痛み:
                    return oi.get間接の痛み();
                case 関節の痛み_程度:
                    return oi.get間接の痛み程度();
                case 失調_不随意運動:
                    return oi.get失調不随意運動();
                case 失調_不随意運動_上肢_右:
                    return oi.get失調不随意上肢().substringEmptyOnError(0, 1);
                case 失調_不随意運動_上肢_左:
                    return oi.get失調不随意上肢().substringEmptyOnError(1);
                case 失調_不随意運動_下肢_右:
                    return oi.get失調不随意下肢().substringEmptyOnError(0, 1);
                case 失調_不随意運動_下肢_左:
                    return oi.get失調不随意下肢().substringEmptyOnError(1);
                case 失調_不随意運動_体幹_右:
                    return oi.get失調不随意体幹().substringEmptyOnError(0, 1);
                case 失調_不随意運動_体幹_左:
                    return oi.get失調不随意体幹().substringEmptyOnError(1);
                case じょくそう:
                    return oi.get褥痩();
                case じょくそう_程度:
                    return oi.get褥痩程度();
                case その他の皮膚疾患:
                    return oi.getその他皮膚疾患();
                case その他の皮膚疾患_程度:
                    return oi.getその他皮膚疾患程度();
                case 屋外歩行:
                    return oi.get屋外歩行();
                case 車いすの使用:
                    return oi.get車いすの使用();
                case 歩行補助具_装具の使用_用いていない:
                    return oi.get歩行補助具装具の使用().substringEmptyOnError(0, 1);
                case 歩行補助具_装具の使用_屋外で使用:
                    return oi.get歩行補助具装具の使用().substringEmptyOnError(1, 2);
                case 歩行補助具_装具の使用_屋内で使用:
                    return oi.get歩行補助具装具の使用().substringEmptyOnError(2);
                case 食事行為:
                    return to記載なし(oi.get食事行為());
                case 現在の栄養状態:
                    return oi.get現在の栄養状況();
                case 尿失禁:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(0, 1);
                case 転倒_骨折:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(1, 2);
                case 移動能力の低下:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(2, 3);
                case 褥瘡:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(3, 4);
                case 心肺機能の低下:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(4, 5);
                case 閉じこもり:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(5, 6);
                case 意欲低下:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(6, 7);
                case 徘徊_可能性が高い病態:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(7, 8);
                case 低栄養:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(8, 9);
                case 摂食_嚥下機能低下:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(9, 10);
                case 脱水:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(10, 11);
                case 易感染性:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(11, 12);
                case がん等による疼痛:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(12, 13);
                case 病態_その他:
                    return oi.get現在または今後発生の可能性の高い状態().substringEmptyOnError(13);
                case 生活機能の維持_改善の見通し:
                    return oi.get予後の見通し();
                case 訪問診療:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(0, 1);
                case 訪問診療_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(0, 1);
                case 訪問看護:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(1, 2);
                case 訪問看護_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(1, 2);
                case 看護職員による相談:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(2, 3);
                case 看護職員による相談_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(2, 3);
                case 訪問歯科診療:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(3, 4);
                case 訪問歯科診療_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(3, 4);
                case 訪問薬剤管理指導:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(4, 5);
                case 訪問薬剤管理指導_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(4, 5);
                case 訪問リハビリテーション:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(5, 6);
                case 訪問リハビリテーション_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(5, 6);
                case 短期入所療養介護:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(6, 7);
                case 短期入所療養介護_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(6, 7);
                case 訪問歯科衛生指導:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(7, 8);
                case 訪問歯科衛生指導_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(7, 8);
                case 訪問栄養食事指導:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(8, 9);
                case 訪問栄養食事指導_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(8, 9);
                case 通所リハビリテーション:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(9, 10);
                case 通所リハビリテーション_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(9, 10);
                case その他の医療系のサービス:
                    return oi.get医学的管理の必要性チェック().substringEmptyOnError(10);
                case その他の医療系のサービス_必要性:
                    return oi.get医学的管理の必要性下線().substringEmptyOnError(10);
                case 介護サービスの留意事項_血圧:
                    return oi.get血圧();
                case 介護サービスの留意事項_移動:
                    return oi.get移動();
                case 介護サービスの留意事項_摂食:
                    return oi.get摂食();
                case 介護サービスの留意事項_運動:
                    return oi.get運動();
                case 介護サービスの留意事項_嚥下:
                    return oi.get嚥下();
                case 感染症の有無:
                    return oi.get感染症();
                default:
                    return RString.EMPTY;
            }
        }

        private static RString to記載なし(RString value) {
            return OCR_記載なし.equals(value) ? DB_記載なし : value;
        }

        private static final RString OCR_記載なし = new RString("0");
        private static final RString DB_記載なし = new RString("9");
    }
}
