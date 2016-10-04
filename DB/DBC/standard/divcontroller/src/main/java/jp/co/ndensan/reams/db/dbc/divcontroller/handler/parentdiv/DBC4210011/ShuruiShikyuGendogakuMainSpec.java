/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBC4210011_種類支給限度額登録のバリデーションです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public enum ShuruiShikyuGendogakuMainSpec implements IPredicate<ShuruiShikyuGendogakuMainDiv> {

    /**
     * 標準適用開始年月の非空チェックです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return Boolean
     */
    標準適用開始年月チェック {
                @Override
                public boolean apply(ShuruiShikyuGendogakuMainDiv div) {
                    int i = 0;
                    for (dgShikyuGendogaku_Row row : div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getDataSource()) {
                        if (row.getServiceShuruiCode().equals(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey())
                        && row.getTekiyoShuryoYM().getValue() == null && !(row.getTekiyoKaishiYM().getValue().isBeforeOrEquals(
                                div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue()))) {
                            i++;
                        }
                    }
                    return i == 0;
                }
            },
    /**
     * サービス提供期間のチェックです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return Boolean
     */
    サービス提供期間チェック {
                @Override
                public boolean apply(ShuruiShikyuGendogakuMainDiv div) {
                    FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                            div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
                    List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                            new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
                    if (!result.isEmpty() && result.get(0).getDbT7130entity().getTeikyoshuryoYM() != null) {
                        return (!result.isEmpty() && result.get(0).getDbT7130entity() != null
                        && 適用期間From.isBefore(result.get(0).getDbT7130entity().getTeikyoshuryoYM()));
                    }
                    if (result.isEmpty()) {
                        return false;
                    }
                    return true;
                }
            },
    /**
     * 種類支給限度額認定対象のチェックです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return Boolean
     */
    種類支給限度額認定対象チェック {
                @Override
                public boolean apply(ShuruiShikyuGendogakuMainDiv div) {
                    FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                            div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
                    List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                            new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
                    if (result.isEmpty()) {
                        return true;
                    } else {
                        return (result.get(0).getDbT7130entity() != null
                        && result.get(0).getDbT7130entity().getGendogakuKubun().equals(new RString("1")));
                    }
                }
            },
    /**
     * 要支援1入力チェック警告のチェックです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return Boolean
     */
    要支援1入力チェック警告 {
                @Override
                public boolean apply(ShuruiShikyuGendogakuMainDiv div) {
                    return SpecHelper.is要支援1入力チェック警告(div);
                }
            },
    /**
     * 要支援1入力チェックエラーのチェックです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return Boolean
     */
    要支援1入力チェックエラー {
                @Override
                public boolean apply(ShuruiShikyuGendogakuMainDiv div) {
                    FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                            div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
                    List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                            new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
                    if (!result.isEmpty() && new RString("0").equals(result.get(0).getDbT7130entity().getShien1InKahiKubun())) {
                        return (result.get(0).getDbT7130entity() != null
                        && (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() == null
                        || (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue().compareTo(Decimal.ZERO) == 0)));
                    } else if (result.isEmpty()) {
                        return true;
                    }
                    return true;
                }
            },
    /**
     * 要支援2入力チェック警告のチェックです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return Boolean
     */
    要支援2入力チェック警告 {
                @Override
                public boolean apply(ShuruiShikyuGendogakuMainDiv div) {
                    FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                            div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
                    List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                            new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
                    if (!result.isEmpty() && (new RString("1")).equals(result.get(0).getDbT7130entity().getShien2InKahiKubun())) {
                        return (result.get(0).getDbT7130entity() != null
                        && !(div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue() == null
                        || (div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue().compareTo(Decimal.ZERO) == 0)));
                    } else if (result.isEmpty()) {
                        return true;
                    }
                    return true;
                }
            },
    /**
     * 要支援2入力チェックエラーのチェックです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return Boolean
     */
    要支援2入力チェックエラー {
                @Override
                public boolean apply(ShuruiShikyuGendogakuMainDiv div
                ) {
                    FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                            div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
                    List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                            new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
                    if (!result.isEmpty() && (new RString("0")).equals(result.get(0).getDbT7130entity().getShien2InKahiKubun())) {
                        return (result.get(0).getDbT7130entity() != null
                        && (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() == null
                        || (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue().compareTo(Decimal.ZERO) == 0)));
                    } else if (result.isEmpty()) {
                        return true;
                    }
                    return true;
                }
            };

    private static class SpecHelper {

        public static boolean is要支援1入力チェック警告(ShuruiShikyuGendogakuMainDiv div) {
            FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                    div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
            List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                    new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
            if (!result.isEmpty() && (new RString("1")).equals(result.get(0).getDbT7130entity().getShien1InKahiKubun())) {
                return (result.get(0).getDbT7130entity() != null
                        && !(div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() == null
                        || (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue().compareTo(Decimal.ZERO) == 0)));
            } else if (result.isEmpty()) {
                return true;
            }
            return true;
        }
    }
}
