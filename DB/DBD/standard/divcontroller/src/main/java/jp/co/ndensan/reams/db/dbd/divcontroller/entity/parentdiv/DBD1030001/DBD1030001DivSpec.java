/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 社会福祉法人等利用者負担軽減申請バリデーションクラスです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public enum DBD1030001DivSpec implements IPredicate<DBD1030001Div> {

    申請日の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtShinseiYMD().getValue() != null && !div.getTxtShinseiYMD().getValue().isEmpty();
                }
            },
    軽減事由の非空チェック {
                /**
                 * 軽減事由の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:軽減事由が非空です、false:軽減事由が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getDdlKeigenJiyu().getSelectedValue() != null && !div.getDdlKeigenJiyu().getSelectedValue().isEmpty();
                }
            },
    確認番号の非空チェック {
                /**
                 * 確認番号の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:確認番号が非空です、false:確認番号が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtKakuninNo().getValue() != null && !div.getTxtKakuninNo().getValue().isEmpty();
                }
            },
    決定区分の非空チェック {
                /**
                 * 決定区分の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:決定区分が非空です、false:決定区分が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getRadKetteiKubun().getSelectedKey() != null && !div.getRadKetteiKubun().getSelectedKey().isEmpty();
                }
            },
    決定日の非空チェック {
                /**
                 * 決定日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:決定日が非空です、false:決定日が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtKetteiYMD().getValue() != null && !div.getTxtKetteiYMD().getValue().isEmpty();
                }
            },
    適用日の非空チェック {
                /**
                 * 適用日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:適用日が非空です、false:適用日が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtTekiyoYMD().getValue() != null && !div.getTxtTekiyoYMD().getValue().isEmpty();
                }
            },
    有効期限の非空チェック {
                /**
                 * 有効期限の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:有効期限が非空です、false:有効期限が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtYukoKigenYMD().getValue() != null && !div.getTxtYukoKigenYMD().getValue().isEmpty();
                }
            },
    軽減率_分子の非空チェック {
                /**
                 * 有効期限の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:有効期限が非空です、false:有効期限が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtKeigenRitsuBunshi().getValue() != null;
                }
            },
    軽減率_分母の非空チェック {
                /**
                 * 有効期限の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:有効期限が非空です、false:有効期限が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtKeigenRitsuBunbo().getValue() != null;
                }
            },
    減免減額_適用日が法施行前のチェック {
                /**
                 * 減免減額_適用日が法施行前のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not減免減額_適用日が法施行前です、false:減免減額_適用日が法施行前です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
                    FlexibleDate 法施工日 = new FlexibleDate(DbBusinessConfig
                            .get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
                    return 法施工日.isEmpty() || !適用開始日.isBefore(法施工日);
                }
            },
    減免減額_有効期限が年度外のチェック {
                /**
                 * 減免減額_有効期限が年度外のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not減免減額_有効期限が年度外です、false:減免減額_有効期限が年度外です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
                    ShakaiFukushiHojinKeigenService service = ShakaiFukushiHojinKeigenService.createIntance();
                    FlexibleDate 標準有効期限 = service.estimate有効期限(適用開始日);
                    FlexibleDate 有効期限 = div.getTxtYukoKigenYMD().getValue();
                    return !標準有効期限.isEmpty() && !標準有効期限.isBefore(有効期限);
                }
            },
    減免減額_有効期限が適用日以前のチェック {
                /**
                 * 減免減額_有効期限が適用日以前のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not減免減額_有効期限が適用日以前です、false:減免減額_有効期限が適用日以前です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
                    FlexibleDate 有効期限 = div.getTxtYukoKigenYMD().getValue();
                    return !有効期限.isBefore(適用開始日);
                }
            },
    社会福祉法人減免_減免率_分子が分母より大のチェック {
                /**
                 * 社会福祉法人減免_減免率_分子が分母より大のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_減免率_分子が分母より大です、false:社会福祉法人減免_減免率_分子が分母より大です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
                    Decimal 減免率_分母 = div.getTxtKeigenRitsuBunbo().getValue();
                    return 減免率_分子.compareTo(減免率_分母) <= 0;
                }
            },
    社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択のチェック {
                /**
                 * 社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return 社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択なし
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    List<RString> 居宅サービス限定SelectKeys = div.getChkKyotakuServiceGentei().getSelectedKeys();
                    List<RString> 旧措置ユニット型個室SelectKeys = div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys();
                    return 居宅サービス限定SelectKeys.isEmpty() || 旧措置ユニット型個室SelectKeys.isEmpty();
                }
            },
    受給共通_受給者_事業対象者登録なしのチェック {
                /**
                 * 受給共通_受給者_事業対象者登録なしのチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not受給共通_受給者_事業対象者登録なしです、false:受給共通_受給者_事業対象者登録なしです。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
                    ShakaiFukushiHojinKeigenService service = ShakaiFukushiHojinKeigenService.createIntance();
                    HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
                    if (div.getHiddenHihokenshaNo() != null) {
                        被保険者番号 = new HihokenshaNo(div.getHiddenHihokenshaNo());
                    }
                    return service.canBe利用者(被保険者番号, 適用開始日);
                }
            },
    社会福祉法人減免_減免率_分子は1桁整数のチェック {
                /**
                 * 社会福祉法人減免_減免率_分子は1桁整数のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_減免率_分子は1桁整数です、false:社会福祉法人減免_減免率_分子は1桁整数です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
                    return 減免率_分子.compareTo(Decimal.ZERO) >= 0 && 減免率_分子.compareTo(new Decimal("9")) < 0;
                }
            },
    社会福祉法人減免_減免率_分母は2桁整数のチェック {
                /**
                 * 社会福祉法人減免_減免率_分母は2桁整数のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_減免率_分母は2桁整数です、false:社会福祉法人減免_減免率_分母は2桁整数です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分母 = div.getTxtKeigenRitsuBunbo().getValue();
                    return 減免率_分母.compareTo(new Decimal("10")) >= 0 && 減免率_分母.compareTo(new Decimal("99")) <= 0;
                }
            },
    社会福祉法人減免_減免率_分子は2桁整数のチェック {
                /**
                 * 社会福祉法人減免_減免率_分子は2桁整数のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_減免率_分子は2桁整数です、false:社会福祉法人減免_減免率_分子は2桁整数です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
                    return 減免率_分子.compareTo(new Decimal("10")) >= 0 && 減免率_分子.compareTo(new Decimal("99")) <= 0;
                }
            },
    社会福祉法人減免_減免率_分母は100のチェック {
                /**
                 * 社会福祉法人減免_減免率_分母は100のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:社会福祉法人減免_減免率_分母は100です、false:not社会福祉法人減免_減免率_分母は100です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分母 = div.getTxtKeigenRitsuBunbo().getValue();
                    return 減免率_分母.compareTo(new Decimal("100")) == 0;
                }
            },
    社会福祉法人減免_減免率_分子は1から99の範囲のチェック {
                /**
                 * 社会福祉法人減免_減免率_分子は1から99の範囲のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_減免率_分子は1から99の範囲です、false:社会福祉法人減免_減免率_分子は1から99の範囲です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
                    return 減免率_分子.compareTo(Decimal.ONE) >= 0 && 減免率_分子.compareTo(new Decimal("99.9")) <= 0;
                }
            },
    減免減額_適用期間重複のチェック {
                /**
                 * 減免減額_適用期間重複のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not減免減額_適用期間重複です、false:減免減額_適用期間重複です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
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
                            if (!row1.getTxtYukoKigenYMD().getValue()
                            .isBeforeOrEquals(row2.getTxtTekiyoYMD().getValue())
                            && !row2.getTxtYukoKigenYMD().getValue()
                            .isBeforeOrEquals(row1.getTxtTekiyoYMD().getValue())) {
                                return false;
                            }
                            index2++;
                        }
                    }
                    return true;
                }
            },
    減免減額_確認番号が既に存在のチェック {
                /**
                 * 減免減額_確認番号が既に存在のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not減免減額_確認番号が既に存在です、false:減免減額_確認番号が既に存在です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    List<dgShinseiList_Row> rows = div.getDgShinseiList().getDataSource();
                    for (dgShinseiList_Row row : rows) {
                        if (new RString("追加").equals(row.getJotai())
                        && new RString("承認する").equals(row.getKetteiKubun())
                        && ShakaiFukushiHojinKeigenService.createIntance()
                        .exsits確認番号In同一年度(row.getKakuninNo(), row.getTxtKetteiYMD().getValue())) {
                            return false;
                        }
                    }
                    return true;
                }
            },
    社会福祉法人減免_軽減率_特例措置期間のチェック1 {
                /**
                 * 社会福祉法人減免_軽減率_特例措置期間のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_軽減率_特例措置期間です、false:社会福祉法人減免_軽減率_特例措置期間です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
                    return 減免率_分子.compareTo(new Decimal("28.0")) == 0 || 減免率_分子.compareTo(new Decimal("53.0")) == 0;
                }
            },
    社会福祉法人減免_軽減率_特例措置期間のチェック2 {
                /**
                 * 社会福祉法人減免_軽減率_特例措置期間のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_軽減率_特例措置期間です、false:社会福祉法人減免_軽減率_特例措置期間です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
                    return 減免率_分子.compareTo(new Decimal("25.0")) == 0 || 減免率_分子.compareTo(new Decimal("50.0")) == 0;
                }
            },
    社会福祉法人減免_非生活保護者_軽減率100のチェック {
                /**
                 * 社会福祉法人減免_非生活保護者_軽減率100のチェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:not社会福祉法人減免_非生活保護者_軽減率100です、false:社会福祉法人減免_非生活保護者_軽減率100です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
                    FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
                    ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
                    if (div.getHiddenShikibetsuCode() != null) {
                        識別コード = new ShikibetsuCode(div.getHiddenShikibetsuCode());
                    }
                    return 減免率_分子.compareTo(new Decimal("100")) != 0
                    || !new FlexibleDate("20110331").isBefore(適用開始日)
                    || SeikatsuhogoManagerFactory.createInstance()
                    .get生活保護(識別コード, GyomuCode.DB介護保険, div.getTxtShinseiYMD().getValue()) != null;
                }
            }
}
