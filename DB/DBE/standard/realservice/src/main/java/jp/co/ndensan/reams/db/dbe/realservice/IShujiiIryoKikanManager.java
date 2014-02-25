/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IShujiiIryoKikan;

/**
 * 主治医医療機関の情報を扱うクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShujiiIryoKikanManager {

    /**
     * 引数から渡された主治医医療機関の情報を記録、保持します。
     *
     * @param 主治医医療機関 主治医医療機関
     * @return 記録に成功ならture
     */
    boolean save(IShujiiIryoKikan 主治医医療機関);

    /**
     * 引数から渡された主治医医療機関の情報を削除します。
     *
     * @param 主治医医療機関 主治医医療機関
     * @return 削除に成功ならtrue
     */
    boolean remove(IShujiiIryoKikan 主治医医療機関);

    /**
     * 引数から渡された主治医医療機関について、状況を有効に変更して記録します。
     *
     * @param 主治医医療機関 主治医医療機関
     * @return 記録に成功ならtrue
     */
    boolean saveAs有効(IShujiiIryoKikan 主治医医療機関);

    /**
     * 引数から渡された主治医医療機関について、状況を無効に変更して記録します。
     *
     * @param 主治医医療機関 主治医医療機関
     * @return 記録に成功ならtrue
     */
    boolean saveAs無効(IShujiiIryoKikan 主治医医療機関);
}
