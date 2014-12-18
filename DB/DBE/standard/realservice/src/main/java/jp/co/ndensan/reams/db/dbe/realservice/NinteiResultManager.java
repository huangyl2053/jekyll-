/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteiKekkaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.business.IKaigoService;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.ur.urz.realservice.IKaigoServiceManager;
import jp.co.ndensan.reams.ur.urz.realservice.KaigoServiceManagerFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
        return NinteiKekkaMapper.toNinteiResult(entity, get介護サービス種類０１(entity), get介護サービス種類０２(entity),
                get介護サービス種類０３(entity), get介護サービス種類０４(entity), get介護サービス種類０５(entity), get介護サービス種類０６(entity),
                get介護サービス種類０７(entity), get介護サービス種類０８(entity), get介護サービス種類０９(entity), get介護サービス種類１０(entity),
                get介護サービス種類１１(entity), get介護サービス種類１２(entity), get介護サービス種類１３(entity), get介護サービス種類１４(entity),
                get介護サービス種類１５(entity), get介護サービス種類１６(entity), get介護サービス種類１７(entity), get介護サービス種類１８(entity),
                get介護サービス種類１９(entity), get介護サービス種類２０(entity), get介護サービス種類２１(entity), get介護サービス種類２２(entity),
                get介護サービス種類２３(entity), get介護サービス種類２４(entity), get介護サービス種類２５(entity), get介護サービス種類２６(entity),
                get介護サービス種類２７(entity), get介護サービス種類２８(entity), get介護サービス種類２９(entity), get介護サービス種類３０(entity));
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

    private IKaigoServiceShurui get介護サービス種類０１(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui01());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０２(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui02());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０３(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui03());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０４(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui04());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０５(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui05());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０６(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui06());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０７(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui07());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０８(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui08());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類０９(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui09());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１０(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui10());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１１(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui11());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１２(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui12());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１３(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui13());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１４(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui14());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１５(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui15());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１６(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui16());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１７(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui17());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１８(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui18());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類１９(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui19());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２０(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui20());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２１(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui21());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２２(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui22());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２３(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui23());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２４(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui24());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２５(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui25());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２６(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui26());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２７(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui27());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２８(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui28());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類２９(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui29());
        return service.get介護サービス種類();
    }

    private IKaigoServiceShurui get介護サービス種類３０(DbT5002NinteiKekkaJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        IKaigoService service = kaigoServiceManager.get介護サービス(
                new FlexibleYearMonth(entity.getYoukaigodoNinteiYMD().toString().substring(0, 6)), entity.getKaigoServiceShurui30());
        return service.get介護サービス種類();
    }
}
