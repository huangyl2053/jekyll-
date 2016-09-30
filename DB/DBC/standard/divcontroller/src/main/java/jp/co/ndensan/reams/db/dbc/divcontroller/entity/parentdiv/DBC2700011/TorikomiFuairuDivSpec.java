/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 給付費単位数表標準マスタ取込画面バリデーションクラスです。
 * 
 * @reamsid_L DBC-3400-010 x_zhaowen
 */
public enum TorikomiFuairuDivSpec implements IPredicate<TorikomiFuairuDiv> {
    /**
     * アップロードファイル未指定チェック。
     */
    アップロードファイル未指定チェック {
        @Override
        public boolean apply(TorikomiFuairuDiv div) {
            return div.getUplAppurodoFuairu().getRemainUnUploadedFiles().size() > 0;
        }
    };
}
