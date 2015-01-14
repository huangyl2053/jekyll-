/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.model.ShoriDateModel;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付のデータアクセスクラスです。
 *
 * @author n3317 塚田 萌
 */
public class ShoriDateDac implements IModifiable<ShoriDateModel> {

    @InjectSession
    private SqlSession session;
    private final DbT7022ShoriDateKanriDac 処理日付Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);

    /**
     * 処理日付情報をキー検索で１件返します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 市町村コード 市町村コード
     * @param 処理名 処理名
     * @param 処理枝番 処理枝番
     * @param 年度 年度
     * @param 年度内連番 年度内連番
     * @return ShoriDateKanriModel
     */
    @Transaction
    public Optional<ShoriDateModel> select処理日付ByKey(SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            ShoriName 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) {

        return createModel(処理日付Dac.selectByKey(
                サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番));
    }

    private Optional<ShoriDateModel> createModel(DbT7022ShoriDateKanriEntity 処理日付エンティティ) {
        if (処理日付エンティティ == null) {
            return Optional.empty();
        }

        return Optional.of(new ShoriDateModel(処理日付エンティティ));
    }

    @Override
    public int insert(ShoriDateModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }
        result = 処理日付Dac.insert(data.getEntity());

        return result;
    }

    @Override
    public int update(ShoriDateModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }
        result = 処理日付Dac.update(data.getEntity());

        return result;
    }

    @Override
    public int delete(ShoriDateModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }
        result = 処理日付Dac.delete(data.getEntity());

        return result;
    }
}
