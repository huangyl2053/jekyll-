/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_子を管理するクラスです。
 */
public class NinteichosahyoGaikyoChosaManager {

    private final DbT5202NinteichosahyoGaikyoChosaDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoGaikyoChosaManager() {
        dac = InstanceProvider.create(DbT5202NinteichosahyoGaikyoChosaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5202NinteichosahyoGaikyoChosaDac}
     */
    NinteichosahyoGaikyoChosaManager(DbT5202NinteichosahyoGaikyoChosaDac dac) {
        this.dac = dac;
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
    public NinteichosahyoGaikyoChosa get認定調査票_概況調査_子(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分
    ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(概況調査テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査テキストイメージ区分"));

        DbT5202NinteichosahyoGaikyoChosaEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号,
                概況調査テキストイメージ区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoGaikyoChosa(entity);
    }

    /**
     * 認定調査票_概況調査_子を全件返します。
     *
     * @return NinteichosahyoGaikyoChosaの{@code list}
     */
    @Transaction
    public List<NinteichosahyoGaikyoChosa> get認定調査票_概況調査_子一覧() {
        List<NinteichosahyoGaikyoChosa> businessList = new ArrayList<>();

        for (DbT5202NinteichosahyoGaikyoChosaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoGaikyoChosa(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_概況調査_子{@link NinteichosahyoGaikyoChosa}を保存します。
     *
     * @param 認定調査票_概況調査_子 {@link NinteichosahyoGaikyoChosa}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_子(NinteichosahyoGaikyoChosa 認定調査票_概況調査_子) {
        requireNonNull(認定調査票_概況調査_子, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_子")
        );
        if (!認定調査票_概況調査_子.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_子.toEntity());
    }

    /**
     * 主キーに合致する認定調査票_概況調査_子を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return SearchResult<NinteichosahyoGaikyoChosa>
     */
    @Transaction
    public SearchResult<NinteichosahyoGaikyoChosa> get認定調査票_概況調査_情報(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        List<NinteichosahyoGaikyoChosa> ninteichosahyoGaikyoChosaList = new ArrayList<>();
        List<DbT5202NinteichosahyoGaikyoChosaEntity> entityList = dac.select認定調査票(
                申請書管理番号,
                認定調査依頼履歴番号);
        for (DbT5202NinteichosahyoGaikyoChosaEntity entity : entityList) {
            entity.initializeMd5();
            ninteichosahyoGaikyoChosaList.add(new NinteichosahyoGaikyoChosa(entity));
        }

        return SearchResult.of(ninteichosahyoGaikyoChosaList, 0, false);
    }
}
