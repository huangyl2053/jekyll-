/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigokougakujuryoininshouninkakuninsho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * [総合窓口用被保険者、受給者等判断]のRelateEntityクラスです。
 *
 * @reamsid_L DBU-4220-010 jinjue
 */
@lombok.Getter
@lombok.Setter
//TODO QA1631 Redmine#99400
public class ShouninkakuninshoEntity {

    private List<RString> 住民情報;
    private RString 識別コード;
}
