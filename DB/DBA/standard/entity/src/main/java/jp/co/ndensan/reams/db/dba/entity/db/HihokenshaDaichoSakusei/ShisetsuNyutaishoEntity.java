/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class ShisetsuNyutaishoEntity {

    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    private AtenaMeisho jigyoshaMeisho;
    private RString nyushoShisetsuShurui;
}
