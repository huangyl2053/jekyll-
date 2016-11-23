/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigohihokenshainfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2009RentaiGimushaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.IDbT2009RentaiGimushaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.mapper.IUaFt200FindShikibetsuTaishoFunctionMapper;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 連帯納付義務者登録Mangerです。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public class KaigoHihokenshaInfoPanelManger {

    private final DbT2009RentaiGimushaDac rentaiGimushaDac;
    private final MapperProvider mapperProvider;

    /**
     * サービス種類登録クラスのコンストラクタです。
     */
    public KaigoHihokenshaInfoPanelManger() {

        rentaiGimushaDac = InstanceProvider.create(DbT2009RentaiGimushaDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 利サービス種類登録クラスのコンストラクタです(テスト用)。
     *
     * @param kaigoServiceDac rentaigimushaDac
     */
    KaigoHihokenshaInfoPanelManger(DbT2009RentaiGimushaDac rentaiGimushaDac) {

        this.rentaiGimushaDac = rentaiGimushaDac;
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 連帯納付義務者登録を取得します。
     *
     * @param entity DbT2009RentaiGimushaEntity
     */
    public void save(RentaiGimusha entity) {
        rentaiGimushaDac.save(entity.toEntity());
    }

    /**
     * 連帯納付義務者登録を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 履歴番号
     */
    public Decimal get最新履歴番号(HihokenshaNo 被保険者番号) {
        DbT2009RentaiGimushaEntity entity = rentaiGimushaDac.selectBy連帯納付義務者_履歴番号(被保険者番号);
        if (entity != null) {
            return entity.getRirekiNo();
        }
        return null;
    }

    /**
     * 連帯納付義務者登録を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 履歴番号
     */
    public Decimal getNoIsDeleted最新履歴番号(HihokenshaNo 被保険者番号) {
        IDbT2009RentaiGimushaMapper mapper = mapperProvider.create(IDbT2009RentaiGimushaMapper.class);
        DbT2009RentaiGimushaEntity entity = mapper.selectBy連帯納付義務者_履歴番号(被保険者番号);
        if (entity != null) {
            return entity.getRirekiNo();
        }
        return null;
    }

    /**
     * 画面．宛名情報を取得する。
     *
     * @param parameter IShikibetsuTaishoPSMSearchKey
     * @return 宛名情報
     */
    public IShikibetsuTaisho get宛名情報(IShikibetsuTaishoPSMSearchKey parameter) {
        UaFt200FindShikibetsuTaishoParam param = new UaFt200FindShikibetsuTaishoParam(parameter);
        IUaFt200FindShikibetsuTaishoFunctionMapper mapper = mapperProvider.create(IUaFt200FindShikibetsuTaishoFunctionMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSMlist = mapper.selectByParameterClass(param);
        if (宛名PSMlist == null || 宛名PSMlist.isEmpty()) {
            return null;
        } else {
            return ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名PSMlist.get(0));
        }
    }

    /**
     * 修正処理を保存します。
     *
     * @param entity RentaiGimusha
     */
    public void saveModify(RentaiGimusha entity) {
        rentaiGimushaDac.save(entity.deleted().toEntity());
        DbT2009RentaiGimushaEntity 計算結果Entity = entity.toEntity();
        計算結果Entity.setRirekiNo(new Decimal(計算結果Entity.getRirekiNo().intValue() + 1));
        計算結果Entity.setState(EntityDataState.Added);
        rentaiGimushaDac.save(計算結果Entity);

    }

    /**
     * 修正処理を保存します。
     *
     * @param entity RentaiGimusha
     */
    public void saveNewModify(RentaiGimusha entity) {
        rentaiGimushaDac.save(entity.deleted().toEntity());
        DbT2009RentaiGimushaEntity 計算結果Entity = entity.toEntity();
        Decimal 最新履歴番号 = getNoIsDeleted最新履歴番号(計算結果Entity.getHihokenshaNo());
        計算結果Entity.setRirekiNo(new Decimal(最新履歴番号.intValue() + 1));
        計算結果Entity.setState(EntityDataState.Added);
        rentaiGimushaDac.save(計算結果Entity);

    }

    /**
     * 主キーに合致する居宅サービス区分支給限度額を削除する。
     *
     * @param entity DbT2009RentaiGimushaEntity
     */
    public void データを物理削除する(DbT2009RentaiGimushaEntity entity) {
        entity.initializeMd5();
        rentaiGimushaDac.delete(entity);
    }
}
