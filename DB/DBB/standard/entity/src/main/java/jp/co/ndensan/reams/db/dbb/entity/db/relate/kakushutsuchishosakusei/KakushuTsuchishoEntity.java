/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 更正前後賦課の情報を取得Entityクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KakushuTsuchishoEntity implements Serializable {

    private DbT2002FukaEntity 介護賦課;
    private List<KibetsuEntity> 介護期別RelateEntity;
    private DbT2001ChoshuHohoEntity 介護徴収方法;
    private List<TotalShunyuRelateEntity> 収入情報取得PSM;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}
