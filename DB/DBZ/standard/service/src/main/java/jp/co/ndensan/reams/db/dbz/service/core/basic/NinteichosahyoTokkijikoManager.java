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
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5205NinteichosahyoTokkijikoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_特記情報を管理するクラスです。
 *
 * @reamsid_L DBE-3000-200 liangbc
 */
public class NinteichosahyoTokkijikoManager {

    private final DbT5205NinteichosahyoTokkijikoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoTokkijikoManager() {
        dac = InstanceProvider.create(DbT5205NinteichosahyoTokkijikoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5205NinteichosahyoTokkijikoDac}
     */
    NinteichosahyoTokkijikoManager(DbT5205NinteichosahyoTokkijikoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoTokkijikoManager}のインスタンスを返します。
     *
     *
     * @return NinteichosahyoTokkijikoManager
     */
    public static NinteichosahyoTokkijikoManager createInstance() {
        return InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
    }

    /**
     * 主キーに合致する認定調査票_特記情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 認定調査特記事項連番 認定調査特記事項連番
     * @param 特記事項テキスト_イメージ区分 特記事項テキスト_イメージ区分
     * @param 原本マスク区分 原本マスク区分
     * @return NinteichosahyoTokkijiko
     */
    @Transaction
    public NinteichosahyoTokkijiko get認定調査票_特記情報(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 認定調査特記事項番号,
            Integer 認定調査特記事項連番,
            RString 特記事項テキスト_イメージ区分,
            Code 原本マスク区分
    ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(認定調査特記事項番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項番号"));
        requireNonNull(認定調査特記事項連番, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項連番"));
        requireNonNull(特記事項テキスト_イメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項テキスト_イメージ区分"));
        requireNonNull(原本マスク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク区分"));

        DbT5205NinteichosahyoTokkijikoEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号,
                認定調査特記事項番号,
                認定調査特記事項連番,
                特記事項テキスト_イメージ区分,
                原本マスク区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoTokkijiko(entity);
    }

    /**
     * 認定調査票_特記情報を全件返します。
     *
     * @return NinteichosahyoTokkijikoの{@code list}
     */
    @Transaction
    public List<NinteichosahyoTokkijiko> get認定調査票_特記情報一覧() {
        List<NinteichosahyoTokkijiko> businessList = new ArrayList<>();

        for (DbT5205NinteichosahyoTokkijikoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoTokkijiko(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_特記情報{@link NinteichosahyoTokkijiko}を保存します。
     *
     * @param 認定調査票_特記情報 {@link NinteichosahyoTokkijiko}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_特記情報(NinteichosahyoTokkijiko 認定調査票_特記情報) {
        requireNonNull(認定調査票_特記情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_特記情報"));
        if (!認定調査票_特記情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_特記情報.toEntity());
    }

    /**
     * 認定調査特記事項照会画面初期化時の検索処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return NinteichosahyoTokkijiko
     */
    @Transaction
    public ArrayList<NinteichosahyoTokkijiko> get調査特記事項(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, List<RString> 認定調査特記事項番号) {
        ArrayList<NinteichosahyoTokkijiko> businessList = new ArrayList<>();
        List<DbT5205NinteichosahyoTokkijikoEntity> entitys
                = dac.selectBy申請書管理番号_認定調査依頼履歴番号_認定調査特記事項番号(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号);
        for (DbT5205NinteichosahyoTokkijikoEntity entity : entitys) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoTokkijiko(entity));
        }
        return businessList;
    }
}
