/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaKekkaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosahyoJohoDac;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 要介護認定調査の調査結果情報を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultManager {

    private final INinteichosaKekkaJohoDac ninteichosaKekkaJohoDac;
    private final INinteichosahyoJohoDac ninteichosahyoJohoDac;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public NinteichosaResultManager() {
        ninteichosaKekkaJohoDac = InstanceCreator.create(INinteichosaKekkaJohoDac.class);
        ninteichosahyoJohoDac = InstanceCreator.create(INinteichosahyoJohoDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param ninteichosaKekkaJohoDac 要介護認定調査結果情報Dac
     * @param ninteichosahyoJohoDac 要介護認定調査票情報Dac
     */
    NinteichosaResultManager(INinteichosaKekkaJohoDac ninteichosaKekkaJohoDac, INinteichosahyoJohoDac ninteichosahyoJohoDac) {
        this.ninteichosaKekkaJohoDac = ninteichosaKekkaJohoDac;
        this.ninteichosahyoJohoDac = ninteichosahyoJohoDac;
    }

    /**
     * 引数の条件に該当する認定調査結果情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 認定調査結果情報
     */
    public NinteichosaResult get認定調査結果(ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号) {
        return NinteichosaKekkaMapper.toNinteichosaResult(
                ninteichosaKekkaJohoDac.select(申請書管理番号.value(), 認定調査履歴番号),
                ninteichosahyoJohoDac.select(申請書管理番号.value(), 認定調査履歴番号));
    }

    /**
     * 引数の認定調査結果情報を追加、または更新します。
     *
     * @param 認定調査結果情報 認定調査結果情報
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    public boolean save認定調査結果(NinteichosaResult 認定調査結果情報) {
        return ninteichosaKekkaJohoDac.insertOrUpdate(NinteichosaKekkaMapper.toDbT5008NinteichosaKekkaJohoEntity(認定調査結果情報)) != 0
                && ninteichosahyoJohoDac.insertOrUpdate(NinteichosaKekkaMapper.toDbT5009NinteichosahyoJohoEntity(認定調査結果情報)) != 0;
    }

    /**
     * 引数の認定調査結果情報を削除します。
     *
     * @param 認定調査結果情報 認定調査結果情報
     * @return 削除が成功した場合はtrueを返します。
     */
    public boolean remove認定調査結果(NinteichosaResult 認定調査結果情報) {
        return ninteichosaKekkaJohoDac.delete(NinteichosaKekkaMapper.toDbT5008NinteichosaKekkaJohoEntity(認定調査結果情報)) != 0
                && ninteichosahyoJohoDac.delete(NinteichosaKekkaMapper.toDbT5009NinteichosahyoJohoEntity(認定調査結果情報)) != 0;
    }
}
