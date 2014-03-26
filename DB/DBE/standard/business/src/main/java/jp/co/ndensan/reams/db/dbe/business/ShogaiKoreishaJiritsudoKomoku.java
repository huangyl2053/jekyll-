/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShogaiKoreishaJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障害高齢者自立度を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShogaiKoreishaJiritsudoKomoku extends KaigoCodeAssignedItem<ShogaiKoreishaJiritsudoCode> {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 障害高齢者自立度コード 障害高齢者自立度コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public ShogaiKoreishaJiritsudoKomoku(Code 障害高齢者自立度コード, RString 名称, RString 略称) {
        super(new ShogaiKoreishaJiritsudoCode(障害高齢者自立度コード.value()), 障害高齢者自立度コード, 名称, 略称, null, null, null);
    }

    /**
     * 障害高齢者自立度コードを返します。
     *
     * @return 障害高齢者自立度コード
     */
    public ShogaiKoreishaJiritsudoCode get障害高齢者自立度コード() {
        return getExtendedCode();
    }
}
