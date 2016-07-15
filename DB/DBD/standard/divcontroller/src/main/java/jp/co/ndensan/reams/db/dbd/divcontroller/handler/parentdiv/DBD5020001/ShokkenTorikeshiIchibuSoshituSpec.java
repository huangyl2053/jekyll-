/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 要介護認定処理画面のチェックロジックです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public enum ShokkenTorikeshiIchibuSoshituSpec implements IPredicate<ShokkenTorikeshiIchibuSoshituDiv> {

    /**
     * 申請日が未入力チェック。
     */
    申請日が未入力チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RDate 申込日 = div.getCcdKaigoNinteiShinseiKihonJohoInput()
                    .getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue();
                    return null != 申込日;
                }
            },
    /**
     * 認定日が未入力チェック。
     */
    認定日が未入力チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RString 今回認定日 = div.getTxtNinteibiKonkai().getValue();
                    return null != 今回認定日 && !今回認定日.isEmpty();
                }
            },
    /**
     * 喪失日が未入力チェック。
     */
    喪失日が未入力チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RDate 喪失日 = div.getTxtSoshitsubi().getValue();
                    return null != 喪失日;
                }
            },
    /**
     * 要介護度が未入力チェック。
     */
    要介護度が未入力チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RString 今回要介護度 = div.getTxtYokaigodoKonkai().getValue();
                    return null != 今回要介護度 && !今回要介護度.isEmpty();
                }
            },
    /**
     * 有効開始日が未入力チェックします。
     */
    有効開始日が未入力チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RString 今回有効開始日 = div.getTxtYukoKaishibiKonkai().getValue();
                    return null != 今回有効開始日 && !今回有効開始日.isEmpty();
                }
            },
    /**
     * 有効終了日が未入力チェックします。
     */
    有効終了日が未入力チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RString 今回有効終了日 = div.getTxtYukoShuryobiKonkai().getValue();
                    return null != 今回有効終了日 && !今回有効終了日.isEmpty();
                }
            },
    /**
     * 有効開始日と有効終了日の関連チェックします。。
     */
    有効開始日と有効終了日の関連チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RString 今回有効開始日 = div.getTxtYukoKaishibiKonkai().getValue();
                    RString 今回有効終了日 = div.getTxtYukoShuryobiKonkai().getValue();

                    if (null != 今回有効開始日 && !今回有効開始日.isEmpty() && null != 今回有効終了日 && !今回有効終了日.isEmpty()) {
                        return new FlexibleDate(今回有効開始日).isBeforeOrEquals(new FlexibleDate(今回有効終了日));
                    }
                    return false;
                }
            },
    /**
     * 前回有効終了日と今回有効開始日の関連チェックします。
     */
    前回有効終了日と今回有効開始日の関連チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RString 今回有効開始日 = div.getTxtYukoKaishibiKonkai().getValue();
                    RString 前回有効終了日 = div.getTxtYukoShuryobiZenkai().getValue();

                    if (null != 今回有効開始日 && !今回有効開始日.isEmpty() && null != 前回有効終了日 && !前回有効終了日.isEmpty()) {
                        return new FlexibleDate(今回有効開始日).isBeforeOrEquals(new FlexibleDate(前回有効終了日));
                    }
                    return false;
                }
            },
    /**
     * 新予防給付適用の60日前のみなし更新チェックします。
     */
    新予防給付適用の60日前のみなし更新チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    // TODO. みなし更新 について、わからない。
                    return true;
                }
            },
    /**
     * 受給申請中かの確認チェックします。
     */
    受給申請中かの確認チェック {
                @Override
                public boolean apply(ShokkenTorikeshiIchibuSoshituDiv div) {
                    RString 今回履歴番号 = div.getHdnKonkaiRirekiNo();
                    RString 前回履歴番号 = div.getHdnZenkaiRirekiNo();
                    return null != 今回履歴番号
                    && null != 前回履歴番号
                    && 今回履歴番号.equals(new RString("0000"))
                    && 前回履歴番号.equals(new RString("0000"));
                }
            };
}
