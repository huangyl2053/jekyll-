/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成Entity。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AtenaSealCreateDBZ100001Entity {

    private RString 市町村コード;
    private RString 市町村名称;
    private RString 郵便番号;
    private RString 行政区;
    private RString 住所;
    private RString 方書;
    private RString 氏名;
    private RString バーコード住所;
}
