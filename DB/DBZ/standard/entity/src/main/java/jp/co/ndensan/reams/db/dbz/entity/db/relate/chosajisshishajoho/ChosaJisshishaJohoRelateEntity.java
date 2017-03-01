/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.entity.db.relate.chosajisshishajoho;

import jp.co.ndensan.reams.db.dbz.definition.core.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査依頼情報＆認定申請情報＆認定調査委託先情報＆調査員情報のRelateEntityクラスです。
 * 
 * @author n3423
 * 
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaJisshishaJohoRelateEntity {
    
    private KaigoJigyoshaNo ninteichosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
}
