/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuHohoModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ChoshuHohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 徴収方法を取得するクラスです。
 *
 * @author N3317 塚田 萌
 */
public class ChoshuHohoFinder {

    private final ChoshuHohoDac dac;

    /**
     * コンストラクタです。
     */
    public ChoshuHohoFinder() {
        dac = InstanceProvider.create(ChoshuHohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 徴収方法dac
     */
    ChoshuHohoFinder(ChoshuHohoDac dac) {
        this.dac = dac;
    }

    /**
     * 引数に該当する、直近の徴収方法モデルを1件取得します。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @return 徴収方法モデル
     */
    public IOptional<ChoshuHohoModel> find徴収方法(FukaNendo 賦課年度, HihokenshaNo 被保険者番号) {

        return dac.select徴収方法Recently(賦課年度, 被保険者番号);
    }
}
