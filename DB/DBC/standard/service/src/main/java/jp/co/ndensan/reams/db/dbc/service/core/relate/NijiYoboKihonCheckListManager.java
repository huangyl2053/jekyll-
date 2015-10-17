/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboCheckListHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboKihonCheckList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboNiniCheckList;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.NijiYoboKihonCheckListMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3101NijiYoboKihonCheckListDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.INijiYoboKihonCheckListMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboCheckListHanteiKekkaManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboNiniCheckListManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防基本チェックリストを管理するクラスです。
 */
public class NijiYoboKihonCheckListManager {

    private final MapperProvider mapperProvider;
    private final DbT3101NijiYoboKihonCheckListDac 二次予防基本チェックリストDac;
    private final NijiYoboNiniCheckListManager 二次予防任意チェックリストManager;
    private final NijiYoboCheckListHanteiKekkaManager 二次予防チェックリスト判定結果Manager;

    /**
     * コンストラクタです。
     */
    NijiYoboKihonCheckListManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.二次予防基本チェックリストDac = InstanceProvider.create(DbT3101NijiYoboKihonCheckListDac.class);
        this.二次予防任意チェックリストManager = new NijiYoboNiniCheckListManager();
        this.二次予防チェックリスト判定結果Manager = new NijiYoboCheckListHanteiKekkaManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 二次予防基本チェックリストDac 二次予防基本チェックリストDac
     * @param 二次予防任意チェックリストManager 二次予防任意チェックリストManager
     * @param 二次予防チェックリスト判定結果Manager 二次予防チェックリスト判定結果Manager
     */
    NijiYoboKihonCheckListManager(
            MapperProvider mapperProvider,
            DbT3101NijiYoboKihonCheckListDac 二次予防基本チェックリストDac,
            NijiYoboNiniCheckListManager 二次予防任意チェックリストManager,
            NijiYoboCheckListHanteiKekkaManager 二次予防チェックリスト判定結果Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.二次予防基本チェックリストDac = 二次予防基本チェックリストDac;
        this.二次予防任意チェックリストManager = 二次予防任意チェックリストManager;
        this.二次予防チェックリスト判定結果Manager = 二次予防チェックリスト判定結果Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NijiYoboKihonCheckListManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NijiYoboKihonCheckListManager}のインスタンス
     */
    public static NijiYoboKihonCheckListManager createInstance() {
        return InstanceProvider.create(NijiYoboKihonCheckListManager.class);
    }

    /**
     * 主キーに合致する二次予防基本チェックリストを返します。
     *
     * @param 二次予防基本チェックリスト検索条件 二次予防基本チェックリスト検索条件
     * @return NijiYoboKihonCheckList 【　※ツールの都合上、このカッコ部は手動で削除して下さい
     * 二次予防基本チェックリスト】 nullが返る可能性があります。
     */
    @Transaction
    public NijiYoboKihonCheckList get二次予防基本チェックリスト(NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件) {
        requireNonNull(二次予防基本チェックリスト検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防基本チェックリスト検索条件"));
        INijiYoboKihonCheckListMapper mapper = mapperProvider.create(INijiYoboKihonCheckListMapper.class);

        NijiYoboKihonCheckListEntity relateEntity = mapper.select二次予防基本チェックリストByKey(二次予防基本チェックリスト検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NijiYoboKihonCheckList(relateEntity.get二次予防基本チェックリストEntity());
    }

    /**
     * 主キー1に合致する二次予防基本チェックリストのリストを返します。
     *
     * @param 二次予防基本チェックリスト検索条件 二次予防基本チェックリスト検索条件
     * @return NijiYoboKihonCheckListの{@code list}
     */
    @Transaction
    public List<NijiYoboKihonCheckList> get二次予防基本チェックリストリストBy主キー1(NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件) {
        requireNonNull(二次予防基本チェックリスト検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防基本チェックリスト検索条件"));
        INijiYoboKihonCheckListMapper mapper = mapperProvider.create(INijiYoboKihonCheckListMapper.class);

        List<NijiYoboKihonCheckListEntity> relateEntityList = mapper.select二次予防基本チェックリストリストBy主キー1(二次予防基本チェックリスト検索条件);

        ArrayList<NijiYoboKihonCheckList> 二次予防基本チェックリストList = new ArrayList<>();
        for (NijiYoboKihonCheckListEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            二次予防基本チェックリストList.add(new NijiYoboKihonCheckList(relateEntity.get二次予防基本チェックリストEntity()));
        }
        return 二次予防基本チェックリストList;

    }

    /**
     * 二次予防基本チェックリスト{@link NijiYoboKihonCheckList}を保存します。
     *
     * @param 二次予防基本チェックリスト 二次予防基本チェックリスト
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NijiYoboKihonCheckList 二次予防基本チェックリスト) {
        requireNonNull(二次予防基本チェックリスト, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防基本チェックリスト"));

        if (!二次予防基本チェックリスト.hasChanged()) {
            return false;
        }
        二次予防基本チェックリスト = 二次予防基本チェックリスト.modifiedModel();
        save二次予防任意チェックリストリスト(二次予防基本チェックリスト.getNijiYoboNiniCheckListList());  // XXXは本メソッドの引数に変更してください。
        save二次予防チェックリスト判定結果リスト(二次予防基本チェックリスト.getNijiYoboCheckListHanteiKekkaList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 二次予防基本チェックリストDac.save(二次予防基本チェックリスト.toEntity());
    }

    private void save二次予防任意チェックリストリスト(List<NijiYoboNiniCheckList> 二次予防任意チェックリストList) {
        for (NijiYoboNiniCheckList 二次予防任意チェックリスト : 二次予防任意チェックリストList) {
            二次予防任意チェックリストManager.save二次予防任意チェックリスト(二次予防任意チェックリスト);
        }
    }

    private void save二次予防チェックリスト判定結果リスト(List<NijiYoboCheckListHanteiKekka> 二次予防チェックリスト判定結果List) {
        for (NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 : 二次予防チェックリスト判定結果List) {
            二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果);
        }
    }
}
