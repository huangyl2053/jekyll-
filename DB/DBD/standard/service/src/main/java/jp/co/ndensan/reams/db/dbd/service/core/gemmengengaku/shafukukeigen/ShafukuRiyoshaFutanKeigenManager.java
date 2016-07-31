/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shafukukeigen;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.shafukukeigen.IShafukuRiyoshaFutanKeigenMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei.GemmenGengakuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 社会福祉法人等利用者負担軽減を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class ShafukuRiyoshaFutanKeigenManager {

    private final MapperProvider mapperProvider;
    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac 社会福祉法人等利用者負担軽減Dac;
    private final GemmenGengakuShinseiManager 減免減額申請Manager;

    /**
     * コンストラクタです。
     */
    ShafukuRiyoshaFutanKeigenManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.社会福祉法人等利用者負担軽減Dac = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
        this.減免減額申請Manager = new GemmenGengakuShinseiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 社会福祉法人等利用者負担軽減Dac 社会福祉法人等利用者負担軽減Dac
     * @param 減免減額申請Manager 減免減額申請Manager
     */
    ShafukuRiyoshaFutanKeigenManager(
            MapperProvider mapperProvider,
            DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac 社会福祉法人等利用者負担軽減Dac,
            GemmenGengakuShinseiManager 減免減額申請Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.社会福祉法人等利用者負担軽減Dac = 社会福祉法人等利用者負担軽減Dac;
        this.減免減額申請Manager = 減免減額申請Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShafukuRiyoshaFutanKeigenManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShafukuRiyoshaFutanKeigenManager}のインスタンス
     */
    public static ShafukuRiyoshaFutanKeigenManager createInstance() {
        return InstanceProvider.create(ShafukuRiyoshaFutanKeigenManager.class);
    }

    /**
     * 主キーに合致する社会福祉法人等利用者負担軽減を返します。
     *
     * @param 社会福祉法人等利用者負担軽減検索条件 社会福祉法人等利用者負担軽減検索条件
     * @return ShakaifukuRiyoshaFutanKeigen nullが返る可能性があります。
     */
    @Transaction
    public ShakaifukuRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減(
            ShafukuRiyoshaFutanKeigenMapperParameter 社会福祉法人等利用者負担軽減検索条件) {
        requireNonNull(社会福祉法人等利用者負担軽減検索条件,
                UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人等利用者負担軽減検索条件"));
        IShafukuRiyoshaFutanKeigenMapper mapper = mapperProvider.create(IShafukuRiyoshaFutanKeigenMapper.class);

        ShafukuRiyoshaFutanKeigenEntity relateEntity = mapper.select社会福祉法人等利用者負担軽減ByKey(社会福祉法人等利用者負担軽減検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShakaifukuRiyoshaFutanKeigen(relateEntity);
    }

    /**
     * 主キー1に合致する社会福祉法人等利用者負担軽減のリストを返します。
     *
     * @param 社会福祉法人等利用者負担軽減検索条件 社会福祉法人等利用者負担軽減検索条件
     * @return ShafukuRiyoshaFutanKeigenの{@code list}
     */
    @Transaction
    public List<ShakaifukuRiyoshaFutanKeigen> get社会福祉法人等利用者負担軽減リストBy主キー1(
            ShafukuRiyoshaFutanKeigenMapperParameter 社会福祉法人等利用者負担軽減検索条件) {
        requireNonNull(社会福祉法人等利用者負担軽減検索条件,
                UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人等利用者負担軽減検索条件"));
        IShafukuRiyoshaFutanKeigenMapper mapper = mapperProvider.create(IShafukuRiyoshaFutanKeigenMapper.class);

        List<ShafukuRiyoshaFutanKeigenEntity> relateEntityList
                = mapper.select社会福祉法人等利用者負担軽減リストBy主キー1(社会福祉法人等利用者負担軽減検索条件);

        List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減List = new ArrayList<>();
        for (ShafukuRiyoshaFutanKeigenEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            社会福祉法人等利用者負担軽減List.add(new ShakaifukuRiyoshaFutanKeigen(relateEntity));
        }
        return 社会福祉法人等利用者負担軽減List;

    }

    /**
     * 社会福祉法人等利用者負担軽減{@link ShakaiFukushiHojinRiyoshaFutanKeigen}を保存します。
     *
     * @param 社会福祉法人等利用者負担軽減 社会福祉法人等利用者負担軽減
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減) {
        requireNonNull(社会福祉法人等利用者負担軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人等利用者負担軽減"));

        if (!社会福祉法人等利用者負担軽減.hasChanged()) {
            return false;
        }
        社会福祉法人等利用者負担軽減 = 社会福祉法人等利用者負担軽減.modifiedModel();
        save減免減額申請リスト(社会福祉法人等利用者負担軽減.getGemmenGengakuShinseiList());
        return 1 == 社会福祉法人等利用者負担軽減Dac.save(社会福祉法人等利用者負担軽減.toEntity());
    }

    private void save減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.save減免減額申請(減免減額申請);
        }
    }

    /**
     * 利用者負担額減額{@link ShakaifukuRiyoshaFutanKeigen}を保存します。
     *
     * @param 社会福祉法人等利用者負担軽減 {@link ShakaifukuRiyoshaFutanKeigen}
     * @param 減免減額種類 減免減額種類
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean delete社会福祉法人等利用者負担軽減By減免減額種類(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減, RString 減免減額種類) {
        requireNonNull(社会福祉法人等利用者負担軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人等利用者負担軽減"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        List<GemmenGengakuShinsei> 減免減額申請リスト = 社会福祉法人等利用者負担軽減.getGemmenGengakuShinseiList();
        List<GemmenGengakuShinsei> 削除減免減額申請リスト = new ArrayList<>();
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請リスト) {
            if (!減免減額種類.equals(減免減額申請.get減免減額種類())) {
                削除減免減額申請リスト.add(減免減額申請);
            }
        }
        if (!削除減免減額申請リスト.isEmpty()) {
            減免減額申請リスト.removeAll(削除減免減額申請リスト);
        }
        delete減免減額申請リスト(減免減額申請リスト);
        return 1 == 社会福祉法人等利用者負担軽減Dac.delete(社会福祉法人等利用者負担軽減.toEntity());
    }

    private void delete減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.delete減免減額申請(減免減額申請);
        }
    }

    /**
     * 被保険者番号、減免減額種類、履歴番号により、取得された社会福祉法人等利用者負担軽減を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     * @return ShafukuRiyoshaFutanKeigen
     */
    @Transaction
    public ShakaifukuRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        IShafukuRiyoshaFutanKeigenMapper mapper = mapperProvider.create(IShafukuRiyoshaFutanKeigenMapper.class);
        NinteiJohoParameter 検索条件 = NinteiJohoParameter.createParameter(被保険者番号, 減免減額種類, 履歴番号);
        ShafukuRiyoshaFutanKeigenEntity relateEntity = mapper.select社会福祉法人等利用者負担軽減(検索条件);
        relateEntity.initializeMd5ToEntities();
        return new ShakaifukuRiyoshaFutanKeigen(relateEntity);

    }
}
