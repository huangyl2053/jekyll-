/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 資格異動対象者情報取得_DB検索用のパラメータです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShikakuIdoTaishoshaShutokuMybatisParameter {

    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 年齢到達日;
   
    /**
     * コンストラクタです。
     * @param 識別コード 識別コード
     * @param 年齢到達日 年齢到達日
     */
    public ShikakuIdoTaishoshaShutokuMybatisParameter(ShikibetsuCode 識別コード, FlexibleDate 年齢到達日) {
        this.識別コード = 識別コード;
        this.年齢到達日 = 年齢到達日;
    }
}
