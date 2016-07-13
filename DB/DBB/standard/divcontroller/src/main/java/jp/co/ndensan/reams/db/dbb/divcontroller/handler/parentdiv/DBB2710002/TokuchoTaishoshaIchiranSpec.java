/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.TokuchoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
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
                    return !RString.isNullOrEmpty(div.getTxtKaishiYM().getValue());
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
            }
}
