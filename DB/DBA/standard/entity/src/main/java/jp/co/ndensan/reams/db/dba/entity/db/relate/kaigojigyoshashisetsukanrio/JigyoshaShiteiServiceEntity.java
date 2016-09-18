/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者・サービス一覧情報のEntityクラスです。
 *
 * @reamsid_L DBA-0340-010 lijia
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoshaShiteiServiceEntity {

    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private AtenaMeisho jigyoshaName;
    private AtenaMeisho kanrishaName;
    private ServiceShuruiCode serviceShuruiCode;
    private RString serviceShuruiRyakusho;
    private boolean isDeleted = false;
}
