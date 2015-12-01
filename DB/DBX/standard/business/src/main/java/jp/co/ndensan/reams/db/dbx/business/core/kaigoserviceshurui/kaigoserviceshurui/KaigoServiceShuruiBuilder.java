/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link KaigoServiceShurui}の編集を行うビルダークラスです。
 */
public class KaigoServiceShuruiBuilder {

    private final DbT7130KaigoServiceShuruiEntity entity;
    private final KaigoServiceShuruiIdentifier id;

    private final Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyou;

    /**
     * {@link DbT7130KaigoServiceShuruiEntity}より{@link KaigoServiceShurui}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7130KaigoServiceShuruiEntity}
     * @param id {@link KaigoServiceShuruiIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    KaigoServiceShuruiBuilder(
            DbT7130KaigoServiceShuruiEntity entity,
            KaigoServiceShuruiIdentifier id,
            Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyou
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.kaigoServiceNaiyou = kaigoServiceNaiyou.clone();

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
    public KaigoServiceShuruiBuilder setサービス分類コード(KaigoServiceBunruiCode サービス分類コード) {
        requireNonNull(サービス分類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス分類コード"));
        entity.setServiceBunrruicode(サービス分類コード);
        return this;
    }

    /**
     * 介護サービス内容のキー情報について判定します。<br>
     * 介護サービスに関連できる介護サービス内容である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護サービス内容リストに介護サービス内容{@link KaigoServiceNaiyou}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護サービス内容 {@link KaigoServiceShurui}
     * @return {@link KaigoServiceShuruiBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public KaigoServiceShuruiBuilder setKaigoServiceNaiyou(KaigoServiceNaiyou 介護サービス内容) {
        if (hasSameIdentifier(介護サービス内容.identifier())) {
            kaigoServiceNaiyou.add(介護サービス内容);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KaigoServiceNaiyouIdentifier 介護サービス内容の識別子) {
//        return (id.getサービス種類コード().equals(介護サービス内容の識別子.getサービス種類コード())
//                && id.get提供開始年月().equals(介護サービス内容の識別子.get提供開始年月()));
        return id.get提供開始年月().equals(介護サービス内容の識別子.get提供開始年月());
    }

    /**
     * {@link KaigoServiceShurui}のインスタンスを生成します。
     *
     * @return {@link KaigoServiceShurui}のインスタンス
     */
    public KaigoServiceShurui build() {
        return new KaigoServiceShurui(entity, id, kaigoServiceNaiyou);
    }
}
