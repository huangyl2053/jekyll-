/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shoridatekanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author x_yuqz
 */
public class ShoriDateKanriFinder {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public ShoriDateKanriFinder() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7022ShoriDateKanriDac}
     */
    ShoriDateKanriFinder(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 処理日付管理情報を取得します。
     *
     * @param 処理名 RString
     * @param 年度 FlexibleYear
     * @return ShoriDateKanri
     */
    public List<ShoriDateKanri> get処理日付管理情報(RString 処理名, FlexibleYear 年度) {
        List<DbT7022ShoriDateKanriEntity> entityList = dac.select処理日付管理情報(処理名, 年度);
        if (null == entityList || entityList.isEmpty()) {
            return null;
        }
        List<ShoriDateKanri> resultList = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            resultList.add(new ShoriDateKanri(entity));
        }
        return resultList;
    }

    /**
     * 処理日付管理情報を取得します。
     *
     * @param 処理名 RString
     * @param 年度 FlexibleYear
     * @return ShoriDateKanri
     */
    public List<ShoriDateKanri> get特徴対象者同定_6月開始分(RString 処理名, FlexibleYear 年度) {
        List<DbT7022ShoriDateKanriEntity> entityList = dac.select特徴対象者同定_6月開始分(処理名, 年度);
        if (null == entityList || entityList.isEmpty()) {
            return null;
        }
        List<ShoriDateKanri> resultList = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            resultList.add(new ShoriDateKanri(entity));
        }
        return resultList;
    }
}
