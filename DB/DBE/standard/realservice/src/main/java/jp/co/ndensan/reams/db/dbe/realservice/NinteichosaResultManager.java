/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosaKekkaMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.NinteichosaKekkaDac;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.realservice._NinteiChosainFinder;
import jp.co.ndensan.reams.ur.urf.realservice.INinteiChosainFinder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定調査の調査結果を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultManager {

    private final NinteichosaKekkaDac dac;
    private final INinteiChosainFinder finder;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public NinteichosaResultManager() {
        dac = InstanceProvider.create(NinteichosaKekkaDac.class);
        finder = new _NinteiChosainFinder();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 要介護認定調査結果Dac
     * @param finder 認定調査員Finder
     */
    NinteichosaResultManager(NinteichosaKekkaDac dac, INinteiChosainFinder finder) {
        this.dac = dac;
        this.finder = finder;
    }

    /**
     * 引数の条件に該当する認定調査結果を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 認定調査結果
     */
    public NinteichosaResult get認定調査結果(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査履歴番号) {
        NinteichosaKekkaEntity entity = dac.select(申請書管理番号, 認定調査履歴番号);
        if (entity == null) {
            return null;
        }
        INinteiChosain chosain = finder.get認定調査員(entity.getDbT5008NinteichosaKekkaJohoEntity().getChosainCode());
        return NinteichosaKekkaMapper.toNinteichosaResult(entity, chosain);
    }

    /**
     * 引数の認定調査結果を追加、または更新します。
     *
     * @param 認定調査結果 認定調査結果
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    public boolean save認定調査結果(NinteichosaResult 認定調査結果) {
        return dac.insertOrUpdate(NinteichosaKekkaMapper.toNinteichosaKekkaEntity(認定調査結果)) != 0;
    }

    /**
     * 引数の認定調査結果を削除します。
     *
     * @param 認定調査結果 認定調査結果
     * @return 削除が成功した場合はtrueを返します。
     */
    public boolean remove認定調査結果(NinteichosaResult 認定調査結果) {
        return dac.delete(NinteichosaKekkaMapper.toNinteichosaKekkaEntity(認定調査結果)) != 0;
    }
}
