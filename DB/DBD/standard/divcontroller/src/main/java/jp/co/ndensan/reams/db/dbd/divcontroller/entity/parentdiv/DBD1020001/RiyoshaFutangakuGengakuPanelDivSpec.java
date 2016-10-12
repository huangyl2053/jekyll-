/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 利用者負担額減額申請バリデーションクラスです。
 *
 * @reamsid_L DBD-3660-010 xuyue
 */
public enum RiyoshaFutangakuGengakuPanelDivSpec implements IPredicate<RiyoshaFutangakuGengakuPanelDiv> {

    申請日の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtShinseiYmd().getValue() != null && !div.getTxtShinseiYmd().getValue().isEmpty() && div.getTxtShinseiYmd().getValue().isValid();
                }
            },
    決定区分の非空チェック {
                /**
                 * 決定区分の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:決定区分が非空です、false:決定区分が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getRadKetteiKubun().getSelectedKey() != null;
                }
            },
    決定日の非空チェック {
                /**
                 * 決定日の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:決定日が非空です、false:決定日が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtKettaiYmd().getValue() != null && !div.getTxtKettaiYmd().getValue().isEmpty() && div.getTxtKettaiYmd().getValue().isValid();
                }
            },
    適用日の非空チェック {
                /**
                 * 適用日の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:適用日が非空です、false:適用日が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtTekiyoYmd().getValue() != null && !div.getTxtTekiyoYmd().getValue().isEmpty() && div.getTxtTekiyoYmd().getValue().isValid();
                }
            },
    有効期限の非空チェック {
                /**
                 * 有効期限の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:有効期限が非空です、false:有効期限が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtYukoKigenYmd().getValue() != null && !div.getTxtYukoKigenYmd().getValue().isEmpty() && div.getTxtYukoKigenYmd().getValue().isValid();
                }
            },
    給付率の非空チェック {
                /**
                 * 給付率の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:給付率が非空です、false:給付率が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtKyufuRitsu().getValue() != null;
                }
            },
    減免減額_給付率範囲外のチェック {
                /**
                 * 減免減額_給付率範囲外のチェック。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:減免減額_給付率範囲外ではないです、false:減免減額_給付率範囲外です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    Decimal 給付率_81 = new Decimal(81);
                    Decimal 給付率_91 = new Decimal(91);
                    Decimal 給付率_100 = new Decimal(100);

                    HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getCcdKaigoKihon().get被保険者番号());
                    RiyoshaFutangakuGengakuService service = RiyoshaFutangakuGengakuService.createInstance();

                    FutanwariaiKubun 負担割合区分 = service.get利用者負担割合(被保険者番号, div.getTxtShinseiYmd().getValue());
                    Decimal 給付率 = Decimal.ZERO;
                    if (div.getTxtKyufuRitsu() != null && div.getTxtKyufuRitsu().getValue() != null) {
                        給付率 = div.getTxtKyufuRitsu().getValue();
                    }
                    if ((FutanwariaiKubun._２割.getコード().equals(負担割合区分.getコード())
                    && (給付率.compareTo(給付率_81) < 0 || 給付率.compareTo(給付率_100) > 0))
                    || (FutanwariaiKubun._１割.getコード().equals(負担割合区分.getコード())
                    && (給付率.compareTo(給付率_91) < 0 || 給付率.compareTo(給付率_100) > 0))) {
                        return false;
                    }
                    return true;
                }
            },
    利用者負担額減額_適用開始日が法施行以前のチェック {
                /**
                 * 利用者負担額減額_適用開始日が法施行以前のチェック。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return
                 * true:利用者負担額減額_適用開始日が法施行以前ではないです、false:利用者負担額減額_適用開始日が法施行以前です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    FlexibleDate 適用日 = div.getTxtTekiyoYmd().getValue();
                    RString 法施行日 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                    if (!new FlexibleDate(法施行日).isBeforeOrEquals(適用日)) {
                        return false;
                    }
                    return true;
                }
            },
    利用者負担額減額_適用終了日が年度外のチェック {
                /**
                 * 利用者負担額減額_適用終了日が年度外のチェック。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return
                 * true:利用者負担額減額_適用終了日が年度外ではないです、false:利用者負担額減額_適用終了日が年度外です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    RiyoshaFutangakuGengakuService service = RiyoshaFutangakuGengakuService.createInstance();

                    FlexibleDate 適用日 = div.getTxtTekiyoYmd().getValue();
                    FlexibleDate 標準有効期限 = service.estimate有効期限(適用日);
                    FlexibleDate 有効期限 = div.getTxtYukoKigenYmd().getValue();
                    if (標準有効期限.isBefore(有効期限)) {
                        return false;
                    }
                    return true;
                }
            },
    利用者負担額減額_適用終了日が開始日以前のチェック {
                /**
                 * 利用者負担額減額_適用終了日が開始日以前のチェック。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return
                 * true:利用者負担額減額_適用終了日が開始日以前ではないです、false:利用者負担額減額_適用終了日が開始日以前です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {

                    FlexibleDate 適用日 = div.getTxtTekiyoYmd().getValue();
                    FlexibleDate 有効期限 = div.getTxtYukoKigenYmd().getValue();

                    if (!適用日.isBeforeOrEquals(有効期限)) {
                        return false;
                    }
                    return true;
                }
            },
    受給共通_受給者登録なしのチェック {
                /**
                 * 受給共通_受給者登録なしのチェック。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:受給共通_受給者登録なしではないです、false:受給共通_受給者登録なしです。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    RiyoshaFutangakuGengakuService service = RiyoshaFutangakuGengakuService.createInstance();

                    HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getCcdKaigoKihon().get被保険者番号());
                    FlexibleDate 適用日 = div.getTxtTekiyoYmd().getValue();

                    boolean 利用者 = service.canBe利用者(被保険者番号, 適用日);
                    if (!利用者) {
                        return false;
                    }
                    return true;
                }
            },
    適用期間重複なしのチェック {
                /**
                 * 適用期間重複なしのチェック。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:適用期間重複なし、false:適用期間重複あり。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    RString 削除 = new RString("削除");

                    List<ddlShinseiIchiran_Row> list = div.getDdlShinseiIchiran().getDataSource();
                    if (list == null || list.isEmpty()) {
                        return true;
                    }
                    FlexibleDate 適用日１;
                    FlexibleDate 適用日２;
                    FlexibleDate 有効期限１;
                    FlexibleDate 有効期限２;
                    ddlShinseiIchiran_Row row1;
                    ddlShinseiIchiran_Row row2;
                    for (int i = 0, size = list.size(); i < size - 1; i++) {
                        row1 = list.get(i);
                        適用日１ = row1.getTxtTekiyoYMD().getValue();
                        有効期限１ = row1.getTxtYukoKigen().getValue();
                        if (削除.equals(row1.getJotai()) || 適用日１ == null || 適用日１.isEmpty() || 有効期限１ == null || 有効期限１.isEmpty() || row1.getKetteiKubun().equals(KetteiKubun.承認しない.get名称())) {
                            continue;
                        }
                        for (int j = i + 1; j < size; j++) {
                            row2 = list.get(j);
                            適用日２ = row2.getTxtTekiyoYMD().getValue();
                            有効期限２ = row2.getTxtYukoKigen().getValue();
                            if (削除.equals(row2.getJotai()) || 適用日２ == null || 適用日２.isEmpty() || 有効期限２ == null || 有効期限２.isEmpty() || row2.getKetteiKubun().equals(KetteiKubun.承認しない.get名称())) {
                                continue;
                            }
                            if (適用日２.isBeforeOrEquals(適用日１) && 有効期限１.isBeforeOrEquals(有効期限２)
                            || 適用日１.isBeforeOrEquals(適用日２) && 有効期限２.isBeforeOrEquals(有効期限１)
                            || (適用日２.isBeforeOrEquals(適用日１) && 適用日１.isBeforeOrEquals(有効期限２))
                            || (適用日２.isBeforeOrEquals(有効期限１) && 有効期限１.isBeforeOrEquals(有効期限２))) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
}
