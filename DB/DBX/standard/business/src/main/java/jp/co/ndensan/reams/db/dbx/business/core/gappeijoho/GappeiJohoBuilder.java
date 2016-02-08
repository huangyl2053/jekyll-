/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.gappeijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichosonBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichosonIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link GappeiJoho}の編集を行うビルダークラスです。
 */
public class GappeiJohoBuilder {

    private final DbT7055GappeiJohoEntity entity;
    private final GappeiJohoIdentifier id;
    private final Models<GappeiShichosonIdentifier, GappeiShichoson> gappeiShichoson;

    /**
     * {@link DbT7055GappeiJohoEntity}より{@link GappeiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7055GappeiJohoEntity}
     * @param id {@link GappeiJohoIdentifier}
     * @param gappeiShichoson {@link Models<GappeiShichosonIdentifier, GappeiShichoson>}
     *
     */
    GappeiJohoBuilder(
            DbT7055GappeiJohoEntity entity,
            GappeiJohoIdentifier id,
            Models<GappeiShichosonIdentifier, GappeiShichoson> gappeiShichoson
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.gappeiShichoson = gappeiShichoson.clone();

    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link GappeiJohoBuilder}
     */
    public GappeiJohoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 合併種類を設定します。
     *
     * @param 合併種類 合併種類
     * @return {@link GappeiJohoBuilder}
     */
    public GappeiJohoBuilder set合併種類(RString 合併種類) {
        requireNonNull(合併種類, UrSystemErrorMessages.値がnull.getReplacedMessage("合併種類"));
        entity.setGappeiShurui(合併種類);
        return this;
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     * @return {@link GappeiJohoBuilder}
     */
    public GappeiJohoBuilder set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
        return this;
    }

    /**
     * 旧市町村情報付与終了年月日を設定します。
     *
     * @param 旧市町村情報付与終了年月日 旧市町村情報付与終了年月日
     * @return {@link GappeiJohoBuilder}
     */
    public GappeiJohoBuilder set旧市町村情報付与終了年月日(FlexibleDate 旧市町村情報付与終了年月日) {
        requireNonNull(旧市町村情報付与終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村情報付与終了年月日"));
        entity.setKyuJohoFuyoToYMD(旧市町村情報付与終了年月日);
        return this;
    }

    /**
     * 国保連データ連携開始年月日を設定します。
     *
     * @param 国保連データ連携開始年月日 国保連データ連携開始年月日
     * @return {@link GappeiJohoBuilder}
     */
    public GappeiJohoBuilder set国保連データ連携開始年月日(FlexibleDate 国保連データ連携開始年月日) {
        requireNonNull(国保連データ連携開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連データ連携開始年月日"));
        entity.setKokuhorenDataFromYMD(国保連データ連携開始年月日);
        return this;
    }

    /**
     * {@link GappeiJoho}のインスタンスを生成します。
     *
     * @return {@link GappeiJoho}のインスタンス
     */
    public GappeiJoho build() {
        return new GappeiJoho(entity, id, gappeiShichoson);
    }

    /**
     * 合併市町村情報のキー情報について判定します。<br>
     * 合併市町村に関連できる合併市町村情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は合併市町村情報リストに合併市町村情報{@link GappeiShichoson}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 合併市町村情報 {@link GappeiShichoson}
     * @return {@link GappeiShichosonBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public GappeiJohoBuilder setGappeiShichoson(GappeiShichoson 合併市町村) {

        if (hasSameIdentifier(合併市町村.identifier())) {
            gappeiShichoson.add(合併市町村);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(GappeiShichosonIdentifier 合併市町村識別子) {
        return (id.get合併年月日().equals(合併市町村識別子.get合併年月日())
                && id.get地域番号().equals(合併市町村識別子.get地域番号()));
    }
}
