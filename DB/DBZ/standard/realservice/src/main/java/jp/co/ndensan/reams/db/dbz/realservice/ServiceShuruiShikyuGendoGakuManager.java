/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.model.ServiceShuruiShikyuGendoGakuModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * サービス種類支給限度額を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class ServiceShuruiShikyuGendoGakuManager {

    private final ServiceShuruiShikyuGendoGakuDac dac;

    /**
     * コンストラクタです。
     */
    public ServiceShuruiShikyuGendoGakuManager() {
        dac = InstanceProvider.create(ServiceShuruiShikyuGendoGakuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    ServiceShuruiShikyuGendoGakuManager(ServiceShuruiShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致するサービス種類支給限度額を返します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 処理日時 処理日時
     * @return ServiceShuruiShikyuGendoGakuModel
     */
    @Transaction
    public ServiceShuruiShikyuGendoGakuModel getサービス種類支給限度額(ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            YMDHMS 処理日時) {

        return dac.selectByKey(サービス種類コード, 要介護状態区分, 適用開始年月, 処理日時);
    }

    /**
     * サービス種類支給限度額の一覧を返します。
     *
     * @return IItemList<ServiceShuruiShikyuGendoGakuModel>
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGakuModel> getサービス種類支給限度額一覧() {
        return dac.selectAll();
    }

    /**
     * サービス種類支給限度額の一覧を返します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 基準日 基準日
     * @return IItemList<ServiceShuruiShikyuGendoGakuModel>
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGakuModel> getサービス種類支給限度額一覧(RString 要介護状態区分,
            FlexibleDate 基準日) {
        return dac.selectサービス種類支給限度額リスト(要介護状態区分, 基準日);
    }

    /**
     * サービス種類支給限度額の一覧を返します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @return IItemList<ServiceShuruiShikyuGendoGakuModel>
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGakuModel> getサービス種類支給限度額一覧(RString 要介護状態区分) {
        return dac.selectサービス種類支給限度額リスト(要介護状態区分);
    }

    /**
     * サービス種類支給限度額を登録します。
     *
     * @param サービス種類支給限度額モデル ServiceShuruiShikyuGendoGakuModel
     * @return 登録件数
     */
    @Transaction
    public int saveサービス種類支給限度額(ServiceShuruiShikyuGendoGakuModel サービス種類支給限度額モデル) {

        if (サービス種類支給限度額モデル.getState() == EntityDataState.Added) {
            return dac.insert(サービス種類支給限度額モデル);
        } else if (サービス種類支給限度額モデル.getState() == EntityDataState.Modified) {
            return dac.update(サービス種類支給限度額モデル);
        } else if (サービス種類支給限度額モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(サービス種類支給限度額モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
