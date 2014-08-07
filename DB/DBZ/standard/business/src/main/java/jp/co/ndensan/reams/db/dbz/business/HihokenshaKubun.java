/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.HihokenshaKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaKubun extends KaigoCodeAssignedItem<HihokenshaKubunCode> implements IHihokenshaKubun {

    /**
     * 被保険者区分を表すコードと区分名称を引数から渡し、インスタンスを生成します。
     *
     * @param code 被保険者区分コード
     * @param codeMeisho 区分名称
     */
    public HihokenshaKubun(Code code, RString codeMeisho) {
        super(new HihokenshaKubunCode(code), code, codeMeisho, codeMeisho);
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public HihokenshaKubunCode get被保険者区分コード() {
        return getExtendedCode();
    }

    @Override
    public RString get被保険者区分() {
        return getMeisho();
    }
}
