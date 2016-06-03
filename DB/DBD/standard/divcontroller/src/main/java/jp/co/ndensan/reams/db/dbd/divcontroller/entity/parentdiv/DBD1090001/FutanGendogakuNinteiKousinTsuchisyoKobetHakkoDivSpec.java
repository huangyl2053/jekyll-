/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 負担限度額認定更新のお知らせ通知書個別発行バリデーションクラスです。
 *
 * @reamsid_L DBD-3570-010 wangchao
 */
public enum FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDivSpec implements IPredicate<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> {

    出力対象の選択されていない {
                /**
                 * 出力対象の必須入力です。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return 画面に一つ出力チェックボックスを選択しない場合、エラーとする
                 */
                @Override
                public boolean apply(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
                    return div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()
                    || div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getFutanGendogakuNinteiHeddaXinseiSyo().isIsPublish();
                }
            },
    発行日の非空チェック {
                /**
                 * 発行日の必須入力です。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
                 */
                @Override
                public boolean apply(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
                    return div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().
                    getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().getValue() != null;
                }
            },
}
