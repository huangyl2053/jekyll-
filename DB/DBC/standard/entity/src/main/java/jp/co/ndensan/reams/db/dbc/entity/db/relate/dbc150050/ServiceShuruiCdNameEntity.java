/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類名称取得Entityクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceShuruiCdNameEntity {

    private RString サービス名称;
    private DbWT3470ServiceShuruiCdTBLTempEntity サービス明細一時TBL;
}
