///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.chikushichoson;
//
//import java.util.ArrayList;
//import java.util.List;
//import static java.util.Objects.requireNonNull;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson.ChikuShichoson;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroup;
//import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.ChikuShichosonMapperParameter;
//import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikushichoson.ChikuShichosonEntity;
//import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5224ChikuShichosonDac;
//import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteischedule.chikushichoson.IChikuShichosonMapper;
//import jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.chosachikugroup.ChosaChikuGroupManager;
//import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
//import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
//import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
//import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
//
///**
// * 地区市町村を管理するクラスです。
// */
//public class ChikuShichosonManager {
//
//    private final MapperProvider mapperProvider;
//    private final DbT5224ChikuShichosonDac 地区市町村Dac;
//    private final ChosaChikuGroupManager 調査地区グループマスタManager;
//
//    /**
//     * コンストラクタです。
//     */
//    ChikuShichosonManager() {
//        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
//        this.地区市町村Dac = InstanceProvider.create(DbT5224ChikuShichosonDac.class);
//        this.調査地区グループマスタManager = new ChosaChikuGroupManager();
//    }
//
//    /**
//     * 単体テスト用のコンストラクタです。
//     * 
//     * @param mapperProvider mapperProvider
//     * @param 地区市町村Dac 地区市町村Dac
//     * @param 調査地区グループマスタManager 調査地区グループマスタManager
//     */
//    ChikuShichosonManager(
//            MapperProvider mapperProvider,
//            DbT5224ChikuShichosonDac 地区市町村Dac,
//            ChosaChikuGroupManager 調査地区グループマスタManager
//    ) {
//        this.mapperProvider = mapperProvider;
//        this.地区市町村Dac = 地区市町村Dac;
//        this.調査地区グループマスタManager = 調査地区グループマスタManager;
//    }
//
//    /**
//     * {@link InstanceProvider#create}にて生成した{@link ChikuShichosonManager}のインスタンスを返します。
//     *
//     * @return {@link InstanceProvider#create}にて生成した{@link ChikuShichosonManager}のインスタンス
//     */
//    public static ChikuShichosonManager createInstance() {
//        return InstanceProvider.create(ChikuShichosonManager.class);
//    }
//
//    /**
//     * 主キーに合致する地区市町村を返します。
//     *
//     * @param 地区市町村検索条件 地区市町村検索条件
//     * @return ChikuShichoson 【　※ツールの都合上、このカッコ部は手動で削除して下さい 地区市町村】 nullが返る可能性があります。
//     */
//    @Transaction
//    public ChikuShichoson  get地区市町村(ChikuShichosonMapperParameter 地区市町村検索条件) {
//        requireNonNull(地区市町村検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("地区市町村検索条件"));
//        IChikuShichosonMapper mapper = mapperProvider.create(IChikuShichosonMapper.class);
//
//        ChikuShichosonEntity relateEntity = mapper.select地区市町村ByKey(地区市町村検索条件);
//        if (relateEntity == null) {
//            return null;
//        }
//        relateEntity.initializeMd5ToEntities();
//        return new ChikuShichoson(relateEntity);
//    }
//
//    /**
//     * 主キー1に合致する地区市町村のリストを返します。
//     *
//     * @param 地区市町村検索条件 地区市町村検索条件
//     * @return ChikuShichosonの{@code list}
//     */
//    @Transaction
//    public List<ChikuShichoson> get地区市町村リストBy主キー1(ChikuShichosonMapperParameter 地区市町村検索条件) {
//        requireNonNull(地区市町村検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("地区市町村検索条件"));
//        IChikuShichosonMapper mapper = mapperProvider.create(IChikuShichosonMapper.class);
//
//        List<ChikuShichosonEntity> relateEntityList = mapper.select地区市町村リストBy主キー1(地区市町村検索条件);
//
//        ArrayList<ChikuShichoson> 地区市町村List = new ArrayList<>();
//        for (ChikuShichosonEntity relateEntity : relateEntityList) {
//            relateEntity.initializeMd5ToEntities();
//            地区市町村List.add(new ChikuShichoson(relateEntity));
//        }
//        return 地区市町村List;
//
//    }
//
//    /**
//     * 地区市町村{@link ChikuShichoson}を保存します。
//     *
//     * @param 地区市町村 地区市町村
//     * @return 更新あり:true、更新なし:false <br>
//     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
//     */
//    @Transaction
//    public boolean save(ChikuShichoson 地区市町村) {
//        requireNonNull(地区市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("地区市町村"));
//
//        if (!地区市町村.hasChanged()) {
//            return false;
//        }
//        地区市町村 = 地区市町村.modifiedModel();
//        save調査地区グループマスタリスト(地区市町村.getChosaChikuGroupList()); 
//        return 1 == 地区市町村Dac.save(地区市町村.toEntity());
//    }
//
//    private void save調査地区グループマスタリスト(List<ChosaChikuGroup> 調査地区グループマスタList) {    
//        for (ChosaChikuGroup 調査地区グループマスタ : 調査地区グループマスタList) {
//            調査地区グループマスタManager.save調査地区グループマスタ(調査地区グループマスタ);
//        }
//    }
//}
