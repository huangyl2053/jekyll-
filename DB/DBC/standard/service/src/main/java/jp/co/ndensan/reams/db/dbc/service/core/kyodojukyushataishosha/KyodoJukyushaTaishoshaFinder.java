/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyodojukyushataishosha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushataishosha.KyodoIdoRenrakuhyoTaishoshaKensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushataishosha.KyodoJukyushaTaishoshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyodojukyushataishosha.IKyodoJukyushaTaishoshaFinderMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共同処理用受給者訂正連絡票登録（対象者検索）（画面）
 *
 * @reamsid_L DBC-1951-050 chenaoqi
 */
public class KyodoJukyushaTaishoshaFinder {

    private static final RString SPIT = new RString("～");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_0 = new RString("0");
    private static final int NUM_ZERO = 0;

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KyodoJukyushaTaishoshaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KyodoJukyushaTaishoshaFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link KyodoJukyushaTaishoshaFinder}
     */
    public static KyodoJukyushaTaishoshaFinder createInstance() {
        return InstanceProvider.create(KyodoJukyushaTaishoshaFinder.class);
    }

    /**
     * 共同処理用受給者異動対象者検索処理
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 削除データ検索 boolean
     * @return 対象者一覧情報List
     */
    @Transaction
    public List<KyodoJukyushaTaishoshaEntity> getTaishosha(HihokenshaNo 被保険者番号,
            FlexibleDate 異動日From,
            FlexibleDate 異動日To,
            boolean 削除データ検索) {
        List<KyodoJukyushaTaishoshaEntity> 対象者一覧情報List = new ArrayList<>();
        IKyodoJukyushaTaishoshaFinderMapper mapper = mapperProvider.create(IKyodoJukyushaTaishoshaFinderMapper.class);
        KyodoJukyushaTaishoshaParameter parameter = new KyodoJukyushaTaishoshaParameter();
        parameter.set被保険者番号(被保険者番号);
        parameter.set異動日From(異動日From);
        parameter.set異動日To(異動日To);
        parameter.set削除データ検索(削除データ検索);
        List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> 基本送付情報list = mapper.get基本送付情報(parameter);
        List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> 償還送付情報list = mapper.get償還送付情報(parameter);
        List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> 高額送付情報list = mapper.get高額送付情報(parameter);
        KyodoJukyushaTaishoshaEntity 対象者一覧情報;
        Map map = new HashMap<>();
        RString breakKey;
        for (DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity 基本送付情報Entity : 基本送付情報list) {
            RString 異動日 = 基本送付情報Entity.getIdoYMD() != null
                    ? new RString(基本送付情報Entity.getIdoYMD().toString()) : RString.EMPTY;
            FlexibleYearMonth 送付 = 基本送付情報Entity.getSofuYM();
            RString 送付年月 = 送付 != null
                    ? 送付.toDateString() : RString.EMPTY;
            RString 論理削除フラグ = 基本送付情報Entity.getLogicalDeletedFlag() ? 定数_1 : 定数_0;
            breakKey = 異動日.concat(SPIT).concat(送付年月).concat(SPIT).concat(論理削除フラグ);
            if (map.containsKey(breakKey)) {
                continue;
            }
            map.put(breakKey, true);
            対象者一覧情報 = new KyodoJukyushaTaishoshaEntity();
            対象者一覧情報.set被保番号(基本送付情報Entity.getHiHokenshaNo());
            対象者一覧情報.set異動日(基本送付情報Entity.getIdoYMD());
            対象者一覧情報.set対象年月(基本送付情報Entity.getSofuYM());
            対象者一覧情報.set履歴番号(基本送付情報Entity.getRirekiNo());
            対象者一覧情報.set被保険者氏名(基本送付情報Entity.getHiHokenshaName());
            対象者一覧情報.set論理削除フラグ(基本送付情報Entity.getLogicalDeletedFlag());
            対象者一覧情報List.add(対象者一覧情報);
        }
        for (DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 償還送付情報Entity : 償還送付情報list) {
            RString 異動日 = 償還送付情報Entity.getIdoYMD() != null
                    ? new RString(償還送付情報Entity.getIdoYMD().toString()) : RString.EMPTY;
            FlexibleYearMonth 送付 = 償還送付情報Entity.getSofuYM();
            RString 送付年月 = 送付 != null
                    ? 送付.toDateString() : RString.EMPTY;
            RString 論理削除フラグ = 償還送付情報Entity.getLogicalDeletedFlag() ? 定数_1 : 定数_0;
            breakKey = 異動日.concat(SPIT).concat(送付年月).concat(SPIT).concat(論理削除フラグ);
            if (map.containsKey(breakKey)) {
                continue;
            }
            map.put(breakKey, true);
            対象者一覧情報 = new KyodoJukyushaTaishoshaEntity();
            対象者一覧情報.set被保番号(償還送付情報Entity.getHiHokenshaNo());
            対象者一覧情報.set異動日(償還送付情報Entity.getIdoYMD());
            対象者一覧情報.set対象年月(償還送付情報Entity.getSofuYM());
            対象者一覧情報.set履歴番号(償還送付情報Entity.getRirekiNo());
            対象者一覧情報.set被保険者氏名(get償還被保険者氏名(償還送付情報Entity));
            対象者一覧情報.set論理削除フラグ(償還送付情報Entity.getLogicalDeletedFlag());
            対象者一覧情報List.add(対象者一覧情報);

        }
        for (DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額送付情報Entity : 高額送付情報list) {
            RString 異動日 = 高額送付情報Entity.getIdoYMD() != null
                    ? new RString(高額送付情報Entity.getIdoYMD().toString()) : RString.EMPTY;
            FlexibleYearMonth 送付 = 高額送付情報Entity.getSofuYM();
            RString 送付年月 = 送付 != null
                    ? 送付.toDateString() : RString.EMPTY;
            RString 論理削除フラグ = 高額送付情報Entity.getLogicalDeletedFlag() ? 定数_1 : 定数_0;
            breakKey = 異動日.concat(SPIT).concat(送付年月).concat(SPIT).concat(論理削除フラグ);
            if (map.containsKey(breakKey)) {
                continue;
            }
            map.put(breakKey, true);
            対象者一覧情報 = new KyodoJukyushaTaishoshaEntity();
            対象者一覧情報.set被保番号(高額送付情報Entity.getHiHokenshaNo());
            対象者一覧情報.set異動日(高額送付情報Entity.getIdoYMD());
            対象者一覧情報.set対象年月(高額送付情報Entity.getSofuYM());
            対象者一覧情報.set履歴番号(高額送付情報Entity.getRirekiNo());
            対象者一覧情報.set被保険者氏名(get高額被保険者氏名(高額送付情報Entity));
            対象者一覧情報.set論理削除フラグ(高額送付情報Entity.getLogicalDeletedFlag());
            対象者一覧情報List.add(対象者一覧情報);

        }
        return 対象者一覧情報List;
    }

    private RString get償還被保険者氏名(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 償還送付情報Entity) {
        KyodoJukyushaTaishoshaParameter parameter = new KyodoJukyushaTaishoshaParameter();
        parameter.set被保険者番号(償還送付情報Entity.getHiHokenshaNo());
        parameter.set異動日To(償還送付情報Entity.getIdoYMD());
        IKyodoJukyushaTaishoshaFinderMapper mapper = mapperProvider.create(IKyodoJukyushaTaishoshaFinderMapper.class);
        List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> 基本送付情報list = mapper.get被保険者氏名(parameter);
        if (基本送付情報list == null || 基本送付情報list.isEmpty()) {
            return RString.EMPTY;
        }
        return 基本送付情報list.get(0).getHiHokenshaName();
    }

    private RString get高額被保険者氏名(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額送付情報Entity) {
        KyodoJukyushaTaishoshaParameter parameter = new KyodoJukyushaTaishoshaParameter();
        parameter.set被保険者番号(高額送付情報Entity.getHiHokenshaNo());
        parameter.set異動日To(高額送付情報Entity.getIdoYMD());
        IKyodoJukyushaTaishoshaFinderMapper mapper = mapperProvider.create(IKyodoJukyushaTaishoshaFinderMapper.class);
        List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> 基本送付情報list = mapper.get被保険者氏名(parameter);
        if (基本送付情報list == null || 基本送付情報list.isEmpty()) {
            return RString.EMPTY;
        }
        return 基本送付情報list.get(0).getHiHokenshaName();
    }

    /**
     * 被保険者情報の取得のメソッドです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 被保険者番号 HihokenshaNo
     * @return 被保険者情報 IShikibetsuTaisho
     */
    public IShikibetsuTaisho get被保険者情報(IShikibetsuTaishoPSMSearchKey searchKey, HihokenshaNo 被保険者番号) {
        KyodoIdoRenrakuhyoTaishoshaKensakuParameter parameter = KyodoIdoRenrakuhyoTaishoshaKensakuParameter
                .createSelectByKeyParam(searchKey, 被保険者番号);
        IKyodoJukyushaTaishoshaFinderMapper mapper = mapperProvider.create(IKyodoJukyushaTaishoshaFinderMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSMlist = mapper.get被保険者情報(parameter);
        if (宛名PSMlist == null || 宛名PSMlist.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        } else {
            return ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名PSMlist.get(NUM_ZERO));
        }
    }
}
