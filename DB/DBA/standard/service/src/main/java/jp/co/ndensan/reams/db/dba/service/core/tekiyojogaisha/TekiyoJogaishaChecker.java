/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha;

import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 対象が適用除外者かどうかを判定するための処理を提供します。
 *
 * @author n8178
 */
public class TekiyoJogaishaChecker {

    private final TekiyoJogaishaManager manager;

    private TekiyoJogaishaChecker() {
        manager = TekiyoJogaishaManager.createInstance();
    }

    public static TekiyoJogaishaChecker createInstance() {
        return new TekiyoJogaishaChecker();
    }

    /**
     * 適用除外者の最新情報を取得・確認し、対象者が資格しゅ
     *
     * @param shikibetsuCode
     * @return 適用除外者と判定された場合{@code true}
     */
    @Transaction
    public boolean is適用除外者(ShikibetsuCode shikibetsuCode) {
        TekiyoJogaisha jogaisha = manager.getNewestTekiyoJogaisha(shikibetsuCode);
        if (jogaisha == null) {
            return false;
        }
        return jogaisha.get解除年月日() == null || jogaisha.get解除年月日().isEmpty();
    }

}
