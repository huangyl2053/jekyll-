/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaijizenshinsakekkaichiran;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiJizenKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5508ShinsakaiJizenKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会委員事前審査結果登録のデータを更新クラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class ShinsakaiJIzenshinsakekkaIchiranManager {

    private final DbT5508ShinsakaiJizenKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiJIzenshinsakekkaIchiranManager() {
        dac = InstanceProvider.create(DbT5508ShinsakaiJizenKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5508ShinsakaiJizenKekkaJohoDac}
     */
    ShinsakaiJIzenshinsakekkaIchiranManager(DbT5508ShinsakaiJizenKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiJIzenshinsakekkaIchiranManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiJIzenshinsakekkaIchiranManager}のインスタンス
     */
    public static ShinsakaiJIzenshinsakekkaIchiranManager createInstance() {
        return InstanceProvider.create(ShinsakaiJIzenshinsakekkaIchiranManager.class);
    }

    /**
     * CSVのデータの更新
     *
     * @param 審査会事前審査結果 審査会事前審査結果
     * @return 更新結果
     */
    public boolean saveCsvDataInput(ShinsakaiJizenKekkaJoho 審査会事前審査結果) {
        requireNonNull(審査会事前審査結果, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会事前審査結果情報エンティティ"));
        if (!審査会事前審査結果.hasChanged()) {
            return false;
        }
        return 1 == dac.save(審査会事前審査結果.toEntity());
    }

    /**
     * 主キーで介護認定審査会事前審査結果情報を取得します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 介護認定審査会審査順 介護認定審査会審査順
     * @return 結果フラグ
     */
    public DbT5508ShinsakaiJizenKekkaJohoEntity selectByKey(RString 介護認定審査会開催番号, RString 介護認定審査会委員コード, int 介護認定審査会審査順) {
        return dac.selectByKey(介護認定審査会開催番号, 介護認定審査会委員コード, 介護認定審査会審査順);
    }
}
