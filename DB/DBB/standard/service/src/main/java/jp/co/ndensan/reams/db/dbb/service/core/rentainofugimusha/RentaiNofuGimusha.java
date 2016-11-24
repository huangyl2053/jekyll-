/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.rentainofugimusha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.business.core.rentainofugimusha.AtenaJouhou;
import jp.co.ndensan.reams.db.dbb.business.core.rentainofugimusha.RentaiGimushaAtenaJouhou;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2009RentaiGimushaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBMN71001_連帯納付義務者登録のクラス
 *
 * @reamsid_L DBB-1640-020 lijunjun
 */
public class RentaiNofuGimusha {

    private final DbT2009RentaiGimushaDac 連帯納付義務者Dac;

    RentaiNofuGimusha() {
        連帯納付義務者Dac = InstanceProvider.create(DbT2009RentaiGimushaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RentaiNofuGimusha}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RentaiNofuGimusha}のインスタンス
     */
    public static RentaiNofuGimusha createInstance() {
        return InstanceProvider.create(RentaiNofuGimusha.class);
    }

    /**
     * 直近世帯一覧取得のメソッド
     *
     * @param 世帯コード SetaiCode
     * @return 世帯宛名情報リスト
     */
    public List<AtenaJouhou> getLastSetaiIchiran(SetaiCode 世帯コード) {
        IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoSearchKey 検索キー = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true)
                .set世帯コード(世帯コード).build();
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(検索キー);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM = InstanceProvider.create(
                UaFt200FindShikibetsuTaishoFunctionDac.class).select(psm);
        List<AtenaJouhou> 世帯宛名情報リスト = new ArrayList<>();
        for (UaFt200FindShikibetsuTaishoEntity entity : 宛名PSM) {
            AtenaJouhou 世帯宛名情報Entity = new AtenaJouhou();
            世帯宛名情報Entity.set識別コード(entity.getShikibetsuCode());
            世帯宛名情報Entity.set個人番号(entity.getKojinNo());
            世帯宛名情報Entity.set氏名(entity.getMeisho());
            世帯宛名情報Entity.set生年月日(entity.getSeinengappiYMD());
            世帯宛名情報Entity.set性別(entity.getSeibetsuCode());
            世帯宛名情報Entity.set住民種別(entity.getJuminJotaiCode());
            世帯宛名情報Entity.set続柄(entity.getTsuzukigara());
            世帯宛名情報Entity.set世帯コード(entity.getSetaiCode());
            世帯宛名情報Entity.set住所(entity.getJusho());
            世帯宛名情報リスト.add(世帯宛名情報Entity);
        }
        return 世帯宛名情報リスト;
    }

    /**
     * 連帯納付義務者宛名情報取得
     *
     * @param 連帯納付義務者リスト List<RentaiGimusha>
     * @return 連帯納付義務者宛名情報リスト
     */
    public List<RentaiGimushaAtenaJouhou> getRentaiNofuGimushaAtenaInfo(
            List<RentaiGimusha> 連帯納付義務者リスト) {
        List<RentaiGimushaAtenaJouhou> 連帯納付義務者宛名情報リスト = new ArrayList<>();
        RentaiGimushaAtenaJouhou 連帯納付義務者宛名情報;
        for (RentaiGimusha 連帯納付義務者 : 連帯納付義務者リスト) {
            DbT2009RentaiGimushaEntity 連帯納付義務者entity = 連帯納付義務者.toEntity();
            IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                    GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
            IShikibetsuTaishoSearchKey 検索キー = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true)
                    .set識別コード(連帯納付義務者entity.getShikibetuCode()).build();
            IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(検索キー);
            List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM = InstanceProvider.create(
                    UaFt200FindShikibetsuTaishoFunctionDac.class).select(psm);
            for (UaFt200FindShikibetsuTaishoEntity 宛名entity : 宛名PSM) {
                連帯納付義務者宛名情報 = new RentaiGimushaAtenaJouhou();
                連帯納付義務者宛名情報.set開始日(連帯納付義務者entity.getStartYMD());
                連帯納付義務者宛名情報.set終了日(連帯納付義務者entity.getEndYMD());
                連帯納付義務者宛名情報.set識別コード(連帯納付義務者entity.getShikibetuCode());
                連帯納付義務者宛名情報.set個人番号(宛名entity.getKojinNo());
                連帯納付義務者宛名情報.set世帯コード(宛名entity.getSetaiCode());
                連帯納付義務者宛名情報.set氏名(宛名entity.getMeisho());
                連帯納付義務者宛名情報.set生年月日(宛名entity.getSeinengappiYMD());
                連帯納付義務者宛名情報.set性別(宛名entity.getSeibetsuCode());
                連帯納付義務者宛名情報.set住民種別(宛名entity.getJuminJotaiCode());
                連帯納付義務者宛名情報.set続柄(宛名entity.getTsuzukigara());
                連帯納付義務者宛名情報.set住所(宛名entity.getJusho());
                連帯納付義務者宛名情報.set履歴番号(連帯納付義務者entity.getRirekiNo().intValue());
                連帯納付義務者宛名情報.set状態(連帯納付義務者entity.getState());
                連帯納付義務者宛名情報リスト.add(連帯納付義務者宛名情報);
            }
        }
        return 連帯納付義務者宛名情報リスト;
    }

    /**
     * 連帯納付義務者情報取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 連帯納付義務者宛名情報リスト
     */
    public List<RentaiGimusha> getRentaiNofuGimushaInfo(HihokenshaNo 被保険者番号) {
        List<DbT2009RentaiGimushaEntity> 連帯納付義務者情報リスト = 連帯納付義務者Dac
                .selectBy連帯納付義務者宛名情報リスト(被保険者番号);
        List<RentaiGimusha> 連帯納付義務者リスト = new ArrayList<>();
        if (連帯納付義務者情報リスト != null && !連帯納付義務者情報リスト.isEmpty()) {
            for (DbT2009RentaiGimushaEntity entity : 連帯納付義務者情報リスト) {
                連帯納付義務者リスト.add(new RentaiGimusha(entity));
            }
        }
        return 連帯納付義務者リスト;
    }

    /**
     * 連帯納付義務者情報削除
     *
     * @param 連帯納付義務者情報リスト List<RentaiGimushaAtenaJouhouEntity>
     * @return 削除件数
     */
    public int delRentaiNofuGimushaInfo(List<RentaiGimusha> 連帯納付義務者情報リスト) {

        int 削除件数 = 0;
        for (RentaiGimusha 連帯納付義務者 : 連帯納付義務者情報リスト) {
            DbT2009RentaiGimushaEntity 連帯納付義務者Entity = 連帯納付義務者.toEntity();
            連帯納付義務者Entity.setState(EntityDataState.Deleted);
            連帯納付義務者Dac.delete(連帯納付義務者Entity);
            削除件数++;
        }
        return 削除件数;
    }

    /**
     * 連帯納付義務者情報登録
     *
     * @param 連帯納付義務者情報リスト List<DbT2009RentaiGimushaEntity>
     * @param 被保険者番号 HihokenshaNo
     */
    public void insRentaiNofuGimushaInfo(
            List<RentaiGimusha> 連帯納付義務者情報リスト,
            HihokenshaNo 被保険者番号) {
        Decimal 履歴番号;
        if (連帯納付義務者情報リスト != null && !連帯納付義務者情報リスト.isEmpty()) {
            for (RentaiGimusha 連帯納付義務者 : 連帯納付義務者情報リスト) {
                DbT2009RentaiGimushaEntity 連帯納付義務者Entity = 連帯納付義務者.toEntity();
                if (連帯納付義務者.isAdded() || 連帯納付義務者.isModified() || 連帯納付義務者.isUnchanged()) {
                    連帯納付義務者Entity.setHihokenshaNo(被保険者番号);
                    連帯納付義務者Entity.setRirekiNo(連帯納付義務者Entity.getRirekiNo());
                    連帯納付義務者Entity.setShikibetuCode(連帯納付義務者.get識別コード());
                    連帯納付義務者Entity.setStartYMD(連帯納付義務者.get開始年月日());
                    連帯納付義務者Entity.setEndYMD(連帯納付義務者.get終了年月日());
                    連帯納付義務者Entity.setState(EntityDataState.Added);
                    連帯納付義務者Dac.save(連帯納付義務者Entity);
                }
            }
        }
    }

}
