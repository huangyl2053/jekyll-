/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 賦課台帳情報クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaDaityouInfo {

    private IShikibetsuTaisho 代納人情報;
    private List<SetaiinShotoku> 世帯員所得情報;
    private TelNo 本人連絡先1;
    private TelNo 本人連絡先2;
    private TelNo 代納人連絡先1;
    private TelNo 代納人連絡先2;
    private DbT1006KyokaisoGaitoshaEntity 境界層当該者情報;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳情報;
    private List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更リスト;
    private DbV4001JukyushaDaichoEntity 受給者台帳情報;
    private YMDHMS 基準日時;
}
