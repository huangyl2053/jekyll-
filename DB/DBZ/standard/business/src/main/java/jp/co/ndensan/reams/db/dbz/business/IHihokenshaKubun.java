/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者区分を扱うインターフェースです。みなし2号を含む被保険者区分を扱うことができます。
 *
 * @author n8178 城間篤人
 */
public interface IHihokenshaKubun {

    /**
     * 被保険者区分を表すコードを返します。
     *
     * @return 被保険者区分コード
     */
    Code getCode();

    /**
     * 被保険者区分を返します。
     *
     * @return 被保険者区分
     */
    RString get被保険者区分();

}
