/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiCollection;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosaIraiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaIraiDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査依頼情報を扱い管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIraiManager {

    private INinteichosaIraiDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteichosaIraiManager() {
        dac = InstanceProvider.create(INinteichosaIraiDac.class);
    }

    /**
     * 引数からDacを受け取る、テスト用packagePrivateコンストラクタです。
     *
     * @param dac テスト用Dac
     */
    NinteichosaIraiManager(INinteichosaIraiDac dac) {
        this.dac = dac;
    }

    /**
     * 引数に指定した申請書管理番号と認定調査依頼履歴番号に該当する、認定調査依頼情報を取得します。<br />
     * 該当する情報が存在しない場合、Nullが返ります。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査依頼情報
     */
    public NinteichosaIrai get認定調査依頼情報(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        DbT5006NinteichosaIraiJohoEntity entity = dac.select(申請書管理番号, 認定調査依頼履歴番号);
        //TODO n8178 城間篤人 認定調査委託先と調査員を表すクラスと、それらの取得方法が実装された後に、ここに取得処理を追加 2014年2月末
        return NinteichosaIraiMapper.to認定調査依頼情報(entity);
    }

    /**
     * 申請書管理番号を指定し、その申請書の認定調査依頼履歴を表す認定調査依頼情報Collectionを返します。<br />
     * 該当する情報が存在しない場合は、空のコレクションが返ります。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査依頼情報Collection
     */
    public NinteichosaIraiCollection get認定調査依頼情報履歴(ShinseishoKanriNo 申請書管理番号) {
        List<DbT5006NinteichosaIraiJohoEntity> entities = dac.select(申請書管理番号);
        //TODO n8178 城間篤人 認定調査委託先と調査員を表すクラスと、それらの取得方法が実装された後に、ここに取得処理を追加 2014年2月末
        return NinteichosaIraiMapper.to認定調査依頼情報Collection(entities);
    }

    /**
     * 引数から渡された認定調査情報を保存します。
     *
     * @param 認定調査依頼情報 認定調査依頼情報
     * @return 保存できた場合true
     */
    public boolean save(NinteichosaIrai 認定調査依頼情報) {
        int 件数 = dac.insertOrUpdate(NinteichosaIraiMapper.to認定調査依頼情報Entity(認定調査依頼情報));
        return 件数 == 1 ? true : false;
    }
}
