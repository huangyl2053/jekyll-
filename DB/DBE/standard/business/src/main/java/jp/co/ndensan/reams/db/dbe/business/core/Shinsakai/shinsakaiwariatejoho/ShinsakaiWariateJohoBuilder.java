/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ShinsakaiWariateJoho}の編集を行うビルダークラスです。
 */
public class ShinsakaiWariateJohoBuilder {

    private final DbT5502ShinsakaiWariateJohoEntity entity;
    private final ShinsakaiWariateJohoIdentifier id;
    private final Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho;

    /**
     * {@link DbT5502ShinsakaiWariateJohoEntity}より{@link ShinsakaiWariateJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5502ShinsakaiWariateJohoEntity}
     * @param id {@link ShinsakaiWariateJohoIdentifier}
     *
     */
    ShinsakaiWariateJohoBuilder(
            DbT5502ShinsakaiWariateJohoEntity entity,
            ShinsakaiWariateJohoIdentifier id,
            Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.ninteiShinseiJoho = ninteiShinseiJoho.clone();
    }

    /**
     * 介護認定審査会開催年月日を設定します。
     *
     * @param 介護認定審査会開催年月日 介護認定審査会開催年月日
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set介護認定審査会開催年月日(FlexibleDate 介護認定審査会開催年月日) {
        requireNonNull(介護認定審査会開催年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催年月日"));
        entity.setShinsakaiKaisaiYMD(介護認定審査会開催年月日);
        return this;
    }

    /**
     * 介護認定審査会割当年月日を設定します。
     *
     * @param 介護認定審査会割当年月日 介護認定審査会割当年月日
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set介護認定審査会割当年月日(FlexibleDate 介護認定審査会割当年月日) {
        requireNonNull(介護認定審査会割当年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当年月日"));
        entity.setShinsakaiWariateYMD(介護認定審査会割当年月日);
        return this;
    }

    /**
     * 介護認定審査会審査順を設定します。
     *
     * @param 介護認定審査会審査順 介護認定審査会審査順
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set介護認定審査会審査順(int 介護認定審査会審査順) {
        requireNonNull(介護認定審査会審査順, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順"));
        entity.setShinsakaiOrder(介護認定審査会審査順);
        return this;
    }

    /**
     * 介護認定審査会審査順確定フラグを設定します。
     *
     * @param 介護認定審査会審査順確定フラグ 介護認定審査会審査順確定フラグ
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set介護認定審査会審査順確定フラグ(boolean 介護認定審査会審査順確定フラグ) {
        requireNonNull(介護認定審査会審査順確定フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順確定フラグ"));
        entity.setShinsakaiOrderKakuteiFlag(介護認定審査会審査順確定フラグ);
        return this;
    }

    /**
     * 審査会自動割付フラグを設定します。
     *
     * @param 審査会自動割付フラグ 審査会自動割付フラグ
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set審査会自動割付フラグ(boolean 審査会自動割付フラグ) {
        requireNonNull(審査会自動割付フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会自動割付フラグ"));
        entity.setShinsakaiJidoWaritsukeFlag(審査会自動割付フラグ);
        return this;
    }

    /**
     * 審査会資料作成年月日を設定します。
     *
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set審査会資料作成年月日(FlexibleDate 審査会資料作成年月日) {
        requireNonNull(審査会資料作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会資料作成年月日"));
        entity.setShinsakaiShiryoSakuseiYMD(審査会資料作成年月日);
        return this;
    }

    /**
     * 審査会資料送付年月日を設定します。
     *
     * @param 審査会資料送付年月日 審査会資料送付年月日
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set審査会資料送付年月日(FlexibleDate 審査会資料送付年月日) {
        requireNonNull(審査会資料送付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会資料送付年月日"));
        entity.setShinsakaiShiryoSofuYMD(審査会資料送付年月日);
        return this;
    }

    /**
     * 判定結果コードを設定します。
     *
     * @param 判定結果コード 判定結果コード
     * @return {@link ShinsakaiWariateJohoBuilder}
     */
    public ShinsakaiWariateJohoBuilder set判定結果コード(Code 判定結果コード) {
        requireNonNull(判定結果コード, UrSystemErrorMessages.値がnull.getReplacedMessage("判定結果コード"));
        entity.setHanteiKekkaCode(判定結果コード);
        return this;
    }

    /**
     * 要介護認定申請情報のキー情報について判定します。<br>
     * 介護認定審査会割当情報に関連できる要介護認定申請情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は要介護認定申請情報リストに要介護認定申請情報{@link NinteiShinseiJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 要介護認定申請情報 {@link NinteiShinseiJoho}
     * @return {@link NinteiShinseiJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShinsakaiWariateJohoBuilder setNinteiShinseiJoho(NinteiShinseiJoho 要介護認定申請情報) {
        if (hasSameIdentifier(要介護認定申請情報.identifier())) {
            ninteiShinseiJoho.add(要介護認定申請情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteiShinseiJohoIdentifier 要介護認定申請情報識別子) {
        return (id.get申請書管理番号().equals(要介護認定申請情報識別子.get申請書管理番号()));
    }

    /**
     * {@link ShinsakaiWariateJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiWariateJoho}のインスタンス
     */
    public ShinsakaiWariateJoho build() {
        return new ShinsakaiWariateJoho(entity, id, ninteiShinseiJoho);
    }
}
