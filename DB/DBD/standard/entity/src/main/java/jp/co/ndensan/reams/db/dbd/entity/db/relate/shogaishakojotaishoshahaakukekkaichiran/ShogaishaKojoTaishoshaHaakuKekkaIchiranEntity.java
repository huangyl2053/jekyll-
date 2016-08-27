/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shogaishakojotaishoshahaakukekkaichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障がい者控除対象者csv出力のentityです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity {

    private HihokenshaNo 被保険者番号;
    private RString 申請理由;
    private FlexibleDate 喪失年月日;
    private Code 認知症高齢者の日常生活自立度コード;
    private Code 障害高齢者の日常生活自立度コード;
    private LasdecCode 市町村コード;
    private LasdecCode 広住特措置元市町村コード;
    private FlexibleDate 資格喪失年月日;
    private RString 資格喪失事由コード;

}
