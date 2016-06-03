/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報のエンティティです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDateEntity {

    private RString jusho;
    private RString hihokenshaNameKana;
    private RString hihokenshaName;
    private RString birthGengoMeiji;
    private RString birthGengoTaisho;
    private RString birthGengoShowa;
    private RString birthYMD;
    private RString seibetsu;
}
