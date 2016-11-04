/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu;

import java.io.Serializable;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0701ShunyuEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0708FunoKessonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.shunokanri.UrT0700ShunoKanriEntity;

/**
 * 収納宛名データを取得Entityクラスです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibetsuShunoritsuDataEntity implements Serializable {

    private UrT0700ShunoKanriEntity 収納管理マスタ;
    private CaT0701ShunyuEntity 収入;
    private CaT0708FunoKessonEntity 不納欠損;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private DbT2002FukaEntity 介護賦課;
    private DbT2003KibetsuEntity 介護期別;
    private UrT0705ChoteiKyotsuEntity 調定共通;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private JukyushaKyufujissekiCountEntity 受給者給付COUNT;
}
