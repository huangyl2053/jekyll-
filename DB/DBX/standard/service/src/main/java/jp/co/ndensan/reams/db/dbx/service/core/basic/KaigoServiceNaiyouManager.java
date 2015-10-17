/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス内容を管理するクラスです。
 */
public class KaigoServiceNaiyouManager {

    private final DbT7131KaigoServiceNaiyouDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoServiceNaiyouManager() {
        dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7131KaigoServiceNaiyouDac}
     */
    KaigoServiceNaiyouManager(DbT7131KaigoServiceNaiyouDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護サービス内容を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKoumokuCode
     * @param 提供開始年月 TeikyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return KaigoServiceNaiyou
     */
    @Transaction
    public KaigoServiceNaiyou get介護サービス内容(
            KaigoServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 提供開始年月,
            Decimal 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7131KaigoServiceNaiyouEntity entity = dac.selectByKey(
                サービス種類コード,
                サービス項目コード,
                提供開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoServiceNaiyou(entity);
    }

    /**
     * 介護サービス内容を全件返します。
     *
     * @return List<KaigoServiceNaiyou>
     */
    @Transaction
    public List<KaigoServiceNaiyou> get介護サービス内容一覧() {
        List<KaigoServiceNaiyou> businessList = new ArrayList<>();

        for (DbT7131KaigoServiceNaiyouEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoServiceNaiyou(entity));
        }

        return businessList;
    }

    /**
     * 介護サービス内容{@link KaigoServiceNaiyou}を保存します。
     *
     * @param 介護サービス内容 {@link KaigoServiceNaiyou}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護サービス内容(KaigoServiceNaiyou 介護サービス内容) {
        requireNonNull(介護サービス内容, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス内容"));
        if (!介護サービス内容.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護サービス内容.toEntity());
    }
}
