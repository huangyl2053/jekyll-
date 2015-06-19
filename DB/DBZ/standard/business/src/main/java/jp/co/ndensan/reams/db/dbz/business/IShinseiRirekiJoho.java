/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.entity.basic.IShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村マスタ情報（ビジネス）を扱うインタフェースです。
 *
 * @author n8223　朴義一
 */
public interface IShinseiRirekiJoho {

    /**
     * 申請履歴情報エンティティの情報を返します。
     *
     * @return 申請履歴情報エンティティの情報
     */
    IShinseiRirekiJohoEntity getEntity();

    /**
     * 申請管理番号を返します。
     *
     * @return 申請管理番号
     */
    ShinseishoKanriNo get申請管理番号();

    /**
     * 前回申請管理番号を返します。
     *
     * @return 前回申請管理番号
     */
    ShinseishoKanriNo get前回申請管理番号();

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    EntityDataState getState();

    /**
     * 状態を設定します。
     *
     * @param entityDataState EntityDataState
     */
    void setState(EntityDataState entityDataState);

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    void setDeletedState(boolean deleteFlag);

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    Builder createBuilderForEdit();

    /**
     * {@link HokenshaShinseiRirekiJoho}を生成するためのビルダーです。
     */
    public class Builder {

        /**
         * shinseishoKanriNoを設定します。
         *
         * @param shinseishoKanriNo 申請書管理番号
         * @return builder
         */
        public Builder setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
            return this;
        }

        /**
         * zenkaiShinseishoKanriNoを設定します。
         *
         * @param zenkaiShinseishoKanriNo 前回申請書管理番号
         * @return builder
         */
        public Builder setZenkaiShinseishoKanriNo(ShinseishoKanriNo zenkaiShinseishoKanriNo) {
            return this;
        }

        /**
         * {@link IShinseiRirekiJoho}を生成します。
         *
         * @return {@link IShinseiRirekiJoho}
         */
        public IShinseiRirekiJoho build() {
            return new IShinseiRirekiJoho.Builder().build();
        }
    };

}
