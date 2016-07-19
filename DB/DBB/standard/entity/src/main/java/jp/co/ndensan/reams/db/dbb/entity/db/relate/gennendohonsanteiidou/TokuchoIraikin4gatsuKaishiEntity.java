/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 特徴依頼金情報Entityクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoIraikin4gatsuKaishiEntity implements IDbAccessable {

    private RString zenNendoHokenryoDankai;
    private Decimal zenNendoGokeiShotokuGaku;
    private Decimal zenNendoNenkinShunyuGaku;
    private DbT1001HihokenshaDaichoEntity 資格の情報;
    private DbT2001ChoshuHohoEntity 徴収方法の情報;
    private List<SeikatsuHogoJukyushaRelateEntity> 生保の情報;
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢の情報;
    private List<KozaRelateEntity> 口座;
}
