/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiKaisaiBashoJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiKaisaiBashoJohoBuilder {

    private final DbT5592ShinsakaiKaisaiBashoJohoEntity entity;
    private final ShinsakaiKaisaiBashoJohoIdentifier id;

    /**
     * {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}より{@link ShinsakaiKaisaiBashoJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}
     * @param id {@link ShinsakaiKaisaiBashoJohoIdentifier}
     *
     */
    ShinsakaiKaisaiBashoJohoBuilder(
            DbT5592ShinsakaiKaisaiBashoJohoEntity entity,
            ShinsakaiKaisaiBashoJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 介護認定審査会開催場所名称を設定します。
     *
     * @param 介護認定審査会開催場所名称 介護認定審査会開催場所名称
     * @return {@link ShinsakaiKaisaiBashoJohoBuilder}
     */
    public ShinsakaiKaisaiBashoJohoBuilder set介護認定審査会開催場所名称(RString 介護認定審査会開催場所名称) {
        requireNonNull(介護認定審査会開催場所名称, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所名称"));
        entity.setShinsakaiKaisaiBashoName(介護認定審査会開催場所名称);
        return this;
    }

    /**
     * 介護認定審査会開催地区コードを設定します。
     *
     * @param 介護認定審査会開催地区コード 介護認定審査会開催地区コード
     * @return {@link ShinsakaiKaisaiBashoJohoBuilder}
     */
    public ShinsakaiKaisaiBashoJohoBuilder set介護認定審査会開催地区コード(Code 介護認定審査会開催地区コード) {
        // requireNonNull(介護認定審査会開催地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催地区コード"));
        entity.setShinsakaiKaisaiChikuCode(介護認定審査会開催地区コード);
        return this;
    }

    /**
     * 介護認定審査会開催場所住所を設定します。
     *
     * @param 介護認定審査会開催場所住所 介護認定審査会開催場所住所
     * @return {@link ShinsakaiKaisaiBashoJohoBuilder}
     */
    public ShinsakaiKaisaiBashoJohoBuilder set介護認定審査会開催場所住所(RString 介護認定審査会開催場所住所) {
        //requireNonNull(介護認定審査会開催場所住所, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所住所"));
        entity.setShinsakaiKaisaiBashoJusho(介護認定審査会開催場所住所);
        return this;
    }

    /**
     * 介護認定審査会開催場所電話番号を設定します。
     *
     * @param 介護認定審査会開催場所電話番号 介護認定審査会開催場所電話番号
     * @return {@link ShinsakaiKaisaiBashoJohoBuilder}
     */
    public ShinsakaiKaisaiBashoJohoBuilder set介護認定審査会開催場所電話番号(TelNo 介護認定審査会開催場所電話番号) {
        //requireNonNull(介護認定審査会開催場所電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所電話番号"));
        entity.setShinsakaiKaisaiBashoTelNo(介護認定審査会開催場所電話番号);
        return this;
    }

    /**
     * 介護認定審査会開催場所状況を設定します。
     *
     * @param 介護認定審査会開催場所状況 介護認定審査会開催場所状況
     * @return {@link ShinsakaiKaisaiBashoJohoBuilder}
     */
    public ShinsakaiKaisaiBashoJohoBuilder set介護認定審査会開催場所状況(boolean 介護認定審査会開催場所状況) {
        requireNonNull(介護認定審査会開催場所状況, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所状況"));
        entity.setShinsakaiKaisaiBashoJokyo(介護認定審査会開催場所状況);
        return this;
    }

    /**
     * {@link ShinsakaiKaisaiBashoJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiKaisaiBashoJoho}のインスタンス
     */
    public ShinsakaiKaisaiBashoJoho build() {
        return new ShinsakaiKaisaiBashoJoho(entity, id);
    }
}
