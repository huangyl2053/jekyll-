/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.tekiyojogaisha;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha.ITekiyoJogaishaMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaishoManager;
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
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者を管理するクラスです。
 */
public class TekiyoJogaishaManager {

    private static final int AGE_65 = 65;
    private static final RString モード_追加 = new RString("追加");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_削除 = new RString("削除");
    private static final RString モード_適用 = new RString("適用");
    private static final RString モード_解除 = new RString("解除");
    private static final RString 枝番 = new RString("0001");
    private static final int PADZERO = 4;
//    private static final RString エラーコード_DBAE00006 = new RString("DBAE00006");
//    private static final RString エラーコード_DBAE00007 = new RString("DBAE00007");
//    private static final RString エラーコード_DBAE00008 = new RString("DBAE00008");
    private final MapperProvider mapperProvider;
    private final DbT1002TekiyoJogaishaDac 適用除外者Dac;
    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager;
    private final DbT1004ShisetsuNyutaishoDac 介護保険施設入退所dac;
    private static int count = 0;
    private static int saveCount = 0;

    /**
     * コンストラクタです。
     */
    TekiyoJogaishaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.適用除外者Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        this.介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
        this.介護保険施設入退所dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
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
            DbT1004ShisetsuNyutaishoDac 介護保険施設入退所dac
    ) {
        this.mapperProvider = mapperProvider;
        this.適用除外者Dac = 適用除外者Dac;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;
        this.介護保険施設入退所dac = 介護保険施設入退所dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaManager}のインスタンス
     */
    public static TekiyoJogaishaManager createInstance() {
        return InstanceProvider.create(TekiyoJogaishaManager.class);
    }

    /**
     * 主キーに合致する適用除外者を返します。
     *
     * @param 適用除外者検索条件 適用除外者検索条件
     * @return TekiyoJogaisha nullが返る可能性があります。
     */
    @Transaction
    public TekiyoJogaisha get適用除外者(TekiyoJogaishaMapperParameter 適用除外者検索条件) {
        requireNonNull(適用除外者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者検索条件"));
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);

        TekiyoJogaishaEntity relateEntity = mapper.select適用除外者ByKey(適用除外者検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new TekiyoJogaisha(relateEntity);
    }

    /**
     * 適用除外者{@link TekiyoJogaisha}を保存します。
     *
     * @param 適用除外者 適用除外者
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(TekiyoJogaisha 適用除外者) {
        requireNonNull(適用除外者, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者"));

        if (!適用除外者.hasChanged()) {
            return false;
        }
        適用除外者 = 適用除外者.modifiedModel();
        save介護保険施設入退所リスト(適用除外者.getSeishinTechoNiniList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 適用除外者Dac.save(適用除外者.toEntity());
    }

    private void save介護保険施設入退所リスト(List<ShisetsuNyutaisho> 介護保険施設入退所List) {
        for (ShisetsuNyutaisho 介護保険施設入退所 : 介護保険施設入退所List) {
            介護保険施設入退所Manager.save介護保険施設入退所(介護保険施設入退所);
        }
    }

    /**
     * 適用除外者の取得処理します。
     *
     * @param shikibetsuCode 識別コード
     * @param ronrisakujyoFlg 論理削除フラグ
     * @return SearchResult<TekiyoJogaisha> 適用除外者を管理
     */
    @Transaction
    public SearchResult<TekiyoJogaisha> getTekiyoJogaishaLst(ShikibetsuCode shikibetsuCode, boolean ronrisakujyoFlg) {
        return null;
    }

    /**
     * 適用除外者の保存処理します。
     *
     * @param tekiyoJogaishalist 用除外者を管理リスト
     * @param shikibetsuCode 別コード
     * @param mode モード
     * @return 処理件数
     */
    @Transaction
    public int saveTekiyoJogaisha(SearchResult<TekiyoJogaisha> tekiyoJogaishalist, ShikibetsuCode shikibetsuCode, RString mode) {
        requireNonNull(tekiyoJogaishalist, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者を管理"));
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        for (TekiyoJogaisha tekiyoJogaisha : tekiyoJogaishalist.records()) {
            if (mode.isEmpty()) {
                continue;
            }
            if (モード_追加.equals(mode)) {
                count = regTekiyoJogaisha(tekiyoJogaisha, mode);
            }
            if (モード_修正.equals(mode)) {
                delTekiyoJogaisha(tekiyoJogaisha.get識別コード(), tekiyoJogaisha.get異動日(), tekiyoJogaisha.get枝番());
                count = regTekiyoJogaisha(tekiyoJogaisha, mode);
            }
            if (モード_削除.equals(mode)) {
                count = delTekiyoJogaisha(tekiyoJogaisha.get識別コード(), tekiyoJogaisha.get異動日(), tekiyoJogaisha.get枝番());
            }
            //TODO  ビジネス設計_DBAMN22001-7_被保険者台帳管理（資格喪失） 実装しない。
//            if (モード_適用.equals(mode)) {
//                エラーコード = new Code("DBAE00006");
////      TODO          HihokenshaShikakuSoshitsuManager.createInstance.ShikakuSoshitsuCheck(tekiyoJogaisha.get識別コード(), HokenshaNo.EMPTY);
//                if (エラーコード_DBAE00006.equals(エラーコード)) {
////        TODO        エラーメッセージを出て、本処理終了
//                } else if (エラーコード_DBAE00008.equals(エラーコード)) {
//                    regTekiyoJogaisha(tekiyoJogaisha);
//                    regKaigoJogaiTokureiTaishoShisetsu(tekiyoJogaisha.getSeishinTechoNiniList().get(0));
//                } else {
//                    HihokenshaShikakuSoshitsuManager.createInstance.saveHihokenshaShikakuSoshitsu(tekiyoJogaisha.get識別コード(),
//                            HihokenshaNo.EMPTY,
//                            tekiyoJogaisha.get適用年月日(),
//                            new CodeShubetsu("0121"),
//                            tekiyoJogaisha.get適用年月日()
//                    );
//                }
//            }
            if (モード_解除.equals(mode)) {
                delTekiyoJogaisha(tekiyoJogaisha.get識別コード(), tekiyoJogaisha.get異動日(), tekiyoJogaisha.get枝番());
                regTekiyoJogaisha(tekiyoJogaisha, mode);
                for (ShisetsuNyutaisho shisetsuNyutaisho : tekiyoJogaisha.getSeishinTechoNiniList()) {
                    updateKaigoJogaiTokureiTaishoShisetsu(shisetsuNyutaisho);
                }
                saveHihokenshaShutoku(tekiyoJogaisha.get適用除外適用事由コード(), tekiyoJogaisha.get解除年月日(), shikibetsuCode, tekiyoJogaisha.get解除届出年月日());
            }
            saveCount++;
        }
        return saveCount;
    }

    /**
     * 適用除外者の登録処理します。
     *
     * @param tekiyoJogaisha 用除外者を管理
     * @param mode モード
     * @return 登録件数
     */
    @Transaction
    public int regTekiyoJogaisha(TekiyoJogaisha tekiyoJogaisha, RString mode) {
        TekiyoJogaishaEntity rentity = getSave使用Entity(tekiyoJogaisha, mode);
        if (save(new TekiyoJogaisha(rentity))) {
            count = 1;
        }
        return count;
    }

    /**
     * 適用除外者の削除処理します。
     *
     * @param shikibetsuCode 識別コード
     * @param idoYMD 異動日
     * @param edaNo 枝番
     * @return 削除件数
     */
    @Transaction
    public int delTekiyoJogaisha(ShikibetsuCode shikibetsuCode, FlexibleDate idoYMD, RString edaNo) {
        if (適用除外者Dac.selectByKey(shikibetsuCode, idoYMD, edaNo) == null) {
            return 0;
        }
        TekiyoJogaishaEntity tekiyoJogaishaEntity = new TekiyoJogaishaEntity();
        DbT1002TekiyoJogaishaEntity entity = new DbT1002TekiyoJogaishaEntity();
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setIdoYMD(idoYMD);
        entity.setEdaNo(edaNo);
        entity.setLogicalDeletedFlag(true);
        entity.setState(EntityDataState.Deleted);
        tekiyoJogaishaEntity.set適用除外者Entity(entity);
        if (save(new TekiyoJogaisha(tekiyoJogaishaEntity))) {
            return 1;
        }
        return 0;
    }

    /**
     * 介護保険施設入退所登録処理します。
     *
     * @param shisetsuNyutaisho 介護保険施設入退所を管理
     * @return 登録件数
     */
    @Transaction
    public int regKaigoJogaiTokureiTaishoShisetsu(ShisetsuNyutaisho shisetsuNyutaisho) {
        DbT1004ShisetsuNyutaishoEntity entity = new DbT1004ShisetsuNyutaishoEntity();
        entity.setShikibetsuCode(shisetsuNyutaisho.get識別コード());
        TekiyoJogaishaMapperParameter parameter = TekiyoJogaishaMapperParameter.createParam_getMax履歴番号(shisetsuNyutaisho.get識別コード());
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        DbT1004ShisetsuNyutaishoEntity 履歴番号 = mapper.getMax履歴番号(parameter);
        if (履歴番号 == null || 履歴番号.getRirekiNo() == 0) {
            entity.setRirekiNo(1);
        } else {
            entity.setRirekiNo(履歴番号.getRirekiNo() + 1);
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        entity.setShichosonCode(association.get地方公共団体コード());
        entity.setDaichoShubetsu(new RString("3"));
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
     * 介護保険施設入退所更新処理します。
     *
     * @param shisetsuNyutaisho 介護保険施設入退所を管理
     * @return 更新件数
     */
    @Transaction
    public int updateKaigoJogaiTokureiTaishoShisetsu(ShisetsuNyutaisho shisetsuNyutaisho) {
        requireNonNull(shisetsuNyutaisho, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所"));
        DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所 = 介護保険施設入退所dac.selectByKey(shisetsuNyutaisho.get識別コード(), shisetsuNyutaisho.get履歴番号());
        if (介護保険施設入退所 == null) {
            return count;
        }
        DbT1004ShisetsuNyutaishoEntity entity = shisetsuNyutaisho.toEntity();
        entity.setTaishoShoriYMD(new FlexibleDate(RDate.getNowDate().toString()));
        entity.setState(EntityDataState.Modified);
        if (介護保険施設入退所Manager.save介護保険施設入退所(new ShisetsuNyutaisho(entity))) {
            count = 1;
        }
        return count;
    }

    /**
     * 被保険者台帳管理（資格取得）登録処理します。
     *
     * @param 解除事由コード 解除事由コード
     * @param 解除年月日 解除年月日
     * @param 識別コード 識別コード
     * @param 解除届出年月日 解除届出年月日
     */
    @Transaction
    public void saveHihokenshaShutoku(RString 解除事由コード, FlexibleDate 解除年月日, ShikibetsuCode 識別コード, FlexibleDate 解除届出年月日) {
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
            HihokenshaShikakuShutokuManager.createInstance().saveHihokenshaShutoku(entity, shikibetsuTaisho.get生年月日());
        }
    }

    //TODO
    private UaFt200FindShikibetsuTaishoEntity get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        TekiyoJogaishaMapperParameter parameter = TekiyoJogaishaMapperParameter.createParam_get宛名情報(
                識別コード, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = mapper.select宛名情報(parameter);
        return 宛名情報;
    }

    private RString get年齢(IDateOfBirth dateOfBirth, FlexibleDate shikakuShutokuYMD) {
        AgeCalculator ageCalculator = new AgeCalculator(dateOfBirth, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, shikakuShutokuYMD);
        return ageCalculator.get年齢();
    }

    private TekiyoJogaishaEntity getSave使用Entity(TekiyoJogaisha tekiyoJogaisha, RString モード) {
        FlexibleDate 異動日 = new FlexibleDate("");
        TekiyoJogaishaEntity rentity = new TekiyoJogaishaEntity();
        DbT1002TekiyoJogaishaEntity entity = new DbT1002TekiyoJogaishaEntity();
        entity.setShikibetsuCode(tekiyoJogaisha.get識別コード());
        entity.setTekiyoJogaiTekiyoJiyuCode(tekiyoJogaisha.get適用除外適用事由コード());
        entity.setTekiyoYMD(tekiyoJogaisha.get適用年月日());
        entity.setTekiyoTodokedeYMD(tekiyoJogaisha.get適用届出年月日());
        entity.setTekiyoUketsukeYMD(tekiyoJogaisha.get適用届出年月日());
        entity.setTekiyoJogaikaijokaijoJiyuCode(tekiyoJogaisha.get適用除外解除事由コード());
        entity.setLogicalDeletedFlag(true);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        if (モード_追加.equals(モード)) {
            異動日 = tekiyoJogaisha.get解除年月日();
            if (tekiyoJogaisha.get解除年月日().isEmpty()) {
                entity.setIdoJiyuCode(tekiyoJogaisha.get適用除外適用事由コード());
            } else {
                entity.setIdoJiyuCode(tekiyoJogaisha.get適用除外解除事由コード());
            }
            entity.setShichosonCode(association.get地方公共団体コード());
            entity.setKaijoYMD(tekiyoJogaisha.get解除年月日());
            entity.setKaijoTodokedeYMD(tekiyoJogaisha.get解除届出年月日());
            entity.setKaijoUketsukeYMD(tekiyoJogaisha.get解除届出年月日());
        }
        if (モード_修正.equals(モード)) {
            異動日 = tekiyoJogaisha.get異動日();
            entity.setIdoJiyuCode(tekiyoJogaisha.get異動事由コード());
            entity.setShichosonCode(tekiyoJogaisha.get市町村コード());
            entity.setKaijoYMD(tekiyoJogaisha.get解除年月日());
            entity.setKaijoTodokedeYMD(tekiyoJogaisha.get解除届出年月日());
            entity.setKaijoUketsukeYMD(tekiyoJogaisha.get解除届出年月日());
            entity.setNyushoTsuchiHakkoYMD(tekiyoJogaisha.get入所通知発行日());
            entity.setTaishoTsuchiHakkoYMD(tekiyoJogaisha.get退所通知発行日());
        }
        if (モード_適用.equals(モード)) {
            異動日 = tekiyoJogaisha.get適用年月日();
            entity.setIdoJiyuCode(tekiyoJogaisha.get適用除外適用事由コード());
            entity.setShichosonCode(association.get地方公共団体コード());
        }
        if (モード_解除.equals(モード)) {
            異動日 = tekiyoJogaisha.get解除年月日();
            entity.setIdoJiyuCode(tekiyoJogaisha.get適用除外解除事由コード());
            entity.setShichosonCode(tekiyoJogaisha.get市町村コード());
            entity.setKaijoYMD(tekiyoJogaisha.get解除年月日());
            entity.setKaijoTodokedeYMD(tekiyoJogaisha.get解除届出年月日());
            entity.setKaijoUketsukeYMD(tekiyoJogaisha.get解除届出年月日());
            entity.setNyushoTsuchiHakkoYMD(tekiyoJogaisha.get入所通知発行日());
            entity.setTaishoTsuchiHakkoYMD(tekiyoJogaisha.get退所通知発行日());
        }
        entity.setIdoYMD(異動日);
        TekiyoJogaishaMapperParameter parameter = TekiyoJogaishaMapperParameter.createParam_get最大の枝番(tekiyoJogaisha.get識別コード(), 異動日);
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        DbT1002TekiyoJogaishaEntity 最大の枝番 = mapper.get最大の枝番(parameter);
        if (最大の枝番 == null || 最大の枝番.getEdaNo().isEmpty()) {
            entity.setEdaNo(枝番);
        } else {
            entity.setEdaNo(new RString(String.valueOf(Integer.valueOf(tekiyoJogaisha.get枝番().toString()) + 1)).padZeroToLeft(PADZERO));
        }
        rentity.set適用除外者Entity(entity);
        List<DbT1004ShisetsuNyutaishoEntity> list = new ArrayList<>();
        List<ShisetsuNyutaisho> shisetsuNyutaisholist = tekiyoJogaisha.getSeishinTechoNiniList();
        for (ShisetsuNyutaisho shisetsuNyutaisho : shisetsuNyutaisholist) {
            list.add(shisetsuNyutaisho.toEntity());
        }
        rentity.set介護保険施設入退所Entity(list);
        return rentity;
    }
}
