/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.shokanbaraika1go.ShokanBaraiKa1Go;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 【共有子Div】 1号償還払い化ダイアログのバリデーションクラスです。
 *
 * @reamsid_L DBD-3620-041 mawy
 */
public enum ShokanBaraiKa1GoDivSpec implements IPredicate<ShokanBaraiKa1GoDiv> {

    適用期間チェック {
                /**
                 * 適用期間のチェックです。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:期間が正確、false:期間が不正
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    if (is年月日が空でない(div.getTxtTekiyoKikanKaishi()) && is年月日が空でない(div.getTxtTekiyoKikanShuryo())) {
                        return div.getTxtTekiyoKikanKaishi().getValue().isBefore(div.getTxtTekiyoKikanShuryo().getValue());
                    } else {
                        return is年月日が空でない(div.getTxtTekiyoKikanKaishi()) || is年月日が空でない(div.getTxtTekiyoKikanShuryo());
                    }
                }
            },
    弁明受付日入力チェック {
                /**
                 * 弁明受付日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return is申請不要(div) || is年月日が空でない(div.getTxtBemmeiUketsukeYMD());
                }
            },
    弁明内容決定日入力チェック {
                /**
                 * 弁明内容決定日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return is申請不要(div) || is年月日が空でない(div.getTxtBemmeiNaiyoKetteiYMD());
                }
            },
    適用期間終了入力チェック {
                /**
                 * 適用期間終了の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return !div.getDdlBemmeiShinsaKekka().getSelectedValue().equals(new RString("申請受理")) || is年月日が空でない(div.getTxtTekiyoKikanShuryo());
                }
            },
    申請受付日入力チェック {
                /**
                 * 申請受付日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return is申請不要(div) || is年月日が空でない(div.getTxtShinseiUketsukeYMD());
                }
            },
    申請日入力チェック {
                /**
                 * 申請日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return is申請不要(div) || is年月日が空でない(div.getTxtShinseiYMD());
                }
            },
    申請内容決定日入力チェック {
                /**
                 * 申請内容決定日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return is申請不要(div) || is年月日が空でない(div.getTxtShinseiNaiyoKetteiYMD());
                }
            },
    弁明審査結果選択チェック {
                /**
                 * 弁明審査結果の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return !div.getDdlBemmeiShinsaKekka().getSelectedValue().isEmpty();
                }
            },
    弁明理由選択チェック {
                /**
                 * 弁明理由の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return !div.getDdlBemmeiRiyu().getSelectedValue().isEmpty();
                }
            },
    申請審査結果選択チェック {
                /**
                 * 申請審査結果の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return !div.getDdlShinseiShinsaKekka().getSelectedValue().isEmpty();
                }
            },
    申請理由選択チェック {
                /**
                 * 申請理由の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return !div.getDdlShinseiRiyu().getSelectedValue().isEmpty();
                }
            },
    終了状況選択チェック {
                /**
                 * 終了状況の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(ShokanBaraiKa1GoDiv div) {
                    return !div.getDdlShuryoJokyo().getSelectedValue().isEmpty();
                }
            };

    private static RString getValue_申請不要() {
        return new RString("申請不要");
    }
    
    private static boolean is申請不要(ShokanBaraiKa1GoDiv div){
        return getValue_申請不要().equals(div.getDdlBemmeiShinsaKekka().getSelectedValue());
    }
    
    private static boolean is年月日が空でない(TextBoxDate ymd){
        return !(ymd.getValue()==null || ymd.getValue().toString().isEmpty());
    }
}
