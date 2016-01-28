/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.chikuninteichosain;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 地区認定調査員を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ChikuNinteiChosainMapperParameter {

    private final Code 調査地区コード;
    private final RString 認定調査委託先コード;
    private final RString 認定調査員コード;
    private final LasdecCode 市町村コード;
    private final boolean uses調査地区コード;
    private final boolean uses認定調査委託先コード;
    private final boolean uses認定調査員コード;
    private final boolean uses市町村コード;

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @return 地区認定調査員検索パラメータ
     */
    public static ChikuNinteiChosainMapperParameter createSelectByKeyParam(Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        return new ChikuNinteiChosainMapperParameter(調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード, true, true, true, true);
    }

    private ChikuNinteiChosainMapperParameter(Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            boolean uses調査地区コード,
            boolean uses認定調査委託先コード,
            boolean uses認定調査員コード,
            boolean uses市町村コード) {
        this.調査地区コード = 調査地区コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.市町村コード = 市町村コード;
        this.uses調査地区コード = uses調査地区コード;
        this.uses認定調査委託先コード = uses認定調査委託先コード;
        this.uses認定調査員コード = uses認定調査員コード;
        this.uses市町村コード = uses市町村コード;
    }
}
