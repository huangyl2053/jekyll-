/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShujiiIkenshoHoshuJissekiJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 xuyannan
 */
public class ShujiiIkenshoHoshuJissekiJohoBuilder {

    private final DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity;
    private final ShujiiIkenshoHoshuJissekiJohoIdentifier id;

    /**
     * {@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}より{@link ShujiiIkenshoHoshuJissekiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}
     * @param id {@link ShujiiIkenshoHoshuJissekiJohoIdentifier}
     *
     */
    ShujiiIkenshoHoshuJissekiJohoBuilder(
            DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity,
            ShujiiIkenshoHoshuJissekiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 主治医医療機関コードを設定します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医医療機関コード(RString 主治医医療機関コード) {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        entity.setShujiiIryoKikanCode(主治医医療機関コード);
        return this;
    }

    /**
     * 主治医コードを設定します。
     *
     * @param 主治医コード 主治医コード
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医コード(RString 主治医コード) {
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        entity.setShujiiCode(主治医コード);
        return this;
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 主治医意見書作成依頼履歴番号を設定します。
     *
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書作成依頼履歴番号(int 主治医意見書作成依頼履歴番号) {
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        return this;
    }

    /**
     * 主治医意見書作成依頼年月日を設定します。
     *
     * @param 主治医意見書作成依頼年月日 主治医意見書作成依頼年月日
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書作成依頼年月日(FlexibleDate 主治医意見書作成依頼年月日) {
        requireNonNull(主治医意見書作成依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼年月日"));
        entity.setIraishoSakuseiIraiYMD(主治医意見書作成依頼年月日);
        return this;
    }

    /**
     * 主治医意見書記入年月日を設定します。
     *
     * @param 主治医意見書記入年月日 主治医意見書記入年月日
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書記入年月日(FlexibleDate 主治医意見書記入年月日) {
        requireNonNull(主治医意見書記入年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書記入年月日"));
        entity.setIkenshoKinyuYMD(主治医意見書記入年月日);
        return this;
    }

    /**
     * 主治医意見書受領年月日を設定します。
     *
     * @param 主治医意見書受領年月日 主治医意見書受領年月日
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書受領年月日(FlexibleDate 主治医意見書受領年月日) {
        requireNonNull(主治医意見書受領年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書受領年月日"));
        entity.setIkenshoJuryoYMD(主治医意見書受領年月日);
        return this;
    }

    /**
     * 医師区分コードを設定します。
     *
     * @param 医師区分コード 医師区分コード
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set医師区分コード(Code 医師区分コード) {
        requireNonNull(医師区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医師区分コード"));
        entity.setIshiKubunCode(医師区分コード);
        return this;
    }

    /**
     * 主治医意見書作成料を設定します。
     *
     * @param 主治医意見書作成料 主治医意見書作成料
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書作成料(int 主治医意見書作成料) {
        requireNonNull(主治医意見書作成料, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成料"));
        entity.setIkenshoSakuseiryo(主治医意見書作成料);
        return this;
    }

    /**
     * 主治医意見書別途診療費を設定します。
     *
     * @param 主治医意見書別途診療費 主治医意見書別途診療費
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書別途診療費(int 主治医意見書別途診療費) {
        requireNonNull(主治医意見書別途診療費, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書別途診療費"));
        entity.setIkenshoBettoShinryohi(主治医意見書別途診療費);
        return this;
    }

    /**
     * 主治医意見書報酬を設定します。
     *
     * @param 主治医意見書報酬 主治医意見書報酬
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書報酬(int 主治医意見書報酬) {
        requireNonNull(主治医意見書報酬, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書報酬"));
        entity.setIkenshoHoshu(主治医意見書報酬);
        return this;
    }

    /**
     * 主治医意見書報酬支払年月日を設定します。
     *
     * @param 主治医意見書報酬支払年月日 主治医意見書報酬支払年月日
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書報酬支払年月日(FlexibleDate 主治医意見書報酬支払年月日) {
        requireNonNull(主治医意見書報酬支払年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書報酬支払年月日"));
        entity.setHoshuShiharaiYMD(主治医意見書報酬支払年月日);
        return this;
    }

    /**
     * 主治医意見書報酬支払メモを設定します。
     *
     * @param 主治医意見書報酬支払メモ 主治医意見書報酬支払メモ
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set主治医意見書報酬支払メモ(RString 主治医意見書報酬支払メモ) {
        requireNonNull(主治医意見書報酬支払メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書報酬支払メモ"));
        entity.setHoshuShiharaiMemo(主治医意見書報酬支払メモ);
        return this;
    }

    /**
     * 銀行振込出力フラグを設定します。
     *
     * @param 銀行振込出力フラグ 銀行振込出力フラグ
     * @return {@link ShujiiIkenshoHoshuJissekiJohoBuilder}
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder set銀行振込出力フラグ(boolean 銀行振込出力フラグ) {
        requireNonNull(銀行振込出力フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("銀行振込出力フラグ"));
        entity.setGinkoFurikomiShutsuryokuFlag(銀行振込出力フラグ);
        return this;
    }

    /**
     * {@link ShujiiIkenshoHoshuJissekiJoho}のインスタンスを生成します。
     *
     * @return {@link ShujiiIkenshoHoshuJissekiJoho}のインスタンス
     */
    public ShujiiIkenshoHoshuJissekiJoho build() {
        return new ShujiiIkenshoHoshuJissekiJoho(entity, id);
    }
}
