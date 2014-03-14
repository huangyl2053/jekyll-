/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinchishoKoreishaJiritsudoCode;
import jp.co.ndensan.reams.ur.urz.business.CodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認知症高齢者の自立度を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinchishoKoreishaJiritsudoKomoku extends CodeAssignedItem {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 認知症高齢者自立度コード 認知症高齢者自立度コード
     * @param 名称 名称
     */
    public NinchishoKoreishaJiritsudoKomoku(NinchishoKoreishaJiritsudoCode 認知症高齢者自立度コード, RString 名称) {
        super(認知症高齢者自立度コード, 名称, null, null, null, null);
    }

    /**
     * 認知症高齢者自立度コードを返します。
     *
     * @return 認知症高齢者自立度コード
     */
    public NinchishoKoreishaJiritsudoCode get認知症高齢者自立度コード() {
        return (NinchishoKoreishaJiritsudoCode) getCode();
    }
}
