/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoServiceShurui}の編集を行うビルダークラスです。
 */
public class KaigoServiceShuruiBuilder {

    private final DbT7130KaigoServiceShuruiEntity entity;
    private final KaigoServiceShuruiIdentifier id;

    /**
     * {@link DbT7130KaigoServiceShuruiEntity}より{@link KaigoServiceShurui}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7130KaigoServiceShuruiEntity}
     * @param id {@link KaigoServiceShuruiIdentifier}
     *
     */
    KaigoServiceShuruiBuilder(
            DbT7130KaigoServiceShuruiEntity entity,
            KaigoServiceShuruiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KaigoServiceShuruiBuilder}
     */
    public KaigoServiceShuruiBuilder setサービス種類コード(KaigoServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCd(サービス種類コード);
        return this;
    }

    /**
     * 提供開始年月を設定します。
     *
     * @param 提供開始年月 提供開始年月
     * @return {@link KaigoServiceShuruiBuilder}
     */
    public KaigoServiceShuruiBuilder set提供開始年月(FlexibleYearMonth 提供開始年月) {
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        entity.setTeikyoKaishiYM(提供開始年月);
        return this;
    }

    /**
     * 提供終了年月を設定します。
     *
     * @param 提供終了年月 提供終了年月
     * @return {@link KaigoServiceShuruiBuilder}
     */
    public KaigoServiceShuruiBuilder set提供終了年月(FlexibleYearMonth 提供終了年月) {
        requireNonNull(提供終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供終了年月"));
        entity.setTeikyoshuryoYM(提供終了年月);
        return this;
    }

    /**
     * サービス種類名称を設定します。
     *
     * @param サービス種類名称 サービス種類名称
     * @return {@link KaigoServiceShuruiBuilder}
     */
    public KaigoServiceShuruiBuilder setサービス種類名称(RString サービス種類名称) {
        requireNonNull(サービス種類名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類名称"));
        entity.setServiceShuruiMeisho(サービス種類名称);
        return this;
    }

    /**
     * サービス種類略称を設定します。
     *
     * @param サービス種類略称 サービス種類略称
     * @return {@link KaigoServiceShuruiBuilder}
     */
    public KaigoServiceShuruiBuilder setサービス種類略称(RString サービス種類略称) {
        requireNonNull(サービス種類略称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類略称"));
        entity.setServiceShuruiRyakusho(サービス種類略称);
        return this;
    }

    /**
     * サービス分類コードを設定します。
     *
     * @param サービス分類コード サービス分類コード
     * @return {@link KaigoServiceShuruiBuilder}
     */
    public KaigoServiceShuruiBuilder setサービス分類コード(Code サービス分類コード) {
        requireNonNull(サービス分類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス分類コード"));
        entity.setServiceBunrruicode(new KaigoServiceBunruiCode(サービス分類コード));
        return this;
    }

    /**
     * {@link KaigoServiceShurui}のインスタンスを生成します。
     *
     * @return {@link KaigoServiceShurui}のインスタンス
     */
    public KaigoServiceShurui build() {
        return new KaigoServiceShurui(entity, id);
    }

    public KaigoServiceShuruiBuilder setKaigoServiceNaiyou(KaigoServiceNaiyou createKaigoServiceNaiyou) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
