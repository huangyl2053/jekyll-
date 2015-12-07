/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所属機関情報Entityクラスです。
 */
@lombok.Setter
@lombok.Getter
public class ShozokuKikanIchiranEntity implements Cloneable, Serializable {

    private RString ninteichosaItakusakiCode;

    private RString ninteiChosainNo;

    private RString shujiiIryokikanCode;

    private RString shujiiCode;

    private RString sonotaKikanCode;

    private RString ninteichosaItakusakiMeisho;

    private RString shujiiIryokikanMeisho;

    private RString sonotaKikanMeisho;
}
