/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IShujii;

/**
 * 主治医情報を管理するインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiManager {

    /**
     * 引数の主治医情報を新規登録、または更新します。
     *
     * @param 主治医情報 主治医情報
     * @return 新規登録、または更新が成功した場合はtrueを返します。
     */
    boolean save(IShujii 主治医情報);

    /**
     * 引数の主治医情報を新規登録、または更新します。<br />
     * 医師の状況を「有効」に設定します。
     *
     * @param 主治医情報 主治医情報
     * @return 新規登録、または更新が成功した場合はtrueを返します。
     */
    boolean saveAs有効(IShujii 主治医情報);

    /**
     * 引数の主治医情報を新規登録、または更新します。<br />
     * 医師の状況を「無効」に設定します。
     *
     * @param 主治医情報 主治医情報
     * @return 新規登録、または更新が成功した場合はtrueを返します。
     */
    boolean saveAs無効(IShujii 主治医情報);

    /**
     * 引数の主治医情報を新規登録します。
     *
     * @param 主治医情報 主治医情報
     * @return 新規登録が成功した場合はtrueを返します。
     */
    boolean saveAsNew(IShujii 主治医情報);

    /**
     * 引数の主治医情報を削除します。
     *
     * @param 主治医情報 主治医情報
     * @return 削除が成功した場合はtrueを返します。
     */
    boolean remove(IShujii 主治医情報);
}
