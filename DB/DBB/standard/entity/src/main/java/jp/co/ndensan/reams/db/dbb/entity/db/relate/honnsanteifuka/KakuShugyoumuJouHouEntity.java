/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 各種業務情報のクラス
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KakuShugyoumuJouHouEntity {

//    private FlexibleYear choteiNendo;
//    private FlexibleYear fukaNendo;
//    private TsuchishoNo tsuchishoNo;
//    private FlexibleDate kijunYMD;
//    private FukaJohoRelateEntity 賦課の情報;
//    private DbT1001HihokenshaDaichoEntity 資格の情報;
//    private KuBunnGaTsurakuTempEntity 月別ランク;
//    private List<SetaiShotokuEntity> 世帯員所得情報;
//    private DbT2001ChoshuHohoEntity 徴収方法の情報;
//    private SeikatsuHogoJukyushaRelateEntity 生保の情報;
//    private DbT7006RoreiFukushiNenkinJukyushaEntity 老齢の情報;
//    private KyokaisoGaitoshaEntity 境界層の情報;
//    private List<KozaRelateEntity> 口座;
    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private FlexibleDate kijunYMD;
    private FukaJohoRelateEntity 賦課の情報Entity;
    private DbT1001HihokenshaDaichoEntity 資格の情報Entity;
    private KuBunnGaTsurakuTempEntity 月別ランクEntity;
    private DbT2001ChoshuHohoEntity 徴収方法の情報Entity;
    private KozaRelateEntity 口座Entity;
    private SetaiShotokuEntity 世帯員所得情報Entity;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private UrT0526SeikatsuHogoFujoShuruiEntity 生活保護扶助種類Entity;
    private DbT7006RoreiFukushiNenkinJukyushaEntity 老齢福祉年金Entity;
    private DbT1006KyokaisoGaitoshaEntity 境界層該当者Entity;
    private DbT1007KyokaisoHokenryoDankaiEntity 境界層保険料段階Entity;
}
