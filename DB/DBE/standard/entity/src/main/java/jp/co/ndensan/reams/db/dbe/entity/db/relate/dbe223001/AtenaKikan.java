/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 宛名機関情報のクラスです。
 */
@Getter
@Setter
public class AtenaKikan {

    private RString 宛名機関名;
    private YubinNo 宛名郵便番号;
    private RString 宛名住所;
    private RString 宛名氏名;

}
