/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIraiJoho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IshiShikibetsuNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiIkenshoSakuseiIraiJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 主治医意見書作成依頼記録を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiIraiKirokuManager {

    private final IShujiiIkenshoIraiJohoDac iraiDac;
    private final INinteiShinseiJohoDac shinseiDac;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public ShujiiIkenshoSakuseiIraiKirokuManager() {
        iraiDac = InstanceCreator.create(IShujiiIkenshoIraiJohoDac.class);
        shinseiDac = InstanceCreator.create(INinteiShinseiJohoDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param iraiDac 主治医意見書作成依頼情報Dac
     * @param shinseiDac 認定申請情報Dac
     */
    ShujiiIkenshoSakuseiIraiKirokuManager(IShujiiIkenshoIraiJohoDac iraiDac, INinteiShinseiJohoDac shinseiDac) {
        this.iraiDac = iraiDac;
        this.shinseiDac = shinseiDac;
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書作成依頼履歴番号 意見書作成依頼履歴番号
     * @return 主治医意見書作成依頼情報
     */
    public ShujiiIkenshoSakuseiIraiJoho get主治医意見書作成依頼情報(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号) {
        DbT5011ShujiiIkenshoIraiJohoEntity entity = iraiDac.select(申請書管理番号, 意見書作成依頼履歴番号.value().intValue());
        return entity == null ? null : ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIraiJoho(entity);
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIraiJoho> get主治医意見書作成依頼情報By申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIraiJohoList(iraiDac.selectBy申請書管理番号(申請書管理番号));
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 意見書作成依頼年月日 意見書作成依頼年月日
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIraiJoho> get主治医意見書作成依頼情報By依頼年月日(FlexibleDate 意見書作成依頼年月日) {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIraiJohoList(iraiDac.selectBy依頼年月日(意見書作成依頼年月日));
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 医師識別番号 医師識別番号
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIraiJoho> get主治医意見書作成依頼情報By主治医情報(ShujiiIryoKikanCode 主治医医療機関コード, IshiShikibetsuNo 医師識別番号) {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIraiJohoList(iraiDac.selectBy主治医情報(主治医医療機関コード.value(), 医師識別番号.value()));
    }

    /**
     * 引数の条件に該当する主治医意見書作成依頼情報を取得します。
     *
     * @param 意見書作成督促年月日 意見書作成督促年月日
     * @return 主治医意見書作成依頼情報
     */
    public List<ShujiiIkenshoSakuseiIraiJoho> get主治医意見書作成依頼情報By督促年月日(FlexibleDate 意見書作成督促年月日) {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIraiJohoList(iraiDac.selectBy督促年月日(意見書作成督促年月日));
    }

    /**
     * 引数の主治医意見書作成依頼情報を追加、または更新します。
     *
     * @param 主治医意見書作成依頼情報 主治医意見書作成依頼情報
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    public boolean save(ShujiiIkenshoSakuseiIraiJoho 主治医意見書作成依頼情報) {
        return iraiDac.insertOrUpdate(ShujiiIkenshoSakuseiIraiJohoMapper.toDbT5011ShujiiIkenshoIraiJohoEntity(主治医意見書作成依頼情報)) != 0;
    }

    /**
     * 引数の条件に該当する認定申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報
     */
    public NinteiShinseiJoho get認定申請情報(ShinseishoKanriNo 申請書管理番号) {
        DbT5001NinteiShinseiJohoEntity entity = shinseiDac.select(申請書管理番号);
        return entity == null ? null : NinteishinseiJohoMapper.to認定申請情報(entity);
    }

    /**
     * 引数の認定申請情報を更新します。
     *
     * @param 認定申請情報 認定申請情報
     * @return 更新が成功した場合はtrueを返します。
     */
    public boolean save(NinteiShinseiJoho 認定申請情報) {
        return shinseiDac.update(NinteishinseiJohoMapper.to認定申請情報Entity(認定申請情報)) != 0;
    }
}
