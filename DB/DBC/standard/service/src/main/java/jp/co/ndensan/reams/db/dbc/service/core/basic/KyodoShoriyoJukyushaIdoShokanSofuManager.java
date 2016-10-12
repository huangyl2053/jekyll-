/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoShokanSofu;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共同処理用受給者異動償還送付を管理するクラスです。
 */
public class KyodoShoriyoJukyushaIdoShokanSofuManager {

    private final DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac dac;

    /**
     * コンストラクタです。
     */
    public KyodoShoriyoJukyushaIdoShokanSofuManager() {
        dac = InstanceProvider.create(DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac}
     */
    KyodoShoriyoJukyushaIdoShokanSofuManager(DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する共同処理用受給者異動償還送付を返します。
     *
     * @param 異動年月日 IdoYMD
     * @param 異動区分コード IdoKubunCode
     * @param 受給者異動事由 JukyushaIdoJiyu
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return KyodoShoriyoJukyushaIdoShokanSofu
     */
    @Transaction
    public KyodoShoriyoJukyushaIdoShokanSofu get共同処理用受給者異動償還送付(
            FlexibleDate 異動年月日,
            RString 異動区分コード,
            RString 受給者異動事由,
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = dac.selectByKey(
                異動年月日,
                異動区分コード,
                受給者異動事由,
                証記載保険者番号,
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyodoShoriyoJukyushaIdoShokanSofu(entity);
    }

    /**
     * 主キーに合致する共同処理用受給者異動償還送付を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param 異動年月日 IdoYMD
     * @param 履歴番号 RirekiNo
     * @return KyodoShoriyoJukyushaIdoShokanSofu
     */
    @Transaction
    public KyodoShoriyoJukyushaIdoShokanSofu select償還送付ByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = dac.select償還送付ByKey(
                被保険者番号,
                異動年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyodoShoriyoJukyushaIdoShokanSofu(entity);
    }

    /**
     * 共同処理用受給者異動償還送付を全件返します。
     *
     * @return List<KyodoShoriyoJukyushaIdoShokanSofu>
     */
    @Transaction
    public List<KyodoShoriyoJukyushaIdoShokanSofu> get共同処理用受給者異動償還送付一覧() {
        List<KyodoShoriyoJukyushaIdoShokanSofu> businessList = new ArrayList<>();

        for (DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyodoShoriyoJukyushaIdoShokanSofu(entity));
        }

        return businessList;
    }

    /**
     * 共同処理用受給者異動償還送付{@link KyodoShoriyoJukyushaIdoShokanSofu}を保存します。
     *
     * @param 共同処理用受給者異動償還送付 {@link KyodoShoriyoJukyushaIdoShokanSofu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save共同処理用受給者異動償還送付(KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付) {
        requireNonNull(共同処理用受給者異動償還送付, UrSystemErrorMessages.値がnull.getReplacedMessage("共同処理用受給者異動償還送付"));
        if (!共同処理用受給者異動償還送付.hasChanged()) {
            return false;
        }
        return 1 == dac.save(共同処理用受給者異動償還送付.toEntity());
    }
}
