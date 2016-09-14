/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定インターフェース情報Entityです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiInterfaceEntity {

    private ShinseishoKanriNo 申請書管理番号;
    private HihokenshaNo 被保険者番号;
    private RString 医療機関コード;
    private RString 主治医コード;
    private RString 調査委託先コード;
    private RString 調査員コード;
    private FlexibleDate 審査会資料作成年月日;
    private FlexibleDate 二次判定日;
    private FlexibleDate 認定有効開始年月日;
    private FlexibleDate 認定有効終了年月日;
    private RString 審査会意見;
    private RString 二次判定結果;
    private RString 予備区分4;
    private RString 申請種別コード;
    private boolean みなし２号等対象フラグ;
    private Code 前回要介護状態区分コード;

    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity;
    private DbT4101NinteiShinseiJohoEntity 要介護認定申請情報Entity;

//    private FlexibleDate 二次判定結果日;
//    private FlexibleDate 審査依頼日;
//
//    private Boolean みなし２号等対象フラグ;
//    private Code 前回要介護状態区分コード;
}
