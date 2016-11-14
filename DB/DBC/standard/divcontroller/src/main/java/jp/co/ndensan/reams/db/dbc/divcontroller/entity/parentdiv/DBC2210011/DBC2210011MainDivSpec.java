/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 *
 * @author liuyl
 */
public enum DBC2210011MainDivSpec implements IPredicate<DBC2210011MainDiv> {

    特別給付サービス重複チェック {
                /**
                 * 特別給付サービス重複チェックです。
                 *
                 * @param div DBC2210011MainDiv
                 * @return boolean
                 */
                @Override
                public boolean apply(DBC2210011MainDiv div) {
                    for (dgTokubetsuKyufuJigyoshaDetailServiceList_Row row : div.getTokubetsuKyufuJigyoshaDetail().
                    getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().getDataSource()) {
                        if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedKey().equals(row.getHdnServiceCode())) {
                            return false;
                        }
                    }
                    return true;
                }
            },
    登録終了日チェック {
                /**
                 * 登録終了日チェックです。
                 *
                 * @param div DBC2210011MainDiv
                 * @return boolean
                 */
                @Override
                public boolean apply(DBC2210011MainDiv div) {
                    return div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().
                    getTxtTorokuShuryoYMD().getValue() == null || div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().getValue().
                    isAfterOrEquals(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                            getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().getValue());

                }
            },
    事業者コード重複チェック {
                /**
                 * 事業者コード重複チェックです。
                 *
                 * @param div DBC2210011MainDiv
                 * @return boolean
                 */
                @Override
                public boolean apply(DBC2210011MainDiv div) {
                    RString 情報存在 = new RString("1");
                    return !情報存在.equals(div.get事業者情報件数());
                }
            },
    サービス情報作成チェック {
                /**
                 * サービス情報作成チェックです。
                 *
                 * @param div DBC2210011MainDiv
                 * @return boolean
                 */
                @Override
                public boolean apply(DBC2210011MainDiv div) {
                    for (dgTokubetsuKyufuJigyoshaDetailServiceList_Row row : div.getTokubetsuKyufuJigyoshaDetail().
                    getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().getDataSource()) {
                        if (!RowState.Deleted.equals(row.getRowState())) {
                            return true;
                        }
                    }
                    return false;
                }
            };
}
