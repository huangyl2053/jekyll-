/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護事業者・施設管理のEntityクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJigyoshaRelateEntity {

    private RString yukoKaishiYMD;
    private RString yukoShuryoYMD;
    private RString jigyoshaNo;
    private RString yukoKaishiYMD2;
    private RString yukoShuryoYMD2;
    private RString jigyoshaNo2;

}
