/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseiShurui;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3099TandokuJoseiShuruiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村単独助成種類を管理するクラスです。
 */
public class TandokuJoseiShuruiManager {

    private final DbT3099TandokuJoseiShuruiDac dac;

    /**
     * コンストラクタです。
     */
    public TandokuJoseiShuruiManager() {
        dac = InstanceProvider.create(DbT3099TandokuJoseiShuruiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3099TandokuJoseiShuruiDac}
     */
    TandokuJoseiShuruiManager(DbT3099TandokuJoseiShuruiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する市町村単独助成種類を返します。
     *
     * @param 市町村単独助成種類 TandokuJoseiShuruiCode
     * @param 助成サービス種類コード JoseiServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return TandokuJoseiShurui
     */
    @Transaction
    public TandokuJoseiShurui get市町村単独助成種類(
            RString 市町村単独助成種類,
            ServiceShuruiCode 助成サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            Decimal 履歴番号) {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        requireNonNull(助成サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3099TandokuJoseiShuruiEntity entity = dac.selectByKey(
                市町村単独助成種類,
                助成サービス種類コード,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TandokuJoseiShurui(entity);
    }

    /**
     * 市町村単独助成種類を全件返します。
     *
     * @return List<TandokuJoseiShurui>
     */
    @Transaction
    public List<TandokuJoseiShurui> get市町村単独助成種類一覧() {
        List<TandokuJoseiShurui> businessList = new ArrayList<>();

        for (DbT3099TandokuJoseiShuruiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TandokuJoseiShurui(entity));
        }

        return businessList;
    }

    /**
     * 市町村単独助成種類{@link TandokuJoseiShurui}を保存します。
     *
     * @param 市町村単独助成種類 {@link TandokuJoseiShurui}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save市町村単独助成種類(TandokuJoseiShurui 市町村単独助成種類) {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        if (!市町村単独助成種類.hasChanged()) {
            return false;
        }
        return 1 == dac.save(市町村単独助成種類.toEntity());
    }
}
