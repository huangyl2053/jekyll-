/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TsuchishoHakkoJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-010 chenxin
 */
public class TsuchishoHakkoJohoBuilder {

    private final DbT4122TsuchishoHakkoJohoEntity entity;
    private final TsuchishoHakkoJohoIdentifier id;

    /**
     * {@link DbT4122TsuchishoHakkoJohoEntity}より{@link TsuchishoHakkoJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4122TsuchishoHakkoJohoEntity}
     * @param id {@link TsuchishoHakkoJohoIdentifier}
     *
     */
    TsuchishoHakkoJohoBuilder(
            DbT4122TsuchishoHakkoJohoEntity entity,
            TsuchishoHakkoJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 通知区分を設定します。
     *
     * @param 通知区分 通知区分
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set通知区分(Code 通知区分) {
        requireNonNull(通知区分, UrSystemErrorMessages.値がnull.getReplacedMessage("通知区分"));
        entity.setTsuchiKubun(通知区分);
        return this;
    }

    /**
     * 通知理由を設定します。
     *
     * @param 通知理由 通知理由
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set通知理由(RString 通知理由) {
        requireNonNull(通知理由, UrSystemErrorMessages.値がnull.getReplacedMessage("通知理由"));
        entity.setTsuchiRiyu(通知理由);
        return this;
    }

    /**
     * 通知年月日を設定します。
     *
     * @param 通知年月日 通知年月日
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set通知年月日(FlexibleDate 通知年月日) {
        requireNonNull(通知年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知年月日"));
        entity.setTsuchiYMD(通知年月日);
        return this;
    }

    /**
     * 通知開始年月日を設定します。
     *
     * @param 通知開始年月日 通知開始年月日
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set通知開始年月日(FlexibleDate 通知開始年月日) {
        requireNonNull(通知開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知開始年月日"));
        entity.setTsuchiKaishiYMD(通知開始年月日);
        return this;
    }

    /**
     * 通知終了年月日を設定します。
     *
     * @param 通知終了年月日 通知終了年月日
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set通知終了年月日(FlexibleDate 通知終了年月日) {
        requireNonNull(通知終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知終了年月日"));
        entity.setTsuchiShuryoYMD(通知終了年月日);
        return this;
    }

    /**
     * 通知区分期限を設定します。
     *
     * @param 通知区分期限 通知区分期限
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set通知区分期限(FlexibleDate 通知区分期限) {
        requireNonNull(通知区分期限, UrSystemErrorMessages.値がnull.getReplacedMessage("通知区分期限"));
        entity.setTsuchiKubunKigenYMD(通知区分期限);
        return this;
    }

    /**
     * 通知完了年月日を設定します。
     *
     * @param 通知完了年月日 通知完了年月日
     * @return {@link TsuchishoHakkoJohoBuilder}
     */
    public TsuchishoHakkoJohoBuilder set通知完了年月日(FlexibleDate 通知完了年月日) {
        requireNonNull(通知完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知完了年月日"));
        entity.setTsuchiKanryoYMD(通知完了年月日);
        return this;
    }

    /**
     * {@link TsuchishoHakkoJoho}のインスタンスを生成します。
     *
     * @return {@link TsuchishoHakkoJoho}のインスタンス
     */
    public TsuchishoHakkoJoho build() {
        return new TsuchishoHakkoJoho(entity, id);
    }
}
