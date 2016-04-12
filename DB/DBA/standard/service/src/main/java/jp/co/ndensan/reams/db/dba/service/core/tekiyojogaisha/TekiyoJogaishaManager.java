/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelate;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha.ITekiyoJogaishaMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者を管理するクラスです。
 *
 * @reamsid_L DBA-0210-020 dingyi
 */
public class TekiyoJogaishaManager {

    private static final int AGE_65 = 65;
    private static final RString 識別コード = new RString("識別コード");
    private final MapperProvider mapperProvider;
    private final DbT1002TekiyoJogaishaDac 適用除外者Dac;
    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager;
    private static boolean 退所日ありフラグ;

    /**
     * コンストラクタです。
     */
    TekiyoJogaishaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.適用除外者Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        this.介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 適用除外者Dac 適用除外者Dac
     * @param 介護保険施設入退所Manager 介護保険施設入退所Manager
     */
    TekiyoJogaishaManager(
            MapperProvider mapperProvider,
            DbT1002TekiyoJogaishaDac 適用除外者Dac,
            ShisetsuNyutaishoManager 介護保険施設入退所Manager,
            DbT1004ShisetsuNyutaishoDac 介護保険施設入退所dac) {
        this.mapperProvider = mapperProvider;
        this.適用除外者Dac = 適用除外者Dac;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaManager}のインスタンス
     */
    public static TekiyoJogaishaManager createInstance() {
        return InstanceProvider.create(TekiyoJogaishaManager.class);
    }

