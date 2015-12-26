/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * {@link FukaSearchAlive}の編集を行うビルダークラスです。
 */
public class FukaSearchAliveBuilder {

    private final DbV7902FukaSearchEntity entity;
    private final FukaSearchAliveIdentifier id;

    /**
     * {@link DbV7902FukaSearchEntity}より{@link FukaSearchAlive}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV7902FukaSearchEntity}
     * @param id {@link FukaSearchAliveIdentifier}
     *
     */
    FukaSearchAliveBuilder(
            DbV7902FukaSearchEntity entity,
            FukaSearchAliveIdentifier id
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
     * @return {@link FukaSearchAliveBuilder}
     */
    public FukaSearchAliveBuilder set調定年度(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度);
        return this;
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     * @return {@link FukaSearchAliveBuilder}
     */
    public FukaSearchAliveBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     * @return {@link FukaSearchAliveBuilder}
     */
    public FukaSearchAliveBuilder set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link FukaSearchAliveBuilder}
     */
    public FukaSearchAliveBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link FukaSearchAliveBuilder}
     */
    public FukaSearchAliveBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 被保台帳被保険者番号を設定します。
     *
     * @param 被保台帳被保険者番号 被保台帳被保険者番号
     * @return {@link FukaSearchAliveBuilder}
     */
    public FukaSearchAliveBuilder set被保台帳被保険者番号(HihokenshaNo 被保台帳被保険者番号) {
        requireNonNull(被保台帳被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保台帳被保険者番号"));
        entity.setHihodaichoHihokenshaNo(被保台帳被保険者番号);
        return this;
    }

    /**
     * {@link FukaSearchAlive}のインスタンスを生成します。
     *
     * @return {@link FukaSearchAlive}のインスタンス
     */
    public FukaSearchAlive build() {
        return new FukaSearchAlive(entity, id);
    }
}
