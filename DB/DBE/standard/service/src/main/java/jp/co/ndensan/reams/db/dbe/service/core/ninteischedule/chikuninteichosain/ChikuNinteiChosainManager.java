///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.chikuninteichosain;
//
//import java.util.ArrayList;
//import java.util.List;
//import static java.util.Objects.requireNonNull;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain.ChikuNinteiChosain;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson.ChikuShichoson;
//import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.ChikuNinteiChosainMapperParameter;
//import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikuninteichosain.ChikuNinteiChosainEntity;
//import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5223ChikuNinteiChosainDac;
//import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteischedule.chikuninteichosain.IChikuNinteiChosainMapper;
//import jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.chikushichoson.ChikuShichosonManager;
//import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
//import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
//import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
//import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
//
///**
// * 地区認定調査員を管理するクラスです。
// */
//public class ChikuNinteiChosainManager {
//
//    private final MapperProvider mapperProvider;
//    private final DbT5223ChikuNinteiChosainDac 地区認定調査員Dac;
//    private final ChikuShichosonManager 地区市町村Manager;
//
//    /**
//     * コンストラクタです。
//     */
//    ChikuNinteiChosainManager() {
//        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
//        this.地区認定調査員Dac = InstanceProvider.create(DbT5223ChikuNinteiChosainDac.class);
//        this.地区市町村Manager =  ChikuShichosonManager.createInstance();
//    }
//
//    /**
//     * 単体テスト用のコンストラクタです。
//     * 
//     * @param mapperProvider mapperProvider
//     * @param 地区認定調査員Dac 地区認定調査員Dac
//     * @param 地区市町村Manager 地区市町村Manager
//     */
//    ChikuNinteiChosainManager(
//            MapperProvider mapperProvider,
//            DbT5223ChikuNinteiChosainDac 地区認定調査員Dac,
//            ChikuShichosonManager 地区市町村Manager
//    ) {
//        this.mapperProvider = mapperProvider;
//        this.地区認定調査員Dac = 地区認定調査員Dac;
//        this.地区市町村Manager = 地区市町村Manager;
//    }
//
//    /**
//     * {@link InstanceProvider#create}にて生成した{@link ChikuNinteiChosainManager}のインスタンスを返します。
//     *
//     * @return {@link InstanceProvider#create}にて生成した{@link ChikuNinteiChosainManager}のインスタンス
//     */
//    public static ChikuNinteiChosainManager createInstance() {
//        return InstanceProvider.create(ChikuNinteiChosainManager.class);
//    }
//
//    /**
//     * 主キーに合致する地区認定調査員を返します。
//     *
//     * @param 地区認定調査員検索条件 地区認定調査員検索条件
//     * @return ChikuNinteiChosain  nullが返る可能性があります。
//     */
//    @Transaction
//    public ChikuNinteiChosain get地区認定調査員(ChikuNinteiChosainMapperParameter 地区認定調査員検索条件) {
//        requireNonNull(地区認定調査員検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員検索条件"));
//        IChikuNinteiChosainMapper mapper = mapperProvider.create(IChikuNinteiChosainMapper.class);
//
//        ChikuNinteiChosainEntity relateEntity = mapper.select地区認定調査員ByKey(地区認定調査員検索条件);
//        if (relateEntity == null) {
//            return null;
//        }
//        relateEntity.initializeMd5ToEntities();
//        return new ChikuNinteiChosain(relateEntity);
//    }
//
//    /**
//     * 主キー1に合致する地区認定調査員のリストを返します。
//     *
//     * @param 地区認定調査員検索条件 地区認定調査員検索条件
//     * @return ChikuNinteiChosainの{@code list}
//     */
//    @Transaction
//    public List<ChikuNinteiChosain> get地区認定調査員リストBy主キー1(ChikuNinteiChosainMapperParameter 地区認定調査員検索条件) {
//        requireNonNull(地区認定調査員検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員検索条件"));
//        IChikuNinteiChosainMapper mapper = mapperProvider.create(IChikuNinteiChosainMapper.class);
//
//        List<ChikuNinteiChosainEntity> relateEntityList = mapper.select地区認定調査員リストBy主キー1(地区認定調査員検索条件);
//
//        ArrayList<ChikuNinteiChosain> 地区認定調査員List = new ArrayList<>();
//        for (ChikuNinteiChosainEntity relateEntity : relateEntityList) {
//            relateEntity.initializeMd5ToEntities();
//            地区認定調査員List.add(new ChikuNinteiChosain(relateEntity));
//        }
//        return 地区認定調査員List;
//
//    }
//
//    /**
//     * 地区認定調査員{@link ChikuNinteiChosain}を保存します。
//     *
//     * @param 地区認定調査員 地区認定調査員
//     * @return 更新あり:true、更新なし:false <br>
//     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
//     */
//    @Transaction
//    public boolean save(ChikuNinteiChosain 地区認定調査員) {
//        requireNonNull(地区認定調査員, UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員"));
//
//        if (!地区認定調査員.hasChanged()) {
//            return false;
//        }
//        地区認定調査員 = 地区認定調査員.modifiedModel();
//        save地区市町村リスト(地区認定調査員.getChikuShichosonList()); 
//        return 1 == 地区認定調査員Dac.save(地区認定調査員.toEntity());
//    }
//
//    private void save地区市町村リスト(List<ChikuShichoson> 地区市町村List) {    
//        for (ChikuShichoson 地区市町村 : 地区市町村List) {
//            地区市町村Manager.save(地区市町村);
//        }
//    }
//}
