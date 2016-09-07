/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiJizenKekkaJoho}の編集を行うビルダークラスです。
 */
public class ShinsakaiJizenKekkaJohoBuilder {

    private final DbT5508ShinsakaiJizenKekkaJohoEntity entity;
    private final ShinsakaiJizenKekkaJohoIdentifier id;

    /**
     * {@link DbT5508ShinsakaiJizenKekkaJohoEntity}より{@link ShinsakaiJizenKekkaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5508ShinsakaiJizenKekkaJohoEntity}
     * @param id {@link ShinsakaiJizenKekkaJohoIdentifier}
     *
     */
    ShinsakaiJizenKekkaJohoBuilder(
            DbT5508ShinsakaiJizenKekkaJohoEntity entity,
            ShinsakaiJizenKekkaJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 介護認定審査会開催番号を設定します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return {@link ShinsakaiJizenKekkaJohoBuilder}
     */
    public ShinsakaiJizenKekkaJohoBuilder set介護認定審査会開催番号(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        return this;
    }

    /**
     * 介護認定審査会委員コードを設定します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return {@link ShinsakaiJizenKekkaJohoBuilder}
     */
    public ShinsakaiJizenKekkaJohoBuilder set介護認定審査会委員コード(RString 介護認定審査会委員コード) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        entity.setShinsakaiIinCode(介護認定審査会委員コード);
        return this;
    }

    /**
     * 介護認定審査会審査順を設定します。
     *
     * @param 介護認定審査会審査順 介護認定審査会審査順
     * @return {@link ShinsakaiJizenKekkaJohoBuilder}
     */
    public ShinsakaiJizenKekkaJohoBuilder set介護認定審査会審査順(int 介護認定審査会審査順) {
        requireNonNull(介護認定審査会審査順, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順"));
        entity.setShinsakaiOrder(介護認定審査会審査順);
        return this;
    }

    /**
     * 有効期間を設定します。
     *
     * @param 有効期間 有効期間
     * @return {@link ShinsakaiJizenKekkaJohoBuilder}
     */
    public ShinsakaiJizenKekkaJohoBuilder set有効期間(int 有効期間) {
        requireNonNull(有効期間, UrSystemErrorMessages.値がnull.getReplacedMessage("有効期間"));
        entity.setYukokikan(有効期間);
        return this;
    }

    /**
     * 二次判定結果コードを設定します。
     *
     * @param 二次判定結果コード 二次判定結果コード
     * @return {@link ShinsakaiJizenKekkaJohoBuilder}
     */
    public ShinsakaiJizenKekkaJohoBuilder set二次判定結果コード(Code 二次判定結果コード) {
        requireNonNull(二次判定結果コード, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定結果コード"));
        entity.setNijiHanteiKekkaCode(二次判定結果コード);
        return this;
    }

    /**
     * {@link ShinsakaiJizenKekkaJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiJizenKekkaJoho}のインスタンス
     */
    public ShinsakaiJizenKekkaJoho build() {
        return new ShinsakaiJizenKekkaJoho(entity, id);
    }
}
