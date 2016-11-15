/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動一時エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdouTempEntity {

    private HihokenshaNo 被保険者番号;
    private int 連番;
    private DbT4021ShiharaiHohoHenkoEntity 支払方法変更_支払方法;
    private DbT4021ShiharaiHohoHenkoEntity 支払方法変更_給付費減額;
    private DbT7124KokiKoreishaInfoEntity 後期高齢者情報;
    private DbT7123KokuhoShikakuInfoEntity 国保資格情報;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者;
    private TokuteiNyusyoshaInfoEntity 特定入所者;
    private ShafukugemmenEntity 社福減免;
    private DbT4014RiyoshaFutangakuGengakuEntity 利用者負担;
    private HyojunFutanEntity 標準負担;
    private DbT3114RiyoshaFutanWariaiMeisaiEntity 二割負担;
    private KyotakuEntity 居宅計画;
    private JushochitokureiInfoEntity 住所地特例;
    private PSMInfoEntity 宛名情報;
    private DbT4001JukyushaDaichoEntity 受給者台帳;
    private DbT3100NijiYoboJigyoTaishoshaEntity 二次予防;
    private DbT3105SogoJigyoTaishoshaEntity 総合事業対象者;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private IdouTblEntity 異動一時;

}
