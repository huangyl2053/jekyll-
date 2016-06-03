/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支援事業者情報のエンティティです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShienJigyoshaDataEntity {

    private RString jigyoshaName1;
    private RString todokedeYMD1;
    private RString jigyoshaName2;
    private RString jigyoshaName2Asutarisuku;
    private RString jigyoshaName2Masshosen;
    private RString todokedeYMD2;
    private RString todokedeYMD2Asutarisuku;
    private RString todokedeYMD2Masshosen;
    private RString jigyoshaName3;
    private RString jigyoshaName3Asutarisuku;
    private RString jigyoshaName3Masshosen;
    private RString todokedeYMD3;
    private RString todokedeYMD3Asutarisuku;
    private RString todokedeYMD3Masshosen;
}
