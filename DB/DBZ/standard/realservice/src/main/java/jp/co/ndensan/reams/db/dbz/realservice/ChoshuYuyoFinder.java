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
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.ChoshuYuyoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ChoshuYuyoRelateDac;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 徴収猶予を取得するクラスです。
 *
 * @author N3317 塚田 萌
 */
public class ChoshuYuyoFinder {

    private final ChoshuYuyoRelateDac dac;

    /**
     * コンストラクタです。
     */
    public ChoshuYuyoFinder() {
        dac = InstanceProvider.create(ChoshuYuyoRelateDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 徴収猶予Relatedac
     */
    ChoshuYuyoFinder(ChoshuYuyoRelateDac dac) {
        this.dac = dac;
    }

    /**
     * 引数の主キーと状態区分に該当する１件の徴収猶予Relateモデルを取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @param 状態区分 状態区分
     * @return 徴収猶予Relateモデル
     */
    public IOptional<ChoshuYuyoRelateModel> find徴収猶予(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, RDateTime 処理日時, GemmenChoshuYuyoStateKubun 状態区分) {

        return dac.select徴収猶予RelateByKeyAndState(調定年度, 賦課年度, 通知書番号, 処理日時, 状態区分);
    }
}
