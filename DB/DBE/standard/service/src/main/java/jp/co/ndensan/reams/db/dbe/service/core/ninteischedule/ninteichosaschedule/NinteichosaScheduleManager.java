///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.ninteichosaschedule;
//
//import java.util.ArrayList;
//import java.util.List;
//import static java.util.Objects.requireNonNull;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain.ChikuNinteiChosain;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedule.NinteichosaSchedule;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo.NinteiChosaScheduleMemo;
//import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJoho;
//import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.NinteichosaScheduleMapperParameter;
//import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosaschedule.NinteichosaScheduleEntity;
//import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5221NinteichosaScheduleDac;
//import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteischedule.ninteichosaschedule.INinteichosaScheduleMapper;
//import jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.chikuninteichosain.ChikuNinteiChosainManager;
//import jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.ninteichosaschedulememo.NinteiChosaScheduleMemoManager;
//import jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.ninteishinseijoho.NinteiShinseiJohoManager;
//import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
//import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
//import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
//import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
//
///**
// * 認定調査スケジュール情報を管理するクラスです。
// */
//public class NinteichosaScheduleManager {
//
//    private final MapperProvider mapperProvider;
//    private final DbT5221NinteichosaScheduleDac 認定調査スケジュール情報Dac;
//    private final NinteiChosaScheduleMemoManager 認定調査スケジュールメモ情報Manager;
//    private final NinteiShinseiJohoManager 要介護認定申請情報Manager;
//    private final ChikuNinteiChosainManager 地区認定調査員Manager;
//
//    /**
//     * コンストラクタです。
//     */
//    NinteichosaScheduleManager() {
//        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
//        this.認定調査スケジュール情報Dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
//        this.認定調査スケジュールメモ情報Manager = new NinteiChosaScheduleMemoManager();
//        this.要介護認定申請情報Manager = new NinteiShinseiJohoManager();
//        this.地区認定調査員Manager =  ChikuNinteiChosainManager.createInstance();
//    }
//
//    /**
//     * 単体テスト用のコンストラクタです。
//     * 
//     * @param mapperProvider mapperProvider
//     * @param 認定調査スケジュール情報Dac 認定調査スケジュール情報Dac
//     * @param 認定調査スケジュールメモ情報Manager 認定調査スケジュールメモ情報Manager
//     * @param 要介護認定申請情報Manager 要介護認定申請情報Manager
//     * @param 地区認定調査員Manager 地区認定調査員Manager
//     */
//    NinteichosaScheduleManager(
//            MapperProvider mapperProvider,
//            DbT5221NinteichosaScheduleDac 認定調査スケジュール情報Dac,
//            NinteiChosaScheduleMemoManager 認定調査スケジュールメモ情報Manager,
//            NinteiShinseiJohoManager 要介護認定申請情報Manager,
//            ChikuNinteiChosainManager 地区認定調査員Manager
//    ) {
//        this.mapperProvider = mapperProvider;
//        this.認定調査スケジュール情報Dac = 認定調査スケジュール情報Dac;
//        this.認定調査スケジュールメモ情報Manager = 認定調査スケジュールメモ情報Manager;
//        this.要介護認定申請情報Manager = 要介護認定申請情報Manager;
//        this.地区認定調査員Manager = 地区認定調査員Manager;
//    }
//
//    /**
//     * {@link InstanceProvider#create}にて生成した{@link NinteichosaScheduleManager}のインスタンスを返します。
//     *
//     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaScheduleManager}のインスタンス
//     */
//    public static NinteichosaScheduleManager createInstance() {
//        return InstanceProvider.create(NinteichosaScheduleManager.class);
//    }
//
//    /**
//     * 主キーに合致する認定調査スケジュール情報を返します。
//     *
//     * @param 認定調査スケジュール情報検索条件 認定調査スケジュール情報検索条件
//     * @return NinteichosaSchedule nullが返る可能性があります。
//     */
//    @Transaction
//    public NinteichosaSchedule get認定調査スケジュール情報(NinteichosaScheduleMapperParameter 認定調査スケジュール情報検索条件) {
//        requireNonNull(認定調査スケジュール情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール情報検索条件"));
//        INinteichosaScheduleMapper mapper = mapperProvider.create(INinteichosaScheduleMapper.class);
//
//        NinteichosaScheduleEntity relateEntity = mapper.select認定調査スケジュール情報ByKey(認定調査スケジュール情報検索条件);
//        if (relateEntity == null) {
//            return null;
//        }
//        relateEntity.initializeMd5ToEntities();
//        return new NinteichosaSchedule(relateEntity);
//    }
//
//    /**
//     * 主キー1に合致する認定調査スケジュール情報のリストを返します。
//     *
//     * @param 認定調査スケジュール情報検索条件 認定調査スケジュール情報検索条件
//     * @return NinteichosaScheduleの{@code list}
//     */
//    @Transaction
//    public List<NinteichosaSchedule> get認定調査スケジュール情報リストBy主キー1(NinteichosaScheduleMapperParameter 認定調査スケジュール情報検索条件) {
//        requireNonNull(認定調査スケジュール情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール情報検索条件"));
//        INinteichosaScheduleMapper mapper = mapperProvider.create(INinteichosaScheduleMapper.class);
//
//        List<NinteichosaScheduleEntity> relateEntityList = mapper.select認定調査スケジュール情報リストBy主キー1(認定調査スケジュール情報検索条件);
//
//        ArrayList<NinteichosaSchedule> 認定調査スケジュール情報List = new ArrayList<>();
//        for (NinteichosaScheduleEntity relateEntity : relateEntityList) {
//            relateEntity.initializeMd5ToEntities();
//            認定調査スケジュール情報List.add(new NinteichosaSchedule(relateEntity));
//        }
//        return 認定調査スケジュール情報List;
//
//    }
//
//    /**
//     * 認定調査スケジュール情報{@link NinteichosaSchedule}を保存します。
//     *
//     * @param 認定調査スケジュール情報 認定調査スケジュール情報
//     * @return 更新あり:true、更新なし:false <br>
//     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
//     */
//    @Transaction
//    public boolean save(NinteichosaSchedule 認定調査スケジュール情報) {
//        requireNonNull(認定調査スケジュール情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール情報"));
//
//        if (!認定調査スケジュール情報.hasChanged()) {
//            return false;
//        }
//        認定調査スケジュール情報 = 認定調査スケジュール情報.modifiedModel();
//        save認定調査スケジュールメモ情報リスト(認定調査スケジュール情報.getNinteiChosaScheduleMemoList());
//        save要介護認定申請情報リスト(認定調査スケジュール情報.getNinteiShinseiJohoList()); 
//        save地区認定調査員リスト(認定調査スケジュール情報.getChikuNinteiChosainList()); 
//        return 1 == 認定調査スケジュール情報Dac.save(認定調査スケジュール情報.toEntity());
//    }
//
//    private void save認定調査スケジュールメモ情報リスト(List<NinteiChosaScheduleMemo> 認定調査スケジュールメモ情報List) {    
//        for (NinteiChosaScheduleMemo 認定調査スケジュールメモ情報 : 認定調査スケジュールメモ情報List) {
//            認定調査スケジュールメモ情報Manager.save認定調査スケジュールメモ情報(認定調査スケジュールメモ情報);
//        }
//    }
//
//    private void save要介護認定申請情報リスト(List<NinteiShinseiJoho> 要介護認定申請情報List) {    
//        for (NinteiShinseiJoho 要介護認定申請情報 : 要介護認定申請情報List) {
//            要介護認定申請情報Manager.save要介護認定申請情報(要介護認定申請情報);
//        }
//    }
//
//    private void save地区認定調査員リスト(List<ChikuNinteiChosain> 地区認定調査員List) {    
//        for (ChikuNinteiChosain 地区認定調査員 : 地区認定調査員List) {
//            地区認定調査員Manager.save(地区認定調査員);
//        }
//    }
//}
