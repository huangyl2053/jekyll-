/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedulekagami;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力対象者明細一覧用RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KaigoNinteiShinsakaiScheduleKagamiRelateEntity {

    private RString yubinNo;
    private RString jushoText;
    private RString shimeiText;
    private RString shujiiIryokikanCode;
    private RString ninteichosaItakusakiCode;
    private RString sonotaKikanCode;
}
