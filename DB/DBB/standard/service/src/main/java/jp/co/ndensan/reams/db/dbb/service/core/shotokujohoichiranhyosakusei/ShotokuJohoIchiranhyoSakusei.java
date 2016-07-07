/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohoichiranhyosakusei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.KaigoHokenShotokuItijiParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.ShotokuJohoIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuItijiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokujohoichiranhyosakusei.IShotokuJohoIchiranhyoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51003_1_所得情報一覧表作成（バッチ）
 *
 * @reamsid_L DBB-1650-050 lijunjun
 */
public class ShotokuJohoIchiranhyoSakusei {

    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタDac;
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString 年度内枝番 = new RString("0001");
    private static final int NUM_0 = 0;
    private static final int NUM_8 = 8;

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 処理日付管理マスタDac DbT7022ShoriDateKanriDac
     */
    ShotokuJohoIchiranhyoSakusei(MapperProvider mapperProvider,
            DbT7022ShoriDateKanriDac 処理日付管理マスタDac) {
        this.mapperProvider = mapperProvider;
        this.処理日付管理マスタDac = 処理日付管理マスタDac;
    }

    /**
     * コンストラクタです。
     */
    public ShotokuJohoIchiranhyoSakusei() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        処理日付管理マスタDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * にて生成した{@link ShotokuJohoIchiranhyoSakusei}のインスタンスを返します。
     *
     * @return FukaKeisan
     */
    public static ShotokuJohoIchiranhyoSakusei createInstance() {
        return InstanceProvider.create(ShotokuJohoIchiranhyoSakusei.class);
    }

    /**
     * 単一市町村の所得情報一覧取得
     *
     * @param 処理年度 FlexibleYear
     * @param チックボックス RString
     * @param ラジオボタン RString
     * @param 期間開始日時 YMDHMS
     * @param 期間終了日時 YMDHMS
     * @param 出力順 RString
     */
    public void getTanitsuShichosonShotokuIchiarn(FlexibleYear 処理年度,
            RString チックボックス,
            RString ラジオボタン,
            YMDHMS 期間開始日時,
            YMDHMS 期間終了日時,
            RString 出力順) {
        if (処理年度 == null || チックボックス == null || ラジオボタン == null || 期間開始日時 == null
                || 期間終了日時 == null || 出力順 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }

//        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
//        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
//                SubGyomuCode.DBB介護賦課, 帳票ID, reamsLoginID, 出力順ID);
//        RString 出力順 = MyBatisOrderByClauseCreator.create(
//                KaigoHokenShotokuJohoIchiranProperty.DBB200008ShutsuryokujunEnum.class, outputOrder);
        ShotokuJohoIchiranhyoSakuseiParameter 介護保険Para = new ShotokuJohoIchiranhyoSakuseiParameter(処理年度,
                チックボックス, ラジオボタン, 期間開始日時, 期間終了日時, 出力順);
        IShotokuJohoIchiranhyoSakuseiMapper mapper = mapperProvider.create(IShotokuJohoIchiranhyoSakuseiMapper.class);
        List<KaigoHokenShotokuTempEntity> 介護保険所得情報一覧リスト = mapper.select介護保険所得情報一覧データ(介護保険Para);
        if (介護保険所得情報一覧リスト != null && !介護保険所得情報一覧リスト.isEmpty()) {
            mapper.creat介護保険所得();
            for (KaigoHokenShotokuTempEntity entity : 介護保険所得情報一覧リスト) {
                mapper.insert介護保険所得(entity);
            }
        } else {
            mapper.creat介護保険所得();
        }
    }

    /**
     * 広域市町村の所得情報一覧取得
     *
     * @param 処理年度 FlexibleYear
     * @param チックボックス RString
     * @param ラジオボタン RString
     * @param 市町村情報リスト List<ShichosonJouhouResult>
     * @param 出力順 RString
     */
    public void getKoikiShichosonShotokuIchiarn(FlexibleYear 処理年度,
            RString チックボックス,
            RString ラジオボタン,
            List<ShichosonJouhouResult> 市町村情報リスト,
            RString 出力順) {
        if (処理年度 == null || チックボックス == null || ラジオボタン == null
                || 市町村情報リスト == null || 出力順 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }

//        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
//        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
//                SubGyomuCode.DBB介護賦課, 帳票ID, reamsLoginID, 出力順ID);
//        RString 出力順 = MyBatisOrderByClauseCreator.create(
//                KaigoHokenShotokuJohoIchiranProperty.DBB200008ShutsuryokujunEnum.class, outputOrder);
        IShotokuJohoIchiranhyoSakuseiMapper mapper = mapperProvider.create(IShotokuJohoIchiranhyoSakuseiMapper.class);
        List<KaigoHokenShotokuItijiTempEntity> 介護所得一時データリスト = mapper.select介護所得一時データ(ラジオボタン);
        for (KaigoHokenShotokuItijiTempEntity 介護所得一時データ : 介護所得一時データリスト) {
            mapper.insert介護所得一時(介護所得一時データ);
        }
        for (ShichosonJouhouResult 市町村情報entity : 市町村情報リスト) {
            KaigoHokenShotokuItijiParameter param = new KaigoHokenShotokuItijiParameter(市町村情報entity.get市町村コード(),
                    市町村情報entity.get開始時刻(), 市町村情報entity.get終了時刻(), 出力順);
            List<KaigoHokenShotokuTempEntity> 対象データリスト = mapper.select対象データ(param);
            insert介護保険所得Temp(対象データリスト, mapper);
        }
    }

