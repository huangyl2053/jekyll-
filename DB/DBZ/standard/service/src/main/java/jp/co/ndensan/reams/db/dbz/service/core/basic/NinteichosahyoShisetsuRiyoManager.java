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
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5210NinteichosahyoShisetsuRiyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_施設利用を管理するクラスです。
 */
public class NinteichosahyoShisetsuRiyoManager {

    private final DbT5210NinteichosahyoShisetsuRiyoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoShisetsuRiyoManager() {
        dac = InstanceProvider.create(DbT5210NinteichosahyoShisetsuRiyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5210NinteichosahyoShisetsuRiyoDac}
     */
    NinteichosahyoShisetsuRiyoManager(DbT5210NinteichosahyoShisetsuRiyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_概況調査_施設利用を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     * @return NinteichosahyoShisetsuRiyo
     */
    @Transaction
    public NinteichosahyoShisetsuRiyo get認定調査票_概況調査_施設利用(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5210NinteichosahyoShisetsuRiyoEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoShisetsuRiyo(entity);
    }

    /**
     * 主キーに合致する認定調査票_概況調査_施設利用を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番List 連番List
     * @return NinteichosahyoShisetsuRiyo
     */
    @Transaction
    public List<NinteichosahyoShisetsuRiyo> get認定調査票_概況調査_施設利用By連番List(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            List<Integer> 連番List) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番List, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        List<NinteichosahyoShisetsuRiyo> list = new ArrayList<>();
        List<DbT5210NinteichosahyoShisetsuRiyoEntity> entityList = dac.selectBy連番List(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番List);
        if (entityList == null) {
            return list;
        }
        for (DbT5210NinteichosahyoShisetsuRiyoEntity entity : entityList) {
            list.add(new NinteichosahyoShisetsuRiyo(entity));
        }
        return list;
    }

    /**
     * 認定調査票_概況調査_施設利用を全件返します。
     *
     * @return NinteichosahyoShisetsuRiyoの{@code list}
     */
    @Transaction
    public List<NinteichosahyoShisetsuRiyo> get認定調査票_概況調査_施設利用一覧() {
        List<NinteichosahyoShisetsuRiyo> businessList = new ArrayList<>();

        for (DbT5210NinteichosahyoShisetsuRiyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoShisetsuRiyo(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_概況調査_施設利用{@link NinteichosahyoShisetsuRiyo}を保存します。
     *
     * @param 認定調査票_概況調査_施設利用 {@link NinteichosahyoShisetsuRiyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_施設利用(NinteichosahyoShisetsuRiyo 認定調査票_概況調査_施設利用) {
        requireNonNull(認定調査票_概況調査_施設利用, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_施設利用"));
        if (!認定調査票_概況調査_施設利用.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_施設利用.toEntity());
    }

    /**
     * 主キーに連番除外の認定調査票_概況調査_施設利用を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return NinteichosahyoShisetsuRiyo
     */
    @Transaction
    public SearchResult<NinteichosahyoShisetsuRiyo> get連番除外の認定調査票_概況調査_施設利用(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {

        List<NinteichosahyoShisetsuRiyo> list = new ArrayList<>();
        List<DbT5210NinteichosahyoShisetsuRiyoEntity> entityList = dac.selectBy連番除外(
                申請書管理番号,
                認定調査依頼履歴番号);
        for (DbT5210NinteichosahyoShisetsuRiyoEntity entity : entityList) {
            list.add(new NinteichosahyoShisetsuRiyo(entity));
        }
        return SearchResult.of(list, 0, false);
    }
}
