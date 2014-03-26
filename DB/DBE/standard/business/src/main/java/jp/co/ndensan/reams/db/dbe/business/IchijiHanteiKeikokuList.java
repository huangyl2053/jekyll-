/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定警告のリストです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKeikokuList {

    private final List<IchijiHanteiKeikoku> 警告List;
    private final RString 警告配列コード;

    public IchijiHanteiKeikokuList(RString 警告配列コード, List<IchijiHanteiKeikoku> 警告List) {
        this.警告配列コード = 警告配列コード;
        this.警告List = 警告List;
    }
}
