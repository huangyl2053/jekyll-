/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4014RiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.riyoshafutangengaku.IRiyoshaFutangakuGengakuMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei.GemmenGengakuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担額減額を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class RiyoshaFutangakuGengakuManager {

    private final MapperProvider mapperProvider;
    private final GemmenGengakuShinseiManager gemmenGengakuShinseiManager;
    private final DbT4014RiyoshaFutangakuGengakuDac dac;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutangakuGengakuManager() {
        dac = InstanceProvider.create(DbT4014RiyoshaFutangakuGengakuDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        gemmenGengakuShinseiManager = InstanceProvider.create(GemmenGengakuShinseiManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     * @param gemmenGengakuShinseiManager {@link GemmenGengakuShinseiManager}
     * @param dac {@link DbT4014RiyoshaFutangakuGengakuDac}
     */
    RiyoshaFutangakuGengakuManager(MapperProvider mapperProvider,
            GemmenGengakuShinseiManager gemmenGengakuShinseiManager,
            DbT4014RiyoshaFutangakuGengakuDac dac) {
        this.mapperProvider = mapperProvider;
        this.gemmenGengakuShinseiManager = gemmenGengakuShinseiManager;
        this.dac = dac;
    }

    /**
     * 利用者負担額減額を管理するクラスを生成します。
     *
     * @return 利用者負担額減額を管理するクラス
     */
    public static RiyoshaFutangakuGengakuManager createInstance() {
        return InstanceProvider.create(RiyoshaFutangakuGengakuManager.class);
    }

    /**
     * 主キーに合致する利用者負担額減額を返します。
     *
     * @param parameter {@link RiyoshaFutangakuGengakuMapperParameter}
     * @return RiyoshaFutangakuGengaku
     */
    @Transaction
    public RiyoshaFutangakuGengaku get利用者負担額減額(
            RiyoshaFutangakuGengakuMapperParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額減額情報検索条件"));
        IRiyoshaFutangakuGengakuMapper mapper = mapperProvider.create(IRiyoshaFutangakuGengakuMapper.class);
        RiyoshaFutangakuGengakuEntity entity = mapper.select利用者負担額減額ByKey(parameter);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5ToEntities();
        return new RiyoshaFutangakuGengaku(entity);
    }

    /**
     * 主キー1に合致する利用者負担額減額のリストを返します。
     *
     * @param parameter {@link RiyoshaFutangakuGengakuMapperParameter}
     * @return RiyoshaFutangakuGengakuの{@code list}
     */
    @Transaction
    public List<RiyoshaFutangakuGengaku> get利用者負担額減額リストBy主キー1(RiyoshaFutangakuGengakuMapperParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額減額情報検索条件"));
        IRiyoshaFutangakuGengakuMapper mapper = mapperProvider.create(IRiyoshaFutangakuGengakuMapper.class);
        List<RiyoshaFutangakuGengakuEntity> relateEntityList = mapper.select利用者負担額減額リストBy主キー1(parameter);
        List<RiyoshaFutangakuGengaku> 利用者負担額減額情報List = new ArrayList<>();
        for (RiyoshaFutangakuGengakuEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            利用者負担額減額情報List.add(new RiyoshaFutangakuGengaku(relateEntity));
        }
        return 利用者負担額減額情報List;

    }

    /**
     * 利用者負担額減額{@link RiyoshaFutangakuGengaku}を保存します。
     *
     * @param 利用者負担額減額 {@link RiyoshaFutangakuGengaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save利用者負担額減額(RiyoshaFutangakuGengaku 利用者負担額減額) {
        requireNonNull(利用者負担額減額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額減額"));
        if (!利用者負担額減額.hasChanged()) {
            return false;
        }
        save減免減額申請リスト(利用者負担額減額.getGemmenGengakuShinseiList());
        return 1 == dac.save(利用者負担額減額.toEntity());
    }

    /**
     * 利用者負担額減額{@link RiyoshaFutangakuGengaku}を保存します。
     *
     * @param 利用者負担額減額 {@link RiyoshaFutangakuGengaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean delete利用者負担額減額(RiyoshaFutangakuGengaku 利用者負担額減額) {
        requireNonNull(利用者負担額減額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額減額"));
        delete減免減額申請リストBy減免減額種類(利用者負担額減額.getGemmenGengakuShinseiList(), GemmenGengakuShurui.利用者負担額減額.getコード());
        return 1 == dac.delete(利用者負担額減額.toEntity());
    }

    private void save減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            gemmenGengakuShinseiManager.save減免減額申請(減免減額申請);
        }
    }

    private void delete減免減額申請リストBy減免減額種類(List<GemmenGengakuShinsei> 減免減額申請List, RString 減免減額種類) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            if (減免減額種類.equals(減免減額申請.get減免減額種類())) {
                gemmenGengakuShinseiManager.delete減免減額申請(減免減額申請);
            }
        }
    }

    /**
     * 被保険者番号、減免減額種類、履歴番号により、取得された利用者負担額減額の情報を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     * @return RiyoshaFutangakuGengaku
     */
    @Transaction
    public RiyoshaFutangakuGengaku get利用者負担額減額(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        IRiyoshaFutangakuGengakuMapper mapper = mapperProvider.create(IRiyoshaFutangakuGengakuMapper.class);
        NinteiJohoParameter 検索条件 = NinteiJohoParameter.createParameter(被保険者番号, 減免減額種類, 履歴番号);
        RiyoshaFutangakuGengakuEntity relateEntity = mapper.select利用者負担額減額(検索条件);

        relateEntity.initializeMd5ToEntities();
        return new RiyoshaFutangakuGengaku(relateEntity);
    }
}
