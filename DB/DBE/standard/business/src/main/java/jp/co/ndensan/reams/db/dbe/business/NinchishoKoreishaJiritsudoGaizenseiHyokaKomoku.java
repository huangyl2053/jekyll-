/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinchishoKoreishaJiritsudoGaizenseiHyokaCode;
import jp.co.ndensan.reams.ur.urz.business.CodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認知症高齢者の自立度蓋然性評価項目を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku extends CodeAssignedItem {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 認知症高齢者自立度蓋然性評価コード 認知症高齢者自立度蓋然性評価コード
     * @param 名称 名称
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(NinchishoKoreishaJiritsudoGaizenseiHyokaCode 認知症高齢者自立度蓋然性評価コード,
            RString 名称) {
        super(認知症高齢者自立度蓋然性評価コード, 名称, null, null, null, null);
    }

    /**
     * 能力未低下認知症高齢者指標コードを返します。
     *
     * @return 能力未低下認知症高齢者指標コード
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaCode get認知症高齢者自立度蓋然性評価コード() {
        return (NinchishoKoreishaJiritsudoGaizenseiHyokaCode) getCode();
    }
}
