/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hihokensha.roreifukushinenkinjukyusha;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金受給者を管理するクラスです。
 *
 * @reamsid_L DBA-0220-020 dongyabin
 */
public class RoreiFukushiNenkinJukyushaManager {

    private final DbT7006RoreiFukushiNenkinJukyushaDac dac;

    /**
     * コンストラクタです。
     */
    public RoreiFukushiNenkinJukyushaManager() {
        dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7006RoreiFukushiNenkinJukyushaDac}
     */
    RoreiFukushiNenkinJukyushaManager(DbT7006RoreiFukushiNenkinJukyushaDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RoreiFukushiNenkinJukyushaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RoreiFukushiNenkinJukyushaManager}のインスタンス
     */
    public static RoreiFukushiNenkinJukyushaManager createInstance() {
        return InstanceProvider.create(RoreiFukushiNenkinJukyushaManager.class);
    }

    /**
     * {@link RoreiFukushiNenkinJukyusha 老齢福祉年金受給者}を保存します。
     *
     * @param 老齢福祉年金受給者 {@link RoreiFukushiNenkinJukyusha 老齢福祉年金受給者}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save老齢福祉年金受給者(RoreiFukushiNenkinJukyusha 老齢福祉年金受給者) {
        requireNonNull(老齢福祉年金受給者, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給者"));
        if (!老齢福祉年金受給者.hasChanged()) {
            return false;
        }
        return 1 == dac.saveOrDeletePhysicalBy(老齢福祉年金受給者.toEntity());
    }

    /**
     * 指定の{@link RoreiFukushiNenkinJukyusha 老齢福祉年金受給者}複数件を保存します。
     *
     * @param 老齢福祉年金受給者s {@link RoreiFukushiNenkinJukyusha 老齢福祉年金受給者}複数件
     * @return 更新件数
     */
    @Transaction
    public int save老齢福祉年金受給者All(Iterable<? extends RoreiFukushiNenkinJukyusha> 老齢福祉年金受給者s) {
        requireNonNull(老齢福祉年金受給者s, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給者"));
        int result = 0;
        for (RoreiFukushiNenkinJukyusha t : 老齢福祉年金受給者s) {
            result += save老齢福祉年金受給者(t) ? 1 : 0;
        }
        return result;
    }

    /**
     * 老齢福祉年金情報の取得処理です。
     *
     * @param param RoreiFukushiNenkinJohoMapperParameter 老齢福祉年金情報パラメータ
     * @return List<RoreiFukushiNenkinJukyusha> 老齢福祉年金受給者を管理
     */
    @Transaction
    public List<RoreiFukushiNenkinJukyusha> getRoreiFukushiNenkinJoho(RoreiFukushiNenkinJohoMapperParameter param) {
        List<RoreiFukushiNenkinJukyusha> bRoreilist = new ArrayList();
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = dac.selectfor老齢福祉年金履歴情報を取得(
                param.getShikibetsuCode());
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList();
        }
        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : entityList) {
            RoreiFukushiNenkinJukyusha roreiFukushiNenkinJukyusha = new RoreiFukushiNenkinJukyusha(entity);
            bRoreilist.add(roreiFukushiNenkinJukyusha);
        }
        return bRoreilist;
    }

    /**
     * 老齢福祉年金履歴情報を登録前重複チェックするです。
     *
     * @param addCheck 老齢福祉年金情報パラメータ
     * @return 老齢福祉年金履歴情報件数
     */
    @Transaction
    public int checkSameJukyuKaishibi(RoreiFukushiNenkinJohoMapperParameter addCheck) {
        return dac.countfor老齢福祉年金履歴情報を取得(
                addCheck.getShikibetsuCode(), addCheck.getJukyuKaishiYMD());
    }

    /**
     * 老齢福祉年金受給者判定。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 所得基準年月日 所得基準年月日
     * @return List<DbT7006RoreiFukushiNenkinJukyushaEntity>
     *
     */
    @Transaction
    public boolean 老齢福祉年金受給者判定(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 所得基準年月日) {
        if (dac.count老齢福祉年金受給者(識別コード, 被保険者番号, 所得基準年月日) > 0) {
            return true;
        }
        return false;
    }
}
