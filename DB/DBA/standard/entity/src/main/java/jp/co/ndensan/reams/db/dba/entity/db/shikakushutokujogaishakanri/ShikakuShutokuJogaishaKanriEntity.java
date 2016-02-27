/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.shikakushutokujogaishakanri;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得除外者一覧取得
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShutokuJogaishaKanriEntity {

    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private int rirekiNo;
    private AtenaMeisho meisho;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private RString juminJotaiCode;
    private RString shikakuShutokuJogaiRiyu;
    private FlexibleDate shikakuShutokuJogaiYMD;
    private FlexibleDate shikakuShutokuJogaiKaijoYMD;

}