    /**
     * 適用除外者の取得処理をします。
     *
     * @param shikibetsuCode 識別コード
     * @param ronrisakujyoFlg 論理削除フラグ
     * @return SearchResult<TekiyoJogaishaRelate> 適用除外者の管理情報
     */
    @Transaction
    public SearchResult<TekiyoJogaishaRelate> getTekiyoJogaishaLst(ShikibetsuCode shikibetsuCode, boolean ronrisakujyoFlg) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        List<TekiyoJogaishaRelate> tekiyoJogaishaRelateList = new ArrayList<>();
        TekiyoJogaishaMapperParameter 適用除外者Parameter = TekiyoJogaishaMapperParameter.
                createParam_get適用除外者(shikibetsuCode, ronrisakujyoFlg);
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        List<TekiyoJogaishaRelateEntity> 適用除外者List = mapper.get適用除外者(適用除外者Parameter);
        if (適用除外者List == null || 適用除外者List.isEmpty()) {
            return SearchResult.of(Collections.<TekiyoJogaishaRelate>emptyList(), 0, false);
        }
        for (TekiyoJogaishaRelateEntity entity : 適用除外者List) {
            退所日ありフラグ = true;
            TekiyoJogaishaMapperParameter 施設情報Parameter = TekiyoJogaishaMapperParameter.createParam_get施設情報(
                    entity.getShikibetsuCode(),
                    entity.getKaijoYMD(),
                    entity.getTekiyoYMD());
            List<TekiyoJogaishaRelateEntity> 施設情報List = mapper.get施設情報(施設情報Parameter);
            if (施設情報List == null || 施設情報List.isEmpty()) {
                tekiyoJogaishaRelateList.add(new TekiyoJogaishaRelate(entity));
            } else {
                for (TekiyoJogaishaRelateEntity entity1 : 施設情報List) {
                    if (entity1.getTaishoYMD() == null || entity1.getTaishoYMD().isEmpty()) {
                        entity.setRirekiNo(entity1.getRirekiNo());
                        entity.setNyushoShisetsuCode(entity1.getNyushoShisetsuCode());
                        entity.setNyushoYMD(entity1.getNyushoYMD());
                        entity.setTaishoYMD(entity1.getTaishoYMD());
                        entity.setJigyoshaMeisho(entity1.getJigyoshaMeisho());
                        tekiyoJogaishaRelateList.add(new TekiyoJogaishaRelate(entity));
                        退所日ありフラグ = false;
                    }
                }
                if (退所日ありフラグ) {
                    entity.setRirekiNo(施設情報List.get(0).getRirekiNo());
                    entity.setNyushoShisetsuCode(施設情報List.get(0).getNyushoShisetsuCode());
                    entity.setNyushoYMD(施設情報List.get(0).getNyushoYMD());
                    entity.setTaishoYMD(施設情報List.get(0).getTaishoYMD());
                    entity.setJigyoshaMeisho(施設情報List.get(0).getJigyoshaMeisho());
                    tekiyoJogaishaRelateList.add(new TekiyoJogaishaRelate(entity));
                }
            }
        }
        return SearchResult.of(tekiyoJogaishaRelateList, 0, false);
    }

    /**
     * 適用除外者と施設入退所情報の取得処理をします。
     *
     * @param shikibetsuCode 識別コード
     * @param ronrisakujyoFlg 論理削除フラグ
     * @return TekiyoJogaishaBusiness 適用除外者管理情報
     */
    @Transaction
    public TekiyoJogaishaBusiness get適用除外者と施設入退所情報(ShikibetsuCode shikibetsuCode, boolean ronrisakujyoFlg) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        TekiyoJogaishaBusiness tekiyoJogaishaBusiness = new TekiyoJogaishaBusiness();
        TekiyoJogaishaMapperParameter 適用除外者Parameter = TekiyoJogaishaMapperParameter.
                createParam_get適用除外者(shikibetsuCode, ronrisakujyoFlg);
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        List<TekiyoJogaishaKanriRelateEntity> 適用除外者管理情報List = mapper.get適用除外者と施設入退所情報(適用除外者Parameter);
        List<TekiyoJogaisha> 適用除外者List = new ArrayList();
        List<jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho> 施設入退所Lsit = new ArrayList();
        for (TekiyoJogaishaKanriRelateEntity entity : 適用除外者管理情報List) {
            DbT1002TekiyoJogaishaEntity 適用除外者Entity = entity.get適用除外者Entity();
            適用除外者Entity.initializeMd5();
            適用除外者List.add(new TekiyoJogaisha(適用除外者Entity));
            DbT1004ShisetsuNyutaishoEntity 施設入退所Entity = entity.get施設入退所Entity();
            施設入退所Entity.initializeMd5();
            施設入退所Lsit.add(new jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho(施設入退所Entity));
        }
        tekiyoJogaishaBusiness.set適用除外者List(適用除外者List);
        tekiyoJogaishaBusiness.set施設入退所Lsit(施設入退所Lsit);
        return tekiyoJogaishaBusiness;
    }

    /**
     * 適用除外者の登録処理をします。
     *
     * @param entity 適用除外者情報
     * @return 登録件数
     */
    @Transaction
    public int regTekiyoJogaisha(DbT1002TekiyoJogaishaEntity entity) {
        return 適用除外者Dac.save(entity);
    }

    /**
     * 適用除外者の削除処理をします。
     *
     * @param shikibetsuCode 識別コード
     * @param idoYMD 異動日
     * @param edaNo 枝番
     * @return 削除件数
     */
    @Transaction
    public int delTekiyoJogaisha(
            ShikibetsuCode shikibetsuCode,
            FlexibleDate idoYMD,
            RString edaNo) {
        DbT1002TekiyoJogaishaEntity entity = 適用除外者Dac.selectByKey(shikibetsuCode, idoYMD, edaNo);
        if (entity == null) {
            return 0;
        }
        entity.setLogicalDeletedFlag(true);
        entity.setState(EntityDataState.Modified);
        return 適用除外者Dac.save(entity);
    }

    /**
     * 介護保険施設入退所登録処理をします。
     *
     * @param shisetsuNyutaisho 介護保険施設入退所管理情報
     * @return 登録件数
     */
    @Transaction
    public int regKaigoJogaiTokureiTaishoShisetsu(ShisetsuNyutaisho shisetsuNyutaisho) {
        int count = 0;
        DbT1004ShisetsuNyutaishoEntity entity = new DbT1004ShisetsuNyutaishoEntity();
        entity.setShikibetsuCode(shisetsuNyutaisho.get識別コード());
        TekiyoJogaishaMapperParameter parameter = TekiyoJogaishaMapperParameter.createParam_getMax履歴番号(shisetsuNyutaisho.get識別コード());
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        Decimal 履歴番号 = mapper.getMax履歴番号(parameter);
        if (履歴番号 == null) {
            entity.setRirekiNo(1);
        } else {
            entity.setRirekiNo(履歴番号.add(1).intValue());
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        entity.setShichosonCode(association.get地方公共団体コード());
        entity.setDaichoShubetsu(DaichoType.適用除外者.getCode());
        entity.setNyushoShisetsuShurui(shisetsuNyutaisho.get入所施設種類());
        entity.setNyushoShisetsuCode(shisetsuNyutaisho.get入所施設コード());
        entity.setNyushoShoriYMD(new FlexibleDate(RDate.getNowDate().toString()));
        entity.setNyushoYMD(shisetsuNyutaisho.get入所年月日());
        if (介護保険施設入退所Manager.save介護保険施設入退所(new ShisetsuNyutaisho(entity))) {
            count = 1;
        }
        return count;
    }

    /**
     * 介護保険施設入退所更新処理をします。
     *
     * @param entity 介護保険施設入退所管理情報
     * @return 更新件数
     */
    @Transaction
    public int updateKaigoJogaiTokureiTaishoShisetsu(DbT1004ShisetsuNyutaishoEntity entity) {
        int count = 0;
        if (介護保険施設入退所Manager.save介護保険施設入退所(new ShisetsuNyutaisho(entity))) {
            count = 1;
        }
        return count;
    }

    /**
     * 被保険者台帳管理（資格取得）登録処理をします。
     *
     * @param 解除事由コード 解除事由コード
     * @param 解除年月日 解除年月日
     * @param 識別コード 識別コード
     * @param 解除届出年月日 解除届出年月日
     */
    @Transaction
    public void saveHihokenshaShutoku(
            RString 解除事由コード, FlexibleDate 解除年月日, ShikibetsuCode 識別コード, FlexibleDate 解除届出年月日) {
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報(識別コード);
        IKojin shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名情報);
        RString 年齢 = get年齢(shikibetsuTaisho.get生年月日(), 解除届出年月日);
        if (Integer.parseInt(年齢.toString()) >= AGE_65) {
            DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
            entity.setIdoYMD(解除年月日);
            entity.setIdoJiyuCode(ShikakuShutokuJiyu.除外者居住.getコード());
            entity.setShichosonCode(shikibetsuTaisho.get現全国地方公共団体コード());
            entity.setShikibetsuCode(識別コード);
            entity.setShikakuShutokuJiyuCode(ShikakuShutokuJiyu.除外者居住.getコード());
            entity.setShikakuShutokuYMD(解除年月日);
            entity.setShikakuShutokuTodokedeYMD(解除届出年月日);
            entity.setKyuShichosonCode(shikibetsuTaisho.get旧全国地方公共団体コード());
            HihokenshaShikakuShutokuManager.createInstance().saveHihokenshaShutoku(new HihokenshaDaicho(entity), shikibetsuTaisho.get生年月日());
        }
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        TekiyoJogaishaMapperParameter parameter = TekiyoJogaishaMapperParameter.createParam_get宛名情報(
                識別コード, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        return mapper.select宛名情報(parameter);
    }

    private RString get年齢(IDateOfBirth dateOfBirth, FlexibleDate shikakuShutokuYMD) {
        AgeCalculator ageCalculator = new AgeCalculator(dateOfBirth, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, shikakuShutokuYMD);
        return ageCalculator.get年齢();
    }

}
