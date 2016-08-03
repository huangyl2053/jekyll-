/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請連携データ作成画面のバリデーションクラスです
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public enum RenkeiDataSakuseiShinseiJohoDivSpec implements IPredicate<RenkeiDataSakuseiShinseiJohoDiv> {

    今回開始時間の非空チェック {
                /**
                 * 今回開始時間の非空チェックです。
                 *
                 * @param div 要介護認定申請連携データ作成画面Div
                 * @return true:今回開始時間が非空です、false:今回開始時間が空です。
                 */
                @Override
                public boolean apply(RenkeiDataSakuseiShinseiJohoDiv div
                ) {
                    boolean dateFalg = div.getTxtKonkaiKaishiDay() != null
                    && !(div.getTxtKonkaiKaishiDay().getText().isEmpty());
                    boolean timeFalg = div.getTxtKonkaiKaishiTime() != null
                    && !(div.getTxtKonkaiKaishiTime().getText().isEmpty());
                    return dateFalg && timeFalg;
                }
            },
    今回終了時間の非空チェック {
                /**
                 * 今回終了時間の非空チェックです。
                 *
                 * @param div 要介護認定申請連携データ作成画面Div
                 * @return true:今回終了時間が非空です、false:今回終了時間が空です。
                 */
                @Override
                public boolean apply(RenkeiDataSakuseiShinseiJohoDiv div
                ) {
                    boolean dateFalg = div.getTxtKonkaiShuryoDay() != null
                    && !(div.getTxtKonkaiShuryoDay().getText().isEmpty());

                    boolean timeFalg = div.getTxtKonkaiShuryoTime() != null
                    && !(div.getTxtKonkaiShuryoTime().getText().isEmpty());

                    return dateFalg && timeFalg;
                }
            },
    保険者の非空チェック {
                /**
                 * 保険者の非空チェックです。
                 *
                 * @param div 要介護認定申請連携データ作成画面Div
                 * @return true:保険者が非空です、false:保険者が空です。
                 */
                @Override
                public boolean apply(RenkeiDataSakuseiShinseiJohoDiv div
                ) {
                    return div.getCommonChildDiv1().getSelectedItem().toString() != null
                    && !(div.getCommonChildDiv1().getSelectedItem().toString().isEmpty());
                }
            },
    対象期間時間チェック {
                /**
                 * 対象期間時間チェックです。
                 *
                 * @param div 要介護認定申請連携データ作成画面Div
                 * @return true:対象期間時間が正しいです、false:対象期間時間が間違いです。
                 */
                @Override
                public boolean apply(RenkeiDataSakuseiShinseiJohoDiv div
                ) {
                    boolean dayflag = false;
                    if (div.getTxtKonkaiKaishiDay() != null && div.getTxtKonkaiShuryoDay().getValue() != null
                    && div.getTxtKonkaiKaishiTime() != null && div.getTxtKonkaiShuryoTime() != null
                    && div.getTxtKonkaiKaishiDay().getValue().compareTo(div.getTxtKonkaiShuryoDay().getValue()) <= 0
                    && div.getTxtKonkaiKaishiTime().getValue().compareTo(div.getTxtKonkaiShuryoTime().getValue()) <= 0) {
                        dayflag = true;
                    }
                    return dayflag;
                }
            },
    被保険者番号の非空チェック {
                /**
                 * 被保険者番号チェックです。
                 *
                 * @param div 要介護認定申請連携データ作成画面Div
                 * @return true:被保険者番号が非空です、false:被保険者番号が空です。
                 */
                @Override
                public boolean apply(RenkeiDataSakuseiShinseiJohoDiv div
                ) {
                    RString radChushutsu = div.getChushutsuJoken().getRadChushutsuJoken().getSelectedValue();
                    RString 被保険者番号 = new RString("被保険者番号");
                    if (radChushutsu.equals(被保険者番号)) {
                        String hihokenshaNo = div.getTxtHihokenshaNo().toString();
                        if (hihokenshaNo == null || hihokenshaNo.isEmpty()) {
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        return true;
                    }

                }
            },
    対象者一覧選択チェック {
                /**
                 * 対象者一覧選択チェックです。
                 *
                 * @param div 要介護認定申請連携データ作成画面Div
                 * @return true:対象者一覧選択が非空です、false:対象者一覧選択が空です。
                 */
                @Override
                public boolean apply(RenkeiDataSakuseiShinseiJohoDiv div
                ) {
                    List<dgTaishoshaIchiran_Row> dayishouSelectedItems = div.getDgTaishoshaIchiran().getSelectedItems();
                    return !dayishouSelectedItems.isEmpty();
                }
            },
}
