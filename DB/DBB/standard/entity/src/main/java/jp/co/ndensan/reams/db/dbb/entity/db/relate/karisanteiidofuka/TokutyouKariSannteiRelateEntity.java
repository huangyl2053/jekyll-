/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特徴仮算定抽出RelateEntityです
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokutyouKariSannteiRelateEntity {

    private RString 前年度保険料段階;
    private Decimal 前年度合計所得金額;
    private Decimal 前年度公的年金収入額;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity;
    private FukaJohoRelateEntity 賦課情報Entity;
    private DbT2001ChoshuHohoEntity 徴収方法Entity;
    private KozaRelateEntity 口座Entity;
    private List<SeikatsuHogoJukyushaRelateEntity> 生保の情報List;
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢の情報List;
}
