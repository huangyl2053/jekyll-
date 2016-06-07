/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shichoson;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域現市町村entity KoikiGenShichosonJoho
 *
 * @reamsid_L DBB-1690-040 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikiGenShichosonJoho {

    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RString 処理状態;
    private RString 表示用処理状態;
    private YMDHMS 処理日時;
    private RString 処理区分;
    private RString 市町村識別ID;

}
