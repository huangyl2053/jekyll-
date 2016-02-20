/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hiroshimadomain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * @author chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HiroshimaDomainRelateEntity implements IDbAccessable {

    private HihokenshaNo 転入_被保険者番号;
    private FlexibleDate 転入_異動日;
    private RString 転入_枝番;
    private LasdecCode 転入_市町村コード;
    private ShikibetsuCode 転入_識別コード;
    private HihokenshaNo 転出_被保険者番号;
    private FlexibleDate 転出_異動日;
    private RString 転出_枝番;
    private LasdecCode 転出_市町村コード;
    private ShikibetsuCode 転出_識別コード;
    private RString 転出PSM_住登内住所;
    private RString 転出PSM_住登内番地;
    private RString 転出PSM_住登内方書;
    private FlexibleDate 転出PSM_転出予定異動年月日;
    private FlexibleDate 転出PSM_転出確定異動年月日;
    private FlexibleDate 転出PSM_転出確定通知年月日;
    private AtenaKanaMeisho 転入PSM_カナ名称;
    private AtenaMeisho 転入PSM_名称;
    private RString 転入PSM_住登内住所;
    private RString 転入PSM_住登内番地;
    private RString 転入PSM_住登内方書;
    private FlexibleDate 転入PSM_登録異動年月日;
    private FlexibleDate 転入PSM_登録異動届出日;

}
