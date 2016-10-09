/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2200011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011.ShichosonTokubetuKyufuServiceTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011.dgServiceNaiyo_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBC2200011_市町村特別給付サービス内容登録のチェックロジックです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public enum ShichosonTokubetuKyufuServiceTourokuSpec implements IPredicate<ShichosonTokubetuKyufuServiceTourokuDiv> {

    /**
     * 非直近データを選択チェック
     */
    非直近データを選択チェック {
                @Override
                public boolean apply(ShichosonTokubetuKyufuServiceTourokuDiv div) {
                    if (CommonButtonHolder.isDisplayNone(追加やめる)) {
                        dgServiceNaiyo_Row row = div.getDgServiceNaiyo().getActiveRow();
                        return row.getChokkinFlag().equals(直近フラグ);
                    }
                    return true;
                }
            },
    /**
     * 有効開始日と有効終了日の前後関係のチェック
     */
    有効開始日と有効終了日の前後関係のチェック {
                @Override
                public boolean apply(ShichosonTokubetuKyufuServiceTourokuDiv div) {
                    RDate 有効期間開始年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue();
                    RDate 有効期間終了年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue();
                    return 有効期間終了年月日 == null || 有効期間終了年月日.isBeforeOrEquals(有効期間開始年月日);
                }
            },
    /**
     * 有効開始日が前回の有効開始日以前の日付のチェック
     */
    有効開始日が前回の有効開始日以前の日付のチェック {
                @Override
                public boolean apply(ShichosonTokubetuKyufuServiceTourokuDiv div) {
                    if (CommonButtonHolder.isDisplayNone(追加やめる)) {
                        return true;
                    }
                    RDate 有効期間開始年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue();
                    dgServiceNaiyo_Row 直近データ = null;
                    for (dgServiceNaiyo_Row row : div.getDgServiceNaiyo().getDataSource()) {
                        if (row.getChokkinFlag().equals(直近フラグ)) {
                            直近データ = row;
                            break;
                        }
                    }
                    if (直近データ != null && 直近データ.getServiceYukoKikanShuryoYMD().isNullOrEmpty()) {
                        return 直近データ.getServiceYukoKikanKaishiYMDSeireki().getValue().isBeforeOrEquals(有効期間開始年月日);
                    }
                    return true;
                }
            },
    /**
     * 有効開始日が前回の有効終了日以前の日付のチェック
     */
    有効開始日が前回の有効終了日以前の日付のチェック {
                @Override
                public boolean apply(ShichosonTokubetuKyufuServiceTourokuDiv div) {
                    if (CommonButtonHolder.isDisplayNone(追加やめる)) {
                        return true;
                    }
                    RDate 有効期間開始年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue();
                    dgServiceNaiyo_Row 直近データ = null;
                    for (dgServiceNaiyo_Row row : div.getDgServiceNaiyo().getDataSource()) {
                        if (row.getChokkinFlag().equals(直近フラグ)) {
                            直近データ = row;
                            break;
                        }
                    }
                    if (直近データ != null && !直近データ.getServiceYukoKikanShuryoYMD().isNullOrEmpty()) {
                        return !直近データ.getServiceYukoKikanShuryoYMDSeireki().getValue().isBeforeOrEquals(有効期間開始年月日);
                    }
                    return true;
                }
            },
    /**
     * 名称入力内容チェック
     */
    名称入力内容チェック {
                @Override
                public boolean apply(ShichosonTokubetuKyufuServiceTourokuDiv div) {
                    if (!CommonButtonHolder.isDisplayNone(削除やめる)) {
                        return true;
                    }
                    RString 名称 = div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue();
                    return RStringUtil.is全角Only(名称);
                }
            },
    /**
     * 略称入力内容チェック
     */
    略称入力内容チェック {
                @Override
                public boolean apply(ShichosonTokubetuKyufuServiceTourokuDiv div) {
                    if (!CommonButtonHolder.isDisplayNone(削除やめる)) {
                        return true;
                    }
                    RString 略称 = div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue();
                    return RStringUtil.is全角Only(略称);
                }
            };

    private static final RString 追加やめる = new RString("btnTsuikaCancel");
    private static final RString 直近フラグ = new RString("1");
    private static final RString 削除やめる = new RString("btnSaikujoCancel");
}
