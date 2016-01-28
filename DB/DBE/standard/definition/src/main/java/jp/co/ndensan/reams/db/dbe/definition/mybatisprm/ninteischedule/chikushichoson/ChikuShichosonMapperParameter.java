/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.chikushichoson;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 地区市町村を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ChikuShichosonMapperParameter {

    private final Code 調査地区コード;
    private final LasdecCode 市町村コード;
    private final boolean uses調査地区コード;
    private final boolean uses市町村コード;

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return 地区市町村検索パラメータ
     */
    public static ChikuShichosonMapperParameter createSelectByKeyParam(
            Code 調査地区コード, LasdecCode 市町村コード) {
        return new ChikuShichosonMapperParameter(調査地区コード, 市町村コード, true, true);
    }

    private ChikuShichosonMapperParameter(Code 調査地区コード,
            LasdecCode 市町村コード,
            boolean uses調査地区コード,
            boolean uses市町村コード) {
        this.調査地区コード = 調査地区コード;
        this.市町村コード = 市町村コード;
        this.uses調査地区コード = uses調査地区コード;
        this.uses市町村コード = uses市町村コード;
    }
}
