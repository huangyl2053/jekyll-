/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医医療機関を表すインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShujiiIryoKikan {

    /**
     * 市町村コードを取得する。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 介護独自の医療機関コードを取得する。
     *
     * @return 介護医療機関コード
     */
    KaigoIryoKikanCode get介護医療機関コード();

    /**
     * 医療機関コードを取得する。
     *
     * @return 医療機関コード
     */
    IryoKikanCode get医療機関コード();

    /**
     * 医療機関の状況を返します。
     *
     * @return 医療機関状況
     */
    IryoKikanJokyo get医療機関状況();

    /**
     * 主治医医療機関が有効か否かを返す。
     *
     * @return 主治医医療機関が有効ならtrue、それ以外はfalse
     */
    boolean is有効();

    /**
     * 医療機関区分を返します。
     *
     * @return 医療機関区分
     */
    IryoKikanKubun get医療機関区分();
}
