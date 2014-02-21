/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShinsakaiKaisaiBashoJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShinsakaiKaisaiBashoDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 審査会開催場所の情報を管理するクラスです。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiBashoManager {
//TODO 審査会開催場所をValueObjectからはずす。詳細が決まってから正式対応。　2014/02/28

    private final IShinsakaiKaisaiBashoDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public ShinsakaiKaisaiBashoManager() {
        dac = InstanceCreator.create(IShinsakaiKaisaiBashoDac.class);
    }

    /**
     * テスト用パッケージプライベートコンストラクタです。
     *
     * @param shinsakaiKaisaiBashoDac テスト用MockDac
     */
    ShinsakaiKaisaiBashoManager(IShinsakaiKaisaiBashoDac shinsakaiKaisaiBashoDac) {
        this.dac = shinsakaiKaisaiBashoDac;
    }

    /**
     * 審査会開催場所コードで指定された審査会開催場所情報を取得します。
     *
     * @param 審査会開催場所コード 審査会開催場所コード
     * @return 審査会開催場所
     */
//    public ShinsakaiKaisaiBasho get審査会開催場所(ShinsakaiKaisaiBashoCode 審査会開催場所コード) {
    public ShinsakaiKaisaiBasho get審査会開催場所(RString 審査会開催場所コード) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = dac.select(審査会開催場所コード);

        if (entity == null) {
            return null;
        }

        return ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(entity);
    }

    /**
     * 審査会開催場所コードと開催場所状況で指定された審査会開催場所情報を取得します。
     *
     * @param 審査会開催場所コード 審査会開催場所コード
     * @param 開催場所状況 開催場所状況（True:有効 False:無効）
     * @return 審査会開催場所
     */
//    public ShinsakaiKaisaiBasho get審査会開催場所(ShinsakaiKaisaiBashoCode 審査会開催場所コード, boolean 開催場所状況) {
    public ShinsakaiKaisaiBasho get審査会開催場所(RString 審査会開催場所コード, ShinsakaiKaisaiBashoJokyo 開催場所状況) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = dac.select(審査会開催場所コード, 開催場所状況);

        if (entity == null) {
            return null;
        }

        return ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(entity);
    }

    /**
     * 審査会開催場所情報の全件を取得します。
     *
     * @return 審査会開催場所のリスト
     */
    public List<ShinsakaiKaisaiBasho> get審査会開催場所List() {
        List<ShinsakaiKaisaiBasho> list = new ArrayList();
        List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entityList = dac.selectAll();
        make審査会開催場所List(entityList, list);

        return list;
    }

    /**
     * 指定した開催場所状況となっている審査会開催場所情報を全件取得します。
     *
     * @param 開催場所状況 開催場所状況（True:有効 False:無効）
     * @return 審査会開催場所のリスト
     */
    public List<ShinsakaiKaisaiBasho> get審査会開催場所List(ShinsakaiKaisaiBashoJokyo 開催場所状況) {
        List<ShinsakaiKaisaiBasho> list = new ArrayList();
        List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entityList = dac.selectAll(開催場所状況);
        make審査会開催場所List(entityList, list);

        return list;
    }

    /**
     * 引数の審査会開催場所の情報を追加、又は更新します。
     *
     * @param shinsakaiKaisaiBasho 審査会開催場所
     * @return 追加又は更新が成功した場合にtrueを返します
     */
    public boolean save(ShinsakaiKaisaiBasho shinsakaiKaisaiBasho) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = toDbT5104ShinsakaiKaisaiBashoJohoEntity(shinsakaiKaisaiBasho);
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
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = toDbT5104ShinsakaiKaisaiBashoJohoEntity(shinsakaiKaisaiBasho);
        int result = dac.delete(entity);
        return (result != 0);
    }

    /**
     * 審査会開催場所Listを作成します。
     *
     * @param entityList 抽出された審査会開催場所情報エンティティ
     * @param list 審査会開催場所のリスト
     */
    private void make審査会開催場所List(List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entityList, List<ShinsakaiKaisaiBasho> list) {
        for (DbT5104ShinsakaiKaisaiBashoJohoEntity entity : entityList) {
            ShinsakaiKaisaiBasho shinsakaiKaisaiBasho = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(entity);
            list.add(shinsakaiKaisaiBasho);
        }
    }

    /**
     * 審査会開催場所情報エンティティを編集します。
     *
     * @param shinsakaiKaisaiBasho 審査会開催場所情報
     * @return 審査会開催場所情報エンティティ
     */
    private DbT5104ShinsakaiKaisaiBashoJohoEntity toDbT5104ShinsakaiKaisaiBashoJohoEntity(ShinsakaiKaisaiBasho shinsakaiKaisaiBasho) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
        entity.setShinsakaiKaisaiBashoCode(shinsakaiKaisaiBasho.get開催場所コード().getColumnValue());
        entity.setShinsakaiKaisaiBashoMei(shinsakaiKaisaiBasho.get開催場所名称());
        entity.setShinsakaiKaisaiChikuCode(shinsakaiKaisaiBasho.get開催場所地区コード().getColumnValue());
        entity.setShinsakaiKaisaiBashoJusho(shinsakaiKaisaiBasho.get開催場所住所());
        entity.setShinsakaiKaisaiBashoTelNo(shinsakaiKaisaiBasho.get開催場所電話番号());
        entity.setShinsakaiKaisaiBashoJokyo(shinsakaiKaisaiBasho.get開催場所状況().is有効());
        return entity;
    }
}
