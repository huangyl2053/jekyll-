/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho;

import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 支払口座情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-0300-020 houtianpeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KozaParameter {

    private final long kozaId;
    private final ShikibetsuCode shikibetsuCode;
    private final ShunoKamokuShubetsu kamokuCode;

    /**
     * コンストラクタです。
     *
     * @param kozaId 口座ID
     * @param shikibetsuCode 識別コード
     * @param kamokuCode 科目コード
     */
    private KozaParameter(long kozaId, ShikibetsuCode shikibetsuCode, ShunoKamokuShubetsu kamokuCode) {
        this.kozaId = kozaId;
        this.shikibetsuCode = shikibetsuCode;
        this.kamokuCode = kamokuCode;
    }

    /**
     * パラメータを生成します。
     *
     * @param kozaId 口座ID
     * @param shikibetsuCode 識別コード
     * @param kamokuCode 科目コード
     * @return 介護認定審査会委員情報パラメータ
     */
    public static KozaParameter createParam(
            long kozaId, ShikibetsuCode shikibetsuCode, ShunoKamokuShubetsu kamokuCode) {
        return new KozaParameter(kozaId, shikibetsuCode, kamokuCode);
    }

}
