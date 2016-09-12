/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.TokuchoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
enum TokuchoTaishoshaIchiranSpec implements IPredicate<TokuchoTaishoshaIchiranDiv> {

    /**
     * 出力対象未選択のチックです。
     */
    出力対象未選択チック {
                @Override
                public boolean apply(TokuchoTaishoshaIchiranDiv div) {
                    return !div.getChkShutsuryokuTaisho().getSelectedKeys().isEmpty();
                }
            },
    /**
     * 特別徴収開始月未指定のチックです。
     */
    特別徴収開始月未指定チック {
                @Override
                public boolean apply(TokuchoTaishoshaIchiranDiv div) {
                    RString kaishiYM = div.getTxtKaishiYM().getValue();
                    return !(kaishiYM == null || kaishiYM.trim().isEmpty());
                }
            },
    /**
     * 被保険者未選択のチックです。
     */
    被保険者未選択チック {
                @Override
                public boolean apply(TokuchoTaishoshaIchiranDiv div) {
                    return !RString.isNullOrEmpty(div.getTxtHihokenshaNo().getValue());
                }
            },
    /**
     * 入力値が不正_追加メッセージありチックのチックです。
     */
    入力値が不正_追加メッセージありチック {
                @Override
                public boolean apply(TokuchoTaishoshaIchiranDiv div) {
                    RDate nowDate = RDate.getNowDate();
                    RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, nowDate, SubGyomuCode.DBU介護統計報告);
                    RString 最大表示件数_画面 = div.getTxtMaxHyojiKensu().getValue();
                    return !RString.isNullOrEmpty(最大表示件数_画面) && Integer.parseInt(最大表示件数.toString())
                    >= Integer.parseInt(最大表示件数_画面.toString());
                }
            }
}
