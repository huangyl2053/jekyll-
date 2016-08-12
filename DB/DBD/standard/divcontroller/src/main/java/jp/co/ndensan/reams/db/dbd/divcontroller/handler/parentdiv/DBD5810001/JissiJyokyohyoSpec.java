/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5810001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001.JissiJyokyohyoDiv;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定実施状況表（統計表）画面のチェックロジックです。
 *
 * @reamsid_L DBD-1771-010 chenxin
 */
public enum JissiJyokyohyoSpec implements IPredicate<JissiJyokyohyoDiv> {

    /**
     * 行政区大小関係チェック
     */
    行政区大小関係チェック {
                @Override
                public boolean apply(JissiJyokyohyoDiv div) {
                    GyoseikuCode 行政区Start = div.getJokenPanel().getCcdGyouseiStart().get行政区コード();
                    GyoseikuCode 行政区End = div.getJokenPanel().getCcdGyouseiEnd().get行政区コード();
                    return 行政区Start.compareTo(行政区End) <= 0;
                }
            },
    /**
     * 地区２大小関係チェック
     */
    地区２大小関係チェック {
                @Override
                public boolean apply(JissiJyokyohyoDiv div) {
                    ChikuCode 地区２Start = div.getJokenPanel().getCcdChikuStart().get地区2コード();
                    ChikuCode 地区２End = div.getJokenPanel().getCcdChikuEnd().get地区2コード();
                    return 地区２Start.compareTo(地区２End) <= 0;
                }
            },
    /**
     * 住所大小関係チェック
     */
    住所大小関係チェック {
                @Override
                public boolean apply(JissiJyokyohyoDiv div) {
                    ChoikiCode 住所Start = div.getJokenPanel().getCcdJyuusyoStart().get町域コード();
                    ChoikiCode 住所End = div.getJokenPanel().getCcdJyuusyoEnd().get町域コード();
                    return 住所Start.compareTo(住所End) <= 0;
                }
            },
    /**
     * 年齢の未入力チェック
     */
    年齢の未入力チェック {
                @Override
                public boolean apply(JissiJyokyohyoDiv div) {
                    RString 年齢From = RString.EMPTY;
                    RString 年齢To = RString.EMPTY;
                    RString 年齢基準日 = RString.EMPTY;
                    if (div.getJokenPanel().getTxtNenrei().getFromValue() != null) {
                        年齢From = new RString(div.getJokenPanel().getTxtNenrei().getFromValue().toString());
                    }
                    if (div.getJokenPanel().getTxtNenrei().getToValue() != null) {
                        年齢To = new RString(div.getJokenPanel().getTxtNenrei().getToValue().toString());
                    }
                    if (div.getJokenPanel().getTxtNenreikijyun() != null) {
                        年齢基準日 = new RString(div.getJokenPanel().getTxtNenreikijyun().toString());
                    }

                    return !年齢From.isEmpty()
                    && !年齢To.isEmpty()
                    && (!年齢基準日.isEmpty() && 年齢基準日 != null);

                }

            },
    /**
     * 生年月日の未入力チェック
     */
    生年月日の未入力チェック {
                @Override
                public boolean apply(JissiJyokyohyoDiv div) {
                    RDate 生年月日From = div.getJokenPanel().getTxtSeinen().getFromValue();
                    RDate 生年月日To = div.getJokenPanel().getTxtSeinen().getToValue();
                    return null != 生年月日From && null != 生年月日To;

                }
            };
}
