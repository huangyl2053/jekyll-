/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link IchijiHanteiKekkaJoho}の編集を行うビルダークラスです。
 */
public class IchijiHanteiKekkaJohoBuilder {

    private final DbT4116IchijiHanteiKekkaJohoEntity entity;
    private final IchijiHanteiKekkaJohoIdentifier id;

    /**
     * {@link DbT4116IchijiHanteiKekkaJohoEntity}より{@link IchijiHanteiKekkaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4116IchijiHanteiKekkaJohoEntity}
     * @param id {@link IchijiHanteiKekkaJohoIdentifier}
     *
     */
    IchijiHanteiKekkaJohoBuilder(
            DbT4116IchijiHanteiKekkaJohoEntity entity,
            IchijiHanteiKekkaJohoIdentifier id
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
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 仮一次判定区分を設定します。
     *
     * @param 仮一次判定区分 仮一次判定区分
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set仮一次判定区分(boolean 仮一次判定区分) {
        requireNonNull(仮一次判定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("仮一次判定区分"));
        entity.setKariIchijiHanteiKubun(仮一次判定区分);
        return this;
    }

    /**
     * 要介護認定一次判定年月日を設定します。
     *
     * @param 要介護認定一次判定年月日 要介護認定一次判定年月日
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定一次判定年月日(FlexibleDate 要介護認定一次判定年月日) {
        requireNonNull(要介護認定一次判定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定年月日"));
        entity.setIchijiHanteiYMD(要介護認定一次判定年月日);
        return this;
    }

    /**
     * 要介護認定一次判定結果コードを設定します。
     *
     * @param 要介護認定一次判定結果コード 要介護認定一次判定結果コード
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定一次判定結果コード(Code 要介護認定一次判定結果コード) {
        requireNonNull(要介護認定一次判定結果コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定結果コード"));
        entity.setIchijiHanteiKekkaCode(要介護認定一次判定結果コード);
        return this;
    }

    /**
     * 要介護認定一次判定結果コード_認知症加算を設定します。
     *
     * @param 要介護認定一次判定結果コード_認知症加算 要介護認定一次判定結果コード_認知症加算
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定一次判定結果コード_認知症加算(Code 要介護認定一次判定結果コード_認知症加算) {
        requireNonNull(要介護認定一次判定結果コード_認知症加算, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定結果コード_認知症加算"));
        entity.setIchijiHanteiKekkaNinchishoKasanCode(要介護認定一次判定結果コード_認知症加算);
        return this;
    }

    /**
     * {@link IchijiHanteiKekkaJoho}のインスタンスを生成します。
     *
     * @return {@link IchijiHanteiKekkaJoho}のインスタンス
     */
    public IchijiHanteiKekkaJoho build() {
        return new IchijiHanteiKekkaJoho(entity, id);
    }
}
