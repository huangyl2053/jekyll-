/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.FutanGendogakuNinteiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4018FutanGendogakuNinteiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.futangendogakunintei.IFutanGendogakuNinteiMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei.GemmenGengakuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 負担限度額認定を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class FutanGendogakuNinteiManager {

    private static final RString TXT負担限度額認定検索条件 = new RString("負担限度額認定検索条件");
    private final MapperProvider mapperProvider;
    private final DbT4018FutanGendogakuNinteiDac 介護保険負担限度額認定Dac;
    private final GemmenGengakuShinseiManager 減免減額申請Manager;

    /**
     * コンストラクタです。
     */
    FutanGendogakuNinteiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護保険負担限度額認定Dac = InstanceProvider.create(DbT4018FutanGendogakuNinteiDac.class);
        this.減免減額申請Manager = new GemmenGengakuShinseiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護保険負担限度額認定Dac 介護保険負担限度額認定Dac
     * @param 減免減額申請Manager 減免減額申請Manager
     */
    FutanGendogakuNinteiManager(
            MapperProvider mapperProvider,
            DbT4018FutanGendogakuNinteiDac 介護保険負担限度額認定Dac,
            GemmenGengakuShinseiManager 減免減額申請Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護保険負担限度額認定Dac = 介護保険負担限度額認定Dac;
        this.減免減額申請Manager = 減免減額申請Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FutanGendogakuNinteiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FutanGendogakuNinteiManager}のインスタンス
     */
    public static FutanGendogakuNinteiManager createInstance() {
        return InstanceProvider.create(FutanGendogakuNinteiManager.class);
    }

    /**
     * 主キーに合致する負担限度額認定を返します。
     *
     * @param 負担限度額認定検索条件 負担限度額認定検索条件
     * @return KaigoHokenFutanGendogakuNintei nullが返る可能性があります。
     */
    @Transaction
    public FutanGendogakuNintei get負担限度額認定(FutanGendogakuNinteiMapperParameter 負担限度額認定検索条件) {
        requireNonNull(負担限度額認定検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT負担限度額認定検索条件.toString()));
        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);

        FutanGendogakuNinteiEntity relateEntity = mapper.select負担限度額認定ByKey(負担限度額認定検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new FutanGendogakuNintei(relateEntity);
    }

    /**
     * 主キー1に合致する負担限度額認定のリストを返します。
     *
     * @param 負担限度額認定検索条件 負担限度額認定検索条件
     * @return FutanGendogakuNinteiの{@code list}
     */
    @Transaction
    public List<FutanGendogakuNintei> get負担限度額認定リストBy主キー1(FutanGendogakuNinteiMapperParameter 負担限度額認定検索条件) {
        requireNonNull(負担限度額認定検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT負担限度額認定検索条件.toString()));
        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);

        List<FutanGendogakuNinteiEntity> relateEntityList = mapper.select負担限度額認定リストBy主キー1(負担限度額認定検索条件);

        ArrayList<FutanGendogakuNintei> 介護保険負担限度額認定List = new ArrayList<>();
        for (FutanGendogakuNinteiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            介護保険負担限度額認定List.add(new FutanGendogakuNintei(relateEntity));
        }
        return 介護保険負担限度額認定List;

    }

    /**
     * 負担限度額認定{@link KaigoHokenFutanGendogakuNintei}を保存します。
     *
     * @param 介護保険負担限度額認定 介護保険負担限度額認定
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(FutanGendogakuNintei 介護保険負担限度額認定) {
        requireNonNull(介護保険負担限度額認定, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT負担限度額認定検索条件.toString()));

        if (!介護保険負担限度額認定.hasChanged()) {
            return false;
        }
        介護保険負担限度額認定 = 介護保険負担限度額認定.modifiedModel();
        save減免減額申請リスト(介護保険負担限度額認定.getGemmenGengakuShinseiList());
        return 1 == 介護保険負担限度額認定Dac.save(介護保険負担限度額認定.toEntity());
    }

    /**
     * 負担限度額認定{@link KaigoHokenFutanGendogakuNintei}を保存します。
     *
     * @param 介護保険負担限度額認定 介護保険負担限度額認定
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean saveOrDeletePhysicalBy(FutanGendogakuNintei 介護保険負担限度額認定) {
        requireNonNull(介護保険負担限度額認定, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT負担限度額認定検索条件.toString()));

        if (!介護保険負担限度額認定.hasChanged()) {
            return false;
        }
        介護保険負担限度額認定 = 介護保険負担限度額認定.modifiedModel();
        saveOrDeletePhysicalBy減免減額申請リスト(介護保険負担限度額認定.getGemmenGengakuShinseiList());
        return 1 == 介護保険負担限度額認定Dac.saveOrDeletePhysicalBy(介護保険負担限度額認定.toEntity());
    }

    private void save減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.save減免減額申請(減免減額申請);
        }
    }

    private void saveOrDeletePhysicalBy減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.saveOrDeletePhysicalBy減免減額申請(減免減額申請);
        }
    }

    /**
     * 負担限度額認定更新のお知らせ通知書が発行可能である場合、介護負担限度額認定の情報を取得する。
     *
     * @param 負担限度額認定検索条件 負担限度額認定検索条件
     * @return FutanGendogakuNinteiの{@code list}
     */
    @Transaction
    public ArrayList<FutanGendogakuNintei> get負担限度額認定画面用リスト(FutanGendogakuNinteiParameter 負担限度額認定検索条件) {
        requireNonNull(負担限度額認定検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT負担限度額認定検索条件.toString()));
        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);

        List<FutanGendogakuNinteiEntity> relateEntityList = mapper.select負担限度額認定画面用リスト(負担限度額認定検索条件);

        ArrayList<FutanGendogakuNintei> 介護保険負担限度額認定List = new ArrayList<>();
        for (FutanGendogakuNinteiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            介護保険負担限度額認定List.add(new FutanGendogakuNintei(relateEntity));
        }
        return 介護保険負担限度額認定List;
    }

    /**
     * 介護負担限度額認定の情報を取得する。
     *
     * @param 負担限度額認定検索条件 負担限度額認定検索条件
     * @return FutanGendogakuNinteiの{@code}
     */
    @Transaction
    public FutanGendogakuNintei get負担限度額認定帳票用(FutanGendogakuNinteiParameter 負担限度額認定検索条件) {
        requireNonNull(負担限度額認定検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT負担限度額認定検索条件.toString()));
        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);

        FutanGendogakuNinteiEntity relateEntity = mapper.get負担限度額認定帳票用リスト(負担限度額認定検索条件);
        if (relateEntity == null) {
            return null;
        }
        return new FutanGendogakuNintei(relateEntity);
    }

    /**
     * 主キー1に合致する負担限度額認定のリストを返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return FutanGendogakuNinteiの{@code list}
     */
    @Transaction
    public List<FutanGendogakuNintei> get負担限度額認定リストBy被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);
        FutanGendogakuNinteiShinseiMapperParameter 検索条件 = FutanGendogakuNinteiShinseiMapperParameter.createParam(
                被保険者番号, GemmenGengakuShurui.負担限度額認定.getコード());

        List<FutanGendogakuNinteiEntity> relateEntityList = mapper.select負担限度額認定リストBy被保険者番号(検索条件);

        ArrayList<FutanGendogakuNintei> 介護保険負担限度額認定List = new ArrayList<>();
        for (FutanGendogakuNinteiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            介護保険負担限度額認定List.add(new FutanGendogakuNintei(relateEntity));
        }
        return 介護保険負担限度額認定List;

    }

    /**
     * 被保険者番号、減免減額種類、履歴番号により、取得された負担限度額認定申請の情報を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     * @return FutanGendogakuNintei
     */
    @Transaction
    public FutanGendogakuNintei get負担限度額認定(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);
        NinteiJohoParameter 検索条件 = NinteiJohoParameter.createParameter(被保険者番号, 減免減額種類, 履歴番号);
        FutanGendogakuNinteiEntity relateEntity = mapper.select負担限度額認定(検索条件);

        relateEntity.initializeMd5ToEntities();
        return new FutanGendogakuNintei(relateEntity);
    }
}
