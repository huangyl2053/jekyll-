/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.kyokaisogaitosha;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoGaito;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoGaitoshaJoho;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoHokenryo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.basic.kyokaisogaitosha.IKyokaisoGaitoshaMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1007KyokaisoHokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1013KyokaisoSochiShinseiDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層該当者台帳管理するクラスです。
 */
public class KyokaisoGaitoshaManager {

    private static final RString 被保険者 = new RString("被保険者番号");
    private final MapperProvider mapperProvider;
    private final DbT1006KyokaisoGaitoshaDac gaitoshaDac;
    private final DbT1007KyokaisoHokenryoDankaiDac hokenryoDankaiDac;
    private final DbT1013KyokaisoSochiShinseiDac sochiShinseiDac;

    /**
     * コンストラクタです。
     */
    KyokaisoGaitoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.gaitoshaDac = InstanceProvider.create(DbT1006KyokaisoGaitoshaDac.class);
        this.hokenryoDankaiDac = InstanceProvider.create(DbT1007KyokaisoHokenryoDankaiDac.class);
        this.sochiShinseiDac = InstanceProvider.create(DbT1013KyokaisoSochiShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param gaitoshaDac DbT1006KyokaisoGaitoshaDac
     * @param hokenryoDankaiDac DbT1007KyokaisoHokenryoDankaiDac
     * @param sochiShinseiDac DbT1013KyokaisoSochiShinseiDac
     */
    KyokaisoGaitoshaManager(
            MapperProvider mapperProvider,
            DbT1006KyokaisoGaitoshaDac gaitoshaDac,
            DbT1007KyokaisoHokenryoDankaiDac hokenryoDankaiDac,
            DbT1013KyokaisoSochiShinseiDac sochiShinseiDac) {
        this.mapperProvider = mapperProvider;
        this.gaitoshaDac = gaitoshaDac;
        this.hokenryoDankaiDac = hokenryoDankaiDac;
        this.sochiShinseiDac = sochiShinseiDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyokaisoGaitoshaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KyokaisoGaitoshaManager}のインスタンス
     */
    public static KyokaisoGaitoshaManager createInstance() {
        return InstanceProvider.create(KyokaisoGaitoshaManager.class);
    }

    /**
     * 境界層該当一覧情報の取得処理します。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KyokaisoGaitoshaJoho> 境界層該当者一覧情報
     */
    @Transaction
    public SearchResult<KyokaisoGaitoshaJoho> getKyokaisoGaitoshaJohoList(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        List<KyokaisoGaitoshaJoho> 境界層該当者一覧情報リスト = new ArrayList<>();
        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        IKyokaisoGaitoshaMapper gaitoshaMapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);
        List<KyokaisoGaitoshaJohoRelateEntity> 境界層該当者一覧リスト = gaitoshaMapper.select一覧情報(parameter);
        for (KyokaisoGaitoshaJohoRelateEntity entity : 境界層該当者一覧リスト) {
            境界層該当者一覧情報リスト.add(new KyokaisoGaitoshaJoho(entity));
        }
        return SearchResult.of(境界層該当者一覧情報リスト, 0, false);
    }

    /**
     * 境界層保険料段階グリッド情報の取得処理します。
     *
     * @param 被保険者番号 被保険者番号
     * @param リンク番号 リンク番号
     * @return SearchResult<KyokaisoHokenryoDankai> 境界層保険料段階情報
     */
    @Transaction
    public SearchResult<KyokaisoHokenryo> getKyokaisoHokenryoDakaiJohoList(
            HihokenshaNo 被保険者番号,
            Decimal リンク番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        List<KyokaisoHokenryo> 境界層保険料段階リスト = new ArrayList<>();
        SearchResult<DbT1007KyokaisoHokenryoDankaiEntity> searchResultEntity
                = hokenryoDankaiDac.select境界層保険料段階リスト(被保険者番号, リンク番号, false);
        for (DbT1007KyokaisoHokenryoDankaiEntity entity : searchResultEntity.records()) {
            境界層保険料段階リスト.add(new KyokaisoHokenryo(entity));
        }
        return SearchResult.of(境界層保険料段階リスト, 0, false);
    }

