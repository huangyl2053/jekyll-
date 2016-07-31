/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課根拠設定(オーバロード)用のパラメータクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaKokyoBatchParameter {

    private FlexibleYear 賦課年度;
    private FukaJoho 賦課の情報_設定前;
    private HihokenshaDaicho 資格の情報;
    private List<SetaiShotokuEntity> 世帯員所得情報List;
    private List<SeikatsuHogoJukyusha> 生保の情報のリスト;
    private List<RoreiFukushiNenkinJukyusha> 老福の情報のリスト;
    private List<KyokaisoGaitosha> 境界層の情報のリスト;
    private FukaKonkyo 賦課根拠パラメータ;
    private TsukibetsuHokenryoDankai 月別保険料段階;
    private Decimal 年額保険料;
    private YMDHMS 調定日時;
}
