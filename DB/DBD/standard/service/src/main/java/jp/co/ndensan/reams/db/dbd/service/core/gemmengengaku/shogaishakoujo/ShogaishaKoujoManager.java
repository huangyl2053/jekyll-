/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shogaishakoujo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shogaishakoujo.ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4038ShogaishaKoujoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.shogaishakoujo.IShogaishaKoujoMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei.GemmenGengakuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 障がい書控除(仮申請情報登録)を管理するクラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public class ShogaishaKoujoManager {

    private final MapperProvider mapperProvider;
    private final DbT4038ShogaishaKoujoDac 障がい書控除Dac;
    private final GemmenGengakuShinseiManager 減免減額申請Manager;

    /**
     * コンストラクタです。
     */
    ShogaishaKoujoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.障がい書控除Dac = InstanceProvider.create(DbT4038ShogaishaKoujoDac.class);
        this.減免減額申請Manager = new GemmenGengakuShinseiManager();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShogaishaKoujoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShogaishaKoujoManager}のインスタンス
     */
    public static ShogaishaKoujoManager createInstance() {
        return InstanceProvider.create(ShogaishaKoujoManager.class);
    }

    /**
     * 障がい書控除{@link ShogaishaKoujo}を保存します。
     *
     * @param 障がい書控除 障がい書控除
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShogaishaKoujo 障がい書控除) {
        requireNonNull(障がい書控除, UrSystemErrorMessages.値がnull.getReplacedMessage("障がい書控除"));

        if (!障がい書控除.hasChanged()) {
            return false;
        }
        障がい書控除 = 障がい書控除.modifiedModel();
        save減免減額申請リスト(障がい書控除.getGemmenGengakuShinseiList());
        return 1 == 障がい書控除Dac.save(障がい書控除.toEntity());
    }

    private void save減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.save減免減額申請(減免減額申請);
        }
    }

    /**
     * 被保険者番号により、取得された障がい書控除申請一覧情報を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShogaishaKoujo
     */
    @Transaction
    public List<ShogaishaKoujo> getすべて障がい書控除申請一覧情報By被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        IShogaishaKoujoMapper mapper = mapperProvider.create(IShogaishaKoujoMapper.class);
        List<ShogaishaKoujoEntity> 申請一覧情報Entity
                = mapper.selectすべて障がい書控除申請一覧情報By被保険者番号(被保険者番号);
        List<ShogaishaKoujo> 申請一覧情報 = new ArrayList<>();
        for (ShogaishaKoujoEntity 申請情報Entity : 申請一覧情報Entity) {
            申請一覧情報.add(new ShogaishaKoujo(申請情報Entity));
        }
        return 申請一覧情報;

    }

    /**
     * 被保険者番号により、対象年度重複チェックします。
     *
     * @param 被保険者番号 被保険者番号
     * @return 対象年度List
     */
    @Transaction
    public List<FlexibleYear> 対象年度重複チェック(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        List<DbT4038ShogaishaKoujoEntity> 申請一覧情報Entity
                = 障がい書控除Dac.selectListBy被保険者番号(被保険者番号);
        List<FlexibleYear> 対象年度List = new ArrayList<>();
        for (DbT4038ShogaishaKoujoEntity entity : 申請一覧情報Entity) {
            対象年度List.add(entity.getTaishoNendo());
        }
        return 対象年度List;

    }

    /**
     * 利用者負担額減額{@link ShogaishaKoujo}を保存します。
     *
     * @param 障がい書控除申請登録情報 {@link ShogaishaKoujo}
     * @param 減免減額種類 減免減額種類
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean delete障がい書控除申請登録情報By減免減額種類(ShogaishaKoujo 障がい書控除申請登録情報, RString 減免減額種類) {
        requireNonNull(障がい書控除申請登録情報, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人等利用者負担軽減"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        List<GemmenGengakuShinsei> 減免減額申請リスト = 障がい書控除申請登録情報.getGemmenGengakuShinseiList();
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
        return 1 == 障がい書控除Dac.delete(障がい書控除申請登録情報.toEntity());
    }

    private void delete減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.delete減免減額申請(減免減額申請);
        }
    }

}
