/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.ShujiiIkensho5Komoku;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiIkensho5KomokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShujiiIkenshoShosaiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書詳細の情報から、一次判定で使用する主治医意見書5項目を取得するFinderです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIkensho5KomokuFinder {

    private final ShujiiIkenshoShosaiJohoDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public ShujiiIkensho5KomokuFinder() {
        dac = InstanceProvider.create(ShujiiIkenshoShosaiJohoDac.class);
    }

    /**
     * 外部からDacを受け取る、テスト用コンストラクタです。
     *
     * @param dac テスト用Dac
     */
    ShujiiIkensho5KomokuFinder(ShujiiIkenshoShosaiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請書管理番号を指定し、一次判定で使用する主治医意見書5項目の情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書作成依頼履歴番号 意見書作成依頼履歴番号
     * @return 主治医意見書5項目
     */
    public ShujiiIkensho5Komoku get主治医意見書5項目(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号) {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = dac.select(申請書管理番号, 意見書作成依頼履歴番号);
        return ShujiiIkensho5KomokuMapper.to主治医意見書5項目(entity);
    }
}
