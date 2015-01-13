/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.fuka.GemmenModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.GemmenDac;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 減免を取得するクラスです。
 *
 * @author N3317 塚田 萌
 */
public class GemmenFinder {

    private final GemmenDac dac;

    /**
     * コンストラクタです。
     */
    public GemmenFinder() {
        dac = InstanceProvider.create(GemmenDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 減免dac
     */
    GemmenFinder(GemmenDac dac) {
        this.dac = dac;
    }

    /**
     * 引数の主キーと状態区分に該当する１件の減免モデルを取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @param 状態区分 状態区分
     * @return 減免モデル
     */
    public IOptional<GemmenModel> find減免(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, RDateTime 処理日時, GemmenChoshuYuyoStateKubun 状態区分) {

        return dac.select減免ByKeyAndState(調定年度, 賦課年度, 通知書番号, 処理日時, 状態区分);
    }
}
