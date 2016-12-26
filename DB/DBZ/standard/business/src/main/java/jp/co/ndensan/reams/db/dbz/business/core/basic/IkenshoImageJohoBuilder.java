/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link IkenshoImageJoho}の編集を行うビルダークラスです。
 */
public class IkenshoImageJohoBuilder {

    private final DbT5305IkenshoImageJohoEntity entity;
    private final IkenshoImageJohoIdentifier id;

    /**
     * {@link DbT5305IkenshoImageJohoEntity}より{@link IkenshoImageJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5305IkenshoImageJohoEntity}
     * @param id {@link IkenshoImageJohoIdentifier}
     *
     */
    IkenshoImageJohoBuilder(
            DbT5305IkenshoImageJohoEntity entity,
            IkenshoImageJohoIdentifier id
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
     * @return {@link IkenshoImageJohoBuilder}
     */
    public IkenshoImageJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 主治医意見書作成依頼履歴番号を設定します。
     *
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return {@link IkenshoImageJohoBuilder}
     */
    public IkenshoImageJohoBuilder set主治医意見書作成依頼履歴番号(int 主治医意見書作成依頼履歴番号) {
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        entity.setIraiRirekiNo(主治医意見書作成依頼履歴番号);
        return this;
    }

    /**
     * 帳票IDを設定します。
     *
     * @param 帳票ID 帳票ID
     * @return {@link IkenshoImageJohoBuilder}
     */
    public IkenshoImageJohoBuilder set帳票ID(Code 帳票ID) {
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        entity.setChoyoID(帳票ID);
        return this;
    }

    /**
     * マスキングデータ区分を設定します。
     *
     * @param マスキングデータ区分 マスキングデータ区分
     * @return {@link IkenshoImageJohoBuilder}
     */
    public IkenshoImageJohoBuilder setマスキングデータ区分(RString マスキングデータ区分) {
        requireNonNull(マスキングデータ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("マスキングデータ区分"));
        entity.setGenponMaskKubun(マスキングデータ区分);
        return this;
    }
//
//    /**
//     * 取込みページ番号を設定します。
//     *
//     * @param 取込みページ番号 取込みページ番号
//     * @return {@link IkenshoImageJohoBuilder}
//     */
//    public IkenshoImageJohoBuilder set取込みページ番号(int 取込みページ番号) {
//        requireNonNull(取込みページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込みページ番号"));
//        entity.setTorikomiPageNo(取込みページ番号);
//        return this;
//    }
//
//    /**
//     * 認定申請年を設定します。
//     *
//     * @param 認定申請年 認定申請年
//     * @return {@link IkenshoImageJohoBuilder}
//     */
//    public IkenshoImageJohoBuilder set認定申請年(int 認定申請年) {
//        requireNonNull(認定申請年, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請年"));
//        entity.setNinteiShinseiNen(認定申請年);
//        return this;
//    }
//
//    /**
//     * 共有ファイルIDを設定します。
//     *
//     * @param 共有ファイルID 共有ファイルID
//     * @return {@link IkenshoImageJohoBuilder}
//     */
//    public IkenshoImageJohoBuilder set共有ファイルID(RDateTime 共有ファイルID) {
//        requireNonNull(共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("共有ファイルID"));
//        entity.setSharedFileId(共有ファイルID);
//        return this;
//    }

    /**
     * {@link IkenshoImageJoho}のインスタンスを生成します。
     *
     * @return {@link IkenshoImageJoho}のインスタンス
     */
    public IkenshoImageJoho build() {
        return new IkenshoImageJoho(entity, id);
    }
}
