/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutangendogakuNinteiService;
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
 *
 * 負担限度額認定申請画面ハンドラクラスです。
 *
 * @reamsid_L DBD-3590-010 huangh
 */
public enum FutangendogakuShinseiDivSpec implements IPredicate<FutangendogakuShinseiDiv> {

    受給共通_受給者登録なし {
                /**
                 * 受給共通_受給者登録なしチェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:受給者登録ありの場合です、false:受給者登録なしの場合です。
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {
                    return FutangendogakuNinteiService.createInstance().canBe利用者(
                            new HihokenshaNo(div.getHihokenshaNo()), div.getTxtTekiyoYMD().getValue());
                }
            },
    負担限度額認定_適用開始日が法施行以前 {
                /**
                 * 負担限度額認定_適用開始日が法施行以前チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return
                 * true:負担限度額認定_適用開始日が法施行以後の場合です、false:負担限度額認定_適用開始日が法施行以前の場合です。
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {
                    FlexibleDate 法施行日 = new FlexibleDate(
                            DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
                    if (法施行日.isEmpty() || 適用開始日 == null || 適用開始日.isEmpty()) {
                        return false;
                    }
                    return 法施行日.isBeforeOrEquals(適用開始日);
                }
            },
    負担限度額認定_適用終了日が年度外 {
                /**
                 * 負担限度額認定_適用終了日が年度外チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return
                 * true:負担限度額認定_適用終了日が年度内の場合です、false:負担限度額認定_適用終了日が年度外の場合です。
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {
                    FlexibleDate 標準有効期限 = FutangendogakuNinteiService.createInstance().estimate有効期限(div.getTxtTekiyoYMD().getValue());
                    FlexibleDate 有効期限 = div.getTxtYukoKigenYMD().getValue();
                    if (標準有効期限.isEmpty() || 有効期限 == null || 有効期限.isEmpty()) {
                        return false;
                    }
                    return 有効期限.isBeforeOrEquals(標準有効期限);
                }
            },
    負担限度額認定_適用終了日が開始日以前 {
                /**
                 * 負担限度額認定_適用終了日が開始日以前チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return
                 * true:負担限度額認定_適用終了日が開始日以後です、false:負担限度額認定_適用終了日が開始日以前です。
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {
                    FlexibleDate 適用日 = div.getTxtTekiyoYMD().getValue();
                    FlexibleDate 有効期限 = div.getTxtYukoKigenYMD().getValue();
                    if (適用日 == null || 適用日.isEmpty() || 有効期限 == null || 有効期限.isEmpty()) {
                        return false;
                    }
                    return 適用日.isBeforeOrEquals(有効期限);
                }
            },
    預貯金_1000万以下_Or_2000万以下 {
                /**
                 * 預貯金チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:配偶者「無」のとき預貯金合計が1001万円以上（配偶者「有」のとき2001万円以上）
                 * false:配偶者「無」のとき預貯金合計が1000万円以下（配偶者「有」のとき2000万円以下）
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {

                    RString SELECT_KEY1 = new RString("key1");
                    Decimal 預貯金_配偶者_無 = new Decimal(10000000);
                    Decimal 預貯金_配偶者_有 = new Decimal(20000000);

                    if (div.getTxtYochokinGaku().getText().isEmpty()
                    && div.getTxtYukaShoken().getText().isEmpty()
                    && div.getTxtSonota().getText().isEmpty()) {
                        return true;
                    } else {
                        if (div.getTxtYochokinGaku().getText().isEmpty()) {
                            div.getTxtYochokinGaku().setValue(Decimal.ZERO);
                        }
                        if (div.getTxtYukaShoken().getText().isEmpty()) {
                            div.getTxtYukaShoken().setValue(Decimal.ZERO);
                        }
                        if (div.getTxtSonota().getText().isEmpty()) {
                            div.getTxtSonota().setValue(Decimal.ZERO);
                        }
                    }

                    if (SELECT_KEY1.equals(div.getRadHaigushaUmu().getSelectedKey())) {
                        if (預貯金_配偶者_無.compareTo(div.getTxtYochokinGaku().getValue().add(div.getTxtYukaShoken().getValue()).add(div.getTxtSonota().getValue())) >= 0
                        && !div.getChkYochokinKijunIka().isAllSelected()) {
                            return false;
                        }
                    } else {
                        if (預貯金_配偶者_有.compareTo(div.getTxtYochokinGaku().getValue().add(div.getTxtYukaShoken().getValue()).add(div.getTxtSonota().getValue())) >= 0
                        && !div.getChkYochokinKijunIka().isAllSelected()) {
                            return false;
                        }
                    }
                    return true;
                }
            },
    減免減額_適用期間重複 {
                /**
                 * 減免減額_適用期間重複チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:減免減額_適用期間重複しない、false:減免減額_適用期間重複します。
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {
                    RString 削除 = new RString("削除");

                    List<dgShinseiList_Row> list = div.getDgShinseiList().getDataSource();
                    if (list == null || list.isEmpty()) {
                        return true;
                    }
                    FlexibleDate 適用日１;
                    FlexibleDate 適用日２;
                    FlexibleDate 有効期限１;
                    FlexibleDate 有効期限２;
                    dgShinseiList_Row row1;
                    dgShinseiList_Row row2;
                    for (int i = 0, size = list.size(); i < size - 1; i++) {
                        row1 = list.get(i);
                        適用日１ = row1.getTxtTekiyoYMD().getValue();
                        有効期限１ = row1.getTxtYukoKigenYMD().getValue();
                        if (削除.equals(row1.getJotai()) || 適用日１ == null || 適用日１.isEmpty() || 有効期限１ == null || 有効期限１.isEmpty() || row1.getKetteiKubun().equals(KetteiKubun.承認しない.get名称())) {
                            continue;
                        }
                        for (int j = i + 1; j < size; j++) {
                            row2 = list.get(j);
                            適用日２ = row2.getTxtTekiyoYMD().getValue();
                            有効期限２ = row2.getTxtYukoKigenYMD().getValue();
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

            };

}
