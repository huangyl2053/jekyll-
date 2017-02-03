/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5213GaikyoChosaTokkiMaskEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5213GaikyoChosaTokkiMaskDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author n3509
 */
public class GaikyoChosaTokkiManager {

    private final DbT5213GaikyoChosaTokkiMaskDac dac;

    /**
     * コンストラクタです。
     */
    public GaikyoChosaTokkiManager() {
        dac = InstanceProvider.create(DbT5213GaikyoChosaTokkiMaskDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5206GaikyoTokkiDac}
     */
    GaikyoChosaTokkiManager(DbT5213GaikyoChosaTokkiMaskDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GaikyoChosaTokkiManager}のインスタンスを返します。
     *
     *
     * @return GaikyoChosaTokkiManager
     */
    public static GaikyoChosaTokkiManager createInstance() {
        return InstanceProvider.create(GaikyoChosaTokkiManager.class);
    }

    /**
     * 主キーに合致する認定調査票_概況調査_子を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況調査テキストイメージ区分 概況調査テキストイメージ区分
     * @return NinteichosahyoGaikyoChosa
     */
    @Transaction
    public GaikyoChosaTokki get概況調査特記マスク(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分
    ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(概況調査テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査テキストイメージ区分"));

        DbT5213GaikyoChosaTokkiMaskEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号,
                概況調査テキストイメージ区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GaikyoChosaTokki(entity);
    }
    
    /**
     * 概況調査特記{@link GaikyoChosaTokki}を保存します。
     *
     * @param 概況調査特記 {@link GaikyoChosaTokki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save概況調査特記(GaikyoChosaTokki 概況調査特記) {
        requireNonNull(概況調査特記, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査特記"));
        if (!概況調査特記.hasChanged()) {
            return false;
        }
        return 1 == dac.save(概況調査特記.toEntity());
    }
}
