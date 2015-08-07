/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為届出詳細を管理するクラスです。
 */
public class DaisanshaKoiTodokedeMeisaiManager {

    private final DbT3085DaisanshaKoiTodokedeMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiTodokedeMeisaiManager() {
        dac = InstanceProvider.create(DbT3085DaisanshaKoiTodokedeMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3085DaisanshaKoiTodokedeMeisaiDac}
     */
    DaisanshaKoiTodokedeMeisaiManager(DbT3085DaisanshaKoiTodokedeMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護第三者行為届出詳細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param サービス提供事業者番号 ServiceTeikyoJigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 履歴番号 RirekiNo
     * @return DaisanshaKoiTodokedeMeisai
     */
    @Transaction
    public DaisanshaKoiTodokedeMeisai get介護第三者行為届出詳細(
             HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3085DaisanshaKoiTodokedeMeisaiEntity entity = dac.selectByKey(
                被保険者番号,
                第三者行為届出管理番号,
                サービス提供事業者番号,
                サービス種類コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DaisanshaKoiTodokedeMeisai(entity);
    }

    /**
     * 介護第三者行為届出詳細を全件返します。
     *
     * @return List<DaisanshaKoiTodokedeMeisai>
     */
    @Transaction
    public List<DaisanshaKoiTodokedeMeisai> get介護第三者行為届出詳細一覧() {
        List<DaisanshaKoiTodokedeMeisai> businessList = new ArrayList<>();

        for (DbT3085DaisanshaKoiTodokedeMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new DaisanshaKoiTodokedeMeisai(entity));
        }

        return businessList;
    }

    /**
     * 介護第三者行為届出詳細{@link DaisanshaKoiTodokedeMeisai}を保存します。
     *
     * @param 介護第三者行為届出詳細 {@link DaisanshaKoiTodokedeMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護第三者行為届出詳細(DaisanshaKoiTodokedeMeisai 介護第三者行為届出詳細) {
        requireNonNull(介護第三者行為届出詳細, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為届出詳細"));
        if (!介護第三者行為届出詳細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護第三者行為届出詳細.toEntity());
    }
}
