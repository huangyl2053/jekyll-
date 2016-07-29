/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1731011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui.SogojigyoShuruiSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * {@link SogojigyoShuruiShikyuGendogakuDiv}の仕様クラスです。 <br>
 * {@link SogojigyoShuruiShikyuGendogakuDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public enum SogojigyoShuruiShikyuGendogakuSpec implements IPredicate<SogojigyoShuruiShikyuGendogakuDiv> {

    /**
     * 各必須入力項目未入力の場合です。
     */
    各必須入力項目未入力の場合 {
                @Override
                public boolean apply(SogojigyoShuruiShikyuGendogakuDiv div) {
                    return SpecHelper.is各必須入力項目未入力(div);
                }
            },
    /**
     * 適用期間重複入力の場合です。
     */
    適用期間重複入力の場合 {
                @Override
                public boolean apply(SogojigyoShuruiShikyuGendogakuDiv div) {
                    return SpecHelper.is適用期間重複入力(div);
                }
            },
    /**
     * 適用期間大小関係不正の場合です。
     */
    適用期間大小関係不正の場合 {
                @Override
                public boolean apply(SogojigyoShuruiShikyuGendogakuDiv div) {
                    return SpecHelper.is適用期間大小関係不正(div);
                }
            };

    /**
     * {@link SogojigyoShuruiShikyuGendogakuSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final RString 登録 = new RString("登録モード");
        private static final int INT_1 = 1;

        /**
         * *が各項目が未入力の場合、エラーとします。
         *
         * @param div SogojigyoShuruiShikyuGendogakuDiv
         */
        public static boolean is各必須入力項目未入力(SogojigyoShuruiShikyuGendogakuDiv div) {

            return !(div.getTxtTekiyoKaishiYM().getText().isNullOrEmpty()
                    || div.getDdlServiceShurui().getSelectedKey().isNullOrEmpty()
                    || div.getTxtYoShien1().getText().isNullOrEmpty()
                    || div.getTxtYoShien2().getText().isNullOrEmpty()
                    || div.getTxtNijiYobo().getText().isNullOrEmpty());
        }

        /**
         * 適用期間が一部でも重複する場合はエラーとします。
         *
         * @param div SogojigyoShuruiShikyuGendogakuDiv
         */
        public static boolean is適用期間重複入力(SogojigyoShuruiShikyuGendogakuDiv div) {

            RString 保存モード = ViewStateHolder.get(ViewStateKeys.保存モード, RString.class);
            List<SogojigyoShuruiSearchResult> 総合事業種類情報 = ViewStateHolder.get(ViewStateKeys.総合事業種類情報, List.class);
            ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(div.getDdlServiceShurui().getSelectedKey());
            List<SogojigyoShuruiSearchResult> 総合事業種類情報登録用 = new ArrayList<>();
            for (SogojigyoShuruiSearchResult result : 総合事業種類情報) {
                if (サービス種類コード.equals(result.get要支援1().getサービス種類コード())) {
                    総合事業種類情報登録用.add(result);
                }
            }
            if (登録.equals(保存モード) && !総合事業種類情報登録用.isEmpty()
                    && !div.getTxtTekiyoKaishiYM().getText().isNullOrEmpty()) {
                FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getValue().getYearMonth()
                        .toDateString());
                SogojigyoShuruiSearchResult firstEntity = 総合事業種類情報登録用.get(0);
                SogojigyoShuruiSearchResult lastEntity = 総合事業種類情報登録用.get(総合事業種類情報登録用.size() - INT_1);
                return !(適用開始年月.isBeforeOrEquals(firstEntity.get要支援1().get適用開始年月())
                        && lastEntity.get要支援1().get適用開始年月().isBeforeOrEquals(適用開始年月));
            }
            return Boolean.TRUE;
        }

        /**
         * 適用終了の入力がある時、適用開始≦適用終了になっていない場合はエラーします。
         *
         * @param div SogoJigyoKubunShikyuGendogakuDiv
         */
        public static boolean is適用期間大小関係不正(SogojigyoShuruiShikyuGendogakuDiv div) {

            if (!div.getTxtTekiyoShuryoYM().getText().isNullOrEmpty()) {
                return !(div.getTxtTekiyoShuryoYM().getValue().isBefore(div.getTxtTekiyoKaishiYM().getValue()));
            }
            return Boolean.TRUE;
        }

    }

}
