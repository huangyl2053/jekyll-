/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課根拠作成クラスです。
 *
 * @reamsid_L DBB-9040-150 cuilin
 */
public class FukaKonkyoFactory {

    private static final RString 賦課基準日メッセージ = new RString("賦課基準日");
    private static final RString 生保の情報メッセージ = new RString("生保の情報");
    private static final RString 老齢の情報メッセージ = new RString("老齢の情報");
    private static final RString 世帯員所得情報メッセージ = new RString("世帯員所得情報");

    /**
     * 賦課根拠パラメータ作成
     *
     * @param 賦課基準日 FlexibleDate
     * @param 生保の情報リスト List<SeikatsuHogoJukyusha>
     * @param 老齢の情報のリスト List<RoreiFukushiNenkinJukyusha>
     * @param 世帯員所得情報List List<SetaiinShotoku>
     * @return FukaKonkyo
     */
    public FukaKonkyo create(FlexibleDate 賦課基準日, List<SeikatsuHogoJukyusha> 生保の情報リスト,
            List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト, List<SetaiinShotoku> 世帯員所得情報List) {
        requireNonNull(賦課基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課基準日メッセージ.toString()));
        requireNonNull(生保の情報リスト, UrSystemErrorMessages.値がnull.getReplacedMessage(生保の情報メッセージ.toString()));
        requireNonNull(老齢の情報のリスト, UrSystemErrorMessages.値がnull.getReplacedMessage(老齢の情報メッセージ.toString()));
        requireNonNull(世帯員所得情報List, UrSystemErrorMessages.値がnull.getReplacedMessage(世帯員所得情報メッセージ.toString()));
        if (賦課基準日.isEmpty() || 生保の情報リスト.isEmpty() || 老齢の情報のリスト.isEmpty() || 世帯員所得情報List.isEmpty()) {
            throw new IllegalArgumentException();
        }
        FukaKonkyo 賦課根拠 = new FukaKonkyo();
        賦課根拠.setFukakijunYMD(賦課基準日);

        for (SeikatsuHogoJukyusha 生保の情報 : 生保の情報リスト) {
            if (!生保の情報.toEntity().getIsDeleted() && 生保の情報.get受給開始日().isBeforeOrEquals(賦課基準日)
                    && (生保の情報.get受給廃止日() == null || 生保の情報.get受給廃止日().isEmpty()
                    || 賦課基準日.isBeforeOrEquals(生保の情報.get受給廃止日()))) {
                賦課根拠.setSeihoStartYMD(生保の情報.get受給開始日());
                賦課根拠.setSeihoEndYMD(生保の情報.get受給廃止日());
                break;
            }
        }
        for (RoreiFukushiNenkinJukyusha 老齢の情報 : 老齢の情報のリスト) {
            if (!老齢の情報.toEntity().getIsDeleted() && 老齢の情報.get受給開始年月日().isBeforeOrEquals(賦課基準日)
                    && (老齢の情報.get受給終了年月日() == null || 老齢の情報.get受給終了年月日().isEmpty()
                    || 賦課基準日.isBeforeOrEquals(老齢の情報.get受給終了年月日()))) {
                賦課根拠.setRoreiNenkinStartYMD(老齢の情報.get受給開始年月日());
                賦課根拠.setRoreiNenkinEndYMD(老齢の情報.get受給終了年月日());
                break;
            }
        }
        for (SetaiinShotoku 世帯員 : 世帯員所得情報List) {
            賦課根拠.getSetaiinKazeiKubunList().add(KazeiKubun.toValue(世帯員.get課税区分_住民税減免前()));
            if (HonninKubun.本人.getCode().equals(世帯員.get本人区分())) {
                賦課根拠.setGokeiShotoku(世帯員.get合計所得金額());
                賦課根拠.setKotekiNenkinShunyu(世帯員.get年金収入額());
            }
        }
        return 賦課根拠;
    }
}
