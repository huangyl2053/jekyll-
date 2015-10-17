/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.RiyoshaFutanWariaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.IRiyoshaFutanWariaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合を管理するクラスです。
 */
public class RiyoshaFutanWariaiManager {

    private final MapperProvider mapperProvider;
    private final DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac;
    private final RiyoshaFutanWariaiMeisaiManager 利用者負担割合明細Manager;

    /**
     * コンストラクタです。
     */
    RiyoshaFutanWariaiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.利用者負担割合Dac = InstanceProvider.create(DbT3113RiyoshaFutanWariaiDac.class);
        this.利用者負担割合明細Manager = new RiyoshaFutanWariaiMeisaiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 利用者負担割合Dac 利用者負担割合Dac
     * @param 利用者負担割合明細Manager 利用者負担割合明細Manager
     */
    RiyoshaFutanWariaiManager(
            MapperProvider mapperProvider,
            DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac,
            RiyoshaFutanWariaiMeisaiManager 利用者負担割合明細Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.利用者負担割合Dac = 利用者負担割合Dac;
        this.利用者負担割合明細Manager = 利用者負担割合明細Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiManager}のインスタンス
     */
    public static RiyoshaFutanWariaiManager createInstance() {
        return InstanceProvider.create(RiyoshaFutanWariaiManager.class);
    }

    /**
     * 主キーに合致する利用者負担割合を返します。
     *
     * @param 利用者負担割合検索条件 利用者負担割合検索条件
     * @return RiyoshaFutanWariai 【　※ツールの都合上、このカッコ部は手動で削除して下さい 利用者負担割合】
     * nullが返る可能性があります。
     */
    @Transaction
    public RiyoshaFutanWariai get利用者負担割合(RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件) {
        requireNonNull(利用者負担割合検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合検索条件"));
        IRiyoshaFutanWariaiMapper mapper = mapperProvider.create(IRiyoshaFutanWariaiMapper.class);

        RiyoshaFutanWariaiEntity relateEntity = mapper.select利用者負担割合ByKey(利用者負担割合検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new RiyoshaFutanWariai(relateEntity.get利用者負担割合Entity());
    }

    /**
     * 主キー1に合致する利用者負担割合のリストを返します。
     *
     * @param 利用者負担割合検索条件 利用者負担割合検索条件
     * @return RiyoshaFutanWariaiの{@code list}
     */
    @Transaction
    public List<RiyoshaFutanWariai> get利用者負担割合リストBy主キー1(RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件) {
        requireNonNull(利用者負担割合検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合検索条件"));
        IRiyoshaFutanWariaiMapper mapper = mapperProvider.create(IRiyoshaFutanWariaiMapper.class);

        List<RiyoshaFutanWariaiEntity> relateEntityList = mapper.select利用者負担割合リストBy主キー1(利用者負担割合検索条件);

        ArrayList<RiyoshaFutanWariai> 利用者負担割合List = new ArrayList<>();
        for (RiyoshaFutanWariaiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            利用者負担割合List.add(new RiyoshaFutanWariai(relateEntity.get利用者負担割合Entity()));
        }
        return 利用者負担割合List;

    }

    /**
     * 利用者負担割合{@link RiyoshaFutanWariai}を保存します。
     *
     * @param 利用者負担割合 利用者負担割合
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(RiyoshaFutanWariai 利用者負担割合) {
        requireNonNull(利用者負担割合, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合"));

        if (!利用者負担割合.hasChanged()) {
            return false;
        }
        利用者負担割合 = 利用者負担割合.modifiedModel();
        save利用者負担割合明細リスト(利用者負担割合.getRiyoshaFutanWariaiMeisaiList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 利用者負担割合Dac.save(利用者負担割合.toEntity());
    }

    private void save利用者負担割合明細リスト(List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List) {
        for (RiyoshaFutanWariaiMeisai 利用者負担割合明細 : 利用者負担割合明細List) {
            利用者負担割合明細Manager.save(利用者負担割合明細);
        }
    }
}
