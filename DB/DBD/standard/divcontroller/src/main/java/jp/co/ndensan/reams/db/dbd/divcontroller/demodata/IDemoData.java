/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;

/**
 * デモデータです。
 *
 * @author N3327 三浦 凌
 * @param <T> 変換後の型
 */
public interface IDemoData<T> {

    /**
     * デモデータを任意の型のlistで返します。
     *
     * @return デモデータ
     */
    List<T> asConvertedType();

    /**
     * デモデータをHashMapのlistで返します。
     *
     * @return デモデータ
     */
    List<HashMap> asRow();
}
