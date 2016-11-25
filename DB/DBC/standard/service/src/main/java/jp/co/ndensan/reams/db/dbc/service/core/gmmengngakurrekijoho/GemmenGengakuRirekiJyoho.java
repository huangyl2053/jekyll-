/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.gmmengngakurrekijoho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.FutanGendogakuRirekiJyohoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.HyojunFutangakuGemmenJyohoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.RiyoshaFutangakuGengakuJyohoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futangendogakurirekijyoho.FutanGendogakuRirekiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hyojunfutangakugemmenjyoho.HyojunFutangakuGemmenJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futangendogakurirekijyoho.IFutanGendogakuRirekiJyohoMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hyojunfutangakugemmenjyoho.IHyojunFutangakuGemmenJyohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4014RiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * GemmenGengakuRirekiJyoho_減免・減額履歴情報(画面)のクラスです。
 *
 * @reamsid_L DBC-4350-090 liuxiaoyu
 */
public class GemmenGengakuRirekiJyoho {

    private static final RString 減免_減額種類_03 = new RString("03");
    private static final RString 減免_減額種類_04 = new RString("04");
    private static final RString 軽減率_0 = new RString("0");
    private static final RString スラッシュ = new RString("/");
    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private final MapperProvider mapperProvider;
    private final DbT4014RiyoshaFutangakuGengakuDac dbt4014Dac;
    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac dbt4017Dac;

    /**
     * コンストラクタです。
     */
    public GemmenGengakuRirekiJyoho() {

        this.dbt4014Dac = InstanceProvider.create(DbT4014RiyoshaFutangakuGengakuDac.class);
        this.dbt4017Dac = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GemmenGengakuRirekiJyoho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link GemmenGengakuRirekiJyoho}のインスタンス
     */
    public static GemmenGengakuRirekiJyoho createInstance() {
        return InstanceProvider.create(GemmenGengakuRirekiJyoho.class);
    }

    /**
     * 減免・減額履歴情報(画面)の負担限度額履歴情報取得ンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     *
     * @return List<FutanGendogakuRirekiJyohoEntity>
     */
    public List<FutanGendogakuRirekiJyohoEntity> getFutanGendogakuRirekiJyoho(HihokenshaNo 被保険者番号) {

        IFutanGendogakuRirekiJyohoMapper mapper = mapperProvider.create(IFutanGendogakuRirekiJyohoMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_被保険者番号.toString(), 被保険者番号);
        List<FutanGendogakuRirekiJyohoRelateEntity> dbList = mapper.get負担限度額履歴情報(param);
        if (dbList == null) {
            return new ArrayList<>();
        } else {
            List<FutanGendogakuRirekiJyohoEntity> list = new ArrayList<>();
            FutanGendogakuRirekiJyohoEntity entity;
            for (FutanGendogakuRirekiJyohoRelateEntity relateEntity : dbList) {
                entity = new FutanGendogakuRirekiJyohoEntity();
                entity.set減免_減額種類(relateEntity.get減免_減額種類());
                entity.set適用開始日(relateEntity.get適用開始日());
                entity.set適用終了日(relateEntity.get適用終了日());
                entity.set食費負担限度額(relateEntity.get食費負担限度額());
                entity.setユニット型個室(relateEntity.getユニット型個室());
                entity.setユニット型準個室(relateEntity.getユニット型準個室());
                entity.set従来型個室_特養等(relateEntity.get従来型個室_特養等());
                entity.set従来型個室_老健_療養等(relateEntity.get従来型個室_老健_療養等());
                entity.set多床室(relateEntity.get多床室());
                list.add(entity);
            }
            return list;
        }
    }

