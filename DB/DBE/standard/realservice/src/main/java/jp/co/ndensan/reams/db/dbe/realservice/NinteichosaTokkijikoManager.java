/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaTokkijiko;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaTokkijikoList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaTokkijikoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaTokkijikoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査特記事項のManagerクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaTokkijikoManager {

    private INinteichosaTokkijikoDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteichosaTokkijikoManager() {
        dac = InstanceProvider.create(INinteichosaTokkijikoDac.class);
    }

    /**
     * 外部からDacを取得する、テスト用パッケージプライベートコンストラクタです。
     *
     * @param dac テスト用Dac
     */
    NinteichosaTokkijikoManager(INinteichosaTokkijikoDac dac) {
        this.dac = dac;
    }

    /**
     * 引数の申請書管理番号、認定調査依頼履歴番号に該当する認定調査特記事項を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査依頼履歴番号
     */
    public NinteichosaTokkijikoList get認定調査特記事項(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        List<DbT5010NinteichosaTokkijikoEntity> entities = dac.select(申請書管理番号, 認定調査依頼履歴番号);
        return NinteichosaTokkijikoMapper.to認定調査特記事項List(entities);
    }

    /**
     * 引数の申請書管理番号に該当する、認定調査特記事項のCollectionを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査特記事項Collection
     */
    public NinteichosaTokkijikoList get認定調査特記事項履歴(ShinseishoKanriNo 申請書管理番号) {
        List<DbT5010NinteichosaTokkijikoEntity> entities = dac.select(申請書管理番号);
        return NinteichosaTokkijikoMapper.to認定調査特記事項List(entities);
    }

    /**
     * 指定した認定調査特記事項を保存します。
     *
     * @param 認定調査特記事項 認定調査特記事項
     * @return 保存に成功したらtrue、失敗したらfalse
     */
    public boolean save(NinteichosaTokkijiko 認定調査特記事項) {
        DbT5010NinteichosaTokkijikoEntity entity = NinteichosaTokkijikoMapper.to認定調査特記事項Entity(認定調査特記事項);
        return dac.insertOrUpdate(entity) == 1 ? true : false;
    }

    /**
     * 指定した認定調査特記事項を削除します。
     *
     * @param 認定調査特記事項 認定調査特記事項
     * @return 削除に成功したらtrue、失敗したらfalse
     */
    public boolean remove(NinteichosaTokkijiko 認定調査特記事項) {
        DbT5010NinteichosaTokkijikoEntity entity = NinteichosaTokkijikoMapper.to認定調査特記事項Entity(認定調査特記事項);
        return dac.delete(entity) == 1 ? true : false;
    }
}
