/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.model.ShoriDateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ShoriDateDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付を取得するクラスです。
 *
 * @author N3317 塚田 萌
 */
public class ShoriDateFinder {

    private final ShoriDateDac dac;

    /**
     * コンストラクタです。
     */
    public ShoriDateFinder() {
        dac = InstanceProvider.create(ShoriDateDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    ShoriDateFinder(ShoriDateDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する処理日付を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return ShoriDateKanriModel
     */
    @Transaction
    public Optional<ShoriDateModel> find処理日付(
            SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            ShoriName 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) {

        return dac.select処理日付ByKey(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
    }
}