    /**
     * 減免・減額履歴情報(画面)の利用者負担額減額履歴情報取得ンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     *
     * @return list List<RiyoshaFutangakuGengakuJyohoEntity>
     */
    public List<RiyoshaFutangakuGengakuJyohoEntity> getRiyoshaFutangakuGengakuJyoho(HihokenshaNo 被保険者番号) {

        RiyoshaFutangakuGengakuJyohoEntity entity;
        List<RiyoshaFutangakuGengakuJyohoEntity> list = new ArrayList<>();
        List<DbT4014RiyoshaFutangakuGengakuEntity> dblist = dbt4014Dac.
                get利用者負担額減額履歴情報(被保険者番号);

        if (dblist != null && !dblist.isEmpty()) {
            for (DbT4014RiyoshaFutangakuGengakuEntity dbt4014Entity : dblist) {
                entity = new RiyoshaFutangakuGengakuJyohoEntity(
                        減免_減額種類_03,
                        dbt4014Entity.getTekiyoKaishiYMD(),
                        dbt4014Entity.getTekiyoShuryoYMD(),
                        dbt4014Entity.getKyuhuritsu());

                list.add(entity);
            }
        }
        return list;
    }

    /**
     * 減免・減額履歴情報(画面)の社会福祉法人等利用者負担軽減履歴情報取得ンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     *
     * @return list List<ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity>
     */
    public List<ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity> getShakaiFukushiHojinRiyoshaFutanKeigenJyoho(
            HihokenshaNo 被保険者番号) {
        RString 軽減率;
        Decimal 軽減率_分子;
        Decimal 軽減率_分母;
        ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity entity;
        List<ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity> list = new ArrayList<>();
        List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> dblist = dbt4017Dac.
                get社会福祉法人等利用者負担軽減履歴情報(被保険者番号);

        if (dblist != null && !dblist.isEmpty()) {
            for (DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity dbt4017Entity : dblist) {
                軽減率_分子 = dbt4017Entity.getKeigenritsu_Bunshi();
                軽減率_分母 = dbt4017Entity.getKeigenritsu_Bumbo();
                if (軽減率_分母 == null || Decimal.ZERO.equals(軽減率_分母)) {
                    軽減率 = 軽減率_0;
                } else if (軽減率_分子 == null) {
                    軽減率_分子 = Decimal.ZERO;
                    軽減率 = new RString(軽減率_分子.intValue() + スラッシュ.toString() + 軽減率_分母.intValue());
                } else {
                    軽減率 = new RString(軽減率_分子.intValue() + スラッシュ.toString() + 軽減率_分母.intValue());
                }
                entity = new ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity(
                        減免_減額種類_04,
                        dbt4017Entity.getTekiyoKaishiYMD(),
                        dbt4017Entity.getTekiyoShuryoYMD(),
                        軽減率);
                list.add(entity);
            }
        }

        return list;
    }

    /**
     * 減免・減額履歴情報(画面)の標準負担額減免履歴情報取得ンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     *
     * @return list List<HyojunFutangakuGemmenJyohoEntity>
     */
    public List<HyojunFutangakuGemmenJyohoEntity> getHyojunFutangakuGemmenJyoho(HihokenshaNo 被保険者番号) {
        IHyojunFutangakuGemmenJyohoMapper mapper = mapperProvider.create(IHyojunFutangakuGemmenJyohoMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_被保険者番号.toString(), 被保険者番号);
        List<HyojunFutangakuGemmenJyohoRelateEntity> dbList = mapper.get標準負担額減免履歴情報(param);
        if (dbList == null) {
            return new ArrayList<>();
        } else {
            List<HyojunFutangakuGemmenJyohoEntity> list = new ArrayList<>();
            HyojunFutangakuGemmenJyohoEntity entity;
            for (HyojunFutangakuGemmenJyohoRelateEntity relateEntity : dbList) {
                entity = new HyojunFutangakuGemmenJyohoEntity();
                entity.set減免_減額種類(relateEntity.get減免_減額種類());
                entity.set適用開始日(relateEntity.get適用開始日());
                entity.set適用終了日(relateEntity.get適用終了日());
                entity.set負担額(relateEntity.get負担額());
                list.add(entity);
            }
            return list;
        }
    }

}
