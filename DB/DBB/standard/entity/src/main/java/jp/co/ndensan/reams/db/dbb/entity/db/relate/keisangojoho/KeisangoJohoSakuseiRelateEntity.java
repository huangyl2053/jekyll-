/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho;

import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 * 計算後情報作成のRelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KeisangoJohoSakuseiRelateEntity {

    private DbV2002FukaEntity 介護賦課ビューEntity;
    private DbT2002FukaEntity 介護賦課Entity;
    private DbT2003KibetsuEntity 介護期別Entity;
    private UrT0705ChoteiKyotsuEntity 調定共通介護継承Entity;
    private DbV2001ChoshuHohoEntity 介護徴収方法ビューEntity;
    private DbT2001ChoshuHohoEntity 介護徴収方法Entity;
    private TotalShunyuRelateEntity 収入情報取得PSMEntity;
}
