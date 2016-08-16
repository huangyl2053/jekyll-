/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 非課税年金対象者情報登録画面バリデーションクラスです。
 *
 * @reamsid_L DBD-4930-010 wangjie2
 */
public enum HikazeiNenkinKenJohoSpec implements IPredicate<HikazeiNenkinKenJohoDiv> {

    年金保険者コードの非空チェック {
                /**
                 * 年金保険者コードの非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:年金保険者コードが非空です、false:年金保険者コードが空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbNenkinHokenshaCode().getValue().isNullOrEmpty();
                }
            },
    基礎年金番号の非空チェック {
                /**
                 * 基礎年金番号の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:基礎年金番号が非空です、false:基礎年金番号が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbKisoNenkinNo().getValue().isNullOrEmpty();
                }
            },
    年金コードの非空チェック {
                /**
                 * 年金コードの非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:年金コードが非空です、false:年金コードが空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbNenkinCode().getValue().isNullOrEmpty();
                }
            },
    現基礎年金番号の非空チェック {
                /**
                 * 現基礎年金番号の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:現基礎年金番号が非空です、false:現基礎年金番号が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbGenkisoNenkinNo().getValue().isNullOrEmpty();
                }
            },
    月の非空チェック {
                /**
                 * 月の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:月が非空です、false:月が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getDdlTsuki().getSelectedKey().isNullOrEmpty();
                }
            },
    金額の非空チェック {
                /**
                 * 金額の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:金額が非空です、false:金額が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return div.getTbKingaku().getValue() != null;
                }
            },
    作成年月日の非空チェック {
                /**
                 * 作成年月日の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:作成年月日が非空です、false:作成年月日が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return div.getTbCreateDate().getValue() != null;
                }
            },
    対象年の非空チェック {
                /**
                 * 対象年の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:対象年が非空です、false:対象年が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbTaishoNen().getValue().isNullOrEmpty();
                }
            },
    氏名カナの非空チェック {
                /**
                 * 氏名カナの非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:氏名カナが非空です、false:氏名カナが空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbNameKana().getValue().isNullOrEmpty();
                }
            },
    性別の非空チェック {
                /**
                 * 性別の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:性別が非空です、false:性別が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getDdlSex().getSelectedValue().isNullOrEmpty();
                }
            },
    生年月日の非空チェック {
                /**
                 * 生年月日の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:生年月日が非空です、false:生年月日が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return div.getTbBirthday().getValue() != null;
                }
            },
    氏名漢字の非空チェック {
                /**
                 * 氏名漢字の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:氏名漢字が非空です、false:氏名漢字が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbNameKanji().getValue().isNullOrEmpty();
                }
            },
    住所漢字の非空チェック {
                /**
                 * 住所漢字の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:住所漢字が非空です、false:住所漢字が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbAddressKanji().getValue().isNullOrEmpty();
                }
            },
    登録区分の非空チェック {
                /**
                 * 登録区分の非空チェックです。
                 *
                 * @param div 非課税年金対象者情報登録Div
                 * @return true:登録区分が非空です、false:登録区分が空です。
                 */
                @Override
                public boolean apply(HikazeiNenkinKenJohoDiv div) {
                    return !div.getTbLoadCata().getValue().isNullOrEmpty();
                }
            }

}
