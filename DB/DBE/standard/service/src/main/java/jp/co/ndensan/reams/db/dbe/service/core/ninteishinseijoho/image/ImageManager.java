/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.image;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.image.Image;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5115ImageDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
