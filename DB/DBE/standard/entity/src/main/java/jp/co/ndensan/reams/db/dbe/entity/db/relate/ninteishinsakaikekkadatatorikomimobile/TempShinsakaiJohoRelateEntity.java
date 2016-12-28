/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author
 */
@lombok.Getter
public class TempShinsakaiJohoRelateEntity {

    private RString 介護認定審査会開催番号;
    private RString 介護認定審査会開催年月日;
    private RString 介護認定審査会開始時刻;
    private RString 介護認定審査会終了時刻;
    private RString 合議体番号;
    private RString 開催場所コード;
    private int 実施人数;
}
