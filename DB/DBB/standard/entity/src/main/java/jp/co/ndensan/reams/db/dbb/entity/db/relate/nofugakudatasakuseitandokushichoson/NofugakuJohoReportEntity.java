/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 納付額一覧表情報Entity項目定義クラスです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class NofugakuJohoReportEntity {

    private DbT2016NofugakuJohoTemp 納付額情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名;

}
