/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT22002_汎用リスト 賦課台帳中間Entityのクラスです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListFukaDaichoTmpEntity {

    private DbT2002FukaEntity 介護賦課;
    private UrT0705ChoteiKyotsuEntity 調定共通;
    private DbT2003KibetsuEntity 介護期別;
    private DbT2001ChoshuHohoEntity 介護徴収方法;
    private DbV4001JukyushaDaichoEntity 受給者台帳Newest;
    private DbV1001HihokenshaDaichoEntity 被保険者台帳管理Newest;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;

    private boolean 本算定後;
    private RString 特別徴収義務者コード;
}