    /**
     * 境界層該当情報の登録処理します。
     *
     * @param kyokaisoGaito 境界層該当者管理Div
     * @param 被保険者番号 被保険者番号
     * @return 登録件数
     */
    @Transaction
    public int regKyokaisoGaitoshaJoho(
            KyokaisoGaito kyokaisoGaito, HihokenshaNo 被保険者番号
    ) {
        int 登録件数 = 0;
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        for (KyokaisoGaitosha gaitosha : kyokaisoGaito.get境界層該当者List()) {
            save境界層該当者(gaitosha.toEntity());
            登録件数 = 登録件数 + 1;
        }
        for (KyokaisoSochiShinsei shinsei : kyokaisoGaito.get境界層措置申請Lsit()) {
            save境界層措置申請(shinsei.toEntity());
            登録件数 = 登録件数 + 1;
        }
        for (KyokaisoHokenryoDankai hokenryoDankai : kyokaisoGaito.get境界層保険料段階List()) {
            save境界層保険料段階(hokenryoDankai.toEntity());
            登録件数 = 登録件数 + 1;
        }
        return 登録件数;
    }

    /**
     * 境界層該当情報の更新処理します。
     *
     * @param kyokaisoGaito 境界層該当者管理Div
     * @param 被保険者番号 被保険者番号
     * @return 更新件数
     */
    @Transaction
    public int updKyokaisoGaitoshaJoho(
            KyokaisoGaito kyokaisoGaito,
            HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        int 更新件数 = 0;
        for (KyokaisoGaitosha gaitosha : kyokaisoGaito.get境界層該当者List()) {
            save境界層該当者(gaitosha.toEntity());
            更新件数 = 更新件数 + 1;
        }
        for (KyokaisoSochiShinsei shinsei : kyokaisoGaito.get境界層措置申請Lsit()) {
            save境界層措置申請(shinsei.toEntity());
            更新件数 = 更新件数 + 1;
        }
        for (KyokaisoHokenryoDankai hokenryoDankai : kyokaisoGaito.get境界層保険料段階List()) {
            save境界層保険料段階(hokenryoDankai.toEntity());
            更新件数 = 更新件数 + 1;
        }
        return 更新件数;
    }

    /**
     * 境界層該当情報の削除処理します。
     *
     * @param kyokaisoGaito 境界層該当者管理Div
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param リンク番号 リンク番号
     * @return 削除件数
     */
    @Transaction
    public int delKyokaisoGaitoshaJoho(
            KyokaisoGaito kyokaisoGaito,
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal リンク番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        int 削除件数 = 0;
        for (KyokaisoGaitosha gaitosha : kyokaisoGaito.get境界層該当者List()) {
            save境界層該当者(gaitosha.toEntity());
            削除件数 = 削除件数 + 1;
        }
        for (KyokaisoSochiShinsei shinsei : kyokaisoGaito.get境界層措置申請Lsit()) {
            save境界層措置申請(shinsei.toEntity());
            削除件数 = 削除件数 + 1;
        }
        for (KyokaisoHokenryoDankai hokenryoDankai : kyokaisoGaito.get境界層保険料段階List()) {
            save境界層保険料段階(hokenryoDankai.toEntity());
            削除件数 = 削除件数 + 1;
        }
        return 削除件数;
    }

    /**
     * 境界層該当一覧情報の取得処理します。
     *
     * @param 被保険者番号 被保険者番号
     * @return KyokaisoGaito 境界層該当者一覧情報
     */
    @Transaction
    public KyokaisoGaito get境界層該当者情報(
            HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        KyokaisoGaito business = new KyokaisoGaito();
        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        IKyokaisoGaitoshaMapper gaitoshaMapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);
        List<KyokaisoGaitoRelateEntity> kyokaisoGaitoList = gaitoshaMapper.select境界層該当者(parameter);
        for (KyokaisoGaitoRelateEntity relateEntity : kyokaisoGaitoList) {
            List<DbT1006KyokaisoGaitoshaEntity> gaitoshaEntityList = relateEntity.get境界層該当者EntityList();
            List<DbT1013KyokaisoSochiShinseiEntity> shinseiEntityList = relateEntity.get境界層措置申請EntityLsit();
            get境界層該当者(gaitoshaEntityList, shinseiEntityList, business);
        }

