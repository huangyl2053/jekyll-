/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikentokusokujo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiikentokusokujo.ShujiiIkenTokusokujoParameter;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikentokusokujo.IShujiiIkenTokusokujoMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書情報を管理するクラスです。
 */
public class ShujiiIkenTokusokujoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIkenTokusokujoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShujiiIkenTokusokujoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenTokusokujoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIkenTokusokujoFinder}のインスタンス
     */
    public static ShujiiIkenTokusokujoFinder createInstance() {
        return InstanceProvider.create(ShujiiIkenTokusokujoFinder.class);
    }

    /**
     * 督促状該当データ件数を返します。
     *
     * @param 主治医意見書情報検索条件 主治医意見書情報検索条件
     * @return 督促状該当データ件数
     */
    @Transaction
    public int get督促状件数(ShujiiIkenTokusokujoHakkoTempData 主治医意見書情報検索条件) {
        requireNonNull(主治医意見書情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書情報検索条件"));
        IShujiiIkenTokusokujoMapper mapper = mapperProvider.create(IShujiiIkenTokusokujoMapper.class);
        return mapper.select督促状件数(ShujiiIkenTokusokujoParameter.createParam督促状件数(主治医意見書情報検索条件));
    }

    /**
     * 督促状対象者該当データ件数を返します。
     *
     * @param 主治医意見書情報検索条件 主治医意見書情報検索条件
     * @return 督促状対象者該当データ件数
     */
    @Transaction
    public int get督促状対象者件数(ShujiiIkenTokusokujoHakkoTempData 主治医意見書情報検索条件) {
        requireNonNull(主治医意見書情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書情報検索条件"));
        IShujiiIkenTokusokujoMapper mapper = mapperProvider.create(IShujiiIkenTokusokujoMapper.class);
        return mapper.select督促状対象者件数(ShujiiIkenTokusokujoParameter.createParam督促状対象者件数(主治医意見書情報検索条件));
    }
}
