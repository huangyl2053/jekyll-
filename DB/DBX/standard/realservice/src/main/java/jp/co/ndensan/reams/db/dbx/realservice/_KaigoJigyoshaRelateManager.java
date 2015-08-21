/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.relate.KaigoJigyoshaRelateDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者関連情報を管理するクラスです。
 *
 * @author N8187 久保田 英男
 * @jpName
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public class _KaigoJigyoshaRelateManager implements IKaigoJigyoshaRelateFinder {

    private final KaigoJigyoshaRelateDac dac;

    /**
     * コンストラクタです。
     */
    public _KaigoJigyoshaRelateManager() {
        dac = InstanceProvider.create(KaigoJigyoshaRelateDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    _KaigoJigyoshaRelateManager(KaigoJigyoshaRelateDac dac) {
        this.dac = dac;
    }

    @Transaction
    @Override
    public KaigoJigyosha findLatestJigyosha(KaigoJigyoshaNo 事業者番号) {
        List<KaigoJigyoshaRelateEntity> result = dac.selectByJigyoshaNo(事業者番号);
        if (result.isEmpty()) {
            return null;
        }
        return new KaigoJigyosha(result.get(0));
    }

    /**
     * 介護事業者関連情報を登録します。
     *
     * @param 介護事業者関連情報 KaigoJigyosha
     * @return 登録件数
     * @throws ApplicationException 更新対象のデータがない場合はスローされる
     */
    @Transaction
    public int save(KaigoJigyosha 介護事業者関連情報) {

        //TODO n3317塚田萌　更新方法が確定したら対応する
//        if (介護事業者関連情報.getState() == EntityDataState.Added) {
//            return dac.insert(介護事業者関連情報);
//        } else if (介護事業者関連情報.getState() == EntityDataState.Modified) {
//            return dac.update(介護事業者関連情報);
//        } else if (介護事業者関連情報.getState() == EntityDataState.Deleted) {
//            return dac.delete(介護事業者関連情報);
//        }
        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
