/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 減免減額申請書一括発行のバリデーションクラスです。
 *
 * @reamsid_L DBD-3530-050 liuyl
 */
public enum ShinseishoIkkatsuHakkoSpec implements IPredicate<ShinseishoIkkatsuHakkoDiv> {

    出力チェックボックスを選択しないチェック {
                /**
                 * 出力チェックボックスを選択しないチェックです。
                 *
                 * @param div ShinseishoIkkatsuHakkoDiv
                 * @return true:出力チェックボックスを選択する、false:出力チェックボックスを選択しない。
                 */
                @Override
                public boolean apply(ShinseishoIkkatsuHakkoDiv div) {
                    return div.getGenmenShinseiHaakuList().getGenmenShinseiHaakuShinseisho().isIsPublish();
                }
            },
    候補者を選択しないチェック {
                /**
                 * 候補者を選択しないチェックです。
                 *
                 * @param div ShinseishoIkkatsuHakkoDiv
                 * @return true: 候補者を選択する、false:候補者を選択しないチェックです。
                 */
                @Override
                public boolean apply(ShinseishoIkkatsuHakkoDiv div) {
                    return !div.getGenmenShinseiHaakuList().getDdlKohoshaList().getSelectedItems().isEmpty() && div.getGenmenShinseiHaakuList().
                    getDdlKohoshaList().getSelectedItems() != null;
                }
            },
    処理日時の非空チェック {
                /**
                 * 処理日時の非空チェックです。
                 *
                 * @param div ShinseishoIkkatsuHakkoDiv
                 * @return true:処理日時が非空です、false:処理日時が空です。
                 */
                @Override
                public boolean apply(ShinseishoIkkatsuHakkoDiv div) {
                    return div.getGenmenShinseiHaakuList().getDdlShoriTimestamp().getSelectedValue() != null && !div.getGenmenShinseiHaakuList().
                    getDdlShoriTimestamp().getSelectedValue().isEmpty();
                }
            };
}
