/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.homonkaigogemmen.HomonKaigoRiryoshaFutangakuGengakuService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 訪問介護利用者負担額減額申請バリデーションクラスです。
 *
 * @reamsid_L DBD-3730-010 wangjie2
 */
public enum HomonKaigoRiyoshaFutanGengakuSpec implements IPredicate<HomonKaigoRiyoshaFutanGengakuMainDiv> {

    申請日の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return div.getTxtShinseiYMD().getValue() != null
                    && !div.getTxtShinseiYMD().getValue().isEmpty();
                }
            },
    決定区分の非空チェック {
                /**
                 * 決定区分の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:決定区分が非空です、false:決定区分が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return div.getDdlKettaiKubun().getSelectedKey() != null
                    && !div.getDdlKettaiKubun().getSelectedKey().isEmpty();
                }
            },
    決定日の非空チェック {
                /**
                 * 決定日の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:決定日が非空です、false:決定日が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return div.getTxtKettaiYmd().getValue() != null
                    && !div.getTxtKettaiYmd().getValue().isEmpty();
                }
            },
    適用日の非空チェック {
                /**
                 * 適用日の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:適用日が非空です、false:適用日が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return div.getTxtTekiyoYmd().getValue() != null
                    && !div.getTxtTekiyoYmd().getValue().isEmpty();
                }
            },
    有効期限の非空チェック {
                /**
                 * 有効期限の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:有効期限が非空です、false:有効期限が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return div.getTxtYukoKigen().getValue() != null
                    && !div.getTxtYukoKigen().getValue().isEmpty();
                }
            },
    給付率の非空チェック {
                /**
                 * 給付率の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:給付率が非空です、false:給付率が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return div.getTxtKyufuRitsu().getValue() != null;
                }
            },
    公費受給者番号の非空チェック {
                /**
                 * 公費受給者番号の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:公費受給者番号が非空です、false:公費受給者番号が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return div.getTxtKohiJyukyshaNo().getText() != null
                    && !div.getTxtKohiJyukyshaNo().getText().isEmpty();
                }
            },
    法別区分の非空チェック {
                /**
                 * 法別区分の非空チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:法別区分が非空です、false:法別区分が空です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    return !div.getDdlHobetsuKubun().getSelectedKey().isEmpty();
                }
            },
    訪問介護利用者負担額減額_給付率範囲外チェック {
                /**
                 * 訪問介護利用者負担額減額_給付率範囲外チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:給付率が91～100の範囲外内です、false:給付率が91～100の範囲外です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    Decimal 給付率 = div.getTxtKyufuRitsu().getValue();
                    if (null == 給付率) {
                        return true;
                    }
                    return 給付率.compareTo(new Decimal("100")) <= 0
                    && 給付率.compareTo(new Decimal("91")) >= 0;
                }
            },
    訪問介護利用者負担額減額_適用開始日が法施行以前チェック {
                /**
                 * 訪問介護利用者負担額減額_適用開始日が法施行以前チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:適用開始日>=法施行日です、false:適用開始日＜法施行日です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYmd().getValue();
                    if (null == 適用開始日 || 適用開始日.isEmpty()) {
                        return true;
                    }
                    FlexibleDate 法施工日 = new FlexibleDate(DbBusinessConfig
                            .get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
                    return 法施工日.isEmpty() || !適用開始日.isBefore(法施工日);
                }
            },
    訪問介護利用者負担額減額_適用終了日が年度外チェック {
                /**
                 * 訪問介護利用者負担額減額_適用終了日が年度外チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:標準有効期限>=有効期限です、false:標準有効期限＜有効期限です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYmd().getValue();
                    HomonKaigoRiryoshaFutangakuGengakuService service = HomonKaigoRiryoshaFutangakuGengakuService.createIntance();
                    FlexibleDate 標準有効期限 = service.estimate有効期限(適用開始日);
                    FlexibleDate 有効期限 = div.getTxtYukoKigen().getValue();
                    return 標準有効期限.isEmpty() || !標準有効期限.isBefore(有効期限);
                }
            },
    訪問介護利用者負担額減額_適用終了日が開始日以前チェック {
                /**
                 * 訪問介護利用者負担額減額_適用終了日が開始日以前チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:有効期限>=適用日です、false:有効期限＜適用日です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYmd().getValue();
                    FlexibleDate 有効期限 = div.getTxtYukoKigen().getValue();
                    if (null == 適用開始日 || 適用開始日.isEmpty()
                    || null == 有効期限 || 有効期限.isEmpty()) {
                        return true;
                    }
                    return !有効期限.isBefore(適用開始日);
                }
            },
    受給共通_受給者登録なしチェック {
                /**
                 * 受給共通_受給者登録なしチェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:有効期限>=適用日です、false:有効期限＜適用日です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    FlexibleDate 適用日 = div.getTxtTekiyoYmd().getValue();
                    if (null == 適用日 || 適用日.isEmpty()) {
                        return true;
                    }
                    return HomonKaigoRiryoshaFutangakuGengakuService.createIntance()
                    .canBe利用者(new HihokenshaNo(div.getHomonKaigoRiyoshaFutanGengaku().getHihokenshaNo()), 適用日);
                }
            },
    減免減額_適用期間重複チェック {
                /**
                 * 減免減額_適用期間重複チェックです。
                 *
                 * @param div 訪問介護利用者負担額減額申請Div
                 * @return true:減免減額_適用期間重複です、false:減免減額_適用期間重複です。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
                    List<dgShinseiList_Row> rows = div.getDgShinseiList().getDataSource();
                    List<dgShinseiList_Row> checkRows = new ArrayList<>();
                    for (dgShinseiList_Row row : rows) {
                        if (!new RString("削除").equals(row.getJotai())
                        && new RString("承認する").equals(row.getKetteiKubun())) {
                            checkRows.add(row);
                        }
                    }
                    int length = checkRows.size();
                    if (length < 2) {
                        return true;
                    }
                    for (int index = 0; index <= length - 2; index++) {
                        int index2 = index + 1;
                        while (index2 <= length - 1) {
                            dgShinseiList_Row row1 = checkRows.get(index);
                            dgShinseiList_Row row2 = checkRows.get(index2);
                            if (!row1.getTxtYukoKigen().getValue()
                            .isBeforeOrEquals(row2.getTxtTekiyoYMD().getValue())
                            && !row2.getTxtYukoKigen().getValue()
                            .isBeforeOrEquals(row1.getTxtTekiyoYMD().getValue())) {
                                return false;
                            }
                            index2++;
                        }
                    }
                    return true;
                }
            }

}
