/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者指定サービスを管理するクラスです。
 */
public class KaigoJigyoshaShiteiServiceManager {

    private final DbT7063KaigoJigyoshaShiteiServiceDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaShiteiServiceManager() {
        dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7063KaigoJigyoshaShiteiServiceDac}
     */
    KaigoJigyoshaShiteiServiceManager(DbT7063KaigoJigyoshaShiteiServiceDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護事業者指定サービスを返します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 有効開始日 YukoKaishiYMD
     * @return KaigoJigyoshaShiteiService
     */
    @Transaction
    public KaigoJigyoshaShiteiService get介護事業者指定サービス(
            KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbT7063KaigoJigyoshaShiteiServiceEntity entity = dac.selectByKey(
                事業者番号,
                サービス種類コード,
                有効開始日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoJigyoshaShiteiService(entity);
    }

    /**
     * 介護事業者指定サービスを全件返します。
     *
     * @return List<KaigoJigyoshaShiteiService>
     */
    @Transaction
    public List<KaigoJigyoshaShiteiService> get介護事業者指定サービス一覧() {
        List<KaigoJigyoshaShiteiService> businessList = new ArrayList<>();

        for (DbT7063KaigoJigyoshaShiteiServiceEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoJigyoshaShiteiService(entity));
        }

        return businessList;
    }

    /**
     * 介護事業者指定サービス{@link KaigoJigyoshaShiteiService}を保存します。
     *
     * @param 介護事業者指定サービス {@link KaigoJigyoshaShiteiService}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護事業者指定サービス(KaigoJigyoshaShiteiService 介護事業者指定サービス) {
        requireNonNull(介護事業者指定サービス, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者指定サービス"));
        if (!介護事業者指定サービス.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護事業者指定サービス.toEntity());
    }
}
