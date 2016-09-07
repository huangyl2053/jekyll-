/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定延期通知発行画面バリデーションクラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public enum NinteiEnkiTsuchishoHakkoDivSpec implements IPredicate<NinteiEnkiTsuchishoHakkoDiv> {

    申請区分の非空チェック {
                /**
                 * 申請区分の非空チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:申請区分が非空です、false:申請区分が空です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return !div.getCblShinseiKubun().getSelectedKeys().isEmpty();
                }
            },
    発行有無の非空チェック {
                /**
                 * 発行有無の非空チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:発行有無が非空です、false:発行有無が空です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return !div.getCblHakkoUmu().getSelectedKeys().isEmpty();
                }
            },
    経過日数の非空チェック {
                /**
                 * 経過日数の非空チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:経過日数が非空です、false:経過日数が空です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return div.getTxtKeikaNissu().getValue() != null;
                }
            },
    延期決定日の非空チェック {
                /**
                 * 延期決定日の非空チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:延期決定日が非空です、false:延期決定日数が空です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return div.getTxtnkiKetteiDate().getValue() != null;
                }
            },
    処理見込み日_開始の非空チェック {
                /**
                 * 処理見込み日_開始の非空チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:処理見込み日_開始が非空です、false:処理見込み日_開始が空です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return div.getTxtMikomiDateTsuchisho().getFromValue() != null;
                }
            },
    処理見込み日_終了の非空チェック {
                /**
                 * 処理見込み日_終了の非空チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:処理見込み日_終了が非空です、false:処理見込み日_終了が空です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return div.getTxtMikomiDateTsuchisho().getToValue() != null;
                }
            },
    通知書発行日の非空チェック {
                /**
                 * 通知書発行日の非空チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:通知書発行日が非空です、false:通知書発行日が空です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return div.getTxtTsuchishoHakkoDate().getValue() != null;
                }
            },
    終了日が開始日以前チェック {
                /**
                 * 終了日が開始日以前チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:not終了日が開始日以前です、false:終了日が開始日以前です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    if (div.getTxtMikomiDate().getFromValue() != null && div.getTxtMikomiDate().getToValue() != null) {
                        return !div.getTxtMikomiDate().getToValue().isBefore(div.getTxtMikomiDate().getFromValue());
                    }
                    return true;
                }
            },
    延期内容_終了日が開始日以前チェック {
                /**
                 * 終了日が開始日以前チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:not終了日が開始日以前です、false:終了日が開始日以前です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    if (div.getTxtMikomiDateTsuchisho().getFromValue() != null && div.getTxtMikomiDateTsuchisho().getToValue() != null) {
                        return !div.getTxtMikomiDateTsuchisho().getToValue().isBefore(div.getTxtMikomiDateTsuchisho().getFromValue());
                    }
                    return true;
                }
            },
    発行一覧表_終了日が開始日以前チェック {
                /**
                 * 終了日が開始日以前チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:not終了日が開始日以前です、false:終了日が開始日以前です。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    if (div.getTxtMikomiDateIchiran().getFromValue() != null && div.getTxtMikomiDateIchiran().getToValue() != null) {
                        return !div.getTxtMikomiDateIchiran().getToValue().isBefore(div.getTxtMikomiDateIchiran().getFromValue());
                    }
                    return true;
                }
            },
    対象行を選択チェック {
                /**
                 * 対象行を選択チェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:対象行を選択ありです、false:対象行を選択しないです。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    return !div.getDgHakkotaishosha().getSelectedItems().isEmpty();
                }
            },
    更新対象のデータがないチェック {
                /**
                 * 更新対象のデータがないチェックです。
                 *
                 * @param div 認定延期通知発行Div
                 * @return true:更新対象のデータがありです、false:更新対象のデータがないです。
                 */
                @Override
                public boolean apply(NinteiEnkiTsuchishoHakkoDiv div) {
                    List<dgHakkotaishosha_Row> rowList = div.getDgHakkotaishosha().getDataSource();
                    RString 変更フラグ_変更 = new RString("1");
                    for (dgHakkotaishosha_Row row : rowList) {
                        if (変更フラグ_変更.equals(row.getChangeflag())) {
                            return true;
                        }
                    }
                    return false;
                }
            }

}
