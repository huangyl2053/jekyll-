/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 介護認定審査会対象者割付バリデーションクラスです。
 */
public enum TaishouWaritsukeDivSpec implements IPredicate<TaishouWaritsukeDiv> {

    候補者一覧データ空チェック {
                /**
                 * 調候補者一覧データ空チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:候補者一覧データが非空です、false:候補者一覧データが空です。
                 */
                @Override
                public boolean apply(TaishouWaritsukeDiv div) {
                    return !div.getDgWaritsukeKohoshaIchiran().getDataSource().isEmpty();
                }
            },
    簡易割付人数チェック {
                /**
                 * 簡易割付人数チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:簡易割付人数は予定人数より少ない、false:簡易割付人数は予定人数より多い
                 */
                @Override
                public boolean apply(TaishouWaritsukeDiv div) {
                    return div.getTxtWaritsukeNinzu().getValue().intValue() < div.getTxtYoteiTeiin().getValue().intValue();
                }
            },
    候補者未選択チェック {
                /**
                 * 候補者未選択チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:候補者が選択した、false:候補者が未選択
                 */
                @Override
                public boolean apply(TaishouWaritsukeDiv div) {
                    return !div.getDgWaritsukeKohoshaIchiran().getSelectedItems().isEmpty();
                }
            },
    対象者一覧データ空チェック {
                /**
                 * 対象者一覧データ空チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:対象者一覧データが非空です、false:対象者一覧データが空です
                 */
                @Override
                public boolean apply(TaishouWaritsukeDiv div) {
                    return !div.getDgTaishoshaIchiran().getDataSource().isEmpty();
                }
            },
    対象者未選択チェック {
                /**
                 * 候補者未選択チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:対象者が選択した、false:対象者が未選択
                 */
                @Override
                public boolean apply(TaishouWaritsukeDiv div) {
                    return !div.getDgWaritsukeKohoshaIchiran().getSelectedItems().isEmpty();
                }
            },
    割付人数チェック {
                /**
                 * 割付人数チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:割付人数＋選択候補者数は予定人数より少ない、false:割付人数＋選択候補者数>=予定人数
                 */
                @Override
                public boolean apply(TaishouWaritsukeDiv div) {
                    return div.getTxtWaritsukeNinzu().getValue().intValue() + div.getDgWaritsukeKohoshaIchiran().getSelectedItems().size()
                    < div.getTxtYoteiTeiin().getValue().intValue();
                }
            };

}
