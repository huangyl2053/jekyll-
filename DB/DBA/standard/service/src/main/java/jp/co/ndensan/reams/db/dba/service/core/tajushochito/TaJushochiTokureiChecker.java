/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tajushochito;

import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 対象者が他市町村住所地特例者であるかどうかを判定する処理をを提供します。
 *
 * @author n8178
 */
public class TaJushochiTokureiChecker {

    private final TaJushochiTokureisyaKanriManager manager;

    private TaJushochiTokureiChecker() {
        manager = TaJushochiTokureisyaKanriManager.createInstance();
    }

    public static TaJushochiTokureiChecker createInstance() {
        return new TaJushochiTokureiChecker();
    }

    /**
     * 適用除外者の最新情報を取得・確認し、対象者が資格しゅ
     *
     * @param shikibetsuCode
     * @return 他市町村住所地特例者と判定された場合{@code true}
     */
    @Transaction
    public boolean is他市町村住所地特例者(ShikibetsuCode shikibetsuCode) {
        TashichosonJushochiTokurei tatokureisha = manager.getNewestTaJushochiTokurei(shikibetsuCode);
        if (tatokureisha == null) {
            return false;
        }
        return tatokureisha.get解除年月日() == null || tatokureisha.get解除年月日().isEmpty();
    }

}
