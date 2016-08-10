/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_受給者台帳異動チェックリストを取得するEntityクラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukyushaDaichoIdoCheckListEntity {

    private LasdecCode 保険者番号;
    private RString 保険者名称;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 受給申請日;
    private FlexibleDate 認定日;
    private FlexibleDate 認定有効開始日;
    private FlexibleDate 認定有効終了日;
    private FlexibleDate 喪失年月日;
    private Code 異動事由;
    private Code 有効無効;
    private Code 受給申請事由;
    private boolean 旧措置者;
    private Code 要介護度;
    private RString 異動理由;
    private Code 厚労省IF識別コード;
    private int 年齢;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;

}
