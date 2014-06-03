/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinchishoKoreishaJiritsudoGaizenseiHyokaCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認知症高齢者日常生活自立度の蓋然性評価を表すクラスです。<br/>
 * 一次判定にて設定された認知症高齢者の日常生活自立度が、どの程度確からしいかを評価する項目になります。
 *
 * @author n8178 城間篤人
 */
public class NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku
        extends KaigoCodeAssignedItem<NinchishoKoreishaJiritsudoGaizenseiHyokaCode> {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 認知症高齢者自立度蓋然性評価コード 認知症高齢者自立度蓋然性評価コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(Code 認知症高齢者自立度蓋然性評価コード, RString 名称, RString 略称) {
        super(new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(認知症高齢者自立度蓋然性評価コード),
                認知症高齢者自立度蓋然性評価コード, 名称, 略称);
    }

    /**
     * 能力未低下認知症高齢者指標コードを返します。
     *
     * @return 能力未低下認知症高齢者指標コード
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaCode get認知症高齢者自立度蓋然性評価コード() {
        return getExtendedCode();
    }
}
