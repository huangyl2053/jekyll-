/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoResult;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiIkenshoMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書の結果を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoResultManager {

    private final ShujiiIkenshoDac dac;
    private final ShujiiIkenshoSakuseiIraiKirokuManager manager;

    /**
     * InstanceProviderを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public ShujiiIkenshoResultManager() {
        dac = InstanceProvider.create(ShujiiIkenshoDac.class);
        manager = new ShujiiIkenshoSakuseiIraiKirokuManager();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 主治医意見書Dac
     * @param manager 主治医意見書作成依頼記録Manager
     */
    ShujiiIkenshoResultManager(ShujiiIkenshoDac dac, ShujiiIkenshoSakuseiIraiKirokuManager manager) {
        this.dac = dac;
        this.manager = manager;
    }

    /**
     * 引数の条件に該当する主治医意見書結果を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書履歴番号 意見書履歴番号
     * @return 認定調査結果
     */
    public ShujiiIkenshoResult get主治医意見書結果(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書履歴番号) {
        ShujiiIkenshoEntity entity = dac.select(申請書管理番号, 意見書履歴番号);
        if (entity == null) {
            return null;
        }
        return ShujiiIkenshoMapper.toShujiiIkenshoResult(entity, manager.get主治医意見書作成依頼情報(申請書管理番号, 意見書履歴番号).get介護医師());
    }

    /**
     * 引数の主治医意見書結果を追加、または更新します。
     *
     * @param 主治医意見書結果 主治医意見書結果
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    public boolean save主治医意見書結果(ShujiiIkenshoResult 主治医意見書結果) {
        return dac.insertOrUpdate(ShujiiIkenshoMapper.toShujiiIkenshoEntity(主治医意見書結果));
    }

    /**
     * 引数の主治医意見書結果を削除します。
     *
     * @param 主治医意見書結果 主治医意見書結果
     * @return 削除が成功した場合はtrueを返します。
     */
    public boolean remove主治医意見書結果(ShujiiIkenshoResult 主治医意見書結果) {
        return dac.delete(ShujiiIkenshoMapper.toShujiiIkenshoEntity(主治医意見書結果));
    }
}
