/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kubunshikyugendogaku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * サービス種類登録Mangerです。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogakuManager {

    private final DbT7130KaigoServiceShuruiDac kaigoServiceDac;
    private static final RString 定値_サービス種類コード = new RString("サービス種類コード");
    private static final RString 定値_提供開始年月 = new RString("提供開始年月");

    /**
     * サービス種類登録クラスのコンストラクタです。
     */
    public KubunShikyuGendogakuManager() {

        kaigoServiceDac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);

    }

    /**
     * 利サービス種類登録クラスのコンストラクタです(テスト用)。
     *
     * @param kaigoServiceDac kaigoServiceDac
     */
    KubunShikyuGendogakuManager(DbT7130KaigoServiceShuruiDac kaigoServiceDac) {

        this.kaigoServiceDac = kaigoServiceDac;

    }

    /**
     * サービス種類登録を取得します。
     *
     * @return List<NinkaModel>
     */
    public List<KaigoServiceShurui> getサービス種類登録() {
        List<KaigoServiceShurui> lists = new ArrayList();
        for (DbT7130KaigoServiceShuruiEntity entity : kaigoServiceDac.selectサービス種類登録()) {
            KaigoServiceShuruiEntity kaigoServiceShuruiEntity = new KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.set介護サービス種類Entity(entity);
            lists.add(new KaigoServiceShurui(kaigoServiceShuruiEntity));
        }
        return lists;
    }

    /**
     * サービス種類登録を取得します。
     *
     * @param entity DbT7130KaigoServiceShuruiEntity
     */
    public void save(KaigoServiceShurui entity) {
        kaigoServiceDac.save(entity.toEntity());
    }

    /**
     * 主キーに合致する居宅サービス区分支給限度額を削除する。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 提供開始年月 FlexibleYearMonth
     */
    @Transaction
    public void データを物理削除する(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_サービス種類コード.toString()));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_提供開始年月.toString()));

        DbT7130KaigoServiceShuruiEntity entity = kaigoServiceDac.selectByKey(
                サービス種類コード,
                提供開始年月);
        entity.initializeMd5();
        kaigoServiceDac.delete(entity);
    }

}
