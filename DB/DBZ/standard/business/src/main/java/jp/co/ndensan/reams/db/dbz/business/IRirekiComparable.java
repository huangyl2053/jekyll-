/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.uz.uza.lang.IOrderComparable;

/**
 * 履歴を比較可能なオブジェクトであることを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 履歴を比較できるオブジェクト
 */
public interface IRirekiComparable<T> extends IOrderComparable<T> {
}
