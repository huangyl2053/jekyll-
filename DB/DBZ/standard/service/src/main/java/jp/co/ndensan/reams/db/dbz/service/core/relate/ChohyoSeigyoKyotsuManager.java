/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsuControl;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ChohyoSeigyoKyotsuMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IChohyoSeigyoKyotsuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuControlManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票制御共通を管理するクラスです。
 */
public class ChohyoSeigyoKyotsuManager {

    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final ChohyoSeigyoKyotsuControlManager 帳票制御共通コントロールManager;
    private final ChohyoSeigyoHanyoManager 帳票制御汎用Manager;

    /**
     * コンストラクタです。
     */
    ChohyoSeigyoKyotsuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御共通コントロールManager = new ChohyoSeigyoKyotsuControlManager();
        this.帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 帳票制御共通Dac 帳票制御共通Dac
     * @param 帳票制御共通コントロールManager 帳票制御共通コントロールManager
     * @param 帳票制御汎用Manager 帳票制御汎用Manager
     */
    ChohyoSeigyoKyotsuManager(
            MapperProvider mapperProvider,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac,
            ChohyoSeigyoKyotsuControlManager 帳票制御共通コントロールManager,
            ChohyoSeigyoHanyoManager 帳票制御汎用Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.帳票制御共通Dac = 帳票制御共通Dac;
        this.帳票制御共通コントロールManager = 帳票制御共通コントロールManager;
        this.帳票制御汎用Manager = 帳票制御汎用Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChohyoSeigyoKyotsuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ChohyoSeigyoKyotsuManager}のインスタンス
     */
    public static ChohyoSeigyoKyotsuManager createInstance() {
        return InstanceProvider.create(ChohyoSeigyoKyotsuManager.class);
    }

    /**
     * 主キーに合致する帳票制御共通を返します。
     *
     * @param 帳票制御共通検索条件 帳票制御共通検索条件
     * @return ChohyoSeigyoKyotsu nullが返る可能性があります。
     */
    @Transaction
    public ChohyoSeigyoKyotsu get帳票制御共通(ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件) {
        requireNonNull(帳票制御共通検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通検索条件"));
        IChohyoSeigyoKyotsuMapper mapper = mapperProvider.create(IChohyoSeigyoKyotsuMapper.class);

        ChohyoSeigyoKyotsuEntity relateEntity = mapper.select帳票制御共通ByKey(帳票制御共通検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ChohyoSeigyoKyotsu(relateEntity.get帳票制御共通Entity());
    }

    /**
     * 主キー1に合致する帳票制御共通のリストを返します。
     *
     * @param 帳票制御共通検索条件 帳票制御共通検索条件
     * @return ChohyoSeigyoKyotsuの{@code list}
     */
    @Transaction
    public List<ChohyoSeigyoKyotsu> get帳票制御共通リストBy主キー1(ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件) {
        requireNonNull(帳票制御共通検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通検索条件"));
        IChohyoSeigyoKyotsuMapper mapper = mapperProvider.create(IChohyoSeigyoKyotsuMapper.class);

        List<ChohyoSeigyoKyotsuEntity> relateEntityList = mapper.select帳票制御共通リストBy主キー1(帳票制御共通検索条件);

        ArrayList<ChohyoSeigyoKyotsu> 帳票制御共通List = new ArrayList<>();
        for (ChohyoSeigyoKyotsuEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            帳票制御共通List.add(new ChohyoSeigyoKyotsu(relateEntity.get帳票制御共通Entity()));
        }
        return 帳票制御共通List;

    }

    /**
     * 要介護認定主治医意見書情報（子）{@link ChohyoSeigyoKyotsu}を保存します。
     *
     * @param 帳票制御共通 帳票制御共通
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ChohyoSeigyoKyotsu 帳票制御共通) {
        requireNonNull(帳票制御共通, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通"));

        if (!帳票制御共通.hasChanged()) {
            return false;
        }
        帳票制御共通 = 帳票制御共通.modifiedModel();
        save帳票制御共通コントロールリスト(帳票制御共通.getChohyoSeigyoKyotsuControlList());  // XXXは本メソッドの引数に変更してください。
        save帳票制御汎用リスト(帳票制御共通.getChohyoSeigyoHanyoList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 帳票制御共通Dac.save(帳票制御共通.toEntity());
    }

    private void save帳票制御共通コントロールリスト(List<ChohyoSeigyoKyotsuControl> 帳票制御共通コントロールList) {
        for (ChohyoSeigyoKyotsuControl 帳票制御共通コントロール : 帳票制御共通コントロールList) {
            帳票制御共通コントロールManager.save帳票制御共通コントロール(帳票制御共通コントロール);
        }
    }

    private void save帳票制御汎用リスト(List<ChohyoSeigyoHanyo> 帳票制御汎用List) {
        for (ChohyoSeigyoHanyo 帳票制御汎用 : 帳票制御汎用List) {
            帳票制御汎用Manager.save帳票制御汎用(帳票制御汎用);
        }
    }
}
