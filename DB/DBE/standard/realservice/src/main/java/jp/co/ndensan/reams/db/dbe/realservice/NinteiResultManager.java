/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteiKekkaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.business.IKaigoService;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.ur.urz.realservice.IKaigoServiceManager;
import jp.co.ndensan.reams.ur.urz.realservice.KaigoServiceManagerFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定結果を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiResultManager {

    private final NinteiKekkaJohoDac dac;
    private final IKaigoServiceManager kaigoServiceManager;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public NinteiResultManager() {
        dac = InstanceProvider.create(NinteiKekkaJohoDac.class);
        kaigoServiceManager = KaigoServiceManagerFactory.createInstance();

    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 要介護認定結果情報Dac
     * @param kaigoServiceManager 介護サービスマネージャー
     */
    NinteiResultManager(NinteiKekkaJohoDac dac, IKaigoServiceManager kaigoServiceManager) {
        this.dac = dac;
        this.kaigoServiceManager = kaigoServiceManager;
    }

    /**
     * 引数の条件に該当する認定結果を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定結果
     */
    public NinteiResult get認定結果(ShinseishoKanriNo 申請書管理番号) {
        DbT5002NinteiKekkaJohoEntity entity = dac.select(申請書管理番号);
        return NinteiKekkaMapper.toNinteiResult(entity, get介護サービス種類(entity));
    }

    /**
     * 引数の認定結果を追加、または更新します。
     *
     * @param 認定結果 認定結果
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    public boolean save認定結果(NinteiResult 認定結果) {
        return dac.insert(NinteiKekkaMapper.toDbT5002NinteiKekkaJohoEntity(認定結果)) != 0;
    }

    /**
     * 引数の認定結果を削除します。
     *
     * @param 認定結果 認定結果
     * @return 削除が成功した場合はtrueを返します。
     */
    public boolean remove認定結果(NinteiResult 認定結果) {
        return dac.delete(NinteiKekkaMapper.toDbT5002NinteiKekkaJohoEntity(認定結果)) != 0;
    }

    private IKaigoServiceShurui get介護サービス種類(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new RDate(entity.getYoukaigodoNinteiYMD().toString()), entity.getKaigoServiceShurui());
        return service.get介護サービス種類();
    }
}
