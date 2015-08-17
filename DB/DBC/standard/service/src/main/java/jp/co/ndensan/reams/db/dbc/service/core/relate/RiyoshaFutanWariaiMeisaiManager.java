/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.RiyoshaFutanWariaiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate.IRiyoshaFutanWariaiMeisaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.RiyoshaFutanWariaiKonkyoManager;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合明細を管理するクラスです。
 */
public class RiyoshaFutanWariaiMeisaiManager {

    private final MapperProvider mapperProvider;
    private final DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac;
    private final RiyoshaFutanWariaiKonkyoManager 利用者負担割合世帯員Manager;

    /**
     * コンストラクタです。
     */
    RiyoshaFutanWariaiMeisaiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.利用者負担割合明細Dac = InstanceProvider.create(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
        this.利用者負担割合世帯員Manager = new RiyoshaFutanWariaiKonkyoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 利用者負担割合明細Dac 利用者負担割合明細Dac
     * @param 利用者負担割合世帯員Manager 利用者負担割合世帯員Manager
     */
    RiyoshaFutanWariaiMeisaiManager(
            MapperProvider mapperProvider,
            DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac,
            RiyoshaFutanWariaiKonkyoManager 利用者負担割合世帯員Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.利用者負担割合明細Dac = 利用者負担割合明細Dac;
        this.利用者負担割合世帯員Manager = 利用者負担割合世帯員Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiMeisaiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiMeisaiManager}のインスタンス
     */
    public static RiyoshaFutanWariaiMeisaiManager createInstance() {
        return InstanceProvider.create(RiyoshaFutanWariaiMeisaiManager.class);
    }

    /**
     * 主キーに合致する利用者負担割合明細を返します。
     *
     * @param 利用者負担割合明細検索条件 利用者負担割合明細検索条件
     * @return RiyoshaFutanWariaiMeisai nullが返る可能性があります。
     */
    @Transaction
    public RiyoshaFutanWariaiMeisai get利用者負担割合明細(RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件) {
        requireNonNull(利用者負担割合明細検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合明細検索条件"));
        IRiyoshaFutanWariaiMeisaiMapper mapper = mapperProvider.create(IRiyoshaFutanWariaiMeisaiMapper.class);

        RiyoshaFutanWariaiMeisaiEntity relateEntity = mapper.select利用者負担割合明細ByKey(利用者負担割合明細検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new RiyoshaFutanWariaiMeisai(relateEntity.get利用者負担割合明細Entity());
    }

    /**
     * 主キー1に合致する利用者負担割合明細のリストを返します。
     *
     * @param 利用者負担割合明細検索条件 利用者負担割合明細検索条件
     * @return RiyoshaFutanWariaiMeisaiの{@code list}
     */
    @Transaction
    public List<RiyoshaFutanWariaiMeisai> get利用者負担割合明細リストBy主キー1(RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件) {
        requireNonNull(利用者負担割合明細検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合明細検索条件"));
        IRiyoshaFutanWariaiMeisaiMapper mapper = mapperProvider.create(IRiyoshaFutanWariaiMeisaiMapper.class);

        List<RiyoshaFutanWariaiMeisaiEntity> relateEntityList = mapper.select利用者負担割合明細リストBy主キー1(利用者負担割合明細検索条件);

        ArrayList<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List = new ArrayList<>();
        for (RiyoshaFutanWariaiMeisaiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            利用者負担割合明細List.add(new RiyoshaFutanWariaiMeisai(relateEntity.get利用者負担割合明細Entity()));
        }
        return 利用者負担割合明細List;

    }

    /**
     * 利用者負担割合明細{@link RiyoshaFutanWariaiMeisai}を保存します。
     *
     * @param 利用者負担割合明細 利用者負担割合明細
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(RiyoshaFutanWariaiMeisai 利用者負担割合明細) {
        requireNonNull(利用者負担割合明細, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合明細"));

        if (!利用者負担割合明細.hasChanged()) {
            return false;
        }
        利用者負担割合明細 = 利用者負担割合明細.modifiedModel();
        save利用者負担割合世帯員リスト(利用者負担割合明細.getRiyoshaFutanWariaiKonkyoList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 利用者負担割合明細Dac.save(利用者負担割合明細.toEntity());
    }

    private void save利用者負担割合世帯員リスト(List<RiyoshaFutanWariaiKonkyo> 利用者負担割合世帯員List) {
        for (RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 : 利用者負担割合世帯員List) {
            利用者負担割合世帯員Manager.save利用者負担割合世帯員(利用者負担割合世帯員);
        }
    }
}
