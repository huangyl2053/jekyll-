/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKihonSofu;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共同処理用受給者異動基本送付を管理するクラスです。
 */
public class KyodoShoriyoJukyushaIdoKihonSofuManager {

    private final DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac dac;

    /**
     * コンストラクタです。
     */
    public KyodoShoriyoJukyushaIdoKihonSofuManager() {
        dac = InstanceProvider.create(DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac}
     */
    KyodoShoriyoJukyushaIdoKihonSofuManager(DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する共同処理用受給者異動基本送付を返します。
     *
     * @param 異動年月日 IdoYMD
     * @param 異動区分コード IdoKubunCode
     * @param 受給者異動事由 JukyushaIdoJiyu
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return KyodoShoriyoJukyushaIdoKihonSofu
     */
    @Transaction
    public KyodoShoriyoJukyushaIdoKihonSofu get共同処理用受給者異動基本送付(
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

        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity = dac.selectByKey(
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
        return new KyodoShoriyoJukyushaIdoKihonSofu(entity);
    }

    /**
     * 主キーに合致する共同処理用受給者異動基本送付を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param 異動年月日 IdoYMD
     * @param 履歴番号 RirekiNo
     * @return KyodoShoriyoJukyushaIdoKihonSofu
     */
    @Transaction
    public KyodoShoriyoJukyushaIdoKihonSofu select基本送付ByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity = dac.select基本送付ByKey(
                被保険者番号,
                異動年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyodoShoriyoJukyushaIdoKihonSofu(entity);
    }

    /**
     * 共同処理用受給者異動基本送付を全件返します。
     *
     * @return List<KyodoShoriyoJukyushaIdoKihonSofu>
     */
    @Transaction
    public List<KyodoShoriyoJukyushaIdoKihonSofu> get共同処理用受給者異動基本送付一覧() {
        List<KyodoShoriyoJukyushaIdoKihonSofu> businessList = new ArrayList<>();

        for (DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyodoShoriyoJukyushaIdoKihonSofu(entity));
        }

        return businessList;
    }

    /**
     * 共同処理用受給者異動基本送付{@link KyodoShoriyoJukyushaIdoKihonSofu}を保存します。
     *
     * @param 共同処理用受給者異動基本送付 {@link KyodoShoriyoJukyushaIdoKihonSofu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save共同処理用受給者異動基本送付(KyodoShoriyoJukyushaIdoKihonSofu 共同処理用受給者異動基本送付) {
        requireNonNull(共同処理用受給者異動基本送付, UrSystemErrorMessages.値がnull.getReplacedMessage("共同処理用受給者異動基本送付"));
        if (!共同処理用受給者異動基本送付.hasChanged()) {
            return false;
        }
        return 1 == dac.save(共同処理用受給者異動基本送付.toEntity());
    }
}
