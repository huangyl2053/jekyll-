/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.RenkeiyoDataSofuKiroku;
import jp.co.ndensan.reams.db.dbe.definition.HikiwatashiKubun;
import jp.co.ndensan.reams.db.dbe.definition.NinteiShinseijiKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiChousaSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiIkenshoSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiSoufuKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5022RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.RenkeiyoDataSofuKirokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IRenkeiyoDataSofuKirokuDac;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 連携用データ送付記録の情報を管理するクラスです。
 *
 * @author n8107 千秋雄
 */
public class RenkeiyoDataSofuKirokuManager {

    private final IRenkeiyoDataSofuKirokuDac dac;

    /**
     * コンストラクタクラスです。
     *
     */
    public RenkeiyoDataSofuKirokuManager() {
        dac = InstanceProvider.create(IRenkeiyoDataSofuKirokuDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     */
    RenkeiyoDataSofuKirokuManager(IRenkeiyoDataSofuKirokuDac dac) {
        this.dac = dac;
    }

    /**
     * 申請書管理番号を指定し、連携用データ送付記録を取得するクラスです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return RenkeiyoDataSofuKiroku
     */
    public RenkeiyoDataSofuKiroku get連携用データ送付記録(RString 申請書管理番号) {
        DbT5022RenkeiyoDataSofuKirokuEntity entity = dac.select(申請書管理番号);

        if (entity == null) {
            return null;
        }

        return RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
    }

    /**
     * 被保険者番号を指定して該当する連携用データ送付記録を全件取得するクラスです。
     *
     * @param 被保険者番号 被保険者番号
     * @return RenkeiyoDataSofuKiroku
     */
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録リスト(RString 被保険者番号) {
        List<RenkeiyoDataSofuKiroku> list = new ArrayList();
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entityList = dac.selectAll(被保険者番号);

        for (DbT5022RenkeiyoDataSofuKirokuEntity entity : entityList) {
            RenkeiyoDataSofuKiroku renkeiyouDataSoufuKiroku = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
            list.add(renkeiyouDataSoufuKiroku);
        }

        return list;
    }

    /**
     * 認定申請時区分を指定して該当する連携用データ送付記録を全件取得するクラスです。
     *
     * @param 認定申請時区分 認定申請時区分
     * @return RenkeiyoDataSofuKiroku
     */
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録リスト(NinteiShinseijiKubun 認定申請時区分) {
        List<RenkeiyoDataSofuKiroku> list = new ArrayList();
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entityList = dac.selectAll(認定申請時区分);

        for (DbT5022RenkeiyoDataSofuKirokuEntity entity : entityList) {
            RenkeiyoDataSofuKiroku renkeiyouDataSoufuKiroku = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
            list.add(renkeiyouDataSoufuKiroku);
        }

        return list;
    }

    /**
     * 引渡し区分を指定して該当する連携用データ送付記録を全件取得するクラスです。
     *
     * @param 引渡し区分 引渡し区分
     * @return RenkeiyoDataSofuKiroku
     */
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録リスト(HikiwatashiKubun 引渡し区分) {
        List<RenkeiyoDataSofuKiroku> list = new ArrayList();
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entityList = dac.selectAll(引渡し区分);

        for (DbT5022RenkeiyoDataSofuKirokuEntity entity : entityList) {
            RenkeiyoDataSofuKiroku renkeiyouDataSoufuKiroku = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
            list.add(renkeiyouDataSoufuKiroku);
        }

        return list;
    }

    /**
     * 引渡し日時を指定して該当する連携用データ送付記録を全件取得するクラスです。
     *
     * @param 引渡し日時 引渡し日時
     * @return RenkeiyoDataSofuKiroku
     */
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録リスト(RDateTime 引渡し日時) {
        List<RenkeiyoDataSofuKiroku> list = new ArrayList();
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entityList = dac.selectAll(引渡し日時);

        for (DbT5022RenkeiyoDataSofuKirokuEntity entity : entityList) {
            RenkeiyoDataSofuKiroku renkeiyouDataSoufuKiroku = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
            list.add(renkeiyouDataSoufuKiroku);
        }

        return list;
    }

    /**
     * 再送付区分を指定して該当する連携用データ送付記録を全件取得するクラスです。
     *
     * @param 再送付区分 再送付区分
     * @return RenkeiyoDataSofuKiroku
     */
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録リスト(SaiSoufuKubun 再送付区分) {
        List<RenkeiyoDataSofuKiroku> list = new ArrayList();
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entityList = dac.selectAll(再送付区分);

        for (DbT5022RenkeiyoDataSofuKirokuEntity entity : entityList) {
            RenkeiyoDataSofuKiroku renkeiyouDataSoufuKiroku = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
            list.add(renkeiyouDataSoufuKiroku);
        }

        return list;
    }

    /**
     * 再調査送付区分を指定して該当する連携用データ送付記録を全件取得するクラスです。
     *
     * @param 再調査送付区分 再調査送付区分
     * @return RenkeiyoDataSofuKiroku
     */
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録リスト(SaiChousaSoufuKubun 再調査送付区分) {
        List<RenkeiyoDataSofuKiroku> list = new ArrayList();
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entityList = dac.selectAll(再調査送付区分);

        for (DbT5022RenkeiyoDataSofuKirokuEntity entity : entityList) {
            RenkeiyoDataSofuKiroku renkeiyouDataSoufuKiroku = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
            list.add(renkeiyouDataSoufuKiroku);
        }

        return list;
    }

    /**
     * 再意見書送付区分を指定して該当する連携用データ送付記録を全件取得するクラスです。
     *
     * @param 再意見書送付区分 再意見書送付区分
     * @return RenkeiyoDataSofuKiroku
     */
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録リスト(SaiIkenshoSoufuKubun 再意見書送付区分) {
        List<RenkeiyoDataSofuKiroku> list = new ArrayList();
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entityList = dac.selectAll(再意見書送付区分);

        for (DbT5022RenkeiyoDataSofuKirokuEntity entity : entityList) {
            RenkeiyoDataSofuKiroku renkeiyouDataSoufuKiroku = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(entity);
            list.add(renkeiyouDataSoufuKiroku);
        }

        return list;
    }

    /**
     * 連携用データ送付記録を追加・更新します。
     *
     * @param renkeiyoDataSofuKiroku 連携用データ送付記録
     * @return 追加・更新結果
     */
    public boolean save(RenkeiyoDataSofuKiroku renkeiyoDataSofuKiroku) {
        DbT5022RenkeiyoDataSofuKirokuEntity entity = toDbT5022RenkeiyoDataSofuKirokuEntity(renkeiyoDataSofuKiroku);
        int result = dac.insertOrUpdate(entity);
        return (result != 0);
    }

    /**
     * 連携用データ送付記録を削除します。
     *
     * @param renkeiyoDataSofuKiroku 連携用データ送付記録
     * @return 削除結果
     */
    public boolean remove(RenkeiyoDataSofuKiroku renkeiyoDataSofuKiroku) {
        DbT5022RenkeiyoDataSofuKirokuEntity entity = toDbT5022RenkeiyoDataSofuKirokuEntity(renkeiyoDataSofuKiroku);
        int result = dac.delete(entity);
        return (result != 0);
    }

    /**
     * 連携用データ送付記録エンティティを編集します。
     *
     * @param renkeiyoDataSofuKiroku 連携用データ送付記録
     * @return 連携用データ送付記録エンティティ
     */
    private DbT5022RenkeiyoDataSofuKirokuEntity toDbT5022RenkeiyoDataSofuKirokuEntity(RenkeiyoDataSofuKiroku renkeiyoDataSofuKiroku) {
        DbT5022RenkeiyoDataSofuKirokuEntity entity = new DbT5022RenkeiyoDataSofuKirokuEntity();
        entity.setShinseishoKanriNo(renkeiyoDataSofuKiroku.get申請書管理番号().getColumnValue());
        entity.setHihokenshaNo(renkeiyoDataSofuKiroku.get被保険者番号().getColumnValue());
        entity.setNinteiShinseiShinseijiKubun(renkeiyoDataSofuKiroku.get認定申請時区分().getCode());
        entity.setHikiwatashiKubun(renkeiyoDataSofuKiroku.get引渡し区分().getCode());
        entity.setHikiwatashiNichiji(renkeiyoDataSofuKiroku.get引渡し日時());
        entity.setSaiSoufuKubun(renkeiyoDataSofuKiroku.get再送付区分().getCode());
        entity.setSaiChousaSoufuKubun(renkeiyoDataSofuKiroku.get再調査送付区分().getCode());
        entity.setSaiIkenshoSoufuKubun(renkeiyoDataSofuKiroku.get再意見書送付区分().getCode());
        return entity;
    }
}
