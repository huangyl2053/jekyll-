/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.ninteikanryoninteishinseijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoChild;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請書発行を管理するクラスです。
 *
 * @reamsid_L DBD-1400-010 tianyh
 */
public class NinteiKanryoNinteiShinseiJohoManager {

    private final DbT5105NinteiKanryoJohoDac ninteiKanryoJohodac;
    private final DbT4101NinteiShinseiJohoDac ninteiShinseiJohodac;
    private final DbT5121ShinseiRirekiJohoDac shinseiRirekiJohodac;

    /**
     * コンストラクタです。
     */
    public NinteiKanryoNinteiShinseiJohoManager() {
        ninteiKanryoJohodac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        ninteiShinseiJohodac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        shinseiRirekiJohodac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    /**
     * 要介護認定申請書発行のコンストラクタです。
     *
     * @param ninteiKanryoJohodac ninteiKanryoJohodac
     * @param ninteiShinseiJohodac ninteiShinseiJohodac
     * @param shinseiRirekiJohodac shinseiRirekiJohodac
     */
    NinteiKanryoNinteiShinseiJohoManager(DbT5105NinteiKanryoJohoDac ninteiKanryoJohodac, DbT4101NinteiShinseiJohoDac ninteiShinseiJohodac,
            DbT5121ShinseiRirekiJohoDac shinseiRirekiJohodac) {
        this.ninteiKanryoJohodac = ninteiKanryoJohodac;
        this.ninteiShinseiJohodac = ninteiShinseiJohodac;
        this.shinseiRirekiJohodac = shinseiRirekiJohodac;

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiKanryoNinteiShinseiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiKanryoNinteiShinseiJohoManager}のインスタンス
     */
    public static NinteiKanryoNinteiShinseiJohoManager createInstance() {
        return InstanceProvider.create(NinteiKanryoNinteiShinseiJohoManager.class);
    }

    /**
     * 主キーで申請履歴情報を返します。
     *
     * @param 申請管理番号 申請管理番号
     * @return DbT5121ShinseiRirekiJohoEntity
     */
    @Transaction
    public ShinseiRirekiJoho selectByKey(ShinseishoKanriNo 申請管理番号) {
        DbT5121ShinseiRirekiJohoEntity entity = shinseiRirekiJohodac.selectByKey(申請管理番号);
        if (entity == null) {
            return null;
        } else {
            return new ShinseiRirekiJoho(entity);
        }
    }

    /**
     * 主キーで要介護認定完了情報を返します。値が空でないかどうかを確認します
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiKanryoJoho
     */
    @Transaction
    public NinteiKanryoJoho selectByShinseishoKanriNo(ShinseishoKanriNo 申請書管理番号) {
        DbT5105NinteiKanryoJohoEntity entity = ninteiKanryoJohodac.selectByShinseishoKanriNo(申請書管理番号);
        if (entity == null) {
            return null;
        } else {
            return new NinteiKanryoJoho(entity);
        }

    }

    /**
     * 保険者番号と被保番号で要介護認定申請情報を返します。
     *
     * @param 保険者番号 保険者番号
     * @param 被保番号 被保番号
     * @return NinteiShinseiJohoChild
     */
    @Transaction
    public NinteiShinseiJohoChild get要介護認定申請情報(RString 保険者番号, RString 被保番号) {
        DbT4101NinteiShinseiJohoEntity entity = ninteiShinseiJohodac.selectByShokiAndHiho(保険者番号, 被保番号);
        if (entity == null) {
            return null;
        } else {
            return new NinteiShinseiJohoChild(entity);
        }

    }

    /**
     * 主キーで要介護認定申請情報を返します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return NinteiShinseiJohoChild
     */
    @Transaction
    public NinteiShinseiJohoChild selectByZenkaiShinseishoKanriNo(ShinseishoKanriNo 申請書管理番号) {
        DbT4101NinteiShinseiJohoEntity entity = ninteiShinseiJohodac.selectByZenkaiShinseishoKanriNo(申請書管理番号);
        if (entity == null) {
            return null;
        } else {
            return new NinteiShinseiJohoChild(entity);
        }

    }

    /**
     * get被保険者名称カナ
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return RString KanaName
     */
    public RString getKanaName(ShikibetsuCode shikibetsuCode) {
        ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        IShikibetsuTaishoSearchKey searchKey = builder.set識別コード(shikibetsuCode).build();
        List<IShikibetsuTaisho> 識別対象 = ShikibetsuTaishoService.getShikibetsuTaishoFinder().get識別対象s(searchKey);
        if (!識別対象.isEmpty() && !識別対象.get(0).toEntity().getKanaMeisho().isEmpty()) {
            return 識別対象.get(0).toEntity().getKanaMeisho().value();
        } else {
            return null;
        }
    }
}