        return business;
    }

    /**
     * 境界層保険料段階グリッド情報の取得処理します。
     *
     * @param 被保険者番号 被保険者番号
     * @param リンク番号 リンク番号
     * @return KyokaisoGaito 境界層保険料段階情報
     */
    @Transaction
    public KyokaisoGaito get境界層保険料段階情報(
            HihokenshaNo 被保険者番号,
            Decimal リンク番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        KyokaisoGaito business = new KyokaisoGaito();
        List<KyokaisoHokenryoDankai> 境界層保険料段階リスト = new ArrayList<>();
        SearchResult<DbT1007KyokaisoHokenryoDankaiEntity> searchResultEntity
                = hokenryoDankaiDac.select境界層保険料段階リスト(被保険者番号, リンク番号, false);
        for (DbT1007KyokaisoHokenryoDankaiEntity entity : searchResultEntity.records()) {
            entity.initializeMd5();
            境界層保険料段階リスト.add(new jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai(entity));
            business.set境界層保険料段階List(境界層保険料段階リスト);
        }
        return business;
    }

    /**
     * 最新履歴番号を取得します。
     *
     * @param parameter 被保険者番号
     * @return 最新履歴番号
     */
    public Decimal get最新履歴番号(KyokaisoGaitoshaParameter parameter) {
        IKyokaisoGaitoshaMapper gaitoshaMapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);
        Decimal 最新履歴番号 = gaitoshaMapper.selcet最新履歴番号(parameter);
        if (最新履歴番号 == null) {
            最新履歴番号 = new Decimal(1);
        } else {
            最新履歴番号 = new Decimal(最新履歴番号.intValue() + 1);
        }
        return 最新履歴番号;
    }

    /**
     * 最新リンク番号を取得します。
     *
     * @param parameter 被保険者番号
     * @return 最新リンク番号
     */
    public Decimal get最新リンク番号(KyokaisoGaitoshaParameter parameter) {
        IKyokaisoGaitoshaMapper gaitoshaMapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);
        Decimal 最新リンク番号 = gaitoshaMapper.selcet最新リンク番号(parameter);
        if (最新リンク番号 == null) {
            最新リンク番号 = new Decimal(1);
        } else {
            最新リンク番号 = new Decimal(最新リンク番号.intValue() + 1);
        }
        return 最新リンク番号;
    }

    private void save境界層該当者(DbT1006KyokaisoGaitoshaEntity gaitoshaEntity) {
        gaitoshaDac.save(gaitoshaEntity);
    }

    private void save境界層措置申請(DbT1013KyokaisoSochiShinseiEntity sochiShinseiEntity) {
        sochiShinseiDac.save(sochiShinseiEntity);
    }

    private void save境界層保険料段階(DbT1007KyokaisoHokenryoDankaiEntity hokenryoDankaiEntity) {
        hokenryoDankaiDac.save(hokenryoDankaiEntity);
    }

    private void get境界層該当者(
            List<DbT1006KyokaisoGaitoshaEntity> gaitoshaEntityList,
            List<DbT1013KyokaisoSochiShinseiEntity> shinseiEntityList,
            KyokaisoGaito business) {
        List<KyokaisoGaitosha> 境界層該当者List = new ArrayList<>();
        for (DbT1006KyokaisoGaitoshaEntity gaitoshaEntity : gaitoshaEntityList) {
            gaitoshaEntity.initializeMd5();
            境界層該当者List.add(new KyokaisoGaitosha(gaitoshaEntity));
            business.set境界層該当者List(境界層該当者List);
        }
        List<KyokaisoSochiShinsei> 境界層措置申請Lsit = new ArrayList<>();
        for (DbT1013KyokaisoSochiShinseiEntity shinseiEntity : shinseiEntityList) {
            shinseiEntity.initializeMd5();
            境界層措置申請Lsit.add(new KyokaisoSochiShinsei(shinseiEntity));
            business.set境界層措置申請Lsit(境界層措置申請Lsit);
        }
    }
}
