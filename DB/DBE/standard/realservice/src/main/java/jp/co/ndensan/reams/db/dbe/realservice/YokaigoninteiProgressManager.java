/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgress;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteiShinchokuJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteiShinchokuJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定進捗情報を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class YokaigoninteiProgressManager {

    private final NinteiShinchokuJohoDac ninteiShinchokuJohoDac;

    /**
     * デフォルトコンストラクタです。
     */
    public YokaigoninteiProgressManager() {
        this.ninteiShinchokuJohoDac = InstanceProvider.create(NinteiShinchokuJohoDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです
     *
     * @param ninteiShinchokuJohoDac 認定進捗情報Dac
     */
    YokaigoninteiProgressManager(
            NinteiShinchokuJohoDac ninteiShinchokuJohoDac) {
        this.ninteiShinchokuJohoDac = ninteiShinchokuJohoDac;
    }

    /**
     * 要介護認定進捗情報を更新します。
     *
     * @param yokaigoniteiProgress yokaigoniteiProgress
     * @return 更新結果
     */
    public boolean save(YokaigoninteiProgress yokaigoniteiProgress) {
        return ninteiShinchokuJohoDac.update(NinteiShinchokuJohoMapper.toNinteiShinchokuJohoEntity(yokaigoniteiProgress)) != 0;
    }
}
