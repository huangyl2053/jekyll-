/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link NijiYoboNiniCheckList}の編集を行うビルダークラスです。
 */
public class NijiYoboNiniCheckListBuilder {

    private final DbT3102NijiYoboNiniCheckListEntity entity;
    private final NijiYoboNiniCheckListIdentifier id;

    /**
     * {@link DbT3102NijiYoboNiniCheckListEntity}より{@link NijiYoboNiniCheckList}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3102NijiYoboNiniCheckListEntity}
     * @param id {@link NijiYoboNiniCheckListIdentifier}
     *
     */
    NijiYoboNiniCheckListBuilder(
            DbT3102NijiYoboNiniCheckListEntity entity,
            NijiYoboNiniCheckListIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link NijiYoboNiniCheckListBuilder}
     */
    public NijiYoboNiniCheckListBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link NijiYoboNiniCheckListBuilder}
     */
    public NijiYoboNiniCheckListBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 任意質問番号を設定します。
     *
     * @param 任意質問番号 任意質問番号
     * @return {@link NijiYoboNiniCheckListBuilder}
     */
    public NijiYoboNiniCheckListBuilder set任意質問番号(int 任意質問番号) {
        requireNonNull(任意質問番号, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問番号"));
        entity.setNiniShitsumonNo(任意質問番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link NijiYoboNiniCheckListBuilder}
     */
    public NijiYoboNiniCheckListBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 任意質問事項を設定します。
     *
     * @param 任意質問事項 任意質問事項
     * @return {@link NijiYoboNiniCheckListBuilder}
     */
    public NijiYoboNiniCheckListBuilder set任意質問事項(int 任意質問事項) {
        requireNonNull(任意質問事項, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問事項"));
        entity.setNiniShitsumonJiko(任意質問事項);
        return this;
    }

    /**
     * {@link NijiYoboNiniCheckList}のインスタンスを生成します。
     *
     * @return {@link NijiYoboNiniCheckList}のインスタンス
     */
    public NijiYoboNiniCheckList build() {
        return new NijiYoboNiniCheckList(entity, id);
    }
}
