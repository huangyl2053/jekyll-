/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link Kibetsu}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class KibetsuBuilder {

    private final DbT2003KibetsuEntity entity;
    private final KibetsuIdentifier id;
    private final Models<ChoteiKyotsuIdentifier, ChoteiKyotsu> choteiKyotsu;

    /**
     * {@link DbT2003KibetsuEntity}より{@link Kibetsu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2003KibetsuEntity}
     * @param id {@link KibetsuIdentifier}
     *
     */
    KibetsuBuilder(
            DbT2003KibetsuEntity entity,
            KibetsuIdentifier id,
            Models<ChoteiKyotsuIdentifier, ChoteiKyotsu> choteiKyotsu
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.choteiKyotsu = choteiKyotsu.clone();

    }

    /**
     * 調定IDを設定します。
     *
     * @param 調定ID 調定ID
     * @return {@link KibetsuBuilder}
     */
    public KibetsuBuilder set調定ID(Decimal 調定ID) {
        requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));
        entity.setChoteiId(調定ID);
        return this;
    }

    /**
     * 調定共通情報のキー情報について判定します。<br>
     * 調定共通情報に関連できる調定共通情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は調定共通情報リストに調定共通情報{@link Kibetsu}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 調定共通情報 {@link Kibetsu}
     * @return {@link FukaJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public KibetsuBuilder setKibetsu(ChoteiKyotsu 調定共通情報) {
        if (hasSameIdentifier(調定共通情報.identifier())) {
            choteiKyotsu.add(調定共通情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ChoteiKyotsuIdentifier 調定共通情報識別子) {
        return entity.getChoteiId().equals(new Decimal(調定共通情報識別子.get調定ID()));
    }

    /**
     * {@link Kibetsu}のインスタンスを生成します。
     *
     * @return {@link Kibetsu}のインスタンス
     */
    public Kibetsu build() {
        return new Kibetsu(entity, id, choteiKyotsu);
    }
}
