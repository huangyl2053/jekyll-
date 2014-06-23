/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author N3327 三浦 凌
 * @param <T>
 */
public interface IDemoData<T> {

    List<T> asConvertedType();

    List<HashMap> asRaw();
}