    private void insert介護保険所得Temp(List<KaigoHokenShotokuTempEntity> 対象データリスト,
            IShotokuJohoIchiranhyoSakuseiMapper mapper) {
        if (対象データリスト != null && !対象データリスト.isEmpty()) {
            mapper.creat介護保険所得();
            for (KaigoHokenShotokuTempEntity 対象データ : 対象データリスト) {
                mapper.insert介護保険所得(対象データ);
            }
        } else {
            mapper.creat介護保険所得();
        }
    }

    /**
     * 処理日付管理マスタ登録
     *
     * @param 導入形態コード RString
     * @param 処理年度 FlexibleYear
     * @param 開始日時 YMDHMS
     * @param 終了日時 YMDHMS
     * @param 市町村情報リスト List<ShichosonJouhouResult>
     */
    public void registShoriDateKanri(RString 導入形態コード,
            FlexibleYear 処理年度,
            YMDHMS 開始日時,
            YMDHMS 終了日時,
            List<ShichosonJouhouResult> 市町村情報リスト) {
        if (導入形態コード == null || 処理年度 == null || 開始日時 == null || 終了日時 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        if (導入形態コード.equals(導入形態コード_112) || 導入形態コード.equals(導入形態コード_120)) {
            requireNonNull(開始日時, UrSystemErrorMessages.値がnull.getReplacedMessage("開始日時"));
            requireNonNull(終了日時, UrSystemErrorMessages.値がnull.getReplacedMessage("終了日時"));
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            LasdecCode 市町村コード = association.get地方公共団体コード();
            DbT7022ShoriDateKanriEntity 処理日付管理マスタentity = 処理日付管理マスタDac.selectByKey(
                    SubGyomuCode.DBB介護賦課, 市町村コード, new RString(ShoriName.所得情報一覧表作成.toString()),
                    処理枝番, 処理年度, 年度内枝番);
            if (処理日付管理マスタentity != null) {
                for (ShichosonJouhouResult 市町村情報 : 市町村情報リスト) {
                    DbT7022ShoriDateKanriEntity entity = 処理日付管理マスタentity;
                    entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(NUM_0, NUM_8)));
                    RString 対象開始日時 = new RString(市町村情報.get開始年月日().toString()).concat(市町村情報.get開始時刻());
                    RString 対象終了日時 = new RString(市町村情報.get終了年月日().toString()).concat(市町村情報.get終了時刻());
                    entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
                    entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
                    entity.setState(EntityDataState.Modified);
                    処理日付管理マスタDac.save(entity);
                }
            } else {
                for (ShichosonJouhouResult 市町村情報 : 市町村情報リスト) {
                    DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
                    entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
                    entity.setShichosonCode(市町村コード);
                    entity.setShoriName(new RString(ShoriName.所得情報一覧表作成.toString()));
                    entity.setShoriEdaban(処理枝番);
                    entity.setNendo(処理年度);
                    entity.setNendoNaiRenban(年度内枝番);
                    entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(NUM_0, NUM_8)));
                    RString 対象開始日時 = new RString(市町村情報.get開始年月日().toString()).concat(市町村情報.get開始時刻());
                    RString 対象終了日時 = new RString(市町村情報.get終了年月日().toString()).concat(市町村情報.get終了時刻());
                    entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
                    entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
                    entity.setState(EntityDataState.Added);
                    処理日付管理マスタDac.save(entity);
                }
            }
        } else if (導入形態コード.equals(導入形態コード_111)) {
            requireNonNull(市町村情報リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村情報リスト"));
            for (ShichosonJouhouResult 市町村情報 : 市町村情報リスト) {
                DbT7022ShoriDateKanriEntity 処理日付管理マスタentity = 処理日付管理マスタDac.selectByKey(
                        SubGyomuCode.DBB介護賦課, 市町村情報.get市町村コード(), new RString(
                                ShoriName.所得情報一覧表作成.toString()), 市町村情報.get市町村識別ID(), 処理年度, 年度内枝番);
                if (処理日付管理マスタentity != null) {
                    DbT7022ShoriDateKanriEntity entity = 処理日付管理マスタentity;
                    entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(NUM_0, NUM_8)));
                    RString 対象開始日時 = new RString(市町村情報.get開始年月日().toString()).concat(市町村情報.get開始時刻());
                    entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
                    RString 対象終了日時 = new RString(市町村情報.get終了年月日().toString()).concat(市町村情報.get終了時刻());
                    entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
                    entity.setState(EntityDataState.Modified);
                    処理日付管理マスタDac.save(entity);
                } else {
                    DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
                    entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
                    entity.setShichosonCode(市町村情報.get市町村コード());
                    entity.setShoriName(new RString(ShoriName.所得情報一覧表作成.toString()));
                    entity.setShoriEdaban(市町村情報.get市町村識別ID());
                    entity.setNendo(処理年度);
                    entity.setNendoNaiRenban(年度内枝番);
                    entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(NUM_0, NUM_8)));
                    entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(NUM_0, NUM_8)));
                    RString 対象開始日時 = new RString(市町村情報.get開始年月日().toString()).concat(市町村情報.get開始時刻());
                    entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
                    RString 対象終了日時 = new RString(市町村情報.get終了年月日().toString()).concat(市町村情報.get終了時刻());
                    entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
                    entity.setState(EntityDataState.Added);
                    処理日付管理マスタDac.save(entity);
                }
            }
        }
    }
}
