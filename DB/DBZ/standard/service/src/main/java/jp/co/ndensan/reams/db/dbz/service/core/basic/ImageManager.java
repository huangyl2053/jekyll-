/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5115ImageDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * イメージ情報を管理するクラスです。
 */
public class ImageManager {

    private final DbT5115ImageDac dac;

    /**
     * コンストラクタです。
     */
    public ImageManager() {
        dac = InstanceProvider.create(DbT5115ImageDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5115ImageDac}
     */
    ImageManager(DbT5115ImageDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致するイメージ情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 取込ページ番号 取込ページ番号
     * @param 原本マスク分 原本マスク分
     * @return Image
     */
    @Transaction
    public Image getイメージ情報(
            ShinseishoKanriNo 申請書管理番号,
            int 取込ページ番号,
            Code 原本マスク分) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(取込ページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込ページ番号"));
        requireNonNull(原本マスク分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク分"));

        DbT5115ImageEntity entity = dac.selectByKey(
                申請書管理番号,
                取込ページ番号,
                原本マスク分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Image(entity);
    }

    /**
     * イメージ情報を全件返します。
     *
     * @return Imageの{@code list}
     */
    @Transaction
    public List<Image> getイメージ情報一覧() {
        List<Image> businessList = new ArrayList<>();

        for (DbT5115ImageEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new Image(entity));
        }

        return businessList;
    }

    /**
     * イメージ情報{@link Image}を保存します。
     *
     * @param イメージ情報 {@link Image}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveイメージ情報(Image イメージ情報) {
        requireNonNull(イメージ情報, UrSystemErrorMessages.値がnull.getReplacedMessage("イメージ情報"));
        if (!イメージ情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(イメージ情報.toEntity());
    }
}
