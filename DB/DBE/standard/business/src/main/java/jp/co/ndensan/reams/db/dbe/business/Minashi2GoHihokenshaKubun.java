/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.Minashi2GoHihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号の被保険者区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class Minashi2GoHihokenshaKubun extends KaigoCodeAssignedItem<Minashi2GoHihokenshaKubunCode> implements IHihokenshaKubun {

    /**
     * みなし2号被保険者区分を表すコードと区分名称を引数から渡し、インスタンスを生成します。
     *
     * @param code みなし2号被保険者区分コード
     * @param codeMeisho 区分名称
     */
    public Minashi2GoHihokenshaKubun(Code code, RString codeMeisho) {
        super(new Minashi2GoHihokenshaKubunCode(code), code, codeMeisho, codeMeisho);
    }

    /**
     * みなし2号被保険者区分コードを返します。
     *
     * @return みなし2号被保険者区分コード
     */
    public Minashi2GoHihokenshaKubunCode getみなし2号被保険者区分コード() {
        return getExtendedCode();
    }

    @Override
    public RString get被保険者区分() {
        return getMeisho();
    }
}
