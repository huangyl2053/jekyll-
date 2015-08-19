/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMasterEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteiSoshinzumiMaster}の編集を行うビルダークラスです。
 */
public class NinteiSoshinzumiMasterBuilder {

    private final DbT5190NinteiSoshinzumiMasterEntity entity;
    private final NinteiSoshinzumiMasterIdentifier id;

    /**
     * {@link DbT5190NinteiSoshinzumiMasterEntity}より{@link NinteiSoshinzumiMaster}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5190NinteiSoshinzumiMasterEntity}
     * @param id {@link NinteiSoshinzumiMasterIdentifier}
     *
     */
    NinteiSoshinzumiMasterBuilder(
            DbT5190NinteiSoshinzumiMasterEntity entity,
            NinteiSoshinzumiMasterIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 同一連番を設定します。
     *
     * @param 同一連番 同一連番
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set同一連番(int 同一連番) {
        requireNonNull(同一連番, UrSystemErrorMessages.値がnull.getReplacedMessage("同一連番"));
        entity.setDoitsuRemban(同一連番);
        return this;
    }

    /**
     * 引き渡しフラグを設定します。
     *
     * @param 引き渡しフラグ 引き渡しフラグ
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set引き渡しフラグ(boolean 引き渡しフラグ) {
        requireNonNull(引き渡しフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("引き渡しフラグ"));
        entity.setIsHikiwatashi(引き渡しフラグ);
        return this;
    }

    /**
     * 引き渡し日時を設定します。
     *
     * @param 引き渡し日時 引き渡し日時
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set引き渡し日時(YMDHM 引き渡し日時) {
        requireNonNull(引き渡し日時, UrSystemErrorMessages.値がnull.getReplacedMessage("引き渡し日時"));
        entity.setHikiwatashiYMDHM(引き渡し日時);
        return this;
    }

    /**
     * 引き渡し解除日時を設定します。
     *
     * @param 引き渡し解除日時 引き渡し解除日時
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set引き渡し解除日時(YMDHM 引き渡し解除日時) {
        requireNonNull(引き渡し解除日時, UrSystemErrorMessages.値がnull.getReplacedMessage("引き渡し解除日時"));
        entity.setHikiwatashiKaijoYMDHM(引き渡し解除日時);
        return this;
    }

    /**
     * 引き渡しカウントを設定します。
     *
     * @param 引き渡しカウント 引き渡しカウント
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set引き渡しカウント(int 引き渡しカウント) {
        requireNonNull(引き渡しカウント, UrSystemErrorMessages.値がnull.getReplacedMessage("引き渡しカウント"));
        entity.setHikiwatashiCount(引き渡しカウント);
        return this;
    }

    /**
     * 取り込み日時を設定します。
     *
     * @param 取り込み日時 取り込み日時
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set取り込み日時(YMDHM 取り込み日時) {
        requireNonNull(取り込み日時, UrSystemErrorMessages.値がnull.getReplacedMessage("取り込み日時"));
        entity.setTorikomiYMDHM(取り込み日時);
        return this;
    }

    /**
     * 再送付区分を設定します。
     *
     * @param 再送付区分 再送付区分
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set再送付区分(RString 再送付区分) {
        requireNonNull(再送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再送付区分"));
        entity.setSaiSofuKubun(再送付区分);
        return this;
    }

    /**
     * 再調査送付区分を設定します。
     *
     * @param 再調査送付区分 再調査送付区分
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set再調査送付区分(RString 再調査送付区分) {
        requireNonNull(再調査送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再調査送付区分"));
        entity.setSaiChosaSofuKubun(再調査送付区分);
        return this;
    }

    /**
     * 再意見書送付区分を設定します。
     *
     * @param 再意見書送付区分 再意見書送付区分
     * @return {@link NinteiSoshinzumiMasterBuilder}
     */
    public NinteiSoshinzumiMasterBuilder set再意見書送付区分(RString 再意見書送付区分) {
        requireNonNull(再意見書送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再意見書送付区分"));
        entity.setSaiIkenshoSofuKubun(再意見書送付区分);
        return this;
    }

    /**
     * {@link NinteiSoshinzumiMaster}のインスタンスを生成します。
     *
     * @return {@link NinteiSoshinzumiMaster}のインスタンス
     */
    public NinteiSoshinzumiMaster build() {
        return new NinteiSoshinzumiMaster(entity, id);
    }
}
