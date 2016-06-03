/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2016FukinitsuNokiKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link FukinitsuNokiKanri}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-012 cuilin
 */
public class FukinitsuNokiKanriBuilder {

    private final DbT2016FukinitsuNokiKanriEntity entity;
    private final FukinitsuNokiKanriIdentifier id;
    private static final RString 調定年度メッセージ = new RString("調定年度");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");

    /**
     * {@link DbT2016FukinitsuNokiKanriEntity}より{@link FukinitsuNokiKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2016FukinitsuNokiKanriEntity}
     * @param id {@link FukinitsuNokiKanriIdentifier}
     *
     */
    FukinitsuNokiKanriBuilder(
            DbT2016FukinitsuNokiKanriEntity entity,
            FukinitsuNokiKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     * @return {@link FukinitsuNokiKanriBuilder}
     */
    public FukinitsuNokiKanriBuilder set調定年度(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度メッセージ.toString()));
        entity.setChoteiNendo(調定年度);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link FukinitsuNokiKanriBuilder}
     */
    public FukinitsuNokiKanriBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * {@link FukinitsuNokiKanri}のインスタンスを生成します。
     *
     * @return {@link FukinitsuNokiKanri}のインスタンス
     */
    public FukinitsuNokiKanri build() {
        return new FukinitsuNokiKanri(entity, id);
    }
}
