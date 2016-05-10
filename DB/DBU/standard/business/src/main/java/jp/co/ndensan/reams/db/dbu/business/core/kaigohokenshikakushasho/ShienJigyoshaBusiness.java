/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支援事業者データのビジネスです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShienJigyoshaBusiness {

    private RString jigyosha;
    private RString todokedeYMD;
    private RString tekiyoKaishiYMD;
    private RString tekiyoShuryoYMD;
}
