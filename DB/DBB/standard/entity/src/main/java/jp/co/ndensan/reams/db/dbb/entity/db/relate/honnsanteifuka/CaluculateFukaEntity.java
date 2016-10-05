/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課計算中間Tempのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CaluculateFukaEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private FlexibleDate kijunYMD;
    private FukaTempEntity 賦課の情報Entity;
    private DbT1001HihokenshaDaichoEntity 資格の情報Entity;
    private KuBunnGaTsurakuTempEntity 月別ランクEntity;
    private DbT2001ChoshuHohoEntity 徴収方法の情報Entity;
    private TokuteiKozaRelateEntity 口座Entity;
    private SetaiTempEntity 世帯員所得情報Entity;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private UrT0526SeikatsuHogoFujoShuruiEntity 生活保護扶助種類Entity;
    private DbT7006RoreiFukushiNenkinJukyushaEntity 老齢情報Entity;
    private DbT1006KyokaisoGaitoshaEntity 境界層該当者Entity;
    private DbT1007KyokaisoHokenryoDankaiEntity 境界層保険料段階Entity;
}
