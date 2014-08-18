/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikanCollection;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 医療機関の情報を取得するためのクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IKaigoIryoKikanFinder {

    /**
     * 市町村コードと介護医療機関コードを元に、介護医療機関の情報を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @return 介護医療機関情報
     */
    KaigoIryoKikan get介護医療機関(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード);

    /**
     * 市町村コード、介護医療機関コード、医療機関情報を元に、介護医療機関の情報を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医療機関の状況 医療機関の状況
     * @return 介護医療機関情報
     */
    KaigoIryoKikan get介護医療機関(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IryoKikanJokyo 医療機関の状況);

    /**
     * 市町村コードを指定して、介護医療機関の情報をリストで返します。
     *
     * @param 市町村コード 市町村コード
     * @return 介護医療機関情報のリスト
     */
    KaigoIryoKikanCollection get介護医療機関Collection(LasdecCode 市町村コード);

    /**
     * 市町村コードと医療機関情報を指定して、介護医療機関の情報をリストで返します。
     *
     * @param 市町村コード 市町村コード
     * @param 医療機関の状況 医療機関の状況
     * @return 介護医療機関情報のリスト
     */
    KaigoIryoKikanCollection get介護医療機関Collection(LasdecCode 市町村コード, IryoKikanJokyo 医療機関の状況);
}
