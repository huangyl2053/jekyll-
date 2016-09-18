/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報Entityです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiKekkaJohoEntity {

    private DbT4101NinteiShinseiJohoEntity 要介護認定申請情報Entity;
    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private ShinseishoKanriNo 申請書管理番号;
    private FlexibleDate 介護認定審査会資料作成年月日;
    private FlexibleDate 二次判定年月日;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private RString 二次判定要介護状態区分コード;
}
