/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShujiiIkenshoIraiJoho}の編集を行うビルダークラスです。
 */
public class ShujiiIkenshoIraiJohoBuilder {

    private final DbT5301ShujiiIkenshoIraiJohoEntity entity;
    private final ShujiiIkenshoIraiJohoIdentifier id;

    /**
     * {@link DbT5301ShujiiIkenshoIraiJohoEntity}より{@link ShujiiIkenshoIraiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5301ShujiiIkenshoIraiJohoEntity}
     * @param id {@link ShujiiIkenshoIraiJohoIdentifier}
     *
     */
    ShujiiIkenshoIraiJohoBuilder(
            DbT5301ShujiiIkenshoIraiJohoEntity entity,
            ShujiiIkenshoIraiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }


    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 主治医医療機関コードを設定します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医医療機関コード(RString 主治医医療機関コード) {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        entity.setShujiiIryokikanCode(主治医医療機関コード);
        return this;
    }

    /**
     * 主治医コードを設定します。
     *
     * @param 主治医コード 主治医コード
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医コード(RString 主治医コード) {
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        entity.setShujiiCode(主治医コード);
        return this;
    }

    /**
     * 主治医意見書依頼区分を設定します。
     *
     * @param 主治医意見書依頼区分 主治医意見書依頼区分
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書依頼区分(RString 主治医意見書依頼区分) {
        requireNonNull(主治医意見書依頼区分, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書依頼区分"));
        entity.setIkenshoIraiKubun(主治医意見書依頼区分);
        return this;
    }

    /**
     * 主治医意見書作成回数を設定します。
     *
     * @param 主治医意見書作成回数 主治医意見書作成回数
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書作成回数(int 主治医意見書作成回数) {
        requireNonNull(主治医意見書作成回数, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成回数"));
        entity.setIkenshoIraiKaisu(主治医意見書作成回数);
        return this;
    }

    /**
     * 医師区分コードを設定します。
     *
     * @param 医師区分コード 医師区分コード
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set医師区分コード(Code 医師区分コード) {
        requireNonNull(医師区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医師区分コード"));
        entity.setIshiKubunCode(医師区分コード);
        return this;
    }

    /**
     * 主治医意見書作成依頼年月日を設定します。
     *
     * @param 主治医意見書作成依頼年月日 主治医意見書作成依頼年月日
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書作成依頼年月日(FlexibleDate 主治医意見書作成依頼年月日) {
        requireNonNull(主治医意見書作成依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼年月日"));
        entity.setIkenshoSakuseiIraiYMD(主治医意見書作成依頼年月日);
        return this;
    }

    /**
     * 主治医意見書作成期限年月日を設定します。
     *
     * @param 主治医意見書作成期限年月日 主治医意見書作成期限年月日
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書作成期限年月日(FlexibleDate 主治医意見書作成期限年月日) {
        requireNonNull(主治医意見書作成期限年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成期限年月日"));
        entity.setIkenshoSakuseiKigenYMD(主治医意見書作成期限年月日);
        return this;
    }

    /**
     * 依頼書出力年月日を設定します。
     *
     * @param 依頼書出力年月日 依頼書出力年月日
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set依頼書出力年月日(FlexibleDate 依頼書出力年月日) {
        requireNonNull(依頼書出力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("依頼書出力年月日"));
        entity.setIraishoShutsuryokuYMD(依頼書出力年月日);
        return this;
    }

    /**
     * 意見書出力年月日を設定します。
     *
     * @param 意見書出力年月日 意見書出力年月日
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set意見書出力年月日(FlexibleDate 意見書出力年月日) {
        requireNonNull(意見書出力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書出力年月日"));
        entity.setIkenshoShutsuryokuYMD(意見書出力年月日);
        return this;
    }

    /**
     * 請求書出力年月日を設定します。
     *
     * @param 請求書出力年月日 請求書出力年月日
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set請求書出力年月日(FlexibleDate 請求書出力年月日) {
        requireNonNull(請求書出力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("請求書出力年月日"));
        entity.setSeikyushoShutsuryokuYMD(請求書出力年月日);
        return this;
    }

    /**
     * 作成料請求区分を設定します。
     *
     * @param 作成料請求区分 作成料請求区分
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set作成料請求区分(Code 作成料請求区分) {
        requireNonNull(作成料請求区分, UrSystemErrorMessages.値がnull.getReplacedMessage("作成料請求区分"));
        entity.setSakuseiryoSeikyuKubun(作成料請求区分);
        return this;
    }

    /**
     * 主治医意見書作成督促年月日を設定します。
     *
     * @param 主治医意見書作成督促年月日 主治医意見書作成督促年月日
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書作成督促年月日(FlexibleDate 主治医意見書作成督促年月日) {
        requireNonNull(主治医意見書作成督促年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成督促年月日"));
        entity.setIkenshoSakuseiTokusokuYMD(主治医意見書作成督促年月日);
        return this;
    }

    /**
     * 主治医意見書作成督促方法を設定します。
     *
     * @param 主治医意見書作成督促方法 主治医意見書作成督促方法
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書作成督促方法(RString 主治医意見書作成督促方法) {
        requireNonNull(主治医意見書作成督促方法, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成督促方法"));
        entity.setIkenshoSakuseiTokusokuHoho(主治医意見書作成督促方法);
        return this;
    }

    /**
     * 主治医意見書作成督促回数を設定します。
     *
     * @param 主治医意見書作成督促回数 主治医意見書作成督促回数
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書作成督促回数(int 主治医意見書作成督促回数) {
        requireNonNull(主治医意見書作成督促回数, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成督促回数"));
        entity.setIkenshoTokusokuKaisu(主治医意見書作成督促回数);
        return this;
    }

    /**
     * 主治医意見書作成督促メモを設定します。
     *
     * @param 主治医意見書作成督促メモ 主治医意見書作成督促メモ
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set主治医意見書作成督促メモ(RString 主治医意見書作成督促メモ) {
        requireNonNull(主治医意見書作成督促メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成督促メモ"));
        entity.setIkenshoTokusokuMemo(主治医意見書作成督促メモ);
        return this;
    }

    /**
     * 認定情報提供希望フラグを設定します。
     *
     * @param 認定情報提供希望フラグ 認定情報提供希望フラグ
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set認定情報提供希望フラグ(boolean 認定情報提供希望フラグ) {
        requireNonNull(認定情報提供希望フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定情報提供希望フラグ"));
        entity.setNinteiJohoTeikyoKiboFlag(認定情報提供希望フラグ);
        return this;
    }

    /**
     * 認定状況提供年月日を設定します。
     *
     * @param 認定状況提供年月日 認定状況提供年月日
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set認定状況提供年月日(FlexibleDate 認定状況提供年月日) {
        requireNonNull(認定状況提供年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定状況提供年月日"));
        entity.setNinteiJohoTeikyoYMD(認定状況提供年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link ShujiiIkenshoIraiJoho}のインスタンスを生成します。
     *
     * @return {@link ShujiiIkenshoIraiJoho}のインスタンス
     */
    public ShujiiIkenshoIraiJoho build() {
        return new ShujiiIkenshoIraiJoho(entity, id);
    }
}
