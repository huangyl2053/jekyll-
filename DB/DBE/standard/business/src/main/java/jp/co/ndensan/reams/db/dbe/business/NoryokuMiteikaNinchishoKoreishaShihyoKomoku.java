/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NoryokuMiteikaNinchishoKoreishaShihyoCode;
import jp.co.ndensan.reams.ur.urz.business.CodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 能力が低下していない認知症高齢者の指標を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NoryokuMiteikaNinchishoKoreishaShihyoKomoku extends CodeAssignedItem {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 能力未低下認知症高齢者指標コード 能力未低下認知症高齢者指標コード
     * @param 名称 名称
     */
    public NoryokuMiteikaNinchishoKoreishaShihyoKomoku(NoryokuMiteikaNinchishoKoreishaShihyoCode 能力未低下認知症高齢者指標コード, RString 名称) {
        super(能力未低下認知症高齢者指標コード, 名称, null, null, null, null);
    }

    /**
     * 能力未低下認知症高齢者指標コードを返します。
     *
     * @return 能力未低下認知症高齢者指標コード
     */
    public NoryokuMiteikaNinchishoKoreishaShihyoCode get能力未低下認知症高齢者指標コード() {
        return (NoryokuMiteikaNinchishoKoreishaShihyoCode) getCode();
    }
}
