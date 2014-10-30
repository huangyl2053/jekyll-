/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.ShinsakaiKaisaiBashoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiKaisaiBashoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会開催場所の情報を管理するクラスです。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiBashoManager {

    private final ShinsakaiKaisaiBashoDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public ShinsakaiKaisaiBashoManager() {
        dac = InstanceProvider.create(ShinsakaiKaisaiBashoDac.class);
    }

    /**
     * テスト用パッケージプライベートコンストラクタです。
     *
     * @param shinsakaiKaisaiBashoDac テスト用MockDac
     */
    ShinsakaiKaisaiBashoManager(ShinsakaiKaisaiBashoDac shinsakaiKaisaiBashoDac) {
        this.dac = shinsakaiKaisaiBashoDac;
    }

    /**
     * 審査会開催場所コードで指定された審査会開催場所情報を取得します。
     *
     * @param 審査会開催場所コード 審査会開催場所コード
     * @return 審査会開催場所
     */
    public ShinsakaiKaisaiBasho get審査会開催場所(ShinsakaiKaisaiBashoCode 審査会開催場所コード) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = dac.select(審査会開催場所コード);
        return ShinsakaiKaisaiBashoMapper.to審査会開催場所(entity);
    }

    /**
     * 審査会開催場所コードと開催場所状況で指定された審査会開催場所情報を取得します。
     *
     * @param 審査会開催場所コード 審査会開催場所コード
     * @param 開催場所状況 開催場所状況（True:有効 False:無効）
     * @return 審査会開催場所
     */
    public ShinsakaiKaisaiBasho get審査会開催場所(ShinsakaiKaisaiBashoCode 審査会開催場所コード, ShinsakaiKaisaiBashoJokyo 開催場所状況) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = dac.select(審査会開催場所コード, 開催場所状況);
        return ShinsakaiKaisaiBashoMapper.to審査会開催場所(entity);
    }

    /**
     * 審査会開催場所情報の全件を取得します。
     *
     * @return 審査会開催場所のリスト
     */
    public List<ShinsakaiKaisaiBasho> get審査会開催場所List() {
        List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entityList = dac.selectAll();
        return to審査会開催場所List(entityList);
    }

    /**
     * 指定した開催場所状況となっている審査会開催場所情報を全件取得します。
     *
     * @param 開催場所状況 開催場所状況（True:有効 False:無効）
     * @return 審査会開催場所のリスト
     */
    public List<ShinsakaiKaisaiBasho> get審査会開催場所List(ShinsakaiKaisaiBashoJokyo 開催場所状況) {
        List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entityList = dac.selectAll(開催場所状況);
        return to審査会開催場所List(entityList);
    }

    /**
     * 引数の審査会開催場所の情報を追加、又は更新します。
     *
     * @param shinsakaiKaisaiBasho 審査会開催場所
     * @return 追加又は更新が成功した場合にtrueを返します
     */
    public boolean save(ShinsakaiKaisaiBasho shinsakaiKaisaiBasho) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(shinsakaiKaisaiBasho);
        int result = dac.insertOrUpdate(entity);
        return (result != 0);
    }

    /**
     * 引数の審査会開催場所の情報を削除します。
     *
     * @param shinsakaiKaisaiBasho 審査会開催場所
     * @return 削除が成功した場合にTrueを返します
     */
    public boolean remove(ShinsakaiKaisaiBasho shinsakaiKaisaiBasho) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(shinsakaiKaisaiBasho);
        int result = dac.delete(entity);
        return (result != 0);
    }

    /**
     * 審査会開催場所Listを作成します。
     *
     * @param entityList 抽出された審査会開催場所情報エンティティ
     * @param list 審査会開催場所のリスト
     */
    private List<ShinsakaiKaisaiBasho> to審査会開催場所List(List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entityList) {
        return entityList.isEmpty() ? Collections.EMPTY_LIST : make審査会開催場所List(entityList);
    }

    private List<ShinsakaiKaisaiBasho> make審査会開催場所List(List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entityList) {
        List<ShinsakaiKaisaiBasho> list = new ArrayList<>();
        for (DbT5104ShinsakaiKaisaiBashoJohoEntity entity : entityList) {
            ShinsakaiKaisaiBasho shinsakaiKaisaiBasho = ShinsakaiKaisaiBashoMapper.to審査会開催場所(entity);
            list.add(shinsakaiKaisaiBasho);
        }
        return list;
    }
}
