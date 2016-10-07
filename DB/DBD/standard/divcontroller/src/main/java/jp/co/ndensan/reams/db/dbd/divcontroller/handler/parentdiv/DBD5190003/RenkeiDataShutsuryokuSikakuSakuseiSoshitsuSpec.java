/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 資格喪失（死亡）データ作成画面のチェックロジックです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public enum RenkeiDataShutsuryokuSikakuSakuseiSoshitsuSpec implements IPredicate<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv> {

    /**
     * 今回処理日時_終了日時が開始日時以前チェック
     */
    今回処理日時_終了日時が開始日時以前チェック {
                @Override
                public boolean apply(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
                    return RDateTime.convertFrom(div.getTxtKonkaiKaishiDay().getValue(), div.getTxtKonkaiKaishiTime().getValue())
                    .isBefore(RDateTime.convertFrom(div.getTxtKonkaiShuryoDay().getValue(), div.getTxtKonkaiShuryoTime().getValue()));
                }
            },
    /**
     * 今回開始チェック（年月日）
     */
    今回開始チェック_年月日 {
                @Override
                public boolean apply(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
                    return div.getTxtKonkaiKaishiDay().getValue() != null;
                }
            },
    /**
     * 今回開始チェック（時分秒）
     */
    今回開始チェック_時分秒 {
                @Override
                public boolean apply(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
                    return div.getTxtKonkaiKaishiTime().getValue() != null;
                }
            },
    /**
     * 今回終了チェック_年月日
     */
    今回終了チェック_年月日 {
                @Override
                public boolean apply(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
                    return div.getTxtKonkaiShuryoDay().getValue() != null;
                }
            },
    /**
     * 今回終了チェック（時分秒）
     */
    今回終了チェック_時分秒 {
                @Override
                public boolean apply(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
                    return div.getTxtKonkaiShuryoTime().getValue() != null;
                }
            };
}
